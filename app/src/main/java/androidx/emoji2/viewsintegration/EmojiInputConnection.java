package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes3.dex */
final class EmojiInputConnection extends InputConnectionWrapper {
    private final TextView MyBillsEntityDataFactory;
    private final EmojiCompatDeleteHelper getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new EmojiCompatDeleteHelper());
    }

    private EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, EmojiCompatDeleteHelper emojiCompatDeleteHelper) {
        super(inputConnection, false);
        this.MyBillsEntityDataFactory = textView;
        this.getAuthRequestContext = emojiCompatDeleteHelper;
        emojiCompatDeleteHelper.KClassImpl$Data$declaredNonStaticMembers$2(editorInfo);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this, this.MyBillsEntityDataFactory.getEditableText(), i, i2, false) || super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this, this.MyBillsEntityDataFactory.getEditableText(), i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2);
    }

    /* loaded from: classes3.dex */
    public static class EmojiCompatDeleteHelper {
        public boolean BuiltInFictitiousFunctionClassFactory(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
            return EmojiCompat.MyBillsEntityDataFactory(inputConnection, editable, i, i2, z);
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(EditorInfo editorInfo) {
            if (EmojiCompat.getAuthRequestContext()) {
                EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(editorInfo);
            }
        }
    }
}
