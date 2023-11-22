package io.opentelemetry.sdk.logs.data;

import io.opentelemetry.sdk.logs.data.Body;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public abstract class StringBody implements Body {
    @Override // io.opentelemetry.sdk.logs.data.Body
    public abstract String asString();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Body create(String str) {
        return new AutoValue_StringBody(str);
    }

    @Override // io.opentelemetry.sdk.logs.data.Body
    public final Body.Type getType() {
        return Body.Type.STRING;
    }
}
