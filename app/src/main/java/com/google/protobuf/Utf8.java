package com.google.protobuf;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    static {
        processor = (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor();
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i2) {
        return processor.isValidUtf8(bArr, i, i2);
    }

    public static int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3) {
        return processor.partialIsValidUtf8(i, bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return incompleteStateFor(b, bArr[i], bArr[i + 1]);
                }
                throw new AssertionError();
            }
            return incompleteStateFor(b, bArr[i]);
        }
        return incompleteStateFor(b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return incompleteStateFor(i, byteBuffer.get(i2), byteBuffer.get(i2 + 1));
                }
                throw new AssertionError();
            }
            return incompleteStateFor(i, byteBuffer.get(i2));
        }
        return incompleteStateFor(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public UnpairedSurrogateException(int r3, int r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Unpaired surrogate at index "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = " of "
                r0.append(r3)
                r0.append(r4)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnpairedSurrogateException.<init>(int, int):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int encodedLength(CharSequence charSequence) {
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
                    i2 += encodedLengthGeneral(charSequence, i);
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

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
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
                        throw new UnpairedSurrogateException(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int encode(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return processor.encodeUtf8(charSequence, bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i2, int i3) {
        return processor.partialIsValidUtf8(i, byteBuffer, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(byteBuffer, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i, int i2) {
        int i3 = i;
        while (i3 < i2 - 7 && (byteBuffer.getLong(i3) & ASCII_MASK_LONG) == 0) {
            i3 += 8;
        }
        return i3 - i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class Processor {
        abstract String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

        abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException;

        abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2);

        abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        abstract int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3);

        abstract int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3);

        Processor() {
        }

        final boolean isValidUtf8(byte[] bArr, int i, int i2) {
            return partialIsValidUtf8(0, bArr, i, i2) == 0;
        }

        final boolean isValidUtf8(ByteBuffer byteBuffer, int i, int i2) {
            return partialIsValidUtf8(0, byteBuffer, i, i2) == 0;
        }

        final int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i2, int i3) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return partialIsValidUtf8(i, byteBuffer.array(), i2 + arrayOffset, arrayOffset + i3);
            } else if (byteBuffer.isDirect()) {
                return partialIsValidUtf8Direct(i, byteBuffer, i2, i3);
            } else {
                return partialIsValidUtf8Default(i, byteBuffer, i2, i3);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r8.get(r9) <= (-65)) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
        
            if (r8.get(r9) > (-65)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x008e, code lost:
        
            if (r8.get(r7) > (-65)) goto L52;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final int partialIsValidUtf8Default(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L91
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1d
                r7 = -62
                if (r0 < r7) goto L1c
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 > r3) goto L1c
            L19:
                r9 = r7
                goto L91
            L1c:
                return r2
            L1d:
                r4 = -16
                if (r0 >= r4) goto L4e
                int r7 = r7 >> 8
                r7 = r7 ^ r2
                byte r7 = (byte) r7
                if (r7 != 0) goto L37
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L34
                int r7 = com.google.protobuf.Utf8.access$000(r0, r9)
                return r7
            L34:
                r5 = r9
                r9 = r7
                r7 = r5
            L37:
                if (r7 > r3) goto L4d
                r4 = -96
                if (r0 != r1) goto L3f
                if (r7 < r4) goto L4d
            L3f:
                r1 = -19
                if (r0 != r1) goto L45
                if (r7 >= r4) goto L4d
            L45:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L19
            L4d:
                return r2
            L4e:
                int r1 = r7 >> 8
                r1 = r1 ^ r2
                byte r1 = (byte) r1
                if (r1 != 0) goto L63
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L61
                int r7 = com.google.protobuf.Utf8.access$000(r0, r1)
                return r7
            L61:
                r9 = 0
                goto L69
            L63:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L69:
                if (r9 != 0) goto L7b
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L78
                int r7 = com.google.protobuf.Utf8.access$100(r0, r1, r7)
                return r7
            L78:
                r5 = r9
                r9 = r7
                r7 = r5
            L7b:
                if (r1 > r3) goto L90
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L90
                if (r9 > r3) goto L90
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L91
            L90:
                return r2
            L91:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.Processor.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i, int i2) {
            int estimateConsecutiveAscii = i + Utf8.estimateConsecutiveAscii(byteBuffer, i, i2);
            while (estimateConsecutiveAscii < i2) {
                int i3 = estimateConsecutiveAscii + 1;
                byte b = byteBuffer.get(estimateConsecutiveAscii);
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b < -62 || byteBuffer.get(i3) > -65) {
                            return -1;
                        }
                        estimateConsecutiveAscii = i3 + 1;
                    } else if (b >= -16) {
                        if (i3 >= i2 - 2) {
                            return Utf8.incompleteStateFor(byteBuffer, b, i3, i2 - i3);
                        }
                        int i4 = i3 + 1;
                        byte b2 = byteBuffer.get(i3);
                        if (b2 <= -65 && (((b << Ascii.FS) + (b2 + 112)) >> 30) == 0) {
                            int i5 = i4 + 1;
                            if (byteBuffer.get(i4) <= -65) {
                                i3 = i5 + 1;
                                if (byteBuffer.get(i5) > -65) {
                                }
                            }
                        }
                        return -1;
                    } else if (i3 >= i2 - 1) {
                        return Utf8.incompleteStateFor(byteBuffer, b, i3, i2 - i3);
                    } else {
                        int i6 = i3 + 1;
                        byte b3 = byteBuffer.get(i3);
                        if (b3 > -65 || ((b == -32 && b3 < -96) || ((b == -19 && b3 >= -96) || byteBuffer.get(i6) > -65))) {
                            return -1;
                        }
                        estimateConsecutiveAscii = i6 + 1;
                    }
                }
                estimateConsecutiveAscii = i3;
            }
            return 0;
        }

        final String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
            } else if (byteBuffer.isDirect()) {
                return decodeUtf8Direct(byteBuffer, i, i2);
            } else {
                return decodeUtf8Default(byteBuffer, i, i2);
            }
        }

        final String decodeUtf8Default(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (i < i3) {
                    byte b = byteBuffer.get(i);
                    if (!DecodeUtil.isOneByte(b)) {
                        break;
                    }
                    i++;
                    DecodeUtil.handleOneByte(b, cArr, i4);
                    i4++;
                }
                int i5 = i4;
                while (i < i3) {
                    int i6 = i + 1;
                    byte b2 = byteBuffer.get(i);
                    if (DecodeUtil.isOneByte(b2)) {
                        DecodeUtil.handleOneByte(b2, cArr, i5);
                        i = i6;
                        i5++;
                        while (i < i3) {
                            byte b3 = byteBuffer.get(i);
                            if (DecodeUtil.isOneByte(b3)) {
                                i++;
                                DecodeUtil.handleOneByte(b3, cArr, i5);
                                i5++;
                            }
                        }
                    } else {
                        if (DecodeUtil.isTwoBytes(b2)) {
                            if (i6 >= i3) {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            DecodeUtil.handleTwoBytes(b2, byteBuffer.get(i6), cArr, i5);
                            i = i6 + 1;
                        } else if (DecodeUtil.isThreeBytes(b2)) {
                            if (i6 >= i3 - 1) {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            int i7 = i6 + 1;
                            DecodeUtil.handleThreeBytes(b2, byteBuffer.get(i6), byteBuffer.get(i7), cArr, i5);
                            i = i7 + 1;
                        } else if (i6 >= i3 - 2) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        } else {
                            int i8 = i6 + 1;
                            int i9 = i8 + 1;
                            DecodeUtil.handleFourBytes(b2, byteBuffer.get(i6), byteBuffer.get(i8), byteBuffer.get(i9), cArr, i5);
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

        final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                byteBuffer.position(Utf8.encode(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                encodeUtf8Default(charSequence, byteBuffer);
            }
        }

        final void encodeUtf8Default(CharSequence charSequence, ByteBuffer byteBuffer) {
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
                } else if (charAt2 < 55296 || 57343 < charAt2) {
                    int i5 = i3 + 1;
                    byteBuffer.put(i3, (byte) ((charAt2 >>> '\f') | 224));
                    i3 = i5 + 1;
                    byteBuffer.put(i5, (byte) (((charAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(i3, (byte) ((charAt2 & '?') | 128));
                } else {
                    int i6 = i2 + 1;
                    if (i6 != length) {
                        try {
                            char charAt3 = charSequence.charAt(i6);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                i = i3 + 1;
                                try {
                                    byteBuffer.put(i3, (byte) ((codePoint >>> 18) | 240));
                                    int i7 = i + 1;
                                    byteBuffer.put(i, (byte) (((codePoint >>> 12) & 63) | 128));
                                    int i8 = i7 + 1;
                                    byteBuffer.put(i7, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(i8, (byte) ((codePoint & 63) | 128));
                                    i3 = i8;
                                    i2 = i6;
                                } catch (IndexOutOfBoundsException unused3) {
                                    i2 = i6;
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
                                i2 = i6;
                            }
                        } catch (IndexOutOfBoundsException unused4) {
                            i = i3;
                        }
                    }
                    throw new UnpairedSurrogateException(i2, length);
                }
                i2++;
                i3++;
            }
            byteBuffer.position(i3);
        }
    }

    /* loaded from: classes.dex */
    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] <= (-65)) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0045, code lost:
        
            if (r8[r9] > (-65)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0082, code lost:
        
            if (r8[r7] > (-65)) goto L52;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final int partialIsValidUtf8(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L85
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1b
                r7 = -62
                if (r0 < r7) goto L1a
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 > r3) goto L1a
            L17:
                r9 = r7
                goto L85
            L1a:
                return r2
            L1b:
                r4 = -16
                if (r0 >= r4) goto L48
                int r7 = r7 >> 8
                r7 = r7 ^ r2
                byte r7 = (byte) r7
                if (r7 != 0) goto L33
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L30
                int r7 = com.google.protobuf.Utf8.access$000(r0, r9)
                return r7
            L30:
                r5 = r9
                r9 = r7
                r7 = r5
            L33:
                if (r7 > r3) goto L47
                r4 = -96
                if (r0 != r1) goto L3b
                if (r7 < r4) goto L47
            L3b:
                r1 = -19
                if (r0 != r1) goto L41
                if (r7 >= r4) goto L47
            L41:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L17
            L47:
                return r2
            L48:
                int r1 = r7 >> 8
                r1 = r1 ^ r2
                byte r1 = (byte) r1
                if (r1 != 0) goto L5b
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L59
                int r7 = com.google.protobuf.Utf8.access$000(r0, r1)
                return r7
            L59:
                r9 = 0
                goto L61
            L5b:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L61:
                if (r9 != 0) goto L71
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r9 < r10) goto L6e
                int r7 = com.google.protobuf.Utf8.access$100(r0, r1, r7)
                return r7
            L6e:
                r5 = r9
                r9 = r7
                r7 = r5
            L71:
                if (r1 > r3) goto L84
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L84
                if (r9 > r3) goto L84
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r7 <= r3) goto L85
            L84:
                return r2
            L85:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        final int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3) {
            return partialIsValidUtf8Default(i, byteBuffer, i2, i3);
        }

        @Override // com.google.protobuf.Utf8.Processor
        final String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (i < i3) {
                    byte b = bArr[i];
                    if (!DecodeUtil.isOneByte(b)) {
                        break;
                    }
                    i++;
                    DecodeUtil.handleOneByte(b, cArr, i4);
                    i4++;
                }
                int i5 = i4;
                while (i < i3) {
                    int i6 = i + 1;
                    byte b2 = bArr[i];
                    if (DecodeUtil.isOneByte(b2)) {
                        DecodeUtil.handleOneByte(b2, cArr, i5);
                        i = i6;
                        i5++;
                        while (i < i3) {
                            byte b3 = bArr[i];
                            if (DecodeUtil.isOneByte(b3)) {
                                i++;
                                DecodeUtil.handleOneByte(b3, cArr, i5);
                                i5++;
                            }
                        }
                    } else {
                        if (DecodeUtil.isTwoBytes(b2)) {
                            if (i6 >= i3) {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            DecodeUtil.handleTwoBytes(b2, bArr[i6], cArr, i5);
                            i = i6 + 1;
                        } else if (DecodeUtil.isThreeBytes(b2)) {
                            if (i6 >= i3 - 1) {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            int i7 = i6 + 1;
                            DecodeUtil.handleThreeBytes(b2, bArr[i6], bArr[i7], cArr, i5);
                            i = i7 + 1;
                        } else if (i6 >= i3 - 2) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        } else {
                            int i8 = i6 + 1;
                            int i9 = i8 + 1;
                            DecodeUtil.handleFourBytes(b2, bArr[i6], bArr[i8], bArr[i9], cArr, i5);
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

        @Override // com.google.protobuf.Utf8.Processor
        final String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            return decodeUtf8Default(byteBuffer, i, i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            return r10 + r0;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final int encodeUtf8(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
            /*
                Method dump skipped, instructions count: 254
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.encodeUtf8(java.lang.CharSequence, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        final void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            encodeUtf8Default(charSequence, byteBuffer);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i, i2);
        }

        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b >= -62) {
                            i = i3 + 1;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return -1;
                    } else if (b >= -16) {
                        if (i3 >= i2 - 2) {
                            return Utf8.incompleteStateFor(bArr, i3, i2);
                        }
                        int i4 = i3 + 1;
                        byte b2 = bArr[i3];
                        if (b2 <= -65 && (((b << Ascii.FS) + (b2 + 112)) >> 30) == 0) {
                            int i5 = i4 + 1;
                            if (bArr[i4] <= -65) {
                                i3 = i5 + 1;
                                if (bArr[i5] > -65) {
                                }
                            }
                        }
                        return -1;
                    } else if (i3 >= i2 - 1) {
                        return Utf8.incompleteStateFor(bArr, i3, i2);
                    } else {
                        int i6 = i3 + 1;
                        byte b3 = bArr[i3];
                        if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                            i = i6 + 1;
                            if (bArr[i6] > -65) {
                            }
                        }
                        return -1;
                    }
                }
                i = i3;
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0056, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r13, r2) <= (-65)) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0099, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r13, r2) > (-65)) goto L57;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final int partialIsValidUtf8(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 201
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0060, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r2) <= (-65)) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r2) > (-65)) goto L57;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final int partialIsValidUtf8Direct(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                Method dump skipped, instructions count: 214
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        final String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (i < i3) {
                    byte b = UnsafeUtil.getByte(bArr, i);
                    if (!DecodeUtil.isOneByte(b)) {
                        break;
                    }
                    i++;
                    DecodeUtil.handleOneByte(b, cArr, i4);
                    i4++;
                }
                int i5 = i4;
                while (i < i3) {
                    int i6 = i + 1;
                    byte b2 = UnsafeUtil.getByte(bArr, i);
                    if (DecodeUtil.isOneByte(b2)) {
                        DecodeUtil.handleOneByte(b2, cArr, i5);
                        i = i6;
                        i5++;
                        while (i < i3) {
                            byte b3 = UnsafeUtil.getByte(bArr, i);
                            if (DecodeUtil.isOneByte(b3)) {
                                i++;
                                DecodeUtil.handleOneByte(b3, cArr, i5);
                                i5++;
                            }
                        }
                    } else {
                        if (DecodeUtil.isTwoBytes(b2)) {
                            if (i6 >= i3) {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            DecodeUtil.handleTwoBytes(b2, UnsafeUtil.getByte(bArr, i6), cArr, i5);
                            i = i6 + 1;
                        } else if (DecodeUtil.isThreeBytes(b2)) {
                            if (i6 >= i3 - 1) {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            int i7 = i6 + 1;
                            DecodeUtil.handleThreeBytes(b2, UnsafeUtil.getByte(bArr, i6), UnsafeUtil.getByte(bArr, i7), cArr, i5);
                            i = i7 + 1;
                        } else if (i6 >= i3 - 2) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        } else {
                            int i8 = i6 + 1;
                            int i9 = i8 + 1;
                            DecodeUtil.handleFourBytes(b2, UnsafeUtil.getByte(bArr, i6), UnsafeUtil.getByte(bArr, i8), UnsafeUtil.getByte(bArr, i9), cArr, i5);
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

        @Override // com.google.protobuf.Utf8.Processor
        final String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
                long addressOffset = UnsafeUtil.addressOffset(byteBuffer) + i;
                long j = i2 + addressOffset;
                char[] cArr = new char[i2];
                int i3 = 0;
                while (addressOffset < j) {
                    byte b = UnsafeUtil.getByte(addressOffset);
                    if (!DecodeUtil.isOneByte(b)) {
                        break;
                    }
                    addressOffset++;
                    DecodeUtil.handleOneByte(b, cArr, i3);
                    i3++;
                }
                while (addressOffset < j) {
                    long j2 = addressOffset + 1;
                    byte b2 = UnsafeUtil.getByte(addressOffset);
                    if (DecodeUtil.isOneByte(b2)) {
                        DecodeUtil.handleOneByte(b2, cArr, i3);
                        i3++;
                        addressOffset = j2;
                        while (addressOffset < j) {
                            byte b3 = UnsafeUtil.getByte(addressOffset);
                            if (DecodeUtil.isOneByte(b3)) {
                                addressOffset++;
                                DecodeUtil.handleOneByte(b3, cArr, i3);
                                i3++;
                            }
                        }
                    } else if (DecodeUtil.isTwoBytes(b2)) {
                        if (j2 >= j) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        addressOffset = j2 + 1;
                        DecodeUtil.handleTwoBytes(b2, UnsafeUtil.getByte(j2), cArr, i3);
                        i3++;
                    } else if (DecodeUtil.isThreeBytes(b2)) {
                        if (j2 >= j - 1) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        long j3 = j2 + 1;
                        DecodeUtil.handleThreeBytes(b2, UnsafeUtil.getByte(j2), UnsafeUtil.getByte(j3), cArr, i3);
                        i3++;
                        addressOffset = j3 + 1;
                    } else if (j2 >= j - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    } else {
                        long j4 = j2 + 1;
                        long j5 = j4 + 1;
                        DecodeUtil.handleFourBytes(b2, UnsafeUtil.getByte(j2), UnsafeUtil.getByte(j4), UnsafeUtil.getByte(j5), cArr, i3);
                        i3 = i3 + 1 + 1;
                        addressOffset = j5 + 1;
                    }
                }
                return new String(cArr, 0, i3);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        @Override // com.google.protobuf.Utf8.Processor
        final int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2) {
            char c;
            long j;
            long j2;
            long j3;
            int i3;
            long j4;
            char charAt;
            long j5 = i;
            long j6 = i2 + j5;
            int length = charSequence.length();
            if (length > i2 || bArr.length - i2 < i) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed writing ");
                sb.append(charSequence.charAt(length - 1));
                sb.append(" at index ");
                sb.append(i + i2);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            int i4 = 0;
            while (true) {
                c = 128;
                j = 1;
                if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(bArr, j5, (byte) charAt);
                i4++;
                j5++;
            }
            if (i4 == length) {
                return (int) j5;
            }
            while (i4 < length) {
                char charAt2 = charSequence.charAt(i4);
                if (charAt2 >= c || j5 >= j6) {
                    if (charAt2 < 2048 && j5 <= j6 - 2) {
                        long j7 = j5 + j;
                        UnsafeUtil.putByte(bArr, j5, (byte) ((charAt2 >>> 6) | 960));
                        UnsafeUtil.putByte(bArr, j7, (byte) ((charAt2 & '?') | c));
                        j4 = 1;
                        j3 = j7 + 1;
                    } else if ((charAt2 >= 55296 && 57343 >= charAt2) || j5 > j6 - 3) {
                        if (j5 <= j6 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char charAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    long j8 = j5 + 1;
                                    UnsafeUtil.putByte(bArr, j5, (byte) ((codePoint >>> 18) | 240));
                                    long j9 = j8 + 1;
                                    UnsafeUtil.putByte(bArr, j8, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j10 = j9 + 1;
                                    UnsafeUtil.putByte(bArr, j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j4 = 1;
                                    j3 = j10 + 1;
                                    UnsafeUtil.putByte(bArr, j10, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new UnpairedSurrogateException(i4 - 1, length);
                        } else if (55296 <= charAt2 && charAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                            throw new UnpairedSurrogateException(i4, length);
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed writing ");
                            sb2.append(charAt2);
                            sb2.append(" at index ");
                            sb2.append(j5);
                            throw new ArrayIndexOutOfBoundsException(sb2.toString());
                        }
                    } else {
                        long j11 = j5 + 1;
                        UnsafeUtil.putByte(bArr, j5, (byte) ((charAt2 >>> '\f') | 480));
                        long j12 = j11 + 1;
                        UnsafeUtil.putByte(bArr, j11, (byte) (((charAt2 >>> 6) & 63) | 128));
                        UnsafeUtil.putByte(bArr, j12, (byte) ((charAt2 & '?') | 128));
                        j2 = 1;
                        j3 = j12 + 1;
                    }
                    i4++;
                    c = 128;
                    long j13 = j4;
                    j5 = j3;
                    j = j13;
                } else {
                    UnsafeUtil.putByte(bArr, j5, (byte) charAt2);
                    j2 = j;
                    j3 = j5 + j;
                }
                j4 = j2;
                i4++;
                c = 128;
                long j132 = j4;
                j5 = j3;
                j = j132;
            }
            return (int) j5;
        }

        @Override // com.google.protobuf.Utf8.Processor
        final void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            char c;
            long j;
            int i;
            char charAt;
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            long position = byteBuffer.position() + addressOffset;
            long limit = byteBuffer.limit() + addressOffset;
            int length = charSequence.length();
            if (length > limit - position) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed writing ");
                sb.append(charSequence.charAt(length - 1));
                sb.append(" at index ");
                sb.append(byteBuffer.limit());
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            int i2 = 0;
            while (true) {
                c = 128;
                if (i2 >= length || (charAt = charSequence.charAt(i2)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(position, (byte) charAt);
                i2++;
                position++;
            }
            if (i2 == length) {
                byteBuffer.position((int) (position - addressOffset));
                return;
            }
            while (i2 < length) {
                char charAt2 = charSequence.charAt(i2);
                if (charAt2 < c && position < limit) {
                    UnsafeUtil.putByte(position, (byte) charAt2);
                    position++;
                    j = addressOffset;
                } else if (charAt2 >= 2048 || position > limit - 2) {
                    j = addressOffset;
                    if ((charAt2 >= 55296 && 57343 >= charAt2) || position > limit - 3) {
                        if (position <= limit - 4) {
                            int i3 = i2 + 1;
                            if (i3 != length) {
                                char charAt3 = charSequence.charAt(i3);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    long j2 = position + 1;
                                    UnsafeUtil.putByte(position, (byte) ((codePoint >>> 18) | 240));
                                    long j3 = j2 + 1;
                                    UnsafeUtil.putByte(j2, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j4 = j3 + 1;
                                    UnsafeUtil.putByte(j3, (byte) (((codePoint >>> 6) & 63) | 128));
                                    UnsafeUtil.putByte(j4, (byte) ((codePoint & 63) | 128));
                                    position = j4 + 1;
                                    i2 = i3;
                                    i2++;
                                    addressOffset = j;
                                    c = 128;
                                } else {
                                    i2 = i3;
                                }
                            }
                            throw new UnpairedSurrogateException(i2 - 1, length);
                        } else if (55296 <= charAt2 && charAt2 <= 57343 && ((i = i2 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i)))) {
                            throw new UnpairedSurrogateException(i2, length);
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed writing ");
                            sb2.append(charAt2);
                            sb2.append(" at index ");
                            sb2.append(position);
                            throw new ArrayIndexOutOfBoundsException(sb2.toString());
                        }
                    }
                    long j5 = position + 1;
                    UnsafeUtil.putByte(position, (byte) ((charAt2 >>> '\f') | 480));
                    long j6 = j5 + 1;
                    UnsafeUtil.putByte(j5, (byte) (((charAt2 >>> 6) & 63) | 128));
                    UnsafeUtil.putByte(j6, (byte) ((charAt2 & '?') | 128));
                    position = j6 + 1;
                } else {
                    j = addressOffset;
                    long j7 = position + 1;
                    UnsafeUtil.putByte(position, (byte) ((charAt2 >>> 6) | 960));
                    UnsafeUtil.putByte(j7, (byte) ((charAt2 & '?') | 128));
                    position = j7 + 1;
                }
                i2++;
                addressOffset = j;
                c = 128;
            }
            byteBuffer.position((int) (position - addressOffset));
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j, int i) {
            int i2 = 0;
            if (i < 16) {
                return 0;
            }
            while (i2 < i) {
                if (UnsafeUtil.getByte(bArr, j) < 0) {
                    return i2;
                }
                i2++;
                j++;
            }
            return i;
        }

        private static int unsafeEstimateConsecutiveAscii(long j, int i) {
            if (i < 16) {
                return 0;
            }
            int i2 = 8 - (((int) j) & 7);
            int i3 = i2;
            while (i3 > 0) {
                if (UnsafeUtil.getByte(j) < 0) {
                    return i2 - i3;
                }
                i3--;
                j++;
            }
            int i4 = i - i2;
            while (i4 >= 8 && (UnsafeUtil.getLong(j) & Utf8.ASCII_MASK_LONG) == 0) {
                j += 8;
                i4 -= 8;
            }
            return i - i4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x008d, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int partialIsValidUtf8(byte[] r8, long r9, int r11) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r8, r9, r11)
                int r11 = r11 - r0
                long r0 = (long) r0
                long r9 = r9 + r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r11 <= 0) goto L1a
                long r4 = r9 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r8, r9)
                if (r1 < 0) goto L19
                int r11 = r11 + (-1)
                r9 = r4
                goto L9
            L19:
                r9 = r4
            L1a:
                if (r11 != 0) goto L1d
                return r0
            L1d:
                int r11 = r11 + (-1)
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L39
                if (r11 != 0) goto L29
                return r1
            L29:
                int r11 = r11 + (-1)
                r0 = -62
                if (r1 < r0) goto L38
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.UnsafeUtil.getByte(r8, r9)
                if (r9 > r4) goto L38
            L36:
                r9 = r2
                goto L7
            L38:
                return r5
            L39:
                r6 = -16
                if (r1 >= r6) goto L63
                r6 = 2
                if (r11 >= r6) goto L45
                int r8 = unsafeIncompleteStateFor(r8, r1, r9, r11)
                return r8
            L45:
                int r11 = r11 + (-2)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.UnsafeUtil.getByte(r8, r9)
                if (r9 > r4) goto L62
                r10 = -96
                if (r1 != r0) goto L55
                if (r9 < r10) goto L62
            L55:
                r0 = -19
                if (r1 != r0) goto L5b
                if (r9 >= r10) goto L62
            L5b:
                long r2 = r2 + r6
                byte r9 = com.google.protobuf.UnsafeUtil.getByte(r8, r6)
                if (r9 <= r4) goto L36
            L62:
                return r5
            L63:
                r0 = 3
                if (r11 >= r0) goto L6b
                int r8 = unsafeIncompleteStateFor(r8, r1, r9, r11)
                return r8
            L6b:
                int r11 = r11 + (-3)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.UnsafeUtil.getByte(r8, r9)
                if (r9 > r4) goto L8d
                int r10 = r1 << 28
                int r9 = r9 + 112
                int r10 = r10 + r9
                int r9 = r10 >> 30
                if (r9 != 0) goto L8d
                long r9 = r6 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r8, r6)
                if (r0 > r4) goto L8d
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.UnsafeUtil.getByte(r8, r9)
                if (r9 <= r4) goto L36
            L8d:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(byte[], long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x008d, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int partialIsValidUtf8(long r8, int r10) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r8, r10)
                long r1 = (long) r0
                long r8 = r8 + r1
                int r10 = r10 - r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r10 <= 0) goto L1a
                long r4 = r8 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r1 < 0) goto L19
                int r10 = r10 + (-1)
                r8 = r4
                goto L9
            L19:
                r8 = r4
            L1a:
                if (r10 != 0) goto L1d
                return r0
            L1d:
                int r10 = r10 + (-1)
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L39
                if (r10 != 0) goto L29
                return r1
            L29:
                int r10 = r10 + (-1)
                r0 = -62
                if (r1 < r0) goto L38
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r8 > r4) goto L38
            L36:
                r8 = r2
                goto L7
            L38:
                return r5
            L39:
                r6 = -16
                if (r1 >= r6) goto L63
                r6 = 2
                if (r10 >= r6) goto L45
                int r8 = unsafeIncompleteStateFor(r8, r1, r10)
                return r8
            L45:
                int r10 = r10 + (-2)
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r8 > r4) goto L62
                r9 = -96
                if (r1 != r0) goto L55
                if (r8 < r9) goto L62
            L55:
                r0 = -19
                if (r1 != r0) goto L5b
                if (r8 >= r9) goto L62
            L5b:
                long r2 = r2 + r6
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r8 <= r4) goto L36
            L62:
                return r5
            L63:
                r0 = 3
                if (r10 >= r0) goto L6b
                int r8 = unsafeIncompleteStateFor(r8, r1, r10)
                return r8
            L6b:
                int r10 = r10 + (-3)
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r8 > r4) goto L8d
                int r9 = r1 << 28
                int r8 = r8 + 112
                int r9 = r9 + r8
                int r8 = r9 >> 30
                if (r8 != 0) goto L8d
                long r8 = r6 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r0 > r4) goto L8d
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r8 <= r4) goto L36
            L8d:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(long, int):int");
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i, long j, int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j), UnsafeUtil.getByte(bArr, j + 1));
                    }
                    throw new AssertionError();
                }
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j));
            }
            return Utf8.incompleteStateFor(i);
        }

        private static int unsafeIncompleteStateFor(long j, int i, int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j), UnsafeUtil.getByte(j + 1));
                    }
                    throw new AssertionError();
                }
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j));
            }
            return Utf8.incompleteStateFor(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DecodeUtil {
        private static char highSurrogate(int i) {
            return (char) ((i >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b) {
            return b > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b) {
            return b >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b) {
            return b < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b) {
            return b < -32;
        }

        private static char lowSurrogate(int i) {
            return (char) ((i & 1023) + 56320);
        }

        private static int trailingByteValue(byte b) {
            return b & 63;
        }

        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b, byte b2, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (b < -62 || isNotTrailingByte(b2)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b & Ascii.US) << 6) | trailingByteValue(b2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b, byte b2, byte b3, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || isNotTrailingByte(b3)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b & 15) << 12) | (trailingByteValue(b2) << 6) | trailingByteValue(b3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b2) || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0 || isNotTrailingByte(b3) || isNotTrailingByte(b4)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            int trailingByteValue = ((b & 7) << 18) | (trailingByteValue(b2) << 12) | (trailingByteValue(b3) << 6) | trailingByteValue(b4);
            cArr[i] = highSurrogate(trailingByteValue);
            cArr[i + 1] = lowSurrogate(trailingByteValue);
        }
    }

    private Utf8() {
    }
}
