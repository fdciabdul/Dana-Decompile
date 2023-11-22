package id.dana.domain.mybills.model;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a)\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lid/dana/domain/mybills/model/BizProductDestination;", "", "billId", "defaultAmount", "findItemAndReturnAmount", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BizProductDestinationKt {
    public static final String findItemAndReturnAmount(List<BizProductDestination> list, String str, String str2) {
        Object obj;
        String totalAmount;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((BizProductDestination) obj).getBillId(), str)) {
                break;
            }
        }
        BizProductDestination bizProductDestination = (BizProductDestination) obj;
        return (bizProductDestination == null || (totalAmount = bizProductDestination.getTotalAmount()) == null) ? str2 : totalAmount;
    }
}
