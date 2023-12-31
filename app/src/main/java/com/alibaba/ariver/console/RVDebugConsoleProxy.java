package com.alibaba.ariver.console;

import android.app.Activity;
import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes6.dex */
public interface RVDebugConsoleProxy extends Proxiable {
    int getConsoleToggleButtonColor(Activity activity);

    int getDebugConsoleViewHeight(Activity activity);

    boolean getToggleButtonVisible(String str);

    void initConsoleView(Activity activity, long j, ConsoleViewCreateCallback consoleViewCreateCallback);

    void setToggleButtonVisible(String str, boolean z);
}
