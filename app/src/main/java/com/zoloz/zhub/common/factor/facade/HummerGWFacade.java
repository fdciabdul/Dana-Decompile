package com.zoloz.zhub.common.factor.facade;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.zoloz.zhub.common.factor.model.FactorNextRequest;
import com.zoloz.zhub.common.factor.model.FactorNextResponse;

/* loaded from: classes8.dex */
public interface HummerGWFacade {
    @OperationType("com.zoloz.zhub.factor.next")
    FactorNextResponse forward(FactorNextRequest factorNextRequest);
}
