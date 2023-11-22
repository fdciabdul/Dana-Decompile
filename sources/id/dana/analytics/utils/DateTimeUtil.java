package id.dana.analytics.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/analytics/utils/DateTimeUtil;", "", "", "p0", "Ljava/util/Locale;", "p1", "Ljava/text/SimpleDateFormat;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/util/Locale;)Ljava/text/SimpleDateFormat;", "()Ljava/util/Locale;", "MyBillsEntityDataFactory", "Ljava/util/Locale;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DateTimeUtil {
    public static final DateTimeUtil INSTANCE = new DateTimeUtil();
    private static Locale MyBillsEntityDataFactory;

    private DateTimeUtil() {
    }

    public static SimpleDateFormat PlaceComponentResult(String p0, Locale p1) {
        return new SimpleDateFormat(p0, p1);
    }

    public static Locale PlaceComponentResult() {
        if (MyBillsEntityDataFactory == null) {
            MyBillsEntityDataFactory = new Locale("in", "ID");
        }
        Locale locale = MyBillsEntityDataFactory;
        if (locale == null) {
            Locale locale2 = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale2, "");
            return locale2;
        }
        return locale;
    }
}
