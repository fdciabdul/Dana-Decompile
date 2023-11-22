package com.alibaba.griver.ui.utils;

import android.view.View;
import android.view.ViewStub;

/* loaded from: classes6.dex */
public class H5ViewStubUtil {
    public static <T> T getView(View view, int i, int i2) {
        ViewStub viewStub = (ViewStub) view.findViewById(i);
        if (viewStub != null) {
            return (T) viewStub.inflate();
        }
        return (T) view.findViewById(i2);
    }

    public static void setViewVisibility(View view, int i, int i2, int i3) {
        if (view == null) {
            return;
        }
        if (view.findViewById(i) != null) {
            if (i3 == 0) {
                ((ViewStub) view.findViewById(i)).inflate().setVisibility(i3);
                return;
            }
            return;
        }
        View findViewById = view.findViewById(i2);
        if (findViewById != null) {
            findViewById.setVisibility(i3);
        }
    }
}
