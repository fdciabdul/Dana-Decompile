package io.opentelemetry.sdk.logs.data;

import io.opentelemetry.sdk.logs.data.Body;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public enum EmptyBody implements Body {
    INSTANCE;

    @Override // io.opentelemetry.sdk.logs.data.Body
    public final String asString() {
        return "";
    }

    @Override // io.opentelemetry.sdk.logs.data.Body
    public final Body.Type getType() {
        return Body.Type.EMPTY;
    }
}
