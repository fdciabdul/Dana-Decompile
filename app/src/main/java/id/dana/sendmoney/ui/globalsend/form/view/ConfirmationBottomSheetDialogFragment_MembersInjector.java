package id.dana.sendmoney.ui.globalsend.form.view;

import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.sendmoney.util.GlobalSendTrackerHelper;

/* loaded from: classes9.dex */
public final class ConfirmationBottomSheetDialogFragment_MembersInjector implements MembersInjector<ConfirmationBottomSheetDialogFragment> {
    public static void PlaceComponentResult(ConfirmationBottomSheetDialogFragment confirmationBottomSheetDialogFragment, ViewModelFactory viewModelFactory) {
        confirmationBottomSheetDialogFragment.viewModelFactory = viewModelFactory;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ConfirmationBottomSheetDialogFragment confirmationBottomSheetDialogFragment, GlobalSendTrackerHelper globalSendTrackerHelper) {
        confirmationBottomSheetDialogFragment.globalSendTrackerHelper = globalSendTrackerHelper;
    }
}
