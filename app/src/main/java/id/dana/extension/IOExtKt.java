package id.dana.extension;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/io/Closeable;", "", "getAuthRequestContext", "(Ljava/io/Closeable;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class IOExtKt {
    public static final void getAuthRequestContext(Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "");
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }
}
