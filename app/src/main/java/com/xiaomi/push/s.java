package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.C0221r;

/* loaded from: classes8.dex */
class s extends Handler {
    final /* synthetic */ C0221r getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(C0221r c0221r, Looper looper) {
        super(looper);
        this.getAuthRequestContext = c0221r;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0221r.b bVar = (C0221r.b) message.obj;
        if (message.what != 0 && message.what == 1) {
            bVar.MyBillsEntityDataFactory();
        }
        super.handleMessage(message);
    }
}
