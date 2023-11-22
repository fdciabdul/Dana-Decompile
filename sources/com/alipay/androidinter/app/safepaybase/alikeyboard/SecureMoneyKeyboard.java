package com.alipay.androidinter.app.safepaybase.alikeyboard;

import android.content.Context;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.androidinter.app.safepaybase.alikeyboard.SecureFrameLayout;
import com.alipay.androidinter.app.safepaybase.alikeyboard.SecureTextView;
import com.alipay.mobile.verifyidentity.uitools.R;
import java.util.Locale;

/* loaded from: classes6.dex */
public class SecureMoneyKeyboard extends AbstractKeyboard implements View.OnTouchListener, TextToSpeech.OnInitListener, SecureTextView.SendAccessiBilityEventListener, View.OnClickListener, SecureFrameLayout.SendAccessiBilityEventListener {
    private View fake_view;
    private Context mContext;
    private TextToSpeech mTts = null;
    private AccessibilityManager mManager = null;
    private boolean mTextToSpeechInitialized = false;

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            return onTouchDown(view);
        }
        if (motionEvent.getAction() == 1) {
            return onTouchUp(view);
        }
        return false;
    }

    private void setEventListener(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setOnClickListener(this);
        } else {
            view.setOnTouchListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.key_enter) {
            onOK();
        } else {
            onTouchDown(view);
        }
    }

    private boolean onTouchDown(View view) {
        int id2 = view.getId();
        if (id2 == R.id.key_del) {
            onDel();
            return false;
        } else if (id2 == R.id.key_space) {
            onInput(" ");
            return false;
        } else if (id2 == R.id.key_enter || !(view instanceof TextView)) {
            return false;
        } else {
            onInput(((TextView) view).getText().toString());
            return false;
        }
    }

    private boolean onTouchUp(View view) {
        if (view.getId() == R.id.key_enter) {
            onOK();
            return false;
        }
        return false;
    }

    public SecureMoneyKeyboard(Context context, OnKeyboardListener onKeyboardListener) {
        this.mContext = null;
        this.keyboardView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.keyboard_secure_money, (ViewGroup) null, false);
        this.onKeyboardListener = onKeyboardListener;
        this.mContext = context;
        initTtsIfTalkBack();
        initialize(context);
    }

    private void initialize(Context context) {
        LinearLayout linearLayout = (LinearLayout) this.keyboardView.getChildAt(0);
        int childCount = linearLayout.getChildCount();
        int rowHeight = getRowHeight(context);
        for (int i = 0; i < childCount; i++) {
            LinearLayout linearLayout2 = (LinearLayout) linearLayout.getChildAt(i);
            if (linearLayout2 != null) {
                ((LinearLayout.LayoutParams) linearLayout2.getLayoutParams()).height = rowHeight;
                int childCount2 = linearLayout2.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    View childAt = linearLayout2.getChildAt(i2);
                    setEventListener(childAt);
                    if (childAt instanceof SecureTextView) {
                        ((SecureTextView) childAt).setSendAccessiBilityEventListener(this);
                    }
                }
            }
        }
        LinearLayout linearLayout3 = (LinearLayout) this.keyboardView.getChildAt(1);
        int childCount3 = linearLayout3.getChildCount();
        for (int i3 = 0; i3 < childCount3; i3++) {
            View childAt2 = linearLayout3.getChildAt(i3);
            setEventListener(childAt2);
            if (childAt2 instanceof SecureTextView) {
                ((SecureTextView) childAt2).setSendAccessiBilityEventListener(this);
            }
            if (childAt2 instanceof SecureFrameLayout) {
                SecureFrameLayout secureFrameLayout = (SecureFrameLayout) childAt2;
                secureFrameLayout.setSendAccessiBilityEventListener(this);
                secureFrameLayout.setSendAccessiBilityEventListener(this);
                this.fake_view = secureFrameLayout.getChildAt(0);
            }
        }
    }

    private int getRowHeight(Context context) {
        double d = context.getResources().getDisplayMetrics().density;
        int i = context.getResources().getDisplayMetrics().heightPixels;
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        if (i2 <= i) {
            i = i2;
        }
        Double.isNaN(d);
        double d2 = (i - (((int) (d * 4.0d)) * 4)) / 3;
        Double.isNaN(d2);
        return (int) (d2 * 0.466d);
    }

    private void initTtsIfTalkBack() {
        this.mManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        this.keyboardView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.alipay.androidinter.app.safepaybase.alikeyboard.SecureMoneyKeyboard.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (SecureMoneyKeyboard.this.mManager.isTouchExplorationEnabled()) {
                    try {
                        SecureMoneyKeyboard.this.mTts = new TextToSpeech(SecureMoneyKeyboard.this.mContext, SecureMoneyKeyboard.this);
                    } catch (SecurityException unused) {
                        SecureMoneyKeyboard.this.mTextToSpeechInitialized = false;
                    }
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (SecureMoneyKeyboard.this.mTextToSpeechInitialized) {
                    SecureMoneyKeyboard.this.mTts.shutdown();
                    SecureMoneyKeyboard.this.mTextToSpeechInitialized = false;
                }
            }
        });
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public void onInit(int i) {
        if (i == 0) {
            if (isZhLanguage()) {
                int language = this.mTts.setLanguage(Locale.CHINA);
                if (language == -1 || language == -2) {
                    this.mTts.setLanguage(Locale.ENGLISH);
                }
            } else {
                this.mTts.setLanguage(Locale.ENGLISH);
            }
            this.mTextToSpeechInitialized = true;
        }
    }

    private boolean proccessAccessiBilityEvent(SecureTextView secureTextView, int i) {
        if (i == 128) {
            if (this.mTextToSpeechInitialized) {
                this.fake_view.sendAccessibilityEvent(32768);
                secureTextView.performAccessibilityAction(64, null);
                announceTextOut(secureTextView);
            }
            return true;
        } else if (i == 1) {
            if (this.mTextToSpeechInitialized) {
                announceTextOut(secureTextView);
            }
            return true;
        } else {
            if (i == 32768 && this.mTextToSpeechInitialized) {
                announceTextOut(secureTextView);
            }
            return true;
        }
    }

    private void announceTextOut(String str) {
        if (this.mManager.isTouchExplorationEnabled()) {
            this.mTts.speak(str, 0, null);
        }
    }

    private void announceTextOut(TextView textView) {
        String charSequence = textView.getText().toString();
        if (".".equals(charSequence)) {
            charSequence = this.mContext.getString(R.string.msp_secure_key_dot);
        }
        announceTextOut(charSequence);
    }

    private void announceTextOut(int i) {
        announceTextOut(this.mContext.getString(i));
    }

    private boolean proccessAccessiBilityEvent(SecureFrameLayout secureFrameLayout, int i) {
        if (i == 128) {
            if (this.mTextToSpeechInitialized) {
                this.fake_view.sendAccessibilityEvent(32768);
                secureFrameLayout.performAccessibilityAction(64, null);
                announceTextOut(R.string.msp_secure_keyboard_del);
            }
            return true;
        } else if (i == 1) {
            if (this.mTextToSpeechInitialized) {
                announceTextOut(R.string.msp_secure_keyboard_already_del);
            }
            return true;
        } else {
            if (i == 32768 && this.mTextToSpeechInitialized) {
                announceTextOut(R.string.msp_secure_keyboard_del);
            }
            return true;
        }
    }

    @Override // com.alipay.androidinter.app.safepaybase.alikeyboard.SecureTextView.SendAccessiBilityEventListener
    public boolean handleAccessiBilityEvent(SecureTextView secureTextView, int i) {
        return proccessAccessiBilityEvent(secureTextView, i);
    }

    @Override // com.alipay.androidinter.app.safepaybase.alikeyboard.SecureFrameLayout.SendAccessiBilityEventListener
    public boolean handleAccessiBilityEvent(SecureFrameLayout secureFrameLayout, int i) {
        return proccessAccessiBilityEvent(secureFrameLayout, i);
    }

    private boolean isZhLanguage() {
        return "zh".equals(Locale.getDefault().getLanguage());
    }

    @Override // com.alipay.androidinter.app.safepaybase.alikeyboard.AbstractKeyboard
    public View getView() {
        return super.getView();
    }
}
