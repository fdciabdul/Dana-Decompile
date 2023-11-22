package com.iap.ac.android.common.container.plugin;

import com.iap.ac.android.common.container.event.ContainerEvent;
import com.iap.ac.android.common.container.event.ContainerEventFilter;

/* loaded from: classes3.dex */
public class BaseContainerPlugin implements IContainerPlugin {
    @Override // com.iap.ac.android.common.container.plugin.IContainerPlugin
    public boolean handleEvent(ContainerEvent containerEvent) {
        return false;
    }

    @Override // com.iap.ac.android.common.container.plugin.IContainerPlugin
    public boolean interceptorEvent(ContainerEvent containerEvent) {
        return false;
    }

    @Override // com.iap.ac.android.common.container.plugin.IContainerPlugin
    public ContainerEventFilter onPrepare(ContainerEventFilter containerEventFilter) {
        return null;
    }
}
