package id.dana.richview.boundcard;

import dagger.MembersInjector;
import id.dana.contract.boundcard.BoundCardContract;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.user.GetUserInfoContract;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.richview.boundcard.mapper.BoundCardMapper;

/* loaded from: classes9.dex */
public final class BoundCardView_MembersInjector implements MembersInjector<BoundCardView> {
    public static void BuiltInFictitiousFunctionClassFactory(BoundCardView boundCardView, BoundCardContract.Presenter presenter) {
        boundCardView.presenter = presenter;
    }

    public static void PlaceComponentResult(BoundCardView boundCardView, QueryPayMethodContract.Presenter presenter) {
        boundCardView.queryPayMethodPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(BoundCardView boundCardView, GetUserInfoContract.Presenter presenter) {
        boundCardView.userInfoPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(BoundCardView boundCardView, BoundCardMapper boundCardMapper) {
        boundCardView.boundCardMapper = boundCardMapper;
    }

    public static void PlaceComponentResult(BoundCardView boundCardView, DynamicUrlWrapper dynamicUrlWrapper) {
        boundCardView.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}
