package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.google.firebase.messaging.Constants;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.h;
import com.huawei.hms.push.s;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.push.v;
import com.huawei.hms.push.w;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import id.dana.danah5.transactionstatus.TransactionStatusBridge;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class PushReceiver extends BroadcastReceiver {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public Context BuiltInFictitiousFunctionClassFactory;
        public Intent getAuthRequestContext;

        public /* synthetic */ a(Context context, Intent intent, byte b) {
            this(context, intent);
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(this.getAuthRequestContext.getPackage());
            try {
                JSONObject b = PushReceiver.b(this.getAuthRequestContext);
                String authRequestContext = JsonUtil.getAuthRequestContext(b, "moduleName", "");
                int authRequestContext2 = JsonUtil.getAuthRequestContext(b, "msgType", 0);
                int authRequestContext3 = JsonUtil.getAuthRequestContext(b, "status", 0);
                if (ErrorEnum.SUCCESS.getInternalCode() != authRequestContext3) {
                    authRequestContext3 = ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode();
                }
                Bundle bundle = new Bundle();
                if ("Push".equals(authRequestContext) && authRequestContext2 == 1) {
                    bundle.putString(Constants.MessagePayloadKeys.MESSAGE_TYPE, "delivery");
                    bundle.putString(Constants.MessagePayloadKeys.MSGID_SERVER, JsonUtil.getAuthRequestContext(b, "msgId", ""));
                    bundle.putInt("error", authRequestContext3);
                    bundle.putString("transaction_id", JsonUtil.getAuthRequestContext(b, TransactionStatusBridge.Companion.TransactionStatusParamKey.TRANSACTION_ID, ""));
                } else {
                    if (this.getAuthRequestContext.getExtras() != null) {
                        bundle.putAll(this.getAuthRequestContext.getExtras());
                    }
                    bundle.putString(Constants.MessagePayloadKeys.MESSAGE_TYPE, "received_message");
                    bundle.putString(Constants.MessagePayloadKeys.MSGID_SERVER, this.getAuthRequestContext.getStringExtra("msgIdStr"));
                    bundle.putByteArray("message_body", this.getAuthRequestContext.getByteArrayExtra("msg_data"));
                    bundle.putString("device_token", w.getAuthRequestContext(this.getAuthRequestContext.getByteArrayExtra("device_token")));
                    bundle.putInt(RequestConstants.Pin.INPUTTYPE, 1);
                    bundle.putString("message_proxy_type", this.getAuthRequestContext.getStringExtra("message_proxy_type"));
                }
                if (new h().MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, bundle, intent)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("receive ");
                    sb.append(this.getAuthRequestContext.getAction());
                    sb.append(" and start service success");
                    HMSLog.i("PushReceiver", sb.toString());
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("receive ");
                sb2.append(this.getAuthRequestContext.getAction());
                sb2.append(" and start service failed");
                HMSLog.e("PushReceiver", sb2.toString());
            } catch (RuntimeException unused) {
                HMSLog.e("PushReceiver", "handle push message occur exception.");
            }
        }

        private a(Context context, Intent intent) {
            this.BuiltInFictitiousFunctionClassFactory = context;
            this.getAuthRequestContext = intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public Intent BuiltInFictitiousFunctionClassFactory;
        public Context PlaceComponentResult;

        public /* synthetic */ b(Context context, Intent intent, byte b) {
            this(context, intent);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] byteArrayExtra = this.BuiltInFictitiousFunctionClassFactory.getByteArrayExtra("device_token");
                if (byteArrayExtra != null && byteArrayExtra.length != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("receive a push token: ");
                    sb.append(this.PlaceComponentResult.getPackageName());
                    HMSLog.i("PushReceiver", sb.toString());
                    Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                    intent.setPackage(this.BuiltInFictitiousFunctionClassFactory.getPackage());
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.MessagePayloadKeys.MESSAGE_TYPE, "new_token");
                    bundle.putString("device_token", w.getAuthRequestContext(byteArrayExtra));
                    bundle.putString("transaction_id", this.BuiltInFictitiousFunctionClassFactory.getStringExtra("transaction_id"));
                    bundle.putString("subjectId", this.BuiltInFictitiousFunctionClassFactory.getStringExtra("subjectId"));
                    bundle.putInt("error", this.BuiltInFictitiousFunctionClassFactory.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode()));
                    bundle.putString("belongId", this.BuiltInFictitiousFunctionClassFactory.getStringExtra("belongId"));
                    if (new h().MyBillsEntityDataFactory(this.PlaceComponentResult, bundle, intent)) {
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("receive ");
                    sb2.append(this.BuiltInFictitiousFunctionClassFactory.getAction());
                    sb2.append(" and start service failed");
                    HMSLog.e("PushReceiver", sb2.toString());
                    return;
                }
                HMSLog.i("PushReceiver", "get a deviceToken, but it is null or empty");
            } catch (RejectedExecutionException unused) {
                HMSLog.e("PushReceiver", "execute task error");
            } catch (Exception unused2) {
                HMSLog.e("PushReceiver", "handle push token error");
            }
        }

        private b(Context context, Intent intent) {
            this.PlaceComponentResult = context;
            this.BuiltInFictitiousFunctionClassFactory = intent;
        }
    }

    public final void b(Context context, Intent intent) {
        try {
            if (intent.hasExtra("device_token")) {
                v.getAuthRequestContext().execute(new b(context, intent, (byte) 0));
            } else {
                HMSLog.i("PushReceiver", "This message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.e("PushReceiver", "handlePushTokenEvent execute task error");
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("push receive broadcast message, Intent:");
        sb.append(intent.getAction());
        sb.append(" pkgName:");
        sb.append(context.getPackageName());
        HMSLog.i("PushReceiver", sb.toString());
        try {
            intent.getStringExtra("TestIntent");
            String action = intent.getAction();
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                b(context, intent);
            } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                a(context, intent);
            } else {
                HMSLog.i("PushReceiver", "message can't be recognised.");
            }
        } catch (Exception unused) {
            HMSLog.e("PushReceiver", "intent has some error");
        }
    }

    public final void a(Context context, Intent intent) {
        try {
            if (intent.hasExtra("msg_data")) {
                v.getAuthRequestContext().execute(new a(context, intent, (byte) 0));
            } else {
                HMSLog.i("PushReceiver", "This push message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.e("PushReceiver", "handlePushMessageEvent execute task error");
        }
    }

    public static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("psContent");
        }
        return null;
    }

    public static JSONObject a(byte[] bArr) {
        try {
            return new JSONObject(w.getAuthRequestContext(bArr));
        } catch (JSONException unused) {
            HMSLog.w("PushReceiver", "JSONException:parse message body failed.");
            return null;
        }
    }

    public static JSONObject b(Intent intent) throws RuntimeException {
        JSONObject a2 = a(intent.getByteArrayExtra("msg_data"));
        JSONObject a3 = a(a2);
        String authRequestContext = JsonUtil.getAuthRequestContext(a3, "data", (String) null);
        if (s.MyBillsEntityDataFactory(a3, b(a3), authRequestContext)) {
            return a2;
        }
        if (TextUtils.isEmpty(authRequestContext)) {
            return null;
        }
        try {
            return new JSONObject(authRequestContext);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("msgContent");
        }
        return null;
    }
}
