package com.apiguard3.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes3.dex */
public final class readObject extends Handler {
    private static int AGState = 0;
    private static int valueOf = 1;

    public readObject(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = valueOf + 35;
        AGState = i % 128;
        if ((i % 2 != 0 ? 'P' : 'L') != 'P') {
            ConfigInstance configInstance = (ConfigInstance) message.obj;
            if ((configInstance != null ? '@' : 'I') != '@') {
                return;
            }
            int i2 = AGState + 75;
            valueOf = i2 % 128;
            if ((i2 % 2 == 0 ? (char) 6 : '^') != 6) {
                dpi.AGState().values(configInstance);
                return;
            } else {
                dpi.AGState().values(configInstance);
                throw new NullPointerException();
            }
        }
        ConfigInstance configInstance2 = (ConfigInstance) message.obj;
        throw new ArithmeticException();
    }
}
