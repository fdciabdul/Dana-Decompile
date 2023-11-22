package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;

/* loaded from: classes.dex */
public final class NullabilityAnnotationStatesImpl<T> implements NullabilityAnnotationStates<T> {
    private final MemoizedFunctionToNullable<FqName, T> cache;
    private final Map<FqName, T> states;
    private final LockBasedStorageManager storageManager;

    /* JADX WARN: Multi-variable type inference failed */
    public NullabilityAnnotationStatesImpl(Map<FqName, ? extends T> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.states = map;
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Java nullability annotation states");
        this.storageManager = lockBasedStorageManager;
        MemoizedFunctionToNullable<FqName, T> createMemoizedFunctionWithNullableValues = lockBasedStorageManager.createMemoizedFunctionWithNullableValues(new Function1<FqName, T>(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl$cache$1
            final /* synthetic */ NullabilityAnnotationStatesImpl<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(FqName fqName) {
                Intrinsics.checkNotNullExpressionValue(fqName, "");
                return (T) FqNamesUtilKt.findValueForMostSpecificFqname(fqName, this.this$0.getStates());
            }
        });
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunctionWithNullableValues, "");
        this.cache = createMemoizedFunctionWithNullableValues;
    }

    public final Map<FqName, T> getStates() {
        return this.states;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates
    public final T get(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "");
        return this.cache.invoke(fqName);
    }
}
