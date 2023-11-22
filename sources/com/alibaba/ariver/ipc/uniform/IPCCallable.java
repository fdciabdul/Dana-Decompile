package com.alibaba.ariver.ipc.uniform;

import android.os.DeadObjectException;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.IIPCManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCParameter;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResult;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResultDesc;
import com.alibaba.ariver.kernel.ipc.uniform.UniformIpcUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes6.dex */
public class IPCCallable {

    /* renamed from: a  reason: collision with root package name */
    private IIPCManager f6071a;
    private Lock b = new ReentrantLock();

    public IPCCallable(IIPCManager iIPCManager) {
        this.f6071a = iIPCManager;
    }

    public IPCResult call(IPCParameter iPCParameter) {
        try {
            this.b.lock();
            try {
                IPCResult call = this.f6071a.call(iPCParameter);
                if (call != null) {
                    return call;
                }
                throw new IllegalStateException("remote return ipcResult is null!");
            } finally {
                this.b.unlock();
            }
        } catch (Exception e) {
            RVLogger.e(UniformIpcUtils.TAG, "IPCCallable call exception!", e);
            IPCResult iPCResult = new IPCResult();
            if (e instanceof DeadObjectException) {
                iPCResult.resultCode = 201;
                iPCResult.resultMsg = IPCResultDesc.DEAD_OBJECT_MSG;
            } else {
                iPCResult.resultCode = 200;
                iPCResult.resultMsg = e.getMessage();
            }
            return iPCResult;
        }
    }
}
