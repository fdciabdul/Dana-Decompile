package id.dana.contract.nearbyme;

import id.dana.domain.nearbyme.model.NearbyRankingConfig;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes8.dex */
public final /* synthetic */ class NewNearbyPresenter$$ExternalSyntheticLambda14 implements Function1 {
    public final /* synthetic */ NewNearbyPresenter MyBillsEntityDataFactory;

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NewNearbyPresenter newNearbyPresenter = this.MyBillsEntityDataFactory;
        NearbyRankingConfig nearbyRankingConfig = (NearbyRankingConfig) obj;
        if (nearbyRankingConfig.getRadius() != null) {
            newNearbyPresenter.GetContactSyncConfig = new ArrayList();
            double intValue = nearbyRankingConfig.getRadius().intValue();
            double rating = nearbyRankingConfig.getRating();
            double review = nearbyRankingConfig.getReview();
            newNearbyPresenter.GetContactSyncConfig.add(Double.valueOf(intValue));
            newNearbyPresenter.GetContactSyncConfig.add(Double.valueOf(rating));
            newNearbyPresenter.GetContactSyncConfig.add(Double.valueOf(review));
        }
        return Unit.INSTANCE;
    }
}
