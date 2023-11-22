package fsimpl;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class fq extends fo {
    private static int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new fr(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r9 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.lang.CharSequence r7, byte[] r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.fq.a(java.lang.CharSequence, byte[], int, int):int");
    }

    public static String a(byte[] bArr, int i, int i2) {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = bArr[i];
                if (!fp.a(b)) {
                    break;
                }
                i++;
                fp.a(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b2 = bArr[i];
                if (fp.a(b2)) {
                    fp.a(b2, cArr, i5);
                    i = i6;
                    i5++;
                    while (i < i3) {
                        byte b3 = bArr[i];
                        if (fp.a(b3)) {
                            i++;
                            fp.a(b3, cArr, i5);
                            i5++;
                        }
                    }
                } else {
                    if (fp.b(b2)) {
                        if (i6 >= i3) {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                        fp.a(b2, bArr[i6], cArr, i5);
                        i = i6 + 1;
                    } else if (fp.c(b2)) {
                        if (i6 >= i3 - 1) {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                        int i7 = i6 + 1;
                        fp.a(b2, bArr[i6], bArr[i7], cArr, i5);
                        i = i7 + 1;
                    } else if (i6 >= i3 - 2) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    } else {
                        int i8 = i6 + 1;
                        int i9 = i8 + 1;
                        fp.a(b2, bArr[i6], bArr[i8], bArr[i9], cArr, i5);
                        i = i9 + 1;
                        i5 = i5 + 1 + 1;
                    }
                    i5++;
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    private static int b(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += a(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(i2 + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    public static String b(ByteBuffer byteBuffer, int i, int i2) {
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = byteBuffer.get(i);
                if (!fp.a(b)) {
                    break;
                }
                i++;
                fp.a(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b2 = byteBuffer.get(i);
                if (fp.a(b2)) {
                    fp.a(b2, cArr, i5);
                    i = i6;
                    i5++;
                    while (i < i3) {
                        byte b3 = byteBuffer.get(i);
                        if (fp.a(b3)) {
                            i++;
                            fp.a(b3, cArr, i5);
                            i5++;
                        }
                    }
                } else {
                    if (fp.b(b2)) {
                        if (i6 >= i3) {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                        fp.a(b2, byteBuffer.get(i6), cArr, i5);
                        i = i6 + 1;
                    } else if (fp.c(b2)) {
                        if (i6 >= i3 - 1) {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                        int i7 = i6 + 1;
                        fp.a(b2, byteBuffer.get(i6), byteBuffer.get(i7), cArr, i5);
                        i = i7 + 1;
                    } else if (i6 >= i3 - 2) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    } else {
                        int i8 = i6 + 1;
                        int i9 = i8 + 1;
                        fp.a(b2, byteBuffer.get(i6), byteBuffer.get(i8), byteBuffer.get(i9), cArr, i5);
                        i = i9 + 1;
                        i5 = i5 + 1 + 1;
                    }
                    i5++;
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    private static void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i2 = 0;
        while (i2 < length) {
            try {
                char charAt = charSequence.charAt(i2);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i2, (byte) charAt);
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                i = position;
                int position2 = byteBuffer.position();
                int max = Math.max(i2, (i - byteBuffer.position()) + 1);
                StringBuilder sb = new StringBuilder();
                sb.append("Failed writing ");
                sb.append(charSequence.charAt(i2));
                sb.append(" at index ");
                sb.append(position2 + max);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
        }
        if (i2 == length) {
            byteBuffer.position(position + i2);
            return;
        }
        int i3 = position + i2;
        while (i2 < length) {
            char charAt2 = charSequence.charAt(i2);
            if (charAt2 < 128) {
                byteBuffer.put(i3, (byte) charAt2);
            } else if (charAt2 < 2048) {
                int i4 = i3 + 1;
                try {
                    byteBuffer.put(i3, (byte) ((charAt2 >>> 6) | 192));
                    byteBuffer.put(i4, (byte) ((charAt2 & '?') | 128));
                    i3 = i4;
                } catch (IndexOutOfBoundsException unused2) {
                    i = i4;
                    int position22 = byteBuffer.position();
                    int max2 = Math.max(i2, (i - byteBuffer.position()) + 1);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed writing ");
                    sb2.append(charSequence.charAt(i2));
                    sb2.append(" at index ");
                    sb2.append(position22 + max2);
                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                }
            } else if (charAt2 >= 55296 && 57343 >= charAt2) {
                int i5 = i2 + 1;
                if (i5 != length) {
                    try {
                        char charAt3 = charSequence.charAt(i5);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            i = i3 + 1;
                            try {
                                byteBuffer.put(i3, (byte) ((codePoint >>> 18) | 240));
                                int i6 = i + 1;
                                byteBuffer.put(i, (byte) (((codePoint >>> 12) & 63) | 128));
                                int i7 = i6 + 1;
                                byteBuffer.put(i6, (byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put(i7, (byte) ((codePoint & 63) | 128));
                                i3 = i7;
                                i2 = i5;
                            } catch (IndexOutOfBoundsException unused3) {
                                i2 = i5;
                                int position222 = byteBuffer.position();
                                int max22 = Math.max(i2, (i - byteBuffer.position()) + 1);
                                StringBuilder sb22 = new StringBuilder();
                                sb22.append("Failed writing ");
                                sb22.append(charSequence.charAt(i2));
                                sb22.append(" at index ");
                                sb22.append(position222 + max22);
                                throw new ArrayIndexOutOfBoundsException(sb22.toString());
                            }
                        } else {
                            i2 = i5;
                        }
                    } catch (IndexOutOfBoundsException unused4) {
                        i = i3;
                    }
                }
                throw new fr(i2, length);
            } else {
                int i8 = i3 + 1;
                byteBuffer.put(i3, (byte) ((charAt2 >>> '\f') | 224));
                i3 = i8 + 1;
                byteBuffer.put(i8, (byte) (((charAt2 >>> 6) & 63) | 128));
                byteBuffer.put(i3, (byte) ((charAt2 & '?') | 128));
            }
            i2++;
            i3++;
        }
        byteBuffer.position(i3);
    }

    @Override // fsimpl.fo
    public final int a(CharSequence charSequence) {
        return b(charSequence);
    }

    @Override // fsimpl.fo
    public final String a(ByteBuffer byteBuffer, int i, int i2) {
        return byteBuffer.hasArray() ? a(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2) : b(byteBuffer, i, i2);
    }

    @Override // fsimpl.fo
    public final void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            b(charSequence, byteBuffer);
            return;
        }
        int arrayOffset = byteBuffer.arrayOffset();
        byteBuffer.position(a(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
    }
}
