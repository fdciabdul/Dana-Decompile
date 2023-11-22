package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.MapsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes.dex */
public interface NullabilityAnnotationStates<T> {
    public static final Companion Companion = Companion.$$INSTANCE;

    T get(FqName fqName);

    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final NullabilityAnnotationStates EMPTY = new NullabilityAnnotationStatesImpl(MapsKt.emptyMap());

        private Companion() {
        }

        public final NullabilityAnnotationStates getEMPTY() {
            return EMPTY;
        }
    }
}
