package id.dana.riskChallenges.data.forgetpassword.mapper;

import id.dana.riskChallenges.data.forgetpassword.source.network.result.ResetPasswordResult;
import id.dana.riskChallenges.data.forgetpassword.source.network.result.RiskChallengesResult;
import id.dana.riskChallenges.data.forgetpassword.source.network.result.SecurityInfoResult;
import id.dana.riskChallenges.data.forgetpassword.source.network.result.UserInfoResult;
import id.dana.riskChallenges.data.forgetpassword.source.network.result.VerificationMethodsResult;
import id.dana.riskChallenges.domain.forgetpassword.model.ResetPasswordResponseModel;
import id.dana.riskChallenges.domain.forgetpassword.model.RiskChallenges;
import id.dana.riskChallenges.domain.forgetpassword.model.SecurityInfo;
import id.dana.riskChallenges.domain.forgetpassword.model.UserInfo;
import id.dana.riskChallenges.domain.forgetpassword.model.VerificationMethods;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/riskChallenges/data/forgetpassword/source/network/result/ResetPasswordResult;", "Lid/dana/riskChallenges/domain/forgetpassword/model/ResetPasswordResponseModel;", "PlaceComponentResult", "(Lid/dana/riskChallenges/data/forgetpassword/source/network/result/ResetPasswordResult;)Lid/dana/riskChallenges/domain/forgetpassword/model/ResetPasswordResponseModel;", "Lid/dana/riskChallenges/data/forgetpassword/source/network/result/RiskChallengesResult;", "Lid/dana/riskChallenges/domain/forgetpassword/model/RiskChallenges;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/riskChallenges/data/forgetpassword/source/network/result/RiskChallengesResult;)Lid/dana/riskChallenges/domain/forgetpassword/model/RiskChallenges;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResetPasswordMapperKt {
    public static final ResetPasswordResponseModel PlaceComponentResult(ResetPasswordResult resetPasswordResult) {
        Intrinsics.checkNotNullParameter(resetPasswordResult, "");
        boolean z = resetPasswordResult.success;
        return new ResetPasswordResponseModel(Boolean.valueOf(z), resetPasswordResult.getClientKey());
    }

    public static final RiskChallenges KClassImpl$Data$declaredNonStaticMembers$2(RiskChallengesResult riskChallengesResult) {
        SecurityInfo securityInfo;
        UserInfo userInfo;
        Intrinsics.checkNotNullParameter(riskChallengesResult, "");
        Boolean riskSwitch = riskChallengesResult.getRiskSwitch();
        boolean booleanValue = riskSwitch != null ? riskSwitch.booleanValue() : false;
        String riskToken = riskChallengesResult.getRiskToken();
        String str = riskToken == null ? "" : riskToken;
        SecurityInfoResult securityInfo2 = riskChallengesResult.getSecurityInfo();
        if (securityInfo2 == null) {
            securityInfo = new SecurityInfo("", "", "");
        } else {
            Intrinsics.checkNotNullParameter(securityInfo2, "");
            String str2 = securityInfo2.MyBillsEntityDataFactory;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = securityInfo2.getAuthRequestContext;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = securityInfo2.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str4 == null) {
                str4 = "";
            }
            securityInfo = new SecurityInfo(str2, str3, str4);
        }
        boolean z = riskChallengesResult.success;
        UserInfoResult userInfo2 = riskChallengesResult.getUserInfo();
        if (userInfo2 == null) {
            userInfo = new UserInfo("", false);
        } else {
            Intrinsics.checkNotNullParameter(userInfo2, "");
            String str5 = userInfo2.PlaceComponentResult;
            if (str5 == null) {
                str5 = "";
            }
            Boolean bool = userInfo2.KClassImpl$Data$declaredNonStaticMembers$2;
            userInfo = new UserInfo(str5, bool != null ? bool.booleanValue() : false);
        }
        ArrayList<VerificationMethodsResult> verificationMethods = riskChallengesResult.getVerificationMethods();
        Intrinsics.checkNotNullParameter(verificationMethods, "");
        ArrayList<VerificationMethodsResult> arrayList = verificationMethods;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (VerificationMethodsResult verificationMethodsResult : arrayList) {
            Intrinsics.checkNotNullParameter(verificationMethodsResult, "");
            Integer num = verificationMethodsResult.MyBillsEntityDataFactory;
            int intValue = num != null ? num.intValue() : 0;
            String str6 = verificationMethodsResult.getAuthRequestContext;
            if (str6 == null) {
                str6 = "";
            }
            String str7 = verificationMethodsResult.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str7 == null) {
                str7 = "";
            }
            arrayList2.add(new VerificationMethods(intValue, str6, str7));
        }
        return new RiskChallenges(booleanValue, str, securityInfo, z, userInfo, arrayList2);
    }
}
