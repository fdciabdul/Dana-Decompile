package androidx.emoji2.viewsintegration;

import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes3.dex */
public final class EmojiEditTextHelper {
    public final HelperInternal KClassImpl$Data$declaredNonStaticMembers$2;
    private int BuiltInFictitiousFunctionClassFactory = Integer.MAX_VALUE;
    private int getAuthRequestContext = 0;

    public EmojiEditTextHelper(EditText editText) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(editText, "editText cannot be null");
        if (Build.VERSION.SDK_INT < 19) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new HelperInternal();
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new HelperInternal19(editText, false);
        }
    }

    public final boolean PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
    }

    /* loaded from: classes3.dex */
    public static class HelperInternal {
        public KeyListener BuiltInFictitiousFunctionClassFactory(KeyListener keyListener) {
            return keyListener;
        }

        public void BuiltInFictitiousFunctionClassFactory(boolean z) {
        }

        boolean BuiltInFictitiousFunctionClassFactory() {
            return false;
        }

        public InputConnection PlaceComponentResult(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection;
        }

        HelperInternal() {
        }
    }

    /* loaded from: classes3.dex */
    static class HelperInternal19 extends HelperInternal {
        private final EditText BuiltInFictitiousFunctionClassFactory;
        private final EmojiTextWatcher getAuthRequestContext;

        HelperInternal19(EditText editText, boolean z) {
            this.BuiltInFictitiousFunctionClassFactory = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText, z);
            this.getAuthRequestContext = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            editText.setEditableFactory(EmojiEditableFactory.PlaceComponentResult());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        public KeyListener BuiltInFictitiousFunctionClassFactory(KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new EmojiKeyListener(keyListener);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        public InputConnection PlaceComponentResult(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof EmojiInputConnection ? inputConnection : new EmojiInputConnection(this.BuiltInFictitiousFunctionClassFactory, inputConnection, editorInfo);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        public void BuiltInFictitiousFunctionClassFactory(boolean z) {
            EmojiTextWatcher emojiTextWatcher = this.getAuthRequestContext;
            if (emojiTextWatcher.getAuthRequestContext != z) {
                if (emojiTextWatcher.MyBillsEntityDataFactory != null) {
                    EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(emojiTextWatcher.MyBillsEntityDataFactory);
                }
                emojiTextWatcher.getAuthRequestContext = z;
                if (z) {
                    EmojiTextWatcher.PlaceComponentResult(emojiTextWatcher.BuiltInFictitiousFunctionClassFactory, EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory());
                }
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        boolean BuiltInFictitiousFunctionClassFactory() {
            return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }
}
