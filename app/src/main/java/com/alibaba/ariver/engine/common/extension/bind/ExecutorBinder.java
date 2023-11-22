package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingExecutor;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class ExecutorBinder implements Binder<BindingExecutor, Executor> {
    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public Executor bind(Class<Executor> cls, BindingExecutor bindingExecutor) throws BindException {
        return ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(bindingExecutor.value());
    }
}
