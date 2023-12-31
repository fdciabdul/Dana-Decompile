package com.alibaba.griver.base.common.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes2.dex */
public interface RVFileAbilityProxy extends Proxiable {
    String getUserId();

    boolean hasFolderPermission(String str);

    String queryLocalIdByPath(String str);

    String queryPathByLocalId(String str);

    boolean saveIdWithPath(String str, String str2);
}
