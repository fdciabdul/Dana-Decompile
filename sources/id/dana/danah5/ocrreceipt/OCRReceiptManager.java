package id.dana.danah5.ocrreceipt;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import id.dana.ocr.model.OCRRequestModel;
import id.dana.ocr.model.OCRResultModel;
import id.dana.ocr.views.OCRCameraActivity;
import id.dana.ocr.views.OCRPreviewImageActivity;
import id.dana.utils.foundation.logger.log.DanaLog;

/* loaded from: classes2.dex */
public class OCRReceiptManager {
    private static final String TAG = "OCRReceiptManager";
    private BridgeCallback bridgeCallback;
    private OCRRequestModel ocrRequestModel;

    public void onGetResult(int i, Intent intent) {
        BridgeCallback bridgeCallback;
        JSONObject jSONObject = null;
        try {
            if (i == 4103) {
                try {
                    OCRResultModel oCRResultModel = (OCRResultModel) intent.getParcelableExtra(OCRPreviewImageActivity.KEY_OCR_RESULT_MODEL);
                    if (oCRResultModel != null) {
                        OCRRequestModel oCRRequestModel = this.ocrRequestModel;
                        if (oCRRequestModel != null && oCRRequestModel.getPlaceComponentResult() && oCRResultModel.getLookAheadTest() && (bridgeCallback = this.bridgeCallback) != null) {
                            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                            BridgeCallback bridgeCallback2 = this.bridgeCallback;
                            if (bridgeCallback2 != null) {
                                bridgeCallback2.sendJSONResponse(null);
                                return;
                            }
                            return;
                        }
                        jSONObject = OCRReceiptResultMapper.mapResult(oCRResultModel);
                    }
                } catch (JSONException e) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory(TAG, e.getMessage());
                    JSONObject failedResult = OCRReceiptPluginResultFactory.getFailedResult("001");
                    BridgeCallback bridgeCallback3 = this.bridgeCallback;
                    if (bridgeCallback3 != null) {
                        bridgeCallback3.sendJSONResponse(failedResult);
                        return;
                    }
                    return;
                }
            }
            if (jSONObject == null) {
                jSONObject = OCRReceiptPluginResultFactory.getFailedResult("010");
            }
            BridgeCallback bridgeCallback4 = this.bridgeCallback;
            if (bridgeCallback4 != null) {
                bridgeCallback4.sendJSONResponse(jSONObject);
            }
        } catch (Throwable th) {
            BridgeCallback bridgeCallback5 = this.bridgeCallback;
            if (bridgeCallback5 != null) {
                bridgeCallback5.sendJSONResponse(null);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBridgeCallback(BridgeCallback bridgeCallback) {
        this.bridgeCallback = bridgeCallback;
    }

    void execute(Activity activity, OCRRequestModel oCRRequestModel) {
        this.ocrRequestModel = oCRRequestModel;
        OCRCameraActivity.openOCRCamera(activity, oCRRequestModel);
    }
}
