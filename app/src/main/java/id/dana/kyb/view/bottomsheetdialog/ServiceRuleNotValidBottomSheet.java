package id.dana.kyb.view.bottomsheetdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.databinding.FragmentServiceRuleNotValidBottomSheetBinding;
import id.dana.kyb.model.KybServiceMessageModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0007R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/kyb/view/bottomsheetdialog/ServiceRuleNotValidBottomSheet;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", IAPSyncCommand.COMMAND_INIT, "()V", "", "isFullDialogHeightRequired", "()Z", "onShow", "onStart", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "Lid/dana/databinding/FragmentServiceRuleNotValidBottomSheetBinding;", "getBindingInflater", "()Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceRuleNotValidBottomSheet extends BaseBottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String lookAheadTest = Reflection.getOrCreateKotlinClass(ServiceRuleNotValidBottomSheet.class).getSimpleName();
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final boolean isFullDialogHeightRequired() {
        return false;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    @JvmName(name = "getBindingInflater")
    public final Function1<LayoutInflater, FragmentServiceRuleNotValidBottomSheetBinding> getBindingInflater() {
        return new Function1<LayoutInflater, FragmentServiceRuleNotValidBottomSheetBinding>() { // from class: id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet$bindingInflater$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FragmentServiceRuleNotValidBottomSheetBinding invoke(LayoutInflater layoutInflater) {
                Intrinsics.checkNotNullParameter(layoutInflater, "");
                FragmentServiceRuleNotValidBottomSheetBinding MyBillsEntityDataFactory = FragmentServiceRuleNotValidBottomSheetBinding.MyBillsEntityDataFactory(ServiceRuleNotValidBottomSheet.this.getLayoutInflater());
                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                return MyBillsEntityDataFactory;
            }
        };
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        initMatchParentDialog(getDialog());
        initTransparentDialogDim(getDialog());
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
        Dialog dialog = getDialog();
        if (dialog == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
        BottomSheetBehavior<FrameLayout> behavior = ((BottomSheetDialog) dialog).getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "");
        behavior.setState(3);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        DanaButtonPrimaryView danaButtonPrimaryView;
        Bundle arguments;
        Parcelable parcelable;
        super.init();
        Context context = getContext();
        if (context != null && (arguments = getArguments()) != null) {
            KybServiceMessageModel.Companion companion = KybServiceMessageModel.INSTANCE;
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) arguments.getParcelable("kybServiceRuleMessageModel", KybServiceMessageModel.class);
            } else {
                Parcelable parcelable2 = arguments.getParcelable("kybServiceRuleMessageModel");
                if (!(parcelable2 instanceof KybServiceMessageModel)) {
                    parcelable2 = null;
                }
                parcelable = (KybServiceMessageModel) parcelable2;
            }
            KybServiceMessageModel PlaceComponentResult = KybServiceMessageModel.Companion.PlaceComponentResult((KybServiceMessageModel) parcelable, context);
            ViewBinding viewBinding = getViewBinding();
            FragmentServiceRuleNotValidBottomSheetBinding fragmentServiceRuleNotValidBottomSheetBinding = viewBinding instanceof FragmentServiceRuleNotValidBottomSheetBinding ? (FragmentServiceRuleNotValidBottomSheetBinding) viewBinding : null;
            if (fragmentServiceRuleNotValidBottomSheetBinding != null) {
                fragmentServiceRuleNotValidBottomSheetBinding.scheduleImpl.setText(PlaceComponentResult.PlaceComponentResult);
                fragmentServiceRuleNotValidBottomSheetBinding.getAuthRequestContext.setText(PlaceComponentResult.MyBillsEntityDataFactory);
                Glide.KClassImpl$Data$declaredNonStaticMembers$2(context).getAuthRequestContext(PlaceComponentResult.getAuthRequestContext).MyBillsEntityDataFactory((int) R.drawable.ic_default_invalid_service_rule).BuiltInFictitiousFunctionClassFactory(R.drawable.ic_default_invalid_service_rule).MyBillsEntityDataFactory((ImageView) fragmentServiceRuleNotValidBottomSheetBinding.MyBillsEntityDataFactory);
            }
        }
        ViewBinding viewBinding2 = getViewBinding();
        FragmentServiceRuleNotValidBottomSheetBinding fragmentServiceRuleNotValidBottomSheetBinding2 = viewBinding2 instanceof FragmentServiceRuleNotValidBottomSheetBinding ? (FragmentServiceRuleNotValidBottomSheetBinding) viewBinding2 : null;
        if (fragmentServiceRuleNotValidBottomSheetBinding2 == null || (danaButtonPrimaryView = fragmentServiceRuleNotValidBottomSheetBinding2.PlaceComponentResult) == null) {
            return;
        }
        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.bottomsheetdialog.ServiceRuleNotValidBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ServiceRuleNotValidBottomSheet.BuiltInFictitiousFunctionClassFactory(ServiceRuleNotValidBottomSheet.this);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0005\u0010\n"}, d2 = {"Lid/dana/kyb/view/bottomsheetdialog/ServiceRuleNotValidBottomSheet$Companion;", "", "Lid/dana/kyb/model/KybServiceMessageModel;", "p0", "Lid/dana/kyb/view/bottomsheetdialog/ServiceRuleNotValidBottomSheet;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/kyb/model/KybServiceMessageModel;)Lid/dana/kyb/view/bottomsheetdialog/ServiceRuleNotValidBottomSheet;", "", "lookAheadTest", "Ljava/lang/String;", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static ServiceRuleNotValidBottomSheet KClassImpl$Data$declaredNonStaticMembers$2(KybServiceMessageModel p0) {
            ServiceRuleNotValidBottomSheet serviceRuleNotValidBottomSheet = new ServiceRuleNotValidBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putParcelable("kybServiceRuleMessageModel", p0);
            serviceRuleNotValidBottomSheet.setArguments(bundle);
            return serviceRuleNotValidBottomSheet;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ServiceRuleNotValidBottomSheet serviceRuleNotValidBottomSheet) {
        Intrinsics.checkNotNullParameter(serviceRuleNotValidBottomSheet, "");
        serviceRuleNotValidBottomSheet.dismiss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final /* synthetic */ ViewBinding getBinding() {
        ViewBinding viewBinding = getViewBinding();
        return viewBinding instanceof FragmentServiceRuleNotValidBottomSheetBinding ? (FragmentServiceRuleNotValidBottomSheetBinding) viewBinding : null;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        ViewBinding viewBinding = getViewBinding();
        FragmentServiceRuleNotValidBottomSheetBinding fragmentServiceRuleNotValidBottomSheetBinding = viewBinding instanceof FragmentServiceRuleNotValidBottomSheetBinding ? (FragmentServiceRuleNotValidBottomSheetBinding) viewBinding : null;
        return fragmentServiceRuleNotValidBottomSheetBinding != null ? fragmentServiceRuleNotValidBottomSheetBinding.BuiltInFictitiousFunctionClassFactory : null;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
