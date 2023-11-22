package io.split.android.client.telemetry.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes9.dex */
public class AtomicLongArray {
    private static final int MAX_LENGTH = 23;
    private final AtomicLong[] array;

    public AtomicLongArray(int i) {
        i = i <= 0 ? 23 : i;
        this.array = new AtomicLong[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.array[i2] = new AtomicLong();
        }
    }

    public void increment(int i) {
        synchronized (this) {
            if (i >= 0) {
                AtomicLong[] atomicLongArr = this.array;
                if (i < atomicLongArr.length) {
                    atomicLongArr[i].getAndIncrement();
                }
            }
        }
    }

    public List<Long> fetchAndClearAll() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            for (AtomicLong atomicLong : this.array) {
                arrayList.add(Long.valueOf(atomicLong.longValue()));
            }
            int length = this.array.length;
            for (int i = 0; i < length; i++) {
                this.array[i] = new AtomicLong();
            }
        }
        return arrayList;
    }
}
