package barboskin.com.tinkoffnews.news.di;

import barboskin.com.tinkoffnews.data.NewsRepository;
import barboskin.com.tinkoffnews.news.NewsContract;
import barboskin.com.tinkoffnews.news.NewsPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Maestro on 13.05.2018.
 */
@Module
public class NewsModule {

    @Provides
    @NewsScope
    public NewsContract.Presenter provideNewsPresenter(NewsRepository newsRepository){
        return new NewsPresenter(newsRepository);
    }
}
