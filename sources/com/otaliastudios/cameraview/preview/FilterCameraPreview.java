package com.otaliastudios.cameraview.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.otaliastudios.cameraview.filter.Filter;

/* loaded from: classes2.dex */
public abstract class FilterCameraPreview<T extends View, Output> extends CameraPreview<T, Output> {
    public abstract void BuiltInFictitiousFunctionClassFactory(Filter filter);

    public abstract Filter getErrorConfigVersion();

    public FilterCameraPreview(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }
}
