package id.dana.domain.expresspurchase.interaction;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchasePaylaterConfig;
import id.dana.domain.expresspurchase.interaction.model.PaylaterOffer;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import id.dana.domain.paylater.model.PaylaterAgreementConfig;
import id.dana.domain.promotion.CdpContent;
import id.dana.domain.promotion.Space;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00030\u0003*\f\u0012\b\u0012\u0006*\u00020\u00030\u00030\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/domain/paylater/model/PaylaterAgreementConfig;", "agreementConfig", "Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer;", BridgeDSL.INVOKE, "(Lid/dana/domain/paylater/model/PaylaterAgreementConfig;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetPaylaterOfferExpressPurchase$composePaylaterOffer$2 extends Lambda implements Function1<PaylaterAgreementConfig, Observable<PaylaterOffer>> {
    final /* synthetic */ ExpressPurchasePaylaterConfig $$expressPurchasePaylaterConfig;
    final /* synthetic */ PaylaterOffer $$paylaterOffer;
    final /* synthetic */ GetPaylaterOfferExpressPurchase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPaylaterOfferExpressPurchase$composePaylaterOffer$2(GetPaylaterOfferExpressPurchase getPaylaterOfferExpressPurchase, ExpressPurchasePaylaterConfig expressPurchasePaylaterConfig, PaylaterOffer paylaterOffer) {
        super(1);
        this.this$0 = getPaylaterOfferExpressPurchase;
        this.$$expressPurchasePaylaterConfig = expressPurchasePaylaterConfig;
        this.$$paylaterOffer = paylaterOffer;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Observable<PaylaterOffer> invoke(PaylaterAgreementConfig paylaterAgreementConfig) {
        UserConsentRepository userConsentRepository;
        ExpressPurchaseRepository expressPurchaseRepository;
        Intrinsics.checkNotNullParameter(paylaterAgreementConfig, "");
        userConsentRepository = this.this$0.userConsentRepository;
        Observable consultAgreement$default = UserConsentRepository.CC.consultAgreement$default(userConsentRepository, paylaterAgreementConfig.getSpaceCodes(), null, 2, null);
        expressPurchaseRepository = this.this$0.expressPurchaseRepository;
        Observable<Space> expressPurchaseCdpContent = expressPurchaseRepository.getExpressPurchaseCdpContent(this.$$expressPurchasePaylaterConfig.getCdpSpaceCode());
        final PaylaterOffer paylaterOffer = this.$$paylaterOffer;
        Observable<PaylaterOffer> zip = Observable.zip(consultAgreement$default, expressPurchaseCdpContent, new BiFunction() { // from class: id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase$composePaylaterOffer$2$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                PaylaterOffer m2313invoke$lambda0;
                m2313invoke$lambda0 = GetPaylaterOfferExpressPurchase$composePaylaterOffer$2.m2313invoke$lambda0(PaylaterOffer.this, (ConsultAgreementResponse) obj, (Space) obj2);
                return m2313invoke$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final PaylaterOffer m2313invoke$lambda0(PaylaterOffer paylaterOffer, ConsultAgreementResponse consultAgreementResponse, Space space) {
        PaylaterOffer.Partner partner;
        CdpContent cdpContent;
        AgreementInfo agreementInfo;
        Intrinsics.checkNotNullParameter(paylaterOffer, "");
        Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
        Intrinsics.checkNotNullParameter(space, "");
        PaylaterOffer.Partner partner2 = paylaterOffer.getPartner();
        String str = null;
        if (partner2 != null) {
            List<AgreementInfo> agreementInfos = consultAgreementResponse.getAgreementInfos();
            String contentValue = (agreementInfos == null || (agreementInfo = (AgreementInfo) CollectionsKt.firstOrNull((List) agreementInfos)) == null) ? null : agreementInfo.getContentValue();
            partner = PaylaterOffer.Partner.copy$default(partner2, 0, null, contentValue == null ? "" : contentValue, 3, null);
        } else {
            partner = null;
        }
        List<CdpContent> cdpContents = space.getCdpContents();
        if (cdpContents != null && (cdpContent = (CdpContent) CollectionsKt.firstOrNull((List) cdpContents)) != null) {
            str = cdpContent.getContentValue();
        }
        return PaylaterOffer.copy$default(paylaterOffer, false, partner, str, 1, null);
    }
}
