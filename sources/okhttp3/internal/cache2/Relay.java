package okhttp3.internal.cache2;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* loaded from: classes9.dex */
final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    long upstreamPos;
    Thread upstreamReader;
    final Buffer upstreamBuffer = new Buffer();
    final Buffer buffer = new Buffer();

    private Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.complete = source == null;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file, Source source, ByteString byteString, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0L, byteString, j);
        randomAccessFile.setLength(0L);
        relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer = new Buffer();
        fileOperator.read(0L, buffer, FILE_HEADER_SIZE);
        if (!new ByteString(buffer.PlaceComponentResult(r2.size())).equals(PREFIX_CLEAN)) {
            throw new IOException("unreadable cache file");
        }
        long newProxyInstance = buffer.newProxyInstance();
        long newProxyInstance2 = buffer.newProxyInstance();
        Buffer buffer2 = new Buffer();
        fileOperator.read(newProxyInstance + FILE_HEADER_SIZE, buffer2, newProxyInstance2);
        return new Relay(randomAccessFile, null, newProxyInstance, new ByteString(buffer2.NetworkUserEntityData$$ExternalSyntheticLambda1()), 0L);
    }

    private void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer = new Buffer();
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(buffer);
        buffer.initRecordTimeStamp(j);
        buffer.initRecordTimeStamp(j2);
        if (buffer.getAuthRequestContext != FILE_HEADER_SIZE) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.file.getChannel()).write(0L, buffer, FILE_HEADER_SIZE);
    }

    private void writeMetadata(long j) throws IOException {
        Buffer buffer = new Buffer();
        ByteString byteString = this.metadata;
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(buffer);
        new FileOperator(this.file.getChannel()).write(FILE_HEADER_SIZE + j, buffer, this.metadata.size());
    }

    final void commit(long j) throws IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    final boolean isClosed() {
        return this.file == null;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    /* loaded from: classes9.dex */
    class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();
        public static final byte[] getAuthRequestContext = {56, -119, 46, TarHeader.LF_CONTIG, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int PlaceComponentResult = 226;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0036). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r7, int r8, byte r9, java.lang.Object[] r10) {
            /*
                int r7 = r7 * 7
                int r7 = r7 + 99
                int r9 = r9 * 3
                int r9 = r9 + 13
                byte[] r0 = okhttp3.internal.cache2.Relay.RelaySource.getAuthRequestContext
                int r8 = r8 * 12
                int r8 = 15 - r8
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L1a
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r8
                goto L36
            L1a:
                r3 = 0
            L1b:
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                int r8 = r8 + 1
                if (r4 != r9) goto L2c
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2c:
                r3 = r0[r8]
                r6 = r8
                r8 = r7
                r7 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r6
            L36:
                int r7 = -r7
                int r8 = r8 + r7
                int r7 = r8 + 2
                r8 = r9
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.a(byte, int, byte, java.lang.Object[]):void");
        }

        RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
        
            r5 = r24.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
        
            r6 = (byte) (-okhttp3.internal.cache2.Relay.RelaySource.getAuthRequestContext[15]);
            r9 = new java.lang.Object[1];
            a(r6, (byte) (r6 - 1), (byte) (-okhttp3.internal.cache2.Relay.RelaySource.getAuthRequestContext[15]), r9);
            r9 = java.lang.Class.forName((java.lang.String) r9[0]);
            r10 = (byte) (okhttp3.internal.cache2.Relay.RelaySource.getAuthRequestContext[15] + 1);
            r13 = (byte) (-okhttp3.internal.cache2.Relay.RelaySource.getAuthRequestContext[15]);
            r15 = new java.lang.Object[1];
            a(r10, r13, (byte) (r13 - 1), r15);
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
        
            r5.upstreamReader = (java.lang.Thread) r9.getMethod((java.lang.String) r15[0], null).invoke(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0078, code lost:
        
            r2 = r0.getCause();
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x007c, code lost:
        
            if (r2 != null) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
        
            throw r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x007f, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0092, code lost:
        
            if (r12 != 2) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0094, code lost:
        
            r2 = java.lang.Math.min(r26, r7 - r24.sourcePos);
            r24.fileOperator.read(r24.sourcePos + okhttp3.internal.cache2.Relay.FILE_HEADER_SIZE, r25, r2);
            r24.sourcePos += r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00ac, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ad, code lost:
        
            r9 = r24.this$0.upstream.read(r24.this$0.upstreamBuffer, r24.this$0.bufferMaxSize);
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00c1, code lost:
        
            if (r9 != (-1)) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00c3, code lost:
        
            r24.this$0.commit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00c8, code lost:
        
            r2 = r24.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00ca, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00cb, code lost:
        
            r24.this$0.upstreamReader = null;
            r24.this$0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00d4, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00d5, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00db, code lost:
        
            r2 = java.lang.Math.min(r9, r26);
            r24.this$0.upstreamBuffer.BuiltInFictitiousFunctionClassFactory(r25, 0, r2);
            r24.sourcePos += r2;
            r24.fileOperator.write(r7 + okhttp3.internal.cache2.Relay.FILE_HEADER_SIZE, r24.this$0.upstreamBuffer.clone(), r9);
            r4 = r24.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0106, code lost:
        
            monitor-enter(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0107, code lost:
        
            r24.this$0.buffer.write(r24.this$0.upstreamBuffer, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x011e, code lost:
        
            if (r24.this$0.buffer.getAuthRequestContext <= r24.this$0.bufferMaxSize) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0120, code lost:
        
            r24.this$0.buffer.NetworkUserEntityData$$ExternalSyntheticLambda0(r24.this$0.buffer.getAuthRequestContext - r24.this$0.bufferMaxSize);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0132, code lost:
        
            r24.this$0.upstreamPos += r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0139, code lost:
        
            monitor-exit(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x013a, code lost:
        
            r4 = r24.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x013c, code lost:
        
            monitor-enter(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x013d, code lost:
        
            r24.this$0.upstreamReader = null;
            r24.this$0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0146, code lost:
        
            monitor-exit(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0147, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x014e, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0151, code lost:
        
            monitor-enter(r24.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0152, code lost:
        
            r24.this$0.upstreamReader = null;
            r24.this$0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x015c, code lost:
        
            throw r0;
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(okio.Buffer r25, long r26) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 391
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay relay = Relay.this;
                relay.sourceCount--;
                if (Relay.this.sourceCount == 0) {
                    RandomAccessFile randomAccessFile2 = Relay.this.file;
                    Relay.this.file = null;
                    randomAccessFile = randomAccessFile2;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }
    }
}
