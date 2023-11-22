package com.squareup.wire;

import com.squareup.wire.Message;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class Redactor<T extends Message> {
    private static final Redactor<?> NOOP_REDACTOR;
    private static final Map<Class<? extends Message>, Redactor> redactors = new LinkedHashMap();
    private final Constructor<?> builderConstructor;
    private final List<Field> messageFields;
    private final List<Redactor<?>> messageRedactors;
    private final List<Field> redactedFields;

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, java.lang.reflect.Constructor] */
    static {
        ?? r1 = 0;
        NOOP_REDACTOR = new Redactor<Message>(r1, r1, r1, r1) { // from class: com.squareup.wire.Redactor.1
            @Override // com.squareup.wire.Redactor
            public final Message redact(Message message) {
                return message;
            }
        };
    }

    Redactor(Constructor<?> constructor, List<Field> list, List<Field> list2, List<Redactor<?>> list3) {
        this.builderConstructor = constructor;
        this.redactedFields = list;
        this.messageFields = list2;
        this.messageRedactors = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Message> Redactor<T> get(Class<T> cls) {
        Redactor redactor;
        Redactor<?> redactor2;
        synchronized (Redactor.class) {
            Map<Class<? extends Message>, Redactor> map = redactors;
            Redactor redactor3 = map.get(cls);
            if (redactor3 != null) {
                return redactor3;
            }
            FutureRedactor futureRedactor = new FutureRedactor();
            map.put(cls, futureRedactor);
            try {
                try {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (Field field : cls.getDeclaredFields()) {
                        if (!Modifier.isStatic(field.getModifiers())) {
                            ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
                            if (protoField != null && protoField.redacted()) {
                                if (protoField.label() == Message.Label.REQUIRED) {
                                    throw new IllegalArgumentException(String.format("Field %s is REQUIRED and cannot be redacted.", field));
                                }
                                arrayList.add(field);
                            } else if (Message.class.isAssignableFrom(field.getType()) && (redactor2 = get(field.getType())) != NOOP_REDACTOR) {
                                arrayList2.add(field);
                                arrayList3.add(redactor2);
                            }
                        }
                    }
                    if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                        redactor = NOOP_REDACTOR;
                    } else {
                        redactor = new Redactor(cls.getConstructor(cls), arrayList, arrayList2, arrayList3);
                    }
                    futureRedactor.setDelegate(redactor);
                    redactors.put(cls, redactor);
                    return redactor;
                } catch (Exception e) {
                    throw new AssertionError(e);
                }
            } catch (RuntimeException e2) {
                throw e2;
            }
        }
    }

    public T redact(T t) {
        if (t == null) {
            return null;
        }
        try {
            T t2 = (T) this.builderConstructor.newInstance(t);
            Iterator<Field> it = this.redactedFields.iterator();
            while (it.hasNext()) {
                it.next().set(t2, null);
            }
            for (int i = 0; i < this.messageFields.size(); i++) {
                Field field = this.messageFields.get(i);
                field.set(t2, this.messageRedactors.get(i).redact((Message) field.get(t2)));
            }
            return t2;
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /* loaded from: classes8.dex */
    static class FutureRedactor<T extends Message> extends Redactor<T> {
        private Redactor<T> delegate;

        public FutureRedactor() {
            super(null, null, null, null);
        }

        public void setDelegate(Redactor<T> redactor) {
            this.delegate = redactor;
        }

        @Override // com.squareup.wire.Redactor
        public T redact(T t) {
            Redactor<T> redactor = this.delegate;
            if (redactor == null) {
                throw new IllegalStateException("Delegate was not set.");
            }
            return redactor.redact(t);
        }
    }
}
