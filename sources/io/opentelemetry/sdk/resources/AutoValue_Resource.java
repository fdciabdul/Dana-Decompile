package io.opentelemetry.sdk.resources;

import io.opentelemetry.api.common.Attributes;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_Resource extends Resource {
    private final Attributes attributes;
    private final String schemaUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Resource(@Nullable String str, Attributes attributes) {
        this.schemaUrl = str;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
    }

    @Override // io.opentelemetry.sdk.resources.Resource
    @Nullable
    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    @Override // io.opentelemetry.sdk.resources.Resource
    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resource{schemaUrl=");
        sb.append(this.schemaUrl);
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Resource) {
            Resource resource = (Resource) obj;
            String str = this.schemaUrl;
            if (str != null ? str.equals(resource.getSchemaUrl()) : resource.getSchemaUrl() == null) {
                if (this.attributes.equals(resource.getAttributes())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.schemaUrl;
        return (((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.attributes.hashCode();
    }
}
