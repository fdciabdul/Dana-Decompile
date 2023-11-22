package io.opentelemetry.exporter.internal.marshal;

/* loaded from: classes9.dex */
final class AutoValue_ProtoEnumInfo extends ProtoEnumInfo {
    private final int enumNumber;
    private final String jsonName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ProtoEnumInfo(int i, String str) {
        this.enumNumber = i;
        if (str == null) {
            throw new NullPointerException("Null jsonName");
        }
        this.jsonName = str;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.ProtoEnumInfo
    public final int getEnumNumber() {
        return this.enumNumber;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.ProtoEnumInfo
    public final String getJsonName() {
        return this.jsonName;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProtoEnumInfo{enumNumber=");
        sb.append(this.enumNumber);
        sb.append(", jsonName=");
        sb.append(this.jsonName);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProtoEnumInfo) {
            ProtoEnumInfo protoEnumInfo = (ProtoEnumInfo) obj;
            return this.enumNumber == protoEnumInfo.getEnumNumber() && this.jsonName.equals(protoEnumInfo.getJsonName());
        }
        return false;
    }

    public final int hashCode() {
        return ((this.enumNumber ^ 1000003) * 1000003) ^ this.jsonName.hashCode();
    }
}
