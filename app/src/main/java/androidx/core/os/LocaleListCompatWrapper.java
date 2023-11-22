package androidx.core.os;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class LocaleListCompatWrapper implements LocaleListInterface {
    private final Locale[] MyBillsEntityDataFactory;
    private final String getErrorConfigVersion;
    private static final Locale[] getAuthRequestContext = new Locale[0];
    private static final Locale PlaceComponentResult = new Locale("en", "XA");
    private static final Locale KClassImpl$Data$declaredNonStaticMembers$2 = new Locale("ar", "XB");
    private static final Locale BuiltInFictitiousFunctionClassFactory = LocaleListCompat.PlaceComponentResult("en-Latn");

    @Override // androidx.core.os.LocaleListInterface
    public final Object getAuthRequestContext() {
        return null;
    }

    @Override // androidx.core.os.LocaleListInterface
    public final Locale MyBillsEntityDataFactory(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.MyBillsEntityDataFactory;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).MyBillsEntityDataFactory;
        if (this.MyBillsEntityDataFactory.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.MyBillsEntityDataFactory;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    public final int hashCode() {
        int i = 1;
        for (Locale locale : this.MyBillsEntityDataFactory) {
            i = (i * 31) + locale.hashCode();
        }
        return i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.MyBillsEntityDataFactory;
            if (i < localeArr.length) {
                sb.append(localeArr[i]);
                if (i < this.MyBillsEntityDataFactory.length - 1) {
                    sb.append(',');
                }
                i++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public final String PlaceComponentResult() {
        return this.getErrorConfigVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocaleListCompatWrapper(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.MyBillsEntityDataFactory = getAuthRequestContext;
            this.getErrorConfigVersion = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("list[");
                sb2.append(i);
                sb2.append("] is null");
                throw new NullPointerException(sb2.toString());
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                PlaceComponentResult(sb, locale2);
                if (i < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.MyBillsEntityDataFactory = (Locale[]) arrayList.toArray(new Locale[0]);
        this.getErrorConfigVersion = sb.toString();
    }

    static void PlaceComponentResult(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append('-');
        sb.append(locale.getCountry());
    }

    /* loaded from: classes6.dex */
    static class Api21Impl {
        private Api21Impl() {
        }
    }
}
