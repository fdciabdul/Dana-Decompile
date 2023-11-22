package id.dana.danah5.qrisinfo;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import id.dana.animation.ScanQrLoyaltyActivity;
import id.dana.animation.enums.ScanQrLoyaltyErrorCodeEnum;
import id.dana.danah5.constant.BridgeName;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.utils.RandomInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014"}, d2 = {"Lid/dana/danah5/qrisinfo/GetNmidQrInfoBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "", BridgeName.GET_NMID_QR_INFO, "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "errorCode", "sendErrorResponse", "(Ljava/lang/String;)V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetNmidQrInfoBridge extends BaseBridge {
    public static final String GENERAL_ERROR = "001";
    private BridgeCallback bridgeCallback;
    private static final int SCAN_QR_LOYALTY_REQUEST_CODE = RandomInteger.BuiltInFictitiousFunctionClassFactory();

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void getNmidQR(@BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        this.bridgeCallback = bridgeCallback;
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        startActivityForResult(activity, new Intent(activity, ScanQrLoyaltyActivity.class), SCAN_QR_LOYALTY_REQUEST_CODE);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1 && requestCode == SCAN_QR_LOYALTY_REQUEST_CODE && data != null) {
            if (data.getBooleanExtra("success", false)) {
                BridgeCallback bridgeCallback = this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = jSONObject;
                jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
                jSONObject2.put((JSONObject) ScanQrLoyaltyActivity.KEY_NMID, data.getStringExtra(ScanQrLoyaltyActivity.KEY_NMID));
                bridgeCallback.sendJSONResponse(jSONObject);
                return;
            }
            String stringExtra = data.getStringExtra("errorCode");
            if (stringExtra == null) {
                stringExtra = ScanQrLoyaltyErrorCodeEnum.GENERAL_ERROR.getErrorCode();
            }
            Intrinsics.checkNotNullExpressionValue(stringExtra, "");
            sendErrorResponse(stringExtra);
            return;
        }
        sendErrorResponse("001");
    }

    private final void sendErrorResponse(String errorCode) {
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "errorCode", errorCode);
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
