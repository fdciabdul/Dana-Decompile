package okhttp3.internal.ws;

import okio.Buffer;
import okio.ByteString;

/* loaded from: classes9.dex */
public final class WebSocketProtocol {
    static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    static final int B0_FLAG_FIN = 128;
    static final int B0_FLAG_RSV1 = 64;
    static final int B0_FLAG_RSV2 = 32;
    static final int B0_FLAG_RSV3 = 16;
    static final int B0_MASK_OPCODE = 15;
    static final int B1_FLAG_MASK = 128;
    static final int B1_MASK_LENGTH = 127;
    static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    static final long CLOSE_MESSAGE_MAX = 123;
    static final int CLOSE_NO_STATUS_CODE = 1005;
    static final int OPCODE_BINARY = 2;
    static final int OPCODE_CONTINUATION = 0;
    static final int OPCODE_CONTROL_CLOSE = 8;
    static final int OPCODE_CONTROL_PING = 9;
    static final int OPCODE_CONTROL_PONG = 10;
    static final int OPCODE_FLAG_CONTROL = 8;
    static final int OPCODE_TEXT = 1;
    static final long PAYLOAD_BYTE_MAX = 125;
    static final int PAYLOAD_LONG = 127;
    static final int PAYLOAD_SHORT = 126;
    static final long PAYLOAD_SHORT_MAX = 65535;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void toggleMask(Buffer.UnsafeCursor unsafeCursor, byte[] bArr) {
        long j;
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = unsafeCursor.KClassImpl$Data$declaredNonStaticMembers$2;
            int i2 = unsafeCursor.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i3 = unsafeCursor.MyBillsEntityDataFactory;
            while (i2 < i3) {
                int i4 = i % length;
                bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                i2++;
                i = i4 + 1;
            }
            if (unsafeCursor.getAuthRequestContext == unsafeCursor.PlaceComponentResult.getAuthRequestContext) {
                throw new IllegalStateException();
            }
            j = unsafeCursor.getAuthRequestContext;
        } while ((j == -1 ? unsafeCursor.MyBillsEntityDataFactory(0L) : unsafeCursor.MyBillsEntityDataFactory(j + (unsafeCursor.MyBillsEntityDataFactory - unsafeCursor.NetworkUserEntityData$$ExternalSyntheticLambda0))) != -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String closeCodeExceptionMessage(int i) {
        if (i < 1000 || i >= 5000) {
            StringBuilder sb = new StringBuilder();
            sb.append("Code must be in range [1000,5000): ");
            sb.append(i);
            return sb.toString();
        } else if ((i < 1004 || i > 1006) && (i < 1012 || i > 2999)) {
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Code ");
            sb2.append(i);
            sb2.append(" is reserved and may not be used.");
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void validateCloseCode(int i) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i);
        if (closeCodeExceptionMessage != null) {
            throw new IllegalArgumentException(closeCodeExceptionMessage);
        }
    }

    public static String acceptHeader(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(ACCEPT_MAGIC);
        return ByteString.encodeUtf8(sb.toString()).sha1().base64();
    }

    private WebSocketProtocol() {
        throw new AssertionError("No instances.");
    }
}
