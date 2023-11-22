package io.opentelemetry.sdk.internal;

import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class ComponentRegistry<V> {
    private final Function<InstrumentationScopeInfo, V> factory;
    private final ConcurrentMap<InstrumentationScopeInfo, V> registry = new ConcurrentHashMap();

    public ComponentRegistry(Function<InstrumentationScopeInfo, V> function) {
        this.factory = function;
    }

    public final V get(InstrumentationScopeInfo instrumentationScopeInfo) {
        V v = this.registry.get(instrumentationScopeInfo);
        if (v != null) {
            return v;
        }
        V apply = this.factory.apply(instrumentationScopeInfo);
        V putIfAbsent = this.registry.putIfAbsent(instrumentationScopeInfo, apply);
        return putIfAbsent != null ? putIfAbsent : apply;
    }

    public final Collection<V> getComponents() {
        return Collections.unmodifiableCollection(new ArrayList(this.registry.values()));
    }
}
