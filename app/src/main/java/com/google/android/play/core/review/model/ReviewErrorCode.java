package com.google.android.play.core.review.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface ReviewErrorCode {
    public static final int INTERNAL_ERROR = -100;
    public static final int INVALID_REQUEST = -2;
    public static final int NO_ERROR = 0;
    public static final int PLAY_STORE_NOT_FOUND = -1;
}
