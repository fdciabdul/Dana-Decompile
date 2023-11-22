package com.twilio.verify.networking;

import kotlin.Metadata;
import o.A;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJF\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0019\u0010\b\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0005¢\u0006\u0002\b\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/twilio/verify/networking/NetworkAdapter;", "Lcom/twilio/verify/networking/NetworkProvider;", "Lcom/twilio/verify/networking/Request;", "p0", "Lkotlin/Function1;", "Lcom/twilio/verify/networking/Response;", "Lkotlin/ParameterName;", "", "p1", "Lcom/twilio/verify/networking/NetworkException;", "p2", "BuiltInFictitiousFunctionClassFactory", "(Lcom/twilio/verify/networking/Request;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "<init>", "()V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class NetworkAdapter implements NetworkProvider {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 269894836;
    private static int MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 1;

    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0131 A[Catch: all -> 0x02d2, Exception -> 0x02d4, TRY_LEAVE, TryCatch #9 {Exception -> 0x02d4, all -> 0x02d2, blocks: (B:6:0x0050, B:7:0x008e, B:9:0x0094, B:10:0x00c5, B:12:0x00ca, B:14:0x00e4, B:38:0x01d4, B:40:0x01f9, B:42:0x021d, B:49:0x0250, B:50:0x0253, B:51:0x0254, B:53:0x0277, B:75:0x02ce, B:76:0x02d1, B:29:0x0131, B:36:0x014a, B:15:0x00eb, B:19:0x0110, B:20:0x011a, B:52:0x026e, B:41:0x0214, B:72:0x02cb, B:46:0x024d), top: B:107:0x0050, inners: #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01f9 A[Catch: all -> 0x02d2, Exception -> 0x02d4, TRY_LEAVE, TryCatch #9 {Exception -> 0x02d4, all -> 0x02d2, blocks: (B:6:0x0050, B:7:0x008e, B:9:0x0094, B:10:0x00c5, B:12:0x00ca, B:14:0x00e4, B:38:0x01d4, B:40:0x01f9, B:42:0x021d, B:49:0x0250, B:50:0x0253, B:51:0x0254, B:53:0x0277, B:75:0x02ce, B:76:0x02d1, B:29:0x0131, B:36:0x014a, B:15:0x00eb, B:19:0x0110, B:20:0x011a, B:52:0x026e, B:41:0x0214, B:72:0x02cb, B:46:0x024d), top: B:107:0x0050, inners: #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0254 A[Catch: all -> 0x02d2, Exception -> 0x02d4, TRY_LEAVE, TryCatch #9 {Exception -> 0x02d4, all -> 0x02d2, blocks: (B:6:0x0050, B:7:0x008e, B:9:0x0094, B:10:0x00c5, B:12:0x00ca, B:14:0x00e4, B:38:0x01d4, B:40:0x01f9, B:42:0x021d, B:49:0x0250, B:50:0x0253, B:51:0x0254, B:53:0x0277, B:75:0x02ce, B:76:0x02d1, B:29:0x0131, B:36:0x014a, B:15:0x00eb, B:19:0x0110, B:20:0x011a, B:52:0x026e, B:41:0x0214, B:72:0x02cb, B:46:0x024d), top: B:107:0x0050, inners: #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02ae  */
    @Override // com.twilio.verify.networking.NetworkProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(com.twilio.verify.networking.Request r22, kotlin.jvm.functions.Function1<? super com.twilio.verify.networking.Response, kotlin.Unit> r23, kotlin.jvm.functions.Function1<? super com.twilio.verify.networking.NetworkException, kotlin.Unit> r24) {
        /*
            Method dump skipped, instructions count: 777
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twilio.verify.networking.NetworkAdapter.BuiltInFictitiousFunctionClassFactory(com.twilio.verify.networking.Request, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        char[] cArr2;
        int i4;
        A a2 = new A();
        char[] cArr3 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i2) {
            try {
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr3[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i5 = a2.MyBillsEntityDataFactory;
                cArr3[i5] = (char) (cArr3[i5] - ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
        if (i3 > 0) {
            int i6 = $10 + 49;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr4 = new char[i2];
            System.arraycopy(cArr3, 0, cArr4, 0, i2);
            System.arraycopy(cArr4, 0, cArr3, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr4, a2.BuiltInFictitiousFunctionClassFactory, cArr3, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if ((z ? 'B' : '5') != '5') {
            int i8 = $10 + 105;
            $11 = i8 % 128;
            if (i8 % 2 == 0) {
                cArr2 = new char[i2];
                a2.MyBillsEntityDataFactory = 1;
            } else {
                cArr2 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
            }
            while (a2.MyBillsEntityDataFactory < i2) {
                int i9 = $10 + 103;
                $11 = i9 % 128;
                if (!(i9 % 2 != 0)) {
                    cArr2[a2.MyBillsEntityDataFactory] = cArr3[(i2 >> a2.MyBillsEntityDataFactory) % 0];
                    i4 = a2.MyBillsEntityDataFactory % 0;
                } else {
                    cArr2[a2.MyBillsEntityDataFactory] = cArr3[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    i4 = a2.MyBillsEntityDataFactory + 1;
                }
                a2.MyBillsEntityDataFactory = i4;
            }
            cArr3 = cArr2;
        }
        objArr[0] = new String(cArr3);
    }
}
