package io.split.android.engine.splitter;

import io.split.android.client.dtos.Partition;
import io.split.android.client.utils.MurmurHash3;
import java.util.List;

/* loaded from: classes6.dex */
public class Splitter {
    public static String PlaceComponentResult(String str, int i, List<Partition> list, int i2) {
        long murmurhash3_x86_32;
        if (list.isEmpty()) {
            return "control";
        }
        int i3 = 0;
        if (KClassImpl$Data$declaredNonStaticMembers$2(list)) {
            return list.get(0).treatment;
        }
        if (i2 != 2) {
            murmurhash3_x86_32 = getAuthRequestContext(str, i);
        } else {
            murmurhash3_x86_32 = MurmurHash3.murmurhash3_x86_32(str, 0, str.length(), i);
        }
        int abs = (int) (Math.abs(murmurhash3_x86_32 % 100) + 1);
        for (Partition partition : list) {
            i3 += partition.size;
            if (i3 >= abs) {
                return partition.treatment;
            }
        }
        return "control";
    }

    private static int getAuthRequestContext(String str, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            i2 = (i2 * 31) + str.charAt(i3);
        }
        return i2 ^ i;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(List<Partition> list) {
        return list.size() == 1 && list.get(0).size == 100;
    }

    public static int MyBillsEntityDataFactory(String str, int i, int i2) {
        long murmurhash3_x86_32;
        if (i2 != 2) {
            murmurhash3_x86_32 = getAuthRequestContext(str, i);
        } else {
            murmurhash3_x86_32 = MurmurHash3.murmurhash3_x86_32(str, 0, str.length(), i);
        }
        return (int) (Math.abs(murmurhash3_x86_32 % 100) + 1);
    }
}
