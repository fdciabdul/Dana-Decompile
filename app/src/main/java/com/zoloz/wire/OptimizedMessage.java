package com.zoloz.wire;

import java.lang.reflect.Field;

/* loaded from: classes8.dex */
public abstract class OptimizedMessage extends Message {
    protected OptimizedMessage(Message message) {
        super(message);
        if (message == null) {
            return;
        }
        for (Field field : message.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (((ProtoField) field.getAnnotation(ProtoField.class)) != null) {
                    field.set(this, field.get(message));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected OptimizedMessage() {
    }

    public Message fillTagValue(int i, Object obj) {
        for (Field field : getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
                if (protoField != null && i == protoField.tag()) {
                    field.set(this, obj);
                    return this;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Message) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    if (((ProtoField) field.getAnnotation(ProtoField.class)) != null) {
                        field.get(obj);
                        field.get(this);
                        return false;
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Field[] declaredFields = getClass().getDeclaredFields();
            for (int i2 = 0; i2 < declaredFields.length; i2++) {
                try {
                    Field field = declaredFields[i2];
                    field.setAccessible(true);
                    if (((ProtoField) field.getAnnotation(ProtoField.class)) != null) {
                        Object obj = field.get(this);
                        if (i2 == 0) {
                            i += obj != null ? obj.hashCode() : 0;
                        } else {
                            i = (i * 37) + (obj != null ? obj.hashCode() : 1);
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            this.hashCode = i;
        }
        return i;
    }
}
