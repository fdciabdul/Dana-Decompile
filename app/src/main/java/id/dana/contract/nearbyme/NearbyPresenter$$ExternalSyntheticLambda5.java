package id.dana.contract.nearbyme;

import id.dana.nearbyme.model.ShopModel;
import java.util.Comparator;

/* loaded from: classes4.dex */
public final /* synthetic */ class NearbyPresenter$$ExternalSyntheticLambda5 implements Comparator {
    public final /* synthetic */ NearbyPresenter KClassImpl$Data$declaredNonStaticMembers$2;

    public /* synthetic */ NearbyPresenter$$ExternalSyntheticLambda5(NearbyPresenter nearbyPresenter) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = nearbyPresenter;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        NearbyPresenter nearbyPresenter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return Double.compare(nearbyPresenter.getSupportButtonTintMode.KClassImpl$Data$declaredNonStaticMembers$2((ShopModel) obj2), nearbyPresenter.getSupportButtonTintMode.KClassImpl$Data$declaredNonStaticMembers$2((ShopModel) obj));
    }
}
