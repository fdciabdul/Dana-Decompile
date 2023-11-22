package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;

/* loaded from: classes8.dex */
public class UCropView extends FrameLayout {
    private final OverlayView KClassImpl$Data$declaredNonStaticMembers$2;
    private GestureCropImageView getAuthRequestContext;

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UCropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.ucrop_view, (ViewGroup) this, true);
        this.getAuthRequestContext = (GestureCropImageView) findViewById(R.id.image_view_crop);
        OverlayView overlayView = (OverlayView) findViewById(R.id.res_0x7f0a1b5b_networkuserentitydata_externalsyntheticlambda6);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = overlayView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.F);
        overlayView.processStyledAttributes(obtainStyledAttributes);
        this.getAuthRequestContext.processStyledAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        this.getAuthRequestContext.setCropBoundsChangeListener(new AnonymousClass1());
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOverlayViewChangeListener(new AnonymousClass2());
    }

    /* renamed from: com.yalantis.ucrop.view.UCropView$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass1 implements CropBoundsChangeListener {
        AnonymousClass1() {
        }

        @Override // com.yalantis.ucrop.callback.CropBoundsChangeListener
        public final void PlaceComponentResult(float f) {
            UCropView.this.KClassImpl$Data$declaredNonStaticMembers$2.setTargetAspectRatio(f);
        }
    }

    /* renamed from: com.yalantis.ucrop.view.UCropView$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass2 implements OverlayViewChangeListener {
        AnonymousClass2() {
        }

        @Override // com.yalantis.ucrop.callback.OverlayViewChangeListener
        public final void MyBillsEntityDataFactory(RectF rectF) {
            UCropView.this.getAuthRequestContext.setCropRect(rectF);
        }
    }

    public GestureCropImageView getCropImageView() {
        return this.getAuthRequestContext;
    }

    public OverlayView getOverlayView() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void resetCropImageView() {
        removeView(this.getAuthRequestContext);
        GestureCropImageView gestureCropImageView = new GestureCropImageView(getContext());
        this.getAuthRequestContext = gestureCropImageView;
        gestureCropImageView.setCropBoundsChangeListener(new AnonymousClass1());
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOverlayViewChangeListener(new AnonymousClass2());
        this.getAuthRequestContext.setCropRect(getOverlayView().getCropViewRect());
        addView(this.getAuthRequestContext, 0);
    }
}
