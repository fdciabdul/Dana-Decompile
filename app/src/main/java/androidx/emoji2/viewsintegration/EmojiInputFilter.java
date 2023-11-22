package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class EmojiInputFilter implements InputFilter {
    private final TextView PlaceComponentResult;
    private EmojiCompat.InitCallback getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiInputFilter(TextView textView) {
        this.PlaceComponentResult = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (this.PlaceComponentResult.isInEditMode()) {
            return charSequence;
        }
        int MyBillsEntityDataFactory = EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory != 0) {
            boolean z = true;
            if (MyBillsEntityDataFactory == 1) {
                if (i4 == 0 && i3 == 0 && spanned.length() == 0 && charSequence == this.PlaceComponentResult.getText()) {
                    z = false;
                }
                if (!z || charSequence == null) {
                    return charSequence;
                }
                if (i != 0 || i2 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i, i2);
                }
                return EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(charSequence, 0, charSequence.length());
            } else if (MyBillsEntityDataFactory != 3) {
                return charSequence;
            }
        }
        EmojiCompat KClassImpl$Data$declaredNonStaticMembers$2 = EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2();
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new InitCallbackImpl(this.PlaceComponentResult, this);
        }
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
        return charSequence;
    }

    /* loaded from: classes.dex */
    static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<TextView> MyBillsEntityDataFactory;
        private final Reference<EmojiInputFilter> PlaceComponentResult;

        InitCallbackImpl(TextView textView, EmojiInputFilter emojiInputFilter) {
            this.MyBillsEntityDataFactory = new WeakReference(textView);
            this.PlaceComponentResult = new WeakReference(emojiInputFilter);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void BuiltInFictitiousFunctionClassFactory() {
            CharSequence text;
            CharSequence authRequestContext;
            super.BuiltInFictitiousFunctionClassFactory();
            TextView textView = this.MyBillsEntityDataFactory.get();
            if (PlaceComponentResult(textView, this.PlaceComponentResult.get()) && textView.isAttachedToWindow() && text != (authRequestContext = EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(authRequestContext);
                int selectionEnd = Selection.getSelectionEnd(authRequestContext);
                textView.setText(authRequestContext);
                if (authRequestContext instanceof Spannable) {
                    EmojiInputFilter.PlaceComponentResult((Spannable) authRequestContext, selectionStart, selectionEnd);
                }
            }
        }

        private static boolean PlaceComponentResult(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
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
