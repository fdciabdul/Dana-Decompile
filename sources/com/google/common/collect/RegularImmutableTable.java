package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    abstract Table.Cell<R, C, V> getCell(int i);

    abstract V getValue(int i);

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public final ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
        return isEmpty() ? ImmutableSet.of() : new CellSet();
    }

    /* loaded from: classes7.dex */
    public final class CellSet extends IndexedImmutableSet<Table.Cell<R, C, V>> {
        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return false;
        }

        private CellSet() {
            RegularImmutableTable.this = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return RegularImmutableTable.this.size();
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public final Table.Cell<R, C, V> get(int i) {
            return RegularImmutableTable.this.getCell(i);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object obj) {
            if (obj instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell) obj;
                Object obj2 = RegularImmutableTable.this.get(cell.getRowKey(), cell.getColumnKey());
                return obj2 != null && obj2.equals(cell.getValue());
            }
            return false;
        }
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public final ImmutableCollection<V> createValues() {
        return isEmpty() ? ImmutableList.of() : new Values();
    }

    /* loaded from: classes7.dex */
    public final class Values extends ImmutableList<V> {
        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return true;
        }

        private Values() {
            RegularImmutableTable.this = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return RegularImmutableTable.this.size();
        }

        @Override // java.util.List
        public final V get(int i) {
            return (V) RegularImmutableTable.this.getValue(i);
        }
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Table.Cell<R, C, V>> list, @CheckForNull final Comparator<? super R> comparator, @CheckForNull final Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(list);
        if (comparator != null || comparator2 != null) {
            Collections.sort(list, new Comparator() { // from class: com.google.common.collect.RegularImmutableTable$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return RegularImmutableTable.lambda$forCells$0(comparator, comparator2, (Table.Cell) obj, (Table.Cell) obj2);
                }
            });
        }
        return forCellsInternal(list, comparator, comparator2);
    }

    public static /* synthetic */ int lambda$forCells$0(Comparator comparator, Comparator comparator2, Table.Cell cell, Table.Cell cell2) {
        int compare = comparator == null ? 0 : comparator.compare(cell.getRowKey(), cell2.getRowKey());
        if (compare != 0) {
            return compare;
        }
        if (comparator2 == null) {
            return 0;
        }
        return comparator2.compare(cell.getColumnKey(), cell2.getColumnKey());
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Table.Cell<R, C, V>> iterable) {
        return forCellsInternal(iterable, null, null);
    }

    private static <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Table.Cell<R, C, V>> iterable, @CheckForNull Comparator<? super R> comparator, @CheckForNull Comparator<? super C> comparator2) {
        ImmutableSet copyOf;
        ImmutableSet copyOf2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ImmutableList copyOf3 = ImmutableList.copyOf(iterable);
        for (Table.Cell<R, C, V> cell : iterable) {
            linkedHashSet.add(cell.getRowKey());
            linkedHashSet2.add(cell.getColumnKey());
        }
        if (comparator == null) {
            copyOf = ImmutableSet.copyOf((Collection) linkedHashSet);
        } else {
            copyOf = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet));
        }
        if (comparator2 == null) {
            copyOf2 = ImmutableSet.copyOf((Collection) linkedHashSet2);
        } else {
            copyOf2 = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2));
        }
        return forOrderedComponents(copyOf3, copyOf, copyOf2);
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        if (immutableList.size() > (immutableSet.size() * immutableSet2.size()) / 2) {
            return new DenseImmutableTable(immutableList, immutableSet, immutableSet2);
        }
        return new SparseImmutableTable(immutableList, immutableSet, immutableSet2);
    }

    public final void checkNoDuplicate(R r, C c, @CheckForNull V v, V v2) {
        Preconditions.checkArgument(v == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r, c, v2, v);
    }
}
