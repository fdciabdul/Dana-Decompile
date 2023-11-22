package com.alipay.androidinter.app.safepaybase.alikeyboard;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.alipay.androidinter.app.safepaybase.util.ResUtils;
import com.alipay.mobile.verifyidentity.uitools.R;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class AlipayKeyboard extends LinearLayout implements OnKeyboardListener {
    private static final Object LOCK_SHOW_KEYBOARD = new Object();
    private AliKeyboardAction cachedKeyboardAction;
    private AliKeyboardType currentKeyboard;
    private EditText editText;
    private boolean isShowKeyboard;
    private boolean isSwitchedSystemKeyboard;
    private final HashMap<AliKeyboardType, AbstractKeyboard> keyboardMap;
    private AlipayKeyboardActionListener mActionListener;
    private StatisticInterface mStatisticImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public enum AliKeyboardAction {
        None,
        Show,
        Hide
    }

    public boolean isShowKeyboard() {
        return this.isShowKeyboard;
    }

    public AlipayKeyboard(Context context) {
        super(context);
        this.currentKeyboard = AliKeyboardType.none;
        this.keyboardMap = new HashMap<>();
        this.isShowKeyboard = false;
        this.isSwitchedSystemKeyboard = false;
        this.cachedKeyboardAction = AliKeyboardAction.None;
        this.mActionListener = null;
        this.mStatisticImpl = null;
        ResUtils.setUiContext(context);
    }

    public AlipayKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentKeyboard = AliKeyboardType.none;
        this.keyboardMap = new HashMap<>();
        this.isShowKeyboard = false;
        this.isSwitchedSystemKeyboard = false;
        this.cachedKeyboardAction = AliKeyboardAction.None;
        this.mActionListener = null;
        this.mStatisticImpl = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alipay.androidinter.app.safepaybase.alikeyboard.AlipayKeyboard$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$alipay$androidinter$app$safepaybase$alikeyboard$AliKeyboardType;

        static {
            int[] iArr = new int[AliKeyboardType.values().length];
            $SwitchMap$com$alipay$androidinter$app$safepaybase$alikeyboard$AliKeyboardType = iArr;
            try {
                iArr[AliKeyboardType.none.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alipay$androidinter$app$safepaybase$alikeyboard$AliKeyboardType[AliKeyboardType.abc.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alipay$androidinter$app$safepaybase$alikeyboard$AliKeyboardType[AliKeyboardType.money.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alipay$androidinter$app$safepaybase$alikeyboard$AliKeyboardType[AliKeyboardType.num.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alipay$androidinter$app$safepaybase$alikeyboard$AliKeyboardType[AliKeyboardType.idcard.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alipay$androidinter$app$safepaybase$alikeyboard$AliKeyboardType[AliKeyboardType.phone.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void switchKeyboard() {
        switch (AnonymousClass2.$SwitchMap$com$alipay$androidinter$app$safepaybase$alikeyboard$AliKeyboardType[this.currentKeyboard.ordinal()]) {
            case 1:
                initializeNoneKeyboard();
                return;
            case 2:
                initializeQwertyKeyboard();
                return;
            case 3:
                initializeMoneyKeyboard();
                return;
            case 4:
                initializeNumKeyboard();
                return;
            case 5:
                initializeIdcardKeyboard();
                return;
            case 6:
                initializePhoneKeyboard();
                return;
            default:
                initializeQwertyKeyboard();
                return;
        }
    }

    public void initializeKeyboard(FrameLayout frameLayout) {
        if (Build.VERSION.SDK_INT >= 16 && ((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            this.keyboardMap.put(AliKeyboardType.num, new SecureNumKeyboard(getContext(), this));
            this.keyboardMap.put(AliKeyboardType.money, new SecureMoneyKeyboard(getContext(), this));
            this.keyboardMap.put(AliKeyboardType.abc, new SecureQwertyKeyboard(getContext(), frameLayout, this));
            this.keyboardMap.put(AliKeyboardType.idcard, new SecureNumKeyboard(getContext(), this, 2));
            this.keyboardMap.put(AliKeyboardType.phone, new SecureNumKeyboard(getContext(), this, 1));
        } else {
            this.keyboardMap.put(AliKeyboardType.num, new NumKeyboard(getContext(), this));
            this.keyboardMap.put(AliKeyboardType.money, new MoneyKeyboard(getContext(), this));
            this.keyboardMap.put(AliKeyboardType.abc, new QwertyKeyboard(getContext(), frameLayout, this));
            this.keyboardMap.put(AliKeyboardType.idcard, new NumKeyboard(getContext(), this, 2));
            this.keyboardMap.put(AliKeyboardType.phone, new NumKeyboard(getContext(), this, 1));
        }
        setOrientation(1);
        setBackgroundResource(R.drawable.keyboard_shape);
        removeAllViews();
    }

    private void initializeNoneKeyboard() {
        hideKeyboard();
    }

    private void initializeNumKeyboard() {
        removeAllViews();
        addView(this.keyboardMap.get(AliKeyboardType.num).getView());
    }

    private void initializeMoneyKeyboard() {
        EditText editText = this.editText;
        if (editText != null) {
            editText.setKeyListener(new MoneyKeyListener());
        }
        removeAllViews();
        addView(this.keyboardMap.get(AliKeyboardType.money).getView());
    }

    private void initializeQwertyKeyboard() {
        removeAllViews();
        addView(this.keyboardMap.get(AliKeyboardType.abc).getView());
    }

    private void initializeIdcardKeyboard() {
        removeAllViews();
        addView(this.keyboardMap.get(AliKeyboardType.idcard).getView());
    }

    private void initializePhoneKeyboard() {
        removeAllViews();
        addView(this.keyboardMap.get(AliKeyboardType.phone).getView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showKeyboard(AliKeyboardType aliKeyboardType, EditText editText) {
        synchronized (LOCK_SHOW_KEYBOARD) {
            this.cachedKeyboardAction = AliKeyboardAction.None;
            this.isShowKeyboard = true;
            this.editText = editText;
            if (editText != null && !(editText instanceof SecureEditText) && aliKeyboardType != AliKeyboardType.money) {
                InstrumentInjector.setAccessibilityDelegate(this.editText, new SecureAccessbilityDelegate());
            }
            if (this.currentKeyboard != aliKeyboardType) {
                this.currentKeyboard = aliKeyboardType;
                switchKeyboard();
            }
            setVisibility(0);
        }
    }

    public void showKeyboard(final AliKeyboardType aliKeyboardType, final EditText editText, long j) {
        if (this.isSwitchedSystemKeyboard) {
            this.isSwitchedSystemKeyboard = false;
            j = 200;
        }
        if (j <= 0) {
            showKeyboard(aliKeyboardType, editText);
            return;
        }
        this.isShowKeyboard = true;
        this.cachedKeyboardAction = AliKeyboardAction.Show;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alipay.androidinter.app.safepaybase.alikeyboard.AlipayKeyboard.1
            @Override // java.lang.Runnable
            public void run() {
                if (AlipayKeyboard.this.cachedKeyboardAction == AliKeyboardAction.Show) {
                    AlipayKeyboard.this.showKeyboard(aliKeyboardType, editText);
                } else if (AlipayKeyboard.this.cachedKeyboardAction == AliKeyboardAction.Hide) {
                    AlipayKeyboard.this.hideKeyboard();
                }
            }
        }, j);
    }

    public void hideKeyboard() {
        synchronized (LOCK_SHOW_KEYBOARD) {
            this.cachedKeyboardAction = AliKeyboardAction.None;
            this.isShowKeyboard = false;
            this.editText = null;
            this.currentKeyboard = AliKeyboardType.none;
            setVisibility(8);
        }
    }

    @Override // com.alipay.androidinter.app.safepaybase.alikeyboard.OnKeyboardListener
    public void onDel() {
        AlipayKeyboardActionListener alipayKeyboardActionListener = this.mActionListener;
        if (alipayKeyboardActionListener != null) {
            alipayKeyboardActionListener.onDel();
        }
        EditText editText = this.editText;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionStart = this.editText.getSelectionStart();
        int selectionEnd = this.editText.getSelectionEnd();
        if (selectionStart <= 0) {
            return;
        }
        if (selectionStart == selectionEnd) {
            this.editText.getText().delete(selectionStart - 1, selectionStart);
        } else {
            this.editText.getText().delete(selectionStart, selectionEnd);
        }
    }

    @Override // com.alipay.androidinter.app.safepaybase.alikeyboard.OnKeyboardListener
    public void onOK() {
        AlipayKeyboardActionListener alipayKeyboardActionListener = this.mActionListener;
        if (alipayKeyboardActionListener != null) {
            alipayKeyboardActionListener.onOk();
        }
        hideKeyboard();
    }

    @Override // com.alipay.androidinter.app.safepaybase.alikeyboard.OnKeyboardListener
    public void onInput(String str) {
        AlipayKeyboardActionListener alipayKeyboardActionListener = this.mActionListener;
        if (alipayKeyboardActionListener != null) {
            alipayKeyboardActionListener.onInput(str);
        }
        EditText editText = this.editText;
        if (editText == null) {
            return;
        }
        int selectionStart = editText.getSelectionStart();
        this.editText.getText().insert(selectionStart, str);
        setSelection(this.editText, selectionStart + str.length());
    }

    @Override // com.alipay.androidinter.app.safepaybase.alikeyboard.OnKeyboardListener
    public void onStatisticEvent(String str) {
        StatisticInterface statisticInterface = this.mStatisticImpl;
        if (statisticInterface != null) {
            statisticInterface.onStatistic(str);
        }
    }

    private void setSelection(EditText editText, int i) {
        Editable editableText;
        if (editText == null || (editableText = editText.getEditableText()) == null) {
            return;
        }
        int length = editableText.length();
        if (i < 0 || i > length) {
            Selection.setSelection(editableText, length);
        } else {
            Selection.setSelection(editableText, i);
        }
    }

    public void setKeyboardActionListener(AlipayKeyboardActionListener alipayKeyboardActionListener) {
        this.mActionListener = alipayKeyboardActionListener;
    }

    public void setStatisticInterface(StatisticInterface statisticInterface) {
        this.mStatisticImpl = statisticInterface;
    }
}
