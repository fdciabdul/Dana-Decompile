package com.alibaba.ariver.remotedebug.core.state;

/* loaded from: classes6.dex */
public enum RemoteDebugState {
    STATE_NON_REMOTE_DEBUG,
    STATE_CONNECTING,
    STATE_CONNECTED,
    STATE_CONNECT_FAILED,
    STATE_NETWORK_UNAVAILABLE,
    STATE_REMOTE_DISCONNECTED,
    STATE_LOCAL_DISCONNECTED,
    STATE_HIT_BREAKPOINT,
    STATE_RELEASE_BREAKPOINT,
    STATE_EXITED
}
