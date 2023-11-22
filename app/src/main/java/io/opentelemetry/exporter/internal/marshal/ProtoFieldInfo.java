package io.opentelemetry.exporter.internal.marshal;

/* loaded from: classes9.dex */
public abstract class ProtoFieldInfo {
    public abstract int getFieldNumber();

    public abstract String getJsonName();

    public abstract int getTag();

    public abstract int getTagSize();

    public static ProtoFieldInfo create(int i, int i2, String str) {
        return new AutoValue_ProtoFieldInfo(i, i2, CodedOutputStream.computeTagSize(i), str);
    }
}
