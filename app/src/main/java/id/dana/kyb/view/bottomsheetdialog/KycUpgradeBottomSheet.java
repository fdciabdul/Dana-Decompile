package id.dana.kyb.view.bottomsheetdialog;

import android.app.Dialog;
import android.view.View;
import android.widget.FrameLayout;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.kyb.view.MyBusinessFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/kyb/view/bottomsheetdialog/KycUpgradeBottomSheet;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onShow", "Lid/dana/component/buttoncomponent/DanaButtonGhostView;", "lookAheadTest", "Lid/dana/component/buttoncomponent/DanaButtonGhostView;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "moveToNextValue", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "MyBillsEntityDataFactory", "Landroid/widget/FrameLayout;", "scheduleImpl", "Landroid/widget/FrameLayout;", "getAuthRequestContext", "Lid/dana/kyb/view/MyBusinessFragment$KycUpgradeListener;", "getErrorConfigVersion", "Lid/dana/kyb/view/MyBusinessFragment$KycUpgradeListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KycUpgradeBottomSheet extends BaseBottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NetworkUserEntityData$$ExternalSyntheticLambda0 = Reflection.getOrCreateKotlinClass(KycUpgradeBottomSheet.class).getSimpleName();
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public MyBusinessFragment.KycUpgradeListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private DanaButtonGhostView BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private DanaButtonPrimaryView MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private FrameLayout getAuthRequestContext;

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.fragment_kyc_upgrade;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        Dialog dialog = getDialog();
        this.getAuthRequestContext = dialog != null ? (FrameLayout) dialog.findViewById(R.id.fl_container) : null;
        Dialog dialog2 = getDialog();
        this.BuiltInFictitiousFunctionClassFactory = dialog2 != null ? (DanaButtonGhostView) dialog2.findViewById(R.id.btn_close) : null;
        Dialog dialog3 = getDialog();
        this.MyBillsEntityDataFactory = dialog3 != null ? (DanaButtonPrimaryView) dialog3.findViewById(R.id.btn_upgrade) : null;
        DanaButtonGhostView danaButtonGhostView = this.BuiltInFictitiousFunctionClassFactory;
        if (danaButtonGhostView != null) {
            danaButtonGhostView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.bottomsheetdialog.KycUpgradeBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    KycUpgradeBottomSheet.MyBillsEntityDataFactory(KycUpgradeBottomSheet.this);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView = this.MyBillsEntityDataFactory;
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.bottomsheetdialog.KycUpgradeBottomSheet$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    KycUpgradeBottomSheet.PlaceComponentResult(KycUpgradeBottomSheet.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kyb/view/bottomsheetdialog/KycUpgradeBottomSheet$Companion;", "", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        public static String MyBillsEntityDataFactory() {
            return KycUpgradeBottomSheet.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(KycUpgradeBottomSheet kycUpgradeBottomSheet) {
        Intrinsics.checkNotNullParameter(kycUpgradeBottomSheet, "");
        kycUpgradeBottomSheet.dismiss();
    }

    public static /* synthetic */ void PlaceComponentResult(KycUpgradeBottomSheet kycUpgradeBottomSheet) {
        Intrinsics.checkNotNullParameter(kycUpgradeBottomSheet, "");
        MyBusinessFragment.KycUpgradeListener kycUpgradeListener = kycUpgradeBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2;
        if (kycUpgradeListener != null) {
            kycUpgradeListener.BuiltInFictitiousFunctionClassFactory();
        }
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
