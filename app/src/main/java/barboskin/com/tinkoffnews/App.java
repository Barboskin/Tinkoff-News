package barboskin.com.tinkoffnews;

import android.app.Application;

import barboskin.com.tinkoffnews.di.ComponentsHolder;

/**
 * Created by Maestro on 31.03.2018.
 */

public class App extends Application {

    private static ComponentsHolder componentsHolder;

    public static ComponentsHolder getComponentsHolder(){
        return componentsHolder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        componentsHolder = new ComponentsHolder(this);
        componentsHolder.init();
    }
}
