package id.dana.contract.nearbyme;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.domain.nearbyme.model.NearbyRankingConfig;
import id.dana.drawable.ShopRankingCalculator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/model/NearbyRankingConfig;", "nearbyRankingConfig", "", BridgeDSL.INVOKE, "(Lid/dana/domain/nearbyme/model/NearbyRankingConfig;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
final class NearbyMerchantLocationSearchPresenter$getNearbyRankingConfig$1 extends Lambda implements Function1<NearbyRankingConfig, Unit> {
    final /* synthetic */ NearbyMerchantLocationSearchPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NearbyMerchantLocationSearchPresenter$getNearbyRankingConfig$1(NearbyMerchantLocationSearchPresenter nearbyMerchantLocationSearchPresenter) {
        super(1);
        this.this$0 = nearbyMerchantLocationSearchPresenter;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(NearbyRankingConfig nearbyRankingConfig) {
        invoke2(nearbyRankingConfig);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(NearbyRankingConfig nearbyRankingConfig) {
        ShopRankingCalculator shopRankingCalculator;
        Intrinsics.checkNotNullParameter(nearbyRankingConfig, "");
        shopRankingCalculator = this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda2;
        shopRankingCalculator.BuiltInFictitiousFunctionClassFactory(nearbyRankingConfig.getRadius(), Integer.valueOf(nearbyRankingConfig.getRating()), Integer.valueOf(nearbyRankingConfig.getReview()));
    }
}
