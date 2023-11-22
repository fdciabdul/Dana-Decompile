package com.alibaba.griver.ui.progress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class GriverProgressBar extends ProgressBar {
    public static final int DEFAULT_DURATION = 400;
    public static final int MIN_DURATION = 300;
    public static final String TAG = "H5Progress";

    /* renamed from: a  reason: collision with root package name */
    private ProgressNotifier f6741a;
    private long b;
    private long c;
    private int d;
    private int e;
    private int f;
    private long g;
    private long h;
    private int i;
    private boolean j;
    private Handler k;
    private UpdateRunnable l;

    /* loaded from: classes6.dex */
    public interface ProgressNotifier {
        void onProgressBegin();

        void onProgressEnd();
    }

    public GriverProgressBar(Context context) {
        super(context);
        this.j = false;
        this.k = new Handler(Looper.getMainLooper());
        this.l = new UpdateRunnable();
        a();
    }

    public GriverProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        this.k = new Handler(Looper.getMainLooper());
        this.l = new UpdateRunnable();
        a();
    }

    public GriverProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
        this.k = new Handler(Looper.getMainLooper());
        this.l = new UpdateRunnable();
        a();
    }

    public void setNotifier(ProgressNotifier progressNotifier) {
        this.f6741a = progressNotifier;
    }

    private void a() {
        this.b = 400L;
        setMax(100);
        this.i = -1;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.g = 0L;
        this.d = 0;
        this.f = 0;
        this.e = 0;
    }

    public void setMinDuration(long j) {
        this.b = j;
    }

    public void updateProgress(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.g == 0) {
            this.g = currentTimeMillis;
        }
        int max = getMax();
        double d = i;
        double d2 = max;
        Double.isNaN(d);
        Double.isNaN(d2);
        int i2 = (int) ((d * 0.25d) + (d2 * 0.75d));
        int i3 = this.e;
        if (i2 < i3 || i2 > max) {
            return;
        }
        this.f = i3;
        this.c = currentTimeMillis;
        this.d = i2;
        c();
    }

    private void c() {
        if (isIndeterminate()) {
            GriverLogger.d(TAG, "isIndeterminate");
            return;
        }
        this.h = this.b;
        if (this.d == getMax() && this.f > getMax() / 2) {
            this.h = 300L;
        }
        int i = this.d - this.f;
        if (i > 0) {
            long j = this.h;
            if (j > 0) {
                int i2 = (int) (j / i);
                this.k.removeCallbacks(this.l);
                this.l.setPeriodValue(i2);
                this.l.setdeltaProgressValue(i);
                this.k.postDelayed(this.l, i2);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("setVisibility:");
        sb.append(i);
        GriverLogger.d(TAG, sb.toString());
        if (!this.j || i == 0) {
            super.setVisibility(i);
        } else {
            this.i = i;
        }
    }

    public void hideProgress() {
        GriverLogger.d(TAG, "hideProgress");
        super.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class UpdateRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f6742a;
        private int b;

        UpdateRunnable() {
        }

        public void setPeriodValue(int i) {
            this.f6742a = i;
        }

        public void setdeltaProgressValue(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            GriverProgressBar.this.j = true;
            int max = GriverProgressBar.this.getMax();
            if (max == 0) {
                GriverProgressBar.this.k.removeCallbacks(this);
                GriverProgressBar.this.j = false;
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = GriverProgressBar.this.c;
            if ((GriverProgressBar.this.h * this.b) / max == 0) {
                GriverProgressBar.this.k.removeCallbacks(this);
                GriverProgressBar.this.j = false;
                return;
            }
            int i = GriverProgressBar.this.f + ((int) (((currentTimeMillis - j) * this.b) / GriverProgressBar.this.h));
            if (i <= GriverProgressBar.this.d) {
                if (GriverProgressBar.this.e == 0 && GriverProgressBar.this.f6741a != null) {
                    GriverProgressBar.this.f6741a.onProgressBegin();
                }
                GriverProgressBar.this.setProgress(i);
                GriverProgressBar.this.e = i;
            } else {
                if (i > GriverProgressBar.this.getMax() && GriverProgressBar.this.f6741a != null) {
                    GriverProgressBar.this.f6741a.onProgressEnd();
                }
                if (GriverProgressBar.this.i != -1) {
                    GriverProgressBar griverProgressBar = GriverProgressBar.this;
                    GriverProgressBar.super.setVisibility(griverProgressBar.i);
                    GriverProgressBar.this.i = -1;
                }
            }
            if (i <= GriverProgressBar.this.d) {
                GriverProgressBar.this.k.postDelayed(this, this.f6742a);
                return;
            }
            if (i > GriverProgressBar.this.getMax()) {
                GriverProgressBar.this.b();
            }
            GriverProgressBar.this.k.removeCallbacks(this);
            GriverProgressBar.this.j = false;
        }
    }
}
