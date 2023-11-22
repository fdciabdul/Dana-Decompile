package com.alibaba.griver.core.embedview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import androidx.core.util.Pair;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.api.H5BridgeContext;
import com.alibaba.griver.base.api.H5EmbededViewProvider;
import com.alibaba.griver.base.api.IH5EmbedView;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class H5EmbededViewProviderImpl implements H5EmbededViewProvider {
    private Context c;
    private Page d;

    /* renamed from: a */
    private final Map<String, List<Pair<H5BridgeContext, JSONObject>>> f6400a = new ConcurrentHashMap();
    private final Set<String> b = new HashSet<String>() { // from class: com.alibaba.griver.core.embedview.H5EmbededViewProviderImpl.1
        {
            H5EmbededViewProviderImpl.this = this;
            add("map");
            add("input");
        }
    };
    private Map<String, IH5EmbedView> e = new ConcurrentHashMap();
    private List<String> f = new ArrayList();

    public H5EmbededViewProviderImpl(Context context, Page page) {
        this.c = context;
        this.d = page;
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public void addPendingMessage(String str, H5BridgeContext h5BridgeContext, JSONObject jSONObject) {
        synchronized (this.f6400a) {
            List<Pair<H5BridgeContext, JSONObject>> list = this.f6400a.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.f6400a.put(str, list);
            }
            list.add(new Pair<>(h5BridgeContext, jSONObject));
        }
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public View getEmbedView(int i, int i2, String str, String str2, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("H5EmbededViewProviderImpl getEmbedView, viewId ");
        sb.append(str);
        sb.append(", mType ");
        sb.append(str2);
        GriverLogger.d("H5EmbededViewProviderImpl", sb.toString());
        if (map != null) {
            try {
                if (!map.isEmpty() && this.e != null) {
                    String str3 = map.get("type");
                    String a2 = a(str, map);
                    if (!this.e.containsKey(a2)) {
                        GriverLogger.d("H5EmbededViewProviderImpl", "H5EmbededViewProviderImpl getEmbedView init");
                        IH5EmbedView a3 = a(str3);
                        if (a3 != null) {
                            if (TextUtils.equals(str3, "newembedbase")) {
                                clearBaseView();
                                this.f.add(a2);
                            }
                            this.e.put(a2, a3);
                            View view = a3.getView(i, i2, str, str2, map);
                            Page page = this.d;
                            if (page != null && page.getRender() != null) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("elementid", (Object) a2);
                                EngineUtils.sendToRender(this.d.getRender(), RVEvents.NBCOMPONENT_CANRENDER, jSONObject, null);
                            }
                            if ("canvas".equals(str3)) {
                                a(a2, a3);
                            }
                            return view;
                        }
                    } else {
                        GriverLogger.d("H5EmbededViewProviderImpl", "H5EmbededViewProviderImpl getEmbedView reuse");
                        IH5EmbedView iH5EmbedView = this.e.get(a2);
                        if (this.b.contains(str3)) {
                            return iH5EmbedView.getSpecialRestoreView(i, i2, str, str2, map);
                        }
                        return iH5EmbedView.getView(i, i2, str, str2, map);
                    }
                }
            } catch (Throwable th) {
                GriverLogger.e("H5EmbededViewProviderImpl", "getEmbedView catch throwable ", th);
            }
        }
        return null;
    }

    private void a(String str, IH5EmbedView iH5EmbedView) {
        synchronized (this.f6400a) {
            List<Pair<H5BridgeContext, JSONObject>> remove = this.f6400a.remove(str);
            int size = remove == null ? 0 : remove.size();
            StringBuilder sb = new StringBuilder();
            sb.append("flushPendingMessages id: ");
            sb.append(str);
            sb.append(" size: ");
            sb.append(size);
            GriverLogger.d("H5EmbededViewProviderImpl", sb.toString());
            if (remove != null) {
                for (Pair<H5BridgeContext, JSONObject> pair : remove) {
                    String string = JSONUtils.getString(pair.PlaceComponentResult, "actionType");
                    JSONObject jSONObject = JSONUtils.getJSONObject(pair.PlaceComponentResult, "data", new JSONObject());
                    jSONObject.put(LottieParams.KEY_ELEMENT_ID, (Object) str);
                    iH5EmbedView.onReceivedMessage(string, jSONObject, pair.getAuthRequestContext);
                }
            }
        }
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public void onEmbedViewAttachedToWebView(int i, int i2, String str, String str2, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("H5EmbededViewProviderImpl onEmbedViewAttachedToWebView, viewId ");
        sb.append(str);
        sb.append(", mType ");
        sb.append(str2);
        GriverLogger.d("H5EmbededViewProviderImpl", sb.toString());
        if (map != null) {
            try {
                if (map.isEmpty() || this.e == null) {
                    return;
                }
                IH5EmbedView iH5EmbedView = this.e.get(a(str, map));
                if (iH5EmbedView != null) {
                    iH5EmbedView.onEmbedViewAttachedToWebView(i, i2, str, str2, map);
                }
            } catch (Throwable th) {
                GriverLogger.e("H5EmbededViewProviderImpl", "onEmbedViewAttachedToWebView catch throwable ", th);
            }
        }
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public void onEmbedViewDetachedFromWebView(int i, int i2, String str, String str2, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("H5EmbededViewProviderImpl onEmbedViewDetachedFromWebView, viewId ");
        sb.append(str);
        sb.append(", mType ");
        sb.append(str2);
        GriverLogger.d("H5EmbededViewProviderImpl", sb.toString());
        if (map != null) {
            try {
                if (map.isEmpty() || this.e == null) {
                    return;
                }
                IH5EmbedView iH5EmbedView = this.e.get(a(str, map));
                if (iH5EmbedView != null) {
                    iH5EmbedView.onEmbedViewDetachedFromWebView(i, i2, str, str2, map);
                }
            } catch (Throwable th) {
                GriverLogger.e("H5EmbededViewProviderImpl", "onEmbedViewDetachedFromWebView catch throwable ", th);
            }
        }
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public void onEmbedViewDestory(int i, int i2, String str, String str2, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("H5EmbededViewProviderImpl onEmbedViewDestory, viewId ");
        sb.append(str);
        sb.append(", mType ");
        sb.append(str2);
        GriverLogger.d("H5EmbededViewProviderImpl", sb.toString());
        if (map != null) {
            try {
                if (map.isEmpty() || this.e == null) {
                    return;
                }
                IH5EmbedView iH5EmbedView = this.e.get(a(str, map));
                if (iH5EmbedView != null) {
                    iH5EmbedView.onEmbedViewDestory(i, i2, str, str2, map);
                }
            } catch (Throwable th) {
                GriverLogger.e("H5EmbededViewProviderImpl", "onEmbedViewDestory catch throwable ", th);
            }
        }
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public void onEmbedViewParamChanged(int i, int i2, String str, String str2, Map<String, String> map, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append("H5EmbededViewProviderImpl onEmbedViewParamChanged, viewId ");
        sb.append(str);
        sb.append(", mType ");
        sb.append(str2);
        GriverLogger.d("H5EmbededViewProviderImpl", sb.toString());
        if (map != null) {
            try {
                if (map.isEmpty() || this.e == null) {
                    return;
                }
                IH5EmbedView iH5EmbedView = this.e.get(a(str, map));
                if (iH5EmbedView != null) {
                    iH5EmbedView.onEmbedViewParamChanged(i, i2, str, str2, map, strArr, strArr2);
                }
            } catch (Throwable th) {
                GriverLogger.e("H5EmbededViewProviderImpl", "onEmbedViewParamChanged catch throwable ", th);
            }
        }
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public void onEmbedViewVisibilityChanged(int i, int i2, String str, String str2, Map<String, String> map, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("H5EmbededViewProviderImpl onEmbedViewVisibilityChanged, viewId ");
        sb.append(str);
        sb.append(", mType ");
        sb.append(str2);
        GriverLogger.d("H5EmbededViewProviderImpl", sb.toString());
        if (map != null) {
            try {
                if (map.isEmpty() || this.e == null) {
                    return;
                }
                IH5EmbedView iH5EmbedView = this.e.get(a(str, map));
                if (iH5EmbedView != null) {
                    iH5EmbedView.onEmbedViewVisibilityChanged(i, i2, str, str2, map, i3);
                }
            } catch (Throwable th) {
                GriverLogger.e("H5EmbededViewProviderImpl", "onEmbedViewVisibilityChanged catch throwable ", th);
            }
        }
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public void onWebViewResume() {
        GriverLogger.d("H5EmbededViewProviderImpl", "H5EmbededViewProviderImpl onWebViewResume");
        try {
            Map<String, IH5EmbedView> map = this.e;
            if (map != null) {
                Iterator<String> it = map.keySet().iterator();
                while (it.hasNext()) {
                    IH5EmbedView iH5EmbedView = this.e.get(it.next());
                    if (iH5EmbedView != null) {
                        iH5EmbedView.onWebViewResume();
                    }
                }
            }
        } catch (Throwable th) {
            GriverLogger.e("H5EmbededViewProviderImpl", "onWebViewResume catch throwable ", th);
        }
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public void onWebViewPause() {
        GriverLogger.d("H5EmbededViewProviderImpl", "H5EmbededViewProviderImpl onWebViewPause");
        try {
            Map<String, IH5EmbedView> map = this.e;
            if (map != null) {
                Iterator<String> it = map.keySet().iterator();
                while (it.hasNext()) {
                    IH5EmbedView iH5EmbedView = this.e.get(it.next());
                    if (iH5EmbedView != null) {
                        iH5EmbedView.onWebViewPause();
                    }
                }
            }
        } catch (Throwable th) {
            GriverLogger.e("H5EmbededViewProviderImpl", "onWebViewPause catch throwable ", th);
        }
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public void onWebViewDestory() {
        GriverLogger.d("H5EmbededViewProviderImpl", "H5EmbededViewProviderImpl onWebViewDestory");
        try {
            Map<String, IH5EmbedView> map = this.e;
            if (map != null) {
                Iterator<String> it = map.keySet().iterator();
                while (it.hasNext()) {
                    IH5EmbedView iH5EmbedView = this.e.get(it.next());
                    if (iH5EmbedView != null) {
                        iH5EmbedView.onWebViewDestory();
                    }
                }
            }
        } catch (Throwable th) {
            GriverLogger.e("H5EmbededViewProviderImpl", "onWebViewDestory catch throwable ", th);
        }
    }

    private IH5EmbedView a(String str) {
        H5EmbedViewConfig config = H5EmbededViewConfigManager.getInstance().getConfig(str);
        if (config == null) {
            return null;
        }
        config.getBundleName();
        String className = config.getClassName();
        StringBuilder sb = new StringBuilder();
        sb.append("getEmbedViewWrapper reflect clazz == null ");
        sb.append(className);
        GriverLogger.w("H5EmbededViewProviderImpl", sb.toString());
        return null;
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public void releaseView() {
        GriverLogger.d("H5EmbededViewProviderImpl", "releaseView");
        synchronized (this.f6400a) {
            this.f6400a.clear();
        }
        this.e.clear();
        this.e = null;
        this.c = null;
        this.d = null;
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public void clearBaseView() {
        Map<String, IH5EmbedView> map = this.e;
        if (map == null || map.isEmpty() || this.f.isEmpty()) {
            return;
        }
        for (String str : this.f) {
            if (!TextUtils.isEmpty(str)) {
                this.e.remove(str);
            }
        }
        this.f.clear();
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        Map<String, IH5EmbedView> map = this.e;
        if (map != null) {
            Iterator<IH5EmbedView> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().onRequestPermissionResult(i, strArr, iArr);
            }
        }
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public IH5EmbedView getEmbedViewWrapperById(String str) {
        return this.e.get(str);
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public Bitmap getSnapshot(int i, int i2, String str, String str2, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("H5EmbededViewProviderImpl getSnapshot, viewId ");
        sb.append(str);
        sb.append(", mType ");
        sb.append(str2);
        GriverLogger.d("H5EmbededViewProviderImpl", sb.toString());
        if (map != null) {
            try {
                if (map.isEmpty()) {
                    return null;
                }
                IH5EmbedView iH5EmbedView = this.e.get(a(str, map));
                if (iH5EmbedView != null) {
                    return iH5EmbedView.getSnapshot(i, i2, str, str2, map);
                }
                return null;
            } catch (Throwable th) {
                GriverLogger.e("H5EmbededViewProviderImpl", "getSnapshot catch throwable ", th);
                return null;
            }
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.H5EmbededViewProvider
    public void triggerPreSnapshot() {
        try {
            Map<String, IH5EmbedView> map = this.e;
            if (map == null || map.isEmpty()) {
                return;
            }
            Iterator<IH5EmbedView> it = this.e.values().iterator();
            while (it.hasNext()) {
                it.next().triggerPreSnapshot();
            }
        } catch (Throwable th) {
            GriverLogger.e("H5EmbededViewProviderImpl", "triggerPreSnapshot catch throwable ", th);
        }
    }

    private String a(String str, Map<String, String> map) {
        String str2 = map.get("type");
        return (TextUtils.equals("TINY_COMPONENT", str2) || TextUtils.equals("newembedbase", str2)) ? str : map.get("id");
    }
}
