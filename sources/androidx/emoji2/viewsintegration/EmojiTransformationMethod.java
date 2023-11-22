package androidx.emoji2.viewsintegration;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
class EmojiTransformationMethod implements TransformationMethod {
    final TransformationMethod KClassImpl$Data$declaredNonStaticMembers$2;

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
        return (charSequence == null || EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory() != 1) ? charSequence : EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
        TransformationMethod transformationMethod = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z, i, rect);
        }
    }
}
