package id.dana.passkey.json;

/* loaded from: classes5.dex */
public interface JsonAdapter {
    <T> T fromJson(String str, Class<T> cls);

    <T> String toJson(T t);
}
