package id.dana.sendmoney.summary.view;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.core.ui.dialog.WarningDialogUtil;
import id.dana.core.ui.model.UiTextModel;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.databinding.ViewSendmoneySummaryBinding;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.sendmoney.summary.view.SummaryView;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ErrorUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\r\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ#\u0010\u0018\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004JA\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0007\u0010\u001dJ7\u0010\u0014\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u001eJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u0019\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\r\u0010 "}, d2 = {"Lid/dana/sendmoney/summary/view/SummaryView$injectComponent$1;", "Lid/dana/contract/sendmoney/SendMoneyContract$View;", "", "dismissProgress", "()V", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "Lid/dana/core/ui/model/UiTextModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/core/ui/model/UiTextModel;)V", "Lid/dana/domain/sendmoney/model/TransferInit;", "getAuthRequestContext", "(Lid/dana/domain/sendmoney/model/TransferInit;)V", "", "(Ljava/lang/Throwable;)V", "PlaceComponentResult", "Lid/dana/sendmoney/model/RecipientModel;", "p1", "(Lid/dana/sendmoney/model/RecipientModel;Ljava/lang/String;)V", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "p2", "p3", "p4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "showProgress", "(Lid/dana/sendmoney/model/RecipientModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SummaryView$injectComponent$1 implements SendMoneyContract.View {
    final /* synthetic */ SummaryView PlaceComponentResult;

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SummaryView$injectComponent$1(SummaryView summaryView) {
        this.PlaceComponentResult = summaryView;
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void BuiltInFictitiousFunctionClassFactory(RecipientModel p0) {
        ViewSendmoneySummaryBinding binding;
        SummaryView.SummaryListener summaryListener;
        ViewSendmoneySummaryBinding binding2;
        binding = this.PlaceComponentResult.getBinding();
        AppCompatTextView appCompatTextView = binding.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(4);
        SummaryViewState summaryViewState = this.PlaceComponentResult.getSummaryViewState();
        if (summaryViewState != null) {
            SummaryView.access$renderFreeTransfer(this.PlaceComponentResult, summaryViewState, false);
        }
        summaryListener = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        if (summaryListener != null) {
            summaryListener.KClassImpl$Data$declaredNonStaticMembers$2(p0);
        }
        binding2 = this.PlaceComponentResult.getBinding();
        TextView textView = binding2.getAuthRequestContext.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(4);
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3, String p4) {
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2, p3, p4);
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ViewSendmoneySummaryBinding binding;
        boolean authRequestContext;
        SmartFrictionConfig smartFrictionConfig;
        SmartFrictionConfig smartFrictionConfig2;
        SendMoneyFeatureTime access$getSendMoneyFeatureTime = SummaryView.access$getSendMoneyFeatureTime(this.PlaceComponentResult);
        access$getSendMoneyFeatureTime.moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = true;
        SummaryViewState summaryViewState = this.PlaceComponentResult.getSummaryViewState();
        if (summaryViewState != null) {
            this.PlaceComponentResult.getAuthRequestContext(summaryViewState);
        }
        binding = this.PlaceComponentResult.getBinding();
        CurrencyEditText currencyEditText = binding.getAuthRequestContext.MyBillsEntityDataFactory;
        SummaryView summaryView = this.PlaceComponentResult;
        if (!(currencyEditText.getAmountModel().getAmount().length() > 0) || currencyEditText.getAmountModel().isAmountLessThanOne()) {
            return;
        }
        authRequestContext = summaryView.getAuthRequestContext();
        if (authRequestContext) {
            return;
        }
        smartFrictionConfig = summaryView.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (smartFrictionConfig != null) {
            SendMoneyContract.Presenter presenter = summaryView.getPresenter();
            String amount = currencyEditText.getAmount();
            smartFrictionConfig2 = summaryView.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (smartFrictionConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                smartFrictionConfig2 = null;
            }
            presenter.MyBillsEntityDataFactory(amount, smartFrictionConfig2.getReachLimit());
        }
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void MyBillsEntityDataFactory(String p0) {
        boolean authRequestContext;
        SummaryView.SummaryListener summaryListener;
        Intrinsics.checkNotNullParameter(p0, "");
        authRequestContext = this.PlaceComponentResult.getAuthRequestContext();
        if (authRequestContext) {
            return;
        }
        SummaryView summaryView = this.PlaceComponentResult;
        String access$getMaxErrorAmountToSend = SummaryView.access$getMaxErrorAmountToSend(summaryView, p0);
        String string = this.PlaceComponentResult.getResources().getString(R.string.sm_maximum_amount);
        Intrinsics.checkNotNullExpressionValue(string, "");
        summaryView.showAmountWarningMessage(access$getMaxErrorAmountToSend, string, R.drawable.ic_warning_16, R.color.f26712131100373);
        summaryListener = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        if (summaryListener != null) {
            summaryListener.getAuthRequestContext();
        }
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void getAuthRequestContext() {
        SummaryView.SummaryListener summaryListener;
        summaryListener = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        if (summaryListener != null) {
            summaryListener.PlaceComponentResult();
        }
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void PlaceComponentResult(TransferInit p0) {
        RecipientModel recipientModel;
        String str;
        List<String> list;
        SummaryViewState summaryViewState = this.PlaceComponentResult.getSummaryViewState();
        if (summaryViewState != null) {
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(summaryViewState);
        }
        if (p0 != null) {
            SummaryView.access$setFreezeProperty(this.PlaceComponentResult, p0);
        }
        SendMoneyAnalyticTracker sendMoneyAnalyticalTracker = this.PlaceComponentResult.getSendMoneyAnalyticalTracker();
        recipientModel = this.PlaceComponentResult.getErrorConfigVersion;
        boolean errorConfigVersion = recipientModel != null ? recipientModel.getErrorConfigVersion() : false;
        str = this.PlaceComponentResult.scheduleImpl;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        list = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
        sendMoneyAnalyticalTracker.getAuthRequestContext(errorConfigVersion, str, list);
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        boolean authRequestContext;
        SummaryView.SummaryListener summaryListener;
        Intrinsics.checkNotNullParameter(p0, "");
        authRequestContext = this.PlaceComponentResult.getAuthRequestContext();
        if (!authRequestContext) {
            SummaryView summaryView = this.PlaceComponentResult;
            String string = summaryView.getResources().getString(R.string.sm_minimum_amount);
            Intrinsics.checkNotNullExpressionValue(string, "");
            summaryView.showAmountWarningMessage(p0, string, R.drawable.ic_warning_16, R.color.f26712131100373);
            summaryListener = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
            if (summaryListener != null) {
                summaryListener.getAuthRequestContext();
            }
        }
        SummaryViewState summaryViewState = this.PlaceComponentResult.getSummaryViewState();
        if (summaryViewState != null) {
            SummaryView.access$renderFreeTransfer(this.PlaceComponentResult, summaryViewState, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0059, code lost:
    
        r4 = r3.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(id.dana.sendmoney.model.RecipientModel r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            id.dana.sendmoney.summary.view.SummaryView r4 = r3.PlaceComponentResult
            id.dana.sendmoney.summary.view.SummaryViewState r4 = r4.getSummaryViewState()
            if (r4 == 0) goto L51
            id.dana.sendmoney.summary.view.SummaryView r1 = r3.PlaceComponentResult
            id.dana.sendmoney.model.RecipientModel r4 = r4.scheduleImpl
            int r4 = r4.A
            if (r4 <= 0) goto L30
            android.content.res.Resources r4 = r1.getResources()
            r2 = 2131957012(0x7f131514, float:1.9550596E38)
            java.lang.String r4 = r4.getString(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r0 = 2131233191(0x7f0809a7, float:1.8082513E38)
            r2 = 2131099995(0x7f06015b, float:1.7812359E38)
            r1.showAmountWarningMessage(r5, r4, r0, r2)
            goto L51
        L30:
            id.dana.databinding.ViewSendmoneySummaryBinding r4 = id.dana.sendmoney.summary.view.SummaryView.access$getBinding(r1)
            id.dana.databinding.LayoutAmountViewBinding r4 = r4.getAuthRequestContext
            androidx.appcompat.widget.AppCompatTextView r4 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.view.View r4 = (android.view.View) r4
            r2 = 4
            r4.setVisibility(r2)
            id.dana.databinding.ViewSendmoneySummaryBinding r4 = id.dana.sendmoney.summary.view.SummaryView.access$getBinding(r1)
            id.dana.databinding.LayoutAmountViewBinding r4 = r4.getAuthRequestContext
            android.widget.TextView r4 = r4.scheduleImpl
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.view.View r4 = (android.view.View) r4
            r4.setVisibility(r2)
        L51:
            id.dana.sendmoney.summary.view.SummaryView r4 = r3.PlaceComponentResult
            boolean r4 = id.dana.sendmoney.summary.view.SummaryView.access$isCashierEnable(r4)
            if (r4 != 0) goto L64
            id.dana.sendmoney.summary.view.SummaryView r4 = r3.PlaceComponentResult
            id.dana.sendmoney.summary.view.SummaryView$SummaryListener r4 = id.dana.sendmoney.summary.view.SummaryView.access$getListener$p(r4)
            if (r4 == 0) goto L64
            r4.PlaceComponentResult(r5)
        L64:
            id.dana.sendmoney.summary.view.SummaryView r4 = r3.PlaceComponentResult
            id.dana.sendmoney.summary.view.SummaryViewState r4 = r4.getSummaryViewState()
            if (r4 == 0) goto L72
            id.dana.sendmoney.summary.view.SummaryView r5 = r3.PlaceComponentResult
            r0 = 1
            id.dana.sendmoney.summary.view.SummaryView.access$renderFreeTransfer(r5, r4, r0)
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.view.SummaryView$injectComponent$1.PlaceComponentResult(id.dana.sendmoney.model.RecipientModel, java.lang.String):void");
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void MyBillsEntityDataFactory(String p0, String p1) {
        boolean authRequestContext;
        SummaryView.SummaryListener summaryListener;
        String str;
        authRequestContext = this.PlaceComponentResult.getAuthRequestContext();
        if (authRequestContext) {
            return;
        }
        String str2 = p1;
        if (!(str2 == null || str2.length() == 0)) {
            summaryListener = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
            if (summaryListener != null) {
                str = this.PlaceComponentResult.MyBillsEntityDataFactory;
                summaryListener.getAuthRequestContext(p1, str);
                return;
            }
            return;
        }
        SummaryViewState summaryViewState = this.PlaceComponentResult.getSummaryViewState();
        if (summaryViewState != null) {
            SummaryView summaryView = this.PlaceComponentResult;
            summaryViewState.scheduleImpl.PrepareContext = p0;
            summaryView.checkEnableTransferInit(summaryViewState);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
    
        r1 = (r0 = r2.PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2;
     */
    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r3) {
        /*
            r2 = this;
            id.dana.sendmoney.summary.view.SummaryView r0 = r2.PlaceComponentResult
            boolean r0 = id.dana.sendmoney.summary.view.SummaryView.access$isCashierEnable(r0)
            if (r0 != 0) goto L19
            if (r3 == 0) goto L19
            id.dana.sendmoney.summary.view.SummaryView r0 = r2.PlaceComponentResult
            id.dana.sendmoney.summary.view.SummaryView$SummaryListener r1 = id.dana.sendmoney.summary.view.SummaryView.access$getListener$p(r0)
            if (r1 == 0) goto L19
            java.lang.String r0 = id.dana.sendmoney.summary.view.SummaryView.access$getCleanAmountToSend$p(r0)
            r1.getAuthRequestContext(r3, r0)
        L19:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.view.SummaryView$injectComponent$1.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String):void");
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
        Context context = this.PlaceComponentResult.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        String string = this.PlaceComponentResult.getContext().getString(R.string.transfer_method_not_available);
        final SummaryView summaryView = this.PlaceComponentResult;
        WarningDialogUtil.MyBillsEntityDataFactory(context, string, new DialogInterface.OnDismissListener() { // from class: id.dana.sendmoney.summary.view.SummaryView$injectComponent$1$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SummaryView$injectComponent$1.PlaceComponentResult(SummaryView.this);
            }
        }, false, 0);
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void getAuthRequestContext(TransferInit p0) {
        if (p0 != null) {
            Context context = this.PlaceComponentResult.getContext();
            SummaryActivity summaryActivity = context instanceof SummaryActivity ? (SummaryActivity) context : null;
            if (summaryActivity != null) {
                summaryActivity.getTransferInitCallback(p0);
            }
        }
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void BuiltInFictitiousFunctionClassFactory(Throwable p0) {
        RecipientModel recipientModel;
        String str;
        this.PlaceComponentResult.lookAheadTest = p0 == null ? new Throwable() : p0;
        SendMoneyFeatureTime access$getSendMoneyFeatureTime = SummaryView.access$getSendMoneyFeatureTime(this.PlaceComponentResult);
        access$getSendMoneyFeatureTime.moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = false;
        SendMoneyAnalyticTracker sendMoneyAnalyticalTracker = this.PlaceComponentResult.getSendMoneyAnalyticalTracker();
        recipientModel = this.PlaceComponentResult.getErrorConfigVersion;
        boolean errorConfigVersion = recipientModel != null ? recipientModel.getErrorConfigVersion() : false;
        str = this.PlaceComponentResult.scheduleImpl;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        sendMoneyAnalyticalTracker.getAuthRequestContext(errorConfigVersion, str, CollectionsKt.emptyList());
        onError(ErrorUtil.PlaceComponentResult(p0, this.PlaceComponentResult.getContext()));
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void onError(String p0) {
        Context context = this.PlaceComponentResult.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        final SummaryView summaryView = this.PlaceComponentResult;
        WarningDialogUtil.MyBillsEntityDataFactory(context, p0, new DialogInterface.OnDismissListener() { // from class: id.dana.sendmoney.summary.view.SummaryView$injectComponent$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SummaryView$injectComponent$1.BuiltInFictitiousFunctionClassFactory(SummaryView.this);
            }
        }, true, 3000);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        SummaryViewShimmerExt summaryViewShimmerExt = SummaryViewShimmerExt.INSTANCE;
        SummaryViewShimmerExt.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        SummaryViewShimmerExt summaryViewShimmerExt = SummaryViewShimmerExt.INSTANCE;
        SummaryViewShimmerExt.getAuthRequestContext(this.PlaceComponentResult);
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void PlaceComponentResult(Throwable p0, String p1, String p2, String p3) {
        Throwable th;
        Throwable th2;
        boolean z = false;
        if (p2 != null) {
            if (p2.length() > 0) {
                z = true;
            }
        }
        if (z) {
            th = this.PlaceComponentResult.lookAheadTest;
            if (th != null) {
                Context context = this.PlaceComponentResult.getContext();
                th2 = this.PlaceComponentResult.lookAheadTest;
                if (th2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    th2 = null;
                }
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(context, p1, ErrorUtil.PlaceComponentResult(th2, this.PlaceComponentResult.getContext()), p3, p0);
            }
        }
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void BuiltInFictitiousFunctionClassFactory(UiTextModel p0) {
        Context context = this.PlaceComponentResult.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        String asString = p0.asString(this.PlaceComponentResult.getContext());
        final SummaryView summaryView = this.PlaceComponentResult;
        WarningDialogUtil.MyBillsEntityDataFactory(context, asString, new DialogInterface.OnDismissListener() { // from class: id.dana.sendmoney.summary.view.SummaryView$injectComponent$1$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SummaryView$injectComponent$1.MyBillsEntityDataFactory(SummaryView.this);
            }
        }, true, 3000);
    }

    public static /* synthetic */ void PlaceComponentResult(SummaryView summaryView) {
        Intrinsics.checkNotNullParameter(summaryView, "");
        Context context = summaryView.getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.base.BaseActivity");
        }
        ((BaseActivity) context).getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SummaryView summaryView) {
        Intrinsics.checkNotNullParameter(summaryView, "");
        Context context = summaryView.getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.base.BaseActivity");
        }
        ((BaseActivity) context).finish();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SummaryView summaryView) {
        Intrinsics.checkNotNullParameter(summaryView, "");
        Context context = summaryView.getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.base.BaseActivity");
        }
        ((BaseActivity) context).finish();
    }
}
