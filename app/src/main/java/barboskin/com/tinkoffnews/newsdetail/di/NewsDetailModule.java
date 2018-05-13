package barboskin.com.tinkoffnews.newsdetail.di;

import barboskin.com.tinkoffnews.data.NewsRepository;
import barboskin.com.tinkoffnews.newsdetail.NewsDetailContract;
import barboskin.com.tinkoffnews.newsdetail.NewsDetailPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Maestro on 13.05.2018.
 */
@Module
public class NewsDetailModule {

    @Provides
    @NewsDetailScope
    public NewsDetailContract.Presenter provideNewsDetailPresenter(NewsRepository newsRepository){
        return new NewsDetailPresenter(newsRepository);
    }
}
