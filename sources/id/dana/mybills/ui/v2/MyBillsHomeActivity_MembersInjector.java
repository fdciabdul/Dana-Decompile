package id.dana.mybills.ui.v2;

import dagger.MembersInjector;
import id.dana.mybills.di.module.ViewModelFactory;

/* loaded from: classes9.dex */
public final class MyBillsHomeActivity_MembersInjector implements MembersInjector<MyBillsHomeActivity> {
    public static void getAuthRequestContext(MyBillsHomeActivity myBillsHomeActivity, ViewModelFactory viewModelFactory) {
        myBillsHomeActivity.viewModelFactory = viewModelFactory;
    }
}
