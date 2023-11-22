package id.dana.promocode.views;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.promocode.RedeemPromoCodeContract;

/* loaded from: classes5.dex */
public final class RedeemPromoCodeActivity_MembersInjector implements MembersInjector<RedeemPromoCodeActivity> {
    public static void MyBillsEntityDataFactory(RedeemPromoCodeActivity redeemPromoCodeActivity, RedeemPromoCodeContract.Presenter presenter) {
        redeemPromoCodeActivity.redeemPromoCodePresenter = presenter;
    }

    public static void getAuthRequestContext(RedeemPromoCodeActivity redeemPromoCodeActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        redeemPromoCodeActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}
