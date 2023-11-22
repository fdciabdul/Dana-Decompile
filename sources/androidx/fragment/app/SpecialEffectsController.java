package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class SpecialEffectsController {
    private final ViewGroup KClassImpl$Data$declaredNonStaticMembers$2;
    final ArrayList<Operation> PlaceComponentResult = new ArrayList<>();
    final ArrayList<Operation> BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
    boolean getAuthRequestContext = false;
    boolean MyBillsEntityDataFactory = false;

    abstract void KClassImpl$Data$declaredNonStaticMembers$2(List<Operation> list, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpecialEffectsController MyBillsEntityDataFactory(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return KClassImpl$Data$declaredNonStaticMembers$2(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpecialEffectsController KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup, SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        Object tag = viewGroup.getTag(R.id.PlaceComponentResult);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController MyBillsEntityDataFactory = specialEffectsControllerFactory.MyBillsEntityDataFactory(viewGroup);
        viewGroup.setTag(R.id.PlaceComponentResult, MyBillsEntityDataFactory);
        return MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpecialEffectsController(ViewGroup viewGroup) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewGroup;
    }

    public final ViewGroup KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Operation getAuthRequestContext(Fragment fragment) {
        Iterator<Operation> it = this.PlaceComponentResult.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.MyBillsEntityDataFactory.equals(fragment) && !next.MyBillsEntityDataFactory()) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult(Operation.State state, FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing add operation for fragment ");
            sb.append(fragmentStateManager.PlaceComponentResult);
            InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
        }
        KClassImpl$Data$declaredNonStaticMembers$2(state, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing show operation for fragment ");
            sb.append(fragmentStateManager.PlaceComponentResult);
            InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
        }
        KClassImpl$Data$declaredNonStaticMembers$2(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
            sb.append(fragmentStateManager.PlaceComponentResult);
            InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
        }
        KClassImpl$Data$declaredNonStaticMembers$2(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
            sb.append(fragmentStateManager.PlaceComponentResult);
            InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
        }
        KClassImpl$Data$declaredNonStaticMembers$2(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Operation.State state, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager) {
        synchronized (this.PlaceComponentResult) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            Operation authRequestContext = getAuthRequestContext(fragmentStateManager.PlaceComponentResult);
            if (authRequestContext != null) {
                authRequestContext.getAuthRequestContext(state, lifecycleImpact);
                return;
            }
            final FragmentStateManagerOperation fragmentStateManagerOperation = new FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager, cancellationSignal);
            this.PlaceComponentResult.add(fragmentStateManagerOperation);
            fragmentStateManagerOperation.PlaceComponentResult.add(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialEffectsController.this.PlaceComponentResult.contains(fragmentStateManagerOperation)) {
                        fragmentStateManagerOperation.BuiltInFictitiousFunctionClassFactory.applyState(fragmentStateManagerOperation.MyBillsEntityDataFactory.mView);
                    }
                }
            });
            fragmentStateManagerOperation.PlaceComponentResult.add(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.2
                @Override // java.lang.Runnable
                public void run() {
                    SpecialEffectsController.this.PlaceComponentResult.remove(fragmentStateManagerOperation);
                    SpecialEffectsController.this.BuiltInFictitiousFunctionClassFactory.remove(fragmentStateManagerOperation);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
    
        r6.MyBillsEntityDataFactory = r2.MyBillsEntityDataFactory.isPostponed();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory() {
        /*
            r6 = this;
            java.util.ArrayList<androidx.fragment.app.SpecialEffectsController$Operation> r0 = r6.PlaceComponentResult
            monitor-enter(r0)
            r6.PlaceComponentResult()     // Catch: java.lang.Throwable -> L3b
            r1 = 0
            r6.MyBillsEntityDataFactory = r1     // Catch: java.lang.Throwable -> L3b
            java.util.ArrayList<androidx.fragment.app.SpecialEffectsController$Operation> r1 = r6.PlaceComponentResult     // Catch: java.lang.Throwable -> L3b
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L3b
            int r1 = r1 + (-1)
        L11:
            if (r1 < 0) goto L39
            java.util.ArrayList<androidx.fragment.app.SpecialEffectsController$Operation> r2 = r6.PlaceComponentResult     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r2 = r2.get(r1)     // Catch: java.lang.Throwable -> L3b
            androidx.fragment.app.SpecialEffectsController$Operation r2 = (androidx.fragment.app.SpecialEffectsController.Operation) r2     // Catch: java.lang.Throwable -> L3b
            androidx.fragment.app.Fragment r3 = r2.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L3b
            android.view.View r3 = r3.mView     // Catch: java.lang.Throwable -> L3b
            androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.from(r3)     // Catch: java.lang.Throwable -> L3b
            androidx.fragment.app.SpecialEffectsController$Operation$State r4 = r2.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L3b
            androidx.fragment.app.SpecialEffectsController$Operation$State r5 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch: java.lang.Throwable -> L3b
            if (r4 != r5) goto L36
            androidx.fragment.app.SpecialEffectsController$Operation$State r4 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch: java.lang.Throwable -> L3b
            if (r3 == r4) goto L36
            androidx.fragment.app.Fragment r1 = r2.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L3b
            boolean r1 = r1.isPostponed()     // Catch: java.lang.Throwable -> L3b
            r6.MyBillsEntityDataFactory = r1     // Catch: java.lang.Throwable -> L3b
            goto L39
        L36:
            int r1 = r1 + (-1)
            goto L11
        L39:
            monitor-exit(r0)
            return
        L3b:
            r1 = move-exception
            monitor-exit(r0)
            goto L3f
        L3e:
            throw r1
        L3f:
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.BuiltInFictitiousFunctionClassFactory():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory() {
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        if (!ViewCompat.C(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            getAuthRequestContext();
            this.getAuthRequestContext = false;
            return;
        }
        synchronized (this.PlaceComponentResult) {
            if (!this.PlaceComponentResult.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.BuiltInFictitiousFunctionClassFactory);
                this.BuiltInFictitiousFunctionClassFactory.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Operation operation = (Operation) it.next();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: Cancelling operation ");
                        sb.append(operation);
                        InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
                    }
                    operation.PlaceComponentResult();
                    if (!operation.BuiltInFictitiousFunctionClassFactory()) {
                        this.BuiltInFictitiousFunctionClassFactory.add(operation);
                    }
                }
                PlaceComponentResult();
                ArrayList arrayList2 = new ArrayList(this.PlaceComponentResult);
                this.PlaceComponentResult.clear();
                this.BuiltInFictitiousFunctionClassFactory.addAll(arrayList2);
                if (FragmentManager.isLoggingEnabled(2)) {
                    InstrumentInjector.log_v(FragmentManager.TAG, "SpecialEffectsController: Executing pending operations");
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((Operation) it2.next()).getAuthRequestContext();
                }
                KClassImpl$Data$declaredNonStaticMembers$2(arrayList2, this.getAuthRequestContext);
                this.getAuthRequestContext = false;
                if (FragmentManager.isLoggingEnabled(2)) {
                    InstrumentInjector.log_v(FragmentManager.TAG, "SpecialEffectsController: Finished executing pending operations");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext() {
        String obj;
        String obj2;
        if (FragmentManager.isLoggingEnabled(2)) {
            InstrumentInjector.log_v(FragmentManager.TAG, "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean C = ViewCompat.C(this.KClassImpl$Data$declaredNonStaticMembers$2);
        synchronized (this.PlaceComponentResult) {
            PlaceComponentResult();
            Iterator<Operation> it = this.PlaceComponentResult.iterator();
            while (it.hasNext()) {
                it.next().getAuthRequestContext();
            }
            Iterator it2 = new ArrayList(this.BuiltInFictitiousFunctionClassFactory).iterator();
            while (it2.hasNext()) {
                Operation operation = (Operation) it2.next();
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (C) {
                        obj2 = "";
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Container ");
                        sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                        sb2.append(" is not attached to window. ");
                        obj2 = sb2.toString();
                    }
                    sb.append(obj2);
                    sb.append("Cancelling running operation ");
                    sb.append(operation);
                    InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
                }
                operation.PlaceComponentResult();
            }
            Iterator it3 = new ArrayList(this.PlaceComponentResult).iterator();
            while (it3.hasNext()) {
                Operation operation2 = (Operation) it3.next();
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: ");
                    if (C) {
                        obj = "";
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Container ");
                        sb4.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                        sb4.append(" is not attached to window. ");
                        obj = sb4.toString();
                    }
                    sb3.append(obj);
                    sb3.append("Cancelling pending operation ");
                    sb3.append(operation2);
                    InstrumentInjector.log_v(FragmentManager.TAG, sb3.toString());
                }
                operation2.PlaceComponentResult();
            }
        }
    }

    private void PlaceComponentResult() {
        Iterator<Operation> it = this.PlaceComponentResult.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.getAuthRequestContext == Operation.LifecycleImpact.ADDING) {
                next.getAuthRequestContext(Operation.State.from(next.MyBillsEntityDataFactory.requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Operation {
        State BuiltInFictitiousFunctionClassFactory;
        final Fragment MyBillsEntityDataFactory;
        LifecycleImpact getAuthRequestContext;
        public static final byte[] moveToNextValue = {4, -41, 37, 5, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        public static final int lookAheadTest = 29;
        final List<Runnable> PlaceComponentResult = new ArrayList();
        final HashSet<CancellationSignal> KClassImpl$Data$declaredNonStaticMembers$2 = new HashSet<>();
        private boolean scheduleImpl = false;
        private boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0035). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r6, short r7, int r8, java.lang.Object[] r9) {
            /*
                int r8 = 106 - r8
                int r7 = r7 * 3
                int r7 = 16 - r7
                byte[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.moveToNextValue
                int r6 = r6 + 4
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L19
                r8 = r7
                r3 = r1
                r4 = 0
                r7 = r6
                r1 = r0
                r0 = r9
                r9 = r8
                goto L35
            L19:
                r3 = 0
            L1a:
                byte r4 = (byte) r8
                r1[r3] = r4
                if (r3 != r7) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L27:
                int r6 = r6 + 1
                int r3 = r3 + 1
                r4 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L35:
                int r6 = -r6
                int r8 = r8 + r6
                int r8 = r8 + 2
                r6 = r7
                r7 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.Operation.a(byte, short, int, java.lang.Object[]):void");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void getAuthRequestContext() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            /* JADX INFO: Access modifiers changed from: package-private */
            public static State from(View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return from(view.getVisibility());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static State from(int i) {
                if (i != 0) {
                    if (i != 4) {
                        if (i == 8) {
                            return GONE;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unknown visibility ");
                        sb.append(i);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    return INVISIBLE;
                }
                return VISIBLE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public final void applyState(View view) {
                int i = AnonymousClass3.MyBillsEntityDataFactory[ordinal()];
                if (i == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("SpecialEffectsController: Removing view ");
                            sb.append(view);
                            sb.append(" from container ");
                            sb.append(viewGroup);
                            InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
                        }
                        viewGroup.removeView(view);
                    }
                } else if (i == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: Setting view ");
                        sb2.append(view);
                        sb2.append(" to VISIBLE");
                        InstrumentInjector.log_v(FragmentManager.TAG, sb2.toString());
                    }
                    view.setVisibility(0);
                } else if (i == 3) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: Setting view ");
                        sb3.append(view);
                        sb3.append(" to GONE");
                        InstrumentInjector.log_v(FragmentManager.TAG, sb3.toString());
                    }
                    view.setVisibility(8);
                } else if (i == 4) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("SpecialEffectsController: Setting view ");
                        sb4.append(view);
                        sb4.append(" to INVISIBLE");
                        InstrumentInjector.log_v(FragmentManager.TAG, sb4.toString());
                    }
                    view.setVisibility(4);
                }
            }
        }

        Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, CancellationSignal cancellationSignal) {
            this.BuiltInFictitiousFunctionClassFactory = state;
            this.getAuthRequestContext = lifecycleImpact;
            this.MyBillsEntityDataFactory = fragment;
            cancellationSignal.MyBillsEntityDataFactory(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.SpecialEffectsController.Operation.1
                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                public void MyBillsEntityDataFactory() {
                    Operation.this.PlaceComponentResult();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean MyBillsEntityDataFactory() {
            return this.scheduleImpl;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Operation ");
            sb.append("{");
            try {
                Object[] objArr = {this};
                byte b = (byte) (lookAheadTest >>> 1);
                byte b2 = (byte) (moveToNextValue[5] - 1);
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (-moveToNextValue[5]);
                Object[] objArr3 = new Object[1];
                a(b3, (byte) (b3 + 1), moveToNextValue[5], objArr3);
                sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
                sb.append("} ");
                sb.append("{");
                sb.append("mFinalState = ");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                sb.append("} ");
                sb.append("{");
                sb.append("mLifecycleImpact = ");
                sb.append(this.getAuthRequestContext);
                sb.append("} ");
                sb.append("{");
                sb.append("mFragment = ");
                sb.append(this.MyBillsEntityDataFactory);
                sb.append("}");
                return sb.toString();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        final void PlaceComponentResult() {
            if (MyBillsEntityDataFactory()) {
                return;
            }
            this.scheduleImpl = true;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
                KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            }
            Iterator it = new ArrayList(this.KClassImpl$Data$declaredNonStaticMembers$2).iterator();
            while (it.hasNext()) {
                ((CancellationSignal) it.next()).PlaceComponentResult();
            }
        }

        final void getAuthRequestContext(State state, LifecycleImpact lifecycleImpact) {
            int i = AnonymousClass3.KClassImpl$Data$declaredNonStaticMembers$2[lifecycleImpact.ordinal()];
            if (i == 1) {
                if (this.BuiltInFictitiousFunctionClassFactory == State.REMOVED) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: For fragment ");
                        sb.append(this.MyBillsEntityDataFactory);
                        sb.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                        sb.append(this.getAuthRequestContext);
                        sb.append(" to ADDING.");
                        InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
                    }
                    this.BuiltInFictitiousFunctionClassFactory = State.VISIBLE;
                    this.getAuthRequestContext = LifecycleImpact.ADDING;
                }
            } else if (i == 2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: For fragment ");
                    sb2.append(this.MyBillsEntityDataFactory);
                    sb2.append(" mFinalState = ");
                    sb2.append(this.BuiltInFictitiousFunctionClassFactory);
                    sb2.append(" -> REMOVED. mLifecycleImpact  = ");
                    sb2.append(this.getAuthRequestContext);
                    sb2.append(" to REMOVING.");
                    InstrumentInjector.log_v(FragmentManager.TAG, sb2.toString());
                }
                this.BuiltInFictitiousFunctionClassFactory = State.REMOVED;
                this.getAuthRequestContext = LifecycleImpact.REMOVING;
            } else if (i != 3 || this.BuiltInFictitiousFunctionClassFactory == State.REMOVED) {
            } else {
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: For fragment ");
                    sb3.append(this.MyBillsEntityDataFactory);
                    sb3.append(" mFinalState = ");
                    sb3.append(this.BuiltInFictitiousFunctionClassFactory);
                    sb3.append(" -> ");
                    sb3.append(state);
                    sb3.append(". ");
                    InstrumentInjector.log_v(FragmentManager.TAG, sb3.toString());
                }
                this.BuiltInFictitiousFunctionClassFactory = state;
            }
        }

        final boolean BuiltInFictitiousFunctionClassFactory() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2() {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("SpecialEffectsController: ");
                sb.append(this);
                sb.append(" has called complete.");
                InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            Iterator<Runnable> it = this.PlaceComponentResult.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.fragment.app.SpecialEffectsController$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[Operation.LifecycleImpact.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Operation.LifecycleImpact.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Operation.LifecycleImpact.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Operation.State.values().length];
            MyBillsEntityDataFactory = iArr2;
            try {
                iArr2[Operation.State.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MyBillsEntityDataFactory[Operation.State.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                MyBillsEntityDataFactory[Operation.State.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                MyBillsEntityDataFactory[Operation.State.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class FragmentStateManagerOperation extends Operation {
        private final FragmentStateManager NetworkUserEntityData$$ExternalSyntheticLambda0;

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            super.KClassImpl$Data$declaredNonStaticMembers$2();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult();
        }

        FragmentStateManagerOperation(Operation.State state, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager, CancellationSignal cancellationSignal) {
            super(state, lifecycleImpact, fragmentStateManager.PlaceComponentResult, cancellationSignal);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = fragmentStateManager;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        final void getAuthRequestContext() {
            if (this.getAuthRequestContext != Operation.LifecycleImpact.ADDING) {
                if (this.getAuthRequestContext == Operation.LifecycleImpact.REMOVING) {
                    Fragment fragment = this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
                    View requireView = fragment.requireView();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Clearing focus ");
                        sb.append(requireView.findFocus());
                        sb.append(" on view ");
                        sb.append(requireView);
                        sb.append(" for Fragment ");
                        sb.append(fragment);
                        InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
                    }
                    requireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragment2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
            View findFocus = fragment2.mView.findFocus();
            if (findFocus != null) {
                fragment2.setFocusedView(findFocus);
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("requestFocus: Saved focused view ");
                    sb2.append(findFocus);
                    sb2.append(" for Fragment ");
                    sb2.append(fragment2);
                    InstrumentInjector.log_v(FragmentManager.TAG, sb2.toString());
                }
            }
            View requireView2 = this.MyBillsEntityDataFactory.requireView();
            if (requireView2.getParent() == null) {
                FragmentStateManager fragmentStateManager = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                fragmentStateManager.PlaceComponentResult.mContainer.addView(fragmentStateManager.PlaceComponentResult.mView, fragmentStateManager.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(fragmentStateManager.PlaceComponentResult));
                requireView2.setAlpha(0.0f);
            }
            if (requireView2.getAlpha() == 0.0f && requireView2.getVisibility() == 0) {
                requireView2.setVisibility(4);
            }
            requireView2.setAlpha(fragment2.getPostOnViewCreatedAlpha());
        }
    }
}
