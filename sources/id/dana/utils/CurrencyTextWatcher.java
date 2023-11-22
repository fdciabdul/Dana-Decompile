package id.dana.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* loaded from: classes9.dex */
public class CurrencyTextWatcher implements TextWatcher {
    private EditText MyBillsEntityDataFactory;
    private int PlaceComponentResult;

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public CurrencyTextWatcher(EditText editText) {
        this.MyBillsEntityDataFactory = editText;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.PlaceComponentResult = this.MyBillsEntityDataFactory.getText().toString().length() - this.MyBillsEntityDataFactory.getSelectionStart();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        try {
            this.MyBillsEntityDataFactory.removeTextChangedListener(this);
            String obj = this.MyBillsEntityDataFactory.getText().toString();
            String replace = String.valueOf(getAuthRequestContext(obj)).replace(".", "");
            StringBuilder sb = new StringBuilder(replace);
            int i = 0;
            if (replace.charAt(0) == '0') {
                sb.deleteCharAt(0);
                replace = sb.toString();
            }
            String str = "";
            int i2 = 0;
            for (int length = replace.length() - 1; length >= 0; length--) {
                if (i2 == 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(".");
                    sb2.append(str);
                    str = sb2.toString();
                    i2 = 0;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(replace.charAt(length));
                sb3.append(str);
                str = sb3.toString();
                i2++;
            }
            if (obj != null && !obj.equals("")) {
                if (getAuthRequestContext(obj).intValue() == 0) {
                    this.MyBillsEntityDataFactory.setText("");
                }
                if (!obj.equals("")) {
                    this.MyBillsEntityDataFactory.setText(str);
                }
                this.MyBillsEntityDataFactory.setSelection(str.length());
            }
            EditText editText = this.MyBillsEntityDataFactory;
            if (str.length() - this.PlaceComponentResult >= 0) {
                i = str.length() - this.PlaceComponentResult;
            }
            editText.setSelection(i);
            this.MyBillsEntityDataFactory.addTextChangedListener(this);
        } catch (Exception unused) {
            this.MyBillsEntityDataFactory.addTextChangedListener(this);
        }
    }

    private static Integer getAuthRequestContext(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str.replace(".", "")));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}
