package com.alipay.imobile.network.quake.exception;

import com.alipay.mobile.common.rpc.RpcException;

/* loaded from: classes.dex */
public class TimeoutException extends RpcException {
    public TimeoutException(Integer num, String str) {
        super(num, str);
    }
}
