package id.dana.riskChallenges.data.danaprotection.mapper;

import id.dana.network.response.authface.VerificationMethodInfoEntity;
import id.dana.riskChallenges.data.danaprotection.source.network.result.RiskChallengeStatusResult;
import id.dana.riskChallenges.domain.danaprotection.model.RiskChallengeStatusModel;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/data/danaprotection/source/network/result/RiskChallengeStatusResult;", "Lid/dana/riskChallenges/domain/danaprotection/model/RiskChallengeStatusModel;", "getAuthRequestContext", "(Lid/dana/riskChallenges/data/danaprotection/source/network/result/RiskChallengeStatusResult;)Lid/dana/riskChallenges/domain/danaprotection/model/RiskChallengeStatusModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class RiskChallengeStatusMapperKt {
    public static final RiskChallengeStatusModel getAuthRequestContext(RiskChallengeStatusResult riskChallengeStatusResult) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(riskChallengeStatusResult, "");
        String riskResult = riskChallengeStatusResult.getRiskResult();
        String str = riskResult == null ? "" : riskResult;
        String securityId = riskChallengeStatusResult.getSecurityId();
        String str2 = securityId == null ? "" : securityId;
        List<VerificationMethodInfoEntity> verificationMethods = riskChallengeStatusResult.getVerificationMethods();
        if (verificationMethods != null) {
            List<VerificationMethodInfoEntity> list = verificationMethods;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (VerificationMethodInfoEntity verificationMethodInfoEntity : list) {
                int priority = verificationMethodInfoEntity.getPriority();
                String verificationMethod = verificationMethodInfoEntity.getVerificationMethod();
                if (verificationMethod == null) {
                    verificationMethod = "";
                }
                String verificationMethod2 = verificationMethodInfoEntity.getVerificationMethod();
                if (verificationMethod2 == null) {
                    verificationMethod2 = "";
                }
                arrayList2.add(new VerificationMethodModel(priority, verificationMethod, verificationMethod2));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        String riskInfo = riskChallengeStatusResult.getRiskInfo();
        String str3 = riskInfo == null ? "" : riskInfo;
        String ctaResult = riskChallengeStatusResult.getCtaResult();
        String str4 = ctaResult == null ? "" : ctaResult;
        String journeySuggestion = riskChallengeStatusResult.getJourneySuggestion();
        return new RiskChallengeStatusModel(str, str2, arrayList, str3, str4, journeySuggestion == null ? "" : journeySuggestion);
    }
}
