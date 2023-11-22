package com.alipay.mobile.rome.syncservice.c.a;

/* loaded from: classes3.dex */
public final class f extends a {
    @Override // com.alipay.mobile.rome.syncservice.c.a.a
    public final byte[] b() {
        return new byte[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0072 A[Catch: Exception -> 0x00bc, TryCatch #0 {Exception -> 0x00bc, blocks: (B:48:0x000b, B:49:0x0037, B:51:0x003d, B:53:0x0055, B:56:0x005d, B:58:0x006a, B:60:0x0072, B:61:0x007a, B:63:0x0080, B:65:0x0088, B:67:0x008c, B:68:0x009b, B:57:0x0060, B:69:0x00a7), top: B:76:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(int r9, java.util.List<com.alipay.mobile.rome.syncservice.sync.d.b> r10) {
        /*
            r0 = 0
            java.lang.String r1 = "Operation5001"
            if (r10 == 0) goto Ld5
            boolean r2 = r10.isEmpty()
            if (r2 != 0) goto Ld5
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Exception -> Lbc
            r2.<init>()     // Catch: java.lang.Exception -> Lbc
            int r3 = r10.size()     // Catch: java.lang.Exception -> Lbc
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbc
            java.lang.String r5 = "sendSync5001Msg[size="
            r4.<init>(r5)     // Catch: java.lang.Exception -> Lbc
            r4.append(r3)     // Catch: java.lang.Exception -> Lbc
            java.lang.String r3 = "][seq="
            r4.append(r3)     // Catch: java.lang.Exception -> Lbc
            r4.append(r9)     // Catch: java.lang.Exception -> Lbc
            java.lang.String r3 = "]"
            r4.append(r3)     // Catch: java.lang.Exception -> Lbc
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Exception -> Lbc
            com.alipay.mobile.rome.syncsdk.util.c.b(r1, r3)     // Catch: java.lang.Exception -> Lbc
            java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Exception -> Lbc
        L37:
            boolean r3 = r10.hasNext()     // Catch: java.lang.Exception -> Lbc
            if (r3 == 0) goto La7
            java.lang.Object r3 = r10.next()     // Catch: java.lang.Exception -> Lbc
            com.alipay.mobile.rome.syncservice.sync.d.b r3 = (com.alipay.mobile.rome.syncservice.sync.d.b) r3     // Catch: java.lang.Exception -> Lbc
            com.alipay.msync.core.model.spcode.pb.ProtoClientSyncData r4 = new com.alipay.msync.core.model.spcode.pb.ProtoClientSyncData     // Catch: java.lang.Exception -> Lbc
            r4.<init>()     // Catch: java.lang.Exception -> Lbc
            com.alipay.mobile.rome.syncservice.sync.register.a r5 = com.alipay.mobile.rome.syncservice.sync.register.a.a()     // Catch: java.lang.Exception -> Lbc
            java.lang.String r6 = r3.biz     // Catch: java.lang.Exception -> Lbc
            java.lang.Integer r5 = r5.a(r6)     // Catch: java.lang.Exception -> Lbc
            r6 = 0
            if (r5 == 0) goto L60
            int r7 = r5.intValue()     // Catch: java.lang.Exception -> Lbc
            r8 = -1
            if (r7 != r8) goto L5d
            goto L60
        L5d:
            r4.biz_order = r5     // Catch: java.lang.Exception -> Lbc
            goto L6a
        L60:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> Lbc
            r4.biz_order = r5     // Catch: java.lang.Exception -> Lbc
            java.lang.String r5 = r3.biz     // Catch: java.lang.Exception -> Lbc
            r4.biz_type = r5     // Catch: java.lang.Exception -> Lbc
        L6a:
            java.lang.String r5 = r3.msgData     // Catch: java.lang.Exception -> Lbc
            r4.payload = r5     // Catch: java.lang.Exception -> Lbc
            byte[] r5 = r3.msgData_pb     // Catch: java.lang.Exception -> Lbc
            if (r5 == 0) goto L7a
            byte[] r5 = r3.msgData_pb     // Catch: java.lang.Exception -> Lbc
            okio.ByteString r5 = okio.ByteString.of(r5)     // Catch: java.lang.Exception -> Lbc
            r4.binary_payload = r5     // Catch: java.lang.Exception -> Lbc
        L7a:
            com.alipay.mobile.rome.syncservice.up.SyncUplinkCallbackType r5 = r3.h     // Catch: java.lang.Exception -> Lbc
            com.alipay.mobile.rome.syncservice.up.SyncUplinkCallbackType r7 = com.alipay.mobile.rome.syncservice.up.SyncUplinkCallbackType.TYPE_LIKE_RPC     // Catch: java.lang.Exception -> Lbc
            if (r5 != r7) goto L9b
            java.lang.String r5 = r3.msgData     // Catch: java.lang.Exception -> Lbc
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> Lbc
            if (r5 == 0) goto L9b
            java.io.Serializable r5 = r3.reqData     // Catch: java.lang.Exception -> Lbc
            if (r5 == 0) goto L9b
            java.io.Serializable r5 = r3.reqData     // Catch: java.lang.Exception -> Lbc
            r7 = 1
            com.alibaba.fastjson.serializer.SerializerFeature[] r7 = new com.alibaba.fastjson.serializer.SerializerFeature[r7]     // Catch: java.lang.Exception -> Lbc
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect     // Catch: java.lang.Exception -> Lbc
            r7[r6] = r8     // Catch: java.lang.Exception -> Lbc
            java.lang.String r5 = com.alibaba.fastjson.JSON.toJSONString(r5, r7)     // Catch: java.lang.Exception -> Lbc
            r4.payload = r5     // Catch: java.lang.Exception -> Lbc
        L9b:
            java.lang.String r5 = r3.b     // Catch: java.lang.Exception -> Lbc
            r4.cmk = r5     // Catch: java.lang.Exception -> Lbc
            java.lang.String r3 = r3.bizId     // Catch: java.lang.Exception -> Lbc
            r4.biz_id = r3     // Catch: java.lang.Exception -> Lbc
            r2.add(r4)     // Catch: java.lang.Exception -> Lbc
            goto L37
        La7:
            com.alipay.msync.core.model.spcode.pb.ProtoSyncOpCode5001 r10 = new com.alipay.msync.core.model.spcode.pb.ProtoSyncOpCode5001     // Catch: java.lang.Exception -> Lbc
            r10.<init>()     // Catch: java.lang.Exception -> Lbc
            r10.client_sync_data = r2     // Catch: java.lang.Exception -> Lbc
            long r2 = (long) r9     // Catch: java.lang.Exception -> Lbc
            java.lang.Long r9 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Exception -> Lbc
            r10.seq = r9     // Catch: java.lang.Exception -> Lbc
            r9 = 5001(0x1389, float:7.008E-42)
            byte[] r0 = com.alipay.mobile.rome.syncsdk.util.f.a(r10, r9)     // Catch: java.lang.Exception -> Lbc
            goto Ld4
        Lbc:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r2 = "sendSync5001Msg [ Exception="
            r10.<init>(r2)
            r10.append(r9)
            java.lang.String r9 = " ]"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.alipay.mobile.rome.syncsdk.util.c.d(r1, r9)
        Ld4:
            return r0
        Ld5:
            java.lang.String r9 = "sendSync5001Msg: uplinkMsgItemList size is zero or null"
            com.alipay.mobile.rome.syncsdk.util.c.a(r1, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncservice.c.a.f.a(int, java.util.List):byte[]");
    }
}
