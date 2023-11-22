package id.dana.richview.splitbill;

import dagger.MembersInjector;
import id.dana.richview.splitbill.SelectedPayerContract;

/* loaded from: classes5.dex */
public final class SelectedPayerView_MembersInjector implements MembersInjector<SelectedPayerView> {
    public static void PlaceComponentResult(SelectedPayerView selectedPayerView, SelectedPayerContract.Presenter presenter) {
        selectedPayerView.presenter = presenter;
    }
}
