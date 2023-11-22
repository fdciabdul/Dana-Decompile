package id.dana.contract.promocenter.promo;

import android.location.Location;
import id.dana.base.AbstractContract;
import id.dana.promocenter.model.PromoModel;
import id.dana.promocenter.model.PromoResultModel;
import java.util.List;

/* loaded from: classes4.dex */
public interface PromoCenterContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(Location location);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z, String str);

        void MyBillsEntityDataFactory(String str, boolean z, Location location);

        void PlaceComponentResult();
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void onEmptyGetPromoCategorized();

        void onEmptyGetPromoList();

        void onErrorGetPromo();

        void onErrorGetPromoCategorized();

        void onErrorLoadMorePromo(boolean z);

        void onGetPromoAdsError();

        void onGetPromoAdsSuccess(List<PromoModel> list);

        void onSuccessGetPromoList(PromoResultModel promoResultModel);

        void onSuccessLoadMorePromo(PromoResultModel promoResultModel);

        void trackPromotionCenterOpen();
    }
}
