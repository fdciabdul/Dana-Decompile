package com.alibaba.ariver.integration.ipc.server;

import android.os.Bundle;
import android.util.Log;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class RemoteReplyHandler implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private IIpcChannel f6057a;
    private String b;
    private String c;
    private long d;
    private long e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteReplyHandler(String str, String str2, long j, long j2) {
        this.e = j;
        this.c = str;
        this.f6057a = IpcChannelManager.getInstance().getClientChannel(j);
        this.d = j2;
        this.b = str2;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (this.f6057a == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Client channel is not found!!!");
            sb.append(Log.getStackTraceString(new Throwable("Just Print!")));
            RVLogger.e("AriverInt:RemoteReplyHandler", sb.toString());
            return null;
        }
        if ("onCallback".equalsIgnoreCase(method.getName())) {
            JSONObject jSONObject = (JSONObject) objArr[0];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            Bundle bundle = new Bundle();
            bundle.putByteArray("data", JSONUtils.marshallJSONObject(jSONObject));
            bundle.putBoolean("keepCallback", booleanValue);
            bundle.putString("clientId", this.b);
            bundle.putLong(IpcMessageConstants.EXTRA_NODE_ID, this.d);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("send RemoteCall back to client: ");
            sb2.append(bundle);
            RVLogger.d("AriverInt:RemoteReplyHandler", sb2.toString());
            IpcServerUtils.sendMsgToClient(this.c, this.e, 7, bundle);
        }
        return null;
    }
}
