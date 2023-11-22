package id.dana.savings.withdrawal;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.core.ui.model.UiTextModel;
import id.dana.data.saving.repository.source.network.exception.GoalsApiException;
import id.dana.savings.contract.WithdrawSavingContract;
import id.dana.savings.withdrawal.WithdrawalSavingBottomSheetDialog;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.UrlUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0014J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\r\u0010\u0015"}, d2 = {"Lid/dana/savings/withdrawal/WithdrawalSavingBottomSheetDialog$initComponent$1;", "Lid/dana/savings/contract/WithdrawSavingContract$View;", "", "p0", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "", "getAuthRequestContext", "(Ljava/util/List;)V", "MyBillsEntityDataFactory", "()V", "", "p1", "Lid/dana/core/ui/model/UiTextModel;", "p2", "p3", "(Ljava/lang/Throwable;Ljava/lang/String;Lid/dana/core/ui/model/UiTextModel;Ljava/lang/String;)V", "(Lid/dana/core/ui/model/UiTextModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WithdrawalSavingBottomSheetDialog$initComponent$1 implements WithdrawSavingContract.View {
    final /* synthetic */ WithdrawalSavingBottomSheetDialog BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WithdrawalSavingBottomSheetDialog$initComponent$1(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog) {
        this.BuiltInFictitiousFunctionClassFactory = withdrawalSavingBottomSheetDialog;
    }

    @Override // id.dana.savings.contract.WithdrawSavingContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final boolean p0) {
        ConstraintLayout constraintLayout = (ConstraintLayout) this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(R.id.cl_second_option);
        if (constraintLayout != null) {
            final WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog = this.BuiltInFictitiousFunctionClassFactory;
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.withdrawal.WithdrawalSavingBottomSheetDialog$initComponent$1$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WithdrawalSavingBottomSheetDialog$initComponent$1.KClassImpl$Data$declaredNonStaticMembers$2(WithdrawalSavingBottomSheetDialog.this, p0);
                }
            });
        }
    }

    @Override // id.dana.savings.contract.WithdrawSavingContract.View
    public final void getAuthRequestContext(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.moveToNextValue.addAll(p0);
        WithdrawalSavingBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // id.dana.savings.contract.WithdrawSavingContract.View
    public final void MyBillsEntityDataFactory() {
        String PlaceComponentResult;
        WithdrawalSavingBottomSheetDialog.WithdrawListener withdrawListener = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
        if (withdrawListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            withdrawListener = null;
        }
        PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult("balance");
        String authRequestContext = UrlUtil.getAuthRequestContext(PlaceComponentResult);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        withdrawListener.BuiltInFictitiousFunctionClassFactory(authRequestContext);
        WithdrawalSavingBottomSheetDialog.getErrorConfigVersion(this.BuiltInFictitiousFunctionClassFactory);
        this.BuiltInFictitiousFunctionClassFactory.dismiss();
    }

    @Override // id.dana.savings.contract.WithdrawSavingContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0, String p1, UiTextModel p2, String p3) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this.BuiltInFictitiousFunctionClassFactory.getContext());
        builder.MyBillsEntityDataFactory = "Displayed Error";
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", p3).MyBillsEntityDataFactory("Displayed Message", p2.asString(this.BuiltInFictitiousFunctionClassFactory.getContext())).MyBillsEntityDataFactory("Operation Type", p1);
        String message = p0 != null ? p0.getMessage() : null;
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Message", message != null ? message : "");
        if (p0 instanceof GoalsApiException) {
            GoalsApiException goalsApiException = (GoalsApiException) p0;
            if (goalsApiException.hasTraceIdAndErrorCode()) {
                MyBillsEntityDataFactory2.MyBillsEntityDataFactory("Error Code", goalsApiException.getApiErrorCode());
                MyBillsEntityDataFactory2.MyBillsEntityDataFactory("Trace ID", goalsApiException.getApiTraceId());
            }
        }
        MyBillsEntityDataFactory2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
    }

    @Override // id.dana.savings.contract.WithdrawSavingContract.View
    public final void MyBillsEntityDataFactory(UiTextModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        onError(p0.asString(this.BuiltInFictitiousFunctionClassFactory.getContext()));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String p0) {
        CustomSnackbar customSnackbar;
        this.BuiltInFictitiousFunctionClassFactory.dismiss();
        WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog = this.BuiltInFictitiousFunctionClassFactory;
        View findViewById = withdrawalSavingBottomSheetDialog.getBaseActivity().getWindow().getDecorView().findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder((ViewGroup) findViewById);
        builder.initRecordTimeStamp = p0;
        builder.lookAheadTest = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.pop_up_positive_button_saving_limit_info);
        builder.moveToNextValue = 0;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning_orange;
        builder.MyBillsEntityDataFactory = R.drawable.bg_rectangle_tangerine;
        final WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog2 = this.BuiltInFictitiousFunctionClassFactory;
        builder.scheduleImpl = new View.OnClickListener() { // from class: id.dana.savings.withdrawal.WithdrawalSavingBottomSheetDialog$initComponent$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WithdrawalSavingBottomSheetDialog$initComponent$1.MyBillsEntityDataFactory(WithdrawalSavingBottomSheetDialog.this);
            }
        };
        withdrawalSavingBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2 = builder.BuiltInFictitiousFunctionClassFactory();
        customSnackbar = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customSnackbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            customSnackbar = null;
        }
        customSnackbar.show();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog) {
        CustomSnackbar customSnackbar;
        Intrinsics.checkNotNullParameter(withdrawalSavingBottomSheetDialog, "");
        customSnackbar = withdrawalSavingBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customSnackbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            customSnackbar = null;
        }
        customSnackbar.dismiss();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog, boolean z) {
        Intrinsics.checkNotNullParameter(withdrawalSavingBottomSheetDialog, "");
        WithdrawalSavingBottomSheetDialog.MyBillsEntityDataFactory(withdrawalSavingBottomSheetDialog, z);
    }
}
