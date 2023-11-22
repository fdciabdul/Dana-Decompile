package id.dana.domain.featureconfig;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface KnowledgeBasedAuthType {
    public static final String FORGOT_PIN = "forgot_pin";
    public static final String SECURITY_SETTING = "security_setting";
}
