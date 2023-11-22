package id.dana.sendmoney.ui.groupsend.summary.view;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.sendmoney.databinding.BottomSheetInformationBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/view/InformationDialogFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/sendmoney/databinding/BottomSheetInformationBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "onStart", "Landroidx/fragment/app/FragmentManager;", "p0", "(Landroidx/fragment/app/FragmentManager;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InformationDialogFragment extends BaseViewBindingBottomSheetDialogFragment<BottomSheetInformationBinding> {
    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.48f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetInformationBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetInformationBinding KClassImpl$Data$declaredNonStaticMembers$2 = BottomSheetInformationBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((BottomSheetInformationBinding) vb).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.InformationDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InformationDialogFragment.BuiltInFictitiousFunctionClassFactory(InformationDialogFragment.this);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            a_(PlaceComponentResult(dialog));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            View view = getView();
            if (view != null) {
                view.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(view, this));
            }
            MyBillsEntityDataFactory(dialog);
        }
    }

    public final void MyBillsEntityDataFactory(FragmentManager p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.show(p0, "InformationDialogFragment");
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(InformationDialogFragment informationDialogFragment) {
        Intrinsics.checkNotNullParameter(informationDialogFragment, "");
        informationDialogFragment.dismiss();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetInformationBinding) vb).MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
