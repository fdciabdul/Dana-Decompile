package com.alibaba.griver.video.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.video.base.BasePlayer;

/* loaded from: classes6.dex */
public class GRVTextureView extends TextureView {

    /* renamed from: a  reason: collision with root package name */
    private final String f6788a;
    private MeasureHelper b;
    private BasePlayer c;
    private SurfaceTexture d;
    private Surface e;
    private Handler f;
    private boolean g;
    private boolean h;
    private boolean i;
    private Runnable j;
    private TextureView.SurfaceTextureListener k;

    public GRVTextureView(Context context) {
        super(context);
        StringBuilder sb = new StringBuilder();
        sb.append("[YoukuContainerView]YoukuTextureView[");
        sb.append(hashCode());
        sb.append("]");
        this.f6788a = sb.toString();
        this.b = new MeasureHelper();
        this.d = null;
        this.f = new Handler(Looper.getMainLooper());
        this.h = false;
        this.i = false;
        this.j = new Runnable() { // from class: com.alibaba.griver.video.view.GRVTextureView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GRVTextureView.this.h && GRVTextureView.this.i) {
                    GRVTextureView.this.b();
                }
            }
        };
        TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.alibaba.griver.video.view.GRVTextureView.2
            int count = 0;

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                String str = GRVTextureView.this.f6788a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onSurfaceTextureAvailable, surfaceTexture=");
                sb2.append(surfaceTexture);
                sb2.append(", dimension=");
                sb2.append(i);
                sb2.append("x");
                sb2.append(i2);
                sb2.append(", mSurfaceTexture=");
                sb2.append(GRVTextureView.this.d);
                GriverLogger.w(str, sb2.toString());
                GRVTextureView.this.f.removeCallbacks(GRVTextureView.this.j);
                if (GRVTextureView.this.d == null) {
                    GRVTextureView.this.d = surfaceTexture;
                    GRVTextureView.this.e = new Surface(surfaceTexture);
                    if (GRVTextureView.this.c != null) {
                        if (!GRVTextureView.this.g) {
                            GRVTextureView.this.c.setPlayerSurface(GRVTextureView.this.e, i, i2);
                            return;
                        } else {
                            GriverLogger.d(GRVTextureView.this.f6788a, "Using external surface, ignore onSurfaceTextureAvailable callback");
                            return;
                        }
                    }
                    return;
                }
                GRVTextureView gRVTextureView = GRVTextureView.this;
                gRVTextureView.setSurfaceTexture(gRVTextureView.d);
                if (GRVTextureView.this.c != null) {
                    if (GRVTextureView.this.g || GRVTextureView.this.e == null) {
                        GriverLogger.d(GRVTextureView.this.f6788a, "onSurfaceTextureAvailable, setPlayerSurface Using external surface, ignore onSurfaceTextureAvailable callback");
                    } else {
                        GRVTextureView.this.c.setPlayerSurface(GRVTextureView.this.e, i, i2);
                    }
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                String str = GRVTextureView.this.f6788a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onSurfaceTextureSizeChanged, surfaceTexture=");
                sb2.append(surfaceTexture);
                sb2.append(", dimension=");
                sb2.append(i);
                sb2.append("x");
                sb2.append(i2);
                GriverLogger.w(str, sb2.toString());
                if (GRVTextureView.this.c != null) {
                    String str2 = GRVTextureView.this.f6788a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("onSurfaceTextureSizeChanged, call setPlayerSurface, mPlayerSurface=");
                    sb3.append(GRVTextureView.this.e);
                    GriverLogger.w(str2, sb3.toString());
                    if (GRVTextureView.this.g) {
                        return;
                    }
                    GRVTextureView.this.c.setPlayerSurface(GRVTextureView.this.e, i, i2);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                String str = GRVTextureView.this.f6788a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onSurfaceTextureDestroyed, surfaceTexture=");
                sb2.append(surfaceTexture);
                sb2.append(", do nothing!");
                GriverLogger.w(str, sb2.toString());
                this.count = 0;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (this.count % 10 == 0 && surfaceTexture != null) {
                    String str = GRVTextureView.this.f6788a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onSurfaceTextureUpdated, surface=");
                    sb2.append(surfaceTexture);
                    sb2.append(", pts=");
                    sb2.append(surfaceTexture.getTimestamp() / 1000000);
                    sb2.append(" ms");
                    GriverLogger.d(str, sb2.toString());
                }
                this.count++;
            }
        };
        this.k = surfaceTextureListener;
        setSurfaceTextureListener(surfaceTextureListener);
    }

    public GRVTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        StringBuilder sb = new StringBuilder();
        sb.append("[YoukuContainerView]YoukuTextureView[");
        sb.append(hashCode());
        sb.append("]");
        this.f6788a = sb.toString();
        this.b = new MeasureHelper();
        this.d = null;
        this.f = new Handler(Looper.getMainLooper());
        this.h = false;
        this.i = false;
        this.j = new Runnable() { // from class: com.alibaba.griver.video.view.GRVTextureView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GRVTextureView.this.h && GRVTextureView.this.i) {
                    GRVTextureView.this.b();
                }
            }
        };
        TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.alibaba.griver.video.view.GRVTextureView.2
            int count = 0;

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                String str = GRVTextureView.this.f6788a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onSurfaceTextureAvailable, surfaceTexture=");
                sb2.append(surfaceTexture);
                sb2.append(", dimension=");
                sb2.append(i);
                sb2.append("x");
                sb2.append(i2);
                sb2.append(", mSurfaceTexture=");
                sb2.append(GRVTextureView.this.d);
                GriverLogger.w(str, sb2.toString());
                GRVTextureView.this.f.removeCallbacks(GRVTextureView.this.j);
                if (GRVTextureView.this.d == null) {
                    GRVTextureView.this.d = surfaceTexture;
                    GRVTextureView.this.e = new Surface(surfaceTexture);
                    if (GRVTextureView.this.c != null) {
                        if (!GRVTextureView.this.g) {
                            GRVTextureView.this.c.setPlayerSurface(GRVTextureView.this.e, i, i2);
                            return;
                        } else {
                            GriverLogger.d(GRVTextureView.this.f6788a, "Using external surface, ignore onSurfaceTextureAvailable callback");
                            return;
                        }
                    }
                    return;
                }
                GRVTextureView gRVTextureView = GRVTextureView.this;
                gRVTextureView.setSurfaceTexture(gRVTextureView.d);
                if (GRVTextureView.this.c != null) {
                    if (GRVTextureView.this.g || GRVTextureView.this.e == null) {
                        GriverLogger.d(GRVTextureView.this.f6788a, "onSurfaceTextureAvailable, setPlayerSurface Using external surface, ignore onSurfaceTextureAvailable callback");
                    } else {
                        GRVTextureView.this.c.setPlayerSurface(GRVTextureView.this.e, i, i2);
                    }
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                String str = GRVTextureView.this.f6788a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onSurfaceTextureSizeChanged, surfaceTexture=");
                sb2.append(surfaceTexture);
                sb2.append(", dimension=");
                sb2.append(i);
                sb2.append("x");
                sb2.append(i2);
                GriverLogger.w(str, sb2.toString());
                if (GRVTextureView.this.c != null) {
                    String str2 = GRVTextureView.this.f6788a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("onSurfaceTextureSizeChanged, call setPlayerSurface, mPlayerSurface=");
                    sb3.append(GRVTextureView.this.e);
                    GriverLogger.w(str2, sb3.toString());
                    if (GRVTextureView.this.g) {
                        return;
                    }
                    GRVTextureView.this.c.setPlayerSurface(GRVTextureView.this.e, i, i2);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                String str = GRVTextureView.this.f6788a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onSurfaceTextureDestroyed, surfaceTexture=");
                sb2.append(surfaceTexture);
                sb2.append(", do nothing!");
                GriverLogger.w(str, sb2.toString());
                this.count = 0;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (this.count % 10 == 0 && surfaceTexture != null) {
                    String str = GRVTextureView.this.f6788a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onSurfaceTextureUpdated, surface=");
                    sb2.append(surfaceTexture);
                    sb2.append(", pts=");
                    sb2.append(surfaceTexture.getTimestamp() / 1000000);
                    sb2.append(" ms");
                    GriverLogger.d(str, sb2.toString());
                }
                this.count++;
            }
        };
        this.k = surfaceTextureListener;
        setSurfaceTextureListener(surfaceTextureListener);
    }

    public GRVTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        StringBuilder sb = new StringBuilder();
        sb.append("[YoukuContainerView]YoukuTextureView[");
        sb.append(hashCode());
        sb.append("]");
        this.f6788a = sb.toString();
        this.b = new MeasureHelper();
        this.d = null;
        this.f = new Handler(Looper.getMainLooper());
        this.h = false;
        this.i = false;
        this.j = new Runnable() { // from class: com.alibaba.griver.video.view.GRVTextureView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GRVTextureView.this.h && GRVTextureView.this.i) {
                    GRVTextureView.this.b();
                }
            }
        };
        TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.alibaba.griver.video.view.GRVTextureView.2
            int count = 0;

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                String str = GRVTextureView.this.f6788a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onSurfaceTextureAvailable, surfaceTexture=");
                sb2.append(surfaceTexture);
                sb2.append(", dimension=");
                sb2.append(i2);
                sb2.append("x");
                sb2.append(i22);
                sb2.append(", mSurfaceTexture=");
                sb2.append(GRVTextureView.this.d);
                GriverLogger.w(str, sb2.toString());
                GRVTextureView.this.f.removeCallbacks(GRVTextureView.this.j);
                if (GRVTextureView.this.d == null) {
                    GRVTextureView.this.d = surfaceTexture;
                    GRVTextureView.this.e = new Surface(surfaceTexture);
                    if (GRVTextureView.this.c != null) {
                        if (!GRVTextureView.this.g) {
                            GRVTextureView.this.c.setPlayerSurface(GRVTextureView.this.e, i2, i22);
                            return;
                        } else {
                            GriverLogger.d(GRVTextureView.this.f6788a, "Using external surface, ignore onSurfaceTextureAvailable callback");
                            return;
                        }
                    }
                    return;
                }
                GRVTextureView gRVTextureView = GRVTextureView.this;
                gRVTextureView.setSurfaceTexture(gRVTextureView.d);
                if (GRVTextureView.this.c != null) {
                    if (GRVTextureView.this.g || GRVTextureView.this.e == null) {
                        GriverLogger.d(GRVTextureView.this.f6788a, "onSurfaceTextureAvailable, setPlayerSurface Using external surface, ignore onSurfaceTextureAvailable callback");
                    } else {
                        GRVTextureView.this.c.setPlayerSurface(GRVTextureView.this.e, i2, i22);
                    }
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
                String str = GRVTextureView.this.f6788a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onSurfaceTextureSizeChanged, surfaceTexture=");
                sb2.append(surfaceTexture);
                sb2.append(", dimension=");
                sb2.append(i2);
                sb2.append("x");
                sb2.append(i22);
                GriverLogger.w(str, sb2.toString());
                if (GRVTextureView.this.c != null) {
                    String str2 = GRVTextureView.this.f6788a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("onSurfaceTextureSizeChanged, call setPlayerSurface, mPlayerSurface=");
                    sb3.append(GRVTextureView.this.e);
                    GriverLogger.w(str2, sb3.toString());
                    if (GRVTextureView.this.g) {
                        return;
                    }
                    GRVTextureView.this.c.setPlayerSurface(GRVTextureView.this.e, i2, i22);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                String str = GRVTextureView.this.f6788a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onSurfaceTextureDestroyed, surfaceTexture=");
                sb2.append(surfaceTexture);
                sb2.append(", do nothing!");
                GriverLogger.w(str, sb2.toString());
                this.count = 0;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (this.count % 10 == 0 && surfaceTexture != null) {
                    String str = GRVTextureView.this.f6788a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onSurfaceTextureUpdated, surface=");
                    sb2.append(surfaceTexture);
                    sb2.append(", pts=");
                    sb2.append(surfaceTexture.getTimestamp() / 1000000);
                    sb2.append(" ms");
                    GriverLogger.d(str, sb2.toString());
                }
                this.count++;
            }
        };
        this.k = surfaceTextureListener;
        setSurfaceTextureListener(surfaceTextureListener);
    }

    public void setRendMode(String str, RectF rectF, int i) {
        this.b.setRendMode(str, rectF, i);
    }

    public void setFullScreen(boolean z) {
        this.b.setFullScreen(z);
        requestLayout();
    }

    public void setPlayerView(BasePlayer basePlayer) {
        String str = this.f6788a;
        StringBuilder sb = new StringBuilder();
        sb.append("setPlayerView, player=");
        sb.append(basePlayer);
        GriverLogger.d(str, sb.toString());
        this.c = basePlayer;
        if (isAvailable()) {
            GriverLogger.d(this.f6788a, "setPlayerView, is already available, call onSurfaceTextureAvailable myself");
            this.k.onSurfaceTextureAvailable(getSurfaceTexture(), getWidth(), getHeight());
            return;
        }
        setSurfaceTextureListener(this.k);
    }

    public void setVideoSize(int i, int i2) {
        this.b.setVideoSize(i, i2);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        String str = this.f6788a;
        StringBuilder sb = new StringBuilder();
        sb.append("onMeasure, width=");
        sb.append(View.MeasureSpec.getSize(i));
        sb.append(", height=");
        sb.append(View.MeasureSpec.getSize(i2));
        GriverLogger.d(str, sb.toString());
        try {
            this.b.doMeasure(i, i2);
        } catch (Throwable th) {
            String str2 = this.f6788a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onMeasure, doMeasure Exception, t=");
            sb2.append(th);
            GriverLogger.d(str2, sb2.toString());
        }
        String str3 = this.f6788a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("onMeasure, after doMeasure, size=");
        sb3.append(this.b.getMeasuredWidth());
        sb3.append("x");
        sb3.append(this.b.getMeasuredHeight());
        GriverLogger.d(str3, sb3.toString());
        setMeasuredDimension(this.b.getMeasuredWidth(), this.b.getMeasuredHeight());
        GriverLogger.d(this.f6788a, "onMeasure, after setMeasuredDimension");
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        String str = this.f6788a;
        StringBuilder sb = new StringBuilder();
        sb.append("onLayout, changed=");
        sb.append(z);
        sb.append(", left=");
        sb.append(i);
        sb.append(", top=");
        sb.append(i2);
        sb.append(", right=");
        sb.append(i3);
        sb.append(", bottom =");
        sb.append(i4);
        GriverLogger.d(str, sb.toString());
        if ((z || this.b.isNeedRelayout()) && getWidth() > 0 && getHeight() > 0) {
            String str2 = this.f6788a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onLayout, changed=");
            sb2.append(z);
            sb2.append(", width=");
            sb2.append(getWidth());
            sb2.append(", height=");
            sb2.append(getHeight());
            GriverLogger.d(str2, sb2.toString());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", 0.0f, this.b.getOffsetX() * (-1));
            ofFloat.setDuration(0L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "translationY", 0.0f, this.b.getOffsetY() * (-1));
            ofFloat2.setDuration(0L);
            ofFloat.start();
            ofFloat2.start();
            this.b.resetNeedLayout();
        }
    }

    public void setReleased(boolean z) {
        String str = this.f6788a;
        StringBuilder sb = new StringBuilder();
        sb.append("setReleased called, isReleased=");
        sb.append(z);
        GriverLogger.d(str, sb.toString());
        this.i = z;
    }

    public void releaseSurface() {
        synchronized (this) {
            GriverLogger.d(this.f6788a, "releaseSurface called, call realRelease");
            this.i = true;
            try {
                GriverLogger.d(this.f6788a, "releaseSurface called, call realRelease");
                a();
            } catch (Throwable th) {
                GriverLogger.e(this.f6788a, "", th);
            }
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GriverLogger.e(this.f6788a, "onAttachedToWindow");
        this.f.removeCallbacks(this.j);
        this.h = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        GriverLogger.e(this.f6788a, "onDetachedFromWindow");
        super.onDetachedFromWindow();
        this.h = true;
        try {
            GriverLogger.e(this.f6788a, "onDetachedFromWindow, call realRelease");
            a();
        } catch (Throwable th) {
            GriverLogger.e(this.f6788a, "", th);
        }
    }

    private void a() {
        if (this.i && this.h) {
            this.f.postDelayed(this.j, 0L);
        }
    }

    public void setUsingExternalSurface(boolean z) {
        this.g = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Surface surface = this.e;
        if (surface != null) {
            surface.release();
            this.e = null;
        }
        SurfaceTexture surfaceTexture = this.d;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.d = null;
        }
    }
}
