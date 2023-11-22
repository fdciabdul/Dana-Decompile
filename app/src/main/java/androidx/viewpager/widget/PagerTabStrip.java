package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import com.google.android.flexbox.FlexItem;

/* loaded from: classes6.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private final Rect DatabaseTableConfigUtil;
    private int GetContactSyncConfig;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private float NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Paint NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean PlaceComponentResult;
    private int PrepareContext;
    private int getAuthRequestContext;
    private float getErrorConfigVersion;
    private int initRecordTimeStamp;
    private int lookAheadTest;
    private int moveToNextValue;
    private int scheduleImpl;

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = paint;
        this.DatabaseTableConfigUtil = new Rect();
        this.GetContactSyncConfig = 255;
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.MyBillsEntityDataFactory = false;
        int i = this.mTextColor;
        this.getAuthRequestContext = i;
        paint.setColor(i);
        float f = context.getResources().getDisplayMetrics().density;
        this.scheduleImpl = (int) ((3.0f * f) + 0.5f);
        this.moveToNextValue = (int) ((6.0f * f) + 0.5f);
        this.initRecordTimeStamp = (int) (64.0f * f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (int) ((16.0f * f) + 0.5f);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (int) ((1.0f * f) + 0.5f);
        this.lookAheadTest = (int) ((f * 32.0f) + 0.5f);
        this.PrepareContext = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PagerTabStrip.this.mPager.setCurrentItem(PagerTabStrip.this.mPager.getCurrentItem() - 1);
            }
        });
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PagerTabStrip.this.mPager.setCurrentItem(PagerTabStrip.this.mPager.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.BuiltInFictitiousFunctionClassFactory = true;
        }
    }

    public void setTabIndicatorColor(int i) {
        this.getAuthRequestContext = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor(i);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), i));
    }

    public int getTabIndicatorColor() {
        return this.getAuthRequestContext;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        int i5 = this.moveToNextValue;
        if (i4 < i5) {
            i4 = i5;
        }
        super.setPadding(i, i2, i3, i4);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i) {
        int i2 = this.initRecordTimeStamp;
        if (i < i2) {
            i = i2;
        }
        super.setTextSpacing(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = (i & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = i == 0;
    }

    public void setDrawFullUnderline(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.MyBillsEntityDataFactory = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.lookAheadTest);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || !this.PlaceComponentResult) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (action == 0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = x;
                this.getErrorConfigVersion = y;
                this.PlaceComponentResult = false;
            } else if (action != 1) {
                if (action == 2 && (Math.abs(x - this.NetworkUserEntityData$$ExternalSyntheticLambda0) > this.PrepareContext || Math.abs(y - this.getErrorConfigVersion) > this.PrepareContext)) {
                    this.PlaceComponentResult = true;
                }
            } else if (x < this.mCurrText.getLeft() - this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                this.mPager.setCurrentItem(this.mPager.getCurrentItem() - 1);
            } else if (x > this.mCurrText.getRight() + this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                this.mPager.setCurrentItem(this.mPager.getCurrentItem() + 1);
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.mCurrText.getLeft();
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int right = this.mCurrText.getRight();
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int i3 = this.scheduleImpl;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor((this.GetContactSyncConfig << 24) | (this.getAuthRequestContext & FlexItem.MAX_SIZE));
        float f = height;
        canvas.drawRect(left - i, height - i3, right + i2, f, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        if (this.BuiltInFictitiousFunctionClassFactory) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor((-16777216) | (this.getAuthRequestContext & FlexItem.MAX_SIZE));
            canvas.drawRect(getPaddingLeft(), height - this.KClassImpl$Data$declaredNonStaticMembers$2, getWidth() - getPaddingRight(), f, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void updateTextPositions(int i, float f, boolean z) {
        Rect rect = this.DatabaseTableConfigUtil;
        int height = getHeight();
        int left = this.mCurrText.getLeft();
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int right = this.mCurrText.getRight();
        int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int i4 = height - this.scheduleImpl;
        rect.set(left - i2, i4, right + i3, height);
        super.updateTextPositions(i, f, z);
        this.GetContactSyncConfig = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.mCurrText.getLeft() - this.NetworkUserEntityData$$ExternalSyntheticLambda1, i4, this.mCurrText.getRight() + this.NetworkUserEntityData$$ExternalSyntheticLambda1, height);
        invalidate(rect);
    }
}
