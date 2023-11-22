package id.dana.domain.foundation.logger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface LoginScenarioConstant {
    public static final String LOGIN = "normalLogin";
    public static final String OTPLOGIN = "otpLogin";
    public static final String TRUSTRISKLOGIN = "trustRiskLogin";
    public static final String TRUSTRISKLOGINV2 = "trustRiskLoginV2";
}
