package com.alibaba.ariver.remotedebug.core.state;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class RemoteDebugStateManager {

    /* renamed from: a  reason: collision with root package name */
    private RemoteDebugState f6188a = RemoteDebugState.STATE_NON_REMOTE_DEBUG;
    private final List<RemoteDebugStateListener> b = new ArrayList();

    public void addListener(RemoteDebugStateListener remoteDebugStateListener) {
        this.b.add(remoteDebugStateListener);
        remoteDebugStateListener.onStateChanged(this.f6188a);
    }

    public void notifyStateChanged(RemoteDebugState remoteDebugState) {
        for (RemoteDebugStateListener remoteDebugStateListener : this.b) {
            if (remoteDebugStateListener != null) {
                remoteDebugStateListener.onStateChanged(remoteDebugState);
            }
        }
    }
}
