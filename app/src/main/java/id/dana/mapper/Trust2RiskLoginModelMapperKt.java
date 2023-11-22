package id.dana.mapper;

import id.dana.domain.model.VerificationTreeNode;
import id.dana.domain.model.rpc.response.LoginResponse;
import id.dana.domain.model.rpc.response.Trust2RiskLoginResponse;
import id.dana.model.Trust2RiskLoginModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\n\u001a\u00020\u0000*\u00020\t¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/model/Trust2RiskLoginModel;", "", "p0", "", "", "p1", "Lid/dana/domain/model/rpc/response/LoginResponse;", "getAuthRequestContext", "(Lid/dana/model/Trust2RiskLoginModel;ILjava/util/Map;)Lid/dana/domain/model/rpc/response/LoginResponse;", "Lid/dana/domain/model/rpc/response/Trust2RiskLoginResponse;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/model/rpc/response/Trust2RiskLoginResponse;)Lid/dana/model/Trust2RiskLoginModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Trust2RiskLoginModelMapperKt {
    public static final Trust2RiskLoginModel KClassImpl$Data$declaredNonStaticMembers$2(Trust2RiskLoginResponse trust2RiskLoginResponse) {
        Intrinsics.checkNotNullParameter(trust2RiskLoginResponse, "");
        return new Trust2RiskLoginModel(trust2RiskLoginResponse.getUserId(), trust2RiskLoginResponse.getSessionId(), trust2RiskLoginResponse.getSecurityId(), trust2RiskLoginResponse.getChallenges(), trust2RiskLoginResponse.getPhoneNumber(), trust2RiskLoginResponse.getRiskPhoneNumber(), trust2RiskLoginResponse.getAvatarUrl(), trust2RiskLoginResponse.getLoginTokenId(), trust2RiskLoginResponse.getFailedCount(), trust2RiskLoginResponse.getMaxFailedCount(), trust2RiskLoginResponse.getLockedExpireSeconds(), null, null, 6144, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.List] */
    public static final LoginResponse getAuthRequestContext(Trust2RiskLoginModel trust2RiskLoginModel, int i, Map<Integer, String> map) {
        T t;
        Object obj;
        Intrinsics.checkNotNullParameter(trust2RiskLoginModel, "");
        Intrinsics.checkNotNullParameter(map, "");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        VerificationTreeNode verificationTreeNode = trust2RiskLoginModel.KClassImpl$Data$declaredNonStaticMembers$2;
        List list = null;
        objectRef.element = verificationTreeNode != null ? verificationTreeNode.getChildren() : 0;
        int i2 = 0;
        while (i2 < i) {
            i2++;
            String str = map.get(Integer.valueOf(i2));
            List list2 = (List) objectRef.element;
            if (list2 != null) {
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(((VerificationTreeNode) obj).getValue(), str)) {
                        break;
                    }
                }
                VerificationTreeNode verificationTreeNode2 = (VerificationTreeNode) obj;
                if (verificationTreeNode2 != null) {
                    t = verificationTreeNode2.getChildren();
                    objectRef.element = t;
                }
            }
            t = 0;
            objectRef.element = t;
        }
        String str2 = trust2RiskLoginModel.DatabaseTableConfigUtil;
        String str3 = trust2RiskLoginModel.initRecordTimeStamp;
        String str4 = trust2RiskLoginModel.moveToNextValue;
        Integer num = trust2RiskLoginModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Integer num2 = trust2RiskLoginModel.MyBillsEntityDataFactory;
        Integer num3 = trust2RiskLoginModel.PlaceComponentResult;
        List list3 = (List) objectRef.element;
        if (list3 != null) {
            List list4 = list3;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator it2 = list4.iterator();
            while (it2.hasNext()) {
                arrayList.add(((VerificationTreeNode) it2.next()).getValue());
            }
            list = CollectionsKt.toMutableList((Collection) arrayList);
        }
        LoginResponse loginResponse = new LoginResponse(str2, str3, null, null, str4, null, num, num2, 0, list, null, num3, null, null, null, trust2RiskLoginModel.scheduleImpl, 29996, null);
        loginResponse.setSuccess(true);
        return loginResponse;
    }
}
