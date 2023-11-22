package com.alibaba.griver.ui.blur;

import android.graphics.Bitmap;

/* loaded from: classes6.dex */
public class StackBlurManager {
    static final int EXECUTOR_THREADS = 2;

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f6707a;
    private final BlurProcess b = new JavaBlurProcess();
    private Bitmap c;

    public StackBlurManager(Bitmap bitmap) {
        this.f6707a = bitmap;
    }

    public Bitmap process(int i) {
        Bitmap blur = this.b.blur(this.f6707a, i);
        this.c = blur;
        return blur;
    }
}
