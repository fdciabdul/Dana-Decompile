package fsimpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: fsimpl.bf  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C0255bf {

    /* renamed from: a  reason: collision with root package name */
    final boolean f7887a;
    final boolean b;
    final byte[] c;
    final byte[] d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0255bf(boolean z, boolean z2, byte[] bArr) {
        this.f7887a = z;
        this.b = z2;
        this.c = bArr;
        byte[] bArr2 = new byte[bArr.length];
        this.d = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        C0254be.b(this.d);
    }
}
