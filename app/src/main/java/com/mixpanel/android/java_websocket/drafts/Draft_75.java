package com.mixpanel.android.java_websocket.drafts;

import com.google.common.net.HttpHeaders;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.LimitExedeedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* loaded from: classes3.dex */
public class Draft_75 extends Draft {
    protected ByteBuffer PlaceComponentResult;
    protected boolean getErrorConfigVersion = false;
    protected List<Framedata> moveToNextValue = new LinkedList();
    private final Random NetworkUserEntityData$$ExternalSyntheticLambda0 = new Random();

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState BuiltInFictitiousFunctionClassFactory(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        return (clientHandshake.MyBillsEntityDataFactory("WebSocket-Origin").equals(serverHandshake.MyBillsEntityDataFactory(HttpHeaders.ORIGIN)) && MyBillsEntityDataFactory(serverHandshake)) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState getAuthRequestContext(ClientHandshake clientHandshake) {
        if (clientHandshake.KClassImpl$Data$declaredNonStaticMembers$2(HttpHeaders.ORIGIN) && MyBillsEntityDataFactory(clientHandshake)) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2(Framedata framedata) {
        if (framedata.PlaceComponentResult() != Framedata.Opcode.TEXT) {
            throw new RuntimeException("only text frames supported");
        }
        ByteBuffer BuiltInFictitiousFunctionClassFactory = framedata.BuiltInFictitiousFunctionClassFactory();
        ByteBuffer allocate = ByteBuffer.allocate(BuiltInFictitiousFunctionClassFactory.remaining() + 2);
        allocate.put((byte) 0);
        BuiltInFictitiousFunctionClassFactory.mark();
        allocate.put(BuiltInFictitiousFunctionClassFactory);
        BuiltInFictitiousFunctionClassFactory.reset();
        allocate.put((byte) -1);
        allocate.flip();
        return allocate;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public ClientHandshakeBuilder getAuthRequestContext(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException {
        clientHandshakeBuilder.PlaceComponentResult(HttpHeaders.UPGRADE, "WebSocket");
        clientHandshakeBuilder.PlaceComponentResult(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE);
        if (!clientHandshakeBuilder.KClassImpl$Data$declaredNonStaticMembers$2(HttpHeaders.ORIGIN)) {
            StringBuilder sb = new StringBuilder();
            sb.append("random");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0.nextInt());
            clientHandshakeBuilder.PlaceComponentResult(HttpHeaders.ORIGIN, sb.toString());
        }
        return clientHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public HandshakeBuilder getAuthRequestContext(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.getAuthRequestContext("Web Socket Protocol Handshake");
        serverHandshakeBuilder.PlaceComponentResult(HttpHeaders.UPGRADE, "WebSocket");
        serverHandshakeBuilder.PlaceComponentResult(HttpHeaders.CONNECTION, clientHandshake.MyBillsEntityDataFactory(HttpHeaders.CONNECTION));
        serverHandshakeBuilder.PlaceComponentResult("WebSocket-Origin", clientHandshake.MyBillsEntityDataFactory(HttpHeaders.ORIGIN));
        StringBuilder sb = new StringBuilder();
        sb.append("ws://");
        sb.append(clientHandshake.MyBillsEntityDataFactory(HttpHeaders.HOST));
        sb.append(clientHandshake.getAuthRequestContext());
        serverHandshakeBuilder.PlaceComponentResult("WebSocket-Location", sb.toString());
        return serverHandshakeBuilder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<Framedata> MyBillsEntityDataFactory(ByteBuffer byteBuffer) throws InvalidDataException {
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            if (b == 0) {
                if (this.getErrorConfigVersion) {
                    throw new InvalidFrameException("unexpected START_OF_FRAME");
                }
                this.getErrorConfigVersion = true;
            } else if (b == -1) {
                if (!this.getErrorConfigVersion) {
                    throw new InvalidFrameException("unexpected END_OF_FRAME");
                }
                ByteBuffer byteBuffer2 = this.PlaceComponentResult;
                if (byteBuffer2 != null) {
                    byteBuffer2.flip();
                    FramedataImpl1 framedataImpl1 = new FramedataImpl1();
                    framedataImpl1.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
                    framedataImpl1.MyBillsEntityDataFactory(true);
                    framedataImpl1.getAuthRequestContext(Framedata.Opcode.TEXT);
                    this.moveToNextValue.add(framedataImpl1);
                    this.PlaceComponentResult = null;
                    byteBuffer.mark();
                }
                this.getErrorConfigVersion = false;
            } else if (!this.getErrorConfigVersion) {
                return null;
            } else {
                ByteBuffer byteBuffer3 = this.PlaceComponentResult;
                if (byteBuffer3 == null) {
                    this.PlaceComponentResult = ByteBuffer.allocate(KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (!byteBuffer3.hasRemaining()) {
                    this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
                }
                this.PlaceComponentResult.put(b);
            }
        }
        List<Framedata> list = this.moveToNextValue;
        this.moveToNextValue = new LinkedList();
        return list;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public List<Framedata> PlaceComponentResult(ByteBuffer byteBuffer) throws InvalidDataException {
        List<Framedata> MyBillsEntityDataFactory = MyBillsEntityDataFactory(byteBuffer);
        if (MyBillsEntityDataFactory != null) {
            return MyBillsEntityDataFactory;
        }
        throw new InvalidDataException(1002);
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.getErrorConfigVersion = false;
        this.PlaceComponentResult = null;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType KClassImpl$Data$declaredNonStaticMembers$2() {
        return Draft.CloseHandshakeType.NONE;
    }

    private static ByteBuffer BuiltInFictitiousFunctionClassFactory(ByteBuffer byteBuffer) throws LimitExedeedException, InvalidDataException {
        byteBuffer.flip();
        int capacity = byteBuffer.capacity() * 2;
        if (capacity >= 0) {
            ByteBuffer allocate = ByteBuffer.allocate(capacity);
            allocate.put(byteBuffer);
            return allocate;
        }
        throw new InvalidDataException(1002, "Negative count");
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft getAuthRequestContext() {
        return new Draft_75();
    }
}
