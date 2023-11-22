package id.dana.promocode.utils;

import id.dana.riskChallenges.constant.RiskChallengeValue;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/promocode/utils/PromoCodeErrorMapStrategy;", "", "", "p0", "Lid/dana/promocode/utils/ErrorFlag;", "getAuthRequestContext", "(Ljava/lang/String;)Lid/dana/promocode/utils/ErrorFlag;", "", "PlaceComponentResult", "Ljava/util/Map;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoCodeErrorMapStrategy {
    private final Map<String, String> PlaceComponentResult;

    public PromoCodeErrorMapStrategy() {
        HashMap hashMap = new HashMap();
        this.PlaceComponentResult = hashMap;
        HashMap hashMap2 = hashMap;
        hashMap2.put("AE15112249106894", "CODE_NOT_VALID");
        hashMap2.put("AE13112249106304", "CODE_EXPIRED");
        hashMap2.put("AE13112249106303", "CODE_EXPIRED");
        hashMap2.put("AE13112249106302", "CODE_EXPIRED");
        hashMap2.put("AE15112249106899", "CODE_EXPIRED");
        hashMap2.put("AE15112249106158", "LIMIT_EXCEEDED");
        hashMap2.put("AE15112249106893", "LIMIT_EXCEEDED");
        hashMap2.put("AE15112249106884", "QUOTA_NOT_ENOUGH");
        hashMap2.put("AE15112249106400", "QUOTA_NOT_ENOUGH");
        hashMap2.put("AE15112249106407", "QUOTA_NOT_ENOUGH");
        hashMap2.put("AE15112249106112", RiskChallengeValue.RISK_REJECT);
        hashMap2.put("AE15112249106013", RiskChallengeValue.RISK_REJECT);
        hashMap2.put("AE15112249106423", RiskChallengeValue.RISK_REJECT);
    }

    public final ErrorFlag getAuthRequestContext(String p0) {
        String str = this.PlaceComponentResult.get(p0);
        if (str != null) {
            return new ErrorFlag(str);
        }
        return new ErrorFlag("CODE_GENERAL_ERROR");
    }
}
