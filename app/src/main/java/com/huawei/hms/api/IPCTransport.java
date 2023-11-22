package com.huawei.hms.api;

import android.os.Bundle;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes7.dex */
public class IPCTransport implements DatagramTransport {
    private static final String TAG = "IPCTransport";
    private int apiLevel;
    private final IMessageEntity mEntity;
    private final Class<? extends IMessageEntity> mResponseClass;
    private final String mURI;

    public IPCTransport(String str, IMessageEntity iMessageEntity, Class<? extends IMessageEntity> cls) {
        this.mURI = str;
        this.mEntity = iMessageEntity;
        this.mResponseClass = cls;
    }

    private int syncCall(ApiClient apiClient, IAIDLCallback iAIDLCallback) {
        if (apiClient instanceof InnerApiClient) {
            DataBuffer dataBuffer = new DataBuffer(this.mURI, ProtocolNegotiate.getInstance().getVersion());
            MessageCodec authRequestContext = CodecLookup.getAuthRequestContext(dataBuffer.PlaceComponentResult);
            dataBuffer.MyBillsEntityDataFactory = authRequestContext.PlaceComponentResult(this.mEntity, new Bundle());
            RequestHeader requestHeader = new RequestHeader();
            requestHeader.PlaceComponentResult = apiClient.getAppID();
            requestHeader.BuiltInFictitiousFunctionClassFactory = apiClient.getPackageName();
            requestHeader.MyBillsEntityDataFactory = 60500300;
            requestHeader.getAuthRequestContext = ((AidlApiClient) apiClient).getApiNameList();
            requestHeader.getErrorConfigVersion = apiClient.getSessionId();
            requestHeader.KClassImpl$Data$declaredNonStaticMembers$2 = this.apiLevel;
            dataBuffer.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext.PlaceComponentResult(requestHeader, new Bundle());
            try {
                AidlApiClient aidlApiClient = (AidlApiClient) apiClient;
                if (aidlApiClient.getService() == null) {
                    HMSLog.e(TAG, "HuaweiApiClient is not binded to service yet.");
                    return CommonCode.ErrorCode.INTERNAL_ERROR;
                }
                aidlApiClient.getService().asyncCall(dataBuffer, iAIDLCallback);
                return 0;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("sync call ex:");
                sb.append(e);
                HMSLog.e(TAG, sb.toString());
                return CommonCode.ErrorCode.INTERNAL_ERROR;
            }
        }
        if (apiClient instanceof AidlApiClient) {
            AidlApiClient aidlApiClient2 = (AidlApiClient) apiClient;
            DataBuffer dataBuffer2 = new DataBuffer(this.mURI, ProtocolNegotiate.getInstance().getVersion());
            dataBuffer2.MyBillsEntityDataFactory = CodecLookup.getAuthRequestContext(dataBuffer2.PlaceComponentResult).PlaceComponentResult(this.mEntity, new Bundle());
            try {
                aidlApiClient2.getService().asyncCall(dataBuffer2, iAIDLCallback);
                return 0;
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("sync call ex:");
                sb2.append(e2);
                HMSLog.e(TAG, sb2.toString());
            }
        }
        return CommonCode.ErrorCode.INTERNAL_ERROR;
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void post(ApiClient apiClient, DatagramTransport.a aVar) {
        send(apiClient, aVar);
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void send(ApiClient apiClient, DatagramTransport.a aVar) {
        int syncCall = syncCall(apiClient, new IPCCallback(this.mResponseClass, aVar));
        if (syncCall != 0) {
            aVar.BuiltInFictitiousFunctionClassFactory(syncCall, null);
        }
    }

    public IPCTransport(String str, IMessageEntity iMessageEntity, Class<? extends IMessageEntity> cls, int i) {
        this.mURI = str;
        this.mEntity = iMessageEntity;
        this.mResponseClass = cls;
        this.apiLevel = i;
    }
}
