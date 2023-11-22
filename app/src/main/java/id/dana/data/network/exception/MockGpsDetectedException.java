package id.dana.data.network.exception;

import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/network/exception/MockGpsDetectedException;", "Ljava/io/IOException;", "", "getLocalizedMessage", "()Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MockGpsDetectedException extends IOException {
    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return "Location Mock Detected !";
    }
}
