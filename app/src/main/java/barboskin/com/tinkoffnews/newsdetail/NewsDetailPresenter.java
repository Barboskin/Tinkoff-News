package barboskin.com.tinkoffnews.newsdetail;

import barboskin.com.tinkoffnews.data.NewsRepository;
import barboskin.com.tinkoffnews.utils.RxUtils;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Maestro on 01.04.2018.
 */

public class NewsDetailPresenter implements NewsDetailContract.Presenter {

    private CompositeDisposable compositeDisposable;
    private NewsRepository newsRepository;
    private NewsDetailContract.View view;

    public NewsDetailPresenter(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
        compositeDisposable = new CompositeDisposable();
    }


    @Override
    public void takeView(NewsDetailContract.View view) {
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
    public void loadNews(int id) {
        view.showLoadProgress();
        compositeDisposable.add(newsRepository.getDetailNews(id)
                .compose(RxUtils.applySingleSchedulers())
                .doFinally(() -> view.hideLoadProgress())
                .subscribe(x ->
                    view.showDetailNews(x)
                , error ->
                    view.showError()
                ));
    }
}
