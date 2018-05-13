package barboskin.com.tinkoffnews.news.di;

import barboskin.com.tinkoffnews.news.MainActivity;
import dagger.Subcomponent;

/**
 * Created by Maestro on 13.05.2018.
 */
@NewsScope
@Subcomponent(modules = {NewsModule.class})
public interface NewsComponent {

    void inject(MainActivity mainActivity);
}
