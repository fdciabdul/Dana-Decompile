package id.dana.savings.activity;

import dagger.MembersInjector;
import id.dana.savings.presenter.SavingUpdatePresenter;

/* loaded from: classes5.dex */
public final class SavingUpdateActivity_MembersInjector implements MembersInjector<SavingUpdateActivity> {
    public static void MyBillsEntityDataFactory(SavingUpdateActivity savingUpdateActivity, SavingUpdatePresenter savingUpdatePresenter) {
        savingUpdateActivity.savingUpdatePresenter = savingUpdatePresenter;
    }
}
