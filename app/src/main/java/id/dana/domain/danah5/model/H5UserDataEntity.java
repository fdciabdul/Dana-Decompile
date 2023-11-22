package id.dana.domain.danah5.model;

import android.os.Bundle;
import id.dana.domain.miniprogram.model.MiniProgramVersionRequirements;
import id.dana.domain.version.SemanticVersion;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u001bR\"\u0010\f\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u001fR\"\u0010\r\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010#"}, d2 = {"Lid/dana/domain/danah5/model/H5UserDataEntity;", "", "", "component1", "()Ljava/lang/String;", "Landroid/os/Bundle;", "component2", "()Landroid/os/Bundle;", "Lid/dana/domain/miniprogram/model/MiniProgramVersionRequirements;", "component3", "()Lid/dana/domain/miniprogram/model/MiniProgramVersionRequirements;", "appId", "h5ShareData", "versionRequirements", "copy", "(Ljava/lang/String;Landroid/os/Bundle;Lid/dana/domain/miniprogram/model/MiniProgramVersionRequirements;)Lid/dana/domain/danah5/model/H5UserDataEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAppId", "setAppId", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "getH5ShareData", "setH5ShareData", "(Landroid/os/Bundle;)V", "Lid/dana/domain/miniprogram/model/MiniProgramVersionRequirements;", "getVersionRequirements", "setVersionRequirements", "(Lid/dana/domain/miniprogram/model/MiniProgramVersionRequirements;)V", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;Lid/dana/domain/miniprogram/model/MiniProgramVersionRequirements;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class H5UserDataEntity {
    private String appId;
    private Bundle h5ShareData;
    private MiniProgramVersionRequirements versionRequirements;

    public static /* synthetic */ H5UserDataEntity copy$default(H5UserDataEntity h5UserDataEntity, String str, Bundle bundle, MiniProgramVersionRequirements miniProgramVersionRequirements, int i, Object obj) {
        if ((i & 1) != 0) {
            str = h5UserDataEntity.appId;
        }
        if ((i & 2) != 0) {
            bundle = h5UserDataEntity.h5ShareData;
        }
        if ((i & 4) != 0) {
            miniProgramVersionRequirements = h5UserDataEntity.versionRequirements;
        }
        return h5UserDataEntity.copy(str, bundle, miniProgramVersionRequirements);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2  reason: from getter */
    public final Bundle getH5ShareData() {
        return this.h5ShareData;
    }

    /* renamed from: component3  reason: from getter */
    public final MiniProgramVersionRequirements getVersionRequirements() {
        return this.versionRequirements;
    }

    public final H5UserDataEntity copy(String appId, Bundle h5ShareData, MiniProgramVersionRequirements versionRequirements) {
        Intrinsics.checkNotNullParameter(h5ShareData, "");
        Intrinsics.checkNotNullParameter(versionRequirements, "");
        return new H5UserDataEntity(appId, h5ShareData, versionRequirements);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof H5UserDataEntity) {
            H5UserDataEntity h5UserDataEntity = (H5UserDataEntity) other;
            return Intrinsics.areEqual(this.appId, h5UserDataEntity.appId) && Intrinsics.areEqual(this.h5ShareData, h5UserDataEntity.h5ShareData) && Intrinsics.areEqual(this.versionRequirements, h5UserDataEntity.versionRequirements);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.appId;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.h5ShareData.hashCode()) * 31) + this.versionRequirements.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("H5UserDataEntity(appId=");
        sb.append(this.appId);
        sb.append(", h5ShareData=");
        sb.append(this.h5ShareData);
        sb.append(", versionRequirements=");
        sb.append(this.versionRequirements);
        sb.append(')');
        return sb.toString();
    }

    public H5UserDataEntity(String str, Bundle bundle, MiniProgramVersionRequirements miniProgramVersionRequirements) {
        Intrinsics.checkNotNullParameter(bundle, "");
        Intrinsics.checkNotNullParameter(miniProgramVersionRequirements, "");
        this.appId = str;
        this.h5ShareData = bundle;
        this.versionRequirements = miniProgramVersionRequirements;
    }

    @JvmName(name = "getAppId")
    public final String getAppId() {
        return this.appId;
    }

    @JvmName(name = "setAppId")
    public final void setAppId(String str) {
        this.appId = str;
    }

    @JvmName(name = "getH5ShareData")
    public final Bundle getH5ShareData() {
        return this.h5ShareData;
    }

    @JvmName(name = "setH5ShareData")
    public final void setH5ShareData(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "");
        this.h5ShareData = bundle;
    }

    @JvmName(name = "getVersionRequirements")
    public final MiniProgramVersionRequirements getVersionRequirements() {
        return this.versionRequirements;
    }

    @JvmName(name = "setVersionRequirements")
    public final void setVersionRequirements(MiniProgramVersionRequirements miniProgramVersionRequirements) {
        Intrinsics.checkNotNullParameter(miniProgramVersionRequirements, "");
        this.versionRequirements = miniProgramVersionRequirements;
    }

    public /* synthetic */ H5UserDataEntity(String str, Bundle bundle, MiniProgramVersionRequirements miniProgramVersionRequirements, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bundle, (i & 4) != 0 ? new MiniProgramVersionRequirements(new SemanticVersion(0, 0, 0, 6, (DefaultConstructorMarker) null), new SemanticVersion(0, 0, 0, 6, (DefaultConstructorMarker) null)) : miniProgramVersionRequirements);
    }
}
