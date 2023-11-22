package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* loaded from: classes8.dex */
class r {
    int getAuthRequestContext = 0;
    String MyBillsEntityDataFactory = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return !TextUtils.isEmpty(rVar.MyBillsEntityDataFactory) && rVar.MyBillsEntityDataFactory.equals(this.MyBillsEntityDataFactory);
    }
}
