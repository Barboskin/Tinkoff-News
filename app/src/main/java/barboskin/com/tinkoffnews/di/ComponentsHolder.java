package barboskin.com.tinkoffnews.di;

import android.content.Context;

import barboskin.com.tinkoffnews.di.modules.ContextModule;
import barboskin.com.tinkoffnews.news.di.NewsComponent;
import barboskin.com.tinkoffnews.newsdetail.di.NewsDetailComponent;

/**
 * Created by Maestro on 13.05.2018.
 */

public class ComponentsHolder {

    private final Context context;

    private AppComponent appComponent;
    private NewsComponent newsComponent;
    private NewsDetailComponent newsDetailComponent;

    public ComponentsHolder(Context context) {
        this.context = context;
    }

    public void init(){
        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(context))
                .build();
    }

    public NewsComponent getNewsComponent(){
        if (newsComponent == null){
            newsComponent = appComponent.provideNewsComponent();
        }
        return newsComponent;
    }

    public void releaseNewsComponent(){
        newsComponent = null;
    }

    public NewsDetailComponent getNewsDetailComponent(){
        if (newsDetailComponent == null){
            newsDetailComponent = appComponent.provideNewsDetailComponent();
        }
        return newsDetailComponent;
    }

    public void releaseNewsDetailComponent(){
        newsDetailComponent = null;
    }
}
