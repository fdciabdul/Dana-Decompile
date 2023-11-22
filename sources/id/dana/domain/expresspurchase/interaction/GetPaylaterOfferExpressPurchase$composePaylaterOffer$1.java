package id.dana.domain.expresspurchase.interaction;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchasePaylaterConfig;
import id.dana.domain.expresspurchase.interaction.model.PaylaterOffer;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import id.dana.domain.paylater.model.PaylaterAgreementConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer;", "paylaterOffer", "Lio/reactivex/Observable;", BridgeDSL.INVOKE, "(Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetPaylaterOfferExpressPurchase$composePaylaterOffer$1 extends Lambda implements Function1<PaylaterOffer, Observable<PaylaterOffer>> {
    final /* synthetic */ ExpressPurchasePaylaterConfig $$config;
    final /* synthetic */ GetPaylaterOfferExpressPurchase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPaylaterOfferExpressPurchase$composePaylaterOffer$1(GetPaylaterOfferExpressPurchase getPaylaterOfferExpressPurchase, ExpressPurchasePaylaterConfig expressPurchasePaylaterConfig) {
        super(1);
        this.this$0 = getPaylaterOfferExpressPurchase;
        this.$$config = expressPurchasePaylaterConfig;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Observable<PaylaterOffer> invoke(PaylaterOffer paylaterOffer) {
        Observable<PaylaterOffer> noOffer;
        ExpressPurchaseRepository expressPurchaseRepository;
        final Function1 composePaylaterOffer;
        Intrinsics.checkNotNullParameter(paylaterOffer, "");
        if (paylaterOffer.getHasOffer()) {
            expressPurchaseRepository = this.this$0.expressPurchaseRepository;
            Observable<PaylaterAgreementConfig> paylaterAgreementConfig = expressPurchaseRepository.getPaylaterAgreementConfig();
            composePaylaterOffer = this.this$0.composePaylaterOffer(this.$$config, paylaterOffer);
            Observable flatMap = paylaterAgreementConfig.flatMap(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase$composePaylaterOffer$1$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m2312invoke$lambda0;
                    m2312invoke$lambda0 = GetPaylaterOfferExpressPurchase$composePaylaterOffer$1.m2312invoke$lambda0(Function1.this, (PaylaterAgreementConfig) obj);
                    return m2312invoke$lambda0;
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            return flatMap;
        }
        noOffer = this.this$0.noOffer();
        return noOffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final ObservableSource m2312invoke$lambda0(Function1 function1, PaylaterAgreementConfig paylaterAgreementConfig) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(paylaterAgreementConfig);
    }
}
