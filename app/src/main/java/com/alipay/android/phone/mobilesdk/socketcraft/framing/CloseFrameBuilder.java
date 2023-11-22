package com.alipay.android.phone.mobilesdk.socketcraft.framing;

import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidDataException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidFrameException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.util.Charsetfunctions;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class CloseFrameBuilder extends FramedataImpl1 implements CloseFrame {
    static final ByteBuffer emptybytebuffer = ByteBuffer.allocate(0);

    /* renamed from: a  reason: collision with root package name */
    private int f6904a;
    private String b;

    public CloseFrameBuilder() {
        super(Framedata.Opcode.CLOSING);
        setFin(true);
    }

    public CloseFrameBuilder(int i) {
        super(Framedata.Opcode.CLOSING);
        setFin(true);
        a(i, "");
    }

    public CloseFrameBuilder(int i, String str) {
        super(Framedata.Opcode.CLOSING);
        setFin(true);
        a(i, str);
    }

    private void a(int i, String str) {
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
        byte[] utf8Bytes = Charsetfunctions.utf8Bytes(str2);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(utf8Bytes.length + 2);
        allocate2.put(allocate);
        allocate2.put(utf8Bytes);
        allocate2.rewind();
        setPayload(allocate2);
    }

    private void a() {
        this.f6904a = 1005;
        ByteBuffer payloadData = super.getPayloadData();
        payloadData.mark();
        if (payloadData.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(payloadData.getShort());
            allocate.position(0);
            int i = allocate.getInt();
            this.f6904a = i;
            if (i == 1006 || i == 1015 || i == 1005 || i > 4999 || i < 1000 || i == 1004) {
                StringBuilder sb = new StringBuilder("closecode must not be sent over the wire: ");
                sb.append(this.f6904a);
                throw new InvalidFrameException(sb.toString());
            }
        }
        payloadData.reset();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.CloseFrame
    public int getCloseCode() {
        return this.f6904a;
    }

    private void b() {
        if (this.f6904a == 1005) {
            this.b = Charsetfunctions.stringUtf8(super.getPayloadData());
            return;
        }
        ByteBuffer payloadData = super.getPayloadData();
        int position = payloadData.position();
        try {
            try {
                payloadData.position(payloadData.position() + 2);
                this.b = Charsetfunctions.stringUtf8(payloadData);
            } catch (IllegalArgumentException e) {
                throw new InvalidFrameException(e);
            }
        } finally {
            payloadData.position(position);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.CloseFrame
    public String getMessage() {
        return this.b;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FramedataImpl1
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("code: ");
        sb.append(this.f6904a);
        return sb.toString();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FramedataImpl1, com.alipay.android.phone.mobilesdk.socketcraft.framing.FrameBuilder
    public void setPayload(ByteBuffer byteBuffer) {
        super.setPayload(byteBuffer);
        a();
        b();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FramedataImpl1, com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public ByteBuffer getPayloadData() {
        if (this.f6904a == 1005) {
            return emptybytebuffer;
        }
        return super.getPayloadData();
    }
}
