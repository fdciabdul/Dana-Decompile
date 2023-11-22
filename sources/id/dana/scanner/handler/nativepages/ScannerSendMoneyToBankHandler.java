package id.dana.scanner.handler.nativepages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.DanaUrl;
import id.dana.domain.qrbarcode.DecodeQrBizType;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import id.dana.model.BizInfoBankModel;
import id.dana.model.BizInfoModel;
import id.dana.model.ScanModel;
import id.dana.scanner.handler.ScannerViewType;
import id.dana.sendmoney.model.QrRequestBankTransferModel;
import id.dana.sendmoney_v2.landing.SendMoneyActivity;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\n\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/scanner/handler/nativepages/ScannerSendMoneyToBankHandler;", "Lid/dana/scanner/handler/nativepages/BaseScannerNativePageHandler;", "", "PlaceComponentResult", "()V", "Landroid/content/Intent;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Intent;)V", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "Landroid/content/Context;", "Lid/dana/model/ScanModel;", "p1", "p2", "<init>", "(Landroid/content/Context;Lid/dana/model/ScanModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScannerSendMoneyToBankHandler extends BaseScannerNativePageHandler {
    public final String MyBillsEntityDataFactory;

    public ScannerSendMoneyToBankHandler(Context context, ScanModel scanModel, String str) {
        super(context, scanModel, str);
        this.MyBillsEntityDataFactory = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.scanner.handler.nativepages.BaseScannerNativePageHandler
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Intent p0) {
        Context KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
        Activity activity = (Activity) KClassImpl$Data$declaredNonStaticMembers$2;
        String str = this.MyBillsEntityDataFactory;
        if (Intrinsics.areEqual(str, ScannerViewType.ACTIVITY)) {
            activity.startActivity(p0);
            activity.finish();
        } else if (Intrinsics.areEqual(str, ScannerViewType.FRAGMENT)) {
            activity.startActivity(p0);
        }
    }

    @Override // id.dana.scanner.handler.ScannerActionHandler
    public final void PlaceComponentResult() {
        String str;
        ScanModel authRequestContext = getAuthRequestContext();
        BizInfoModel bizInfo = authRequestContext != null ? authRequestContext.getBizInfo() : null;
        BizInfoBankModel bizInfoBankModel = bizInfo instanceof BizInfoBankModel ? (BizInfoBankModel) bizInfo : null;
        String str2 = bizInfoBankModel != null ? bizInfoBankModel.BuiltInFictitiousFunctionClassFactory : null;
        String str3 = str2 == null ? "" : str2;
        String str4 = bizInfoBankModel != null ? bizInfoBankModel.MyBillsEntityDataFactory : null;
        String str5 = str4 == null ? "" : str4;
        String str6 = bizInfoBankModel != null ? bizInfoBankModel.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        String str7 = str6 == null ? "" : str6;
        String str8 = bizInfoBankModel != null ? bizInfoBankModel.getAuthRequestContext : null;
        String str9 = str8 == null ? "" : str8;
        String str10 = bizInfoBankModel != null ? bizInfoBankModel.scheduleImpl : null;
        String str11 = str10 == null ? "" : str10;
        String str12 = bizInfoBankModel != null ? bizInfoBankModel.moveToNextValue : null;
        String str13 = str12 == null ? "" : str12;
        String str14 = bizInfoBankModel != null ? bizInfoBankModel.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
        String str15 = str14 == null ? "" : str14;
        String str16 = bizInfoBankModel != null ? bizInfoBankModel.lookAheadTest : null;
        String str17 = str16 == null ? "" : str16;
        if (bizInfoBankModel != null) {
            String str18 = bizInfoBankModel.scheduleImpl;
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "");
            String lowerCase = str18.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            str = String.format(DanaUrl.BANK_ICON_URL, Arrays.copyOf(new Object[]{lowerCase}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "");
        } else {
            str = null;
        }
        String str19 = str == null ? "" : str;
        String str20 = bizInfoBankModel != null ? bizInfoBankModel.scheduleImpl : null;
        String str21 = str20 == null ? "" : str20;
        String str22 = bizInfoBankModel != null ? bizInfoBankModel.PlaceComponentResult : null;
        String str23 = str22 == null ? "" : str22;
        ScanModel authRequestContext2 = getAuthRequestContext();
        String bizType = authRequestContext2 != null ? authRequestContext2.getBizType() : null;
        QrRequestBankTransferModel qrRequestBankTransferModel = new QrRequestBankTransferModel(str21, str19, bizType == null ? "" : bizType, str23, null, null, null, str3, str5, str7, str9, str11, str13, str15, str17, 112, null);
        ScanModel authRequestContext3 = getAuthRequestContext();
        if (authRequestContext3 != null) {
            authRequestContext3.setSource((Intrinsics.areEqual(qrRequestBankTransferModel.moveToNextValue, DecodeQrBizType.TRANSFER_BANK_ACCOUNT_CODE) || NumberExtKt.toSafeInt(qrRequestBankTransferModel.PlaceComponentResult, 0) > 0) ? TrackerKey.SourceType.REQUEST_MONEY_TO_BANK_WITH_AMOUNT : TrackerKey.SourceType.REQUEST_MONEY_TO_BANK_WITHOUT_AMOUNT);
        }
        QrRequestBankTransferModel qrRequestBankTransferModel2 = qrRequestBankTransferModel;
        SendMoneyActivity.Companion companion = SendMoneyActivity.INSTANCE;
        Context KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        ScanModel authRequestContext4 = getAuthRequestContext();
        String source = authRequestContext4 != null ? authRequestContext4.getSource() : null;
        KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyActivity.Companion.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, qrRequestBankTransferModel2, "request_money", source != null ? source : "", BranchLinkConstant.ActionTarget.SEND_MONEY_BANK));
    }
}
