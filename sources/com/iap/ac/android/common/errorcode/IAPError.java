package com.iap.ac.android.common.errorcode;

import com.alipay.mobile.common.rpc.RpcException;
import com.iap.ac.android.common.a.a;
import java.io.Serializable;

/* loaded from: classes8.dex */
public class IAPError implements Serializable {
    public static final long serialVersionUID = -7742425729580836000L;
    public String errorCode;
    public String errorMessage;
    public String memo;

    public IAPError(String str, String str2) {
        this.errorCode = str;
        this.errorMessage = str2;
        this.memo = "";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.errorCode);
        sb.append(", errorMessage='");
        sb.append(this.errorMessage);
        sb.append("', memo='");
        sb.append(this.memo);
        sb.append("'}");
        return sb.toString();
    }

    public IAPError(String str, String str2, String str3) {
        this.errorCode = str;
        this.errorMessage = str2;
        this.memo = str3;
    }

    public IAPError(RpcException rpcException) {
        StringBuilder a2 = a.a("");
        a2.append(rpcException.getCode());
        this.errorCode = a2.toString();
        this.errorMessage = rpcException.getMsg();
        this.memo = "";
    }
}
