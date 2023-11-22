package id.dana.data.config.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/data/config/model/CitcallPermissionConfig;", "", "Lid/dana/data/config/model/Permission;", "component1", "()Lid/dana/data/config/model/Permission;", "permission", "copy", "(Lid/dana/data/config/model/Permission;)Lid/dana/data/config/model/CitcallPermissionConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/config/model/Permission;", "getPermission", "<init>", "(Lid/dana/data/config/model/Permission;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CitcallPermissionConfig {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Permission permission;

    public /* synthetic */ CitcallPermissionConfig() {
    }

    public static /* synthetic */ CitcallPermissionConfig copy$default(CitcallPermissionConfig citcallPermissionConfig, Permission permission, int i, Object obj) {
        if ((i & 1) != 0) {
            permission = citcallPermissionConfig.permission;
        }
        return citcallPermissionConfig.copy(permission);
    }

    /* renamed from: component1  reason: from getter */
    public final Permission getPermission() {
        return this.permission;
    }

    public final CitcallPermissionConfig copy(@JSONField(name = "permission") Permission permission) {
        Intrinsics.checkNotNullParameter(permission, "");
        return new CitcallPermissionConfig(permission);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CitcallPermissionConfig) && Intrinsics.areEqual(this.permission, ((CitcallPermissionConfig) other).permission);
    }

    public final int hashCode() {
        return this.permission.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CitcallPermissionConfig(permission=");
        sb.append(this.permission);
        sb.append(')');
        return sb.toString();
    }

    public CitcallPermissionConfig(@JSONField(name = "permission") Permission permission) {
        Intrinsics.checkNotNullParameter(permission, "");
        this.permission = permission;
    }

    @JvmName(name = "getPermission")
    public final Permission getPermission() {
        return this.permission;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/config/model/CitcallPermissionConfig$Companion;", "", "Lid/dana/data/config/model/CitcallPermissionConfig;", "default", "()Lid/dana/data/config/model/CitcallPermissionConfig;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: default  reason: not valid java name */
        public final CitcallPermissionConfig m833default() {
            return new CitcallPermissionConfig(new Permission(true, false));
        }
    }
}
