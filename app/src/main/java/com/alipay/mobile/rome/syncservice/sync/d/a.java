package com.alipay.mobile.rome.syncservice.sync.d;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f7300a;
    public String d;
    public int g;
    public long h;
    public int i;
    public String b = "";
    public String c = "";
    public String e = "";
    public String f = "";
    public String j = "";
    public String k = "";
    public boolean l = false;

    public final String toString() {
        StringBuilder sb = new StringBuilder("SyncMsgDbModel [userId=");
        sb.append(this.b);
        sb.append(", biz=");
        sb.append(this.c);
        sb.append(", sKey=");
        sb.append(this.d);
        sb.append(", hm=");
        sb.append(this.e);
        sb.append(", md=");
        sb.append(this.f);
        sb.append(", sendNum=");
        sb.append(this.g);
        sb.append(", localTime=");
        sb.append(this.h);
        sb.append(", id=");
        sb.append(this.i);
        sb.append(",reserv1=");
        sb.append(this.j);
        sb.append(",sOpcode=");
        sb.append(this.f7300a);
        sb.append(",needDisptch=");
        sb.append(this.l);
        sb.append("]");
        return sb.toString();
    }
}
