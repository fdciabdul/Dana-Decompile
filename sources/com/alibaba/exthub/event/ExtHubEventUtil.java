package com.alibaba.exthub.event;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.exthub.base.ExtHubPage;
import com.alibaba.exthub.common.ExtHubLogger;
import com.alibaba.exthub.event.listener.ExtHubEventListener;
import com.alibaba.exthub.event.listener.ExtHubEventWithBizTypeListener;
import com.alibaba.fastjson.JSONObject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ExtHubEventUtil {
    public static void sendEvent(Page page, String str, JSONObject jSONObject, SendToRenderCallback sendToRenderCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (page == null) {
            ExtHubLogger.d("sendEvent page is null");
        } else if (page instanceof ExtHubPage) {
            StringBuilder sb = new StringBuilder();
            sb.append("send Native Event: ");
            sb.append(str);
            ExtHubLogger.d(sb.toString());
            sendNativeEvent(str, jSONObject);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("send Render Event: ");
            sb2.append(str);
            ExtHubLogger.d(sb2.toString());
            page.getRender().getRenderBridge().sendToRender(RenderCallContext.newBuilder(page.getRender()).type("call").action(str).param(jSONObject).build(), sendToRenderCallback, true);
        }
    }

    public static void sendNativeEvent(String str, JSONObject jSONObject) {
        List<ExtHubEventWithBizTypeListener> list;
        List<ExtHubEventListener> list2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, Map<String, List<ExtHubEventListener>>> activityEventMap = ExtHubEventManager.getInstance().getActivityEventMap();
        if (activityEventMap != null) {
            for (Map<String, List<ExtHubEventListener>> map : activityEventMap.values()) {
                if (map != null && (list2 = map.get(str)) != null) {
                    Iterator<ExtHubEventListener> it = list2.iterator();
                    while (it.hasNext()) {
                        it.next().onEvent(str, jSONObject);
                    }
                }
            }
        }
        Map<String, Map<String, List<ExtHubEventWithBizTypeListener>>> bizTypeEventMap = ExtHubEventManager.getInstance().getBizTypeEventMap();
        if (bizTypeEventMap != null) {
            for (String str2 : bizTypeEventMap.keySet()) {
                Map<String, List<ExtHubEventWithBizTypeListener>> map2 = bizTypeEventMap.get(str2);
                if (map2 != null && (list = map2.get(str)) != null) {
                    Iterator<ExtHubEventWithBizTypeListener> it2 = list.iterator();
                    while (it2.hasNext()) {
                        it2.next().onEvent(str2, str, jSONObject);
                    }
                }
            }
        }
    }
}
