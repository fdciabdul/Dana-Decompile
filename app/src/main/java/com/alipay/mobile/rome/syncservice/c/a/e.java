package com.alipay.mobile.rome.syncservice.c.a;

import android.text.TextUtils;
import com.alipay.msync.core.model.spcode.pb.ProtoBizError;
import com.alipay.msync.core.model.spcode.pb.ProtoSyncOpCode4001;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class e extends a {
    @Override // com.alipay.mobile.rome.syncservice.c.a.a
    protected final byte[] b() {
        return new byte[0];
    }

    public static byte[] a(String str, String str2, String str3, String str4, long j) {
        try {
            Integer a2 = a(str2);
            ProtoSyncOpCode4001 protoSyncOpCode4001 = new ProtoSyncOpCode4001();
            if (j == -1 && a2.intValue() != -1 && !TextUtils.isEmpty(str2)) {
                j = com.alipay.mobile.rome.syncservice.sync.a.a().a(str2, str3);
            }
            ArrayList arrayList = new ArrayList();
            ProtoBizError protoBizError = new ProtoBizError();
            protoBizError.biz_order = a2;
            protoBizError.sync_key = Long.valueOf(j);
            protoBizError.error = str;
            protoBizError.error_code = str4;
            arrayList.add(protoBizError);
            protoSyncOpCode4001.biz_error = arrayList;
            protoSyncOpCode4001.principal_id = str3;
            return com.alipay.mobile.rome.syncsdk.util.f.a(protoSyncOpCode4001, 4001);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("send4001 Exception[");
            sb.append(e);
            sb.append("]");
            com.alipay.mobile.rome.syncsdk.util.c.d("Operation4001", sb.toString());
            return null;
        }
    }

    private static Integer a(String str) {
        int i = -1;
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            Integer a2 = com.alipay.mobile.rome.syncservice.sync.register.a.a().a(str);
            return a2 == null ? i : a2;
        }
    }
}
