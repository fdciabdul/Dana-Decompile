package id.dana.lib.gcontainer.app.bridge.launchothersapp;

import android.content.Context;
import android.content.pm.PackageManager;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/launchothersapp/DirectMessageBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "directMessage", "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "", "errorType", "getErrorResult", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "isWhatsAppInstalled", "(Landroid/content/Context;)Z", "Lid/dana/lib/gcontainer/app/bridge/launchothersapp/DirectMessageEntity;", "directMessageEntity", "targetWhatsapp", "(Landroid/content/Context;Lid/dana/lib/gcontainer/app/bridge/launchothersapp/DirectMessageEntity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class DirectMessageBridge extends BaseBridge {
    private final void targetWhatsapp(Context context, DirectMessageEntity directMessageEntity, BridgeCallback bridgeCallback) {
        if (isWhatsAppInstalled(context)) {
            WhatsAppConversation whatsAppConversation = WhatsAppConversation.INSTANCE;
            String id2 = directMessageEntity.getId();
            if (id2 == null) {
                id2 = "";
            }
            String text = directMessageEntity.getText();
            whatsAppConversation.openApp(context, id2, text != null ? text : "", bridgeCallback);
            return;
        }
        bridgeCallback.sendJSONResponse(getErrorResult("003"));
    }

    private final boolean isWhatsAppInstalled(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.whatsapp", 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void directMessage(@BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback) {
        Object obj;
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<DirectMessageEntity>() { // from class: id.dana.lib.gcontainer.app.bridge.launchothersapp.DirectMessageBridge$directMessage$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
            obj = null;
        }
        DirectMessageEntity directMessageEntity = (DirectMessageEntity) obj;
        String id2 = directMessageEntity == null ? null : directMessageEntity.getId();
        if (!(id2 == null || id2.length() == 0)) {
            if (Intrinsics.areEqual(directMessageEntity != null ? directMessageEntity.getApplication() : null, "WHATSAPP")) {
                targetWhatsapp(GContainer.getApplicationContext(), directMessageEntity, bridgeCallback);
                return;
            }
        }
        bridgeCallback.sendJSONResponse(getErrorResult("002"));
    }

    private final JSONObject getErrorResult(String errorType) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        String str = "002";
        if (!Intrinsics.areEqual(errorType, "002")) {
            str = Intrinsics.areEqual(errorType, "003") ? "003" : "001";
        }
        jSONObject2.put((JSONObject) "error", str);
        return jSONObject;
    }
}
