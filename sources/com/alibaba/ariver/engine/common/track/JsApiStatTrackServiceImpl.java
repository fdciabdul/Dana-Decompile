package com.alibaba.ariver.engine.common.track;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService;
import com.alibaba.ariver.engine.common.track.JsApiStatTrackStore;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class JsApiStatTrackServiceImpl implements RVJsStatTrackService {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f6046a = Collections.synchronizedList(new ArrayList());
    public boolean sEnableTinyAppJsApiStat;

    public JsApiStatTrackServiceImpl() {
        this.sEnableTinyAppJsApiStat = false;
        List<String> a2 = a();
        if (a2 != null) {
            this.f6046a.addAll(a2);
        }
        this.sEnableTinyAppJsApiStat = this.f6046a.size() > 0;
    }

    private List<String> a() {
        String[] split;
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        String configWithProcessCache = rVConfigService != null ? rVConfigService.getConfigWithProcessCache("tinyapp_jsapi_whitelist_for_monitor", "") : null;
        if (TextUtils.isEmpty(configWithProcessCache) || (split = configWithProcessCache.split("\\|")) == null) {
            return null;
        }
        if (split.length == 1 && "no".equalsIgnoreCase(split[0])) {
            return Collections.emptyList();
        }
        return Arrays.asList(split);
    }

    private boolean a(NativeCallContext nativeCallContext) {
        try {
            if (this.sEnableTinyAppJsApiStat && nativeCallContext != null && (nativeCallContext.getNode() instanceof Page) && ((Page) nativeCallContext.getNode()).getApp() != null && ((Page) nativeCallContext.getNode()).getApp().isTinyApp() && ((Page) nativeCallContext.getNode()).getApp().isFirstPage()) {
                return this.f6046a.contains(nativeCallContext.getName());
            }
            return false;
        } catch (Throwable th) {
            RVLogger.e("AriverEngine:JsApiStatTrackServcieImpl", "recordJsApiInfoIfNeeded exception", th);
            return false;
        }
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService
    public void onCallDispatch(NativeCallContext nativeCallContext) {
        if (a(nativeCallContext)) {
            try {
                JsApiStatTrackStore jsApiStatTrackStore = (JsApiStatTrackStore) ((Page) nativeCallContext.getNode()).getData(JsApiStatTrackStore.class, true);
                if (jsApiStatTrackStore.isJsApiDetail4TinyWithinT2Uploaded()) {
                    return;
                }
                JsApiStatTrackStore.TinyAppJsApiStatInfo tinyAppJsApiStatInfo = (JsApiStatTrackStore.TinyAppJsApiStatInfo) jsApiStatTrackStore.jsapiStatMap.get(nativeCallContext.getId());
                if (tinyAppJsApiStatInfo == null) {
                    tinyAppJsApiStatInfo = new JsApiStatTrackStore.TinyAppJsApiStatInfo(nativeCallContext.getName());
                    jsApiStatTrackStore.jsapiStatMap.put(nativeCallContext.getId(), tinyAppJsApiStatInfo);
                }
                tinyAppJsApiStatInfo.callTs = System.currentTimeMillis();
            } catch (Throwable th) {
                RVLogger.e("AriverEngine:JsApiStatTrackServcieImpl", "onCallDispatch exception", th);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService
    public void onBeginDispatch(NativeCallContext nativeCallContext) {
        if (a(nativeCallContext)) {
            try {
                JsApiStatTrackStore jsApiStatTrackStore = (JsApiStatTrackStore) ((Page) nativeCallContext.getNode()).getData(JsApiStatTrackStore.class, true);
                if (jsApiStatTrackStore.isJsApiDetail4TinyWithinT2Uploaded()) {
                    return;
                }
                JsApiStatTrackStore.TinyAppJsApiStatInfo tinyAppJsApiStatInfo = (JsApiStatTrackStore.TinyAppJsApiStatInfo) jsApiStatTrackStore.jsapiStatMap.get(nativeCallContext.getId());
                if (tinyAppJsApiStatInfo == null) {
                    tinyAppJsApiStatInfo = new JsApiStatTrackStore.TinyAppJsApiStatInfo(nativeCallContext.getName());
                    jsApiStatTrackStore.jsapiStatMap.put(nativeCallContext.getId(), tinyAppJsApiStatInfo);
                }
                tinyAppJsApiStatInfo.beginDispatchTs = System.currentTimeMillis();
            } catch (Throwable th) {
                RVLogger.e("AriverEngine:JsApiStatTrackServcieImpl", "onInvoke exception", th);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService
    public void onDispatchOnMain(NativeCallContext nativeCallContext) {
        JsApiStatTrackStore.TinyAppJsApiStatInfo tinyAppJsApiStatInfo;
        if (a(nativeCallContext)) {
            try {
                JsApiStatTrackStore jsApiStatTrackStore = (JsApiStatTrackStore) ((Page) nativeCallContext.getNode()).getData(JsApiStatTrackStore.class, true);
                if (jsApiStatTrackStore.isJsApiDetail4TinyWithinT2Uploaded() || (tinyAppJsApiStatInfo = (JsApiStatTrackStore.TinyAppJsApiStatInfo) jsApiStatTrackStore.jsapiStatMap.get(nativeCallContext.getId())) == null) {
                    return;
                }
                tinyAppJsApiStatInfo.dispatchInMainTs = System.currentTimeMillis();
            } catch (Throwable th) {
                RVLogger.e("AriverEngine:JsApiStatTrackServcieImpl", "onInvoke exception", th);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService
    public void onInvoke(NativeCallContext nativeCallContext) {
        JsApiStatTrackStore.TinyAppJsApiStatInfo tinyAppJsApiStatInfo;
        if (a(nativeCallContext)) {
            try {
                JsApiStatTrackStore jsApiStatTrackStore = (JsApiStatTrackStore) ((Page) nativeCallContext.getNode()).getData(JsApiStatTrackStore.class, true);
                if (jsApiStatTrackStore.isJsApiDetail4TinyWithinT2Uploaded() || (tinyAppJsApiStatInfo = (JsApiStatTrackStore.TinyAppJsApiStatInfo) jsApiStatTrackStore.jsapiStatMap.get(nativeCallContext.getId())) == null) {
                    return;
                }
                tinyAppJsApiStatInfo.invokeTs = System.currentTimeMillis();
            } catch (Throwable th) {
                RVLogger.e("AriverEngine:JsApiStatTrackServcieImpl", "onInvoke exception", th);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService
    public void onSendBack(NativeCallContext nativeCallContext) {
        JsApiStatTrackStore.TinyAppJsApiStatInfo tinyAppJsApiStatInfo;
        long j;
        if (a(nativeCallContext)) {
            try {
                JsApiStatTrackStore jsApiStatTrackStore = (JsApiStatTrackStore) ((Page) nativeCallContext.getNode()).getData(JsApiStatTrackStore.class, true);
                if (jsApiStatTrackStore.isJsApiDetail4TinyWithinT2Uploaded() || (tinyAppJsApiStatInfo = (JsApiStatTrackStore.TinyAppJsApiStatInfo) jsApiStatTrackStore.jsapiStatMap.get(nativeCallContext.getId())) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = tinyAppJsApiStatInfo.callTs;
                long j3 = tinyAppJsApiStatInfo.invokeTs;
                long j4 = tinyAppJsApiStatInfo.callTs;
                long j5 = 0;
                if (tinyAppJsApiStatInfo.beginDispatchTs > 0) {
                    j = elapsedRealtime;
                    if (tinyAppJsApiStatInfo.dispatchInMainTs > tinyAppJsApiStatInfo.beginDispatchTs) {
                        j5 = tinyAppJsApiStatInfo.dispatchInMainTs - tinyAppJsApiStatInfo.beginDispatchTs;
                    }
                } else {
                    j = elapsedRealtime;
                }
                jsApiStatTrackStore.appendJsApiDetail4TinyWithT2(tinyAppJsApiStatInfo.name, currentTimeMillis - j2, j3 - j4, currentTimeMillis, j, j5);
            } catch (Throwable th) {
                RVLogger.e("AriverEngine:JsApiStatTrackServcieImpl", "onSendBack exception", th);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService
    public void writeJsApiStatToMap(Node node, Map<String, String> map) {
        if (!this.sEnableTinyAppJsApiStat || map == null || node == null || !(node instanceof Page)) {
            return;
        }
        try {
            JsApiStatTrackStore jsApiStatTrackStore = (JsApiStatTrackStore) ((Page) node).getData(JsApiStatTrackStore.class, false);
            if (jsApiStatTrackStore != null) {
                String jsApiDetail4TinyWithT2 = jsApiStatTrackStore.getJsApiDetail4TinyWithT2();
                if (TextUtils.isEmpty(jsApiDetail4TinyWithT2)) {
                    return;
                }
                map.put("tinyapp_jsapi_stat_within_t2", jsApiDetail4TinyWithT2);
                if (RVKernelUtils.isDebug()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("tinyapp_jsapi_stat_within_t2: ");
                    sb.append(jsApiDetail4TinyWithT2);
                    RVLogger.d("AriverEngine:JsApiStatTrackServcieImpl", sb.toString());
                }
                jsApiStatTrackStore.setJsApiDetail4TinyWithinT2Uploaded(true);
                jsApiStatTrackStore.clear();
            }
        } catch (Throwable th) {
            RVLogger.e("AriverEngine:JsApiStatTrackServcieImpl", "writeJsApiStatToMap exception", th);
        }
    }
}
