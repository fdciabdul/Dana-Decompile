package com.alipay.imobile.network.quake.rpc;

import com.alipay.imobile.network.quake.Request;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class RpcRequest extends Request {
    private Method x;
    private String y;
    private boolean z;

    public RpcRequest(String str, Type type, Request.Listener listener, Request.ErrorListener errorListener) {
        super(str, type, listener, errorListener);
        this.x = null;
        this.y = null;
        this.z = false;
    }

    private Type a() {
        Method method = this.x;
        if (method == null) {
            return Void.TYPE;
        }
        return method.getGenericReturnType();
    }

    @Override // com.alipay.imobile.network.quake.Request
    public String getActionType() {
        return this.y;
    }

    public final Method getOperationMethod() {
        return this.x;
    }

    @Override // com.alipay.imobile.network.quake.Request
    public Type getResponseType() {
        return a();
    }

    public boolean isSkipRequestSerialize() {
        return this.z;
    }

    public final void setOperationMethod(Method method) {
        if (method != null) {
            this.x = method;
        }
    }

    public final void setOperationType(String str) {
        if (str != null) {
            this.y = str;
        }
    }

    public void skipRequestSerialize() {
        this.z = true;
    }
}
