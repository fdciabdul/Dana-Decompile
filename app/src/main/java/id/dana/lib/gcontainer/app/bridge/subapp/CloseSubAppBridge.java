package id.dana.lib.gcontainer.app.bridge.subapp;

import android.app.Activity;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0007\u0010\r"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/subapp/CloseSubAppBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", "event", "", "closeSubApp", "(Landroid/app/Activity;Ljava/lang/String;)V", "Lcom/alibaba/ariver/app/api/Page;", "page", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class CloseSubAppBridge extends SimpleBridgeExtension {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean forceEventTop;

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void closeSubApp(@BindingNode(Page.class) Page page, @BindingParam(name = {"event"}) String event, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(event, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        if (!(event.length() == 0)) {
            Activity activity = BridgeExtensionExtKt.getActivity(page);
            if (activity == null) {
                return;
            }
            closeSubApp(activity, event);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "error", "001");
        Unit unit = Unit.INSTANCE;
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private final void closeSubApp(Activity r2, String event) {
        if (Intrinsics.areEqual(event, "top") || forceEventTop) {
            r2.finish();
        } else {
            GContainer.closeAllContainers();
        }
        forceEventTop = false;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/subapp/CloseSubAppBridge$Companion;", "", "", "forceEventTop", "Z", "getForceEventTop", "()Z", "setForceEventTop", "(Z)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getForceEventTop")
        public final boolean getForceEventTop() {
            return CloseSubAppBridge.forceEventTop;
        }

        @JvmName(name = "setForceEventTop")
        public final void setForceEventTop(boolean z) {
            CloseSubAppBridge.forceEventTop = z;
        }
    }
}
