package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class ConstraintHelper extends View {
    private View[] BuiltInFictitiousFunctionClassFactory;
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds;
    protected HashMap<Integer, String> mMap;
    protected String mReferenceIds;
    protected String mReferenceTags;
    protected boolean mUseViewMeasure;
    protected Context myContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    public ConstraintHelper(Context context) {
        super(context);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BottomSheetCardBindingView$watcherCardNumberView$1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.SummaryVoucherView$$ExternalSyntheticLambda0) {
                    String string = obtainStyledAttributes.getString(index);
                    this.mReferenceIds = string;
                    setIds(string);
                } else if (index == R.styleable.SummaryVoucherView$$ExternalSyntheticLambda2) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.mReferenceTags = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.mReferenceIds;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.mReferenceTags;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public void addView(View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            InstrumentInjector.log_e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        } else if (view.getParent() == null) {
            InstrumentInjector.log_e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
        } else {
            this.mReferenceIds = null;
            KClassImpl$Data$declaredNonStaticMembers$2(view.getId());
            requestLayout();
        }
    }

    public int removeView(View view) {
        int i;
        int id2 = view.getId();
        int i2 = -1;
        if (id2 == -1) {
            return -1;
        }
        this.mReferenceIds = null;
        int i3 = 0;
        while (true) {
            if (i3 >= this.mCount) {
                break;
            } else if (this.mIds[i3] == id2) {
                int i4 = i3;
                while (true) {
                    i = this.mCount - 1;
                    if (i4 >= i) {
                        break;
                    }
                    int[] iArr = this.mIds;
                    int i5 = i4 + 1;
                    iArr[i4] = iArr[i5];
                    i4 = i5;
                }
                this.mIds[i] = 0;
                this.mCount = i;
                i2 = i3;
            } else {
                i3++;
            }
        }
        requestLayout();
        return i2;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    public void setReferencedIds(int[] iArr) {
        this.mReferenceIds = null;
        this.mCount = 0;
        for (int i : iArr) {
            KClassImpl$Data$declaredNonStaticMembers$2(i);
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.mCount;
        int[] iArr = this.mIds;
        if (i2 + 1 > iArr.length) {
            this.mIds = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.mIds;
        int i3 = this.mCount;
        iArr2[i3] = i;
        this.mCount = i3 + 1;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mUseViewMeasure) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void validateParams() {
        if (this.mHelperWidget == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).c = (ConstraintWidget) this.mHelperWidget;
        }
    }

    private void getAuthRequestContext(String str) {
        if (str == null || str.length() == 0 || this.myContext == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        }
        int MyBillsEntityDataFactory = MyBillsEntityDataFactory(trim);
        if (MyBillsEntityDataFactory != 0) {
            this.mMap.put(Integer.valueOf(MyBillsEntityDataFactory), trim);
            KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not find id of \"");
        sb.append(trim);
        sb.append("\"");
        InstrumentInjector.log_w("ConstraintHelper", sb.toString());
    }

    private void PlaceComponentResult(String str) {
        if (str == null || str.length() == 0 || this.myContext == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            InstrumentInjector.log_w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).DatabaseTableConfigUtil)) {
                if (childAt.getId() == -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("to use ConstraintTag view ");
                    sb.append(childAt.getClass().getSimpleName());
                    sb.append(" must have an ID");
                    InstrumentInjector.log_w("ConstraintHelper", sb.toString());
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$2(childAt.getId());
                }
            }
        }
    }

    private int MyBillsEntityDataFactory(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i = ((Integer) designInformation).intValue();
            }
        }
        if (i == 0 && constraintLayout != null) {
            i = KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout, str);
        }
        if (i == 0) {
            try {
                i = R.id.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return i == 0 ? this.myContext.getResources().getIdentifier(str, "id", this.myContext.getPackageName()) : i;
    }

    private int KClassImpl$Data$declaredNonStaticMembers$2(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.myContext.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    protected void setIds(String str) {
        this.mReferenceIds = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.mCount = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                getAuthRequestContext(str.substring(i));
                return;
            } else {
                getAuthRequestContext(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.mReferenceTags = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.mCount = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                PlaceComponentResult(str.substring(i));
                return;
            } else {
                PlaceComponentResult(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyLayoutFeatures(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i = 0; i < this.mCount; i++) {
            View viewById = constraintLayout.getViewById(this.mIds[i]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyLayoutFeatures() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        applyLayoutFeatures((ConstraintLayout) parent);
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        String str;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        if (isInEditMode()) {
            setIds(this.mReferenceIds);
        }
        Helper helper = this.mHelperWidget;
        if (helper == null) {
            return;
        }
        helper.scheduleImpl();
        for (int i = 0; i < this.mCount; i++) {
            int i2 = this.mIds[i];
            View viewById = constraintLayout.getViewById(i2);
            if (viewById == null && (KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout, (str = this.mMap.get(Integer.valueOf(i2))))) != 0) {
                this.mIds[i] = KClassImpl$Data$declaredNonStaticMembers$2;
                this.mMap.put(Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2), str);
                viewById = constraintLayout.getViewById(KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (viewById != null) {
                this.mHelperWidget.MyBillsEntityDataFactory(constraintLayout.getViewWidget(viewById));
            }
        }
        Helper helper2 = this.mHelperWidget;
        ConstraintWidgetContainer constraintWidgetContainer = constraintLayout.mLayoutWidget;
        helper2.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    public void updatePreLayout(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray<ConstraintWidget> sparseArray) {
        helper.scheduleImpl();
        for (int i = 0; i < this.mCount; i++) {
            helper.MyBillsEntityDataFactory(sparseArray.get(this.mIds[i]));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View[] getViews(ConstraintLayout constraintLayout) {
        View[] viewArr = this.BuiltInFictitiousFunctionClassFactory;
        if (viewArr == null || viewArr.length != this.mCount) {
            this.BuiltInFictitiousFunctionClassFactory = new View[this.mCount];
        }
        for (int i = 0; i < this.mCount; i++) {
            this.BuiltInFictitiousFunctionClassFactory[i] = constraintLayout.getViewById(this.mIds[i]);
        }
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        if (constraint.BuiltInFictitiousFunctionClassFactory.J != null) {
            setReferencedIds(constraint.BuiltInFictitiousFunctionClassFactory.J);
        } else if (constraint.BuiltInFictitiousFunctionClassFactory.L != null) {
            if (constraint.BuiltInFictitiousFunctionClassFactory.L.length() > 0) {
                ConstraintSet.Layout layout = constraint.BuiltInFictitiousFunctionClassFactory;
                String[] split = constraint.BuiltInFictitiousFunctionClassFactory.L.split(",");
                getContext();
                int[] iArr = new int[split.length];
                int i = 0;
                for (String str : split) {
                    int MyBillsEntityDataFactory = MyBillsEntityDataFactory(str.trim());
                    if (MyBillsEntityDataFactory != 0) {
                        iArr[i] = MyBillsEntityDataFactory;
                        i++;
                    }
                }
                if (i != split.length) {
                    iArr = Arrays.copyOf(iArr, i);
                }
                layout.J = iArr;
            } else {
                constraint.BuiltInFictitiousFunctionClassFactory.J = null;
            }
        }
        if (helperWidget != null) {
            helperWidget.FlowableCreate$BufferAsyncEmitter = 0;
            Arrays.fill(helperWidget.z, (Object) null);
            if (constraint.BuiltInFictitiousFunctionClassFactory.J != null) {
                for (int i2 = 0; i2 < constraint.BuiltInFictitiousFunctionClassFactory.J.length; i2++) {
                    ConstraintWidget constraintWidget = sparseArray.get(constraint.BuiltInFictitiousFunctionClassFactory.J[i2]);
                    if (constraintWidget != null) {
                        helperWidget.MyBillsEntityDataFactory(constraintWidget);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.mReferenceIds == null) {
            KClassImpl$Data$declaredNonStaticMembers$2(i);
        }
    }

    public boolean containsId(int i) {
        for (int i2 : this.mIds) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public int indexFromId(int i) {
        int i2 = -1;
        for (int i3 : this.mIds) {
            i2++;
            if (i3 == i) {
                return i2;
            }
        }
        return i2;
    }
}
