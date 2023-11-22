package com.xiaomi.push;

/* loaded from: classes8.dex */
public class es {
    private static int MyBillsEntityDataFactory = Integer.MAX_VALUE;

    public static void BuiltInFictitiousFunctionClassFactory(ep epVar, byte b) {
        MyBillsEntityDataFactory(epVar, b, MyBillsEntityDataFactory);
    }

    private static void MyBillsEntityDataFactory(ep epVar, byte b, int i) {
        if (i <= 0) {
            throw new ej("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                epVar.GetContactSyncConfig();
                return;
            case 3:
                epVar.BuiltInFictitiousFunctionClassFactory();
                return;
            case 4:
                epVar.KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                epVar.DatabaseTableConfigUtil();
                return;
            case 8:
                epVar.getAuthRequestContext();
                return;
            case 10:
                epVar.MyBillsEntityDataFactory();
                return;
            case 11:
                epVar.lookAheadTest();
                return;
            case 12:
                break;
            case 13:
                eo moveToNextValue = epVar.moveToNextValue();
                while (i2 < moveToNextValue.PlaceComponentResult) {
                    int i3 = i - 1;
                    MyBillsEntityDataFactory(epVar, moveToNextValue.MyBillsEntityDataFactory, i3);
                    MyBillsEntityDataFactory(epVar, moveToNextValue.BuiltInFictitiousFunctionClassFactory, i3);
                    i2++;
                }
                return;
            case 14:
                et scheduleImpl = epVar.scheduleImpl();
                while (i2 < scheduleImpl.getAuthRequestContext) {
                    MyBillsEntityDataFactory(epVar, scheduleImpl.PlaceComponentResult, i - 1);
                    i2++;
                }
                return;
            case 15:
                en NetworkUserEntityData$$ExternalSyntheticLambda0 = epVar.NetworkUserEntityData$$ExternalSyntheticLambda0();
                while (i2 < NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2) {
                    MyBillsEntityDataFactory(epVar, NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult, i - 1);
                    i2++;
                }
                return;
        }
        while (true) {
            em PlaceComponentResult = epVar.PlaceComponentResult();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 0) {
                return;
            }
            MyBillsEntityDataFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, i - 1);
        }
    }
}
