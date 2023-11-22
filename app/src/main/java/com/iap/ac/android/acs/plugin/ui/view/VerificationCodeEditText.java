package com.iap.ac.android.acs.plugin.ui.view;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class VerificationCodeEditText extends EditText {
    public OnTextMenuListener mOnTextMenuListener;

    /* loaded from: classes8.dex */
    public interface OnTextMenuListener {
        void onPaste(String str);
    }

    public VerificationCodeEditText(Context context) {
        super(context);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        ClipboardManager clipboardManager;
        ClipData.Item itemAt;
        if (i == 16908322 && (clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard")) != null && clipboardManager.hasPrimaryClip() && clipboardManager.getPrimaryClip() != null && clipboardManager.getPrimaryClipDescription() != null && clipboardManager.getPrimaryClipDescription().hasMimeType("text/plain") && (itemAt = clipboardManager.getPrimaryClip().getItemAt(0)) != null && !TextUtils.isEmpty(itemAt.getText())) {
            String charSequence = itemAt.getText().toString();
            StringBuilder sb = new StringBuilder();
            sb.append("VerificationCodeEditText#onTextContextMenuItem, paste: ");
            sb.append(charSequence);
            ACLog.d("IAPConnectPlugin", sb.toString());
            OnTextMenuListener onTextMenuListener = this.mOnTextMenuListener;
            if (onTextMenuListener != null) {
                onTextMenuListener.onPaste(charSequence);
            }
        }
        return super.onTextContextMenuItem(i);
    }

    public void setOnTextMenuListener(OnTextMenuListener onTextMenuListener) {
        this.mOnTextMenuListener = onTextMenuListener;
    }

    public VerificationCodeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VerificationCodeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
