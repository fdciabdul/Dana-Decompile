package dagger.internal;

import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DelegateFactory<T> implements Factory<T> {
    private Provider<T> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final T get() {
        Provider<T> provider = this.MyBillsEntityDataFactory;
        if (provider == null) {
            throw new IllegalStateException();
        }
        return provider.get();
    }
}
