package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* loaded from: classes6.dex */
public class AllCapsTransformationMethod implements TransformationMethod {
    private Locale MyBillsEntityDataFactory;

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }

    public AllCapsTransformationMethod(Context context) {
        this.MyBillsEntityDataFactory = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.MyBillsEntityDataFactory);
        }
        return null;
    }
}
