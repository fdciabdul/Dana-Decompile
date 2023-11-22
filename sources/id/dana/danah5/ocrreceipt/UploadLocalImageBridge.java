package id.dana.danah5.ocrreceipt;

import android.app.Activity;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.ocr.model.ReuploadReceiptTaskModel;
import id.dana.ocr.views.SnapReceiptService;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0012\u001a\u00020\r2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/danah5/ocrreceipt/UploadLocalImageBridge;", "Lid/dana/danah5/ocrreceipt/BaseOCRBridge;", "", "getTag", "()Ljava/lang/String;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", "isBackgroundProcess", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "tryUploadOCRReceipt", "(Landroid/app/Activity;ZLcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Lcom/alibaba/ariver/app/api/Page;", "page", "uploadLocalImage", "(Lcom/alibaba/fastjson/JSONObject;ZLcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UploadLocalImageBridge extends BaseOCRBridge {
    private static final String ACVITITY_NULL = "Activity is Null";
    private static final String TAG;

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void uploadLocalImage(@BindingParam(name = {"info"}) JSONObject info, @BindingParam(name = {"doImageProcessOnBackground"}) boolean isBackgroundProcess, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        handleOnMethodCalled(info, isBackgroundProcess, bridgeCallback, page);
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
        String obj = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        ReuploadReceiptTaskModel reuploadReceiptTaskModel = new ReuploadReceiptTaskModel(obj, null, createNewOCRRequestModel(info, isBackgroundProcess), 2, null);
        getOcrReceiptManager().setBridgeCallback(bridgeCallback);
        if (activity == null) {
            throw new OCRReceiptException(ACVITITY_NULL, "001");
        }
        SnapReceiptService.Companion companion = SnapReceiptService.INSTANCE;
        SnapReceiptService.Companion.getAuthRequestContext(activity, reuploadReceiptTaskModel);
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        TAG = companion.getClass().getSimpleName();
    }
}
