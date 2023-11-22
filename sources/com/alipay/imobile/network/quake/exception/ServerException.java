package com.alipay.imobile.network.quake.exception;

import com.alipay.mobile.common.rpc.RpcException;

/* loaded from: classes.dex */
public class ServerException extends RpcException {
    private String extInfo;

    public ServerException(Integer num, String str) {
        super(num, str);
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public ServerException(Integer num, String str, String str2) {
        super(num, str);
        this.extInfo = str2;
    }

    public ServerException(Integer num, Throwable th) {
        super(num, th);
    }

    public ServerException(Integer num, Throwable th, String str) {
        super(num, th);
        this.extInfo = str;
    }
}
