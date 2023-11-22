package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ah extends Handler {
    final /* synthetic */ ag PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(ag agVar, Looper looper) {
        super(looper);
        this.PlaceComponentResult = agVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        ag agVar;
        am amVar;
        Context context5;
        c cVar;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        ag agVar2;
        am amVar2;
        Context context10;
        Context context11;
        if (message.what == 19) {
            String str = (String) message.obj;
            int i = message.arg1;
            synchronized (x.class) {
                context = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                if (x.BuiltInFictitiousFunctionClassFactory(context).getAuthRequestContext(str)) {
                    context2 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (x.BuiltInFictitiousFunctionClassFactory(context2).MyBillsEntityDataFactory(str) < 10) {
                        if (am.DISABLE_PUSH.ordinal() == i) {
                            context11 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(context11).MyBillsEntityDataFactory(am.DISABLE_PUSH))) {
                                agVar2 = this.PlaceComponentResult;
                                amVar2 = am.DISABLE_PUSH;
                                agVar2.PlaceComponentResult(str, amVar2, true, null);
                                context10 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                                x.BuiltInFictitiousFunctionClassFactory(context10).KClassImpl$Data$declaredNonStaticMembers$2(str);
                            }
                        }
                        if (am.ENABLE_PUSH.ordinal() == i) {
                            context9 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(context9).MyBillsEntityDataFactory(am.ENABLE_PUSH))) {
                                agVar2 = this.PlaceComponentResult;
                                amVar2 = am.ENABLE_PUSH;
                                agVar2.PlaceComponentResult(str, amVar2, true, null);
                                context10 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                                x.BuiltInFictitiousFunctionClassFactory(context10).KClassImpl$Data$declaredNonStaticMembers$2(str);
                            }
                        }
                        if (am.UPLOAD_HUAWEI_TOKEN.ordinal() == i) {
                            context8 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(context8).MyBillsEntityDataFactory(am.UPLOAD_HUAWEI_TOKEN))) {
                                agVar = this.PlaceComponentResult;
                                amVar = am.UPLOAD_HUAWEI_TOKEN;
                                context5 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                                cVar = c.ASSEMBLE_PUSH_HUAWEI;
                                agVar.PlaceComponentResult(str, amVar, false, g.getAuthRequestContext(context5, cVar));
                                context10 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                                x.BuiltInFictitiousFunctionClassFactory(context10).KClassImpl$Data$declaredNonStaticMembers$2(str);
                            }
                        }
                        if (am.UPLOAD_FCM_TOKEN.ordinal() == i) {
                            context7 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(context7).MyBillsEntityDataFactory(am.UPLOAD_FCM_TOKEN))) {
                                agVar = this.PlaceComponentResult;
                                amVar = am.UPLOAD_FCM_TOKEN;
                                context5 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                                cVar = c.ASSEMBLE_PUSH_FCM;
                                agVar.PlaceComponentResult(str, amVar, false, g.getAuthRequestContext(context5, cVar));
                                context10 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                                x.BuiltInFictitiousFunctionClassFactory(context10).KClassImpl$Data$declaredNonStaticMembers$2(str);
                            }
                        }
                        if (am.UPLOAD_COS_TOKEN.ordinal() == i) {
                            context6 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(context6).MyBillsEntityDataFactory(am.UPLOAD_COS_TOKEN))) {
                                agVar = this.PlaceComponentResult;
                                amVar = am.UPLOAD_COS_TOKEN;
                                context5 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                                cVar = c.ASSEMBLE_PUSH_COS;
                                agVar.PlaceComponentResult(str, amVar, false, g.getAuthRequestContext(context5, cVar));
                                context10 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                                x.BuiltInFictitiousFunctionClassFactory(context10).KClassImpl$Data$declaredNonStaticMembers$2(str);
                            }
                        }
                        if (am.UPLOAD_FTOS_TOKEN.ordinal() == i) {
                            context4 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(context4).MyBillsEntityDataFactory(am.UPLOAD_FTOS_TOKEN))) {
                                agVar = this.PlaceComponentResult;
                                amVar = am.UPLOAD_FTOS_TOKEN;
                                context5 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                                cVar = c.ASSEMBLE_PUSH_FTOS;
                                agVar.PlaceComponentResult(str, amVar, false, g.getAuthRequestContext(context5, cVar));
                            }
                        }
                        context10 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                        x.BuiltInFictitiousFunctionClassFactory(context10).KClassImpl$Data$declaredNonStaticMembers$2(str);
                    } else {
                        context3 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                        x.BuiltInFictitiousFunctionClassFactory(context3).BuiltInFictitiousFunctionClassFactory(str);
                    }
                }
            }
        }
    }
}
