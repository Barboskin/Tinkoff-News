package barboskin.com.tinkoffnews;

import android.app.Application;

import barboskin.com.tinkoffnews.di.AppComponent;
import barboskin.com.tinkoffnews.di.modules.ContextModule;
import barboskin.com.tinkoffnews.di.DaggerAppComponent;

/**
 * Created by Maestro on 31.03.2018.
 */

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
