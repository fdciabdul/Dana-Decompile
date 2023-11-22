package com.alibaba.ariver.ariverexthub.api.provider;

import com.alibaba.ariver.ariverexthub.api.model.RVEExecutorType;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public interface RVEThreadService {
    Executor getExecutor(RVEExecutorType rVEExecutorType);
}
