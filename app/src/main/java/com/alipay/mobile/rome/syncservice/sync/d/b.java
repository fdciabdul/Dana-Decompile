package com.alipay.mobile.rome.syncservice.sync.d;

import android.text.TextUtils;
import com.alipay.mobile.rome.longlinkservice.syncmodel.SyncUpMessage;
import com.alipay.mobile.rome.syncservice.up.SyncUplinkCallbackType;

/* loaded from: classes3.dex */
public final class b extends SyncUpMessage {

    /* renamed from: a  reason: collision with root package name */
    public long f7301a;
    public String b;
    public String c;
    public int d;
    public long e;
    public int f;
    public boolean g;
    public SyncUplinkCallbackType h;
    public String i;

    public b() {
        this.g = false;
    }

    public b(SyncUpMessage syncUpMessage) {
        super(syncUpMessage);
        this.g = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return TextUtils.equals(this.b, bVar.b) || (this.f7301a == bVar.f7301a && this.e == bVar.e && this.d == bVar.d);
        }
        return false;
    }

    @Override // com.alipay.mobile.rome.longlinkservice.syncmodel.SyncUpMessage
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[msgId=");
        sb.append(this.b);
        sb.append(",sendImmediate=");
        sb.append(this.g);
        sb.append(",callbackType=");
        sb.append(this.h.ordinal());
        sb.append(",sendStatus=");
        sb.append(this.f);
        sb.append(",userId=");
        sb.append(this.c);
        sb.append("]");
        return sb.toString();
    }

    public final int hashCode() {
        if (TextUtils.isEmpty(this.b)) {
            long j = this.f7301a;
            long j2 = this.e;
            return ((((((int) (j ^ (j >>> 32))) + 629) * 37) + ((int) (j2 ^ (j2 >>> 32)))) * 37) + this.d;
        }
        return this.b.hashCode() + 629;
    }
}
