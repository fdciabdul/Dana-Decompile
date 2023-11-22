package com.zoloz.rpc;

import com.alipay.mobile.security.bio.service.local.rpc.IRpcException;

/* loaded from: classes8.dex */
public class ZolozRpcException extends RuntimeException implements IRpcException {
    private final int mCode;
    private final String mMsg;

    public ZolozRpcException(Integer num, String str) {
        this.mCode = num.intValue();
        this.mMsg = str == null ? "" : str;
    }

    public ZolozRpcException(Integer num, Throwable th) {
        this.mCode = num.intValue();
        this.mMsg = (th == null || th.getMessage() == null) ? "" : th.getMessage();
    }

    public ZolozRpcException(String str) {
        this.mCode = 0;
        this.mMsg = str == null ? "" : str;
    }

    public ZolozRpcException(Exception exc) {
        if (exc instanceof ZolozRpcException) {
            this.mCode = ((ZolozRpcException) exc).mCode;
        } else {
            this.mCode = 0;
        }
        this.mMsg = (exc == null || exc.getMessage() == null) ? "" : exc.getMessage();
    }

    @Override // com.alipay.mobile.security.bio.service.local.rpc.IRpcException
    public int getCode() {
        return this.mCode;
    }

    @Override // com.alipay.mobile.security.bio.service.local.rpc.IRpcException
    public String getMsg() {
        return this.mMsg;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str = this.mMsg;
        return str != null ? str : super.getMessage();
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        String str = this.mMsg;
        return str != null ? str : super.getLocalizedMessage();
    }

    protected static String format(Integer num, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("RPCException: ");
        if (num != null) {
            sb.append("[");
            sb.append(num);
            sb.append("]");
        }
        sb.append(" : ");
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }
}
