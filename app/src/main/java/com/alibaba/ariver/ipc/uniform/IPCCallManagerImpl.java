package com.alibaba.ariver.ipc.uniform;

import android.os.Parcelable;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.IIPCManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCCallManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCException;
import com.alibaba.ariver.kernel.ipc.uniform.IPCParameter;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResult;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResultDesc;
import com.alibaba.ariver.kernel.ipc.uniform.IPCRetryHandler;
import com.alibaba.ariver.kernel.ipc.uniform.UniformIpcUtils;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class IPCCallManagerImpl implements IPCCallManager {

    /* renamed from: a  reason: collision with root package name */
    private IPCRetryHandler f6070a;
    private IIPCManager b;

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCCallManager
    public <T> T getIpcProxy(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new IPCCallProxyHandler());
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCCallManager
    public void setIIPCManager(IIPCManager iIPCManager) {
        synchronized (this) {
            this.b = iIPCManager;
            StringBuilder sb = new StringBuilder();
            sb.append("IPCCallManagerImpl [setIIPCManager] Finished. ");
            sb.append(iIPCManager == null ? " ipcManager is null" : "");
            RVLogger.d(UniformIpcUtils.TAG, sb.toString());
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCCallManager
    public void setIPCCallRetryHandler(IPCRetryHandler iPCRetryHandler) {
        this.f6070a = iPCRetryHandler;
    }

    /* loaded from: classes6.dex */
    class IPCCallProxyHandler implements InvocationHandler {
        private IPCCallProxyHandler() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            return a(method, objArr, 0);
        }

        private Object a(Method method, Object[] objArr, int i) throws IOException, ClassNotFoundException {
            do {
                RVLogger.d(UniformIpcUtils.TAG, "IPCCallManagerImpl IPCCallProxyHandler#invoke");
                if (IPCCallManagerImpl.this.b == null) {
                    RVLogger.d(UniformIpcUtils.TAG, "IPCCallManagerImpl IPCCallProxyHandler#invoke, ipcManager==null.");
                    IPCException iPCException = new IPCException("You must set IIPCManager. example: IPCCallManager#setIIPCManager");
                    iPCException.errorCode = 2;
                    iPCException.errorMsg = IPCResultDesc.IPC_NO_BINDER_MSG;
                    if (IPCCallManagerImpl.this.f6070a != null) {
                        if (IPCCallManagerImpl.this.f6070a.retryIPCCall(method, objArr, iPCException, i)) {
                            if (IPCCallManagerImpl.this.b == null) {
                                RVLogger.w(UniformIpcUtils.TAG, "IPCCallManagerImpl IPCCallProxyHandler#invoke, retry later, ipcManager still is null.");
                                throw iPCException;
                            }
                        } else {
                            throw iPCException;
                        }
                    } else {
                        throw iPCException;
                    }
                }
                Class<?> declaringClass = method.getDeclaringClass();
                Class<?>[] parameterTypes = method.getParameterTypes();
                IPCParameter iPCParameter = new IPCParameter();
                iPCParameter.className = declaringClass.getName();
                iPCParameter.methodName = method.getName();
                iPCParameter.returnType = method.getReturnType().getName();
                iPCParameter.paramTypes = new String[parameterTypes.length];
                if (!IPCCallManagerImpl.this.a(parameterTypes)) {
                    IPCCallManagerImpl.this.a(objArr, parameterTypes, iPCParameter);
                } else {
                    iPCParameter.serType = (byte) 2;
                    iPCParameter.paramTypes[0] = parameterTypes[0].getName();
                    iPCParameter.paramValues = new ArrayList(iPCParameter.paramTypes.length);
                    iPCParameter.parcelable = (Parcelable) objArr[0];
                }
                StringBuilder sb = new StringBuilder();
                sb.append("IPCCallManagerImpl start ipc call. ipcParameter=[");
                sb.append(iPCParameter.toString());
                sb.append("]");
                RVLogger.d(UniformIpcUtils.TAG, sb.toString());
                IPCResult call = new IPCCallable(IPCCallManagerImpl.this.b).call(iPCParameter);
                try {
                    if (call == null) {
                        throw new IPCException(106, IPCResultDesc.RETURN_IPCRESULT_IS_NULL_MSG);
                    }
                    if (call.resultCode != 0) {
                        throw new IPCException(call.resultCode, call.resultMsg);
                    }
                    if (method.getGenericReturnType() == Void.TYPE) {
                        return null;
                    }
                    if (call.serType == 2) {
                        return call.parcelable;
                    }
                    return ObjSerializUtil.deserializ(call.resultValue, method.getReturnType().getClassLoader());
                } catch (IPCException e) {
                    if (IPCCallManagerImpl.this.f6070a == null) {
                        throw e;
                    }
                }
            } while (IPCCallManagerImpl.this.f6070a.retryIPCCall(method, objArr, e, i));
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Class<?>[] clsArr) throws IPCException {
        int length = clsArr.length;
        if (length == 0) {
            return false;
        }
        if (length == 1) {
            return Parcelable.class.isAssignableFrom(clsArr[0]);
        }
        int i = 0;
        for (Class<?> cls : clsArr) {
            if (Parcelable.class.isAssignableFrom(cls)) {
                i++;
            }
        }
        if (i == 0) {
            return false;
        }
        IPCException iPCException = new IPCException("parameter more than one,and not all Serialize,not support");
        iPCException.errorCode = 3;
        iPCException.errorMsg = IPCResultDesc.IPC_PARAMER_ERROR_MSG;
        throw iPCException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object[] objArr, Class<?>[] clsArr, IPCParameter iPCParameter) throws IOException {
        for (int i = 0; i < clsArr.length; i++) {
            iPCParameter.paramTypes[i] = clsArr[i].getName();
        }
        if (iPCParameter.paramTypes.length > 0) {
            iPCParameter.paramValues = new ArrayList(iPCParameter.paramTypes.length);
            for (int i2 = 0; i2 < iPCParameter.paramTypes.length; i2++) {
                iPCParameter.paramValues.add(ObjSerializUtil.serializ((Serializable) objArr[i2]));
            }
        }
    }
}
