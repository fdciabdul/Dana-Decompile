package androidx.emoji.widget;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
final class EmojiTextWatcher implements TextWatcher {
    private final EditText BuiltInFictitiousFunctionClassFactory;
    private EmojiCompat.InitCallback PlaceComponentResult;
    int getAuthRequestContext = Integer.MAX_VALUE;
    int KClassImpl$Data$declaredNonStaticMembers$2 = 0;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiTextWatcher(EditText editText) {
        this.BuiltInFictitiousFunctionClassFactory = editText;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.BuiltInFictitiousFunctionClassFactory.isInEditMode() && i2 <= i3 && (charSequence instanceof Spannable)) {
            int KClassImpl$Data$declaredNonStaticMembers$2 = EmojiCompat.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                if (KClassImpl$Data$declaredNonStaticMembers$2 == 1) {
                    EmojiCompat.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory((Spannable) charSequence, i, i + i3, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                } else if (KClassImpl$Data$declaredNonStaticMembers$2 != 3) {
                    return;
                }
            }
            EmojiCompat MyBillsEntityDataFactory = EmojiCompat.MyBillsEntityDataFactory();
            if (this.PlaceComponentResult == null) {
                this.PlaceComponentResult = new InitCallbackImpl(this.BuiltInFictitiousFunctionClassFactory);
            }
            MyBillsEntityDataFactory.PlaceComponentResult(this.PlaceComponentResult);
        }
    }

    /* loaded from: classes6.dex */
    static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<EditText> BuiltInFictitiousFunctionClassFactory;

        InitCallbackImpl(EditText editText) {
            this.BuiltInFictitiousFunctionClassFactory = new WeakReference(editText);
        }

        @Override // androidx.emoji.text.EmojiCompat.InitCallback
        public void MyBillsEntityDataFactory() {
            super.MyBillsEntityDataFactory();
            EditText editText = this.BuiltInFictitiousFunctionClassFactory.get();
            if (editText == null || !editText.isAttachedToWindow()) {
                return;
            }
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(editableText);
            EmojiInputFilter.PlaceComponentResult(editableText, selectionStart, selectionEnd);
        }
    }
}
