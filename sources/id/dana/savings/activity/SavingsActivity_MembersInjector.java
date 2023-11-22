package id.dana.savings.activity;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.savings.contract.SavingContract;
import id.dana.savings.presenter.SavingConfigPresenter;

/* loaded from: classes5.dex */
public final class SavingsActivity_MembersInjector implements MembersInjector<SavingsActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(SavingsActivity savingsActivity, SavingContract.Presenter presenter) {
        savingsActivity.savingPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(SavingsActivity savingsActivity, SavingConfigPresenter savingConfigPresenter) {
        savingsActivity.savingConfigPresenter = savingConfigPresenter;
    }

    public static void getAuthRequestContext(SavingsActivity savingsActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        savingsActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}
