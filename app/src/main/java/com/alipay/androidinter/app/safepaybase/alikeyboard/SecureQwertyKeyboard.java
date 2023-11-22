package com.alipay.androidinter.app.safepaybase.alikeyboard;

import android.content.Context;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alipay.androidinter.app.safepaybase.alikeyboard.SecureFrameLayout;
import com.alipay.androidinter.app.safepaybase.alikeyboard.SecureTextView;
import com.alipay.androidinter.app.safepaybase.util.ResUtils;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.alipay.mobile.rome.syncsdk.transport.connection.f;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipay.mobile.verifyidentity.uitools.R;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.push.e;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.j256.ormlite.stmt.query.SimpleComparison;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes6.dex */
public class SecureQwertyKeyboard extends AbstractKeyboard implements View.OnClickListener, View.OnTouchListener, TextToSpeech.OnInitListener {
    private static final Map<String, String> signMap = new HashMap<String, String>() { // from class: com.alipay.androidinter.app.safepaybase.alikeyboard.SecureQwertyKeyboard.4
        {
            put("~", "msp_secure_key_tilde");
            put("!", "msp_secure_key_exclamation_point");
            put(AUScreenAdaptTool.PREFIX_ID, "msp_secure_key_at");
            put("#", "msp_secure_key_sharp");
            put("%", "msp_secure_key_percent");
            put("'", "msp_secure_key_quotesingle");
            put(ContainerUtils.FIELD_DELIMITER, "msp_secure_key_and");
            put("*", "msp_secure_key_star");
            put("?", "msp_secure_key_ask");
            put("(", "msp_secure_key_left_bracket");
            put(")", "msp_secure_key_right_bracket");
            put("-", "msp_secure_key_minus");
            put("_", "msp_secure_key_underscore");
            put(":", "msp_secure_key_colon");
            put(";", "msp_secure_key_semiconlon");
            put("/", "msp_secure_key_slash");
            put(SimpleComparison.LESS_THAN_OPERATION, "msp_secure_key_less");
            put(SimpleComparison.GREATER_THAN_OPERATION, "msp_secure_key_more");
            put("+", "msp_secure_key_plus");
            put("=", "msp_secure_key_equal");
            put("÷", "msp_secure_key_divide");
            put("^", "msp_secure_key_hat");
            put("`", "msp_secure_key_apostrophe");
            put("[", "msp_secure_key_left_square");
            put("]", "msp_secure_key_right_square");
            put("\\", "msp_secure_key_backslash");
            put(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "msp_secure_key_vertical");
            put("\"", "msp_secure_key_quotedouble");
            put("$", "msp_secure_key_dollar");
            put("￥", "msp_secure_key_money");
            put("{", "msp_secure_key_left_brace");
            put("}", "msp_secure_key_right_brace");
            put(",", "msp_secure_key_comma");
            put(".", "msp_secure_key_dot");
        }
    };
    private FrameLayout cashierContainer;
    private View fake_view;
    private FrameLayout ib_shift;
    private Context mContext;
    private TextView tv_type;
    private QwertType qwertType = QwertType.abc;
    private ShiftType shiftType = ShiftType.up;
    private TextView[] tv_row1 = new TextView[10];
    private TextView[] tv_row2 = new TextView[9];
    private TextView[] tv_row3 = new TextView[7];
    private final String[] QWERT_ABC_SHIFT_UP_ROW_0 = {HereUrlConstant.QUERY, "w", e.PlaceComponentResult, BranchLinkConstant.PayloadKey.REFERRAL, SecurityConstants.KEY_TEXT, "y", "u", i.MyBillsEntityDataFactory, "o", BranchLinkConstant.PayloadKey.PROMO_CODE};
    private final String[] QWERT_ABC_SHIFT_UP_ROW_1 = {"a", "s", d.f7256a, f.f7258a, "g", "h", "j", "k", "l"};
    private final String[] QWERT_ABC_SHIFT_UP_ROW_2 = {"z", "x", "c", SecurityConstants.KEY_VALUE, "b", "n", "m"};
    private final String[] QWERT_ABC_SHIFT_DOWN_ROW_0 = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"};
    private final String[] QWERT_ABC_SHIFT_DOWN_ROW_1 = {"A", "S", SummaryActivity.DAYS, LogConstants.RESULT_FALSE, DiskFormatter.GB, SummaryActivity.HOURS, "J", DiskFormatter.KB, "L"};
    private final String[] QWERT_ABC_SHIFT_DOWN_ROW_2 = {"Z", "X", "C", "V", DiskFormatter.B, "N", DiskFormatter.MB};
    private final String[] QWERT_123_SHIFT_UP_ROW_0 = {"1", "2", "3", "4", "5", "6", "7", "8", PrepareException.ERROR_OFFLINE_APP, "0"};
    private final String[] QWERT_123_SHIFT_UP_ROW_1 = {"~", "!", AUScreenAdaptTool.PREFIX_ID, "#", "%", "'", ContainerUtils.FIELD_DELIMITER, "*", "?"};
    private final String[] QWERT_123_SHIFT_UP_ROW_2 = {"(", ")", "-", "_", ":", ";", "/"};
    private final String[] QWERT_123_SHIFT_DOWN_ROW_0 = {"1", "2", "3", "4", "5", "6", "7", "8", PrepareException.ERROR_OFFLINE_APP, "0"};
    private final String[] QWERT_123_SHIFT_DOWN_ROW_1 = {SimpleComparison.LESS_THAN_OPERATION, SimpleComparison.GREATER_THAN_OPERATION, "+", "=", "÷", "^", "`", "[", "]"};
    private final String[] QWERT_123_SHIFT_DOWN_ROW_2 = {"\\", HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "\"", "$", "￥", "{", "}"};
    private double screen_density = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    private int width = 0;
    private float textSize = 0.0f;
    private TextToSpeech mTts = null;
    private AccessibilityManager mManager = null;
    private boolean mTextToSpeechInitialized = false;
    SecureTextView.SendAccessiBilityEventListener stvAccessListener = new SecureTextView.SendAccessiBilityEventListener() { // from class: com.alipay.androidinter.app.safepaybase.alikeyboard.SecureQwertyKeyboard.2
        @Override // com.alipay.androidinter.app.safepaybase.alikeyboard.SecureTextView.SendAccessiBilityEventListener
        public boolean handleAccessiBilityEvent(SecureTextView secureTextView, int i) {
            if (secureTextView.getParent() == null || !(secureTextView.getParent() instanceof SecureFrameLayout)) {
                return true;
            }
            ((SecureFrameLayout) secureTextView.getParent()).sendAccessibilityEvent(i);
            return true;
        }
    };
    SecureFrameLayout.SendAccessiBilityEventListener sflAccessListenr = new SecureFrameLayout.SendAccessiBilityEventListener() { // from class: com.alipay.androidinter.app.safepaybase.alikeyboard.SecureQwertyKeyboard.3
        @Override // com.alipay.androidinter.app.safepaybase.alikeyboard.SecureFrameLayout.SendAccessiBilityEventListener
        public boolean handleAccessiBilityEvent(SecureFrameLayout secureFrameLayout, int i) {
            if (i == 128) {
                if (SecureQwertyKeyboard.this.mTextToSpeechInitialized) {
                    SecureQwertyKeyboard.this.fake_view.sendAccessibilityEvent(32768);
                    secureFrameLayout.performAccessibilityAction(64, null);
                    SecureQwertyKeyboard.this.announceTextOut(SecureQwertyKeyboard.this.getAnnounceString(secureFrameLayout, i));
                }
                return true;
            } else if (i == 1) {
                if (SecureQwertyKeyboard.this.mTextToSpeechInitialized && secureFrameLayout.getId() != R.id.key_ABC && secureFrameLayout.getId() != R.id.key_123) {
                    SecureQwertyKeyboard.this.announceTextOut(SecureQwertyKeyboard.this.getAnnounceString(secureFrameLayout, i));
                }
                return true;
            } else {
                if (i == 32768 && SecureQwertyKeyboard.this.mTextToSpeechInitialized) {
                    SecureQwertyKeyboard.this.announceTextOut(SecureQwertyKeyboard.this.getAnnounceString(secureFrameLayout, i));
                }
                return true;
            }
        }
    };

    /* loaded from: classes6.dex */
    public enum QwertType {
        abc,
        num
    }

    /* loaded from: classes6.dex */
    public enum ShiftType {
        up,
        down
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.key_enter) {
            onOK();
        } else {
            onTouchDown(view);
        }
    }

    public SecureQwertyKeyboard(Context context, FrameLayout frameLayout, OnKeyboardListener onKeyboardListener) {
        this.mContext = null;
        this.onKeyboardListener = onKeyboardListener;
        this.keyboardView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.keyboard_secure_qwerty, (ViewGroup) null, false);
        this.cashierContainer = frameLayout;
        this.mContext = context;
        initTtsIfTalkBack();
        initialize(context);
    }

    private void setEventListener(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setOnClickListener(this);
        } else {
            view.setOnTouchListener(this);
        }
    }

    private void initialize(Context context) {
        int childCount = this.keyboardView.getChildCount();
        this.screen_density = context.getResources().getDisplayMetrics().density;
        int i = context.getResources().getDisplayMetrics().heightPixels;
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        if (i2 <= i) {
            i = i2;
        }
        double d = i;
        double d2 = this.screen_density;
        double d3 = 1.5d * d2 * 2.0d;
        Double.isNaN(d);
        int i3 = ((int) (d - d3)) / 10;
        this.width = i3;
        double d4 = i3;
        double d5 = 4.5d * d2;
        Double.isNaN(d4);
        int i4 = (int) (((d4 - (d5 * 2.0d)) * 1.45d) + (d2 * 7.0d * 2.0d));
        double d6 = i - (i3 * 7);
        Double.isNaN(d6);
        int i5 = ((int) ((d6 - d3) - (d5 * 4.0d))) / 2;
        Double.isNaN(d4);
        this.textSize = (float) (d4 * 0.65d);
        for (int i6 = 0; i6 < childCount; i6++) {
            LinearLayout linearLayout = (LinearLayout) this.keyboardView.getChildAt(i6);
            if (linearLayout != null) {
                ((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).height = i4;
                int childCount2 = linearLayout.getChildCount();
                if (i6 == 0) {
                    this.tv_row1 = new TextView[childCount2];
                    for (int i7 = 0; i7 < childCount2; i7++) {
                        SecureFrameLayout secureFrameLayout = (SecureFrameLayout) linearLayout.getChildAt(i7);
                        SecureTextView secureTextView = (SecureTextView) secureFrameLayout.getChildAt(0);
                        secureTextView.setTextSize(0, this.textSize);
                        setEventListener(secureFrameLayout);
                        this.tv_row1[i7] = secureTextView;
                        secureTextView.setSendAccessiBilityEventListener(this.stvAccessListener);
                        secureFrameLayout.setSendAccessiBilityEventListener(this.sflAccessListenr);
                    }
                } else if (i6 == 1) {
                    this.tv_row2 = new TextView[childCount2];
                    for (int i8 = 0; i8 < childCount2; i8++) {
                        SecureFrameLayout secureFrameLayout2 = (SecureFrameLayout) linearLayout.getChildAt(i8);
                        SecureTextView secureTextView2 = (SecureTextView) secureFrameLayout2.getChildAt(0);
                        secureTextView2.setTextSize(0, this.textSize);
                        setEventListener(secureFrameLayout2);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) secureFrameLayout2.getLayoutParams();
                        layoutParams.width = this.width;
                        layoutParams.weight = 0.0f;
                        this.tv_row2[i8] = secureTextView2;
                        secureTextView2.setSendAccessiBilityEventListener(this.stvAccessListener);
                        secureFrameLayout2.setSendAccessiBilityEventListener(this.sflAccessListenr);
                    }
                } else if (i6 == 2) {
                    this.tv_row3 = new TextView[childCount2 - 2];
                    for (int i9 = 0; i9 < childCount2; i9++) {
                        SecureFrameLayout secureFrameLayout3 = (SecureFrameLayout) linearLayout.getChildAt(i9);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) secureFrameLayout3.getLayoutParams();
                        if (i9 == 0) {
                            layoutParams2.width = i5;
                            this.ib_shift = secureFrameLayout3;
                        } else if (i9 == childCount2 - 1) {
                            layoutParams2.width = i5;
                            this.fake_view = secureFrameLayout3.getChildAt(0);
                        } else {
                            layoutParams2.width = this.width;
                            layoutParams2.weight = 0.0f;
                            SecureTextView secureTextView3 = (SecureTextView) secureFrameLayout3.getChildAt(0);
                            secureTextView3.setTextSize(0, this.textSize);
                            InstrumentInjector.setAccessibilityDelegate(secureTextView3, new SecureAccessbilityDelegate());
                            this.tv_row3[i9 - 1] = secureTextView3;
                            secureTextView3.setSendAccessiBilityEventListener(this.stvAccessListener);
                        }
                        layoutParams2.weight = 0.0f;
                        setEventListener(secureFrameLayout3);
                        secureFrameLayout3.setSendAccessiBilityEventListener(this.sflAccessListenr);
                    }
                } else {
                    for (int i10 = 0; i10 < childCount2; i10++) {
                        View childAt = linearLayout.getChildAt(i10);
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        if (i10 == 0) {
                            layoutParams3.width = i5;
                            this.tv_type = (TextView) ((FrameLayout) childAt).getChildAt(0);
                        } else if (i10 == 1) {
                            layoutParams3.width = this.width;
                        } else if (i10 == 2) {
                            layoutParams3.width = i3 * 4;
                        } else if (i10 == 3) {
                            layoutParams3.width = this.width;
                        } else {
                            layoutParams3.width = i3 + i5;
                        }
                        layoutParams3.weight = 0.0f;
                        setEventListener(childAt);
                        if (childAt instanceof SecureFrameLayout) {
                            SecureFrameLayout secureFrameLayout4 = (SecureFrameLayout) childAt;
                            secureFrameLayout4.setSendAccessiBilityEventListener(this.sflAccessListenr);
                            TextView textView = (TextView) secureFrameLayout4.getChildAt(0);
                            textView.setTextSize(0, this.textSize);
                            if (textView instanceof SecureTextView) {
                                ((SecureTextView) textView).setSendAccessiBilityEventListener(this.stvAccessListener);
                            }
                        }
                    }
                }
            }
        }
    }

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

    private boolean onTouchUp(View view) {
        if (view.getId() == R.id.key_enter) {
            onOK();
            return false;
        }
        return false;
    }

    private boolean onTouchDown(View view) {
        int id2 = view.getId();
        if (id2 == R.id.key_del1) {
            onDel();
        } else if (id2 != R.id.key_enter) {
            if (id2 == R.id.key_space) {
                onInput(" ");
            } else if (id2 == R.id.key_ABC) {
                ShiftType shiftType = this.shiftType == ShiftType.up ? ShiftType.down : ShiftType.up;
                this.shiftType = shiftType;
                switchKeyboard(this.qwertType, shiftType);
            } else if (id2 == R.id.key_123) {
                this.qwertType = this.qwertType == QwertType.abc ? QwertType.num : QwertType.abc;
                ShiftType shiftType2 = ShiftType.up;
                this.shiftType = shiftType2;
                switchKeyboard(this.qwertType, shiftType2);
            } else {
                onInput(((TextView) ((FrameLayout) view).getChildAt(0)).getText().toString());
            }
        }
        return false;
    }

    private void switchKeyboard(QwertType qwertType, ShiftType shiftType) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        int i = 0;
        if (qwertType == QwertType.abc) {
            this.ib_shift.getChildAt(0).setVisibility(0);
            this.ib_shift.getChildAt(1).setVisibility(8);
            this.tv_type.setText("123");
            if (shiftType == ShiftType.up) {
                InstrumentInjector.Resources_setImageResource((ImageView) this.ib_shift.getChildAt(0), R.drawable.keyboard_key_shift_up);
                strArr = this.QWERT_ABC_SHIFT_UP_ROW_0;
                strArr2 = this.QWERT_ABC_SHIFT_UP_ROW_1;
                strArr3 = this.QWERT_ABC_SHIFT_UP_ROW_2;
            } else {
                InstrumentInjector.Resources_setImageResource((ImageView) this.ib_shift.getChildAt(0), R.drawable.keyboard_key_shift_down);
                strArr = this.QWERT_ABC_SHIFT_DOWN_ROW_0;
                strArr2 = this.QWERT_ABC_SHIFT_DOWN_ROW_1;
                strArr3 = this.QWERT_ABC_SHIFT_DOWN_ROW_2;
            }
        } else {
            this.ib_shift.getChildAt(0).setVisibility(8);
            this.ib_shift.getChildAt(1).setVisibility(0);
            if (this.ib_shift.getChildAt(1) instanceof TextView) {
                ((TextView) this.ib_shift.getChildAt(1)).setTextSize(0, this.textSize);
            }
            this.tv_type.setText("abc");
            if (shiftType == ShiftType.up) {
                ((TextView) this.ib_shift.getChildAt(1)).setText("123");
                strArr = this.QWERT_123_SHIFT_UP_ROW_0;
                strArr2 = this.QWERT_123_SHIFT_UP_ROW_1;
                strArr3 = this.QWERT_123_SHIFT_UP_ROW_2;
            } else {
                ((TextView) this.ib_shift.getChildAt(1)).setText("#+=");
                strArr = this.QWERT_123_SHIFT_DOWN_ROW_0;
                strArr2 = this.QWERT_123_SHIFT_DOWN_ROW_1;
                strArr3 = this.QWERT_123_SHIFT_DOWN_ROW_2;
            }
        }
        int i2 = 0;
        while (true) {
            TextView[] textViewArr = this.tv_row1;
            if (i2 >= textViewArr.length) {
                break;
            }
            textViewArr[i2].setText(strArr[i2]);
            i2++;
        }
        int i3 = 0;
        while (true) {
            TextView[] textViewArr2 = this.tv_row2;
            if (i3 >= textViewArr2.length) {
                break;
            }
            textViewArr2[i3].setText(strArr2[i3]);
            i3++;
        }
        while (true) {
            TextView[] textViewArr3 = this.tv_row3;
            if (i < textViewArr3.length) {
                textViewArr3[i].setText(strArr3[i]);
                i++;
            } else {
                announceSwitchKeyboard(qwertType, shiftType);
                return;
            }
        }
    }

    private void announceSwitchKeyboard(QwertType qwertType, ShiftType shiftType) {
        String string;
        if (this.mTextToSpeechInitialized) {
            if (qwertType == QwertType.abc) {
                if (shiftType == ShiftType.up) {
                    string = this.mContext.getString(R.string.msp_secure_keyboard_type_lowercase_letter);
                } else {
                    string = this.mContext.getString(R.string.msp_secure_keyboard_type_uppercase_letter);
                }
            } else if (shiftType == ShiftType.up) {
                string = this.mContext.getString(R.string.msp_secure_keyboard_type_digital_sign);
            } else {
                string = this.mContext.getString(R.string.msp_secure_keyboard_type_special_sign);
            }
            if (this.mManager.isTouchExplorationEnabled()) {
                this.mTts.speak(string, 0, null);
            }
        }
    }

    private void initTtsIfTalkBack() {
        this.mManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        this.keyboardView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.alipay.androidinter.app.safepaybase.alikeyboard.SecureQwertyKeyboard.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (SecureQwertyKeyboard.this.mManager.isTouchExplorationEnabled()) {
                    try {
                        SecureQwertyKeyboard.this.mTts = new TextToSpeech(SecureQwertyKeyboard.this.mContext, SecureQwertyKeyboard.this);
                    } catch (SecurityException unused) {
                        SecureQwertyKeyboard.this.mTextToSpeechInitialized = false;
                    }
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (SecureQwertyKeyboard.this.mTextToSpeechInitialized) {
                    SecureQwertyKeyboard.this.mTts.shutdown();
                    SecureQwertyKeyboard.this.mTextToSpeechInitialized = false;
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

    private boolean isZhLanguage() {
        return "zh".equals(Locale.getDefault().getLanguage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void announceTextOut(String str) {
        if (this.mManager.isTouchExplorationEnabled()) {
            this.mTts.speak(str, 0, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAnnounceString(SecureFrameLayout secureFrameLayout, int i) {
        int id2 = secureFrameLayout.getId();
        if (id2 == R.id.key_del1) {
            return i == 1 ? this.mContext.getString(R.string.msp_secure_keyboard_already_del) : this.mContext.getString(R.string.msp_secure_keyboard_del);
        } else if (id2 == R.id.key_space) {
            return this.mContext.getString(R.string.msp_secure_keyboard_space);
        } else {
            if (id2 == R.id.key_ABC) {
                if (this.ib_shift.getChildAt(0).getVisibility() == 0) {
                    return this.mContext.getString(R.string.msp_secure_keyboard_shift);
                }
                return ((TextView) secureFrameLayout.getChildAt(1)).getText().toString();
            } else if (id2 == R.id.key_enter) {
                return this.mContext.getString(R.string.msp_secure_keyboard_compelete);
            } else {
                return convertIfSpecial(((TextView) secureFrameLayout.getChildAt(0)).getText().toString());
            }
        }
    }

    private String convertIfSpecial(String str) {
        String str2 = signMap.get(str);
        return str2 != null ? this.mContext.getString(ResUtils.getStringId(str2)) : str;
    }

    @Override // com.alipay.androidinter.app.safepaybase.alikeyboard.AbstractKeyboard
    public View getView() {
        return super.getView();
    }
}
