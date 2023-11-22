package id.dana.data.util;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/util/LocaleUtils;", "", "", "iso3CountryCode", "getIso2CountryCode", "(Ljava/lang/String;)Ljava/lang/String;", "", "initIsoCodes", "()V", "", "isoCodesMap", "Ljava/util/Map;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocaleUtils {
    public static final LocaleUtils INSTANCE = new LocaleUtils();
    private static Map<String, String> isoCodesMap = new LinkedHashMap();

    private LocaleUtils() {
    }

    public final void initIsoCodes() {
        if (isoCodesMap.isEmpty()) {
            String[] iSOCountries = Locale.getISOCountries();
            Intrinsics.checkNotNullExpressionValue(iSOCountries, "");
            for (String str : iSOCountries) {
                Locale locale = new Locale("", str);
                Map<String, String> map = isoCodesMap;
                String iSO3Country = locale.getISO3Country();
                Intrinsics.checkNotNullExpressionValue(iSO3Country, "");
                Intrinsics.checkNotNullExpressionValue(str, "");
                map.put(iSO3Country, str);
            }
        }
    }

    public final String getIso2CountryCode(String iso3CountryCode) {
        if (iso3CountryCode != null) {
            Map<String, String> map = isoCodesMap;
            String upperCase = iso3CountryCode.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            String str = map.get(upperCase);
            return str == null ? "" : str;
        }
        return "";
    }
}
