package io.reactivex.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    public CompositeException(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public CompositeException(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.exceptions = unmodifiableList;
        StringBuilder sb = new StringBuilder();
        sb.append(unmodifiableList.size());
        sb.append(" exceptions occurred. ");
        this.message = sb.toString();
    }

    public final List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        Throwable th;
        synchronized (this) {
            if (this.cause == null) {
                CompositeExceptionCausalChain compositeExceptionCausalChain = new CompositeExceptionCausalChain();
                HashSet hashSet = new HashSet();
                Iterator<Throwable> it = this.exceptions.iterator();
                CompositeExceptionCausalChain compositeExceptionCausalChain2 = compositeExceptionCausalChain;
                while (it.hasNext()) {
                    Throwable next = it.next();
                    if (!hashSet.contains(next)) {
                        hashSet.add(next);
                        for (Throwable th2 : getListOfCauses(next)) {
                            if (hashSet.contains(th2)) {
                                next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                            } else {
                                hashSet.add(th2);
                            }
                        }
                        try {
                            compositeExceptionCausalChain2.initCause(next);
                        } catch (Throwable unused) {
                        }
                        compositeExceptionCausalChain2 = getRootCause(compositeExceptionCausalChain2);
                    }
                }
                this.cause = compositeExceptionCausalChain;
            }
            th = this.cause;
        }
        return th;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        printStackTrace(new WrappedPrintStream(printStream));
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        printStackTrace(new WrappedPrintWriter(printWriter));
    }

    private void printStackTrace(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i = 1;
        for (Throwable th : this.exceptions) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            appendStackTrace(sb, th, "\t");
            i++;
        }
        printStreamOrWriter.getAuthRequestContext(sb.toString());
    }

    private void appendStackTrace(StringBuilder sb, Throwable th, String str) {
        while (true) {
            sb.append(str);
            sb.append(th);
            sb.append('\n');
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                sb.append("\t\tat ");
                sb.append(stackTraceElement);
                sb.append('\n');
            }
            if (th.getCause() == null) {
                return;
            }
            sb.append("\tCaused by: ");
            th = th.getCause();
            str = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class PrintStreamOrWriter {
        abstract void getAuthRequestContext(Object obj);

        PrintStreamOrWriter() {
        }
    }

    /* loaded from: classes2.dex */
    static final class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream BuiltInFictitiousFunctionClassFactory;

        WrappedPrintStream(PrintStream printStream) {
            this.BuiltInFictitiousFunctionClassFactory = printStream;
        }

        @Override // io.reactivex.exceptions.CompositeException.PrintStreamOrWriter
        final void getAuthRequestContext(Object obj) {
            this.BuiltInFictitiousFunctionClassFactory.println(obj);
        }
    }

    /* loaded from: classes.dex */
    static final class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter KClassImpl$Data$declaredNonStaticMembers$2;

        WrappedPrintWriter(PrintWriter printWriter) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = printWriter;
        }

        @Override // io.reactivex.exceptions.CompositeException.PrintStreamOrWriter
        final void getAuthRequestContext(Object obj) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.println(obj);
        }
    }

    /* loaded from: classes.dex */
    static final class CompositeExceptionCausalChain extends RuntimeException {
        static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        @Override // java.lang.Throwable
        public final String getMessage() {
            return MESSAGE;
        }

        CompositeExceptionCausalChain() {
        }
    }

    private List<Throwable> getListOfCauses(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause2;
            }
        }
        return arrayList;
    }

    public final int size() {
        return this.exceptions.size();
    }

    final Throwable getRootCause(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || th == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause2;
        }
        return cause;
    }
}
