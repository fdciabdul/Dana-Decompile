package id.dana.data.paylater.repository.source.network.request;

import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.google.gson.annotations.SerializedName;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeLogger;
import id.dana.danah5.constant.BridgeName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BC\u0012\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0015R.\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R2\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t"}, d2 = {"Lid/dana/data/paylater/repository/source/network/request/LoanRegisterEntityRequest;", "", "", "", "applyInfo", "Ljava/util/Map;", "getApplyInfo", "()Ljava/util/Map;", "setApplyInfo", "(Ljava/util/Map;)V", "Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "envInfo", "Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", BridgeName.GET_ENV_INFO, "()Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "setEnvInfo", "(Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;)V", ApiDowngradeLogger.EXT_KEY_EXT_PARAMS, "getExtParams", "setExtParams", "<init>", "(Ljava/util/Map;Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoanRegisterEntityRequest {
    private Map<String, String> applyInfo;
    @SerializedName("envInfo")
    private MobileEnvInfo envInfo;
    private Map<String, ? extends Object> extParams;

    public LoanRegisterEntityRequest() {
        this(null, null, null, 7, null);
    }

    public LoanRegisterEntityRequest(Map<String, ? extends Object> map, MobileEnvInfo mobileEnvInfo, Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(map2, "");
        this.extParams = map;
        this.envInfo = mobileEnvInfo;
        this.applyInfo = map2;
    }

    public /* synthetic */ LoanRegisterEntityRequest(HashMap hashMap, MobileEnvInfo mobileEnvInfo, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new HashMap() : hashMap, (i & 2) != 0 ? null : mobileEnvInfo, (i & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    @JvmName(name = "getExtParams")
    public final Map<String, Object> getExtParams() {
        return this.extParams;
    }

    @JvmName(name = "setExtParams")
    public final void setExtParams(Map<String, ? extends Object> map) {
        this.extParams = map;
    }

    @JvmName(name = BridgeName.GET_ENV_INFO)
    public final MobileEnvInfo getEnvInfo() {
        return this.envInfo;
    }

    @JvmName(name = "setEnvInfo")
    public final void setEnvInfo(MobileEnvInfo mobileEnvInfo) {
        this.envInfo = mobileEnvInfo;
    }

    @JvmName(name = "getApplyInfo")
    public final Map<String, String> getApplyInfo() {
        return this.applyInfo;
    }

    @JvmName(name = "setApplyInfo")
    public final void setApplyInfo(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.applyInfo = map;
    }
}
