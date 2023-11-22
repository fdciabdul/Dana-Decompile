package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TransitionManager {
    private static Transition PlaceComponentResult = new AutoTransition();
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> BuiltInFictitiousFunctionClassFactory = new ThreadLocal<>();
    static ArrayList<ViewGroup> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();
    private ArrayMap<Scene, Transition> getAuthRequestContext = new ArrayMap<>();
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> MyBillsEntityDataFactory = new ArrayMap<>();

    static ArrayMap<ViewGroup, ArrayList<Transition>> BuiltInFictitiousFunctionClassFactory() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> weakReference = BuiltInFictitiousFunctionClassFactory.get();
        if (weakReference == null || (arrayMap = weakReference.get()) == null) {
            ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
            BuiltInFictitiousFunctionClassFactory.set(new WeakReference<>(arrayMap2));
            return arrayMap2;
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        ViewGroup MyBillsEntityDataFactory;
        Transition getAuthRequestContext;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        MultiListener(Transition transition, ViewGroup viewGroup) {
            this.getAuthRequestContext = transition;
            this.MyBillsEntityDataFactory = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.MyBillsEntityDataFactory.getViewTreeObserver().removeOnPreDrawListener(this);
            this.MyBillsEntityDataFactory.removeOnAttachStateChangeListener(this);
            if (TransitionManager.KClassImpl$Data$declaredNonStaticMembers$2.remove(this.MyBillsEntityDataFactory)) {
                final ArrayMap<ViewGroup, ArrayList<Transition>> BuiltInFictitiousFunctionClassFactory = TransitionManager.BuiltInFictitiousFunctionClassFactory();
                ArrayList<Transition> arrayList = BuiltInFictitiousFunctionClassFactory.get(this.MyBillsEntityDataFactory);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    BuiltInFictitiousFunctionClassFactory.put(this.MyBillsEntityDataFactory, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.getAuthRequestContext);
                this.getAuthRequestContext.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionManager.MultiListener.1
                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition) {
                        ((ArrayList) BuiltInFictitiousFunctionClassFactory.get(MultiListener.this.MyBillsEntityDataFactory)).remove(transition);
                        transition.removeListener(this);
                    }
                });
                this.getAuthRequestContext.captureValues(this.MyBillsEntityDataFactory, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Transition) it.next()).resume(this.MyBillsEntityDataFactory);
                    }
                }
                this.getAuthRequestContext.playTransition(this.MyBillsEntityDataFactory);
                return true;
            }
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.MyBillsEntityDataFactory.getViewTreeObserver().removeOnPreDrawListener(this);
            this.MyBillsEntityDataFactory.removeOnAttachStateChangeListener(this);
            TransitionManager.KClassImpl$Data$declaredNonStaticMembers$2.remove(this.MyBillsEntityDataFactory);
            ArrayList<Transition> arrayList = TransitionManager.BuiltInFictitiousFunctionClassFactory().get(this.MyBillsEntityDataFactory);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.MyBillsEntityDataFactory);
                }
            }
            this.getAuthRequestContext.clearValues(true);
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = BuiltInFictitiousFunctionClassFactory().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().pause(viewGroup);
            }
        }
        if (transition != null) {
            transition.captureValues(viewGroup, true);
        }
        Scene authRequestContext = Scene.getAuthRequestContext(viewGroup);
        if (authRequestContext != null) {
            authRequestContext.getAuthRequestContext();
        }
    }

    public static void getAuthRequestContext(ViewGroup viewGroup, Transition transition) {
        if (KClassImpl$Data$declaredNonStaticMembers$2.contains(viewGroup) || !ViewCompat.getValueOfTouchPositionAbsolute(viewGroup)) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.add(viewGroup);
        if (transition == null) {
            transition = PlaceComponentResult;
        }
        Transition mo45clone = transition.mo45clone();
        KClassImpl$Data$declaredNonStaticMembers$2(viewGroup, mo45clone);
        Scene.MyBillsEntityDataFactory(viewGroup);
        if (mo45clone == null || viewGroup == null) {
            return;
        }
        MultiListener multiListener = new MultiListener(mo45clone, viewGroup);
        viewGroup.addOnAttachStateChangeListener(multiListener);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
    }
}
