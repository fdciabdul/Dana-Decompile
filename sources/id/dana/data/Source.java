package id.dana.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface Source {
    public static final String DEVICE = "device";
    public static final String GOOGLE = "google";
    public static final String HERE = "here";
    public static final String LOCAL = "local";
    public static final String MOCK = "mock";
    public static final String NETWORK = "network";
    public static final String SPLIT = "split";
}
