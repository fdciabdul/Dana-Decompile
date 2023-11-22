package com.afollestad.materialdialogs.utils;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0015\n\u0002\b\u0003\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "", "indices", "pullIndices", "(Ljava/util/List;[I)Ljava/util/List;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class ArraysKt {
    public static final /* synthetic */ <T> List<T> pullIndices(List<? extends T> list, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(list, "");
        Intrinsics.checkParameterIsNotNull(iArr, "");
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(list.get(i));
        }
        return arrayList;
    }
}
