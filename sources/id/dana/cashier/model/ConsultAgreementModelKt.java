package id.dana.cashier.model;

import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "Lid/dana/cashier/model/ConsultAgreementModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/useragreement/model/ConsultAgreementResponse;)Lid/dana/cashier/model/ConsultAgreementModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsultAgreementModelKt {
    public static final ConsultAgreementModel BuiltInFictitiousFunctionClassFactory(ConsultAgreementResponse consultAgreementResponse) {
        Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
        return new ConsultAgreementModel(consultAgreementResponse.getNeedUserAgreement(), consultAgreementResponse.getAgreementInfos());
    }
}
