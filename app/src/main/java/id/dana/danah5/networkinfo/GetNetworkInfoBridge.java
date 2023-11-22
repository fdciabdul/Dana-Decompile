package id.dana.danah5.networkinfo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.networkinfo.NetworkInfoResult;
import id.dana.lib.gcontainer.GContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00020\f2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/danah5/networkinfo/GetNetworkInfoBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/net/NetworkInfo;", "activeNetwork", "", "getCarrier", "(Landroid/content/Context;Landroid/net/NetworkInfo;)Ljava/lang/String;", "event", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", BridgeName.NETWORK_INFO, "(Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "getRadio", "(Landroid/net/NetworkInfo;)Ljava/lang/String;", "handleNetworkEvent", "(Landroid/content/Context;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetNetworkInfoBridge extends SimpleBridgeExtension {
    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void getNetworkInfo(@BindingParam(name = {"event"}) String event, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        if (event == null) {
            return;
        }
        Context applicationContext = GContainer.getApplicationContext();
        if (Intrinsics.areEqual(event, "network")) {
            handleNetworkEvent(applicationContext, bridgeCallback);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "error", "001");
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private final void handleNetworkEvent(Context context, BridgeCallback bridgeCallback) {
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            String carrier = getCarrier(context, activeNetworkInfo);
            String radio = getRadio(activeNetworkInfo);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
            StringBuilder sb = new StringBuilder();
            sb.append(Build.MANUFACTURER);
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(Build.MODEL);
            jSONObject.put((JSONObject) "data", (String) new NetworkInfoResult(new NetworkInfoResult.Network(carrier, radio, sb.toString())));
            bridgeCallback.sendJSONResponse(jSONObject);
        } catch (Exception unused) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = jSONObject2;
            jSONObject3.put((JSONObject) "success", (String) Boolean.FALSE);
            jSONObject3.put((JSONObject) "error", "001");
            bridgeCallback.sendJSONResponse(jSONObject2);
        }
    }

    private final String getCarrier(Context context, NetworkInfo activeNetwork) {
        Object systemService = context.getSystemService("phone");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        Integer valueOf = activeNetwork != null ? Integer.valueOf(activeNetwork.getType()) : null;
        if (valueOf == null || valueOf.intValue() != 1) {
            if (valueOf == null || valueOf.intValue() != 0) {
                return null;
            }
            return telephonyManager.getNetworkOperatorName();
        }
        return "WIFI";
    }

    private final String getRadio(NetworkInfo activeNetwork) {
        Integer valueOf = activeNetwork != null ? Integer.valueOf(activeNetwork.getType()) : null;
        if (valueOf == null || valueOf.intValue() != 1) {
            if (valueOf == null || valueOf.intValue() != 0) {
                return null;
            }
            return activeNetwork.getSubtypeName();
        }
        return "WIFI";
    }
}
