package com.alipay.mobile.rome.syncservice.sync.c;

import android.text.TextUtils;
import com.alipay.mobile.rome.longlinkservice.ISyncCallback;
import com.alipay.mobile.rome.longlinkservice.syncmodel.SyncMessage;
import com.alipay.mobile.rome.syncservice.sync.register.Biz;

/* loaded from: classes3.dex */
public final class e implements Runnable {

    /* renamed from: a */
    String f7299a;
    int b;
    SyncMessage c;
    String d;
    int e;
    String f;

    public e(SyncMessage syncMessage, String str, int i) {
        this.f7299a = syncMessage.biz;
        this.b = i;
        this.c = syncMessage;
        this.d = str;
        this.e = i;
        this.f = syncMessage.f7210id;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (this.e >= com.alipay.mobile.rome.syncservice.sync.a.a.b()) {
            str5 = c.f7297a;
            com.alipay.mobile.rome.syncsdk.util.c.a(str5, "DispatchMsgTask: start send number exceed 6");
            a.a(this.c);
            return;
        }
        ISyncCallback b = com.alipay.mobile.rome.syncservice.sync.register.c.b(this.f7299a);
        if (b == null) {
            str4 = c.f7297a;
            StringBuilder sb = new StringBuilder("DispatchMsgTask: run: [ getBizCallback return null ][ biz=");
            sb.append(this.f7299a);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.c(str4, sb.toString());
            a.d(this.f7299a);
        } else if (com.alipay.mobile.rome.syncservice.sync.register.a.a().b(this.f7299a) == Biz.BizDimeEnum.USER && TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().f7211a)) {
            str3 = c.f7297a;
            StringBuilder sb2 = new StringBuilder("DispatchMsgTask: run: [ userId null ][ biz=");
            sb2.append(this.f7299a);
            sb2.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.c(str3, sb2.toString());
            a.d(this.f7299a);
        } else {
            this.b++;
            str = c.f7297a;
            StringBuilder sb3 = new StringBuilder("DispatchMsgTask: run: [ biz=");
            sb3.append(this.f7299a);
            sb3.append(" ][");
            sb3.append(this.d);
            sb3.append(" ] sendNum:");
            sb3.append(this.b);
            sb3.append(" startSendNum=");
            sb3.append(this.e);
            com.alipay.mobile.rome.syncsdk.util.c.a(str, sb3.toString());
            if (this.b <= com.alipay.mobile.rome.syncservice.sync.a.a.b()) {
                if (this.b == 4 && this.e != 3) {
                    a.a(this.f7299a);
                    a.d(this.f7299a);
                    return;
                }
                try {
                    String str6 = this.c.f7210id.split(",")[0];
                    com.alipay.mobile.rome.syncservice.sync.b.a.a a2 = com.alipay.mobile.rome.syncservice.sync.b.a.a.a(com.alipay.mobile.rome.syncservice.d.a.f7279a);
                    int parseInt = Integer.parseInt(str6);
                    if (a2.d.get()) {
                        com.alipay.mobile.rome.syncsdk.util.c.a(com.alipay.mobile.rome.syncservice.sync.b.a.a.f7292a, "addMsgSendNum...db recreating~");
                    } else {
                        com.alipay.mobile.rome.syncservice.sync.b.a.a.b bVar = a2.c;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("UPDATE ");
                        sb4.append("sync_dispatch");
                        sb4.append(" SET sendNum = sendNum + 1 ");
                        sb4.append(" WHERE id = ");
                        sb4.append(parseInt);
                        bVar.a(sb4.toString());
                    }
                    SyncMessage syncMessage = this.c;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.f);
                    sb5.append(",");
                    sb5.append(this.b);
                    syncMessage.f7210id = sb5.toString();
                    SyncMessage syncMessage2 = this.c;
                    b.onReceiveMessage(syncMessage2.clone(syncMessage2));
                    return;
                } catch (Exception e) {
                    str2 = c.f7297a;
                    StringBuilder sb6 = new StringBuilder("DispatchMsgTask: run: [ addMsgSendNum ][ Exception=");
                    sb6.append(e);
                    sb6.append(" ]");
                    com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb6.toString());
                    a.d(this.f7299a);
                    return;
                }
            }
            String str7 = this.c.userId;
            a.b(this.f7299a);
            a.a(this.c);
            com.alipay.mobile.rome.syncservice.sync.b.a().a("dispatchMsgFailed", this.f7299a, str7, "3002", com.alipay.mobile.rome.syncservice.d.b.b(this.d));
        }
    }
}
