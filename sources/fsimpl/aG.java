package fsimpl;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

/* loaded from: classes8.dex */
class aG extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FileOutputStream f7824a;
    final /* synthetic */ MessageDigest b;
    final /* synthetic */ aE c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aG(aE aEVar, FileOutputStream fileOutputStream, MessageDigest messageDigest) {
        this.c = aEVar;
        this.f7824a = fileOutputStream;
        this.b = messageDigest;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f7824a.write(i);
        this.b.update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f7824a.write(bArr);
        this.b.update(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f7824a.write(bArr, i, i2);
        this.b.update(bArr, i, i2);
    }
}
