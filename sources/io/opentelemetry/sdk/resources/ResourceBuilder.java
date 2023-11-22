package io.opentelemetry.sdk.resources;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import j$.util.function.Predicate;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class ResourceBuilder {
    private final AttributesBuilder attributesBuilder = Attributes.CC.builder();
    @Nullable
    private String schemaUrl;

    public ResourceBuilder put(String str, String str2) {
        if (str != null && str2 != null) {
            this.attributesBuilder.put(str, str2);
        }
        return this;
    }

    public ResourceBuilder put(String str, long j) {
        if (str != null) {
            this.attributesBuilder.put(str, j);
        }
        return this;
    }

    public ResourceBuilder put(String str, double d) {
        if (str != null) {
            this.attributesBuilder.put(str, d);
        }
        return this;
    }

    public ResourceBuilder put(String str, boolean z) {
        if (str != null) {
            this.attributesBuilder.put(str, z);
        }
        return this;
    }

    public ResourceBuilder put(String str, String... strArr) {
        if (str != null && strArr != null) {
            this.attributesBuilder.put(str, strArr);
        }
        return this;
    }

    public ResourceBuilder put(String str, long... jArr) {
        if (str != null && jArr != null) {
            this.attributesBuilder.put(str, jArr);
        }
        return this;
    }

    public ResourceBuilder put(String str, double... dArr) {
        if (str != null && dArr != null) {
            this.attributesBuilder.put(str, dArr);
        }
        return this;
    }

    public ResourceBuilder put(String str, boolean... zArr) {
        if (str != null && zArr != null) {
            this.attributesBuilder.put(str, zArr);
        }
        return this;
    }

    public <T> ResourceBuilder put(AttributeKey<T> attributeKey, T t) {
        if (attributeKey != null && attributeKey.getKey() != null && !attributeKey.getKey().isEmpty() && t != null) {
            this.attributesBuilder.put((AttributeKey<AttributeKey<T>>) attributeKey, (AttributeKey<T>) t);
        }
        return this;
    }

    public ResourceBuilder put(AttributeKey<Long> attributeKey, int i) {
        if (attributeKey != null && attributeKey.getKey() != null && !attributeKey.getKey().isEmpty()) {
            this.attributesBuilder.put(attributeKey, i);
        }
        return this;
    }

    public ResourceBuilder putAll(Attributes attributes) {
        if (attributes != null) {
            this.attributesBuilder.putAll(attributes);
        }
        return this;
    }

    public ResourceBuilder putAll(Resource resource) {
        if (resource != null) {
            this.attributesBuilder.putAll(resource.getAttributes());
        }
        return this;
    }

    public ResourceBuilder removeIf(Predicate<AttributeKey<?>> predicate) {
        this.attributesBuilder.removeIf(predicate);
        return this;
    }

    public ResourceBuilder setSchemaUrl(String str) {
        this.schemaUrl = str;
        return this;
    }

    public Resource build() {
        return Resource.create(this.attributesBuilder.build(), this.schemaUrl);
    }
}
