package id.dana.mybills.ui.v2.addnewbills.services;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.view.NavController;
import androidx.view.NavDirections;
import androidx.view.NavOptions;
import androidx.viewbinding.ViewBinding;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.core.ui.glide.GlideApp;
import id.dana.mybills.R;
import id.dana.mybills.databinding.ViewHeaderDetailBillsBinding;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.mybills.ui.customview.MyBillsToolbarView;
import id.dana.mybills.ui.model.MyBillsServiceModel;
import id.dana.mybills.ui.model.MyBillsServiceModelKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 #*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001#B\u0007¢\u0006\u0004\b\"\u0010\u0015J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH$¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH$¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H$¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0004¢\u0006\u0004\b\u0014\u0010\u0018J-\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bH\u0004¢\u0006\u0004\b\u0014\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u001e\u0010\u0015J\u000f\u0010\u001f\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001f\u0010\u0015J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020 H\u0004¢\u0006\u0004\b\u0014\u0010!J\u0017\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0004¢\u0006\u0004\b\u0005\u0010\u0018"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/services/BaseMyBillsBottomSheet;", "Landroidx/viewbinding/ViewBinding;", "VB", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroidx/constraintlayout/widget/ConstraintLayout;", "scheduleImpl", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "Lid/dana/mybills/databinding/ViewHeaderDetailBillsBinding;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Lid/dana/mybills/databinding/ViewHeaderDetailBillsBinding;", "Landroidx/core/widget/NestedScrollView;", "moveToNextValue", "()Landroidx/core/widget/NestedScrollView;", "Lid/dana/mybills/ui/customview/MyBillsToolbarView;", "GetContactSyncConfig", "()Lid/dana/mybills/ui/customview/MyBillsToolbarView;", "", "getAuthRequestContext", "()V", "", "p0", "(Ljava/lang/String;)V", "", "p1", "Lkotlin/Function0;", "p2", "(Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "MyBillsEntityDataFactory", "onStart", "Landroidx/navigation/NavDirections;", "(Ljava/lang/String;Landroidx/navigation/NavDirections;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseMyBillsBottomSheet<VB extends ViewBinding> extends BaseViewBindingBottomSheetDialogFragment<VB> {
    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.5f;
    }

    protected abstract MyBillsToolbarView GetContactSyncConfig();

    protected abstract ViewHeaderDetailBillsBinding NetworkUserEntityData$$ExternalSyntheticLambda0();

    protected abstract NestedScrollView moveToNextValue();

    protected abstract ConstraintLayout scheduleImpl();

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            a_(PlaceComponentResult(dialog));
            BottomSheetBehavior<View> o_ = o_();
            if (o_ != null) {
                o_.setSkipCollapsed(true);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext != null) {
                getAuthRequestContext.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(getAuthRequestContext, this));
            }
            MyBillsEntityDataFactory(dialog);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != null) {
            vb.KClassImpl$Data$declaredNonStaticMembers$2().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    BaseMyBillsBottomSheet.MyBillsEntityDataFactory(BaseMyBillsBottomSheet.this);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(String p0, int p1, Function0<Unit> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        MyBillsToolbarView GetContactSyncConfig = GetContactSyncConfig();
        GetContactSyncConfig.setToolbarAction(p1, p2);
        GetContactSyncConfig.setToolbarTitle(p0);
        GetContactSyncConfig.setToolbarBackgroundColor(R.color.GetContactSyncConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Bundle arguments = getArguments();
        if (arguments != null) {
            MyBillsServiceModel myBillsServiceModel = null;
            if (!arguments.containsKey(p0)) {
                arguments = null;
            }
            if (arguments != null) {
                if (Build.VERSION.SDK_INT >= 33) {
                    myBillsServiceModel = (MyBillsServiceModel) arguments.getParcelable(p0, MyBillsServiceModel.class);
                } else {
                    Parcelable parcelable = arguments.getParcelable(p0);
                    if (parcelable instanceof MyBillsServiceModel) {
                        myBillsServiceModel = (MyBillsServiceModel) parcelable;
                    }
                }
                if (myBillsServiceModel != null) {
                    ViewHeaderDetailBillsBinding NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
                    TextView textView = NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "");
                    textView.setText(MyBillsServiceModelKt.getLocalizedName(myBillsServiceModel, requireContext));
                    GlideApp.getAuthRequestContext(requireContext()).PlaceComponentResult(myBillsServiceModel.getIcon()).MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext);
                }
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
        CustomToast.MyBillsEntityDataFactory(requireActivity, R.drawable.GetContactSyncConfig, R.drawable.getAuthRequestContext, p0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(String p0, NavDirections p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Bundle bundle = new Bundle();
        bundle.putBoolean("isSaveBill", true);
        bundle.putBoolean("isAutoDeduction", Intrinsics.areEqual(p0, RecurringType.AUTO_DEDUCTION));
        BaseMyBillsBottomSheet<VB> baseMyBillsBottomSheet = this;
        FragmentKt.KClassImpl$Data$declaredNonStaticMembers$2(baseMyBillsBottomSheet, RecordError.ERROR_INITIALIZE_NO_APP_ID, bundle);
        NavController authRequestContext = androidx.view.fragment.FragmentKt.getAuthRequestContext(baseMyBillsBottomSheet);
        Intrinsics.checkNotNullParameter(p1, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(p1.getKClassImpl$Data$declaredNonStaticMembers$2(), p1.getKClassImpl$Data$declaredNonStaticMembers$2(), (NavOptions) null);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(BaseMyBillsBottomSheet baseMyBillsBottomSheet) {
        Intrinsics.checkNotNullParameter(baseMyBillsBottomSheet, "");
        Rect rect = new Rect();
        baseMyBillsBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2().getGlobalVisibleRect(rect);
        if (rect.bottom >= baseMyBillsBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2().getResources().getDisplayMetrics().heightPixels) {
            NestedScrollView moveToNextValue = baseMyBillsBottomSheet.moveToNextValue();
            ViewGroup.LayoutParams layoutParams = moveToNextValue.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            RelativeLayout.LayoutParams layoutParams3 = layoutParams2;
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            layoutParams3.addRule(2, baseMyBillsBottomSheet.scheduleImpl().getId());
            moveToNextValue.setLayoutParams(layoutParams2);
            ConstraintLayout scheduleImpl = baseMyBillsBottomSheet.scheduleImpl();
            ViewGroup.LayoutParams layoutParams4 = scheduleImpl.getLayoutParams();
            if (layoutParams4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) layoutParams4;
            RelativeLayout.LayoutParams layoutParams6 = layoutParams5;
            layoutParams6.width = -1;
            layoutParams6.height = -2;
            layoutParams6.removeRule(3);
            layoutParams6.addRule(12);
            scheduleImpl.setLayoutParams(layoutParams5);
            return;
        }
        NestedScrollView moveToNextValue2 = baseMyBillsBottomSheet.moveToNextValue();
        ViewGroup.LayoutParams layoutParams7 = moveToNextValue2.getLayoutParams();
        if (layoutParams7 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
        RelativeLayout.LayoutParams layoutParams9 = layoutParams8;
        layoutParams9.width = -1;
        layoutParams9.height = -2;
        layoutParams9.removeRule(2);
        moveToNextValue2.setLayoutParams(layoutParams8);
        ConstraintLayout scheduleImpl2 = baseMyBillsBottomSheet.scheduleImpl();
        ViewGroup.LayoutParams layoutParams10 = scheduleImpl2.getLayoutParams();
        if (layoutParams10 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) layoutParams10;
        RelativeLayout.LayoutParams layoutParams12 = layoutParams11;
        layoutParams12.width = -1;
        layoutParams12.height = -2;
        layoutParams12.removeRule(12);
        layoutParams12.addRule(3, baseMyBillsBottomSheet.moveToNextValue().getId());
        scheduleImpl2.setLayoutParams(layoutParams11);
    }
}
