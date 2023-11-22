package id.dana.lib.gcontainer.app.bridge.deviceinfo;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import id.dana.lib.gcontainer.GContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0010"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInformationBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "", "location", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "getDeviceInfo", "(Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Lcom/alibaba/fastjson/JSONObject;", "successResult", "getSuccessResult", "(Lcom/alibaba/fastjson/JSONObject;)Lcom/alibaba/fastjson/JSONObject;", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInformationManager;", "deviceManager", "handleAllInformation", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInformationManager;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "handleLocationInformation", "<init>", "()V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class DeviceInformationBridge extends SimpleBridgeExtension {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ILocationListener locationListener;

    @ThreadType(ExecutorType.IO)
    @ActionFilter(canOverride = false)
    public final void getDeviceInfo(@BindingParam(name = {"event"}) String location, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        DeviceInformationManager deviceInformationManager = new DeviceInformationManager(GContainer.getApplicationContext(), locationListener);
        if (Intrinsics.areEqual(location, "location")) {
            handleLocationInformation(deviceInformationManager, bridgeCallback);
        } else if (Intrinsics.areEqual(location, "all")) {
            handleAllInformation(deviceInformationManager, bridgeCallback);
        }
    }

    private final void handleAllInformation(DeviceInformationManager deviceManager, BridgeCallback bridgeCallback) {
        try {
            bridgeCallback.sendJSONResponse(getSuccessResult(deviceManager.assembleAllDeviceInfo()));
        } catch (Exception unused) {
            BridgeResponse bridgeResponse = BridgeResponse.UNKNOWN_ERROR;
            JSONObject jSONObject = bridgeResponse.get();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "");
            jSONObject.put((JSONObject) "success", (String) Boolean.FALSE);
            Unit unit = Unit.INSTANCE;
            bridgeCallback.sendBridgeResponse(bridgeResponse);
        }
    }

    private final void handleLocationInformation(DeviceInformationManager deviceManager, BridgeCallback bridgeCallback) {
        try {
            bridgeCallback.sendJSONResponse(getSuccessResult(deviceManager.assembleLocationDeviceInfo()));
        } catch (Exception unused) {
            BridgeResponse bridgeResponse = BridgeResponse.UNKNOWN_ERROR;
            JSONObject jSONObject = bridgeResponse.get();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "");
            jSONObject.put((JSONObject) "success", (String) Boolean.FALSE);
            Unit unit = Unit.INSTANCE;
            bridgeCallback.sendBridgeResponse(bridgeResponse);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInformationBridge$Companion;", "", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/ILocationListener;", "locationListener", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/ILocationListener;", "getLocationListener", "()Lid/dana/lib/gcontainer/app/bridge/deviceinfo/ILocationListener;", "setLocationListener", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/ILocationListener;)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getLocationListener")
        public final ILocationListener getLocationListener() {
            return DeviceInformationBridge.locationListener;
        }

        @JvmName(name = "setLocationListener")
        public final void setLocationListener(ILocationListener iLocationListener) {
            DeviceInformationBridge.locationListener = iLocationListener;
        }
    }

    private final JSONObject getSuccessResult(JSONObject successResult) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
        jSONObject2.put((JSONObject) "data", (String) successResult);
        return jSONObject;
    }
}
