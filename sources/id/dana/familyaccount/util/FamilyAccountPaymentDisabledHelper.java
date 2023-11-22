package id.dana.familyaccount.util;

import id.dana.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R&\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/familyaccount/util/FamilyAccountPaymentDisabledHelper;", "", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)I", "", "Lkotlin/Pair;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyAccountPaymentDisabledHelper {
    public static final FamilyAccountPaymentDisabledHelper INSTANCE = new FamilyAccountPaymentDisabledHelper();
    private static final List<Pair<String, Integer>> KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.listOf(new Pair("AE13112168000917", Integer.valueOf((int) R.string.family_account_payment_method_not_available)));

    private FamilyAccountPaymentDisabledHelper() {
    }

    public static int getAuthRequestContext(String p0) {
        Object obj;
        Intrinsics.checkNotNullParameter(p0, "");
        Iterator<T> it = KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Pair) obj).getFirst(), p0)) {
                break;
            }
        }
        Pair pair = (Pair) obj;
        if (pair != null) {
            return ((Number) pair.getSecond()).intValue();
        }
        return 0;
    }
}
