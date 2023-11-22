package id.dana.richview.bank;

import dagger.MembersInjector;
import id.dana.richview.bank.AutoCompleteBankContract;

/* loaded from: classes9.dex */
public final class AutoCompleteBankView_MembersInjector implements MembersInjector<AutoCompleteBankView> {
    public static void getAuthRequestContext(AutoCompleteBankView autoCompleteBankView, AutoCompleteBankContract.Presenter presenter) {
        autoCompleteBankView.presenter = presenter;
    }
}
