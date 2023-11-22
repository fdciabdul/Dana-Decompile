package io.opentelemetry.sdk.common;

import javax.annotation.Nullable;

@Deprecated
/* loaded from: classes9.dex */
final class AutoValue_InstrumentationLibraryInfo extends InstrumentationLibraryInfo {
    private final String name;
    private final String schemaUrl;
    private final String version;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_InstrumentationLibraryInfo(String str, @Nullable String str2, @Nullable String str3) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        this.version = str2;
        this.schemaUrl = str3;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationLibraryInfo
    public final String getName() {
        return this.name;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationLibraryInfo
    @Nullable
    public final String getVersion() {
        return this.version;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationLibraryInfo
    @Nullable
    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InstrumentationLibraryInfo{name=");
        sb.append(this.name);
        sb.append(", version=");
        sb.append(this.version);
        sb.append(", schemaUrl=");
        sb.append(this.schemaUrl);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstrumentationLibraryInfo) {
            InstrumentationLibraryInfo instrumentationLibraryInfo = (InstrumentationLibraryInfo) obj;
            if (this.name.equals(instrumentationLibraryInfo.getName()) && ((str = this.version) != null ? str.equals(instrumentationLibraryInfo.getVersion()) : instrumentationLibraryInfo.getVersion() == null)) {
                String str2 = this.schemaUrl;
                if (str2 == null) {
                    if (instrumentationLibraryInfo.getSchemaUrl() == null) {
                        return true;
                    }
                } else if (str2.equals(instrumentationLibraryInfo.getSchemaUrl())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.name.hashCode();
        String str = this.version;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.schemaUrl;
        return ((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ (str2 != null ? str2.hashCode() : 0);
    }
}
