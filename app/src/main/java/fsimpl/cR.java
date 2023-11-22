package fsimpl;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: classes.dex */
public class cR {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f7902a = new byte[256];
    private static final byte[] b = new byte[256];
    private static final byte[] c = new byte[256];
    private static final byte[] d = new byte[512];
    private static byte e;

    static {
        b((byte) 0, (byte) 0);
        b((byte) 1, (byte) 1);
        a(Ascii.DC4, (byte) 2, (byte) 1);
        a((byte) 13, (byte) 2, (byte) 3);
        a((byte) 2, (byte) 3, (byte) 2);
        b((byte) 8, (byte) 2);
        b(Ascii.NAK, (byte) 6);
        b((byte) 10, (byte) 11);
        b((byte) 14, (byte) 9);
        b((byte) 15, (byte) 10);
        b((byte) 6, (byte) 8);
        b((byte) 7, (byte) 9);
        b((byte) 4, (byte) 8);
        b((byte) 5, (byte) 9);
        b((byte) 22, (byte) 5);
        b((byte) 82, (byte) 1);
        b((byte) 81, (byte) 4);
        b((byte) 89, (byte) 2);
        a((byte) 80, (byte) 2, (byte) 2);
        a((byte) 86, (byte) 2, (byte) 4);
        b((byte) 88, (byte) 6);
        b((byte) 83, (byte) 4);
        b((byte) 84, (byte) 2);
        b((byte) 93, (byte) 6);
        b((byte) 94, (byte) 2);
        b((byte) 90, (byte) 2);
        b((byte) 91, (byte) 9);
        b((byte) 85, (byte) 2);
        b((byte) 95, (byte) 2);
        b((byte) 96, (byte) 2);
        a((byte) 97, (byte) 2, (byte) 5);
        b((byte) 87, (byte) 11);
        b((byte) 92, (byte) 1);
        b(Ascii.ESC, (byte) 2);
    }

    public static byte a(byte b2) {
        return b[b2];
    }

    public static void a(byte b2, byte b3) {
        if (f7902a[b2] == b3) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected a ");
        sb.append((int) f7902a[b2]);
        sb.append(" (was ");
        sb.append((int) b3);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    private static void a(byte b2, byte b3, byte b4) {
        byte[] bArr = b;
        byte b5 = e;
        bArr[b2] = b5;
        f7902a[b2] = b3;
        c[b5] = b2;
        if (b5 > 0) {
            byte[] bArr2 = d;
            int i = (b5 - 1) * 2;
            bArr2[i] = b2;
            bArr2[i + 1] = (byte) ((b4 << 4) | b3);
        }
        e = (byte) (e + 1);
    }

    public static byte[] a() {
        return Arrays.copyOf(d, e * 2);
    }

    private static void b(byte b2, byte b3) {
        a(b2, b3, (byte) 0);
    }
}
