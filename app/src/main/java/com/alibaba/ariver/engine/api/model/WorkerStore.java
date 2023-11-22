package com.alibaba.ariver.engine.api.model;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class WorkerStore {
    public String workerId;
    public boolean hasReceivedRegisterWorker = false;
    public final Set<String> dynamicLoadedPlugins = new HashSet();
}
