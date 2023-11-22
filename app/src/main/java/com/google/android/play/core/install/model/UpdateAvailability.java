package com.google.android.play.core.install.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
/* loaded from: classes3.dex */
public @interface UpdateAvailability {
    public static final int DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS = 3;
    public static final int UNKNOWN = 0;
    public static final int UPDATE_AVAILABLE = 2;
    public static final int UPDATE_NOT_AVAILABLE = 1;
}
