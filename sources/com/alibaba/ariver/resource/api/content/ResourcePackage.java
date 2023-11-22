package com.alibaba.ariver.resource.api.content;

import com.alibaba.ariver.engine.api.resources.Resource;
import java.util.Set;

/* loaded from: classes2.dex */
public interface ResourcePackage {
    void add(Resource resource);

    String appId();

    int count();

    Resource get(ResourceQuery resourceQuery);

    boolean isPrepareDone();

    Set<String> keySet();

    boolean needWaitForSetup();

    void reload();

    void remove(String str);

    void setup(boolean z);

    void teardown();

    String version();

    void waitForParse();

    void waitForSetup();
}
