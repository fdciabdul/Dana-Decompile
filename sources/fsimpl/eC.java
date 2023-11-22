package fsimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes4.dex */
public class eC {

    /* renamed from: a  reason: collision with root package name */
    private static final TimeZone f7950a = TimeZone.getTimeZone("UTC");
    private static final DateFormat b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    private static final Date c = new Date(0);

    static {
        b.setTimeZone(f7950a);
    }

    public static String a(Date date) {
        return date == null ? "1970-01-01T00:00:00.000Z" : b.format(date);
    }
}
