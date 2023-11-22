package com.alipay.mobile.rome.syncservice.c.a;

import android.text.TextUtils;
import com.alipay.msync.core.model.spcode.pb.ProtoBizSyncInfo;
import com.alipay.msync.core.model.spcode.pb.ProtoSyncOpCode1001;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public final class b extends a {
    @Override // com.alipay.mobile.rome.syncservice.c.a.a
    protected final byte[] b() {
        Boolean bool;
        List<Integer> list;
        try {
            ProtoSyncOpCode1001 protoSyncOpCode1001 = new ProtoSyncOpCode1001();
            com.alipay.mobile.rome.syncservice.a.a.a();
            boolean z = true;
            if (TextUtils.equals(com.alipay.mobile.rome.syncservice.sync.a.a().a("new_device"), "false")) {
                bool = Boolean.FALSE;
            } else {
                bool = Boolean.TRUE;
            }
            protoSyncOpCode1001.is_new_device = bool;
            String str = com.alipay.mobile.rome.syncsdk.a.a.a().f7211a;
            int i = 0;
            if (TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().f()) || TextUtils.isEmpty(str)) {
                z = false;
            }
            com.alipay.mobile.rome.syncservice.sync.register.a a2 = com.alipay.mobile.rome.syncservice.sync.register.a.a();
            if (z) {
                list = new ArrayList();
                list.addAll(a2.h);
                list.addAll(a2.f);
            } else {
                list = a2.h;
            }
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (Integer num : list) {
                    ProtoBizSyncInfo protoBizSyncInfo = new ProtoBizSyncInfo();
                    protoBizSyncInfo.biz_order = num;
                    protoBizSyncInfo.sync_key = Long.valueOf(com.alipay.mobile.rome.syncservice.sync.a.a().a(com.alipay.mobile.rome.syncservice.sync.register.a.a().b(num), null));
                    linkedList.add(protoBizSyncInfo);
                }
                protoSyncOpCode1001.biz_sync_info = linkedList;
            }
            StringBuilder sb = new StringBuilder(64);
            byte[] a3 = com.alipay.mobile.rome.syncsdk.util.f.a(protoSyncOpCode1001, 1001);
            StringBuilder sb2 = new StringBuilder("sendSync1001 dataLength(");
            sb2.append(a3.length);
            sb2.append(") bizTypeNum:");
            if (list != null) {
                i = list.size();
            }
            sb2.append(i);
            sb2.append((Object) sb);
            com.alipay.mobile.rome.syncsdk.util.c.a("Operation1001", sb2.toString());
            return a3;
        } catch (Throwable th) {
            StringBuilder sb3 = new StringBuilder("sendSync1001:  [ Exception=");
            sb3.append(th);
            sb3.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d("Operation1001", sb3.toString());
            return null;
        }
    }
}
