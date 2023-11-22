package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class ICUCompat {
    private static Method BuiltInFictitiousFunctionClassFactory;
    private static Method PlaceComponentResult;

    static {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                Class<?> cls = Class.forName("libcore.icu.ICU");
                BuiltInFictitiousFunctionClassFactory = cls.getMethod("getScript", String.class);
                PlaceComponentResult = cls.getMethod("addLikelySubtags", String.class);
            } catch (Exception e) {
                BuiltInFictitiousFunctionClassFactory = null;
                PlaceComponentResult = null;
                InstrumentInjector.log_w("ICUCompat", e);
            }
        } else if (Build.VERSION.SDK_INT < 24) {
            try {
                PlaceComponentResult = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public static String PlaceComponentResult(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.getAuthRequestContext(Api24Impl.PlaceComponentResult(Api24Impl.MyBillsEntityDataFactory(locale)));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return Api21Impl.MyBillsEntityDataFactory((Locale) PlaceComponentResult.invoke(null, locale));
            } catch (IllegalAccessException e) {
                InstrumentInjector.log_w("ICUCompat", e);
                return Api21Impl.MyBillsEntityDataFactory(locale);
            } catch (InvocationTargetException e2) {
                InstrumentInjector.log_w("ICUCompat", e2);
                return Api21Impl.MyBillsEntityDataFactory(locale);
            }
        }
        String MyBillsEntityDataFactory = MyBillsEntityDataFactory(locale);
        if (MyBillsEntityDataFactory != null) {
            return BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory);
        }
        return null;
    }

    private static String BuiltInFictitiousFunctionClassFactory(String str) {
        try {
            Method method = BuiltInFictitiousFunctionClassFactory;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            InstrumentInjector.log_w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            InstrumentInjector.log_w("ICUCompat", e2);
        }
        return null;
    }

    private static String MyBillsEntityDataFactory(Locale locale) {
        String obj = locale.toString();
        try {
            Method method = PlaceComponentResult;
            if (method != null) {
                return (String) method.invoke(null, obj);
            }
        } catch (IllegalAccessException e) {
            InstrumentInjector.log_w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            InstrumentInjector.log_w("ICUCompat", e2);
        }
        return obj;
    }

    private ICUCompat() {
    }

    /* loaded from: classes3.dex */
    static class Api24Impl {
        private Api24Impl() {
        }

        static ULocale MyBillsEntityDataFactory(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static ULocale PlaceComponentResult(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static String getAuthRequestContext(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    /* loaded from: classes3.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static String MyBillsEntityDataFactory(Locale locale) {
            return locale.getScript();
        }
    }
}
