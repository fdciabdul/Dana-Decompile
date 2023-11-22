package com.iap.ac.android.common.container;

import android.app.Activity;
import android.content.Context;
import java.util.Map;

/* loaded from: classes3.dex */
public interface IContainerPresenter {
    void closeWebview();

    Activity getActivity();

    Context getContext();

    void loadUrl(String str);

    void postUrl(String str, byte[] bArr);

    void reloadPage();

    void setTitle(String str);

    void showNetWorkCheckActivity(Map<String, String> map);
}
