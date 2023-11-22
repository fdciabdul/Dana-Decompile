package com.alibaba.ariver.legacy.v8worker;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.kernel.common.bigdata.BigDataChannelManager;
import com.alibaba.ariver.kernel.common.bigdata.IBigDataChannelCallback;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.mobile.rome.longlinkservice.LongLinkMsgConstants;

/* loaded from: classes6.dex */
class BigDataChannelClient implements IBigDataChannelCallback {
    private static final String TAG = "V8Worker";
    String currentChannelId;
    String currentElementId;
    V8Worker mWorker;

    public BigDataChannelClient(V8Worker v8Worker) {
        this.mWorker = v8Worker;
    }

    @Override // com.alibaba.ariver.kernel.common.bigdata.IBigDataChannelCallback
    public void onReceiveData(JSONObject jSONObject) {
        if (this.currentElementId == null) {
            return;
        }
        String string = JSONUtils.getString(jSONObject, LottieParams.KEY_ELEMENT_ID, null);
        if (jSONObject == null || TextUtils.isEmpty(string) || !this.currentElementId.equals(string)) {
            return;
        }
        String string2 = JSONUtils.getString(jSONObject, "func", null);
        int i = JSONUtils.getInt(jSONObject, "viewId", 0);
        jSONObject.remove("viewId");
        jSONObject.remove("func");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("func", (Object) string2);
        jSONObject3.put("param", (Object) jSONObject2);
        jSONObject3.put("viewId", (Object) Integer.valueOf(i));
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("handlerName", (Object) LongLinkMsgConstants.MSG_PACKET_CHANNEL_PUSH);
        jSONObject4.put("data", (Object) jSONObject3);
        this.mWorker.sendJsonToWorker(jSONObject4, new SendToWorkerCallback() { // from class: com.alibaba.ariver.legacy.v8worker.BigDataChannelClient.1
            @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
            public void onCallBack(JSONObject jSONObject5) {
                if (BigDataChannelClient.this.currentChannelId == null || BigDataChannelClient.this.currentElementId == null) {
                    return;
                }
                BigDataChannelManager.getInstance().readyForNextData(BigDataChannelClient.this.currentChannelId, BigDataChannelClient.this.currentElementId);
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.common.bigdata.IBigDataChannelCallback
    public void onChannelCreated(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("onChannelCreated channelId: ");
        sb.append(str);
        sb.append(", workerId: ");
        sb.append(str2);
        sb.append(", elementId: ");
        sb.append(str3);
        RVLogger.d(TAG, sb.toString());
        if (this.mWorker.getWorkerId().equals(str2)) {
            this.currentChannelId = str;
            this.currentElementId = str3;
            BigDataChannelManager.getInstance().readyForNextData(this.currentChannelId, this.currentElementId);
            return;
        }
        this.currentChannelId = null;
        this.currentElementId = null;
    }

    @Override // com.alibaba.ariver.kernel.common.bigdata.IBigDataChannelCallback
    public void onChannelReleased(String str) {
        String str2 = this.currentChannelId;
        if (str2 == null || !str2.equals(str)) {
            return;
        }
        this.currentChannelId = null;
        this.currentElementId = null;
    }
}
