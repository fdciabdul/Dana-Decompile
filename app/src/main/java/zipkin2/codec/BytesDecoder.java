package zipkin2.codec;

import java.util.Collection;
import zipkin2.internal.Nullable;

/* loaded from: classes9.dex */
public interface BytesDecoder<T> {
    boolean decodeList(byte[] bArr, Collection<T> collection);

    @Nullable
    T decodeOne(byte[] bArr);
}
