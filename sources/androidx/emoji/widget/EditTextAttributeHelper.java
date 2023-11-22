package androidx.emoji.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.emoji.R;

/* loaded from: classes6.dex */
public class EditTextAttributeHelper {
    int BuiltInFictitiousFunctionClassFactory;

    public EditTextAttributeHelper(View view, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.PlaceComponentResult, i, i2);
            this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInteger(R.styleable.MyBillsEntityDataFactory, Integer.MAX_VALUE);
            obtainStyledAttributes.recycle();
        }
    }
}
