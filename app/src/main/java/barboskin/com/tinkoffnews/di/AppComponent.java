package barboskin.com.tinkoffnews.di;

import android.content.Context;

import javax.inject.Singleton;

import barboskin.com.tinkoffnews.di.modules.ContextModule;
import barboskin.com.tinkoffnews.di.modules.RepositoryModule;
import barboskin.com.tinkoffnews.news.di.NewsComponent;
import barboskin.com.tinkoffnews.newsdetail.di.NewsDetailComponent;
import dagger.Component;

/**
 * Created by Maestro on 31.03.2018.
 */
@Singleton
@Component(modules = {ContextModule.class, RepositoryModule.class})
public interface AppComponent {

    Context getContext();

    NewsComponent provideNewsComponent();
    NewsDetailComponent provideNewsDetailComponent();
}
