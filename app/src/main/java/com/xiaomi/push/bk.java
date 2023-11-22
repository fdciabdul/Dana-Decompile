package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.au;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bk {
    private bp BuiltInFictitiousFunctionClassFactory;
    volatile boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private InputStream PlaceComponentResult;
    private byte[] getErrorConfigVersion;
    private ByteBuffer getAuthRequestContext = ByteBuffer.allocate(2048);
    private ByteBuffer NetworkUserEntityData$$ExternalSyntheticLambda0 = ByteBuffer.allocate(4);
    private Adler32 scheduleImpl = new Adler32();
    private bn MyBillsEntityDataFactory = new bn();

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(InputStream inputStream, bp bpVar) {
        this.PlaceComponentResult = new BufferedInputStream(inputStream);
        this.BuiltInFictitiousFunctionClassFactory = bpVar;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.PlaceComponentResult.read(byteBuffer.array(), position, i);
            if (read == -1) {
                throw new EOFException();
            }
            i -= read;
            position += read;
        } while (i > 0);
        byteBuffer.position(position);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory() {
        String obj;
        StringBuilder sb;
        boolean z = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        bi BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
        if ("CONN".equals(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.lookAheadTest)) {
            au.f MyBillsEntityDataFactory = au.f.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2());
            if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2()) {
                this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
                z = true;
            }
            if (MyBillsEntityDataFactory.MyBillsEntityDataFactory()) {
                au.b bVar = MyBillsEntityDataFactory.getAuthRequestContext;
                bi biVar = new bi();
                biVar.getAuthRequestContext("SYNC", "CONF");
                biVar.BuiltInFictitiousFunctionClassFactory(bVar.moveToNextValue(), (String) null);
                this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(biVar);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[Slim] CONN: host = ");
            sb2.append(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.getErrorConfigVersion = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        while (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
            bi BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory();
            bp bpVar = this.BuiltInFictitiousFunctionClassFactory;
            synchronized (bpVar) {
                bpVar.newProxyInstance = SystemClock.elapsedRealtime();
            }
            short authRequestContext = BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext();
            if (authRequestContext != 1) {
                if (authRequestContext != 2) {
                    if (authRequestContext != 3) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("[Slim] unknow blob type ");
                        sb3.append((int) BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext());
                        obj = sb3.toString();
                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(obj);
                    } else {
                        try {
                            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2(), this.BuiltInFictitiousFunctionClassFactory));
                        } catch (Exception e) {
                            e = e;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult.PlaceComponentResult);
                            sb.append("; Id=");
                            sb.append(BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            obj = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(obj);
                        }
                    }
                } else if ("SECMSG".equals(BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult.lookAheadTest) && ((BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult.PlaceComponentResult == 2 || BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult.PlaceComponentResult == 3) && TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2))) {
                    try {
                        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2(com.xiaomi.push.service.az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(Integer.valueOf(BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult.PlaceComponentResult).toString(), BuiltInFictitiousFunctionClassFactory2.scheduleImpl()).isLayoutRequested), this.BuiltInFictitiousFunctionClassFactory));
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder();
                        sb.append("[Slim] Parse packet from Blob chid=");
                        sb.append(BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult.PlaceComponentResult);
                        sb.append("; Id=");
                        sb.append(BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory());
                        sb.append(" failure:");
                        sb.append(e.getMessage());
                        obj = sb.toString();
                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(obj);
                    }
                }
            }
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00bd A[Catch: IOException -> 0x0118, TryCatch #0 {IOException -> 0x0118, blocks: (B:3:0x0001, B:7:0x0021, B:9:0x0033, B:11:0x003d, B:17:0x0082, B:18:0x0084, B:20:0x00bd, B:22:0x00c1, B:23:0x00ca, B:25:0x00d8, B:27:0x00e6, B:26:0x00de, B:31:0x011a, B:32:0x0144, B:12:0x005a, B:16:0x0068, B:33:0x0145, B:34:0x014c, B:35:0x014d, B:36:0x0154), top: B:44:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011a A[Catch: IOException -> 0x0118, TryCatch #0 {IOException -> 0x0118, blocks: (B:3:0x0001, B:7:0x0021, B:9:0x0033, B:11:0x003d, B:17:0x0082, B:18:0x0084, B:20:0x00bd, B:22:0x00c1, B:23:0x00ca, B:25:0x00d8, B:27:0x00e6, B:26:0x00de, B:31:0x011a, B:32:0x0144, B:12:0x005a, B:16:0x0068, B:33:0x0145, B:34:0x014c, B:35:0x014d, B:36:0x0154), top: B:44:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.xiaomi.push.bi BuiltInFictitiousFunctionClassFactory() {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bk.BuiltInFictitiousFunctionClassFactory():com.xiaomi.push.bi");
    }
}
