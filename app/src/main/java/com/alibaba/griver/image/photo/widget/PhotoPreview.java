package com.alibaba.griver.image.photo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.alibaba.griver.image.R;

/* loaded from: classes6.dex */
public class PhotoPreview extends FrameLayout {
    public static final String TAG = "PreviewPhoto";

    /* renamed from: a  reason: collision with root package name */
    private PhotoView f6632a;
    private ProgressBar b;
    private FrameLayout c;
    private CircleProgressBar d;
    private int e;

    public boolean isPhotoType() {
        return this.e == 0;
    }

    public PhotoPreview(Context context) {
        super(context);
        this.e = 0;
    }

    public PhotoPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.c = (FrameLayout) findViewById(R.id.photoZone);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_loading);
        this.b = progressBar;
        progressBar.bringToFront();
        this.f6632a = (PhotoView) findViewById(R.id.iv_content);
        this.d = (CircleProgressBar) findViewById(R.id.pb_exactly_progress);
    }

    public void changeViewType(int i) {
        this.e = i;
        if (i == 0) {
            this.c.setVisibility(0);
        } else if (i == 1 || i == 2) {
            this.c.setVisibility(8);
        } else if (i == 10) {
            this.c.setVisibility(8);
        }
    }

    public PhotoView getPhotoView() {
        return this.f6632a;
    }

    public void setProgress(int i) {
        if (this.d.getVisibility() == 0) {
            this.d.setProgress(i);
        }
    }

    public void showProgress(boolean z) {
        if (z) {
            this.b.setVisibility(8);
            this.d.setVisibility(0);
            return;
        }
        this.b.setVisibility(0);
        this.d.setVisibility(8);
    }

    public void dismissProgress() {
        this.b.setVisibility(8);
        this.d.setVisibility(8);
    }
}
