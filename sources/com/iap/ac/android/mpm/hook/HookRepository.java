package com.iap.ac.android.mpm.hook;

import com.iap.ac.android.mpm.base.model.hook.PreCreateOrderConfig;
import com.iap.ac.android.mpm.base.model.hook.result.CommonHookResult;
import com.iap.ac.android.mpm.hook.source.CommonHookEntityData;

/* loaded from: classes3.dex */
public class HookRepository {
    private CommonHookEntityData entityData = new CommonHookEntityData();

    public CommonHookResult hookUrl(String str) {
        return this.entityData.hookUrl(str);
    }

    public CommonHookResult hookJsApi(PreCreateOrderConfig preCreateOrderConfig) {
        return this.entityData.hookJsAPI(preCreateOrderConfig);
    }
}
