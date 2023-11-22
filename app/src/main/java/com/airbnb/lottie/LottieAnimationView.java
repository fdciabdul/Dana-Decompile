package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final String PlaceComponentResult = "LottieAnimationView";
    private static final LottieListener<Throwable> getAuthRequestContext = new LottieListener() { // from class: com.airbnb.lottie.LottieAnimationView$$ExternalSyntheticLambda2
        @Override // com.airbnb.lottie.LottieListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
            LottieAnimationView.lambda$static$0((Throwable) obj);
        }
    };
    private boolean BuiltInFictitiousFunctionClassFactory;
    private final Set<UserActionTaken> DatabaseTableConfigUtil;
    private boolean GetContactSyncConfig;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final LottieListener<LottieComposition> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Set<LottieOnCompositionLoadedListener> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final LottieListener<Throwable> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private LottieTask<LottieComposition> getErrorConfigVersion;
    private final LottieDrawable initRecordTimeStamp;
    private LottieListener<Throwable> lookAheadTest;
    private LottieComposition moveToNextValue;
    private boolean scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum UserActionTaken {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    @Deprecated
    public void disableExtraScaleModeInFitXY() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$static$0(Throwable th) {
        if (Utils.KClassImpl$Data$declaredNonStaticMembers$2(th)) {
            Logger.getAuthRequestContext("Unable to load composition.", th);
            return;
        }
        throw new IllegalStateException("Unable to parse composition", th);
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new LottieListener() { // from class: com.airbnb.lottie.LottieAnimationView$$ExternalSyntheticLambda1
            @Override // com.airbnb.lottie.LottieListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.LottieListener
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
                Throwable th2 = th;
                if (LottieAnimationView.this.NetworkUserEntityData$$ExternalSyntheticLambda0 != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    int i = lottieAnimationView.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (lottieAnimationView instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(lottieAnimationView, i);
                    } else {
                        lottieAnimationView.setImageResource(i);
                    }
                }
                (LottieAnimationView.this.lookAheadTest == null ? LottieAnimationView.getAuthRequestContext : LottieAnimationView.this.lookAheadTest).KClassImpl$Data$declaredNonStaticMembers$2(th2);
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        this.initRecordTimeStamp = new LottieDrawable();
        this.GetContactSyncConfig = false;
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.scheduleImpl = true;
        this.DatabaseTableConfigUtil = new HashSet();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new HashSet();
        MyBillsEntityDataFactory(null, R.attr.res_0x7f040400_kclassimpl_data_declarednonstaticmembers_2);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new LottieListener() { // from class: com.airbnb.lottie.LottieAnimationView$$ExternalSyntheticLambda1
            @Override // com.airbnb.lottie.LottieListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.LottieListener
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
                Throwable th2 = th;
                if (LottieAnimationView.this.NetworkUserEntityData$$ExternalSyntheticLambda0 != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    int i = lottieAnimationView.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (lottieAnimationView instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(lottieAnimationView, i);
                    } else {
                        lottieAnimationView.setImageResource(i);
                    }
                }
                (LottieAnimationView.this.lookAheadTest == null ? LottieAnimationView.getAuthRequestContext : LottieAnimationView.this.lookAheadTest).KClassImpl$Data$declaredNonStaticMembers$2(th2);
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        this.initRecordTimeStamp = new LottieDrawable();
        this.GetContactSyncConfig = false;
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.scheduleImpl = true;
        this.DatabaseTableConfigUtil = new HashSet();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new HashSet();
        MyBillsEntityDataFactory(attributeSet, R.attr.res_0x7f040400_kclassimpl_data_declarednonstaticmembers_2);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new LottieListener() { // from class: com.airbnb.lottie.LottieAnimationView$$ExternalSyntheticLambda1
            @Override // com.airbnb.lottie.LottieListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.LottieListener
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
                Throwable th2 = th;
                if (LottieAnimationView.this.NetworkUserEntityData$$ExternalSyntheticLambda0 != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    int i2 = lottieAnimationView.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (lottieAnimationView instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(lottieAnimationView, i2);
                    } else {
                        lottieAnimationView.setImageResource(i2);
                    }
                }
                (LottieAnimationView.this.lookAheadTest == null ? LottieAnimationView.getAuthRequestContext : LottieAnimationView.this.lookAheadTest).KClassImpl$Data$declaredNonStaticMembers$2(th2);
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        this.initRecordTimeStamp = new LottieDrawable();
        this.GetContactSyncConfig = false;
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.scheduleImpl = true;
        this.DatabaseTableConfigUtil = new HashSet();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new HashSet();
        MyBillsEntityDataFactory(attributeSet, i);
    }

    private void MyBillsEntityDataFactory(AttributeSet attributeSet, int i) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.getCallingPid, i, 0);
        this.scheduleImpl = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetCardBindingView$watcherCardNumberView$1, true);
        boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.AppCompatEmojiTextHelper);
        boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.getValueOfTouchPositionAbsolute);
        boolean hasValue3 = obtainStyledAttributes.hasValue(R.styleable.J);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatEmojiTextHelper, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(R.styleable.getValueOfTouchPositionAbsolute);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(R.styleable.J)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(R.styleable.A, 0));
        if (obtainStyledAttributes.getBoolean(R.styleable.readMicros, false)) {
            this.BuiltInFictitiousFunctionClassFactory = true;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.D, false)) {
            this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.setRepeatCount(-1);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.H)) {
            setRepeatMode(obtainStyledAttributes.getInt(R.styleable.H, 1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.I)) {
            setRepeatCount(obtainStyledAttributes.getInt(R.styleable.I, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.G)) {
            setSpeed(obtainStyledAttributes.getFloat(R.styleable.G, 1.0f));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.B)) {
            setClipToCompositionBounds(obtainStyledAttributes.getBoolean(R.styleable.B, true));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.VerifyPinStateManager$executeRiskChallenge$2$2));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.getOnBoardingScenario, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(R.styleable.VerifyPinStateManager$executeRiskChallenge$2$1, false));
        if (obtainStyledAttributes.hasValue(R.styleable.C)) {
            addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.BuiltInFictitiousFunctionClassFactory, (LottieValueCallback<KeyPath>) new LottieValueCallback(new SimpleColorFilter(AppCompatResources.getAuthRequestContext(getContext(), obtainStyledAttributes.getResourceId(R.styleable.C, -1)).getDefaultColor())));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.F)) {
            int i2 = obtainStyledAttributes.getInt(R.styleable.F, RenderMode.AUTOMATIC.ordinal());
            if (i2 >= RenderMode.values().length) {
                i2 = RenderMode.AUTOMATIC.ordinal();
            }
            setRenderMode(RenderMode.values()[i2]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(R.styleable.E, false));
        obtainStyledAttributes.recycle();
        this.initRecordTimeStamp.FragmentBottomSheetPaymentSettingBinding = Utils.BuiltInFictitiousFunctionClassFactory(getContext()) != 0.0f;
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        LottieDrawable lottieDrawable;
        if (!this.GetContactSyncConfig && drawable == (lottieDrawable = this.initRecordTimeStamp) && lottieDrawable.scheduleImpl()) {
            pauseAnimation();
        } else if (!this.GetContactSyncConfig && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable2 = (LottieDrawable) drawable;
            if (lottieDrawable2.scheduleImpl()) {
                lottieDrawable2.DatabaseTableConfigUtil.clear();
                lottieDrawable2.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
                if (!lottieDrawable2.isVisible()) {
                    lottieDrawable2.initRecordTimeStamp = LottieDrawable.OnVisibleAction.NONE;
                }
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if (drawable instanceof LottieDrawable) {
            if ((((LottieDrawable) drawable).NetworkUserEntityData$$ExternalSyntheticLambda6 ? RenderMode.SOFTWARE : RenderMode.HARDWARE) == RenderMode.SOFTWARE) {
                this.initRecordTimeStamp.invalidateSelf();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.initRecordTimeStamp;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.MyBillsEntityDataFactory = this.MyBillsEntityDataFactory;
        savedState.getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2;
        savedState.KClassImpl$Data$declaredNonStaticMembers$2 = this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
        savedState.PlaceComponentResult = this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda2();
        savedState.BuiltInFictitiousFunctionClassFactory = this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda1;
        savedState.moveToNextValue = this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.getRepeatMode();
        savedState.scheduleImpl = this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.getRepeatCount();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.MyBillsEntityDataFactory = savedState.MyBillsEntityDataFactory;
        if (!this.DatabaseTableConfigUtil.contains(UserActionTaken.SET_ANIMATION) && !TextUtils.isEmpty(this.MyBillsEntityDataFactory)) {
            setAnimation(this.MyBillsEntityDataFactory);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = savedState.getAuthRequestContext;
        if (!this.DatabaseTableConfigUtil.contains(UserActionTaken.SET_ANIMATION) && (i = this.KClassImpl$Data$declaredNonStaticMembers$2) != 0) {
            setAnimation(i);
        }
        if (!this.DatabaseTableConfigUtil.contains(UserActionTaken.SET_PROGRESS)) {
            setProgress(savedState.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (!this.DatabaseTableConfigUtil.contains(UserActionTaken.PLAY_OPTION) && savedState.PlaceComponentResult) {
            playAnimation();
        }
        if (!this.DatabaseTableConfigUtil.contains(UserActionTaken.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.BuiltInFictitiousFunctionClassFactory);
        }
        if (!this.DatabaseTableConfigUtil.contains(UserActionTaken.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.moveToNextValue);
        }
        if (this.DatabaseTableConfigUtil.contains(UserActionTaken.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(savedState.scheduleImpl);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.initRecordTimeStamp.DatabaseTableConfigUtil();
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.initRecordTimeStamp.getErrorConfigVersion = z;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        LottieDrawable lottieDrawable = this.initRecordTimeStamp;
        if (lottieDrawable.BuiltInFictitiousFunctionClassFactory != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Logger.getAuthRequestContext("Merge paths are not supported pre-Kit Kat.");
                return;
            }
            lottieDrawable.BuiltInFictitiousFunctionClassFactory = z;
            if (lottieDrawable.getAuthRequestContext != null) {
                lottieDrawable.PlaceComponentResult();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.initRecordTimeStamp.GetContactSyncConfig();
    }

    public void setClipToCompositionBounds(boolean z) {
        LottieDrawable lottieDrawable = this.initRecordTimeStamp;
        if (z != lottieDrawable.PlaceComponentResult) {
            lottieDrawable.PlaceComponentResult = z;
            CompositionLayer compositionLayer = lottieDrawable.MyBillsEntityDataFactory;
            if (compositionLayer != null) {
                compositionLayer.moveToNextValue = z;
            }
            lottieDrawable.invalidateSelf();
        }
    }

    public boolean getClipToCompositionBounds() {
        return this.initRecordTimeStamp.moveToNextValue();
    }

    public void setCacheComposition(boolean z) {
        this.scheduleImpl = z;
    }

    public void setOutlineMasksAndMattes(boolean z) {
        LottieDrawable lottieDrawable = this.initRecordTimeStamp;
        if (lottieDrawable.PrepareContext != z) {
            lottieDrawable.PrepareContext = z;
            CompositionLayer compositionLayer = lottieDrawable.MyBillsEntityDataFactory;
            if (compositionLayer != null) {
                compositionLayer.KClassImpl$Data$declaredNonStaticMembers$2(z);
            }
        }
    }

    public void setAnimation(final int i) {
        LottieTask<LottieComposition> KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.MyBillsEntityDataFactory = null;
        if (isInEditMode()) {
            KClassImpl$Data$declaredNonStaticMembers$2 = new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.LottieAnimationView$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return LottieAnimationView.this.m48lambda$fromRawRes$1$comairbnblottieLottieAnimationView(i);
                }
            }, true);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = this.scheduleImpl ? LottieCompositionFactory.KClassImpl$Data$declaredNonStaticMembers$2(getContext(), i) : LottieCompositionFactory.getAuthRequestContext(getContext(), i);
        }
        getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$fromRawRes$1$com-airbnb-lottie-LottieAnimationView  reason: not valid java name */
    public /* synthetic */ LottieResult m48lambda$fromRawRes$1$comairbnblottieLottieAnimationView(int i) throws Exception {
        return this.scheduleImpl ? LottieCompositionFactory.MyBillsEntityDataFactory(getContext(), i) : LottieCompositionFactory.PlaceComponentResult(getContext(), i, (String) null);
    }

    public void setAnimation(final String str) {
        LottieTask<LottieComposition> BuiltInFictitiousFunctionClassFactory;
        this.MyBillsEntityDataFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        if (isInEditMode()) {
            BuiltInFictitiousFunctionClassFactory = new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.LottieAnimationView$$ExternalSyntheticLambda3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return LottieAnimationView.this.m47lambda$fromAssets$2$comairbnblottieLottieAnimationView(str);
                }
            }, true);
        } else {
            BuiltInFictitiousFunctionClassFactory = this.scheduleImpl ? LottieCompositionFactory.BuiltInFictitiousFunctionClassFactory(getContext(), str) : LottieCompositionFactory.PlaceComponentResult(getContext(), str);
        }
        getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$fromAssets$2$com-airbnb-lottie-LottieAnimationView  reason: not valid java name */
    public /* synthetic */ LottieResult m47lambda$fromAssets$2$comairbnblottieLottieAnimationView(String str) throws Exception {
        return this.scheduleImpl ? LottieCompositionFactory.getAuthRequestContext(getContext(), str) : LottieCompositionFactory.BuiltInFictitiousFunctionClassFactory(getContext(), str, (String) null);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromJson(String str, String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setAnimation(InputStream inputStream, String str) {
        getAuthRequestContext(LottieCompositionFactory.getAuthRequestContext(inputStream, str));
    }

    public void setAnimationFromUrl(String str) {
        LottieTask<LottieComposition> MyBillsEntityDataFactory;
        if (!this.scheduleImpl) {
            MyBillsEntityDataFactory = LottieCompositionFactory.MyBillsEntityDataFactory((String) null, new LottieCompositionFactory$$ExternalSyntheticLambda2(getContext(), str, null));
        } else {
            MyBillsEntityDataFactory = LottieCompositionFactory.KClassImpl$Data$declaredNonStaticMembers$2(getContext(), str);
        }
        getAuthRequestContext(MyBillsEntityDataFactory);
    }

    public void setAnimationFromUrl(String str, String str2) {
        LottieTask<LottieComposition> MyBillsEntityDataFactory;
        MyBillsEntityDataFactory = LottieCompositionFactory.MyBillsEntityDataFactory(str2, new LottieCompositionFactory$$ExternalSyntheticLambda2(getContext(), str, str2));
        getAuthRequestContext(MyBillsEntityDataFactory);
    }

    public void setFailureListener(LottieListener<Throwable> lottieListener) {
        this.lookAheadTest = lottieListener;
    }

    public void setFallbackResource(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
    }

    private void getAuthRequestContext(LottieTask<LottieComposition> lottieTask) {
        this.DatabaseTableConfigUtil.add(UserActionTaken.SET_ANIMATION);
        this.moveToNextValue = null;
        this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory();
        LottieTask<LottieComposition> lottieTask2 = this.getErrorConfigVersion;
        if (lottieTask2 != null) {
            lottieTask2.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        }
        this.getErrorConfigVersion = lottieTask.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1).getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
    }

    public void setComposition(LottieComposition lottieComposition) {
        if (L.getAuthRequestContext) {
            String str = PlaceComponentResult;
            StringBuilder sb = new StringBuilder();
            sb.append("Set Composition \n");
            sb.append(lottieComposition);
            InstrumentInjector.log_v(str, sb.toString());
        }
        this.initRecordTimeStamp.setCallback(this);
        this.moveToNextValue = lottieComposition;
        this.GetContactSyncConfig = true;
        boolean authRequestContext = this.initRecordTimeStamp.getAuthRequestContext(lottieComposition);
        this.GetContactSyncConfig = false;
        if (getDrawable() != this.initRecordTimeStamp || authRequestContext) {
            if (!authRequestContext) {
                boolean isAnimating = isAnimating();
                setImageDrawable(null);
                setImageDrawable(this.initRecordTimeStamp);
                if (isAnimating) {
                    this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda1();
                }
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener : this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            }
        }
    }

    public LottieComposition getComposition() {
        return this.moveToNextValue;
    }

    public boolean hasMasks() {
        return this.initRecordTimeStamp.getErrorConfigVersion();
    }

    public boolean hasMatte() {
        return this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    public void playAnimation() {
        this.DatabaseTableConfigUtil.add(UserActionTaken.PLAY_OPTION);
        this.initRecordTimeStamp.DatabaseTableConfigUtil();
    }

    public void resumeAnimation() {
        this.DatabaseTableConfigUtil.add(UserActionTaken.PLAY_OPTION);
        this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda1();
    }

    public void setMinFrame(int i) {
        this.initRecordTimeStamp.PlaceComponentResult(i);
    }

    public float getMinFrame() {
        LottieValueAnimator lottieValueAnimator = this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2;
        LottieComposition lottieComposition = lottieValueAnimator.MyBillsEntityDataFactory;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = lottieValueAnimator.PlaceComponentResult;
        return f == -2.14748365E9f ? lottieComposition.DatabaseTableConfigUtil : f;
    }

    public void setMinProgress(float f) {
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(f);
    }

    public void setMaxFrame(int i) {
        this.initRecordTimeStamp.getAuthRequestContext(i);
    }

    public float getMaxFrame() {
        LottieValueAnimator lottieValueAnimator = this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2;
        LottieComposition lottieComposition = lottieValueAnimator.MyBillsEntityDataFactory;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = lottieValueAnimator.getAuthRequestContext;
        return f == 2.14748365E9f ? lottieComposition.MyBillsEntityDataFactory : f;
    }

    public void setMaxProgress(float f) {
        this.initRecordTimeStamp.PlaceComponentResult(f);
    }

    public void setMinFrame(String str) {
        this.initRecordTimeStamp.MyBillsEntityDataFactory(str);
    }

    public void setMaxFrame(String str) {
        this.initRecordTimeStamp.getAuthRequestContext(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.initRecordTimeStamp.PlaceComponentResult(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory(str, str2, z);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory(i, i2);
    }

    public void setMinAndMaxProgress(float f, float f2) {
        this.initRecordTimeStamp.PlaceComponentResult(f, f2);
    }

    public void reverseAnimationSpeed() {
        LottieValueAnimator lottieValueAnimator = this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2;
        lottieValueAnimator.getErrorConfigVersion = -lottieValueAnimator.getErrorConfigVersion;
    }

    public void setSpeed(float f) {
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = f;
    }

    public float getSpeed() {
        return this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.addUpdateListener(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        LottieDrawable lottieDrawable = this.initRecordTimeStamp;
        lottieDrawable.KClassImpl$Data$declaredNonStaticMembers$2.removeAllUpdateListeners();
        lottieDrawable.KClassImpl$Data$declaredNonStaticMembers$2.addUpdateListener(lottieDrawable.isLayoutRequested);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.removeAllListeners();
    }

    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.addPauseListener(animatorPauseListener);
    }

    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.removePauseListener(animatorPauseListener);
    }

    @Deprecated
    public void loop(boolean z) {
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.setRepeatCount(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.DatabaseTableConfigUtil.add(UserActionTaken.SET_REPEAT_MODE);
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.DatabaseTableConfigUtil.add(UserActionTaken.SET_REPEAT_COUNT);
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.initRecordTimeStamp.scheduleImpl();
    }

    public void setImageAssetsFolder(String str) {
        this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
    }

    public String getImageAssetsFolder() {
        return this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.initRecordTimeStamp.GetContactSyncConfig = z;
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.initRecordTimeStamp.lookAheadTest();
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        LottieDrawable lottieDrawable = this.initRecordTimeStamp;
        ImageAssetManager KClassImpl$Data$declaredNonStaticMembers$2 = lottieDrawable.KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            Logger.getAuthRequestContext("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        if (bitmap == null) {
            LottieImageAsset lottieImageAsset = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.get(str);
            bitmap2 = lottieImageAsset.MyBillsEntityDataFactory;
            lottieImageAsset.MyBillsEntityDataFactory = null;
        } else {
            Bitmap bitmap3 = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.get(str).MyBillsEntityDataFactory;
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(str, bitmap);
            bitmap2 = bitmap3;
        }
        lottieDrawable.invalidateSelf();
        return bitmap2;
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        LottieDrawable lottieDrawable = this.initRecordTimeStamp;
        lottieDrawable.NetworkUserEntityData$$ExternalSyntheticLambda0 = imageAssetDelegate;
        ImageAssetManager imageAssetManager = lottieDrawable.moveToNextValue;
        if (imageAssetManager != null) {
            imageAssetManager.KClassImpl$Data$declaredNonStaticMembers$2 = imageAssetDelegate;
        }
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        LottieDrawable lottieDrawable = this.initRecordTimeStamp;
        lottieDrawable.scheduleImpl = fontAssetDelegate;
        FontAssetManager fontAssetManager = lottieDrawable.lookAheadTest;
        if (fontAssetManager != null) {
            fontAssetManager.PlaceComponentResult = fontAssetDelegate;
        }
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda4 = textDelegate;
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        return this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(keyPath);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory(keyPath, (KeyPath) t, (LottieValueCallback<KeyPath>) lottieValueCallback);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory(keyPath, (KeyPath) t, (LottieValueCallback<KeyPath>) new LottieValueCallback<T>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.value.LottieValueCallback
            public final T BuiltInFictitiousFunctionClassFactory(LottieFrameInfo<T> lottieFrameInfo) {
                return (T) simpleLottieValueCallback.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    public void cancelAnimation() {
        this.DatabaseTableConfigUtil.add(UserActionTaken.PLAY_OPTION);
        LottieDrawable lottieDrawable = this.initRecordTimeStamp;
        lottieDrawable.DatabaseTableConfigUtil.clear();
        lottieDrawable.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
        if (lottieDrawable.isVisible()) {
            return;
        }
        lottieDrawable.initRecordTimeStamp = LottieDrawable.OnVisibleAction.NONE;
    }

    public void pauseAnimation() {
        this.BuiltInFictitiousFunctionClassFactory = false;
        LottieDrawable lottieDrawable = this.initRecordTimeStamp;
        lottieDrawable.DatabaseTableConfigUtil.clear();
        lottieDrawable.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
        if (lottieDrawable.isVisible()) {
            return;
        }
        lottieDrawable.initRecordTimeStamp = LottieDrawable.OnVisibleAction.NONE;
    }

    public void setFrame(int i) {
        this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory(i);
    }

    public int getFrame() {
        return (int) this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void setProgress(float f) {
        this.DatabaseTableConfigUtil.add(UserActionTaken.SET_PROGRESS);
        this.initRecordTimeStamp.MyBillsEntityDataFactory(f);
    }

    public float getProgress() {
        return this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
    }

    public long getDuration() {
        if (this.moveToNextValue != null) {
            return ((r0.MyBillsEntityDataFactory - r0.DatabaseTableConfigUtil) / r0.PlaceComponentResult) * 1000.0f;
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        LottieDrawable lottieDrawable = this.initRecordTimeStamp;
        lottieDrawable.NetworkUserEntityData$$ExternalSyntheticLambda8 = z;
        LottieComposition lottieComposition = lottieDrawable.getAuthRequestContext;
        if (lottieComposition != null) {
            lottieComposition.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult = z;
        }
    }

    public PerformanceTracker getPerformanceTracker() {
        LottieComposition lottieComposition = this.initRecordTimeStamp.getAuthRequestContext;
        if (lottieComposition != null) {
            return lottieComposition.NetworkUserEntityData$$ExternalSyntheticLambda1;
        }
        return null;
    }

    public void setSafeMode(boolean z) {
        this.initRecordTimeStamp.newProxyInstance = z;
    }

    public void setRenderMode(RenderMode renderMode) {
        LottieDrawable lottieDrawable = this.initRecordTimeStamp;
        lottieDrawable.NetworkUserEntityData$$ExternalSyntheticLambda7 = renderMode;
        lottieDrawable.MyBillsEntityDataFactory();
    }

    public RenderMode getRenderMode() {
        return this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda6 ? RenderMode.SOFTWARE : RenderMode.HARDWARE;
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda2 = z;
    }

    public boolean addLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2.add(lottieOnCompositionLoadedListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2.remove(lottieOnCompositionLoadedListener);
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.clear();
    }

    /* loaded from: classes3.dex */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.airbnb.lottie.LottieAnimationView.SavedState.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String BuiltInFictitiousFunctionClassFactory;
        float KClassImpl$Data$declaredNonStaticMembers$2;
        String MyBillsEntityDataFactory;
        boolean PlaceComponentResult;
        int getAuthRequestContext;
        int moveToNextValue;
        int scheduleImpl;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.MyBillsEntityDataFactory = parcel.readString();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readFloat();
            this.PlaceComponentResult = parcel.readInt() == 1;
            this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
            this.moveToNextValue = parcel.readInt();
            this.scheduleImpl = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.MyBillsEntityDataFactory);
            parcel.writeFloat(this.KClassImpl$Data$declaredNonStaticMembers$2);
            parcel.writeInt(this.PlaceComponentResult ? 1 : 0);
            parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
            parcel.writeInt(this.moveToNextValue);
            parcel.writeInt(this.scheduleImpl);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        LottieTask<LottieComposition> lottieTask = this.getErrorConfigVersion;
        if (lottieTask != null) {
            lottieTask.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        }
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        LottieTask<LottieComposition> lottieTask = this.getErrorConfigVersion;
        if (lottieTask != null) {
            lottieTask.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        }
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        LottieTask<LottieComposition> lottieTask = this.getErrorConfigVersion;
        if (lottieTask != null) {
            lottieTask.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        }
        super.setImageResource(i);
    }
}
