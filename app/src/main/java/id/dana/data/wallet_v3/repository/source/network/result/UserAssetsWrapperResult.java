package id.dana.data.wallet_v3.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetsWrapperResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetInfosResult;", "component3", "()Ljava/util/List;", "location", "requestTime", "assetInfos", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetsWrapperResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getAssetInfos", "Ljava/lang/String;", "getLocation", "Ljava/lang/Long;", "getRequestTime", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserAssetsWrapperResult extends BaseRpcResult {
    private final List<UserAssetInfosResult> assetInfos;
    private final String location;
    private final Long requestTime;

    public UserAssetsWrapperResult() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserAssetsWrapperResult copy$default(UserAssetsWrapperResult userAssetsWrapperResult, String str, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userAssetsWrapperResult.location;
        }
        if ((i & 2) != 0) {
            l = userAssetsWrapperResult.requestTime;
        }
        if ((i & 4) != 0) {
            list = userAssetsWrapperResult.assetInfos;
        }
        return userAssetsWrapperResult.copy(str, l, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component2  reason: from getter */
    public final Long getRequestTime() {
        return this.requestTime;
    }

    public final List<UserAssetInfosResult> component3() {
        return this.assetInfos;
    }

    public final UserAssetsWrapperResult copy(String location, Long requestTime, List<UserAssetInfosResult> assetInfos) {
        return new UserAssetsWrapperResult(location, requestTime, assetInfos);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserAssetsWrapperResult) {
            UserAssetsWrapperResult userAssetsWrapperResult = (UserAssetsWrapperResult) other;
            return Intrinsics.areEqual(this.location, userAssetsWrapperResult.location) && Intrinsics.areEqual(this.requestTime, userAssetsWrapperResult.requestTime) && Intrinsics.areEqual(this.assetInfos, userAssetsWrapperResult.assetInfos);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.location;
        int hashCode = str == null ? 0 : str.hashCode();
        Long l = this.requestTime;
        int hashCode2 = l == null ? 0 : l.hashCode();
        List<UserAssetInfosResult> list = this.assetInfos;
        return (((hashCode * 31) + hashCode2) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserAssetsWrapperResult(location=");
        sb.append(this.location);
        sb.append(", requestTime=");
        sb.append(this.requestTime);
        sb.append(", assetInfos=");
        sb.append(this.assetInfos);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ UserAssetsWrapperResult(String str, Long l, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : list);
    }

    @JvmName(name = "getLocation")
    public final String getLocation() {
        return this.location;
    }

    @JvmName(name = "getRequestTime")
    public final Long getRequestTime() {
        return this.requestTime;
    }

    @JvmName(name = "getAssetInfos")
    public final List<UserAssetInfosResult> getAssetInfos() {
        return this.assetInfos;
    }

    public UserAssetsWrapperResult(String str, Long l, List<UserAssetInfosResult> list) {
        this.location = str;
        this.requestTime = l;
        this.assetInfos = list;
    }
}
