package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import o.A;

/* loaded from: classes3.dex */
public final class SerializeWriter extends Writer {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    public static final char[] DIGITS;
    static final char[] DigitOnes;
    static final char[] DigitTens;
    private static int PlaceComponentResult = 1;
    static final char[] ascii_chars;
    private static final ThreadLocal<char[]> bufLocal;
    static final char[] digits;
    private static int getAuthRequestContext;
    static final char[] replaceChars;
    static final int[] sizeTable;
    static final byte[] specicalFlags_doubleQuotes;
    static final byte[] specicalFlags_singleQuotes;
    protected char[] buf;
    protected int count;
    protected int features;
    protected final Writer writer;

    static void PlaceComponentResult() {
        getAuthRequestContext = 269894771;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Writer append(char c) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 93;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        SerializeWriter append = append(c);
        int i3 = PlaceComponentResult + 21;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return append;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* synthetic */ Writer append(CharSequence charSequence) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 87;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        SerializeWriter append = append(charSequence);
        int i3 = PlaceComponentResult + 85;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 != 0 ? 'C' : (char) 0) != 'C') {
            return append;
        }
        Object obj = null;
        obj.hashCode();
        return append;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Writer append(CharSequence charSequence, int i, int i2) throws IOException {
        int i3 = PlaceComponentResult + 67;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        char c = i3 % 2 != 0 ? 'b' : (char) 17;
        SerializeWriter append = append(charSequence, i, i2);
        if (c != 17) {
            int i4 = 68 / 0;
        }
        int i5 = BuiltInFictitiousFunctionClassFactory + 31;
        PlaceComponentResult = i5 % 128;
        int i6 = i5 % 2;
        return append;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* synthetic */ Appendable append(char c) throws IOException {
        int i = PlaceComponentResult + 55;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? '2' : ')') == ')') {
            try {
                return append(c);
            } catch (Exception e) {
                throw e;
            }
        }
        SerializeWriter append = append(c);
        Object obj = null;
        obj.hashCode();
        return append;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* synthetic */ Appendable append(CharSequence charSequence) throws IOException {
        SerializeWriter append;
        int i = BuiltInFictitiousFunctionClassFactory + 119;
        PlaceComponentResult = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? 'T' : '5') != 'T') {
            append = append(charSequence);
        } else {
            append = append(charSequence);
            obj.hashCode();
        }
        try {
            int i2 = PlaceComponentResult + 33;
            try {
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                if (!(i2 % 2 == 0)) {
                    obj.hashCode();
                    return append;
                }
                return append;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
        int i3 = BuiltInFictitiousFunctionClassFactory + 19;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 != 0)) {
            try {
                SerializeWriter append = append(charSequence, i, i2);
                Object[] objArr = null;
                int length = objArr.length;
                return append;
            } catch (Exception e) {
                throw e;
            }
        }
        return append(charSequence, i, i2);
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    public SerializeWriter(Writer writer) {
        this.writer = writer;
        this.features = JSON.DEFAULT_GENERATE_FEATURE;
        ThreadLocal<char[]> threadLocal = bufLocal;
        this.buf = threadLocal.get();
        if (threadLocal != null) {
            threadLocal.set(null);
            int i = PlaceComponentResult + 19;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
        }
        if (!(this.buf == null)) {
            return;
        }
        int i3 = PlaceComponentResult + 101;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        try {
            this.buf = new char[1024];
            int i5 = BuiltInFictitiousFunctionClassFactory + 109;
            PlaceComponentResult = i5 % 128;
            int i6 = i5 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this(null, 0, serializerFeatureArr);
    }

    public SerializeWriter(Writer writer, int i, SerializerFeature[] serializerFeatureArr) {
        this.writer = writer;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            try {
                int i2 = PlaceComponentResult + 119;
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                if ((i2 % 2 != 0 ? 'N' : (char) 21) == 'N') {
                    try {
                        this.buf = new char[6922];
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    this.buf = new char[1024];
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int length = serializerFeatureArr.length;
        int i3 = 0;
        while (true) {
            if ((i3 < length ? 'U' : (char) 17) != 17) {
                i |= serializerFeatureArr[i3].mask;
                i3++;
                int i4 = PlaceComponentResult + 9;
                BuiltInFictitiousFunctionClassFactory = i4 % 128;
                int i5 = i4 % 2;
            } else {
                this.features = i;
                return;
            }
        }
    }

    public SerializeWriter(int i) {
        this(null, i);
    }

    public SerializeWriter(Writer writer, int i) {
        this.writer = writer;
        if (i <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Negative initial size: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        this.buf = new char[i];
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 41;
            PlaceComponentResult = i2 % 128;
            if ((i2 % 2 == 0 ? '%' : (char) 18) != '%') {
                return;
            }
            int i3 = 5 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        if ((r4 ? ';' : 'G') != 'G') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
    
        if ((r4 ? '^' : '`') != '^') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0029, code lost:
    
        r2.features = (r3.mask ^ (-1)) & r2.features;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        r2.features = r3.mask | r2.features;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        r3 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
    
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        if ((r3 % 2) != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0045, code lost:
    
        r1 = 2 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004b, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004c, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004d, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004e, code lost:
    
        throw r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void config(com.alibaba.fastjson.serializer.SerializerFeature r3, boolean r4) {
        /*
            r2 = this;
            int r0 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 5
            int r1 = r0 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r1
            r1 = 2
            int r0 = r0 % r1
            if (r0 != 0) goto L1e
            r0 = 98
            int r0 = r0 / 0
            r0 = 71
            if (r4 == 0) goto L17
            r4 = 59
            goto L19
        L17:
            r4 = 71
        L19:
            if (r4 == r0) goto L29
            goto L33
        L1c:
            r3 = move-exception
            throw r3
        L1e:
            r0 = 94
            if (r4 == 0) goto L25
            r4 = 94
            goto L27
        L25:
            r4 = 96
        L27:
            if (r4 == r0) goto L33
        L29:
            int r4 = r2.features
            int r3 = r3.mask
            r3 = r3 ^ (-1)
            r3 = r3 & r4
            r2.features = r3
            return
        L33:
            int r4 = r2.features     // Catch: java.lang.Exception -> L4d
            int r3 = r3.mask     // Catch: java.lang.Exception -> L4b
            r3 = r3 | r4
            r2.features = r3     // Catch: java.lang.Exception -> L4b
            int r3 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L4b
            int r3 = r3 + 103
            int r4 = r3 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r4     // Catch: java.lang.Exception -> L4d
            int r3 = r3 % r1
            if (r3 != 0) goto L4a
            int r1 = r1 / 0
            return
        L48:
            r3 = move-exception
            throw r3
        L4a:
            return
        L4b:
            r3 = move-exception
            throw r3
        L4d:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.config(com.alibaba.fastjson.serializer.SerializerFeature, boolean):void");
    }

    public final boolean isEnabled(SerializerFeature serializerFeature) {
        try {
            try {
                if (!((serializerFeature.mask & this.features) == 0)) {
                    int i = BuiltInFictitiousFunctionClassFactory + 93;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    return true;
                }
                int i3 = PlaceComponentResult + 105;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                return false;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        if ((r6.writer != null) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r1 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        expandCapacity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        flush();
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void write(int r7) {
        /*
            r6 = this;
            int r0 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult
            r1 = 87
            int r0 = r0 + r1
            int r2 = r0 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r2
            int r0 = r0 % 2
            int r0 = r6.count
            r2 = 1
            int r0 = r0 + r2
            char[] r3 = r6.buf
            int r3 = r3.length
            r4 = 0
            if (r0 <= r3) goto L17
            r3 = 0
            goto L18
        L17:
            r3 = 1
        L18:
            if (r3 == r2) goto L45
            int r3 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult
            int r3 = r3 + 99
            int r5 = r3 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r5
            int r3 = r3 % 2
            r5 = 45
            if (r3 == 0) goto L2a
            r1 = 45
        L2a:
            if (r1 == r5) goto L35
            java.io.Writer r1 = r6.writer
            if (r1 != 0) goto L31
            goto L32
        L31:
            r4 = 1
        L32:
            if (r4 == 0) goto L3b
            goto L3f
        L35:
            java.io.Writer r1 = r6.writer
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L43
            if (r1 != 0) goto L3f
        L3b:
            r6.expandCapacity(r0)
            goto L45
        L3f:
            r6.flush()
            goto L50
        L43:
            r7 = move-exception
            throw r7
        L45:
            int r1 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult
            int r1 = r1 + 61
            int r2 = r1 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r2
            int r1 = r1 % 2
            r2 = r0
        L50:
            char[] r0 = r6.buf
            int r1 = r6.count
            char r7 = (char) r7
            r0[r1] = r7
            r6.count = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.write(int):void");
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        if (!(i < 0)) {
            if ((i <= cArr.length) && i2 >= 0) {
                int i3 = i + i2;
                if (!(i3 > cArr.length)) {
                    int i4 = PlaceComponentResult + 47;
                    BuiltInFictitiousFunctionClassFactory = i4 % 128;
                    int i5 = i4 % 2;
                    if (i3 >= 0) {
                        int i6 = PlaceComponentResult + 7;
                        BuiltInFictitiousFunctionClassFactory = i6 % 128;
                        int i7 = i6 % 2;
                        if (i2 == 0) {
                            return;
                        }
                        int i8 = this.count + i2;
                        if (i8 > this.buf.length) {
                            if (!(this.writer != null)) {
                                try {
                                    expandCapacity(i8);
                                } catch (Exception e) {
                                    throw e;
                                }
                            }
                            do {
                                char[] cArr2 = this.buf;
                                int length = cArr2.length;
                                int i9 = this.count;
                                int i10 = length - i9;
                                System.arraycopy(cArr, i, cArr2, i9, i10);
                                this.count = this.buf.length;
                                flush();
                                i2 -= i10;
                                i += i10;
                            } while ((i2 <= this.buf.length ? 'P' : '%') != 'P');
                            int i11 = BuiltInFictitiousFunctionClassFactory + 83;
                            PlaceComponentResult = i11 % 128;
                            int i12 = i11 % 2;
                            i8 = i2;
                        }
                        try {
                            System.arraycopy(cArr, i, this.buf, this.count, i2);
                            this.count = i8;
                            return;
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void expandCapacity(int i) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 117;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        char[] cArr = this.buf;
        int length = ((cArr.length * 3) / 2) + 1;
        if ((length >= i ? ';' : '8') == ';') {
            int i4 = BuiltInFictitiousFunctionClassFactory + 29;
            PlaceComponentResult = i4 % 128;
            int i5 = i4 % 2;
            i = length;
        }
        char[] cArr2 = new char[i];
        System.arraycopy(cArr, 0, cArr2, 0, this.count);
        this.buf = cArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        if ((r0 > r4.buf.length ? ')' : 27) != 27) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        if (r0 > r4.buf.length) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
    
        r1 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult + 5;
        com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        if ((r1 % 2) == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r1 = r4.writer;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        if (r1 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        r1 = ']';
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        r1 = '+';
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        if (r1 == '+') goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
    
        if (r4.writer != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004d, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004f, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        if (r1 == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0052, code lost:
    
        r0 = r4.buf;
        r1 = r0.length;
        r2 = r4.count;
        r1 = r1 - r2;
        r3 = r6 + r1;
        r5.getChars(r6, r3, r0, r2);
        r4.count = r4.buf.length;
        flush();
        r7 = r7 - r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
    
        if (r7 > r4.buf.length) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
    
        r6 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 17;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r6 % 128;
        r6 = r6 % 2;
        r0 = r7;
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0078, code lost:
    
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007a, code lost:
    
        expandCapacity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:
    
        r5.getChars(r6, r7 + r6, r4.buf, r4.count);
        r4.count = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0087, code lost:
    
        return;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void write(java.lang.String r5, int r6, int r7) {
        /*
            r4 = this;
            int r0 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L88
            int r0 = r0 + 45
            int r1 = r0 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L88
            int r0 = r0 % 2
            if (r0 != 0) goto L21
            int r0 = r4.count     // Catch: java.lang.Exception -> L88
            int r0 = r0 * r7
            char[] r1 = r4.buf     // Catch: java.lang.Exception -> L1f
            int r1 = r1.length
            r2 = 27
            if (r0 <= r1) goto L1a
            r1 = 41
            goto L1c
        L1a:
            r1 = 27
        L1c:
            if (r1 == r2) goto L7d
            goto L29
        L1f:
            r5 = move-exception
            throw r5
        L21:
            int r0 = r4.count
            int r0 = r0 + r7
            char[] r1 = r4.buf
            int r1 = r1.length
            if (r0 <= r1) goto L7d
        L29:
            int r1 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult     // Catch: java.lang.Exception -> L88
            int r1 = r1 + 5
            int r2 = r1 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r2     // Catch: java.lang.Exception -> L88
            int r1 = r1 % 2
            if (r1 == 0) goto L49
            java.io.Writer r1 = r4.writer
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L47
            r2 = 43
            if (r1 != 0) goto L42
            r1 = 93
            goto L44
        L42:
            r1 = 43
        L44:
            if (r1 == r2) goto L52
            goto L7a
        L47:
            r5 = move-exception
            throw r5
        L49:
            java.io.Writer r1 = r4.writer
            if (r1 != 0) goto L4f
            r1 = 0
            goto L50
        L4f:
            r1 = 1
        L50:
            if (r1 == 0) goto L7a
        L52:
            char[] r0 = r4.buf
            int r1 = r0.length
            int r2 = r4.count
            int r1 = r1 - r2
            int r3 = r6 + r1
            r5.getChars(r6, r3, r0, r2)
            char[] r6 = r4.buf
            int r6 = r6.length
            r4.count = r6
            r4.flush()
            int r7 = r7 - r1
            char[] r6 = r4.buf
            int r6 = r6.length
            if (r7 > r6) goto L78
            int r6 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 17
            int r0 = r6 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r0
            int r6 = r6 % 2
            r0 = r7
            r6 = r3
            goto L7d
        L78:
            r6 = r3
            goto L52
        L7a:
            r4.expandCapacity(r0)
        L7d:
            int r7 = r7 + r6
            char[] r1 = r4.buf
            int r2 = r4.count
            r5.getChars(r6, r7, r1, r2)
            r4.count = r0
            return
        L88:
            r5 = move-exception
            goto L8b
        L8a:
            throw r5
        L8b:
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.write(java.lang.String, int, int):void");
    }

    public final void writeTo(Writer writer) throws IOException {
        if ((this.writer == null ? '9' : '-') == '-') {
            throw new UnsupportedOperationException("writer not null");
        }
        try {
            int i = PlaceComponentResult + 17;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (!(i % 2 == 0)) {
                try {
                    writer.write(this.buf, 0, this.count);
                } catch (Exception e) {
                    throw e;
                }
            } else {
                writer.write(this.buf, 0, this.count);
            }
            int i2 = PlaceComponentResult + 3;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            if (i2 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void writeTo(OutputStream outputStream, String str) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 107;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? ':' : '%') != '%') {
            writeTo(outputStream, Charset.forName(str));
            Object obj = null;
            obj.hashCode();
            return;
        }
        try {
            try {
                writeTo(outputStream, Charset.forName(str));
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
    
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        if (r5.writer == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0024, code lost:
    
        r4 = false;
        r6.write(new java.lang.String(r5.buf, 0, r5.count).getBytes(r7.name()));
        r6 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 107;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        if ((r6 % 2) != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        if (r4 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
    
        throw new java.lang.UnsupportedOperationException("writer not null");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeTo(java.io.OutputStream r6, java.nio.charset.Charset r7) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult     // Catch: java.lang.Exception -> L5a
            int r0 = r0 + 53
            int r1 = r0 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r1     // Catch: java.lang.Exception -> L58
            int r0 = r0 % 2
            r1 = 9
            if (r0 == 0) goto L11
            r0 = 58
            goto L13
        L11:
            r0 = 9
        L13:
            r2 = 0
            if (r0 == r1) goto L20
            java.io.Writer r0 = r5.writer
            r2.hashCode()     // Catch: java.lang.Throwable -> L1e
            if (r0 != 0) goto L4f
            goto L24
        L1e:
            r6 = move-exception
            throw r6
        L20:
            java.io.Writer r0 = r5.writer     // Catch: java.lang.Exception -> L58
            if (r0 != 0) goto L4f
        L24:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r5.buf
            int r3 = r5.count
            r4 = 0
            r0.<init>(r1, r4, r3)
            java.lang.String r7 = r7.name()
            byte[] r7 = r0.getBytes(r7)
            r6.write(r7)
            int r6 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 107
            int r7 = r6 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r7
            int r6 = r6 % 2
            if (r6 != 0) goto L46
            r4 = 1
        L46:
            if (r4 == 0) goto L4e
            r2.hashCode()     // Catch: java.lang.Throwable -> L4c
            return
        L4c:
            r6 = move-exception
            throw r6
        L4e:
            return
        L4f:
            java.lang.UnsupportedOperationException r6 = new java.lang.UnsupportedOperationException
            java.lang.String r7 = "writer not null"
            r6.<init>(r7)     // Catch: java.lang.Exception -> L5a
            throw r6     // Catch: java.lang.Exception -> L5a
        L58:
            r6 = move-exception
            throw r6
        L5a:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeTo(java.io.OutputStream, java.nio.charset.Charset):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:17:0x0036
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.io.Writer, java.lang.Appendable
    public final com.alibaba.fastjson.serializer.SerializeWriter append(java.lang.CharSequence r4) {
        /*
            r3 = this;
            int r0 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 69
            int r1 = r0 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 38
            if (r0 != 0) goto L15
            int r2 = r2 / r1
            if (r4 != 0) goto L1d
            goto L2c
        L13:
            r4 = move-exception
            throw r4
        L15:
            r0 = 35
            if (r4 != 0) goto L1b
            r2 = 35
        L1b:
            if (r2 == r0) goto L2c
        L1d:
            java.lang.String r4 = r4.toString()
            int r0 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult
            int r0 = r0 + 9
            int r2 = r0 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r2
            int r0 = r0 % 2
            goto L2e
        L2c:
            java.lang.String r4 = "null"
        L2e:
            int r0 = r4.length()
            r3.write(r4, r1, r0)
            return r3
        L36:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.append(java.lang.CharSequence):com.alibaba.fastjson.serializer.SerializeWriter");
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final SerializeWriter append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            int i3 = PlaceComponentResult + 41;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 44 / 0;
            }
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        int i5 = PlaceComponentResult + 19;
        BuiltInFictitiousFunctionClassFactory = i5 % 128;
        int i6 = i5 % 2;
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final SerializeWriter append(char c) {
        int i = BuiltInFictitiousFunctionClassFactory + 45;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        write(c);
        int i3 = PlaceComponentResult + 97;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 22 : '(') != 22) {
            return this;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
    
        if (r14 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        if ((r14 == null ? '\t' : 'U') != '\t') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        r14 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 93;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r14 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if ((r14 % 2) != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
    
        r14 = 'F';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        r14 = id.dana.cashier.view.InputCardNumberView.DIVIDER;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        if (r14 == 'F') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
    
        r14 = new java.lang.Object[1];
        a(new char[]{2, 65513, 65524, 17, 16}, 154 - (android.graphics.PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (android.graphics.PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 5 - android.text.TextUtils.indexOf("", "", 0, 0), false, 3 - (android.os.Process.myTid() >> 22), r14);
        r14 = ((java.lang.String) r14[0]).intern();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        r0 = new java.lang.Object[1];
        a(new char[]{2, 65513, 65524, 17, 16}, (android.graphics.PointF.length(2.0f, 2.0f) > 0.0f ? 1 : (android.graphics.PointF.length(2.0f, 2.0f) == 0.0f ? 0 : -1)) * 15917, 4 / android.text.TextUtils.indexOf("", "", 1, 1), false, 3 / (android.os.Process.myTid() + 77), r0);
        r14 = ((java.lang.String) r0[0]).intern();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00af, code lost:
    
        return new java.lang.String(r13.buf, 0, r13.count).getBytes(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b0, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b9, code lost:
    
        throw new com.alibaba.fastjson.JSONException("toBytes error", r14);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] toBytes(java.lang.String r14) {
        /*
            r13 = this;
            java.io.Writer r0 = r13.writer
            if (r0 != 0) goto Lbc
            int r0 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult
            int r0 = r0 + 59
            int r1 = r0 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 36
            if (r0 == 0) goto L15
            r0 = 36
            goto L17
        L15:
            r0 = 11
        L17:
            r2 = 0
            if (r0 == r1) goto L1d
            if (r14 != 0) goto La2
            goto L2e
        L1d:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> Lba
            r0 = 9
            if (r14 != 0) goto L28
            r1 = 9
            goto L2a
        L28:
            r1 = 85
        L2a:
            if (r1 == r0) goto L2e
            goto La2
        L2e:
            int r14 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory
            int r14 = r14 + 93
            int r0 = r14 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r0
            int r14 = r14 % 2
            r0 = 70
            if (r14 != 0) goto L3f
            r14 = 70
            goto L41
        L3f:
            r14 = 32
        L41:
            r1 = 3
            r3 = 5
            r4 = 1
            java.lang.String r5 = ""
            r6 = 0
            if (r14 == r0) goto L74
            char[] r7 = new char[r3]
            r7 = {x00c6: FILL_ARRAY_DATA , data: [2, -23, -12, 17, 16} // fill-array
            float r14 = android.graphics.PointF.length(r6, r6)
            int r14 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            int r8 = 154 - r14
            int r14 = android.text.TextUtils.indexOf(r5, r5, r2, r2)
            int r9 = 5 - r14
            r10 = 0
            int r14 = android.os.Process.myTid()
            int r14 = r14 >> 22
            int r11 = 3 - r14
            java.lang.Object[] r14 = new java.lang.Object[r4]
            r12 = r14
            a(r7, r8, r9, r10, r11, r12)
            r14 = r14[r2]
            java.lang.String r14 = (java.lang.String) r14
            java.lang.String r14 = r14.intern()
            goto La2
        L74:
            char[] r3 = new char[r3]
            r3 = {x00d0: FILL_ARRAY_DATA , data: [2, -23, -12, 17, 16} // fill-array
            r14 = 1073741824(0x40000000, float:2.0)
            float r14 = android.graphics.PointF.length(r14, r14)
            int r14 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            int r14 = r14 * 15917
            r0 = 4
            int r5 = android.text.TextUtils.indexOf(r5, r5, r4, r4)
            int r5 = r0 / r5
            r6 = 0
            int r0 = android.os.Process.myTid()
            int r0 = r0 + 77
            int r7 = r1 / r0
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r4 = r14
            r8 = r0
            a(r3, r4, r5, r6, r7, r8)
            r14 = r0[r2]
            java.lang.String r14 = (java.lang.String) r14
            java.lang.String r14 = r14.intern()
        La2:
            java.lang.String r0 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> Lb0
            char[] r1 = r13.buf     // Catch: java.io.UnsupportedEncodingException -> Lb0
            int r3 = r13.count     // Catch: java.io.UnsupportedEncodingException -> Lb0
            r0.<init>(r1, r2, r3)     // Catch: java.io.UnsupportedEncodingException -> Lb0
            byte[] r14 = r0.getBytes(r14)     // Catch: java.io.UnsupportedEncodingException -> Lb0
            return r14
        Lb0:
            r14 = move-exception
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "toBytes error"
            r0.<init>(r1, r14)
            throw r0
        Lba:
            r14 = move-exception
            throw r14
        Lbc:
            java.lang.UnsupportedOperationException r14 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "writer not null"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.toBytes(java.lang.String):byte[]");
    }

    public final String toString() {
        String str = new String(this.buf, 0, this.count);
        int i = BuiltInFictitiousFunctionClassFactory + 23;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
    
        if (r4.writer != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        if (r4.count <= 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        if (r2 == true) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
    
        flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0026, code lost:
    
        r0 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 65;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        r0 = r4.buf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        if (r0.length > 8192) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        r1 = '8';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        r1 = 'U';
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
    
        if (r1 == '8') goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        com.alibaba.fastjson.serializer.SerializeWriter.bufLocal.set(r0);
        r0 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 43;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
    
        r4.buf = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r4.writer != null) goto L12;
     */
    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() {
        /*
            r4 = this;
            int r0 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r2
            int r0 = r0 % 2
            r2 = 0
            if (r0 == 0) goto L17
            java.io.Writer r0 = r4.writer
            r3 = 87
            int r3 = r3 / r2
            if (r0 == 0) goto L30
            goto L1b
        L15:
            r0 = move-exception
            throw r0
        L17:
            java.io.Writer r0 = r4.writer     // Catch: java.lang.Exception -> L56
            if (r0 == 0) goto L30
        L1b:
            int r0 = r4.count
            if (r0 <= 0) goto L20
            goto L21
        L20:
            r2 = 1
        L21:
            if (r2 == r1) goto L30
            r4.flush()     // Catch: java.lang.Exception -> L54
            int r0 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 65
            int r1 = r0 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r1
            int r0 = r0 % 2
        L30:
            char[] r0 = r4.buf     // Catch: java.lang.Exception -> L54
            int r1 = r0.length
            r2 = 8192(0x2000, float:1.14794E-41)
            r3 = 56
            if (r1 > r2) goto L3c
            r1 = 56
            goto L3e
        L3c:
            r1 = 85
        L3e:
            if (r1 == r3) goto L41
            goto L50
        L41:
            java.lang.ThreadLocal<char[]> r1 = com.alibaba.fastjson.serializer.SerializeWriter.bufLocal     // Catch: java.lang.Exception -> L54
            r1.set(r0)
            int r0 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 43
            int r1 = r0 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r1
            int r0 = r0 % 2
        L50:
            r0 = 0
            r4.buf = r0     // Catch: java.lang.Exception -> L54
            return
        L54:
            r0 = move-exception
            throw r0
        L56:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.close():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
    
        if ((r4 != null) != true) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        writeNull();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
    
        r4 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult + 45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0034, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0036, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
    
        write(r4, 0, r4.length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        if (r4 == null) goto L30;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void write(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 45
            int r1 = r0 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 98
            if (r0 != 0) goto L11
            r0 = 98
            goto L13
        L11:
            r0 = 92
        L13:
            r2 = 0
            if (r0 == r1) goto L19
            if (r4 != 0) goto L37
            goto L25
        L19:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L3f
            r0 = 1
            if (r4 != 0) goto L22
            r1 = 0
            goto L23
        L22:
            r1 = 1
        L23:
            if (r1 == r0) goto L37
        L25:
            r3.writeNull()     // Catch: java.lang.Exception -> L35
            int r4 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult     // Catch: java.lang.Exception -> L33
            int r4 = r4 + 45
            int r0 = r4 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r0     // Catch: java.lang.Exception -> L33
            int r4 = r4 % 2
            return
        L33:
            r4 = move-exception
            throw r4
        L35:
            r4 = move-exception
            throw r4
        L37:
            int r0 = r4.length()
            r3.write(r4, r2, r0)
            return
        L3f:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.write(java.lang.String):void");
    }

    public final void writeInt(int i) {
        int i2;
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        if ((i < 0 ? 'J' : 'F') != 'J') {
            i2 = i;
        } else {
            int i3 = BuiltInFictitiousFunctionClassFactory + 79;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            i2 = -i;
        }
        int i5 = 0;
        while (i2 > sizeTable[i5]) {
            i5++;
        }
        int i6 = i5 + 1;
        if ((i < 0 ? 'U' : '\\') != '\\') {
            i6++;
        }
        int i7 = this.count + i6;
        if (i7 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i7);
                int i8 = BuiltInFictitiousFunctionClassFactory + 1;
                PlaceComponentResult = i8 % 128;
                int i9 = i8 % 2;
            } else {
                char[] cArr = new char[i6];
                getChars(i, i6, cArr);
                write(cArr, 0, i6);
                return;
            }
        }
        getChars(i, i7, this.buf);
        this.count = i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c9, code lost:
    
        if ((r4) != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ce, code lost:
    
        if (r4 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d0, code lost:
    
        r0 = "''";
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01d3, code lost:
    
        r0 = "\"\"";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeByteArray(byte[] r19) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeByteArray(byte[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        if (r17 == Long.MIN_VALUE) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        write("-9223372036854775808");
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if (r17 >= 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        r6 = 'I';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        r6 = '\r';
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        if (r6 == '\r') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        r6 = -r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:
    
        r6 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        r0 = true;
        r11 = 10;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        if (r10 >= 19) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0045, code lost:
    
        r15 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 51;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r15 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:
    
        if ((r15 % 2) != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        r15 = 2 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        if (r6 < r11) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005d, code lost:
    
        if (r6 < r11) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005f, code lost:
    
        r11 = r11 * 10;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0065, code lost:
    
        if (r10 != 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0067, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0069, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006a, code lost:
    
        if (r6 == true) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006c, code lost:
    
        r13 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006e, code lost:
    
        r13 = 19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0072, code lost:
    
        if (r17 >= 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0074, code lost:
    
        r4 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult + 87;
        com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r4 % 128;
        r4 = r4 % 2;
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0080, code lost:
    
        r4 = r16.count + r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
    
        if (r4 <= r16.buf.length) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0089, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008a, code lost:
    
        if (r0 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008e, code lost:
    
        if (r16.writer != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0090, code lost:
    
        expandCapacity(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0095, code lost:
    
        r0 = new char[r13];
        getChars(r17, r13, r0);
        write(r0, 0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x009d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009e, code lost:
    
        getChars(r17, r4, r16.buf);
        r16.count = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a8, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r17 == Long.MIN_VALUE) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeLong(long r17) {
        /*
            Method dump skipped, instructions count: 170
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeLong(long):void");
    }

    public final void writeNull() {
        int i = BuiltInFictitiousFunctionClassFactory + 35;
        PlaceComponentResult = i % 128;
        char c = i % 2 == 0 ? (char) 1 : (char) 30;
        write("null");
        if (c == 1) {
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = PlaceComponentResult + 63;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            if ((i2 % 2 != 0 ? ']' : '@') != ']') {
                return;
            }
            int i3 = 98 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d1, code lost:
    
        r0 = com.alibaba.fastjson.serializer.SerializeWriter.specicalFlags_doubleQuotes;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01d4, code lost:
    
        if (r10 >= r0.length) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01d8, code lost:
    
        if (r0[r10] != 4) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01da, code lost:
    
        r0 = r16 + 1;
        r3 = r18.buf;
        java.lang.System.arraycopy(r3, r0, r3, r16 + 6, (r13 - r16) - 1);
        r3 = r18.buf;
        r3[r16] = '\\';
        r4 = r0 + 1;
        r3[r0] = 'u';
        r0 = r4 + 1;
        r5 = com.alibaba.fastjson.serializer.SerializeWriter.DIGITS;
        r3[r4] = r5[(r10 >>> '\f') & 15];
        r4 = r0 + 1;
        r3[r0] = r5[(r10 >>> '\b') & 15];
        r3[r4] = r5[(r10 >>> 4) & 15];
        r3[r4 + 1] = r5[r10 & 15];
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0215, code lost:
    
        r0 = r16 + 1;
        r3 = r18.buf;
        java.lang.System.arraycopy(r3, r0, r3, r16 + 2, (r13 - r16) - 1);
        r3 = r18.buf;
        r3[r16] = '\\';
        r3[r0] = com.alibaba.fastjson.serializer.SerializeWriter.replaceChars[r10];
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x022d, code lost:
    
        r4 = r18.buf[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0233, code lost:
    
        if (r4 != 8232) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0235, code lost:
    
        r14 = r14 + 1;
        r5 = r5 + 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x023a, code lost:
    
        if (r15 != (-1)) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r19 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x023f, code lost:
    
        r3 = '#';
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0243, code lost:
    
        if (r4 < ']') goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0245, code lost:
    
        r8 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 35;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x024e, code lost:
    
        if ((r8 % 2) != 0) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0252, code lost:
    
        if (r4 < 18) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0257, code lost:
    
        if (r4 < 127) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        writeNull();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x025d, code lost:
    
        if (r4 >= 160) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x025f, code lost:
    
        r3 = '\b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0262, code lost:
    
        r3 = kotlin.text.Typography.greater;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0264, code lost:
    
        if (r3 == '\b') goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0267, code lost:
    
        r3 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 121;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0271, code lost:
    
        if ((r3 % 2) != 0) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0273, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0274, code lost:
    
        r3 = r8.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        if (r20 == 0) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0276, code lost:
    
        if (r15 != (-1)) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x027e, code lost:
    
        if (r15 != (-1)) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0280, code lost:
    
        r15 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0281, code lost:
    
        r14 = r14 + 1;
        r5 = r5 + 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        write(r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x028d, code lost:
    
        if (r4 != ' ') goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0290, code lost:
    
        if (r4 != r7) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0299, code lost:
    
        if ((com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial.mask & r18.features) == 0) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x029c, code lost:
    
        if (r4 <= '#') goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x029e, code lost:
    
        if (r4 != '\\') goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02a0, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02a2, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02a3, code lost:
    
        if (r7 == true) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02a7, code lost:
    
        if (r4 <= 31) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02a9, code lost:
    
        r7 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult + 41;
        com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02b3, code lost:
    
        if (r4 == '\\') goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02b7, code lost:
    
        if (r4 != '\"') goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        r3 = r19.length();
        r5 = (r18.count + r3) + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02ba, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02bc, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02bd, code lost:
    
        if (r7 == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02bf, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02c1, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02c2, code lost:
    
        if (r7 == true) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02c4, code lost:
    
        r14 = r14 + 1;
        r7 = com.alibaba.fastjson.serializer.SerializeWriter.specicalFlags_doubleQuotes;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x02cb, code lost:
    
        if (r4 >= r7.length) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02ce, code lost:
    
        r3 = '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if (r20 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x02d0, code lost:
    
        if (r3 == '@') goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x02d5, code lost:
    
        if (r7[r4] != 4) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x02d7, code lost:
    
        r3 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 27;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x02e2, code lost:
    
        if ((r3 % 2) != 0) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x02e4, code lost:
    
        r5 = r5 >>> 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x02e7, code lost:
    
        r5 = r5 + 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x02ea, code lost:
    
        if (r15 != (-1)) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x02ec, code lost:
    
        r10 = r4;
        r15 = r6;
        r16 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        r6 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 33;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x02f1, code lost:
    
        r10 = r4;
        r16 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x02f4, code lost:
    
        r6 = r6 + 1;
        r7 = '/';
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x02fb, code lost:
    
        if (r20 == 0) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x02fd, code lost:
    
        r0 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult + 29;
        com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r0 % 128;
        r0 = r0 % 2;
        r0 = r18.buf;
        r3 = r18.count;
        r0[r3 - 2] = kotlin.text.Typography.quote;
        r0[r3 - 1] = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0314, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0315, code lost:
    
        r18.buf[r18.count - 1] = kotlin.text.Typography.quote;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x031e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
    
        if ((r6 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
    
        r5 = r5 % 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        r7 = '/';
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        if (r5 <= r18.buf.length) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        if (r18.writer == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        write(34);
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r3 >= r19.length()) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        r4 = r19.charAt(r3);
        r5 = com.alibaba.fastjson.serializer.SerializeWriter.specicalFlags_doubleQuotes;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        if (r4 >= r5.length) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0069, code lost:
    
        if (r5[r4] != 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006b, code lost:
    
        if (r4 != '/') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0074, code lost:
    
        if ((r18.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial.mask) == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0076, code lost:
    
        write(92);
        write(com.alibaba.fastjson.serializer.SerializeWriter.replaceChars[r4]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0081, code lost:
    
        write(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0084, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
    
        write(34);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        if (r20 == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008d, code lost:
    
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008e, code lost:
    
        if (r10 == 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0091, code lost:
    
        write(r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0094, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0095, code lost:
    
        expandCapacity(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0098, code lost:
    
        r6 = r18.count;
        r12 = r6 + 1;
        r13 = r12 + r3;
        r14 = r18.buf;
        r14[r6] = kotlin.text.Typography.quote;
        r19.getChars(0, r3, r14, r12);
        r18.count = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a7, code lost:
    
        if (r21 == false) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a9, code lost:
    
        r6 = r12;
        r14 = 0;
        r15 = -1;
        r16 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b0, code lost:
    
        if (r6 >= r13) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b2, code lost:
    
        r4 = 27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b5, code lost:
    
        r4 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b9, code lost:
    
        if (r4 == 27) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bb, code lost:
    
        if (r14 <= 0) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00bd, code lost:
    
        r5 = r5 + r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c1, code lost:
    
        if (r5 <= r18.buf.length) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c3, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:
    
        if (r19 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c5, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c6, code lost:
    
        if (r4 == true) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c8, code lost:
    
        expandCapacity(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00cb, code lost:
    
        r18.count = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00cd, code lost:
    
        if (r14 != 1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00cf, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d1, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d4, code lost:
    
        if (r4 == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00d6, code lost:
    
        if (r14 <= 1) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d8, code lost:
    
        r4 = r15 - r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00de, code lost:
    
        if (r4 >= r19.length()) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e0, code lost:
    
        r6 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult + 89;
        com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r6 % 128;
        r6 = r6 % 2;
        r6 = r19.charAt(r4);
        r8 = com.alibaba.fastjson.serializer.SerializeWriter.specicalFlags_doubleQuotes;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f1, code lost:
    
        if (r6 >= r8.length) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f5, code lost:
    
        if (r8[r6] != 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f7, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00f9, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00fa, code lost:
    
        if (r10 == true) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00fe, code lost:
    
        if (r6 != r7) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0100, code lost:
    
        r12 = ':';
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0103, code lost:
    
        r12 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0105, code lost:
    
        if (r12 == ':') goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0111, code lost:
    
        if ((r18.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial.mask) == 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0113, code lost:
    
        r10 = r18.buf;
        r12 = r15 + 1;
        r10[r15] = '\\';
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x011b, code lost:
    
        if (r8[r6] != 4) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x011d, code lost:
    
        r8 = r12 + 1;
        r10[r12] = 'u';
        r12 = r8 + 1;
        r13 = com.alibaba.fastjson.serializer.SerializeWriter.DIGITS;
        r10[r8] = r13[(r6 >>> '\f') & 15];
        r8 = r12 + 1;
        r10[r12] = r13[(r6 >>> '\b') & 15];
        r12 = r8 + 1;
        r10[r8] = r13[(r6 >>> 4) & 15];
        r8 = r12 + 1;
        r10[r12] = r13[r6 & 15];
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x014a, code lost:
    
        r8 = r12 + 1;
        r10[r12] = com.alibaba.fastjson.serializer.SerializeWriter.replaceChars[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0152, code lost:
    
        r15 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0154, code lost:
    
        if (r6 != 8232) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0156, code lost:
    
        r8 = r18.buf;
        r10 = r15 + 1;
        r8[r15] = '\\';
        r12 = r10 + 1;
        r8[r10] = 'u';
        r10 = r12 + 1;
        r13 = com.alibaba.fastjson.serializer.SerializeWriter.DIGITS;
        r8[r12] = r13[(r6 >>> '\f') & 15];
        r12 = r10 + 1;
        r8[r10] = r13[(r6 >>> '\b') & 15];
        r10 = r12 + 1;
        r8[r12] = r13[(r6 >>> 4) & 15];
        r8[r10] = r13[r6 & 15];
        r15 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0189, code lost:
    
        r18.buf[r15] = r6;
        r15 = r15 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x018f, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0193, code lost:
    
        r0 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 15;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x019f, code lost:
    
        if (r10 != 8232) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01a1, code lost:
    
        r0 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 107;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r0 % 128;
        r0 = r0 % 2;
        r0 = r16 + 1;
        r3 = r18.buf;
        java.lang.System.arraycopy(r3, r0, r3, r16 + 6, (r13 - r16) - 1);
        r3 = r18.buf;
        r3[r16] = '\\';
        r3[r0] = 'u';
        r0 = r0 + 1;
        r3[r0] = '2';
        r0 = r0 + 1;
        r3[r0] = '0';
        r0 = r0 + 1;
        r3[r0] = '2';
        r3[r0 + 1] = '8';
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeStringWithDoubleQuote(java.lang.String r19, char r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 799
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char, boolean):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x0021
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public final void write(boolean r3) {
        /*
            r2 = this;
            r0 = 1
            if (r3 == 0) goto L5
            r3 = 0
            goto L6
        L5:
            r3 = 1
        L6:
            if (r3 == r0) goto L23
            int r3 = com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult
            int r3 = r3 + r0
            int r0 = r3 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory = r0
            int r3 = r3 % 2
            java.lang.String r3 = "true"
            int r0 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L1f
            int r0 = r0 + 59
            int r1 = r0 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L1f
            int r0 = r0 % 2
            goto L25
        L1f:
            r3 = move-exception
            throw r3
        L21:
            r3 = move-exception
            throw r3
        L23:
            java.lang.String r3 = "false"
        L25:
            r2.write(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.write(boolean):void");
    }

    public final void writeString(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 61;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if ((this.features & SerializerFeature.UseSingleQuotes.mask) == 0) {
            writeStringWithDoubleQuote(str, (char) 0, true);
            return;
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 27;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 == 0 ? 'a' : ':') == ':') {
            writeStringWithSingleQuote(str);
            return;
        }
        try {
            writeStringWithSingleQuote(str);
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if ((r17.writer != null ? 6 : '\'') != '\'') goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        if ((r6 == null) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        expandCapacity(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
    
        write(39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        if (r4 >= r18.length()) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
    
        r3 = r18.charAt(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
    
        if (r3 <= '\r') goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
    
        if (r3 == '\\') goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006f, code lost:
    
        r5 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 39;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
    
        if ((r5 % 2) != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007e, code lost:
    
        if (r3 == 'W') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:
    
        r5 = '%';
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0083, code lost:
    
        r5 = '\n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0085, code lost:
    
        if (r5 == '%') goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0088, code lost:
    
        if (r3 == '\'') goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008a, code lost:
    
        if (r3 != '/') goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0093, code lost:
    
        if ((r17.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial.mask) != 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0097, code lost:
    
        write(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009b, code lost:
    
        write(92);
        write(com.alibaba.fastjson.serializer.SerializeWriter.replaceChars[r3]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a5, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a8, code lost:
    
        write(39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ab, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeStringWithSingleQuote(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithSingleQuote(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if ((r3.features & com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask) != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        if ((r3.features | com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask) != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if ((r3.features & com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames.mask) == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r5 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 99;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        if ((r5 % 2) != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        writeStringWithSingleQuote(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
    
        write(27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
    
        writeStringWithSingleQuote(r4);
        write(58);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
    
        writeKeyWithSingleQuoteIfHasSpecial(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
    
        if ((r3.features & com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames.mask) == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0060, code lost:
    
        r0 = 'X';
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
    
        r0 = '^';
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        if (r0 == 'X') goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        writeKeyWithDoubleQuoteIfHasSpecial(r4);
        r4 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory + 125;
        com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
    
        if ((r4 % 2) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0077, code lost:
    
        r4 = r4.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0078, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007c, code lost:
    
        writeStringWithDoubleQuote(r4, ':', r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeFieldName(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            int r0 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 19
            int r1 = r0 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 != 0) goto Lf
            r0 = 1
            goto L10
        Lf:
            r0 = 0
        L10:
            r2 = 58
            if (r0 == r1) goto L20
            int r0 = r3.features     // Catch: java.lang.Exception -> L1e
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes     // Catch: java.lang.Exception -> L1e
            int r1 = r1.mask     // Catch: java.lang.Exception -> L1e
            r0 = r0 & r1
            if (r0 == 0) goto L55
            goto L29
        L1e:
            r4 = move-exception
            goto L47
        L20:
            int r0 = r3.features
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes
            int r1 = r1.mask
            r0 = r0 | r1
            if (r0 == 0) goto L55
        L29:
            int r5 = r3.features
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames
            int r0 = r0.mask
            r5 = r5 & r0
            if (r5 == 0) goto L51
            int r5 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory
            int r5 = r5 + 99
            int r0 = r5 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r0
            int r5 = r5 % 2
            if (r5 != 0) goto L4a
            r3.writeStringWithSingleQuote(r4)     // Catch: java.lang.Exception -> L48
            r4 = 27
            r3.write(r4)     // Catch: java.lang.Exception -> L1e
            goto L50
        L47:
            throw r4
        L48:
            r4 = move-exception
            throw r4
        L4a:
            r3.writeStringWithSingleQuote(r4)
            r3.write(r2)
        L50:
            return
        L51:
            r3.writeKeyWithSingleQuoteIfHasSpecial(r4)
            return
        L55:
            int r0 = r3.features
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames
            int r1 = r1.mask
            r0 = r0 & r1
            r1 = 88
            if (r0 == 0) goto L63
            r0 = 88
            goto L65
        L63:
            r0 = 94
        L65:
            if (r0 == r1) goto L7c
            r3.writeKeyWithDoubleQuoteIfHasSpecial(r4)
            int r4 = com.alibaba.fastjson.serializer.SerializeWriter.BuiltInFictitiousFunctionClassFactory
            int r4 = r4 + 125
            int r5 = r4 % 128
            com.alibaba.fastjson.serializer.SerializeWriter.PlaceComponentResult = r5
            int r4 = r4 % 2
            if (r4 != 0) goto L7b
            r4 = 0
            int r4 = r4.length     // Catch: java.lang.Throwable -> L79
            return
        L79:
            r4 = move-exception
            throw r4
        L7b:
            return
        L7c:
            r3.writeStringWithDoubleQuote(r4, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeFieldName(java.lang.String, boolean):void");
    }

    private void writeKeyWithDoubleQuoteIfHasSpecial(String str) {
        char c;
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        if (i > this.buf.length) {
            if ((this.writer != null ? 'Y' : '7') != '7') {
                int i2 = BuiltInFictitiousFunctionClassFactory + 35;
                PlaceComponentResult = i2 % 128;
                int i3 = i2 % 2;
                if (length == 0) {
                    write(34);
                    write(34);
                    write(58);
                    return;
                }
                int i4 = 0;
                while (true) {
                    if ((i4 < length ? (char) 3 : '=') == '=') {
                        z = false;
                        break;
                    }
                    char charAt = str.charAt(i4);
                    byte[] bArr = specicalFlags_doubleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        int i5 = BuiltInFictitiousFunctionClassFactory + 49;
                        PlaceComponentResult = i5 % 128;
                        int i6 = i5 % 2;
                        break;
                    }
                    i4++;
                }
                if (z) {
                    write(34);
                }
                for (int i7 = 0; i7 < length; i7++) {
                    int i8 = PlaceComponentResult + 47;
                    BuiltInFictitiousFunctionClassFactory = i8 % 128;
                    int i9 = i8 % 2;
                    char charAt2 = str.charAt(i7);
                    byte[] bArr2 = specicalFlags_doubleQuotes;
                    if (charAt2 >= bArr2.length || bArr2[charAt2] == 0) {
                        write(charAt2);
                    } else {
                        int i10 = BuiltInFictitiousFunctionClassFactory + 53;
                        PlaceComponentResult = i10 % 128;
                        if (i10 % 2 == 0) {
                            write(12);
                            c = replaceChars[charAt2];
                        } else {
                            write(92);
                            c = replaceChars[charAt2];
                        }
                        write(c);
                        int i11 = BuiltInFictitiousFunctionClassFactory + 19;
                        PlaceComponentResult = i11 % 128;
                        int i12 = i11 % 2;
                    }
                }
                if (z) {
                    write(34);
                }
                write(58);
                return;
            }
            expandCapacity(i);
        }
        if (length == 0) {
            int i13 = BuiltInFictitiousFunctionClassFactory + 37;
            PlaceComponentResult = i13 % 128;
            int i14 = i13 % 2;
            int i15 = this.count;
            int i16 = i15 + 3;
            if (i16 > this.buf.length) {
                int i17 = BuiltInFictitiousFunctionClassFactory + 41;
                PlaceComponentResult = i17 % 128;
                if ((i17 % 2 != 0 ? (char) 23 : (char) 3) != 23) {
                    expandCapacity(i15 >>> 5);
                } else {
                    expandCapacity(i16);
                }
                int i18 = BuiltInFictitiousFunctionClassFactory + 35;
                PlaceComponentResult = i18 % 128;
                int i19 = i18 % 2;
            }
            char[] cArr = this.buf;
            int i20 = this.count;
            int i21 = i20 + 1;
            cArr[i20] = Typography.quote;
            int i22 = i21 + 1;
            cArr[i21] = Typography.quote;
            this.count = i22 + 1;
            cArr[i22] = ':';
            return;
        }
        int i23 = this.count;
        int i24 = i23 + length;
        str.getChars(0, length, this.buf, i23);
        this.count = i;
        int i25 = i23;
        boolean z2 = false;
        while (i25 < i24) {
            char[] cArr2 = this.buf;
            char c2 = cArr2[i25];
            byte[] bArr3 = specicalFlags_doubleQuotes;
            if (c2 < bArr3.length && bArr3[c2] != 0) {
                if (z2) {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                        int i26 = PlaceComponentResult + 33;
                        BuiltInFictitiousFunctionClassFactory = i26 % 128;
                        int i27 = i26 % 2;
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i28 = i25 + 1;
                    System.arraycopy(cArr3, i28, cArr3, i25 + 2, i24 - i25);
                    char[] cArr4 = this.buf;
                    cArr4[i25] = '\\';
                    cArr4[i28] = replaceChars[c2];
                    i24++;
                    i25 = i28;
                } else {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr5 = this.buf;
                    int i29 = i25 + 1;
                    System.arraycopy(cArr5, i29, cArr5, i25 + 3, (i24 - i25) - 1);
                    char[] cArr6 = this.buf;
                    System.arraycopy(cArr6, 0, cArr6, 1, i25);
                    char[] cArr7 = this.buf;
                    cArr7[i23] = Typography.quote;
                    cArr7[i29] = '\\';
                    int i30 = i29 + 1;
                    cArr7[i30] = replaceChars[c2];
                    i24 += 2;
                    cArr7[this.count - 2] = Typography.quote;
                    i25 = i30;
                    z2 = true;
                }
            }
            i25++;
        }
        this.buf[this.count - 1] = ':';
    }

    /*  JADX ERROR: JadxRuntimeException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r15v24 int, still in use, count: 2, list:
          (r15v24 int) from 0x00aa: ARITH (r15v24 int) % (4 int) A[WRAPPED] (LINE:916)
          (r15v24 int) from 0x00bf: PHI (r15v21 int) = (r15v20 int), (r15v24 int) binds: [B:57:0x00bd, B:51:0x00af] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:152)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:117)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:33)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:57)
        */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00af, code lost:
    
        if ((r15 % 4) > r14.buf.length) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00bd, code lost:
    
        if ((r15 + 3 > r14.buf.length) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00bf, code lost:
    
        expandCapacity(r15 + 3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void writeKeyWithSingleQuoteIfHasSpecial(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeKeyWithSingleQuoteIfHasSpecial(java.lang.String):void");
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        int i = BuiltInFictitiousFunctionClassFactory + 77;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Writer writer = this.writer;
        if (writer != null) {
            try {
                writer.write(this.buf, 0, this.count);
                this.writer.flush();
                this.count = 0;
                return;
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
        int i3 = PlaceComponentResult + 83;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if ((r8 < 0 ? 'b' : 'X') != 'X') goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        r0 = '-';
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        if (r8 < 1) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void getChars(long r8, int r10, char[] r11) {
        /*
            Method dump skipped, instructions count: 191
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.getChars(long, int, char[]):void");
    }

    static {
        PlaceComponentResult();
        bufLocal = new ThreadLocal<>();
        sizeTable = new int[]{9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        char c = Typography.dollar;
        digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        DigitTens = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        DigitOnes = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        ascii_chars = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        replaceChars = new char[93];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        int i = 14;
        while (true) {
            if ((i <= 31 ? ';' : Typography.dollar) == c) {
                break;
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 17;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            specicalFlags_doubleQuotes[i] = 4;
            specicalFlags_singleQuotes[i] = 4;
            i++;
            c = Typography.dollar;
        }
        int i4 = 127;
        while (true) {
            if (i4 >= 160) {
                char[] cArr = replaceChars;
                cArr[0] = '0';
                cArr[1] = '1';
                cArr[2] = '2';
                cArr[3] = '3';
                cArr[4] = '4';
                cArr[5] = '5';
                cArr[6] = '6';
                cArr[7] = '7';
                cArr[8] = 'b';
                cArr[9] = 't';
                cArr[10] = 'n';
                cArr[11] = 'v';
                cArr[12] = 'f';
                cArr[13] = 'r';
                cArr[34] = Typography.quote;
                cArr[39] = '\'';
                cArr[47] = '/';
                cArr[92] = '\\';
                DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                int i5 = PlaceComponentResult + 81;
                BuiltInFictitiousFunctionClassFactory = i5 % 128;
                int i6 = i5 % 2;
                return;
            }
            int i7 = PlaceComponentResult + 53;
            BuiltInFictitiousFunctionClassFactory = i7 % 128;
            int i8 = i7 % 2;
            specicalFlags_doubleQuotes[i4] = 4;
            specicalFlags_singleQuotes[i4] = 4;
            i4++;
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        int i4;
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i2) {
            int i5 = $11 + 25;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i7 = a2.MyBillsEntityDataFactory;
            cArr2[i7] = (char) (cArr2[i7] - ((int) (getAuthRequestContext ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i3 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr2, 0, cArr3, 0, i2);
            System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (true) {
                if (a2.MyBillsEntityDataFactory >= i2) {
                    break;
                }
                int i8 = $10 + 1;
                $11 = i8 % 128;
                if ((i8 % 2 == 0 ? (char) 16 : '=') != 16) {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    i4 = a2.MyBillsEntityDataFactory + 1;
                } else {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(a2.MyBillsEntityDataFactory * i2) % 1];
                    i4 = a2.MyBillsEntityDataFactory >> 0;
                }
                a2.MyBillsEntityDataFactory = i4;
                int i9 = $11 + 23;
                $10 = i9 % 128;
                int i10 = i9 % 2;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
