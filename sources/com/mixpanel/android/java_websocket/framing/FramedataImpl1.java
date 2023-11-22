package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class FramedataImpl1 implements FrameBuilder {
    protected static byte[] KClassImpl$Data$declaredNonStaticMembers$2 = new byte[0];
    protected Framedata.Opcode BuiltInFictitiousFunctionClassFactory;
    private ByteBuffer MyBillsEntityDataFactory;
    protected boolean PlaceComponentResult;
    protected boolean getAuthRequestContext;

    public FramedataImpl1() {
    }

    public FramedataImpl1(Framedata.Opcode opcode) {
        this.BuiltInFictitiousFunctionClassFactory = opcode;
        this.MyBillsEntityDataFactory = ByteBuffer.wrap(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public FramedataImpl1(Framedata framedata) {
        this.PlaceComponentResult = framedata.moveToNextValue();
        this.BuiltInFictitiousFunctionClassFactory = framedata.PlaceComponentResult();
        this.MyBillsEntityDataFactory = framedata.BuiltInFictitiousFunctionClassFactory();
        this.getAuthRequestContext = framedata.getAuthRequestContext();
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    public final boolean moveToNextValue() {
        return this.PlaceComponentResult;
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    public final Framedata.Opcode PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    public final boolean getAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    public ByteBuffer BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FrameBuilder
    public final void MyBillsEntityDataFactory(boolean z) {
        this.PlaceComponentResult = z;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FrameBuilder
    public final void getAuthRequestContext(Framedata.Opcode opcode) {
        this.BuiltInFictitiousFunctionClassFactory = opcode;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FrameBuilder
    public void BuiltInFictitiousFunctionClassFactory(ByteBuffer byteBuffer) throws InvalidDataException {
        this.MyBillsEntityDataFactory = byteBuffer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Framedata{ optcode:");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", fin:");
        sb.append(moveToNextValue());
        sb.append(", payloadlength:[pos:");
        sb.append(this.MyBillsEntityDataFactory.position());
        sb.append(", len:");
        sb.append(this.MyBillsEntityDataFactory.remaining());
        sb.append("], payload:");
        sb.append(Arrays.toString(Charsetfunctions.PlaceComponentResult(new String(this.MyBillsEntityDataFactory.array()))));
        sb.append("}");
        return sb.toString();
    }
}
