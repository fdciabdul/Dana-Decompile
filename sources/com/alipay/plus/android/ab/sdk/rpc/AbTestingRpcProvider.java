package com.alipay.plus.android.ab.sdk.rpc;

import com.alipay.plus.android.ab.sdk.facade.request.AbTestingRequest;
import com.alipay.plus.android.ab.sdk.facade.result.AbTestingResponse;

/* loaded from: classes7.dex */
public interface AbTestingRpcProvider {
    AbTestingResponse fetchVariation(AbTestingRequest abTestingRequest) throws Throwable;
}
