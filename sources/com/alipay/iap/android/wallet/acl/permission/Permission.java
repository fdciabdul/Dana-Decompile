package com.alipay.iap.android.wallet.acl.permission;

/* loaded from: classes6.dex */
public class Permission {
    PermissionStatus permissionStatus;
    PermissionType permissionType;

    /* loaded from: classes6.dex */
    public enum PermissionStatus {
        UKNOWN,
        AUTHORISED,
        NOT_AVAILABLE,
        UNSUPPORTED
    }

    /* loaded from: classes2.dex */
    public enum PermissionType {
        STEP,
        CONTACT_READ
    }

    public Permission(PermissionStatus permissionStatus, PermissionType permissionType) {
        this.permissionStatus = permissionStatus;
        this.permissionType = permissionType;
    }

    public PermissionStatus getPermissionStatus() {
        return this.permissionStatus;
    }

    public void setPermissionStatus(PermissionStatus permissionStatus) {
        this.permissionStatus = permissionStatus;
    }

    public PermissionType getPermissionType() {
        return this.permissionType;
    }

    public void setPermissionType(PermissionType permissionType) {
        this.permissionType = permissionType;
    }
}
