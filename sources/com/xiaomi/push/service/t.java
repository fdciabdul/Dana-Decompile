package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;
import java.util.Collection;

/* loaded from: classes8.dex */
public class t extends XMPushService.j {
    private byte[] BuiltInFictitiousFunctionClassFactory;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    private String PlaceComponentResult;
    private XMPushService getAuthRequestContext;

    public t(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.getAuthRequestContext = xMPushService;
        this.PlaceComponentResult = str;
        this.BuiltInFictitiousFunctionClassFactory = bArr;
        this.MyBillsEntityDataFactory = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        az.b next;
        q KClassImpl$Data$declaredNonStaticMembers$2 = r.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = r.MyBillsEntityDataFactory(this.getAuthRequestContext, this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("fail to register push account. ");
                sb.append(e);
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
            }
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("no account for registration.");
            u.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, 70000002, "no account.");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("do registration now.");
        Collection<az.b> authRequestContext = az.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext("5");
        if (authRequestContext.isEmpty()) {
            XMPushService xMPushService = this.getAuthRequestContext;
            next = new az.b(xMPushService);
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(next, xMPushService, xMPushService.m390b(), "c");
            ad.PlaceComponentResult(this.getAuthRequestContext, next);
            az.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(next);
        } else {
            next = authRequestContext.iterator().next();
        }
        if (!this.getAuthRequestContext.m394d()) {
            u.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
            this.getAuthRequestContext.a(true);
            return;
        }
        try {
            if (next.lookAheadTest == az.c.binded) {
                ad.getAuthRequestContext(this.getAuthRequestContext, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
            } else if (next.lookAheadTest == az.c.unbind) {
                u.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
                XMPushService xMPushService2 = this.getAuthRequestContext;
                xMPushService2.a(new XMPushService.b(next));
            }
        } catch (com.xiaomi.push.cd e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("meet error, disconnect connection. ");
            sb2.append(e2);
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb2.toString());
            this.getAuthRequestContext.a(10, e2);
        }
    }
}
