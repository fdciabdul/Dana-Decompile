package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ba implements az.b.a {
    final /* synthetic */ az.b PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az.b bVar) {
        this.PlaceComponentResult = bVar;
    }

    @Override // com.xiaomi.push.service.az.b.a
    public final void PlaceComponentResult(az.c cVar) {
        XMPushService.c cVar2;
        XMPushService.c cVar3;
        if (cVar == az.c.binding) {
            XMPushService xMPushService = this.PlaceComponentResult.FragmentBottomSheetPaymentSettingBinding;
            cVar3 = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7;
            xMPushService.a(cVar3, 60000L);
            return;
        }
        XMPushService xMPushService2 = this.PlaceComponentResult.FragmentBottomSheetPaymentSettingBinding;
        cVar2 = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7;
        xMPushService2.b(cVar2);
    }
}
