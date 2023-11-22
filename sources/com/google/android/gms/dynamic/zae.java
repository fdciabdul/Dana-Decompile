package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
final class zae implements View.OnClickListener {
    final /* synthetic */ Context zaa;
    final /* synthetic */ Intent zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zae(Context context, Intent intent) {
        this.zaa = context;
        this.zab = intent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.zaa.startActivity(this.zab);
        } catch (ActivityNotFoundException e) {
            InstrumentInjector.log_e("DeferredLifecycleHelper", "Failed to start resolution intent", e);
        }
    }
}
