package id.dana.contract.nearbyme;

import id.dana.nearbyme.model.ShopModel;
import java.util.Comparator;

/* loaded from: classes8.dex */
public final /* synthetic */ class NewNearbyPresenter$$ExternalSyntheticLambda13 implements Comparator {
    public final /* synthetic */ NewNearbyPresenter MyBillsEntityDataFactory;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        NewNearbyPresenter newNearbyPresenter = this.MyBillsEntityDataFactory;
        return Double.compare(newNearbyPresenter.PrepareContext.get().KClassImpl$Data$declaredNonStaticMembers$2((ShopModel) obj2), newNearbyPresenter.PrepareContext.get().KClassImpl$Data$declaredNonStaticMembers$2((ShopModel) obj));
    }
}
