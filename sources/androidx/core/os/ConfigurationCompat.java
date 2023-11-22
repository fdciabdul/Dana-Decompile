package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

/* loaded from: classes3.dex */
public final class ConfigurationCompat {
    private ConfigurationCompat() {
    }

    public static LocaleListCompat PlaceComponentResult(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? LocaleListCompat.KClassImpl$Data$declaredNonStaticMembers$2(Api24Impl.MyBillsEntityDataFactory(configuration)) : LocaleListCompat.BuiltInFictitiousFunctionClassFactory(configuration.locale);
    }

    /* loaded from: classes3.dex */
    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList MyBillsEntityDataFactory(Configuration configuration) {
            return configuration.getLocales();
        }
    }
}
