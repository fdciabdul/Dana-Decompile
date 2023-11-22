package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.fullstory.instrumentation.InstrumentInjector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zabc extends com.google.android.gms.internal.base.zaq {
    final /* synthetic */ zabe zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zabc(zabe zabeVar, Looper looper) {
        super(looper);
        this.zaa = zabeVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            zabe.zaj(this.zaa);
        } else if (i == 2) {
            zabe.zai(this.zaa);
        } else {
            int i2 = message.what;
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i2);
            InstrumentInjector.log_w("GoogleApiClientImpl", sb.toString());
        }
    }
}
