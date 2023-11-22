package androidx.emoji.widget;

import android.os.Build;
import android.text.method.KeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.Preconditions;

/* loaded from: classes6.dex */
public final class EmojiEditTextHelper {
    final HelperInternal PlaceComponentResult;
    int getAuthRequestContext = Integer.MAX_VALUE;
    int KClassImpl$Data$declaredNonStaticMembers$2 = 0;

    public EmojiEditTextHelper(EditText editText) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(editText, "editText cannot be null");
        this.PlaceComponentResult = Build.VERSION.SDK_INT >= 19 ? new HelperInternal19(editText) : new HelperInternal();
    }

    /* loaded from: classes6.dex */
    static class HelperInternal {
        /* JADX INFO: Access modifiers changed from: package-private */
        public void BuiltInFictitiousFunctionClassFactory(int i) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public KeyListener PlaceComponentResult(KeyListener keyListener) {
            return keyListener;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public InputConnection getAuthRequestContext(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void getAuthRequestContext(int i) {
        }

        HelperInternal() {
        }
    }

    /* loaded from: classes6.dex */
    static class HelperInternal19 extends HelperInternal {
        private final EmojiTextWatcher BuiltInFictitiousFunctionClassFactory;
        private final EditText PlaceComponentResult;

        HelperInternal19(EditText editText) {
            this.PlaceComponentResult = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText);
            this.BuiltInFictitiousFunctionClassFactory = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            editText.setEditableFactory(EmojiEditableFactory.MyBillsEntityDataFactory());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji.widget.EmojiEditTextHelper.HelperInternal
        public void getAuthRequestContext(int i) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji.widget.EmojiEditTextHelper.HelperInternal
        public void BuiltInFictitiousFunctionClassFactory(int i) {
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji.widget.EmojiEditTextHelper.HelperInternal
        public KeyListener PlaceComponentResult(KeyListener keyListener) {
            return keyListener instanceof EmojiKeyListener ? keyListener : new EmojiKeyListener(keyListener);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji.widget.EmojiEditTextHelper.HelperInternal
        public InputConnection getAuthRequestContext(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof EmojiInputConnection ? inputConnection : new EmojiInputConnection(this.PlaceComponentResult, inputConnection, editorInfo);
        }
    }
}
