package id.dana.electronicmoney.bank.mandiri.applet;

import id.dana.electronicmoney.bank.mandiri.MandiriApduCommand;
import id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager;
import id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult;
import id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute;
import id.dana.electronicmoney.helper.EmoneyErrorHelper;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0011J\u001b\u0010\t\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0013J#\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nR\u0016\u0010\u0007\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/applet/OldApplet;", "Lid/dana/electronicmoney/bank/mandiri/applet/CardApplet;", "", "p0", "", "p1", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;", "getAuthRequestContext", "(Ljava/lang/String;Z)Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "PlaceComponentResult", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;)V", "", "BuiltInFictitiousFunctionClassFactory", "(ILid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/electronicmoney/BalanceResult;", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "I", "Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;", "Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;", "p2", "<init>", "(Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class OldApplet extends CardApplet {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int getAuthRequestContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldApplet(MandiriEmoneyManager mandiriEmoneyManager, EmoneyCardAttribute emoneyCardAttribute, MandiriApduCommand mandiriApduCommand) {
        super(mandiriEmoneyManager, emoneyCardAttribute, mandiriApduCommand);
        Intrinsics.checkNotNullParameter(mandiriEmoneyManager, "");
        Intrinsics.checkNotNullParameter(emoneyCardAttribute, "");
        Intrinsics.checkNotNullParameter(mandiriApduCommand, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0 A[Catch: Exception -> 0x01b0, TRY_ENTER, TryCatch #0 {Exception -> 0x01b0, blocks: (B:30:0x007c, B:45:0x00b2, B:48:0x00c0, B:49:0x00ce, B:51:0x00d6, B:57:0x00ff, B:59:0x0107, B:62:0x0114, B:68:0x0126, B:70:0x012e, B:76:0x0156, B:78:0x015e, B:84:0x0170, B:86:0x0178, B:87:0x0182, B:90:0x018c, B:91:0x0196, B:94:0x01a0, B:95:0x01aa), top: B:102:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce A[Catch: Exception -> 0x01b0, TryCatch #0 {Exception -> 0x01b0, blocks: (B:30:0x007c, B:45:0x00b2, B:48:0x00c0, B:49:0x00ce, B:51:0x00d6, B:57:0x00ff, B:59:0x0107, B:62:0x0114, B:68:0x0126, B:70:0x012e, B:76:0x0156, B:78:0x015e, B:84:0x0170, B:86:0x0178, B:87:0x0182, B:90:0x018c, B:91:0x0196, B:94:0x01a0, B:95:0x01aa), top: B:102:0x007c }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v33 */
    @Override // id.dana.electronicmoney.bank.mandiri.applet.CardApplet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object PlaceComponentResult(id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r18, boolean r19, kotlin.coroutines.Continuation<? super id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult> r20) {
        /*
            Method dump skipped, instructions count: 441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.applet.OldApplet.PlaceComponentResult(id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d4 A[RETURN] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    @Override // id.dana.electronicmoney.bank.mandiri.applet.CardApplet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object BuiltInFictitiousFunctionClassFactory(java.lang.String r11, kotlin.coroutines.Continuation<? super id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult> r12) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.applet.OldApplet.BuiltInFictitiousFunctionClassFactory(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Type inference failed for: r2v2, types: [id.dana.electronicmoney.bank.mandiri.applet.OldApplet] */
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.applet.OldApplet.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object KClassImpl$Data$declaredNonStaticMembers$2(EmoneyApiResult emoneyApiResult, boolean z, Continuation<? super EmoneyApiResult> continuation) {
        String str;
        if (z) {
            int i = this.getAuthRequestContext;
            str = i == 1 ? "reversal_cardInfo" : "reversal";
            if (i != 1) {
                PlaceComponentResult(emoneyApiResult);
            }
        } else {
            if (!emoneyApiResult.getGetErrorConfigVersion()) {
                EmoneyErrorHelper emoneyErrorHelper = EmoneyErrorHelper.INSTANCE;
                if (EmoneyErrorHelper.scheduleImpl(emoneyApiResult)) {
                    getAuthRequestContext("010", false);
                }
            }
            PlaceComponentResult(emoneyApiResult);
            str = "update";
        }
        return MyBillsEntityDataFactory(str, emoneyApiResult, continuation);
    }

    private final void PlaceComponentResult(EmoneyApiResult p0) {
        MandiriApduCommand MyBillsEntityDataFactory = getMyBillsEntityDataFactory();
        String str = p0.PlaceComponentResult.get("message");
        if (str == null) {
            str = "";
        }
        p0.PlaceComponentResult.put("message", MyBillsEntityDataFactory.PlaceComponentResult(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0079 A[Catch: Exception -> 0x0158, TryCatch #2 {Exception -> 0x0158, blocks: (B:14:0x0033, B:68:0x0115, B:19:0x0044, B:47:0x00bd, B:29:0x0072, B:31:0x0079, B:34:0x007e, B:35:0x0084, B:38:0x008e, B:39:0x0097, B:41:0x00a0, B:44:0x00b0, B:48:0x00c2, B:50:0x00ca, B:51:0x00d5, B:53:0x00dd, B:56:0x00e2, B:57:0x00ed, B:59:0x00f5, B:62:0x00fb, B:63:0x0100, B:65:0x0108, B:69:0x0119, B:71:0x0121, B:72:0x0128, B:74:0x0130, B:77:0x013d, B:78:0x0147, B:81:0x0153), top: B:92:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0084 A[Catch: Exception -> 0x0158, TRY_LEAVE, TryCatch #2 {Exception -> 0x0158, blocks: (B:14:0x0033, B:68:0x0115, B:19:0x0044, B:47:0x00bd, B:29:0x0072, B:31:0x0079, B:34:0x007e, B:35:0x0084, B:38:0x008e, B:39:0x0097, B:41:0x00a0, B:44:0x00b0, B:48:0x00c2, B:50:0x00ca, B:51:0x00d5, B:53:0x00dd, B:56:0x00e2, B:57:0x00ed, B:59:0x00f5, B:62:0x00fb, B:63:0x0100, B:65:0x0108, B:69:0x0119, B:71:0x0121, B:72:0x0128, B:74:0x0130, B:77:0x013d, B:78:0x0147, B:81:0x0153), top: B:92:0x0027 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object BuiltInFictitiousFunctionClassFactory(int r13, id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r14, kotlin.coroutines.Continuation<? super id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult> r15) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.applet.OldApplet.BuiltInFictitiousFunctionClassFactory(int, id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final EmoneyApiResult getAuthRequestContext(String p0, boolean p1) {
        this.getAuthRequestContext = 0;
        if (Intrinsics.areEqual(p0, "000")) {
            return new EmoneyApiResult(true, "", null, null, null, null, null, new LinkedHashMap(), p1, false, 636, null);
        }
        return new EmoneyApiResult(false, p0, null, null, null, null, null, new LinkedHashMap(), false, false, 892, null);
    }
}
