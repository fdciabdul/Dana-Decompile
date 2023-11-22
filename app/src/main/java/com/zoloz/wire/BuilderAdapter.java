package com.zoloz.wire;

import com.zoloz.wire.Message;
import com.zoloz.wire.Message.Builder;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class BuilderAdapter<B extends Message.Builder> {
    private static final Comparator<Field> ORDER_BY_FIELD_NAME = new Comparator<Field>() { // from class: com.zoloz.wire.BuilderAdapter.1
        @Override // java.util.Comparator
        public final int compare(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }
    };
    private static final int SUFFIX_LENGTH = 8;
    private final List<Field> requiredFields = new ArrayList();

    public BuilderAdapter(Class<B> cls) {
        String name = cls.getName();
        try {
            for (Field field : Class.forName(name.substring(0, name.length() - SUFFIX_LENGTH), true, cls.getClassLoader()).getDeclaredFields()) {
                ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
                if (protoField != null && protoField.label() == Message.Label.REQUIRED) {
                    try {
                        this.requiredFields.add(cls.getField(field.getName()));
                    } catch (NoSuchFieldException unused) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("No builder field found for message field ");
                        sb.append(field.getName());
                        throw new AssertionError(sb.toString());
                    }
                }
            }
            Collections.sort(this.requiredFields, ORDER_BY_FIELD_NAME);
        } catch (ClassNotFoundException unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No message class found for builder type ");
            sb2.append(name);
            throw new AssertionError(sb2.toString());
        }
    }

    public final <B extends Message.Builder> void checkRequiredFields(B b) {
        try {
            int size = this.requiredFields.size();
            StringBuilder sb = null;
            String str = "";
            for (int i = 0; i < size; i++) {
                Field field = this.requiredFields.get(i);
                if (field.get(b) == null) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    } else {
                        str = "s";
                    }
                    sb.append("\n  ");
                    sb.append(field.getName());
                }
            }
            if (sb == null) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Required field");
            sb2.append(str);
            sb2.append(" not set:");
            sb2.append((Object) sb);
            throw new IllegalStateException(sb2.toString());
        } catch (IllegalAccessException unused) {
            throw new AssertionError("Unable to access required fields");
        }
    }
}
