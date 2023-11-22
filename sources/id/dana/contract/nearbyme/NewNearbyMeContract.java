package id.dana.contract.nearbyme;

import android.location.Location;
import id.dana.base.AbstractContract;
import id.dana.nearbyme.model.NearbyShopsModel;
import id.dana.nearbyme.model.ShopModel;
import java.util.List;

/* loaded from: classes4.dex */
public interface NewNearbyMeContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(List<ShopModel> list);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void getAuthRequestContext();

        void getAuthRequestContext(Location location);
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        String BuiltInFictitiousFunctionClassFactory();

        String KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z, boolean z2);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(NearbyShopsModel nearbyShopsModel);

        void PlaceComponentResult(List<ShopModel> list);

        void getAuthRequestContext(boolean z);
    }
}
