package id.dana.pushverify.view.bottomsheet;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.databinding.BottomSheetEnableNotificationBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012"}, d2 = {"Lid/dana/pushverify/view/bottomsheet/EnableNotificationBottomSheetDialogFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/databinding/BottomSheetEnableNotificationBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "onStart", "Landroidx/fragment/app/FragmentManager;", "p0", "(Landroidx/fragment/app/FragmentManager;)V", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "PlaceComponentResult", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnableNotificationBottomSheetDialogFragment extends BaseViewBindingBottomSheetDialogFragment<BottomSheetEnableNotificationBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Function0<Unit> MyBillsEntityDataFactory = new Function0<Unit>() { // from class: id.dana.pushverify.view.bottomsheet.EnableNotificationBottomSheetDialogFragment$onPositiveButtonClick$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    };

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function0<Unit> getAuthRequestContext = new Function0<Unit>() { // from class: id.dana.pushverify.view.bottomsheet.EnableNotificationBottomSheetDialogFragment$onNegativeButtonClick$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    };

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.48f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetEnableNotificationBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetEnableNotificationBinding authRequestContext = BottomSheetEnableNotificationBinding.getAuthRequestContext(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            BottomSheetEnableNotificationBinding bottomSheetEnableNotificationBinding = (BottomSheetEnableNotificationBinding) vb;
            bottomSheetEnableNotificationBinding.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pushverify.view.bottomsheet.EnableNotificationBottomSheetDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnableNotificationBottomSheetDialogFragment.MyBillsEntityDataFactory(EnableNotificationBottomSheetDialogFragment.this);
                }
            });
            bottomSheetEnableNotificationBinding.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pushverify.view.bottomsheet.EnableNotificationBottomSheetDialogFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnableNotificationBottomSheetDialogFragment.getAuthRequestContext(EnableNotificationBottomSheetDialogFragment.this);
                }
            });
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.setCanceledOnTouchOutside(false);
                return;
            }
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
        super.show(p0, "EnableNotificationBottomSheetDialogFragment");
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/pushverify/view/bottomsheet/EnableNotificationBottomSheetDialogFragment$Companion;", "", "Lkotlin/Function0;", "", "p0", "p1", "Lid/dana/pushverify/view/bottomsheet/EnableNotificationBottomSheetDialogFragment;", "BuiltInFictitiousFunctionClassFactory", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lid/dana/pushverify/view/bottomsheet/EnableNotificationBottomSheetDialogFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static EnableNotificationBottomSheetDialogFragment BuiltInFictitiousFunctionClassFactory(Function0<Unit> p0, Function0<Unit> p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            EnableNotificationBottomSheetDialogFragment enableNotificationBottomSheetDialogFragment = new EnableNotificationBottomSheetDialogFragment();
            enableNotificationBottomSheetDialogFragment.MyBillsEntityDataFactory = p0;
            enableNotificationBottomSheetDialogFragment.getAuthRequestContext = p1;
            return enableNotificationBottomSheetDialogFragment;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(EnableNotificationBottomSheetDialogFragment enableNotificationBottomSheetDialogFragment) {
        Intrinsics.checkNotNullParameter(enableNotificationBottomSheetDialogFragment, "");
        enableNotificationBottomSheetDialogFragment.getAuthRequestContext.invoke();
        enableNotificationBottomSheetDialogFragment.dismiss();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(EnableNotificationBottomSheetDialogFragment enableNotificationBottomSheetDialogFragment) {
        Intrinsics.checkNotNullParameter(enableNotificationBottomSheetDialogFragment, "");
        enableNotificationBottomSheetDialogFragment.MyBillsEntityDataFactory.invoke();
        enableNotificationBottomSheetDialogFragment.dismiss();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetEnableNotificationBinding) vb).MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }
}
