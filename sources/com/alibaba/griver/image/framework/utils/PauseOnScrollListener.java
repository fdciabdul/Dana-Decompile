package com.alibaba.griver.image.framework.utils;

import android.widget.AbsListView;
import com.alibaba.griver.base.common.utils.ReflectUtils;
import com.alibaba.griver.image.GriverImageService;
import com.alibaba.griver.image.impl.GriverPicassoExtensionImpl;
import com.squareup.picasso.Picasso;

/* loaded from: classes6.dex */
public class PauseOnScrollListener implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f6594a;
    private final boolean b;
    private final boolean c = ReflectUtils.classExist(GriverPicassoExtensionImpl.PICASSO_CLASS_STR);
    private final boolean d = ReflectUtils.methodExist(GriverPicassoExtensionImpl.PICASSO_CLASS_STR, "get");
    private final AbsListView.OnScrollListener e;

    public PauseOnScrollListener(boolean z, boolean z2, AbsListView.OnScrollListener onScrollListener) {
        this.f6594a = z;
        this.b = z2;
        this.e = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0) {
            if (i == 1) {
                if (this.f6594a && this.c && this.d) {
                    Picasso.get().cancelTag(GriverImageService.IMAGE_TAG);
                }
            } else if (i == 2 && this.b && this.c && this.d) {
                Picasso.get().cancelTag(GriverImageService.IMAGE_TAG);
            }
        } else if (this.c && this.d) {
            Picasso.get().resumeTag(GriverImageService.IMAGE_TAG);
        }
        AbsListView.OnScrollListener onScrollListener = this.e;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.e;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }
}
