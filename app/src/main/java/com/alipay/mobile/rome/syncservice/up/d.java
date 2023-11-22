package com.alipay.mobile.rome.syncservice.up;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

/* loaded from: classes3.dex */
public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f7311a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, Looper looper) {
        super(looper);
        this.f7311a = bVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        String str;
        String str2;
        String str3;
        String str4;
        super.handleMessage(message);
        int i = message.what;
        if (i != 10) {
            switch (i) {
                case 0:
                    str = b.f7309a;
                    com.alipay.mobile.rome.syncsdk.util.c.a(str, "SEND_SYNC_UNPLINK_DELAYED");
                    this.f7311a.a((com.alipay.mobile.rome.syncservice.sync.d.b) message.obj);
                    return;
                case 1:
                    str2 = b.f7309a;
                    com.alipay.mobile.rome.syncsdk.util.c.a(str2, "SYNC_UNPLINK_EXPIRED");
                    this.f7311a.c((com.alipay.mobile.rome.syncservice.sync.d.b) message.obj);
                    return;
                case 2:
                    b.a(this.f7311a);
                    return;
                case 3:
                    str3 = b.f7309a;
                    com.alipay.mobile.rome.syncsdk.util.c.a(str3, "RECV_SYNC_UNPLINK_ACK");
                    b.a(this.f7311a, message.arg1, (List) message.obj);
                    return;
                case 4:
                    b.a(this.f7311a, (c) message.obj);
                    return;
                case 5:
                    str4 = b.f7309a;
                    com.alipay.mobile.rome.syncsdk.util.c.a(str4, "CANCEL_SYNC_UPLINK");
                    b.c(this.f7311a, (com.alipay.mobile.rome.syncservice.sync.d.b) message.obj);
                    return;
                case 6:
                    b.a(this.f7311a, (String) message.obj);
                    return;
                default:
                    return;
            }
        }
        a aVar = (a) message.obj;
        if (aVar != null) {
            b.a(this.f7311a, aVar.f7308a, aVar.b, aVar.c);
        }
    }
}
