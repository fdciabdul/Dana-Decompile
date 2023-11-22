package id.dana.lib.gcontainer.app.bridge.logging;

import android.content.Context;
import android.os.Build;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.common.utils.NetworkUtils;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.logger.DANALog;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/logging/H5GetLogInfoBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lcom/alibaba/fastjson/JSONObject;", "assembleLogInfo", "(Landroid/content/Context;)Lcom/alibaba/fastjson/JSONObject;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "getLogInfo", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class H5GetLogInfoBridge extends SimpleBridgeExtension {
    private static final String COMBINATION_DIVIDE = "^";
    private static final String COMBINATION_EQUALS = "=";
    public static final String RESULT_BRAND = "brand";
    public static final String RESULT_BUNDLE_VERSION = "bundleVersion";
    public static final String RESULT_DEVICE_ID = "deviceId";
    public static final String RESULT_MODEL = "model";
    public static final String RESULT_NETWORK = "network";
    public static final String RESULT_OS = "os";
    public static final String RESULT_SESSION_ID = "sessionId";
    public static final String RESULT_TIMEZONE = "TimeZone";
    public static final String TAG = "H5GetMonitorInfo";

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void getLogInfo(@BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        JSONObject assembleLogInfo = assembleLogInfo(GContainer.getApplicationContext());
        if (assembleLogInfo != null) {
            bridgeCallback.sendJSONResponse(assembleLogInfo);
            return;
        }
        BridgeResponse bridgeResponse = BridgeResponse.UNKNOWN_ERROR;
        JSONObject jSONObject = bridgeResponse.get();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "");
        jSONObject.put((JSONObject) "success", (String) Boolean.FALSE);
        Unit unit = Unit.INSTANCE;
        bridgeCallback.sendBridgeResponse(bridgeResponse);
    }

    private final JSONObject assembleLogInfo(Context r6) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
            jSONObject.put((JSONObject) "deviceId", LoggerFactory.getLogContext().getDeviceID());
            jSONObject.put((JSONObject) "sessionId", LoggerFactory.getLogContext().getSessionID());
            jSONObject.put((JSONObject) RESULT_MODEL, Build.MODEL);
            jSONObject.put((JSONObject) RESULT_OS, Build.VERSION.RELEASE);
            jSONObject.put((JSONObject) "network", NetworkUtils.getNetworkTypeString(r6));
            StringBuilder sb = new StringBuilder();
            sb.append(RESULT_TIMEZONE);
            sb.append("=");
            sb.append(TimeZone.getDefault().getID());
            sb.append(COMBINATION_DIVIDE);
            sb.append(RESULT_BRAND);
            sb.append("=");
            sb.append(Build.BRAND);
            jSONObject.put((JSONObject) RESULT_BUNDLE_VERSION, sb.toString());
            return jSONObject;
        } catch (Exception e) {
            DANALog.PlaceComponentResult(TAG, "assembleLogInfo", e);
            return null;
        }
    }
}
