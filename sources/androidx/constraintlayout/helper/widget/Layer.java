package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Layer extends ConstraintHelper {
    private float BuiltInFictitiousFunctionClassFactory;
    private float KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private float PlaceComponentResult;
    private boolean getAuthRequestContext;
    private float getErrorConfigVersion;
    private float lookAheadTest;
    protected float mComputedCenterX;
    protected float mComputedCenterY;
    protected float mComputedMaxX;
    protected float mComputedMaxY;
    protected float mComputedMinX;
    protected float mComputedMinY;
    ConstraintLayout mContainer;
    boolean mNeedBounds;
    View[] mViews;
    private float moveToNextValue;
    private float scheduleImpl;

    public Layer(Context context) {
        super(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Float.NaN;
        this.BuiltInFictitiousFunctionClassFactory = Float.NaN;
        this.PlaceComponentResult = Float.NaN;
        this.scheduleImpl = 1.0f;
        this.getErrorConfigVersion = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.moveToNextValue = 0.0f;
        this.lookAheadTest = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Float.NaN;
        this.BuiltInFictitiousFunctionClassFactory = Float.NaN;
        this.PlaceComponentResult = Float.NaN;
        this.scheduleImpl = 1.0f;
        this.getErrorConfigVersion = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.moveToNextValue = 0.0f;
        this.lookAheadTest = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Float.NaN;
        this.BuiltInFictitiousFunctionClassFactory = Float.NaN;
        this.PlaceComponentResult = Float.NaN;
        this.scheduleImpl = 1.0f;
        this.getErrorConfigVersion = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.moveToNextValue = 0.0f;
        this.lookAheadTest = 0.0f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BottomSheetCardBindingView$watcherCardNumberView$1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.AppCompatEmojiTextHelper) {
                    this.getAuthRequestContext = true;
                } else if (index == R.styleable.A) {
                    this.MyBillsEntityDataFactory = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = (ConstraintLayout) getParent();
        if (this.getAuthRequestContext || this.MyBillsEntityDataFactory) {
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i = 0; i < this.mCount; i++) {
                View viewById = this.mContainer.getViewById(this.mIds[i]);
                if (viewById != null) {
                    if (this.getAuthRequestContext) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.MyBillsEntityDataFactory && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreDraw(ConstraintLayout constraintLayout) {
        this.mContainer = constraintLayout;
        float rotation = getRotation();
        if (rotation == 0.0f && Float.isNaN(this.PlaceComponentResult)) {
            return;
        }
        this.PlaceComponentResult = rotation;
    }

    @Override // android.view.View
    public void setRotation(float f) {
        this.PlaceComponentResult = f;
        getAuthRequestContext();
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        this.scheduleImpl = f;
        getAuthRequestContext();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        this.getErrorConfigVersion = f;
        getAuthRequestContext();
    }

    @Override // android.view.View
    public void setPivotX(float f) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        getAuthRequestContext();
    }

    @Override // android.view.View
    public void setPivotY(float f) {
        this.BuiltInFictitiousFunctionClassFactory = f;
        getAuthRequestContext();
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        this.moveToNextValue = f;
        getAuthRequestContext();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        this.lookAheadTest = f;
        getAuthRequestContext();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout constraintLayout) {
        MyBillsEntityDataFactory();
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        ConstraintWidget constraintWidget = ((ConstraintLayout.LayoutParams) getLayoutParams()).c;
        constraintWidget.getErrorConfigVersion(0);
        constraintWidget.lookAheadTest(0);
        calcCenters();
        layout(((int) this.mComputedMinX) - getPaddingLeft(), ((int) this.mComputedMinY) - getPaddingTop(), ((int) this.mComputedMaxX) + getPaddingRight(), ((int) this.mComputedMaxY) + getPaddingBottom());
        getAuthRequestContext();
    }

    private void MyBillsEntityDataFactory() {
        if (this.mContainer == null || this.mCount == 0) {
            return;
        }
        View[] viewArr = this.mViews;
        if (viewArr == null || viewArr.length != this.mCount) {
            this.mViews = new View[this.mCount];
        }
        for (int i = 0; i < this.mCount; i++) {
            this.mViews[i] = this.mContainer.getViewById(this.mIds[i]);
        }
    }

    protected void calcCenters() {
        if (this.mContainer == null) {
            return;
        }
        if (this.mNeedBounds || Float.isNaN(this.mComputedCenterX) || Float.isNaN(this.mComputedCenterY)) {
            if (Float.isNaN(this.KClassImpl$Data$declaredNonStaticMembers$2) || Float.isNaN(this.BuiltInFictitiousFunctionClassFactory)) {
                View[] views = getViews(this.mContainer);
                int left = views[0].getLeft();
                int top = views[0].getTop();
                int right = views[0].getRight();
                int bottom = views[0].getBottom();
                for (int i = 0; i < this.mCount; i++) {
                    View view = views[i];
                    left = Math.min(left, view.getLeft());
                    top = Math.min(top, view.getTop());
                    right = Math.max(right, view.getRight());
                    bottom = Math.max(bottom, view.getBottom());
                }
                this.mComputedMaxX = right;
                this.mComputedMaxY = bottom;
                this.mComputedMinX = left;
                this.mComputedMinY = top;
                if (Float.isNaN(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    this.mComputedCenterX = (left + right) / 2;
                } else {
                    this.mComputedCenterX = this.KClassImpl$Data$declaredNonStaticMembers$2;
                }
                if (Float.isNaN(this.BuiltInFictitiousFunctionClassFactory)) {
                    this.mComputedCenterY = (top + bottom) / 2;
                    return;
                } else {
                    this.mComputedCenterY = this.BuiltInFictitiousFunctionClassFactory;
                    return;
                }
            }
            this.mComputedCenterY = this.BuiltInFictitiousFunctionClassFactory;
            this.mComputedCenterX = this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    private void getAuthRequestContext() {
        if (this.mContainer == null) {
            return;
        }
        if (this.mViews == null) {
            MyBillsEntityDataFactory();
        }
        calcCenters();
        double radians = Float.isNaN(this.PlaceComponentResult) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : Math.toRadians(this.PlaceComponentResult);
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        float f = this.scheduleImpl;
        float f2 = this.getErrorConfigVersion;
        float f3 = -f2;
        for (int i = 0; i < this.mCount; i++) {
            View view = this.mViews[i];
            int left = (view.getLeft() + view.getRight()) / 2;
            int top = (view.getTop() + view.getBottom()) / 2;
            float f4 = left - this.mComputedCenterX;
            float f5 = top - this.mComputedCenterY;
            float f6 = this.moveToNextValue;
            float f7 = this.lookAheadTest;
            view.setTranslationX(((((f * cos) * f4) + ((f3 * sin) * f5)) - f4) + f6);
            view.setTranslationY((((f4 * (f * sin)) + ((f2 * cos) * f5)) - f5) + f7);
            view.setScaleY(this.getErrorConfigVersion);
            view.setScaleX(this.scheduleImpl);
            if (!Float.isNaN(this.PlaceComponentResult)) {
                view.setRotation(this.PlaceComponentResult);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout constraintLayout) {
        applyLayoutFeatures(constraintLayout);
    }
}
