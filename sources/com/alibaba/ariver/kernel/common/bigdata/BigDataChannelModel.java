package com.alibaba.ariver.kernel.common.bigdata;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class BigDataChannelModel {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f6117a;
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private JSONObject h;
    private boolean i;
    private LinkedBlockingQueue<JSONObject> j;
    private IBigDataConsumerReadyCallback k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigDataChannelModel() {
        this.f6117a = new AtomicInteger(0);
        this.g = 0;
        this.i = true;
    }

    BigDataChannelModel(String str, int i, JSONObject jSONObject) {
        this.f6117a = new AtomicInteger(0);
        this.i = true;
        this.b = str;
        this.g = i;
        this.h = jSONObject;
        if (i > 0) {
            this.j = new LinkedBlockingQueue<>();
        }
    }

    String getChannelId() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setChannelId(String str) {
        this.b = str;
    }

    public String getViewId() {
        return this.d;
    }

    public void setViewId(String str) {
        this.d = str;
    }

    public String getWorkerId() {
        return this.c;
    }

    public void setWorkerId(String str) {
        this.c = str;
    }

    public int getBizType() {
        return this.e;
    }

    public void setBizType(int i) {
        this.e = i;
    }

    int getBufferSize() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBufferSize(int i) {
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPolicy() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPolicy(int i) {
        this.f = i;
    }

    public boolean isConsumerReady() {
        return this.i;
    }

    public void setConsumerReady(boolean z) {
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBigDataConsumerReadyCallback getCallback() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCallback(IBigDataConsumerReadyCallback iBigDataConsumerReadyCallback) {
        this.k = iBigDataConsumerReadyCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enqueueBuffer(JSONObject jSONObject) {
        if (this.f6117a.get() >= 10) {
            RVLogger.w("AriverKernel:BigDataChannelModel", "buffer size limit : 10");
            return;
        }
        try {
            this.j.put(jSONObject);
            this.f6117a.incrementAndGet();
        } catch (Throwable th) {
            RVLogger.e("AriverKernel:BigDataChannelModel", "enqueueBuffer exception, ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject getBufferedData() {
        LinkedBlockingQueue<JSONObject> linkedBlockingQueue = this.j;
        if (linkedBlockingQueue == null || linkedBlockingQueue.isEmpty()) {
            return null;
        }
        try {
            this.f6117a.decrementAndGet();
            return this.j.take();
        } catch (Throwable th) {
            RVLogger.e("AriverKernel:BigDataChannelModel", "getBufferedData exception, ", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseBuffer() {
        if (this.j != null) {
            this.h.clear();
        }
        this.j = null;
    }
}
