package com.google.firebase.encoders;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class FieldDescriptor {
    private final String name;
    private final Map<Class<?>, Object> properties;

    private FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.name = str;
        this.properties = map;
    }

    public final String getName() {
        return this.name;
    }

    public final <T extends Annotation> T getProperty(Class<T> cls) {
        return (T) this.properties.get(cls);
    }

    public static FieldDescriptor of(String str) {
        return new FieldDescriptor(str, Collections.emptyMap());
    }

    public static Builder builder(String str) {
        return new Builder(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldDescriptor) {
            FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
            return this.name.equals(fieldDescriptor.name) && this.properties.equals(fieldDescriptor.properties);
        }
        return false;
    }

    public final int hashCode() {
        return (this.name.hashCode() * 31) + this.properties.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FieldDescriptor{name=");
        sb.append(this.name);
        sb.append(", properties=");
        sb.append(this.properties.values());
        sb.append("}");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private final String name;
        private Map<Class<?>, Object> properties = null;

        Builder(String str) {
            this.name = str;
        }

        public final <T extends Annotation> Builder withProperty(T t) {
            if (this.properties == null) {
                this.properties = new HashMap();
            }
            this.properties.put(t.annotationType(), t);
            return this;
        }

        public final FieldDescriptor build() {
            Map unmodifiableMap;
            String str = this.name;
            if (this.properties == null) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(new HashMap(this.properties));
            }
            return new FieldDescriptor(str, unmodifiableMap);
        }
    }
}
