package id.dana.sendmoney.util;

import id.dana.sendmoney.constants.GroupSendRecipientType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/lang/String;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupSendTrackerExtKt {
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return Intrinsics.areEqual(str, GroupSendRecipientType.CONTACT) ? "Peer" : Intrinsics.areEqual(str, GroupSendRecipientType.BANK) ? "Bank" : "";
    }
}
