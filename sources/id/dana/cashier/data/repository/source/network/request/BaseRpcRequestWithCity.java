package id.dana.cashier.data.repository.source.network.request;

import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeLogger;
import id.dana.danah5.constant.BridgeName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B/\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR4\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/BaseRpcRequestWithCity;", "", "Lid/dana/cashier/data/repository/source/network/request/MobileEnvInfoWithCity;", "envInfo", "Lid/dana/cashier/data/repository/source/network/request/MobileEnvInfoWithCity;", BridgeName.GET_ENV_INFO, "()Lid/dana/cashier/data/repository/source/network/request/MobileEnvInfoWithCity;", "setEnvInfo", "(Lid/dana/cashier/data/repository/source/network/request/MobileEnvInfoWithCity;)V", "", "", ApiDowngradeLogger.EXT_KEY_EXT_PARAMS, "Ljava/util/Map;", "getExtParams", "()Ljava/util/Map;", "setExtParams", "(Ljava/util/Map;)V", "<init>", "(Ljava/util/Map;Lid/dana/cashier/data/repository/source/network/request/MobileEnvInfoWithCity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class BaseRpcRequestWithCity {
    private MobileEnvInfoWithCity envInfo;
    private Map<String, ? extends Object> extParams;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.util.Map, id.dana.cashier.data.repository.source.network.request.MobileEnvInfoWithCity] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BaseRpcRequestWithCity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.data.repository.source.network.request.BaseRpcRequestWithCity.<init>():void");
    }

    public BaseRpcRequestWithCity(Map<String, ? extends Object> map, MobileEnvInfoWithCity mobileEnvInfoWithCity) {
        this.extParams = map;
        this.envInfo = mobileEnvInfoWithCity;
    }

    public /* synthetic */ BaseRpcRequestWithCity(HashMap hashMap, MobileEnvInfoWithCity mobileEnvInfoWithCity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new HashMap() : hashMap, (i & 2) != 0 ? null : mobileEnvInfoWithCity);
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
    public final MobileEnvInfoWithCity getEnvInfo() {
        return this.envInfo;
    }

    @JvmName(name = "setEnvInfo")
    public final void setEnvInfo(MobileEnvInfoWithCity mobileEnvInfoWithCity) {
        this.envInfo = mobileEnvInfoWithCity;
    }
}
