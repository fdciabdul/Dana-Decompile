package com.alibaba.ariver.kernel.common.rpc;

import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.Map;

/* loaded from: classes6.dex */
public interface RVRpcProxy extends Proxiable {
    <T> T getPBRpcProxy(Class<T> cls);

    <T> T getPBRpcProxy(Class<T> cls, RVRpcConfig rVRpcConfig);

    <T> T getRpcProxy(Class<T> cls);

    <T> T getRpcProxy(Class<T> cls, RVRpcConfig rVRpcConfig);

    RVRpcResponse sendSimpleRpc(Node node, boolean z, String str, RVRpcConfig rVRpcConfig, Object obj, Map<String, String> map) throws RVRpcException;

    RVRpcResponse sendSimpleRpcJsapi(Node node, boolean z, String str, RVRpcConfig rVRpcConfig, Object obj, Map<String, String> map) throws RVRpcException;
}
