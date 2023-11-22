package com.alipay.plus.android.push.fcm;

import com.alipay.plus.push.core.PushExtConstants;
import com.alipay.plus.push.core.PushServiceInstance;
import com.alipay.plus.push.core.pushservice.IPushService;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/* loaded from: classes7.dex */
public class CommonFirebaseInstanceIdService extends FirebaseInstanceIdService {
    private static final String TAG = "CommonFirebaseInstanceIdService";
    private IPushService iPushService;

    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        StringBuilder sb = new StringBuilder();
        sb.append("Refreshed token: ");
        sb.append(token);
        InstrumentInjector.log_d(PushExtConstants.GLOBAL_TAG, sb.toString());
        IPushService pushService = PushServiceInstance.getPushService();
        this.iPushService = pushService;
        pushService.report(token, null);
    }
}
