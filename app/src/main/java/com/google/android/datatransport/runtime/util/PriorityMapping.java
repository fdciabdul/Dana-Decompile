package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* loaded from: classes7.dex */
public final class PriorityMapping {
    private static HashMap<Priority, Integer> PRIORITY_INT_MAP;
    private static SparseArray<Priority> PRIORITY_MAP = new SparseArray<>();

    static {
        HashMap<Priority, Integer> hashMap = new HashMap<>();
        PRIORITY_INT_MAP = hashMap;
        hashMap.put(Priority.DEFAULT, 0);
        PRIORITY_INT_MAP.put(Priority.VERY_LOW, 1);
        PRIORITY_INT_MAP.put(Priority.HIGHEST, 2);
        for (Priority priority : PRIORITY_INT_MAP.keySet()) {
            PRIORITY_MAP.append(PRIORITY_INT_MAP.get(priority).intValue(), priority);
        }
    }

    public static Priority valueOf(int i) {
        Priority priority = PRIORITY_MAP.get(i);
        if (priority != null) {
            return priority;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown Priority for value ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int toInt(Priority priority) {
        Integer num = PRIORITY_INT_MAP.get(priority);
        if (num == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("PriorityMapping is missing known Priority value ");
            sb.append(priority);
            throw new IllegalStateException(sb.toString());
        }
        return num.intValue();
    }
}
