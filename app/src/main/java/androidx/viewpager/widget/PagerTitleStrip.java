package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.flexbox.FlexItem;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.DecorView
/* loaded from: classes6.dex */
public class PagerTitleStrip extends ViewGroup {
    private int BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private WeakReference<PagerAdapter> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    private boolean getErrorConfigVersion;
    private int lookAheadTest;
    TextView mCurrText;
    float mLastKnownPositionOffset;
    TextView mNextText;
    ViewPager mPager;
    TextView mPrevText;
    int mTextColor;
    private final PageListener moveToNextValue;
    private boolean scheduleImpl;
    private static final int[] getAuthRequestContext = {16842804, 16842901, 16842904, 16842927};
    private static final int[] MyBillsEntityDataFactory = {16843660};

    /* loaded from: classes6.dex */
    static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private Locale BuiltInFictitiousFunctionClassFactory;

        SingleLineAllCapsTransform(Context context) {
            this.BuiltInFictitiousFunctionClassFactory = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.BuiltInFictitiousFunctionClassFactory);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.moveToNextValue = new PageListener();
        TextView textView = new TextView(context);
        this.mPrevText = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.mCurrText = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.mNextText = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, getAuthRequestContext);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.mPrevText, resourceId);
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.mCurrText, resourceId);
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.mNextText, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.mPrevText.setTextColor(color);
            this.mCurrText.setTextColor(color);
            this.mNextText.setTextColor(color);
        }
        this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
        this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
        this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, MyBillsEntityDataFactory);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            TextView textView4 = this.mPrevText;
            textView4.setTransformationMethod(new SingleLineAllCapsTransform(textView4.getContext()));
            TextView textView5 = this.mCurrText;
            textView5.setTransformationMethod(new SingleLineAllCapsTransform(textView5.getContext()));
            TextView textView6 = this.mNextText;
            textView6.setTransformationMethod(new SingleLineAllCapsTransform(textView6.getContext()));
        } else {
            this.mPrevText.setSingleLine();
            this.mCurrText.setSingleLine();
            this.mNextText.setSingleLine();
        }
        this.lookAheadTest = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i) {
        this.lookAheadTest = i;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.lookAheadTest;
    }

    public void setNonPrimaryAlpha(float f) {
        int i = ((int) (f * 255.0f)) & 255;
        this.PlaceComponentResult = i;
        int i2 = (i << 24) | (this.mTextColor & FlexItem.MAX_SIZE);
        this.mPrevText.setTextColor(i2);
        this.mNextText.setTextColor(i2);
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        this.mCurrText.setTextColor(i);
        int i2 = (this.PlaceComponentResult << 24) | (this.mTextColor & FlexItem.MAX_SIZE);
        this.mPrevText.setTextColor(i2);
        this.mNextText.setTextColor(i2);
    }

    public void setTextSize(int i, float f) {
        this.mPrevText.setTextSize(i, f);
        this.mCurrText.setTextSize(i, f);
        this.mNextText.setTextSize(i, f);
    }

    public void setGravity(int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        PagerAdapter adapter = viewPager.getAdapter();
        viewPager.setInternalPageChangeListener(this.moveToNextValue);
        viewPager.addOnAdapterChangeListener(this.moveToNextValue);
        this.mPager = viewPager;
        WeakReference<PagerAdapter> weakReference = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        updateAdapter(weakReference != null ? weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            updateAdapter(viewPager.getAdapter(), null);
            this.mPager.setInternalPageChangeListener(null);
            this.mPager.removeOnAdapterChangeListener(this.moveToNextValue);
            this.mPager = null;
        }
    }

    void updateText(int i, PagerAdapter pagerAdapter) {
        int count = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.scheduleImpl = true;
        CharSequence charSequence = null;
        this.mPrevText.setText((i <= 0 || pagerAdapter == null) ? null : pagerAdapter.getPageTitle(i - 1));
        this.mCurrText.setText((pagerAdapter == null || i >= count) ? null : pagerAdapter.getPageTitle(i));
        int i2 = i + 1;
        if (i2 < count && pagerAdapter != null) {
            charSequence = pagerAdapter.getPageTitle(i2);
        }
        this.mNextText.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.mPrevText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mCurrText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mNextText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        if (!this.getErrorConfigVersion) {
            updateTextPositions(i, this.mLastKnownPositionOffset, false);
        }
        this.scheduleImpl = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.scheduleImpl) {
            return;
        }
        super.requestLayout();
    }

    void updateAdapter(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.moveToNextValue);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.moveToNextValue);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            this.mLastKnownPositionOffset = -1.0f;
            updateText(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateTextPositions(int i, float f, boolean z) {
        if (i != this.KClassImpl$Data$declaredNonStaticMembers$2) {
            updateText(i, this.mPager.getAdapter());
        } else if (!z && f == this.mLastKnownPositionOffset) {
            return;
        }
        this.getErrorConfigVersion = true;
        int measuredWidth = this.mPrevText.getMeasuredWidth();
        int measuredWidth2 = this.mCurrText.getMeasuredWidth();
        int measuredWidth3 = this.mNextText.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        int i4 = ((width - i3) - ((int) (((width - (paddingLeft + i2)) - i3) * f2))) - i2;
        int i5 = measuredWidth2 + i4;
        int baseline = this.mPrevText.getBaseline();
        int baseline2 = this.mCurrText.getBaseline();
        int baseline3 = this.mNextText.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i6 = max - baseline;
        int i7 = max - baseline2;
        int i8 = max - baseline3;
        int max2 = Math.max(Math.max(this.mPrevText.getMeasuredHeight() + i6, this.mCurrText.getMeasuredHeight() + i7), this.mNextText.getMeasuredHeight() + i8);
        int i9 = this.BuiltInFictitiousFunctionClassFactory & 112;
        if (i9 == 16) {
            paddingTop = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i9 == 80) {
            paddingTop = (height - paddingBottom) - max2;
        }
        int i10 = i6 + paddingTop;
        int i11 = i7 + paddingTop;
        int i12 = paddingTop + i8;
        TextView textView = this.mCurrText;
        textView.layout(i4, i11, i5, textView.getMeasuredHeight() + i11);
        int min = Math.min(paddingLeft, (i4 - this.lookAheadTest) - measuredWidth);
        TextView textView2 = this.mPrevText;
        textView2.layout(min, i10, measuredWidth + min, textView2.getMeasuredHeight() + i10);
        int max3 = Math.max((width - paddingRight) - measuredWidth3, i5 + this.lookAheadTest);
        TextView textView3 = this.mNextText;
        textView3.layout(max3, i12, max3 + measuredWidth3, textView3.getMeasuredHeight() + i12);
        this.mLastKnownPositionOffset = f;
        this.getErrorConfigVersion = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int max;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (size * 0.2f), -2);
        this.mPrevText.measure(childMeasureSpec2, childMeasureSpec);
        this.mCurrText.measure(childMeasureSpec2, childMeasureSpec);
        this.mNextText.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            max = View.MeasureSpec.getSize(i2);
        } else {
            max = Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(max, i2, this.mCurrText.getMeasuredState() << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mPager != null) {
            float f = this.mLastKnownPositionOffset;
            if (f < 0.0f) {
                f = 0.0f;
            }
            updateTextPositions(this.KClassImpl$Data$declaredNonStaticMembers$2, f, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
        private int KClassImpl$Data$declaredNonStaticMembers$2;

        PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.updateTextPositions(i, f, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
                float f = PagerTitleStrip.this.mLastKnownPositionOffset >= 0.0f ? PagerTitleStrip.this.mLastKnownPositionOffset : 0.0f;
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f, true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.updateAdapter(pagerAdapter, pagerAdapter2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
            float f = PagerTitleStrip.this.mLastKnownPositionOffset >= 0.0f ? PagerTitleStrip.this.mLastKnownPositionOffset : 0.0f;
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f, true);
        }
    }
}
