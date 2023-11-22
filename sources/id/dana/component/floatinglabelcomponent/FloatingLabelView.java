package id.dana.component.floatinglabelcomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.component.R;
import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public class FloatingLabelView extends TextInputLayout {
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    Method collapseHintMethod;

    public FloatingLabelView(Context context) {
        super(context);
        setFloatingLabel(context, null);
    }

    public FloatingLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFloatingLabel(context, attributeSet);
    }

    public FloatingLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setFloatingLabel(context, attributeSet);
    }

    public void setFloatingLabel(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TypefaceCompatApi26Impl, 0, 0);
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getInt(R.styleable.y, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2 == 1;
        setHintAnimationEnabled(z);
        try {
            Method declaredMethod = TextInputLayout.class.getDeclaredMethod("collapseHint", Boolean.TYPE);
            this.collapseHintMethod = declaredMethod;
            declaredMethod.setAccessible(!z);
        } catch (Exception unused) {
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setError(CharSequence charSequence) {
        super.setError(charSequence);
        setHintTextAppearance(R.style.getAuthRequestContext);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        try {
            this.collapseHintMethod.invoke(this, Boolean.FALSE);
        } catch (Exception unused) {
        }
    }
}
