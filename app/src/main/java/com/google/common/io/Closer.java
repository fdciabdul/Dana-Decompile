package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class Closer implements Closeable {
    private static final Suppressor SUPPRESSOR;
    private final Deque<Closeable> stack = new ArrayDeque(4);
    final Suppressor suppressor;
    @CheckForNull
    private Throwable thrown;

    /* loaded from: classes7.dex */
    interface Suppressor {
        void suppress(Closeable closeable, Throwable th, Throwable th2);
    }

    static {
        Suppressor tryCreate = SuppressingSuppressor.tryCreate();
        if (tryCreate == null) {
            tryCreate = LoggingSuppressor.INSTANCE;
        }
        SUPPRESSOR = tryCreate;
    }

    public static Closer create() {
        return new Closer(SUPPRESSOR);
    }

    Closer(Suppressor suppressor) {
        this.suppressor = (Suppressor) Preconditions.checkNotNull(suppressor);
    }

    @ParametricNullness
    public final <C extends Closeable> C register(@ParametricNullness C c) {
        if (c != null) {
            this.stack.addFirst(c);
        }
        return c;
    }

    public final RuntimeException rethrow(Throwable th) throws IOException {
        Preconditions.checkNotNull(th);
        this.thrown = th;
        Throwables.propagateIfPossible(th, IOException.class);
        throw new RuntimeException(th);
    }

    public final <X extends Exception> RuntimeException rethrow(Throwable th, Class<X> cls) throws IOException, Exception {
        Preconditions.checkNotNull(th);
        this.thrown = th;
        Throwables.propagateIfPossible(th, IOException.class);
        Throwables.propagateIfPossible(th, cls);
        throw new RuntimeException(th);
    }

    public final <X1 extends Exception, X2 extends Exception> RuntimeException rethrow(Throwable th, Class<X1> cls, Class<X2> cls2) throws IOException, Exception, Exception {
        Preconditions.checkNotNull(th);
        this.thrown = th;
        Throwables.propagateIfPossible(th, IOException.class);
        Throwables.propagateIfPossible(th, cls, cls2);
        throw new RuntimeException(th);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Throwable th = this.thrown;
        while (!this.stack.isEmpty()) {
            Closeable removeFirst = this.stack.removeFirst();
            try {
                removeFirst.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.suppressor.suppress(removeFirst, th, th2);
                }
            }
        }
        if (this.thrown != null || th == null) {
            return;
        }
        Throwables.propagateIfPossible(th, IOException.class);
        throw new AssertionError(th);
    }

    /* loaded from: classes7.dex */
    static final class LoggingSuppressor implements Suppressor {
        static final LoggingSuppressor INSTANCE = new LoggingSuppressor();

        LoggingSuppressor() {
        }

        @Override // com.google.common.io.Closer.Suppressor
        public final void suppress(Closeable closeable, Throwable th, Throwable th2) {
            Logger logger = Closeables.logger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppressing exception thrown when closing ");
            sb.append(closeable);
            logger.log(level, sb.toString(), th2);
        }
    }

    /* loaded from: classes7.dex */
    static final class SuppressingSuppressor implements Suppressor {
        private final Method addSuppressed;

        @CheckForNull
        static SuppressingSuppressor tryCreate() {
            try {
                return new SuppressingSuppressor(Throwable.class.getMethod("addSuppressed", Throwable.class));
            } catch (Throwable unused) {
                return null;
            }
        }

        private SuppressingSuppressor(Method method) {
            this.addSuppressed = method;
        }

        @Override // com.google.common.io.Closer.Suppressor
        public final void suppress(Closeable closeable, Throwable th, Throwable th2) {
            if (th == th2) {
                return;
            }
            try {
                this.addSuppressed.invoke(th, th2);
            } catch (Throwable unused) {
                LoggingSuppressor.INSTANCE.suppress(closeable, th, th2);
            }
        }
    }
}
