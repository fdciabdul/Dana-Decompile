package com.alipay.mobile.rome.syncservice.sync.c;

import android.text.TextUtils;
import com.alipay.mobile.rome.longlinkservice.syncmodel.SyncMessage;
import com.alipay.mobile.rome.syncservice.sync.register.Biz;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7295a = "a";
    private static final ConcurrentHashMap<String, b> b = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> c = new ConcurrentHashMap<>();

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = f7295a;
        StringBuilder sb = new StringBuilder("setBizDispatchFailedFlag: ");
        sb.append(str);
        com.alipay.mobile.rome.syncsdk.util.c.a(str2, sb.toString());
        c.put(str, Boolean.TRUE);
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c.remove(str);
    }

    private static com.alipay.mobile.rome.syncservice.sync.d.a e(String str) {
        String str2;
        com.alipay.mobile.rome.syncservice.sync.d.a b2;
        Biz.BizDimeEnum b3 = com.alipay.mobile.rome.syncservice.sync.register.a.a().b(str);
        if (b3 == Biz.BizDimeEnum.DEVICE) {
            str2 = com.alipay.mobile.rome.syncsdk.a.a.a().e();
        } else if (b3 != Biz.BizDimeEnum.USER) {
            com.alipay.mobile.rome.syncsdk.util.c.c(f7295a, "dispatchBiz: [ unknown biz ]");
            return null;
        } else {
            str2 = com.alipay.mobile.rome.syncsdk.a.a.a().f7211a;
        }
        if (TextUtils.isEmpty(str2)) {
            com.alipay.mobile.rome.syncsdk.util.c.c(f7295a, "dispatchBiz: [ userId=null ]");
            return null;
        }
        try {
            com.alipay.mobile.rome.syncservice.sync.b.a.a a2 = com.alipay.mobile.rome.syncservice.sync.b.a.a.a(com.alipay.mobile.rome.syncservice.d.a.f7279a);
            if (a2.d.get()) {
                com.alipay.mobile.rome.syncsdk.util.c.a(com.alipay.mobile.rome.syncservice.sync.b.a.a.f7292a, "queryMsgByBiz...db recreating~");
                b2 = null;
            } else {
                b2 = a2.c.b(str2, str);
            }
            if (b2 == null) {
                String str3 = f7295a;
                StringBuilder sb = new StringBuilder("dispatchBiz: [uid=");
                sb.append(str2);
                sb.append("][biz=");
                sb.append(str);
                sb.append(" ], no msg found");
                com.alipay.mobile.rome.syncsdk.util.c.c(str3, sb.toString());
                return null;
            }
            return b2;
        } catch (Throwable th) {
            String str4 = f7295a;
            StringBuilder sb2 = new StringBuilder("dispatchBiz: [ Exception=");
            sb2.append(th);
            sb2.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str4, sb2.toString());
            return null;
        }
    }

    public static void a() {
        com.alipay.mobile.rome.syncsdk.util.c.b(f7295a, "checkAllBizNeedDispatch:");
        for (String str : com.alipay.mobile.rome.syncservice.sync.register.a.a().e) {
            if (com.alipay.mobile.rome.syncservice.sync.register.c.b(str) != null && !f(str)) {
                c(str);
            }
        }
    }

    private static boolean f(String str) {
        ScheduledFuture scheduledFuture;
        b bVar = b.get(str);
        if (bVar == null || (scheduledFuture = bVar.f7296a) == null || scheduledFuture.isDone() || scheduledFuture.isCancelled()) {
            return false;
        }
        String str2 = f7295a;
        StringBuilder sb = new StringBuilder("isBizDispatching:[ biz=");
        sb.append(str);
        sb.append(" ][ isDispatch=true ]");
        com.alipay.mobile.rome.syncsdk.util.c.b(str2, sb.toString());
        return true;
    }

    public static void d(String str) {
        ScheduledFuture scheduledFuture;
        b bVar = b.get(str);
        if (bVar == null || (scheduledFuture = bVar.f7296a) == null) {
            return;
        }
        scheduledFuture.cancel(true);
    }

    public static void a(SyncMessage syncMessage) {
        String str = syncMessage.userId;
        String str2 = syncMessage.biz;
        String str3 = syncMessage.f7210id;
        String str4 = str3.split(",")[0];
        d(str2);
        int a2 = com.alipay.mobile.rome.syncservice.sync.b.a.a.a(com.alipay.mobile.rome.syncservice.d.a.f7279a).a(str, str2, Integer.parseInt(str4));
        String str5 = f7295a;
        StringBuilder sb = new StringBuilder("dispatchMsgFailed[ userId=");
        sb.append(str);
        sb.append(" ][ biz=");
        sb.append(str2);
        sb.append(" ][ id=");
        sb.append(str3);
        sb.append(" ] deleteResult:");
        sb.append(a2);
        com.alipay.mobile.rome.syncsdk.util.c.c(str5, sb.toString());
        c(str2);
    }

    public static void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            com.alipay.mobile.rome.syncsdk.util.c.b(f7295a, "bizReportMsgReceived: id is null");
            return;
        }
        String str4 = f7295a;
        StringBuilder sb = new StringBuilder("bizReportMsgReceived:");
        sb.append(str);
        sb.append(" / ");
        sb.append(str2);
        sb.append(" / ");
        sb.append(str3);
        com.alipay.mobile.rome.syncsdk.util.c.a(str4, sb.toString());
        b(str2);
        String[] split = str3.split(",");
        if (split == null || split.length <= 2) {
            return;
        }
        int a2 = com.alipay.mobile.rome.syncservice.sync.b.a.a.a(com.alipay.mobile.rome.syncservice.d.a.f7279a).a(str, str2, Integer.parseInt(split[0]));
        String str5 = split.length > 3 ? split[2] : split[1];
        if (a2 == 0 && "4".equals(split[split.length - 1])) {
            com.alipay.mobile.rome.syncsdk.util.c.a(str4, "handleBizReportReceived: data is not lost");
            com.alipay.mobile.rome.syncservice.sync.b.a().a("msgNotLost", str2, str, "3009", com.alipay.mobile.rome.syncservice.d.b.b(str5));
        }
        if (a2 > 0) {
            d(str2);
        }
        b bVar = b.get(str2);
        if (bVar != null && !com.alipay.mobile.rome.syncservice.d.b.a(bVar.b, str5)) {
            StringBuilder sb2 = new StringBuilder("dispatch ack not match: ");
            sb2.append(bVar.b);
            sb2.append(", ack id: ");
            sb2.append(str5);
            com.alipay.mobile.rome.syncsdk.util.c.a(str4, sb2.toString());
            return;
        }
        c(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncservice.sync.c.a.c(java.lang.String):void");
    }
}
