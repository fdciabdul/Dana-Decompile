package com.alipay.mobile.framework.service.ext;

import com.alipay.mobile.framework.service.annotation.OperationType;

/* loaded from: classes3.dex */
public interface SimpleRpcService {
    public static final String OPERATION_TYPE = "alipay.client.executerpc";

    @OperationType(OPERATION_TYPE)
    String executeRPC(String str, String str2);

    Object getRpcConfig();
}
