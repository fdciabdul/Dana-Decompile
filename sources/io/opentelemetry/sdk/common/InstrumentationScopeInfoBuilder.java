package io.opentelemetry.sdk.common;

import io.opentelemetry.api.common.Attributes;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class InstrumentationScopeInfoBuilder {
    @Nullable
    private Attributes attributes;
    private final String name;
    @Nullable
    private String schemaUrl;
    @Nullable
    private String version;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstrumentationScopeInfoBuilder(String str) {
        this.name = str;
    }

    public final InstrumentationScopeInfoBuilder setVersion(String str) {
        this.version = str;
        return this;
    }

    public final InstrumentationScopeInfoBuilder setSchemaUrl(String str) {
        this.schemaUrl = str;
        return this;
    }

    public final InstrumentationScopeInfoBuilder setAttributes(Attributes attributes) {
        this.attributes = attributes;
        return this;
    }

    public final InstrumentationScopeInfo build() {
        String str = this.name;
        String str2 = this.version;
        String str3 = this.schemaUrl;
        Attributes attributes = this.attributes;
        if (attributes == null) {
            attributes = Attributes.CC.empty();
        }
        return InstrumentationScopeInfo.create(str, str2, str3, attributes);
    }
}
