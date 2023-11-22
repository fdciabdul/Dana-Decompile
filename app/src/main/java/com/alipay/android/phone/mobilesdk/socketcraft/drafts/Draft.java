package com.alipay.android.phone.mobilesdk.socketcraft.drafts;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.IncompleteHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidDataException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.FramedataImpl1;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshakeBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeImpl1Client;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeImpl1Server;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.Handshakedata;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshakeBuilder;
import com.alipay.android.phone.mobilesdk.socketcraft.util.Charsetfunctions;
import com.google.common.net.HttpHeaders;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes6.dex */
public abstract class Draft {
    public static final byte[] FLASH_POLICY_REQUEST = Charsetfunctions.utf8Bytes("<policy-file-request/>\u0000");
    public static int INITIAL_FAMESIZE = 64;
    public static int MAX_FAME_SIZE = 1000;
    protected WebSocket.Role role = null;
    protected Framedata.Opcode continuousFrameType = null;

    /* loaded from: classes6.dex */
    public enum CloseHandshakeType {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* loaded from: classes6.dex */
    public enum HandshakeState {
        MATCHED,
        NOT_MATCHED
    }

    public abstract HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake);

    public abstract HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake);

    public abstract Draft copyInstance();

    public abstract ByteBuffer createBinaryFrame(Framedata framedata);

    public abstract List<Framedata> createFrames(String str, boolean z);

    public abstract List<Framedata> createFrames(ByteBuffer byteBuffer, boolean z);

    public abstract CloseHandshakeType getCloseHandshakeType();

    public abstract ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder);

    public abstract HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder);

    public abstract void reset();

    public abstract List<Framedata> translateFrame(ByteBuffer byteBuffer);

    public static ByteBuffer readLine(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = TarHeader.LF_NORMAL;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            allocate.put(b2);
            if (b == 13 && b2 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String readStringLine(ByteBuffer byteBuffer) {
        ByteBuffer readLine = readLine(byteBuffer);
        if (readLine == null) {
            return null;
        }
        return Charsetfunctions.stringAscii(readLine.array(), 0, readLine.limit());
    }

    public static HandshakeBuilder translateHandshakeHttp(ByteBuffer byteBuffer, WebSocket.Role role) {
        ServerHandshakeBuilder serverHandshakeBuilder;
        String readStringLine;
        String readStringLine2 = readStringLine(byteBuffer);
        if (readStringLine2 == null) {
            throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
        }
        String[] split = readStringLine2.split(" ", 3);
        if (split.length != 3) {
            throw new InvalidHandshakeException();
        }
        if (role == WebSocket.Role.CLIENT) {
            ServerHandshakeBuilder handshakeImpl1Server = new HandshakeImpl1Server();
            ServerHandshakeBuilder serverHandshakeBuilder2 = handshakeImpl1Server;
            serverHandshakeBuilder2.setHttpStatus(Short.parseShort(split[1]));
            serverHandshakeBuilder2.setHttpStatusMessage(split[2]);
            serverHandshakeBuilder = handshakeImpl1Server;
        } else {
            HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
            handshakeImpl1Client.setResourceDescriptor(split[1]);
            serverHandshakeBuilder = handshakeImpl1Client;
        }
        while (true) {
            readStringLine = readStringLine(byteBuffer);
            if (readStringLine == null || readStringLine.length() <= 0) {
                break;
            }
            String[] split2 = readStringLine.split(":", 2);
            if (split2.length != 2) {
                throw new InvalidHandshakeException("not an http header");
            }
            serverHandshakeBuilder.put(split2[0], split2[1].replaceFirst("^ +", ""));
        }
        if (readStringLine != null) {
            return serverHandshakeBuilder;
        }
        throw new IncompleteHandshakeException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean basicAccept(Handshakedata handshakedata) {
        return handshakedata.getFieldValue(HttpHeaders.UPGRADE).equalsIgnoreCase("websocket") && handshakedata.getFieldValue(HttpHeaders.CONNECTION).toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public List<Framedata> continuousFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.continuousFrameType != null) {
            this.continuousFrameType = Framedata.Opcode.CONTINUOUS;
        } else {
            this.continuousFrameType = opcode;
        }
        FramedataImpl1 framedataImpl1 = new FramedataImpl1(this.continuousFrameType);
        try {
            framedataImpl1.setPayload(byteBuffer);
            framedataImpl1.setFin(z);
            if (z) {
                this.continuousFrameType = null;
            } else {
                this.continuousFrameType = opcode;
            }
            return Collections.singletonList(framedataImpl1);
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, WebSocket.Role role) {
        return createHandshake(handshakedata, role, true);
    }

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, WebSocket.Role role, boolean z) {
        StringBuilder sb = new StringBuilder(100);
        if (handshakedata instanceof ClientHandshake) {
            sb.append("GET ");
            sb.append(((ClientHandshake) handshakedata).getResourceDescriptor());
            sb.append(" HTTP/1.1");
        } else if (handshakedata instanceof ServerHandshake) {
            StringBuilder sb2 = new StringBuilder("HTTP/1.1 101 ");
            sb2.append(((ServerHandshake) handshakedata).getHttpStatusMessage());
            sb.append(sb2.toString());
        } else {
            throw new RuntimeException("unknow role");
        }
        sb.append("\r\n");
        Iterator<String> iterateHttpFields = handshakedata.iterateHttpFields();
        while (iterateHttpFields.hasNext()) {
            String next = iterateHttpFields.next();
            String fieldValue = handshakedata.getFieldValue(next);
            sb.append(next);
            sb.append(": ");
            sb.append(fieldValue);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] asciiBytes = Charsetfunctions.asciiBytes(sb.toString());
        byte[] content = z ? handshakedata.getContent() : null;
        ByteBuffer allocate = ByteBuffer.allocate((content == null ? 0 : content.length) + asciiBytes.length);
        allocate.put(asciiBytes);
        if (content != null) {
            allocate.put(content);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public Handshakedata translateHandshake(ByteBuffer byteBuffer) {
        return translateHandshakeHttp(byteBuffer, this.role);
    }

    public int checkAlloc(int i) {
        if (i >= 0) {
            return i;
        }
        throw new InvalidDataException(1002, "Negative count");
    }

    public void setParseMode(WebSocket.Role role) {
        this.role = role;
    }

    public WebSocket.Role getRole() {
        return this.role;
    }
}
