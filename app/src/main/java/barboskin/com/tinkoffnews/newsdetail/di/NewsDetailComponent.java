package barboskin.com.tinkoffnews.newsdetail.di;

import barboskin.com.tinkoffnews.newsdetail.DetailActivity;
import dagger.Subcomponent;

/**
 * Created by Maestro on 13.05.2018.
 */
@NewsDetailScope
@Subcomponent(modules = {NewsDetailModule.class})
public interface NewsDetailComponent {
    void inject(DetailActivity detailActivity);
}
