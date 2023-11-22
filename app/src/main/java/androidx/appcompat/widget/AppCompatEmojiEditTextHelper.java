package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatEmojiEditTextHelper {
    private final EditText PlaceComponentResult;
    private final EmojiEditTextHelper getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatEmojiEditTextHelper(EditText editText) {
        this.PlaceComponentResult = editText;
        this.getAuthRequestContext = new EmojiEditTextHelper(editText);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MyBillsEntityDataFactory(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.PlaceComponentResult.getContext().obtainStyledAttributes(attributeSet, R.styleable.V, i, 0);
        try {
            boolean z = obtainStyledAttributes.hasValue(R.styleable.QrExpiredActivity) ? obtainStyledAttributes.getBoolean(R.styleable.QrExpiredActivity, true) : true;
            obtainStyledAttributes.recycle();
            MyBillsEntityDataFactory(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean PlaceComponentResult(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MyBillsEntityDataFactory(boolean z) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getAuthRequestContext() {
        return this.getAuthRequestContext.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyListener KClassImpl$Data$declaredNonStaticMembers$2(KeyListener keyListener) {
        return PlaceComponentResult(keyListener) ? this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(keyListener) : keyListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputConnection BuiltInFictitiousFunctionClassFactory(InputConnection inputConnection, EditorInfo editorInfo) {
        EmojiEditTextHelper emojiEditTextHelper = this.getAuthRequestContext;
        if (inputConnection == null) {
            return null;
        }
        return emojiEditTextHelper.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(inputConnection, editorInfo);
    }
}
