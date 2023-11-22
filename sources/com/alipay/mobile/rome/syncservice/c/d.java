package com.alipay.mobile.rome.syncservice.c;

import android.text.TextUtils;
import com.alipay.msync.core.model.spcode.pb.ProtoBizSyncData;
import com.alipay.msync.core.model.spcode.pb.ProtoBizSyncInfo;
import com.alipay.msync.core.model.spcode.pb.ProtoSyncOpCode2001;
import com.alipay.msync.core.model.spcode.pb.ProtoSyncOpCode2002;
import com.squareup.wire.Message;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public final class d extends b<ProtoSyncOpCode2001> {
    @Override // com.alipay.mobile.rome.syncservice.c.b
    protected final boolean a() {
        return true;
    }

    @Override // com.alipay.mobile.rome.syncservice.c.b
    protected final int b() {
        return 2002;
    }

    @Override // com.alipay.mobile.rome.syncservice.c.a
    protected final /* synthetic */ void a(Object obj) {
        ProtoSyncOpCode2001 protoSyncOpCode2001 = (ProtoSyncOpCode2001) obj;
        if (protoSyncOpCode2001 == null || protoSyncOpCode2001.biz_sync_data == null) {
            return;
        }
        for (ProtoBizSyncData protoBizSyncData : protoSyncOpCode2001.biz_sync_data) {
            if (protoBizSyncData != null) {
                com.alipay.mobile.rome.syncservice.sync.register.a.a().a(protoBizSyncData.biz_order, protoBizSyncData.biz_type, protoBizSyncData.multi_device, protoSyncOpCode2001.principal_id_type, protoBizSyncData.persistent_biz);
            }
        }
    }

    @Override // com.alipay.mobile.rome.syncservice.c.a
    protected final /* synthetic */ com.alipay.mobile.rome.syncservice.model.a b(Object obj) {
        ProtoSyncOpCode2001 protoSyncOpCode2001 = (ProtoSyncOpCode2001) obj;
        if (protoSyncOpCode2001 != null && a(protoSyncOpCode2001.principal_id, protoSyncOpCode2001.not_check_principal, protoSyncOpCode2001.biz_sync_data)) {
            com.alipay.mobile.rome.syncservice.model.a aVar = new com.alipay.mobile.rome.syncservice.model.a();
            aVar.c = protoSyncOpCode2001.has_more_data;
            aVar.g = protoSyncOpCode2001.principal_id;
            aVar.h = protoSyncOpCode2001.principal_id_type;
            aVar.f7284a = a(a(protoSyncOpCode2001.biz_sync_data, protoSyncOpCode2001.principal_id, protoSyncOpCode2001.not_check_principal), protoSyncOpCode2001.biz_sync_data == null ? 0 : protoSyncOpCode2001.biz_sync_data.size());
            aVar.b = protoSyncOpCode2001.server_ip;
            return aVar;
        }
        return null;
    }

    public d() {
        this.b = 2001;
    }

    @Override // com.alipay.mobile.rome.syncservice.c.a
    /* renamed from: b */
    public ProtoSyncOpCode2001 a(byte[] bArr) {
        try {
            ProtoSyncOpCode2001 protoSyncOpCode2001 = (ProtoSyncOpCode2001) com.alipay.mobile.rome.syncsdk.util.f.a(bArr, ProtoSyncOpCode2001.class);
            if (protoSyncOpCode2001 == null) {
                a("pbError", "UNKNOWN", (String) null, "3005");
                return null;
            }
            return protoSyncOpCode2001;
        } catch (Exception e) {
            String str = this.f7274a;
            StringBuilder sb = new StringBuilder("parsePBData: [ Exception=");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
            a("pbError", "UNKNOWN", (String) null, "3005");
            return null;
        }
    }

    @Override // com.alipay.mobile.rome.syncservice.c.a
    protected final void a(com.alipay.mobile.rome.syncservice.model.a aVar) {
        if (aVar == null) {
            return;
        }
        List<com.alipay.mobile.rome.syncservice.model.c> list = aVar.f7284a;
        if (list == null || list.isEmpty()) {
            com.alipay.mobile.rome.syncsdk.util.c.d(this.f7274a, "dispatchBizData bizDataList is null.");
            return;
        }
        List<com.alipay.mobile.rome.syncservice.sync.d.a> list2 = list.get(0).f7286a;
        if (list2 == null) {
            return;
        }
        for (com.alipay.mobile.rome.syncservice.sync.d.a aVar2 : list2) {
            if (aVar2 != null && aVar2.l) {
                com.alipay.mobile.rome.syncservice.sync.e.a.b(aVar2);
                com.alipay.mobile.rome.syncservice.sync.e.a.c(aVar2);
            }
        }
    }

    @Override // com.alipay.mobile.rome.syncservice.c.b
    protected final Message a(List<com.alipay.mobile.rome.syncservice.model.c> list, Boolean bool, Integer num, String str) {
        ProtoSyncOpCode2002 protoSyncOpCode2002 = null;
        if (list != null && !list.isEmpty()) {
            com.alipay.mobile.rome.syncservice.model.c cVar = list.get(0);
            if (cVar.f7286a != null && !cVar.f7286a.isEmpty()) {
                protoSyncOpCode2002 = new ProtoSyncOpCode2002();
                LinkedList linkedList = new LinkedList();
                List<com.alipay.mobile.rome.syncservice.sync.d.a> list2 = cVar.f7286a;
                if (list2 != null && list2.size() > 0) {
                    for (com.alipay.mobile.rome.syncservice.sync.d.a aVar : list2) {
                        long a2 = com.alipay.mobile.rome.syncservice.sync.a.a().a(aVar.c, aVar.b);
                        if (Long.parseLong(aVar.d) < a2) {
                            aVar.d = String.valueOf(a2);
                        }
                        ProtoBizSyncInfo protoBizSyncInfo = new ProtoBizSyncInfo();
                        protoBizSyncInfo.biz_order = com.alipay.mobile.rome.syncservice.sync.register.a.a().a(aVar.c);
                        protoBizSyncInfo.sync_key = Long.valueOf(Long.parseLong(aVar.d));
                        linkedList.add(protoBizSyncInfo);
                    }
                    protoSyncOpCode2002.biz_sync_info = linkedList;
                }
                protoSyncOpCode2002.has_more_data = bool;
                protoSyncOpCode2002.principal_id = str;
                protoSyncOpCode2002.principal_id_type = num;
            }
        }
        return protoSyncOpCode2002;
    }

    @Override // com.alipay.mobile.rome.syncservice.c.b
    protected final long a(com.alipay.mobile.rome.syncservice.sync.d.a aVar) {
        if (aVar == null) {
            return -16L;
        }
        return com.alipay.mobile.rome.syncservice.sync.a.a().a(aVar.c, aVar.b);
    }

    @Override // com.alipay.mobile.rome.syncservice.c.b
    protected final void a(com.alipay.mobile.rome.syncservice.sync.d.a aVar, long j) {
        if (aVar != null && Long.parseLong(aVar.d) > j) {
            if (!TextUtils.isEmpty(aVar.f)) {
                aVar.l = true;
            } else if (TextUtils.isEmpty(aVar.f)) {
                com.alipay.mobile.rome.syncservice.sync.a.a().a(aVar.c, Long.parseLong(aVar.d), aVar.b);
            }
        }
    }
}
