package id.dana.cashier.guide.bottomsheet;

import dagger.MembersInjector;
import id.dana.cashier.guide.contract.GuideContract;

/* loaded from: classes4.dex */
public final class CashierGuideDialogFragment_MembersInjector implements MembersInjector<CashierGuideDialogFragment> {
    public static void getAuthRequestContext(CashierGuideDialogFragment cashierGuideDialogFragment, GuideContract.Presenter presenter) {
        cashierGuideDialogFragment.presenter = presenter;
    }
}
