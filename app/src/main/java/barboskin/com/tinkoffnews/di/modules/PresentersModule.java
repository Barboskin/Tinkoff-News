package barboskin.com.tinkoffnews.di.modules;

import javax.inject.Singleton;

import barboskin.com.tinkoffnews.data.NewsRepository;
import barboskin.com.tinkoffnews.news.NewsContract;
import barboskin.com.tinkoffnews.news.NewsPresenter;
import barboskin.com.tinkoffnews.newsdetail.NewsDetailContract;
import barboskin.com.tinkoffnews.newsdetail.NewsDetailPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Maestro on 01.04.2018.
 */
@Module(includes = RepositoryModule.class)
public class PresentersModule {

    @Provides
    @Singleton
    public NewsContract.Presenter provideNewsPresenter(NewsRepository newsRepository){
        return new NewsPresenter(newsRepository);
    }

    @Provides
    @Singleton
    public NewsDetailContract.Presenter provideNewsDetailPresenter(NewsRepository newsRepository){
        return new NewsDetailPresenter(newsRepository);
    }
}
