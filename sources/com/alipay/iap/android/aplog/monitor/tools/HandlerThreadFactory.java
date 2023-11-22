package com.alipay.iap.android.aplog.monitor.tools;

import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.griver.video.H5Constants;

/* loaded from: classes6.dex */
public class HandlerThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private static a f6935a = new a(H5Constants.PARAM_LOOP);

    public static Handler a() {
        return f6935a.a();
    }

    /* loaded from: classes6.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private Handler f6936a;

        public a(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("Monitor-");
            sb.append(str);
            HandlerThread handlerThread = new HandlerThread(sb.toString());
            handlerThread.start();
            this.f6936a = new Handler(handlerThread.getLooper());
        }

        public Handler a() {
            return this.f6936a;
        }
    }
}
