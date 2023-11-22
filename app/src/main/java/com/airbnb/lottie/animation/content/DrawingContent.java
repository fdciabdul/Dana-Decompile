package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* loaded from: classes3.dex */
public interface DrawingContent extends Content {
    void getAuthRequestContext(Canvas canvas, Matrix matrix, int i);

    void getAuthRequestContext(RectF rectF, Matrix matrix, boolean z);
}
