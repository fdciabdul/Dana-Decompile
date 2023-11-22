package io.opentelemetry.sdk.logs.data;

/* loaded from: classes9.dex */
public interface Body {

    /* loaded from: classes9.dex */
    public enum Type {
        EMPTY,
        STRING
    }

    String asString();

    Type getType();

    /* renamed from: io.opentelemetry.sdk.logs.data.Body$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static Body string(String str) {
            return StringBody.create(str);
        }

        public static Body empty() {
            return EmptyBody.INSTANCE;
        }
    }
}
