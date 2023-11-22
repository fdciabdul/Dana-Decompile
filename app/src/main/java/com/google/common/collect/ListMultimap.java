package com.google.common.collect;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public interface ListMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    boolean equals(@CheckForNull Object obj);

    @Override // com.google.common.collect.Multimap
    List<V> get(@ParametricNullness K k);

    @Override // com.google.common.collect.Multimap
    List<V> removeAll(@CheckForNull Object obj);

    @Override // com.google.common.collect.Multimap
    List<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable);

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: com.google.common.collect.ListMultimap$-CC  reason: invalid class name */
    /* loaded from: classes7.dex */
    public final /* synthetic */ class CC<K, V> {
    }
}
