package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.R;

/* loaded from: classes3.dex */
public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {16842801};
    private static final CardViewImpl IMPL;
    private final CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            IMPL = new CardViewApi21Impl();
        } else if (Build.VERSION.SDK_INT >= 17) {
            IMPL = new CardViewApi17Impl();
        } else {
            IMPL = new CardViewBaseImpl();
        }
        IMPL.PlaceComponentResult();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.getAuthRequestContext);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int color;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.mContentPadding = rect;
        this.mShadowBounds = new Rect();
        CardViewDelegate cardViewDelegate = new CardViewDelegate() { // from class: androidx.cardview.widget.CardView.1
            private Drawable KClassImpl$Data$declaredNonStaticMembers$2;

            @Override // androidx.cardview.widget.CardViewDelegate
            public final void MyBillsEntityDataFactory(Drawable drawable) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public final boolean PlaceComponentResult() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public final boolean BuiltInFictitiousFunctionClassFactory() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public final void MyBillsEntityDataFactory(int i2, int i3, int i4, int i5) {
                CardView.this.mShadowBounds.set(i2, i3, i4, i5);
                CardView cardView = CardView.this;
                CardView.super.setPadding(i2 + cardView.mContentPadding.left, i3 + CardView.this.mContentPadding.top, i4 + CardView.this.mContentPadding.right, i5 + CardView.this.mContentPadding.bottom);
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public final void BuiltInFictitiousFunctionClassFactory(int i2, int i3) {
                if (i2 > CardView.this.mUserSetMinWidth) {
                    CardView.super.setMinimumWidth(i2);
                }
                if (i3 > CardView.this.mUserSetMinHeight) {
                    CardView.super.setMinimumHeight(i3);
                }
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public final Drawable KClassImpl$Data$declaredNonStaticMembers$2() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2;
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public final View MyBillsEntityDataFactory() {
                return CardView.this;
            }
        };
        this.mCardViewDelegate = cardViewDelegate;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KClassImpl$Data$declaredNonStaticMembers$2, i, R.style.getAuthRequestContext);
        if (obtainStyledAttributes.hasValue(R.styleable.BuiltInFictitiousFunctionClassFactory)) {
            valueOf = obtainStyledAttributes.getColorStateList(R.styleable.BuiltInFictitiousFunctionClassFactory);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(R.color.KClassImpl$Data$declaredNonStaticMembers$2);
            } else {
                color = getResources().getColor(R.color.getAuthRequestContext);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R.styleable.getAuthRequestContext, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.lookAheadTest, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R.styleable.scheduleImpl, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(R.styleable.moveToNextValue, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(R.styleable.getErrorConfigVersion, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(R.styleable.initRecordTimeStamp, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GetContactSyncConfig, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda2, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DatabaseTableConfigUtil, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MyBillsEntityDataFactory, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PlaceComponentResult, 0);
        obtainStyledAttributes.recycle();
        IMPL.PlaceComponentResult(cardViewDelegate, context, colorStateList, dimension, dimension2, f);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            IMPL.getErrorConfigVersion(this.mCardViewDelegate);
        }
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.mContentPadding.set(i, i2, i3, i4);
        IMPL.moveToNextValue(this.mCardViewDelegate);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (!(IMPL instanceof CardViewApi21Impl)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.getAuthRequestContext(this.mCardViewDelegate)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.MyBillsEntityDataFactory(this.mCardViewDelegate)), View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.mUserSetMinWidth = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.mUserSetMinHeight = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        IMPL.KClassImpl$Data$declaredNonStaticMembers$2(this.mCardViewDelegate, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        IMPL.KClassImpl$Data$declaredNonStaticMembers$2(this.mCardViewDelegate, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.PlaceComponentResult(this.mCardViewDelegate);
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public void setRadius(float f) {
        IMPL.MyBillsEntityDataFactory(this.mCardViewDelegate, f);
    }

    public float getRadius() {
        return IMPL.NetworkUserEntityData$$ExternalSyntheticLambda0(this.mCardViewDelegate);
    }

    public void setCardElevation(float f) {
        IMPL.getAuthRequestContext(this.mCardViewDelegate, f);
    }

    public float getCardElevation() {
        return IMPL.BuiltInFictitiousFunctionClassFactory(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f) {
        IMPL.BuiltInFictitiousFunctionClassFactory(this.mCardViewDelegate, f);
    }

    public float getMaxCardElevation() {
        return IMPL.KClassImpl$Data$declaredNonStaticMembers$2(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            IMPL.lookAheadTest(this.mCardViewDelegate);
        }
    }
}
