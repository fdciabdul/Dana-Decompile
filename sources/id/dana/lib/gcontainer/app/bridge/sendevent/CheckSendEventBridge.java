package id.dana.lib.gcontainer.app.bridge.sendevent;

import android.content.Context;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.lib.gcontainer.GContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/sendevent/CheckSendEventBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "checkSendEvent", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "isEventValid", "(Landroid/content/Context;)Z", "<init>", "()V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CheckSendEventBridge extends SimpleBridgeExtension {
    private static final String AVAILABLE = "available";
    private static final String TAG = "CheckSendEventBridge";

    protected abstract boolean isEventValid(Context context);

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = true)
    public void checkSendEvent(@BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) AVAILABLE, (String) Boolean.valueOf(isEventValid(GContainer.getApplicationContext())));
        Unit unit = Unit.INSTANCE;
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
