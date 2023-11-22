package com.mixpanel.android.viewcrawler;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fullstory.instrumentation.InstrumentInjector;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.Pathfinder;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class ViewVisitor implements Pathfinder.Accumulator {
    private final List<Pathfinder.PathElement> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Pathfinder MyBillsEntityDataFactory = new Pathfinder();

    /* loaded from: classes.dex */
    public interface OnEventListener {
        void BuiltInFictitiousFunctionClassFactory(View view, String str, boolean z);
    }

    /* loaded from: classes.dex */
    public interface OnLayoutErrorListener {
        void getAuthRequestContext(LayoutErrorMessage layoutErrorMessage);
    }

    public abstract void BuiltInFictitiousFunctionClassFactory();

    /* loaded from: classes.dex */
    public static class LayoutErrorMessage {
        final String KClassImpl$Data$declaredNonStaticMembers$2;
        final String PlaceComponentResult;

        public LayoutErrorMessage(String str, String str2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.PlaceComponentResult = str2;
        }
    }

    /* loaded from: classes.dex */
    public static class PropertySetVisitor extends ViewVisitor {
        private final Caller BuiltInFictitiousFunctionClassFactory;
        private final Caller KClassImpl$Data$declaredNonStaticMembers$2;
        private final WeakHashMap<View, Object> MyBillsEntityDataFactory;
        private final Object[] PlaceComponentResult;

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public final /* bridge */ /* synthetic */ void MyBillsEntityDataFactory(View view) {
            super.MyBillsEntityDataFactory(view);
        }

        public PropertySetVisitor(List<Pathfinder.PathElement> list, Caller caller, Caller caller2) {
            super(list);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = caller;
            this.BuiltInFictitiousFunctionClassFactory = caller2;
            this.PlaceComponentResult = new Object[1];
            this.MyBillsEntityDataFactory = new WeakHashMap<>();
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public final void BuiltInFictitiousFunctionClassFactory() {
            for (Map.Entry<View, Object> entry : this.MyBillsEntityDataFactory.entrySet()) {
                View key = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    Object[] objArr = this.PlaceComponentResult;
                    objArr[0] = value;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(key, objArr);
                }
            }
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        public final void BuiltInFictitiousFunctionClassFactory(View view) {
            if (this.BuiltInFictitiousFunctionClassFactory != null) {
                Object[] objArr = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
                if (1 == objArr.length) {
                    Object obj = objArr[0];
                    Caller caller = this.BuiltInFictitiousFunctionClassFactory;
                    Object MyBillsEntityDataFactory = caller.MyBillsEntityDataFactory(view, caller.BuiltInFictitiousFunctionClassFactory);
                    if (obj == MyBillsEntityDataFactory) {
                        return;
                    }
                    if (obj != null) {
                        if ((obj instanceof Bitmap) && (MyBillsEntityDataFactory instanceof Bitmap)) {
                            if (((Bitmap) obj).sameAs((Bitmap) MyBillsEntityDataFactory)) {
                                return;
                            }
                        } else if ((obj instanceof BitmapDrawable) && (MyBillsEntityDataFactory instanceof BitmapDrawable)) {
                            Bitmap bitmap = ((BitmapDrawable) obj).getBitmap();
                            Bitmap bitmap2 = ((BitmapDrawable) MyBillsEntityDataFactory).getBitmap();
                            if (bitmap != null && bitmap.sameAs(bitmap2)) {
                                return;
                            }
                        } else if (obj.equals(MyBillsEntityDataFactory)) {
                            return;
                        }
                    }
                    if (!(MyBillsEntityDataFactory instanceof Bitmap) && !(MyBillsEntityDataFactory instanceof BitmapDrawable) && !this.MyBillsEntityDataFactory.containsKey(view)) {
                        Object[] objArr2 = this.PlaceComponentResult;
                        objArr2[0] = MyBillsEntityDataFactory;
                        if (this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(objArr2)) {
                            this.MyBillsEntityDataFactory.put(view, MyBillsEntityDataFactory);
                        } else {
                            this.MyBillsEntityDataFactory.put(view, null);
                        }
                    }
                }
            }
            Caller caller2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            caller2.MyBillsEntityDataFactory(view, caller2.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CycleDetector {
        private CycleDetector() {
        }

        /* synthetic */ CycleDetector(byte b) {
            this();
        }

        public final boolean BuiltInFictitiousFunctionClassFactory(TreeMap<View, List<View>> treeMap) {
            ArrayList arrayList = new ArrayList();
            while (!treeMap.isEmpty()) {
                if (!BuiltInFictitiousFunctionClassFactory(treeMap, treeMap.firstKey(), arrayList)) {
                    return false;
                }
            }
            return true;
        }

        private boolean BuiltInFictitiousFunctionClassFactory(TreeMap<View, List<View>> treeMap, View view, List<View> list) {
            if (list.contains(view)) {
                return false;
            }
            if (treeMap.containsKey(view)) {
                List<View> remove = treeMap.remove(view);
                list.add(view);
                int size = remove.size();
                for (int i = 0; i < size; i++) {
                    if (!BuiltInFictitiousFunctionClassFactory(treeMap, remove.get(i), list)) {
                        return false;
                    }
                }
                list.remove(view);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutUpdateVisitor extends ViewVisitor {
        private final CycleDetector MyBillsEntityDataFactory;
        private final OnLayoutErrorListener NetworkUserEntityData$$ExternalSyntheticLambda0;
        private boolean PlaceComponentResult;
        private final List<LayoutRule> getAuthRequestContext;
        private final WeakHashMap<View, int[]> lookAheadTest;
        private final String scheduleImpl;
        private static final Set<Integer> KClassImpl$Data$declaredNonStaticMembers$2 = new HashSet(Arrays.asList(0, 1, 5, 7));
        private static final Set<Integer> BuiltInFictitiousFunctionClassFactory = new HashSet(Arrays.asList(2, 3, 4, 6, 8));

        public LayoutUpdateVisitor(List<Pathfinder.PathElement> list, List<LayoutRule> list2, String str, OnLayoutErrorListener onLayoutErrorListener) {
            super(list);
            this.lookAheadTest = new WeakHashMap<>();
            this.getAuthRequestContext = list2;
            this.scheduleImpl = str;
            this.PlaceComponentResult = true;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = onLayoutErrorListener;
            this.MyBillsEntityDataFactory = new CycleDetector((byte) 0);
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public final void BuiltInFictitiousFunctionClassFactory() {
            Iterator<Map.Entry<View, int[]>> it = this.lookAheadTest.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<View, int[]> next = it.next();
                    View key = next.getKey();
                    int[] value = next.getValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) key.getLayoutParams();
                    for (int i = 0; i < value.length; i++) {
                        layoutParams.addRule(i, value[i]);
                    }
                    key.setLayoutParams(layoutParams);
                } else {
                    this.PlaceComponentResult = false;
                    return;
                }
            }
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public final void MyBillsEntityDataFactory(View view) {
            if (this.PlaceComponentResult) {
                getAuthRequestContext().PlaceComponentResult(view, KClassImpl$Data$declaredNonStaticMembers$2(), this);
            }
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        public final void BuiltInFictitiousFunctionClassFactory(View view) {
            ViewGroup viewGroup = (ViewGroup) view;
            SparseArray<View> sparseArray = new SparseArray<>();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                int id2 = childAt.getId();
                if (id2 > 0) {
                    sparseArray.put(id2, childAt);
                }
            }
            int size = this.getAuthRequestContext.size();
            for (int i2 = 0; i2 < size; i2++) {
                LayoutRule layoutRule = this.getAuthRequestContext.get(i2);
                View view2 = sparseArray.get(layoutRule.KClassImpl$Data$declaredNonStaticMembers$2);
                if (view2 != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
                    int[] iArr = (int[]) layoutParams.getRules().clone();
                    if (iArr[layoutRule.BuiltInFictitiousFunctionClassFactory] == layoutRule.MyBillsEntityDataFactory) {
                        continue;
                    } else {
                        if (!this.lookAheadTest.containsKey(view2)) {
                            this.lookAheadTest.put(view2, iArr);
                        }
                        layoutParams.addRule(layoutRule.BuiltInFictitiousFunctionClassFactory, layoutRule.MyBillsEntityDataFactory);
                        Set<Integer> set = KClassImpl$Data$declaredNonStaticMembers$2;
                        if (!set.contains(Integer.valueOf(layoutRule.BuiltInFictitiousFunctionClassFactory))) {
                            set = BuiltInFictitiousFunctionClassFactory;
                            if (!set.contains(Integer.valueOf(layoutRule.BuiltInFictitiousFunctionClassFactory))) {
                                set = null;
                            }
                        }
                        if (set != null && !PlaceComponentResult(set, sparseArray)) {
                            BuiltInFictitiousFunctionClassFactory();
                            this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(new LayoutErrorMessage("circular_dependency", this.scheduleImpl));
                            return;
                        }
                        view2.setLayoutParams(layoutParams);
                    }
                }
            }
        }

        private boolean PlaceComponentResult(Set<Integer> set, SparseArray<View> sparseArray) {
            TreeMap<View, List<View>> treeMap = new TreeMap<>(new Comparator<View>() { // from class: com.mixpanel.android.viewcrawler.ViewVisitor.LayoutUpdateVisitor.1
                @Override // java.util.Comparator
                public /* synthetic */ int compare(View view, View view2) {
                    View view3 = view;
                    View view4 = view2;
                    if (view3 == view4) {
                        return 0;
                    }
                    if (view3 == null) {
                        return -1;
                    }
                    if (view4 == null) {
                        return 1;
                    }
                    return view4.hashCode() - view3.hashCode();
                }
            });
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View valueAt = sparseArray.valueAt(i);
                int[] rules = ((RelativeLayout.LayoutParams) valueAt.getLayoutParams()).getRules();
                ArrayList arrayList = new ArrayList();
                Iterator<Integer> it = set.iterator();
                while (it.hasNext()) {
                    int i2 = rules[it.next().intValue()];
                    if (i2 > 0 && i2 != valueAt.getId()) {
                        arrayList.add(sparseArray.get(i2));
                    }
                }
                treeMap.put(valueAt, arrayList);
            }
            return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(treeMap);
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutRule {
        public final int BuiltInFictitiousFunctionClassFactory;
        public final int KClassImpl$Data$declaredNonStaticMembers$2;
        public final int MyBillsEntityDataFactory;

        public LayoutRule(int i, int i2, int i3) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.MyBillsEntityDataFactory = i3;
        }
    }

    /* loaded from: classes.dex */
    public static class AddAccessibilityEventVisitor extends EventTriggeringVisitor {
        private final int BuiltInFictitiousFunctionClassFactory;
        private final WeakHashMap<View, TrackingAccessibilityDelegate> getAuthRequestContext;

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public final /* bridge */ /* synthetic */ void MyBillsEntityDataFactory(View view) {
            super.MyBillsEntityDataFactory(view);
        }

        public AddAccessibilityEventVisitor(List<Pathfinder.PathElement> list, int i, String str, OnEventListener onEventListener) {
            super(list, str, onEventListener, false);
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.getAuthRequestContext = new WeakHashMap<>();
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public final void BuiltInFictitiousFunctionClassFactory() {
            for (Map.Entry<View, TrackingAccessibilityDelegate> entry : this.getAuthRequestContext.entrySet()) {
                View key = entry.getKey();
                TrackingAccessibilityDelegate value = entry.getValue();
                View.AccessibilityDelegate authRequestContext = getAuthRequestContext(key);
                if (authRequestContext == value) {
                    InstrumentInjector.setAccessibilityDelegate(key, value.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (authRequestContext instanceof TrackingAccessibilityDelegate) {
                    while (true) {
                        TrackingAccessibilityDelegate trackingAccessibilityDelegate = (TrackingAccessibilityDelegate) authRequestContext;
                        View.AccessibilityDelegate accessibilityDelegate = trackingAccessibilityDelegate.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (accessibilityDelegate == value) {
                            trackingAccessibilityDelegate.KClassImpl$Data$declaredNonStaticMembers$2 = value.KClassImpl$Data$declaredNonStaticMembers$2;
                            break;
                        } else if (accessibilityDelegate instanceof TrackingAccessibilityDelegate) {
                            authRequestContext = accessibilityDelegate;
                        }
                    }
                }
            }
            this.getAuthRequestContext.clear();
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        public final void BuiltInFictitiousFunctionClassFactory(View view) {
            View.AccessibilityDelegate authRequestContext = getAuthRequestContext(view);
            if ((authRequestContext instanceof TrackingAccessibilityDelegate) && ((TrackingAccessibilityDelegate) authRequestContext).PlaceComponentResult(((EventTriggeringVisitor) this).MyBillsEntityDataFactory)) {
                return;
            }
            TrackingAccessibilityDelegate trackingAccessibilityDelegate = new TrackingAccessibilityDelegate(authRequestContext);
            InstrumentInjector.setAccessibilityDelegate(view, trackingAccessibilityDelegate);
            this.getAuthRequestContext.put(view, trackingAccessibilityDelegate);
        }

        private static View.AccessibilityDelegate getAuthRequestContext(View view) {
            try {
                return (View.AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException unused) {
                return null;
            } catch (InvocationTargetException e) {
                MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.ViewVisitor", "getAccessibilityDelegate threw an exception when called.", e);
                return null;
            }
        }

        /* loaded from: classes3.dex */
        class TrackingAccessibilityDelegate extends View.AccessibilityDelegate {
            View.AccessibilityDelegate KClassImpl$Data$declaredNonStaticMembers$2;

            public TrackingAccessibilityDelegate(View.AccessibilityDelegate accessibilityDelegate) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = accessibilityDelegate;
            }

            public final boolean PlaceComponentResult(String str) {
                TrackingAccessibilityDelegate trackingAccessibilityDelegate = this;
                while (((EventTriggeringVisitor) AddAccessibilityEventVisitor.this).MyBillsEntityDataFactory != str) {
                    View.AccessibilityDelegate accessibilityDelegate = trackingAccessibilityDelegate.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (!(accessibilityDelegate instanceof TrackingAccessibilityDelegate)) {
                        return false;
                    }
                    trackingAccessibilityDelegate = (TrackingAccessibilityDelegate) accessibilityDelegate;
                }
                return true;
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i) {
                if (i == AddAccessibilityEventVisitor.this.BuiltInFictitiousFunctionClassFactory) {
                    AddAccessibilityEventVisitor addAccessibilityEventVisitor = AddAccessibilityEventVisitor.this;
                    addAccessibilityEventVisitor.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(view, ((EventTriggeringVisitor) addAccessibilityEventVisitor).MyBillsEntityDataFactory, ((EventTriggeringVisitor) addAccessibilityEventVisitor).KClassImpl$Data$declaredNonStaticMembers$2);
                }
                View.AccessibilityDelegate accessibilityDelegate = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.sendAccessibilityEvent(view, i);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AddTextChangeListener extends EventTriggeringVisitor {
        private final Map<TextView, TextWatcher> BuiltInFictitiousFunctionClassFactory;

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public final /* bridge */ /* synthetic */ void MyBillsEntityDataFactory(View view) {
            super.MyBillsEntityDataFactory(view);
        }

        public AddTextChangeListener(List<Pathfinder.PathElement> list, String str, OnEventListener onEventListener) {
            super(list, str, onEventListener, true);
            this.BuiltInFictitiousFunctionClassFactory = new HashMap();
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public final void BuiltInFictitiousFunctionClassFactory() {
            for (Map.Entry<TextView, TextWatcher> entry : this.BuiltInFictitiousFunctionClassFactory.entrySet()) {
                entry.getKey().removeTextChangedListener(entry.getValue());
            }
            this.BuiltInFictitiousFunctionClassFactory.clear();
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        public final void BuiltInFictitiousFunctionClassFactory(View view) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                TrackingTextWatcher trackingTextWatcher = new TrackingTextWatcher(textView);
                TextWatcher textWatcher = this.BuiltInFictitiousFunctionClassFactory.get(textView);
                if (textWatcher != null) {
                    textView.removeTextChangedListener(textWatcher);
                }
                textView.addTextChangedListener(trackingTextWatcher);
                this.BuiltInFictitiousFunctionClassFactory.put(textView, trackingTextWatcher);
            }
        }

        /* loaded from: classes3.dex */
        class TrackingTextWatcher implements TextWatcher {
            private final View BuiltInFictitiousFunctionClassFactory;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public TrackingTextWatcher(View view) {
                this.BuiltInFictitiousFunctionClassFactory = view;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AddTextChangeListener addTextChangeListener = AddTextChangeListener.this;
                addTextChangeListener.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, ((EventTriggeringVisitor) addTextChangeListener).MyBillsEntityDataFactory, ((EventTriggeringVisitor) addTextChangeListener).KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ViewDetectorVisitor extends EventTriggeringVisitor {
        private boolean getAuthRequestContext;

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public final void BuiltInFictitiousFunctionClassFactory() {
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public final /* bridge */ /* synthetic */ void MyBillsEntityDataFactory(View view) {
            super.MyBillsEntityDataFactory(view);
        }

        public ViewDetectorVisitor(List<Pathfinder.PathElement> list, String str, OnEventListener onEventListener) {
            super(list, str, onEventListener, false);
            this.getAuthRequestContext = false;
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        public final void BuiltInFictitiousFunctionClassFactory(View view) {
            if (view != null && !this.getAuthRequestContext) {
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(view, ((EventTriggeringVisitor) this).MyBillsEntityDataFactory, ((EventTriggeringVisitor) this).KClassImpl$Data$declaredNonStaticMembers$2);
            }
            this.getAuthRequestContext = view != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class EventTriggeringVisitor extends ViewVisitor {
        final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final String MyBillsEntityDataFactory;
        final OnEventListener PlaceComponentResult;

        public EventTriggeringVisitor(List<Pathfinder.PathElement> list, String str, OnEventListener onEventListener, boolean z) {
            super(list);
            this.PlaceComponentResult = onEventListener;
            this.MyBillsEntityDataFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        }
    }

    public void MyBillsEntityDataFactory(View view) {
        this.MyBillsEntityDataFactory.PlaceComponentResult(view, this.KClassImpl$Data$declaredNonStaticMembers$2, this);
    }

    protected ViewVisitor(List<Pathfinder.PathElement> list) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }

    protected final List<Pathfinder.PathElement> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    protected final Pathfinder getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }
}
