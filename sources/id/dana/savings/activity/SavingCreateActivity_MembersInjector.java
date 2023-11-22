package id.dana.savings.activity;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.savings.contract.SavingCreateContract;

/* loaded from: classes5.dex */
public final class SavingCreateActivity_MembersInjector implements MembersInjector<SavingCreateActivity> {
    public static void getAuthRequestContext(SavingCreateActivity savingCreateActivity, SavingCreateContract.Presenter presenter) {
        savingCreateActivity.presenter = presenter;
    }

    public static void getAuthRequestContext(SavingCreateActivity savingCreateActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        savingCreateActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}
