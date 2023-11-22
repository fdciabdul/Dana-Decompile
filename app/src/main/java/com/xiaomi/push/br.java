package com.xiaomi.push;

import com.xiaomi.push.au;
import com.xiaomi.push.bt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* loaded from: classes8.dex */
public class br implements ce {
    public static boolean PlaceComponentResult;
    private bt BuiltInFictitiousFunctionClassFactory;
    private a MyBillsEntityDataFactory;
    private bv getAuthRequestContext;
    private a lookAheadTest;
    private SimpleDateFormat NetworkUserEntityData$$ExternalSyntheticLambda0 = new SimpleDateFormat("hh:mm:ss aaa");
    private final String KClassImpl$Data$declaredNonStaticMembers$2 = "[Slim] ";

    /* loaded from: classes8.dex */
    class a implements bx, cf {
        String KClassImpl$Data$declaredNonStaticMembers$2;
        private boolean MyBillsEntityDataFactory;

        a(boolean z) {
            this.MyBillsEntityDataFactory = z;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.bx
        public final void MyBillsEntityDataFactory(bi biVar) {
            StringBuilder sb;
            String str;
            if (br.PlaceComponentResult) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(br.this.NetworkUserEntityData$$ExternalSyntheticLambda0.format(new Date()));
                sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                str = biVar.toString();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(br.this.NetworkUserEntityData$$ExternalSyntheticLambda0.format(new Date()));
                sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append(" Blob [");
                sb.append(biVar.PlaceComponentResult.lookAheadTest);
                sb.append(",");
                sb.append(biVar.PlaceComponentResult.PlaceComponentResult);
                sb.append(",");
                sb.append(com.xiaomi.push.service.aw.BuiltInFictitiousFunctionClassFactory(biVar.MyBillsEntityDataFactory()));
                str = "]";
            }
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
            if (biVar == null || biVar.PlaceComponentResult.PlaceComponentResult != 99999) {
                return;
            }
            String str2 = biVar.PlaceComponentResult.lookAheadTest;
            bi biVar2 = null;
            if (!this.MyBillsEntityDataFactory) {
                if ("BIND".equals(str2)) {
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("build binded result for loopback.");
                    au.d dVar = new au.d();
                    dVar.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    dVar.PlaceComponentResult = true;
                    dVar.lookAheadTest = true;
                    dVar.BuiltInFictitiousFunctionClassFactory = "login success.";
                    dVar.getErrorConfigVersion = true;
                    dVar.MyBillsEntityDataFactory = "success";
                    dVar.scheduleImpl = true;
                    dVar.getAuthRequestContext = "success";
                    bi biVar3 = new bi();
                    biVar3.BuiltInFictitiousFunctionClassFactory(dVar.moveToNextValue(), (String) null);
                    biVar3.MyBillsEntityDataFactory = (short) 2;
                    au.a aVar = biVar3.PlaceComponentResult;
                    aVar.getAuthRequestContext = true;
                    aVar.PlaceComponentResult = 99999;
                    biVar3.getAuthRequestContext("BIND", null);
                    String MyBillsEntityDataFactory = biVar.MyBillsEntityDataFactory();
                    au.a aVar2 = biVar3.PlaceComponentResult;
                    aVar2.PrepareContext = true;
                    aVar2.initRecordTimeStamp = MyBillsEntityDataFactory;
                    biVar3.getAuthRequestContext = null;
                    biVar3.BuiltInFictitiousFunctionClassFactory(biVar.scheduleImpl());
                    biVar2 = biVar3;
                } else if (!"UBND".equals(str2) && "SECMSG".equals(str2)) {
                    bi biVar4 = new bi();
                    au.a aVar3 = biVar4.PlaceComponentResult;
                    aVar3.getAuthRequestContext = true;
                    aVar3.PlaceComponentResult = 99999;
                    biVar4.getAuthRequestContext("SECMSG", null);
                    biVar4.BuiltInFictitiousFunctionClassFactory(biVar.scheduleImpl());
                    String MyBillsEntityDataFactory2 = biVar.MyBillsEntityDataFactory();
                    au.a aVar4 = biVar4.PlaceComponentResult;
                    aVar4.PrepareContext = true;
                    aVar4.initRecordTimeStamp = MyBillsEntityDataFactory2;
                    biVar4.MyBillsEntityDataFactory = biVar.getAuthRequestContext();
                    biVar4.getAuthRequestContext = biVar.getAuthRequestContext;
                    biVar4.BuiltInFictitiousFunctionClassFactory(biVar.KClassImpl$Data$declaredNonStaticMembers$2(com.xiaomi.push.service.az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory("99999", biVar.scheduleImpl()).isLayoutRequested), (String) null);
                    biVar2 = biVar4;
                }
            }
            if (biVar2 != null) {
                for (Map.Entry<bx, bt.a> entry : br.this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion().entrySet()) {
                    if (br.this.MyBillsEntityDataFactory != entry.getKey()) {
                        entry.getValue().getAuthRequestContext.MyBillsEntityDataFactory(biVar2);
                    }
                }
            }
        }

        @Override // com.xiaomi.push.bx
        public final void MyBillsEntityDataFactory(cj cjVar) {
            StringBuilder sb;
            String str;
            if (br.PlaceComponentResult) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(br.this.NetworkUserEntityData$$ExternalSyntheticLambda0.format(new Date()));
                sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append(" PKT ");
                str = cjVar.MyBillsEntityDataFactory();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(br.this.NetworkUserEntityData$$ExternalSyntheticLambda0.format(new Date()));
                sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append(" PKT [");
                sb.append(cjVar.NetworkUserEntityData$$ExternalSyntheticLambda3);
                sb.append(",");
                sb.append(cjVar.getAuthRequestContext());
                str = "]";
            }
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
        }
    }

    public br(bt btVar) {
        this.MyBillsEntityDataFactory = null;
        this.lookAheadTest = null;
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = btVar;
        this.MyBillsEntityDataFactory = new a(true);
        this.lookAheadTest = new a(false);
        bt btVar2 = this.BuiltInFictitiousFunctionClassFactory;
        a aVar = this.MyBillsEntityDataFactory;
        btVar2.PlaceComponentResult(aVar, aVar);
        bt btVar3 = this.BuiltInFictitiousFunctionClassFactory;
        a aVar2 = this.lookAheadTest;
        btVar3.KClassImpl$Data$declaredNonStaticMembers$2(aVar2, aVar2);
        this.getAuthRequestContext = new bs(this);
    }
}
