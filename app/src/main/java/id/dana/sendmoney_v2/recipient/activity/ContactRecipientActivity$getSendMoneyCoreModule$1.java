package id.dana.sendmoney_v2.recipient.activity;

import android.content.DialogInterface;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.core.ui.model.UiTextModel;
import id.dana.databinding.ActivityRecipientV2Binding;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.ui.core.model.SendMoneyApiMigrationConfigModel;
import id.dana.sendmoney.ui.core.model.TransferInitResultModel;
import id.dana.sendmoney.ui.core.model.TransferUserInfoModel;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import id.dana.sendmoney_v2.recipient.view.RecipientView;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.DateTimeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0003\u0010\u0011J1\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\b\u0010\u0016J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004"}, d2 = {"Lid/dana/sendmoney_v2/recipient/activity/ContactRecipientActivity$getSendMoneyCoreModule$1;", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$View;", "", "PlaceComponentResult", "()V", "getAuthRequestContext", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/Throwable;)V", "Lid/dana/core/ui/model/UiTextModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/core/ui/model/UiTextModel;)V", "Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;)V", "Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "(Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;)V", "", "p1", "p2", "p3", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactRecipientActivity$getSendMoneyCoreModule$1 implements SendMoneyCoreContract.View {
    final /* synthetic */ ContactRecipientActivity MyBillsEntityDataFactory;

    public static /* synthetic */ void MyBillsEntityDataFactory() {
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void PlaceComponentResult() {
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void getAuthRequestContext() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContactRecipientActivity$getSendMoneyCoreModule$1(ContactRecipientActivity contactRecipientActivity) {
        this.MyBillsEntityDataFactory = contactRecipientActivity;
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void BuiltInFictitiousFunctionClassFactory(SendMoneyApiMigrationConfigModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.scheduleImpl = p0;
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void PlaceComponentResult(TransferInitResultModel p0) {
        RecipientModel recipientModel;
        boolean z;
        ActivityRecipientV2Binding binding;
        RecipientModel recipientModel2;
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.GetContactSyncConfig = p0;
        TransferUserInfoModel transferUserInfoModel = p0.PlaceComponentResult;
        ContactRecipientActivity.access$updateRecipientModel(this.MyBillsEntityDataFactory, transferUserInfoModel);
        SendMoneyFeatureTime access$getSendMoneyFeatureTime = ContactRecipientActivity.access$getSendMoneyFeatureTime(this.MyBillsEntityDataFactory);
        access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = true;
        RecipientModel recipientModel3 = null;
        this.MyBillsEntityDataFactory.getSendMoneyAnalyticTracker().PlaceComponentResult(transferUserInfoModel.MyBillsEntityDataFactory() ? null : TrackerKey.SmartFrictionProperties.NON_DANA_USER);
        if (transferUserInfoModel.MyBillsEntityDataFactory()) {
            this.MyBillsEntityDataFactory.PlaceComponentResult = true;
            binding = this.MyBillsEntityDataFactory.getBinding();
            RecipientView recipientView = binding.BuiltInFictitiousFunctionClassFactory;
            ContactRecipientActivity contactRecipientActivity = this.MyBillsEntityDataFactory;
            recipientModel2 = contactRecipientActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            if (recipientModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                recipientModel3 = recipientModel2;
            }
            contactRecipientActivity.MyBillsEntityDataFactory(contactRecipientActivity.isNewNumber(recipientModel3));
            return;
        }
        recipientModel = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (recipientModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            recipientModel3 = recipientModel;
        }
        recipientModel3.GetContactSyncConfig = false;
        z = this.MyBillsEntityDataFactory.PlaceComponentResult;
        if (z) {
            return;
        }
        ContactRecipientActivity.access$showUnregisteredUserDialog(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void MyBillsEntityDataFactory(Throwable p0) {
        RecipientModel recipientModel;
        boolean z;
        RecipientModel recipientModel2;
        Intrinsics.checkNotNullParameter(p0, "");
        recipientModel = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        RecipientModel recipientModel3 = null;
        if (recipientModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientModel = null;
        }
        recipientModel.GetContactSyncConfig = false;
        SendMoneyFeatureTime access$getSendMoneyFeatureTime = ContactRecipientActivity.access$getSendMoneyFeatureTime(this.MyBillsEntityDataFactory);
        access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = false;
        this.MyBillsEntityDataFactory.getSendMoneyAnalyticTracker().PlaceComponentResult(TrackerKey.SmartFrictionProperties.NON_DANA_USER);
        z = this.MyBillsEntityDataFactory.PlaceComponentResult;
        if (z) {
            ContactRecipientActivity contactRecipientActivity = this.MyBillsEntityDataFactory;
            recipientModel2 = contactRecipientActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            if (recipientModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                recipientModel3 = recipientModel2;
            }
            contactRecipientActivity.MyBillsEntityDataFactory(contactRecipientActivity.isNewNumber(recipientModel3));
            return;
        }
        ContactRecipientActivity.access$showUnregisteredUserDialog(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(UiTextModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ContactRecipientActivity contactRecipientActivity = this.MyBillsEntityDataFactory;
        contactRecipientActivity.showWarningDialog(p0.asString(contactRecipientActivity), new DialogInterface.OnDismissListener() { // from class: id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity$getSendMoneyCoreModule$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ContactRecipientActivity$getSendMoneyCoreModule$1.MyBillsEntityDataFactory();
            }
        }, true, 3000);
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void MyBillsEntityDataFactory(Throwable p0, String p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        if (p2.length() > 0) {
            MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, p1, p2, TrackerKey.SourceType.SEND_TO_FRIEND_CONTACT_SELECT, p0);
        }
    }
}
