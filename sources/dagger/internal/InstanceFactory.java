package dagger.internal;

import dagger.Lazy;

/* loaded from: classes8.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    private static final InstanceFactory<Object> getAuthRequestContext = new InstanceFactory<>(null);
    private final T KClassImpl$Data$declaredNonStaticMembers$2;

    public static <T> Factory<T> MyBillsEntityDataFactory(T t) {
        return new InstanceFactory(Preconditions.getAuthRequestContext(t, "instance cannot be null"));
    }

    private InstanceFactory(T t) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
    }

    @Override // javax.inject.Provider
    public final T get() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
