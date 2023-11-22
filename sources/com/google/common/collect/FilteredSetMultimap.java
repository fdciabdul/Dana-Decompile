package com.google.common.collect;

import com.android.tools.r8.annotations.SynthesizedClassV2;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
interface FilteredSetMultimap<K, V> extends FilteredMultimap<K, V>, SetMultimap<K, V> {
    @Override // com.google.common.collect.FilteredMultimap
    SetMultimap<K, V> unfiltered();

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: com.google.common.collect.FilteredSetMultimap$-CC  reason: invalid class name */
    /* loaded from: classes7.dex */
    public final /* synthetic */ class CC<K, V> {
    }
}
