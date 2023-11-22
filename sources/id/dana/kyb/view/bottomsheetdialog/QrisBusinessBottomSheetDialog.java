package id.dana.kyb.view.bottomsheetdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.kyb.constant.KybDataSource;
import id.dana.kyb.domain.model.KybCompressQrConfig;
import id.dana.kyb.model.KybQrisModel;
import id.dana.kyb.tracker.KybRenderQrTracker;
import id.dana.kyb.view.richview.QrisBusinessView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\"\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\nR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Lid/dana/kyb/view/bottomsheetdialog/QrisBusinessBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onDestroy", "Landroid/content/DialogInterface;", "p0", "onDismiss", "(Landroid/content/DialogInterface;)V", "onShow", "onStart", "Landroid/widget/FrameLayout;", "moveToNextValue", "Landroid/widget/FrameLayout;", "getAuthRequestContext", "Landroid/widget/ImageButton;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/widget/ImageButton;", "MyBillsEntityDataFactory", "Lkotlin/Function0;", "lookAheadTest", "Lkotlin/jvm/functions/Function0;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/view/richview/QrisBusinessView;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/kyb/view/richview/QrisBusinessView;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QrisBusinessBottomSheetDialog extends BaseBottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String getErrorConfigVersion = Reflection.getOrCreateKotlinClass(QrisBusinessBottomSheetDialog.class).getSimpleName();
    private static KybQrisModel scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private ImageButton MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private QrisBusinessView KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private FrameLayout getAuthRequestContext;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Function0<Unit> BuiltInFictitiousFunctionClassFactory = new Function0<Unit>() { // from class: id.dana.kyb.view.bottomsheetdialog.QrisBusinessBottomSheetDialog$onDismissAction$1
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
        return R.layout.fragment_qris_business_bottom_sheet_dialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        initMatchParentDialog(getDialog());
        initTransparentDialogDim(getDialog());
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        KybCompressQrConfig kybCompressQrConfig;
        QrisBusinessView qrisBusinessView;
        super.init();
        Dialog dialog = getDialog();
        this.getAuthRequestContext = dialog != null ? (FrameLayout) dialog.findViewById(R.id.fl_container) : null;
        Dialog dialog2 = getDialog();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dialog2 != null ? (QrisBusinessView) dialog2.findViewById(R.id.qbv_poster) : null;
        Dialog dialog3 = getDialog();
        ImageButton imageButton = dialog3 != null ? (ImageButton) dialog3.findViewById(R.id.ib_qris_business_close) : null;
        this.MyBillsEntityDataFactory = imageButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.bottomsheetdialog.QrisBusinessBottomSheetDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QrisBusinessBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(QrisBusinessBottomSheetDialog.this);
                }
            });
        }
        QrisBusinessView qrisBusinessView2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (qrisBusinessView2 != null) {
            qrisBusinessView2.setData(this, scheduleImpl);
        }
        scheduleImpl = null;
        Bundle arguments = getArguments();
        if (arguments != null && (kybCompressQrConfig = (KybCompressQrConfig) arguments.getParcelable("kybCompressQrConfigKey")) != null && (qrisBusinessView = this.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            Intrinsics.checkNotNullExpressionValue(kybCompressQrConfig, "");
            qrisBusinessView.setCompressQrConfig(kybCompressQrConfig);
        }
        KybRenderQrTracker.BuiltInFictitiousFunctionClassFactory();
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_QRIS_OPEN;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.KybProperties.LOAD_TIME, KybRenderQrTracker.getAuthRequestContext()).MyBillsEntityDataFactory(TrackerKey.KybProperties.DATA_SOURCE, KybRenderQrTracker.KClassImpl$Data$declaredNonStaticMembers$2() ? KybDataSource.CACHE : KybDataSource.RENDER);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
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
        this.BuiltInFictitiousFunctionClassFactory.invoke();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        scheduleImpl = null;
        QrisBusinessView qrisBusinessView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (qrisBusinessView != null) {
            qrisBusinessView.dispose();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\f\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/kyb/view/bottomsheetdialog/QrisBusinessBottomSheetDialog$Companion;", "", "Lid/dana/kyb/model/KybQrisModel;", "p0", "Lid/dana/kyb/domain/model/KybCompressQrConfig;", "p1", "Lid/dana/kyb/view/bottomsheetdialog/QrisBusinessBottomSheetDialog;", "getAuthRequestContext", "(Lid/dana/kyb/model/KybQrisModel;Lid/dana/kyb/domain/model/KybCompressQrConfig;)Lid/dana/kyb/view/bottomsheetdialog/QrisBusinessBottomSheetDialog;", "", "getErrorConfigVersion", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "scheduleImpl", "Lid/dana/kyb/model/KybQrisModel;", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        public static String BuiltInFictitiousFunctionClassFactory() {
            return QrisBusinessBottomSheetDialog.getErrorConfigVersion;
        }

        @JvmStatic
        public static QrisBusinessBottomSheetDialog getAuthRequestContext(KybQrisModel p0, KybCompressQrConfig p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            QrisBusinessBottomSheetDialog qrisBusinessBottomSheetDialog = new QrisBusinessBottomSheetDialog();
            Companion companion = QrisBusinessBottomSheetDialog.INSTANCE;
            QrisBusinessBottomSheetDialog.scheduleImpl = p0;
            KybRenderQrTracker.PlaceComponentResult();
            Bundle bundle = new Bundle();
            bundle.putParcelable("kybCompressQrConfigKey", p1);
            qrisBusinessBottomSheetDialog.setArguments(bundle);
            return qrisBusinessBottomSheetDialog;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(QrisBusinessBottomSheetDialog qrisBusinessBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(qrisBusinessBottomSheetDialog, "");
        qrisBusinessBottomSheetDialog.dismiss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* bridge */ /* synthetic */ View getPlaceComponentResult() {
        return this.getAuthRequestContext;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
