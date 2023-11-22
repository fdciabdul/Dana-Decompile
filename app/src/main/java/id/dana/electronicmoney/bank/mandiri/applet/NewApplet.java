package id.dana.electronicmoney.bank.mandiri.applet;

import id.dana.electronicmoney.bank.mandiri.MandiriApduCommand;
import id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager;
import id.dana.electronicmoney.bank.mandiri.constants.EmoneyMandiriErrorCode;
import id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult;
import id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\u0006\u0010\u000b\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/applet/NewApplet;", "Lid/dana/electronicmoney/bank/mandiri/applet/CardApplet;", "", "p0", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/electronicmoney/BalanceResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "p1", "PlaceComponentResult", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;", "Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;", "p2", "<init>", "(Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class NewApplet extends CardApplet {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewApplet(MandiriEmoneyManager mandiriEmoneyManager, EmoneyCardAttribute emoneyCardAttribute, MandiriApduCommand mandiriApduCommand) {
        super(mandiriEmoneyManager, emoneyCardAttribute, mandiriApduCommand);
        Intrinsics.checkNotNullParameter(mandiriEmoneyManager, "");
        Intrinsics.checkNotNullParameter(emoneyCardAttribute, "");
        Intrinsics.checkNotNullParameter(mandiriApduCommand, "");
    }

    @Override // id.dana.electronicmoney.bank.mandiri.applet.CardApplet
    public final Object PlaceComponentResult(EmoneyApiResult emoneyApiResult, boolean z, Continuation<? super EmoneyApiResult> continuation) {
        try {
            MandiriApduCommand MyBillsEntityDataFactory = getMyBillsEntityDataFactory();
            String str = emoneyApiResult.PlaceComponentResult.get("responseFromSam");
            if (str == null) {
                str = "";
            }
            String PlaceComponentResult = MyBillsEntityDataFactory.PlaceComponentResult(str);
            return new EmoneyApiResult(StringsKt.contains$default((CharSequence) PlaceComponentResult, (CharSequence) "9000", false, 2, (Object) null), StringsKt.contains$default((CharSequence) PlaceComponentResult, (CharSequence) "9000", false, 2, (Object) null) ? "" : EmoneyMandiriErrorCode.REVERSAL_NEEDED, null, null, null, null, null, null, false, false, 1020, null);
        } catch (Exception unused) {
            return new EmoneyApiResult(false, null, null, null, null, null, null, null, false, false, 1023, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6 A[PHI: r1
      0x00a6: PHI (r1v11 java.lang.Object) = (r1v10 java.lang.Object), (r1v1 java.lang.Object) binds: [B:32:0x00a3, B:13:0x0031] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    @Override // id.dana.electronicmoney.bank.mandiri.applet.CardApplet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object BuiltInFictitiousFunctionClassFactory(java.lang.String r17, kotlin.coroutines.Continuation<? super id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof id.dana.electronicmoney.bank.mandiri.applet.NewApplet$reversal$1
            if (r2 == 0) goto L18
            r2 = r1
            id.dana.electronicmoney.bank.mandiri.applet.NewApplet$reversal$1 r2 = (id.dana.electronicmoney.bank.mandiri.applet.NewApplet$reversal$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 + r4
            r2.label = r1
            goto L1d
        L18:
            id.dana.electronicmoney.bank.mandiri.applet.NewApplet$reversal$1 r2 = new id.dana.electronicmoney.bank.mandiri.applet.NewApplet$reversal$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r4 == 0) goto L5a
            if (r4 == r7) goto L46
            if (r4 == r6) goto L3e
            if (r4 != r5) goto L36
            kotlin.ResultKt.throwOnFailure(r1)     // Catch: android.nfc.TagLostException -> La7
            goto La6
        L36:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3e:
            java.lang.Object r4 = r2.L$0
            id.dana.electronicmoney.bank.mandiri.applet.NewApplet r4 = (id.dana.electronicmoney.bank.mandiri.applet.NewApplet) r4
            kotlin.ResultKt.throwOnFailure(r1)     // Catch: android.nfc.TagLostException -> La7
            goto L99
        L46:
            java.lang.Object r4 = r2.L$2
            id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute r4 = (id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute) r4
            java.lang.Object r7 = r2.L$1
            id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager r7 = (id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager) r7
            java.lang.Object r9 = r2.L$0
            id.dana.electronicmoney.bank.mandiri.applet.NewApplet r9 = (id.dana.electronicmoney.bank.mandiri.applet.NewApplet) r9
            kotlin.ResultKt.throwOnFailure(r1)     // Catch: android.nfc.TagLostException -> La7
            r15 = r7
            r7 = r4
            r4 = r9
            r9 = r15
            goto L88
        L5a:
            kotlin.ResultKt.throwOnFailure(r1)
            id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager r1 = r16.getKClassImpl$Data$declaredNonStaticMembers$2()     // Catch: android.nfc.TagLostException -> La7
            id.dana.electronicmoney.bank.mandiri.CardAttributeGenerator r4 = id.dana.electronicmoney.bank.mandiri.CardAttributeGenerator.INSTANCE     // Catch: android.nfc.TagLostException -> La7
            id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute r4 = r16.getPlaceComponentResult()     // Catch: android.nfc.TagLostException -> La7
            id.dana.electronicmoney.bank.mandiri.MandiriApduCommand r9 = r16.getMyBillsEntityDataFactory()     // Catch: android.nfc.TagLostException -> La7
            r10 = r17
            id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute r4 = id.dana.electronicmoney.bank.mandiri.CardAttributeGenerator.BuiltInFictitiousFunctionClassFactory(r4, r9, r10)     // Catch: android.nfc.TagLostException -> La7
            id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager r9 = r16.getKClassImpl$Data$declaredNonStaticMembers$2()     // Catch: android.nfc.TagLostException -> La7
            r2.L$0 = r0     // Catch: android.nfc.TagLostException -> La7
            r2.L$1 = r1     // Catch: android.nfc.TagLostException -> La7
            r2.L$2 = r4     // Catch: android.nfc.TagLostException -> La7
            r2.label = r7     // Catch: android.nfc.TagLostException -> La7
            java.lang.Object r7 = r9.getAuthRequestContext(r2)     // Catch: android.nfc.TagLostException -> La7
            if (r7 != r3) goto L84
            return r3
        L84:
            r9 = r1
            r1 = r7
            r7 = r4
            r4 = r0
        L88:
            java.lang.String r1 = (java.lang.String) r1     // Catch: android.nfc.TagLostException -> La7
            r2.L$0 = r4     // Catch: android.nfc.TagLostException -> La7
            r2.L$1 = r8     // Catch: android.nfc.TagLostException -> La7
            r2.L$2 = r8     // Catch: android.nfc.TagLostException -> La7
            r2.label = r6     // Catch: android.nfc.TagLostException -> La7
            java.lang.Object r1 = r9.PlaceComponentResult(r7, r1, r2)     // Catch: android.nfc.TagLostException -> La7
            if (r1 != r3) goto L99
            return r3
        L99:
            id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r1 = (id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult) r1     // Catch: android.nfc.TagLostException -> La7
            r2.L$0 = r8     // Catch: android.nfc.TagLostException -> La7
            r2.label = r5     // Catch: android.nfc.TagLostException -> La7
            java.lang.Object r1 = r4.MyBillsEntityDataFactory(r1, r2)     // Catch: android.nfc.TagLostException -> La7
            if (r1 != r3) goto La6
            return r3
        La6:
            return r1
        La7:
            id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r1 = new id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 1020(0x3fc, float:1.43E-42)
            r14 = 0
            java.lang.String r4 = "007"
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.applet.NewApplet.BuiltInFictitiousFunctionClassFactory(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [id.dana.electronicmoney.bank.mandiri.applet.NewApplet] */
    @Override // id.dana.electronicmoney.bank.mandiri.applet.CardApplet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r10, kotlin.coroutines.Continuation<? super id.dana.electronicmoney.BalanceResult> r11) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.applet.NewApplet.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
