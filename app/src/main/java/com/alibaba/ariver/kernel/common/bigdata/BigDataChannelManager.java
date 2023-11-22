package com.alibaba.ariver.kernel.common.bigdata;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes6.dex */
public class BigDataChannelManager {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, BigDataChannelModel> f6116a;
    private Map<String, IBigDataChannelCallback> b;

    private BigDataChannelManager() {
        this.b = new ConcurrentHashMap();
        this.f6116a = new ConcurrentHashMap(8);
    }

    /* loaded from: classes6.dex */
    static class InstanceHolder {
        static BigDataChannelManager sInstance = new BigDataChannelManager();

        private InstanceHolder() {
        }
    }

    public static BigDataChannelManager getInstance() {
        return InstanceHolder.sInstance;
    }

    public void registerReceiveDataCallback(String str, IBigDataChannelCallback iBigDataChannelCallback) {
        this.b.put(str, iBigDataChannelCallback);
    }

    public String createDirectPassChannel(String str, String str2, int i, IBigDataConsumerReadyCallback iBigDataConsumerReadyCallback) {
        return createChannel(str, str2, i, 1, iBigDataConsumerReadyCallback);
    }

    public String createChannel(String str, String str2, int i, int i2) {
        return createChannel(str, str2, i, i2, null);
    }

    public String createChannel(String str, String str2, int i, int i2, IBigDataConsumerReadyCallback iBigDataConsumerReadyCallback) {
        return createChannelWithBuffer(str, str2, i, i2, 0, iBigDataConsumerReadyCallback);
    }

    public String createChannelWithBuffer(String str, String str2, int i, int i2, int i3) {
        return createChannelWithBuffer(str, str2, i, i2, 0, null);
    }

    public String createChannelWithBuffer(String str, String str2, int i, int i2, int i3, IBigDataConsumerReadyCallback iBigDataConsumerReadyCallback) {
        String obj = UUID.randomUUID().toString();
        BigDataChannelModel bigDataChannelModel = new BigDataChannelModel();
        bigDataChannelModel.setChannelId(obj);
        bigDataChannelModel.setWorkerId(str);
        bigDataChannelModel.setViewId(str2);
        bigDataChannelModel.setBizType(i);
        bigDataChannelModel.setBufferSize(i3);
        bigDataChannelModel.setPolicy(i2);
        bigDataChannelModel.setConsumerReady(true);
        bigDataChannelModel.setCallback(iBigDataConsumerReadyCallback);
        this.f6116a.put(obj, bigDataChannelModel);
        if (this.b.get(str) != null) {
            this.b.get(str).onChannelCreated(obj, str, str2);
        }
        return obj;
    }

    public void readyForNextData(String str, String str2) {
        BigDataChannelModel bigDataChannelModel;
        if (TextUtils.isEmpty(str)) {
            RVLogger.e("AriverKernel:BigDataChannelManager", "channel id is null");
            return;
        }
        Map<String, BigDataChannelModel> map = this.f6116a;
        if (map == null || (bigDataChannelModel = map.get(str)) == null) {
            return;
        }
        bigDataChannelModel.setConsumerReady(true);
        IBigDataConsumerReadyCallback callback = bigDataChannelModel.getCallback();
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channelId", (Object) str);
            jSONObject.put("viewId", (Object) str2);
            callback.onConsumerReady(jSONObject);
        }
    }

    public boolean isConsumerReady(String str) {
        BigDataChannelModel bigDataChannelModel;
        if (TextUtils.isEmpty(str)) {
            RVLogger.e("AriverKernel:BigDataChannelManager", "channel id is null");
            return false;
        }
        Map<String, BigDataChannelModel> map = this.f6116a;
        if (map == null || (bigDataChannelModel = map.get(str)) == null) {
            return false;
        }
        return bigDataChannelModel.isConsumerReady();
    }

    public void releaseChannelByChannelId(String str) {
        String str2;
        IBigDataChannelCallback iBigDataChannelCallback;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str2 = "";
        Map<String, BigDataChannelModel> map = this.f6116a;
        if (map != null) {
            BigDataChannelModel bigDataChannelModel = map.get(str);
            str2 = bigDataChannelModel != null ? bigDataChannelModel.getWorkerId() : "";
            this.f6116a.remove(str);
        }
        if (TextUtils.isEmpty(str2) || (iBigDataChannelCallback = this.b.get(str2)) == null) {
            return;
        }
        iBigDataChannelCallback.onChannelReleased(str);
    }

    public void releaseChannelByWorkerId(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str) || this.b.get(str) == null) {
            return;
        }
        this.b.remove(str);
    }

    public JSONObject pickNext(String str) {
        Map<String, BigDataChannelModel> map = this.f6116a;
        if (map == null || map.isEmpty()) {
            RVLogger.e("AriverKernel:BigDataChannelManager", "pickNext, no data");
            return null;
        }
        BigDataChannelModel bigDataChannelModel = this.f6116a.get(str);
        if (bigDataChannelModel == null) {
            RVLogger.e("AriverKernel:BigDataChannelManager", "pickNext, no channel");
            return null;
        }
        return bigDataChannelModel.getBufferedData();
    }

    public void pushData(String str, JSONObject jSONObject) {
        if (this.f6116a == null) {
            this.f6116a = new ConcurrentHashMap(8);
        }
        BigDataChannelModel bigDataChannelModel = this.f6116a.get(str);
        if (bigDataChannelModel == null) {
            RVLogger.e("AriverKernel:BigDataChannelManager", "please invoke createChannel first !!!");
            return;
        }
        if (!jSONObject.containsKey("channelId")) {
            jSONObject.put("channelId", (Object) str);
        }
        if (!jSONObject.containsKey("workerId")) {
            jSONObject.put("workerId", (Object) bigDataChannelModel.getWorkerId());
        }
        if (!jSONObject.containsKey("viewId")) {
            jSONObject.put("viewId", (Object) bigDataChannelModel.getViewId());
        }
        IBigDataChannelCallback iBigDataChannelCallback = this.b.get(bigDataChannelModel.getWorkerId());
        if (1 == bigDataChannelModel.getPolicy()) {
            if (iBigDataChannelCallback != null) {
                iBigDataChannelCallback.onReceiveData(jSONObject);
            }
        } else if (2 == bigDataChannelModel.getPolicy()) {
            bigDataChannelModel.enqueueBuffer(jSONObject);
        }
    }

    public void releaseAllChannel() {
        Map<String, BigDataChannelModel> map = this.f6116a;
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            BigDataChannelModel bigDataChannelModel = this.f6116a.get(str);
            if (bigDataChannelModel != null) {
                bigDataChannelModel.releaseBuffer();
            }
            IBigDataChannelCallback iBigDataChannelCallback = this.b.get(bigDataChannelModel.getWorkerId());
            if (iBigDataChannelCallback != null) {
                iBigDataChannelCallback.onChannelReleased(str);
            }
        }
        this.b.clear();
        this.f6116a.clear();
    }
}
