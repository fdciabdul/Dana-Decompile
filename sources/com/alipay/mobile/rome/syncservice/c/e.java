package com.alipay.mobile.rome.syncservice.c;

import android.os.Message;
import com.alipay.mobile.rome.syncservice.model.DownstreamDataRequest;
import com.alipay.msync.core.model.spcode.pb.ProtoClientSyncAck;
import com.alipay.msync.core.model.spcode.pb.ProtoSyncOpCode5002;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class e extends a<ProtoSyncOpCode5002> {
    @Override // com.alipay.mobile.rome.syncservice.c.a
    protected final void a(com.alipay.mobile.rome.syncservice.model.a aVar, DownstreamDataRequest.DataSource dataSource) {
    }

    @Override // com.alipay.mobile.rome.syncservice.c.a
    protected final /* synthetic */ void a(ProtoSyncOpCode5002 protoSyncOpCode5002) {
        ProtoSyncOpCode5002 protoSyncOpCode50022 = protoSyncOpCode5002;
        if (protoSyncOpCode50022 == null || protoSyncOpCode50022.ack_msg == null) {
            return;
        }
        for (ProtoClientSyncAck protoClientSyncAck : protoSyncOpCode50022.ack_msg) {
            if (protoClientSyncAck != null) {
                com.alipay.mobile.rome.syncservice.sync.register.a.a().a(protoClientSyncAck.biz_order, protoClientSyncAck.biz_type);
            }
        }
    }

    @Override // com.alipay.mobile.rome.syncservice.c.a
    protected final /* synthetic */ com.alipay.mobile.rome.syncservice.model.a b(ProtoSyncOpCode5002 protoSyncOpCode5002) {
        ProtoSyncOpCode5002 protoSyncOpCode50022 = protoSyncOpCode5002;
        if (protoSyncOpCode50022 == null) {
            return null;
        }
        List<ProtoClientSyncAck> list = protoSyncOpCode50022.ack_msg;
        if (list == null || list.isEmpty()) {
            com.alipay.mobile.rome.syncsdk.util.c.d(this.f7274a, "handleSyncUplinkAckMsg: ackMsgList is null or size 0 ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("handleSyncUplinkAckMsg 5002 size=");
        sb.append(list.size());
        StringBuffer stringBuffer = new StringBuffer(sb.toString());
        for (ProtoClientSyncAck protoClientSyncAck : list) {
            com.alipay.mobile.rome.syncservice.sync.d.b bVar = new com.alipay.mobile.rome.syncservice.sync.d.b();
            bVar.biz = com.alipay.mobile.rome.syncservice.sync.register.a.a().b(protoClientSyncAck.biz_order);
            bVar.b = protoClientSyncAck.cmk;
            String[] split = bVar.b.split("_");
            bVar.e = com.alipay.mobile.rome.syncservice.d.b.a(split[0]);
            bVar.d = Integer.parseInt(split[1]);
            bVar.f7301a = Long.parseLong(split[2]);
            StringBuilder sb2 = new StringBuilder(" [");
            sb2.append(bVar.biz);
            sb2.append("(");
            sb2.append(bVar.b);
            sb2.append(")]");
            stringBuffer.append(sb2.toString());
            arrayList.add(bVar);
        }
        com.alipay.mobile.rome.syncsdk.util.c.b(this.f7274a, stringBuffer.toString());
        com.alipay.mobile.rome.syncservice.model.a aVar = new com.alipay.mobile.rome.syncservice.model.a();
        aVar.e = protoSyncOpCode50022.seq.intValue();
        aVar.f = arrayList;
        return aVar;
    }

    public e() {
        this.b = 5002;
    }

    @Override // com.alipay.mobile.rome.syncservice.c.a
    protected final void a(com.alipay.mobile.rome.syncservice.model.a aVar) {
        if (aVar == null) {
            return;
        }
        com.alipay.mobile.rome.syncservice.up.b a2 = com.alipay.mobile.rome.syncservice.up.b.a();
        int i = aVar.e;
        List<com.alipay.mobile.rome.syncservice.sync.d.b> list = aVar.f;
        if (list == null || list.isEmpty()) {
            com.alipay.mobile.rome.syncsdk.util.c.a(com.alipay.mobile.rome.syncservice.up.b.f7309a, "recvSyncUplinkAck uplinkMsgItemList is null or size 0");
            return;
        }
        Message obtainMessage = a2.b.obtainMessage(3, list);
        obtainMessage.arg1 = i;
        a2.b.sendMessage(obtainMessage);
    }

    @Override // com.alipay.mobile.rome.syncservice.c.a
    protected final /* bridge */ /* synthetic */ ProtoSyncOpCode5002 a(byte[] bArr) {
        return (ProtoSyncOpCode5002) com.alipay.mobile.rome.syncsdk.util.f.a(bArr, ProtoSyncOpCode5002.class);
    }
}
