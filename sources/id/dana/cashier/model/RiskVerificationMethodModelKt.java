package id.dana.cashier.model;

import id.dana.cashier.domain.model.OneKlikPhones;
import id.dana.cashier.domain.model.RiskVerificationMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/model/RiskVerificationMethod;", "Lid/dana/cashier/model/RiskVerificationMethodModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/domain/model/RiskVerificationMethod;)Lid/dana/cashier/model/RiskVerificationMethodModel;", "", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RiskVerificationMethodModelKt {
    public static final List<RiskVerificationMethodModel> PlaceComponentResult(List<RiskVerificationMethod> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<RiskVerificationMethod> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2((RiskVerificationMethod) it.next()));
        }
        return arrayList;
    }

    public static final RiskVerificationMethodModel KClassImpl$Data$declaredNonStaticMembers$2(RiskVerificationMethod riskVerificationMethod) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(riskVerificationMethod, "");
        String result = riskVerificationMethod.getResult();
        String pubKey = riskVerificationMethod.getPubKey();
        String verificationMethod = riskVerificationMethod.getVerificationMethod();
        String maskPhoneNumber = riskVerificationMethod.getMaskPhoneNumber();
        Boolean needResendButton = riskVerificationMethod.getNeedResendButton();
        List<OneKlikPhones> phoneList = riskVerificationMethod.getPhoneList();
        if (phoneList != null) {
            List<OneKlikPhones> list = phoneList;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(OneKlikPhonesModelKt.MyBillsEntityDataFactory((OneKlikPhones) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new RiskVerificationMethodModel(result, pubKey, verificationMethod, maskPhoneNumber, needResendButton, arrayList, riskVerificationMethod.getVerifyElements());
    }
}
