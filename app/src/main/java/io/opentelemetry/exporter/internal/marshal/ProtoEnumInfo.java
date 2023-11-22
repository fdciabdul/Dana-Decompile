package io.opentelemetry.exporter.internal.marshal;

/* loaded from: classes9.dex */
public abstract class ProtoEnumInfo {
    public abstract int getEnumNumber();

    public abstract String getJsonName();

    public static ProtoEnumInfo create(int i, String str) {
        return new AutoValue_ProtoEnumInfo(i, str);
    }
}
