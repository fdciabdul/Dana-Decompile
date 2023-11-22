package okio;

import java.io.IOException;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class Pipe {
    final long BuiltInFictitiousFunctionClassFactory;
    final Buffer KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory;
    boolean PlaceComponentResult;
    @Nullable
    private Sink getAuthRequestContext;

    /* loaded from: classes9.dex */
    final class PipeSink implements Sink {
        final PushableTimeout KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ Pipe getAuthRequestContext;

        @Override // okio.Sink
        public final void write(Buffer buffer, long j) throws IOException {
            Sink sink;
            synchronized (this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (!this.getAuthRequestContext.PlaceComponentResult) {
                    while (true) {
                        if (j <= 0) {
                            sink = null;
                            break;
                        } else if (this.getAuthRequestContext.getAuthRequestContext != null) {
                            sink = this.getAuthRequestContext.getAuthRequestContext;
                            break;
                        } else if (this.getAuthRequestContext.MyBillsEntityDataFactory) {
                            throw new IOException("source is closed");
                        } else {
                            long j2 = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory - this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                            if (j2 == 0) {
                                this.KClassImpl$Data$declaredNonStaticMembers$2.waitUntilNotified(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
                            } else {
                                long min = Math.min(j2, j);
                                this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.write(buffer, min);
                                j -= min;
                                this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.notifyAll();
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
            if (sink != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(sink.timeout());
                try {
                    sink.write(buffer, j);
                } finally {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            Sink sink;
            synchronized (this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (!this.getAuthRequestContext.PlaceComponentResult) {
                    if (this.getAuthRequestContext.getAuthRequestContext != null) {
                        sink = this.getAuthRequestContext.getAuthRequestContext;
                    } else {
                        if (this.getAuthRequestContext.MyBillsEntityDataFactory && this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext > 0) {
                            throw new IOException("source is closed");
                        }
                        sink = null;
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
            if (sink != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(sink.timeout());
                try {
                    sink.flush();
                } finally {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                }
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            Sink sink;
            synchronized (this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (this.getAuthRequestContext.PlaceComponentResult) {
                    return;
                }
                if (this.getAuthRequestContext.getAuthRequestContext != null) {
                    sink = this.getAuthRequestContext.getAuthRequestContext;
                } else {
                    if (this.getAuthRequestContext.MyBillsEntityDataFactory && this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext > 0) {
                        throw new IOException("source is closed");
                    }
                    this.getAuthRequestContext.PlaceComponentResult = true;
                    this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.notifyAll();
                    sink = null;
                }
                if (sink != null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(sink.timeout());
                    try {
                        sink.close();
                    } finally {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                    }
                }
            }
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* loaded from: classes9.dex */
    final class PipeSource implements Source {
        final /* synthetic */ Pipe BuiltInFictitiousFunctionClassFactory;
        final Timeout MyBillsEntityDataFactory;

        @Override // okio.Source
        public final long read(Buffer buffer, long j) throws IOException {
            synchronized (this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory) {
                    throw new IllegalStateException("closed");
                }
                while (this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext == 0) {
                    if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult) {
                        return -1L;
                    }
                    this.MyBillsEntityDataFactory.waitUntilNotified(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                long read = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.read(buffer, j);
                this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.notifyAll();
                return read;
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            synchronized (this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = true;
                this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.notifyAll();
            }
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.MyBillsEntityDataFactory;
        }
    }
}
