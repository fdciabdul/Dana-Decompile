package id.dana.savings.withdrawal;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.savings.WithdrawSavingPresenter;

/* loaded from: classes5.dex */
public final class WithdrawalSavingBottomSheetDialog_MembersInjector implements MembersInjector<WithdrawalSavingBottomSheetDialog> {
    public static void BuiltInFictitiousFunctionClassFactory(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog, WithdrawSavingPresenter withdrawSavingPresenter) {
        withdrawalSavingBottomSheetDialog.presenter = withdrawSavingPresenter;
    }

    public static void getAuthRequestContext(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog, DynamicUrlWrapper dynamicUrlWrapper) {
        withdrawalSavingBottomSheetDialog.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}
