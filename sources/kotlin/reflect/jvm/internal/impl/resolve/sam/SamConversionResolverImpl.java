package kotlin.reflect.jvm.internal.impl.resolve.sam;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNullableValues;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* loaded from: classes.dex */
public final class SamConversionResolverImpl implements SamConversionResolver {
    private final CacheWithNullableValues<ClassDescriptor, SimpleType> functionTypesForSamInterfaces;
    private final Iterable<Object> samWithReceiverResolvers;

    public SamConversionResolverImpl(StorageManager storageManager, Iterable<? extends Object> iterable) {
        Intrinsics.checkNotNullParameter(storageManager, "");
        Intrinsics.checkNotNullParameter(iterable, "");
        this.samWithReceiverResolvers = iterable;
        this.functionTypesForSamInterfaces = storageManager.createCacheWithNullableValues();
    }
}
