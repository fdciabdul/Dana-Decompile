package com.huawei.hms.framework.common.hianalytics;

import java.util.LinkedHashMap;

/* loaded from: classes7.dex */
public class LinkedHashMapPack {
    private LinkedHashMap<String, String> MyBillsEntityDataFactory = new LinkedHashMap<>();

    public LinkedHashMapPack put(String str, String str2) {
        if (str != null && str2 != null) {
            this.MyBillsEntityDataFactory.put(str, str2);
        }
        return this;
    }

    public LinkedHashMapPack putIfNotDefault(String str, long j, long j2) {
        return j == j2 ? this : put(str, j);
    }

    public LinkedHashMapPack put(String str, boolean z) {
        if (str != null) {
            if (z) {
                this.MyBillsEntityDataFactory.put(str, "1");
            } else {
                this.MyBillsEntityDataFactory.put(str, "0");
            }
        }
        return this;
    }

    public LinkedHashMapPack put(String str, long j) {
        if (str != null) {
            LinkedHashMap<String, String> linkedHashMap = this.MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            linkedHashMap.put(str, sb.toString());
        }
        return this;
    }

    public LinkedHashMap<String, String> getAll() {
        return this.MyBillsEntityDataFactory;
    }
}
