package barboskin.com.tinkoffnews.utils;

import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Maestro on 31.03.2018.
 */

public class RxUtils {

    public static <T> SingleTransformer<T, T> applySingleSchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
