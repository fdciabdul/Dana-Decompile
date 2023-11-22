package com.alipay.androidinter.app.safepaybase.alikeyboard;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
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

/* loaded from: classes6.dex */
public class QwertyKeyboard extends AbstractKeyboard implements View.OnTouchListener {
    private FrameLayout cashierContainer;
    private FrameLayout ib_shift;
    private TextView inputTips;
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

    public QwertyKeyboard(Context context, FrameLayout frameLayout, OnKeyboardListener onKeyboardListener) {
        this.onKeyboardListener = onKeyboardListener;
        this.keyboardView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.keyboard_qwerty, (ViewGroup) null, false);
        this.cashierContainer = frameLayout;
        initialize(context);
        initializeTips(context);
    }

    private void initializeTips(Context context) {
        double d = context.getResources().getDisplayMetrics().density;
        this.inputTips = new TextView(context);
        Double.isNaN(d);
        Double.isNaN(d);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams((int) (65.0d * d), (int) (78.0d * d));
        layoutParams.gravity = 51;
        layoutParams.height = -2;
        int i = this.width;
        Double.isNaN(d);
        layoutParams.width = (i - ((int) (d * 9.0d))) * 2;
        this.inputTips.setTextSize(1, 35.0f);
        this.inputTips.setLayoutParams(layoutParams);
        this.inputTips.setTextColor(-16777216);
        this.inputTips.setBackgroundResource(R.drawable.keyborad_show);
        this.inputTips.setGravity(17);
        this.inputTips.setVisibility(4);
        FrameLayout frameLayout = this.cashierContainer;
        if (frameLayout != null) {
            frameLayout.addView(this.inputTips);
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
                        FrameLayout frameLayout = (FrameLayout) linearLayout.getChildAt(i7);
                        TextView textView = (TextView) frameLayout.getChildAt(0);
                        textView.setTextSize(0, this.textSize);
                        InstrumentInjector.setAccessibilityDelegate(textView, new SecureAccessbilityDelegate());
                        frameLayout.setOnTouchListener(this);
                        this.tv_row1[i7] = textView;
                    }
                } else if (i6 == 1) {
                    this.tv_row2 = new TextView[childCount2];
                    for (int i8 = 0; i8 < childCount2; i8++) {
                        FrameLayout frameLayout2 = (FrameLayout) linearLayout.getChildAt(i8);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout2.getLayoutParams();
                        layoutParams.width = this.width;
                        layoutParams.weight = 0.0f;
                        TextView textView2 = (TextView) frameLayout2.getChildAt(0);
                        textView2.setTextSize(0, this.textSize);
                        InstrumentInjector.setAccessibilityDelegate(textView2, new SecureAccessbilityDelegate());
                        frameLayout2.setOnTouchListener(this);
                        this.tv_row2[i8] = textView2;
                    }
                } else if (i6 == 2) {
                    this.tv_row3 = new TextView[childCount2 - 2];
                    for (int i9 = 0; i9 < childCount2; i9++) {
                        FrameLayout frameLayout3 = (FrameLayout) linearLayout.getChildAt(i9);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) frameLayout3.getLayoutParams();
                        if (i9 == 0) {
                            layoutParams2.width = i5;
                            this.ib_shift = frameLayout3;
                        } else if (i9 == childCount2 - 1) {
                            layoutParams2.width = i5;
                        } else {
                            layoutParams2.width = this.width;
                            layoutParams2.weight = 0.0f;
                            TextView textView3 = (TextView) frameLayout3.getChildAt(0);
                            textView3.setTextSize(0, this.textSize);
                            InstrumentInjector.setAccessibilityDelegate(textView3, new SecureAccessbilityDelegate());
                            this.tv_row3[i9 - 1] = textView3;
                            layoutParams2.width = this.width;
                        }
                        layoutParams2.weight = 0.0f;
                        frameLayout3.setOnTouchListener(this);
                    }
                } else {
                    for (int i10 = 0; i10 < childCount2; i10++) {
                        View childAt = linearLayout.getChildAt(i10);
                        InstrumentInjector.setAccessibilityDelegate(childAt, new SecureAccessbilityDelegate());
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        if (i10 == 0) {
                            layoutParams3.width = i5;
                            TextView textView4 = (TextView) childAt;
                            this.tv_type = textView4;
                            textView4.setTextSize(0, this.textSize);
                        } else if (i10 == 1) {
                            layoutParams3.width = this.width;
                            ((TextView) ((FrameLayout) childAt).getChildAt(0)).setTextSize(0, this.textSize);
                        } else if (i10 == 2) {
                            layoutParams3.width = i3 * 4;
                            ((TextView) ((FrameLayout) childAt).getChildAt(0)).setTextSize(0, this.textSize);
                        } else if (i10 == 3) {
                            layoutParams3.width = this.width;
                            ((TextView) ((FrameLayout) childAt).getChildAt(0)).setTextSize(0, this.textSize);
                        } else {
                            layoutParams3.width = i3 + i5;
                            ((TextView) childAt).setTextSize(0, this.textSize);
                        }
                        layoutParams3.weight = 0.0f;
                        childAt.setOnTouchListener(this);
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
        }
        this.inputTips.setVisibility(4);
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
                String charSequence = ((TextView) ((FrameLayout) view).getChildAt(0)).getText().toString();
                showInputTips(view, charSequence);
                onInput(charSequence);
            }
        }
        return false;
    }

    private void showInputTips(View view, String str) {
        if (this.cashierContainer == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.inputTips.getLayoutParams();
        Point relatePoint = getRelatePoint(this.cashierContainer, view);
        int i = relatePoint.x;
        int width = this.inputTips.getWidth() / 2;
        int width2 = view.getWidth() / 2;
        int i2 = relatePoint.y;
        int height = this.inputTips.getHeight();
        int height2 = view.getHeight();
        double d = this.screen_density;
        layoutParams.setMargins((i - width) + width2, (((i2 - height) + height2) + ((int) (3.0d * d))) - ((int) (d * 9.0d)), 0, 0);
        this.inputTips.setLayoutParams(layoutParams);
        this.inputTips.setText(str);
        this.inputTips.setVisibility(0);
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
            if (i >= textViewArr3.length) {
                return;
            }
            textViewArr3[i].setText(strArr3[i]);
            i++;
        }
    }
}
