package id.dana.passkey.json;

import com.google.gson.Gson;

/* loaded from: classes5.dex */
public class GsonAdapter implements JsonAdapter {
    private final Gson gson = new Gson();

    @Override // id.dana.passkey.json.JsonAdapter
    public <T> T fromJson(String str, Class<T> cls) {
        return (T) this.gson.fromJson(str, (Class) cls);
    }

    @Override // id.dana.passkey.json.JsonAdapter
    public <T> String toJson(T t) {
        return this.gson.toJson(t);
    }
}
