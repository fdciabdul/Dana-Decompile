package id.dana.onboarding.confirmpin;

import dagger.MembersInjector;
import id.dana.onboarding.confirmpin.ConfirmPinContract;
import id.dana.tncsummary.TncSummaryContract;

/* loaded from: classes5.dex */
public final class ConfirmPinFragment_MembersInjector implements MembersInjector<ConfirmPinFragment> {
    public static void MyBillsEntityDataFactory(ConfirmPinFragment confirmPinFragment, ConfirmPinContract.Presenter presenter) {
        confirmPinFragment.presenter = presenter;
    }

    public static void PlaceComponentResult(ConfirmPinFragment confirmPinFragment, TncSummaryContract.Presenter presenter) {
        confirmPinFragment.tncSummaryPresenter = presenter;
    }
}
