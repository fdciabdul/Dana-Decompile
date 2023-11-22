package id.dana.scanner.handler.nativepages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.qrbarcode.DecodeQrBizType;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import id.dana.model.BizInfoModel;
import id.dana.model.ScanModel;
import id.dana.requestmoney.RequestMoneyTrackingHelperKt;
import id.dana.scanner.handler.ScannerViewType;
import id.dana.sendmoney.model.QrTransferModel;
import id.dana.sendmoney_v2.landing.SendMoneyActivity;

/* loaded from: classes5.dex */
public class ScannerSendMoneyHandler extends BaseScannerNativePageHandler {
    Context MyBillsEntityDataFactory;
    String getAuthRequestContext;

    public ScannerSendMoneyHandler(Context context, ScanModel scanModel, String str) {
        super(context, scanModel, str);
        this.MyBillsEntityDataFactory = context;
        this.getAuthRequestContext = str;
    }

    @Override // id.dana.scanner.handler.ScannerActionHandler
    public final void PlaceComponentResult() {
        String str;
        BizInfoModel bizInfo = getAuthRequestContext().getBizInfo();
        QrTransferModel.Builder builder = new QrTransferModel.Builder();
        String str2 = bizInfo.scheduleImpl;
        if (str2 == null) {
            str2 = "";
        }
        builder.BuiltInFictitiousFunctionClassFactory = str2;
        String avatarUrl = getAuthRequestContext().getAvatarUrl();
        if (avatarUrl == null) {
            avatarUrl = "";
        }
        builder.MyBillsEntityDataFactory = avatarUrl;
        String str3 = bizInfo.initRecordTimeStamp;
        if (str3 == null) {
            str3 = "";
        }
        builder.getAuthRequestContext = str3;
        String mobileNumber = getAuthRequestContext().getMobileNumber();
        if (mobileNumber == null) {
            mobileNumber = "";
        }
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = mobileNumber;
        String nickname = getAuthRequestContext().getNickname();
        if (nickname == null) {
            nickname = "";
        }
        builder.getErrorConfigVersion = nickname;
        String receiverId = getAuthRequestContext().getReceiverId();
        if (receiverId == null) {
            receiverId = "";
        }
        builder.lookAheadTest = receiverId;
        String bizType = getAuthRequestContext().getBizType();
        builder.PlaceComponentResult = bizType != null ? bizType : "";
        QrTransferModel KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
        ScanModel authRequestContext = getAuthRequestContext();
        if (DecodeQrBizType.TRANSFER_CODE.equals(KClassImpl$Data$declaredNonStaticMembers$2.getBuiltInFictitiousFunctionClassFactory()) || getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.getKClassImpl$Data$declaredNonStaticMembers$2())) {
            str = TrackerKey.SourceType.REQUEST_MONEY_WITH_AMOUNT;
        } else {
            str = PlaceComponentResult(getAuthRequestContext().getBizInfo().NetworkUserEntityData$$ExternalSyntheticLambda6) ? TrackerKey.SourceType.REQUEST_MONEY_WITHOUT_AMOUNT : "Scan QR";
        }
        authRequestContext.setSource(str);
        SendMoneyActivity.Companion companion = SendMoneyActivity.INSTANCE;
        KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyActivity.Companion.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2(), KClassImpl$Data$declaredNonStaticMembers$2, "request_money", getAuthRequestContext().getSource()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // id.dana.scanner.handler.nativepages.BaseScannerNativePageHandler
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Intent intent) {
        String str;
        if (this.MyBillsEntityDataFactory == null || (str = this.getAuthRequestContext) == null || str.isEmpty()) {
            return;
        }
        Activity activity = (Activity) this.MyBillsEntityDataFactory;
        String str2 = this.getAuthRequestContext;
        str2.hashCode();
        if (str2.equals(ScannerViewType.ACTIVITY)) {
            activity.startActivity(intent);
            activity.finish();
        } else if (str2.equals(ScannerViewType.FRAGMENT)) {
            activity.startActivity(intent);
        }
    }

    private boolean PlaceComponentResult(String str) {
        return RequestMoneyTrackingHelperKt.PlaceComponentResult("request_money", str) || "request_money".equals(getAuthRequestContext().getSource());
    }

    private static boolean getAuthRequestContext(String str) {
        return !TextUtils.isEmpty(str) && NumberExtKt.toSafeInt(str, 0) > 0;
    }
}
