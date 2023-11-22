package com.zoloz.rpccommon;

/* loaded from: classes8.dex */
public interface RpcInterceptor {
    void onPostExecute(NetRequest netRequest, NetResponse netResponse);

    void onPreExecute(NetRequest netRequest);
}
