package id.dana.textbehavior.manipulate;

import android.widget.EditText;

/* loaded from: classes5.dex */
public class NoZeroFirstManipulator implements Manipulator {
    @Override // id.dana.textbehavior.manipulate.Manipulator
    public final void BuiltInFictitiousFunctionClassFactory(EditText editText, int i) {
        String obj = editText.getText().toString();
        if (obj.length() > 0) {
            StringBuilder sb = new StringBuilder(obj);
            if (i == 0 && obj.charAt(i) == '0') {
                sb.deleteCharAt(i);
                editText.setText(sb.toString());
                editText.setSelection(i);
            }
        }
    }
}
