package id.dana.domain.pocket.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "status", "", "isExpiredOrRedeemed", "(Ljava/lang/String;)Z"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AssetStatusKt {
    public static final boolean isExpiredOrRedeemed(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return Intrinsics.areEqual(str, AssetStatus.REDEEMED.getValue()) || Intrinsics.areEqual(str, AssetStatus.EXPIRED.getValue());
    }
}
