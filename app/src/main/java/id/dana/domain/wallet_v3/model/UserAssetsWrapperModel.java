package id.dana.domain.wallet_v3.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJR\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004R\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u000eR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\u0007"}, d2 = {"Lid/dana/domain/wallet_v3/model/UserAssetsWrapperModel;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "", "component3", "()Ljava/util/Map;", "", "Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;", "component4", "()Ljava/util/List;", "location", "requestTime", "errorActions", "assetInfos", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/util/List;)Lid/dana/domain/wallet_v3/model/UserAssetsWrapperModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getAssetInfos", "Ljava/util/Map;", "getErrorActions", "Ljava/lang/String;", "getLocation", "Ljava/lang/Long;", "getRequestTime", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserAssetsWrapperModel {
    private final List<UserAssetInfosModel> assetInfos;
    private final Map<String, String> errorActions;
    private final String location;
    private final Long requestTime;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserAssetsWrapperModel copy$default(UserAssetsWrapperModel userAssetsWrapperModel, String str, Long l, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userAssetsWrapperModel.location;
        }
        if ((i & 2) != 0) {
            l = userAssetsWrapperModel.requestTime;
        }
        if ((i & 4) != 0) {
            map = userAssetsWrapperModel.errorActions;
        }
        if ((i & 8) != 0) {
            list = userAssetsWrapperModel.assetInfos;
        }
        return userAssetsWrapperModel.copy(str, l, map, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component2  reason: from getter */
    public final Long getRequestTime() {
        return this.requestTime;
    }

    public final Map<String, String> component3() {
        return this.errorActions;
    }

    public final List<UserAssetInfosModel> component4() {
        return this.assetInfos;
    }

    public final UserAssetsWrapperModel copy(String location, Long requestTime, Map<String, String> errorActions, List<UserAssetInfosModel> assetInfos) {
        return new UserAssetsWrapperModel(location, requestTime, errorActions, assetInfos);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserAssetsWrapperModel) {
            UserAssetsWrapperModel userAssetsWrapperModel = (UserAssetsWrapperModel) other;
            return Intrinsics.areEqual(this.location, userAssetsWrapperModel.location) && Intrinsics.areEqual(this.requestTime, userAssetsWrapperModel.requestTime) && Intrinsics.areEqual(this.errorActions, userAssetsWrapperModel.errorActions) && Intrinsics.areEqual(this.assetInfos, userAssetsWrapperModel.assetInfos);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.location;
        int hashCode = str == null ? 0 : str.hashCode();
        Long l = this.requestTime;
        int hashCode2 = l == null ? 0 : l.hashCode();
        Map<String, String> map = this.errorActions;
        int hashCode3 = map == null ? 0 : map.hashCode();
        List<UserAssetInfosModel> list = this.assetInfos;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserAssetsWrapperModel(location=");
        sb.append(this.location);
        sb.append(", requestTime=");
        sb.append(this.requestTime);
        sb.append(", errorActions=");
        sb.append(this.errorActions);
        sb.append(", assetInfos=");
        sb.append(this.assetInfos);
        sb.append(')');
        return sb.toString();
    }

    public UserAssetsWrapperModel(String str, Long l, Map<String, String> map, List<UserAssetInfosModel> list) {
        this.location = str;
        this.requestTime = l;
        this.errorActions = map;
        this.assetInfos = list;
    }

    @JvmName(name = "getLocation")
    public final String getLocation() {
        return this.location;
    }

    @JvmName(name = "getRequestTime")
    public final Long getRequestTime() {
        return this.requestTime;
    }

    @JvmName(name = "getErrorActions")
    public final Map<String, String> getErrorActions() {
        return this.errorActions;
    }

    @JvmName(name = "getAssetInfos")
    public final List<UserAssetInfosModel> getAssetInfos() {
        return this.assetInfos;
    }
}
