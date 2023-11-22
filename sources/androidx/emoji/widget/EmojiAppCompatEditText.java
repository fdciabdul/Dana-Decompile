package androidx.emoji.widget;

import android.content.Context;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.util.Preconditions;

/* loaded from: classes6.dex */
public class EmojiAppCompatEditText extends AppCompatEditText {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private EmojiEditTextHelper getAuthRequestContext;

    public EmojiAppCompatEditText(Context context) {
        super(context);
        MyBillsEntityDataFactory(null, 0);
    }

    public EmojiAppCompatEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        MyBillsEntityDataFactory(attributeSet, R.attr.A);
    }

    public EmojiAppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MyBillsEntityDataFactory(attributeSet, i);
    }

    private void MyBillsEntityDataFactory(AttributeSet attributeSet, int i) {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = true;
        setMaxEmojiCount(new EditTextAttributeHelper(this, attributeSet, i, 0).BuiltInFictitiousFunctionClassFactory);
        setKeyListener(super.getKeyListener());
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        if (keyListener != null) {
            EmojiEditTextHelper MyBillsEntityDataFactory = MyBillsEntityDataFactory();
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(keyListener, "keyListener cannot be null");
            keyListener = MyBillsEntityDataFactory.PlaceComponentResult.PlaceComponentResult(keyListener);
        }
        super.setKeyListener(keyListener);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        EmojiEditTextHelper MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        if (onCreateInputConnection == null) {
            return null;
        }
        return MyBillsEntityDataFactory.PlaceComponentResult.getAuthRequestContext(onCreateInputConnection, editorInfo);
    }

    public void setMaxEmojiCount(int i) {
        EmojiEditTextHelper MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        Preconditions.MyBillsEntityDataFactory(i, "maxEmojiCount should be greater than 0");
        MyBillsEntityDataFactory.getAuthRequestContext = i;
        MyBillsEntityDataFactory.PlaceComponentResult.getAuthRequestContext(i);
    }

    public int getMaxEmojiCount() {
        return MyBillsEntityDataFactory().getAuthRequestContext;
    }

    private EmojiEditTextHelper MyBillsEntityDataFactory() {
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new EmojiEditTextHelper(this);
        }
        return this.getAuthRequestContext;
    }
}
