package id.dana.kyb.view.bottomsheetdialog;

import android.app.Dialog;
import android.view.View;
import android.widget.FrameLayout;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/kyb/view/bottomsheetdialog/KycInProgressBottomSheet;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onShow", "Lid/dana/component/buttoncomponent/DanaButtonSecondaryView;", "moveToNextValue", "Lid/dana/component/buttoncomponent/DanaButtonSecondaryView;", "BuiltInFictitiousFunctionClassFactory", "Landroid/widget/FrameLayout;", "lookAheadTest", "Landroid/widget/FrameLayout;", "MyBillsEntityDataFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KycInProgressBottomSheet extends BaseBottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NetworkUserEntityData$$ExternalSyntheticLambda0 = Reflection.getOrCreateKotlinClass(KycInProgressBottomSheet.class).getSimpleName();
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private FrameLayout MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.fragment_kyc_inprogress;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        Dialog dialog = getDialog();
        this.MyBillsEntityDataFactory = dialog != null ? (FrameLayout) dialog.findViewById(R.id.fl_container) : null;
        Dialog dialog2 = getDialog();
        DanaButtonSecondaryView danaButtonSecondaryView = dialog2 != null ? (DanaButtonSecondaryView) dialog2.findViewById(R.id.btn_close) : null;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.bottomsheetdialog.KycInProgressBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    KycInProgressBottomSheet.PlaceComponentResult(KycInProgressBottomSheet.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kyb/view/bottomsheetdialog/KycInProgressBottomSheet$Companion;", "", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        public static String MyBillsEntityDataFactory() {
            return KycInProgressBottomSheet.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(KycInProgressBottomSheet kycInProgressBottomSheet) {
        Intrinsics.checkNotNullParameter(kycInProgressBottomSheet, "");
        kycInProgressBottomSheet.dismiss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final /* bridge */ /* synthetic */ View getBottomSheet() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
