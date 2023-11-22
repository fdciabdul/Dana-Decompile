package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UShort;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class Http2Reader implements Closeable {
    static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation;
    final Hpack.Reader hpackReader;
    private final BufferedSource source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.source = bufferedSource;
        this.client = z;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(4096, continuationSource);
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        ByteString MyBillsEntityDataFactory = this.source.MyBillsEntityDataFactory(Http2.CONNECTION_PREFACE.size());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Util.format("<< CONNECTION %s", MyBillsEntityDataFactory.hex()));
        }
        if (!Http2.CONNECTION_PREFACE.equals(MyBillsEntityDataFactory)) {
            throw Http2.ioException("Expected a connection header but was %s", MyBillsEntityDataFactory.utf8());
        }
    }

    public final boolean nextFrame(boolean z, Handler handler) throws IOException {
        try {
            this.source.lookAheadTest(9L);
            int readMedium = readMedium(this.source);
            if (readMedium < 0 || readMedium > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(readMedium));
            }
            byte initRecordTimeStamp = (byte) (this.source.initRecordTimeStamp() & 255);
            if (!z || initRecordTimeStamp == 4) {
                byte initRecordTimeStamp2 = (byte) (this.source.initRecordTimeStamp() & 255);
                int GetContactSyncConfig = this.source.GetContactSyncConfig() & Integer.MAX_VALUE;
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Http2.frameLog(true, GetContactSyncConfig, readMedium, initRecordTimeStamp, initRecordTimeStamp2));
                }
                switch (initRecordTimeStamp) {
                    case 0:
                        readData(handler, readMedium, initRecordTimeStamp2, GetContactSyncConfig);
                        break;
                    case 1:
                        readHeaders(handler, readMedium, initRecordTimeStamp2, GetContactSyncConfig);
                        break;
                    case 2:
                        readPriority(handler, readMedium, initRecordTimeStamp2, GetContactSyncConfig);
                        break;
                    case 3:
                        readRstStream(handler, readMedium, initRecordTimeStamp2, GetContactSyncConfig);
                        break;
                    case 4:
                        readSettings(handler, readMedium, initRecordTimeStamp2, GetContactSyncConfig);
                        break;
                    case 5:
                        readPushPromise(handler, readMedium, initRecordTimeStamp2, GetContactSyncConfig);
                        break;
                    case 6:
                        readPing(handler, readMedium, initRecordTimeStamp2, GetContactSyncConfig);
                        break;
                    case 7:
                        readGoAway(handler, readMedium, initRecordTimeStamp2, GetContactSyncConfig);
                        break;
                    case 8:
                        readWindowUpdate(handler, readMedium, initRecordTimeStamp2, GetContactSyncConfig);
                        break;
                    default:
                        this.source.NetworkUserEntityData$$ExternalSyntheticLambda0(readMedium);
                        break;
                }
                return true;
            }
            throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(initRecordTimeStamp));
        } catch (IOException unused) {
            return false;
        }
    }

    private void readHeaders(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        short initRecordTimeStamp = (b & 8) != 0 ? (short) (this.source.initRecordTimeStamp() & 255) : (short) 0;
        if ((b & 32) != 0) {
            readPriority(handler, i2);
            i -= 5;
        }
        handler.headers(z, i2, -1, readHeaderBlock(lengthWithoutPadding(i, b, initRecordTimeStamp), initRecordTimeStamp, b, i2));
    }

    private List<Header> readHeaderBlock(int i, short s, byte b, int i2) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i;
        continuationSource.length = i;
        this.continuation.padding = s;
        this.continuation.flags = b;
        this.continuation.streamId = i2;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readData(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short initRecordTimeStamp = (b & 8) != 0 ? (short) (this.source.initRecordTimeStamp() & 255) : (short) 0;
        handler.data(z, i2, this.source, lengthWithoutPadding(i, b, initRecordTimeStamp));
        this.source.NetworkUserEntityData$$ExternalSyntheticLambda0(initRecordTimeStamp);
    }

    private void readPriority(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        readPriority(handler, i2);
    }

    private void readPriority(Handler handler, int i) throws IOException {
        int GetContactSyncConfig = this.source.GetContactSyncConfig();
        handler.priority(i, GetContactSyncConfig & Integer.MAX_VALUE, (this.source.initRecordTimeStamp() & 255) + 1, (Integer.MIN_VALUE & GetContactSyncConfig) != 0);
    }

    private void readRstStream(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int GetContactSyncConfig = this.source.GetContactSyncConfig();
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(GetContactSyncConfig);
        if (fromHttp2 == null) {
            throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(GetContactSyncConfig));
        }
        handler.rstStream(i2, fromHttp2);
    }

    private void readSettings(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            handler.ackSettings();
        } else if (i % 6 != 0) {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        } else {
            Settings settings = new Settings();
            for (int i3 = 0; i3 < i; i3 += 6) {
                int NetworkUserEntityData$$ExternalSyntheticLambda8 = this.source.NetworkUserEntityData$$ExternalSyntheticLambda8() & UShort.MAX_VALUE;
                int GetContactSyncConfig = this.source.GetContactSyncConfig();
                if (NetworkUserEntityData$$ExternalSyntheticLambda8 != 2) {
                    if (NetworkUserEntityData$$ExternalSyntheticLambda8 == 3) {
                        NetworkUserEntityData$$ExternalSyntheticLambda8 = 4;
                    } else if (NetworkUserEntityData$$ExternalSyntheticLambda8 == 4) {
                        NetworkUserEntityData$$ExternalSyntheticLambda8 = 7;
                        if (GetContactSyncConfig < 0) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    } else if (NetworkUserEntityData$$ExternalSyntheticLambda8 == 5 && (GetContactSyncConfig < 16384 || GetContactSyncConfig > 16777215)) {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(GetContactSyncConfig));
                    }
                } else if (GetContactSyncConfig != 0 && GetContactSyncConfig != 1) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                settings.set(NetworkUserEntityData$$ExternalSyntheticLambda8, GetContactSyncConfig);
            }
            handler.settings(false, settings);
        }
    }

    private void readPushPromise(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short initRecordTimeStamp = (b & 8) != 0 ? (short) (this.source.initRecordTimeStamp() & 255) : (short) 0;
        handler.pushPromise(i2, Integer.MAX_VALUE & this.source.GetContactSyncConfig(), readHeaderBlock(lengthWithoutPadding(i - 4, b, initRecordTimeStamp), initRecordTimeStamp, b, i2));
    }

    private void readPing(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
        handler.ping((b & 1) != 0, this.source.GetContactSyncConfig(), this.source.GetContactSyncConfig());
    }

    private void readGoAway(Handler handler, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int GetContactSyncConfig = this.source.GetContactSyncConfig();
        int GetContactSyncConfig2 = this.source.GetContactSyncConfig();
        int i3 = i - 8;
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(GetContactSyncConfig2);
        if (fromHttp2 == null) {
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(GetContactSyncConfig2));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i3 > 0) {
            byteString = this.source.MyBillsEntityDataFactory(i3);
        }
        handler.goAway(GetContactSyncConfig, fromHttp2, byteString);
    }

    private void readWindowUpdate(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long GetContactSyncConfig = this.source.GetContactSyncConfig() & 2147483647L;
        if (GetContactSyncConfig == 0) {
            throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(GetContactSyncConfig));
        }
        handler.windowUpdate(i2, GetContactSyncConfig);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.source.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class ContinuationSource implements Source {
        byte flags;
        int left;
        int length;
        short padding;
        private final BufferedSource source;
        int streamId;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
        }

        ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        @Override // okio.Source
        public final long read(Buffer buffer, long j) throws IOException {
            while (true) {
                int i = this.left;
                if (i == 0) {
                    this.source.NetworkUserEntityData$$ExternalSyntheticLambda0(this.padding);
                    this.padding = (short) 0;
                    if ((this.flags & 4) != 0) {
                        return -1L;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(buffer, Math.min(j, i));
                    if (read == -1) {
                        return -1L;
                    }
                    this.left = (int) (this.left - read);
                    return read;
                }
            }
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.source.timeout();
        }

        private void readContinuationHeader() throws IOException {
            int i = this.streamId;
            int readMedium = Http2Reader.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            byte initRecordTimeStamp = (byte) (this.source.initRecordTimeStamp() & 255);
            this.flags = (byte) (this.source.initRecordTimeStamp() & 255);
            if (Http2Reader.logger.isLoggable(Level.FINE)) {
                Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, initRecordTimeStamp, this.flags));
            }
            int GetContactSyncConfig = this.source.GetContactSyncConfig() & Integer.MAX_VALUE;
            this.streamId = GetContactSyncConfig;
            if (initRecordTimeStamp != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(initRecordTimeStamp));
            }
            if (GetContactSyncConfig != i) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int readMedium(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.initRecordTimeStamp() & 255) | ((bufferedSource.initRecordTimeStamp() & 255) << 16) | ((bufferedSource.initRecordTimeStamp() & 255) << 8);
    }

    static int lengthWithoutPadding(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
