package com.alibaba.ariver.ariverexthub.api;

import com.alibaba.ariver.ariverexthub.api.model.RVEApiInfo;
import com.alibaba.ariver.ariverexthub.api.model.RVEHandlerProcess;
import com.alibaba.ariver.ariverexthub.api.model.RVEHandlerScope;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class RVEApiConfig {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, RVEApiInfo> f5993a = new ConcurrentHashMap<>();

    public void handleApis(Map<List<String>, RVEApiInfo> map) {
        for (Map.Entry<List<String>, RVEApiInfo> entry : map.entrySet()) {
            Iterator<String> it = entry.getKey().iterator();
            while (it.hasNext()) {
                this.f5993a.put(it.next(), entry.getValue());
            }
        }
    }

    public RVEHandlerScope getScope(String str) {
        RVEApiInfo rVEApiInfo = this.f5993a.get(str);
        if (rVEApiInfo != null) {
            return rVEApiInfo.scope;
        }
        return RVEHandlerScope.Service;
    }

    public RVEHandlerProcess getApiProcess(String str) {
        RVEApiInfo rVEApiInfo = this.f5993a.get(str);
        if (rVEApiInfo != null) {
            return rVEApiInfo.process;
        }
        return RVEHandlerProcess.Normal;
    }

    public String getHandler(String str) {
        RVEApiInfo rVEApiInfo = this.f5993a.get(str);
        if (rVEApiInfo != null) {
            return rVEApiInfo.handlerName;
        }
        return null;
    }

    public boolean isApiCanuse(String str) {
        return this.f5993a.containsKey(str);
    }

    public RVEApiInfo getApiInfo(String str) {
        return this.f5993a.get(str);
    }
}
