package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.fullstory.instrumentation.FSDraw;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable, FSDraw {
    private RectF A;
    private Matrix B;
    private Rect BottomSheetCardBindingView$watcherCardNumberView$1;
    boolean BuiltInFictitiousFunctionClassFactory;
    private Paint C;
    final ArrayList<LazyCompositionTask> DatabaseTableConfigUtil;
    boolean FragmentBottomSheetPaymentSettingBinding;
    boolean GetContactSyncConfig;
    final LottieValueAnimator KClassImpl$Data$declaredNonStaticMembers$2;
    CompositionLayer MyBillsEntityDataFactory;
    ImageAssetDelegate NetworkUserEntityData$$ExternalSyntheticLambda0;
    String NetworkUserEntityData$$ExternalSyntheticLambda1;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private int NetworkUserEntityData$$ExternalSyntheticLambda3;
    public TextDelegate NetworkUserEntityData$$ExternalSyntheticLambda4;
    private Rect NetworkUserEntityData$$ExternalSyntheticLambda5;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
    RenderMode NetworkUserEntityData$$ExternalSyntheticLambda7;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    boolean PlaceComponentResult;
    boolean PrepareContext;
    private Canvas SubSequence;
    private Matrix VerifyPinStateManager$executeRiskChallenge$2$1;
    private Rect VerifyPinStateManager$executeRiskChallenge$2$2;
    public LottieComposition getAuthRequestContext;
    private Bitmap getCallingPid;
    boolean getErrorConfigVersion;
    private RectF getSupportButtonTintMode;
    private RectF getValueOfTouchPositionAbsolute;
    OnVisibleAction initRecordTimeStamp;
    final ValueAnimator.AnimatorUpdateListener isLayoutRequested;
    public FontAssetManager lookAheadTest;
    ImageAssetManager moveToNextValue;
    boolean newProxyInstance;
    private final Matrix readMicros;
    public FontAssetDelegate scheduleImpl;
    private boolean whenAvailable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface LazyCompositionTask {
        void MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface RepeatMode {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lottieValueAnimator;
        this.FragmentBottomSheetPaymentSettingBinding = true;
        this.getErrorConfigVersion = false;
        this.newProxyInstance = false;
        this.initRecordTimeStamp = OnVisibleAction.NONE;
        this.DatabaseTableConfigUtil = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.LottieDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieDrawable.this.MyBillsEntityDataFactory != null) {
                    LottieDrawable.this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(LottieDrawable.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
                }
            }
        };
        this.isLayoutRequested = animatorUpdateListener;
        this.GetContactSyncConfig = false;
        this.PlaceComponentResult = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = 255;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = RenderMode.AUTOMATIC;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = false;
        this.readMicros = new Matrix();
        this.whenAvailable = false;
        lottieValueAnimator.addUpdateListener(animatorUpdateListener);
    }

    public final boolean getErrorConfigVersion() {
        CompositionLayer compositionLayer = this.MyBillsEntityDataFactory;
        return compositionLayer != null && compositionLayer.getErrorConfigVersion();
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        CompositionLayer compositionLayer = this.MyBillsEntityDataFactory;
        return compositionLayer != null && compositionLayer.lookAheadTest();
    }

    public final boolean getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean GetContactSyncConfig() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean moveToNextValue() {
        return this.PlaceComponentResult;
    }

    public final boolean lookAheadTest() {
        return this.GetContactSyncConfig;
    }

    public final boolean getAuthRequestContext(LottieComposition lottieComposition) {
        if (this.getAuthRequestContext == lottieComposition) {
            return false;
        }
        this.whenAvailable = true;
        BuiltInFictitiousFunctionClassFactory();
        this.getAuthRequestContext = lottieComposition;
        PlaceComponentResult();
        LottieValueAnimator lottieValueAnimator = this.KClassImpl$Data$declaredNonStaticMembers$2;
        boolean z = lottieValueAnimator.MyBillsEntityDataFactory == null;
        lottieValueAnimator.MyBillsEntityDataFactory = lottieComposition;
        if (z) {
            lottieValueAnimator.KClassImpl$Data$declaredNonStaticMembers$2(Math.max(lottieValueAnimator.PlaceComponentResult, lottieComposition.DatabaseTableConfigUtil), Math.min(lottieValueAnimator.getAuthRequestContext, lottieComposition.MyBillsEntityDataFactory));
        } else {
            lottieValueAnimator.KClassImpl$Data$declaredNonStaticMembers$2((int) lottieComposition.DatabaseTableConfigUtil, (int) lottieComposition.MyBillsEntityDataFactory);
        }
        float f = lottieValueAnimator.KClassImpl$Data$declaredNonStaticMembers$2;
        lottieValueAnimator.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        lottieValueAnimator.getAuthRequestContext((int) f);
        lottieValueAnimator.BuiltInFictitiousFunctionClassFactory();
        MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAnimatedFraction());
        Iterator it = new ArrayList(this.DatabaseTableConfigUtil).iterator();
        while (it.hasNext()) {
            LazyCompositionTask lazyCompositionTask = (LazyCompositionTask) it.next();
            if (lazyCompositionTask != null) {
                lazyCompositionTask.MyBillsEntityDataFactory();
            }
            it.remove();
        }
        this.DatabaseTableConfigUtil.clear();
        lottieComposition.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        MyBillsEntityDataFactory();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory() {
        LottieComposition lottieComposition = this.getAuthRequestContext;
        if (lottieComposition == null) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.useSoftwareRendering(Build.VERSION.SDK_INT, lottieComposition.BuiltInFictitiousFunctionClassFactory(), lottieComposition.GetContactSyncConfig);
    }

    public final boolean initRecordTimeStamp() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult() {
        LottieComposition lottieComposition = this.getAuthRequestContext;
        if (lottieComposition == null) {
            return;
        }
        CompositionLayer compositionLayer = new CompositionLayer(this, LayerParser.PlaceComponentResult(lottieComposition), lottieComposition.getErrorConfigVersion, lottieComposition);
        this.MyBillsEntityDataFactory = compositionLayer;
        if (this.PrepareContext) {
            compositionLayer.KClassImpl$Data$declaredNonStaticMembers$2(true);
        }
        this.MyBillsEntityDataFactory.moveToNextValue = this.PlaceComponentResult;
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.isRunning()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
            if (!isVisible()) {
                this.initRecordTimeStamp = OnVisibleAction.NONE;
            }
        }
        this.getAuthRequestContext = null;
        this.MyBillsEntityDataFactory = null;
        this.moveToNextValue = null;
        LottieValueAnimator lottieValueAnimator = this.KClassImpl$Data$declaredNonStaticMembers$2;
        lottieValueAnimator.MyBillsEntityDataFactory = null;
        lottieValueAnimator.PlaceComponentResult = -2.14748365E9f;
        lottieValueAnimator.getAuthRequestContext = 2.14748365E9f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.whenAvailable) {
            return;
        }
        this.whenAvailable = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Logger.getAuthRequestContext("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        L.getAuthRequestContext("Drawable#draw");
        if (this.newProxyInstance) {
            try {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
                    MyBillsEntityDataFactory(canvas, this.MyBillsEntityDataFactory);
                } else {
                    BuiltInFictitiousFunctionClassFactory(canvas);
                }
            } catch (Throwable th) {
                Logger.MyBillsEntityDataFactory("Lottie crashed in draw!", th);
            }
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
            MyBillsEntityDataFactory(canvas, this.MyBillsEntityDataFactory);
        } else {
            BuiltInFictitiousFunctionClassFactory(canvas);
        }
        this.whenAvailable = false;
        L.MyBillsEntityDataFactory("Drawable#draw");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        DatabaseTableConfigUtil();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return scheduleImpl();
    }

    public final void DatabaseTableConfigUtil() {
        if (this.MyBillsEntityDataFactory == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda2
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.DatabaseTableConfigUtil();
                }
            });
            return;
        }
        MyBillsEntityDataFactory();
        if (NetworkUserEntityData$$ExternalSyntheticLambda8() || this.KClassImpl$Data$declaredNonStaticMembers$2.getRepeatCount() == 0) {
            if (isVisible()) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0();
                this.initRecordTimeStamp = OnVisibleAction.NONE;
            } else {
                this.initRecordTimeStamp = OnVisibleAction.PLAY;
            }
        }
        if (NetworkUserEntityData$$ExternalSyntheticLambda8()) {
            return;
        }
        BuiltInFictitiousFunctionClassFactory((int) (this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion < 0.0f ? PrepareContext() : NetworkUserEntityData$$ExternalSyntheticLambda7()));
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        if (isVisible()) {
            return;
        }
        this.initRecordTimeStamp = OnVisibleAction.NONE;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        if (this.MyBillsEntityDataFactory == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda10
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.NetworkUserEntityData$$ExternalSyntheticLambda1();
                }
            });
            return;
        }
        MyBillsEntityDataFactory();
        if (NetworkUserEntityData$$ExternalSyntheticLambda8() || this.KClassImpl$Data$declaredNonStaticMembers$2.getRepeatCount() == 0) {
            if (isVisible()) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl();
                this.initRecordTimeStamp = OnVisibleAction.NONE;
            } else {
                this.initRecordTimeStamp = OnVisibleAction.RESUME;
            }
        }
        if (NetworkUserEntityData$$ExternalSyntheticLambda8()) {
            return;
        }
        BuiltInFictitiousFunctionClassFactory((int) (this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion < 0.0f ? PrepareContext() : NetworkUserEntityData$$ExternalSyntheticLambda7()));
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        if (isVisible()) {
            return;
        }
        this.initRecordTimeStamp = OnVisibleAction.NONE;
    }

    public final void PlaceComponentResult(final int i) {
        if (this.getAuthRequestContext == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda7
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.PlaceComponentResult(i);
                }
            });
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(i, (int) r0.getAuthRequestContext);
    }

    private float PrepareContext() {
        LottieValueAnimator lottieValueAnimator = this.KClassImpl$Data$declaredNonStaticMembers$2;
        LottieComposition lottieComposition = lottieValueAnimator.MyBillsEntityDataFactory;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = lottieValueAnimator.PlaceComponentResult;
        return f == -2.14748365E9f ? lottieComposition.DatabaseTableConfigUtil : f;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(final float f) {
        LottieComposition lottieComposition = this.getAuthRequestContext;
        if (lottieComposition == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda8
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.KClassImpl$Data$declaredNonStaticMembers$2(f);
                }
            });
        } else {
            PlaceComponentResult((int) MiscUtils.PlaceComponentResult(lottieComposition.DatabaseTableConfigUtil, this.getAuthRequestContext.MyBillsEntityDataFactory, f));
        }
    }

    public final void getAuthRequestContext(final int i) {
        if (this.getAuthRequestContext == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda9
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.getAuthRequestContext(i);
                }
            });
            return;
        }
        LottieValueAnimator lottieValueAnimator = this.KClassImpl$Data$declaredNonStaticMembers$2;
        lottieValueAnimator.KClassImpl$Data$declaredNonStaticMembers$2(lottieValueAnimator.PlaceComponentResult, i + 0.99f);
    }

    private float NetworkUserEntityData$$ExternalSyntheticLambda7() {
        LottieValueAnimator lottieValueAnimator = this.KClassImpl$Data$declaredNonStaticMembers$2;
        LottieComposition lottieComposition = lottieValueAnimator.MyBillsEntityDataFactory;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = lottieValueAnimator.getAuthRequestContext;
        return f == 2.14748365E9f ? lottieComposition.MyBillsEntityDataFactory : f;
    }

    public final void PlaceComponentResult(final float f) {
        LottieComposition lottieComposition = this.getAuthRequestContext;
        if (lottieComposition == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda1
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.PlaceComponentResult(f);
                }
            });
            return;
        }
        LottieValueAnimator lottieValueAnimator = this.KClassImpl$Data$declaredNonStaticMembers$2;
        lottieValueAnimator.KClassImpl$Data$declaredNonStaticMembers$2(lottieValueAnimator.PlaceComponentResult, MiscUtils.PlaceComponentResult(lottieComposition.DatabaseTableConfigUtil, this.getAuthRequestContext.MyBillsEntityDataFactory, f));
    }

    public final void MyBillsEntityDataFactory(final String str) {
        LottieComposition lottieComposition = this.getAuthRequestContext;
        if (lottieComposition == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda13
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.MyBillsEntityDataFactory(str);
                }
            });
            return;
        }
        Marker KClassImpl$Data$declaredNonStaticMembers$2 = lottieComposition.KClassImpl$Data$declaredNonStaticMembers$2(str);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find marker with name ");
            sb.append(str);
            sb.append(".");
            throw new IllegalArgumentException(sb.toString());
        }
        PlaceComponentResult((int) KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
    }

    public final void getAuthRequestContext(final String str) {
        LottieComposition lottieComposition = this.getAuthRequestContext;
        if (lottieComposition == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda11
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.getAuthRequestContext(str);
                }
            });
            return;
        }
        Marker KClassImpl$Data$declaredNonStaticMembers$2 = lottieComposition.KClassImpl$Data$declaredNonStaticMembers$2(str);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find marker with name ");
            sb.append(str);
            sb.append(".");
            throw new IllegalArgumentException(sb.toString());
        }
        getAuthRequestContext((int) (KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult + KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    public final void PlaceComponentResult(final String str) {
        LottieComposition lottieComposition = this.getAuthRequestContext;
        if (lottieComposition == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda5
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.PlaceComponentResult(str);
                }
            });
            return;
        }
        Marker KClassImpl$Data$declaredNonStaticMembers$2 = lottieComposition.KClassImpl$Data$declaredNonStaticMembers$2(str);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find marker with name ");
            sb.append(str);
            sb.append(".");
            throw new IllegalArgumentException(sb.toString());
        }
        int i = (int) KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
        BuiltInFictitiousFunctionClassFactory(i, ((int) KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2) + i);
    }

    public final void BuiltInFictitiousFunctionClassFactory(final String str, final String str2, final boolean z) {
        LottieComposition lottieComposition = this.getAuthRequestContext;
        if (lottieComposition == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda12
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.BuiltInFictitiousFunctionClassFactory(str, str2, z);
                }
            });
            return;
        }
        Marker KClassImpl$Data$declaredNonStaticMembers$2 = lottieComposition.KClassImpl$Data$declaredNonStaticMembers$2(str);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find marker with name ");
            sb.append(str);
            sb.append(".");
            throw new IllegalArgumentException(sb.toString());
        }
        int i = (int) KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
        Marker KClassImpl$Data$declaredNonStaticMembers$22 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(str2);
        if (KClassImpl$Data$declaredNonStaticMembers$22 == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot find marker with name ");
            sb2.append(str2);
            sb2.append(".");
            throw new IllegalArgumentException(sb2.toString());
        }
        BuiltInFictitiousFunctionClassFactory(i, (int) (KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult + (z ? 1.0f : 0.0f)));
    }

    public final void BuiltInFictitiousFunctionClassFactory(final int i, final int i2) {
        if (this.getAuthRequestContext == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda4
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.BuiltInFictitiousFunctionClassFactory(i, i2);
                }
            });
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(i, i2 + 0.99f);
        }
    }

    public final void PlaceComponentResult(final float f, final float f2) {
        LottieComposition lottieComposition = this.getAuthRequestContext;
        if (lottieComposition == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda6
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.PlaceComponentResult(f, f2);
                }
            });
        } else {
            BuiltInFictitiousFunctionClassFactory((int) MiscUtils.PlaceComponentResult(lottieComposition.DatabaseTableConfigUtil, this.getAuthRequestContext.MyBillsEntityDataFactory, f), (int) MiscUtils.PlaceComponentResult(this.getAuthRequestContext.DatabaseTableConfigUtil, this.getAuthRequestContext.MyBillsEntityDataFactory, f2));
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(final int i) {
        if (this.getAuthRequestContext == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda3
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.BuiltInFictitiousFunctionClassFactory(i);
                }
            });
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(i);
        }
    }

    public final void MyBillsEntityDataFactory(final float f) {
        if (this.getAuthRequestContext == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda0
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.MyBillsEntityDataFactory(f);
                }
            });
            return;
        }
        L.getAuthRequestContext("Drawable#setProgress");
        LottieValueAnimator lottieValueAnimator = this.KClassImpl$Data$declaredNonStaticMembers$2;
        LottieComposition lottieComposition = this.getAuthRequestContext;
        lottieValueAnimator.getAuthRequestContext(MiscUtils.PlaceComponentResult(lottieComposition.DatabaseTableConfigUtil, lottieComposition.MyBillsEntityDataFactory, f));
        L.MyBillsEntityDataFactory("Drawable#setProgress");
    }

    public final boolean scheduleImpl() {
        LottieValueAnimator lottieValueAnimator = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        if (isVisible()) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isRunning();
        }
        return this.initRecordTimeStamp == OnVisibleAction.PLAY || this.initRecordTimeStamp == OnVisibleAction.RESUME;
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return this.FragmentBottomSheetPaymentSettingBinding || this.getErrorConfigVersion;
    }

    public final boolean newProxyInstance() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda4 == null && this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory() > 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.getAuthRequestContext;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.KClassImpl$Data$declaredNonStaticMembers$2.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.getAuthRequestContext;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.KClassImpl$Data$declaredNonStaticMembers$2.height();
    }

    public final List<KeyPath> KClassImpl$Data$declaredNonStaticMembers$2(KeyPath keyPath) {
        if (this.MyBillsEntityDataFactory == null) {
            Logger.getAuthRequestContext("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(keyPath, 0, arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    public final <T> void BuiltInFictitiousFunctionClassFactory(final KeyPath keyPath, final T t, final LottieValueCallback<T> lottieValueCallback) {
        if (this.MyBillsEntityDataFactory == null) {
            this.DatabaseTableConfigUtil.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable$$ExternalSyntheticLambda14
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void MyBillsEntityDataFactory() {
                    LottieDrawable.this.BuiltInFictitiousFunctionClassFactory(keyPath, (KeyPath) t, (LottieValueCallback<KeyPath>) lottieValueCallback);
                }
            });
            return;
        }
        boolean z = true;
        if (keyPath == KeyPath.MyBillsEntityDataFactory) {
            this.MyBillsEntityDataFactory.PlaceComponentResult(t, lottieValueCallback);
        } else if (keyPath.BuiltInFictitiousFunctionClassFactory != null) {
            keyPath.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(t, lottieValueCallback);
        } else {
            List<KeyPath> KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(keyPath);
            for (int i = 0; i < KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
                KClassImpl$Data$declaredNonStaticMembers$2.get(i).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(t, lottieValueCallback);
            }
            z = true ^ KClassImpl$Data$declaredNonStaticMembers$2.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == LottieProperty.getSupportButtonTintMode) {
                MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.airbnb.lottie.LottieDrawable$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2<T> extends LottieValueCallback<T> {
        final /* synthetic */ SimpleLottieValueCallback KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // com.airbnb.lottie.value.LottieValueCallback
        public final T BuiltInFictitiousFunctionClassFactory(LottieFrameInfo<T> lottieFrameInfo) {
            return (T) this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public final ImageAssetManager KClassImpl$Data$declaredNonStaticMembers$2() {
        if (getCallback() == null) {
            return null;
        }
        ImageAssetManager imageAssetManager = this.moveToNextValue;
        if (imageAssetManager != null) {
            Drawable.Callback callback = getCallback();
            if (!imageAssetManager.getAuthRequestContext((callback == null || !(callback instanceof View)) ? null : ((View) callback).getContext())) {
                this.moveToNextValue = null;
            }
        }
        if (this.moveToNextValue == null) {
            this.moveToNextValue = new ImageAssetManager(getCallback(), this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getAuthRequestContext.moveToNextValue);
        }
        return this.moveToNextValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean isVisible = isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            if (this.initRecordTimeStamp == OnVisibleAction.PLAY) {
                DatabaseTableConfigUtil();
            } else if (this.initRecordTimeStamp == OnVisibleAction.RESUME) {
                NetworkUserEntityData$$ExternalSyntheticLambda1();
            }
        } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.isRunning()) {
            this.DatabaseTableConfigUtil.clear();
            this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
            if (!isVisible()) {
                this.initRecordTimeStamp = OnVisibleAction.NONE;
            }
            this.initRecordTimeStamp = OnVisibleAction.RESUME;
        } else if ((!isVisible) == false) {
            this.initRecordTimeStamp = OnVisibleAction.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    private void BuiltInFictitiousFunctionClassFactory(Canvas canvas) {
        CompositionLayer compositionLayer = this.MyBillsEntityDataFactory;
        LottieComposition lottieComposition = this.getAuthRequestContext;
        if (compositionLayer == null || lottieComposition == null) {
            return;
        }
        this.readMicros.reset();
        if (!getBounds().isEmpty()) {
            this.readMicros.preScale(r2.width() / lottieComposition.KClassImpl$Data$declaredNonStaticMembers$2.width(), r2.height() / lottieComposition.KClassImpl$Data$declaredNonStaticMembers$2.height());
        }
        compositionLayer.getAuthRequestContext(canvas, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
    }

    private void MyBillsEntityDataFactory(Canvas canvas, CompositionLayer compositionLayer) {
        if (this.getAuthRequestContext == null || compositionLayer == null) {
            return;
        }
        if (this.SubSequence == null) {
            this.SubSequence = new Canvas();
            this.getValueOfTouchPositionAbsolute = new RectF();
            this.B = new Matrix();
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = new Matrix();
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new Rect();
            this.getSupportButtonTintMode = new RectF();
            this.C = new LPaint();
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = new Rect();
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = new Rect();
            this.A = new RectF();
        }
        canvas.getMatrix(this.B);
        canvas.getClipBounds(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        Rect rect = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        this.getSupportButtonTintMode.set(rect.left, rect.top, rect.right, rect.bottom);
        this.B.mapRect(this.getSupportButtonTintMode);
        getAuthRequestContext(this.getSupportButtonTintMode, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        if (this.PlaceComponentResult) {
            this.getValueOfTouchPositionAbsolute.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            compositionLayer.getAuthRequestContext(this.getValueOfTouchPositionAbsolute, (Matrix) null, false);
        }
        this.B.mapRect(this.getValueOfTouchPositionAbsolute);
        Rect bounds = getBounds();
        float width = bounds.width() / getIntrinsicWidth();
        float height = bounds.height() / getIntrinsicHeight();
        RectF rectF = this.getValueOfTouchPositionAbsolute;
        rectF.set(rectF.left * width, rectF.top * height, rectF.right * width, rectF.bottom * height);
        if (!isLayoutRequested()) {
            this.getValueOfTouchPositionAbsolute.intersect(this.NetworkUserEntityData$$ExternalSyntheticLambda5.left, this.NetworkUserEntityData$$ExternalSyntheticLambda5.top, this.NetworkUserEntityData$$ExternalSyntheticLambda5.right, this.NetworkUserEntityData$$ExternalSyntheticLambda5.bottom);
        }
        int ceil = (int) Math.ceil(this.getValueOfTouchPositionAbsolute.width());
        int ceil2 = (int) Math.ceil(this.getValueOfTouchPositionAbsolute.height());
        if (ceil == 0 || ceil2 == 0) {
            return;
        }
        Bitmap bitmap = this.getCallingPid;
        if (bitmap == null || bitmap.getWidth() < ceil || this.getCallingPid.getHeight() < ceil2) {
            Bitmap createBitmap = Bitmap.createBitmap(ceil, ceil2, Bitmap.Config.ARGB_8888);
            this.getCallingPid = createBitmap;
            this.SubSequence.setBitmap(createBitmap);
            this.whenAvailable = true;
        } else if (this.getCallingPid.getWidth() > ceil || this.getCallingPid.getHeight() > ceil2) {
            Bitmap createBitmap2 = Bitmap.createBitmap(this.getCallingPid, 0, 0, ceil, ceil2);
            this.getCallingPid = createBitmap2;
            this.SubSequence.setBitmap(createBitmap2);
            this.whenAvailable = true;
        }
        if (this.whenAvailable) {
            this.readMicros.set(this.B);
            this.readMicros.preScale(width, height);
            this.readMicros.postTranslate(-this.getValueOfTouchPositionAbsolute.left, -this.getValueOfTouchPositionAbsolute.top);
            this.getCallingPid.eraseColor(0);
            compositionLayer.getAuthRequestContext(this.SubSequence, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.B.invert(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.VerifyPinStateManager$executeRiskChallenge$2$1.mapRect(this.A, this.getValueOfTouchPositionAbsolute);
            getAuthRequestContext(this.A, this.BottomSheetCardBindingView$watcherCardNumberView$1);
        }
        this.VerifyPinStateManager$executeRiskChallenge$2$2.set(0, 0, ceil, ceil2);
        canvas.drawBitmap(this.getCallingPid, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.C);
    }

    private static void getAuthRequestContext(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private boolean isLayoutRequested() {
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            ViewParent parent = ((View) callback).getParent();
            if (Build.VERSION.SDK_INT < 18 || !(parent instanceof ViewGroup)) {
                return false;
            }
            return !((ViewGroup) parent).getClipChildren();
        }
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.DatabaseTableConfigUtil.clear();
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        if (isVisible()) {
            return;
        }
        this.initRecordTimeStamp = OnVisibleAction.NONE;
    }
}
