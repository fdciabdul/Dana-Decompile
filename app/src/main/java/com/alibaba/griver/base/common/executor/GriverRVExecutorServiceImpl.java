package com.alibaba.griver.base.common.executor;

import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes6.dex */
public class GriverRVExecutorServiceImpl implements RVExecutorService {
    @Override // com.alibaba.ariver.kernel.common.service.executor.RVExecutorService
    public Executor getExecutor(ExecutorType executorType) {
        return GriverExecutors.getExecutor(executorType);
    }

    @Override // com.alibaba.ariver.kernel.common.service.executor.RVExecutorService
    public ScheduledThreadPoolExecutor getScheduledExecutor() {
        return GriverExecutors.getScheduledExecutor();
    }

    @Override // com.alibaba.ariver.kernel.common.service.executor.RVExecutorService
    public String getCurrentScheduleType() {
        return ExecutorUtils.isMainThread() ? RVScheduleType.UI : RVScheduleType.UNKNOW;
    }
}
