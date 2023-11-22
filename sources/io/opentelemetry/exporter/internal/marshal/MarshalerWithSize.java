package io.opentelemetry.exporter.internal.marshal;

/* loaded from: classes9.dex */
public abstract class MarshalerWithSize extends Marshaler {
    private final int size;

    protected MarshalerWithSize(int i) {
        this.size = i;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Marshaler
    public final int getBinarySerializedSize() {
        return this.size;
    }
}
