package id.dana.sendmoney_v2.landing;

import android.content.DialogInterface;
import android.os.Bundle;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.databinding.ActivitySendMoneyLandingBinding;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.withdraw.model.TransferMethodView;
import id.dana.model.SendMoneyScenarioModel;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract;
import id.dana.sendmoney_v2.landing.view.RecentTransactionView;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.UrlUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\t\u0010\fJ!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\u000eJ/\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\fJ\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/sendmoney_v2/landing/SendMoneyActivity$sendMoneyLandingModule$1;", "Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$View;", "", "p0", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/sendmoney/model/TransferInit;", "getAuthRequestContext", "(Lid/dana/domain/sendmoney/model/TransferInit;)V", "", "()V", "p1", "(Ljava/lang/String;Ljava/lang/String;)V", "", "p2", "p3", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "PlaceComponentResult", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SendMoneyActivity$sendMoneyLandingModule$1 implements KycAndDebitPayOptionContract.View {
    final /* synthetic */ SendMoneyActivity PlaceComponentResult;

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
    public SendMoneyActivity$sendMoneyLandingModule$1(SendMoneyActivity sendMoneyActivity) {
        this.PlaceComponentResult = sendMoneyActivity;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String p0) {
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = true;
        SendMoneyFeatureTime access$getSendMoneyFeatureTime = SendMoneyActivity.access$getSendMoneyFeatureTime(this.PlaceComponentResult);
        access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = false;
        final SendMoneyActivity sendMoneyActivity = this.PlaceComponentResult;
        if (p0 == null) {
            p0 = "";
        }
        sendMoneyActivity.showWarningDialog(p0, new DialogInterface.OnDismissListener() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$sendMoneyLandingModule$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SendMoneyActivity$sendMoneyLandingModule$1.BuiltInFictitiousFunctionClassFactory(SendMoneyActivity.this);
            }
        });
    }

    @Override // id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract.View
    public final void PlaceComponentResult(Object p0) {
        ActivitySendMoneyLandingBinding binding;
        ActivitySendMoneyLandingBinding binding2;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        Bundle extras = this.PlaceComponentResult.getIntent().getExtras();
        String string = extras != null ? extras.getString("recipientType") : null;
        String str = string;
        if (((str == null || str.length() == 0) || Intrinsics.areEqual(string, BranchLinkConstant.ActionTarget.SEND_MONEY)) ? false : true) {
            KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
        }
        if (p0 instanceof SendMoneyScenarioModel) {
            SendMoneyActivity.access$checkSendMoneyUseCase(this.PlaceComponentResult, (SendMoneyScenarioModel) p0);
        } else if (p0 instanceof RecipientModel) {
            SendMoneyActivity.access$openSummary(this.PlaceComponentResult, (RecipientModel) p0);
        } else if (p0 instanceof RecentTransactionView) {
            binding2 = this.PlaceComponentResult.getBinding();
            binding2.PlaceComponentResult.openSearchRecipient();
        } else if (p0 instanceof RecentRecipientModel) {
            binding = this.PlaceComponentResult.getBinding();
            binding.PlaceComponentResult.onItemClicked((RecentRecipientModel) p0);
        } else {
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract.View
    public final void getAuthRequestContext() {
        SendMoneyActivity.access$showKycDialog(this.PlaceComponentResult);
    }

    @Override // id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract.View
    public final void getAuthRequestContext(TransferInit p0) {
        ActivitySendMoneyLandingBinding binding;
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = true;
        SendMoneyFeatureTime access$getSendMoneyFeatureTime = SendMoneyActivity.access$getSendMoneyFeatureTime(this.PlaceComponentResult);
        access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = true;
        List<TransferMethodView> transferMethod = p0.getTransferMethod();
        Intrinsics.checkNotNullExpressionValue(transferMethod, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : transferMethod) {
            if (Intrinsics.areEqual(((TransferMethodView) obj).getTransferMethod(), "BANK_TRANSFER")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        SendMoneyActivity sendMoneyActivity = this.PlaceComponentResult;
        if ((!arrayList2.isEmpty()) == true) {
            binding = sendMoneyActivity.getBinding();
            binding.MyBillsEntityDataFactory.updateSendmoneyScenarios((int) ((TransferMethodView) arrayList2.get(0)).getFreeRemainedTimes());
        }
    }

    @Override // id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract.View
    public final void getAuthRequestContext(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        SendMoneyActivity sendMoneyActivity = this.PlaceComponentResult;
        String authRequestContext = UrlUtil.getAuthRequestContext(p0);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        SendMoneyActivity.access$openPostH5Container(this.PlaceComponentResult, SendMoneyActivity.access$constructFullUrl(sendMoneyActivity, authRequestContext, p1, this.PlaceComponentResult.getDeviceInformationProvider().getDeviceUUID()));
    }

    @Override // id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        CustomToast.MyBillsEntityDataFactory(this.PlaceComponentResult, R.drawable.ic_close_red, R.drawable.bg_rounded_border_red_50, p0);
    }

    @Override // id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract.View
    public final void BuiltInFictitiousFunctionClassFactory(Throwable p0, String p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        if (p2.length() > 0) {
            MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, p1, p2, p3, p0);
        }
    }

    @Override // id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        SendMoneyActivity.access$showUserDataOnProcessedDialog(this.PlaceComponentResult);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SendMoneyActivity sendMoneyActivity) {
        Intrinsics.checkNotNullParameter(sendMoneyActivity, "");
        sendMoneyActivity.enableClick();
    }
}
