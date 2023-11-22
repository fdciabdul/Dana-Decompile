package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean BuiltInFictitiousFunctionClassFactory(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object getAuthRequestContext(Object obj) {
        if (obj != null) {
            return ((Transition) obj).mo45clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object MyBillsEntityDataFactory(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.getAuthRequestContext((Transition) obj);
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void PlaceComponentResult(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            BuiltInFictitiousFunctionClassFactory(targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        getAuthRequestContext(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void KClassImpl$Data$declaredNonStaticMembers$2(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            BuiltInFictitiousFunctionClassFactory(view, rect);
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.transition.FragmentTransitionSupport.1
                @Override // androidx.transition.Transition.EpicenterCallback
                public final Rect getAuthRequestContext() {
                    return rect;
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void getAuthRequestContext(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int size = transitionSet.getAuthRequestContext.size();
            while (i < size) {
                getAuthRequestContext((i < 0 || i >= transitionSet.getAuthRequestContext.size()) ? null : transitionSet.getAuthRequestContext.get(i), arrayList);
                i++;
            }
        } else if (PlaceComponentResult(transition) || !PlaceComponentResult(transition.getTargets())) {
        } else {
            int size2 = arrayList.size();
            while (i < size2) {
                transition.addTarget(arrayList.get(i));
                i++;
            }
        }
    }

    private static boolean PlaceComponentResult(Transition transition) {
        return (PlaceComponentResult(transition.getTargetIds()) && PlaceComponentResult(transition.getTargetNames()) && PlaceComponentResult(transition.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object getAuthRequestContext(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.getAuthRequestContext((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.getAuthRequestContext((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.getAuthRequestContext((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void MyBillsEntityDataFactory(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new Transition.TransitionListener() { // from class: androidx.transition.FragmentTransitionSupport.2
            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                transition.removeListener(this);
                transition.addListener(this);
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object MyBillsEntityDataFactory(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().getAuthRequestContext(transition).getAuthRequestContext(transition2).PlaceComponentResult(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 != null) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.getAuthRequestContext(transition);
            }
            transitionSet.getAuthRequestContext(transition3);
            return transitionSet;
        }
        return transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void BuiltInFictitiousFunctionClassFactory(ViewGroup viewGroup, Object obj) {
        TransitionManager.getAuthRequestContext(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void getAuthRequestContext(Object obj, final Object obj2, final ArrayList<View> arrayList, final Object obj3, final ArrayList<View> arrayList2, final Object obj4, final ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new TransitionListenerAdapter() { // from class: androidx.transition.FragmentTransitionSupport.3
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                Object obj5 = obj2;
                if (obj5 != null) {
                    FragmentTransitionSupport.this.MyBillsEntityDataFactory(obj5, arrayList, (ArrayList<View>) null);
                }
                Object obj6 = obj3;
                if (obj6 != null) {
                    FragmentTransitionSupport.this.MyBillsEntityDataFactory(obj6, arrayList2, (ArrayList<View>) null);
                }
                Object obj7 = obj4;
                if (obj7 != null) {
                    FragmentTransitionSupport.this.MyBillsEntityDataFactory(obj7, arrayList3, (ArrayList<View>) null);
                }
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void MyBillsEntityDataFactory(Fragment fragment, Object obj, CancellationSignal cancellationSignal, final Runnable runnable) {
        final Transition transition = (Transition) obj;
        cancellationSignal.MyBillsEntityDataFactory(new CancellationSignal.OnCancelListener() { // from class: androidx.transition.FragmentTransitionSupport.4
            @Override // androidx.core.os.CancellationSignal.OnCancelListener
            public void MyBillsEntityDataFactory() {
                transition.cancel();
            }
        });
        transition.addListener(new Transition.TransitionListener() { // from class: androidx.transition.FragmentTransitionSupport.5
            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                runnable.run();
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void PlaceComponentResult(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            MyBillsEntityDataFactory((Object) transitionSet, arrayList, arrayList2);
        }
    }

    public final void MyBillsEntityDataFactory(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int size = transitionSet.getAuthRequestContext.size();
            while (i < size) {
                MyBillsEntityDataFactory((Object) ((i < 0 || i >= transitionSet.getAuthRequestContext.size()) ? null : transitionSet.getAuthRequestContext.get(i)), arrayList, arrayList2);
                i++;
            }
        } else if (!PlaceComponentResult(transition)) {
            List<View> targets = transition.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                int size2 = arrayList2 == null ? 0 : arrayList2.size();
                while (i < size2) {
                    transition.addTarget(arrayList2.get(i));
                    i++;
                }
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    transition.removeTarget(arrayList.get(size3));
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void BuiltInFictitiousFunctionClassFactory(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void PlaceComponentResult(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.transition.FragmentTransitionSupport.6
                @Override // androidx.transition.Transition.EpicenterCallback
                public final Rect getAuthRequestContext() {
                    Rect rect2 = rect;
                    if (rect2 == null || rect2.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}
