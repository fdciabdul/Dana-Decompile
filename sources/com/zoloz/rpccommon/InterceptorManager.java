package com.zoloz.rpccommon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class InterceptorManager implements RpcInterceptor {
    private List<RpcInterceptor> mInterceptors;

    public static InterceptorManager get() {
        return Holder.MANAGER;
    }

    private InterceptorManager() {
    }

    public void addInterceptor(RpcInterceptor rpcInterceptor) {
        if (this.mInterceptors == null) {
            this.mInterceptors = new ArrayList();
        }
        this.mInterceptors.add(rpcInterceptor);
    }

    public void removeInterceptor(RpcInterceptor rpcInterceptor) {
        List<RpcInterceptor> list = this.mInterceptors;
        if (list != null) {
            list.remove(rpcInterceptor);
        }
    }

    @Override // com.zoloz.rpccommon.RpcInterceptor
    public void onPostExecute(NetRequest netRequest, NetResponse netResponse) {
        List<RpcInterceptor> list = this.mInterceptors;
        if (list != null) {
            Iterator<RpcInterceptor> it = list.iterator();
            while (it.hasNext()) {
                it.next().onPostExecute(netRequest, netResponse);
            }
        }
    }

    @Override // com.zoloz.rpccommon.RpcInterceptor
    public void onPreExecute(NetRequest netRequest) {
        List<RpcInterceptor> list = this.mInterceptors;
        if (list != null) {
            Iterator<RpcInterceptor> it = list.iterator();
            while (it.hasNext()) {
                it.next().onPreExecute(netRequest);
            }
        }
    }

    /* loaded from: classes8.dex */
    static class Holder {
        static final InterceptorManager MANAGER = new InterceptorManager();

        Holder() {
        }
    }
}
