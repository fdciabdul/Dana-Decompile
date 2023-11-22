package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.Map;
import java.util.Set;

@DefaultImpl("com.alibaba.ariver.kernel.common.log.DefaultAppLogConfigProxyImpl")
/* loaded from: classes3.dex */
public interface AppLogConfigProxy extends Proxiable {
    int getAPILengthLimit();

    String getCurrentEnv();

    Set<String> getErrorIgnoreAPIList();

    Set<String> getIgnoreAPIList();

    int getIgnoreApiLogCount();

    Set<String> getIgnoreErrorResourceHostList();

    Set<String> getIgnoreEventList();

    Set<String> getIgnoreInputAPIList();

    Set<String> getIgnoreOutputAPIList();

    Map<String, Map<String, String>> getNotIgnoreAPIForSpecificParam();
}
