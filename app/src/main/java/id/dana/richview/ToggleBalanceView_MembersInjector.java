package id.dana.richview;

import dagger.MembersInjector;
import id.dana.contract.user.GetBalanceContract;

/* loaded from: classes5.dex */
public final class ToggleBalanceView_MembersInjector implements MembersInjector<ToggleBalanceView> {
    public static void PlaceComponentResult(ToggleBalanceView toggleBalanceView, GetBalanceContract.Presenter presenter) {
        toggleBalanceView.getBalancePresenter = presenter;
    }
}
