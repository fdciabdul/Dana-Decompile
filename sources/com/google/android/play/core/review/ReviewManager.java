package com.google.android.play.core.review;

import android.app.Activity;
import com.google.android.gms.tasks.Task;

/* loaded from: classes7.dex */
public interface ReviewManager {
    Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo);

    Task<ReviewInfo> requestReviewFlow();
}
