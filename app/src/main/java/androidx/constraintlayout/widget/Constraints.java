package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class Constraints extends ViewGroup {
    public static final String TAG = "Constraints";
    ConstraintSet myConstraintSet;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        InstrumentInjector.log_v(TAG, " ################# init");
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        InstrumentInjector.log_v(TAG, " ################# init");
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float FillAnimation;
        public float FlowViewUtil$textChanges$1;
        public float FlowViewUtil$textChanges$2;
        public boolean TypeProjectionImpl;
        public float connectForeground;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public float j;
        public float k;
        public float l;

        public LayoutParams() {
            super(-2);
            this.e = 1.0f;
            this.TypeProjectionImpl = false;
            this.g = 0.0f;
            this.f = 0.0f;
            this.FillAnimation = 0.0f;
            this.FlowViewUtil$textChanges$1 = 0.0f;
            this.connectForeground = 1.0f;
            this.FlowViewUtil$textChanges$2 = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.l = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.e = 1.0f;
            this.TypeProjectionImpl = false;
            this.g = 0.0f;
            this.f = 0.0f;
            this.FillAnimation = 0.0f;
            this.FlowViewUtil$textChanges$1 = 0.0f;
            this.connectForeground = 1.0f;
            this.FlowViewUtil$textChanges$2 = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.l = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.getNrCsiRsrq);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ListenerMethod) {
                    this.e = obtainStyledAttributes.getFloat(index, this.e);
                } else if (index == R.styleable.onLayoutDirectionChanged) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.g = obtainStyledAttributes.getFloat(index, this.g);
                        this.TypeProjectionImpl = true;
                    }
                } else if (index == R.styleable.CreateRemoteWorkerExtension) {
                    this.FillAnimation = obtainStyledAttributes.getFloat(index, this.FillAnimation);
                } else if (index == R.styleable.CreateOrderTopUpFamilyBalance) {
                    this.FlowViewUtil$textChanges$1 = obtainStyledAttributes.getFloat(index, this.FlowViewUtil$textChanges$1);
                } else if (index == R.styleable.ImageWithDescriptionView$showImage$1) {
                    this.f = obtainStyledAttributes.getFloat(index, this.f);
                } else if (index == R.styleable.indexOfAny) {
                    this.connectForeground = obtainStyledAttributes.getFloat(index, this.connectForeground);
                } else if (index == R.styleable.DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider) {
                    this.FlowViewUtil$textChanges$2 = obtainStyledAttributes.getFloat(index, this.FlowViewUtil$textChanges$2);
                } else if (index == R.styleable.access$getServiceItemDecorator$p) {
                    this.h = obtainStyledAttributes.getFloat(index, this.h);
                } else if (index == R.styleable.FamilyManageAvailableServicesAdapter) {
                    this.i = obtainStyledAttributes.getFloat(index, this.i);
                } else if (index == R.styleable.f8$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0) {
                    this.l = obtainStyledAttributes.getFloat(index, this.l);
                } else if (index == R.styleable.KeyEvent$DispatcherState) {
                    this.j = obtainStyledAttributes.getFloat(index, this.j);
                } else if (index == R.styleable.CacheBuilderSpec$AccessDurationParser && Build.VERSION.SDK_INT >= 21) {
                    this.k = obtainStyledAttributes.getFloat(index, this.k);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public ConstraintSet getConstraintSet() {
        if (this.myConstraintSet == null) {
            this.myConstraintSet = new ConstraintSet();
        }
        ConstraintSet constraintSet = this.myConstraintSet;
        int childCount = getChildCount();
        constraintSet.getAuthRequestContext.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (constraintSet.PlaceComponentResult && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!constraintSet.getAuthRequestContext.containsKey(Integer.valueOf(id2))) {
                constraintSet.getAuthRequestContext.put(Integer.valueOf(id2), new ConstraintSet.Constraint());
            }
            ConstraintSet.Constraint constraint = constraintSet.getAuthRequestContext.get(Integer.valueOf(id2));
            if (constraint != null) {
                if (childAt instanceof ConstraintHelper) {
                    ConstraintSet.Constraint.BuiltInFictitiousFunctionClassFactory(constraint, (ConstraintHelper) childAt, id2, layoutParams);
                }
                constraint.KClassImpl$Data$declaredNonStaticMembers$2(id2, layoutParams);
            }
        }
        return this.myConstraintSet;
    }
}
