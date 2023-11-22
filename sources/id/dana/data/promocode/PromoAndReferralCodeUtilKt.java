package id.dana.data.promocode;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a'\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0005\u001a\u00020\u00018\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "cityName", "setUserCity", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", "USER_CITY", "Ljava/lang/String;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromoAndReferralCodeUtilKt {
    public static final String USER_CITY = "city";

    public static final String setUserCity(Map<String, String> map, String str) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(str, "");
        return map.put("city", str);
    }
}
