package com.mixpanel.android.java_websocket.drafts;

import com.alibaba.griver.base.common.utils.MD5Util;
import com.google.common.net.HttpHeaders;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.CloseFrameBuilder;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* loaded from: classes3.dex */
public class Draft_76 extends Draft_75 {
    private static final byte[] lookAheadTest = {-1, 0};
    private boolean scheduleImpl = false;
    private final Random NetworkUserEntityData$$ExternalSyntheticLambda0 = new Random();

    private static byte[] getAuthRequestContext(String str, String str2, byte[] bArr) throws InvalidHandshakeException {
        byte[] KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str);
        byte[] KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(str2);
        try {
            return MessageDigest.getInstance(MD5Util.ALGORIGTHM_MD5).digest(new byte[]{KClassImpl$Data$declaredNonStaticMembers$2[0], KClassImpl$Data$declaredNonStaticMembers$2[1], KClassImpl$Data$declaredNonStaticMembers$2[2], KClassImpl$Data$declaredNonStaticMembers$2[3], KClassImpl$Data$declaredNonStaticMembers$22[0], KClassImpl$Data$declaredNonStaticMembers$22[1], KClassImpl$Data$declaredNonStaticMembers$22[2], KClassImpl$Data$declaredNonStaticMembers$22[3], bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]});
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String PlaceComponentResult() {
        Random random = new Random();
        long nextInt = random.nextInt(12) + 1;
        String l = Long.toString((random.nextInt(Math.abs(new Long(4294967295L / nextInt).intValue())) + 1) * nextInt);
        int nextInt2 = random.nextInt(12);
        for (int i = 0; i < nextInt2 + 1; i++) {
            int abs = Math.abs(random.nextInt(l.length()));
            char nextInt3 = (char) (random.nextInt(95) + 33);
            if (nextInt3 >= '0' && nextInt3 <= '9') {
                nextInt3 = (char) (nextInt3 - 15);
            }
            l = new StringBuilder(l).insert(abs, nextInt3).toString();
        }
        for (int i2 = 0; i2 < nextInt; i2++) {
            l = new StringBuilder(l).insert(Math.abs(random.nextInt(l.length() - 1) + 1), " ").toString();
        }
        return l;
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(String str) throws InvalidHandshakeException {
        try {
            long parseLong = Long.parseLong(str.replaceAll("[^0-9]", ""));
            long length = str.split(" ").length - 1;
            if (length == 0) {
                throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key2/)");
            }
            long longValue = new Long(parseLong / length).longValue();
            return new byte[]{(byte) (longValue >> 24), (byte) ((longValue << 8) >> 24), (byte) ((longValue << 16) >> 24), (byte) ((longValue << 24) >> 24)};
        } catch (NumberFormatException unused) {
            throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public final Draft.HandshakeState BuiltInFictitiousFunctionClassFactory(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        if (this.scheduleImpl) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        try {
            if (serverHandshake.MyBillsEntityDataFactory("Sec-WebSocket-Origin").equals(clientHandshake.MyBillsEntityDataFactory(HttpHeaders.ORIGIN)) && MyBillsEntityDataFactory(serverHandshake)) {
                byte[] PlaceComponentResult = serverHandshake.PlaceComponentResult();
                if (PlaceComponentResult == null || PlaceComponentResult.length == 0) {
                    throw new IncompleteHandshakeException();
                }
                if (Arrays.equals(PlaceComponentResult, getAuthRequestContext(clientHandshake.MyBillsEntityDataFactory("Sec-WebSocket-Key1"), clientHandshake.MyBillsEntityDataFactory("Sec-WebSocket-Key2"), clientHandshake.PlaceComponentResult()))) {
                    return Draft.HandshakeState.MATCHED;
                }
                return Draft.HandshakeState.NOT_MATCHED;
            }
            return Draft.HandshakeState.NOT_MATCHED;
        } catch (InvalidHandshakeException e) {
            throw new RuntimeException("bad handshakerequest", e);
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public final Draft.HandshakeState getAuthRequestContext(ClientHandshake clientHandshake) {
        if (clientHandshake.MyBillsEntityDataFactory(HttpHeaders.UPGRADE).equals("WebSocket") && clientHandshake.MyBillsEntityDataFactory(HttpHeaders.CONNECTION).contains(HttpHeaders.UPGRADE) && clientHandshake.MyBillsEntityDataFactory("Sec-WebSocket-Key1").length() > 0 && !clientHandshake.MyBillsEntityDataFactory("Sec-WebSocket-Key2").isEmpty() && clientHandshake.KClassImpl$Data$declaredNonStaticMembers$2(HttpHeaders.ORIGIN)) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public final ClientHandshakeBuilder getAuthRequestContext(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.PlaceComponentResult(HttpHeaders.UPGRADE, "WebSocket");
        clientHandshakeBuilder.PlaceComponentResult(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE);
        clientHandshakeBuilder.PlaceComponentResult("Sec-WebSocket-Key1", PlaceComponentResult());
        clientHandshakeBuilder.PlaceComponentResult("Sec-WebSocket-Key2", PlaceComponentResult());
        if (!clientHandshakeBuilder.KClassImpl$Data$declaredNonStaticMembers$2(HttpHeaders.ORIGIN)) {
            StringBuilder sb = new StringBuilder();
            sb.append("random");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0.nextInt());
            clientHandshakeBuilder.PlaceComponentResult(HttpHeaders.ORIGIN, sb.toString());
        }
        byte[] bArr = new byte[8];
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.nextBytes(bArr);
        clientHandshakeBuilder.BuiltInFictitiousFunctionClassFactory(bArr);
        return clientHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public final HandshakeBuilder getAuthRequestContext(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.getAuthRequestContext("WebSocket Protocol Handshake");
        serverHandshakeBuilder.PlaceComponentResult(HttpHeaders.UPGRADE, "WebSocket");
        serverHandshakeBuilder.PlaceComponentResult(HttpHeaders.CONNECTION, clientHandshake.MyBillsEntityDataFactory(HttpHeaders.CONNECTION));
        serverHandshakeBuilder.PlaceComponentResult("Sec-WebSocket-Origin", clientHandshake.MyBillsEntityDataFactory(HttpHeaders.ORIGIN));
        StringBuilder sb = new StringBuilder();
        sb.append("ws://");
        sb.append(clientHandshake.MyBillsEntityDataFactory(HttpHeaders.HOST));
        sb.append(clientHandshake.getAuthRequestContext());
        serverHandshakeBuilder.PlaceComponentResult("Sec-WebSocket-Location", sb.toString());
        String MyBillsEntityDataFactory = clientHandshake.MyBillsEntityDataFactory("Sec-WebSocket-Key1");
        String MyBillsEntityDataFactory2 = clientHandshake.MyBillsEntityDataFactory("Sec-WebSocket-Key2");
        byte[] PlaceComponentResult = clientHandshake.PlaceComponentResult();
        if (MyBillsEntityDataFactory == null || MyBillsEntityDataFactory2 == null || PlaceComponentResult == null || PlaceComponentResult.length != 8) {
            throw new InvalidHandshakeException("Bad keys");
        }
        serverHandshakeBuilder.BuiltInFictitiousFunctionClassFactory(getAuthRequestContext(MyBillsEntityDataFactory, MyBillsEntityDataFactory2, PlaceComponentResult));
        return serverHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public final Handshakedata KClassImpl$Data$declaredNonStaticMembers$2(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        HandshakeBuilder MyBillsEntityDataFactory = MyBillsEntityDataFactory(byteBuffer, this.BuiltInFictitiousFunctionClassFactory);
        if ((MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2("Sec-WebSocket-Key1") || this.BuiltInFictitiousFunctionClassFactory == WebSocket.Role.CLIENT) && !MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(HttpHeaders.SEC_WEBSOCKET_VERSION)) {
            byte[] bArr = new byte[this.BuiltInFictitiousFunctionClassFactory == WebSocket.Role.SERVER ? 8 : 16];
            try {
                byteBuffer.get(bArr);
                MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(bArr);
            } catch (BufferUnderflowException unused) {
                throw new IncompleteHandshakeException(byteBuffer.capacity() + 16);
            }
        }
        return MyBillsEntityDataFactory;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public final List<Framedata> PlaceComponentResult(ByteBuffer byteBuffer) throws InvalidDataException {
        byteBuffer.mark();
        List<Framedata> MyBillsEntityDataFactory = super.MyBillsEntityDataFactory(byteBuffer);
        if (MyBillsEntityDataFactory == null) {
            byteBuffer.reset();
            List<Framedata> list = this.moveToNextValue;
            this.getErrorConfigVersion = true;
            if (this.PlaceComponentResult == null) {
                this.PlaceComponentResult = ByteBuffer.allocate(2);
                if (byteBuffer.remaining() > this.PlaceComponentResult.remaining()) {
                    throw new InvalidFrameException();
                }
                this.PlaceComponentResult.put(byteBuffer);
                if (!this.PlaceComponentResult.hasRemaining()) {
                    if (Arrays.equals(this.PlaceComponentResult.array(), lookAheadTest)) {
                        list.add(new CloseFrameBuilder((byte) 0));
                        return list;
                    }
                    throw new InvalidFrameException();
                }
                this.moveToNextValue = new LinkedList();
                return list;
            }
            throw new InvalidFrameException();
        }
        return MyBillsEntityDataFactory;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public final ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2(Framedata framedata) {
        if (framedata.PlaceComponentResult() == Framedata.Opcode.CLOSING) {
            return ByteBuffer.wrap(lookAheadTest);
        }
        return super.KClassImpl$Data$declaredNonStaticMembers$2(framedata);
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public final Draft.CloseHandshakeType KClassImpl$Data$declaredNonStaticMembers$2() {
        return Draft.CloseHandshakeType.ONEWAY;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public final Draft getAuthRequestContext() {
        return new Draft_76();
    }
}
