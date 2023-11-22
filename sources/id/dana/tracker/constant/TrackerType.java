package id.dana.tracker.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface TrackerType {
    public static final String APPSFLYER = "apssflyer";
    public static final String BRANCH = "branch";
    public static final String FIREBASE = "firebase";
    public static final String FULLSTORY = "fullstory";
    public static final String MIXPANEL = "mixpanel";
}
