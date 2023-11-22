package id.dana.data.wallet_v3.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.animation.HomeTabActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/request/UserAssetsRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "", "assetBizType", "Ljava/util/List;", "getAssetBizType", "()Ljava/util/List;", "assetType", "getAssetType", "", "enableOnly", "Ljava/lang/Boolean;", "getEnableOnly", "()Ljava/lang/Boolean;", "ipRoleId", "Ljava/lang/String;", "getIpRoleId", "()Ljava/lang/String;", HomeTabActivity.WALLET_SECTION, "getSection", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserAssetsRequest extends BaseRpcRequest {
    private final List<String> assetBizType;
    private final List<String> assetType;
    private final Boolean enableOnly;
    private final String ipRoleId;
    private final List<String> section;

    public UserAssetsRequest() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ UserAssetsRequest(String str, Boolean bool, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : list3);
    }

    @JvmName(name = "getIpRoleId")
    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    @JvmName(name = "getEnableOnly")
    public final Boolean getEnableOnly() {
        return this.enableOnly;
    }

    @JvmName(name = "getSection")
    public final List<String> getSection() {
        return this.section;
    }

    @JvmName(name = "getAssetBizType")
    public final List<String> getAssetBizType() {
        return this.assetBizType;
    }

    @JvmName(name = "getAssetType")
    public final List<String> getAssetType() {
        return this.assetType;
    }

    public UserAssetsRequest(String str, Boolean bool, List<String> list, List<String> list2, List<String> list3) {
        this.ipRoleId = str;
        this.enableOnly = bool;
        this.section = list;
        this.assetBizType = list2;
        this.assetType = list3;
    }
}
