package com.mixpanel.android.java_websocket.drafts;

import com.alipay.android.phone.mobilesdk.socketcraft.util.WsMessageConstants;
import com.google.common.net.HttpHeaders;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.LimitExedeedException;
import com.mixpanel.android.java_websocket.framing.CloseFrameBuilder;
import com.mixpanel.android.java_websocket.framing.FrameBuilder;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import com.mixpanel.android.java_websocket.util.Base64;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* loaded from: classes3.dex */
public class Draft_10 extends Draft {
    private Framedata PlaceComponentResult = null;
    private final Random getErrorConfigVersion = new Random();
    private ByteBuffer moveToNextValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Handshakedata handshakedata) {
        String MyBillsEntityDataFactory = handshakedata.MyBillsEntityDataFactory(HttpHeaders.SEC_WEBSOCKET_VERSION);
        if (MyBillsEntityDataFactory.length() > 0) {
            try {
                return new Integer(MyBillsEntityDataFactory.trim()).intValue();
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return -1;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public final Draft.HandshakeState BuiltInFictitiousFunctionClassFactory(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException {
        if (!clientHandshake.KClassImpl$Data$declaredNonStaticMembers$2(HttpHeaders.SEC_WEBSOCKET_KEY) || !serverHandshake.KClassImpl$Data$declaredNonStaticMembers$2(HttpHeaders.SEC_WEBSOCKET_ACCEPT)) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (MyBillsEntityDataFactory(clientHandshake.MyBillsEntityDataFactory(HttpHeaders.SEC_WEBSOCKET_KEY)).equals(serverHandshake.MyBillsEntityDataFactory(HttpHeaders.SEC_WEBSOCKET_ACCEPT))) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState getAuthRequestContext(ClientHandshake clientHandshake) throws InvalidHandshakeException {
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(clientHandshake);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == 7 || KClassImpl$Data$declaredNonStaticMembers$2 == 8) {
            return MyBillsEntityDataFactory(clientHandshake) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public final ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2(Framedata framedata) {
        ByteBuffer BuiltInFictitiousFunctionClassFactory = framedata.BuiltInFictitiousFunctionClassFactory();
        int i = 0;
        boolean z = this.BuiltInFictitiousFunctionClassFactory == WebSocket.Role.CLIENT;
        int i2 = BuiltInFictitiousFunctionClassFactory.remaining() <= 125 ? 1 : BuiltInFictitiousFunctionClassFactory.remaining() <= 65535 ? 2 : 8;
        ByteBuffer allocate = ByteBuffer.allocate((i2 > 1 ? i2 + 1 : i2) + 1 + (z ? 4 : 0) + BuiltInFictitiousFunctionClassFactory.remaining());
        allocate.put((byte) (((byte) (framedata.moveToNextValue() ? -128 : 0)) | getAuthRequestContext(framedata.PlaceComponentResult())));
        byte[] MyBillsEntityDataFactory = MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory.remaining(), i2);
        if (i2 == 1) {
            allocate.put((byte) (MyBillsEntityDataFactory[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
        } else if (i2 == 2) {
            allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
            allocate.put(MyBillsEntityDataFactory);
        } else if (i2 == 8) {
            allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
            allocate.put(MyBillsEntityDataFactory);
        } else {
            throw new RuntimeException("Size representation not supported/specified");
        }
        if (z) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.getErrorConfigVersion.nextInt());
            allocate.put(allocate2.array());
            while (BuiltInFictitiousFunctionClassFactory.hasRemaining()) {
                allocate.put((byte) (BuiltInFictitiousFunctionClassFactory.get() ^ allocate2.get(i % 4)));
                i++;
            }
        } else {
            allocate.put(BuiltInFictitiousFunctionClassFactory);
        }
        allocate.flip();
        return allocate;
    }

    private static byte getAuthRequestContext(Framedata.Opcode opcode) {
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
        StringBuilder sb = new StringBuilder();
        sb.append("Don't know how to handle ");
        sb.append(opcode.toString());
        throw new RuntimeException(sb.toString());
    }

    private static String MyBillsEntityDataFactory(String str) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder();
        sb.append(trim);
        sb.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        String obj = sb.toString();
        try {
            return Base64.KClassImpl$Data$declaredNonStaticMembers$2(MessageDigest.getInstance("SHA1").digest(obj.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public ClientHandshakeBuilder getAuthRequestContext(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.PlaceComponentResult(HttpHeaders.UPGRADE, "websocket");
        clientHandshakeBuilder.PlaceComponentResult(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE);
        clientHandshakeBuilder.PlaceComponentResult(HttpHeaders.SEC_WEBSOCKET_VERSION, "8");
        byte[] bArr = new byte[16];
        this.getErrorConfigVersion.nextBytes(bArr);
        clientHandshakeBuilder.PlaceComponentResult(HttpHeaders.SEC_WEBSOCKET_KEY, Base64.KClassImpl$Data$declaredNonStaticMembers$2(bArr));
        return clientHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public final HandshakeBuilder getAuthRequestContext(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.PlaceComponentResult(HttpHeaders.UPGRADE, "websocket");
        serverHandshakeBuilder.PlaceComponentResult(HttpHeaders.CONNECTION, clientHandshake.MyBillsEntityDataFactory(HttpHeaders.CONNECTION));
        serverHandshakeBuilder.getAuthRequestContext("Switching Protocols");
        String MyBillsEntityDataFactory = clientHandshake.MyBillsEntityDataFactory(HttpHeaders.SEC_WEBSOCKET_KEY);
        if (MyBillsEntityDataFactory == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        serverHandshakeBuilder.PlaceComponentResult(HttpHeaders.SEC_WEBSOCKET_ACCEPT, MyBillsEntityDataFactory(MyBillsEntityDataFactory));
        return serverHandshakeBuilder;
    }

    private static byte[] MyBillsEntityDataFactory(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (j >>> (((i * 8) - 8) - (i2 * 8)));
        }
        return bArr;
    }

    private static Framedata.Opcode getAuthRequestContext(byte b) throws InvalidFrameException {
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
                        StringBuilder sb = new StringBuilder();
                        sb.append("unknow optcode ");
                        sb.append((int) b);
                        throw new InvalidFrameException(sb.toString());
                }
            }
            return Framedata.Opcode.TEXT;
        }
        return Framedata.Opcode.CONTINUOUS;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public final List<Framedata> PlaceComponentResult(ByteBuffer byteBuffer) throws LimitExedeedException, InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.moveToNextValue == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.moveToNextValue.remaining();
                if (remaining2 > remaining) {
                    this.moveToNextValue.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.moveToNextValue.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(getAuthRequestContext((ByteBuffer) this.moveToNextValue.duplicate().position(0)));
                this.moveToNextValue = null;
            } catch (IncompleteException e) {
                this.moveToNextValue.limit();
                int preferedSize = e.getPreferedSize();
                if (preferedSize >= 0) {
                    ByteBuffer allocate = ByteBuffer.allocate(preferedSize);
                    this.moveToNextValue.rewind();
                    allocate.put(this.moveToNextValue);
                    this.moveToNextValue = allocate;
                } else {
                    throw new InvalidDataException(1002, "Negative count");
                }
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(getAuthRequestContext(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                int preferedSize2 = e2.getPreferedSize();
                if (preferedSize2 >= 0) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(preferedSize2);
                    this.moveToNextValue = allocate2;
                    allocate2.put(byteBuffer);
                } else {
                    throw new InvalidDataException(1002, "Negative count");
                }
            }
        }
        return linkedList;
    }

    private Framedata getAuthRequestContext(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
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
            StringBuilder sb = new StringBuilder();
            sb.append("bad rsv ");
            sb.append((int) b2);
            throw new InvalidFrameException(sb.toString());
        }
        byte b3 = byteBuffer.get();
        boolean z2 = (b3 & Byte.MIN_VALUE) != 0;
        int i2 = (byte) (b3 & Byte.MAX_VALUE);
        Framedata.Opcode authRequestContext = getAuthRequestContext((byte) (b & 15));
        if (z || !(authRequestContext == Framedata.Opcode.PING || authRequestContext == Framedata.Opcode.PONG || authRequestContext == Framedata.Opcode.CLOSING)) {
            if (i2 < 0 || i2 > 125) {
                if (authRequestContext == Framedata.Opcode.PING || authRequestContext == Framedata.Opcode.PONG || authRequestContext == Framedata.Opcode.CLOSING) {
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
            if (remaining >= i4) {
                if (i2 >= 0) {
                    ByteBuffer allocate = ByteBuffer.allocate(i2);
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
                    if (authRequestContext == Framedata.Opcode.CLOSING) {
                        framedataImpl1 = new CloseFrameBuilder();
                    } else {
                        framedataImpl1 = new FramedataImpl1();
                        framedataImpl1.MyBillsEntityDataFactory(z);
                        framedataImpl1.getAuthRequestContext(authRequestContext);
                    }
                    allocate.flip();
                    framedataImpl1.BuiltInFictitiousFunctionClassFactory(allocate);
                    return framedataImpl1;
                }
                throw new InvalidDataException(1002, "Negative count");
            }
            throw new IncompleteException(i4);
        }
        throw new InvalidFrameException("control frames may no be fragmented");
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.moveToNextValue = null;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft getAuthRequestContext() {
        return new Draft_10();
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public final Draft.CloseHandshakeType KClassImpl$Data$declaredNonStaticMembers$2() {
        return Draft.CloseHandshakeType.TWOWAY;
    }
}
