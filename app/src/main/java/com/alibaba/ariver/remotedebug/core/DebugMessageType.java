package com.alibaba.ariver.remotedebug.core;

import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;

/* loaded from: classes2.dex */
public enum DebugMessageType {
    REMOTE_DEBUG_NETWORK_ERROR("tinyAppRemoteDebug_network_error"),
    REMOTE_DEBUG_NETWORK_REQUEST("tinyAppRemoteDebug_network_request"),
    REMOTE_DEBUG_NETWORK_RESPONSE("tinyAppRemoteDebug_network_response"),
    REMOTE_DEBUG_STORAGE("tinyAppRemoteDebug_storage"),
    STANDARD_LOG(TinyAppLogUtil.TINY_APP_STANDARD_LOG);

    private String mType;

    DebugMessageType(String str) {
        this.mType = str;
    }

    public final String getType() {
        return this.mType;
    }
}
