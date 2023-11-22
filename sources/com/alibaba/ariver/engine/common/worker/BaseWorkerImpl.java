package com.alibaba.ariver.engine.common.worker;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.rome.longlinkservice.LongLinkMsgConstants;
import com.iap.ac.android.container.constant.ContainerKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class BaseWorkerImpl implements Worker {
    private HandlerThread b;
    private Handler c;
    public String mAppId;
    protected boolean mDestroyed;
    protected boolean mPreStarted;
    protected List<RenderReadyListener> mRenderReadyListeners;
    protected Bundle mStartupParams;
    public String mWorkerId;
    protected List<Worker.WorkerReadyListener> mWorkerReadyListeners;
    protected volatile boolean mWorkerReady = false;
    protected volatile boolean mRenderReady = false;
    protected boolean mAlipayJSBridgeReady = false;
    protected String mAppxVersionInWorker = null;

    /* renamed from: a */
    private final Object f6048a = new Object();
    private int d = 0;

    /* loaded from: classes6.dex */
    public interface RenderReadyListener {
        void onRenderReady();
    }

    protected abstract String getLogTag();

    @Override // com.alibaba.ariver.engine.api.Worker
    public void loadPlugin(String str) {
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public abstract void sendMessageToWorker(String str, String str2, String str3, SendToWorkerCallback sendToWorkerCallback);

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void setWorkerId(String str) {
        this.mWorkerId = str;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public String getWorkerId() {
        return this.mWorkerId;
    }

    public void setAppxVersionInWorker(String str) {
        this.mAppxVersionInWorker = str;
    }

    public String getAppxVersionInWorker() {
        return this.mAppxVersionInWorker;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public Handler getWorkerHandler() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ariver-post-message-");
                    int i = this.d;
                    this.d = i + 1;
                    sb.append(i);
                    HandlerThread handlerThread = new HandlerThread(sb.toString(), 5);
                    this.b = handlerThread;
                    handlerThread.start();
                    this.c = new Handler(this.b.getLooper());
                }
            }
        }
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public boolean isWorkerReady() {
        return this.mWorkerReady;
    }

    public boolean isRenderReady() {
        return this.mRenderReady;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void setStartupParams(Bundle bundle) {
        this.mStartupParams = (Bundle) bundle.clone();
    }

    public Bundle getStartupParams() {
        return this.mStartupParams;
    }

    public boolean isPrestarted() {
        return this.mPreStarted;
    }

    public void onAlipayJSBridgeReady() {
        RVLogger.d(getLogTag(), "onAlipayJSBridgeReady");
        this.mAlipayJSBridgeReady = true;
        tryToInjectStartupParamsAndPushWorker();
    }

    public void setWorkerReady() {
        List<Worker.WorkerReadyListener> list;
        RVLogger.e(getLogTag(), "setWorkerReady");
        synchronized (this.f6048a) {
            this.mWorkerReady = true;
            list = this.mWorkerReadyListeners;
            this.mWorkerReadyListeners = null;
        }
        if (list != null) {
            Iterator<Worker.WorkerReadyListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onWorkerReady();
            }
            list.clear();
        }
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void setRenderReady() {
        List<RenderReadyListener> list;
        RVLogger.e(getLogTag(), "setRenderReady");
        synchronized (this.f6048a) {
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

    @Override // com.alibaba.ariver.engine.api.Worker
    public void registerWorkerReadyListener(Worker.WorkerReadyListener workerReadyListener) {
        boolean z;
        synchronized (this.f6048a) {
            if (this.mWorkerReady) {
                z = true;
            } else {
                if (this.mWorkerReadyListeners == null) {
                    this.mWorkerReadyListeners = new ArrayList();
                }
                if (workerReadyListener != null && !this.mWorkerReadyListeners.contains(workerReadyListener)) {
                    this.mWorkerReadyListeners.add(workerReadyListener);
                }
                z = false;
            }
        }
        if (z) {
            workerReadyListener.onWorkerReady();
        }
    }

    public void registerRenderReadyListener(RenderReadyListener renderReadyListener) {
        boolean z;
        synchronized (this.f6048a) {
            if (this.mRenderReady) {
                z = true;
            } else {
                if (this.mRenderReadyListeners == null) {
                    this.mRenderReadyListeners = new ArrayList();
                }
                if (renderReadyListener != null && !this.mRenderReadyListeners.contains(renderReadyListener)) {
                    this.mRenderReadyListeners.add(renderReadyListener);
                }
                z = false;
            }
        }
        if (z) {
            renderReadyListener.onRenderReady();
        }
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void destroy() {
        synchronized (this.f6048a) {
            if (this.mDestroyed) {
                return;
            }
            this.mDestroyed = true;
            if (this.b != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.b.quitSafely();
                } else {
                    this.b.quit();
                }
            }
            List<Worker.WorkerReadyListener> list = this.mWorkerReadyListeners;
            if (list != null) {
                list.clear();
            }
            List<RenderReadyListener> list2 = this.mRenderReadyListeners;
            if (list2 != null) {
                list2.clear();
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public boolean isDestroyed() {
        boolean z;
        synchronized (this.f6048a) {
            z = this.mDestroyed;
        }
        return z;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void sendPushMessage(Render render, String str, JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback) {
        JSONObject jSONObject2;
        if (render == null || render.getPage() == null) {
            RVLogger.e(getLogTag(), "sendPushWorkMessage but render or render.getPage() == null");
            return;
        }
        Object currentUri = render.getCurrentUri();
        Object renderId = render.getRenderId();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("func", (Object) str);
        if (jSONObject != null) {
            try {
                jSONObject2 = jSONObject.getJSONObject("data");
            } catch (Throwable th) {
                RVLogger.e(getLogTag(), "data is not a jsonobj ", th);
                jSONObject2 = null;
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
                if (str.startsWith("syncMessage")) {
                    jSONObject2.put("syncMessage", (Object) jSONObject.getString("data"));
                }
                if (str.equalsIgnoreCase(RVEvents.NBCOMPONENT_CAMERA_ERROR)) {
                    JSONObject deepCopy = JSONUtils.deepCopy(jSONObject2);
                    deepCopy.putAll(jSONObject);
                    jSONObject2 = deepCopy;
                }
                jSONObject.put("data", (Object) jSONObject2);
            } else if (str.equalsIgnoreCase(RVEvents.NBCOMPONENT_CAMERA_ERROR)) {
                jSONObject2 = JSONUtils.deepCopy(jSONObject2);
                jSONObject2.putAll(jSONObject);
            }
            jSONObject2.put("NBPageUrl", currentUri);
            jSONObject3.put("param", (Object) jSONObject);
        } else {
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("NBPageUrl", currentUri);
            jSONObject4.put("data", (Object) jSONObject5);
            jSONObject3.put("param", (Object) jSONObject4);
        }
        jSONObject3.put("viewId", renderId);
        jSONObject3.put(ContainerKeys.PARAM_PAGE_ID, Integer.valueOf(render.getPageId()));
        final JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("handlerName", LongLinkMsgConstants.MSG_PACKET_CHANNEL_PUSH);
        jSONObject6.put("data", (Object) jSONObject3);
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("sendPushMessage workerReady: ");
        sb.append(isWorkerReady());
        RVLogger.d(logTag, sb.toString());
        if (isWorkerReady()) {
            sendJsonToWorker(jSONObject6, sendToWorkerCallback);
        } else {
            registerWorkerReadyListener(new Worker.WorkerReadyListener() { // from class: com.alibaba.ariver.engine.common.worker.BaseWorkerImpl.1
                {
                    BaseWorkerImpl.this = this;
                }

                @Override // com.alibaba.ariver.engine.api.Worker.WorkerReadyListener
                public void onWorkerReady() {
                    BaseWorkerImpl.this.sendJsonToWorker(jSONObject6, sendToWorkerCallback);
                }
            });
        }
    }

    public void sendPushCallBack(String str, String str2, SendToWorkerCallback sendToWorkerCallback) {
        sendPushCallBack(null, str, str2, sendToWorkerCallback);
    }

    public void sendPushCallBack(JSONObject jSONObject, String str, String str2, SendToWorkerCallback sendToWorkerCallback) {
        if (sendToWorkerCallback != null) {
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
            String logTag = getLogTag();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sendPushCallBack...");
            sb2.append(jSONObject.toJSONString());
            RVLogger.d(logTag, sb2.toString());
            sendToWorkerCallback.onCallBack(jSONObject);
        }
    }

    public void sendMessageToWorker(String str, String str2, String str3) {
        sendMessageToWorker(str, str2, str3, null);
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void sendJsonToWorker(JSONObject jSONObject, SendToWorkerCallback sendToWorkerCallback) {
        sendMessageToWorker(getAppId(), "", jSONObject == null ? "" : jSONObject.toJSONString(), sendToWorkerCallback);
    }
}
