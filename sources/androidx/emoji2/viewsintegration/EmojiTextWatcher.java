package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
final class EmojiTextWatcher implements TextWatcher {
    final EditText BuiltInFictitiousFunctionClassFactory;
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    EmojiCompat.InitCallback MyBillsEntityDataFactory;
    private int getErrorConfigVersion = Integer.MAX_VALUE;
    private int PlaceComponentResult = 0;
    boolean getAuthRequestContext = true;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiTextWatcher(EditText editText, boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = editText;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.BuiltInFictitiousFunctionClassFactory.isInEditMode() || getAuthRequestContext() || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int MyBillsEntityDataFactory = EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory != 0) {
            if (MyBillsEntityDataFactory == 1) {
                EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory((Spannable) charSequence, i, i + i3, this.getErrorConfigVersion, this.PlaceComponentResult);
                return;
            } else if (MyBillsEntityDataFactory != 3) {
                return;
            }
        }
        EmojiCompat KClassImpl$Data$declaredNonStaticMembers$2 = EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2();
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new InitCallbackImpl(this.BuiltInFictitiousFunctionClassFactory);
        }
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
    }

    private boolean getAuthRequestContext() {
        return (this.getAuthRequestContext && (this.KClassImpl$Data$declaredNonStaticMembers$2 || EmojiCompat.getAuthRequestContext())) ? false : true;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }

    /* loaded from: classes3.dex */
    static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<EditText> PlaceComponentResult;

        InitCallbackImpl(EditText editText) {
            this.PlaceComponentResult = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void BuiltInFictitiousFunctionClassFactory() {
            super.BuiltInFictitiousFunctionClassFactory();
            EmojiTextWatcher.PlaceComponentResult(this.PlaceComponentResult.get(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(EditText editText, int i) {
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(editableText);
            EmojiInputFilter.PlaceComponentResult(editableText, selectionStart, selectionEnd);
        }
    }
}
