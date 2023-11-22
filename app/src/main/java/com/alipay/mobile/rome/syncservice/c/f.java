package com.alipay.mobile.rome.syncservice.c;

import com.alipay.mobile.rome.syncservice.sync.register.Biz;
import com.alipay.msync.core.model.spcode.pb.ProtoSyncOpCode8001;
import com.squareup.wire.Message;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class f extends b<ProtoSyncOpCode8001> {
    @Override // com.alipay.mobile.rome.syncservice.c.b
    protected final long a(com.alipay.mobile.rome.syncservice.sync.d.a aVar) {
        return 0L;
    }

    @Override // com.alipay.mobile.rome.syncservice.c.b
    protected final Message a(List<com.alipay.mobile.rome.syncservice.model.c> list, Boolean bool, Integer num, String str) {
        return null;
    }

    @Override // com.alipay.mobile.rome.syncservice.c.a
    protected final void a(com.alipay.mobile.rome.syncservice.model.a aVar) {
    }

    @Override // com.alipay.mobile.rome.syncservice.c.b
    protected final void a(com.alipay.mobile.rome.syncservice.sync.d.a aVar, long j) {
    }

    @Override // com.alipay.mobile.rome.syncservice.c.a
    protected final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    @Override // com.alipay.mobile.rome.syncservice.c.b
    protected final boolean a() {
        return false;
    }

    @Override // com.alipay.mobile.rome.syncservice.c.b
    protected final int b() {
        return 0;
    }

    @Override // com.alipay.mobile.rome.syncservice.c.a
    protected final /* synthetic */ com.alipay.mobile.rome.syncservice.model.a b(Object obj) {
        String e;
        ProtoSyncOpCode8001 protoSyncOpCode8001 = (ProtoSyncOpCode8001) obj;
        if (protoSyncOpCode8001 == null) {
            return null;
        }
        com.alipay.mobile.rome.syncservice.model.a aVar = new com.alipay.mobile.rome.syncservice.model.a();
        aVar.d = "8001";
        List<Integer> list = protoSyncOpCode8001.biz_order;
        if (list != null && list.size() > 0) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                Biz a2 = next != null ? com.alipay.mobile.rome.syncservice.sync.register.a.a().a(next) : null;
                if (a2 == null) {
                    String str = this.f7274a;
                    StringBuilder sb = new StringBuilder("handleDownstreamDataPacket local doesn't exist this biz[");
                    sb.append(next);
                    sb.append("]");
                    com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
                    return null;
                }
                if (a2.f != Biz.BizDimeEnum.USER) {
                    e = a2.f == Biz.BizDimeEnum.DEVICE ? com.alipay.mobile.rome.syncsdk.a.a.a().e() : "";
                } else {
                    e = com.alipay.mobile.rome.syncsdk.a.a.a().f7211a;
                }
                String str2 = a2.f7304a;
                int a3 = com.alipay.mobile.rome.syncservice.sync.b.a.a.a(com.alipay.mobile.rome.syncservice.d.a.f7279a).c.a(e, str2);
                String str3 = this.f7274a;
                StringBuilder sb2 = new StringBuilder("deleteData[ ");
                sb2.append(str2);
                sb2.append(" / ");
                sb2.append(e);
                sb2.append(" ] count:");
                sb2.append(a3);
                com.alipay.mobile.rome.syncsdk.util.c.a(str3, sb2.toString());
                String str4 = a2.f7304a;
                com.alipay.mobile.rome.syncservice.sync.a a4 = com.alipay.mobile.rome.syncservice.sync.a.a();
                Biz.BizDimeEnum b = com.alipay.mobile.rome.syncservice.sync.register.a.a().b(str4);
                if (b == Biz.BizDimeEnum.DEVICE) {
                    StringBuilder sb3 = new StringBuilder("deviceId_");
                    sb3.append(str4);
                    a4.b(sb3.toString());
                } else if (b == Biz.BizDimeEnum.USER) {
                    StringBuilder sb4 = new StringBuilder("sync_");
                    sb4.append(e);
                    sb4.append("_");
                    sb4.append(str4);
                    a4.b(sb4.toString());
                }
                String str5 = a2.f7304a;
                com.alipay.mobile.rome.syncservice.sync.register.a a5 = com.alipay.mobile.rome.syncservice.sync.register.a.a();
                a5.j.f7306a.edit().remove(str5).commit();
                StringBuilder sb5 = new StringBuilder("deleteBizConfigInfo:");
                sb5.append(str5);
                sb5.append(" successful");
                com.alipay.mobile.rome.syncsdk.util.c.b("DynamicBizConfigStorage", sb5.toString());
                a5.b.remove(str5);
                a5.c.remove(next);
                a5.d.remove(str5);
                a5.e.remove(str5);
                a5.f.remove(next);
                a5.g.remove(next);
                a5.h.remove(next);
                a5.i.remove(next);
            }
        }
        return aVar;
    }

    public f() {
        this.b = 8001;
    }

    @Override // com.alipay.mobile.rome.syncservice.c.a
    /* renamed from: b */
    public ProtoSyncOpCode8001 a(byte[] bArr) {
        try {
            ProtoSyncOpCode8001 protoSyncOpCode8001 = (ProtoSyncOpCode8001) com.alipay.mobile.rome.syncsdk.util.f.a(bArr, ProtoSyncOpCode8001.class);
            if (protoSyncOpCode8001 == null) {
                return null;
            }
            return protoSyncOpCode8001;
        } catch (Exception e) {
            String str = this.f7274a;
            StringBuilder sb = new StringBuilder("parsePBData: [ Exception=");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
            return null;
        }
    }
}
