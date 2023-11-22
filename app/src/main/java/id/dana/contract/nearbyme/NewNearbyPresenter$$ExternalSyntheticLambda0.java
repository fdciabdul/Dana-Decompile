package id.dana.contract.nearbyme;

import id.dana.nearbyme.model.ShopModel;
import java.util.Comparator;

/* loaded from: classes8.dex */
public final /* synthetic */ class NewNearbyPresenter$$ExternalSyntheticLambda0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compare;
        compare = Double.compare(((ShopModel) obj).getErrorConfigVersion, ((ShopModel) obj2).getErrorConfigVersion);
        return compare;
    }
}
