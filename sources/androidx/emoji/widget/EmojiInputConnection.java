package androidx.emoji.widget;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji.text.EmojiCompat;

/* loaded from: classes6.dex */
final class EmojiInputConnection extends InputConnectionWrapper {
    private final TextView BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        this.BuiltInFictitiousFunctionClassFactory = textView;
        EmojiCompat.MyBillsEntityDataFactory().getAuthRequestContext(editorInfo);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        return EmojiCompat.BuiltInFictitiousFunctionClassFactory((InputConnection) this, this.BuiltInFictitiousFunctionClassFactory.getEditableText(), i, i2, false) || super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return EmojiCompat.BuiltInFictitiousFunctionClassFactory((InputConnection) this, this.BuiltInFictitiousFunctionClassFactory.getEditableText(), i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2);
    }
}
