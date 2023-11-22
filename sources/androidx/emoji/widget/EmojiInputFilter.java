package androidx.emoji.widget;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
final class EmojiInputFilter implements InputFilter {
    private final TextView BuiltInFictitiousFunctionClassFactory;
    private EmojiCompat.InitCallback getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiInputFilter(TextView textView) {
        this.BuiltInFictitiousFunctionClassFactory = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (this.BuiltInFictitiousFunctionClassFactory.isInEditMode()) {
            return charSequence;
        }
        int KClassImpl$Data$declaredNonStaticMembers$2 = EmojiCompat.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
            boolean z = true;
            if (KClassImpl$Data$declaredNonStaticMembers$2 == 1) {
                if (i4 == 0 && i3 == 0 && spanned.length() == 0 && charSequence == this.BuiltInFictitiousFunctionClassFactory.getText()) {
                    z = false;
                }
                if (!z || charSequence == null) {
                    return charSequence;
                }
                if (i != 0 || i2 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i, i2);
                }
                return EmojiCompat.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(charSequence, 0, charSequence.length());
            } else if (KClassImpl$Data$declaredNonStaticMembers$2 != 3) {
                return charSequence;
            }
        }
        EmojiCompat MyBillsEntityDataFactory = EmojiCompat.MyBillsEntityDataFactory();
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new InitCallbackImpl(this.BuiltInFictitiousFunctionClassFactory);
        }
        MyBillsEntityDataFactory.PlaceComponentResult(this.getAuthRequestContext);
        return charSequence;
    }

    /* loaded from: classes3.dex */
    static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<TextView> BuiltInFictitiousFunctionClassFactory;

        InitCallbackImpl(TextView textView) {
            this.BuiltInFictitiousFunctionClassFactory = new WeakReference(textView);
        }

        @Override // androidx.emoji.text.EmojiCompat.InitCallback
        public void MyBillsEntityDataFactory() {
            super.MyBillsEntityDataFactory();
            TextView textView = this.BuiltInFictitiousFunctionClassFactory.get();
            if (textView == null || !textView.isAttachedToWindow()) {
                return;
            }
            CharSequence KClassImpl$Data$declaredNonStaticMembers$2 = EmojiCompat.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(textView.getText());
            int selectionStart = Selection.getSelectionStart(KClassImpl$Data$declaredNonStaticMembers$2);
            int selectionEnd = Selection.getSelectionEnd(KClassImpl$Data$declaredNonStaticMembers$2);
            textView.setText(KClassImpl$Data$declaredNonStaticMembers$2);
            if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof Spannable) {
                EmojiInputFilter.PlaceComponentResult((Spannable) KClassImpl$Data$declaredNonStaticMembers$2, selectionStart, selectionEnd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(Spannable spannable, int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            Selection.setSelection(spannable, i, i2);
        } else if (i >= 0) {
            Selection.setSelection(spannable, i);
        } else if (i2 >= 0) {
            Selection.setSelection(spannable, i2);
        }
    }
}
