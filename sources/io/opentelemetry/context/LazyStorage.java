package io.opentelemetry.context;

import io.opentelemetry.context.ContextStorage;
import j$.util.function.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class LazyStorage {
    private static final String CONTEXT_STORAGE_PROVIDER_PROPERTY = "io.opentelemetry.context.contextStorageProvider";
    private static final String ENABLE_STRICT_CONTEXT_PROVIDER_PROPERTY = "io.opentelemetry.context.enableStrictContext";
    private static final String ENFORCE_DEFAULT_STORAGE_VALUE = "default";
    private static final Logger logger = Logger.getLogger(LazyStorage.class.getName());
    private static final ContextStorage storage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContextStorage get() {
        return storage;
    }

    static {
        AtomicReference atomicReference = new AtomicReference();
        ContextStorage createStorage = createStorage(atomicReference);
        if (Boolean.getBoolean(ENABLE_STRICT_CONTEXT_PROVIDER_PROPERTY)) {
            createStorage = StrictContextStorage.create(createStorage);
        }
        Iterator<Function<? super ContextStorage, ? extends ContextStorage>> it = ContextStorageWrappers.getWrappers().iterator();
        while (it.hasNext()) {
            createStorage = it.next().apply(createStorage);
        }
        storage = createStorage;
        ContextStorageWrappers.setStorageInitialized();
        Throwable th = (Throwable) atomicReference.get();
        if (th != null) {
            logger.log(Level.WARNING, "ContextStorageProvider initialized failed. Using default", th);
        }
    }

    static ContextStorage createStorage(AtomicReference<Throwable> atomicReference) {
        String property = System.getProperty(CONTEXT_STORAGE_PROVIDER_PROPERTY, "");
        if ("default".equals(property)) {
            return ContextStorage.CC.defaultStorage();
        }
        ArrayList<ContextStorageProvider> arrayList = new ArrayList();
        Iterator it = ServiceLoader.load(ContextStorageProvider.class).iterator();
        while (it.hasNext()) {
            ContextStorageProvider contextStorageProvider = (ContextStorageProvider) it.next();
            if (contextStorageProvider.getClass().getName().equals("io.opentelemetry.sdk.testing.context.SettableContextStorageProvider")) {
                return contextStorageProvider.get();
            }
            arrayList.add(contextStorageProvider);
        }
        if (arrayList.isEmpty()) {
            return ContextStorage.CC.defaultStorage();
        }
        if (property.isEmpty()) {
            if (arrayList.size() == 1) {
                return ((ContextStorageProvider) arrayList.get(0)).get();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Found multiple ContextStorageProvider. Set the io.opentelemetry.context.ContextStorageProvider property to the fully qualified class name of the provider to use. Falling back to default ContextStorage. Found providers: ");
            sb.append(arrayList);
            atomicReference.set(new IllegalStateException(sb.toString()));
            return ContextStorage.CC.defaultStorage();
        }
        for (ContextStorageProvider contextStorageProvider2 : arrayList) {
            if (contextStorageProvider2.getClass().getName().equals(property)) {
                return contextStorageProvider2.get();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("io.opentelemetry.context.ContextStorageProvider property set but no matching class could be found, requested: ");
        sb2.append(property);
        sb2.append(" but found providers: ");
        sb2.append(arrayList);
        atomicReference.set(new IllegalStateException(sb2.toString()));
        return ContextStorage.CC.defaultStorage();
    }

    private LazyStorage() {
    }
}
