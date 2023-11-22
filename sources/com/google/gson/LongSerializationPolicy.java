package com.google.gson;

/* loaded from: classes3.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public final JsonElement serialize(Long l) {
            if (l == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(l);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public final JsonElement serialize(Long l) {
            if (l == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(l.toString());
        }
    };

    public abstract JsonElement serialize(Long l);
}
