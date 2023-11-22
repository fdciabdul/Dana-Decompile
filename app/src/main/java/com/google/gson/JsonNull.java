package com.google.gson;

/* loaded from: classes3.dex */
public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE = new JsonNull();

    @Deprecated
    public JsonNull() {
    }

    @Override // com.google.gson.JsonElement
    public final JsonNull deepCopy() {
        return INSTANCE;
    }

    public final int hashCode() {
        return JsonNull.class.hashCode();
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof JsonNull);
    }
}
