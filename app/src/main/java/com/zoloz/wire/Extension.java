package com.zoloz.wire;

import com.zoloz.wire.ExtendableMessage;
import com.zoloz.wire.Message;
import java.util.List;
import okio.ByteString;

/* loaded from: classes8.dex */
public final class Extension<T extends ExtendableMessage<?>, E> implements Comparable<Extension<?, ?>> {
    private final Message.Datatype datatype;
    private final Class<? extends ProtoEnum> enumType;
    private final Class<T> extendedType;
    private final Message.Label label;
    private final Class<? extends Message> messageType;
    private final String name;
    private final int tag;

    /* loaded from: classes8.dex */
    public static final class Builder<T extends ExtendableMessage<?>, E> {
        private final Message.Datatype datatype;
        private final Class<? extends ProtoEnum> enumType;
        private final Class<T> extendedType;
        private Message.Label label;
        private final Class<? extends Message> messageType;
        private String name;
        private int tag;

        private Builder(Class<T> cls, Message.Datatype datatype) {
            this.name = null;
            this.tag = -1;
            this.label = null;
            this.extendedType = cls;
            this.messageType = null;
            this.enumType = null;
            this.datatype = datatype;
        }

        private Builder(Class<T> cls, Class<? extends Message> cls2, Class<? extends ProtoEnum> cls3, Message.Datatype datatype) {
            this.name = null;
            this.tag = -1;
            this.label = null;
            this.extendedType = cls;
            this.messageType = cls2;
            this.enumType = cls3;
            this.datatype = datatype;
        }

        public final Builder<T, E> setName(String str) {
            this.name = str;
            return this;
        }

        public final Builder<T, E> setTag(int i) {
            this.tag = i;
            return this;
        }

        public final Extension<T, E> buildOptional() {
            this.label = Message.Label.OPTIONAL;
            validate();
            return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype);
        }

        public final Extension<T, E> buildRequired() {
            this.label = Message.Label.REQUIRED;
            validate();
            return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype);
        }

        public final Extension<T, List<E>> buildRepeated() {
            this.label = Message.Label.REPEATED;
            validate();
            return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype);
        }

        public final Extension<T, List<E>> buildPacked() {
            this.label = Message.Label.PACKED;
            validate();
            return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype);
        }

        private void validate() {
            if (this.extendedType == null) {
                throw new IllegalArgumentException("extendedType == null");
            }
            if (this.name == null) {
                throw new IllegalArgumentException("name == null");
            }
            Message.Datatype datatype = this.datatype;
            if (datatype == null) {
                throw new IllegalArgumentException("datatype == null");
            }
            if (this.label == null) {
                throw new IllegalArgumentException("label == null");
            }
            if (this.tag <= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("tag == ");
                sb.append(this.tag);
                throw new IllegalArgumentException(sb.toString());
            } else if (datatype == Message.Datatype.MESSAGE) {
                if (this.messageType == null || this.enumType != null) {
                    throw new IllegalStateException("Message w/o messageType or w/ enumType");
                }
            } else if (this.datatype == Message.Datatype.ENUM) {
                if (this.messageType != null || this.enumType == null) {
                    throw new IllegalStateException("Enum w/ messageType or w/o enumType");
                }
            } else if (this.messageType != null || this.enumType != null) {
                throw new IllegalStateException("Scalar w/ messageType or enumType");
            }
        }
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> int32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.INT32);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> sint32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.SINT32);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> uint32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.UINT32);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> fixed32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.FIXED32);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> sfixed32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.SFIXED32);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> int64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.INT64);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> sint64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.SINT64);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> uint64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.UINT64);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> fixed64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.FIXED64);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> sfixed64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.SFIXED64);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Boolean> boolExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.BOOL);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, String> stringExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.STRING);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, ByteString> bytesExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.BYTES);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Float> floatExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.FLOAT);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Double> doubleExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.DOUBLE);
    }

    public static <T extends ExtendableMessage<?>, E extends Enum & ProtoEnum> Builder<T, E> enumExtending(Class<E> cls, Class<T> cls2) {
        return new Builder<>(cls2, null, cls, Message.Datatype.ENUM);
    }

    public static <T extends ExtendableMessage<?>, M extends Message> Builder<T, M> messageExtending(Class<M> cls, Class<T> cls2) {
        return new Builder<>(cls2, cls, null, Message.Datatype.MESSAGE);
    }

    private Extension(Class<T> cls, Class<? extends Message> cls2, Class<? extends ProtoEnum> cls3, String str, int i, Message.Label label, Message.Datatype datatype) {
        this.extendedType = cls;
        this.name = str;
        this.tag = i;
        this.datatype = datatype;
        this.label = label;
        this.messageType = cls2;
        this.enumType = cls3;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Extension<?, ?> extension) {
        int value;
        int value2;
        if (extension == this) {
            return 0;
        }
        int i = this.tag;
        int i2 = extension.tag;
        if (i != i2) {
            return i - i2;
        }
        Message.Datatype datatype = this.datatype;
        if (datatype != extension.datatype) {
            value = datatype.value();
            value2 = extension.datatype.value();
        } else {
            Message.Label label = this.label;
            if (label != extension.label) {
                value = label.value();
                value2 = extension.label.value();
            } else {
                Class<T> cls = this.extendedType;
                if (cls != null && !cls.equals(extension.extendedType)) {
                    return this.extendedType.getName().compareTo(extension.extendedType.getName());
                }
                Class<? extends Message> cls2 = this.messageType;
                if (cls2 != null && !cls2.equals(extension.messageType)) {
                    return this.messageType.getName().compareTo(extension.messageType.getName());
                }
                Class<? extends ProtoEnum> cls3 = this.enumType;
                if (cls3 == null || cls3.equals(extension.enumType)) {
                    return 0;
                }
                return this.enumType.getName().compareTo(extension.enumType.getName());
            }
        }
        return value - value2;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Extension) && compareTo((Extension) obj) == 0;
    }

    public final int hashCode() {
        int i = this.tag;
        int value = this.datatype.value();
        int value2 = this.label.value();
        int hashCode = this.extendedType.hashCode();
        Class<? extends Message> cls = this.messageType;
        int hashCode2 = cls != null ? cls.hashCode() : 0;
        Class<? extends ProtoEnum> cls2 = this.enumType;
        return (((((((((i * 37) + value) * 37) + value2) * 37) + hashCode) * 37) + hashCode2) * 37) + (cls2 != null ? cls2.hashCode() : 0);
    }

    public final String toString() {
        return String.format("[%s %s %s = %d]", this.label, this.datatype, this.name, Integer.valueOf(this.tag));
    }

    public final Class<T> getExtendedType() {
        return this.extendedType;
    }

    public final Class<? extends Message> getMessageType() {
        return this.messageType;
    }

    public final Class<? extends ProtoEnum> getEnumType() {
        return this.enumType;
    }

    public final String getName() {
        return this.name;
    }

    public final int getTag() {
        return this.tag;
    }

    public final Message.Datatype getDatatype() {
        return this.datatype;
    }

    public final Message.Label getLabel() {
        return this.label;
    }
}
