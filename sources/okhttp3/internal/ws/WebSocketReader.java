package okhttp3.internal.ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: classes9.dex */
final class WebSocketReader {
    boolean closed;
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    int opcode;
    final BufferedSource source;
    private final Buffer controlFrameBuffer = new Buffer();
    private final Buffer messageFrameBuffer = new Buffer();

    /* loaded from: classes9.dex */
    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        if (frameCallback == null) {
            throw new NullPointerException("frameCallback == null");
        }
        this.isClient = z;
        this.source = bufferedSource;
        this.frameCallback = frameCallback;
        this.maskKey = z ? null : new byte[4];
        this.maskCursor = z ? null : new Buffer.UnsafeCursor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }

    /* JADX WARN: Finally extract failed */
    private void readHeader() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        long timeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int initRecordTimeStamp = this.source.initRecordTimeStamp() & 255;
            this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            this.opcode = initRecordTimeStamp & 15;
            boolean z = (initRecordTimeStamp & 128) != 0;
            this.isFinalFrame = z;
            boolean z2 = (initRecordTimeStamp & 8) != 0;
            this.isControlFrame = z2;
            if (z2 && !z) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z3 = (initRecordTimeStamp & 64) != 0;
            boolean z4 = (initRecordTimeStamp & 32) != 0;
            boolean z5 = (initRecordTimeStamp & 16) != 0;
            if (z3 || z4 || z5) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            int initRecordTimeStamp2 = this.source.initRecordTimeStamp() & 255;
            boolean z6 = (initRecordTimeStamp2 & 128) != 0;
            boolean z7 = this.isClient;
            if (z6 == z7) {
                throw new ProtocolException(z7 ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = initRecordTimeStamp2 & 127;
            this.frameLength = j;
            if (j == 126) {
                this.frameLength = this.source.NetworkUserEntityData$$ExternalSyntheticLambda8() & 65535;
            } else if (j == 127) {
                long newProxyInstance = this.source.newProxyInstance();
                this.frameLength = newProxyInstance;
                if (newProxyInstance < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Frame length 0x");
                    sb.append(Long.toHexString(this.frameLength));
                    sb.append(" > 0x7FFFFFFFFFFFFFFF");
                    throw new ProtocolException(sb.toString());
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z6) {
                this.source.BuiltInFictitiousFunctionClassFactory(this.maskKey);
            }
        } catch (Throwable th) {
            this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private void readControlFrame() throws IOException {
        String str;
        long j = this.frameLength;
        if (j > 0) {
            this.source.KClassImpl$Data$declaredNonStaticMembers$2(this.controlFrameBuffer, j);
            if (!this.isClient) {
                Buffer buffer = this.controlFrameBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                if (unsafeCursor.PlaceComponentResult != null) {
                    throw new IllegalStateException("already attached to a buffer");
                }
                unsafeCursor.PlaceComponentResult = buffer;
                unsafeCursor.BuiltInFictitiousFunctionClassFactory = true;
                this.maskCursor.MyBillsEntityDataFactory(0L);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                short s = 1005;
                long j2 = this.controlFrameBuffer.getAuthRequestContext;
                if (j2 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j2 != 0) {
                    s = this.controlFrameBuffer.NetworkUserEntityData$$ExternalSyntheticLambda8();
                    str = this.controlFrameBuffer.FragmentBottomSheetPaymentSettingBinding();
                    String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s);
                    if (closeCodeExceptionMessage != null) {
                        throw new ProtocolException(closeCodeExceptionMessage);
                    }
                } else {
                    str = "";
                }
                this.frameCallback.onReadClose(s, str);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onReadPing(new ByteString(this.controlFrameBuffer.NetworkUserEntityData$$ExternalSyntheticLambda1()));
                return;
            case 10:
                this.frameCallback.onReadPong(new ByteString(this.controlFrameBuffer.NetworkUserEntityData$$ExternalSyntheticLambda1()));
                return;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown control opcode: ");
                sb.append(Integer.toHexString(this.opcode));
                throw new ProtocolException(sb.toString());
        }
    }

    private void readMessageFrame() throws IOException {
        int i = this.opcode;
        if (i != 1 && i != 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown opcode: ");
            sb.append(Integer.toHexString(i));
            throw new ProtocolException(sb.toString());
        }
        readMessage();
        if (i == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.FragmentBottomSheetPaymentSettingBinding());
        } else {
            this.frameCallback.onReadMessage(new ByteString(this.messageFrameBuffer.NetworkUserEntityData$$ExternalSyntheticLambda1()));
        }
    }

    private void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            }
            readControlFrame();
        }
    }

    private void readMessage() throws IOException {
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.KClassImpl$Data$declaredNonStaticMembers$2(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    Buffer buffer = this.messageFrameBuffer;
                    Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                    if (unsafeCursor.PlaceComponentResult != null) {
                        throw new IllegalStateException("already attached to a buffer");
                    }
                    unsafeCursor.PlaceComponentResult = buffer;
                    unsafeCursor.BuiltInFictitiousFunctionClassFactory = true;
                    this.maskCursor.MyBillsEntityDataFactory(this.messageFrameBuffer.getAuthRequestContext - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected continuation opcode. Got: ");
                sb.append(Integer.toHexString(this.opcode));
                throw new ProtocolException(sb.toString());
            }
        }
        throw new IOException("closed");
    }
}
