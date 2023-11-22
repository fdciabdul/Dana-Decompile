package at.wirecube.additiveanimations.additive_animator;

import android.util.Property;
import android.view.View;
import at.wirecube.additiveanimations.additive_animator.animation_set.AnimationState;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class RunningAnimationsManager<T> {
    private static final Map<Object, RunningAnimationsManager> lookAheadTest = new HashMap();
    final T KClassImpl$Data$declaredNonStaticMembers$2;
    private final AccumulatedAnimationValueManager moveToNextValue = new AccumulatedAnimationValueManager();
    boolean BuiltInFictitiousFunctionClassFactory = false;
    AnimationState<T> PlaceComponentResult = null;
    final Set<AdditiveAnimationAccumulator> getAuthRequestContext = new HashSet();
    final Map<String, RunningAnimationsManager<T>.AnimationInfo> MyBillsEntityDataFactory = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class AnimationInfo {
        int BuiltInFictitiousFunctionClassFactory;
        Float KClassImpl$Data$declaredNonStaticMembers$2;
        Float getAuthRequestContext;

        private AnimationInfo() {
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.getAuthRequestContext = null;
        }

        /* synthetic */ AnimationInfo(RunningAnimationsManager runningAnimationsManager, byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> RunningAnimationsManager<T> getAuthRequestContext(T t) {
        if (t == null) {
            return null;
        }
        Map<Object, RunningAnimationsManager> map = lookAheadTest;
        RunningAnimationsManager<T> runningAnimationsManager = map.get(t);
        if (runningAnimationsManager == null) {
            RunningAnimationsManager<T> runningAnimationsManager2 = new RunningAnimationsManager<>(t);
            map.put(t, runningAnimationsManager2);
            return runningAnimationsManager2;
        }
        return runningAnimationsManager;
    }

    private RunningAnimationsManager(T t) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final RunningAnimationsManager<T>.AnimationInfo BuiltInFictitiousFunctionClassFactory(String str, boolean z) {
        RunningAnimationsManager<T>.AnimationInfo animationInfo = this.MyBillsEntityDataFactory.get(str);
        if (animationInfo == null && z) {
            RunningAnimationsManager<T>.AnimationInfo animationInfo2 = new AnimationInfo(this, (byte) 0);
            this.MyBillsEntityDataFactory.put(str, animationInfo2);
            return animationInfo2;
        }
        return animationInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult(AdditiveAnimationAccumulator additiveAnimationAccumulator, AdditiveAnimation additiveAnimation) {
        this.getAuthRequestContext.add(additiveAnimationAccumulator);
        additiveAnimationAccumulator.getAuthRequestContext(additiveAnimation);
        BuiltInFictitiousFunctionClassFactory(additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda1, true).getAuthRequestContext = Float.valueOf(additiveAnimation.GetContactSyncConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(AdditiveAnimationAccumulator additiveAnimationAccumulator) {
        for (AdditiveAnimation additiveAnimation : additiveAnimationAccumulator.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            if (additiveAnimation.PlaceComponentResult != null) {
                if (additiveAnimation.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult)) {
                    if (additiveAnimation.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2() != null) {
                        additiveAnimation.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                } else {
                    additiveAnimationAccumulator.KClassImpl$Data$declaredNonStaticMembers$2(additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda1, additiveAnimation.DatabaseTableConfigUtil);
                }
            }
        }
        if (additiveAnimationAccumulator.getAuthRequestContext().isEmpty()) {
            this.getAuthRequestContext.remove(additiveAnimationAccumulator);
            BuiltInFictitiousFunctionClassFactory();
        } else if (this.BuiltInFictitiousFunctionClassFactory) {
            T t = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (!(t instanceof View) || ((View) t).getLayerType() == 2) {
                return;
            }
            ((View) this.KClassImpl$Data$declaredNonStaticMembers$2).setLayerType(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(AdditiveAnimation<T> additiveAnimation) {
        AccumulatedAnimationValue authRequestContext = this.moveToNextValue.getAuthRequestContext(additiveAnimation);
        RunningAnimationsManager<T>.AnimationInfo BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda1, true);
        RunningAnimationsManager<T>.AnimationInfo BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda1, false);
        if ((BuiltInFictitiousFunctionClassFactory2 == null ? null : BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2) == null || BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory == 0) {
            Float BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(additiveAnimation);
            if (BuiltInFictitiousFunctionClassFactory3 != null) {
                additiveAnimation.initRecordTimeStamp = BuiltInFictitiousFunctionClassFactory3.floatValue();
            }
            authRequestContext.MyBillsEntityDataFactory = additiveAnimation.initRecordTimeStamp;
        } else {
            RunningAnimationsManager<T>.AnimationInfo BuiltInFictitiousFunctionClassFactory4 = BuiltInFictitiousFunctionClassFactory(additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda1, false);
            additiveAnimation.initRecordTimeStamp = (BuiltInFictitiousFunctionClassFactory4 != null ? BuiltInFictitiousFunctionClassFactory4.KClassImpl$Data$declaredNonStaticMembers$2 : null).floatValue();
        }
        if (additiveAnimation.PlaceComponentResult()) {
            additiveAnimation.GetContactSyncConfig = additiveAnimation.initRecordTimeStamp + additiveAnimation.BuiltInFictitiousFunctionClassFactory;
        }
        additiveAnimation.getAuthRequestContext = authRequestContext;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory++;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = Float.valueOf(additiveAnimation.GetContactSyncConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        if (this.getAuthRequestContext.isEmpty()) {
            lookAheadTest.remove(this.KClassImpl$Data$declaredNonStaticMembers$2);
            if (this.BuiltInFictitiousFunctionClassFactory) {
                T t = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (t instanceof View) {
                    ((View) t).setLayerType(0, null);
                }
            }
        }
    }

    private Float BuiltInFictitiousFunctionClassFactory(AdditiveAnimation<T> additiveAnimation) {
        if (additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            Property<T, Float> property = additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0;
            RunningAnimationsManager<T>.AnimationInfo BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(property.getName(), false);
            Float f = BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            return f == null ? property.get(this.KClassImpl$Data$declaredNonStaticMembers$2) : f;
        }
        return null;
    }
}
