package com.google.android.material.animation;

import android.view.View;

/* loaded from: classes7.dex */
public interface TransformationCallback<T extends View> {
    void onScaleChanged(T t);

    void onTranslationChanged(T t);
}
