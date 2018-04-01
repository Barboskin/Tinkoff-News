package barboskin.com.tinkoffnews.newsdetail;

import barboskin.com.tinkoffnews.BasePresenter;
import barboskin.com.tinkoffnews.BaseView;
import barboskin.com.tinkoffnews.data.model.News;

/**
 * Created by Maestro on 01.04.2018.
 */

public class NewsDetailContract {

    public interface Presenter extends BasePresenter<View>{
        void loadNews(int id);
    }

    public interface View extends BaseView<Presenter>{
        void showDetailNews(News news);

        void showLoadProgress();

        void hideLoadProgress();

        void showError();
    }
}
