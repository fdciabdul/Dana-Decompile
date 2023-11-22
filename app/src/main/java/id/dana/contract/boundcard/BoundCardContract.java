package id.dana.contract.boundcard;

import id.dana.base.AbstractContract;
import id.dana.richview.boundcard.model.BoundCard;
import java.util.List;

/* loaded from: classes8.dex */
public interface BoundCardContract {

    /* loaded from: classes8.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(String str);

        void getAuthRequestContext();
    }

    /* loaded from: classes8.dex */
    public interface View extends AbstractContract.AbstractView {
        void onCheckEnableExpressPayFeature(Boolean bool);

        void onErrorGetCard(String str);

        void onGetBoundCardsSuccess(List<BoundCard> list);

        void onGetDefaultCardSuccess(String str);

        void onGetIsCardBindingV2Enabled(Boolean bool);

        void onGetPhoneNumberSuccess(String str);
    }
}
