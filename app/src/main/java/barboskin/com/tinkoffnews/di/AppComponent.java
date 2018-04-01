package barboskin.com.tinkoffnews.di;

import android.content.Context;

import javax.inject.Singleton;

import barboskin.com.tinkoffnews.di.modules.PresentersModule;
import barboskin.com.tinkoffnews.newsdetail.DetailActivity;
import barboskin.com.tinkoffnews.data.NewsRepository;
import barboskin.com.tinkoffnews.di.modules.ContextModule;
import barboskin.com.tinkoffnews.news.MainActivity;
import dagger.Component;

/**
 * Created by Maestro on 31.03.2018.
 */
@Singleton
@Component(modules = {ContextModule.class, PresentersModule.class})
public interface AppComponent {

    Context getContext();
    NewsRepository getNewsRepository();

    void inject(MainActivity mainActivity);
    void inject(DetailActivity detailActivity);
}
