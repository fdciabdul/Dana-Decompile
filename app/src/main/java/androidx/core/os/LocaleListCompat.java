package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class LocaleListCompat {
    private static final LocaleListCompat PlaceComponentResult = BuiltInFictitiousFunctionClassFactory(new Locale[0]);
    private final LocaleListInterface getAuthRequestContext;

    private LocaleListCompat(LocaleListInterface localeListInterface) {
        this.getAuthRequestContext = localeListInterface;
    }

    public static LocaleListCompat KClassImpl$Data$declaredNonStaticMembers$2(LocaleList localeList) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(localeList));
    }

    public static LocaleListCompat BuiltInFictitiousFunctionClassFactory(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return KClassImpl$Data$declaredNonStaticMembers$2(Api24Impl.KClassImpl$Data$declaredNonStaticMembers$2(localeArr));
        }
        return new LocaleListCompat(new LocaleListCompatWrapper(localeArr));
    }

    public final Locale BuiltInFictitiousFunctionClassFactory(int i) {
        return this.getAuthRequestContext.MyBillsEntityDataFactory(i);
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Locale PlaceComponentResult(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (str.contains("_")) {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        } else {
            return new Locale(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can not parse language tag: [");
        sb.append(str);
        sb.append("]");
        throw new IllegalArgumentException(sb.toString());
    }

    public static LocaleListCompat getAuthRequestContext() {
        return Build.VERSION.SDK_INT >= 24 ? KClassImpl$Data$declaredNonStaticMembers$2(Api24Impl.MyBillsEntityDataFactory()) : BuiltInFictitiousFunctionClassFactory(Locale.getDefault());
    }

    /* loaded from: classes6.dex */
    static class Api21Impl {
        private static final Locale[] MyBillsEntityDataFactory = {new Locale("en", "XA"), new Locale("ar", "XB")};

        private Api21Impl() {
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof LocaleListCompat) && this.getAuthRequestContext.equals(((LocaleListCompat) obj).getAuthRequestContext);
    }

    public final int hashCode() {
        return this.getAuthRequestContext.hashCode();
    }

    public final String toString() {
        return this.getAuthRequestContext.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList KClassImpl$Data$declaredNonStaticMembers$2(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList MyBillsEntityDataFactory() {
            return LocaleList.getAdjustedDefault();
        }
    }
}
