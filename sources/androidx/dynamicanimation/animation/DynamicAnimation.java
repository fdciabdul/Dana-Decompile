package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    private float NetworkUserEntityData$$ExternalSyntheticLambda6;
    final Object PrepareContext;
    final FloatPropertyCompat isLayoutRequested;
    public static final ViewProperty lookAheadTest = new ViewProperty("translationX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.1
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            view.setTranslationX(f);
        }
    };
    public static final ViewProperty getErrorConfigVersion = new ViewProperty("translationY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.2
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            view.setTranslationY(f);
        }
    };
    public static final ViewProperty NetworkUserEntityData$$ExternalSyntheticLambda1 = new ViewProperty("translationZ") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.3
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return ViewCompat.readMicros(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            ViewCompat.getAuthRequestContext(view, f);
        }
    };
    public static final ViewProperty MyBillsEntityDataFactory = new ViewProperty("scaleX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.4
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return view.getScaleX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            view.setScaleX(f);
        }
    };
    public static final ViewProperty NetworkUserEntityData$$ExternalSyntheticLambda0 = new ViewProperty("scaleY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.5
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return view.getScaleY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            view.setScaleY(f);
        }
    };
    public static final ViewProperty PlaceComponentResult = new ViewProperty("rotation") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.6
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return view.getRotation();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            view.setRotation(f);
        }
    };
    public static final ViewProperty BuiltInFictitiousFunctionClassFactory = new ViewProperty("rotationX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.7
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return view.getRotationX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            view.setRotationX(f);
        }
    };
    public static final ViewProperty KClassImpl$Data$declaredNonStaticMembers$2 = new ViewProperty("rotationY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.8
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return view.getRotationY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            view.setRotationY(f);
        }
    };
    public static final ViewProperty initRecordTimeStamp = new ViewProperty("x") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.9
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return view.getX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            view.setX(f);
        }
    };
    public static final ViewProperty DatabaseTableConfigUtil = new ViewProperty("y") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.10
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return view.getY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            view.setY(f);
        }
    };
    public static final ViewProperty NetworkUserEntityData$$ExternalSyntheticLambda2 = new ViewProperty("z") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.11
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return ViewCompat.getSupportButtonTintMode(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            ViewCompat.moveToNextValue(view, f);
        }
    };
    public static final ViewProperty getAuthRequestContext = new ViewProperty("alpha") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.12
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return view.getAlpha();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            view.setAlpha(f);
        }
    };
    public static final ViewProperty scheduleImpl = new ViewProperty("scrollX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.13
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return view.getScrollX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            view.setScrollX((int) f);
        }
    };
    public static final ViewProperty moveToNextValue = new ViewProperty("scrollY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.14
        {
            byte b = 0;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ float getValue(View view) {
            return view.getScrollY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final /* synthetic */ void setValue(View view, float f) {
            view.setScrollY((int) f);
        }
    };
    float NetworkUserEntityData$$ExternalSyntheticLambda5 = 0.0f;
    public float FragmentBottomSheetPaymentSettingBinding = Float.MAX_VALUE;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
    float GetContactSyncConfig = Float.MAX_VALUE;
    float newProxyInstance = -3.4028235E38f;
    private long NetworkUserEntityData$$ExternalSyntheticLambda3 = 0;
    private final ArrayList<OnAnimationEndListener> NetworkUserEntityData$$ExternalSyntheticLambda4 = new ArrayList<>();
    private final ArrayList<OnAnimationUpdateListener> getCallingPid = new ArrayList<>();

    /* loaded from: classes3.dex */
    static class MassState {
        float PlaceComponentResult;
        float getAuthRequestContext;
    }

    /* loaded from: classes3.dex */
    public interface OnAnimationEndListener {
    }

    /* loaded from: classes3.dex */
    public interface OnAnimationUpdateListener {
    }

    abstract boolean MyBillsEntityDataFactory(long j);

    abstract boolean getAuthRequestContext(float f, float f2);

    /* loaded from: classes3.dex */
    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        /* synthetic */ ViewProperty(String str, byte b) {
            this(str);
        }

        private ViewProperty(String str) {
            super(str);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$15  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass15 extends FloatPropertyCompat {
        final /* synthetic */ FloatValueHolder PlaceComponentResult;

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(Object obj) {
            return this.PlaceComponentResult.getValue();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(Object obj, float f) {
            this.PlaceComponentResult.setValue(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K> DynamicAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        this.PrepareContext = k;
        this.isLayoutRequested = floatPropertyCompat;
        if (floatPropertyCompat == PlaceComponentResult || floatPropertyCompat == BuiltInFictitiousFunctionClassFactory || floatPropertyCompat == KClassImpl$Data$declaredNonStaticMembers$2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = 0.1f;
        } else if (floatPropertyCompat == getAuthRequestContext) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = 0.00390625f;
        } else if (floatPropertyCompat == MyBillsEntityDataFactory || floatPropertyCompat == NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = 0.00390625f;
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = 1.0f;
        }
    }

    public T MyBillsEntityDataFactory(float f) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = f;
        return this;
    }

    private static <T> void BuiltInFictitiousFunctionClassFactory(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public void getAuthRequestContext() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (z || z) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            this.FragmentBottomSheetPaymentSettingBinding = this.isLayoutRequested.getValue(this.PrepareContext);
        }
        float f = this.FragmentBottomSheetPaymentSettingBinding;
        if (f > this.GetContactSyncConfig || f < this.newProxyInstance) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        AnimationHandler BuiltInFictitiousFunctionClassFactory2 = AnimationHandler.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.size() == 0) {
            BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext();
        }
        if (BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.contains(this)) {
            return;
        }
        BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.add(this);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    public final boolean getAuthRequestContext(long j) {
        long j2 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (j2 == 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = j;
            getAuthRequestContext(this.FragmentBottomSheetPaymentSettingBinding);
            return false;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = j;
        boolean MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(j - j2);
        float min = Math.min(this.FragmentBottomSheetPaymentSettingBinding, this.GetContactSyncConfig);
        this.FragmentBottomSheetPaymentSettingBinding = min;
        float max = Math.max(min, this.newProxyInstance);
        this.FragmentBottomSheetPaymentSettingBinding = max;
        getAuthRequestContext(max);
        if (MyBillsEntityDataFactory2) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return MyBillsEntityDataFactory2;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
        AnimationHandler BuiltInFictitiousFunctionClassFactory2 = AnimationHandler.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult.remove(this);
        int indexOf = BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.indexOf(this);
        if (indexOf >= 0) {
            BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.set(indexOf, null);
            BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = true;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = 0L;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
        for (int i = 0; i < this.NetworkUserEntityData$$ExternalSyntheticLambda4.size(); i++) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda4.get(i) != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda4.get(i);
            }
        }
        BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
    }

    private void getAuthRequestContext(float f) {
        this.isLayoutRequested.setValue(this.PrepareContext, f);
        for (int i = 0; i < this.getCallingPid.size(); i++) {
            if (this.getCallingPid.get(i) != null) {
                this.getCallingPid.get(i);
            }
        }
        BuiltInFictitiousFunctionClassFactory(this.getCallingPid);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float MyBillsEntityDataFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6 * 0.75f;
    }
}
