package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class CloseFrameBuilder extends FramedataImpl1 implements CloseFrame {
    static final ByteBuffer MyBillsEntityDataFactory = ByteBuffer.allocate(0);
    private int getErrorConfigVersion;
    private String moveToNextValue;

    public CloseFrameBuilder() {
        super(Framedata.Opcode.CLOSING);
        MyBillsEntityDataFactory(true);
    }

    public CloseFrameBuilder(byte b) throws InvalidDataException {
        super(Framedata.Opcode.CLOSING);
        MyBillsEntityDataFactory(true);
        MyBillsEntityDataFactory(1000, "");
    }

    public CloseFrameBuilder(int i, String str) throws InvalidDataException {
        super(Framedata.Opcode.CLOSING);
        MyBillsEntityDataFactory(true);
        MyBillsEntityDataFactory(i, str);
    }

    private void MyBillsEntityDataFactory(int i, String str) throws InvalidDataException {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (i == 1015) {
            i = 1005;
        } else {
            str2 = str;
        }
        if (i == 1005) {
            if (str2.length() > 0) {
                throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
            }
            return;
        }
        byte[] PlaceComponentResult = Charsetfunctions.PlaceComponentResult(str2);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(PlaceComponentResult.length + 2);
        allocate2.put(allocate);
        allocate2.put(PlaceComponentResult);
        allocate2.rewind();
        super.BuiltInFictitiousFunctionClassFactory(allocate2);
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        scheduleImpl();
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0() throws InvalidFrameException {
        this.getErrorConfigVersion = 1005;
        ByteBuffer BuiltInFictitiousFunctionClassFactory = super.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.mark();
        if (BuiltInFictitiousFunctionClassFactory.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(BuiltInFictitiousFunctionClassFactory.getShort());
            allocate.position(0);
            int i = allocate.getInt();
            this.getErrorConfigVersion = i;
            if (i == 1006 || i == 1015 || i == 1005 || i > 4999 || i < 1000 || i == 1004) {
                StringBuilder sb = new StringBuilder();
                sb.append("closecode must not be sent over the wire: ");
                sb.append(this.getErrorConfigVersion);
                throw new InvalidFrameException(sb.toString());
            }
        }
        BuiltInFictitiousFunctionClassFactory.reset();
    }

    @Override // com.mixpanel.android.java_websocket.framing.CloseFrame
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }

    private void scheduleImpl() throws InvalidDataException {
        if (this.getErrorConfigVersion == 1005) {
            this.moveToNextValue = Charsetfunctions.PlaceComponentResult(super.BuiltInFictitiousFunctionClassFactory());
            return;
        }
        ByteBuffer BuiltInFictitiousFunctionClassFactory = super.BuiltInFictitiousFunctionClassFactory();
        int position = BuiltInFictitiousFunctionClassFactory.position();
        try {
            try {
                BuiltInFictitiousFunctionClassFactory.position(BuiltInFictitiousFunctionClassFactory.position() + 2);
                this.moveToNextValue = Charsetfunctions.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
            } catch (IllegalArgumentException e) {
                throw new InvalidFrameException(e);
            }
        } finally {
            BuiltInFictitiousFunctionClassFactory.position(position);
        }
    }

    @Override // com.mixpanel.android.java_websocket.framing.CloseFrame
    public final String MyBillsEntityDataFactory() {
        return this.moveToNextValue;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FramedataImpl1
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("code: ");
        sb.append(this.getErrorConfigVersion);
        return sb.toString();
    }

    @Override // com.mixpanel.android.java_websocket.framing.FramedataImpl1, com.mixpanel.android.java_websocket.framing.FrameBuilder
    public final void BuiltInFictitiousFunctionClassFactory(ByteBuffer byteBuffer) throws InvalidDataException {
        super.BuiltInFictitiousFunctionClassFactory(byteBuffer);
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        scheduleImpl();
    }

    @Override // com.mixpanel.android.java_websocket.framing.FramedataImpl1, com.mixpanel.android.java_websocket.framing.Framedata
    public final ByteBuffer BuiltInFictitiousFunctionClassFactory() {
        if (this.getErrorConfigVersion == 1005) {
            return MyBillsEntityDataFactory;
        }
        return super.BuiltInFictitiousFunctionClassFactory();
    }
}
