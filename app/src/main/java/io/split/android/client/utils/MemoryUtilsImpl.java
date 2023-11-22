package io.split.android.client.utils;

import com.google.common.base.Strings;

/* loaded from: classes9.dex */
public class MemoryUtilsImpl implements MemoryUtils {
    private static final int MEMORY_ALLOCATION_TIMES_FOR_JSON = 2;

    @Override // io.split.android.client.utils.MemoryUtils
    public boolean isMemoryAvailableToAllocate(long j, int i) {
        return Runtime.getRuntime().freeMemory() > j * ((long) i);
    }

    @Override // io.split.android.client.utils.MemoryUtils
    public boolean isMemoryAvailableForJson(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return true;
        }
        return isMemoryAvailableToAllocate(str.getBytes().length, 2);
    }
}
