package com.alibaba.griver.ui.titlebar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.griver.ui.R;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class H5SegmentGroup extends RadioGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f6764a;
    private int b;
    private int c;
    private LayoutSelector d;
    private float e;
    private OnItemCheckedChangeListener f;
    private int g;
    private int h;
    private RadioGroup.OnCheckedChangeListener i;

    /* loaded from: classes6.dex */
    public interface OnItemCheckedChangeListener {
        void onCheckedChanged(RadioGroup radioGroup, int i);
    }

    public H5SegmentGroup(Context context) {
        this(context, null);
    }

    public H5SegmentGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -65536;
        this.c = -16711936;
        this.g = -1;
        this.h = -1;
        this.f6764a = (int) getResources().getDimension(R.dimen.griver_nav_segment_stroke_border);
        float dimension = getResources().getDimension(R.dimen.griver_nav_segment_conner_radius);
        this.e = dimension;
        this.d = new LayoutSelector(dimension);
        RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() { // from class: com.alibaba.griver.ui.titlebar.H5SegmentGroup.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (H5SegmentGroup.this.f != null) {
                    RadioButton radioButton = (RadioButton) radioGroup.findViewById(i);
                    if (H5SegmentGroup.this.g == -1) {
                        H5SegmentGroup.this.clearCheck(false);
                    } else {
                        H5SegmentGroup h5SegmentGroup = H5SegmentGroup.this;
                        h5SegmentGroup.checked(h5SegmentGroup.g, false);
                    }
                    H5SegmentGroup.this.h = i;
                    H5SegmentGroup.this.f.onCheckedChanged(radioGroup, radioGroup.indexOfChild(radioButton));
                }
            }
        };
        this.i = onCheckedChangeListener;
        setOnCheckedChangeListener(onCheckedChangeListener);
    }

    @Override // android.widget.RadioGroup, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    public void setSegmentColor(int i, int i2) {
        this.b = i2;
        this.c = i;
    }

    public void addItems(String[] strArr, Integer[] numArr) {
        TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.griverSegmentItemArray);
        for (int i = 0; i < strArr.length; i++) {
            int dip2px = DimensionUtil.dip2px(getContext(), numArr[i].intValue());
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setButtonDrawable((Drawable) null);
            radioButton.setGravity(17);
            radioButton.setText(strArr[i]);
            radioButton.setEllipsize(TextUtils.TruncateAt.END);
            radioButton.setMaxLines(1);
            radioButton.setPadding(0, 0, 0, 0);
            radioButton.setTextSize(2, 16.0f);
            radioButton.setId(obtainTypedArray.getResourceId(i, 0));
            addView(radioButton, new RadioGroup.LayoutParams(dip2px, -1));
        }
        obtainTypedArray.recycle();
        a();
    }

    private void a() {
        int childCount = super.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            a(childAt);
            if (i == childCount - 1) {
                return;
            }
            RadioGroup.LayoutParams layoutParams = (RadioGroup.LayoutParams) childAt.getLayoutParams();
            RadioGroup.LayoutParams layoutParams2 = new RadioGroup.LayoutParams(layoutParams.width, layoutParams.height, layoutParams.weight);
            if (getOrientation() == 0) {
                layoutParams2.setMargins(0, 0, -this.f6764a, 0);
            } else {
                layoutParams2.setMargins(0, 0, 0, -this.f6764a);
            }
            childAt.setLayoutParams(layoutParams2);
        }
    }

    public void clearCheck(boolean z) {
        if (z) {
            clearCheck();
            return;
        }
        setOnCheckedChangeListener(null);
        clearCheck();
        setOnCheckedChangeListener(this.i);
    }

    public void checked(int i, boolean z) {
        if (z) {
            check(i);
            return;
        }
        setOnCheckedChangeListener(null);
        check(i);
        setOnCheckedChangeListener(this.i);
    }

    public void setDefaultChecked(int i) {
        RadioButton radioButton = (RadioButton) getChildAt(i);
        if (radioButton != null) {
            int id2 = radioButton.getId();
            this.g = id2;
            checked(id2, false);
        }
    }

    private void a(View view) {
        Drawable mutate;
        Drawable mutate2;
        int checked = this.d.getChecked();
        int unChecked = this.d.getUnChecked();
        ((Button) view).setTextColor(new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{16842912}}, new int[]{this.b, this.c}));
        if (Build.VERSION.SDK_INT > 21) {
            mutate = getResources().getDrawable(checked, null).mutate();
            mutate2 = getResources().getDrawable(unChecked, null).mutate();
        } else {
            mutate = InstrumentInjector.Resources_getDrawable(getResources(), checked).mutate();
            mutate2 = InstrumentInjector.Resources_getDrawable(getResources(), unChecked).mutate();
        }
        GradientDrawable gradientDrawable = (GradientDrawable) mutate;
        gradientDrawable.setColor(this.b);
        gradientDrawable.setStroke(this.f6764a, this.c);
        gradientDrawable.setCornerRadii(this.d.getChildRadii(view));
        GradientDrawable gradientDrawable2 = (GradientDrawable) mutate2;
        gradientDrawable2.setColor(this.c);
        gradientDrawable2.setStroke(this.f6764a, this.c);
        gradientDrawable2.setCornerRadii(this.d.getChildRadii(view));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, mutate);
        stateListDrawable.addState(new int[]{-16842912}, mutate2);
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(stateListDrawable);
        } else {
            view.setBackgroundDrawable(stateListDrawable);
        }
    }

    public void performLastItemChecked(boolean z) {
        if (z) {
            int i = this.g;
            if (i != -1) {
                checked(i, false);
                return;
            }
            return;
        }
        checked(this.h, false);
        this.g = this.h;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setEnabled(z);
        }
    }

    public void setItemChangeListener(OnItemCheckedChangeListener onItemCheckedChangeListener) {
        this.f = onItemCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class LayoutSelector {

        /* renamed from: a  reason: collision with root package name */
        private final int f6765a = R.drawable.griver_ui_nav_segment_item_checked;
        private final int b = R.drawable.griver_ui_nav_segment_item_unchecked;
        private final float c;
        private final float[] d;
        private final float[] e;
        private final float[] f;
        private final float[] g;
        private int h;
        private int i;
        private float j;
        private float[] k;

        public LayoutSelector(float f) {
            float applyDimension = TypedValue.applyDimension(1, 0.1f, H5SegmentGroup.this.getResources().getDisplayMetrics());
            this.c = applyDimension;
            this.h = -1;
            this.i = -1;
            this.j = f;
            this.d = new float[]{f, f, applyDimension, applyDimension, applyDimension, applyDimension, f, f};
            this.e = new float[]{applyDimension, applyDimension, f, f, f, f, applyDimension, applyDimension};
            this.f = new float[]{applyDimension, applyDimension, applyDimension, applyDimension, applyDimension, applyDimension, applyDimension, applyDimension};
            this.g = new float[]{f, f, f, f, f, f, f, f};
        }

        private int a() {
            return H5SegmentGroup.this.getChildCount();
        }

        private int a(View view) {
            return H5SegmentGroup.this.indexOfChild(view);
        }

        private void a(int i, int i2) {
            if (this.h == i && this.i == i2) {
                return;
            }
            this.h = i;
            this.i = i2;
            if (i == 1) {
                this.k = this.g;
            } else if (i2 == 0) {
                this.k = this.d;
            } else if (i2 == i - 1) {
                this.k = this.e;
            } else {
                this.k = this.f;
            }
        }

        public int getChecked() {
            return this.f6765a;
        }

        public int getUnChecked() {
            return this.b;
        }

        public float[] getChildRadii(View view) {
            a(a(), a(view));
            return this.k;
        }
    }
}
