package com.xiaomi.push;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.au;
import com.xiaomi.push.bt;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class bp extends bz {
    private bk NetworkUserEntityData$$ExternalSyntheticLambda6;
    private byte[] getCallingPid;
    private Thread getSupportButtonTintMode;
    private bl whenAvailable;

    public bp(XMPushService xMPushService, bu buVar) {
        super(xMPushService, buVar);
    }

    @Override // com.xiaomi.push.bt
    @Deprecated
    public final void KClassImpl$Data$declaredNonStaticMembers$2(cj cjVar) {
        PlaceComponentResult(bi.BuiltInFictitiousFunctionClassFactory(cjVar, (String) null));
    }

    @Override // com.xiaomi.push.bt
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return true;
    }

    @Override // com.xiaomi.push.bt
    public final void MyBillsEntityDataFactory(az.b bVar) {
        synchronized (this) {
            bh.KClassImpl$Data$declaredNonStaticMembers$2(bVar, NetworkUserEntityData$$ExternalSyntheticLambda1(), this);
        }
    }

    @Override // com.xiaomi.push.bt
    public final void PlaceComponentResult(String str, String str2) {
        synchronized (this) {
            bh.MyBillsEntityDataFactory(str, str2, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] PlaceComponentResult() {
        byte[] bArr;
        synchronized (this) {
            if (this.getCallingPid == null && !TextUtils.isEmpty(this.getErrorConfigVersion)) {
                String BuiltInFictitiousFunctionClassFactory = com.xiaomi.push.service.bn.BuiltInFictitiousFunctionClassFactory();
                StringBuilder sb = new StringBuilder();
                sb.append(this.getErrorConfigVersion.substring(this.getErrorConfigVersion.length() / 2));
                sb.append(BuiltInFictitiousFunctionClassFactory.substring(BuiltInFictitiousFunctionClassFactory.length() / 2));
                this.getCallingPid = com.xiaomi.push.service.bh.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion.getBytes(), sb.toString().getBytes());
            }
            bArr = this.getCallingPid;
        }
        return bArr;
    }

    @Override // com.xiaomi.push.bz, com.xiaomi.push.bt
    public final void getAuthRequestContext(bi[] biVarArr) {
        for (bi biVar : biVarArr) {
            PlaceComponentResult(biVar);
        }
    }

    @Override // com.xiaomi.push.bz
    protected final void BuiltInFictitiousFunctionClassFactory() {
        synchronized (this) {
            try {
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new bk(this.NetworkUserEntityData$$ExternalSyntheticLambda8.getInputStream(), this);
                this.whenAvailable = new bl(this.NetworkUserEntityData$$ExternalSyntheticLambda8.getOutputStream(), this);
                StringBuilder sb = new StringBuilder();
                sb.append("Blob Reader (");
                sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                sb.append(")");
                bq bqVar = new bq(this, sb.toString());
                this.getSupportButtonTintMode = bqVar;
                bqVar.start();
                bl blVar = this.whenAvailable;
                au.e eVar = new au.e();
                eVar.BuiltInFictitiousFunctionClassFactory = true;
                eVar.getAuthRequestContext = 106;
                String BuiltInFictitiousFunctionClassFactory = com.xiaomi.push.service.bn.BuiltInFictitiousFunctionClassFactory();
                eVar.getErrorConfigVersion = true;
                eVar.lookAheadTest = BuiltInFictitiousFunctionClassFactory;
                eVar.moveToNextValue = true;
                eVar.PlaceComponentResult = 48;
                String scheduleImpl = blVar.BuiltInFictitiousFunctionClassFactory.scheduleImpl();
                eVar.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                eVar.scheduleImpl = scheduleImpl;
                int i = Build.VERSION.SDK_INT;
                eVar.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
                eVar.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                byte[] BuiltInFictitiousFunctionClassFactory2 = blVar.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory();
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    au.b PlaceComponentResult = au.b.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2);
                    eVar.DatabaseTableConfigUtil = true;
                    eVar.MyBillsEntityDataFactory = PlaceComponentResult;
                }
                bi biVar = new bi();
                au.a aVar = biVar.PlaceComponentResult;
                aVar.getAuthRequestContext = true;
                aVar.PlaceComponentResult = 0;
                biVar.getAuthRequestContext("CONN", null);
                biVar.KClassImpl$Data$declaredNonStaticMembers$2(0L, "xiaomi.com", null);
                biVar.BuiltInFictitiousFunctionClassFactory(eVar.moveToNextValue(), (String) null);
                blVar.BuiltInFictitiousFunctionClassFactory(biVar);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[slim] open conn: andver=");
                sb2.append(Build.VERSION.SDK_INT);
                sb2.append(" sdk=");
                sb2.append(48);
                sb2.append(" tz=");
                sb2.append(blVar.MyBillsEntityDataFactory);
                sb2.append(":");
                sb2.append(blVar.PlaceComponentResult);
                sb2.append(" Model=");
                sb2.append(Build.MODEL);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
            } catch (Exception e) {
                throw new cd("Error to init reader and writer", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.bz
    public final void BuiltInFictitiousFunctionClassFactory(int i, Exception exc) {
        synchronized (this) {
            bk bkVar = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (bkVar != null) {
                bkVar.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = null;
            }
            bl blVar = this.whenAvailable;
            if (blVar != null) {
                try {
                    bi biVar = new bi();
                    biVar.getAuthRequestContext("CLOSE", null);
                    blVar.BuiltInFictitiousFunctionClassFactory(biVar);
                    blVar.KClassImpl$Data$declaredNonStaticMembers$2.close();
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                }
                this.whenAvailable = null;
            }
            this.getCallingPid = null;
            super.BuiltInFictitiousFunctionClassFactory(i, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(bi biVar) {
        if (biVar == null) {
            return;
        }
        if (biVar.BuiltInFictitiousFunctionClassFactory()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[Slim] RCV blob chid=");
            sb.append(biVar.PlaceComponentResult.PlaceComponentResult);
            sb.append("; id=");
            sb.append(biVar.MyBillsEntityDataFactory());
            sb.append("; errCode=");
            sb.append(biVar.PlaceComponentResult.moveToNextValue);
            sb.append("; err=");
            sb.append(biVar.PlaceComponentResult.isLayoutRequested);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        }
        if (biVar.PlaceComponentResult.PlaceComponentResult == 0) {
            if ("PING".equals(biVar.PlaceComponentResult.lookAheadTest)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[Slim] RCV ping id=");
                sb2.append(biVar.MyBillsEntityDataFactory());
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                NetworkUserEntityData$$ExternalSyntheticLambda2();
            } else if ("CLOSE".equals(biVar.PlaceComponentResult.lookAheadTest)) {
                KClassImpl$Data$declaredNonStaticMembers$2(13, (Exception) null);
            }
        }
        Iterator<bt.a> it = this.scheduleImpl.values().iterator();
        while (it.hasNext()) {
            it.next().getAuthRequestContext.MyBillsEntityDataFactory(biVar);
        }
    }

    @Override // com.xiaomi.push.bz
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        if (this.whenAvailable == null) {
            throw new cd("The BlobWriter is null.");
        }
        bo boVar = new bo();
        if (z) {
            au.a aVar = boVar.PlaceComponentResult;
            aVar.PrepareContext = true;
            aVar.initRecordTimeStamp = "1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[Slim] SND ping id=");
        sb.append(boVar.MyBillsEntityDataFactory());
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        PlaceComponentResult(boVar);
        DatabaseTableConfigUtil();
    }

    @Override // com.xiaomi.push.bt
    public final void PlaceComponentResult(bi biVar) {
        bl blVar = this.whenAvailable;
        if (blVar == null) {
            throw new cd("the writer is null.");
        }
        try {
            int BuiltInFictitiousFunctionClassFactory = blVar.BuiltInFictitiousFunctionClassFactory(biVar);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = SystemClock.elapsedRealtime();
            String str = biVar.getAuthRequestContext;
            if (!TextUtils.isEmpty(str)) {
                cx.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue, str, BuiltInFictitiousFunctionClassFactory, false, true, System.currentTimeMillis());
            }
            Iterator<bt.a> it = this.initRecordTimeStamp.values().iterator();
            while (it.hasNext()) {
                it.next().getAuthRequestContext.MyBillsEntityDataFactory(biVar);
            }
        } catch (Exception e) {
            throw new cd(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(cj cjVar) {
        if (cjVar == null) {
            return;
        }
        for (bt.a aVar : this.scheduleImpl.values()) {
            cf cfVar = aVar.BuiltInFictitiousFunctionClassFactory;
            aVar.getAuthRequestContext.MyBillsEntityDataFactory(cjVar);
        }
    }
}
