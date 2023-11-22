package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
final class zaar extends com.google.android.gms.signin.internal.zac {
    private final WeakReference<zaaw> zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaar(zaaw zaawVar) {
        this.zaa = new WeakReference<>(zaawVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        zabi zabiVar;
        zaaw zaawVar = this.zaa.get();
        if (zaawVar == null) {
            return;
        }
        zabiVar = zaawVar.zaa;
        zabiVar.zal(new zaaq(this, zaawVar, zaawVar, zakVar));
    }
}
