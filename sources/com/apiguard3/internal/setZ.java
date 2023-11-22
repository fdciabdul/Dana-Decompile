package com.apiguard3.internal;

import com.alibaba.fastjson.parser.JSONLexer;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class setZ extends setLayerType {
    private setHovered AGState;
    private String APIGuard;
    private final List<setHovered> values;
    private static final Writer getSharedInstance = new Writer() { // from class: com.apiguard3.internal.setZ.5
        @Override // java.io.Writer
        public final void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final setScrollY valueOf = new setScrollY("closed");
    private static int generateHeaders = 1;
    private static int getRequestHeaders = (generateHeaders + 67) % 128;

    @Override // com.apiguard3.internal.setLayerType, java.io.Flushable
    public final void flush() throws IOException {
        int i = getRequestHeaders + 55;
        generateHeaders = i % 128;
        if (i % 2 == 0) {
            throw null;
        }
    }

    public setZ() {
        super(getSharedInstance);
        this.values = new ArrayList();
        this.AGState = setAccessibilityLiveRegion.getSharedInstance;
    }

    public final setHovered APIGuard() {
        getRequestHeaders = (generateHeaders + 85) % 128;
        if (!this.values.isEmpty()) {
            StringBuilder sb = new StringBuilder("Expected one JSON element but was ");
            sb.append(this.values);
            throw new IllegalStateException(sb.toString());
        }
        setHovered sethovered = this.AGState;
        getRequestHeaders = (generateHeaders + 91) % 128;
        return sethovered;
    }

    private setHovered initialize() {
        getRequestHeaders = (generateHeaders + 103) % 128;
        setHovered sethovered = this.values.get(r0.size() - 1);
        generateHeaders = (getRequestHeaders + 43) % 128;
        return sethovered;
    }

    private void APIGuard(setHovered sethovered) {
        if (this.APIGuard == null) {
            if (this.values.isEmpty()) {
                this.AGState = sethovered;
                getRequestHeaders = (generateHeaders + 15) % 128;
                return;
            }
            setHovered initialize = initialize();
            if (!(initialize instanceof setSaveFromParentEnabled)) {
                throw new IllegalStateException();
            }
            generateHeaders = (getRequestHeaders + 59) % 128;
            ((setSaveFromParentEnabled) initialize).getSharedInstance(sethovered);
            return;
        }
        int i = generateHeaders + 25;
        getRequestHeaders = i % 128;
        if (i % 2 != 0) {
            sethovered.parseResponseHeaders();
            throw new ArithmeticException();
        }
        if (!sethovered.parseResponseHeaders() || getRequestHeaders()) {
            ((setImportantForAccessibility) initialize()).values(this.APIGuard, sethovered);
        }
        this.APIGuard = null;
    }

    @Override // com.apiguard3.internal.setLayerType
    public final setLayerType valueOf() throws IOException {
        setSaveFromParentEnabled setsavefromparentenabled = new setSaveFromParentEnabled();
        APIGuard(setsavefromparentenabled);
        this.values.add(setsavefromparentenabled);
        int i = generateHeaders + 7;
        getRequestHeaders = i % 128;
        if (i % 2 != 0) {
            throw new ArithmeticException();
        }
        return this;
    }

    @Override // com.apiguard3.internal.setLayerType
    public final setLayerType values() throws IOException {
        int i = generateHeaders + 17;
        getRequestHeaders = i % 128;
        if (i % 2 == 0) {
            if (this.values.isEmpty() || this.APIGuard != null) {
                throw new IllegalStateException();
            }
            if (initialize() instanceof setSaveFromParentEnabled) {
                List<setHovered> list = this.values;
                list.remove(list.size() - 1);
                int i2 = generateHeaders + 89;
                getRequestHeaders = i2 % 128;
                if ((i2 % 2 != 0 ? 'V' : 'C') != 'V') {
                    return this;
                }
                throw null;
            }
            throw new IllegalStateException();
        }
        this.values.isEmpty();
        throw new ArithmeticException();
    }

    @Override // com.apiguard3.internal.setLayerType
    public final setLayerType AGState() throws IOException {
        setImportantForAccessibility setimportantforaccessibility = new setImportantForAccessibility();
        APIGuard(setimportantforaccessibility);
        this.values.add(setimportantforaccessibility);
        int i = getRequestHeaders + 33;
        generateHeaders = i % 128;
        if ((i % 2 == 0 ? Typography.dollar : 'F') != '$') {
            return this;
        }
        throw new NullPointerException();
    }

    @Override // com.apiguard3.internal.setLayerType
    public final setLayerType getSharedInstance() throws IOException {
        int i = getRequestHeaders + 15;
        generateHeaders = i % 128;
        if ((i % 2 == 0 ? (char) 2 : 'H') != 2) {
            if (this.values.isEmpty() || this.APIGuard != null) {
                throw new IllegalStateException();
            }
            if ((initialize() instanceof setImportantForAccessibility ? 'K' : JSONLexer.EOI) != 26) {
                this.values.remove(r0.size() - 1);
                getRequestHeaders = (generateHeaders + 81) % 128;
                return this;
            }
            throw new IllegalStateException();
        }
        this.values.isEmpty();
        throw null;
    }

    @Override // com.apiguard3.internal.setLayerType
    public final setLayerType APIGuard(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if ((!this.values.isEmpty() ? 'E' : 'F') != 'E' || this.APIGuard != null) {
            throw new IllegalStateException();
        }
        if ((!(initialize() instanceof setImportantForAccessibility)) != true) {
            int i = getRequestHeaders;
            generateHeaders = (i + 71) % 128;
            this.APIGuard = str;
            generateHeaders = (i + 89) % 128;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.apiguard3.internal.setLayerType
    public final setLayerType AGState(String str) throws IOException {
        int i = generateHeaders + 3;
        getRequestHeaders = i % 128;
        if (i % 2 != 0) {
            throw new NullPointerException();
        }
        if ((str == null ? 'c' : (char) 19) == 'c') {
            setLayerType analyzeResponse = analyzeResponse();
            getRequestHeaders = (generateHeaders + 57) % 128;
            return analyzeResponse;
        }
        APIGuard(new setScrollY(str));
        return this;
    }

    @Override // com.apiguard3.internal.setLayerType
    public final setLayerType analyzeResponse() throws IOException {
        getRequestHeaders = (generateHeaders + 11) % 128;
        APIGuard(setAccessibilityLiveRegion.getSharedInstance);
        generateHeaders = (getRequestHeaders + 31) % 128;
        return this;
    }

    @Override // com.apiguard3.internal.setLayerType
    public final setLayerType values(boolean z) throws IOException {
        APIGuard(new setScrollY(Boolean.valueOf(z)));
        int i = generateHeaders + 115;
        getRequestHeaders = i % 128;
        if (!(i % 2 != 0)) {
            return this;
        }
        throw new NullPointerException();
    }

    @Override // com.apiguard3.internal.setLayerType
    public final setLayerType valueOf(Boolean bool) throws IOException {
        int i = getRequestHeaders + 93;
        int i2 = i % 128;
        generateHeaders = i2;
        if (i % 2 == 0) {
            throw new NullPointerException();
        }
        if (bool != null) {
            APIGuard(new setScrollY(bool));
            return this;
        }
        int i3 = i2 + 105;
        getRequestHeaders = i3 % 128;
        if (i3 % 2 == 0) {
            return analyzeResponse();
        }
        analyzeResponse();
        throw new NullPointerException();
    }

    @Override // com.apiguard3.internal.setLayerType
    public final setLayerType AGState(long j) throws IOException {
        APIGuard(new setScrollY(Long.valueOf(j)));
        int i = generateHeaders + 15;
        getRequestHeaders = i % 128;
        if (i % 2 == 0) {
            return this;
        }
        throw new NullPointerException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        if (java.lang.Double.isInfinite(r0) == false) goto L29;
     */
    @Override // com.apiguard3.internal.setLayerType
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.apiguard3.internal.setLayerType APIGuard(java.lang.Number r5) throws java.io.IOException {
        /*
            r4 = this;
            int r0 = com.apiguard3.internal.setZ.getRequestHeaders
            int r1 = r0 + 95
            int r2 = r1 % 128
            com.apiguard3.internal.setZ.generateHeaders = r2
            int r1 = r1 % 2
            if (r1 == 0) goto L74
            r1 = 1
            if (r5 != 0) goto L11
            r2 = 0
            goto L12
        L11:
            r2 = 1
        L12:
            if (r2 == r1) goto L1f
            int r0 = r0 + 17
            int r0 = r0 % 128
            com.apiguard3.internal.setZ.generateHeaders = r0
            com.apiguard3.internal.setLayerType r5 = r4.analyzeResponse()
            return r5
        L1f:
            boolean r0 = r4.parseResponseHeaders()
            r1 = 42
            if (r0 != 0) goto L2a
            r0 = 42
            goto L2c
        L2a:
            r0 = 43
        L2c:
            if (r0 != r1) goto L6b
            int r0 = com.apiguard3.internal.setZ.getRequestHeaders
            int r0 = r0 + 39
            int r0 = r0 % 128
            com.apiguard3.internal.setZ.generateHeaders = r0
            double r0 = r5.doubleValue()
            boolean r2 = java.lang.Double.isNaN(r0)
            if (r2 != 0) goto L5b
            int r2 = com.apiguard3.internal.setZ.getRequestHeaders
            int r2 = r2 + 77
            int r3 = r2 % 128
            com.apiguard3.internal.setZ.generateHeaders = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L53
            boolean r0 = java.lang.Double.isInfinite(r0)
            if (r0 != 0) goto L5b
            goto L6b
        L53:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException     // Catch: java.lang.Throwable -> L59
            r5.<init>()     // Catch: java.lang.Throwable -> L59
            throw r5     // Catch: java.lang.Throwable -> L59
        L59:
            r5 = move-exception
            throw r5
        L5b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r1 = "JSON forbids NaN and infinities: "
            java.lang.String r5 = r1.concat(r5)
            r0.<init>(r5)
            throw r0
        L6b:
            com.apiguard3.internal.setScrollY r0 = new com.apiguard3.internal.setScrollY
            r0.<init>(r5)
            r4.APIGuard(r0)
            return r4
        L74:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException     // Catch: java.lang.Throwable -> L7a
            r5.<init>()     // Catch: java.lang.Throwable -> L7a
            throw r5     // Catch: java.lang.Throwable -> L7a
        L7a:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setZ.APIGuard(java.lang.Number):com.apiguard3.internal.setLayerType");
    }

    @Override // com.apiguard3.internal.setLayerType, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i = generateHeaders + 95;
        getRequestHeaders = i % 128;
        if (!(i % 2 != 0)) {
            if (!this.values.isEmpty()) {
                throw new IOException("Incomplete document");
            }
            this.values.add(valueOf);
            int i2 = getRequestHeaders + 89;
            generateHeaders = i2 % 128;
            if ((i2 % 2 == 0 ? '8' : 'N') != '8') {
                return;
            }
            throw new NullPointerException();
        }
        this.values.isEmpty();
        throw new NullPointerException();
    }
}
