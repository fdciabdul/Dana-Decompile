package androidx.emoji.widget;

import android.content.Context;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.Preconditions;
import androidx.core.widget.TextViewCompat;

/* loaded from: classes6.dex */
public class EmojiEditText extends EditText {
    private EmojiEditTextHelper KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;

    public EmojiEditText(Context context) {
        super(context);
        KClassImpl$Data$declaredNonStaticMembers$2(null, 0, 0);
    }

    public EmojiEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet, 16842862, 0);
    }

    public EmojiEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet, i, 0);
    }

    public EmojiEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet, i, i2);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(AttributeSet attributeSet, int i, int i2) {
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        this.MyBillsEntityDataFactory = true;
        setMaxEmojiCount(new EditTextAttributeHelper(this, attributeSet, i, i2).BuiltInFictitiousFunctionClassFactory);
        setKeyListener(super.getKeyListener());
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new EmojiEditTextHelper(this);
        }
        EmojiEditTextHelper emojiEditTextHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onCreateInputConnection == null) {
            return null;
        }
        return emojiEditTextHelper.PlaceComponentResult.getAuthRequestContext(onCreateInputConnection, editorInfo);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.BuiltInFictitiousFunctionClassFactory(this, callback));
    }

    public int getMaxEmojiCount() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new EmojiEditTextHelper(this);
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        if (keyListener != null) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new EmojiEditTextHelper(this);
            }
            EmojiEditTextHelper emojiEditTextHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(keyListener, "keyListener cannot be null");
            keyListener = emojiEditTextHelper.PlaceComponentResult.PlaceComponentResult(keyListener);
        }
        super.setKeyListener(keyListener);
    }

    public void setMaxEmojiCount(int i) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new EmojiEditTextHelper(this);
        }
        EmojiEditTextHelper emojiEditTextHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Preconditions.MyBillsEntityDataFactory(i, "maxEmojiCount should be greater than 0");
        emojiEditTextHelper.getAuthRequestContext = i;
        emojiEditTextHelper.PlaceComponentResult.getAuthRequestContext(i);
    }
}
