package com.zhuinden.simplestack;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import com.zhuinden.simplestack.GlobalServices;
import com.zhuinden.simplestack.History;
import com.zhuinden.simplestack.ScopeKey;
import com.zhuinden.simplestack.StateChanger;
import com.zhuinden.statebundle.StateBundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class Backstack implements Bundleable {
    private static final String HISTORY_TAG = "HISTORY";
    private static final String RETAINED_OBJECT_STATES_TAG = "RETAINED_OBJECT_STATES_TAG";
    private static final String SCOPES_TAG = "SCOPES";
    private static final String STATES_TAG = "STATES";
    NavigationCore core;
    private boolean didRunInitialStateChange;
    private boolean isStateChangerAttached;
    private KeyFilter keyFilter;
    private KeyParceler keyParceler;
    Map<Object, SavedState> keyStateMap;
    private final StateChanger managedStateChanger;
    private final CompletionListener managedStateChangerCompletionListener;
    private final StateBundle pendingRestoredRetainedObjectStates;
    private Object previousTopKeyWithAssociatedScope;
    private final Map<String, Object> retainedObjects;
    ScopeManager scopeManager;
    StateChanger stateChanger;
    private StateClearStrategy stateClearStrategy;
    private final long threadId;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {116, -27, -60, 115, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int MyBillsEntityDataFactory = 239;

    /* loaded from: classes2.dex */
    public interface CompletionListener {
        void stateChangeCompleted(@Nonnull StateChange stateChange);
    }

    /* loaded from: classes2.dex */
    public interface StateClearStrategy {
        void clearStatesNotIn(@Nonnull Map<Object, SavedState> map, @Nonnull StateChange stateChange);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 7
            int r7 = 106 - r7
            int r8 = r8 * 12
            int r8 = r8 + 4
            int r6 = r6 * 3
            int r6 = r6 + 13
            byte[] r0 = com.zhuinden.simplestack.Backstack.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r8 = r8 + r7
            int r7 = r9 + 1
            int r8 = r8 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zhuinden.simplestack.Backstack.a(byte, short, short, java.lang.Object[]):void");
    }

    static String getHistoryTag() {
        return HISTORY_TAG;
    }

    static String getRetainedObjectStatesTag() {
        return RETAINED_OBJECT_STATES_TAG;
    }

    static String getScopesTag() {
        return SCOPES_TAG;
    }

    static String getStatesTag() {
        return STATES_TAG;
    }

    public Backstack() {
        try {
            byte b = BuiltInFictitiousFunctionClassFactory[15];
            Object[] objArr = new Object[1];
            a(b, (byte) (b - 1), BuiltInFictitiousFunctionClassFactory[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
            byte b3 = BuiltInFictitiousFunctionClassFactory[15];
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            this.threadId = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId();
            this.previousTopKeyWithAssociatedScope = null;
            this.managedStateChanger = new StateChanger() { // from class: com.zhuinden.simplestack.Backstack.1
                @Override // com.zhuinden.simplestack.StateChanger
                public void handleStateChange(@Nonnull StateChange stateChange, @Nonnull StateChanger.Callback callback) {
                    Backstack.this.scopeManager.buildScopes(stateChange.getNewKeys());
                    Backstack.this.stateChanger.handleStateChange(stateChange, callback);
                }
            };
            this.managedStateChangerCompletionListener = new CompletionListener() { // from class: com.zhuinden.simplestack.Backstack.2
                @Override // com.zhuinden.simplestack.Backstack.CompletionListener
                public void stateChangeCompleted(@Nonnull StateChange stateChange) {
                    Object obj;
                    if (Backstack.this.isStateChangePending()) {
                        return;
                    }
                    if (Backstack.this.isStateChangerAttached) {
                        Backstack.this.core.removeStateChanger();
                    }
                    Backstack.this.stateClearStrategy.clearStatesNotIn(Backstack.this.keyStateMap, stateChange);
                    History newKeys = stateChange.getNewKeys();
                    int i = 0;
                    int size = newKeys.size();
                    while (true) {
                        obj = null;
                        if (i >= size) {
                            break;
                        }
                        obj = newKeys.fromTop(i);
                        if ((obj instanceof ScopeKey) || (obj instanceof ScopeKey.Child)) {
                            break;
                        }
                        i++;
                    }
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    if (Backstack.this.previousTopKeyWithAssociatedScope != null) {
                        if (Backstack.this.previousTopKeyWithAssociatedScope instanceof ScopeKey) {
                            linkedHashSet.add(((ScopeKey) Backstack.this.previousTopKeyWithAssociatedScope).getScopeTag());
                        }
                        if (Backstack.this.previousTopKeyWithAssociatedScope instanceof ScopeKey.Child) {
                            ScopeKey.Child child = (ScopeKey.Child) Backstack.this.previousTopKeyWithAssociatedScope;
                            ScopeManager.checkParentScopes(child);
                            List<String> parentScopes = child.getParentScopes();
                            for (int size2 = parentScopes.size() - 1; size2 >= 0; size2--) {
                                linkedHashSet.add(parentScopes.get(size2));
                            }
                        }
                    }
                    if (obj != null) {
                        if (obj instanceof ScopeKey.Child) {
                            ScopeKey.Child child2 = (ScopeKey.Child) obj;
                            ScopeManager.checkParentScopes(child2);
                            linkedHashSet2.addAll(child2.getParentScopes());
                        }
                        if (obj instanceof ScopeKey) {
                            linkedHashSet2.add(((ScopeKey) obj).getScopeTag());
                        }
                    }
                    Backstack.this.previousTopKeyWithAssociatedScope = obj;
                    Iterator it = linkedHashSet2.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (linkedHashSet.contains(str)) {
                            linkedHashSet.remove(str);
                            it.remove();
                        }
                    }
                    if (!linkedHashSet2.isEmpty() || !linkedHashSet.isEmpty()) {
                        Backstack.this.scopeManager.dispatchActivation(linkedHashSet, linkedHashSet2);
                    }
                    Backstack.this.scopeManager.cleanupScopesBy(newKeys);
                    if (Backstack.this.isStateChangerAttached) {
                        Backstack.this.core.setStateChanger(Backstack.this.managedStateChanger, 1);
                    }
                }
            };
            this.keyFilter = new DefaultKeyFilter();
            this.keyParceler = new DefaultKeyParceler();
            this.stateClearStrategy = new DefaultStateClearStrategy();
            this.keyStateMap = new HashMap();
            ScopeManager scopeManager = new ScopeManager();
            this.scopeManager = scopeManager;
            scopeManager.setBackstack(this);
            this.isStateChangerAttached = false;
            this.didRunInitialStateChange = false;
            this.retainedObjects = new LinkedHashMap();
            this.pendingRestoredRetainedObjectStates = new StateBundle();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Nonnull
    public static <K> K getKey(@Nonnull Context context) {
        return (K) KeyContextWrapper.getKey(context);
    }

    public void setKeyFilter(@Nonnull KeyFilter keyFilter) {
        if (this.core != null) {
            throw new IllegalStateException("Custom key filter should be set before calling `setup()`");
        }
        if (keyFilter == null) {
            throw new IllegalArgumentException("The key filter cannot be null!");
        }
        this.keyFilter = keyFilter;
    }

    public void setKeyParceler(@Nonnull KeyParceler keyParceler) {
        if (this.core != null) {
            throw new IllegalStateException("Custom key parceler should be set before calling `setup()`");
        }
        if (keyParceler == null) {
            throw new IllegalArgumentException("The key parceler cannot be null!");
        }
        this.keyParceler = keyParceler;
    }

    public void setStateClearStrategy(@Nonnull StateClearStrategy stateClearStrategy) {
        if (this.core != null) {
            throw new IllegalStateException("Custom state clear strategy should be set before calling `setup()`");
        }
        if (stateClearStrategy == null) {
            throw new IllegalArgumentException("The state clear strategy cannot be null!");
        }
        this.stateClearStrategy = stateClearStrategy;
    }

    public final boolean canSetScopeProviders() {
        return !this.didRunInitialStateChange;
    }

    public void setScopedServices(@Nonnull ScopedServices scopedServices) {
        if (!canSetScopeProviders()) {
            throw new IllegalStateException("Scope provider should be set before the initial state change!");
        }
        if (scopedServices == null) {
            throw new IllegalArgumentException("The scope provider cannot be null!");
        }
        this.scopeManager.setScopedServices(scopedServices);
    }

    public void setGlobalServices(@Nonnull GlobalServices globalServices) {
        if (!canSetScopeProviders()) {
            throw new IllegalStateException("Scope provider should be set before the initial state change!");
        }
        if (globalServices == null) {
            throw new IllegalArgumentException("The global services cannot be null!");
        }
        this.scopeManager.setGlobalServices(globalServices);
    }

    public void setGlobalServices(@Nonnull GlobalServices.Factory factory) {
        if (!canSetScopeProviders()) {
            throw new IllegalStateException("Scope provider should be set before the initial state change!");
        }
        if (factory == null) {
            throw new IllegalArgumentException("The global service factory cannot be null!");
        }
        this.scopeManager.setGlobalServices(factory);
    }

    public void setup(@Nonnull List<?> list) {
        NavigationCore navigationCore = new NavigationCore(list);
        this.core = navigationCore;
        navigationCore.setBackstack(this);
        this.core.addCompletionListener(this.managedStateChangerCompletionListener);
    }

    public boolean isInitialized() {
        return this.core != null;
    }

    private void initializeBackstack(StateChanger stateChanger) {
        if (stateChanger != null) {
            if (!this.didRunInitialStateChange) {
                this.didRunInitialStateChange = true;
            }
            this.isStateChangerAttached = true;
            this.core.setStateChanger(this.managedStateChanger);
        }
    }

    public void setStateChanger(@Nullable StateChanger stateChanger) {
        checkBackstack("You must call `setup()` before calling `setStateChanger()`.");
        if (this.core.hasStateChanger()) {
            this.core.removeStateChanger();
        }
        this.stateChanger = stateChanger;
        initializeBackstack(stateChanger);
    }

    public void detachStateChanger() {
        checkBackstack("You must call `setup()` before calling `detachStateChanger()`.");
        if (this.core.hasStateChanger()) {
            this.core.removeStateChanger();
            this.isStateChangerAttached = false;
        }
    }

    public void reattachStateChanger() {
        checkBackstack("You must call `setup()` before calling `reattachStateChanger()`.");
        if (this.core.hasStateChanger()) {
            return;
        }
        this.isStateChangerAttached = true;
        this.core.setStateChanger(this.managedStateChanger, 1);
    }

    public void finalizeScopes() {
        if (this.scopeManager.isFinalized()) {
            return;
        }
        if (this.previousTopKeyWithAssociatedScope != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Object obj = this.previousTopKeyWithAssociatedScope;
            if (obj instanceof ScopeKey.Child) {
                ScopeKey.Child child = (ScopeKey.Child) obj;
                ScopeManager.checkParentScopes(child);
                linkedHashSet.addAll(new ArrayList(child.getParentScopes()));
            }
            Object obj2 = this.previousTopKeyWithAssociatedScope;
            if (obj2 instanceof ScopeKey) {
                linkedHashSet.add(((ScopeKey) obj2).getScopeTag());
            }
            ArrayList arrayList = new ArrayList(linkedHashSet);
            Collections.reverse(arrayList);
            this.scopeManager.dispatchActivation(new LinkedHashSet(arrayList), Collections.emptySet());
        }
        this.scopeManager.deactivateGlobalScope();
        History history = getHistory();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        int size = history.size();
        for (int i = 0; i < size; i++) {
            Object fromTop = history.fromTop(i);
            if (fromTop instanceof ScopeKey) {
                linkedHashSet2.add(((ScopeKey) fromTop).getScopeTag());
            }
            if (fromTop instanceof ScopeKey.Child) {
                ArrayList<String> arrayList2 = new ArrayList(((ScopeKey.Child) fromTop).getParentScopes());
                Collections.reverse(arrayList2);
                for (String str : arrayList2) {
                    if (linkedHashSet2.contains(str)) {
                        linkedHashSet2.remove(str);
                    }
                    linkedHashSet2.add(str);
                }
            }
        }
        Iterator it = new ArrayList(linkedHashSet2).iterator();
        while (it.hasNext()) {
            this.scopeManager.destroyScope((String) it.next());
        }
        this.scopeManager.finalizeScopes();
        this.previousTopKeyWithAssociatedScope = null;
    }

    public boolean hasService(@Nonnull ScopeKey scopeKey, @Nonnull String str) {
        return hasService(scopeKey.getScopeTag(), str);
    }

    @Nonnull
    public <T> T getService(@Nonnull ScopeKey scopeKey, @Nonnull String str) {
        return (T) getService(scopeKey.getScopeTag(), str);
    }

    public boolean hasService(@Nonnull String str, @Nonnull String str2) {
        return this.scopeManager.hasService(str, str2);
    }

    @Nonnull
    public <T> T getService(@Nonnull String str, @Nonnull String str2) {
        return (T) this.scopeManager.getService(str, str2);
    }

    public boolean hasScope(@Nonnull String str) {
        return this.scopeManager.hasScope(str);
    }

    public boolean canFindService(@Nonnull String str) {
        return this.scopeManager.canFindService(str);
    }

    public boolean canFindFromScope(@Nonnull String str, @Nonnull String str2) {
        return this.scopeManager.canFindFromScope(str, str2, ScopeLookupMode.ALL);
    }

    public boolean canFindFromScope(@Nonnull String str, @Nonnull String str2, @Nonnull ScopeLookupMode scopeLookupMode) {
        return this.scopeManager.canFindFromScope(str, str2, scopeLookupMode);
    }

    @Nonnull
    public <T> T lookupService(@Nonnull String str) {
        return (T) this.scopeManager.lookupService(str);
    }

    @Nonnull
    public List<String> findScopesForKey(@Nonnull Object obj, @Nonnull ScopeLookupMode scopeLookupMode) {
        return Collections.unmodifiableList(new ArrayList(this.scopeManager.findScopesForKey(obj, scopeLookupMode)));
    }

    @Nonnull
    public <T> T lookupFromScope(String str, String str2) {
        return (T) this.scopeManager.lookupFromScope(str, str2, ScopeLookupMode.ALL);
    }

    @Nonnull
    public <T> T lookupFromScope(String str, String str2, ScopeLookupMode scopeLookupMode) {
        return (T) this.scopeManager.lookupFromScope(str, str2, scopeLookupMode);
    }

    @Nonnull
    public SavedState getSavedState(@Nonnull Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
        if (!this.keyStateMap.containsKey(obj)) {
            this.keyStateMap.put(obj, SavedState.builder().setKey(obj).build());
        }
        return this.keyStateMap.get(obj);
    }

    public boolean hasRetainedObject(@Nonnull String str) {
        assertCorrectThread();
        return this.retainedObjects.containsKey(str);
    }

    @Nonnull
    public <T> T getRetainedObject(@Nonnull String str) {
        assertCorrectThread();
        if (!this.retainedObjects.containsKey(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Retained object with tag [");
            sb.append(str);
            sb.append("] was not found.!");
            throw new IllegalArgumentException(sb.toString());
        }
        return (T) this.retainedObjects.get(str);
    }

    public void addRetainedObject(@Nonnull String str, @Nonnull Object obj) {
        if (str == null) {
            throw new NullPointerException("objectTag cannot be null!");
        }
        if (obj == null) {
            throw new NullPointerException("retainedObject cannot be null!");
        }
        assertCorrectThread();
        if (this.retainedObjects.containsKey(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("A retained object is already added with the object tag [");
            sb.append(str);
            sb.append("]");
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.pendingRestoredRetainedObjectStates.KClassImpl$Data$declaredNonStaticMembers$2(str)) {
            if (!(obj instanceof Bundleable)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("State restoration mismatch: expected [");
                sb2.append(str);
                sb2.append("] to be restored, but was not actually Bundleable anymore.");
                throw new IllegalStateException(sb2.toString());
            }
            ((Bundleable) obj).fromBundle(this.pendingRestoredRetainedObjectStates.getAuthRequestContext(str));
            StateBundle stateBundle = this.pendingRestoredRetainedObjectStates;
            stateBundle.KClassImpl$Data$declaredNonStaticMembers$2.remove(str);
            stateBundle.MyBillsEntityDataFactory.remove(str);
        }
        this.retainedObjects.put(str, obj);
    }

    @Nullable
    public <T> T removeRetainedObject(@Nonnull String str) {
        if (str == null) {
            throw new NullPointerException("objectTag cannot be null!");
        }
        assertCorrectThread();
        StateBundle stateBundle = this.pendingRestoredRetainedObjectStates;
        stateBundle.KClassImpl$Data$declaredNonStaticMembers$2.remove(str);
        stateBundle.MyBillsEntityDataFactory.remove(str);
        return (T) this.retainedObjects.remove(str);
    }

    public void persistViewToState(@Nullable View view) {
        assertCorrectThread();
        if (view != null) {
            Object key = KeyContextWrapper.getKey(view.getContext());
            if (key == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("The view [");
                sb.append(view);
                sb.append("] contained no key in its context hierarchy. The view or its parent hierarchy should be inflated by a layout inflater from `stateChange.createContext(baseContext, key)`, or a KeyContextWrapper.");
                throw new IllegalArgumentException(sb.toString());
            }
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            view.saveHierarchyState(sparseArray);
            StateBundle bundle = view instanceof Bundleable ? ((Bundleable) view).toBundle() : null;
            SavedState savedState = getSavedState(key);
            savedState.setViewHierarchyState(sparseArray);
            savedState.setViewBundle(bundle);
        }
    }

    public void restoreViewFromState(@Nonnull View view) {
        assertCorrectThread();
        if (view == null) {
            throw new IllegalArgumentException("You cannot restore state into null view!");
        }
        SavedState savedState = getSavedState(KeyContextWrapper.getKey(view.getContext()));
        view.restoreHierarchyState(savedState.getViewHierarchyState());
        if (view instanceof Bundleable) {
            ((Bundleable) view).fromBundle(savedState.getViewBundle());
        }
    }

    public void addStateChangeCompletionListener(@Nonnull CompletionListener completionListener) {
        checkBackstack("A backstack must be set up before a state change completion listener is added to it.");
        if (completionListener == null) {
            throw new IllegalArgumentException("StateChangeCompletionListener cannot be null!");
        }
        this.core.addCompletionListener(completionListener);
    }

    public void removeStateChangeCompletionListener(@Nonnull CompletionListener completionListener) {
        checkBackstack("A backstack must be set up before a state change completion listener is removed from it.");
        if (completionListener == null) {
            throw new IllegalArgumentException("StateChangeCompletionListener cannot be null!");
        }
        this.core.removeCompletionListener(completionListener);
    }

    @Deprecated
    public void removeAllStateChangeCompletionListeners() {
        checkBackstack("A backstack must be set up before state change completion listeners are removed from it.");
        this.core.removeCompletionListeners();
        this.core.addCompletionListener(this.managedStateChangerCompletionListener);
    }

    @Override // com.zhuinden.simplestack.Bundleable
    public void fromBundle(@Nullable StateBundle stateBundle) {
        checkBackstack("A backstack must be set up before it is restored!");
        assertCorrectThread();
        if (stateBundle != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList MyBillsEntityDataFactory2 = stateBundle.MyBillsEntityDataFactory(getHistoryTag());
            if (MyBillsEntityDataFactory2 != null) {
                Iterator it = MyBillsEntityDataFactory2.iterator();
                while (it.hasNext()) {
                    arrayList.add(this.keyParceler.fromParcelable((Parcelable) it.next()));
                }
            }
            List<?> filterHistory = this.keyFilter.filterHistory(new ArrayList(arrayList));
            if (filterHistory == null) {
                filterHistory = Collections.emptyList();
            }
            if (!filterHistory.isEmpty()) {
                this.core.setInitialParameters(filterHistory);
            }
            ArrayList<ParcelledState> MyBillsEntityDataFactory3 = stateBundle.MyBillsEntityDataFactory(getStatesTag());
            if (MyBillsEntityDataFactory3 != null) {
                for (ParcelledState parcelledState : MyBillsEntityDataFactory3) {
                    Object fromParcelable = this.keyParceler.fromParcelable(parcelledState.parcelableKey);
                    if (filterHistory.contains(fromParcelable)) {
                        SavedState build = SavedState.builder().setKey(fromParcelable).setViewHierarchyState(parcelledState.viewHierarchyState).setBundle(parcelledState.bundle).setViewBundle(parcelledState.viewBundle).build();
                        this.keyStateMap.put(build.getKey(), build);
                    }
                }
            }
            this.scopeManager.setRestoredStates(stateBundle.getAuthRequestContext(SCOPES_TAG));
            StateBundle authRequestContext = stateBundle.getAuthRequestContext(RETAINED_OBJECT_STATES_TAG);
            if (authRequestContext != null) {
                this.pendingRestoredRetainedObjectStates.BuiltInFictitiousFunctionClassFactory(authRequestContext);
                for (Map.Entry<String, Object> entry : this.retainedObjects.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (this.pendingRestoredRetainedObjectStates.KClassImpl$Data$declaredNonStaticMembers$2(key)) {
                        if (!(value instanceof Bundleable)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("State restoration mismatch: expected [");
                            sb.append(key);
                            sb.append("] to be restored, but was not actually Bundleable anymore.");
                            throw new IllegalStateException(sb.toString());
                        }
                        ((Bundleable) value).fromBundle(this.pendingRestoredRetainedObjectStates.getAuthRequestContext(key));
                        StateBundle stateBundle2 = this.pendingRestoredRetainedObjectStates;
                        stateBundle2.KClassImpl$Data$declaredNonStaticMembers$2.remove(key);
                        stateBundle2.MyBillsEntityDataFactory.remove(key);
                    }
                }
            }
        }
    }

    private void assertCorrectThread() {
        try {
            byte b = BuiltInFictitiousFunctionClassFactory[15];
            Object[] objArr = new Object[1];
            a(b, (byte) (b - 1), BuiltInFictitiousFunctionClassFactory[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
            byte b3 = BuiltInFictitiousFunctionClassFactory[15];
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            if (((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId() != this.threadId) {
                throw new IllegalStateException("The backstack is not thread-safe, and must be manipulated only from the thread where it was originally created.");
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private void checkBackstack(String str) {
        if (this.core == null) {
            throw new IllegalStateException(str);
        }
    }

    @Override // com.zhuinden.simplestack.Bundleable
    @Nonnull
    public StateBundle toBundle() {
        assertCorrectThread();
        StateBundle stateBundle = new StateBundle();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = getHistory().iterator();
        while (it.hasNext()) {
            arrayList.add(this.keyParceler.toParcelable(it.next()));
        }
        String historyTag = getHistoryTag();
        stateBundle.KClassImpl$Data$declaredNonStaticMembers$2.put(historyTag, arrayList);
        stateBundle.MyBillsEntityDataFactory.put(historyTag, 29);
        ArrayList arrayList2 = new ArrayList();
        for (SavedState savedState : this.keyStateMap.values()) {
            ParcelledState parcelledState = new ParcelledState();
            parcelledState.parcelableKey = this.keyParceler.toParcelable(savedState.getKey());
            parcelledState.viewHierarchyState = savedState.getViewHierarchyState();
            parcelledState.bundle = savedState.getBundle();
            parcelledState.viewBundle = savedState.getViewBundle();
            arrayList2.add(parcelledState);
        }
        String statesTag = getStatesTag();
        stateBundle.KClassImpl$Data$declaredNonStaticMembers$2.put(statesTag, arrayList2);
        stateBundle.MyBillsEntityDataFactory.put(statesTag, 29);
        String scopesTag = getScopesTag();
        stateBundle.KClassImpl$Data$declaredNonStaticMembers$2.put(scopesTag, this.scopeManager.saveStates());
        stateBundle.MyBillsEntityDataFactory.put(scopesTag, 27);
        StateBundle stateBundle2 = new StateBundle();
        for (Map.Entry<String, Object> entry : this.retainedObjects.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Bundleable) {
                stateBundle2.KClassImpl$Data$declaredNonStaticMembers$2.put(key, ((Bundleable) value).toBundle());
                stateBundle2.MyBillsEntityDataFactory.put(key, 27);
            }
        }
        String retainedObjectStatesTag = getRetainedObjectStatesTag();
        stateBundle.KClassImpl$Data$declaredNonStaticMembers$2.put(retainedObjectStatesTag, stateBundle2);
        stateBundle.MyBillsEntityDataFactory.put(retainedObjectStatesTag, 27);
        return stateBundle;
    }

    public boolean hasStateChanger() {
        checkBackstack("A backstack must be set up before checking state changer.");
        return this.core.hasStateChanger();
    }

    public void removeStateChanger() {
        checkBackstack("A backstack must be set up before removing state changer.");
        this.core.removeStateChanger();
    }

    public void goTo(@Nonnull Object obj) {
        checkBackstack("A backstack must be set up before navigation.");
        this.core.goTo(obj);
    }

    public void replaceTop(@Nonnull Object obj, int i) {
        checkBackstack("A backstack must be set up before navigation.");
        this.core.replaceTop(obj, i);
    }

    public void goUp(@Nonnull Object obj) {
        checkBackstack("A backstack must be set up before navigation.");
        this.core.goUp(obj);
    }

    public void goUp(@Nonnull Object obj, boolean z) {
        checkBackstack("A backstack must be set up before navigation.");
        this.core.goUp(obj, z);
    }

    public void moveToTop(@Nonnull Object obj) {
        checkBackstack("A backstack must be set up before navigation.");
        this.core.moveToTop(obj);
    }

    public void moveToTop(@Nonnull Object obj, boolean z) {
        checkBackstack("A backstack must be set up before navigation.");
        this.core.moveToTop(obj, z);
    }

    public void jumpToRoot() {
        checkBackstack("A backstack must be set up before navigation.");
        this.core.jumpToRoot();
    }

    public void jumpToRoot(int i) {
        checkBackstack("A backstack must be set up before navigation.");
        this.core.jumpToRoot(i);
    }

    public void goUpChain(@Nonnull List<?> list) {
        checkBackstack("A backstack must be set up before navigation.");
        this.core.goUpChain(list);
    }

    public void exitScope(@Nonnull String str) {
        exitScope(str, -1);
    }

    public void exitScope(@Nonnull String str, int i) {
        checkBackstack("A backstack must be set up before navigation.");
        assertCorrectThread();
        if (str == null) {
            throw new NullPointerException("scopeTag must not be null!");
        }
        History history = getHistory();
        if (history.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot exit scope [");
            sb.append(str);
            sb.append("] within an empty backstack.");
            throw new IllegalStateException(sb.toString());
        } else if (!this.scopeManager.hasScope(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot exit scope [");
            sb2.append(str);
            sb2.append("] as it does not exist.");
            throw new IllegalArgumentException(sb2.toString());
        } else {
            Object obj = history.get(0);
            Iterator<T> it = history.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (this.scopeManager.canFindScope(next, str, ScopeLookupMode.EXPLICIT)) {
                    break;
                }
                obj = next;
            }
            this.core.setHistory(History.builderFrom(history).removeUntil(obj).build(), i);
        }
    }

    public void exitScopeTo(@Nonnull String str, @Nonnull Object obj, int i) {
        checkBackstack("A backstack must be set up before navigation.");
        if (str == null) {
            throw new NullPointerException("scopeTag must not be null!");
        }
        if (obj == null) {
            throw new NullPointerException("newKey must not be null!");
        }
        History history = getHistory();
        if (history.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot exit scope [");
            sb.append(str);
            sb.append("] within an empty backstack.");
            throw new IllegalStateException(sb.toString());
        } else if (!this.scopeManager.hasScope(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot exit scope [");
            sb2.append(str);
            sb2.append("] as it does not exist.");
            throw new IllegalArgumentException(sb2.toString());
        } else {
            Object obj2 = history.get(0);
            Iterator<T> it = history.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (this.scopeManager.canFindScope(next, str, ScopeLookupMode.EXPLICIT)) {
                    break;
                }
                obj2 = next;
            }
            History.Builder removeUntil = History.builderFrom(history).removeUntil(obj2);
            if (this.scopeManager.canFindScope(removeUntil.get(0), str, ScopeLookupMode.EXPLICIT)) {
                removeUntil.removeAt(0);
            }
            if (!removeUntil.contains(obj)) {
                removeUntil.add(obj);
            } else {
                removeUntil.removeUntil(obj);
            }
            this.core.setHistory(removeUntil.build(), i);
        }
    }

    public void goUpChain(@Nonnull List<?> list, boolean z) {
        checkBackstack("A backstack must be set up before navigation.");
        this.core.goUpChain(list, z);
    }

    public boolean goBack() {
        checkBackstack("A backstack must be set up before navigation.");
        if (isStateChangePending()) {
            return true;
        }
        Object pVar = getHistory().top();
        if (pVar == null) {
            return false;
        }
        if (this.scopeManager.dispatchBack(pVar)) {
            return true;
        }
        return this.core.goBack();
    }

    public void forceClear() {
        checkBackstack("A backstack must be set up before navigation.");
        finalizeScopes();
        this.core.forceClear();
    }

    public void setHistory(@Nonnull List<?> list, int i) {
        checkBackstack("A backstack must be set up before navigation.");
        this.core.setHistory(list, i);
    }

    @Nonnull
    public <K> K root() {
        checkBackstack("A backstack must be set up before getting keys from it.");
        return (K) this.core.root();
    }

    @Nonnull
    public <K> K top() {
        checkBackstack("A backstack must be set up before getting keys from it.");
        return (K) this.core.top();
    }

    @Nonnull
    public <K> K fromTop(int i) {
        checkBackstack("A backstack must be set up before getting keys from it.");
        return (K) this.core.fromTop(i);
    }

    @Nonnull
    public <K> History<K> getHistory() {
        checkBackstack("A backstack must be set up before getting keys from it.");
        return this.core.getHistory();
    }

    @Nonnull
    public <K> History<K> getInitialKeys() {
        checkBackstack("A backstack must be set up before getting keys from it.");
        return this.core.getInitialKeys();
    }

    public boolean isStateChangePending() {
        checkBackstack("A backstack must be set up before navigation.");
        return this.core.isStateChangePending();
    }

    @Deprecated
    public void addCompletionListener(@Nonnull CompletionListener completionListener) {
        addStateChangeCompletionListener(completionListener);
    }

    @Deprecated
    public void removeCompletionListener(@Nonnull CompletionListener completionListener) {
        removeStateChangeCompletionListener(completionListener);
    }

    @Deprecated
    public void removeCompletionListeners() {
        removeAllStateChangeCompletionListeners();
    }

    public void executePendingStateChange() {
        checkBackstack("A backstack must be set up before navigation.");
        this.core.executePendingStateChange();
    }
}
