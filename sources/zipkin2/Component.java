package zipkin2;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class Component implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }
}
