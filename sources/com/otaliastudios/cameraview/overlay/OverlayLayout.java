package com.otaliastudios.cameraview.overlay;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.R;
import com.otaliastudios.cameraview.overlay.Overlay;

/* loaded from: classes2.dex */
public class OverlayLayout extends FrameLayout implements Overlay, FSDraw, FSDispatchDraw {
    private static final CameraLogger MyBillsEntityDataFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("OverlayLayout");
    Overlay.Target currentTarget;

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        fsSuperDispatchDraw_946ddf226af6342311a420972c5ec667(canvas);
    }

    public void fsSuperDispatchDraw_946ddf226af6342311a420972c5ec667(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_946ddf226af6342311a420972c5ec667(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public void fsSuperDraw_946ddf226af6342311a420972c5ec667(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    public OverlayLayout(Context context) {
        super(context);
        this.currentTarget = Overlay.Target.PREVIEW;
        setWillNotDraw(false);
    }

    public boolean isOverlay(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return false;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PlaceComponentResult);
        boolean z = obtainStyledAttributes.hasValue(R.styleable.KClassImpl$Data$declaredNonStaticMembers$2) || obtainStyledAttributes.hasValue(R.styleable.MyBillsEntityDataFactory) || obtainStyledAttributes.hasValue(R.styleable.getAuthRequestContext);
        obtainStyledAttributes.recycle();
        return z;
    }

    public boolean isOverlay(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "normal draw called.");
        if (drawsOn(Overlay.Target.PREVIEW)) {
            drawOn(Overlay.Target.PREVIEW, canvas);
        }
    }

    @Override // com.otaliastudios.cameraview.overlay.Overlay
    public boolean drawsOn(Overlay.Target target) {
        for (int i = 0; i < getChildCount(); i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).MyBillsEntityDataFactory(target)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.otaliastudios.cameraview.overlay.Overlay
    public void drawOn(Overlay.Target target, Canvas canvas) {
        synchronized (this) {
            this.currentTarget = target;
            int i = AnonymousClass1.PlaceComponentResult[target.ordinal()];
            if (i == 1) {
                fsSuperDraw_946ddf226af6342311a420972c5ec667(canvas);
            } else if (i == 2 || i == 3) {
                canvas.save();
                float width = canvas.getWidth() / getWidth();
                float height = canvas.getHeight() / getHeight();
                CameraLogger cameraLogger = MyBillsEntityDataFactory;
                StringBuilder sb = new StringBuilder();
                sb.append(canvas.getWidth());
                sb.append("x");
                sb.append(canvas.getHeight());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getWidth());
                sb2.append("x");
                sb2.append(getHeight());
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(0, "draw", "target:", target, "canvas:", sb.toString(), "view:", sb2.toString(), "widthScale:", Float.valueOf(width), "heightScale:", Float.valueOf(height));
                canvas.scale(width, height);
                dispatchDraw(canvas);
                canvas.restore();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.otaliastudios.cameraview.overlay.OverlayLayout$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[Overlay.Target.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[Overlay.Target.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[Overlay.Target.VIDEO_SNAPSHOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[Overlay.Target.PICTURE_SNAPSHOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.MyBillsEntityDataFactory(this.currentTarget)) {
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(0, "Performing drawing for view:", view.getClass().getSimpleName(), "target:", this.currentTarget, "params:", layoutParams);
            return doDrawChild(canvas, view, j);
        }
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(0, "Skipping drawing for view:", view.getClass().getSimpleName(), "target:", this.currentTarget, "params:", layoutParams);
        return false;
    }

    boolean doDrawChild(Canvas canvas, View view, long j) {
        return fsSuperDrawChild_946ddf226af6342311a420972c5ec667(canvas, view, j);
    }

    /* loaded from: classes8.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public boolean BuiltInFictitiousFunctionClassFactory;
        public boolean MyBillsEntityDataFactory;
        public boolean PlaceComponentResult;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.PlaceComponentResult = false;
            this.MyBillsEntityDataFactory = false;
            this.BuiltInFictitiousFunctionClassFactory = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PlaceComponentResult);
            try {
                this.PlaceComponentResult = obtainStyledAttributes.getBoolean(R.styleable.KClassImpl$Data$declaredNonStaticMembers$2, false);
                this.MyBillsEntityDataFactory = obtainStyledAttributes.getBoolean(R.styleable.MyBillsEntityDataFactory, false);
                this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getBoolean(R.styleable.getAuthRequestContext, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        final boolean MyBillsEntityDataFactory(Overlay.Target target) {
            return (target == Overlay.Target.PREVIEW && this.PlaceComponentResult) || (target == Overlay.Target.VIDEO_SNAPSHOT && this.BuiltInFictitiousFunctionClassFactory) || (target == Overlay.Target.PICTURE_SNAPSHOT && this.MyBillsEntityDataFactory);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append("[drawOnPreview:");
            sb.append(this.PlaceComponentResult);
            sb.append(",drawOnPictureSnapshot:");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(",drawOnVideoSnapshot:");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append("]");
            return sb.toString();
        }
    }
}
