package com.alibaba.griver.base.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Switch;
import com.alibaba.griver.base.R;

/* loaded from: classes6.dex */
public class GriverSwtich extends Switch {
    public GriverSwtich(Context context) {
        super(context);
        a();
    }

    public GriverSwtich(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public GriverSwtich(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public GriverSwtich(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a();
    }

    private void a() {
        setThumbResource(R.drawable.griver_switch_thumb);
        setTrackResource(R.drawable.griver_switch_track);
    }
}
