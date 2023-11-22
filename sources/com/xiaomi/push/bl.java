package com.xiaomi.push;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* loaded from: classes8.dex */
public class bl {
    bp BuiltInFictitiousFunctionClassFactory;
    OutputStream KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    int PlaceComponentResult;
    private byte[] lookAheadTest;
    ByteBuffer getAuthRequestContext = ByteBuffer.allocate(2048);
    private ByteBuffer scheduleImpl = ByteBuffer.allocate(4);
    private Adler32 moveToNextValue = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(OutputStream outputStream, bp bpVar) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new BufferedOutputStream(outputStream);
        this.BuiltInFictitiousFunctionClassFactory = bpVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.MyBillsEntityDataFactory = timeZone.getRawOffset() / 3600000;
        this.PlaceComponentResult = timeZone.useDaylightTime() ? 1 : 0;
    }

    public final int BuiltInFictitiousFunctionClassFactory(bi biVar) {
        int PlaceComponentResult = biVar.PlaceComponentResult();
        if (PlaceComponentResult > 32768) {
            StringBuilder sb = new StringBuilder();
            sb.append("Blob size=");
            sb.append(PlaceComponentResult);
            sb.append(" should be less than ");
            sb.append(32768);
            sb.append(" Drop blob chid=");
            sb.append(biVar.PlaceComponentResult.PlaceComponentResult);
            sb.append(" id=");
            sb.append(biVar.MyBillsEntityDataFactory());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            return 0;
        }
        this.getAuthRequestContext.clear();
        int i = PlaceComponentResult + 8 + 4;
        if (i > this.getAuthRequestContext.capacity() || this.getAuthRequestContext.capacity() > 4096) {
            this.getAuthRequestContext = ByteBuffer.allocate(i);
        }
        this.getAuthRequestContext.putShort((short) -15618);
        this.getAuthRequestContext.putShort((short) 5);
        this.getAuthRequestContext.putInt(PlaceComponentResult);
        int position = this.getAuthRequestContext.position();
        this.getAuthRequestContext = biVar.PlaceComponentResult(this.getAuthRequestContext);
        if (!"CONN".equals(biVar.PlaceComponentResult.lookAheadTest)) {
            if (this.lookAheadTest == null) {
                this.lookAheadTest = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
            }
            com.xiaomi.push.service.bh.PlaceComponentResult(this.lookAheadTest, this.getAuthRequestContext.array(), position, PlaceComponentResult);
        }
        this.moveToNextValue.reset();
        this.moveToNextValue.update(this.getAuthRequestContext.array(), 0, this.getAuthRequestContext.position());
        this.scheduleImpl.putInt(0, (int) this.moveToNextValue.getValue());
        this.KClassImpl$Data$declaredNonStaticMembers$2.write(this.getAuthRequestContext.array(), 0, this.getAuthRequestContext.position());
        this.KClassImpl$Data$declaredNonStaticMembers$2.write(this.scheduleImpl.array(), 0, 4);
        this.KClassImpl$Data$declaredNonStaticMembers$2.flush();
        int position2 = this.getAuthRequestContext.position() + 4;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[Slim] Wrote {cmd=");
        sb2.append(biVar.PlaceComponentResult.lookAheadTest);
        sb2.append(";chid=");
        sb2.append(biVar.PlaceComponentResult.PlaceComponentResult);
        sb2.append(";len=");
        sb2.append(position2);
        sb2.append("}");
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb2.toString());
        return position2;
    }
}
