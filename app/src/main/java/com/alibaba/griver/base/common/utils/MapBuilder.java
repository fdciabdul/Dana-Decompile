package com.alibaba.griver.base.common.utils;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class MapBuilder {

    /* loaded from: classes2.dex */
    public static class Builder {
        public Map<String, String> map = new HashMap();

        public Builder map(String str, String str2) {
            this.map.put(str, str2);
            return this;
        }

        public Map<String, String> build() {
            return this.map;
        }
    }
}
