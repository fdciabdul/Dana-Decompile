package okio;

import java.io.IOException;
import java.security.MessageDigest;
import javax.annotation.Nullable;
import javax.crypto.Mac;

/* loaded from: classes9.dex */
public final class HashingSink extends ForwardingSink {
    @Nullable
    private final MessageDigest PlaceComponentResult;
    @Nullable
    private final Mac getAuthRequestContext;

    @Override // okio.ForwardingSink, okio.Sink
    public final void write(Buffer buffer, long j) throws IOException {
        Util.MyBillsEntityDataFactory(buffer.getAuthRequestContext, 0L, j);
        Segment segment = buffer.BuiltInFictitiousFunctionClassFactory;
        long j2 = 0;
        while (j2 < j) {
            int min = (int) Math.min(j - j2, segment.MyBillsEntityDataFactory - segment.PlaceComponentResult);
            MessageDigest messageDigest = this.PlaceComponentResult;
            if (messageDigest != null) {
                messageDigest.update(segment.BuiltInFictitiousFunctionClassFactory, segment.PlaceComponentResult, min);
            } else {
                this.getAuthRequestContext.update(segment.BuiltInFictitiousFunctionClassFactory, segment.PlaceComponentResult, min);
            }
            j2 += min;
            segment = segment.getAuthRequestContext;
        }
        super.write(buffer, j);
    }
}
