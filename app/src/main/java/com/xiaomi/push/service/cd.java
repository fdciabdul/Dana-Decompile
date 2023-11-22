package com.xiaomi.push.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/* loaded from: classes8.dex */
class cd extends Handler {
    final /* synthetic */ XMPushService getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(XMPushService xMPushService) {
        this.getAuthRequestContext = xMPushService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message != null) {
            try {
                int i = message.what;
                if (i == 17) {
                    if (message.obj != null) {
                        this.getAuthRequestContext.onStart((Intent) message.obj, 1);
                    }
                } else if (i == 18) {
                    Message obtain = Message.obtain((Handler) null, 0);
                    obtain.what = 18;
                    Bundle bundle = new Bundle();
                    bundle.putString("xmsf_region", a.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getApplicationContext()).KClassImpl$Data$declaredNonStaticMembers$2());
                    obtain.setData(bundle);
                    message.replyTo.send(obtain);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
