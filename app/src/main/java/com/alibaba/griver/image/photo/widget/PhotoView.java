package com.alibaba.griver.image.photo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.image.photo.utils.PhotoUtil;
import com.fullstory.instrumentation.FSDraw;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* loaded from: classes6.dex */
public class PhotoView extends ImageView {
    public static final String TAG = "PhotoView";

    /* renamed from: a  reason: collision with root package name */
    private static int f6633a = 2048;
    private static boolean b;
    private static boolean c;
    private boolean A;
    private boolean B;
    private View.OnLongClickListener C;
    private View.OnClickListener D;
    private boolean E;
    private int F;
    private boolean d;
    public int defaultDrawableHashCode;
    private int e;
    private DragDetector f;
    public int failDrawableHashCode;
    private ScaleGestureDetector g;
    private GestureDetector h;
    private GridDetector i;
    private Matrix j;
    private float[] k;
    private State l;
    private float m;
    private float n;

    /* renamed from: o  reason: collision with root package name */
    private float f6634o;
    private float p;
    private float q;
    private int r;
    private int s;
    private RectF t;
    public int thumbDrawableHashCode;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private FlingRunnable y;
    private boolean z;

    /* loaded from: classes6.dex */
    public interface SimpleDragListener {
        void onDrag(float f, float f2);

        void onDragBegin();

        void onDragEnd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public enum State {
        NONE,
        DRAG,
        SCALE,
        FLING,
        TRANSLATE
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(float f, float f2, float f3, float f4) {
        if (f4 - f3 <= f2 || f == 0.0f) {
            return 0.0f;
        }
        if (f > 0.0f && f3 + f > 0.0f) {
            float f5 = 0.0f - f3;
            return f5 <= f ? f5 : f;
        } else if (f >= 0.0f || f4 + f >= f2) {
            return f;
        } else {
            float f6 = f2 - f4;
            return f6 < f ? f : f6;
        }
    }

    @Deprecated
    public void setForceFullScreen(boolean z) {
    }

    static {
        c = Build.VERSION.SDK_INT >= 14;
    }

    public void setDisplayType(int i) {
        this.e = i;
    }

    public void setInitToMaxSquare(boolean z) {
        this.d = z;
    }

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 2;
        a();
    }

    private void a() {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.m = 1.0f;
        this.x = true;
        this.w = false;
        this.j = new Matrix();
        this.l = State.NONE;
        this.t = new RectF();
        this.k = new float[9];
        Context context = getContext();
        this.f = new DragDetector(new DragListener());
        this.g = new ScaleGestureDetector(context, new ScaleListener());
        this.h = new GestureDetector(context.getApplicationContext(), new GestureListener());
        setEnableCrop(false);
        setClickable(true);
        setEnableScale(true);
        if (c) {
            return;
        }
        f6633a = getMaxTextureSize();
    }

    public void setFitSpace(boolean z) {
        this.x = z;
    }

    public void setEnableScale(boolean z) {
        this.z = z;
    }

    public void setCropSquare(boolean z) {
        this.B = z;
    }

    public boolean getEnableCrop() {
        return this.A;
    }

    public void setEnableCrop(boolean z) {
        this.A = z;
        if (z) {
            GridDetector gridDetector = new GridDetector();
            this.i = gridDetector;
            gridDetector.initRect();
        } else {
            this.i = null;
        }
        invalidate();
    }

    public Bitmap applyCrop() {
        if (this.j != null && this.w && this.A) {
            Drawable drawable = getDrawable();
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                RectF rect = this.i.getRect();
                Bitmap createBitmap = Bitmap.createBitmap((int) (rect.right - rect.left), (int) (rect.bottom - rect.top), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.translate(-rect.left, -rect.top);
                canvas.drawBitmap(bitmap, this.j, null);
                return createBitmap;
            }
            return null;
        }
        return null;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        e();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        e();
        a(bitmap, (Drawable) null);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        e();
        a((Bitmap) null, drawable);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        setImageMatrix(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(State state) {
        this.l = state;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (c) {
            a(canvas);
        }
        if (this.A) {
            this.i.draw(canvas);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.A ? this.i.onTouchEvent(motionEvent) : false;
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            this.E = false;
        }
        if (action == 5) {
            this.E = true;
        }
        if (!onTouchEvent && this.z) {
            this.g.onTouchEvent(motionEvent);
            this.h.onTouchEvent(motionEvent);
            this.f.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onShow() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        a((Bitmap) null, drawable);
    }

    private boolean c() {
        if (PhotoBrowseView.gDisablePhotoViewHardwareAcc) {
            if (Build.VERSION.SDK_INT >= 11 && isHardwareAccelerated()) {
                setLayerType(1, null);
            }
            return true;
        }
        return false;
    }

    private void a(Bitmap bitmap, Drawable drawable) {
        if (!c() && Build.VERSION.SDK_INT >= 11) {
            int i = 0;
            if (bitmap == null && drawable != null) {
                i = Math.max(drawable.getMinimumHeight(), drawable.getMinimumWidth());
            }
            if (bitmap != null) {
                i = Math.max(bitmap.getWidth(), bitmap.getHeight());
            }
            if (i > f6633a) {
                if (getLayerType() != 1) {
                    setLayerType(1, null);
                }
            } else if (getLayerType() != 2) {
                setLayerType(2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class GridDetector implements FSDraw {
        private int c;
        private int f;
        private int g;
        private float h;
        private int i;
        private RectF d = new RectF();
        private RectF e = new RectF();

        /* renamed from: a  reason: collision with root package name */
        private PointF f6637a = new PointF();
        private Paint b = new Paint();

        public GridDetector() {
            this.g = PhotoUtil.dp2px(PhotoView.this.getContext(), 30);
            this.f = PhotoUtil.dp2px(PhotoView.this.getContext(), 4);
            this.i = PhotoUtil.dp2px(PhotoView.this.getContext(), 2);
            this.h = this.g * 4.0f;
            this.b.setColor(-1);
            this.b.setStyle(Paint.Style.STROKE);
        }

        public RectF getRect() {
            return this.d;
        }

        public void draw(Canvas canvas) {
            int dp2px = PhotoUtil.dp2px(PhotoView.this.getContext(), 6);
            int i = this.f;
            this.b.setStrokeWidth(i / 3);
            float f = i / 2;
            this.e.set(this.d.left + f, this.d.top + f, this.d.right - f, this.d.bottom - f);
            canvas.drawLine(this.d.centerX(), this.d.top, this.d.centerX(), this.d.bottom, this.b);
            canvas.drawLine(this.d.left, this.d.centerY(), this.d.right, this.d.centerY(), this.b);
            this.b.setStyle(Paint.Style.FILL);
            Path path = new Path();
            float f2 = dp2px;
            path.moveTo(this.d.centerX() - f2, this.d.centerY());
            path.lineTo(this.d.centerX(), this.d.centerY() - f2);
            path.lineTo(this.d.centerX() + f2, this.d.centerY());
            path.lineTo(this.d.centerX(), this.d.centerY() + f2);
            path.close();
            canvas.drawPath(path, this.b);
            path.reset();
            path.moveTo(this.d.left, this.d.top);
            float f3 = dp2px * 2;
            path.lineTo(this.d.left + f3, this.d.top);
            path.lineTo(this.d.left, this.d.top + f3);
            path.close();
            canvas.drawPath(path, this.b);
            path.reset();
            path.moveTo(this.d.right, this.d.top);
            path.lineTo(this.d.right - f3, this.d.top);
            path.lineTo(this.d.right, this.d.top + f3);
            path.close();
            canvas.drawPath(path, this.b);
            path.reset();
            path.moveTo(this.d.left, this.d.bottom);
            path.lineTo(this.d.left + f3, this.d.bottom);
            path.lineTo(this.d.left, this.d.bottom - f3);
            path.close();
            canvas.drawPath(path, this.b);
            path.reset();
            path.moveTo(this.d.right, this.d.bottom);
            path.lineTo(this.d.right - f3, this.d.bottom);
            path.lineTo(this.d.right, this.d.bottom - f3);
            path.close();
            canvas.drawPath(path, this.b);
            if (Build.VERSION.SDK_INT >= 28) {
                this.b.setStrokeWidth(this.f);
                this.b.setStyle(Paint.Style.STROKE);
                this.b.setStrokeWidth(this.f);
                canvas.drawRect(this.d, this.b);
                return;
            }
            canvas.clipRect(this.e, Region.Op.XOR);
            canvas.drawColor(1711276032);
            this.b.setStrokeWidth(this.f);
            this.b.setStyle(Paint.Style.STROKE);
            canvas.drawRect(this.e, this.b);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.c = a(motionEvent);
                this.f6637a.set(motionEvent.getX(), motionEvent.getY());
            } else if (action == 5 || action == 1 || action == 6) {
                this.c = 0;
            } else if (action == 2 && this.c != 0) {
                b(motionEvent);
                PhotoView.this.invalidate();
            }
            return this.c != 0;
        }

        public void initRect() {
            float min;
            float width = ((float) PhotoView.this.u) > PhotoView.this.t.width() ? PhotoView.this.t.width() : PhotoView.this.u;
            float height = ((float) PhotoView.this.v) > PhotoView.this.t.height() ? PhotoView.this.t.height() : PhotoView.this.v;
            if (PhotoView.this.d) {
                min = Math.min(width, height) - this.i;
            } else {
                min = (Math.min(width, height) * 2.0f) / 3.0f;
            }
            this.d.set((PhotoView.this.u - min) / 2.0f, (PhotoView.this.v - min) / 2.0f, (PhotoView.this.u + min) / 2.0f, (PhotoView.this.v + min) / 2.0f);
        }

        private int a(MotionEvent motionEvent) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (y >= this.d.top - this.g && y <= this.d.bottom + this.g) {
                r2 = Math.abs(x - this.d.left) < ((float) this.g) ? 1 : 0;
                if (Math.abs(x - this.d.right) < this.g) {
                    r2 |= 4;
                }
            }
            if (x >= this.d.left - this.g && x <= this.d.right + this.g) {
                if (Math.abs(y - this.d.top) < this.g) {
                    r2 |= 2;
                }
                if (Math.abs(y - this.d.bottom) < this.g) {
                    r2 |= 8;
                }
            }
            if (Math.abs(x - ((this.d.left + this.d.right) / 2.0f)) < this.g && Math.abs(y - ((this.d.top + this.d.bottom) / 2.0f)) < this.g) {
                r2 = 16;
            }
            if (PhotoView.this.B && PhotoUtil.isPowerOfTwo(r2)) {
                return 16;
            }
            return r2;
        }

        private void b(MotionEvent motionEvent) {
            float x = motionEvent.getX() - this.f6637a.x;
            float y = motionEvent.getY() - this.f6637a.y;
            this.f6637a.set(motionEvent.getX(), motionEvent.getY());
            float f = PhotoView.this.t.left > 0.0f ? PhotoView.this.t.left : 0.0f;
            float f2 = PhotoView.this.t.top > 0.0f ? PhotoView.this.t.top : 0.0f;
            float f3 = PhotoView.this.t.right > ((float) PhotoView.this.u) ? PhotoView.this.u : PhotoView.this.t.right;
            float f4 = PhotoView.this.t.bottom > ((float) PhotoView.this.v) ? PhotoView.this.v : PhotoView.this.t.bottom;
            if ((this.c & 16) == 0) {
                if (PhotoView.this.B && this.c != 16) {
                    float f5 = this.d.left - f;
                    float f6 = this.d.top - f2;
                    float f7 = f3 - this.d.right;
                    float f8 = f4 - this.d.bottom;
                    if (x > 0.0f) {
                        if (x >= f7) {
                            x = f7;
                        }
                    } else if ((-x) >= f5) {
                        x = -f5;
                    }
                    if (y > 0.0f) {
                        if (y >= f8) {
                            y = f8;
                        }
                    } else if ((-y) >= f6) {
                        y = -f6;
                    }
                    float min = Math.min(Math.abs(x), Math.abs(y));
                    if (min == 0.0f) {
                        return;
                    }
                    x = (x / Math.abs(x)) * min;
                    y = (y / Math.abs(y)) * min;
                }
                if ((this.c & 1) != 0) {
                    if (this.d.left + x < f) {
                        x = f - this.d.left;
                    }
                    if (this.d.left + x + this.h > this.d.right) {
                        x = (this.d.right - this.d.left) - this.h;
                    }
                    this.d.left += x;
                }
                if ((this.c & 2) != 0) {
                    if (this.d.top + y < f2) {
                        y = f2 - this.d.top;
                    }
                    if (this.d.top + y + this.h > this.d.bottom) {
                        y = (this.d.bottom - this.d.top) - this.h;
                    }
                    this.d.top += y;
                }
                if ((this.c & 4) != 0) {
                    if (this.d.right + x > f3) {
                        x = f3 - this.d.right;
                    }
                    if ((this.d.right + x) - this.h < this.d.left) {
                        x = this.d.left + (this.h - this.d.right);
                    }
                    this.d.right += x;
                }
                if ((this.c & 8) != 0) {
                    if (this.d.bottom + y > f4) {
                        y = f4 - this.d.bottom;
                    }
                    if ((this.d.bottom + y) - this.h < this.d.top) {
                        y = (this.h - this.d.bottom) + this.d.top;
                    }
                    this.d.bottom += y;
                    return;
                }
                return;
            }
            RectF rectF = new RectF(this.d);
            rectF.offset(x, y);
            if (rectF.top < f2 || rectF.left < f || rectF.right > f3 || rectF.bottom > f4) {
                return;
            }
            this.d.offset(x, y);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.u = ((i3 - i) - getPaddingLeft()) - getPaddingRight();
            this.v = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class DragListener implements SimpleDragListener {
        private DragListener() {
        }

        @Override // com.alibaba.griver.image.photo.widget.PhotoView.SimpleDragListener
        public void onDragBegin() {
            PhotoView.this.setState(State.DRAG);
        }

        @Override // com.alibaba.griver.image.photo.widget.PhotoView.SimpleDragListener
        public void onDrag(float f, float f2) {
            if (PhotoView.this.l != State.DRAG) {
                return;
            }
            float f3 = PhotoView.this.t.left;
            float f4 = PhotoView.this.t.top;
            float f5 = PhotoView.this.t.bottom;
            float f6 = PhotoView.this.t.right;
            PhotoView.this.a(PhotoView.this.a(f, r4.u, f3, f6), PhotoView.this.a(f2, r0.v, f4, f5));
        }

        @Override // com.alibaba.griver.image.photo.widget.PhotoView.SimpleDragListener
        public void onDragEnd() {
            if (PhotoView.this.l == State.DRAG) {
                PhotoView.this.setState(State.NONE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        private GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            RVLogger.d(PhotoView.TAG, "onSingleTapConfirmed");
            if (PhotoView.this.D != null) {
                PhotoView.this.D.onClick(PhotoView.this);
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PhotoView.this.C != null) {
                PhotoView.this.C.onLongClick(PhotoView.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (PhotoView.this.l == State.NONE || PhotoView.this.l == State.FLING || PhotoView.this.l == State.DRAG) {
                if (PhotoView.this.y != null) {
                    PhotoView.this.y.cancelFling();
                }
                PhotoView photoView = PhotoView.this;
                photoView.y = new FlingRunnable((int) f, (int) f2);
                PhotoView photoView2 = PhotoView.this;
                photoView2.a(photoView2.y);
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (PhotoView.this.l != State.NONE) {
                return false;
            }
            double abs = Math.abs(PhotoView.this.m - PhotoView.this.f6634o);
            PhotoView photoView = PhotoView.this;
            float f = abs <= 0.001d ? photoView.p : photoView.f6634o;
            PhotoView.this.a(new ScaleRunnable(f, PhotoView.this.a(f, new PointF(motionEvent.getX(), motionEvent.getY()))));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f6639a;

        private ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            if (PhotoView.this.E) {
                this.f6639a = PhotoView.this.m >= PhotoView.this.p;
                PhotoView.this.setState(State.SCALE);
                return true;
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float f;
            float f2;
            if (PhotoView.this.l == State.NONE || PhotoView.this.l == State.SCALE) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                float focusX = scaleGestureDetector.getFocusX();
                float focusY = scaleGestureDetector.getFocusY();
                float f3 = PhotoView.this.m * scaleFactor;
                if (f3 >= PhotoView.this.p) {
                    f = PhotoView.this.p;
                    f2 = PhotoView.this.m;
                } else if (this.f6639a || f3 <= PhotoView.this.p) {
                    if (f3 < PhotoView.this.n) {
                        f = PhotoView.this.n;
                        f2 = PhotoView.this.m;
                    }
                    PhotoView.this.a(scaleFactor, focusX, focusY);
                    PhotoView.this.b();
                    return true;
                } else {
                    f = PhotoView.this.p;
                    f2 = PhotoView.this.m;
                }
                scaleFactor = f / f2;
                PhotoView.this.a(scaleFactor, focusX, focusY);
                PhotoView.this.b();
                return true;
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            super.onScaleEnd(scaleGestureDetector);
            this.f6639a = false;
            if (PhotoView.this.l != State.SCALE) {
                return;
            }
            PhotoView.this.setState(State.NONE);
            if (!PhotoView.this.a(new PointF(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()))) {
                if (PhotoView.this.d()) {
                    RVLogger.d(PhotoView.TAG, "adjustToBounds");
                    return;
                }
                return;
            }
            RVLogger.d(PhotoView.TAG, "adjustToScale");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        float f = this.t.left;
        float f2 = this.t.top;
        float f3 = this.t.right;
        float f4 = this.t.bottom;
        float width = (this.u - this.t.width()) / 2.0f;
        float height = (this.v - this.t.height()) / 2.0f;
        float f5 = f > 0.0f ? width > 0.0f ? width - f : -f : 0.0f;
        float f6 = f2 > 0.0f ? height > 0.0f ? height - f2 : -f2 : 0.0f;
        float f7 = this.u;
        if (f3 < f7) {
            f5 = width > 0.0f ? (f7 - f3) - width : f7 - f3;
        }
        float f8 = this.v;
        if (f4 < f8) {
            f6 = height > 0.0f ? (f8 - f4) - height : f8 - f4;
        }
        if ((f5 == 0.0f && f6 == 0.0f) ? false : true) {
            post(new TransRunnable(f5, f6));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(PointF pointF) {
        float f = this.m;
        float f2 = this.p;
        if (f >= f2) {
            return true;
        }
        float f3 = this.q;
        if (f > f3) {
            f2 = f3;
        } else if (f <= f2) {
            f2 = this.f6634o;
            if (f >= f2) {
                f2 = -1.0f;
            }
        }
        if (f2 == -1.0f) {
            return false;
        }
        a(new ScaleRunnable(f2, a(f2, pointF)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF a(float f, PointF pointF) {
        if (pointF == null) {
            pointF = new PointF(this.u / 2, this.v / 2);
        }
        Matrix matrix = new Matrix(this.j);
        float f2 = f / this.m;
        matrix.postScale(f2, f2, pointF.x, pointF.y);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float f3 = fArr[2];
        float f4 = fArr[5];
        float f5 = this.r * f;
        float f6 = f5 + f3;
        float f7 = this.s * f;
        float f8 = f7 + f4;
        if (f3 > 0.0f || f4 > 0.0f || f6 < this.u || f8 < this.v) {
            float f9 = this.t.left;
            float f10 = this.t.top;
            if (f3 >= 0.0f) {
                f3 = 0.0f;
            }
            if (f4 >= 0.0f) {
                f4 = 0.0f;
            }
            float f11 = this.u;
            if (f5 <= f11) {
                f3 = (f11 - f5) / 2.0f;
            } else if (f6 < f11) {
                f3 = f11 - f5;
            }
            float f12 = this.v;
            if (f7 <= f12) {
                f4 = (f12 - f7) / 2.0f;
            } else if (f8 < f12) {
                f4 = f12 - f7;
            }
            return new PointF(((f9 * f5) - (f3 * this.t.width())) / (f5 - this.t.width()), ((f10 * f7) - (f4 * this.t.height())) / (f7 - this.t.height()));
        }
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimation(runnable);
        } else {
            postDelayed(runnable, 16L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class TransRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private float f6641a;
        private float b;
        private float c = 0.0f;
        private PhotoInter d;

        public TransRunnable(float f, float f2) {
            this.d = new PhotoInter(new LinearInterpolator(), 150.0f);
            this.f6641a = f;
            this.b = f2;
            PhotoView.this.setState(State.TRANSLATE);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PhotoView.this.l != State.NONE && PhotoView.this.l != State.TRANSLATE) {
                StringBuilder sb = new StringBuilder();
                sb.append("cancel translate for current state ");
                sb.append(PhotoView.this.l);
                RVLogger.d(PhotoView.TAG, sb.toString());
                return;
            }
            float calInterpolate = this.d.calInterpolate();
            float f = calInterpolate - this.c;
            this.c = calInterpolate;
            PhotoView.this.a(this.f6641a * f, this.b * f);
            if (calInterpolate < 1.0f) {
                PhotoView.this.a(this);
            } else {
                PhotoView.this.setState(State.NONE);
            }
        }
    }

    /* loaded from: classes6.dex */
    class PhotoInter {

        /* renamed from: a  reason: collision with root package name */
        private Interpolator f6638a;
        private long b = System.currentTimeMillis();
        private float c;

        public PhotoInter(Interpolator interpolator, float f) {
            this.f6638a = interpolator;
            this.c = f;
        }

        public float calInterpolate() {
            return this.f6638a.getInterpolation(Math.min(1.0f, ((float) (System.currentTimeMillis() - this.b)) / this.c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ScaleRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private float f6640a;
        private float b;
        private PhotoInter c;
        private PointF d;

        ScaleRunnable(float f, PointF pointF) {
            PhotoView.this.setState(State.SCALE);
            this.c = new PhotoInter(new LinearInterpolator(), 200.0f);
            this.f6640a = PhotoView.this.m;
            this.b = f;
            this.d = pointF;
        }

        @Override // java.lang.Runnable
        public void run() {
            float calInterpolate = this.c.calInterpolate();
            PhotoView.this.a(a(calInterpolate), this.d.x, this.d.y);
            if (calInterpolate < 1.0f) {
                PhotoView.this.a(this);
            } else {
                PhotoView.this.setState(State.NONE);
            }
        }

        private float a(float f) {
            float f2 = this.b;
            float f3 = this.f6640a;
            return (f3 + (f * (f2 - f3))) / PhotoView.this.m;
        }
    }

    private void e() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.w = false;
            return;
        }
        this.j.reset();
        this.m = 1.0f;
        this.l = State.NONE;
        this.r = drawable.getIntrinsicWidth();
        this.s = drawable.getIntrinsicHeight();
        int i = this.r;
        if (i <= 0 || i <= 0) {
            this.w = false;
            return;
        }
        this.w = true;
        this.u = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.v = measuredHeight;
        if (this.u == 0 || measuredHeight == 0) {
            return;
        }
        f();
        d(this.f6634o);
        float width = (this.u - this.t.width()) / 2.0f;
        float height = (this.v - this.t.height()) / 2.0f;
        if (this.t.height() > this.v) {
            a(width, 0.0f);
        } else {
            a(width, height);
        }
        if (this.A) {
            this.i.initRect();
        }
    }

    private void f() {
        int hashCode = getDrawable().hashCode();
        this.F = hashCode;
        if (hashCode == this.defaultDrawableHashCode || hashCode == this.failDrawableHashCode) {
            RVLogger.d(TAG, "default drawable or fial drawable,disable scale");
            this.f6634o = 1.0f;
            this.n = 1.0f;
            this.p = 1.0f;
            this.q = 1.0f;
            return;
        }
        float f = this.u / this.r;
        float f2 = this.v / this.s;
        RVLogger.d(TAG, "PhotoView displayType = ");
        int i = this.e;
        if (i == 0) {
            RVLogger.d(TAG, "TYPE_THUMBORI_ORI");
            a(f);
        } else if (i == 1) {
            RVLogger.d(TAG, "TYPE_THUMBORI_ORIFITWIDTH");
            if (this.F == this.thumbDrawableHashCode) {
                a(f);
            } else {
                b(f);
            }
        } else if (i == 2) {
            RVLogger.d(TAG, "TYPE_THUMBORI_ORIFITWITDH_3P2LIMIT");
            if (this.F == this.thumbDrawableHashCode) {
                a(f);
            } else {
                c(f);
            }
        } else if (i == 4) {
            RVLogger.d(TAG, "TYPE_THUMBFITWIDTH_ORIFITWIDTH");
            b(f);
        } else if (i == 8) {
            RVLogger.d(TAG, "TYPE_THUMBFITWITDH_LIMIT_ORIFITWITD_LIMIT");
            c(f);
        }
        if (f <= f2) {
            f = f2;
        }
        float f3 = this.f6634o;
        float f4 = 2.5f * f3;
        if (f <= f4) {
            f = f4;
        }
        this.n = f3 * 0.6f;
        this.p = f;
        this.q = f * 1.2f;
    }

    public boolean isPhotoScaled() {
        return this.m != this.f6634o;
    }

    public boolean isPhotoUpTop() {
        return this.t.top < 0.0f;
    }

    private void a(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("is thumbnail = ");
        sb.append(this.F == this.thumbDrawableHashCode);
        RVLogger.d(TAG, sb.toString());
        if (this.x && f < 1.0f) {
            this.f6634o = f * 1.0f;
        } else {
            this.f6634o = 1.0f;
        }
    }

    private void b(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("is thumbnail = ");
        sb.append(this.F == this.thumbDrawableHashCode);
        RVLogger.d(TAG, sb.toString());
        if (this.x) {
            this.f6634o = f * 1.0f;
        } else {
            this.f6634o = 1.0f;
        }
    }

    private void c(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("is thumbnail = ");
        sb.append(this.F == this.thumbDrawableHashCode);
        RVLogger.d(TAG, sb.toString());
        if (this.x) {
            float f2 = f * 1.0f;
            this.f6634o = f2;
            if (f2 > 3.2f) {
                this.f6634o = 3.2f;
                return;
            }
            return;
        }
        this.f6634o = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, float f2) {
        if (!this.w) {
            RVLogger.d(TAG, "invalid photo content");
            return;
        }
        this.j.postTranslate(f, f2);
        g();
        b();
    }

    private void d(float f) {
        if (!this.w) {
            RVLogger.d(TAG, "invalid photo content");
            return;
        }
        this.m *= f;
        this.j.postScale(f, f);
        g();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, float f2, float f3) {
        if (!this.w) {
            RVLogger.d(TAG, "invalid photo content");
            return;
        }
        this.m *= f;
        this.j.postScale(f, f, f2, f3);
        g();
        b();
    }

    public void postRotate(float f) {
        if (!this.w) {
            RVLogger.d(TAG, "invlaid photo content!");
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Matrix matrix = new Matrix();
            matrix.postRotate(f, this.r / 2, this.s / 2);
            setImageBitmap(Bitmap.createBitmap(bitmap, 0, 0, this.r, this.s, matrix, true));
        }
    }

    public RectF getPhotoRect() {
        return this.t;
    }

    private void g() {
        this.j.getValues(this.k);
        float[] fArr = this.k;
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = this.m;
        this.t.set(f, f2, (this.r * f3) + f, (f3 * this.s) + f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class DragDetector {

        /* renamed from: a  reason: collision with root package name */
        private SimpleDragListener f6635a;
        private float b;
        private float c;
        private boolean d = true;

        public DragDetector(SimpleDragListener simpleDragListener) {
            this.f6635a = simpleDragListener;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (PhotoView.this.l != State.NONE && PhotoView.this.l != State.DRAG) {
                this.b = motionEvent.getX();
                this.c = motionEvent.getY();
                return false;
            } else if (this.f6635a == null || !this.d) {
                return false;
            } else {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.b = motionEvent.getX();
                    this.c = motionEvent.getY();
                    this.f6635a.onDragBegin();
                } else if (action == 5) {
                    this.d = false;
                } else if (action == 2) {
                    float x = motionEvent.getX() - this.b;
                    float y = motionEvent.getY() - this.c;
                    this.b = motionEvent.getX();
                    this.c = motionEvent.getY();
                    if (x == 0.0f && y == 0.0f) {
                        return false;
                    }
                    this.f6635a.onDrag(x, y);
                } else if (action == 1) {
                    this.f6635a.onDragEnd();
                    this.b = 0.0f;
                    this.c = 0.0f;
                    this.d = true;
                }
                return true;
            }
        }
    }

    /* loaded from: classes6.dex */
    class FlingRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private CompactScroller f6636a;
        private int b;
        private int c;

        FlingRunnable(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            PhotoView.this.setState(State.FLING);
            this.f6636a = new CompactScroller(PhotoView.this.getContext());
            int i7 = (int) PhotoView.this.t.left;
            int i8 = (int) PhotoView.this.t.top;
            float width = PhotoView.this.t.width();
            float height = PhotoView.this.t.height();
            if (width > PhotoView.this.u) {
                i3 = PhotoView.this.u - ((int) width);
                i4 = 0;
            } else {
                i3 = i7;
                i4 = i3;
            }
            if (height > PhotoView.this.v) {
                i5 = PhotoView.this.v - ((int) height);
                i6 = 0;
            } else {
                i5 = i8;
                i6 = i5;
            }
            this.f6636a.fling(i7, i8, i, i2, i3, i4, i5, i6, 1, 1);
            this.b = i7;
            this.c = i8;
        }

        public void cancelFling() {
            if (this.f6636a != null) {
                PhotoView.this.setState(State.NONE);
                this.f6636a.forceFinished(true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            CompactScroller compactScroller = this.f6636a;
            if (compactScroller == null || compactScroller.isFinished() || !this.f6636a.computeScrollOffset()) {
                if (PhotoView.this.l == State.FLING) {
                    PhotoView.this.setState(State.NONE);
                }
                this.f6636a = null;
                return;
            }
            int currX = this.f6636a.getCurrX();
            int currY = this.f6636a.getCurrY();
            int i = this.b;
            int i2 = this.c;
            this.b = currX;
            this.c = currY;
            PhotoView.this.a(currX - i, currY - i2);
            PhotoView.this.a(this);
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (!this.w) {
            RVLogger.d(TAG, "canScrollHorizontally false");
            return false;
        }
        float f = this.t.left;
        float width = this.t.width();
        float f2 = this.u;
        if (width > f2) {
            if (i >= 0 || f < 0.0f) {
                return i <= 0 || f + width > f2;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.C = onLongClickListener;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    public static int getMaxTextureSize() {
        if (b) {
            return f6633a;
        }
        new Canvas().getMaximumBitmapHeight();
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        egl10.eglGetConfigs(eglGetDisplay, null, 0, iArr);
        int i = iArr[0];
        EGLConfig[] eGLConfigArr = new EGLConfig[i];
        egl10.eglGetConfigs(eglGetDisplay, eGLConfigArr, i, iArr);
        int[] iArr2 = new int[1];
        int i2 = 0;
        for (int i3 = 0; i3 < iArr[0]; i3++) {
            egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i3], 12330, iArr2);
            int i4 = iArr2[0];
            if (i2 < i4) {
                i2 = i4;
            }
        }
        egl10.eglTerminate(eglGetDisplay);
        StringBuilder sb = new StringBuilder();
        sb.append("getMaxTextureSize = ");
        sb.append(Math.max(i2, 2048));
        RVLogger.w(TAG, sb.toString());
        b = true;
        return Math.max(i2, 2048);
    }

    private static void a(Canvas canvas) {
        if (b || !canvas.isHardwareAccelerated()) {
            return;
        }
        int min = Math.min(canvas.getMaximumBitmapHeight(), canvas.getMaximumBitmapWidth());
        if (2048 <= min && min < 32766) {
            f6633a = min;
            StringBuilder sb = new StringBuilder();
            sb.append("getMaxTextureSizeV2 = ");
            sb.append(f6633a);
            RVLogger.w(TAG, sb.toString());
        } else {
            RVLogger.w(TAG, "getMaxTextureSizeV2 size abnormal,handle to  previous method!");
            f6633a = getMaxTextureSize();
        }
        b = true;
    }

    public boolean isShowingThumbnail() {
        return this.F == this.thumbDrawableHashCode;
    }

    public Bitmap getValidShowingPhoto() {
        int i = this.F;
        if (i == this.defaultDrawableHashCode || i == this.failDrawableHashCode || !(getDrawable() instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) getDrawable()).getBitmap();
    }
}
