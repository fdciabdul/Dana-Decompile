package com.iap.ac.android.acs.plugin.ui.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.acs.plugin.ui.view.VerificationCodeEditText;
import com.iap.ac.android.acs.transition.R;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class VerificationCodeInputView extends LinearLayout implements TextWatcher, View.OnKeyListener, View.OnFocusChangeListener, VerificationCodeEditText.OnTextMenuListener {
    public static final int SIZE = 4;
    public EditText[] mCodeEditTexts;
    public OnCompleteListener mOnCompleteListener;

    /* loaded from: classes8.dex */
    public interface OnCompleteListener {
        void onComplete(String str);
    }

    public VerificationCodeInputView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.acplugin_layout_verification_code_input_view, (ViewGroup) this, true);
        initView();
    }

    private void focus() {
        for (int i = 0; i < 4; i++) {
            EditText editText = this.mCodeEditTexts[i];
            Editable text = editText.getText();
            if (text != null && text.length() <= 0) {
                editText.requestFocus();
                return;
            }
        }
        this.mCodeEditTexts[3].requestFocus();
        this.mCodeEditTexts[3].setSelection(1);
    }

    private String getCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append((CharSequence) this.mCodeEditTexts[i].getText());
        }
        return sb.toString();
    }

    private void initView() {
        VerificationCodeEditText verificationCodeEditText = (VerificationCodeEditText) findViewById(R.id.code_edit_text_1);
        verificationCodeEditText.setOnTextMenuListener(this);
        this.mCodeEditTexts = new EditText[]{verificationCodeEditText, (EditText) findViewById(R.id.code_edit_text_2), (EditText) findViewById(R.id.code_edit_text_3), (EditText) findViewById(R.id.code_edit_text_4)};
        for (int i = 0; i < 4; i++) {
            EditText editText = this.mCodeEditTexts[i];
            editText.addTextChangedListener(this);
            editText.setOnKeyListener(this);
            editText.setOnFocusChangeListener(this);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable != null && editable.length() != 0) {
            focus();
        }
        Editable text = this.mCodeEditTexts[3].getText();
        if (text == null || text.length() <= 0) {
            return;
        }
        OnCompleteListener onCompleteListener = this.mOnCompleteListener;
        if (onCompleteListener != null) {
            onCompleteListener.onComplete(getCode());
        }
        UIUtils.hideSoftInput(getContext(), this);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void clear() {
        for (int i = 3; i >= 0; i--) {
            this.mCodeEditTexts[i].setText("");
        }
        this.mCodeEditTexts[0].requestFocus();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            focus();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 67 && keyEvent.getAction() == 0) {
            for (int i2 = 3; i2 >= 0; i2--) {
                EditText editText = this.mCodeEditTexts[i2];
                Editable text = editText.getText();
                if (text != null && text.length() == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("VerificationCodeInputView#onKey, delete code in position: ");
                    sb.append(i2);
                    ACLog.d("IAPConnectPlugin", sb.toString());
                    editText.setText("");
                    editText.requestFocus();
                    return false;
                }
            }
            this.mCodeEditTexts[0].requestFocus();
        }
        return false;
    }

    @Override // com.iap.ac.android.acs.plugin.ui.view.VerificationCodeEditText.OnTextMenuListener
    public void onPaste(String str) {
        if (!UIUtils.isNumeric(str)) {
            ACLog.e("IAPConnectPlugin", "VerificationCodeInputView#onPaste, content is not numeric");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VerificationCodeInputView#onPaste, content: ");
        sb.append(str);
        ACLog.d("IAPConnectPlugin", sb.toString());
        for (int i = 0; i < str.length() && i < 4; i++) {
            this.mCodeEditTexts[i].setText(String.valueOf(str.charAt(i)));
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void setOnCompleteListener(OnCompleteListener onCompleteListener) {
        this.mOnCompleteListener = onCompleteListener;
    }

    public void showSoftInput() {
        for (int i = 0; i < 4; i++) {
            EditText editText = this.mCodeEditTexts[i];
            if (editText.isFocused()) {
                UIUtils.showSoftInput(getContext(), editText);
                return;
            }
        }
    }

    public VerificationCodeInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.acplugin_layout_verification_code_input_view, (ViewGroup) this, true);
        initView();
    }

    public VerificationCodeInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.acplugin_layout_verification_code_input_view, (ViewGroup) this, true);
        initView();
    }
}
