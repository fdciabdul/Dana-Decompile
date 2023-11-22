package com.google.android.gms.common.api.internal;

/* loaded from: classes3.dex */
final class zas {
    final /* synthetic */ BasePendingResult zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zas(BasePendingResult basePendingResult, zar zarVar) {
        this.zaa = basePendingResult;
    }

    protected final void finalize() throws Throwable {
        BasePendingResult.zal(BasePendingResult.zaj(this.zaa));
        super.finalize();
    }
}
