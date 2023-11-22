package com.alibaba.ariver.app.api.ui.fragment;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.embedview.EmbedViewProvider;
import com.alibaba.ariver.engine.api.embedview.IEmbedPerformance;
import com.alibaba.ariver.engine.api.embedview.IEmbedPerformanceReporter;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.fastjson.JSONObject;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes3.dex */
public class DefaultEmbedViewManager implements IEmbedViewManager {
    private Page d;

    /* renamed from: a */
    private final Map<String, IEmbedView> f5975a = new ConcurrentHashMap();
    private final List<IEmbedView> b = new ArrayList();
    private final List<String> c = new ArrayList();
    final Map<String, Queue<Render>> mRenderQueueMap = new ConcurrentHashMap();
    final Map<String, Queue<Message>> mMessageQueueMap = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Render {
        BridgeCallback callback;
        JSONObject data;

        private Render(JSONObject jSONObject, BridgeCallback bridgeCallback) {
            this.data = jSONObject;
            this.callback = bridgeCallback;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Message {
        String actionType;
        BridgeCallback bridgeCallback;
        JSONObject data;

        private Message(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
            this.actionType = str;
            this.data = jSONObject;
            this.bridgeCallback = bridgeCallback;
        }
    }

    public DefaultEmbedViewManager(Page page) {
        this.d = page;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public List<IEmbedView> findAllEmbedView() {
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public IEmbedView findViewById(String str) {
        return this.f5975a.get(str);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public void destroyView(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("destroyView viewId: ");
            sb.append(str);
            RVLogger.d("AriverApp:DefaultEmbedViewManager", sb.toString());
            IEmbedView remove = this.f5975a.remove(str);
            this.b.remove(remove);
            if (remove != null) {
                remove.onDestroy();
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("destroyView occurs error!");
            sb2.append(th.getMessage());
            RVLogger.e("AriverApp:DefaultEmbedViewManager", sb2.toString());
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public IEmbedView createView(String str, String str2) {
        IEmbedView iEmbedView;
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("createView for viewId: ");
            sb.append(str);
            sb.append(" type: ");
            sb.append(str2);
            RVLogger.d("AriverApp:DefaultEmbedViewManager", sb.toString());
            iEmbedView = this.f5975a.get(str);
            if (iEmbedView == null) {
                iEmbedView = ((EmbedViewProvider) RVProxy.get(EmbedViewProvider.class)).createEmbedView(str2);
                if (iEmbedView instanceof IEmbedPerformance) {
                    a(str2, (IEmbedPerformance) iEmbedView);
                }
                if (TextUtils.equals(str2, "newembedbase")) {
                    clearBaseView();
                    this.c.add(str);
                }
                HashMap hashMap = new HashMap();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.d.getApp().getNodeId());
                hashMap.put(RVConstants.EXTRA_APP_INSTANCE_ID, sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.d.getNodeId());
                hashMap.put(RVConstants.EXTRA_PAGE_INSTANCE_ID, sb3.toString());
                hashMap.put(RVConstants.EXTRA_EMBED_VIEW_ID, str);
                hashMap.put(RVConstants.EXTRA_APP_INFO_SCENE, BundleUtils.getString(this.d.getStartParams(), AppInfoScene.PARAM_SOURCE));
                if (TextUtils.equals(str2, "web-view-stub")) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(BundleUtils.getLong(this.d.getStartParams(), "shell_id"));
                    hashMap.put(RVConstants.EXTRA_SHELL_PAGE_ID, sb4.toString());
                }
                iEmbedView.onCreate(hashMap);
                synchronized (this.f5975a) {
                    this.f5975a.put(str, iEmbedView);
                    this.b.add(iEmbedView);
                    Queue<Render> remove = this.mRenderQueueMap.remove(str);
                    if (remove != null) {
                        for (Render render : remove) {
                            a(iEmbedView, render.data, render.callback);
                        }
                        remove.clear();
                    }
                    Queue<Message> remove2 = this.mMessageQueueMap.remove(str);
                    if (remove2 != null) {
                        for (Message message : remove2) {
                            a(iEmbedView, message.actionType, message.data, message.bridgeCallback);
                        }
                        remove2.clear();
                    }
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("elementid", (Object) str);
                EngineUtils.sendToRender(this.d.getRender(), RVEvents.NBCOMPONENT_CANRENDER, jSONObject, null);
            }
        }
        return iEmbedView;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public void dispatchRender(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        synchronized (this.f5975a) {
            IEmbedView findViewById = findViewById(str);
            if (findViewById == null) {
                Queue<Render> queue = this.mRenderQueueMap.get(str);
                if (queue == null) {
                    queue = new ArrayBlockingQueue<>(20);
                    this.mRenderQueueMap.put(str, queue);
                }
                queue.add(new Render(jSONObject, bridgeCallback));
                StringBuilder sb = new StringBuilder();
                sb.append("findViewById ");
                sb.append(str);
                sb.append(" null, just add to render queueMap!");
                RVLogger.d("AriverApp:DefaultEmbedViewManager", sb.toString());
                return;
            }
            a(findViewById, jSONObject, bridgeCallback);
        }
    }

    private void a(final IEmbedView iEmbedView, final JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.api.ui.fragment.DefaultEmbedViewManager.1
            {
                DefaultEmbedViewManager.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    iEmbedView.onReceivedRender(jSONObject, bridgeCallback);
                } catch (Throwable th) {
                    RVLogger.e("AriverApp:DefaultEmbedViewManager", "EmbedView dispatchOnReceivedRender exception: ", th);
                    BridgeCallback bridgeCallback2 = bridgeCallback;
                    StringBuilder sb = new StringBuilder();
                    sb.append("EmbedView onReceivedRender exception: ");
                    sb.append(th);
                    bridgeCallback2.sendBridgeResponse(new BridgeResponse.Error(5, sb.toString()));
                }
            }
        });
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public void dispatchSendMessage(String str, String str2, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        synchronized (this.f5975a) {
            IEmbedView findViewById = findViewById(str);
            if (findViewById == null) {
                Queue<Message> queue = this.mMessageQueueMap.get(str);
                if (queue == null) {
                    queue = new ArrayBlockingQueue<>(20);
                    this.mMessageQueueMap.put(str, queue);
                }
                queue.add(new Message(str2, jSONObject, bridgeCallback));
                StringBuilder sb = new StringBuilder();
                sb.append("findViewById ");
                sb.append(str);
                sb.append(" null, just add to message queueMap!");
                RVLogger.d("AriverApp:DefaultEmbedViewManager", sb.toString());
                return;
            }
            a(findViewById, str2, jSONObject, bridgeCallback);
        }
    }

    private void a(final IEmbedView iEmbedView, final String str, final JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.api.ui.fragment.DefaultEmbedViewManager.2
            {
                DefaultEmbedViewManager.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    iEmbedView.onReceivedMessage(str, jSONObject, bridgeCallback);
                } catch (Throwable th) {
                    RVLogger.e("AriverApp:DefaultEmbedViewManager", "EmbedView dispatchOnReceivedMessage exception: ", th);
                    BridgeCallback bridgeCallback2 = bridgeCallback;
                    StringBuilder sb = new StringBuilder();
                    sb.append("EmbedView onReceivedMessage exception: ");
                    sb.append(th);
                    bridgeCallback2.sendBridgeResponse(new BridgeResponse.Error(5, sb.toString()));
                }
            }
        });
    }

    private void a(final String str, IEmbedPerformance iEmbedPerformance) {
        final WeakReference weakReference = new WeakReference(this.d);
        final int hashCode = iEmbedPerformance.hashCode();
        iEmbedPerformance.setPerformanceReporter(new IEmbedPerformanceReporter() { // from class: com.alibaba.ariver.app.api.ui.fragment.DefaultEmbedViewManager.3
            {
                DefaultEmbedViewManager.this = this;
            }

            @Override // com.alibaba.ariver.engine.api.embedview.IEmbedPerformanceReporter
            public void onRenderFinished(long j) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("on render finished type=");
                    sb.append(str);
                    sb.append(", obj=");
                    sb.append(hashCode);
                    sb.append(",elapsedRealtime");
                    sb.append(j);
                    RVLogger.d("AriverApp:DefaultEmbedViewManager", sb.toString());
                    Page page = (Page) weakReference.get();
                    if (page == null || page.isExited() || page.isDestroyed()) {
                        return;
                    }
                    EventTracker eventTracker = (EventTracker) RVProxy.get(EventTracker.class);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("embed_view_");
                    sb2.append(str);
                    sb2.append("_");
                    sb2.append(hashCode);
                    eventTracker.stub(page, sb2.toString(), j);
                } catch (Throwable th) {
                    RVLogger.e("AriverApp:DefaultEmbedViewManager", " embed view render finished callback error!", th);
                }
            }
        });
    }

    public void clearBaseView() {
        if (this.f5975a.isEmpty() || this.c.isEmpty()) {
            return;
        }
        for (String str : this.c) {
            if (!TextUtils.isEmpty(str)) {
                IEmbedView iEmbedView = this.f5975a.get(str);
                this.f5975a.remove(str);
                this.b.remove(iEmbedView);
            }
        }
        this.c.clear();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        Iterator<IEmbedView> it = this.f5975a.values().iterator();
        while (it.hasNext()) {
            it.next().onRequestPermissionResult(i, strArr, iArr);
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public void releaseViews() {
        boolean isDebug;
        Iterator<IEmbedView> it = this.f5975a.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().onDestroy();
            } finally {
                if (!isDebug) {
                }
            }
        }
        this.b.clear();
        this.f5975a.clear();
        this.mRenderQueueMap.clear();
        this.mMessageQueueMap.clear();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public void triggerPreSnapshot() {
        try {
            Map<String, IEmbedView> map = this.f5975a;
            if (map == null || map.isEmpty()) {
                return;
            }
            Iterator<IEmbedView> it = this.f5975a.values().iterator();
            while (it.hasNext()) {
                it.next().triggerPreSnapshot();
            }
        } catch (Throwable th) {
            RVLogger.e("AriverApp:DefaultEmbedViewManager", "triggerPreSnapshot catch throwable ", th);
        }
    }
}
