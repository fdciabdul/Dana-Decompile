package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class GlideException extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS;
    public static final int MyBillsEntityDataFactory;
    public static final byte[] PlaceComponentResult;
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private Key key;

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }

    public GlideException(String str) {
        this(str, Collections.emptyList());
    }

    public GlideException(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setLoggingDetails(Key key, DataSource dataSource) {
        setLoggingDetails(key, dataSource, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setLoggingDetails(Key key, DataSource dataSource, Class<?> cls) {
        this.key = key;
        this.dataSource = dataSource;
        this.dataClass = cls;
    }

    public final void setOrigin(Exception exc) {
        this.exception = exc;
    }

    public final Exception getOrigin() {
        return this.exception;
    }

    public final List<Throwable> getCauses() {
        return this.causes;
    }

    public final List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        addRootCauses(this, arrayList);
        return arrayList;
    }

    public final void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            InstrumentInjector.log_i(str, sb.toString(), rootCauses.get(i));
            i = i2;
        }
    }

    private void addRootCauses(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            Iterator<Throwable> it = ((GlideException) th).getCauses().iterator();
            while (it.hasNext()) {
                addRootCauses(it.next(), list);
            }
            return;
        }
        list.add(th);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        printStackTrace((Appendable) printStream);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        printStackTrace((Appendable) printWriter);
    }

    private void printStackTrace(Appendable appendable) {
        appendExceptionMessage(this, appendable);
        appendCauses(getCauses(), new IndentedAppendable(appendable));
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.detailMessage);
        String str3 = "";
        if (this.dataClass != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(", ");
            sb2.append(this.dataClass);
            str = sb2.toString();
        } else {
            str = "";
        }
        sb.append(str);
        if (this.dataSource != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(", ");
            sb3.append(this.dataSource);
            str2 = sb3.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (this.key != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(", ");
            sb4.append(this.key);
            str3 = sb4.toString();
        }
        sb.append(str3);
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb.toString();
        }
        if (rootCauses.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(rootCauses.size());
            sb.append(" root causes:");
        }
        for (Throwable th : rootCauses) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    private static void appendExceptionMessage(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private static void appendCauses(List<Throwable> list, Appendable appendable) {
        try {
            appendCausesWrapped(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void appendCausesWrapped(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof GlideException) {
                ((GlideException) th).printStackTrace(appendable);
            } else {
                appendExceptionMessage(th, appendable);
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class IndentedAppendable implements Appendable {
        private final Appendable BuiltInFictitiousFunctionClassFactory;
        private boolean MyBillsEntityDataFactory = true;

        IndentedAppendable(Appendable appendable) {
            this.BuiltInFictitiousFunctionClassFactory = appendable;
        }

        @Override // java.lang.Appendable
        public final Appendable append(char c) throws IOException {
            if (this.MyBillsEntityDataFactory) {
                this.MyBillsEntityDataFactory = false;
                this.BuiltInFictitiousFunctionClassFactory.append("  ");
            }
            this.MyBillsEntityDataFactory = c == '\n';
            this.BuiltInFictitiousFunctionClassFactory.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            return append(charSequence, 0, charSequence.length());
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z = false;
            if (this.MyBillsEntityDataFactory) {
                this.MyBillsEntityDataFactory = false;
                this.BuiltInFictitiousFunctionClassFactory.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.MyBillsEntityDataFactory = z;
            this.BuiltInFictitiousFunctionClassFactory.append(charSequence, i, i2);
            return this;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0046 -> B:11:0x004d). Please submit an issue!!! */
    static {
        /*
            r0 = 30
            byte[] r0 = new byte[r0]
            r0 = {x0056: FILL_ARRAY_DATA , data: [11, -83, -14, 91, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 31, -21, 0, 6, -25, 28, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4} // fill-array
            com.bumptech.glide.load.engine.GlideException.PlaceComponentResult = r0
            r1 = 186(0xba, float:2.6E-43)
            com.bumptech.glide.load.engine.GlideException.MyBillsEntityDataFactory = r1
            r1 = 16
            r1 = r0[r1]
            byte r1 = (byte) r1
            byte r2 = (byte) r1
            byte r3 = (byte) r2
            int r1 = r1 * 3
            int r1 = r1 + 106
            int r3 = r3 * 2
            int r3 = r3 + 27
            int r2 = r2 * 2
            int r2 = r2 + 4
            byte[] r4 = new byte[r3]
            int r3 = r3 + (-1)
            r5 = 0
            if (r0 != 0) goto L2c
            r6 = r4
            r7 = 0
            r4 = r3
            r3 = r2
            goto L4d
        L2c:
            r6 = 0
        L2d:
            byte r7 = (byte) r1
            r4[r6] = r7
            int r7 = r6 + 1
            if (r6 != r3) goto L46
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4, r5)
            java.lang.Class r0 = java.lang.Class.forName(r0)
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r5)
            java.lang.StackTraceElement[] r0 = (java.lang.StackTraceElement[]) r0
            com.bumptech.glide.load.engine.GlideException.EMPTY_ELEMENTS = r0
            return
        L46:
            r6 = r0[r2]
            r8 = r3
            r3 = r1
            r1 = r6
            r6 = r4
            r4 = r8
        L4d:
            int r2 = r2 + 1
            int r3 = r3 + r1
            int r1 = r3 + 2
            r3 = r4
            r4 = r6
            r6 = r7
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.GlideException.<clinit>():void");
    }
}
