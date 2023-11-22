package id.dana.savings.activity;

import dagger.MembersInjector;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.savings.presenter.SavingDetailPresenter;
import id.dana.savings.presenter.SavingTopUpPresenter;

/* loaded from: classes5.dex */
public final class SavingDetailActivity_MembersInjector implements MembersInjector<SavingDetailActivity> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(SavingDetailActivity savingDetailActivity, SavingDetailPresenter savingDetailPresenter) {
        savingDetailActivity.savingDetailPresenter = savingDetailPresenter;
    }

    public static void MyBillsEntityDataFactory(SavingDetailActivity savingDetailActivity, SavingTopUpPresenter savingTopUpPresenter) {
        savingDetailActivity.savingTopUpPresenter = savingTopUpPresenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(SavingDetailActivity savingDetailActivity, CheckoutH5EventContract.Presenter presenter) {
        savingDetailActivity.checkoutH5EventPresenter = presenter;
    }
}
