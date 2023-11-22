package io.opentelemetry.sdk.common;

import io.opentelemetry.api.common.Attributes;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
final class AutoValue_InstrumentationScopeInfo extends InstrumentationScopeInfo {
    private final Attributes attributes;
    private final String name;
    private final String schemaUrl;
    private final String version;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_InstrumentationScopeInfo(String str, @Nullable String str2, @Nullable String str3, Attributes attributes) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        this.version = str2;
        this.schemaUrl = str3;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationScopeInfo
    public final String getName() {
        return this.name;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationScopeInfo
    @Nullable
    public final String getVersion() {
        return this.version;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationScopeInfo
    @Nullable
    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationScopeInfo
    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InstrumentationScopeInfo{name=");
        sb.append(this.name);
        sb.append(", version=");
        sb.append(this.version);
        sb.append(", schemaUrl=");
        sb.append(this.schemaUrl);
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstrumentationScopeInfo) {
            InstrumentationScopeInfo instrumentationScopeInfo = (InstrumentationScopeInfo) obj;
            return this.name.equals(instrumentationScopeInfo.getName()) && ((str = this.version) != null ? str.equals(instrumentationScopeInfo.getVersion()) : instrumentationScopeInfo.getVersion() == null) && ((str2 = this.schemaUrl) != null ? str2.equals(instrumentationScopeInfo.getSchemaUrl()) : instrumentationScopeInfo.getSchemaUrl() == null) && this.attributes.equals(instrumentationScopeInfo.getAttributes());
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.name.hashCode();
        String str = this.version;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.schemaUrl;
        return ((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ (str2 != null ? str2.hashCode() : 0)) * 1000003) ^ this.attributes.hashCode();
    }
}
