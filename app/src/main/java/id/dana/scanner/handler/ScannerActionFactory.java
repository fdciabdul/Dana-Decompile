package id.dana.scanner.handler;

import android.content.Context;
import id.dana.cashier.model.featureTime.FeatureTimeModel;
import id.dana.domain.qrbarcode.DecodeQrBizType;
import id.dana.model.ScanModel;
import id.dana.scanner.handler.h5pages.ScannerDefaultHandler;
import id.dana.scanner.handler.h5pages.ScannerH5EmvcoHandler;
import id.dana.scanner.handler.h5pages.ScannerH5MerchantHandler;
import id.dana.scanner.handler.h5pages.ScannerH5ParkingHandler;
import id.dana.scanner.handler.h5pages.ScannerH5TcicoQrHandler;
import id.dana.scanner.handler.h5pages.ScannerH5UserMerchantHandler;
import id.dana.scanner.handler.nativepages.ScannerAddPayerHandler;
import id.dana.scanner.handler.nativepages.ScannerCashierHandler;
import id.dana.scanner.handler.nativepages.ScannerH5GnMerchantHandler;
import id.dana.scanner.handler.nativepages.ScannerSendMoneyHandler;
import id.dana.scanner.handler.nativepages.ScannerSendMoneyToBankHandler;
import id.dana.scanner.handler.nativepages.ScannerSplitBillHandler;
import id.dana.utils.RandomInteger;
import id.dana.utils.danah5.DanaH5Listener;

/* loaded from: classes3.dex */
public class ScannerActionFactory {
    public static final int BuiltInFictitiousFunctionClassFactory = RandomInteger.BuiltInFictitiousFunctionClassFactory();
    private Context KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory = false;
    public boolean getAuthRequestContext = false;

    public ScannerActionFactory(Context context) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    public final ScannerActionHandler MyBillsEntityDataFactory(DanaH5Listener danaH5Listener, ScanModel scanModel, String str, String str2, FeatureTimeModel featureTimeModel) {
        if (getAuthRequestContext(scanModel)) {
            return new ScannerCashierHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, scanModel, str, this.getAuthRequestContext, featureTimeModel);
        }
        String bizType = scanModel.getBizType();
        bizType.hashCode();
        char c = 65535;
        switch (bizType.hashCode()) {
            case -1167020686:
                if (bizType.equals(DecodeQrBizType.EMVCO_CODE)) {
                    c = 0;
                    break;
                }
                break;
            case -1048821661:
                if (bizType.equals(DecodeQrBizType.EXTERNAL_CASH_IN_QR)) {
                    c = 1;
                    break;
                }
                break;
            case -922877266:
                if (bizType.equals(DecodeQrBizType.TRANSFER_BANK_ACCOUNT_CODE)) {
                    c = 2;
                    break;
                }
                break;
            case -724740381:
                if (bizType.equals(DecodeQrBizType.PROFILE_CODE)) {
                    c = 3;
                    break;
                }
                break;
            case -276560242:
                if (bizType.equals(DecodeQrBizType.USER_BANK_ACCOUNT_CODE)) {
                    c = 4;
                    break;
                }
                break;
            case 141637776:
                if (bizType.equals(DecodeQrBizType.USER_MERCHANT_CODE)) {
                    c = 5;
                    break;
                }
                break;
            case 203789441:
                if (bizType.equals(DecodeQrBizType.EXTERNAL_TRANSFER_QR)) {
                    c = 6;
                    break;
                }
                break;
            case 554049076:
                if (bizType.equals(DecodeQrBizType.PARKING_CODE)) {
                    c = 7;
                    break;
                }
                break;
            case 923238916:
                if (bizType.equals(DecodeQrBizType.MERCHANT_CODE)) {
                    c = '\b';
                    break;
                }
                break;
            case 1131344321:
                if (bizType.equals(DecodeQrBizType.TRANSFER_CODE)) {
                    c = '\t';
                    break;
                }
                break;
            case 1317723168:
                if (bizType.equals(DecodeQrBizType.SPLIT_BILL_CODE)) {
                    c = '\n';
                    break;
                }
                break;
            case 1609299090:
                if (bizType.equals(DecodeQrBizType.GN_AC_CODE)) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (this.MyBillsEntityDataFactory) {
                    return new ScannerCashierHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, scanModel, str, this.getAuthRequestContext, featureTimeModel);
                }
                return new ScannerH5EmvcoHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, danaH5Listener, scanModel);
            case 1:
            case 6:
                return new ScannerH5TcicoQrHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, danaH5Listener, scanModel, str);
            case 2:
            case 4:
                return new ScannerSendMoneyToBankHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, scanModel, str);
            case 3:
            case '\t':
                if ("split_bill".equals(str2)) {
                    return new ScannerAddPayerHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, scanModel, str);
                }
                if (ScannerFromViewType.FOUR_KINGKONG.equals(str2)) {
                    str = ScannerViewType.FRAGMENT;
                }
                return new ScannerSendMoneyHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, scanModel, str);
            case 5:
                return new ScannerH5UserMerchantHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, danaH5Listener, scanModel);
            case 7:
                return new ScannerH5ParkingHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, danaH5Listener, scanModel);
            case '\b':
                if (this.MyBillsEntityDataFactory) {
                    return new ScannerCashierHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, scanModel, str, this.getAuthRequestContext, featureTimeModel);
                }
                return new ScannerH5MerchantHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, danaH5Listener, scanModel);
            case '\n':
                return new ScannerSplitBillHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, scanModel, str);
            case 11:
                return new ScannerH5GnMerchantHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, scanModel, str);
            default:
                return PlaceComponentResult(scanModel, danaH5Listener);
        }
    }

    private ScannerActionHandler PlaceComponentResult(ScanModel scanModel, DanaH5Listener danaH5Listener) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(scanModel)) {
            return new ScannerDefaultHandler(this.KClassImpl$Data$declaredNonStaticMembers$2, danaH5Listener, scanModel);
        }
        return new ErrorScannerHandler(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(ScanModel scanModel) {
        return (scanModel.getBizInfo() == null || scanModel.getBizInfo().isLayoutRequested == null) ? false : true;
    }

    private static boolean getAuthRequestContext(ScanModel scanModel) {
        return scanModel.getNativelyDecodedQr() != null;
    }
}
