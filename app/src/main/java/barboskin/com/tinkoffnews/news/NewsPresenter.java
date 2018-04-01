package barboskin.com.tinkoffnews.news;

import java.util.Collections;

import barboskin.com.tinkoffnews.data.NewsRepository;
import barboskin.com.tinkoffnews.utils.RxUtils;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Maestro on 01.04.2018.
 */

public class NewsPresenter implements NewsContract.Presenter {

    private CompositeDisposable compositeDisposable;
    private NewsRepository newsRepository;
    private NewsContract.View view;
    private boolean isUpdateLoading = false;

    public NewsPresenter(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
        compositeDisposable = new CompositeDisposable();
    }


    @Override
    public void takeView(NewsContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        view = null;
    }

    @Override
    public void unsubscribe() {
        compositeDisposable.clear();
    }

    @Override
    public void loadNews() {
        view.showLoadProgress();

        compositeDisposable.add(newsRepository.getNews()
                .compose(RxUtils.applySingleSchedulers())
                .doFinally(() -> view.hideLoadProgress())
                .subscribe(data -> {
                    if (data.isEmpty()){
                        view.showError();
                    } else {
                        Collections.sort(data, Collections.reverseOrder());
                        view.showNews(data);
                    }
                }, error -> {
                    view.showError();
                }));
    }

    @Override
    public void updateNews() {
        if (isUpdateLoading){
            return;
        }
        isUpdateLoading = true;
        view.showUpdateProgress();

        compositeDisposable.add(newsRepository.updateNews()
                .compose(RxUtils.applySingleSchedulers())
                .doFinally(() -> {
                    view.hideUpdateProgress();
                    isUpdateLoading = false;
                })
                .subscribe(data -> {
                    Collections.sort(data, Collections.reverseOrder());
                    view.showNews(data);
                }, error -> {
                    view.showUpdateError();
                }));
    }
}
