package com.alipay.mobile.rome.syncservice.c;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alipay.mobile.rome.syncservice.model.DownstreamDataRequest;
import com.alipay.mobile.rome.syncservice.model.ResultCodeEnum;
import com.alipay.mobile.rome.syncservice.sync.register.Biz;
import com.alipay.msync.core.model.spcode.pb.ProtoBizSyncData;
import com.alipay.msync.core.model.spcode.pb.ProtoOplog;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class b<T> extends a<T> {
    protected boolean d;

    protected abstract long a(com.alipay.mobile.rome.syncservice.sync.d.a aVar);

    protected abstract Message a(List<com.alipay.mobile.rome.syncservice.model.c> list, Boolean bool, Integer num, String str);

    protected abstract void a(com.alipay.mobile.rome.syncservice.sync.d.a aVar, long j);

    protected abstract boolean a();

    protected abstract int b();

    @Override // com.alipay.mobile.rome.syncservice.c.a
    public final void a(DownstreamDataRequest downstreamDataRequest) {
        this.d = false;
        super.a(downstreamDataRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <K> List<com.alipay.mobile.rome.syncservice.sync.d.a> a(List<K> list, String str, Boolean bool) {
        com.alipay.mobile.rome.syncservice.model.b bVar;
        com.alipay.mobile.rome.syncservice.sync.d.a a2;
        if (list == null || list.isEmpty()) {
            com.alipay.mobile.rome.syncsdk.util.c.d(this.f7274a, ": no data!");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (K k : list) {
            synchronized (com.alipay.mobile.rome.syncservice.d.d.f7281a) {
                if (k != null) {
                    if (k instanceof ProtoBizSyncData) {
                        bVar = new com.alipay.mobile.rome.syncservice.model.b((ProtoBizSyncData) k);
                        a2 = a(bVar, str, bool);
                    } else {
                        String str2 = this.f7274a;
                        StringBuilder sb = new StringBuilder("transfer: unknown object:");
                        sb.append(k);
                        com.alipay.mobile.rome.syncsdk.util.c.a(str2, sb.toString());
                    }
                }
                bVar = null;
                a2 = a(bVar, str, bool);
            }
            if (!a()) {
                return null;
            }
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<com.alipay.mobile.rome.syncservice.model.c> a(List<com.alipay.mobile.rome.syncservice.sync.d.a> list, int i) {
        if (list == null || list.isEmpty() || (list != null && list.size() != i)) {
            com.alipay.mobile.rome.syncsdk.util.c.a(this.f7274a, "something error occured!");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.alipay.mobile.rome.syncservice.model.c(list));
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x01bb, code lost:
    
        if (r1.f7287a != com.alipay.mobile.rome.syncservice.model.ResultCodeEnum.ERROR) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01bd, code lost:
    
        r12.l = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1 A[Catch: all -> 0x01c0, TRY_LEAVE, TryCatch #0 {all -> 0x01c0, blocks: (B:20:0x0065, B:23:0x006d, B:28:0x0078, B:30:0x0086, B:32:0x0099, B:34:0x00a1, B:31:0x008f, B:39:0x00c1, B:43:0x0106, B:47:0x011b, B:71:0x01b3, B:46:0x0113, B:48:0x012a, B:49:0x0131, B:53:0x013a, B:55:0x0156, B:57:0x015e, B:59:0x017a, B:61:0x017e, B:64:0x018a, B:68:0x019f, B:67:0x0197, B:70:0x01ae, B:72:0x01b7, B:74:0x01bd), top: B:82:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00c0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alipay.mobile.rome.syncservice.sync.d.a a(com.alipay.mobile.rome.syncservice.model.b r24, java.lang.String r25, java.lang.Boolean r26) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncservice.c.b.a(com.alipay.mobile.rome.syncservice.model.b, java.lang.String, java.lang.Boolean):com.alipay.mobile.rome.syncservice.sync.d.a");
    }

    private com.alipay.mobile.rome.syncservice.model.d a(com.alipay.mobile.rome.syncservice.sync.d.a aVar, List<ProtoOplog> list, long j, StringBuilder sb) {
        JSONObject jSONObject;
        if (aVar == null) {
            sb.append("(packet is null)");
            return new com.alipay.mobile.rome.syncservice.model.d(ResultCodeEnum.ERROR);
        }
        sb.append("(");
        if (list == null || list.isEmpty()) {
            StringBuilder sb2 = new StringBuilder("localSyncKey=");
            sb2.append(j);
            sb2.append(")");
            sb.append(sb2.toString());
            return new com.alipay.mobile.rome.syncservice.model.d(ResultCodeEnum.SUCCESS);
        }
        com.alipay.mobile.rome.syncservice.model.d dVar = new com.alipay.mobile.rome.syncservice.model.d(ResultCodeEnum.SUCCESS);
        try {
            JSONArray jSONArray = new JSONArray();
            for (ProtoOplog protoOplog : list) {
                if (protoOplog != null) {
                    Long l = protoOplog.mk;
                    String str = protoOplog.payload;
                    ByteString byteString = protoOplog.binary_payload;
                    boolean z = true;
                    if (TextUtils.isEmpty(str) && byteString == null) {
                        a("payload_null", aVar.c, aVar.b, "3003", l == null ? -1L : l.longValue());
                        this.d = true;
                        com.alipay.mobile.rome.syncsdk.util.c.d(this.f7274a, "checkPayload: [ payload &  binary_payload is null.]");
                        z = false;
                    }
                    if (z) {
                        sb.append(protoOplog.mk);
                        if (protoOplog.mk.longValue() > j) {
                            if (protoOplog == null) {
                                jSONObject = null;
                            } else {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("mk", protoOplog.mk);
                                jSONObject2.put(RVParams.SHOW_TITLEBAR, protoOplog.st);
                                jSONObject2.put("bId", protoOplog.biz_id);
                                jSONObject2.put("ext", protoOplog.ext);
                                jSONObject2.put("mct", protoOplog.mct);
                                if (!TextUtils.isEmpty(protoOplog.payload)) {
                                    jSONObject2.put(RVParams.PREFETCH_LOCATION, protoOplog.payload);
                                } else if (protoOplog.binary_payload != null) {
                                    jSONObject2.put(RVParams.PREFETCH_LOCATION, a(protoOplog.binary_payload));
                                    jSONObject2.put("isB", "1");
                                }
                                jSONObject = jSONObject2;
                            }
                            jSONArray.put(jSONObject);
                        } else {
                            sb.append("-r");
                        }
                        sb.append(" ");
                    }
                }
            }
            aVar.f = "";
            if (jSONArray.length() > 0) {
                aVar.f = jSONArray.toString();
            }
        } catch (Exception e) {
            String str2 = this.f7274a;
            StringBuilder sb3 = new StringBuilder("parsePacketMsgData: ");
            sb3.append(e);
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb3.toString());
        }
        sb.append(")");
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(String str, Boolean bool, List<ProtoBizSyncData> list) {
        if (TextUtils.isEmpty(str)) {
            if (bool != null && !bool.booleanValue()) {
                com.alipay.mobile.rome.syncsdk.util.c.d(this.f7274a, "checkUIDAvailability exception: principal is null, but not_check_principal equal false");
                return false;
            }
        } else if (!TextUtils.equals(str, com.alipay.mobile.rome.syncsdk.a.a.a().f7211a) && !TextUtils.equals(str, com.alipay.mobile.rome.syncsdk.a.a.a().e())) {
            String str2 = this.f7274a;
            StringBuilder sb = new StringBuilder("checkUIDAvailability: [ uid unmatched, Client(");
            sb.append(com.alipay.mobile.rome.syncsdk.a.a.a().f7211a);
            sb.append(") Server(");
            sb.append(str);
            sb.append(")] ");
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb.toString());
            a("msg_dismatch_exception", a(list), com.alipay.mobile.rome.syncsdk.a.a.a().e(), "3004");
            this.d = true;
            return false;
        }
        return true;
    }

    private static String a(List<ProtoBizSyncData> list) {
        Biz a2;
        if (list == null || list.isEmpty()) {
            return "No_Biz";
        }
        StringBuilder sb = new StringBuilder(64);
        for (ProtoBizSyncData protoBizSyncData : list) {
            if (!TextUtils.isEmpty(protoBizSyncData.biz_type)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(protoBizSyncData.biz_type);
                sb2.append(",");
                sb.append(sb2.toString());
            } else if (protoBizSyncData.biz_order != null && (a2 = com.alipay.mobile.rome.syncservice.sync.register.a.a().a(protoBizSyncData.biz_order)) != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(a2.f7304a);
                sb3.append(",");
                sb.append(sb3.toString());
            }
        }
        return sb.toString();
    }

    private String a(ByteString byteString) {
        if (byteString != null) {
            try {
                return byteString.base64();
            } catch (Throwable th) {
                String str = this.f7274a;
                StringBuilder sb = new StringBuilder("convertToBase64: [ Exception=");
                sb.append(th);
                sb.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
                return "";
            }
        }
        return "";
    }

    private byte[] b(List<com.alipay.mobile.rome.syncservice.model.c> list, Boolean bool, Integer num, String str) {
        try {
            return com.alipay.mobile.rome.syncsdk.util.f.a(a(list, bool, num, str), b());
        } catch (Exception e) {
            String str2 = this.f7274a;
            StringBuilder sb = new StringBuilder("getRespDataStream: [ Exception=");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb.toString());
            return null;
        }
    }

    @Override // com.alipay.mobile.rome.syncservice.c.a
    protected final void a(com.alipay.mobile.rome.syncservice.model.a aVar, DownstreamDataRequest.DataSource dataSource) {
        String str = "UNKNOWN";
        if (aVar == null) {
            com.alipay.mobile.rome.syncsdk.util.c.a(this.f7274a, "handlePacketResponse: packet is null");
            b("otherError", "UNKNOWN", (String) null, "3006");
        } else if (TextUtils.equals(aVar.d, "8001")) {
            com.alipay.mobile.rome.syncsdk.util.c.a(this.f7274a, "handlePacketResponse 8001 needn't to response.");
        } else {
            List<com.alipay.mobile.rome.syncservice.model.c> list = aVar.f7284a;
            if (list == null || list.size() <= 0) {
                com.alipay.mobile.rome.syncsdk.util.c.a(this.f7274a, "handlePacketResponse: list is null or empty");
                b("otherError", "UNKNOWN", (String) null, "3006");
                return;
            }
            try {
                byte[] b = b(list, aVar.c, aVar.h, aVar.g);
                if (b == null) {
                    b("otherError", "UNKNOWN", (String) null, "3006");
                    return;
                }
                long length = b.length;
                int i = c.f7277a[dataSource.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        com.alipay.mobile.rome.syncservice.a.a.a().a(b);
                    } else if (i != 3) {
                        com.alipay.mobile.rome.syncsdk.util.c.a(this.f7274a, "handleResponse no dataSource found.");
                    }
                }
                if (list != null && !list.isEmpty()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Iterator<com.alipay.mobile.rome.syncservice.model.c> it = list.iterator();
                    while (it.hasNext()) {
                        List<com.alipay.mobile.rome.syncservice.sync.d.a> list2 = it.next().f7286a;
                        if (list2 != null && !list2.isEmpty()) {
                            for (com.alipay.mobile.rome.syncservice.sync.d.a aVar2 : list2) {
                                if (stringBuffer.length() == 0) {
                                    stringBuffer.append(aVar2.c);
                                } else {
                                    StringBuilder sb = new StringBuilder(",");
                                    sb.append(aVar2.c);
                                    stringBuffer.append(sb.toString());
                                }
                            }
                        }
                    }
                    str = stringBuffer.toString();
                }
                try {
                    String str2 = this.f7274a;
                    StringBuilder sb2 = new StringBuilder("handleResponse");
                    sb2.append(this.b);
                    sb2.append("[dataSource:");
                    sb2.append(dataSource);
                    sb2.append("][ip:");
                    sb2.append((String) null);
                    sb2.append("][biz:");
                    sb2.append(str);
                    sb2.append("][");
                    sb2.append(b(list));
                    sb2.append("] datasize:");
                    sb2.append(length);
                    com.alipay.mobile.rome.syncsdk.util.c.a(str2, sb2.toString());
                } catch (Throwable th) {
                    th = th;
                    String str3 = this.f7274a;
                    StringBuilder sb3 = new StringBuilder("handlePacketResp:  [ Exception=");
                    sb3.append(th);
                    sb3.append(" ]");
                    com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb3.toString());
                    b("otherError", str, (String) null, "3006");
                }
            } catch (Throwable th2) {
                th = th2;
                str = null;
            }
        }
    }

    private static String b(List<com.alipay.mobile.rome.syncservice.model.c> list) {
        List<com.alipay.mobile.rome.syncservice.sync.d.a> list2;
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (com.alipay.mobile.rome.syncservice.model.c cVar : list) {
            if (cVar != null && (list2 = cVar.f7286a) != null && list2.size() > 0) {
                sb.append(list2.get(0).d);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, str4, -1L);
    }

    private static void a(String str, String str2, String str3, String str4, long j) {
        com.alipay.mobile.rome.syncservice.sync.b.a().a(str, str2, str3, str4, j);
    }

    private void b(String str, String str2, String str3, String str4) {
        b(str, str2, str3, str4, -1L);
    }

    private void b(String str, String str2, String str3, String str4, long j) {
        if (this.d) {
            return;
        }
        a(str, str2, str3, str4, j);
    }
}
