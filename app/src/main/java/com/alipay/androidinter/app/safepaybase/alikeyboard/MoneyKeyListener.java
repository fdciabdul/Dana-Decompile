package com.alipay.androidinter.app.safepaybase.alikeyboard;

import android.os.Build;
import android.text.Editable;
import android.text.Spanned;
import android.text.method.NumberKeyListener;
import android.view.KeyEvent;
import android.view.View;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class MoneyKeyListener extends NumberKeyListener {
    private static final Pattern MONEY_PATTERN = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");

    @Override // android.text.method.NumberKeyListener
    protected char[] getAcceptedChars() {
        return new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'};
    }

    public static MoneyKeyListener getInstance() {
        return new MoneyKeyListener();
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return (TaoHelper.isSpecialManuFacturer("samsung") || Build.VERSION.SDK_INT >= 14 || Build.VERSION.SDK_INT >= 14) ? 128 : 0;
    }

    @Override // android.text.method.NumberKeyListener, android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        String obj = spanned.toString();
        String substring = obj.substring(0, i3);
        String substring2 = obj.substring(i4, spanned.length());
        StringBuilder sb = new StringBuilder();
        sb.append(substring);
        sb.append(charSequence2);
        sb.append(substring2);
        return !MONEY_PATTERN.matcher(sb.toString()).find() ? "" : charSequence2;
    }

    @Override // android.text.method.NumberKeyListener, android.text.method.BaseKeyListener, android.text.method.MetaKeyKeyListener, android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        return super.onKeyDown(view, editable, i, keyEvent);
    }
}
