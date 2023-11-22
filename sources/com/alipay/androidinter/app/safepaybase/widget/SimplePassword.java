package com.alipay.androidinter.app.safepaybase.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.androidinter.app.safepaybase.EncryptRandomType;
import com.alipay.androidinter.app.safepaybase.OnConfirmListener;
import com.alipay.androidinter.app.safepaybase.alikeyboard.SecureAccessbilityDelegate;
import com.alipay.androidinter.app.safepaybase.log.LogTracer;
import com.alipay.androidinter.app.safepaybase.util.EditTextManager;
import com.alipay.androidinter.app.safepaybase.util.EditTextUtil;
import com.alipay.mobile.verifyidentity.uitools.R;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class SimplePassword extends LinearLayout {
    private int inputCharCount;
    private int mBizId;
    private List<ImageView> mBlackPointList;
    private List<View> mBlackPointRlList;
    private EditText mEditText;
    private String mEncryptRandomString;
    private LinearLayout mLayout;
    private View.OnFocusChangeListener mOnFocusChangeListener;
    private String mRsaPublicKey;
    private String mSimplePassword;
    private OnConfirmListener mSubmitInterface;
    private EncryptRandomType mType;
    private EditTextUtil util;

    public SimplePassword(Context context) {
        super(context);
        this.mBizId = 0;
        this.util = EditTextManager.getEditTextUtils();
        this.mRsaPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDENksAVqDoz5SMCZq0bsZwE+I3NjrANyTTwUVSf1+ec1PfPB4tiocEpYJFCYju9MIbawR8ivECbUWjpffZq5QllJg+19CB7V5rYGcEnb/M7CS3lFF2sNcRFJUtXUUAqyR3/l7PmpxTwObZ4DLG258dhE2vFlVGXjnuLs+FI2hg4QIDAQAB";
        this.mEncryptRandomString = "";
        this.mType = EncryptRandomType.randombefore;
        this.inputCharCount = 6;
    }

    public SimplePassword(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBizId = 0;
        this.util = EditTextManager.getEditTextUtils();
        this.mRsaPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDENksAVqDoz5SMCZq0bsZwE+I3NjrANyTTwUVSf1+ec1PfPB4tiocEpYJFCYju9MIbawR8ivECbUWjpffZq5QllJg+19CB7V5rYGcEnb/M7CS3lFF2sNcRFJUtXUUAqyR3/l7PmpxTwObZ4DLG258dhE2vFlVGXjnuLs+FI2hg4QIDAQAB";
        this.mEncryptRandomString = "";
        this.mType = EncryptRandomType.randombefore;
        this.inputCharCount = 6;
        LayoutInflater.from(context).inflate(R.layout.safe_input_simple_password, (ViewGroup) this, true);
        initView();
    }

    private void initView() {
        this.mLayout = (LinearLayout) findViewById(R.id.mini_linSimplePwdComponent);
        this.mBlackPointRlList = new ArrayList();
        View findViewById = findViewById(R.id.mini_spwd_rl_1);
        View findViewById2 = findViewById(R.id.mini_spwd_rl_2);
        View findViewById3 = findViewById(R.id.mini_spwd_rl_3);
        View findViewById4 = findViewById(R.id.mini_spwd_rl_4);
        View findViewById5 = findViewById(R.id.mini_spwd_rl_5);
        View findViewById6 = findViewById(R.id.mini_spwd_rl_6);
        this.mBlackPointRlList.add(findViewById);
        this.mBlackPointRlList.add(findViewById2);
        this.mBlackPointRlList.add(findViewById3);
        this.mBlackPointRlList.add(findViewById4);
        this.mBlackPointRlList.add(findViewById5);
        this.mBlackPointRlList.add(findViewById6);
        ImageView imageView = (ImageView) findViewById(R.id.mini_spwd_iv_1);
        ImageView imageView2 = (ImageView) findViewById(R.id.mini_spwd_iv_2);
        ImageView imageView3 = (ImageView) findViewById(R.id.mini_spwd_iv_3);
        ImageView imageView4 = (ImageView) findViewById(R.id.mini_spwd_iv_4);
        ImageView imageView5 = (ImageView) findViewById(R.id.mini_spwd_iv_5);
        ImageView imageView6 = (ImageView) findViewById(R.id.mini_spwd_iv_6);
        ArrayList arrayList = new ArrayList();
        this.mBlackPointList = arrayList;
        arrayList.add(imageView);
        this.mBlackPointList.add(imageView2);
        this.mBlackPointList.add(imageView3);
        this.mBlackPointList.add(imageView4);
        this.mBlackPointList.add(imageView5);
        this.mBlackPointList.add(imageView6);
        EditText editText = (EditText) findViewById(R.id.mini_spwd_input);
        this.mEditText = editText;
        editText.setFocusable(true);
        this.mEditText.addTextChangedListener(new TextWatcherImpl());
        this.mEditText.setInputType(2);
        this.mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.mEditText.setTypeface(Typeface.MONOSPACE);
        this.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.alipay.androidinter.app.safepaybase.widget.SimplePassword.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SimplePassword.this.mOnFocusChangeListener != null) {
                    SimplePassword.this.mOnFocusChangeListener.onFocusChange(view, z);
                }
            }
        });
        this.mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.alipay.androidinter.app.safepaybase.widget.SimplePassword.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return i == 6;
            }
        });
        InstrumentInjector.setAccessibilityDelegate(this.mEditText, new SecureAccessbilityDelegate());
    }

    public void setBizId(int i) {
        this.mBizId = i;
    }

    /* loaded from: classes6.dex */
    public class TextWatcherImpl implements TextWatcher {
        private boolean skipTextChanged = false;
        private boolean isSendSubmit = false;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public TextWatcherImpl() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                int length = editable.length();
                for (int i = 0; i < length; i++) {
                    if (editable.charAt(i) != '0') {
                        this.skipTextChanged = true;
                        editable.replace(i, i + 1, "0");
                    }
                }
                SimplePassword simplePassword = SimplePassword.this;
                simplePassword.mSimplePassword = simplePassword.mEditText.getText().toString();
                SimplePassword simplePassword2 = SimplePassword.this;
                simplePassword2.setPointView(simplePassword2.mSimplePassword.length());
                if (SimplePassword.this.mSimplePassword.length() == SimplePassword.this.inputCharCount) {
                    if (SimplePassword.this.mSubmitInterface != null && !this.isSendSubmit) {
                        SimplePassword.this.mSubmitInterface.onUserConfirm(SimplePassword.this.util.getText(SimplePassword.this.mBizId, SimplePassword.this.mRsaPublicKey, SimplePassword.this.mEncryptRandomString, SimplePassword.this.mType));
                    }
                    if (this.isSendSubmit) {
                        return;
                    }
                    this.isSendSubmit = true;
                    return;
                }
                this.isSendSubmit = false;
            } catch (Exception e) {
                LogTracer.getInstance().printExceptionStackTrace(e);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!this.skipTextChanged) {
                try {
                    SimplePassword.this.util.OnTextChanged(SimplePassword.this.mBizId, charSequence.toString(), i, i2, i3);
                } catch (Throwable th) {
                    LogTracer.getInstance().printExceptionStackTrace(th);
                }
            }
            this.skipTextChanged = false;
        }
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    public void setmSubmitInterface(OnConfirmListener onConfirmListener) {
        this.mSubmitInterface = onConfirmListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPointView(int i) {
        for (int i2 = 0; i2 < this.mBlackPointList.size(); i2++) {
            if (i2 < i) {
                if (Build.VERSION.SDK_INT < 16) {
                    this.mBlackPointList.get(i2).setBackgroundDrawable(InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.password_point_selected));
                } else {
                    this.mBlackPointList.get(i2).setBackground(InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.password_point_selected));
                }
            } else if (Build.VERSION.SDK_INT < 16) {
                this.mBlackPointList.get(i2).setBackgroundDrawable(InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.password_point));
            } else {
                this.mBlackPointList.get(i2).setBackground(InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.password_point));
            }
        }
    }

    public void setInputCharCount(int i) {
        if (i != 0) {
            this.inputCharCount = i;
            this.mEditText.setMaxLines(i);
            for (int i2 = 0; i2 < this.mBlackPointRlList.size(); i2++) {
                if (i2 < i) {
                    this.mBlackPointRlList.get(i2).setVisibility(0);
                    if (i2 == i - 1) {
                        if (Build.VERSION.SDK_INT < 16) {
                            this.mBlackPointRlList.get(i2).setBackgroundDrawable(InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.mini_simple_pwd_right));
                        } else {
                            this.mBlackPointRlList.get(i2).setBackground(InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.mini_simple_pwd_right));
                        }
                    }
                } else {
                    this.mBlackPointRlList.get(i2).setVisibility(8);
                }
            }
        }
    }

    public void clearText() {
        EditText editText = this.mEditText;
        if (editText != null) {
            editText.setText("");
            this.util.clear(this.mBizId);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mLayout.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mOnFocusChangeListener = onFocusChangeListener;
    }

    public void setRsaPublicKey(String str) {
        this.mRsaPublicKey = str;
    }

    public void setEncryptRandomStringAndType(String str, EncryptRandomType encryptRandomType) {
        this.mEncryptRandomString = str;
        this.mType = encryptRandomType;
    }
}
