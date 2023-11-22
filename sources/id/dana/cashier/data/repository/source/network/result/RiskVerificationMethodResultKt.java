package id.dana.cashier.data.repository.source.network.result;

import id.dana.cashier.domain.model.RiskVerificationMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/RiskVerificationMethodResult;", "Lid/dana/cashier/domain/model/RiskVerificationMethod;", "toRiskVerificationMethod", "(Lid/dana/cashier/data/repository/source/network/result/RiskVerificationMethodResult;)Lid/dana/cashier/domain/model/RiskVerificationMethod;", "", "toRiskVerificationMethods", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RiskVerificationMethodResultKt {
    public static final List<RiskVerificationMethod> toRiskVerificationMethods(List<RiskVerificationMethodResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<RiskVerificationMethodResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toRiskVerificationMethod((RiskVerificationMethodResult) it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final id.dana.cashier.domain.model.RiskVerificationMethod toRiskVerificationMethod(id.dana.cashier.data.repository.source.network.result.RiskVerificationMethodResult r9) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r2 = r9.getResult()
            id.dana.cashier.data.repository.source.network.result.SecurityContextResult r0 = r9.getSecurityContext()
            r1 = 0
            if (r0 == 0) goto L19
            java.lang.String r0 = r0.getSecurityId()
            if (r0 != 0) goto L17
            goto L19
        L17:
            r3 = r0
            goto L25
        L19:
            id.dana.cashier.data.repository.source.network.result.SecurityContextResult r0 = r9.getSecurityContext()
            if (r0 == 0) goto L24
            java.lang.String r0 = r0.getPubKey()
            goto L17
        L24:
            r3 = r1
        L25:
            java.lang.String r4 = r9.getVerificationMethod()
            java.lang.String r5 = r9.getMaskPhoneNumber()
            java.lang.Boolean r6 = r9.getNeedResendButton()
            java.util.List r0 = r9.getPhoneList()
            if (r0 == 0) goto L60
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r7 = 10
            int r7 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r7)
            r1.<init>(r7)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L4a:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L5e
            java.lang.Object r7 = r0.next()
            id.dana.cashier.data.repository.source.network.result.OneKlikPhonesResult r7 = (id.dana.cashier.data.repository.source.network.result.OneKlikPhonesResult) r7
            id.dana.cashier.domain.model.OneKlikPhones r7 = id.dana.cashier.data.repository.source.network.result.OneKlikPhonesResultKt.toOneKlikPhone(r7)
            r1.add(r7)
            goto L4a
        L5e:
            java.util.List r1 = (java.util.List) r1
        L60:
            r7 = r1
            java.util.List r8 = r9.getVerifyElements()
            id.dana.cashier.domain.model.RiskVerificationMethod r9 = new id.dana.cashier.domain.model.RiskVerificationMethod
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.data.repository.source.network.result.RiskVerificationMethodResultKt.toRiskVerificationMethod(id.dana.cashier.data.repository.source.network.result.RiskVerificationMethodResult):id.dana.cashier.domain.model.RiskVerificationMethod");
    }
}
