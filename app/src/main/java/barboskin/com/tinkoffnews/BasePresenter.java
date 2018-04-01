package barboskin.com.tinkoffnews;

import android.view.View;

/**
 * Created by Maestro on 01.04.2018.
 */

public interface BasePresenter<T> {

    void takeView(T view);

    void dropView();

    void unsubscribe();
}
