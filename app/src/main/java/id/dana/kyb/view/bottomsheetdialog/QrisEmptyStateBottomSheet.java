package id.dana.kyb.view.bottomsheetdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\"\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000f\u0010\nR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001e"}, d2 = {"Lid/dana/kyb/view/bottomsheetdialog/QrisEmptyStateBottomSheet;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/content/DialogInterface;", "p0", "onDismiss", "(Landroid/content/DialogInterface;)V", "onShow", "Lid/dana/component/buttoncomponent/DanaButtonGhostView;", "scheduleImpl", "Lid/dana/component/buttoncomponent/DanaButtonGhostView;", "PlaceComponentResult", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "getErrorConfigVersion", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "BuiltInFictitiousFunctionClassFactory", "Landroid/widget/FrameLayout;", "moveToNextValue", "Landroid/widget/FrameLayout;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function0;", "lookAheadTest", "Lkotlin/jvm/functions/Function0;", "getAuthRequestContext", "GetContactSyncConfig", "MyBillsEntityDataFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QrisEmptyStateBottomSheet extends BaseBottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NetworkUserEntityData$$ExternalSyntheticLambda0 = Reflection.getOrCreateKotlinClass(QrisEmptyStateBottomSheet.class).getSimpleName();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public Function0<Unit> getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private DanaButtonGhostView PlaceComponentResult;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private Function0<Unit> MyBillsEntityDataFactory = new Function0<Unit>() { // from class: id.dana.kyb.view.bottomsheetdialog.QrisEmptyStateBottomSheet$onDismissAction$1
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
        return R.layout.fragment_qris_empty_state;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        Dialog dialog = getDialog();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dialog != null ? (FrameLayout) dialog.findViewById(R.id.fl_container) : null;
        Dialog dialog2 = getDialog();
        this.PlaceComponentResult = dialog2 != null ? (DanaButtonGhostView) dialog2.findViewById(R.id.btn_close) : null;
        Dialog dialog3 = getDialog();
        this.BuiltInFictitiousFunctionClassFactory = dialog3 != null ? (DanaButtonPrimaryView) dialog3.findViewById(R.id.btn_request_payment) : null;
        DanaButtonGhostView danaButtonGhostView = this.PlaceComponentResult;
        if (danaButtonGhostView != null) {
            danaButtonGhostView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.bottomsheetdialog.QrisEmptyStateBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QrisEmptyStateBottomSheet.PlaceComponentResult(QrisEmptyStateBottomSheet.this);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView = this.BuiltInFictitiousFunctionClassFactory;
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.bottomsheetdialog.QrisEmptyStateBottomSheet$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QrisEmptyStateBottomSheet.BuiltInFictitiousFunctionClassFactory(QrisEmptyStateBottomSheet.this);
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
        this.MyBillsEntityDataFactory.invoke();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kyb/view/bottomsheetdialog/QrisEmptyStateBottomSheet$Companion;", "", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "PlaceComponentResult", "()Ljava/lang/String;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "PlaceComponentResult")
        public static String PlaceComponentResult() {
            return QrisEmptyStateBottomSheet.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(QrisEmptyStateBottomSheet qrisEmptyStateBottomSheet) {
        Intrinsics.checkNotNullParameter(qrisEmptyStateBottomSheet, "");
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(qrisEmptyStateBottomSheet.getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_PAYMENT_LINK_CLICK;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
        Function0<Unit> function0 = qrisEmptyStateBottomSheet.getAuthRequestContext;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(QrisEmptyStateBottomSheet qrisEmptyStateBottomSheet) {
        Intrinsics.checkNotNullParameter(qrisEmptyStateBottomSheet, "");
        qrisEmptyStateBottomSheet.dismiss();
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
