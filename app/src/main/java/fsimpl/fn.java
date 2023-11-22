package fsimpl;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class fn {

    /* renamed from: a  reason: collision with root package name */
    protected int f7991a;
    protected ByteBuffer b;
    fo c = fo.a();
    private int d;
    private int e;

    protected static String a(int i, ByteBuffer byteBuffer, fo foVar) {
        int i2 = i + byteBuffer.getInt(i);
        return foVar.a(byteBuffer, i2 + 4, byteBuffer.getInt(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(int i) {
        if (i < this.e) {
            return this.b.getShort(this.d + i);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i, ByteBuffer byteBuffer) {
        this.b = byteBuffer;
        short s = 0;
        if (byteBuffer != null) {
            this.f7991a = i;
            int i2 = i - byteBuffer.getInt(i);
            this.d = i2;
            s = this.b.getShort(i2);
        } else {
            this.f7991a = 0;
            this.d = 0;
        }
        this.e = s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(int i) {
        return i + this.b.getInt(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String e(int i) {
        return a(i, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f(int i) {
        int i2 = i + this.f7991a;
        return this.b.getInt(i2 + this.b.getInt(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int g(int i) {
        int i2 = i + this.f7991a;
        return i2 + this.b.getInt(i2) + 4;
    }
}
