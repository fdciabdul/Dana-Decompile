package com.alipay.mobile.rome.syncservice.up;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile int f7310a;
    public volatile int b = 0;

    public c(int i) {
        this.f7310a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f7310a == ((c) obj).f7310a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[sequence=");
        sb.append(this.f7310a);
        sb.append(", retryTimes=");
        sb.append(this.b);
        sb.append("]");
        return sb.toString();
    }

    public final int hashCode() {
        return this.f7310a + 629;
    }
}
