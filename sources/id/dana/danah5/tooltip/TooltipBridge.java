package id.dana.danah5.tooltip;

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
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.tooltip.entity.ShowcaseEntity;
import id.dana.danah5.tooltip.entity.TooltipEntity;
import id.dana.danah5.tooltip.manager.TooltipPluginManager;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0015\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/danah5/tooltip/TooltipBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lid/dana/danah5/tooltip/manager/TooltipPluginManager;", "createTooltipPluginManager", "(Landroid/app/Activity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)Lid/dana/danah5/tooltip/manager/TooltipPluginManager;", "Lcom/alibaba/fastjson/JSONObject;", "info", "", "handleBottomSheet", "(Landroid/app/Activity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/fastjson/JSONObject;)Z", "", "handleShowcase", "(Landroid/app/Activity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/fastjson/JSONObject;)V", "", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/ariver/app/api/Page;", "page", "tooltip", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TooltipBridge extends SimpleBridgeExtension {
    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void tooltip(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        if (Intrinsics.areEqual(eventName, "bottomSheet")) {
            handleBottomSheet(activity, bridgeCallback, info);
        } else if (Intrinsics.areEqual(eventName, TooltipEvent.SHOW_CASE)) {
            handleShowcase(activity, bridgeCallback, info);
        }
    }

    private final void handleShowcase(Activity activity, BridgeCallback bridgeCallback, JSONObject info) {
        Object obj;
        TooltipPluginManager createTooltipPluginManager = createTooltipPluginManager(activity, bridgeCallback);
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<ShowcaseEntity>() { // from class: id.dana.danah5.tooltip.TooltipBridge$handleShowcase$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
            obj = null;
        }
        createTooltipPluginManager.openShowCase((ShowcaseEntity) obj);
    }

    private final boolean handleBottomSheet(Activity activity, BridgeCallback bridgeCallback, JSONObject info) {
        Object obj;
        TooltipPluginManager createTooltipPluginManager = createTooltipPluginManager(activity, bridgeCallback);
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<TooltipEntity>() { // from class: id.dana.danah5.tooltip.TooltipBridge$handleBottomSheet$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
            obj = null;
        }
        return createTooltipPluginManager.openBottomSheet((TooltipEntity) obj);
    }

    private final TooltipPluginManager createTooltipPluginManager(Activity activity, BridgeCallback bridgeCallback) {
        return new TooltipPluginManager(activity, bridgeCallback);
    }
}
