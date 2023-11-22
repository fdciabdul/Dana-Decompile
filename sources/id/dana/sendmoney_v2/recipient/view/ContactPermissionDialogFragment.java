package id.dana.sendmoney_v2.recipient.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.databinding.BottomSheetContactPermissionCoordinatorBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB7\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0013R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016"}, d2 = {"Lid/dana/sendmoney_v2/recipient/view/ContactPermissionDialogFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/databinding/BottomSheetContactPermissionCoordinatorBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "Landroid/content/DialogInterface;", "p0", "onDismiss", "(Landroid/content/DialogInterface;)V", "MyBillsEntityDataFactory", "onStart", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "Lkotlin/Function0;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "p1", "p2", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactPermissionDialogFragment extends BaseViewBindingBottomSheetDialogFragment<BottomSheetContactPermissionCoordinatorBinding> {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;
    private Function0<Unit> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Function0<Unit> getAuthRequestContext;

    public ContactPermissionDialogFragment() {
        this(null, null, null, 7, null);
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.48f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    private ContactPermissionDialogFragment(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        Intrinsics.checkNotNullParameter(function03, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = function0;
        this.MyBillsEntityDataFactory = function02;
        this.getAuthRequestContext = function03;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetContactPermissionCoordinatorBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetContactPermissionCoordinatorBinding authRequestContext = BottomSheetContactPermissionCoordinatorBinding.getAuthRequestContext(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public /* synthetic */ ContactPermissionDialogFragment(AnonymousClass1 anonymousClass1, AnonymousClass2 anonymousClass2, AnonymousClass3 anonymousClass3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.view.ContactPermissionDialogFragment.1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : anonymousClass1, (i & 2) != 0 ? new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.view.ContactPermissionDialogFragment.2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : anonymousClass2, (i & 4) != 0 ? new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.view.ContactPermissionDialogFragment.3
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : anonymousClass3);
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((BottomSheetContactPermissionCoordinatorBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.view.ContactPermissionDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContactPermissionDialogFragment.BuiltInFictitiousFunctionClassFactory(ContactPermissionDialogFragment.this);
                }
            });
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                ((BottomSheetContactPermissionCoordinatorBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.view.ContactPermissionDialogFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ContactPermissionDialogFragment.MyBillsEntityDataFactory(ContactPermissionDialogFragment.this);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
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
            getDialog();
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext != null) {
                getAuthRequestContext.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(getAuthRequestContext, this));
            }
            MyBillsEntityDataFactory(dialog);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onDismiss(p0);
        this.getAuthRequestContext.invoke();
    }

    public final void MyBillsEntityDataFactory(FragmentManager p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.show(p0, "ContactPermissionDialogFragment");
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ContactPermissionDialogFragment contactPermissionDialogFragment) {
        Intrinsics.checkNotNullParameter(contactPermissionDialogFragment, "");
        contactPermissionDialogFragment.MyBillsEntityDataFactory.invoke();
        contactPermissionDialogFragment.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ContactPermissionDialogFragment contactPermissionDialogFragment) {
        Intrinsics.checkNotNullParameter(contactPermissionDialogFragment, "");
        contactPermissionDialogFragment.BuiltInFictitiousFunctionClassFactory.invoke();
        contactPermissionDialogFragment.dismissAllowingStateLoss();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetContactPermissionCoordinatorBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
