package id.dana.riskChallenges.ui.resetpin.mapper;

import id.dana.riskChallenges.domain.forgetpassword.model.RiskChallenges;
import id.dana.riskChallenges.domain.forgetpassword.model.SecurityInfo;
import id.dana.riskChallenges.domain.forgetpassword.model.UserInfo;
import id.dana.riskChallenges.domain.forgetpassword.model.VerificationMethods;
import id.dana.riskChallenges.ui.resetpin.model.ResetPinModel;
import id.dana.riskChallenges.ui.resetpin.model.SecurityInfoModel;
import id.dana.riskChallenges.ui.resetpin.model.UserInfoModel;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/riskChallenges/domain/forgetpassword/model/RiskChallenges;", "Lid/dana/riskChallenges/ui/resetpin/model/ResetPinModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/riskChallenges/domain/forgetpassword/model/RiskChallenges;)Lid/dana/riskChallenges/ui/resetpin/model/ResetPinModel;", "Lid/dana/riskChallenges/domain/forgetpassword/model/SecurityInfo;", "Lid/dana/riskChallenges/ui/resetpin/model/SecurityInfoModel;", "PlaceComponentResult", "(Lid/dana/riskChallenges/domain/forgetpassword/model/SecurityInfo;)Lid/dana/riskChallenges/ui/resetpin/model/SecurityInfoModel;", "Lid/dana/riskChallenges/domain/forgetpassword/model/VerificationMethods;", "Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;", "MyBillsEntityDataFactory", "(Lid/dana/riskChallenges/domain/forgetpassword/model/VerificationMethods;)Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResetPinMapperKt {
    public static final ResetPinModel KClassImpl$Data$declaredNonStaticMembers$2(RiskChallenges riskChallenges) {
        Intrinsics.checkNotNullParameter(riskChallenges, "");
        boolean placeComponentResult = riskChallenges.getPlaceComponentResult();
        String str = riskChallenges.MyBillsEntityDataFactory;
        SecurityInfo securityInfo = riskChallenges.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(securityInfo, "");
        SecurityInfoModel securityInfoModel = new SecurityInfoModel(securityInfo.BuiltInFictitiousFunctionClassFactory, securityInfo.PlaceComponentResult, securityInfo.KClassImpl$Data$declaredNonStaticMembers$2);
        boolean kClassImpl$Data$declaredNonStaticMembers$2 = riskChallenges.getKClassImpl$Data$declaredNonStaticMembers$2();
        UserInfo userInfo = riskChallenges.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(userInfo, "");
        UserInfoModel userInfoModel = new UserInfoModel(userInfo.BuiltInFictitiousFunctionClassFactory, userInfo.getGetAuthRequestContext());
        List<VerificationMethods> list = riskChallenges.getErrorConfigVersion;
        Intrinsics.checkNotNullParameter(list, "");
        List<VerificationMethods> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (VerificationMethods verificationMethods : list2) {
            Intrinsics.checkNotNullParameter(verificationMethods, "");
            arrayList.add(new VerificationMethodModel(verificationMethods.PlaceComponentResult, verificationMethods.MyBillsEntityDataFactory, verificationMethods.getAuthRequestContext));
        }
        return new ResetPinModel(placeComponentResult, str, securityInfoModel, kClassImpl$Data$declaredNonStaticMembers$2, userInfoModel, arrayList);
    }

    public static final SecurityInfoModel PlaceComponentResult(SecurityInfo securityInfo) {
        Intrinsics.checkNotNullParameter(securityInfo, "");
        return new SecurityInfoModel(securityInfo.BuiltInFictitiousFunctionClassFactory, securityInfo.PlaceComponentResult, securityInfo.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public static final VerificationMethodModel MyBillsEntityDataFactory(VerificationMethods verificationMethods) {
        Intrinsics.checkNotNullParameter(verificationMethods, "");
        return new VerificationMethodModel(verificationMethods.PlaceComponentResult, verificationMethods.MyBillsEntityDataFactory, verificationMethods.getAuthRequestContext);
    }
}
