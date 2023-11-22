package com.alibaba.ariver.app.api.ui.loading;

import com.alibaba.ariver.app.api.EntryInfo;
import java.util.Map;

/* loaded from: classes2.dex */
public interface SplashView {

    /* loaded from: classes6.dex */
    public interface ExitListener {
        void onExit();
    }

    /* loaded from: classes2.dex */
    public enum Status {
        WAITING,
        LOADING,
        ERROR,
        EXIT
    }

    boolean backPressed();

    void exit(ExitListener exitListener);

    Status getStatus();

    void showError(String str, String str2, Map<String, String> map);

    void showLoading(EntryInfo entryInfo);

    void update(EntryInfo entryInfo);
}
