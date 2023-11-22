package io.opentelemetry.context;

import j$.util.function.Function;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public interface ContextStorage {
    Scope attach(Context context);

    @Nullable
    Context current();

    Context root();

    /* renamed from: io.opentelemetry.context.ContextStorage$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static ContextStorage get() {
            return LazyStorage.get();
        }

        public static ContextStorage defaultStorage() {
            return ThreadLocalContextStorage.INSTANCE;
        }

        public static void addWrapper(Function<? super ContextStorage, ? extends ContextStorage> function) {
            ContextStorageWrappers.addWrapper(function);
        }
    }
}
