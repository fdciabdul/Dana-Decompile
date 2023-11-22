package com.alibaba.ariver.ipc.uniform;

import android.os.RemoteException;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.IIPCManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCParameter;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResult;
import com.alibaba.ariver.kernel.ipc.uniform.LocalCallManager;
import com.alibaba.ariver.kernel.ipc.uniform.UniformIpcUtils;

/* loaded from: classes3.dex */
public class IPCManagerService extends IIPCManager.Stub {

    /* renamed from: a  reason: collision with root package name */
    private LocalCallManager f6073a;

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IIPCManager
    public IPCResult call(IPCParameter iPCParameter) throws RemoteException {
        StringBuilder sb = new StringBuilder();
        sb.append("IPCManagerService IPCParameter=[");
        sb.append(iPCParameter.toString());
        sb.append("]");
        RVLogger.d(UniformIpcUtils.TAG, sb.toString());
        return this.f6073a.call(iPCParameter);
    }

    public void setLocalCallManager(LocalCallManager localCallManager) {
        this.f6073a = localCallManager;
    }
}
