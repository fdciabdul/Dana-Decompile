package id.dana.core.ui.util;

import android.os.Build;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0004"}, d2 = {"Lid/dana/core/ui/util/OSUtil;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "getAuthRequestContext", "MyBillsEntityDataFactory", "scheduleImpl", "lookAheadTest", "getErrorConfigVersion", "moveToNextValue", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OSUtil {
    public static final OSUtil INSTANCE = new OSUtil();

    private OSUtil() {
    }

    public static boolean getErrorConfigVersion() {
        return Build.VERSION.SDK_INT >= 25;
    }

    public static boolean moveToNextValue() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean getAuthRequestContext() {
        return Build.VERSION.SDK_INT <= 33;
    }

    public static boolean lookAheadTest() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean MyBillsEntityDataFactory() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean BuiltInFictitiousFunctionClassFactory() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean PlaceComponentResult() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static boolean scheduleImpl() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
