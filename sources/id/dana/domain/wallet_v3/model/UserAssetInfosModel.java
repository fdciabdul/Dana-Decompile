package id.dana.domain.wallet_v3.model;

import id.dana.animation.HomeTabActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/domain/wallet_v3/model/UserAssetsModel;", "component3", "()Lid/dana/domain/wallet_v3/model/UserAssetsModel;", HomeTabActivity.WALLET_SECTION, "assetType", "info", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/wallet_v3/model/UserAssetsModel;)Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAssetType", "Lid/dana/domain/wallet_v3/model/UserAssetsModel;", "getInfo", "getSection", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/wallet_v3/model/UserAssetsModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserAssetInfosModel {
    private final String assetType;
    private final UserAssetsModel info;
    private final String section;

    public static /* synthetic */ UserAssetInfosModel copy$default(UserAssetInfosModel userAssetInfosModel, String str, String str2, UserAssetsModel userAssetsModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userAssetInfosModel.section;
        }
        if ((i & 2) != 0) {
            str2 = userAssetInfosModel.assetType;
        }
        if ((i & 4) != 0) {
            userAssetsModel = userAssetInfosModel.info;
        }
        return userAssetInfosModel.copy(str, str2, userAssetsModel);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSection() {
        return this.section;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAssetType() {
        return this.assetType;
    }

    /* renamed from: component3  reason: from getter */
    public final UserAssetsModel getInfo() {
        return this.info;
    }

    public final UserAssetInfosModel copy(String section, String assetType, UserAssetsModel info) {
        return new UserAssetInfosModel(section, assetType, info);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserAssetInfosModel) {
            UserAssetInfosModel userAssetInfosModel = (UserAssetInfosModel) other;
            return Intrinsics.areEqual(this.section, userAssetInfosModel.section) && Intrinsics.areEqual(this.assetType, userAssetInfosModel.assetType) && Intrinsics.areEqual(this.info, userAssetInfosModel.info);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.section;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.assetType;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        UserAssetsModel userAssetsModel = this.info;
        return (((hashCode * 31) + hashCode2) * 31) + (userAssetsModel != null ? userAssetsModel.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserAssetInfosModel(section=");
        sb.append(this.section);
        sb.append(", assetType=");
        sb.append(this.assetType);
        sb.append(", info=");
        sb.append(this.info);
        sb.append(')');
        return sb.toString();
    }

    public UserAssetInfosModel(String str, String str2, UserAssetsModel userAssetsModel) {
        this.section = str;
        this.assetType = str2;
        this.info = userAssetsModel;
    }

    @JvmName(name = "getSection")
    public final String getSection() {
        return this.section;
    }

    @JvmName(name = "getAssetType")
    public final String getAssetType() {
        return this.assetType;
    }

    @JvmName(name = "getInfo")
    public final UserAssetsModel getInfo() {
        return this.info;
    }
}
