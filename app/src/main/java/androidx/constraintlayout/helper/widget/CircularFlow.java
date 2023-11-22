package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class CircularFlow extends VirtualLayout {
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    private static float getAuthRequestContext;
    private int BuiltInFictitiousFunctionClassFactory;
    private int MyBillsEntityDataFactory;
    private int[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private float[] PlaceComponentResult;
    private Integer getErrorConfigVersion;
    private String lookAheadTest;
    ConstraintLayout mContainer;
    int mViewCenter;
    private String moveToNextValue;
    private Float scheduleImpl;

    public CircularFlow(Context context) {
        super(context);
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.MyBillsEntityDataFactory);
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BottomSheetCardBindingView$watcherCardNumberView$1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.O) {
                    this.mViewCenter = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R.styleable.M) {
                    String string = obtainStyledAttributes.getString(index);
                    this.lookAheadTest = string;
                    PlaceComponentResult(string);
                } else if (index == R.styleable.P) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.moveToNextValue = string2;
                    MyBillsEntityDataFactory(string2);
                } else if (index == R.styleable.L) {
                    Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, getAuthRequestContext));
                    this.scheduleImpl = valueOf;
                    setDefaultAngle(valueOf.floatValue());
                } else if (index == R.styleable.Q) {
                    Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, KClassImpl$Data$declaredNonStaticMembers$2));
                    this.getErrorConfigVersion = valueOf2;
                    setDefaultRadius(valueOf2.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.lookAheadTest;
        if (str != null) {
            this.PlaceComponentResult = new float[1];
            PlaceComponentResult(str);
        }
        String str2 = this.moveToNextValue;
        if (str2 != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new int[1];
            MyBillsEntityDataFactory(str2);
        }
        Float f = this.scheduleImpl;
        if (f != null) {
            setDefaultAngle(f.floatValue());
        }
        Integer num = this.getErrorConfigVersion;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        BuiltInFictitiousFunctionClassFactory();
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        this.mContainer = (ConstraintLayout) getParent();
        for (int i = 0; i < this.mCount; i++) {
            View viewById = this.mContainer.getViewById(this.mIds[i]);
            if (viewById != null) {
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2;
                float f = getAuthRequestContext;
                int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (iArr != null && i < iArr.length) {
                    i2 = iArr[i];
                } else {
                    Integer num = this.getErrorConfigVersion;
                    if (num != null && num.intValue() != -1) {
                        this.MyBillsEntityDataFactory++;
                        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new int[1];
                        }
                        int[] radius = getRadius();
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = radius;
                        radius[this.MyBillsEntityDataFactory - 1] = i2;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Added radius to view with id: ");
                        sb.append(this.mMap.get(Integer.valueOf(viewById.getId())));
                        InstrumentInjector.log_e("CircularFlow", sb.toString());
                    }
                }
                float[] fArr = this.PlaceComponentResult;
                if (fArr != null && i < fArr.length) {
                    f = fArr[i];
                } else {
                    Float f2 = this.scheduleImpl;
                    if (f2 != null && f2.floatValue() != -1.0f) {
                        this.BuiltInFictitiousFunctionClassFactory++;
                        if (this.PlaceComponentResult == null) {
                            this.PlaceComponentResult = new float[1];
                        }
                        float[] angles = getAngles();
                        this.PlaceComponentResult = angles;
                        angles[this.BuiltInFictitiousFunctionClassFactory - 1] = f;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Added angle to view with id: ");
                        sb2.append(this.mMap.get(Integer.valueOf(viewById.getId())));
                        InstrumentInjector.log_e("CircularFlow", sb2.toString());
                    }
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewById.getLayoutParams();
                layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda0 = f;
                layoutParams.scheduleImpl = this.mViewCenter;
                layoutParams.getErrorConfigVersion = i2;
                viewById.setLayoutParams(layoutParams);
            }
        }
        applyLayoutFeatures();
    }

    public void addViewToCircularFlow(View view, int i, float f) {
        if (containsId(view.getId())) {
            return;
        }
        addView(view);
        this.BuiltInFictitiousFunctionClassFactory++;
        float[] angles = getAngles();
        this.PlaceComponentResult = angles;
        angles[this.BuiltInFictitiousFunctionClassFactory - 1] = f;
        this.MyBillsEntityDataFactory++;
        int[] radius = getRadius();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = radius;
        radius[this.MyBillsEntityDataFactory - 1] = (int) (i * this.myContext.getResources().getDisplayMetrics().density);
        BuiltInFictitiousFunctionClassFactory();
    }

    public void updateRadius(View view, int i) {
        if (!isUpdatable(view)) {
            StringBuilder sb = new StringBuilder();
            sb.append("It was not possible to update radius to view with id: ");
            sb.append(view.getId());
            InstrumentInjector.log_e("CircularFlow", sb.toString());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId > this.NetworkUserEntityData$$ExternalSyntheticLambda0.length) {
            return;
        }
        int[] radius = getRadius();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = radius;
        radius[indexFromId] = (int) (i * this.myContext.getResources().getDisplayMetrics().density);
        BuiltInFictitiousFunctionClassFactory();
    }

    public void updateAngle(View view, float f) {
        if (!isUpdatable(view)) {
            StringBuilder sb = new StringBuilder();
            sb.append("It was not possible to update angle to view with id: ");
            sb.append(view.getId());
            InstrumentInjector.log_e("CircularFlow", sb.toString());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId > this.PlaceComponentResult.length) {
            return;
        }
        float[] angles = getAngles();
        this.PlaceComponentResult = angles;
        angles[indexFromId] = f;
        BuiltInFictitiousFunctionClassFactory();
    }

    public void updateReference(View view, int i, float f) {
        if (!isUpdatable(view)) {
            StringBuilder sb = new StringBuilder();
            sb.append("It was not possible to update radius and angle to view with id: ");
            sb.append(view.getId());
            InstrumentInjector.log_e("CircularFlow", sb.toString());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (getAngles().length > indexFromId) {
            float[] angles = getAngles();
            this.PlaceComponentResult = angles;
            angles[indexFromId] = f;
        }
        if (getRadius().length > indexFromId) {
            int[] radius = getRadius();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = radius;
            radius[indexFromId] = (int) (i * this.myContext.getResources().getDisplayMetrics().density);
        }
        BuiltInFictitiousFunctionClassFactory();
    }

    public void setDefaultAngle(float f) {
        getAuthRequestContext = f;
    }

    public void setDefaultRadius(int i) {
        KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public int removeView(View view) {
        int removeView = super.removeView(view);
        if (removeView == -1) {
            return removeView;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.getAuthRequestContext(this.mContainer);
        constraintSet.MyBillsEntityDataFactory(view.getId(), 8);
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(this.mContainer);
        float[] fArr = this.PlaceComponentResult;
        if (removeView < fArr.length) {
            if (fArr != null && removeView >= 0 && removeView < this.BuiltInFictitiousFunctionClassFactory) {
                fArr = removeElementFromArray(fArr, removeView);
            }
            this.PlaceComponentResult = fArr;
            this.BuiltInFictitiousFunctionClassFactory--;
        }
        int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (removeView < iArr.length) {
            if (iArr != null && removeView >= 0 && removeView < this.MyBillsEntityDataFactory) {
                iArr = removeElementFromArray(iArr, removeView);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = iArr;
            this.MyBillsEntityDataFactory--;
        }
        BuiltInFictitiousFunctionClassFactory();
        return removeView;
    }

    private void PlaceComponentResult(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        this.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                getAuthRequestContext(str.substring(i).trim());
                return;
            } else {
                getAuthRequestContext(str.substring(i, indexOf).trim());
                i = indexOf + 1;
            }
        }
    }

    private void MyBillsEntityDataFactory(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        this.MyBillsEntityDataFactory = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                BuiltInFictitiousFunctionClassFactory(str.substring(i).trim());
                return;
            } else {
                BuiltInFictitiousFunctionClassFactory(str.substring(i, indexOf).trim());
                i = indexOf + 1;
            }
        }
    }

    private void getAuthRequestContext(String str) {
        float[] fArr;
        if (str == null || str.length() == 0 || this.myContext == null || (fArr = this.PlaceComponentResult) == null) {
            return;
        }
        if (this.BuiltInFictitiousFunctionClassFactory + 1 > fArr.length) {
            this.PlaceComponentResult = Arrays.copyOf(fArr, fArr.length + 1);
        }
        this.PlaceComponentResult[this.BuiltInFictitiousFunctionClassFactory] = Integer.parseInt(str);
        this.BuiltInFictitiousFunctionClassFactory++;
    }

    private void BuiltInFictitiousFunctionClassFactory(String str) {
        int[] iArr;
        if (str == null || str.length() == 0 || this.myContext == null || (iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
            return;
        }
        if (this.MyBillsEntityDataFactory + 1 > iArr.length) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Arrays.copyOf(iArr, iArr.length + 1);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0[this.MyBillsEntityDataFactory] = (int) (Integer.parseInt(str) * this.myContext.getResources().getDisplayMetrics().density);
        this.MyBillsEntityDataFactory++;
    }

    public static int[] removeElementFromArray(int[] iArr, int i) {
        int[] iArr2 = new int[iArr.length - 1];
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (i3 != i) {
                iArr2[i2] = iArr[i3];
                i2++;
            }
        }
        return iArr2;
    }

    public static float[] removeElementFromArray(float[] fArr, int i) {
        float[] fArr2 = new float[fArr.length - 1];
        int i2 = 0;
        for (int i3 = 0; i3 < fArr.length; i3++) {
            if (i3 != i) {
                fArr2[i2] = fArr[i3];
                i2++;
            }
        }
        return fArr2;
    }

    public boolean isUpdatable(View view) {
        return containsId(view.getId()) && indexFromId(view.getId()) != -1;
    }
}
