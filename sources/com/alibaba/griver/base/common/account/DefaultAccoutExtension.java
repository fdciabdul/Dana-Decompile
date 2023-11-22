package com.alibaba.griver.base.common.account;

import com.alibaba.griver.api.common.account.GriverAccountExtension;

/* loaded from: classes6.dex */
public class DefaultAccoutExtension implements GriverAccountExtension {
    @Override // com.alibaba.griver.api.common.account.GriverAccountExtension
    public String getUserId() {
        return "default-user-id";
    }
}
