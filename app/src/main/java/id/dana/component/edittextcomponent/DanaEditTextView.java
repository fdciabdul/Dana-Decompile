package id.dana.component.edittextcomponent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;
import id.dana.component.R;

/* loaded from: classes4.dex */
public class DanaEditTextView extends AppCompatEditText {
    public DanaEditTextView(Context context) {
        super(context);
        BuiltInFictitiousFunctionClassFactory(context, null);
    }

    public DanaEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        BuiltInFictitiousFunctionClassFactory(context, attributeSet);
    }

    public DanaEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        BuiltInFictitiousFunctionClassFactory(context, attributeSet);
    }

    private void BuiltInFictitiousFunctionClassFactory(Context context, AttributeSet attributeSet) {
        int i;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.p, 0, 0);
            try {
                i = obtainStyledAttributes.getInt(R.styleable.OtpRegistrationPresenter$input$2, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            i = 0;
        }
        PlaceComponentResult(i == 0);
        setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.component.edittextcomponent.DanaEditTextView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return DanaEditTextView.this.m610x9b60a310(view, motionEvent);
            }
        });
        setMaxLines(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOnIconTouchListener$0$id-dana-component-edittextcomponent-DanaEditTextView  reason: not valid java name */
    public /* synthetic */ boolean m610x9b60a310(View view, MotionEvent motionEvent) {
        if (getCompoundDrawables()[2] == null || motionEvent.getAction() != 1 || motionEvent.getRawX() < getRight() - getCompoundDrawables()[2].getBounds().width() || getText() == null) {
            return false;
        }
        getText().clear();
        return true;
    }

    @Override // android.widget.TextView
    public void setError(CharSequence charSequence) {
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r2.getResources(), R.color.lookAheadTest, getContext().getTheme());
        setSupportBackgroundTintList(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$22;
        super.setEnabled(z);
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$22 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r2.getResources(), R.color.BuiltInFictitiousFunctionClassFactory, getContext().getTheme());
            setSupportBackgroundTintList(KClassImpl$Data$declaredNonStaticMembers$22);
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r2.getResources(), R.color.MyBillsEntityDataFactory, getContext().getTheme());
        setSupportBackgroundTintList(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        setCompoundDrawablesWithIntrinsicBounds(0, 0, i3 > 0 ? R.drawable.initRecordTimeStamp : 0, 0);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$22;
        super.onFocusChanged(z, i, rect);
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$22 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r1.getResources(), R.color.moveToNextValue, getContext().getTheme());
            setSupportBackgroundTintList(KClassImpl$Data$declaredNonStaticMembers$22);
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r1.getResources(), R.color.BuiltInFictitiousFunctionClassFactory, getContext().getTheme());
        setSupportBackgroundTintList(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    private void PlaceComponentResult(boolean z) {
        setTextSize(0, getResources().getDimension(z ? R.dimen.res_0x7f07011f_kclassimpl_data_declarednonstaticmembers_2 : R.dimen.PlaceComponentResult_res_0x7f070124));
        setTextColor(getResources().getColor(z ? R.color.getAuthRequestContext : R.color.getErrorConfigVersion_res_0x7f0602a3));
    }
}
