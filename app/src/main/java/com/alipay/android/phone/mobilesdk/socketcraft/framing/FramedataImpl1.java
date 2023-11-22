package com.alipay.android.phone.mobilesdk.socketcraft.framing;

import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.util.Charsetfunctions;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class FramedataImpl1 implements FrameBuilder {
    protected static byte[] emptyarray = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f6905a;
    protected boolean fin;
    protected Framedata.Opcode optcode;
    protected boolean transferemasked;

    public FramedataImpl1() {
    }

    public FramedataImpl1(Framedata.Opcode opcode) {
        this.optcode = opcode;
        this.f6905a = ByteBuffer.wrap(emptyarray);
    }

    public FramedataImpl1(Framedata framedata) {
        this.fin = framedata.isFin();
        this.optcode = framedata.getOpcode();
        this.f6905a = framedata.getPayloadData();
        this.transferemasked = framedata.getTransfereMasked();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public boolean isFin() {
        return this.fin;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public Framedata.Opcode getOpcode() {
        return this.optcode;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public boolean getTransfereMasked() {
        return this.transferemasked;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public ByteBuffer getPayloadData() {
        return this.f6905a;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FrameBuilder
    public void setFin(boolean z) {
        this.fin = z;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FrameBuilder
    public void setOptcode(Framedata.Opcode opcode) {
        this.optcode = opcode;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FrameBuilder
    public void setPayload(ByteBuffer byteBuffer) {
        this.f6905a = byteBuffer;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.FrameBuilder
    public void setTransferemasked(boolean z) {
        this.transferemasked = z;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public void append(Framedata framedata) {
        ByteBuffer payloadData = framedata.getPayloadData();
        if (this.f6905a == null) {
            this.f6905a = ByteBuffer.allocate(payloadData.remaining());
            payloadData.mark();
            this.f6905a.put(payloadData);
            payloadData.reset();
        } else {
            payloadData.mark();
            ByteBuffer byteBuffer = this.f6905a;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.f6905a;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (payloadData.remaining() > this.f6905a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(payloadData.remaining() + this.f6905a.capacity());
                this.f6905a.flip();
                allocate.put(this.f6905a);
                allocate.put(payloadData);
                this.f6905a = allocate;
            } else {
                this.f6905a.put(payloadData);
            }
            this.f6905a.rewind();
            payloadData.reset();
        }
        this.fin = framedata.isFin();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Framedata{ optcode:");
        sb.append(getOpcode());
        sb.append(", fin:");
        sb.append(isFin());
        sb.append(", payloadlength:[pos:");
        sb.append(this.f6905a.position());
        sb.append(", len:");
        sb.append(this.f6905a.remaining());
        sb.append("], payload:");
        sb.append(Arrays.toString(Charsetfunctions.utf8Bytes(new String(this.f6905a.array()))));
        sb.append("}");
        return sb.toString();
    }
}
