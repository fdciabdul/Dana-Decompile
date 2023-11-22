package com.ta.utdid2.a.a;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class b {
    static final /* synthetic */ boolean j = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class a {
        public int op;
        public byte[] output;

        a() {
        }
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        C0149b c0149b = new C0149b(i3, new byte[(i2 * 3) / 4]);
        if (!c0149b.process(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (c0149b.op == c0149b.output.length) {
            return c0149b.output;
        }
        byte[] bArr2 = new byte[c0149b.op];
        System.arraycopy(c0149b.output, 0, bArr2, 0, c0149b.op);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ta.utdid2.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0149b extends a {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f7686a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private final int[] c;
        private int state;
        private int value;

        public C0149b(int i, byte[] bArr) {
            this.output = bArr;
            this.c = (i & 8) == 0 ? f7686a : b;
            this.state = 0;
            this.value = 0;
        }

        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.state;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = this.c;
            int i6 = i5;
            int i7 = 0;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4 || (i6 = (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9 + 2] & 255] << 6) | iArr[bArr[i9 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i7 + 2] = (byte) i6;
                        bArr2[i7 + 1] = (byte) (i6 >> 8);
                        bArr2[i7] = (byte) (i6 >> 16);
                        i7 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = iArr[bArr[i9] & 255];
                if (i8 != 0) {
                    if (i8 == 1) {
                        if (i11 < 0) {
                            if (i11 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i11 |= i6 << 6;
                    } else if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 != 4) {
                                if (i8 == 5 && i11 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            } else if (i11 == -2) {
                                i8++;
                            } else if (i11 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i11 >= 0) {
                            int i12 = (i6 << 6) | i11;
                            bArr2[i7 + 2] = (byte) i12;
                            bArr2[i7 + 1] = (byte) (i12 >> 8);
                            bArr2[i7] = (byte) (i12 >> 16);
                            i7 += 3;
                            i6 = i12;
                            i8 = 0;
                        } else if (i11 == -2) {
                            bArr2[i7 + 1] = (byte) (i6 >> 2);
                            bArr2[i7] = (byte) (i6 >> 10);
                            i7 += 2;
                            i8 = 5;
                        } else if (i11 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i11 >= 0) {
                        i11 |= i6 << 6;
                    } else if (i11 == -2) {
                        bArr2[i7] = (byte) (i6 >> 4);
                        i7++;
                        i8 = 4;
                    } else if (i11 != -1) {
                        this.state = 6;
                        return false;
                    }
                    i8++;
                    i6 = i11;
                } else {
                    if (i11 < 0) {
                        if (i11 != -1) {
                            this.state = 6;
                            return false;
                        }
                    }
                    i8++;
                    i6 = i11;
                }
                i9++;
            }
            if (!z) {
                this.state = i8;
                this.value = i6;
                this.op = i7;
                return true;
            } else if (i8 == 1) {
                this.state = 6;
                return false;
            } else {
                if (i8 == 2) {
                    bArr2[i7] = (byte) (i6 >> 4);
                    i7++;
                } else if (i8 == 3) {
                    int i13 = i7 + 1;
                    bArr2[i7] = (byte) (i6 >> 10);
                    i7 = i13 + 1;
                    bArr2[i13] = (byte) (i6 >> 2);
                } else if (i8 == 4) {
                    this.state = 6;
                    return false;
                }
                this.state = i8;
                this.op = i7;
                return true;
            }
        }
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        c cVar = new c(i3, null);
        int i4 = (i2 / 3) * 4;
        if (cVar.do_padding) {
            if (i2 % 3 > 0) {
                i4 += 4;
            }
        } else {
            int i5 = i2 % 3;
            if (i5 == 1) {
                i4 += 2;
            } else if (i5 == 2) {
                i4 += 3;
            }
        }
        if (cVar.do_newline && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (cVar.do_cr ? 2 : 1);
        }
        cVar.output = new byte[i4];
        cVar.process(bArr, i, i2, true);
        if (j || cVar.op == i4) {
            return cVar.output;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f7687a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 43, 47};
        private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 45, 95};
        static final /* synthetic */ boolean j = true;

        /* renamed from: b  reason: collision with other field name */
        int f57b;
        private final byte[] c;
        private int count;
        private final byte[] d;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;

        public c(int i, byte[] bArr) {
            this.output = bArr;
            this.do_padding = (i & 1) == 0;
            boolean z = (i & 2) == 0;
            this.do_newline = z;
            this.do_cr = (i & 4) != 0;
            this.d = (i & 8) == 0 ? f7687a : b;
            this.c = new byte[2];
            this.f57b = 0;
            this.count = z ? 19 : -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00fc  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x01ce  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01db A[ADDED_TO_REGION] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ee -> B:32:0x00f4). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00f7 -> B:34:0x00f8). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean process(byte[] r19, int r20, int r21, boolean r22) {
            /*
                Method dump skipped, instructions count: 529
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.a.a.b.c.process(byte[], int, int, boolean):boolean");
        }
    }

    private b() {
    }
}
