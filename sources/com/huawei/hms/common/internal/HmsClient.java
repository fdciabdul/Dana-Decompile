package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class HmsClient extends BaseHmsClient implements AnyClient {
    private static final String TAG = "HmsClient";

    public HmsClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    @Override // com.huawei.hms.common.internal.AnyClient
    public void post(IMessageEntity iMessageEntity, String str, AnyClient.CallBack callBack) {
        if (callBack == null) {
            HMSLog.e(TAG, "callback is invalid, discard.");
            return;
        }
        if ((iMessageEntity instanceof RequestHeader) && str != null) {
            if (!isConnected()) {
                StringBuilder sb = new StringBuilder();
                sb.append("No connection now, the connection status:");
                sb.append(getConnectionStatus());
                HMSLog.i(TAG, sb.toString());
                if (getConnectionStatus() != 6) {
                    HMSLog.e(TAG, "post failed for not connected.");
                    callBack.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.INTERNAL_ERROR, "Not Connected"), new JSONObject().toString());
                    return;
                }
                HMSLog.i(TAG, "in timeout-disconnect status, need to bind again.");
                bindCoreService();
            }
            RequestHeader requestHeader = (RequestHeader) iMessageEntity;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("post msg ");
            sb2.append(requestHeader);
            HMSLog.i(TAG, sb2.toString());
            Activity cpActivity = getClientSettings().getCpActivity();
            boolean z = cpActivity == null;
            if (z) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Activity is null for ");
                sb3.append(getClientSettings().getAppID());
                HMSLog.i(TAG, sb3.toString());
            }
            (z ? new BaseAdapter(this) : new BaseAdapter(this, cpActivity)).baseRequest(requestHeader.toJson(), str, requestHeader.getParcelable(), new BaseAdapterCallBack(this, callBack));
            return;
        }
        HMSLog.e(TAG, "arguments is invalid.");
        callBack.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "Args is invalid"), new JSONObject().toString());
    }

    public void updateSessionId(String str) {
        if (TextUtils.isEmpty(this.sessionId)) {
            this.sessionId = str;
        }
    }

    /* loaded from: classes7.dex */
    static class BaseAdapterCallBack implements BaseAdapter.BaseCallBack {
        private final AnyClient.CallBack callback;
        private final WeakReference<HmsClient> hmsClient;

        BaseAdapterCallBack(HmsClient hmsClient, AnyClient.CallBack callBack) {
            this.callback = callBack;
            this.hmsClient = new WeakReference<>(hmsClient);
        }

        private void doCallback(String str, String str2) {
            ResponseHeader responseHeader = new ResponseHeader();
            if (responseHeader.fromJson(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("receive msg ");
                sb.append(responseHeader);
                HMSLog.i(HmsClient.TAG, sb.toString());
                updateSessionId(responseHeader.getSessionId());
                this.callback.onCallback(responseHeader, str2);
                return;
            }
            this.callback.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
        }

        private void updateSessionId(String str) {
            HmsClient hmsClient = this.hmsClient.get();
            if (hmsClient != null) {
                hmsClient.updateSessionId(str);
            }
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onComplete(String str, String str2, Parcelable parcelable) {
            if (parcelable == null) {
                doCallback(str, str2);
            } else {
                doCallback(str, str2, parcelable);
            }
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onError(String str) {
            ResponseWrap responseWrap = new ResponseWrap(new ResponseHeader());
            if (responseWrap.fromJson(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("receive msg ");
                sb.append(responseWrap);
                HMSLog.i(HmsClient.TAG, sb.toString());
                ResponseHeader responseHeader = responseWrap.getResponseHeader();
                updateSessionId(responseHeader.getSessionId());
                this.callback.onCallback(responseHeader, responseWrap.getBody());
                return;
            }
            this.callback.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
        }

        private void doCallback(String str, String str2, Parcelable parcelable) {
            ResponseHeader responseHeader = new ResponseHeader();
            if (responseHeader.fromJson(str)) {
                responseHeader.setParcelable(parcelable);
                StringBuilder sb = new StringBuilder();
                sb.append("receive msg ");
                sb.append(responseHeader);
                HMSLog.i(HmsClient.TAG, sb.toString());
                updateSessionId(responseHeader.getSessionId());
                this.callback.onCallback(responseHeader, str2);
                return;
            }
            this.callback.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
        }
    }
}
