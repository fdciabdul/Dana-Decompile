package id.dana.richview.boundcard;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.savings.contract.SavingContract;

/* loaded from: classes9.dex */
public final class DanaBalanceCardView_MembersInjector implements MembersInjector<DanaBalanceCardView> {
    public static void BuiltInFictitiousFunctionClassFactory(DanaBalanceCardView danaBalanceCardView, DynamicUrlWrapper dynamicUrlWrapper) {
        danaBalanceCardView.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void getAuthRequestContext(DanaBalanceCardView danaBalanceCardView, SavingContract.Presenter presenter) {
        danaBalanceCardView.goalsPresenter = presenter;
    }
}
