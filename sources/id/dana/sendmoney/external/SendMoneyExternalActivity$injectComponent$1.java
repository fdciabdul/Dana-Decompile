package id.dana.sendmoney.external;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.sendmoney.model.WithdrawChannelInfoData;
import id.dana.scanner.ScannerActivity;
import id.dana.sendmoney.external.SendMoneyExternalContract;
import id.dana.sendmoney.model.ExternalWithdrawChannelModel;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.DateTimeUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\r\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0005\u0010\u0011J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0006\u0010\u0013J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u000f\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0005\u0010\u0015J/\u0010\u001a\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/external/SendMoneyExternalActivity$injectComponent$1;", "Lid/dana/sendmoney/external/SendMoneyExternalContract$View;", "", "dismissProgress", "()V", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p0", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "getAuthRequestContext", "(Ljava/util/List;)V", "MyBillsEntityDataFactory", "Lid/dana/domain/sendmoney/model/TransferInit;", "(Lid/dana/domain/sendmoney/model/TransferInit;)V", "Lid/dana/domain/sendmoney/model/WithdrawChannelInfoData;", "(Lid/dana/domain/sendmoney/model/WithdrawChannelInfoData;)V", "", "(Z)V", "p1", "p2", "", "p3", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "showProgress"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyExternalActivity$injectComponent$1 implements SendMoneyExternalContract.View {
    final /* synthetic */ SendMoneyExternalActivity KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SendMoneyExternalActivity$injectComponent$1(SendMoneyExternalActivity sendMoneyExternalActivity) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sendMoneyExternalActivity;
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.View
    public final void getAuthRequestContext(List<ExternalWithdrawChannelModel> p0) {
        SendMoneyExternalOutletAdapter sendMoneyExternalOutletAdapter;
        SendMoneyExternalOutletAdapter sendMoneyExternalOutletAdapter2;
        Intrinsics.checkNotNullParameter(p0, "");
        sendMoneyExternalOutletAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        SendMoneyExternalOutletAdapter sendMoneyExternalOutletAdapter3 = null;
        if (sendMoneyExternalOutletAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            sendMoneyExternalOutletAdapter = null;
        }
        sendMoneyExternalOutletAdapter.setItems(p0);
        TextView textView = (TextView) this.KClassImpl$Data$declaredNonStaticMembers$2._$_findCachedViewById(R.id.tvAtmSectionTitle);
        if (textView != null) {
            TextView textView2 = textView;
            sendMoneyExternalOutletAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
            if (sendMoneyExternalOutletAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                sendMoneyExternalOutletAdapter3 = sendMoneyExternalOutletAdapter2;
            }
            List<ExternalWithdrawChannelModel> items = sendMoneyExternalOutletAdapter3.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            textView2.setVisibility(items.isEmpty() ^ true ? 0 : 8);
        }
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.View
    public final void MyBillsEntityDataFactory(List<ExternalWithdrawChannelModel> p0) {
        SendMoneyExternalOutletAdapter sendMoneyExternalOutletAdapter;
        SendMoneyExternalOutletAdapter sendMoneyExternalOutletAdapter2;
        Intrinsics.checkNotNullParameter(p0, "");
        sendMoneyExternalOutletAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        SendMoneyExternalOutletAdapter sendMoneyExternalOutletAdapter3 = null;
        if (sendMoneyExternalOutletAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            sendMoneyExternalOutletAdapter = null;
        }
        sendMoneyExternalOutletAdapter.setItems(p0);
        TextView textView = (TextView) this.KClassImpl$Data$declaredNonStaticMembers$2._$_findCachedViewById(R.id.DeclineFriendRequest);
        if (textView != null) {
            TextView textView2 = textView;
            sendMoneyExternalOutletAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
            if (sendMoneyExternalOutletAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                sendMoneyExternalOutletAdapter3 = sendMoneyExternalOutletAdapter2;
            }
            List<ExternalWithdrawChannelModel> items = sendMoneyExternalOutletAdapter3.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            textView2.setVisibility(items.isEmpty() ^ true ? 0 : 8);
        }
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.View
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        if (p0) {
            SendMoneyExternalActivity.access$showOnboardingDialog(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.View
    public final void MyBillsEntityDataFactory(boolean p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = p0;
        this.KClassImpl$Data$declaredNonStaticMembers$2.getSendMoneyExternalPresenter().BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2.getSendMoneyExternalPresenter().PlaceComponentResult();
        SendMoneyExternalActivity.access$getSendMoneyFeatureTime(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.View
    public final void BuiltInFictitiousFunctionClassFactory(final TransferInit p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SendMoneyExternalActivity.access$setupViewQrisTcicoOutletSection(this.KClassImpl$Data$declaredNonStaticMembers$2, p0);
        View _$_findCachedViewById = this.KClassImpl$Data$declaredNonStaticMembers$2._$_findCachedViewById(R.id.resumeWithException);
        final SendMoneyExternalActivity sendMoneyExternalActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        _$_findCachedViewById.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.external.SendMoneyExternalActivity$injectComponent$1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendMoneyExternalActivity$injectComponent$1.PlaceComponentResult(SendMoneyExternalActivity.this, p0);
            }
        });
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.View
    public final void getAuthRequestContext() {
        SendMoneyExternalActivity.access$hideViewQrisTcicoOutletSection(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.View
    public final void getAuthRequestContext(TransferInit p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SendMoneyExternalActivity.access$setMaintenanceOnQrisTcicoOutlet(this.KClassImpl$Data$declaredNonStaticMembers$2);
        SendMoneyExternalActivity.access$setupViewQrisTcicoOutletSection(this.KClassImpl$Data$declaredNonStaticMembers$2, p0);
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(WithdrawChannelInfoData p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SendMoneyExternalActivity.access$setupLabelQrisTcicoOutlet(this.KClassImpl$Data$declaredNonStaticMembers$2, p0);
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
        SendMoneyExternalActivity.access$getSendMoneyFeatureTime(this.KClassImpl$Data$declaredNonStaticMembers$2).scheduleImpl = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        SendMoneyExternalActivity.access$getSendMoneyFeatureTime(this.KClassImpl$Data$declaredNonStaticMembers$2).getErrorConfigVersion = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.View
    public final void PlaceComponentResult() {
        SendMoneyExternalActivity.access$getSendMoneyFeatureTime(this.KClassImpl$Data$declaredNonStaticMembers$2).moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = this.KClassImpl$Data$declaredNonStaticMembers$2.getSendMoneyAnalyticTracker();
        String source = this.KClassImpl$Data$declaredNonStaticMembers$2.getSource();
        Intrinsics.checkNotNullExpressionValue(source, "");
        sendMoneyAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(source);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        SendMoneyExternalActivity.access$showShimmeringScreen(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        SendMoneyExternalActivity.access$hideShimmeringScreen(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String p0) {
        final SendMoneyExternalActivity sendMoneyExternalActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        sendMoneyExternalActivity.showWarningDialog(p0, new DialogInterface.OnDismissListener() { // from class: id.dana.sendmoney.external.SendMoneyExternalActivity$injectComponent$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SendMoneyExternalActivity$injectComponent$1.BuiltInFictitiousFunctionClassFactory(SendMoneyExternalActivity.this);
            }
        }, 3000);
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.View
    public final void PlaceComponentResult(String p0, String p1, String p2, Throwable p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        if (p1.length() > 0) {
            MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, p0, p1, p2, p3);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SendMoneyExternalActivity sendMoneyExternalActivity) {
        Intrinsics.checkNotNullParameter(sendMoneyExternalActivity, "");
        sendMoneyExternalActivity.finish();
    }

    public static /* synthetic */ void PlaceComponentResult(SendMoneyExternalActivity sendMoneyExternalActivity, TransferInit transferInit) {
        Intrinsics.checkNotNullParameter(sendMoneyExternalActivity, "");
        Intrinsics.checkNotNullParameter(transferInit, "");
        sendMoneyExternalActivity.startActivity(new Intent(sendMoneyExternalActivity, ScannerActivity.class));
        sendMoneyExternalActivity.getSendMoneyAnalyticTracker().BuiltInFictitiousFunctionClassFactory(transferInit.getQrisTcicoEntryPointInfo().getInstName());
    }
}
