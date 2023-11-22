package com.mixpanel.android.java_websocket.drafts;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.net.HttpHeaders;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Client;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Server;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class Draft {
    public static int KClassImpl$Data$declaredNonStaticMembers$2 = 64;
    public static final byte[] getAuthRequestContext = Charsetfunctions.PlaceComponentResult("<policy-file-request/>\u0000");
    protected WebSocket.Role BuiltInFictitiousFunctionClassFactory = null;
    protected Framedata.Opcode MyBillsEntityDataFactory = null;

    /* loaded from: classes3.dex */
    public enum CloseHandshakeType {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* loaded from: classes3.dex */
    public enum HandshakeState {
        MATCHED,
        NOT_MATCHED
    }

    public abstract HandshakeState BuiltInFictitiousFunctionClassFactory(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException;

    public abstract void BuiltInFictitiousFunctionClassFactory();

    public abstract CloseHandshakeType KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2(Framedata framedata);

    public abstract List<Framedata> PlaceComponentResult(ByteBuffer byteBuffer) throws InvalidDataException;

    public abstract HandshakeState getAuthRequestContext(ClientHandshake clientHandshake) throws InvalidHandshakeException;

    public abstract Draft getAuthRequestContext();

    public abstract ClientHandshakeBuilder getAuthRequestContext(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException;

    public abstract HandshakeBuilder getAuthRequestContext(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException;

    public static HandshakeBuilder MyBillsEntityDataFactory(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        ServerHandshakeBuilder serverHandshakeBuilder;
        String BuiltInFictitiousFunctionClassFactory;
        String BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(byteBuffer);
        if (BuiltInFictitiousFunctionClassFactory2 == null) {
            throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
        }
        String[] split = BuiltInFictitiousFunctionClassFactory2.split(" ", 3);
        if (split.length != 3) {
            throw new InvalidHandshakeException();
        }
        if (role == WebSocket.Role.CLIENT) {
            ServerHandshakeBuilder handshakeImpl1Server = new HandshakeImpl1Server();
            ServerHandshakeBuilder serverHandshakeBuilder2 = handshakeImpl1Server;
            serverHandshakeBuilder2.PlaceComponentResult(Short.parseShort(split[1]));
            serverHandshakeBuilder2.getAuthRequestContext(split[2]);
            serverHandshakeBuilder = handshakeImpl1Server;
        } else {
            HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
            handshakeImpl1Client.PlaceComponentResult(split[1]);
            serverHandshakeBuilder = handshakeImpl1Client;
        }
        while (true) {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(byteBuffer);
            if (BuiltInFictitiousFunctionClassFactory == null || BuiltInFictitiousFunctionClassFactory.length() <= 0) {
                break;
            }
            String[] split2 = BuiltInFictitiousFunctionClassFactory.split(":", 2);
            if (split2.length != 2) {
                throw new InvalidHandshakeException("not an http header");
            }
            serverHandshakeBuilder.PlaceComponentResult(split2[0], split2[1].replaceFirst("^ +", ""));
        }
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return serverHandshakeBuilder;
        }
        throw new IncompleteHandshakeException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean MyBillsEntityDataFactory(Handshakedata handshakedata) {
        return handshakedata.MyBillsEntityDataFactory(HttpHeaders.UPGRADE).equalsIgnoreCase("websocket") && handshakedata.MyBillsEntityDataFactory(HttpHeaders.CONNECTION).toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public final List<Framedata> getAuthRequestContext(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.MyBillsEntityDataFactory != null) {
            this.MyBillsEntityDataFactory = Framedata.Opcode.CONTINUOUS;
        } else {
            this.MyBillsEntityDataFactory = opcode;
        }
        FramedataImpl1 framedataImpl1 = new FramedataImpl1(this.MyBillsEntityDataFactory);
        try {
            framedataImpl1.BuiltInFictitiousFunctionClassFactory(byteBuffer);
            framedataImpl1.MyBillsEntityDataFactory(z);
            if (z) {
                this.MyBillsEntityDataFactory = null;
            } else {
                this.MyBillsEntityDataFactory = opcode;
            }
            return Collections.singletonList(framedataImpl1);
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<ByteBuffer> getAuthRequestContext(Handshakedata handshakedata) {
        StringBuilder sb = new StringBuilder(100);
        if (handshakedata instanceof ClientHandshake) {
            sb.append("GET ");
            sb.append(((ClientHandshake) handshakedata).getAuthRequestContext());
            sb.append(" HTTP/1.1");
        } else if (handshakedata instanceof ServerHandshake) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("HTTP/1.1 101 ");
            sb2.append(((ServerHandshake) handshakedata).MyBillsEntityDataFactory());
            sb.append(sb2.toString());
        } else {
            throw new RuntimeException("unknow role");
        }
        sb.append("\r\n");
        Iterator<String> BuiltInFictitiousFunctionClassFactory = handshakedata.BuiltInFictitiousFunctionClassFactory();
        while (BuiltInFictitiousFunctionClassFactory.hasNext()) {
            String next = BuiltInFictitiousFunctionClassFactory.next();
            String MyBillsEntityDataFactory = handshakedata.MyBillsEntityDataFactory(next);
            sb.append(next);
            sb.append(": ");
            sb.append(MyBillsEntityDataFactory);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] KClassImpl$Data$declaredNonStaticMembers$22 = Charsetfunctions.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
        byte[] PlaceComponentResult = handshakedata.PlaceComponentResult();
        ByteBuffer allocate = ByteBuffer.allocate((PlaceComponentResult == null ? 0 : PlaceComponentResult.length) + KClassImpl$Data$declaredNonStaticMembers$22.length);
        allocate.put(KClassImpl$Data$declaredNonStaticMembers$22);
        if (PlaceComponentResult != null) {
            allocate.put(PlaceComponentResult);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public Handshakedata KClassImpl$Data$declaredNonStaticMembers$2(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return MyBillsEntityDataFactory(byteBuffer, this.BuiltInFictitiousFunctionClassFactory);
    }

    public final void BuiltInFictitiousFunctionClassFactory(WebSocket.Role role) {
        this.BuiltInFictitiousFunctionClassFactory = role;
    }

    private static String BuiltInFictitiousFunctionClassFactory(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = TarHeader.LF_NORMAL;
        while (true) {
            if (byteBuffer.hasRemaining()) {
                byte b2 = byteBuffer.get();
                allocate.put(b2);
                if (b == 13 && b2 == 10) {
                    allocate.limit(allocate.position() - 2);
                    allocate.position(0);
                    break;
                }
                b = b2;
            } else {
                byteBuffer.position(byteBuffer.position() - allocate.position());
                allocate = null;
                break;
            }
        }
        if (allocate == null) {
            return null;
        }
        return Charsetfunctions.BuiltInFictitiousFunctionClassFactory(allocate.array(), allocate.limit());
    }
}
