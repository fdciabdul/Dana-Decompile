package id.dana.domain.expresspurchase.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "time", "", "dayThreshold", "", "isMoreThanDaysThreshold", "(JJI)Z"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExpressPurchaseExtKt {
    public static final boolean isMoreThanDaysThreshold(long j, long j2, int i) {
        return j > j2 + (((long) i) * 86400000);
    }
}
