package com.alibaba.ariver.ipc;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.UniformIpcUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class IpcCallClientHelper {
    private Class b;
    private ServiceConnection c;

    /* renamed from: a  reason: collision with root package name */
    private Context f6066a = ProcessUtils.getContext();
    private boolean d = false;
    private int e = 0;

    public void bindService(Class cls, ServiceConnection serviceConnection) {
        this.b = cls;
        this.c = serviceConnection;
    }

    public void bindContext(Context context) {
        this.f6066a = context;
    }

    public boolean bind() {
        synchronized (this) {
            if (this.b != null && this.c != null && this.f6066a != null) {
                if (isBind()) {
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.b.getSimpleName());
                sb.append(" bind with context: ");
                sb.append(this.f6066a);
                RVLogger.d(UniformIpcUtils.TAG, sb.toString());
                Intent intent = new Intent(this.f6066a, this.b);
                try {
                    try {
                        RVLogger.d(UniformIpcUtils.TAG, "IpcCallClientHelper start service begin!");
                        this.f6066a.startService(intent);
                        RVLogger.d(UniformIpcUtils.TAG, "IpcCallClientHelper start service end!");
                        this.f6066a.bindService(intent, this.c, 0);
                        return true;
                    } catch (Throwable th) {
                        RVLogger.e(UniformIpcUtils.TAG, "IpcCallClientHelper start service failed!", th);
                        return false;
                    }
                } catch (Throwable th2) {
                    RVLogger.e(UniformIpcUtils.TAG, Log.getStackTraceString(th2));
                    return false;
                }
            }
            return false;
        }
    }

    public void unbind() {
        if (this.d) {
            this.f6066a.unbindService(this.c);
            this.d = false;
        }
    }

    public void rebind() {
        unbind();
        if (this.e < 3) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.b.getSimpleName());
            sb.append(" retry bind ");
            sb.append(this.e);
            RVLogger.d(UniformIpcUtils.TAG, sb.toString());
            this.e++;
            bind();
        }
    }

    public void setBind(boolean z) {
        this.d = z;
    }

    public boolean isBind() {
        return this.d;
    }
}
