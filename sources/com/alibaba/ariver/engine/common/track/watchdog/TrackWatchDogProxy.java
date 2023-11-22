package com.alibaba.ariver.engine.common.track.watchdog;

import android.os.Bundle;
import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes6.dex */
public interface TrackWatchDogProxy extends Proxiable {
    void sendStartupMessage(int i, String str, String str2, String str3);

    void startApp(String str, Bundle bundle);

    void startAppFinished(Bundle bundle);

    void startAppStep(Bundle bundle, String str);

    void startAppStep(Bundle bundle, String str, String str2);

    void startAppStepWithExt(Bundle bundle, String str, String str2, int i);
}
