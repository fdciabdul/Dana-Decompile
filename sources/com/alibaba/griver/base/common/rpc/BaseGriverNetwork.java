package com.alibaba.griver.base.common.rpc;

import com.alibaba.ariver.kernel.common.RVProxy;

/* loaded from: classes3.dex */
public abstract class BaseGriverNetwork<T> {

    /* loaded from: classes6.dex */
    public interface FacadeProcessor<F, S> {
        S processFacade(F f);
    }

    protected abstract Class<T> getFacadeClass();

    protected <S extends BaseGriverRpcResult> S wrapper(FacadeProcessor<T, S> facadeProcessor) throws Exception {
        return facadeProcessor.processFacade(getFacade());
    }

    public T getFacade() {
        return a(getFacadeClass());
    }

    private <T> T a(Class<T> cls) {
        return (T) ((GriverRpcExtension) RVProxy.get(GriverRpcExtension.class)).getFacade(cls);
    }
}
