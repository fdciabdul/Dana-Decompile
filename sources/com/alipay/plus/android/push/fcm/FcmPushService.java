package com.alipay.plus.android.push.fcm;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.product.delegate.IAPLoginUserInfo;
import com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import com.alipay.plus.push.core.ICallback;
import com.alipay.plus.push.core.PushService;
import com.alipay.plus.push.core.impl.RpcPushApi;
import com.alipay.plus.push.core.model.PushMessage;
import com.alipay.plus.push.core.rpc.ResultPbPB;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.RemoteMessage;

/* loaded from: classes7.dex */
public class FcmPushService extends PushService implements IAPUserChangeObserver {
    private String TAG = "FcmPushService";
    private Context context;
    private String token;
    private String userId;

    @Override // com.alipay.plus.push.core.PushService, com.alipay.plus.push.core.pushservice.IPushService
    public void init(Context context) {
        this.context = context;
        FirebaseApp.initializeApp(context);
        UserInfoManager.instance().addUserChangeObserver(this);
    }

    @Override // com.alipay.plus.push.core.PushService, com.alipay.plus.push.core.pushservice.IPushService
    public String getPushToken() {
        try {
            if (FirebaseInstanceId.getInstance() != null) {
                return FirebaseInstanceId.getInstance().getToken();
            }
            return FirebaseInstanceId.getInstance().getToken();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.alipay.plus.push.core.pushservice.IPushService
    public void report(String str, final ICallback iCallback) {
        String deviceId = UtdidDeviceIdProvider.getDeviceId((Application) this.context);
        String pushToken = getPushToken();
        InstrumentInjector.log_d(this.TAG, "start report:");
        RpcPushApi.report(deviceId, "Google Play", pushToken, 6, new ICallback<ResultPbPB>() { // from class: com.alipay.plus.android.push.fcm.FcmPushService.1
            @Override // com.alipay.plus.push.core.ICallback
            public void onSuccess(ResultPbPB resultPbPB) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onSuccess(resultPbPB);
                }
            }

            @Override // com.alipay.plus.push.core.ICallback
            public void onFailed(String str2, String str3) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onFailed(str2, str3);
                }
            }
        });
    }

    @Override // com.alipay.plus.push.core.pushservice.IPushService
    public void bind(String str, final ICallback iCallback) {
        String deviceId = UtdidDeviceIdProvider.getDeviceId((Application) this.context);
        this.token = deviceId;
        if (TextUtils.isEmpty(deviceId) || TextUtils.isEmpty(str)) {
            return;
        }
        RpcPushApi.bind(str, this.token, new ICallback<ResultPbPB>() { // from class: com.alipay.plus.android.push.fcm.FcmPushService.2
            @Override // com.alipay.plus.push.core.ICallback
            public void onSuccess(ResultPbPB resultPbPB) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onSuccess(resultPbPB);
                }
            }

            @Override // com.alipay.plus.push.core.ICallback
            public void onFailed(String str2, String str3) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onFailed(str2, str3);
                }
            }
        });
    }

    @Override // com.alipay.plus.push.core.pushservice.IPushService
    public void unBind(String str, final ICallback iCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RpcPushApi.unbind(str, this.token, new ICallback() { // from class: com.alipay.plus.android.push.fcm.FcmPushService.3
            @Override // com.alipay.plus.push.core.ICallback
            public void onSuccess(Object obj) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onSuccess(obj);
                }
            }

            @Override // com.alipay.plus.push.core.ICallback
            public void onFailed(String str2, String str3) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onFailed(str2, str3);
                }
            }
        });
    }

    @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
    public void onUserChanged(IAPLoginUserInfo iAPLoginUserInfo) {
        if (this.autoReport) {
            String userId = UserInfoManager.instance().getUserId();
            if (!TextUtils.isEmpty(this.userId)) {
                unBind(this.userId, null);
            }
            if (TextUtils.isEmpty(userId)) {
                return;
            }
            bind(userId, null);
        }
    }

    @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
    public void onUserLogin(IAPLoginUserInfo iAPLoginUserInfo) {
        if (this.autoReport) {
            String userId = UserInfoManager.instance().getUserId();
            this.userId = userId;
            bind(userId, null);
        }
    }

    @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
    public void onUserLogout() {
        if (this.autoReport) {
            unBind(this.userId, null);
        }
    }

    @Override // com.alipay.plus.push.core.PushService, com.alipay.plus.push.core.pushservice.IPushService
    public void dispatchMessage(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof RemoteMessage) {
            super.dispatchMessage(((RemoteMessage) obj).getData());
        } else if (obj instanceof PushMessage) {
            super.dispatchMessage(obj);
        }
    }
}
