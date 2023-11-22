package id.dana.sendmoney.summary.view;

import android.content.Context;
import android.content.DialogInterface;
import id.dana.base.BaseActivity;
import id.dana.core.ui.dialog.WarningDialogUtil;
import id.dana.core.ui.model.UiTextModel;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.ui.core.model.SendMoneyApiMigrationConfigModel;
import id.dana.sendmoney.ui.core.model.TransferInitResultModel;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ErrorUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0003\u0010\u0011J1\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\b\u0010\u0016J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/summary/view/SummaryView$getSendMoneyCoreModule$1;", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$View;", "", "PlaceComponentResult", "()V", "getAuthRequestContext", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/Throwable;)V", "Lid/dana/core/ui/model/UiTextModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/core/ui/model/UiTextModel;)V", "Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;)V", "Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "(Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;)V", "", "p1", "p2", "p3", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SummaryView$getSendMoneyCoreModule$1 implements SendMoneyCoreContract.View {
    final /* synthetic */ SummaryView BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SummaryView$getSendMoneyCoreModule$1(SummaryView summaryView) {
        this.BuiltInFictitiousFunctionClassFactory = summaryView;
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void BuiltInFictitiousFunctionClassFactory(SendMoneyApiMigrationConfigModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SummaryViewState summaryViewState = this.BuiltInFictitiousFunctionClassFactory.getSummaryViewState();
        if (summaryViewState != null) {
            this.BuiltInFictitiousFunctionClassFactory.initTransfer(summaryViewState, p0);
        }
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void getAuthRequestContext() {
        TransferInit transferInit;
        SummaryViewState summaryViewState = this.BuiltInFictitiousFunctionClassFactory.getSummaryViewState();
        if (summaryViewState != null) {
            SummaryView summaryView = this.BuiltInFictitiousFunctionClassFactory;
            transferInit = summaryView.PlaceComponentResult;
            if (transferInit != null) {
                summaryView.BuiltInFictitiousFunctionClassFactory();
            } else {
                summaryView.initSummaryBiztransfer(summaryViewState.getAuthRequestContext(), summaryViewState.scheduleImpl);
            }
        }
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void PlaceComponentResult(TransferInitResultModel p0) {
        RecipientModel recipientModel;
        String str;
        List<String> list;
        Intrinsics.checkNotNullParameter(p0, "");
        SendMoneyFeatureTime access$getSendMoneyFeatureTime = SummaryView.access$getSendMoneyFeatureTime(this.BuiltInFictitiousFunctionClassFactory);
        access$getSendMoneyFeatureTime.moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = true;
        SendMoneyAnalyticTracker sendMoneyAnalyticalTracker = this.BuiltInFictitiousFunctionClassFactory.getSendMoneyAnalyticalTracker();
        recipientModel = this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion;
        boolean errorConfigVersion = recipientModel != null ? recipientModel.getErrorConfigVersion() : false;
        str = this.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        list = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
        sendMoneyAnalyticalTracker.getAuthRequestContext(errorConfigVersion, str, list);
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(p0);
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void MyBillsEntityDataFactory(Throwable p0) {
        RecipientModel recipientModel;
        String str;
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.lookAheadTest = p0;
        SendMoneyFeatureTime access$getSendMoneyFeatureTime = SummaryView.access$getSendMoneyFeatureTime(this.BuiltInFictitiousFunctionClassFactory);
        access$getSendMoneyFeatureTime.moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = false;
        SendMoneyAnalyticTracker sendMoneyAnalyticalTracker = this.BuiltInFictitiousFunctionClassFactory.getSendMoneyAnalyticalTracker();
        recipientModel = this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion;
        boolean errorConfigVersion = recipientModel != null ? recipientModel.getErrorConfigVersion() : false;
        str = this.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        sendMoneyAnalyticalTracker.getAuthRequestContext(errorConfigVersion, str, CollectionsKt.emptyList());
        Context context = this.BuiltInFictitiousFunctionClassFactory.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        String PlaceComponentResult = ErrorUtil.PlaceComponentResult(p0, this.BuiltInFictitiousFunctionClassFactory.getContext());
        final SummaryView summaryView = this.BuiltInFictitiousFunctionClassFactory;
        WarningDialogUtil.MyBillsEntityDataFactory(context, PlaceComponentResult, new DialogInterface.OnDismissListener() { // from class: id.dana.sendmoney.summary.view.SummaryView$getSendMoneyCoreModule$1$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SummaryView$getSendMoneyCoreModule$1.MyBillsEntityDataFactory(SummaryView.this);
            }
        }, true, 3000);
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(UiTextModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Context context = this.BuiltInFictitiousFunctionClassFactory.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        String asString = p0.asString(this.BuiltInFictitiousFunctionClassFactory.getContext());
        final SummaryView summaryView = this.BuiltInFictitiousFunctionClassFactory;
        WarningDialogUtil.MyBillsEntityDataFactory(context, asString, new DialogInterface.OnDismissListener() { // from class: id.dana.sendmoney.summary.view.SummaryView$getSendMoneyCoreModule$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SummaryView$getSendMoneyCoreModule$1.PlaceComponentResult(SummaryView.this);
            }
        }, true, 3000);
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
        SummaryViewShimmerExt summaryViewShimmerExt = SummaryViewShimmerExt.INSTANCE;
        SummaryViewShimmerExt.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void PlaceComponentResult() {
        SummaryViewShimmerExt summaryViewShimmerExt = SummaryViewShimmerExt.INSTANCE;
        SummaryViewShimmerExt.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void MyBillsEntityDataFactory(Throwable p0, String p1, String p2, String p3) {
        Throwable th;
        Throwable th2;
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        if (p2.length() > 0) {
            th = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest;
            if (th != null) {
                Context context = this.BuiltInFictitiousFunctionClassFactory.getContext();
                th2 = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest;
                if (th2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    th2 = null;
                }
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(context, p1, ErrorUtil.PlaceComponentResult(th2, this.BuiltInFictitiousFunctionClassFactory.getContext()), p3, p0);
            }
        }
    }

    public static /* synthetic */ void PlaceComponentResult(SummaryView summaryView) {
        Intrinsics.checkNotNullParameter(summaryView, "");
        Context context = summaryView.getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.base.BaseActivity");
        }
        ((BaseActivity) context).finish();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SummaryView summaryView) {
        Intrinsics.checkNotNullParameter(summaryView, "");
        Context context = summaryView.getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.base.BaseActivity");
        }
        ((BaseActivity) context).finish();
    }
}
