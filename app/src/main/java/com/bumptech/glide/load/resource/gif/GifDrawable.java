package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import com.fullstory.instrumentation.FSDraw;
import java.util.List;

/* loaded from: classes3.dex */
public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable, Animatable2Compat, FSDraw {
    public final GifState BuiltInFictitiousFunctionClassFactory;
    private Rect KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Paint NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean PlaceComponentResult;
    private List<Animatable2Compat.AnimationCallback> getAuthRequestContext;
    private boolean getErrorConfigVersion;
    private boolean lookAheadTest;
    private boolean moveToNextValue;
    private int scheduleImpl;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(new GifState(new GifFrameLoader(Glide.BuiltInFictitiousFunctionClassFactory(context), gifDecoder, i, i2, transformation, bitmap)));
    }

    GifDrawable(GifState gifState) {
        this.lookAheadTest = true;
        this.scheduleImpl = -1;
        this.BuiltInFictitiousFunctionClassFactory = (GifState) Preconditions.PlaceComponentResult(gifState);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.getErrorConfigVersion = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        if (this.lookAheadTest) {
            getAuthRequestContext();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.getErrorConfigVersion = false;
        BuiltInFictitiousFunctionClassFactory();
    }

    private void getAuthRequestContext() {
        Preconditions.BuiltInFictitiousFunctionClassFactory(!this.MyBillsEntityDataFactory, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.moveToNextValue.moveToNextValue() != 1) {
            if (this.moveToNextValue) {
                return;
            }
            this.moveToNextValue = true;
            GifFrameLoader gifFrameLoader = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
            if (gifFrameLoader.getErrorConfigVersion) {
                throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
            }
            if (gifFrameLoader.KClassImpl$Data$declaredNonStaticMembers$2.contains(this)) {
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
            boolean isEmpty = gifFrameLoader.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty();
            gifFrameLoader.KClassImpl$Data$declaredNonStaticMembers$2.add(this);
            if (isEmpty && !gifFrameLoader.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                gifFrameLoader.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                gifFrameLoader.getErrorConfigVersion = false;
                gifFrameLoader.getAuthRequestContext();
            }
        }
        invalidateSelf();
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        this.moveToNextValue = false;
        GifFrameLoader gifFrameLoader = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        gifFrameLoader.KClassImpl$Data$declaredNonStaticMembers$2.remove(this);
        if (gifFrameLoader.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            gifFrameLoader.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Preconditions.BuiltInFictitiousFunctionClassFactory(!this.MyBillsEntityDataFactory, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.lookAheadTest = z;
        if (!z) {
            BuiltInFictitiousFunctionClassFactory();
        } else if (this.getErrorConfigVersion) {
            getAuthRequestContext();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.DatabaseTableConfigUtil;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.scheduleImpl;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.moveToNextValue;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.PlaceComponentResult = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        if (this.PlaceComponentResult) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.PlaceComponentResult = false;
        }
        GifFrameLoader gifFrameLoader = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        GifFrameLoader.DelayTarget delayTarget = gifFrameLoader.getAuthRequestContext;
        if (delayTarget == null) {
            bitmap = gifFrameLoader.PlaceComponentResult;
        } else {
            bitmap = delayTarget.PlaceComponentResult;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new Rect();
        }
        Rect rect = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes3.dex */
    public static final class GifState extends Drawable.ConstantState {
        public final GifFrameLoader PlaceComponentResult;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        GifState(GifFrameLoader gifFrameLoader) {
            this.PlaceComponentResult = gifFrameLoader;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback
    public final void MyBillsEntityDataFactory() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        GifFrameLoader.DelayTarget delayTarget = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.getAuthRequestContext;
        if ((delayTarget != null ? delayTarget.BuiltInFictitiousFunctionClassFactory : -1) == this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.moveToNextValue.moveToNextValue() - 1) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0++;
        }
        int i = this.scheduleImpl;
        if (i == -1 || this.NetworkUserEntityData$$ExternalSyntheticLambda0 < i) {
            return;
        }
        List<Animatable2Compat.AnimationCallback> list = this.getAuthRequestContext;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.getAuthRequestContext.get(i2).onAnimationEnd(this);
            }
        }
        stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Paint(2);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Paint(2);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColorFilter(colorFilter);
    }
}
