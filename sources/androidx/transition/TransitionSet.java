package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TransitionSet extends Transition {
    int BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    boolean PlaceComponentResult;
    public ArrayList<Transition> getAuthRequestContext;

    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo45clone() throws CloneNotSupportedException {
        return mo45clone();
    }

    public TransitionSet() {
        this.getAuthRequestContext = new ArrayList<>();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.PlaceComponentResult = false;
        this.MyBillsEntityDataFactory = 0;
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.getAuthRequestContext = new ArrayList<>();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.PlaceComponentResult = false;
        this.MyBillsEntityDataFactory = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.scheduleImpl);
        PlaceComponentResult(TypedArrayUtils.getAuthRequestContext(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    public final TransitionSet PlaceComponentResult(int i) {
        if (i == 0) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        } else if (i == 1) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid parameter for TransitionSet ordering: ");
            sb.append(i);
            throw new AndroidRuntimeException(sb.toString());
        }
        return this;
    }

    @Override // androidx.transition.Transition
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public final TransitionSet setDuration(long j) {
        ArrayList<Transition> arrayList;
        super.setDuration(j);
        if (this.mDuration >= 0 && (arrayList = this.getAuthRequestContext) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.getAuthRequestContext.get(i).setDuration(j);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public final TransitionSet setInterpolator(TimeInterpolator timeInterpolator) {
        this.MyBillsEntityDataFactory |= 1;
        ArrayList<Transition> arrayList = this.getAuthRequestContext;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.getAuthRequestContext.get(i).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(View view, boolean z) {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            this.getAuthRequestContext.get(i).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(String str, boolean z) {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            this.getAuthRequestContext.get(i).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.getAuthRequestContext.size(); i2++) {
            this.getAuthRequestContext.get(i2).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(Class<?> cls, boolean z) {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            this.getAuthRequestContext.get(i).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.MyBillsEntityDataFactory |= 4;
        if (this.getAuthRequestContext != null) {
            for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
                this.getAuthRequestContext.get(i).setPathMotion(pathMotion);
            }
        }
    }

    /* loaded from: classes.dex */
    static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet getAuthRequestContext;

        TransitionSetListener(TransitionSet transitionSet) {
            this.getAuthRequestContext = transitionSet;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            if (this.getAuthRequestContext.PlaceComponentResult) {
                return;
            }
            this.getAuthRequestContext.start();
            this.getAuthRequestContext.PlaceComponentResult = true;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            TransitionSet transitionSet = this.getAuthRequestContext;
            transitionSet.BuiltInFictitiousFunctionClassFactory--;
            if (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory == 0) {
                this.getAuthRequestContext.PlaceComponentResult = false;
                this.getAuthRequestContext.end();
            }
            transition.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.transition.Transition
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.getAuthRequestContext.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.getAuthRequestContext.get(i);
            if (startDelay > 0 && (this.KClassImpl$Data$declaredNonStaticMembers$2 || i == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.transition.Transition
    public void runAnimators() {
        if (this.getAuthRequestContext.isEmpty()) {
            start();
            end();
            return;
        }
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it = this.getAuthRequestContext.iterator();
        while (it.hasNext()) {
            it.next().addListener(transitionSetListener);
        }
        this.BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.size();
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
            for (int i = 1; i < this.getAuthRequestContext.size(); i++) {
                Transition transition = this.getAuthRequestContext.get(i - 1);
                final Transition transition2 = this.getAuthRequestContext.get(i);
                transition.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.1
                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition3) {
                        transition2.runAnimators();
                        transition3.removeListener(this);
                    }
                });
            }
            Transition transition3 = this.getAuthRequestContext.get(0);
            if (transition3 != null) {
                transition3.runAnimators();
                return;
            }
            return;
        }
        Iterator<Transition> it2 = this.getAuthRequestContext.iterator();
        while (it2.hasNext()) {
            it2.next().runAnimators();
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.MyBillsEntityDataFactory)) {
            Iterator<Transition> it = this.getAuthRequestContext.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.MyBillsEntityDataFactory)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.KClassImpl$Data$declaredNonStaticMembers$2.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.MyBillsEntityDataFactory)) {
            Iterator<Transition> it = this.getAuthRequestContext.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.MyBillsEntityDataFactory)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.KClassImpl$Data$declaredNonStaticMembers$2.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.getAuthRequestContext.size();
        for (int i = 0; i < size; i++) {
            this.getAuthRequestContext.get(i).capturePropagationValues(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public void pause(View view) {
        super.pause(view);
        int size = this.getAuthRequestContext.size();
        for (int i = 0; i < size; i++) {
            this.getAuthRequestContext.get(i).pause(view);
        }
    }

    @Override // androidx.transition.Transition
    public void resume(View view) {
        super.resume(view);
        int size = this.getAuthRequestContext.size();
        for (int i = 0; i < size; i++) {
            this.getAuthRequestContext.get(i).resume(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.transition.Transition
    public void cancel() {
        super.cancel();
        int size = this.getAuthRequestContext.size();
        for (int i = 0; i < size; i++) {
            this.getAuthRequestContext.get(i).cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.getAuthRequestContext.size();
        for (int i = 0; i < size; i++) {
            this.getAuthRequestContext.get(i).forceToEnd(viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.getAuthRequestContext.size();
        for (int i = 0; i < size; i++) {
            this.getAuthRequestContext.get(i).setCanRemoveViews(z);
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.MyBillsEntityDataFactory |= 2;
        int size = this.getAuthRequestContext.size();
        for (int i = 0; i < size; i++) {
            this.getAuthRequestContext.get(i).setPropagation(transitionPropagation);
        }
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.MyBillsEntityDataFactory |= 8;
        int size = this.getAuthRequestContext.size();
        for (int i = 0; i < size; i++) {
            this.getAuthRequestContext.get(i).setEpicenterCallback(epicenterCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public String toString(String str) {
        String transition = super.toString(str);
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(transition);
            sb.append("\n");
            Transition transition2 = this.getAuthRequestContext.get(i);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("  ");
            sb.append(transition2.toString(sb2.toString()));
            transition = sb.toString();
        }
        return transition;
    }

    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public Transition mo45clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo45clone();
        transitionSet.getAuthRequestContext = new ArrayList<>();
        int size = this.getAuthRequestContext.size();
        for (int i = 0; i < size; i++) {
            Transition mo45clone = this.getAuthRequestContext.get(i).mo45clone();
            transitionSet.getAuthRequestContext.add(mo45clone);
            mo45clone.mParent = transitionSet;
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addListener(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    public /* synthetic */ Transition addTarget(int i) {
        for (int i2 = 0; i2 < this.getAuthRequestContext.size(); i2++) {
            this.getAuthRequestContext.get(i2).addTarget(i);
        }
        return (TransitionSet) super.addTarget(i);
    }

    @Override // androidx.transition.Transition
    public /* synthetic */ Transition addTarget(View view) {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            this.getAuthRequestContext.get(i).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    @Override // androidx.transition.Transition
    public /* synthetic */ Transition addTarget(Class cls) {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            this.getAuthRequestContext.get(i).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    @Override // androidx.transition.Transition
    public /* synthetic */ Transition addTarget(String str) {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            this.getAuthRequestContext.get(i).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    public final TransitionSet getAuthRequestContext(Transition transition) {
        this.getAuthRequestContext.add(transition);
        transition.mParent = this;
        if (this.mDuration >= 0) {
            transition.setDuration(this.mDuration);
        }
        if ((this.MyBillsEntityDataFactory & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.MyBillsEntityDataFactory & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.MyBillsEntityDataFactory & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.MyBillsEntityDataFactory & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeListener(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    public /* synthetic */ Transition removeTarget(int i) {
        for (int i2 = 0; i2 < this.getAuthRequestContext.size(); i2++) {
            this.getAuthRequestContext.get(i2).removeTarget(i);
        }
        return (TransitionSet) super.removeTarget(i);
    }

    @Override // androidx.transition.Transition
    public /* synthetic */ Transition removeTarget(View view) {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            this.getAuthRequestContext.get(i).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    @Override // androidx.transition.Transition
    public /* synthetic */ Transition removeTarget(Class cls) {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            this.getAuthRequestContext.get(i).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    @Override // androidx.transition.Transition
    public /* synthetic */ Transition removeTarget(String str) {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            this.getAuthRequestContext.get(i).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setStartDelay(long j) {
        return (TransitionSet) super.setStartDelay(j);
    }
}
