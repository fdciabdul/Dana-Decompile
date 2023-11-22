package at.wirecube.additiveanimations.additive_animator;

import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;
import at.wirecube.additiveanimations.additive_animator.SubclassableAdditiveViewAnimator;
import at.wirecube.additiveanimations.additive_animator.view_visibility.ViewVisibilityAnimation;
import at.wirecube.additiveanimations.helper.AnimationUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class SubclassableAdditiveViewAnimator<T extends SubclassableAdditiveViewAnimator> extends BaseAdditiveAnimator<T, View> {
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
    protected boolean lookAheadTest = false;

    @Override // at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator
    public final Float MyBillsEntityDataFactory() {
        return null;
    }

    @Override // at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator
    public final void PlaceComponentResult() {
    }

    @Override // at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator
    public final /* synthetic */ BaseAdditiveAnimator KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        View view2 = view;
        if (this.lookAheadTest) {
            scheduleImpl();
        }
        return (SubclassableAdditiveViewAnimator) super.KClassImpl$Data$declaredNonStaticMembers$2((SubclassableAdditiveViewAnimator<T>) view2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator
    public final /* bridge */ /* synthetic */ BaseAdditiveAnimator MyBillsEntityDataFactory(BaseAdditiveAnimator baseAdditiveAnimator) {
        SubclassableAdditiveViewAnimator subclassableAdditiveViewAnimator = (SubclassableAdditiveViewAnimator) baseAdditiveAnimator;
        super.MyBillsEntityDataFactory(subclassableAdditiveViewAnimator);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = subclassableAdditiveViewAnimator.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.lookAheadTest = subclassableAdditiveViewAnimator.lookAheadTest;
        return this;
    }

    public final T BuiltInFictitiousFunctionClassFactory(View view) {
        if (this.lookAheadTest) {
            scheduleImpl();
        }
        return (T) super.KClassImpl$Data$declaredNonStaticMembers$2((SubclassableAdditiveViewAnimator<T>) view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator
    public final void MyBillsEntityDataFactory(List<AccumulatedAnimationValue<View>> list) {
        HashSet<View> hashSet = new HashSet(1);
        HashMap hashMap = null;
        for (AccumulatedAnimationValue<View> accumulatedAnimationValue : list) {
            View view = accumulatedAnimationValue.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil;
            hashSet.add(view);
            if (accumulatedAnimationValue.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                accumulatedAnimationValue.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.set(view, Float.valueOf(accumulatedAnimationValue.MyBillsEntityDataFactory));
            } else {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                List list2 = (List) hashMap.get(view);
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(view, list2);
                }
                list2.add(accumulatedAnimationValue);
            }
        }
        if (hashMap != null) {
            for (View view2 : hashMap.keySet()) {
                HashMap hashMap2 = new HashMap();
                for (AccumulatedAnimationValue accumulatedAnimationValue2 : (List) hashMap.get(view2)) {
                    hashMap2.put(accumulatedAnimationValue2.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1, Float.valueOf(accumulatedAnimationValue2.MyBillsEntityDataFactory));
                }
            }
        }
        for (View view3 : hashSet) {
            if (!ViewCompat.A(view3) && !this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                view3.requestLayout();
            }
        }
    }

    private T scheduleImpl() {
        if (this.scheduleImpl != null) {
            this.scheduleImpl.BuiltInFictitiousFunctionClassFactory = true;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.lookAheadTest = true;
        MyBillsEntityDataFactory(new Runnable() { // from class: at.wirecube.additiveanimations.additive_animator.SubclassableAdditiveViewAnimator$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SubclassableAdditiveViewAnimator.this.getErrorConfigVersion();
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void getErrorConfigVersion() {
        ((SubclassableAdditiveViewAnimator) this.getAuthRequestContext).scheduleImpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void moveToNextValue() {
        final SubclassableAdditiveViewAnimator subclassableAdditiveViewAnimator = (SubclassableAdditiveViewAnimator) this.getAuthRequestContext;
        if (subclassableAdditiveViewAnimator.scheduleImpl != null) {
            subclassableAdditiveViewAnimator.scheduleImpl.BuiltInFictitiousFunctionClassFactory = false;
        }
        subclassableAdditiveViewAnimator.lookAheadTest = false;
        subclassableAdditiveViewAnimator.MyBillsEntityDataFactory(new Runnable() { // from class: at.wirecube.additiveanimations.additive_animator.SubclassableAdditiveViewAnimator$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SubclassableAdditiveViewAnimator.this.moveToNextValue();
            }
        });
    }

    public final T BuiltInFictitiousFunctionClassFactory(int i) {
        if (i != 0) {
            if (i != 4) {
                if (i == 8) {
                    return (T) BuiltInFictitiousFunctionClassFactory(ViewVisibilityAnimation.PlaceComponentResult(true));
                }
                return this;
            }
            return (T) BuiltInFictitiousFunctionClassFactory(ViewVisibilityAnimation.PlaceComponentResult(false));
        }
        return (T) BuiltInFictitiousFunctionClassFactory(ViewVisibilityAnimation.PlaceComponentResult());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final Property property, final float f) {
        final SubclassableAdditiveViewAnimator subclassableAdditiveViewAnimator = (SubclassableAdditiveViewAnimator) this.getAuthRequestContext;
        subclassableAdditiveViewAnimator.BuiltInFictitiousFunctionClassFactory();
        float MyBillsEntityDataFactory = subclassableAdditiveViewAnimator.MyBillsEntityDataFactory(property);
        if (subclassableAdditiveViewAnimator.getAuthRequestContext(property.getName()) != null) {
            MyBillsEntityDataFactory = subclassableAdditiveViewAnimator.getAuthRequestContext(property.getName()).floatValue();
        }
        float MyBillsEntityDataFactory2 = AnimationUtils.MyBillsEntityDataFactory(MyBillsEntityDataFactory, f);
        subclassableAdditiveViewAnimator.MyBillsEntityDataFactory(new Runnable() { // from class: at.wirecube.additiveanimations.additive_animator.SubclassableAdditiveViewAnimator$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SubclassableAdditiveViewAnimator.this.BuiltInFictitiousFunctionClassFactory(property, f);
            }
        });
        SubclassableAdditiveViewAnimator subclassableAdditiveViewAnimator2 = (SubclassableAdditiveViewAnimator) subclassableAdditiveViewAnimator.BuiltInFictitiousFunctionClassFactory((AdditiveAnimation) subclassableAdditiveViewAnimator.PlaceComponentResult(property, MyBillsEntityDataFactory + MyBillsEntityDataFactory2), false);
    }
}
