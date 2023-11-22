package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;
import com.fullstory.instrumentation.FSDraw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class ReactiveGuide extends View implements SharedValues.SharedValuesListener, FSDraw {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private int getAuthRequestContext;

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }

    public ReactiveGuide(Context context) {
        super(context);
        this.getAuthRequestContext = -1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.MyBillsEntityDataFactory = 0;
        this.BuiltInFictitiousFunctionClassFactory = true;
        super.setVisibility(8);
        getAuthRequestContext(null);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.getAuthRequestContext = -1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.MyBillsEntityDataFactory = 0;
        this.BuiltInFictitiousFunctionClassFactory = true;
        super.setVisibility(8);
        getAuthRequestContext(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.getAuthRequestContext = -1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.MyBillsEntityDataFactory = 0;
        this.BuiltInFictitiousFunctionClassFactory = true;
        super.setVisibility(8);
        getAuthRequestContext(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.getAuthRequestContext = -1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.MyBillsEntityDataFactory = 0;
        this.BuiltInFictitiousFunctionClassFactory = true;
        super.setVisibility(8);
        getAuthRequestContext(attributeSet);
    }

    private void getAuthRequestContext(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FlowableKt$toIterable$1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.rotateTo) {
                    this.getAuthRequestContext = obtainStyledAttributes.getResourceId(index, this.getAuthRequestContext);
                } else if (index == R.styleable.FlowableConcatMapEagerPublisher) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getBoolean(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (index == R.styleable.isRegionMiniProgram) {
                    this.MyBillsEntityDataFactory = obtainStyledAttributes.getResourceId(index, this.MyBillsEntityDataFactory);
                } else if (index == R.styleable.getFontAssetManager) {
                    this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getBoolean(index, this.BuiltInFictitiousFunctionClassFactory);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.getAuthRequestContext != -1) {
            ConstraintLayout.getSharedValues().getAuthRequestContext(this.getAuthRequestContext, this);
        }
    }

    public int getAttributeId() {
        return this.getAuthRequestContext;
    }

    public void setAttributeId(int i) {
        HashSet<WeakReference<SharedValues.SharedValuesListener>> hashSet;
        SharedValues sharedValues = ConstraintLayout.getSharedValues();
        int i2 = this.getAuthRequestContext;
        if (i2 != -1 && (hashSet = sharedValues.PlaceComponentResult.get(Integer.valueOf(i2))) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<WeakReference<SharedValues.SharedValuesListener>> it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference<SharedValues.SharedValuesListener> next = it.next();
                SharedValues.SharedValuesListener sharedValuesListener = next.get();
                if (sharedValuesListener == null || sharedValuesListener == this) {
                    arrayList.add(next);
                }
            }
            hashSet.removeAll(arrayList);
        }
        this.getAuthRequestContext = i;
        if (i != -1) {
            sharedValues.getAuthRequestContext(i, this);
        }
    }

    public int getApplyToConstraintSetId() {
        return this.MyBillsEntityDataFactory;
    }

    public void setApplyToConstraintSetId(int i) {
        this.MyBillsEntityDataFactory = i;
    }

    public boolean isAnimatingChange() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void setAnimateChange(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.whenAvailable = i;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.getSupportButtonTintMode = i;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.SubSequence = f;
        setLayoutParams(layoutParams);
    }

    public void onNewValue(int i, int i2, int i3) {
        setGuidelineBegin(i2);
        int id2 = getId();
        if (id2 > 0 && (getParent() instanceof MotionLayout)) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            int currentState = motionLayout.getCurrentState();
            int i4 = this.MyBillsEntityDataFactory;
            if (i4 != 0) {
                currentState = i4;
            }
            int i5 = 0;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (this.BuiltInFictitiousFunctionClassFactory) {
                    int[] constraintSetIds = motionLayout.getConstraintSetIds();
                    while (i5 < constraintSetIds.length) {
                        int i6 = constraintSetIds[i5];
                        if (i6 != currentState) {
                            ConstraintSet constraintSet = motionLayout.getConstraintSet(i6);
                            constraintSet.BuiltInFictitiousFunctionClassFactory(id2, i2);
                            motionLayout.updateState(i6, constraintSet);
                        }
                        i5++;
                    }
                }
                ConstraintSet cloneConstraintSet = motionLayout.cloneConstraintSet(currentState);
                cloneConstraintSet.BuiltInFictitiousFunctionClassFactory(id2, i2);
                motionLayout.updateStateAnimate(currentState, cloneConstraintSet, 1000);
            } else if (this.BuiltInFictitiousFunctionClassFactory) {
                int[] constraintSetIds2 = motionLayout.getConstraintSetIds();
                while (i5 < constraintSetIds2.length) {
                    int i7 = constraintSetIds2[i5];
                    ConstraintSet constraintSet2 = motionLayout.getConstraintSet(i7);
                    constraintSet2.BuiltInFictitiousFunctionClassFactory(id2, i2);
                    motionLayout.updateState(i7, constraintSet2);
                    i5++;
                }
            } else {
                ConstraintSet constraintSet3 = motionLayout.getConstraintSet(currentState);
                constraintSet3.BuiltInFictitiousFunctionClassFactory(id2, i2);
                motionLayout.updateState(currentState, constraintSet3);
            }
        }
    }
}
