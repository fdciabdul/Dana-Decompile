package fsimpl;

/* loaded from: classes8.dex */
public class eK {

    /* renamed from: a  reason: collision with root package name */
    private final float f7956a;
    private int[] b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public eK(int i, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("FillFactor must be in (0, 1)");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("Size must be positive!");
        }
        int a2 = eL.a(i, f);
        this.g = a2 - 1;
        int i2 = a2 * 2;
        this.h = i2 - 1;
        this.f7956a = f;
        this.b = new int[i2];
        this.e = (int) (a2 * f);
    }

    private int c(int i) {
        int i2;
        int i3;
        int[] iArr = this.b;
        while (true) {
            int i4 = i + 2;
            while (true) {
                i2 = i4 & this.h;
                i3 = iArr[i2];
                if (i3 == 0) {
                    iArr[i] = 0;
                    return i;
                }
                int a2 = (eL.a(i3) & this.g) << 1;
                if (i > i2) {
                    if (i >= a2 && a2 > i2) {
                        break;
                    }
                    i4 = i2 + 2;
                } else if (i < a2 && a2 <= i2) {
                    i4 = i2 + 2;
                }
            }
            iArr[i] = i3;
            iArr[i + 1] = iArr[i2 + 1];
            i = i2;
        }
    }

    private void d(int i) {
        int i2 = i / 2;
        this.e = (int) (i2 * this.f7956a);
        this.g = i2 - 1;
        this.h = i - 1;
        int[] iArr = this.b;
        int length = iArr.length;
        this.b = new int[i];
        this.f = this.c ? 1 : 0;
        for (int i3 = 0; i3 < length; i3 += 2) {
            int i4 = iArr[i3];
            if (i4 != 0) {
                b(i4, iArr[i3 + 1]);
            }
        }
    }

    public int a() {
        return this.f;
    }

    public int a(int i) {
        return a(i, 0);
    }

    public int a(int i, int i2) {
        int[] iArr;
        int i3;
        int a2 = (eL.a(i) & this.g) << 1;
        if (i == 0) {
            return this.c ? this.d : i2;
        }
        int[] iArr2 = this.b;
        int i4 = iArr2[a2];
        if (i4 == 0) {
            return i2;
        }
        if (i4 == i) {
            return iArr2[a2 + 1];
        }
        do {
            a2 = (a2 + 2) & this.h;
            iArr = this.b;
            i3 = iArr[a2];
            if (i3 == 0) {
                return i2;
            }
        } while (i3 != i);
        return iArr[a2 + 1];
    }

    public int b(int i) {
        int i2;
        if (i == 0) {
            if (this.c) {
                this.c = false;
                this.f--;
                return this.d;
            }
            return 0;
        }
        int a2 = (eL.a(i) & this.g) << 1;
        int[] iArr = this.b;
        int i3 = iArr[a2];
        if (i3 == i) {
            int i4 = iArr[a2 + 1];
            c(a2);
            this.f--;
            return i4;
        }
        if (i3 == 0) {
            return 0;
        }
        do {
            a2 = (a2 + 2) & this.h;
            int[] iArr2 = this.b;
            i2 = iArr2[a2];
            if (i2 == i) {
                int i5 = iArr2[a2 + 1];
                c(a2);
                this.f--;
                return i5;
            }
        } while (i2 != 0);
        return 0;
    }

    public int b(int i, int i2) {
        int[] iArr;
        int i3;
        if (i == 0) {
            int i4 = this.d;
            if (!this.c) {
                this.f++;
            }
            this.c = true;
            this.d = i2;
            return i4;
        }
        int a2 = (eL.a(i) & this.g) << 1;
        int[] iArr2 = this.b;
        int i5 = iArr2[a2];
        if (i5 == 0) {
            iArr2[a2] = i;
            iArr2[a2 + 1] = i2;
            int i6 = this.f;
            if (i6 >= this.e) {
                d(iArr2.length * 2);
            } else {
                this.f = i6 + 1;
            }
            return 0;
        }
        if (i5 == i) {
            int i7 = a2 + 1;
            int i8 = iArr2[i7];
            iArr2[i7] = i2;
            return i8;
        }
        do {
            a2 = (a2 + 2) & this.h;
            iArr = this.b;
            i3 = iArr[a2];
            if (i3 == 0) {
                iArr[a2] = i;
                iArr[a2 + 1] = i2;
                int i9 = this.f;
                if (i9 >= this.e) {
                    d(iArr.length * 2);
                } else {
                    this.f = i9 + 1;
                }
                return 0;
            }
        } while (i3 != i);
        int i10 = a2 + 1;
        int i11 = iArr[i10];
        iArr[i10] = i2;
        return i11;
    }
}
