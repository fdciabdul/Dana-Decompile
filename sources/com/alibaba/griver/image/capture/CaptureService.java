package com.alibaba.griver.image.capture;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.griver.image.capture.listener.CaptureListener;

/* loaded from: classes2.dex */
public abstract class CaptureService {
    public abstract void capture(App app, CaptureListener captureListener, String str, Bundle bundle);
}
