package id.dana.sendmoney_v2.recipient.activity;

import android.content.DialogInterface;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.core.ui.model.UiTextModel;
import id.dana.databinding.ActivityRecipientV2Binding;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney_v2.recipient.view.RecipientView;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.DateTimeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\r\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J#\u0010\u0014\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ#\u0010\u0018\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004JA\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0007\u0010\u001dJ7\u0010\u0014\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u001eJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u0019\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\r\u0010 "}, d2 = {"Lid/dana/sendmoney_v2/recipient/activity/ContactRecipientActivity$getSendMoneyModule$1;", "Lid/dana/contract/sendmoney/SendMoneyContract$View;", "", "dismissProgress", "()V", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "Lid/dana/core/ui/model/UiTextModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/core/ui/model/UiTextModel;)V", "Lid/dana/domain/sendmoney/model/TransferInit;", "getAuthRequestContext", "(Lid/dana/domain/sendmoney/model/TransferInit;)V", "", "(Ljava/lang/Throwable;)V", "PlaceComponentResult", "Lid/dana/sendmoney/model/RecipientModel;", "p1", "(Lid/dana/sendmoney/model/RecipientModel;Ljava/lang/String;)V", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "p2", "p3", "p4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "showProgress", "(Lid/dana/sendmoney/model/RecipientModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactRecipientActivity$getSendMoneyModule$1 implements SendMoneyContract.View {
    final /* synthetic */ ContactRecipientActivity BuiltInFictitiousFunctionClassFactory;

    public static /* synthetic */ void PlaceComponentResult() {
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void BuiltInFictitiousFunctionClassFactory(RecipientModel p0) {
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void MyBillsEntityDataFactory(String p0) {
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void MyBillsEntityDataFactory(String p0, String p1) {
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void PlaceComponentResult(TransferInit p0) {
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void PlaceComponentResult(RecipientModel p0, String p1) {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void getAuthRequestContext() {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContactRecipientActivity$getSendMoneyModule$1(ContactRecipientActivity contactRecipientActivity) {
        this.BuiltInFictitiousFunctionClassFactory = contactRecipientActivity;
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3, String p4) {
        ActivityRecipientV2Binding binding;
        RecipientModel recipientModel;
        RecipientModel recipientModel2;
        RecipientModel recipientModel3;
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        binding = this.BuiltInFictitiousFunctionClassFactory.getBinding();
        RecipientView recipientView = binding.BuiltInFictitiousFunctionClassFactory;
        ContactRecipientActivity contactRecipientActivity = this.BuiltInFictitiousFunctionClassFactory;
        recipientModel = contactRecipientActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        RecipientModel recipientModel4 = null;
        if (recipientModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientModel = null;
        }
        if (p4 == null) {
            p4 = "";
        }
        recipientModel.PlaceComponentResult = p4;
        recipientModel2 = contactRecipientActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (recipientModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientModel2 = null;
        }
        recipientModel2.GetContactSyncConfig = true;
        recipientModel3 = contactRecipientActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (recipientModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            recipientModel4 = recipientModel3;
        }
        contactRecipientActivity.MyBillsEntityDataFactory(contactRecipientActivity.isNewNumber(recipientModel4));
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        RecipientModel recipientModel;
        boolean z;
        boolean z2;
        recipientModel = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (recipientModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientModel = null;
        }
        recipientModel.GetContactSyncConfig = false;
        SendMoneyFeatureTime access$getSendMoneyFeatureTime = ContactRecipientActivity.access$getSendMoneyFeatureTime(this.BuiltInFictitiousFunctionClassFactory);
        access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = true;
        ContactRecipientActivity contactRecipientActivity = this.BuiltInFictitiousFunctionClassFactory;
        z = contactRecipientActivity.PlaceComponentResult;
        contactRecipientActivity.getSendMoneyAnalyticTracker().PlaceComponentResult(z ? null : TrackerKey.SmartFrictionProperties.NON_DANA_USER);
        z2 = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        if (z2) {
            return;
        }
        ContactRecipientActivity.access$showUnregisteredUserDialog(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void getAuthRequestContext(TransferInit p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = p0;
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        if (p0) {
            DanaLoadingDialog danaLoadingDialog = this.BuiltInFictitiousFunctionClassFactory.getDanaLoadingDialog();
            if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                return;
            }
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.getDanaLoadingDialog().PlaceComponentResult();
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void BuiltInFictitiousFunctionClassFactory(Throwable p0) {
        RecipientModel recipientModel;
        boolean z;
        RecipientModel recipientModel2;
        recipientModel = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        RecipientModel recipientModel3 = null;
        if (recipientModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientModel = null;
        }
        recipientModel.GetContactSyncConfig = false;
        SendMoneyFeatureTime access$getSendMoneyFeatureTime = ContactRecipientActivity.access$getSendMoneyFeatureTime(this.BuiltInFictitiousFunctionClassFactory);
        access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = false;
        this.BuiltInFictitiousFunctionClassFactory.getSendMoneyAnalyticTracker().PlaceComponentResult(TrackerKey.SmartFrictionProperties.NON_DANA_USER);
        z = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        if (z) {
            ContactRecipientActivity contactRecipientActivity = this.BuiltInFictitiousFunctionClassFactory;
            recipientModel2 = contactRecipientActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            if (recipientModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                recipientModel3 = recipientModel2;
            }
            contactRecipientActivity.MyBillsEntityDataFactory(contactRecipientActivity.isNewNumber(recipientModel3));
            return;
        }
        ContactRecipientActivity.access$showUnregisteredUserDialog(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void onError(String p0) {
        RecipientModel recipientModel;
        ContactRecipientActivity contactRecipientActivity = this.BuiltInFictitiousFunctionClassFactory;
        recipientModel = contactRecipientActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (recipientModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientModel = null;
        }
        contactRecipientActivity.MyBillsEntityDataFactory(contactRecipientActivity.isNewNumber(recipientModel));
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void PlaceComponentResult(Throwable p0, String p1, String p2, String p3) {
        String str = p2;
        if (str == null || str.length() == 0) {
            return;
        }
        MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, p1, p2, p3, p0);
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.View
    public final void BuiltInFictitiousFunctionClassFactory(UiTextModel p0) {
        ContactRecipientActivity contactRecipientActivity = this.BuiltInFictitiousFunctionClassFactory;
        contactRecipientActivity.showWarningDialog(p0.asString(contactRecipientActivity), new DialogInterface.OnDismissListener() { // from class: id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity$getSendMoneyModule$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ContactRecipientActivity$getSendMoneyModule$1.PlaceComponentResult();
            }
        }, true, 3000);
    }
}
