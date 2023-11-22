package id.dana.kyb.view.bottomsheetdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.extension.view.InputExtKt;
import id.dana.kyb.helper.KybUrlsDataManager;
import id.dana.kyb.view.bottomsheetdialog.WithdrawBalanceFaceAuthActivationBottomSheet;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b'\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000f\u0010\nR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010$"}, d2 = {"Lid/dana/kyb/view/bottomsheetdialog/WithdrawBalanceFaceAuthActivationBottomSheet;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/content/DialogInterface;", "p0", "onDismiss", "(Landroid/content/DialogInterface;)V", "onShow", "Lid/dana/component/buttoncomponent/DanaButtonGhostView;", "lookAheadTest", "Lid/dana/component/buttoncomponent/DanaButtonGhostView;", "MyBillsEntityDataFactory", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "scheduleImpl", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "getAuthRequestContext", "Landroid/widget/FrameLayout;", "initRecordTimeStamp", "Landroid/widget/FrameLayout;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function0;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/jvm/functions/Function0;", "BuiltInFictitiousFunctionClassFactory", "getErrorConfigVersion", "PlaceComponentResult", "Landroid/widget/TextView;", "GetContactSyncConfig", "Landroid/widget/TextView;", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda1", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WithdrawBalanceFaceAuthActivationBottomSheet extends BaseBottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean moveToNextValue;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private TextView moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private TextView lookAheadTest;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private DanaButtonGhostView MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private DanaButtonPrimaryView getAuthRequestContext;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public Function0<Unit> BuiltInFictitiousFunctionClassFactory = new Function0<Unit>() { // from class: id.dana.kyb.view.bottomsheetdialog.WithdrawBalanceFaceAuthActivationBottomSheet$onActivateClickedAction$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    };

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public Function0<Unit> PlaceComponentResult = new Function0<Unit>() { // from class: id.dana.kyb.view.bottomsheetdialog.WithdrawBalanceFaceAuthActivationBottomSheet$onDismissAction$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    };

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.fragment_withdraw_balance_face_auth_activation;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        Dialog dialog = getDialog();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dialog != null ? (FrameLayout) dialog.findViewById(R.id.fl_container) : null;
        Dialog dialog2 = getDialog();
        this.lookAheadTest = dialog2 != null ? (TextView) dialog2.findViewById(R.id.tv_withdraw_face_auth_bs_description) : null;
        Dialog dialog3 = getDialog();
        this.moveToNextValue = dialog3 != null ? (TextView) dialog3.findViewById(R.id.tv_withdraw_face_auth_bs_benefit) : null;
        Dialog dialog4 = getDialog();
        this.MyBillsEntityDataFactory = dialog4 != null ? (DanaButtonGhostView) dialog4.findViewById(R.id.btn_withdraw_face_auth_negative) : null;
        Dialog dialog5 = getDialog();
        this.getAuthRequestContext = dialog5 != null ? (DanaButtonPrimaryView) dialog5.findViewById(R.id.btn_withdraw_face_auth_positive) : null;
        TextView textView = this.moveToNextValue;
        if (textView != null) {
            String string = getString(R.string.withdraw_balance_face_auth_bottom_sheet_clickable);
            Intrinsics.checkNotNullExpressionValue(string, "");
            InputExtKt.getAuthRequestContext(textView, R.color.f22912131099753, string, false, new Function0<Unit>() { // from class: id.dana.kyb.view.bottomsheetdialog.WithdrawBalanceFaceAuthActivationBottomSheet$initDescriptionSpan$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WithdrawBalanceFaceAuthActivationBottomSheet.PlaceComponentResult(WithdrawBalanceFaceAuthActivationBottomSheet.this);
                }
            });
        }
        DanaButtonGhostView danaButtonGhostView = this.MyBillsEntityDataFactory;
        if (danaButtonGhostView != null) {
            danaButtonGhostView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.bottomsheetdialog.WithdrawBalanceFaceAuthActivationBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WithdrawBalanceFaceAuthActivationBottomSheet.BuiltInFictitiousFunctionClassFactory(WithdrawBalanceFaceAuthActivationBottomSheet.this);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView = this.getAuthRequestContext;
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.bottomsheetdialog.WithdrawBalanceFaceAuthActivationBottomSheet$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WithdrawBalanceFaceAuthActivationBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2(WithdrawBalanceFaceAuthActivationBottomSheet.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onDismiss(p0);
        this.PlaceComponentResult.invoke();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/kyb/view/bottomsheetdialog/WithdrawBalanceFaceAuthActivationBottomSheet$Companion;", "", "", "moveToNextValue", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        public static boolean BuiltInFictitiousFunctionClassFactory() {
            return WithdrawBalanceFaceAuthActivationBottomSheet.moveToNextValue;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(WithdrawBalanceFaceAuthActivationBottomSheet withdrawBalanceFaceAuthActivationBottomSheet) {
        Intrinsics.checkNotNullParameter(withdrawBalanceFaceAuthActivationBottomSheet, "");
        withdrawBalanceFaceAuthActivationBottomSheet.BuiltInFictitiousFunctionClassFactory.invoke();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(WithdrawBalanceFaceAuthActivationBottomSheet withdrawBalanceFaceAuthActivationBottomSheet) {
        Intrinsics.checkNotNullParameter(withdrawBalanceFaceAuthActivationBottomSheet, "");
        withdrawBalanceFaceAuthActivationBottomSheet.dismiss();
    }

    public static final /* synthetic */ void PlaceComponentResult(final WithdrawBalanceFaceAuthActivationBottomSheet withdrawBalanceFaceAuthActivationBottomSheet) {
        String authRequestContext = UrlUtil.getAuthRequestContext(DanaUrl.KYC_FACE_VERIFICATION);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(KybUrlsDataManager.PlaceComponentResult(authRequestContext), new DanaH5Listener() { // from class: id.dana.kyb.view.bottomsheetdialog.WithdrawBalanceFaceAuthActivationBottomSheet$openFaceAuthIntro$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                Function0 function0;
                DanaH5Listener.CC.MyBillsEntityDataFactory();
                WithdrawBalanceFaceAuthActivationBottomSheet.Companion companion = WithdrawBalanceFaceAuthActivationBottomSheet.INSTANCE;
                if (WithdrawBalanceFaceAuthActivationBottomSheet.Companion.BuiltInFictitiousFunctionClassFactory()) {
                    WithdrawBalanceFaceAuthActivationBottomSheet.Companion companion2 = WithdrawBalanceFaceAuthActivationBottomSheet.INSTANCE;
                    WithdrawBalanceFaceAuthActivationBottomSheet.moveToNextValue = false;
                    function0 = WithdrawBalanceFaceAuthActivationBottomSheet.this.BuiltInFictitiousFunctionClassFactory;
                    function0.invoke();
                }
            }
        });
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* bridge */ /* synthetic */ View getPlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
