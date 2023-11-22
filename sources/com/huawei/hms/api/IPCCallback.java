package com.huawei.hms.api;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes7.dex */
public class IPCCallback extends IAIDLCallback.Stub {
    private static final String TAG = "IPCCallback";
    private final DatagramTransport.a mCallback;
    private final Class<? extends IMessageEntity> mResponseClass;

    public IPCCallback(Class<? extends IMessageEntity> cls, DatagramTransport.a aVar) {
        this.mResponseClass = cls;
        this.mCallback = aVar;
    }

    @Override // com.huawei.hms.core.aidl.IAIDLCallback
    public void call(DataBuffer dataBuffer) throws RemoteException {
        if (dataBuffer != null && !TextUtils.isEmpty(dataBuffer.getAuthRequestContext)) {
            MessageCodec authRequestContext = CodecLookup.getAuthRequestContext(dataBuffer.PlaceComponentResult);
            IMessageEntity iMessageEntity = null;
            if ((dataBuffer.MyBillsEntityDataFactory == null ? (char) 0 : (char) 1) > 0 && (iMessageEntity = newResponseInstance()) != null) {
                authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(dataBuffer.MyBillsEntityDataFactory, iMessageEntity);
            }
            if (dataBuffer.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                ResponseHeader responseHeader = new ResponseHeader();
                authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(dataBuffer.KClassImpl$Data$declaredNonStaticMembers$2, responseHeader);
                this.mCallback.BuiltInFictitiousFunctionClassFactory(responseHeader.getAuthRequestContext(), iMessageEntity);
                return;
            }
            this.mCallback.BuiltInFictitiousFunctionClassFactory(0, iMessageEntity);
            return;
        }
        HMSLog.e(TAG, "In call, URI cannot be empty.");
        throw new RemoteException();
    }

    protected IMessageEntity newResponseInstance() {
        Class<? extends IMessageEntity> cls = this.mResponseClass;
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("In newResponseInstance, instancing exception.");
                sb.append(e.getMessage());
                HMSLog.e(TAG, sb.toString());
                return null;
            }
        }
        return null;
    }
}
