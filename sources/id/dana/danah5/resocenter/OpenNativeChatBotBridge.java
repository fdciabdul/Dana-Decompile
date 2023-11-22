package id.dana.danah5.resocenter;

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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yellowmessenger.ymchat.YMChat;
import com.yellowmessenger.ymchat.YMConfig;
import id.dana.R;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.constant.BridgeName;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.utils.OSUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ5\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013"}, d2 = {"Lid/dana/danah5/resocenter/OpenNativeChatBotBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "", BridgeName.OPEN_CHATBOT_NATIVE, "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "payload", "", "botId", OpenNativeChatBotBridge.YM_AUTHENTICATION_TOKEN, "openNativeChatBot", "(Landroid/app/Activity;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OpenNativeChatBotBridge extends SimpleBridgeExtension {
    private static final String BOT_ID = "bot";
    private static final String DANA_CUSTOM_BASE_URL = "https://r2.cloud.yellow.ai";
    private static final String PAYLOAD = "payload";
    private static final String SUCCESS = "success";
    private static final String YM_AUTHENTICATION_TOKEN = "ymAuthenticationToken";
    private BridgeCallback bridgeCallback;

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void openChatBot(@BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        this.bridgeCallback = bridgeCallback;
        Boolean bool = Boolean.FALSE;
        if (info == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) bool);
            bridgeCallback.sendJSONResponse(jSONObject);
        }
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        JSONObject jSONObject2 = info != null ? info.getJSONObject("payload") : null;
        String string = info != null ? info.getString(BOT_ID) : null;
        String str = string != null ? string : "";
        String string2 = info != null ? info.getString(YM_AUTHENTICATION_TOKEN) : null;
        if (OSUtil.scheduleImpl()) {
            openNativeChatBot(activity, jSONObject2, str, string2);
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("success", (Object) bool);
        bridgeCallback.sendJSONResponse(jSONObject3);
    }

    static /* synthetic */ void openNativeChatBot$default(OpenNativeChatBotBridge openNativeChatBotBridge, Activity activity, JSONObject jSONObject, String str, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        openNativeChatBotBridge.openNativeChatBot(activity, jSONObject, str, str2);
    }

    private final void openNativeChatBot(Activity activity, JSONObject payload, String botId, String ymAuthenticationToken) {
        YMChat KClassImpl$Data$declaredNonStaticMembers$2 = YMChat.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = new YMConfig(botId);
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = DANA_CUSTOM_BASE_URL;
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested = R.color.f23182131099816;
        if (ymAuthenticationToken != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance = ymAuthenticationToken;
        }
        if (payload != null) {
            Object fromJson = new Gson().fromJson(payload.toJSONString(), new TypeToken<HashMap<String, Object>>() { // from class: id.dana.danah5.resocenter.OpenNativeChatBotBridge$openNativeChatBot$mapObj$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "");
            HashMap<String, Object> hashMap = new HashMap<>();
            for (Map.Entry entry : ((Map) fromJson).entrySet()) {
                hashMap.put((String) entry.getKey(), entry.getValue());
            }
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp = hashMap;
        }
        try {
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(activity);
        } catch (Exception unused) {
            BridgeCallback bridgeCallback = this.bridgeCallback;
            if (bridgeCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                bridgeCallback = null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.FALSE);
            bridgeCallback.sendJSONResponse(jSONObject);
        }
    }
}
