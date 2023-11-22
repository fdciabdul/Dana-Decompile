package com.squareup.wire;

import com.squareup.wire.Message;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Source;

/* loaded from: classes3.dex */
public final class Wire {
    private final Map<Class<? extends Message>, AvailabilityChecker<? extends Message>> availabilityCheckers;
    private final Map<Class<? extends Message.Builder>, BuilderAdapter<? extends Message.Builder>> builderAdapters;
    private final Map<Class<? extends ProtoEnum>, EnumAdapter<? extends ProtoEnum>> enumAdapters;
    private final Map<Class<? extends Message>, MessageAdapter<? extends Message>> messageAdapters;
    final ExtensionRegistry registry;

    public static <T> T get(T t, T t2) {
        return t == null ? t2 : t;
    }

    public Wire(Class<?>... clsArr) {
        this(Arrays.asList(clsArr));
    }

    public Wire(List<Class<?>> list) {
        this.messageAdapters = new LinkedHashMap();
        this.builderAdapters = new LinkedHashMap();
        this.enumAdapters = new LinkedHashMap();
        this.availabilityCheckers = new LinkedHashMap();
        this.registry = new ExtensionRegistry();
        Iterator<Class<?>> it = list.iterator();
        while (it.hasNext()) {
            for (Field field : it.next().getDeclaredFields()) {
                if (field.getType().equals(Extension.class)) {
                    try {
                        this.registry.add((Extension) field.get(null));
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <M extends Message> MessageAdapter<M> messageAdapter(Class<M> cls) {
        MessageAdapter<M> messageAdapter;
        synchronized (this) {
            messageAdapter = (MessageAdapter<M>) this.messageAdapters.get(cls);
            if (messageAdapter == null) {
                messageAdapter = new MessageAdapter<>(this, cls);
                this.messageAdapters.put(cls, messageAdapter);
            }
        }
        return messageAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <B extends Message.Builder> BuilderAdapter<B> builderAdapter(Class<B> cls) {
        BuilderAdapter<B> builderAdapter;
        synchronized (this) {
            builderAdapter = (BuilderAdapter<B>) this.builderAdapters.get(cls);
            if (builderAdapter == null) {
                builderAdapter = new BuilderAdapter<>(cls);
                this.builderAdapters.put(cls, builderAdapter);
            }
        }
        return builderAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T extends Message> AvailabilityChecker<T> availabilityChecker(Class<T> cls) {
        AvailabilityChecker<T> availabilityChecker;
        synchronized (this) {
            availabilityChecker = (AvailabilityChecker<T>) this.availabilityCheckers.get(cls);
            if (availabilityChecker == null) {
                availabilityChecker = new AvailabilityChecker<>(cls);
                this.availabilityCheckers.put(cls, availabilityChecker);
            }
        }
        return availabilityChecker;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <E extends ProtoEnum> EnumAdapter<E> enumAdapter(Class<E> cls) {
        EnumAdapter<E> enumAdapter;
        synchronized (this) {
            enumAdapter = (EnumAdapter<E>) this.enumAdapters.get(cls);
            if (enumAdapter == null) {
                enumAdapter = new EnumAdapter<>(cls);
                this.enumAdapters.put(cls, enumAdapter);
            }
        }
        return enumAdapter;
    }

    public final <M extends Message> M parseFrom(byte[] bArr, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(bArr, "bytes");
        Preconditions.checkNotNull(cls, "messageClass");
        M m = (M) parseFrom(WireInput.newInstance(bArr), cls);
        m.checkAvailability();
        return m;
    }

    public final <M extends Message> M parseFrom(byte[] bArr, int i, int i2, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(bArr, "bytes");
        Preconditions.checkArgument(i >= 0, "offset < 0");
        Preconditions.checkArgument(i2 >= 0, "count < 0");
        Preconditions.checkArgument(i + i2 <= bArr.length, "offset + count > bytes");
        Preconditions.checkNotNull(cls, "messageClass");
        return (M) parseFrom(WireInput.newInstance(bArr, i, i2), cls);
    }

    public final <M extends Message> M parseFrom(InputStream inputStream, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(inputStream, "input");
        Preconditions.checkNotNull(cls, "messageClass");
        return (M) parseFrom(WireInput.newInstance(inputStream), cls);
    }

    public final <M extends Message> M parseFrom(Source source, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(source, "input");
        Preconditions.checkNotNull(cls, "messageClass");
        return (M) parseFrom(WireInput.newInstance(source), cls);
    }

    private <M extends Message> M parseFrom(WireInput wireInput, Class<M> cls) throws IOException {
        return messageAdapter(cls).read(wireInput);
    }
}
