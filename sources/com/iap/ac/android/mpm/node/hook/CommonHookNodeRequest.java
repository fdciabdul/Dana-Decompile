package com.iap.ac.android.mpm.node.hook;

import com.iap.ac.android.mpm.base.model.hook.HookConstants;
import com.iap.ac.android.mpm.base.model.hook.PreCreateOrderConfig;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeType;

/* loaded from: classes3.dex */
public class CommonHookNodeRequest extends NodeRequest {
    public final String hookCategory;
    public String hookUrl;
    public PreCreateOrderConfig preCreateOrderConfig;

    public CommonHookNodeRequest(PreCreateOrderConfig preCreateOrderConfig) {
        super(NodeType.CommonHook);
        this.hookCategory = HookConstants.HookCategory.HOOK_CATEGORY_TRADEPAY;
        this.preCreateOrderConfig = preCreateOrderConfig;
    }

    public CommonHookNodeRequest(String str) {
        super(NodeType.CommonHook);
        this.hookCategory = "URL";
        this.hookUrl = str;
    }
}
