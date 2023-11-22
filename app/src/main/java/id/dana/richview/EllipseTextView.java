package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import id.dana.R;

/* loaded from: classes5.dex */
public class EllipseTextView extends AppCompatTextView {
    private GradientDrawable KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private float PlaceComponentResult;
    private int getAuthRequestContext;
    private int moveToNextValue;

    public EllipseTextView(Context context) {
        super(context);
        PlaceComponentResult(null);
    }

    public EllipseTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        PlaceComponentResult(attributeSet);
    }

    public EllipseTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        PlaceComponentResult(attributeSet);
    }

    private void PlaceComponentResult(AttributeSet attributeSet) {
        MyBillsEntityDataFactory(attributeSet);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gradientDrawable;
        gradientDrawable.setShape(0);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setStroke(this.moveToNextValue, this.MyBillsEntityDataFactory);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setCornerRadius(this.PlaceComponentResult);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setColor(this.getAuthRequestContext);
        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            setBackground(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    private void MyBillsEntityDataFactory(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.w);
            try {
                getResources();
                this.MyBillsEntityDataFactory = obtainStyledAttributes.getInt(2, -1);
                this.moveToNextValue = obtainStyledAttributes.getInt(3, 0);
                getResources();
                this.getAuthRequestContext = obtainStyledAttributes.getInt(0, -1);
                this.PlaceComponentResult = obtainStyledAttributes.getFloat(1, 0.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.getAuthRequestContext = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setColor(i);
    }

    public void setStrokeColor(int i) {
        this.MyBillsEntityDataFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setStroke(this.moveToNextValue, i);
    }

    public void setCornerRadius(float f) {
        this.PlaceComponentResult = f;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setCornerRadius(f);
    }
}
