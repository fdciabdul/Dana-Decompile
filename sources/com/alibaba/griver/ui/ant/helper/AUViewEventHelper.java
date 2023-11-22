package com.alibaba.griver.ui.ant.helper;

import android.view.View;
import android.widget.AdapterView;

/* loaded from: classes6.dex */
public class AUViewEventHelper {

    /* renamed from: a  reason: collision with root package name */
    private static ClickListenerWrapper f6682a;

    /* loaded from: classes6.dex */
    public interface ClickListenerWrapper {
        View.OnClickListener wrap(View.OnClickListener onClickListener);

        AdapterView.OnItemClickListener wrap(AdapterView.OnItemClickListener onItemClickListener);
    }

    public static void setWrapper(ClickListenerWrapper clickListenerWrapper) {
        f6682a = clickListenerWrapper;
    }

    public static View.OnClickListener wrapClickListener(View.OnClickListener onClickListener) {
        ClickListenerWrapper clickListenerWrapper = f6682a;
        return clickListenerWrapper == null ? onClickListener : clickListenerWrapper.wrap(onClickListener);
    }

    public static AdapterView.OnItemClickListener wrapItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        ClickListenerWrapper clickListenerWrapper = f6682a;
        return clickListenerWrapper == null ? onItemClickListener : clickListenerWrapper.wrap(onItemClickListener);
    }
}
