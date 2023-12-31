package id.dana.domain.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface KycStatus {
    public static final String DUKCAPIL_INTEGRATION = "DUKCAPIL_INTEGRATION";
    public static final String FAILED = "FAILED";
    public static final String IN_PROGRESS = "IN_PROGRESS";
    public static final String MANUAL_REVIEW = "MANUAL_REVIEW";
    public static final String SUCCESS = "SUCCESS";
    public static final String UNDEFINED = "UNDEFINED";
    public static final String WAITING_DOC = "WAITING_DOC";
}
