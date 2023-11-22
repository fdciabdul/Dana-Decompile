package id.dana.domain.expresspurchase.interaction;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase;
import id.dana.domain.expresspurchase.interaction.model.AddonOffer;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseConfig;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseType;
import id.dana.domain.expresspurchase.interaction.model.LatestExpressPurchaseAction;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00030\u0003*\f\u0012\b\u0012\u0006*\u00020\u00030\u00030\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchaseConfig;", "config", "Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/interaction/model/AddonOffer;", BridgeDSL.INVOKE, "(Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchaseConfig;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetAddOnOfferExpressPurchase$checkOfferEP$1 extends Lambda implements Function1<ExpressPurchaseConfig, Observable<AddonOffer>> {
    final /* synthetic */ GetAddOnOfferExpressPurchase.Params $$params;
    final /* synthetic */ GetAddOnOfferExpressPurchase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetAddOnOfferExpressPurchase$checkOfferEP$1(GetAddOnOfferExpressPurchase getAddOnOfferExpressPurchase, GetAddOnOfferExpressPurchase.Params params) {
        super(1);
        this.this$0 = getAddOnOfferExpressPurchase;
        this.$$params = params;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Observable<AddonOffer> invoke(final ExpressPurchaseConfig expressPurchaseConfig) {
        ExpressPurchaseRepository expressPurchaseRepository;
        Intrinsics.checkNotNullParameter(expressPurchaseConfig, "");
        expressPurchaseRepository = this.this$0.expressPurchaseRepository;
        Observable<LatestExpressPurchaseAction> lastExpressPurchaseAction = expressPurchaseRepository.getLastExpressPurchaseAction(this.$$params.getAddonId(), ExpressPurchaseType.ADDON.name());
        final GetAddOnOfferExpressPurchase getAddOnOfferExpressPurchase = this.this$0;
        final GetAddOnOfferExpressPurchase.Params params = this.$$params;
        Observable<R> map = lastExpressPurchaseAction.map(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase$checkOfferEP$1$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m2303invoke$lambda0;
                m2303invoke$lambda0 = GetAddOnOfferExpressPurchase$checkOfferEP$1.m2303invoke$lambda0(GetAddOnOfferExpressPurchase.this, params, expressPurchaseConfig, (LatestExpressPurchaseAction) obj);
                return m2303invoke$lambda0;
            }
        });
        final GetAddOnOfferExpressPurchase getAddOnOfferExpressPurchase2 = this.this$0;
        final GetAddOnOfferExpressPurchase.Params params2 = this.$$params;
        Observable<AddonOffer> flatMap = map.flatMap(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase$checkOfferEP$1$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2304invoke$lambda1;
                m2304invoke$lambda1 = GetAddOnOfferExpressPurchase$checkOfferEP$1.m2304invoke$lambda1(GetAddOnOfferExpressPurchase.this, params2, (Boolean) obj);
                return m2304invoke$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Boolean m2303invoke$lambda0(GetAddOnOfferExpressPurchase getAddOnOfferExpressPurchase, GetAddOnOfferExpressPurchase.Params params, ExpressPurchaseConfig expressPurchaseConfig, LatestExpressPurchaseAction latestExpressPurchaseAction) {
        boolean checkCoolDownEP;
        Intrinsics.checkNotNullParameter(getAddOnOfferExpressPurchase, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(expressPurchaseConfig, "");
        Intrinsics.checkNotNullParameter(latestExpressPurchaseAction, "");
        checkCoolDownEP = getAddOnOfferExpressPurchase.checkCoolDownEP(params, latestExpressPurchaseAction, expressPurchaseConfig);
        return Boolean.valueOf(checkCoolDownEP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final ObservableSource m2304invoke$lambda1(GetAddOnOfferExpressPurchase getAddOnOfferExpressPurchase, GetAddOnOfferExpressPurchase.Params params, Boolean bool) {
        Observable isEPCanProceed;
        Intrinsics.checkNotNullParameter(getAddOnOfferExpressPurchase, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(bool, "");
        isEPCanProceed = getAddOnOfferExpressPurchase.isEPCanProceed(params, bool.booleanValue());
        return isEPCanProceed;
    }
}
