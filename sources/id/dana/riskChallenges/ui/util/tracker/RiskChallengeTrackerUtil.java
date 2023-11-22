package id.dana.riskChallenges.ui.util.tracker;

import id.dana.riskChallenges.constant.RiskChallengeKey;
import id.dana.riskChallenges.ui.util.mapper.RiskChallengeMapper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/riskChallenges/ui/util/tracker/RiskChallengeTrackerUtil;", "", "", "p0", "", "p1", "getAuthRequestContext", "(ZLjava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RiskChallengeTrackerUtil {
    public static final RiskChallengeTrackerUtil INSTANCE = new RiskChallengeTrackerUtil();

    private RiskChallengeTrackerUtil() {
    }

    public static String getAuthRequestContext(boolean p0, @RiskChallengeKey String p1) {
        if (p0) {
            RiskChallengeMapper riskChallengeMapper = RiskChallengeMapper.INSTANCE;
            if (p1 == null) {
                p1 = "";
            }
            String BuiltInFictitiousFunctionClassFactory = RiskChallengeMapper.BuiltInFictitiousFunctionClassFactory(p1);
            StringBuilder sb = new StringBuilder();
            sb.append(BuiltInFictitiousFunctionClassFactory);
            sb.append(" Fallback");
            return sb.toString();
        }
        return "Direct Challenge";
    }
}
