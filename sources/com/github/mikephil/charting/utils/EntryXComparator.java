package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

/* loaded from: classes7.dex */
public class EntryXComparator implements Comparator<Entry> {
    @Override // java.util.Comparator
    public /* synthetic */ int compare(Entry entry, Entry entry2) {
        float MyBillsEntityDataFactory = entry.MyBillsEntityDataFactory() - entry2.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory == 0.0f) {
            return 0;
        }
        return MyBillsEntityDataFactory > 0.0f ? 1 : -1;
    }
}
