package com.zhuinden.simplestack;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.zhuinden.simplestack.Backstack;
import com.zhuinden.simplestack.History;
import com.zhuinden.simplestack.PendingStateChange;
import com.zhuinden.simplestack.StateChanger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class NavigationCore {
    static final int INITIALIZE = 0;
    static final int REATTACH = 1;
    private Backstack backstack;
    private LinkedList<Backstack.CompletionListener> completionListeners;
    private final List<Object> initialKeys;
    private List<Object> initialParameters;
    private final List<Object> originalStack;
    private LinkedList<PendingStateChange> queuedStateChanges;
    private List<Object> stack;
    private StateChanger stateChanger;
    private final long threadId;
    public static final byte[] PlaceComponentResult = {71, Ascii.US, 113, 39, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int getAuthRequestContext = 47;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    @interface StateChangerRegisterMode {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.zhuinden.simplestack.NavigationCore.PlaceComponentResult
            int r8 = r8 * 12
            int r8 = 16 - r8
            int r9 = r9 * 7
            int r9 = r9 + 99
            int r7 = r7 * 3
            int r7 = 16 - r7
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1b
            r9 = r8
            r3 = r1
            r5 = 0
            r8 = r7
            r1 = r0
            r0 = r10
            r10 = r9
            goto L37
        L1b:
            r3 = 0
            r6 = r9
            r9 = r8
            r8 = r6
        L1f:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L2e
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2e:
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L37:
            int r7 = -r7
            int r9 = r9 + 1
            int r10 = r10 + r7
            int r7 = r10 + 2
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zhuinden.simplestack.NavigationCore.a(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackstack(Backstack backstack) {
        this.backstack = backstack;
    }

    public NavigationCore(@Nonnull Object... objArr) {
        ArrayList arrayList = new ArrayList();
        this.originalStack = arrayList;
        this.stack = arrayList;
        this.queuedStateChanges = new LinkedList<>();
        try {
            byte b = (byte) (PlaceComponentResult[15] + 1);
            Object[] objArr2 = new Object[1];
            a(b, b, (byte) (-PlaceComponentResult[15]), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b2 = (byte) (-PlaceComponentResult[15]);
            byte b3 = b2;
            Object[] objArr3 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr3);
            this.threadId = ((Thread) cls.getMethod((String) objArr3[0], null).invoke(null, null)).getId();
            this.completionListeners = new LinkedList<>();
            if (objArr == null || objArr.length <= 0) {
                throw new IllegalArgumentException("At least one initial key must be defined");
            }
            List<Object> unmodifiableList = Collections.unmodifiableList(new ArrayList(Arrays.asList(objArr)));
            this.initialKeys = unmodifiableList;
            setInitialParameters(new ArrayList(unmodifiableList));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public NavigationCore(@Nonnull List<?> list) {
        ArrayList arrayList = new ArrayList();
        this.originalStack = arrayList;
        this.stack = arrayList;
        this.queuedStateChanges = new LinkedList<>();
        try {
            byte b = (byte) (PlaceComponentResult[15] + 1);
            Object[] objArr = new Object[1];
            a(b, b, (byte) (-PlaceComponentResult[15]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-PlaceComponentResult[15]);
            byte b3 = b2;
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            this.threadId = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId();
            this.completionListeners = new LinkedList<>();
            if (list == null) {
                throw new NullPointerException("Initial key list should not be null");
            }
            if (list.size() <= 0) {
                throw new IllegalArgumentException("Initial key list should contain at least one element");
            }
            List<Object> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
            this.initialKeys = unmodifiableList;
            setInitialParameters(new ArrayList(unmodifiableList));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInitialParameters(List<?> list) {
        if (list == null || list.size() <= 0) {
            throw new IllegalArgumentException("At least one initial key must be defined");
        }
        this.initialParameters = new ArrayList(list);
    }

    public boolean hasStateChanger() {
        assertCorrectThread();
        return this.stateChanger != null;
    }

    public void setStateChanger(@Nonnull StateChanger stateChanger) {
        setStateChanger(stateChanger, 0);
    }

    public void setStateChanger(@Nonnull StateChanger stateChanger, int i) {
        if (stateChanger == null) {
            throw new NullPointerException("New state changer cannot be null");
        }
        assertCorrectThread();
        this.stateChanger = stateChanger;
        if (i == 0 && (this.queuedStateChanges.size() <= 1 || this.stack.isEmpty())) {
            if (beginStateChangeIfPossible()) {
                return;
            }
            ArrayList arrayList = new ArrayList(selectActiveHistory());
            if (this.stack.isEmpty()) {
                this.stack = this.initialParameters;
            }
            enqueueStateChange(arrayList, 0, true, false, true);
            return;
        }
        beginStateChangeIfPossible();
    }

    public void removeStateChanger() {
        assertCorrectThread();
        this.stateChanger = null;
    }

    public void goTo(@Nonnull Object obj) {
        boolean z;
        checkNewKey(obj);
        assertCorrectThread();
        History.Builder builderFrom = History.builderFrom(selectActiveHistory());
        int i = 1;
        if (builderFrom.contains(obj)) {
            builderFrom.removeUntil(obj);
            z = true;
            i = -1;
        } else {
            builderFrom.add(obj);
            z = false;
        }
        executeOrConsumeNavigationOp(builderFrom.build(), i, z, false);
    }

    public void replaceTop(@Nonnull Object obj, int i) {
        checkNewKey(obj);
        assertCorrectThread();
        History.Builder builderFrom = History.builderFrom(selectActiveHistory());
        if (!builderFrom.isEmpty()) {
            builderFrom.removeLast();
        }
        builderFrom.add(obj);
        executeOrConsumeNavigationOp(builderFrom.build(), i, true, false);
    }

    public void goUp(@Nonnull Object obj) {
        goUp(obj, false);
    }

    public void goUp(@Nonnull Object obj, boolean z) {
        checkNewKey(obj);
        assertCorrectThread();
        List<?> selectActiveHistory = selectActiveHistory();
        if (selectActiveHistory.size() <= 1) {
            replaceTop(obj, -1);
        } else if (!selectActiveHistory.contains(obj)) {
            replaceTop(obj, -1);
        } else if (z) {
            executeOrConsumeNavigationOp(History.builderFrom(selectActiveHistory).removeLast().build(), -1, true, false);
        } else {
            goTo(obj);
        }
    }

    public void moveToTop(@Nonnull Object obj, boolean z) {
        checkNewKey(obj);
        assertCorrectThread();
        History.Builder builderFrom = History.builderFrom(selectActiveHistory());
        if (builderFrom.contains(obj)) {
            builderFrom.remove(obj);
        }
        builderFrom.add(obj);
        executeOrConsumeNavigationOp(builderFrom.build(), !z ? 1 : 0, false, false);
    }

    public void moveToTop(@Nonnull Object obj) {
        moveToTop(obj, false);
    }

    public void jumpToRoot() {
        jumpToRoot(-1);
    }

    public void jumpToRoot(int i) {
        assertCorrectThread();
        executeOrConsumeNavigationOp(History.of(History.from(selectActiveHistory()).root()), i, true, false);
    }

    public void goUpChain(@Nonnull List<?> list) {
        goUpChain(list, false);
    }

    public void goUpChain(@Nonnull List<?> list, boolean z) {
        checkNewHistory(list);
        assertCorrectThread();
        int size = list.size();
        if (size == 1) {
            goUp(list.get(0), z);
            return;
        }
        History.Builder builderFrom = History.builderFrom(selectActiveHistory());
        builderFrom.removeLast();
        if (Collections.indexOfSubList(builderFrom.build(), list) != -1) {
            if (z) {
                executeOrConsumeNavigationOp(builderFrom.build(), -1, true, false);
                return;
            } else {
                goTo(list.get(size - 1));
                return;
            }
        }
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (builderFrom.contains(obj)) {
                int indexOf = builderFrom.indexOf(obj);
                History.Builder newBuilder = History.newBuilder();
                for (int i2 = 0; i2 < indexOf; i2++) {
                    newBuilder.add(builderFrom.get(i2));
                }
                for (int i3 = 0; i3 < size; i3++) {
                    Object obj2 = list.get(i3);
                    if (newBuilder.contains(obj2)) {
                        newBuilder.remove(obj2);
                    }
                    newBuilder.add(obj2);
                }
                executeOrConsumeNavigationOp(newBuilder.build(), -1, true, false);
                return;
            }
        }
        executeOrConsumeNavigationOp(builderFrom.addAll(list).build(), -1, true, false);
    }

    public boolean goBack() {
        assertCorrectThread();
        if (isStateChangePending()) {
            return true;
        }
        if (this.stack.size() <= 1) {
            return false;
        }
        History.Builder builderFrom = History.builderFrom(selectActiveHistory());
        builderFrom.removeLast();
        executeOrConsumeNavigationOp(builderFrom.build(), -1, true, false);
        return true;
    }

    private void resetBackstack() {
        this.stack.clear();
        this.initialParameters = new ArrayList(this.initialKeys);
    }

    public void forceClear() {
        assertCorrectThread();
        assertNoStateChange();
        resetBackstack();
    }

    public void setHistory(@Nonnull List<?> list, int i) {
        checkNewHistory(list);
        assertCorrectThread();
        executeOrConsumeNavigationOp(list, i, false, true);
    }

    private void executeOrConsumeNavigationOp(@Nonnull List<?> list, int i, boolean z, boolean z2) {
        checkNewHistory(list);
        assertCorrectThread();
        if (this.queuedStateChanges.isEmpty() || !this.queuedStateChanges.peekLast().isTerminal || z2) {
            enqueueStateChange(list, i, false, z, z2);
        }
    }

    @Nonnull
    public <K> K root() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Cannot obtain elements from an uninitialized backstack.");
        }
        return (K) this.stack.get(0);
    }

    @Nonnull
    public <K> K top() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Cannot obtain elements from an uninitialized backstack.");
        }
        return (K) this.stack.get(r0.size() - 1);
    }

    @Nonnull
    public <K> K fromTop(int i) {
        int size = this.stack.size();
        if (size > 0) {
            int i2 = -size;
            if (i < i2 || i >= size) {
                StringBuilder sb = new StringBuilder();
                sb.append("The provided offset value [");
                sb.append(i);
                sb.append("] was out of range: [");
                sb.append(i2);
                sb.append("; ");
                sb.append(size);
                sb.append(")");
                throw new IllegalArgumentException(sb.toString());
            }
            while (i < 0) {
                i += size;
            }
            return (K) this.stack.get(((size - 1) - (i % size)) % size);
        }
        throw new IllegalStateException("Cannot obtain elements from an uninitialized backstack.");
    }

    @Nonnull
    public <K> History<K> getHistory() {
        ArrayList arrayList = new ArrayList(this.stack.size());
        Iterator<Object> it = this.stack.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return History.from(arrayList);
    }

    @Nonnull
    public <K> History<K> getInitialKeys() {
        ArrayList arrayList = new ArrayList(this.initialKeys.size());
        Iterator<Object> it = this.initialKeys.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return History.from(arrayList);
    }

    public boolean isStateChangePending() {
        assertCorrectThread();
        return !this.queuedStateChanges.isEmpty();
    }

    private void enqueueStateChange(List<?> list, int i, boolean z, boolean z2, boolean z3) {
        this.queuedStateChanges.add(new PendingStateChange(list, i, z, z2, z3));
        beginStateChangeIfPossible();
    }

    private List<?> selectActiveHistory() {
        if (this.stack.isEmpty() && this.queuedStateChanges.size() <= 0) {
            return this.initialParameters;
        }
        if (this.queuedStateChanges.size() <= 0) {
            return this.stack;
        }
        return this.queuedStateChanges.getLast().newHistory;
    }

    private boolean beginStateChangeIfPossible() {
        if (hasStateChanger() && isStateChangePending()) {
            PendingStateChange first = this.queuedStateChanges.getFirst();
            if (first.getStatus() == PendingStateChange.Status.ENQUEUED) {
                first.setStatus(PendingStateChange.Status.IN_PROGRESS);
                changeState(first);
                return true;
            }
            return false;
        }
        return false;
    }

    private void changeState(final PendingStateChange pendingStateChange) {
        List arrayList;
        boolean z = pendingStateChange.initialization;
        List<?> list = pendingStateChange.newHistory;
        int i = pendingStateChange.direction;
        if (z) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList(this.stack);
        }
        final StateChange stateChange = new StateChange(this.backstack, Collections.unmodifiableList(arrayList), Collections.unmodifiableList(list), i);
        StateChanger.Callback callback = new StateChanger.Callback() { // from class: com.zhuinden.simplestack.NavigationCore.1
            @Override // com.zhuinden.simplestack.StateChanger.Callback
            public void stateChangeComplete() {
                NavigationCore.this.assertCorrectThread();
                if (pendingStateChange.didForceExecute) {
                    return;
                }
                if (pendingStateChange.getStatus() != PendingStateChange.Status.COMPLETED) {
                    NavigationCore.this.completeStateChange(stateChange);
                    return;
                }
                throw new IllegalStateException("State change completion cannot be called multiple times!");
            }
        };
        pendingStateChange.completionCallback = callback;
        this.stateChanger.handleStateChange(stateChange, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeStateChange(StateChange stateChange) {
        if (this.initialParameters == this.stack) {
            this.stack = this.originalStack;
        }
        this.stack.clear();
        this.stack.addAll(stateChange.newKeys);
        this.queuedStateChanges.removeFirst().setStatus(PendingStateChange.Status.COMPLETED);
        notifyCompletionListeners(stateChange);
        beginStateChangeIfPossible();
    }

    public void addCompletionListener(@Nonnull Backstack.CompletionListener completionListener) {
        if (completionListener == null) {
            throw new IllegalArgumentException("Null completion listener cannot be added!");
        }
        assertCorrectThread();
        this.completionListeners.add(completionListener);
    }

    public void removeCompletionListener(@Nonnull Backstack.CompletionListener completionListener) {
        if (completionListener == null) {
            throw new IllegalArgumentException("Null completion listener cannot be removed!");
        }
        assertCorrectThread();
        this.completionListeners.remove(completionListener);
    }

    public void removeCompletionListeners() {
        this.completionListeners.clear();
    }

    private void notifyCompletionListeners(StateChange stateChange) {
        Iterator<Backstack.CompletionListener> it = this.completionListeners.iterator();
        while (it.hasNext()) {
            it.next().stateChangeCompleted(stateChange);
        }
    }

    public void executePendingStateChange() {
        assertCorrectThread();
        if (isStateChangePending()) {
            PendingStateChange first = this.queuedStateChanges.getFirst();
            if (first.getStatus() == PendingStateChange.Status.IN_PROGRESS) {
                first.completionCallback.stateChangeComplete();
                first.didForceExecute = true;
            }
        }
    }

    private void checkNewHistory(List<?> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("New history cannot be null or empty");
        }
    }

    private void checkNewKey(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

    private void assertNoStateChange() {
        if (isStateChangePending()) {
            throw new IllegalStateException("This operation is not allowed while there are enqueued state changes.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void assertCorrectThread() {
        try {
            byte b = (byte) (PlaceComponentResult[15] + 1);
            Object[] objArr = new Object[1];
            a(b, b, (byte) (-PlaceComponentResult[15]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-PlaceComponentResult[15]);
            byte b3 = b2;
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
}
