package id.dana.danah5.ocrreceipt;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import id.dana.ocr.model.OCRResultModel;
import id.dana.utils.BitmapUtil;
import id.dana.utils.foundation.logger.log.DanaLog;

/* loaded from: classes8.dex */
class OCRReceiptResultMapper {
    private static final String TAG = "OCRReceiptManager";

    private OCRReceiptResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject mapResult(OCRResultModel oCRResultModel) {
        String str = oCRResultModel.getAuthRequestContext;
        boolean lookAheadTest = oCRResultModel.getLookAheadTest();
        String PlaceComponentResult = BitmapUtil.PlaceComponentResult(oCRResultModel.KClassImpl$Data$declaredNonStaticMembers$2);
        if ((lookAheadTest || str.equals("004")) && TextUtils.isEmpty(PlaceComponentResult)) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(TAG, String.format("File not found or base64 encoding failed. Path : %1$s", oCRResultModel.KClassImpl$Data$declaredNonStaticMembers$2));
            str = "009";
            lookAheadTest = false;
        }
        OCRSuccessResult oCRSuccessResult = new OCRSuccessResult();
        oCRSuccessResult.setOrderId(oCRResultModel.BuiltInFictitiousFunctionClassFactory);
        oCRSuccessResult.setMerchantName(oCRResultModel.PlaceComponentResult);
        oCRSuccessResult.setOrderAmount(oCRResultModel.MyBillsEntityDataFactory);
        oCRSuccessResult.setTimestamp(oCRResultModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
        oCRSuccessResult.setReceipt(PlaceComponentResult);
        oCRSuccessResult.setRawText(oCRResultModel.getErrorConfigVersion);
        return OCRReceiptPluginResultFactory.getSuccessResult(lookAheadTest, str, oCRSuccessResult);
    }
}
