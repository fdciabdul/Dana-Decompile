package io.opentelemetry.sdk.common;

import io.opentelemetry.api.common.Attributes;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class InstrumentationScopeInfo {
    private static final InstrumentationScopeInfo EMPTY = create("");

    public abstract Attributes getAttributes();

    public abstract String getName();

    @Nullable
    public abstract String getSchemaUrl();

    @Nullable
    public abstract String getVersion();

    public static InstrumentationScopeInfo create(String str) {
        return create(str, null, null, Attributes.CC.empty());
    }

    @Deprecated
    public static InstrumentationScopeInfo create(String str, @Nullable String str2, @Nullable String str3) {
        return create(str, str2, str3, Attributes.CC.empty());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InstrumentationScopeInfo create(String str, @Nullable String str2, @Nullable String str3, Attributes attributes) {
        Objects.requireNonNull(str, "name");
        Objects.requireNonNull(attributes, "attributes");
        return new AutoValue_InstrumentationScopeInfo(str, str2, str3, attributes);
    }

    public static InstrumentationScopeInfoBuilder builder(String str) {
        return new InstrumentationScopeInfoBuilder(str);
    }

    public static InstrumentationScopeInfo empty() {
        return EMPTY;
    }
}
