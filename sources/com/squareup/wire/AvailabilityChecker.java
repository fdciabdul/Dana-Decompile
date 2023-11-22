package com.squareup.wire;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class AvailabilityChecker<M extends Message> {
    private static final Comparator<Field> ORDER_BY_FIELD_NAME = new Comparator<Field>() { // from class: com.squareup.wire.AvailabilityChecker.1
        @Override // java.util.Comparator
        public final int compare(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }
    };
    private final List<Field> requiredFields = new ArrayList();
    private final List<Field> collectionFields = new ArrayList();

    public AvailabilityChecker(Class<M> cls) {
        for (Field field : cls.getDeclaredFields()) {
            ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
            if (protoField != null) {
                if (protoField.label() == Message.Label.REQUIRED) {
                    try {
                        this.requiredFields.add(cls.getField(field.getName()));
                    } catch (NoSuchFieldException unused) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("No message field found for message field ");
                        sb.append(field.getName());
                        throw new AssertionError(sb.toString());
                    }
                }
                if (protoField.label() == Message.Label.REPEATED) {
                    try {
                        this.collectionFields.add(cls.getField(field.getName()));
                    } catch (NoSuchFieldException unused2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("No message field found for message field ");
                        sb2.append(field.getName());
                        throw new AssertionError(sb2.toString());
                    }
                } else {
                    continue;
                }
            }
        }
        Collections.sort(this.requiredFields, ORDER_BY_FIELD_NAME);
    }

    public final void checkRequiredFields(M m) {
        try {
            int size = this.requiredFields.size();
            StringBuilder sb = null;
            String str = "";
            for (int i = 0; i < size; i++) {
                Field field = this.requiredFields.get(i);
                if (field.get(m) == null) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkForNulls(M m) {
        for (Field field : this.collectionFields) {
            try {
                List list = (List) field.get(m);
                if (list != null) {
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            if (list.get(i) == null) {
                                throw new NullPointerException(String.format("Element at index %d of field %s is null", Integer.valueOf(i), field.getName()));
                            }
                        }
                    }
                } else {
                    field.set(m, Collections.emptyList());
                }
            } catch (IllegalAccessException unused) {
                throw new AssertionError("Unable to access required fields");
            } catch (IllegalArgumentException unused2) {
                throw new AssertionError("Unable to access required fields");
            }
        }
    }
}
