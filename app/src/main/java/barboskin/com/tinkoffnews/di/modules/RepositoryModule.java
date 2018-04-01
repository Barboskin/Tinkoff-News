package barboskin.com.tinkoffnews.di.modules;

import javax.inject.Singleton;

import barboskin.com.tinkoffnews.data.NewsRepository;
import barboskin.com.tinkoffnews.data.local.NewsDatabase;
import barboskin.com.tinkoffnews.data.network.TinkoffNewsApiService;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Maestro on 31.03.2018.
 */
@Module(includes = {NewsApiModule.class, LocalStorageModule.class})
public class RepositoryModule {

    @Provides
    @Singleton
    public NewsRepository provideNewsRepository(TinkoffNewsApiService tinkoffNewsApiService, NewsDatabase newsDatabase){
        return new NewsRepository(tinkoffNewsApiService, newsDatabase);
    }
}
