package com.alipay.mobile.rome.syncsdk.transport.b;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7242a = "c";

    public static a a(int i) {
        if (b.b == i) {
            return new d();
        }
        String str = f7242a;
        StringBuilder sb = new StringBuilder("getPacket: protoVersion not supported [ protoVersion=");
        sb.append(i);
        sb.append(" ]");
        com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
        return null;
    }
}
