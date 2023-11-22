package com.xiaomi.push;

import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bs implements bv {
    final /* synthetic */ br PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(br brVar) {
        this.PlaceComponentResult = brVar;
    }

    @Override // com.xiaomi.push.bv
    public void a(bt btVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Slim] ");
        sb.append(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0.format(new Date()));
        sb.append(" Connection started (");
        sb.append(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.hashCode());
        sb.append(")");
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
    }

    @Override // com.xiaomi.push.bv
    public void a(bt btVar, int i, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Slim] ");
        sb.append(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0.format(new Date()));
        sb.append(" Connection closed (");
        sb.append(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.hashCode());
        sb.append(")");
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
    }

    @Override // com.xiaomi.push.bv
    public void a(bt btVar, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Slim] ");
        sb.append(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0.format(new Date()));
        sb.append(" Reconnection failed due to an exception (");
        sb.append(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.hashCode());
        sb.append(")");
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
    }

    @Override // com.xiaomi.push.bv
    public void b(bt btVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Slim] ");
        sb.append(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0.format(new Date()));
        sb.append(" Connection reconnected (");
        sb.append(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.hashCode());
        sb.append(")");
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
    }
}
