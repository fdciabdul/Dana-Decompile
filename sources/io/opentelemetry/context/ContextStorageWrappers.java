package io.opentelemetry.context;

import j$.util.function.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
final class ContextStorageWrappers {
    private static boolean storageInitialized;
    private static final Logger log = Logger.getLogger(ContextStorageWrappers.class.getName());
    private static final List<Function<? super ContextStorage, ? extends ContextStorage>> wrappers = new ArrayList();
    private static final Object mutex = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addWrapper(Function<? super ContextStorage, ? extends ContextStorage> function) {
        synchronized (mutex) {
            if (storageInitialized) {
                log.log(Level.FINE, "ContextStorage has already been initialized, ignoring call to add wrapper.", new Throwable());
            } else {
                wrappers.add(function);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Function<? super ContextStorage, ? extends ContextStorage>> getWrappers() {
        List<Function<? super ContextStorage, ? extends ContextStorage>> list;
        synchronized (mutex) {
            list = wrappers;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setStorageInitialized() {
        synchronized (mutex) {
            storageInitialized = true;
        }
    }

    private ContextStorageWrappers() {
    }
}
