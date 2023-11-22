package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {
    private int[] PlaceComponentResult;
    private SizeViewTarget getAuthRequestContext;

    /* loaded from: classes7.dex */
    static final class SizeViewTarget extends CustomViewTarget<View, Object> {
        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public final void MyBillsEntityDataFactory(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void onLoadFailed(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void onResourceReady(Object obj, Transition<? super Object> transition) {
        }
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public final int[] PlaceComponentResult() {
        int[] iArr = this.PlaceComponentResult;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public final void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        this.PlaceComponentResult = new int[]{i, i2};
        this.getAuthRequestContext = null;
    }
}
