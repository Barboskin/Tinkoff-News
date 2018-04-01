package barboskin.com.tinkoffnews.news;

import java.util.List;

import barboskin.com.tinkoffnews.BasePresenter;
import barboskin.com.tinkoffnews.BaseView;
import barboskin.com.tinkoffnews.data.model.News;

/**
 * Created by Maestro on 01.04.2018.
 */

public class NewsContract{

    public interface Presenter extends BasePresenter<View>{

        void loadNews();

        void updateNews();
    }

    public interface View extends BaseView<Presenter>{

        void showNews(List<News> news);

        void showError();

        void showUpdateError();

        void showLoadProgress();

        void hideLoadProgress();

        void showUpdateProgress();

        void hideUpdateProgress();
    }
}
