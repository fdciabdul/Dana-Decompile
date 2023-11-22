package com.iap.ac.android.common.rpc.interfaces;

import com.iap.ac.android.common.rpc.RpcAppInfo;
import java.util.Map;

/* loaded from: classes3.dex */
public interface SignRpcRequestPlugin {
    String signRequest(RpcAppInfo rpcAppInfo, String str, Map<String, String> map);
}
