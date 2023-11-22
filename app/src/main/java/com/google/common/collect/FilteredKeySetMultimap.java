package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.FilteredKeyMultimap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class FilteredKeySetMultimap<K, V> extends FilteredKeyMultimap<K, V> implements FilteredSetMultimap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.Multimap
    public final /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object obj) {
        return get((FilteredKeySetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object obj, Iterable iterable) {
        return replaceValues((FilteredKeySetMultimap<K, V>) obj, iterable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilteredKeySetMultimap(SetMultimap<K, V> setMultimap, Predicate<? super K> predicate) {
        super(setMultimap, predicate);
    }

    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.FilteredMultimap
    public final SetMultimap<K, V> unfiltered() {
        return (SetMultimap) this.unfiltered;
    }

    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.Multimap
    public final Set<V> get(@ParametricNullness K k) {
        return (Set) super.get((FilteredKeySetMultimap<K, V>) k);
    }

    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.Multimap
    public final Set<V> removeAll(@CheckForNull Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Set<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues((FilteredKeySetMultimap<K, V>) k, (Iterable) iterable);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.AbstractMultimap
    public final Set<Map.Entry<K, V>> createEntries() {
        return new EntrySet(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class EntrySet extends FilteredKeyMultimap.Entries implements Set {
        EntrySet(FilteredKeySetMultimap filteredKeySetMultimap) {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return Sets.equalsImpl(this, obj);
        }
    }
}