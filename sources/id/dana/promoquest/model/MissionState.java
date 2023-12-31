package id.dana.promoquest.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface MissionState {
    public static final String ACTIVE = "ACTIVE";
    public static final String CLOSE = "CLOSE";
    public static final String COMPLETE = "COMPLETE";
    public static final String FINISH = "FINISH";
    public static final String INIT = "INIT";
}
