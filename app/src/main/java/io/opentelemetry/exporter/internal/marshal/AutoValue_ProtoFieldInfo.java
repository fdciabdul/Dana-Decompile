package io.opentelemetry.exporter.internal.marshal;

/* loaded from: classes9.dex */
final class AutoValue_ProtoFieldInfo extends ProtoFieldInfo {
    private final int fieldNumber;
    private final String jsonName;
    private final int tag;
    private final int tagSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ProtoFieldInfo(int i, int i2, int i3, String str) {
        this.fieldNumber = i;
        this.tag = i2;
        this.tagSize = i3;
        if (str == null) {
            throw new NullPointerException("Null jsonName");
        }
        this.jsonName = str;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.ProtoFieldInfo
    public final int getFieldNumber() {
        return this.fieldNumber;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.ProtoFieldInfo
    public final int getTag() {
        return this.tag;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.ProtoFieldInfo
    public final int getTagSize() {
        return this.tagSize;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.ProtoFieldInfo
    public final String getJsonName() {
        return this.jsonName;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProtoFieldInfo{fieldNumber=");
        sb.append(this.fieldNumber);
        sb.append(", tag=");
        sb.append(this.tag);
        sb.append(", tagSize=");
        sb.append(this.tagSize);
        sb.append(", jsonName=");
        sb.append(this.jsonName);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProtoFieldInfo) {
            ProtoFieldInfo protoFieldInfo = (ProtoFieldInfo) obj;
            return this.fieldNumber == protoFieldInfo.getFieldNumber() && this.tag == protoFieldInfo.getTag() && this.tagSize == protoFieldInfo.getTagSize() && this.jsonName.equals(protoFieldInfo.getJsonName());
        }
        return false;
    }

    public final int hashCode() {
        int i = this.fieldNumber;
        return ((((((i ^ 1000003) * 1000003) ^ this.tag) * 1000003) ^ this.tagSize) * 1000003) ^ this.jsonName.hashCode();
    }
}
