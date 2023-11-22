package id.dana.sendmoney;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.domain.sendmoney.TransferScenario;
import id.dana.sendmoney.bank.AddReceiverDialogFragment;
import id.dana.sendmoney.external.SendMoneyExternalActivity;
import id.dana.sendmoney.model.QrTransferModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity;
import id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity;
import id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity;
import id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity;
import id.dana.sendmoney_v2.x2l.model.SocialLinkModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0005\u0010\rJ\u0017\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\fH\u0002¢\u0006\u0004\b\b\u0010\rJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\fH\u0002¢\u0006\u0004\b\n\u0010\rJ#\u0010\u0005\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0005\u0010\u0010J\u000f\u0010\u0007\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0007\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u000bR\u0014\u0010\n\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0015"}, d2 = {"Lid/dana/sendmoney/SendMoneyScenarioDirector;", "", "Landroid/os/Bundle;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/os/Bundle;)Z", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "", "PlaceComponentResult", "(Landroid/os/Bundle;)V", "", "(Ljava/lang/String;)V", "Lid/dana/sendmoney_v2/x2l/model/SocialLinkModel;", "p1", "(Ljava/lang/String;Lid/dana/sendmoney_v2/x2l/model/SocialLinkModel;)V", "()V", "MyBillsEntityDataFactory", "Lid/dana/base/BaseActivity;", "Lid/dana/base/BaseActivity;", "Ljava/lang/String;", "<init>", "(Lid/dana/base/BaseActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyScenarioDirector {
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final BaseActivity PlaceComponentResult;

    public SendMoneyScenarioDirector(BaseActivity baseActivity) {
        Intrinsics.checkNotNullParameter(baseActivity, "");
        this.PlaceComponentResult = baseActivity;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean getAuthRequestContext(Bundle p0) {
        QrTransferModel qrTransferModel;
        String getContactSyncConfig;
        String str;
        if (BuiltInFictitiousFunctionClassFactory(p0)) {
            return false;
        }
        String string = p0 != null ? p0.getString("recipientType") : null;
        String str2 = "";
        if (string != null) {
            switch (string.hashCode()) {
                case -1482068345:
                    if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_GROUPSEND)) {
                        String source = this.PlaceComponentResult.getSource();
                        Intrinsics.checkNotNullExpressionValue(source, "");
                        PlaceComponentResult(source);
                        break;
                    }
                    break;
                case -1420060106:
                    if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_PHONE)) {
                        MyBillsEntityDataFactory(p0);
                        break;
                    }
                    break;
                case -1088666555:
                    if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_OUTLET)) {
                        getAuthRequestContext();
                        break;
                    }
                    break;
                case 757209410:
                    if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_CASHOUT_WITHDRAW)) {
                        KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.SendMoneyProperties.DANA_HOME_PAGE);
                        break;
                    }
                    break;
                case 785051764:
                    if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_BANK)) {
                        PlaceComponentResult(p0);
                        break;
                    }
                    break;
                case 785087888:
                    if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_CHAT)) {
                        if (p0 != null) {
                            String string2 = p0.getString("iconUrl", "");
                            Intrinsics.checkNotNullExpressionValue(string2, "");
                            str2 = string2;
                        }
                        KClassImpl$Data$declaredNonStaticMembers$2(str2, p0 != null ? (SocialLinkModel) p0.getParcelable("socilaLink") : null);
                        break;
                    }
                    break;
                case 1042376846:
                    if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_GLOBAL)) {
                        String source2 = this.PlaceComponentResult.getSource();
                        Intrinsics.checkNotNullExpressionValue(source2, "");
                        BuiltInFictitiousFunctionClassFactory(source2);
                        break;
                    }
                    break;
            }
            return true;
        }
        if (p0 != null && (qrTransferModel = (QrTransferModel) p0.getParcelable("scanner_data")) != null) {
            if (qrTransferModel.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                this.BuiltInFictitiousFunctionClassFactory = qrTransferModel.getKClassImpl$Data$declaredNonStaticMembers$2();
            } else {
                if (TextUtils.isEmpty(qrTransferModel.getGetContactSyncConfig())) {
                    getContactSyncConfig = qrTransferModel.getNetworkUserEntityData$$ExternalSyntheticLambda0();
                    str = "phonenumber";
                } else {
                    getContactSyncConfig = qrTransferModel.getGetContactSyncConfig();
                    str = "userid";
                }
                RecipientModel.Builder builder = new RecipientModel.Builder("contact");
                builder.scheduleImpl = getContactSyncConfig;
                builder.PrepareContext = str;
                builder.initRecordTimeStamp = qrTransferModel.getMoveToNextValue();
                builder.GetContactSyncConfig = qrTransferModel.getNetworkUserEntityData$$ExternalSyntheticLambda0();
                builder.getErrorConfigVersion = qrTransferModel.getPlaceComponentResult();
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = qrTransferModel.getKClassImpl$Data$declaredNonStaticMembers$2();
                builder.BuiltInFictitiousFunctionClassFactory = true;
                RecipientModel KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
                Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                KClassImpl$Data$declaredNonStaticMembers$2.B = p0.getString("transactionType");
                if ("split_bill".equals(KClassImpl$Data$declaredNonStaticMembers$2.B)) {
                    KClassImpl$Data$declaredNonStaticMembers$2.BottomSheetCardBindingView$watcherCardNumberView$1 = TransferScenario.SPLIT_BILL;
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$2.BottomSheetCardBindingView$watcherCardNumberView$1 = RecipientModel.KClassImpl$Data$declaredNonStaticMembers$2(qrTransferModel);
                }
                Intent intentClassWithTracking = this.PlaceComponentResult.getIntentClassWithTracking(SummaryActivity.class);
                intentClassWithTracking.putExtra("data", KClassImpl$Data$declaredNonStaticMembers$2);
                intentClassWithTracking.putExtra("remarks", qrTransferModel.getMyBillsEntityDataFactory());
                intentClassWithTracking.putExtra("transferScenario", KClassImpl$Data$declaredNonStaticMembers$2.BottomSheetCardBindingView$watcherCardNumberView$1);
                intentClassWithTracking.putExtra(DecodedScanBizInfoKey.SPLIT_BILL_ID, p0.getString(DecodedScanBizInfoKey.SPLIT_BILL_ID));
                this.PlaceComponentResult.startActivity(intentClassWithTracking);
                if (Intrinsics.areEqual("split_bill", KClassImpl$Data$declaredNonStaticMembers$2.B)) {
                    this.PlaceComponentResult.finish();
                }
            }
        }
        return true;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Bundle p0) {
        return p0 == null || (TextUtils.isEmpty(p0.getString("recipientType")) && p0.getParcelable("scanner_data") == null);
    }

    private final void MyBillsEntityDataFactory(Bundle p0) {
        QrTransferModel qrTransferModel;
        Intent intent = new Intent(this.PlaceComponentResult, ContactRecipientActivity.class);
        if (!p0.containsKey("scanner_data")) {
            qrTransferModel = null;
        } else if (Build.VERSION.SDK_INT >= 33) {
            qrTransferModel = (QrTransferModel) p0.getParcelable("scanner_data", QrTransferModel.class);
        } else {
            qrTransferModel = (QrTransferModel) p0.getParcelable("scanner_data");
        }
        if (qrTransferModel != null) {
            intent.putExtra("scanner_data", qrTransferModel);
        } else if (!TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory)) {
            QrTransferModel qrTransferModel2 = new QrTransferModel(null, null, null, null, null, null, null, 127, null);
            qrTransferModel2.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
            intent.putExtra("scanner_data", qrTransferModel2);
        }
        intent.putExtras(p0);
        this.PlaceComponentResult.startActivity(intent);
    }

    private final void PlaceComponentResult(Bundle p0) {
        Intent intent = new Intent(this.PlaceComponentResult, BankRecipientActivity.class);
        if (!TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory)) {
            QrTransferModel qrTransferModel = new QrTransferModel(null, null, null, null, null, null, null, 127, null);
            qrTransferModel.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
            intent.putExtra("scanner_data", qrTransferModel);
        }
        intent.putExtras(p0);
        this.PlaceComponentResult.startActivity(intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x003a, code lost:
    
        if (r5 == null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r4, id.dana.sendmoney_v2.x2l.model.SocialLinkModel r5) {
        /*
            r3 = this;
            id.dana.base.BaseActivity r0 = r3.PlaceComponentResult
            boolean r1 = r0 instanceof id.dana.sendmoney_v2.landing.SendMoneyActivity
            if (r1 == 0) goto L12
            java.lang.Class<id.dana.sendmoney_v2.x2l.SendToLinkActivity> r4 = id.dana.sendmoney_v2.x2l.SendToLinkActivity.class
            android.content.Intent r4 = r0.getIntentClassWithTracking(r4)
            id.dana.base.BaseActivity r5 = r3.PlaceComponentResult
            r5.startActivity(r4)
            return
        L12:
            id.dana.sendmoney.model.RecipientModel$Builder r0 = new id.dana.sendmoney.model.RecipientModel$Builder
            java.lang.String r1 = "link"
            r0.<init>(r1)
            java.lang.String r1 = ""
            if (r5 == 0) goto L3c
            id.dana.base.BaseActivity r2 = r3.PlaceComponentResult
            android.content.Context r2 = (android.content.Context) r2
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r5 = r5.BuiltInFictitiousFunctionClassFactory
            java.lang.String r5 = id.dana.sendmoney_v2.x2l.model.SocialLinkModel.MyBillsEntityDataFactory(r2, r5)
            if (r5 != 0) goto L2d
            r5 = r1
        L2d:
            if (r5 == 0) goto L3c
            java.util.Locale r2 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            java.lang.String r5 = kotlin.text.StringsKt.capitalize(r5, r2)
            if (r5 != 0) goto L48
        L3c:
            id.dana.base.BaseActivity r5 = r3.PlaceComponentResult
            r2 = 2131956861(0x7f13147d, float:1.955029E38)
            java.lang.String r5 = r5.getString(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
        L48:
            r0.initRecordTimeStamp = r5
            if (r4 != 0) goto L4d
            r4 = r1
        L4d:
            r0.getErrorConfigVersion = r4
            java.lang.String r4 = r3.BuiltInFictitiousFunctionClassFactory
            if (r4 != 0) goto L54
            goto L55
        L54:
            r1 = r4
        L55:
            r0.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            id.dana.base.BaseActivity r4 = r3.PlaceComponentResult
            java.lang.String r4 = r4.getSource()
            r0.NetworkUserEntityData$$ExternalSyntheticLambda6 = r4
            id.dana.sendmoney.model.RecipientModel r4 = r0.KClassImpl$Data$declaredNonStaticMembers$2()
            id.dana.base.BaseActivity r5 = r3.PlaceComponentResult
            java.lang.Class<id.dana.sendmoney.summary.SummaryActivity> r0 = id.dana.sendmoney.summary.SummaryActivity.class
            android.content.Intent r5 = r5.getIntentClassWithTracking(r0)
            java.lang.String r0 = "send_money"
            r4.BottomSheetCardBindingView$watcherCardNumberView$1 = r0
            android.os.Parcelable r4 = (android.os.Parcelable) r4
            java.lang.String r0 = "data"
            r5.putExtra(r0, r4)
            java.lang.String r4 = "recipientType"
            java.lang.String r0 = "chat"
            r5.putExtra(r4, r0)
            id.dana.base.BaseActivity r4 = r3.PlaceComponentResult
            r4.startActivity(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.SendMoneyScenarioDirector.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String, id.dana.sendmoney_v2.x2l.model.SocialLinkModel):void");
    }

    private final void getAuthRequestContext() {
        AddReceiverDialogFragment addReceiverDialogFragment = new AddReceiverDialogFragment();
        addReceiverDialogFragment.scheduleImpl = new AddReceiverDialogFragment.OnAddReceiverInformation() { // from class: id.dana.sendmoney.SendMoneyScenarioDirector$$ExternalSyntheticLambda0
            @Override // id.dana.sendmoney.bank.AddReceiverDialogFragment.OnAddReceiverInformation
            public final void KClassImpl$Data$declaredNonStaticMembers$2(RecipientModel recipientModel) {
                SendMoneyScenarioDirector.BuiltInFictitiousFunctionClassFactory(SendMoneyScenarioDirector.this, recipientModel);
            }
        };
        addReceiverDialogFragment.show(this.PlaceComponentResult.getSupportFragmentManager(), "Add Receiver Info Dialog");
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intent intent = new Intent(this.PlaceComponentResult, SendMoneyExternalActivity.class);
        intent.putExtra("source", p0);
        this.PlaceComponentResult.startActivity(intent);
    }

    private final void PlaceComponentResult(String p0) {
        Intent intent = new Intent(this.PlaceComponentResult, GroupSendLandingActivity.class);
        intent.putExtra("source", p0);
        this.PlaceComponentResult.startActivity(intent);
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intent intent = new Intent(this.PlaceComponentResult, GlobalSendLandingActivity.class);
        intent.putExtra("source", p0);
        this.PlaceComponentResult.startActivity(intent);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
        String string;
        String str = "";
        Intrinsics.checkNotNullParameter(p0, "");
        if (!BuiltInFictitiousFunctionClassFactory(p0) && (string = p0.getString("recipientType")) != null) {
            switch (string.hashCode()) {
                case -1820761141:
                    if (string.equals("external")) {
                        KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.SendMoneyProperties.SEND_MONEY_PAGE);
                        return true;
                    }
                    break;
                case -1005516787:
                    if (string.equals("outlet")) {
                        getAuthRequestContext();
                        return true;
                    }
                    break;
                case -276836809:
                    if (string.equals("phonenumber")) {
                        MyBillsEntityDataFactory(p0);
                        return true;
                    }
                    break;
                case 3016252:
                    if (string.equals("bank")) {
                        PlaceComponentResult(p0);
                        return true;
                    }
                    break;
                case 3052376:
                    if (string.equals("chat")) {
                        if (p0 != null) {
                            String string2 = p0.getString("iconUrl", "");
                            Intrinsics.checkNotNullExpressionValue(string2, "");
                            str = string2;
                        }
                        KClassImpl$Data$declaredNonStaticMembers$2(str, p0 != null ? (SocialLinkModel) p0.getParcelable("socilaLink") : null);
                        return true;
                    }
                    break;
                case 98629247:
                    if (string.equals("group")) {
                        PlaceComponentResult(TrackerKey.SendMoneyProperties.SEND_MONEY_PAGE);
                        return true;
                    }
                    break;
                case 1107020974:
                    if (string.equals("globalTransfer")) {
                        BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.SEND_MONEY_PAGE);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SendMoneyScenarioDirector sendMoneyScenarioDirector, RecipientModel recipientModel) {
        if (!TextUtils.isEmpty(sendMoneyScenarioDirector.BuiltInFictitiousFunctionClassFactory)) {
            recipientModel.PrepareContext = sendMoneyScenarioDirector.BuiltInFictitiousFunctionClassFactory;
        }
        recipientModel.B = "send_money";
        Intent intentClassWithTracking = sendMoneyScenarioDirector.PlaceComponentResult.getIntentClassWithTracking(SummaryActivity.class);
        intentClassWithTracking.putExtra("data", recipientModel);
        intentClassWithTracking.putExtra("transferScenario", "send_money");
        sendMoneyScenarioDirector.PlaceComponentResult.startActivity(intentClassWithTracking);
    }
}
