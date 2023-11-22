package id.dana.kyb.view.bottomsheetdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\"\u0010\rJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0012\u0010\rR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u0014R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0014"}, d2 = {"Lid/dana/kyb/view/bottomsheetdialog/KybWithdrawDestinationBottomSheet;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "Landroid/view/View;", "getBottomSheet", "()Landroid/view/View;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/content/DialogInterface;", "p0", "onDismiss", "(Landroid/content/DialogInterface;)V", "onShow", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "lookAheadTest", "PlaceComponentResult", "Lkotlin/Function0;", "scheduleImpl", "Lkotlin/jvm/functions/Function0;", "MyBillsEntityDataFactory", "moveToNextValue", "getAuthRequestContext", "getErrorConfigVersion", "BuiltInFictitiousFunctionClassFactory", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybWithdrawDestinationBottomSheet extends BaseBottomSheetDialogFragment {

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private View NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private View KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private View moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private View PlaceComponentResult;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public Function0<Unit> MyBillsEntityDataFactory = new Function0<Unit>() { // from class: id.dana.kyb.view.bottomsheetdialog.KybWithdrawDestinationBottomSheet$onBalanceClickAction$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    };

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public Function0<Unit> getAuthRequestContext = new Function0<Unit>() { // from class: id.dana.kyb.view.bottomsheetdialog.KybWithdrawDestinationBottomSheet$onBankClickAction$1
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
    public Function0<Unit> BuiltInFictitiousFunctionClassFactory = new Function0<Unit>() { // from class: id.dana.kyb.view.bottomsheetdialog.KybWithdrawDestinationBottomSheet$onDismissAction$1
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
        return R.layout.fragment_kyb_withdraw_destination;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet  reason: from getter */
    public final View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        Dialog dialog = getDialog();
        this.PlaceComponentResult = dialog != null ? dialog.findViewById(R.id.fl_container) : null;
        Dialog dialog2 = getDialog();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = dialog2 != null ? dialog2.findViewById(R.id.option_balance) : null;
        Dialog dialog3 = getDialog();
        this.moveToNextValue = dialog3 != null ? dialog3.findViewById(R.id.option_bank) : null;
        Dialog dialog4 = getDialog();
        View findViewById = dialog4 != null ? dialog4.findViewById(R.id.btn_cancel) : null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.bottomsheetdialog.KybWithdrawDestinationBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    KybWithdrawDestinationBottomSheet.MyBillsEntityDataFactory(KybWithdrawDestinationBottomSheet.this);
                }
            });
        }
        View view = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.bottomsheetdialog.KybWithdrawDestinationBottomSheet$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    KybWithdrawDestinationBottomSheet.PlaceComponentResult(KybWithdrawDestinationBottomSheet.this);
                }
            });
        }
        View view2 = this.moveToNextValue;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.bottomsheetdialog.KybWithdrawDestinationBottomSheet$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    KybWithdrawDestinationBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2(KybWithdrawDestinationBottomSheet.this);
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
        this.BuiltInFictitiousFunctionClassFactory.invoke();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(KybWithdrawDestinationBottomSheet kybWithdrawDestinationBottomSheet) {
        Intrinsics.checkNotNullParameter(kybWithdrawDestinationBottomSheet, "");
        kybWithdrawDestinationBottomSheet.dismiss();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(KybWithdrawDestinationBottomSheet kybWithdrawDestinationBottomSheet) {
        Intrinsics.checkNotNullParameter(kybWithdrawDestinationBottomSheet, "");
        kybWithdrawDestinationBottomSheet.getAuthRequestContext.invoke();
    }

    public static /* synthetic */ void PlaceComponentResult(KybWithdrawDestinationBottomSheet kybWithdrawDestinationBottomSheet) {
        Intrinsics.checkNotNullParameter(kybWithdrawDestinationBottomSheet, "");
        kybWithdrawDestinationBottomSheet.MyBillsEntityDataFactory.invoke();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
