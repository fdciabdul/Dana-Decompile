package com.alibaba.ariver.ipc.uniform;

import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.IPCParameter;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResult;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResultDesc;
import com.alibaba.ariver.kernel.ipc.uniform.LocalCallManager;
import com.alibaba.ariver.kernel.ipc.uniform.LocalCallRetryHandler;
import com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager;
import com.alibaba.ariver.kernel.ipc.uniform.UniformIpcUtils;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes3.dex */
public class LocalCallManagerImpl implements LocalCallManager {

    /* renamed from: a  reason: collision with root package name */
    private ServiceBeanManager f6074a;
    private LocalCallRetryHandler b;

    public LocalCallManagerImpl(ServiceBeanManager serviceBeanManager) {
        this.f6074a = serviceBeanManager;
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.LocalCallManager
    public IPCResult call(IPCParameter iPCParameter) {
        RVLogger.d(UniformIpcUtils.TAG, "LocalCallManagerImpl start local call");
        Object serviceBean = this.f6074a.getServiceBean(iPCParameter.className);
        if (serviceBean == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("LocalCallManagerImpl Service not found,className=[");
            sb.append(iPCParameter.className);
            sb.append("] serviceBeanManager hashcode=[");
            sb.append(this.f6074a.hashCode());
            sb.append("] service bean count=[");
            sb.append(this.f6074a.getServiceBeanCount());
            sb.append("]");
            RVLogger.w(UniformIpcUtils.TAG, sb.toString());
            IPCResult iPCResult = new IPCResult();
            iPCResult.resultCode = 100;
            iPCResult.resultMsg = IPCResultDesc.SERVICE_NOT_FOUND_MSG;
            LocalCallRetryHandler localCallRetryHandler = this.b;
            if (localCallRetryHandler == null) {
                RVLogger.w(UniformIpcUtils.TAG, "LocalCallManagerImpl Service not found,localCallRetryHandler is null,no retry!");
                return iPCResult;
            } else if (!localCallRetryHandler.retryLocalCall(iPCParameter, iPCResult, this.f6074a, 1)) {
                RVLogger.w(UniformIpcUtils.TAG, "LocalCallManagerImpl Service not found. no retry!");
                return iPCResult;
            } else {
                RVLogger.d(UniformIpcUtils.TAG, "Service not found. ye retry!");
                Object serviceBean2 = this.f6074a.getServiceBean(iPCParameter.className);
                if (serviceBean2 == null) {
                    RVLogger.d(UniformIpcUtils.TAG, "LocalCallManagerImpl Service not found. retry fail!");
                    return iPCResult;
                }
                serviceBean = serviceBean2;
            }
        }
        Method a2 = a(iPCParameter, serviceBean);
        if (a2 == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("LocalCallManagerImpl serviceBean=[");
            sb2.append(serviceBean.getClass().getName());
            sb2.append("],Method not found,className=[");
            sb2.append(iPCParameter.className);
            sb2.append("]");
            RVLogger.w(UniformIpcUtils.TAG, sb2.toString());
            IPCResult iPCResult2 = new IPCResult();
            iPCResult2.resultCode = 101;
            iPCResult2.resultMsg = IPCResultDesc.METHOD_NOT_FOUND_MSG;
            return iPCResult2;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("LocalCallManagerImpl serviceBean=[");
        sb3.append(serviceBean.getClass().getName());
        sb3.append("],method=[");
        sb3.append(a2.getName());
        sb3.append("]");
        RVLogger.d(UniformIpcUtils.TAG, sb3.toString());
        if (!TextUtils.equals(iPCParameter.returnType, a2.getReturnType().getName())) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Not the same returnType, peer returnType=[");
            sb4.append(iPCParameter.returnType);
            sb4.append("] local returnType=[");
            sb4.append(a2.getReturnType().getName());
            sb4.append("]");
            RVLogger.d(UniformIpcUtils.TAG, sb4.toString());
            IPCResult iPCResult3 = new IPCResult();
            iPCResult3.resultCode = 105;
            iPCResult3.resultMsg = IPCResultDesc.METHOD_NOT_FOUND_MSG;
            return iPCResult3;
        }
        List<byte[]> list = iPCParameter.paramValues;
        Class<?>[] parameterTypes = a2.getParameterTypes();
        if (list != null && parameterTypes.length != list.size()) {
            IPCResult iPCResult4 = new IPCResult();
            iPCResult4.resultCode = 102;
            iPCResult4.resultMsg = IPCResultDesc.NUMBER_OF_PARAMETERS_NOT_MATCH_MSG;
            return iPCResult4;
        }
        Object[] objArr = new Object[parameterTypes.length];
        if (parameterTypes.length > 0) {
            try {
                if (iPCParameter.serType == 2) {
                    objArr[0] = iPCParameter.parcelable;
                } else {
                    for (int i = 0; i < parameterTypes.length; i++) {
                        objArr[i] = ObjSerializUtil.deserializ(list.get(i), parameterTypes[i].getClassLoader());
                    }
                }
            } catch (Exception e) {
                RVLogger.e(UniformIpcUtils.TAG, "LocalCallManagerImpl call Exception", e);
                IPCResult iPCResult5 = new IPCResult();
                iPCResult5.resultCode = 103;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Param deserializ error. exception: ");
                sb5.append(e.getMessage());
                iPCResult5.resultMsg = sb5.toString();
                return iPCResult5;
            }
        }
        try {
            Object invoke = a2.invoke(serviceBean, objArr);
            if (invoke == null) {
                RVLogger.d(UniformIpcUtils.TAG, "LocalCallManagerImpl invoke success, result is void");
                return new IPCResult();
            }
            IPCResult iPCResult6 = new IPCResult();
            iPCResult6.resultType = invoke.getClass().getName();
            if (invoke instanceof Parcelable) {
                iPCResult6.serType = (byte) 2;
                iPCResult6.parcelable = (Parcelable) invoke;
            } else {
                iPCResult6.resultValue = ObjSerializUtil.serializ((Serializable) invoke);
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("LocalCallManagerImpl invoke success, result type = ");
            sb6.append(iPCResult6.resultType != null ? iPCResult6.resultType : "is null");
            RVLogger.d(UniformIpcUtils.TAG, sb6.toString());
            return iPCResult6;
        } catch (Throwable th) {
            RVLogger.e(UniformIpcUtils.TAG, "LocalCallManager Exception", th);
            IPCResult iPCResult7 = new IPCResult();
            iPCResult7.resultCode = 104;
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Invoke method error. exception: ");
            sb7.append(th.getMessage());
            iPCResult7.resultMsg = sb7.toString();
            return iPCResult7;
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.LocalCallManager
    public void setLocalCallRetryHandler(LocalCallRetryHandler localCallRetryHandler) {
        this.b = localCallRetryHandler;
    }

    private Method a(IPCParameter iPCParameter, Object obj) {
        for (Method method : obj.getClass().getMethods()) {
            if (TextUtils.equals(iPCParameter.methodName, method.getName())) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                String[] strArr = iPCParameter.paramTypes;
                if (parameterTypes.length == strArr.length && a(parameterTypes, strArr)) {
                    return method;
                }
            }
        }
        return null;
    }

    private boolean a(Class<?>[] clsArr, String[] strArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (!TextUtils.equals(clsArr[i].getName(), strArr[i])) {
                return false;
            }
        }
        return true;
    }
}
