package com.alipay.iap.android.wallet.acl.member;

import com.alipay.iap.android.wallet.acl.base.BaseResult;

/* loaded from: classes.dex */
public class MemberInfoResult extends BaseResult {
    public MemberInfo memberInfo;

    public MemberInfoResult(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    public MemberInfo getMemberInfo() {
        return this.memberInfo;
    }
}
