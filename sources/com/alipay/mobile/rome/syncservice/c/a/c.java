package com.alipay.mobile.rome.syncservice.c.a;

import android.text.TextUtils;
import com.alipay.msync.core.model.spcode.pb.ProtoBizSyncInfo;
import com.alipay.msync.core.model.spcode.pb.ProtoSyncOpCode3001;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public final class c extends a {
    @Override // com.alipay.mobile.rome.syncservice.c.a.a
    public final byte[] b() {
        String str;
        byte[] bArr = null;
        try {
            str = com.alipay.mobile.rome.syncsdk.a.a.a().f7211a;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("sendSync3001:  [ Exception=");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d("Operation3001", sb.toString());
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().f())) {
            ProtoSyncOpCode3001 protoSyncOpCode3001 = new ProtoSyncOpCode3001();
            protoSyncOpCode3001.user_id = str;
            List<Integer> list = com.alipay.mobile.rome.syncservice.sync.register.a.a().f;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (Integer num : list) {
                    ProtoBizSyncInfo protoBizSyncInfo = new ProtoBizSyncInfo();
                    protoBizSyncInfo.biz_order = num;
                    protoBizSyncInfo.sync_key = Long.valueOf(com.alipay.mobile.rome.syncservice.sync.a.a().a(com.alipay.mobile.rome.syncservice.sync.register.a.a().b(num), null));
                    linkedList.add(protoBizSyncInfo);
                }
                protoSyncOpCode3001.biz_sync_info = linkedList;
            }
            StringBuilder sb2 = new StringBuilder(64);
            bArr = com.alipay.mobile.rome.syncsdk.util.f.a(protoSyncOpCode3001, 3001);
            StringBuilder sb3 = new StringBuilder("sendSync3001 dataLength(");
            sb3.append(bArr.length);
            sb3.append(") bizTypeNum:");
            sb3.append(list == null ? 0 : list.size());
            sb3.append(" ");
            sb3.append((Object) sb2);
            com.alipay.mobile.rome.syncsdk.util.c.a("Operation3001", sb3.toString());
            return bArr;
        }
        com.alipay.mobile.rome.syncsdk.util.c.c("Operation3001", "sendSync3001：[ userId or session isEmpty ]");
        return null;
    }
}
