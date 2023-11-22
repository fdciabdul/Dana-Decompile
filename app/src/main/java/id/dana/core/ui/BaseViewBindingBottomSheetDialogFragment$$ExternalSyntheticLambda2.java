package id.dana.core.ui;

import android.view.View;

/* loaded from: classes4.dex */
public final /* synthetic */ class BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ BaseViewBindingBottomSheetDialogFragment PlaceComponentResult;
    public final /* synthetic */ View getAuthRequestContext;

    public /* synthetic */ BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(View view, BaseViewBindingBottomSheetDialogFragment baseViewBindingBottomSheetDialogFragment) {
        this.getAuthRequestContext = view;
        this.PlaceComponentResult = baseViewBindingBottomSheetDialogFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseViewBindingBottomSheetDialogFragment.PlaceComponentResult(this.getAuthRequestContext, this.PlaceComponentResult);
    }
}
