package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import com.airbnb.lottie.utils.MiscUtils;
import com.google.android.flexbox.FlexItem;

/* loaded from: classes3.dex */
public class LPaint extends Paint {
    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    public LPaint() {
    }

    public LPaint(int i) {
        super(i);
    }

    public LPaint(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public LPaint(PorterDuff.Mode mode, byte b) {
        super(1);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT < 30) {
            setColor((MiscUtils.getAuthRequestContext(i) << 24) | (getColor() & FlexItem.MAX_SIZE));
            return;
        }
        super.setAlpha(MiscUtils.getAuthRequestContext(i));
    }
}
