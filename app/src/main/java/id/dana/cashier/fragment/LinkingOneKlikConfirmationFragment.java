package id.dana.cashier.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.danah5.DanaH5;
import id.dana.utils.danah5.DanaH5Listener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0012\u0012\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\nJ!\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u0016X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/cashier/fragment/LinkingOneKlikConfirmationFragment;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onShow", "Landroid/view/View;", "p0", "Landroid/os/Bundle;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lkotlin/Function0;", "scheduleImpl", "Lkotlin/jvm/functions/Function0;", "MyBillsEntityDataFactory", "", "getErrorConfigVersion", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LinkingOneKlikConfirmationFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Function0<Unit> MyBillsEntityDataFactory;

    private View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.0f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.fragment_linking_oneklik_confirmation;
    }

    public LinkingOneKlikConfirmationFragment(Function0<Unit> function0, String str) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.MyBillsEntityDataFactory = function0;
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: id.dana.cashier.fragment.LinkingOneKlikConfirmationFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    LinkingOneKlikConfirmationFragment.MyBillsEntityDataFactory(LinkingOneKlikConfirmationFragment.this);
                }
            });
        }
        ((DanaButtonSecondaryView) getAuthRequestContext(R.id.res_0x7f0a016e_summaryvoucherview_externalsyntheticlambda1)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.LinkingOneKlikConfirmationFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LinkingOneKlikConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(LinkingOneKlikConfirmationFragment.this);
            }
        });
        ((DanaButtonPrimaryView) getAuthRequestContext(R.id.btnOneKlikConfirm)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.LinkingOneKlikConfirmationFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LinkingOneKlikConfirmationFragment.BuiltInFictitiousFunctionClassFactory(LinkingOneKlikConfirmationFragment.this);
            }
        });
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: id.dana.cashier.fragment.LinkingOneKlikConfirmationFragment$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    LinkingOneKlikConfirmationFragment.PlaceComponentResult(LinkingOneKlikConfirmationFragment.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(9999, 3);
        this.bottomSheetBehavior.setSkipCollapsed(true);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/cashier/fragment/LinkingOneKlikConfirmationFragment$Companion;", "", "Lkotlin/Function0;", "", "p0", "", "p1", "Lid/dana/cashier/fragment/LinkingOneKlikConfirmationFragment;", "getAuthRequestContext", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;)Lid/dana/cashier/fragment/LinkingOneKlikConfirmationFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static LinkingOneKlikConfirmationFragment getAuthRequestContext(Function0<Unit> p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return new LinkingOneKlikConfirmationFragment(p0, p1);
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(LinkingOneKlikConfirmationFragment linkingOneKlikConfirmationFragment) {
        Intrinsics.checkNotNullParameter(linkingOneKlikConfirmationFragment, "");
        linkingOneKlikConfirmationFragment.MyBillsEntityDataFactory.invoke();
    }

    public static /* synthetic */ void PlaceComponentResult(LinkingOneKlikConfirmationFragment linkingOneKlikConfirmationFragment) {
        Intrinsics.checkNotNullParameter(linkingOneKlikConfirmationFragment, "");
        BottomSheetBehavior.from((FrameLayout) linkingOneKlikConfirmationFragment.getAuthRequestContext(R.id.flLinkingOneklik)).setState(3);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(LinkingOneKlikConfirmationFragment linkingOneKlikConfirmationFragment) {
        Intrinsics.checkNotNullParameter(linkingOneKlikConfirmationFragment, "");
        DanaH5.startContainerFullUrl(linkingOneKlikConfirmationFragment.BuiltInFictitiousFunctionClassFactory, new DanaH5Listener() { // from class: id.dana.cashier.fragment.LinkingOneKlikConfirmationFragment$init$3$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
            }

            /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Bundle, kotlin.jvm.internal.DefaultConstructorMarker] */
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                ?? r1 = 0;
                EventBus.getDefault().post(new HomeTabActivity.FinishSubActivitiesMessageEvent(r1, 1, r1));
                EventBus.getDefault().post(new HomeTabActivity.OnBackToHomepageMessageEvent(null));
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(LinkingOneKlikConfirmationFragment linkingOneKlikConfirmationFragment) {
        Intrinsics.checkNotNullParameter(linkingOneKlikConfirmationFragment, "");
        Dialog dialog = linkingOneKlikConfirmationFragment.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        View findViewById = ((CoordinatorLayout) getAuthRequestContext(R.id.clLinkingOneklikCoordinator)).findViewById(R.id.f3779flLinkingOneklik);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        return (FrameLayout) findViewById;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
