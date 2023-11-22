package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.ContainerHelpers;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private ArrayList<TransitionValues> mEndValuesList;
    private EpicenterCallback mEpicenterCallback;
    private ArrayMap<String, String> mNameOverrides;
    TransitionPropagation mPropagation;
    private ArrayList<TransitionValues> mStartValuesList;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion() { // from class: androidx.transition.Transition.1
        @Override // androidx.transition.PathMotion
        public Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal<>();
    private String mName = getClass().getName();
    private long mStartDelay = -1;
    long mDuration = -1;
    private TimeInterpolator mInterpolator = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    ArrayList<View> mTargets = new ArrayList<>();
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    public TransitionSet mParent = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    private int mNumInstances = 0;
    private boolean mPaused = false;
    private boolean mEnded = false;
    private ArrayList<TransitionListener> mListeners = null;
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;

    /* loaded from: classes.dex */
    public static abstract class EpicenterCallback {
        public abstract Rect getAuthRequestContext();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MatchOrder {
    }

    /* loaded from: classes.dex */
    public interface TransitionListener {
        void onTransitionCancel(Transition transition);

        void onTransitionEnd(Transition transition);

        void onTransitionPause(Transition transition);

        void onTransitionResume(Transition transition);

        void onTransitionStart(Transition transition);
    }

    private static boolean isValidMatch(int i) {
        return i > 0 && i <= 4;
    }

    public abstract void captureEndValues(TransitionValues transitionValues);

    public abstract void captureStartValues(TransitionValues transitionValues);

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public Transition() {
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.getErrorConfigVersion);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long authRequestContext = TypedArrayUtils.getAuthRequestContext(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (authRequestContext >= 0) {
            setDuration(authRequestContext);
        }
        long authRequestContext2 = TypedArrayUtils.getAuthRequestContext(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (authRequestContext2 > 0) {
            setStartDelay(authRequestContext2);
        }
        int KClassImpl$Data$declaredNonStaticMembers$2 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(obtainStyledAttributes, xmlResourceParser, "interpolator", 0);
        if (KClassImpl$Data$declaredNonStaticMembers$2 > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, KClassImpl$Data$declaredNonStaticMembers$2));
        }
        String BuiltInFictitiousFunctionClassFactory = TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            setMatchOrder(parseMatchOrder(BuiltInFictitiousFunctionClassFactory));
        }
        obtainStyledAttributes.recycle();
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown match type in matchOrder: '");
                sb.append(trim);
                sb.append("'");
                throw new InflateException(sb.toString());
            }
            i++;
        }
        return iArr;
    }

    public Transition setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Transition setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (!isValidMatch(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (alreadyContains(iArr, i)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    private static boolean alreadyContains(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View view = (View) arrayMap.moveToNextValue[size << 1];
            if (view != null && isValidTarget(view) && (remove = arrayMap2.remove(view)) != null && isValidTarget(remove.MyBillsEntityDataFactory)) {
                this.mStartValuesList.add(arrayMap.MyBillsEntityDataFactory(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i = 0; i < size; i++) {
            int i2 = i << 1;
            View view2 = (View) arrayMap3.moveToNextValue[i2 + 1];
            if (view2 != null && isValidTarget(view2) && (view = arrayMap4.get(arrayMap3.moveToNextValue[i2])) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(view2);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(view2);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i = 0; i < arrayMap.size(); i++) {
            TransitionValues transitionValues = (TransitionValues) arrayMap.moveToNextValue[(i << 1) + 1];
            if (isValidTarget(transitionValues.MyBillsEntityDataFactory)) {
                this.mStartValuesList.add(transitionValues);
                this.mEndValuesList.add(null);
            }
        }
        for (int i2 = 0; i2 < arrayMap2.size(); i2++) {
            TransitionValues transitionValues2 = (TransitionValues) arrayMap2.moveToNextValue[(i2 << 1) + 1];
            if (isValidTarget(transitionValues2.MyBillsEntityDataFactory)) {
                this.mEndValuesList.add(transitionValues2);
                this.mStartValuesList.add(null);
            }
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap<View, TransitionValues> arrayMap = new ArrayMap<>(transitionValuesMaps.MyBillsEntityDataFactory);
        ArrayMap<View, TransitionValues> arrayMap2 = new ArrayMap<>(transitionValuesMaps2.MyBillsEntityDataFactory);
        int i = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    matchInstances(arrayMap, arrayMap2);
                } else if (i2 == 2) {
                    matchNames(arrayMap, arrayMap2, transitionValuesMaps.getAuthRequestContext, transitionValuesMaps2.getAuthRequestContext);
                } else if (i2 == 3) {
                    matchIds(arrayMap, arrayMap2, transitionValuesMaps.PlaceComponentResult, transitionValuesMaps2.PlaceComponentResult);
                } else if (i2 == 4) {
                    matchItemIds(arrayMap, arrayMap2, transitionValuesMaps.KClassImpl$Data$declaredNonStaticMembers$2, transitionValuesMaps2.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                i++;
            } else {
                addUnmatched(arrayMap, arrayMap2);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0123 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void createAnimators(android.view.ViewGroup r21, androidx.transition.TransitionValuesMaps r22, androidx.transition.TransitionValuesMaps r23, java.util.ArrayList<androidx.transition.TransitionValues> r24, java.util.ArrayList<androidx.transition.TransitionValues> r25) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Transition.createAnimators(android.view.ViewGroup, androidx.transition.TransitionValuesMaps, androidx.transition.TransitionValuesMaps, java.util.ArrayList, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id2 = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 == null || !arrayList3.contains(Integer.valueOf(id2))) {
            ArrayList<View> arrayList4 = this.mTargetExcludes;
            if (arrayList4 == null || !arrayList4.contains(view)) {
                ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                            return false;
                        }
                    }
                }
                if (this.mTargetNameExcludes == null || ViewCompat.getCallingPid(view) == null || !this.mTargetNameExcludes.contains(ViewCompat.getCallingPid(view))) {
                    if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id2)) || this.mTargets.contains(view)) {
                        return true;
                    }
                    ArrayList<String> arrayList6 = this.mTargetNames;
                    if (arrayList6 == null || !arrayList6.contains(ViewCompat.getCallingPid(view))) {
                        if (this.mTargetTypes != null) {
                            for (int i2 = 0; i2 < this.mTargetTypes.size(); i2++) {
                                if (this.mTargetTypes.get(i2).isInstance(view)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> arrayMap = sRunningAnimators.get();
        if (arrayMap == null) {
            ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
            sRunningAnimators.set(arrayMap2);
            return arrayMap2;
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runAnimators() {
        start();
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    private void runAnimator(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Transition.this.mCurrentAnimators.add(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    arrayMap.remove(animator2);
                    Transition.this.mCurrentAnimators.remove(animator2);
                }
            });
            animate(animator);
        }
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public Transition addTarget(int i) {
        if (i != 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    public Transition addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public Transition addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public Transition removeTarget(int i) {
        if (i != 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public Transition removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public Transition removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        if (t != null) {
            if (z) {
                return ArrayListManager.getAuthRequestContext(arrayList, t);
            }
            return ArrayListManager.KClassImpl$Data$declaredNonStaticMembers$2(arrayList, t);
        }
        return arrayList;
    }

    public Transition excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    public Transition excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public Transition excludeTarget(String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    public Transition excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public Transition excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        if (i > 0) {
            if (z) {
                return ArrayListManager.getAuthRequestContext(arrayList, Integer.valueOf(i));
            }
            return ArrayListManager.KClassImpl$Data$declaredNonStaticMembers$2(arrayList, Integer.valueOf(i));
        }
        return arrayList;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        if (view != null) {
            if (z) {
                return ArrayListManager.getAuthRequestContext(arrayList, view);
            }
            return ArrayListManager.KClassImpl$Data$declaredNonStaticMembers$2(arrayList, view);
        }
        return arrayList;
    }

    public Transition excludeTarget(Class<?> cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public Transition excludeChildren(Class<?> cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        if (cls != null) {
            if (z) {
                return ArrayListManager.getAuthRequestContext(arrayList, cls);
            }
            return ArrayListManager.KClassImpl$Data$declaredNonStaticMembers$2(arrayList, cls);
        }
        return arrayList;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void captureValues(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        ArrayMap<String, String> arrayMap;
        clearValues(z);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(findViewById);
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.KClassImpl$Data$declaredNonStaticMembers$2.add(this);
                    capturePropagationValues(transitionValues);
                    if (z) {
                        addViewValues(this.mStartValues, findViewById, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, findViewById, transitionValues);
                    }
                }
            }
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                View view = this.mTargets.get(i2);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.KClassImpl$Data$declaredNonStaticMembers$2.add(this);
                capturePropagationValues(transitionValues2);
                if (z) {
                    addViewValues(this.mStartValues, view, transitionValues2);
                } else {
                    addViewValues(this.mEndValues, view, transitionValues2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z);
        }
        if (z || (arrayMap = this.mNameOverrides) == null) {
            return;
        }
        int size = arrayMap.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.mStartValues.getAuthRequestContext.remove((String) this.mNameOverrides.moveToNextValue[i3 << 1]));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.mStartValues.getAuthRequestContext.put((String) this.mNameOverrides.moveToNextValue[(i4 << 1) + 1], view2);
            }
        }
    }

    private static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.MyBillsEntityDataFactory.put(view, transitionValues);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (transitionValuesMaps.PlaceComponentResult.indexOfKey(id2) >= 0) {
                transitionValuesMaps.PlaceComponentResult.put(id2, null);
            } else {
                transitionValuesMaps.PlaceComponentResult.put(id2, view);
            }
        }
        String callingPid = ViewCompat.getCallingPid(view);
        if (callingPid != null) {
            if (transitionValuesMaps.getAuthRequestContext.containsKey(callingPid)) {
                transitionValuesMaps.getAuthRequestContext.put(callingPid, null);
            } else {
                transitionValuesMaps.getAuthRequestContext.put(callingPid, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                LongSparseArray<View> longSparseArray = transitionValuesMaps.KClassImpl$Data$declaredNonStaticMembers$2;
                if (longSparseArray.MyBillsEntityDataFactory) {
                    longSparseArray.BuiltInFictitiousFunctionClassFactory();
                }
                if (ContainerHelpers.KClassImpl$Data$declaredNonStaticMembers$2(longSparseArray.PlaceComponentResult, longSparseArray.KClassImpl$Data$declaredNonStaticMembers$2, itemIdAtPosition) < 0) {
                    ViewCompat.PlaceComponentResult(view, true);
                    transitionValuesMaps.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(itemIdAtPosition, view);
                    return;
                }
                View MyBillsEntityDataFactory = transitionValuesMaps.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(itemIdAtPosition, null);
                if (MyBillsEntityDataFactory != null) {
                    ViewCompat.PlaceComponentResult(MyBillsEntityDataFactory, false);
                    transitionValuesMaps.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(itemIdAtPosition, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.MyBillsEntityDataFactory.clear();
            this.mStartValues.PlaceComponentResult.clear();
            this.mStartValues.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            return;
        }
        this.mEndValues.MyBillsEntityDataFactory.clear();
        this.mEndValues.PlaceComponentResult.clear();
        this.mEndValues.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
    }

    private void captureHierarchy(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id2 = view.getId();
        ArrayList<Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
            ArrayList<View> arrayList2 = this.mTargetExcludes;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    TransitionValues transitionValues = new TransitionValues(view);
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.KClassImpl$Data$declaredNonStaticMembers$2.add(this);
                    capturePropagationValues(transitionValues);
                    if (z) {
                        addViewValues(this.mStartValues, view, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, view, transitionValues);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                        ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.mTargetTypeChildExcludes.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                captureHierarchy(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public TransitionValues getTransitionValues(View view, boolean z) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z);
        }
        return (z ? this.mStartValues : this.mEndValues).MyBillsEntityDataFactory.get(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransitionValues getMatchedTransitionValues(View view, boolean z) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z);
        }
        ArrayList<TransitionValues> arrayList = z ? this.mStartValuesList : this.mEndValuesList;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            TransitionValues transitionValues = arrayList.get(i);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.MyBillsEntityDataFactory == view) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return (z ? this.mEndValuesList : this.mStartValuesList).get(i);
        }
        return null;
    }

    public void pause(View view) {
        if (this.mEnded) {
            return;
        }
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            AnimatorUtils.PlaceComponentResult(this.mCurrentAnimators.get(size));
        }
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i = 0; i < size2; i++) {
                ((TransitionListener) arrayList2.get(i)).onTransitionPause(this);
            }
        }
        this.mPaused = true;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
                    AnimatorUtils.getAuthRequestContext(this.mCurrentAnimators.get(size));
                }
                ArrayList<TransitionListener> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i = 0; i < size2; i++) {
                        ((TransitionListener) arrayList2.get(i)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void playTransition(ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        WindowIdImpl BuiltInFictitiousFunctionClassFactory = ViewUtils.BuiltInFictitiousFunctionClassFactory(viewGroup);
        while (true) {
            size--;
            if (size >= 0) {
                Animator animator = (Animator) runningAnimators.moveToNextValue[size << 1];
                if (animator != null && (animationInfo = runningAnimators.get(animator)) != null && animationInfo.KClassImpl$Data$declaredNonStaticMembers$2 != null && BuiltInFictitiousFunctionClassFactory.equals(animationInfo.BuiltInFictitiousFunctionClassFactory)) {
                    TransitionValues transitionValues = animationInfo.MyBillsEntityDataFactory;
                    View view = animationInfo.KClassImpl$Data$declaredNonStaticMembers$2;
                    TransitionValues transitionValues2 = getTransitionValues(view, true);
                    TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
                    if (transitionValues2 == null && matchedTransitionValues == null) {
                        matchedTransitionValues = this.mEndValues.MyBillsEntityDataFactory.get(view);
                    }
                    if (!(transitionValues2 == null && matchedTransitionValues == null) && animationInfo.getAuthRequestContext.isTransitionRequired(transitionValues, matchedTransitionValues)) {
                        if (animator.isRunning() || animator.isStarted()) {
                            animator.cancel();
                        } else {
                            runningAnimators.remove(animator);
                        }
                    }
                }
            } else {
                createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
                runAnimators();
                return;
            }
        }
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            for (String str : transitionProperties) {
                if (!isValueChanged(transitionValues, transitionValues2, str)) {
                }
            }
            return false;
        }
        Iterator<String> it = transitionValues.getAuthRequestContext.keySet().iterator();
        while (it.hasNext()) {
            if (isValueChanged(transitionValues, transitionValues2, it.next())) {
            }
        }
        return false;
        return true;
    }

    private static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.getAuthRequestContext.get(str);
        Object obj2 = transitionValues2.getAuthRequestContext.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    protected void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Transition.this.end();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList2.get(i)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void end() {
        int i = this.mNumInstances - 1;
        this.mNumInstances = i;
        if (i != 0) {
            return;
        }
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((TransitionListener) arrayList2.get(i2)).onTransitionEnd(this);
            }
        }
        int i3 = 0;
        while (true) {
            LongSparseArray<View> longSparseArray = this.mStartValues.KClassImpl$Data$declaredNonStaticMembers$2;
            if (longSparseArray.MyBillsEntityDataFactory) {
                longSparseArray.BuiltInFictitiousFunctionClassFactory();
            }
            if (i3 >= longSparseArray.KClassImpl$Data$declaredNonStaticMembers$2) {
                break;
            }
            LongSparseArray<View> longSparseArray2 = this.mStartValues.KClassImpl$Data$declaredNonStaticMembers$2;
            if (longSparseArray2.MyBillsEntityDataFactory) {
                longSparseArray2.BuiltInFictitiousFunctionClassFactory();
            }
            View view = (View) longSparseArray2.BuiltInFictitiousFunctionClassFactory[i3];
            if (view != null) {
                ViewCompat.PlaceComponentResult(view, false);
            }
            i3++;
        }
        int i4 = 0;
        while (true) {
            LongSparseArray<View> longSparseArray3 = this.mEndValues.KClassImpl$Data$declaredNonStaticMembers$2;
            if (longSparseArray3.MyBillsEntityDataFactory) {
                longSparseArray3.BuiltInFictitiousFunctionClassFactory();
            }
            if (i4 < longSparseArray3.KClassImpl$Data$declaredNonStaticMembers$2) {
                LongSparseArray<View> longSparseArray4 = this.mEndValues.KClassImpl$Data$declaredNonStaticMembers$2;
                if (longSparseArray4.MyBillsEntityDataFactory) {
                    longSparseArray4.BuiltInFictitiousFunctionClassFactory();
                }
                View view2 = (View) longSparseArray4.BuiltInFictitiousFunctionClassFactory[i4];
                if (view2 != null) {
                    ViewCompat.PlaceComponentResult(view2, false);
                }
                i4++;
            } else {
                this.mEnded = true;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void forceToEnd(ViewGroup viewGroup) {
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup == null || size == 0) {
            return;
        }
        WindowIdImpl BuiltInFictitiousFunctionClassFactory = ViewUtils.BuiltInFictitiousFunctionClassFactory(viewGroup);
        ArrayMap arrayMap = new ArrayMap(runningAnimators);
        runningAnimators.clear();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            int i = size << 1;
            AnimationInfo animationInfo = (AnimationInfo) arrayMap.moveToNextValue[i + 1];
            if (animationInfo.KClassImpl$Data$declaredNonStaticMembers$2 != null && BuiltInFictitiousFunctionClassFactory.equals(animationInfo.BuiltInFictitiousFunctionClassFactory)) {
                ((Animator) arrayMap.moveToNextValue[i]).end();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((TransitionListener) arrayList2.get(i)).onTransitionCancel(this);
        }
    }

    public Transition addListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    public Transition removeListener(TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(transitionListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public void setPathMotion(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public void setEpicenterCallback(EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public Rect getEpicenter() {
        EpicenterCallback epicenterCallback = this.mEpicenterCallback;
        if (epicenterCallback == null) {
            return null;
        }
        return epicenterCallback.getAuthRequestContext();
    }

    public void setPropagation(TransitionPropagation transitionPropagation) {
        this.mPropagation = transitionPropagation;
    }

    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void capturePropagationValues(TransitionValues transitionValues) {
        String[] PlaceComponentResult;
        if (this.mPropagation == null || transitionValues.getAuthRequestContext.isEmpty() || (PlaceComponentResult = this.mPropagation.PlaceComponentResult()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= PlaceComponentResult.length) {
                z = true;
                break;
            } else if (!transitionValues.getAuthRequestContext.containsKey(PlaceComponentResult[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.mPropagation.PlaceComponentResult(transitionValues);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public String toString() {
        return toString("");
    }

    @Override // 
    /* renamed from: clone  reason: merged with bridge method [inline-methods] */
    public Transition mo45clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new TransitionValuesMaps();
            transition.mEndValues = new TransitionValuesMaps();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(getClass().getSimpleName());
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        String obj = sb.toString();
        if (this.mDuration != -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append("dur(");
            sb2.append(this.mDuration);
            sb2.append(") ");
            obj = sb2.toString();
        }
        if (this.mStartDelay != -1) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(obj);
            sb3.append("dly(");
            sb3.append(this.mStartDelay);
            sb3.append(") ");
            obj = sb3.toString();
        }
        if (this.mInterpolator != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(obj);
            sb4.append("interp(");
            sb4.append(this.mInterpolator);
            sb4.append(") ");
            obj = sb4.toString();
        }
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(obj);
            sb5.append("tgts(");
            String obj2 = sb5.toString();
            if (this.mTargetIds.size() > 0) {
                for (int i = 0; i < this.mTargetIds.size(); i++) {
                    if (i > 0) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(obj2);
                        sb6.append(", ");
                        obj2 = sb6.toString();
                    }
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(obj2);
                    sb7.append(this.mTargetIds.get(i));
                    obj2 = sb7.toString();
                }
            }
            if (this.mTargets.size() > 0) {
                for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                    if (i2 > 0) {
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append(obj2);
                        sb8.append(", ");
                        obj2 = sb8.toString();
                    }
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(obj2);
                    sb9.append(this.mTargets.get(i2));
                    obj2 = sb9.toString();
                }
            }
            StringBuilder sb10 = new StringBuilder();
            sb10.append(obj2);
            sb10.append(")");
            return sb10.toString();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnimationInfo {
        WindowIdImpl BuiltInFictitiousFunctionClassFactory;
        View KClassImpl$Data$declaredNonStaticMembers$2;
        TransitionValues MyBillsEntityDataFactory;
        String PlaceComponentResult;
        Transition getAuthRequestContext;

        AnimationInfo(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
            this.PlaceComponentResult = str;
            this.MyBillsEntityDataFactory = transitionValues;
            this.BuiltInFictitiousFunctionClassFactory = windowIdImpl;
            this.getAuthRequestContext = transition;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> getAuthRequestContext(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> KClassImpl$Data$declaredNonStaticMembers$2(ArrayList<T> arrayList, T t) {
            if (arrayList != null) {
                arrayList.remove(t);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            }
            return arrayList;
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        if (longSparseArray.MyBillsEntityDataFactory) {
            longSparseArray.BuiltInFictitiousFunctionClassFactory();
        }
        int i = longSparseArray.KClassImpl$Data$declaredNonStaticMembers$2;
        for (int i2 = 0; i2 < i; i2++) {
            if (longSparseArray.MyBillsEntityDataFactory) {
                longSparseArray.BuiltInFictitiousFunctionClassFactory();
            }
            View view = (View) longSparseArray.BuiltInFictitiousFunctionClassFactory[i2];
            if (view != null && isValidTarget(view)) {
                if (longSparseArray.MyBillsEntityDataFactory) {
                    longSparseArray.BuiltInFictitiousFunctionClassFactory();
                }
                View MyBillsEntityDataFactory = longSparseArray2.MyBillsEntityDataFactory(longSparseArray.PlaceComponentResult[i2], null);
                if (MyBillsEntityDataFactory != null && isValidTarget(MyBillsEntityDataFactory)) {
                    TransitionValues transitionValues = arrayMap.get(view);
                    TransitionValues transitionValues2 = arrayMap2.get(MyBillsEntityDataFactory);
                    if (transitionValues != null && transitionValues2 != null) {
                        this.mStartValuesList.add(transitionValues);
                        this.mEndValuesList.add(transitionValues2);
                        arrayMap.remove(view);
                        arrayMap2.remove(MyBillsEntityDataFactory);
                    }
                }
            }
        }
    }
}
