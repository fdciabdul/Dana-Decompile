package fsimpl;

import java.util.Arrays;

/* loaded from: classes.dex */
public class eJ implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f7955a = new int[0];
    private int[] b;
    private int c;

    public eJ() {
        this(10);
    }

    public eJ(int i) {
        if (i == 0) {
            this.b = f7955a;
        } else {
            this.b = c(i);
        }
        this.c = 0;
    }

    private void b(int i) {
        int i2 = this.c;
        int i3 = i + i2;
        if (i3 >= this.b.length) {
            int i4 = (i2 < 6 ? 12 : i2 >> 1) + i2;
            if (i4 > i3) {
                i3 = i4;
            }
            int[] c = c(i3);
            System.arraycopy(this.b, 0, c, 0, i2);
            this.b = c;
        }
    }

    private static void b(int i, int i2) {
        if (i2 < 0 || i <= i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("length=");
            sb.append(i);
            sb.append("; index=");
            sb.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
    }

    private static int[] c(int i) {
        return new int[i];
    }

    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public eJ clone() {
        eJ eJVar = (eJ) super.clone();
        eJVar.b = (int[]) this.b.clone();
        return eJVar;
    }

    public void a(int i) {
        a(this.c, i);
    }

    public void a(int i, int i2) {
        b(1);
        int i3 = this.c;
        int i4 = i3 - i;
        int i5 = i3 + 1;
        this.c = i5;
        b(i5, i);
        if (i4 != 0) {
            int[] iArr = this.b;
            System.arraycopy(iArr, i, iArr, i + 1, i4);
        }
        this.b[i] = i2;
    }

    public int b() {
        return this.c;
    }

    public int[] c() {
        return Arrays.copyOf(this.b, this.c);
    }
}
