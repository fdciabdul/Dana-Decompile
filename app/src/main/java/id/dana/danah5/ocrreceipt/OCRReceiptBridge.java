package id.dana.danah5.ocrreceipt;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.constant.BridgeName;
import id.dana.ocr.views.OCRCameraActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u0015\u001a\u00020\n2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/danah5/ocrreceipt/OCRReceiptBridge;", "Lid/dana/danah5/ocrreceipt/BaseOCRBridge;", "", "getTag", "()Ljava/lang/String;", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/alibaba/fastjson/JSONObject;", "info", "", "isBackgroundProcess", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", BridgeName.RECOGNIZE_TEXT_MERCHANT_RECEIPT, "(Lcom/alibaba/fastjson/JSONObject;ZLcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "tryUploadOCRReceipt", "(Landroid/app/Activity;ZLcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OCRReceiptBridge extends BaseOCRBridge {
    private static final String TAG = "OCRReceiptBridge";

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void recognizeTextMerchantReceipt(@BindingParam(name = {"info"}) JSONObject info, @BindingParam(name = {"doImageProcessOnBackground"}) boolean isBackgroundProcess, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        handleOnMethodCalled(info, isBackgroundProcess, bridgeCallback, page);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        getOcrReceiptManager().onGetResult(requestCode, data);
    }

    @Override // id.dana.danah5.ocrreceipt.BaseOCRBridge
    public final String getTag() {
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "");
        return str;
    }

    @Override // id.dana.danah5.ocrreceipt.BaseOCRBridge
    public final void tryUploadOCRReceipt(Activity activity, boolean isBackgroundProcess, JSONObject info, BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        getOcrReceiptManager().setBridgeCallback(bridgeCallback);
        if (activity != null) {
            OCRCameraActivity.Companion companion = OCRCameraActivity.INSTANCE;
            startActivityForResult(activity, OCRCameraActivity.Companion.MyBillsEntityDataFactory(activity, createNewOCRRequestModel(info, isBackgroundProcess)), OCRCameraActivity.OCR_CAMERA_REQUEST_CODE);
        }
    }
}
