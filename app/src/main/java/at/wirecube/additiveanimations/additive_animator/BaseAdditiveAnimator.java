package at.wirecube.additiveanimations.additive_animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.animation.LinearInterpolator;
import at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator;
import at.wirecube.additiveanimations.additive_animator.animation_set.AnimationAction;
import at.wirecube.additiveanimations.additive_animator.animation_set.AnimationState;
import at.wirecube.additiveanimations.additive_animator.sequence.AnimationSequence;
import at.wirecube.additiveanimations.helper.EaseInOutPathInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class BaseAdditiveAnimator<T extends BaseAdditiveAnimator, V> extends AnimationSequence {
    private static TimeInterpolator NetworkUserEntityData$$ExternalSyntheticLambda0 = EaseInOutPathInterpolator.MyBillsEntityDataFactory();
    private static long lookAheadTest = 300;
    protected AdditiveAnimationAccumulator KClassImpl$Data$declaredNonStaticMembers$2;
    protected T getAuthRequestContext = null;
    protected V BuiltInFictitiousFunctionClassFactory = null;
    protected RunningAnimationsManager<V> scheduleImpl = null;
    protected TimeInterpolator MyBillsEntityDataFactory = null;
    protected long getErrorConfigVersion = 0;
    protected long moveToNextValue = 0;
    private Map<V, List<AccumulatedAnimationValue<V>>> NetworkUserEntityData$$ExternalSyntheticLambda1 = new HashMap();
    private HashMap<String, Float> initRecordTimeStamp = new HashMap<>();
    protected AdditiveAnimatorGroup PlaceComponentResult = null;
    private boolean GetContactSyncConfig = true;

    public abstract Float MyBillsEntityDataFactory();

    public abstract void PlaceComponentResult();

    protected abstract T getAuthRequestContext();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory() {
        if (!this.GetContactSyncConfig) {
            throw new RuntimeException("AdditiveAnimator instances cannot be reused.");
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new AdditiveAnimationAccumulator(this);
            BuiltInFictitiousFunctionClassFactory();
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setInterpolator(NetworkUserEntityData$$ExternalSyntheticLambda0);
            BuiltInFictitiousFunctionClassFactory();
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setDuration(lookAheadTest);
        }
    }

    public final float MyBillsEntityDataFactory(Property<V, Float> property) {
        RunningAnimationsManager<V> runningAnimationsManager = this.scheduleImpl;
        if (runningAnimationsManager == null) {
            return 0.0f;
        }
        RunningAnimationsManager<V>.AnimationInfo BuiltInFictitiousFunctionClassFactory = runningAnimationsManager.BuiltInFictitiousFunctionClassFactory(property.getName(), false);
        Float f = BuiltInFictitiousFunctionClassFactory == null ? null : BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (f == null) {
            f = property.get(runningAnimationsManager.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return f.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Float getAuthRequestContext(String str) {
        RunningAnimationsManager<V>.AnimationInfo BuiltInFictitiousFunctionClassFactory = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(str, false);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return null;
        }
        return BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MyBillsEntityDataFactory(List<AccumulatedAnimationValue<V>> list) {
        for (AccumulatedAnimationValue<V> accumulatedAnimationValue : list) {
            V v = accumulatedAnimationValue.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil;
            if (accumulatedAnimationValue.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                accumulatedAnimationValue.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.set(v, Float.valueOf(accumulatedAnimationValue.MyBillsEntityDataFactory));
            } else {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new HashMap();
                }
                List<AccumulatedAnimationValue<V>> list2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(v);
                if (list2 == null) {
                    list2 = new ArrayList<>(1);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.put(v, list2);
                }
                list2.add(accumulatedAnimationValue);
            }
        }
        Map<V, List<AccumulatedAnimationValue<V>>> map = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (map != null) {
            Iterator<V> it = map.keySet().iterator();
            while (it.hasNext()) {
                for (AccumulatedAnimationValue<V> accumulatedAnimationValue2 : this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(it.next())) {
                    this.initRecordTimeStamp.put(accumulatedAnimationValue2.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1, Float.valueOf(accumulatedAnimationValue2.MyBillsEntityDataFactory));
                }
            }
        }
        Iterator<List<AccumulatedAnimationValue<V>>> it2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.values().iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
        this.initRecordTimeStamp.clear();
        PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AdditiveAnimation<V> PlaceComponentResult(Property<V, Float> property, float f) {
        V v = this.BuiltInFictitiousFunctionClassFactory;
        AdditiveAnimation<V> additiveAnimation = new AdditiveAnimation<>(v, property, property.get(v).floatValue(), f);
        additiveAnimation.MyBillsEntityDataFactory = this.MyBillsEntityDataFactory;
        return additiveAnimation;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T BuiltInFictitiousFunctionClassFactory(final AdditiveAnimation additiveAnimation, boolean z) {
        BuiltInFictitiousFunctionClassFactory();
        this.scheduleImpl.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, additiveAnimation);
        if (z) {
            MyBillsEntityDataFactory(new Runnable() { // from class: at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    BaseAdditiveAnimator.this.BuiltInFictitiousFunctionClassFactory(additiveAnimation);
                }
            });
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void MyBillsEntityDataFactory(final Property property, final float f) {
        final T t = this.getAuthRequestContext;
        t.BuiltInFictitiousFunctionClassFactory();
        AdditiveAnimation<V> PlaceComponentResult = t.PlaceComponentResult(property, f);
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult.GetContactSyncConfig;
        t.BuiltInFictitiousFunctionClassFactory();
        t.scheduleImpl.PlaceComponentResult(t.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult);
        t.MyBillsEntityDataFactory(new Runnable() { // from class: at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                BaseAdditiveAnimator.this.MyBillsEntityDataFactory(property, f);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T BuiltInFictitiousFunctionClassFactory(AnimationState<V> animationState) {
        this.scheduleImpl.PlaceComponentResult = animationState;
        AdditiveAnimatorGroup additiveAnimatorGroup = this.PlaceComponentResult;
        if (additiveAnimatorGroup != null) {
            Iterator<BaseAdditiveAnimator> it = additiveAnimatorGroup.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                it.next().scheduleImpl.PlaceComponentResult = animationState;
            }
        }
        for (AnimationAction.Animation animation : animationState.BuiltInFictitiousFunctionClassFactory()) {
            Property<T, Float> property = animation.BuiltInFictitiousFunctionClassFactory;
            float f = animation.MyBillsEntityDataFactory;
            TypeEvaluator<Float> typeEvaluator = animation.getAuthRequestContext;
            V v = this.BuiltInFictitiousFunctionClassFactory;
            AdditiveAnimation additiveAnimation = new AdditiveAnimation(v, (Property<V, Float>) property, property.get(v).floatValue(), f);
            additiveAnimation.lookAheadTest = typeEvaluator;
            additiveAnimation.MyBillsEntityDataFactory = this.MyBillsEntityDataFactory;
            additiveAnimation.PlaceComponentResult = animationState;
            BuiltInFictitiousFunctionClassFactory(additiveAnimation, true);
        }
        return this;
    }

    public T KClassImpl$Data$declaredNonStaticMembers$2(V v) {
        if (this.PlaceComponentResult == null) {
            this.BuiltInFictitiousFunctionClassFactory = v;
            this.scheduleImpl = RunningAnimationsManager.getAuthRequestContext(v);
            BuiltInFictitiousFunctionClassFactory();
            return this;
        }
        T authRequestContext = getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory(this);
        authRequestContext.BuiltInFictitiousFunctionClassFactory();
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setStartDelay(0L);
        authRequestContext.MyBillsEntityDataFactory(new BaseAdditiveAnimator$$ExternalSyntheticLambda1(authRequestContext, 0L));
        BuiltInFictitiousFunctionClassFactory();
        long startDelay = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getStartDelay() + 0;
        authRequestContext.BuiltInFictitiousFunctionClassFactory();
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setStartDelay(startDelay);
        authRequestContext.MyBillsEntityDataFactory(new BaseAdditiveAnimator$$ExternalSyntheticLambda1(authRequestContext, startDelay));
        return (T) authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(v);
    }

    /* renamed from: at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ AnimationEndListener BuiltInFictitiousFunctionClassFactory;
        boolean MyBillsEntityDataFactory;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.MyBillsEntityDataFactory = true;
        }
    }

    /* renamed from: at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ Runnable PlaceComponentResult;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.PlaceComponentResult.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(long j) {
        T t = this.getAuthRequestContext;
        t.BuiltInFictitiousFunctionClassFactory();
        t.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setStartDelay(j);
        t.MyBillsEntityDataFactory(new BaseAdditiveAnimator$$ExternalSyntheticLambda1(t, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void PlaceComponentResult(long j) {
        T t = this.getAuthRequestContext;
        t.BuiltInFictitiousFunctionClassFactory();
        t.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setDuration(j);
        t.MyBillsEntityDataFactory(new BaseAdditiveAnimator$$ExternalSyntheticLambda3(t, j));
    }

    private T KClassImpl$Data$declaredNonStaticMembers$2(final TimeInterpolator timeInterpolator) {
        if (this.MyBillsEntityDataFactory != null) {
            return MyBillsEntityDataFactory(timeInterpolator);
        }
        BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setInterpolator(timeInterpolator);
        MyBillsEntityDataFactory(new Runnable() { // from class: at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                BaseAdditiveAnimator.this.PlaceComponentResult(timeInterpolator);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void PlaceComponentResult(TimeInterpolator timeInterpolator) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(timeInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        T t = this.getAuthRequestContext;
        t.BuiltInFictitiousFunctionClassFactory();
        t.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setRepeatCount(i);
        t.MyBillsEntityDataFactory(new BaseAdditiveAnimator$$ExternalSyntheticLambda7(t, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void MyBillsEntityDataFactory(int i) {
        T t = this.getAuthRequestContext;
        t.BuiltInFictitiousFunctionClassFactory();
        t.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setRepeatMode(i);
        t.MyBillsEntityDataFactory(new BaseAdditiveAnimator$$ExternalSyntheticLambda8(t, i));
    }

    private T MyBillsEntityDataFactory(final TimeInterpolator timeInterpolator) {
        BuiltInFictitiousFunctionClassFactory();
        for (AdditiveAnimation additiveAnimation : this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
            BuiltInFictitiousFunctionClassFactory();
            additiveAnimation.MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getInterpolator();
        }
        this.MyBillsEntityDataFactory = timeInterpolator;
        BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setInterpolator(new LinearInterpolator());
        MyBillsEntityDataFactory(new Runnable() { // from class: at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                BaseAdditiveAnimator.this.getAuthRequestContext(timeInterpolator);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void getAuthRequestContext(TimeInterpolator timeInterpolator) {
        this.getAuthRequestContext.MyBillsEntityDataFactory(timeInterpolator);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        T t = this.getAuthRequestContext;
        if (t != null) {
            t.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        BuiltInFictitiousFunctionClassFactory();
        ValueAnimator valueAnimator = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
        BuiltInFictitiousFunctionClassFactory();
        valueAnimator.setStartDelay(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getStartDelay() + this.moveToNextValue);
        BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.start();
        this.GetContactSyncConfig = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(Runnable runnable) {
        T t;
        AdditiveAnimatorGroup additiveAnimatorGroup = this.PlaceComponentResult;
        if (additiveAnimatorGroup == null || (t = this.getAuthRequestContext) == null || t.PlaceComponentResult != additiveAnimatorGroup) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(AdditiveAnimation additiveAnimation) {
        AdditiveAnimation additiveAnimation2;
        Float f = null;
        if (additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            f = additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0.get(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory);
        } else {
            String str = additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda1;
            RunningAnimationsManager<V> runningAnimationsManager = this.scheduleImpl;
            if (runningAnimationsManager != null) {
                RunningAnimationsManager<V>.AnimationInfo BuiltInFictitiousFunctionClassFactory = runningAnimationsManager.BuiltInFictitiousFunctionClassFactory(str, false);
                if ((BuiltInFictitiousFunctionClassFactory == null ? null : BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                    RunningAnimationsManager<V>.AnimationInfo BuiltInFictitiousFunctionClassFactory2 = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(str, false);
                    if (BuiltInFictitiousFunctionClassFactory2 != null) {
                        f = BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2;
                    }
                }
            }
            f = MyBillsEntityDataFactory();
        }
        T t = this.getAuthRequestContext;
        V v = t.BuiltInFictitiousFunctionClassFactory;
        if (additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            if (additiveAnimation.scheduleImpl != null) {
                additiveAnimation2 = new AdditiveAnimation(v, (Property<V, Float>) additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0, f.floatValue(), additiveAnimation.scheduleImpl, additiveAnimation.moveToNextValue, additiveAnimation.getErrorConfigVersion);
            } else {
                additiveAnimation2 = new AdditiveAnimation(v, (Property<V, Float>) additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0, f.floatValue(), additiveAnimation.GetContactSyncConfig);
            }
        } else if (additiveAnimation.scheduleImpl != null) {
            additiveAnimation2 = new AdditiveAnimation(v, additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda1, f.floatValue(), additiveAnimation.scheduleImpl, additiveAnimation.moveToNextValue, additiveAnimation.getErrorConfigVersion);
        } else {
            additiveAnimation2 = new AdditiveAnimation(v, additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda1, f.floatValue(), additiveAnimation.GetContactSyncConfig);
        }
        boolean z = additiveAnimation.KClassImpl$Data$declaredNonStaticMembers$2;
        if (z) {
            additiveAnimation2.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            additiveAnimation2.BuiltInFictitiousFunctionClassFactory = additiveAnimation.BuiltInFictitiousFunctionClassFactory;
            additiveAnimation2.GetContactSyncConfig = f.floatValue() + additiveAnimation2.BuiltInFictitiousFunctionClassFactory;
        }
        TimeInterpolator timeInterpolator = additiveAnimation.MyBillsEntityDataFactory;
        if (timeInterpolator != null) {
            additiveAnimation2.MyBillsEntityDataFactory = timeInterpolator;
        }
        TypeEvaluator<Float> typeEvaluator = additiveAnimation.lookAheadTest;
        if (typeEvaluator != null) {
            additiveAnimation2.lookAheadTest = typeEvaluator;
        }
        AnimationState<T> animationState = additiveAnimation.PlaceComponentResult;
        if (animationState != 0) {
            additiveAnimation2.PlaceComponentResult = animationState;
        }
        t.BuiltInFictitiousFunctionClassFactory(additiveAnimation2, true);
    }

    public final T MyBillsEntityDataFactory(long j) {
        BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setDuration(j);
        MyBillsEntityDataFactory(new BaseAdditiveAnimator$$ExternalSyntheticLambda3(this, j));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T MyBillsEntityDataFactory(T t) {
        KClassImpl$Data$declaredNonStaticMembers$2((BaseAdditiveAnimator<T, V>) t.BuiltInFictitiousFunctionClassFactory);
        t.BuiltInFictitiousFunctionClassFactory();
        MyBillsEntityDataFactory(t.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getDuration());
        t.BuiltInFictitiousFunctionClassFactory();
        KClassImpl$Data$declaredNonStaticMembers$2(t.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getInterpolator());
        t.BuiltInFictitiousFunctionClassFactory();
        int repeatCount = t.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getRepeatCount();
        BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setRepeatCount(repeatCount);
        MyBillsEntityDataFactory(new BaseAdditiveAnimator$$ExternalSyntheticLambda7(this, repeatCount));
        t.BuiltInFictitiousFunctionClassFactory();
        int repeatMode = t.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getRepeatMode();
        BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.setRepeatMode(repeatMode);
        MyBillsEntityDataFactory(new BaseAdditiveAnimator$$ExternalSyntheticLambda8(this, repeatMode));
        this.MyBillsEntityDataFactory = t.MyBillsEntityDataFactory;
        this.getAuthRequestContext = t;
        return this;
    }
}
