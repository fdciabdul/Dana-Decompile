package androidx.fragment.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DefaultSpecialEffectsController extends SpecialEffectsController {
    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:683:0x07c3  */
    /* JADX WARN: Removed duplicated region for block: B:726:0x08da  */
    /* JADX WARN: Removed duplicated region for block: B:760:0x09f7 A[LOOP:7: B:758:0x09f1->B:760:0x09f7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:763:0x0a11  */
    /* JADX WARN: Removed duplicated region for block: B:869:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r40v0, types: [androidx.fragment.app.DefaultSpecialEffectsController] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.util.Map] */
    @Override // androidx.fragment.app.SpecialEffectsController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void KClassImpl$Data$declaredNonStaticMembers$2(java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> r41, final boolean r42) {
        /*
            Method dump skipped, instructions count: 2610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.KClassImpl$Data$declaredNonStaticMembers$2(java.util.List, boolean):void");
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10 */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static void PlaceComponentResult(ArrayMap<String, View> arrayMap, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getCallingPid(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    private void PlaceComponentResult(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (ViewGroupCompat.KClassImpl$Data$declaredNonStaticMembers$2(viewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    PlaceComponentResult(arrayList, childAt);
                }
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    private void MyBillsEntityDataFactory(Map<String, View> map, View view) {
        String callingPid = ViewCompat.getCallingPid(view);
        if (callingPid != null) {
            map.put(callingPid, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    MyBillsEntityDataFactory(map, childAt);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SpecialEffectsInfo {
        final SpecialEffectsController.Operation KClassImpl$Data$declaredNonStaticMembers$2;
        final CancellationSignal PlaceComponentResult;

        SpecialEffectsInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = operation;
            this.PlaceComponentResult = cancellationSignal;
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.mView);
            SpecialEffectsController.Operation.State state = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
            return from == state || !(from == SpecialEffectsController.Operation.State.VISIBLE || state == SpecialEffectsController.Operation.State.VISIBLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnimationInfo extends SpecialEffectsInfo {
        private boolean BuiltInFictitiousFunctionClassFactory;
        private boolean MyBillsEntityDataFactory;
        private FragmentAnim.AnimationOrAnimator getAuthRequestContext;

        AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.MyBillsEntityDataFactory = false;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        final FragmentAnim.AnimationOrAnimator getAuthRequestContext(Context context) {
            if (this.MyBillsEntityDataFactory) {
                return this.getAuthRequestContext;
            }
            FragmentAnim.AnimationOrAnimator BuiltInFictitiousFunctionClassFactory = FragmentAnim.BuiltInFictitiousFunctionClassFactory(context, this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory == SpecialEffectsController.Operation.State.VISIBLE, this.BuiltInFictitiousFunctionClassFactory);
            this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
            this.MyBillsEntityDataFactory = true;
            return BuiltInFictitiousFunctionClassFactory;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TransitionInfo extends SpecialEffectsInfo {
        final Object BuiltInFictitiousFunctionClassFactory;
        final Object MyBillsEntityDataFactory;
        private final boolean getAuthRequestContext;

        TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            Object exitTransition;
            Object enterTransition;
            boolean allowEnterTransitionOverlap;
            if (operation.BuiltInFictitiousFunctionClassFactory == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z) {
                    enterTransition = operation.MyBillsEntityDataFactory.getReenterTransition();
                } else {
                    enterTransition = operation.MyBillsEntityDataFactory.getEnterTransition();
                }
                this.BuiltInFictitiousFunctionClassFactory = enterTransition;
                if (z) {
                    allowEnterTransitionOverlap = operation.MyBillsEntityDataFactory.getAllowReturnTransitionOverlap();
                } else {
                    allowEnterTransitionOverlap = operation.MyBillsEntityDataFactory.getAllowEnterTransitionOverlap();
                }
                this.getAuthRequestContext = allowEnterTransitionOverlap;
            } else {
                if (z) {
                    exitTransition = operation.MyBillsEntityDataFactory.getReturnTransition();
                } else {
                    exitTransition = operation.MyBillsEntityDataFactory.getExitTransition();
                }
                this.BuiltInFictitiousFunctionClassFactory = exitTransition;
                this.getAuthRequestContext = true;
            }
            if (!z2) {
                this.MyBillsEntityDataFactory = null;
            } else if (z) {
                this.MyBillsEntityDataFactory = operation.MyBillsEntityDataFactory.getSharedElementReturnTransition();
            } else {
                this.MyBillsEntityDataFactory = operation.MyBillsEntityDataFactory.getSharedElementEnterTransition();
            }
        }

        final boolean PlaceComponentResult() {
            return this.getAuthRequestContext;
        }

        public final boolean getAuthRequestContext() {
            return this.MyBillsEntityDataFactory != null;
        }

        final FragmentTransitionImpl KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
            if (obj == null) {
                return null;
            }
            if (FragmentTransition.getAuthRequestContext != null && FragmentTransition.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(obj)) {
                return FragmentTransition.getAuthRequestContext;
            }
            if (FragmentTransition.BuiltInFictitiousFunctionClassFactory != null && FragmentTransition.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(obj)) {
                return FragmentTransition.BuiltInFictitiousFunctionClassFactory;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Transition ");
            sb.append(obj);
            sb.append(" for fragment ");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
            sb.append(" is not a valid framework Transition or AndroidX Transition");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    static void PlaceComponentResult(SpecialEffectsController.Operation operation) {
        operation.BuiltInFictitiousFunctionClassFactory.applyState(operation.MyBillsEntityDataFactory.mView);
    }
}
