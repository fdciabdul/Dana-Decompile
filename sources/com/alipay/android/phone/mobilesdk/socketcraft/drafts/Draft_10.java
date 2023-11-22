package com.alipay.android.phone.mobilesdk.socketcraft.drafts;

import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidDataException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidFrameException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.LimitExedeedException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.NotSendableException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.CloseFrameBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.FrameBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.FramedataImpl1;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshakeBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.Handshakedata;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshakeBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.util.Base64;
import com.alipay.android.phone.mobilesdk.socketcraft.util.Charsetfunctions;
import com.alipay.android.phone.mobilesdk.socketcraft.util.WsMessageConstants;
import com.google.common.net.HttpHeaders;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* loaded from: classes6.dex */
public class Draft_10 extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f6901a;
    private final Random b = new Random();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class IncompleteException extends Throwable {
        private static final long serialVersionUID = 7330519489840500997L;
        private int preferedsize;

        public IncompleteException(int i) {
            this.preferedsize = i;
        }

        public int getPreferedSize() {
            return this.preferedsize;
        }
    }

    public static int readVersion(Handshakedata handshakedata) {
        String fieldValue = handshakedata.getFieldValue(HttpHeaders.SEC_WEBSOCKET_VERSION);
        if (fieldValue.length() > 0) {
            try {
                return new Integer(fieldValue.trim()).intValue();
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return -1;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        if (!clientHandshake.hasFieldValue(HttpHeaders.SEC_WEBSOCKET_KEY) || !serverHandshake.hasFieldValue(HttpHeaders.SEC_WEBSOCKET_ACCEPT)) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (a(clientHandshake.getFieldValue(HttpHeaders.SEC_WEBSOCKET_KEY)).equals(serverHandshake.getFieldValue(HttpHeaders.SEC_WEBSOCKET_ACCEPT))) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) {
        int readVersion = readVersion(clientHandshake);
        if (readVersion == 7 || readVersion == 8) {
            return basicAccept(clientHandshake) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public ByteBuffer createBinaryFrame(Framedata framedata) {
        ByteBuffer payloadData = framedata.getPayloadData();
        int i = 0;
        boolean z = this.role == WebSocket.Role.CLIENT;
        int i2 = payloadData.remaining() <= 125 ? 1 : payloadData.remaining() <= 65535 ? 2 : 8;
        ByteBuffer allocate = ByteBuffer.allocate((i2 > 1 ? i2 + 1 : i2) + 1 + (z ? 4 : 0) + payloadData.remaining());
        allocate.put((byte) (((byte) (framedata.isFin() ? -128 : 0)) | a(framedata.getOpcode())));
        byte[] a2 = a(payloadData.remaining(), i2);
        if (i2 == 1) {
            allocate.put((byte) (a2[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
        } else if (i2 == 2) {
            allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
            allocate.put(a2);
        } else if (i2 == 8) {
            allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
            allocate.put(a2);
        } else {
            throw new RuntimeException("Size representation not supported/specified");
        }
        if (z) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.b.nextInt());
            allocate.put(allocate2.array());
            while (payloadData.hasRemaining()) {
                allocate.put((byte) (payloadData.get() ^ allocate2.get(i % 4)));
                i++;
            }
        } else {
            allocate.put(payloadData);
        }
        allocate.flip();
        return allocate;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public List<Framedata> createFrames(ByteBuffer byteBuffer, boolean z) {
        FramedataImpl1 framedataImpl1 = new FramedataImpl1();
        try {
            framedataImpl1.setPayload(byteBuffer);
            framedataImpl1.setFin(true);
            framedataImpl1.setOptcode(Framedata.Opcode.BINARY);
            framedataImpl1.setTransferemasked(z);
            return Collections.singletonList(framedataImpl1);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public List<Framedata> createFrames(String str, boolean z) {
        FramedataImpl1 framedataImpl1 = new FramedataImpl1();
        try {
            framedataImpl1.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(str)));
            framedataImpl1.setFin(true);
            framedataImpl1.setOptcode(Framedata.Opcode.TEXT);
            framedataImpl1.setTransferemasked(z);
            return Collections.singletonList(framedataImpl1);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    private byte a(Framedata.Opcode opcode) {
        if (opcode == Framedata.Opcode.CONTINUOUS) {
            return (byte) 0;
        }
        if (opcode == Framedata.Opcode.TEXT) {
            return (byte) 1;
        }
        if (opcode == Framedata.Opcode.BINARY) {
            return (byte) 2;
        }
        if (opcode == Framedata.Opcode.CLOSING) {
            return (byte) 8;
        }
        if (opcode == Framedata.Opcode.PING) {
            return (byte) 9;
        }
        if (opcode == Framedata.Opcode.PONG) {
            return (byte) 10;
        }
        StringBuilder sb = new StringBuilder("Don't know how to handle ");
        sb.append(opcode.toString());
        throw new RuntimeException(sb.toString());
    }

    private String a(String str) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder();
        sb.append(trim);
        sb.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        String obj = sb.toString();
        try {
            return Base64.encodeBytes(MessageDigest.getInstance("SHA1").digest(obj.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put(HttpHeaders.UPGRADE, "websocket");
        clientHandshakeBuilder.put(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE);
        clientHandshakeBuilder.put(HttpHeaders.SEC_WEBSOCKET_VERSION, "8");
        byte[] bArr = new byte[16];
        this.b.nextBytes(bArr);
        clientHandshakeBuilder.put(HttpHeaders.SEC_WEBSOCKET_KEY, Base64.encodeBytes(bArr));
        return clientHandshakeBuilder;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) {
        serverHandshakeBuilder.put(HttpHeaders.UPGRADE, "websocket");
        serverHandshakeBuilder.put(HttpHeaders.CONNECTION, clientHandshake.getFieldValue(HttpHeaders.CONNECTION));
        serverHandshakeBuilder.setHttpStatusMessage("Switching Protocols");
        String fieldValue = clientHandshake.getFieldValue(HttpHeaders.SEC_WEBSOCKET_KEY);
        if (fieldValue == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        serverHandshakeBuilder.put(HttpHeaders.SEC_WEBSOCKET_ACCEPT, a(fieldValue));
        return serverHandshakeBuilder;
    }

    private byte[] a(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (j >>> (((i * 8) - 8) - (i2 * 8)));
        }
        return bArr;
    }

    private Framedata.Opcode a(byte b) {
        if (b != 0) {
            if (b != 1) {
                if (b == 2) {
                    return Framedata.Opcode.BINARY;
                }
                switch (b) {
                    case 8:
                        return Framedata.Opcode.CLOSING;
                    case 9:
                        return Framedata.Opcode.PING;
                    case 10:
                        return Framedata.Opcode.PONG;
                    default:
                        StringBuilder sb = new StringBuilder("unknow optcode ");
                        sb.append((int) b);
                        throw new InvalidFrameException(sb.toString());
                }
            }
            return Framedata.Opcode.TEXT;
        }
        return Framedata.Opcode.CONTINUOUS;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public List<Framedata> translateFrame(ByteBuffer byteBuffer) {
        LinkedList linkedList = new LinkedList();
        if (this.f6901a != null) {
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.f6901a.remaining();
                if (remaining2 > remaining) {
                    this.f6901a.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.f6901a.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(translateSingleFrame((ByteBuffer) this.f6901a.duplicate().position(0)));
                this.f6901a = null;
            } catch (IncompleteException e) {
                this.f6901a.limit();
                ByteBuffer allocate = ByteBuffer.allocate(checkAlloc(e.getPreferedSize()));
                this.f6901a.rewind();
                allocate.put(this.f6901a);
                this.f6901a = allocate;
                return translateFrame(byteBuffer);
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(translateSingleFrame(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                ByteBuffer allocate2 = ByteBuffer.allocate(checkAlloc(e2.getPreferedSize()));
                this.f6901a = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public Framedata translateSingleFrame(ByteBuffer byteBuffer) {
        FrameBuilder framedataImpl1;
        int remaining = byteBuffer.remaining();
        int i = 2;
        if (remaining < 2) {
            throw new IncompleteException(2);
        }
        byte b = byteBuffer.get();
        boolean z = (b >> 8) != 0;
        byte b2 = (byte) ((b & Byte.MAX_VALUE) >> 4);
        if (b2 != 0) {
            StringBuilder sb = new StringBuilder("bad rsv ");
            sb.append((int) b2);
            throw new InvalidFrameException(sb.toString());
        }
        byte b3 = byteBuffer.get();
        boolean z2 = (b3 & Byte.MIN_VALUE) != 0;
        int i2 = (byte) (b3 & Byte.MAX_VALUE);
        Framedata.Opcode a2 = a((byte) (b & 15));
        if (z || !(a2 == Framedata.Opcode.PING || a2 == Framedata.Opcode.PONG || a2 == Framedata.Opcode.CLOSING)) {
            if (i2 < 0 || i2 > 125) {
                if (a2 == Framedata.Opcode.PING || a2 == Framedata.Opcode.PONG || a2 == Framedata.Opcode.CLOSING) {
                    throw new InvalidFrameException("more than 125 octets");
                }
                if (i2 == 126) {
                    if (remaining < 4) {
                        throw new IncompleteException(4);
                    }
                    i2 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                    i = 4;
                } else if (remaining < 10) {
                    throw new IncompleteException(10);
                } else {
                    byte[] bArr = new byte[8];
                    for (int i3 = 0; i3 < 8; i3++) {
                        bArr[i3] = byteBuffer.get();
                    }
                    long longValue = new BigInteger(bArr).longValue();
                    if (longValue > 2147483647L) {
                        throw new LimitExedeedException(WsMessageConstants.MSG_PAYLOAD_SIZE_BIG);
                    }
                    i2 = (int) longValue;
                    i = 10;
                }
            }
            int i4 = i + (z2 ? 4 : 0) + i2;
            if (remaining < i4) {
                throw new IncompleteException(i4);
            }
            ByteBuffer allocate = ByteBuffer.allocate(checkAlloc(i2));
            if (z2) {
                byte[] bArr2 = new byte[4];
                byteBuffer.get(bArr2);
                for (int i5 = 0; i5 < i2; i5++) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr2[i5 % 4]));
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            if (a2 == Framedata.Opcode.CLOSING) {
                framedataImpl1 = new CloseFrameBuilder();
            } else {
                framedataImpl1 = new FramedataImpl1();
                framedataImpl1.setFin(z);
                framedataImpl1.setOptcode(a2);
            }
            allocate.flip();
            framedataImpl1.setPayload(allocate);
            return framedataImpl1;
        }
        throw new InvalidFrameException("control frames may no be fragmented");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public void reset() {
        this.f6901a = null;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft copyInstance() {
        return new Draft_10();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.CloseHandshakeType getCloseHandshakeType() {
        return Draft.CloseHandshakeType.TWOWAY;
    }
}
