package barboskin.com.tinkoffnews.utils;

import android.text.Html;
import android.text.Spanned;

/**
 * Created by Maestro on 29.03.2018.
 */

public class StringUtils {

    public static Spanned fromHtml(String html) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(html);
        }
    }
}
