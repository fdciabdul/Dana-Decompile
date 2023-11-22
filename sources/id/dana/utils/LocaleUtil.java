package id.dana.utils;

import androidx.core.os.LocaleListCompat;
import java.util.Locale;

/* loaded from: classes2.dex */
public class LocaleUtil {
    private static Locale BuiltInFictitiousFunctionClassFactory;

    public static Locale getAuthRequestContext() {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = new Locale("in", "ID");
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static Locale KClassImpl$Data$declaredNonStaticMembers$2() {
        return Locale.getDefault();
    }

    public static String MyBillsEntityDataFactory() {
        return LocaleListCompat.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static boolean BuiltInFictitiousFunctionClassFactory() {
        return "in".equals(Locale.getDefault().getLanguage());
    }
}
