package barboskin.com.tinkoffnews.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Maestro on 29.03.2018.
 */

public class DateUtils {

    public static String getFormatDate(long milliseconds, String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date(milliseconds));
    }
}
