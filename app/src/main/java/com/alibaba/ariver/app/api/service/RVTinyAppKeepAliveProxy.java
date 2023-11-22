package com.alibaba.ariver.app.api.service;

import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes6.dex */
public interface RVTinyAppKeepAliveProxy extends Proxiable {
    boolean heartbeat(String str, String str2);

    boolean register(String str, String str2);

    boolean release(String str, String str2);
}
