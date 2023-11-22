package id.dana.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: classes9.dex */
public class ForceImeEditText extends TextInputEditText {
    private int MyBillsEntityDataFactory;

    public ForceImeEditText(Context context) {
        super(context);
        this.MyBillsEntityDataFactory = 6;
    }

    public ForceImeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MyBillsEntityDataFactory = 6;
    }

    public ForceImeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MyBillsEntityDataFactory = 6;
    }

    public void setDefaultIme(int i) {
        this.MyBillsEntityDataFactory = i;
    }

    @Override // com.google.android.material.textfield.TextInputEditText, androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        int i = editorInfo.imeOptions & 255;
        if ((this.MyBillsEntityDataFactory & i) != 0) {
            editorInfo.imeOptions = i ^ editorInfo.imeOptions;
            editorInfo.imeOptions |= this.MyBillsEntityDataFactory;
        }
        if ((editorInfo.imeOptions & 1073741824) != 0) {
            editorInfo.imeOptions &= -1073741825;
        }
        return onCreateInputConnection;
    }
}
