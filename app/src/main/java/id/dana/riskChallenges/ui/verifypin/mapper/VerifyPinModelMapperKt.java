package id.dana.riskChallenges.ui.verifypin.mapper;

import id.dana.riskChallenges.domain.forgetpassword.model.VerificationMethods;
import id.dana.riskChallenges.domain.model.BaseRiskChallenges;
import id.dana.riskChallenges.domain.verifypassword.model.VerifyPassword;
import id.dana.riskChallenges.ui.resetpin.mapper.ResetPinMapperKt;
import id.dana.riskChallenges.ui.resetpin.model.SecurityInfoModel;
import id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel;
import id.dana.riskChallenges.ui.verifypin.model.VerifyPinModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/domain/verifypassword/model/VerifyPassword;", "Lid/dana/riskChallenges/ui/verifypin/model/VerifyPinModel;", "getAuthRequestContext", "(Lid/dana/riskChallenges/domain/verifypassword/model/VerifyPassword;)Lid/dana/riskChallenges/ui/verifypin/model/VerifyPinModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyPinModelMapperKt {
    public static final VerifyPinModel getAuthRequestContext(VerifyPassword verifyPassword) {
        BasicRiskChallengesModel basicRiskChallengesModel;
        Intrinsics.checkNotNullParameter(verifyPassword, "");
        Integer num = verifyPassword.BuiltInFictitiousFunctionClassFactory;
        Long l = verifyPassword.MyBillsEntityDataFactory;
        Long l2 = verifyPassword.PlaceComponentResult;
        Integer num2 = verifyPassword.KClassImpl$Data$declaredNonStaticMembers$2;
        String str = verifyPassword.getErrorConfigVersion;
        BaseRiskChallenges baseRiskChallenges = verifyPassword.getAuthRequestContext;
        if (baseRiskChallenges != null) {
            Intrinsics.checkNotNullParameter(baseRiskChallenges, "");
            String myBillsEntityDataFactory = baseRiskChallenges.getMyBillsEntityDataFactory();
            SecurityInfoModel PlaceComponentResult = ResetPinMapperKt.PlaceComponentResult(baseRiskChallenges.getBuiltInFictitiousFunctionClassFactory());
            List<VerificationMethods> BuiltInFictitiousFunctionClassFactory = baseRiskChallenges.BuiltInFictitiousFunctionClassFactory();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(BuiltInFictitiousFunctionClassFactory, 10));
            Iterator<T> it = BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                arrayList.add(ResetPinMapperKt.MyBillsEntityDataFactory((VerificationMethods) it.next()));
            }
            basicRiskChallengesModel = new BasicRiskChallengesModel(myBillsEntityDataFactory, PlaceComponentResult, arrayList);
        } else {
            basicRiskChallengesModel = null;
        }
        return new VerifyPinModel(num, l, l2, num2, str, basicRiskChallengesModel);
    }
}
