package com.alibaba.ariver.kernel.api.track;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class EventTrackStore {
    public final Map<String, Object> fullLinkAttrMap = new ConcurrentHashMap();
    public final Map<String, Object> whiteScreenAttrMap = new ConcurrentHashMap();
    public final JSAPICallDict jsapiCallDict = new JSAPICallDict();
    public final Map<String, Object> fullLinkRequestMap = new ConcurrentHashMap();
    public final Map<String, Object> fullLinkOriginalUrlMap = new ConcurrentHashMap();
    public final List<String> urlList = new ArrayList();
    public String pageToken = null;
    public boolean isShowLoading = false;
    public boolean hasScriptChecked = false;
    public boolean mainDocLoadFinish = false;
    public boolean hasLogPageAbnormal = false;
    public boolean hasGotEmbedWebView = false;
    public boolean hasReceviedNBComponentRenderMsg = false;
    public boolean hasLoadHoistEmbedWebView = false;
    public boolean hasGotLoadHoistEmbedWebViewSrc = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f6112a = false;
    public Map<String, Object> hasFindPageAbnormal = new ConcurrentHashMap();
    private int b = 15;

    public boolean apiCallIsFull() {
        if (!this.f6112a) {
            this.f6112a = true;
            int i = JSONUtils.getInt(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONObject("h5_fltConfig"), "apiCallCount", 0);
            if (i > 0) {
                this.b = i;
            }
        }
        return this.jsapiCallDict.size() >= this.b;
    }
}
