package com.alibaba.ariver.integration.ipc.server;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;

/* loaded from: classes3.dex */
public interface ServerRemoteCallPoint extends Extension {
    void serverCallPoint(RemoteCallArgs remoteCallArgs, String str, String str2, Node node);
}
