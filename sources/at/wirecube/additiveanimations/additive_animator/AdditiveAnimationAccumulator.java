package at.wirecube.additiveanimations.additive_animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import at.wirecube.additiveanimations.additive_animator.AdditiveAnimationAccumulator;
import at.wirecube.additiveanimations.additive_animator.RunningAnimationsManager;
import at.wirecube.additiveanimations.additive_animator.animation_set.AnimationState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AdditiveAnimationAccumulator {
    BaseAdditiveAnimator MyBillsEntityDataFactory;
    ValueAnimator getAuthRequestContext;
    List<AdditiveAnimationWrapper> BuiltInFictitiousFunctionClassFactory = new ArrayList();
    private Map<Object, Set<AdditiveAnimationWrapper>> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
    boolean PlaceComponentResult = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class AdditiveAnimationWrapper<T> {
        private final AdditiveAnimation<T> BuiltInFictitiousFunctionClassFactory;
        private float MyBillsEntityDataFactory = 0.0f;

        AdditiveAnimationWrapper(AdditiveAnimation<T> additiveAnimation) {
            this.BuiltInFictitiousFunctionClassFactory = additiveAnimation;
        }

        public final int hashCode() {
            return this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return this.BuiltInFictitiousFunctionClassFactory.equals(((AdditiveAnimationWrapper) obj).BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdditiveAnimationAccumulator(BaseAdditiveAnimator baseAdditiveAnimator) {
        this.getAuthRequestContext = null;
        this.getAuthRequestContext = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.MyBillsEntityDataFactory = baseAdditiveAnimator;
        final ArrayList arrayList = new ArrayList();
        this.getAuthRequestContext.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: at.wirecube.additiveanimations.additive_animator.AdditiveAnimationAccumulator$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f;
                AdditiveAnimationAccumulator additiveAnimationAccumulator = AdditiveAnimationAccumulator.this;
                List list = arrayList;
                if (!additiveAnimationAccumulator.PlaceComponentResult) {
                    additiveAnimationAccumulator.PlaceComponentResult();
                }
                for (AdditiveAnimationAccumulator.AdditiveAnimationWrapper additiveAnimationWrapper : additiveAnimationAccumulator.BuiltInFictitiousFunctionClassFactory) {
                    AccumulatedAnimationValue accumulatedAnimationValue = additiveAnimationWrapper.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    f = additiveAnimationWrapper.MyBillsEntityDataFactory;
                    float PlaceComponentResult = additiveAnimationWrapper.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(animatedFraction);
                    additiveAnimationWrapper.MyBillsEntityDataFactory = PlaceComponentResult;
                    accumulatedAnimationValue.MyBillsEntityDataFactory += PlaceComponentResult - f;
                    list.add(accumulatedAnimationValue);
                }
                additiveAnimationAccumulator.MyBillsEntityDataFactory.MyBillsEntityDataFactory(list);
                list.clear();
            }
        });
        this.getAuthRequestContext.addListener(new AnimatorListenerAdapter() { // from class: at.wirecube.additiveanimations.additive_animator.AdditiveAnimationAccumulator.1
            boolean MyBillsEntityDataFactory = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.MyBillsEntityDataFactory = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RunningAnimationsManager.AnimationInfo BuiltInFictitiousFunctionClassFactory;
                Iterator it = AdditiveAnimationAccumulator.this.KClassImpl$Data$declaredNonStaticMembers$2.keySet().iterator();
                while (it.hasNext()) {
                    RunningAnimationsManager authRequestContext = RunningAnimationsManager.getAuthRequestContext(it.next());
                    AdditiveAnimationAccumulator additiveAnimationAccumulator = AdditiveAnimationAccumulator.this;
                    boolean z = this.MyBillsEntityDataFactory;
                    authRequestContext.getAuthRequestContext.remove(additiveAnimationAccumulator);
                    authRequestContext.BuiltInFictitiousFunctionClassFactory();
                    for (AdditiveAnimation additiveAnimation : additiveAnimationAccumulator.MyBillsEntityDataFactory(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2)) {
                        AnimationState<T> animationState = authRequestContext.PlaceComponentResult;
                        if (animationState != 0 && animationState.MyBillsEntityDataFactory() != null && authRequestContext.PlaceComponentResult.PlaceComponentResult(additiveAnimation.PlaceComponentResult)) {
                            authRequestContext.PlaceComponentResult.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
                        }
                        if (!z && (BuiltInFictitiousFunctionClassFactory = authRequestContext.BuiltInFictitiousFunctionClassFactory(additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda1, false)) != null) {
                            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = Math.max(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory - 1, 0);
                            if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory == 0) {
                                authRequestContext.MyBillsEntityDataFactory.remove(additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda1);
                            }
                        }
                    }
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                AdditiveAnimationAccumulator.this.PlaceComponentResult();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult() {
        if (this.PlaceComponentResult) {
            return;
        }
        this.PlaceComponentResult = true;
        for (Object obj : new ArrayList(this.KClassImpl$Data$declaredNonStaticMembers$2.keySet())) {
            RunningAnimationsManager authRequestContext = RunningAnimationsManager.getAuthRequestContext(obj);
            authRequestContext.BuiltInFictitiousFunctionClassFactory(this);
            Set<AdditiveAnimationWrapper> set = this.KClassImpl$Data$declaredNonStaticMembers$2.get(obj);
            if (set == null) {
                set = new HashSet<>();
            }
            for (AdditiveAnimationWrapper additiveAnimationWrapper : set) {
                authRequestContext.MyBillsEntityDataFactory(additiveAnimationWrapper.BuiltInFictitiousFunctionClassFactory);
                additiveAnimationWrapper.MyBillsEntityDataFactory = additiveAnimationWrapper.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(AdditiveAnimation additiveAnimation) {
        AdditiveAnimationWrapper additiveAnimationWrapper = new AdditiveAnimationWrapper(additiveAnimation);
        this.BuiltInFictitiousFunctionClassFactory.add(additiveAnimationWrapper);
        Set<AdditiveAnimationWrapper> set = this.KClassImpl$Data$declaredNonStaticMembers$2.get(additiveAnimationWrapper.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil);
        if (set == null) {
            set = new HashSet<>(1);
            this.KClassImpl$Data$declaredNonStaticMembers$2.put(additiveAnimationWrapper.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil, set);
        }
        set.add(additiveAnimationWrapper);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Collection<AdditiveAnimation> getAuthRequestContext() {
        HashSet hashSet = new HashSet(this.BuiltInFictitiousFunctionClassFactory.size());
        Iterator<AdditiveAnimationWrapper> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().BuiltInFictitiousFunctionClassFactory);
        }
        return hashSet;
    }

    public int hashCode() {
        return this.getAuthRequestContext.hashCode();
    }

    public boolean equals(Object obj) {
        return obj == this || ((AdditiveAnimationAccumulator) obj).getAuthRequestContext == this.getAuthRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Collection<AdditiveAnimation> MyBillsEntityDataFactory(Object obj) {
        Set<AdditiveAnimationWrapper> set = this.KClassImpl$Data$declaredNonStaticMembers$2.get(obj);
        if (set == null) {
            set = new HashSet<>();
        }
        ArrayList arrayList = new ArrayList(set.size());
        Iterator<AdditiveAnimationWrapper> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().BuiltInFictitiousFunctionClassFactory);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str, Object obj) {
        AdditiveAnimationWrapper additiveAnimationWrapper;
        Set<AdditiveAnimationWrapper> set = this.KClassImpl$Data$declaredNonStaticMembers$2.get(obj);
        if (set == null) {
            set = new HashSet<>();
        }
        Iterator<AdditiveAnimationWrapper> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                additiveAnimationWrapper = null;
                break;
            }
            additiveAnimationWrapper = it.next();
            if (additiveAnimationWrapper.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1.equals(str)) {
                break;
            }
        }
        if (additiveAnimationWrapper != null) {
            this.BuiltInFictitiousFunctionClassFactory.remove(additiveAnimationWrapper);
            Set<AdditiveAnimationWrapper> set2 = this.KClassImpl$Data$declaredNonStaticMembers$2.get(additiveAnimationWrapper.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil);
            if (set2 != null) {
                set2.remove(additiveAnimationWrapper);
                if (set2.size() == 0) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.remove(additiveAnimationWrapper.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil);
                }
            }
        }
        Set<AdditiveAnimationWrapper> set3 = this.KClassImpl$Data$declaredNonStaticMembers$2.get(obj);
        return set3 == null || set3.size() == 0;
    }
}
