package com.alipay.iap.android.wallet.acl.member;

import com.alipay.iap.android.wallet.acl.base.BaseResult;

/* loaded from: classes6.dex */
public class MemberNotification extends BaseResult {
    private MemberInfo memberInfo;
    private NotificationType notificationType;

    /* loaded from: classes6.dex */
    public enum NotificationType {
        LOGIN,
        UPDATE,
        LOGOUT
    }

    public MemberInfo getMemberInfo() {
        return this.memberInfo;
    }

    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    public NotificationType getNotificationType() {
        return this.notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }
}
