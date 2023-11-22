package androidx.emoji.widget;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji.text.EmojiCompat;

/* loaded from: classes3.dex */
class EmojiTransformationMethod implements TransformationMethod {
    private final TransformationMethod KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiTransformationMethod(TransformationMethod transformationMethod) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = transformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || EmojiCompat.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2() != 1) ? charSequence : EmojiCompat.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
        TransformationMethod transformationMethod = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z, i, rect);
        }
    }
}
