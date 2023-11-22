package com.afollestad.materialdialogs.utils;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0015\n\u0002\u0010\u001e\n\u0002\u0010\b\n\u0002\b\u0004\u001a!\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0005"}, d2 = {"", "", "", "values", "appendAll", "([ILjava/util/Collection;)[I", "removeAll"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class IntArraysKt {
    public static final int[] appendAll(int[] iArr, Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(iArr, "");
        Intrinsics.checkParameterIsNotNull(collection, "");
        List<Integer> mutableList = kotlin.collections.ArraysKt.toMutableList(iArr);
        mutableList.addAll(collection);
        return CollectionsKt.toIntArray(mutableList);
    }

    public static final int[] removeAll(int[] iArr, final Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(iArr, "");
        Intrinsics.checkParameterIsNotNull(collection, "");
        List<Integer> mutableList = kotlin.collections.ArraysKt.toMutableList(iArr);
        CollectionsKt.removeAll((List) mutableList, (Function1) new Function1<Integer, Boolean>() { // from class: com.afollestad.materialdialogs.utils.IntArraysKt$removeAll$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Boolean invoke(Integer num) {
                return Boolean.valueOf(invoke(num.intValue()));
            }

            public final boolean invoke(int i) {
                return collection.contains(Integer.valueOf(i));
            }
        });
        return CollectionsKt.toIntArray(mutableList);
    }
}
