package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.1
        @Override // androidx.customview.widget.FocusStrategy.BoundsAdapter
        public final /* synthetic */ void MyBillsEntityDataFactory(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getAuthRequestContext(rect);
        }
    };
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.2
        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.MyBillsEntityDataFactory();
        }

        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public final /* synthetic */ AccessibilityNodeInfoCompat getAuthRequestContext(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i) {
            return sparseArrayCompat.lookAheadTest(i);
        }
    };
    private final View mHost;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final int[] mTempGlobalRect = new int[2];
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    public int mHoveredVirtualViewId = Integer.MIN_VALUE;

    private static int keyToDirection(int i) {
        if (i != 19) {
            if (i != 21) {
                return i != 22 ? 130 : 66;
            }
            return 17;
        }
        return 33;
    }

    protected abstract int getVirtualViewAt(float f, float f2);

    protected abstract void getVisibleVirtualViews(List<Integer> list);

    protected abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    protected void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    protected abstract void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    protected void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    public ExploreByTouchHelper(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.mHost = view;
        this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda1(view) == 0) {
            ViewCompat.moveToNextValue(view, 1);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.mManager.isEnabled() && this.mManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
                updateHoveredVirtualView(virtualViewAt);
                if (virtualViewAt != Integer.MIN_VALUE) {
                    return true;
                }
            } else if (action == 10 && this.mHoveredVirtualViewId != Integer.MIN_VALUE) {
                updateHoveredVirtualView(Integer.MIN_VALUE);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                int keyToDirection = keyToDirection(keyCode);
                                int repeatCount = keyEvent.getRepeatCount();
                                boolean z = false;
                                while (i < repeatCount + 1 && moveFocus(keyToDirection, null)) {
                                    i++;
                                    z = true;
                                }
                                return z;
                            }
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    clickKeyboardFocusedVirtualView();
                    return true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                return moveFocus(2, null);
            } else {
                if (keyEvent.hasModifiers(1)) {
                    return moveFocus(1, null);
                }
            }
        }
        return false;
    }

    public final void onFocusChanged(boolean z, int i, Rect rect) {
        int i2 = this.mKeyboardFocusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (z) {
            moveFocus(i, rect);
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    private void getBoundsInParent(int i, Rect rect) {
        obtainAccessibilityNodeInfo(i).getAuthRequestContext(rect);
    }

    private boolean moveFocus(int i, Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        SparseArrayCompat<AccessibilityNodeInfoCompat> allNodes = getAllNodes();
        int i2 = this.mKeyboardFocusedVirtualViewId;
        AccessibilityNodeInfoCompat BuiltInFictitiousFunctionClassFactory = i2 == Integer.MIN_VALUE ? null : allNodes.BuiltInFictitiousFunctionClassFactory(i2);
        if (i == 1 || i == 2) {
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.MyBillsEntityDataFactory(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, BuiltInFictitiousFunctionClassFactory, i, ViewCompat.initRecordTimeStamp(this.mHost) == 1);
        } else if (i == 17 || i == 33 || i == 66 || i == 130) {
            Rect rect2 = new Rect();
            int i3 = this.mKeyboardFocusedVirtualViewId;
            if (i3 != Integer.MIN_VALUE) {
                getBoundsInParent(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, i, rect2);
            }
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.getAuthRequestContext(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, BuiltInFictitiousFunctionClassFactory, rect2, i);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return requestKeyboardFocusForVirtualView(accessibilityNodeInfoCompat != null ? allNodes.PlaceComponentResult(allNodes.PlaceComponentResult((SparseArrayCompat<AccessibilityNodeInfoCompat>) accessibilityNodeInfoCompat)) : Integer.MIN_VALUE);
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i = 0; i < arrayList.size(); i++) {
            sparseArrayCompat.PlaceComponentResult(arrayList.get(i).intValue(), createNodeForChild(arrayList.get(i).intValue()));
        }
        return sparseArrayCompat;
    }

    private static Rect guessPreviouslyFocusedRect(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i = this.mKeyboardFocusedVirtualViewId;
        return i != Integer.MIN_VALUE && onPerformActionForVirtualView(i, 16, null);
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.mHost, createEvent(i, i2));
    }

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i) {
        invalidateVirtualView(i, 0);
    }

    public final void invalidateVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return;
        }
        AccessibilityEvent createEvent = createEvent(i, 2048);
        AccessibilityEventCompat.BuiltInFictitiousFunctionClassFactory(createEvent, i2);
        parent.requestSendAccessibilityEvent(this.mHost, createEvent);
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    private void updateHoveredVirtualView(int i) {
        int i2 = this.mHoveredVirtualViewId;
        if (i2 == i) {
            return;
        }
        this.mHoveredVirtualViewId = i;
        sendEventForVirtualView(i, 128);
        sendEventForVirtualView(i2, 256);
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        if (i == -1) {
            return createEventForHost(i2);
        }
        return createEventForChild(i, i2);
    }

    private AccessibilityEvent createEventForHost(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
        obtain.getText().add(obtainAccessibilityNodeInfo.lookAheadTest());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.scheduleImpl());
        obtain.setScrollable(obtainAccessibilityNodeInfo.NetworkUserEntityData$$ExternalSyntheticLambda3());
        obtain.setPassword(obtainAccessibilityNodeInfo.FragmentBottomSheetPaymentSettingBinding());
        obtain.setEnabled(obtainAccessibilityNodeInfo.NetworkUserEntityData$$ExternalSyntheticLambda8());
        obtain.setChecked(obtainAccessibilityNodeInfo.NetworkUserEntityData$$ExternalSyntheticLambda1());
        onPopulateEventForVirtualView(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(obtainAccessibilityNodeInfo.getAuthRequestContext());
        AccessibilityRecordCompat.MyBillsEntityDataFactory(obtain, this.mHost, i);
        obtain.setPackageName(this.mHost.getContext().getPackageName());
        return obtain;
    }

    AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i) {
        if (i == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i);
    }

    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat authRequestContext = AccessibilityNodeInfoCompat.getAuthRequestContext(this.mHost);
        ViewCompat.PlaceComponentResult(this.mHost, authRequestContext);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (authRequestContext.MyBillsEntityDataFactory() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.mHost, ((Integer) arrayList.get(i)).intValue());
        }
        return authRequestContext;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    private AccessibilityNodeInfoCompat createNodeForChild(int i) {
        AccessibilityNodeInfoCompat MyBillsEntityDataFactory;
        AccessibilityNodeInfoCompat MyBillsEntityDataFactory2;
        MyBillsEntityDataFactory = AccessibilityNodeInfoCompat.MyBillsEntityDataFactory(AccessibilityNodeInfo.obtain());
        MyBillsEntityDataFactory.moveToNextValue(true);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0(true);
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(DEFAULT_CLASS_NAME);
        Rect rect = INVALID_PARENT_BOUNDS;
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(rect);
        MyBillsEntityDataFactory.MyBillsEntityDataFactory(rect);
        MyBillsEntityDataFactory.PlaceComponentResult(this.mHost);
        onPopulateNodeForVirtualView(i, MyBillsEntityDataFactory);
        if (MyBillsEntityDataFactory.lookAheadTest() == null && MyBillsEntityDataFactory.scheduleImpl() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        MyBillsEntityDataFactory.getAuthRequestContext(this.mTempParentRect);
        if (this.mTempParentRect.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int PlaceComponentResult = MyBillsEntityDataFactory.PlaceComponentResult();
        if ((PlaceComponentResult & 64) == 0) {
            if ((PlaceComponentResult & 128) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            MyBillsEntityDataFactory.scheduleImpl(this.mHost.getContext().getPackageName());
            MyBillsEntityDataFactory.getAuthRequestContext(this.mHost, i);
            if (this.mAccessibilityFocusedVirtualViewId == i) {
                MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(true);
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(128);
            } else {
                MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(false);
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(64);
            }
            boolean z = this.mKeyboardFocusedVirtualViewId == i;
            if (z) {
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2);
            } else if (MyBillsEntityDataFactory.newProxyInstance()) {
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1);
            }
            MyBillsEntityDataFactory.scheduleImpl(z);
            this.mHost.getLocationOnScreen(this.mTempGlobalRect);
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.mTempScreenRect);
            if (this.mTempScreenRect.equals(rect)) {
                MyBillsEntityDataFactory.getAuthRequestContext(this.mTempScreenRect);
                if (MyBillsEntityDataFactory.getAuthRequestContext != -1) {
                    MyBillsEntityDataFactory2 = AccessibilityNodeInfoCompat.MyBillsEntityDataFactory(AccessibilityNodeInfo.obtain());
                    for (int i2 = MyBillsEntityDataFactory.getAuthRequestContext; i2 != -1; i2 = MyBillsEntityDataFactory2.getAuthRequestContext) {
                        MyBillsEntityDataFactory2.PlaceComponentResult(this.mHost, -1);
                        MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(INVALID_PARENT_BOUNDS);
                        onPopulateNodeForVirtualView(i2, MyBillsEntityDataFactory2);
                        MyBillsEntityDataFactory2.getAuthRequestContext(this.mTempParentRect);
                        this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
                    }
                    MyBillsEntityDataFactory2.whenAvailable();
                }
                this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            }
            if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                    MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.mTempScreenRect);
                    if (isVisibleToUser(this.mTempScreenRect)) {
                        MyBillsEntityDataFactory.PrepareContext(true);
                    }
                }
            }
            return MyBillsEntityDataFactory;
        }
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }

    boolean performAction(int i, int i2, Bundle bundle) {
        if (i == -1) {
            return performActionForHost(i2, bundle);
        }
        return performActionForChild(i, i2, bundle);
    }

    private boolean performActionForHost(int i, Bundle bundle) {
        return ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.mHost, i, bundle);
    }

    private boolean performActionForChild(int i, int i2, Bundle bundle) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 64) {
                    if (i2 == 128) {
                        return clearAccessibilityFocus(i);
                    }
                    return onPerformActionForVirtualView(i, i2, bundle);
                }
                return requestAccessibilityFocus(i);
            }
            return clearKeyboardFocusForVirtualView(i);
        }
        return requestKeyboardFocusForVirtualView(i);
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private boolean requestAccessibilityFocus(int i) {
        int i2;
        if (this.mManager.isEnabled() && this.mManager.isTouchExplorationEnabled() && (i2 = this.mAccessibilityFocusedVirtualViewId) != i) {
            if (i2 != Integer.MIN_VALUE) {
                clearAccessibilityFocus(i2);
            }
            this.mAccessibilityFocusedVirtualViewId = i;
            this.mHost.invalidate();
            sendEventForVirtualView(i, 32768);
            return true;
        }
        return false;
    }

    private boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId == i) {
            this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
            this.mHost.invalidate();
            sendEventForVirtualView(i, 65536);
            return true;
        }
        return false;
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        if ((this.mHost.isFocused() || this.mHost.requestFocus()) && (i2 = this.mKeyboardFocusedVirtualViewId) != i) {
            if (i2 != Integer.MIN_VALUE) {
                clearKeyboardFocusForVirtualView(i2);
            }
            if (i == Integer.MIN_VALUE) {
                return false;
            }
            this.mKeyboardFocusedVirtualViewId = i;
            onVirtualViewKeyboardFocusChanged(i, true);
            sendEventForVirtualView(i, 8);
            return true;
        }
        return false;
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    /* loaded from: classes3.dex */
    class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat BuiltInFictitiousFunctionClassFactory(int i) {
            AccessibilityNodeInfoCompat MyBillsEntityDataFactory;
            MyBillsEntityDataFactory = AccessibilityNodeInfoCompat.MyBillsEntityDataFactory(AccessibilityNodeInfo.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i).MyBillsEntityDataFactory));
            return MyBillsEntityDataFactory;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean MyBillsEntityDataFactory(int i, int i2, Bundle bundle) {
            return ExploreByTouchHelper.this.performAction(i, i2, bundle);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat PlaceComponentResult(int i) {
            int i2 = i == 2 ? ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId : ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return BuiltInFictitiousFunctionClassFactory(i2);
        }
    }
}
