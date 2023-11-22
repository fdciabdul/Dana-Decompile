package okio;

import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;

/* loaded from: classes9.dex */
public final class HashingSource extends ForwardingSource {
    private final Mac KClassImpl$Data$declaredNonStaticMembers$2;
    private final MessageDigest MyBillsEntityDataFactory;

    @Override // okio.ForwardingSource, okio.Source
    public final long read(Buffer buffer, long j) throws IOException {
        long read = super.read(buffer, j);
        if (read != -1) {
            long j2 = buffer.getAuthRequestContext - read;
            long j3 = buffer.getAuthRequestContext;
            Segment segment = buffer.BuiltInFictitiousFunctionClassFactory;
            while (j3 > j2) {
                segment = segment.lookAheadTest;
                j3 -= segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
            }
            while (j3 < buffer.getAuthRequestContext) {
                int i = (int) ((segment.PlaceComponentResult + j2) - j3);
                MessageDigest messageDigest = this.MyBillsEntityDataFactory;
                if (messageDigest != null) {
                    messageDigest.update(segment.BuiltInFictitiousFunctionClassFactory, i, segment.MyBillsEntityDataFactory - i);
                } else {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.update(segment.BuiltInFictitiousFunctionClassFactory, i, segment.MyBillsEntityDataFactory - i);
                }
                j3 += segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
                segment = segment.getAuthRequestContext;
                j2 = j3;
            }
        }
        return read;
    }
}
