package id.dana.danah5.danaprotection;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danah5/danaprotection/DanaProtectionKey;", "", "<init>", "()V", "DanaProtectionResultParamsKey", "EventName"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DanaProtectionKey {
    public static final DanaProtectionKey INSTANCE = new DanaProtectionKey();

    private DanaProtectionKey() {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/danah5/danaprotection/DanaProtectionKey$EventName;", "", "", "GET_RECOMMENDATION", "Ljava/lang/String;", "HANDLE_RISK_CHALLENGE", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class EventName {
        public static final String GET_RECOMMENDATION = "getRecommendation";
        public static final String HANDLE_RISK_CHALLENGE = "handleRiskChallenge";
        public static final EventName INSTANCE = new EventName();

        private EventName() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004"}, d2 = {"Lid/dana/danah5/danaprotection/DanaProtectionKey$DanaProtectionResultParamsKey;", "", "", "CALL_API_SUCCESS", "Ljava/lang/String;", "PROTECTED_ACTIVITY", "RECOMMENDATION", "RECOMMENDATION_DATA", "RISK_CHALLENGE_SUCCESS", "SUCCESS", "SUSPICIOUS_ACTIVITY", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class DanaProtectionResultParamsKey {
        public static final String CALL_API_SUCCESS = "callAPISuccess";
        public static final DanaProtectionResultParamsKey INSTANCE = new DanaProtectionResultParamsKey();
        public static final String PROTECTED_ACTIVITY = "protectedActivity";
        public static final String RECOMMENDATION = "recommendation";
        public static final String RECOMMENDATION_DATA = "recommendationData";
        public static final String RISK_CHALLENGE_SUCCESS = "riskChallengeSuccess";
        public static final String SUCCESS = "success";
        public static final String SUSPICIOUS_ACTIVITY = "suspiciousActicity";

        private DanaProtectionResultParamsKey() {
        }
    }
}
