package zipkin2.codec;

/* loaded from: classes2.dex */
public interface BytesEncoder<T> {
    byte[] encode(T t);

    Encoding encoding();
}
