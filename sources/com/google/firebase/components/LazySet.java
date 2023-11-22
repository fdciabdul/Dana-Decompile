package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LazySet<T> implements Provider<Set<T>> {
    private volatile Set<T> actualSet = null;
    private volatile Set<Provider<T>> providers = Collections.newSetFromMap(new ConcurrentHashMap());

    LazySet(Collection<Provider<T>> collection) {
        this.providers.addAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LazySet<?> fromCollection(Collection<Provider<?>> collection) {
        return new LazySet<>((Set) collection);
    }

    @Override // com.google.firebase.inject.Provider
    public Set<T> get() {
        if (this.actualSet == null) {
            synchronized (this) {
                if (this.actualSet == null) {
                    this.actualSet = Collections.newSetFromMap(new ConcurrentHashMap());
                    updateSet();
                }
            }
        }
        return Collections.unmodifiableSet(this.actualSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(Provider<T> provider) {
        synchronized (this) {
            if (this.actualSet == null) {
                this.providers.add(provider);
            } else {
                this.actualSet.add(provider.get());
            }
        }
    }

    private void updateSet() {
        synchronized (this) {
            Iterator<Provider<T>> it = this.providers.iterator();
            while (it.hasNext()) {
                this.actualSet.add(it.next().get());
            }
            this.providers = null;
        }
    }
}
