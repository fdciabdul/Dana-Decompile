package io.opentelemetry.sdk.common;

import java.util.Objects;
import javax.annotation.Nullable;

@Deprecated
/* loaded from: classes9.dex */
public abstract class InstrumentationLibraryInfo {
    private static final InstrumentationLibraryInfo EMPTY = create("", null);

    public abstract String getName();

    @Nullable
    public abstract String getSchemaUrl();

    @Nullable
    public abstract String getVersion();

    public static InstrumentationLibraryInfo create(String str, @Nullable String str2) {
        Objects.requireNonNull(str, "name");
        return new AutoValue_InstrumentationLibraryInfo(str, str2, null);
    }

    public static InstrumentationLibraryInfo create(String str, @Nullable String str2, @Nullable String str3) {
        Objects.requireNonNull(str, "name");
        return new AutoValue_InstrumentationLibraryInfo(str, str2, str3);
    }

    public static InstrumentationLibraryInfo empty() {
        return EMPTY;
    }
}
