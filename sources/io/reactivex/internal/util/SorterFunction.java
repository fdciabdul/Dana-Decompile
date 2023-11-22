package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes9.dex */
public final class SorterFunction<T> implements Function<List<T>, List<T>> {
    final Comparator<? super T> getAuthRequestContext;

    @Override // io.reactivex.functions.Function
    public final /* synthetic */ Object apply(Object obj) throws Exception {
        List list = (List) obj;
        Collections.sort(list, this.getAuthRequestContext);
        return list;
    }
}
