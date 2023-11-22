package kotlin.io;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/io/ExposingBufferByteArrayOutputStream;", "Ljava/io/ByteArrayOutputStream;", "", "getBuffer", "()[B", "buffer", "", GriverMonitorConstants.KEY_SIZE, "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
final class ExposingBufferByteArrayOutputStream extends ByteArrayOutputStream {
    public ExposingBufferByteArrayOutputStream(int i) {
        super(i);
    }

    @JvmName(name = "getBuffer")
    public final byte[] getBuffer() {
        byte[] bArr = this.buf;
        Intrinsics.checkNotNullExpressionValue(bArr, "");
        return bArr;
    }
}
