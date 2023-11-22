package com.alibaba.griver.ui.ant.api;

import android.view.View;
import android.widget.AdapterView;

/* loaded from: classes6.dex */
public class APViewEventHelper {

    /* renamed from: a  reason: collision with root package name */
    private static ClickListenerWrapper f6659a;

    /* loaded from: classes6.dex */
    public interface ClickListenerWrapper {
        View.OnClickListener wrap(View.OnClickListener onClickListener);

        AdapterView.OnItemClickListener wrap(AdapterView.OnItemClickListener onItemClickListener);
    }

    public static void setWrapper(ClickListenerWrapper clickListenerWrapper) {
        f6659a = clickListenerWrapper;
    }

    public static View.OnClickListener wrapClickListener(View.OnClickListener onClickListener) {
        ClickListenerWrapper clickListenerWrapper = f6659a;
        return clickListenerWrapper == null ? onClickListener : clickListenerWrapper.wrap(onClickListener);
    }

    public static AdapterView.OnItemClickListener wrapItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        ClickListenerWrapper clickListenerWrapper = f6659a;
        return clickListenerWrapper == null ? onItemClickListener : clickListenerWrapper.wrap(onItemClickListener);
    }
}
