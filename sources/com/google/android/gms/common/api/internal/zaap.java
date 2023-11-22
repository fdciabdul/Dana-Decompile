package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zaap extends zaav {
    final /* synthetic */ zaaw zaa;
    private final ArrayList<Api.Client> zac;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaap(zaaw zaawVar, ArrayList<Api.Client> arrayList) {
        super(zaawVar, null);
        this.zaa = zaawVar;
        this.zac = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.zaav
    public final void zaa() {
        zabi zabiVar;
        IAccountAccessor iAccountAccessor;
        zabi zabiVar2;
        zaaw zaawVar = this.zaa;
        zabiVar = zaawVar.zaa;
        zabiVar.zag.zad = zaaw.zao(zaawVar);
        ArrayList<Api.Client> arrayList = this.zac;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Api.Client client = arrayList.get(i);
            zaaw zaawVar2 = this.zaa;
            iAccountAccessor = zaawVar2.zao;
            zabiVar2 = zaawVar2.zaa;
            client.getRemoteService(iAccountAccessor, zabiVar2.zag.zad);
        }
    }
}
