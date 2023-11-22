package com.apiguard3.internal;

import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public class setLayerType implements Closeable, Flushable {
    private static final String[] AGState;
    private static int checkCertificates = 79;
    private static final String[] getSharedInstance = new String[128];
    private static int updateKernel;
    private boolean APIGuard$Callback;
    private String analyzeResponse;
    private String generateHeaders;
    private boolean getRequestHeaders;
    private boolean initialize;
    private String parseResponseHeaders;
    private final Writer values;
    private int[] valueOf = new int[32];
    private int APIGuard = 0;

    static {
        int i = 0;
        while (true) {
            if (!(i <= 31)) {
                break;
            }
            checkCertificates = (updateKernel + 59) % 128;
            getSharedInstance[i] = String.format("\\u%04x", Integer.valueOf(i));
            i++;
            checkCertificates = (updateKernel + 97) % 128;
        }
        String[] strArr = getSharedInstance;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        AGState = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
        int i2 = checkCertificates + 77;
        updateKernel = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 16 : 'a') == 16) {
            return;
        }
        throw null;
    }

    public setLayerType(Writer writer) {
        APIGuard(6);
        this.analyzeResponse = ":";
        this.APIGuard$Callback = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.values = writer;
    }

    public final void AGState(boolean z) {
        int i = (updateKernel + 89) % 128;
        checkCertificates = i;
        this.getRequestHeaders = z;
        updateKernel = (i + 63) % 128;
    }

    public final boolean parseResponseHeaders() {
        int i = checkCertificates + 91;
        int i2 = i % 128;
        updateKernel = i2;
        if (!(i % 2 == 0)) {
            throw new NullPointerException();
        }
        boolean z = this.getRequestHeaders;
        checkCertificates = (i2 + 77) % 128;
        return z;
    }

    public final void getSharedInstance(boolean z) {
        int i = updateKernel + 121;
        checkCertificates = i % 128;
        boolean z2 = i % 2 == 0;
        this.initialize = z;
        if (z2) {
            throw null;
        }
    }

    public final boolean generateHeaders() {
        int i = updateKernel + 65;
        int i2 = i % 128;
        checkCertificates = i2;
        if (i % 2 == 0) {
            throw new ArithmeticException();
        }
        boolean z = this.initialize;
        updateKernel = (i2 + 35) % 128;
        return z;
    }

    public final void valueOf(boolean z) {
        int i = (updateKernel + 65) % 128;
        checkCertificates = i;
        this.APIGuard$Callback = z;
        int i2 = i + 123;
        updateKernel = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        throw null;
    }

    public final boolean getRequestHeaders() {
        int i = updateKernel;
        checkCertificates = (i + 65) % 128;
        boolean z = this.APIGuard$Callback;
        checkCertificates = (i + 81) % 128;
        return z;
    }

    public setLayerType valueOf() throws IOException {
        checkCertificates = (updateKernel + 95) % 128;
        initialize();
        setLayerType APIGuard = APIGuard(1, '[');
        updateKernel = (checkCertificates + 91) % 128;
        return APIGuard;
    }

    public setLayerType values() throws IOException {
        int i = updateKernel + 35;
        checkCertificates = i % 128;
        return i % 2 != 0 ? values(1, 2, ']') : values(0, 4, 'H');
    }

    public setLayerType AGState() throws IOException {
        updateKernel = (checkCertificates + 125) % 128;
        initialize();
        setLayerType APIGuard = APIGuard(3, '{');
        int i = updateKernel + 83;
        checkCertificates = i % 128;
        if (!(i % 2 == 0)) {
            return APIGuard;
        }
        throw null;
    }

    public setLayerType getSharedInstance() throws IOException {
        int i = checkCertificates + 97;
        updateKernel = i % 128;
        setLayerType values = i % 2 != 0 ? values(2, 4, Typography.dollar) : values(3, 5, '}');
        checkCertificates = (updateKernel + 119) % 128;
        return values;
    }

    private setLayerType APIGuard(int i, char c) throws IOException {
        checkCertificates = (updateKernel + 55) % 128;
        updateKernel();
        APIGuard(i);
        this.values.write(c);
        updateKernel = (checkCertificates + 95) % 128;
        return this;
    }

    private setLayerType values(int i, int i2, char c) throws IOException {
        int APIGuard = APIGuard();
        if ((APIGuard != i2 ? '\b' : (char) 17) == '\b') {
            int i3 = updateKernel + 85;
            checkCertificates = i3 % 128;
            if (i3 % 2 == 0) {
                throw new ArithmeticException();
            } else if (APIGuard != i) {
                throw new IllegalStateException("Nesting problem.");
            }
        }
        if (this.generateHeaders != null) {
            StringBuilder sb = new StringBuilder("Dangling name: ");
            sb.append(this.generateHeaders);
            throw new IllegalStateException(sb.toString());
        }
        this.APIGuard--;
        if (APIGuard == i2) {
            updateKernel = (checkCertificates + 109) % 128;
            log();
        }
        this.values.write(c);
        return this;
    }

    private void APIGuard(int i) {
        int i2 = this.APIGuard;
        int[] iArr = this.valueOf;
        if ((i2 == iArr.length ? (char) 14 : '\'') == 14) {
            updateKernel = (checkCertificates + 49) % 128;
            this.valueOf = Arrays.copyOf(iArr, i2 << 1);
        }
        int[] iArr2 = this.valueOf;
        int i3 = this.APIGuard;
        this.APIGuard = i3 + 1;
        iArr2[i3] = i;
        int i4 = checkCertificates + 63;
        updateKernel = i4 % 128;
        if ((i4 % 2 != 0 ? 'O' : JSONLexer.EOI) == 26) {
            return;
        }
        throw new NullPointerException();
    }

    private int APIGuard() {
        int i = updateKernel;
        checkCertificates = (i + 69) % 128;
        int i2 = this.APIGuard;
        if (i2 == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        int i3 = this.valueOf[i2 - 1];
        checkCertificates = (i + 7) % 128;
        return i3;
    }

    private void valueOf(int i) {
        int i2 = (checkCertificates + 29) % 128;
        updateKernel = i2;
        this.valueOf[this.APIGuard - 1] = i;
        checkCertificates = (i2 + 119) % 128;
    }

    public setLayerType APIGuard(String str) throws IOException {
        int i = updateKernel;
        int i2 = i + 31;
        checkCertificates = i2 % 128;
        if ((i2 % 2 == 0 ? 'B' : '7') == 'B') {
            throw new NullPointerException();
        } else if (str == null) {
            throw new NullPointerException("name == null");
        } else {
            if (this.generateHeaders != null) {
                throw new IllegalStateException();
            }
            if (this.APIGuard == 0) {
                throw new IllegalStateException("JsonWriter is closed.");
            }
            this.generateHeaders = str;
            int i3 = i + 119;
            checkCertificates = i3 % 128;
            if ((i3 % 2 == 0 ? JSONLexer.EOI : 'B') != 26) {
                return this;
            }
            throw new NullPointerException();
        }
    }

    private void initialize() throws IOException {
        checkCertificates = (updateKernel + 111) % 128;
        if ((this.generateHeaders != null ? '\r' : 'C') == '\r') {
            checkCertificates();
            values(this.generateHeaders);
            this.generateHeaders = null;
        }
        updateKernel = (checkCertificates + 67) % 128;
    }

    public setLayerType AGState(String str) throws IOException {
        if (str == null) {
            int i = updateKernel + 77;
            checkCertificates = i % 128;
            if (i % 2 != 0) {
                return analyzeResponse();
            }
            analyzeResponse();
            throw null;
        }
        initialize();
        updateKernel();
        values(str);
        int i2 = checkCertificates + 109;
        updateKernel = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        return this;
    }

    public setLayerType analyzeResponse() throws IOException {
        int i = checkCertificates + 89;
        int i2 = i % 128;
        updateKernel = i2;
        if (i % 2 != 0) {
            throw null;
        }
        if (this.generateHeaders != null) {
            if ((!this.APIGuard$Callback) == true) {
                this.generateHeaders = null;
                checkCertificates = (i2 + 1) % 128;
                return this;
            }
            initialize();
            updateKernel = (checkCertificates + 61) % 128;
        }
        updateKernel();
        this.values.write("null");
        int i3 = updateKernel + 53;
        checkCertificates = i3 % 128;
        if ((i3 % 2 == 0 ? 'J' : 'a') == 'a') {
            return this;
        }
        throw new NullPointerException();
    }

    public setLayerType values(boolean z) throws IOException {
        String str;
        updateKernel = (checkCertificates + 69) % 128;
        initialize();
        updateKernel();
        Writer writer = this.values;
        if ((z ? '7' : 'R') != '7') {
            str = "false";
        } else {
            updateKernel = (checkCertificates + 11) % 128;
            str = SummaryActivity.CHECKED;
        }
        writer.write(str);
        return this;
    }

    public setLayerType valueOf(Boolean bool) throws IOException {
        String str;
        int i = (updateKernel + 113) % 128;
        checkCertificates = i;
        if (bool == null) {
            int i2 = i + 25;
            updateKernel = i2 % 128;
            if (i2 % 2 == 0) {
                return analyzeResponse();
            }
            analyzeResponse();
            throw null;
        }
        initialize();
        updateKernel();
        Writer writer = this.values;
        if ((bool.booleanValue() ? Typography.dollar : (char) 16) != '$') {
            checkCertificates = (updateKernel + 89) % 128;
            str = "false";
        } else {
            int i3 = updateKernel + 73;
            checkCertificates = i3 % 128;
            if ((i3 % 2 != 0 ? '0' : (char) 16) != '0') {
                throw new NullPointerException();
            }
            str = SummaryActivity.CHECKED;
        }
        writer.write(str);
        return this;
    }

    public setLayerType AGState(long j) throws IOException {
        checkCertificates = (updateKernel + 103) % 128;
        initialize();
        updateKernel();
        this.values.write(Long.toString(j));
        int i = updateKernel + 59;
        checkCertificates = i % 128;
        if (!(i % 2 == 0)) {
            return this;
        }
        throw new ArithmeticException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
    
        if (r0.equals("NaN") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.apiguard3.internal.setLayerType APIGuard(java.lang.Number r4) throws java.io.IOException {
        /*
            r3 = this;
            int r0 = com.apiguard3.internal.setLayerType.checkCertificates
            int r0 = r0 + 85
            int r1 = r0 % 128
            com.apiguard3.internal.setLayerType.updateKernel = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L5f
            if (r4 != 0) goto L19
            int r1 = r1 + 3
            int r1 = r1 % 128
            com.apiguard3.internal.setLayerType.checkCertificates = r1
            com.apiguard3.internal.setLayerType r4 = r3.analyzeResponse()
            return r4
        L19:
            r3.initialize()
            java.lang.String r0 = r4.toString()
            boolean r1 = r3.getRequestHeaders
            if (r1 != 0) goto L56
            java.lang.String r1 = "-Infinity"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L46
            java.lang.String r1 = "Infinity"
            boolean r1 = r0.equals(r1)
            r2 = 49
            if (r1 != 0) goto L39
            r1 = 49
            goto L3b
        L39:
            r1 = 18
        L3b:
            if (r1 != r2) goto L46
            java.lang.String r1 = "NaN"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L46
            goto L56
        L46:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r1 = "Numeric values must be finite, but was "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        L56:
            r3.updateKernel()
            java.io.Writer r4 = r3.values
            r4.append(r0)
            return r3
        L5f:
            r4 = 0
            throw r4     // Catch: java.lang.Throwable -> L61
        L61:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setLayerType.APIGuard(java.lang.Number):com.apiguard3.internal.setLayerType");
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        checkCertificates = (updateKernel + 47) % 128;
        if (this.APIGuard == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.values.flush();
        checkCertificates = (updateKernel + 123) % 128;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if ((r0 == 0 ? 'X' : 'C') != 'C') goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r0 == 1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        if (r5.valueOf[r0 - 1] != 7) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        r5.APIGuard = 0;
        r2 = r2 + 75;
        com.apiguard3.internal.setLayerType.updateKernel = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        if ((r2 % 2) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        if (r1 == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
    
        throw null;
     */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void close() throws java.io.IOException {
        /*
            r5 = this;
            java.io.Writer r0 = r5.values
            r0.close()
            int r0 = r5.APIGuard
            r1 = 1
            if (r0 > r1) goto L41
            int r2 = com.apiguard3.internal.setLayerType.checkCertificates
            int r3 = r2 + 65
            int r4 = r3 % 128
            com.apiguard3.internal.setLayerType.updateKernel = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L22
            r3 = 67
            if (r0 != 0) goto L1d
            r4 = 88
            goto L1f
        L1d:
            r4 = 67
        L1f:
            if (r4 == r3) goto L2c
            goto L24
        L22:
            if (r0 != r1) goto L2c
        L24:
            int[] r3 = r5.valueOf
            int r0 = r0 - r1
            r0 = r3[r0]
            r3 = 7
            if (r0 != r3) goto L41
        L2c:
            r0 = 0
            r5.APIGuard = r0
            int r2 = r2 + 75
            int r3 = r2 % 128
            com.apiguard3.internal.setLayerType.updateKernel = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L3a
            r1 = 0
        L3a:
            if (r1 == 0) goto L3d
            return
        L3d:
            r0 = 0
            throw r0     // Catch: java.lang.Throwable -> L3f
        L3f:
            r0 = move-exception
            throw r0
        L41:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Incomplete document"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setLayerType.close():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void values(java.lang.String r11) throws java.io.IOException {
        /*
            r10 = this;
            int r0 = com.apiguard3.internal.setLayerType.checkCertificates
            int r1 = r0 + 7
            r2 = 128(0x80, float:1.794E-43)
            int r1 = r1 % r2
            com.apiguard3.internal.setLayerType.updateKernel = r1
            boolean r1 = r10.initialize
            if (r1 == 0) goto L1e
            int r0 = r0 + 73
            int r1 = r0 % 128
            com.apiguard3.internal.setLayerType.updateKernel = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L1a
            java.lang.String[] r0 = com.apiguard3.internal.setLayerType.AGState
            goto L20
        L1a:
            r11 = 0
            throw r11     // Catch: java.lang.Throwable -> L1c
        L1c:
            r11 = move-exception
            throw r11
        L1e:
            java.lang.String[] r0 = com.apiguard3.internal.setLayerType.getSharedInstance
        L20:
            java.io.Writer r1 = r10.values
            r3 = 34
            r1.write(r3)
            int r1 = r11.length()
            r4 = 0
            r5 = 0
            r6 = 0
        L2e:
            r7 = 1
            if (r5 >= r1) goto L33
            r8 = 1
            goto L34
        L33:
            r8 = 0
        L34:
            if (r8 == r7) goto L4d
            r0 = 42
            if (r6 >= r1) goto L3d
            r2 = 11
            goto L3f
        L3d:
            r2 = 42
        L3f:
            if (r2 == r0) goto L47
            java.io.Writer r0 = r10.values
            int r1 = r1 - r6
            r0.write(r11, r6, r1)
        L47:
            java.io.Writer r11 = r10.values
            r11.write(r3)
            return
        L4d:
            int r8 = com.apiguard3.internal.setLayerType.checkCertificates
            int r8 = r8 + 59
            int r8 = r8 % r2
            com.apiguard3.internal.setLayerType.updateKernel = r8
            char r8 = r11.charAt(r5)
            if (r8 >= r2) goto L5f
            r7 = r0[r8]
            if (r7 != 0) goto L77
            goto L8e
        L5f:
            r9 = 8232(0x2028, float:1.1535E-41)
            if (r8 != r9) goto L64
            goto L65
        L64:
            r7 = 0
        L65:
            if (r7 == 0) goto L6a
            java.lang.String r7 = "\\u2028"
            goto L77
        L6a:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r8 != r7) goto L8e
            int r7 = com.apiguard3.internal.setLayerType.checkCertificates
            int r7 = r7 + 101
            int r7 = r7 % r2
            com.apiguard3.internal.setLayerType.updateKernel = r7
            java.lang.String r7 = "\\u2029"
        L77:
            if (r6 >= r5) goto L87
            java.io.Writer r8 = r10.values
            int r9 = r5 - r6
            r8.write(r11, r6, r9)
            int r6 = com.apiguard3.internal.setLayerType.updateKernel
            int r6 = r6 + 89
            int r6 = r6 % r2
            com.apiguard3.internal.setLayerType.checkCertificates = r6
        L87:
            java.io.Writer r6 = r10.values
            r6.write(r7)
            int r6 = r5 + 1
        L8e:
            int r5 = r5 + 1
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setLayerType.values(java.lang.String):void");
    }

    private void log() throws IOException {
        checkCertificates = (updateKernel + 93) % 128;
        if (this.parseResponseHeaders == null) {
            return;
        }
        this.values.write(10);
        int i = this.APIGuard;
        int i2 = 1;
        while (true) {
            if (i2 >= i) {
                return;
            }
            int i3 = checkCertificates + 55;
            updateKernel = i3 % 128;
            if ((i3 % 2 != 0 ? '\t' : (char) 25) != 25) {
                this.values.write(this.parseResponseHeaders);
                i2 += 101;
            } else {
                this.values.write(this.parseResponseHeaders);
                i2++;
            }
        }
    }

    private void checkCertificates() throws IOException {
        updateKernel = (checkCertificates + 29) % 128;
        int APIGuard = APIGuard();
        if ((APIGuard == 5 ? InputCardNumberView.DIVIDER : (char) 3) != 3) {
            this.values.write(44);
            checkCertificates = (updateKernel + 67) % 128;
        } else if (APIGuard != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        log();
        valueOf(4);
        updateKernel = (checkCertificates + 51) % 128;
    }

    private void updateKernel() throws IOException {
        int APIGuard = APIGuard();
        if (APIGuard == 1) {
            valueOf(2);
            log();
            updateKernel = (checkCertificates + 55) % 128;
        } else if (APIGuard == 2) {
            this.values.append(',');
            log();
        } else if (APIGuard != 4) {
            if (APIGuard != 6) {
                if (APIGuard == 7) {
                    if (!this.getRequestHeaders) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                } else {
                    throw new IllegalStateException("Nesting problem.");
                }
            }
            valueOf(7);
            checkCertificates = (updateKernel + 97) % 128;
        } else {
            this.values.append((CharSequence) this.analyzeResponse);
            valueOf(5);
        }
    }
}
