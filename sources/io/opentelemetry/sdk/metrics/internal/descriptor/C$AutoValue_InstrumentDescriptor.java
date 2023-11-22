package io.opentelemetry.sdk.metrics.internal.descriptor;

import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.InstrumentValueType;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: io.opentelemetry.sdk.metrics.internal.descriptor.$AutoValue_InstrumentDescriptor  reason: invalid class name */
/* loaded from: classes6.dex */
public abstract class C$AutoValue_InstrumentDescriptor extends InstrumentDescriptor {
    private final String description;
    private final String name;
    private final InstrumentType type;
    private final String unit;
    private final InstrumentValueType valueType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C$AutoValue_InstrumentDescriptor(String str, String str2, String str3, InstrumentType instrumentType, InstrumentValueType instrumentValueType) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        if (str2 == null) {
            throw new NullPointerException("Null description");
        }
        this.description = str2;
        if (str3 == null) {
            throw new NullPointerException("Null unit");
        }
        this.unit = str3;
        if (instrumentType == null) {
            throw new NullPointerException("Null type");
        }
        this.type = instrumentType;
        if (instrumentValueType == null) {
            throw new NullPointerException("Null valueType");
        }
        this.valueType = instrumentValueType;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public String getName() {
        return this.name;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public String getDescription() {
        return this.description;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public String getUnit() {
        return this.unit;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public InstrumentType getType() {
        return this.type;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public InstrumentValueType getValueType() {
        return this.valueType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InstrumentDescriptor{name=");
        sb.append(this.name);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", unit=");
        sb.append(this.unit);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", valueType=");
        sb.append(this.valueType);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstrumentDescriptor) {
            InstrumentDescriptor instrumentDescriptor = (InstrumentDescriptor) obj;
            return this.name.equals(instrumentDescriptor.getName()) && this.description.equals(instrumentDescriptor.getDescription()) && this.unit.equals(instrumentDescriptor.getUnit()) && this.type.equals(instrumentDescriptor.getType()) && this.valueType.equals(instrumentDescriptor.getValueType());
        }
        return false;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public int hashCode() {
        int hashCode = this.name.hashCode();
        int hashCode2 = this.description.hashCode();
        return ((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ this.unit.hashCode()) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.valueType.hashCode();
    }
}
