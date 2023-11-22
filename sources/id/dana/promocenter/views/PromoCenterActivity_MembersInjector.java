package id.dana.promocenter.views;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.promocenter.promo.PromoCenterContract;

/* loaded from: classes5.dex */
public final class PromoCenterActivity_MembersInjector implements MembersInjector<PromoCenterActivity> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(PromoCenterActivity promoCenterActivity, PromoCenterContract.Presenter presenter) {
        promoCenterActivity.promoCenterPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(PromoCenterActivity promoCenterActivity, ReadLinkPropertiesContract.Presenter presenter) {
        promoCenterActivity.readLinkPropertiesPresenter = presenter;
    }
}
