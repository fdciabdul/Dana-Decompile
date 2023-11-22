package com.alibaba.ariver.permission.view;

import java.util.Map;

/* loaded from: classes6.dex */
public interface LocalPermissionDialog {
    void setDialogContent(String str, String str2, String str3);

    void setDialogExtraData(Map<String, String> map);

    void setPermissionPermitListener(PermissionPermitListener permissionPermitListener);

    void show();
}
