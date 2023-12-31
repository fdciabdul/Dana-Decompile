package com.alipay.androidinter.app.safepaybase.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.alipay.androidinter.app.safepaybase.EncryptRandomType;
import com.alipay.androidinter.app.safepaybase.OnConfirmListener;
import com.alipay.androidinter.app.safepaybase.alikeyboard.SecureAccessbilityDelegate;
import com.alipay.androidinter.app.safepaybase.util.EditTextManager;
import com.alipay.androidinter.app.safepaybase.util.EditTextUtil;
import com.alipay.androidinter.app.safepaybase.util.ResUtils;
import com.alipay.mobile.verifyidentity.uitools.R;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.lib.drawbitmap.style.Pallette;

/* loaded from: classes6.dex */
public class SafeInputWidget implements View.OnTouchListener {
    private Activity mActivity;
    private int mBizId;
    private int mBottom;
    private Button mButtonOk;
    private boolean mIsSimplePassword;
    private int mLeft;
    private int mRight;
    private int mTop;
    private EditText mEditText = null;
    private SimplePassword mSimpleEditText = null;
    private View mButtonOkVerticalLine = null;
    private EditTextUtil util = EditTextManager.getEditTextUtils();
    private View mLocalView = null;
    private OnConfirmListener mOnConfirmListener = null;
    private View.OnFocusChangeListener mOnFocusChangeListener = null;
    private String rsaPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDENksAVqDoz5SMCZq0bsZwE+I3NjrANyTTwUVSf1+ec1PfPB4tiocEpYJFCYju9MIbawR8ivECbUWjpffZq5QllJg+19CB7V5rYGcEnb/M7CS3lFF2sNcRFJUtXUUAqyR3/l7PmpxTwObZ4DLG258dhE2vFlVGXjnuLs+FI2hg4QIDAQAB";
    private String mEncryptRandomString = "";
    private EncryptRandomType mType = EncryptRandomType.randombefore;
    private boolean isCleanIconShowing = false;
    private Drawable mCleanDrawable = null;

    public SafeInputWidget(Activity activity, boolean z, int i) {
        this.mIsSimplePassword = false;
        this.mBizId = -1;
        this.mActivity = activity;
        this.mBizId = hashCode();
        this.mIsSimplePassword = z;
        initView(activity);
        initPwdInputView(i);
    }

    private void initPwdInputView(int i) {
        if (this.mIsSimplePassword) {
            this.mEditText.setVisibility(8);
            this.mLocalView.findViewById(R.id.common_input_item).setVisibility(8);
            this.mSimpleEditText.setVisibility(0);
            this.mSimpleEditText.setBizId(this.mBizId);
            return;
        }
        this.mCleanDrawable = ResUtils.getPaddingDrawable(-1, R.drawable.input_clean_icon, this.mActivity);
        this.mEditText.setVisibility(0);
        InstrumentInjector.setAccessibilityDelegate(this.mEditText, new SecureAccessbilityDelegate());
        this.mSimpleEditText.setVisibility(8);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.alipay.androidinter.app.safepaybase.widget.SafeInputWidget.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SafeInputWidget.this.util.OnTextChanged(SafeInputWidget.this.mBizId, charSequence.toString(), i2, i3, i4);
                if (SafeInputWidget.this.mButtonOk != null) {
                    if (TextUtils.isEmpty(charSequence)) {
                        SafeInputWidget.this.mButtonOk.setTextColor(-7829368);
                        SafeInputWidget.this.mButtonOk.setClickable(false);
                    } else {
                        SafeInputWidget.this.mButtonOk.setTextColor(Color.parseColor(Pallette.BLUE_50));
                        SafeInputWidget.this.mButtonOk.setClickable(true);
                    }
                }
                SafeInputWidget.this.setCleanIcon();
            }
        });
    }

    public void setUserConfirmListener(OnConfirmListener onConfirmListener) {
        this.mOnConfirmListener = onConfirmListener;
        if (this.mIsSimplePassword) {
            this.mSimpleEditText.setmSubmitInterface(onConfirmListener);
        }
    }

    public void setRsaPublicKey(String str) {
        this.rsaPublicKey = str;
        if (this.mIsSimplePassword) {
            this.mSimpleEditText.setRsaPublicKey(str);
        }
    }

    public void setEncryptRandomStringAndType(String str, EncryptRandomType encryptRandomType) {
        this.mEncryptRandomString = str;
        this.mType = encryptRandomType;
        if (this.mIsSimplePassword) {
            this.mSimpleEditText.setEncryptRandomStringAndType(str, encryptRandomType);
        }
    }

    public EditText getEditText() {
        if (this.mIsSimplePassword) {
            return this.mSimpleEditText.getEditText();
        }
        return this.mEditText;
    }

    public View getContentView() {
        return this.mLocalView;
    }

    public void initView(Context context) {
        View inflate = View.inflate(context, R.layout.safe_input_widget, null);
        this.mLocalView = inflate;
        EditText editText = (EditText) inflate.findViewById(R.id.input_et_password);
        this.mEditText = editText;
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.alipay.androidinter.app.safepaybase.widget.SafeInputWidget.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SafeInputWidget.this.mOnFocusChangeListener != null) {
                    SafeInputWidget.this.mOnFocusChangeListener.onFocusChange(view, z);
                }
            }
        });
        SimplePassword simplePassword = (SimplePassword) this.mLocalView.findViewById(R.id.spwd_input);
        this.mSimpleEditText = simplePassword;
        simplePassword.setmSubmitInterface(this.mOnConfirmListener);
        Button button = (Button) this.mLocalView.findViewById(R.id.button_ok);
        this.mButtonOk = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.androidinter.app.safepaybase.widget.SafeInputWidget.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SafeInputWidget.this.mOnConfirmListener != null) {
                    SafeInputWidget.this.mOnConfirmListener.onUserConfirm(SafeInputWidget.this.util.getText(SafeInputWidget.this.mBizId, SafeInputWidget.this.rsaPublicKey, SafeInputWidget.this.mEncryptRandomString, SafeInputWidget.this.mType));
                }
            }
        });
        this.mButtonOk.setTextColor(-7829368);
        this.mButtonOk.setClickable(false);
        this.mButtonOkVerticalLine = this.mLocalView.findViewById(R.id.button_ok_verticalline);
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        if (this.mIsSimplePassword) {
            this.mSimpleEditText.setOnFocusChangeListener(onFocusChangeListener);
        } else {
            this.mOnFocusChangeListener = onFocusChangeListener;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.mIsSimplePassword) {
            this.mSimpleEditText.setOnClickListener(onClickListener);
        } else {
            this.mEditText.setOnClickListener(onClickListener);
        }
    }

    public String getEditContent() {
        return this.util.getText(this.mBizId, this.rsaPublicKey, this.mEncryptRandomString, this.mType);
    }

    public void clearText() {
        if (this.mIsSimplePassword) {
            this.mSimpleEditText.clearText();
        } else {
            this.mEditText.setText("");
        }
        this.util.clear(this.mBizId);
    }

    public void setNeedComfirm(boolean z) {
        if (z) {
            return;
        }
        this.mButtonOk.setVisibility(8);
        this.mButtonOkVerticalLine.setVisibility(8);
    }

    public void setOkButtonText(String str) {
        Button button = this.mButtonOk;
        if (button != null) {
            button.setText(str);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.isCleanIconShowing && this.mCleanDrawable != null) {
            int width = this.mEditText.getWidth();
            int height = this.mEditText.getHeight();
            int intrinsicWidth = this.mCleanDrawable.getIntrinsicWidth();
            int intrinsicHeight = this.mCleanDrawable.getIntrinsicHeight();
            int i = (width - intrinsicWidth) - (intrinsicWidth / 4);
            this.mLeft = i;
            int i2 = (height - intrinsicHeight) / 2;
            this.mTop = i2;
            this.mRight = i + intrinsicWidth;
            this.mBottom = i2 + intrinsicHeight;
        }
        if (this.mLeft > 0 && this.isCleanIconShowing) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x >= this.mLeft && x <= this.mRight && y >= this.mTop && y <= this.mBottom) {
                if (motionEvent.getAction() == 1) {
                    clearText();
                }
                return true;
            }
        }
        return this.mEditText.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCleanIcon() {
        if (this.mEditText.isEnabled()) {
            if (!TextUtils.isEmpty(this.mEditText.getText()) && this.mCleanDrawable != null && this.mEditText.isFocused()) {
                this.isCleanIconShowing = true;
                this.mEditText.setOnTouchListener(this);
                this.mEditText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mCleanDrawable, (Drawable) null);
                return;
            }
            this.isCleanIconShowing = false;
            this.mEditText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
