package com.alipay.mobile.embedview.mapbiz.utils;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public class ComparableIndex<T extends Comparable> implements Comparable<ComparableIndex<T>> {
    public final int index;
    public final T value;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((ComparableIndex) ((ComparableIndex) obj));
    }

    private ComparableIndex(int i, T t) {
        this.index = i;
        this.value = t;
    }

    public int compareTo(ComparableIndex<T> comparableIndex) {
        if (comparableIndex != null) {
            return this.value.compareTo(comparableIndex.value);
        }
        return 0;
    }

    public static <T extends Comparable> List<ComparableIndex<T>> sort(List<T> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new ComparableIndex(i, list.get(i)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
