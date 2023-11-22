package com.alibaba.griver.core.worker;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.api.H5CallBack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class H5Worker {
    protected String mAppId;
    protected boolean mPreStarted;
    protected List<RenderReadyListener> mRenderReadyListeners;
    protected Bundle mStartupParams;
    protected String mWorkerId;
    protected List<WorkerReadyListener> mWorkerReadyListeners;
    protected boolean mWorkerReady = false;
    protected boolean mRenderReady = false;
    protected boolean mAlipayJSBridgeReady = false;
    protected boolean mDestroyed = false;
    protected String mAppxVersionInWorker = null;

    /* renamed from: a  reason: collision with root package name */
    private final Object f6494a = new Object();

    /* loaded from: classes6.dex */
    public interface RenderReadyListener {
        void onRenderReady();
    }

    /* loaded from: classes6.dex */
    public interface WorkerReadyListener {
        void onWorkerReady();
    }

    public boolean audit(String str, int i) {
        return true;
    }

    protected abstract String getLogTag();

    public abstract void sendMessageToWorker(String str, String str2, String str3, H5CallBack h5CallBack);

    protected abstract void tryToInjectStartupParamsAndPushWorker();

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public void setWorkerId(String str) {
        this.mWorkerId = str;
    }

    public String getWorkerId() {
        return this.mWorkerId;
    }

    public void setAppxVersionInWorker(String str) {
        this.mAppxVersionInWorker = str;
    }

    public String getAppxVersionInWorker() {
        return this.mAppxVersionInWorker;
    }

    public boolean isWorkerReady() {
        return this.mWorkerReady;
    }

    public boolean isRenderReady() {
        return this.mRenderReady;
    }

    public void setStartupParams(Bundle bundle) {
        this.mStartupParams = BundleUtils.clone(bundle);
    }

    public Bundle getStartupParams() {
        return this.mStartupParams;
    }

    public void preStart(String str, Bundle bundle) {
        if (this.mPreStarted) {
            return;
        }
        this.mPreStarted = true;
        setWorkerId(str);
        setStartupParams(bundle);
        tryToInjectStartupParamsAndPushWorker();
    }

    public boolean isPrestarted() {
        return this.mPreStarted;
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public void onAlipayJSBridgeReady() {
        RVLogger.d(getLogTag(), "onAlipayJSBridgeReady");
        this.mAlipayJSBridgeReady = true;
        tryToInjectStartupParamsAndPushWorker();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setWorkerReady() {
        List<WorkerReadyListener> list;
        RVLogger.e(getLogTag(), "setWorkerReady");
        synchronized (this.f6494a) {
            this.mWorkerReady = true;
            list = this.mWorkerReadyListeners;
            this.mWorkerReadyListeners = null;
        }
        if (list != null) {
            Iterator<WorkerReadyListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onWorkerReady();
            }
            list.clear();
        }
    }

    public void setRenderReady() {
        List<RenderReadyListener> list;
        RVLogger.e(getLogTag(), "setRenderReady");
        synchronized (this.f6494a) {
            this.mRenderReady = true;
            list = this.mRenderReadyListeners;
            this.mRenderReadyListeners = null;
        }
        if (list != null) {
            Iterator<RenderReadyListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onRenderReady();
            }
            list.clear();
        }
    }

    public void registerWorkerReadyListener(WorkerReadyListener workerReadyListener) {
        synchronized (this.f6494a) {
            if (this.mWorkerReadyListeners == null) {
                this.mWorkerReadyListeners = new ArrayList();
            }
            if (workerReadyListener != null && !this.mWorkerReadyListeners.contains(workerReadyListener)) {
                this.mWorkerReadyListeners.add(workerReadyListener);
            }
        }
    }

    public void registerRenderReadyListener(RenderReadyListener renderReadyListener) {
        synchronized (this.f6494a) {
            if (this.mRenderReadyListeners == null) {
                this.mRenderReadyListeners = new ArrayList();
            }
            if (renderReadyListener != null && !this.mRenderReadyListeners.contains(renderReadyListener)) {
                this.mRenderReadyListeners.add(renderReadyListener);
            }
        }
    }

    public void destroy() {
        synchronized (this.f6494a) {
            this.mDestroyed = true;
            List<WorkerReadyListener> list = this.mWorkerReadyListeners;
            if (list != null) {
                list.clear();
            }
            List<RenderReadyListener> list2 = this.mRenderReadyListeners;
            if (list2 != null) {
                list2.clear();
            }
        }
    }

    protected void sendPushCallBack(JSONObject jSONObject, String str, String str2, H5CallBack h5CallBack) {
        if (h5CallBack != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (TextUtils.isEmpty(str)) {
                str = this.mWorkerId;
            }
            jSONObject.put("appId", (Object) str);
            jSONObject.put("result", "0");
            if (TextUtils.isEmpty(str2)) {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                str2 = sb.toString();
            }
            jSONObject.put("messageId", (Object) str2);
            h5CallBack.onCallBack(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendPushCallBack(String str, String str2, H5CallBack h5CallBack) {
        sendPushCallBack(null, str, str2, h5CallBack);
    }

    public void sendMessageToWorker(String str, String str2, String str3) {
        sendMessageToWorker(str, str2, str3, null);
    }

    public void sendJsonToWorker(String str, String str2, JSONObject jSONObject) {
        sendJsonToWorker(str, str2, jSONObject, null);
    }

    public void sendJsonToWorker(String str, String str2, JSONObject jSONObject, H5CallBack h5CallBack) {
        sendMessageToWorker(str, str2, jSONObject == null ? "{}" : jSONObject.toJSONString(), h5CallBack);
    }
}
