package id.dana.feeds.ui.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lid/dana/feeds/ui/model/DealsVoucherColor;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/feeds/ui/model/DealsVoucherColor;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DealsVoucherColorKt {
    public static final DealsVoucherColor KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        if (Intrinsics.areEqual(str, "blue")) {
            return DealsVoucherColor.BLUE;
        }
        Intrinsics.areEqual(str, "white");
        return DealsVoucherColor.WHITE;
    }
}
