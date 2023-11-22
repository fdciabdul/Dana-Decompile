package androidx.emoji.widget;

import android.content.Context;
import android.inputmethodservice.ExtractEditText;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.core.util.Preconditions;
import androidx.core.widget.TextViewCompat;

/* loaded from: classes6.dex */
public class EmojiExtractEditText extends ExtractEditText {
    private EmojiEditTextHelper BuiltInFictitiousFunctionClassFactory;
    private boolean PlaceComponentResult;

    public EmojiExtractEditText(Context context) {
        super(context);
        MyBillsEntityDataFactory(null, 0, 0);
    }

    public EmojiExtractEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        MyBillsEntityDataFactory(attributeSet, 16842862, 0);
    }

    public EmojiExtractEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MyBillsEntityDataFactory(attributeSet, i, 0);
    }

    public EmojiExtractEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        MyBillsEntityDataFactory(attributeSet, i, i2);
    }

    private void MyBillsEntityDataFactory(AttributeSet attributeSet, int i, int i2) {
        if (this.PlaceComponentResult) {
            return;
        }
        this.PlaceComponentResult = true;
        setMaxEmojiCount(new EditTextAttributeHelper(this, attributeSet, i, i2).BuiltInFictitiousFunctionClassFactory);
        setKeyListener(super.getKeyListener());
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new EmojiEditTextHelper(this);
        }
        EmojiEditTextHelper emojiEditTextHelper = this.BuiltInFictitiousFunctionClassFactory;
        if (onCreateInputConnection == null) {
            return null;
        }
        return emojiEditTextHelper.PlaceComponentResult.getAuthRequestContext(onCreateInputConnection, editorInfo);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.BuiltInFictitiousFunctionClassFactory(this, callback));
    }

    public int getEmojiReplaceStrategy() {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new EmojiEditTextHelper(this);
        }
        return this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public int getMaxEmojiCount() {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new EmojiEditTextHelper(this);
        }
        return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
    }

    public void setEmojiReplaceStrategy(int i) {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new EmojiEditTextHelper(this);
        }
        EmojiEditTextHelper emojiEditTextHelper = this.BuiltInFictitiousFunctionClassFactory;
        emojiEditTextHelper.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        emojiEditTextHelper.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(i);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        if (keyListener != null) {
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                this.BuiltInFictitiousFunctionClassFactory = new EmojiEditTextHelper(this);
            }
            EmojiEditTextHelper emojiEditTextHelper = this.BuiltInFictitiousFunctionClassFactory;
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(keyListener, "keyListener cannot be null");
            keyListener = emojiEditTextHelper.PlaceComponentResult.PlaceComponentResult(keyListener);
        }
        super.setKeyListener(keyListener);
    }

    public void setMaxEmojiCount(int i) {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new EmojiEditTextHelper(this);
        }
        EmojiEditTextHelper emojiEditTextHelper = this.BuiltInFictitiousFunctionClassFactory;
        Preconditions.MyBillsEntityDataFactory(i, "maxEmojiCount should be greater than 0");
        emojiEditTextHelper.getAuthRequestContext = i;
        emojiEditTextHelper.PlaceComponentResult.getAuthRequestContext(i);
    }
}
