package id.dana.electronicmoney.bank.mandiri.applet;

import id.dana.electronicmoney.BalanceResult;
import id.dana.electronicmoney.bank.mandiri.CardAttributeGenerator;
import id.dana.electronicmoney.bank.mandiri.MandiriApduCommand;
import id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager;
import id.dana.electronicmoney.bank.mandiri.constants.EmoneyMandiriErrorCode;
import id.dana.electronicmoney.bank.mandiri.constants.EmoneyMandiriErrorMessage;
import id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult;
import id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResultKt;
import id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute;
import id.dana.electronicmoney.constants.ElectronicMoneyErrorCode;
import id.dana.electronicmoney.constants.ElectronicMoneyName;
import id.dana.electronicmoney.helper.EmoneyErrorHelper;
import id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 *2\u00020\u0001:\u0001*B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\"\u0012\u0006\u0010\u0004\u001a\u00020\u001b\u0012\u0006\u0010'\u001a\u00020\u001e¢\u0006\u0004\b(\u0010)J%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\rJ\u001b\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\rJ\u001b\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\rJ%\u0010\t\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u000bH\u0084@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0010J\u001b\u0010\t\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\rJ#\u0010\u0006\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0012J\u001b\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0013J!\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\t\u0010\u0014J\u000f\u0010\f\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\f\u0010\u0015J#\u0010\u000e\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\rJ#\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\rJ#\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0019J\u0013\u0010\u0006\u001a\u00020\u0011*\u00020\u000bH\u0002¢\u0006\u0004\b\u0006\u0010\u001aR\u001a\u0010\f\u001a\u00020\u001b8\u0005X\u0084\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u0016\u0010\u001dR\u001a\u0010\t\u001a\u00020\u001e8\u0005X\u0085\u0004¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b\t\u0010 R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010!R\u001a\u0010\u0016\u001a\u00020\"8\u0005X\u0085\u0004¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b\u0006\u0010$R\u0016\u0010\u0006\u001a\u00020%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010&\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/applet/CardApplet;", "", "", "p0", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/electronicmoney/BalanceResult;", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Lid/dana/electronicmoney/BalanceResult;", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;", "PlaceComponentResult", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthRequestContext", "lookAheadTest", "(Ljava/lang/String;Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/lang/String;Ljava/lang/String;)Z", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;)V", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleImpl", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;)Z", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;", "()Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;", "Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;", "Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;", "()Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;", "Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;", "Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;", "()Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;", "", "I", "p2", "<init>", "(Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class CardApplet {
    private int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final EmoneyCardAttribute PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final MandiriEmoneyManager KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final MandiriApduCommand MyBillsEntityDataFactory;
    private EmoneyApiResult getAuthRequestContext;

    public abstract Object BuiltInFictitiousFunctionClassFactory(String str, Continuation<? super EmoneyApiResult> continuation);

    public abstract Object KClassImpl$Data$declaredNonStaticMembers$2(EmoneyApiResult emoneyApiResult, Continuation<? super BalanceResult> continuation);

    public abstract Object PlaceComponentResult(EmoneyApiResult emoneyApiResult, boolean z, Continuation<? super EmoneyApiResult> continuation);

    public CardApplet(MandiriEmoneyManager mandiriEmoneyManager, EmoneyCardAttribute emoneyCardAttribute, MandiriApduCommand mandiriApduCommand) {
        Intrinsics.checkNotNullParameter(mandiriEmoneyManager, "");
        Intrinsics.checkNotNullParameter(emoneyCardAttribute, "");
        Intrinsics.checkNotNullParameter(mandiriApduCommand, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = mandiriEmoneyManager;
        this.PlaceComponentResult = emoneyCardAttribute;
        this.MyBillsEntityDataFactory = mandiriApduCommand;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final MandiriEmoneyManager getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final EmoneyCardAttribute getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final MandiriApduCommand getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public final Object PlaceComponentResult(EmoneyApiResult emoneyApiResult, Continuation<? super BalanceResult> continuation) {
        this.getAuthRequestContext = emoneyApiResult;
        EmoneyErrorHelper emoneyErrorHelper = EmoneyErrorHelper.INSTANCE;
        if (EmoneyErrorHelper.NetworkUserEntityData$$ExternalSyntheticLambda1(emoneyApiResult)) {
            return lookAheadTest(emoneyApiResult, continuation);
        }
        if (!BuiltInFictitiousFunctionClassFactory(emoneyApiResult)) {
            EmoneyErrorHelper emoneyErrorHelper2 = EmoneyErrorHelper.INSTANCE;
            if (EmoneyErrorHelper.MyBillsEntityDataFactory(emoneyApiResult)) {
                return MyBillsEntityDataFactory(ElectronicMoneyErrorCode.INQUIRY_BALANCE_FAILED);
            }
            EmoneyErrorHelper emoneyErrorHelper3 = EmoneyErrorHelper.INSTANCE;
            if (EmoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(emoneyApiResult)) {
                MyBillsEntityDataFactory(emoneyApiResult.getAuthRequestContext, EmoneyMandiriErrorMessage.CARD_NOT_SUPPORTED);
                return MyBillsEntityDataFactory("011");
            }
            EmoneyErrorHelper emoneyErrorHelper4 = EmoneyErrorHelper.INSTANCE;
            if (EmoneyErrorHelper.DatabaseTableConfigUtil(emoneyApiResult)) {
                getAuthRequestContext("3 times tried", "3 times tried");
                return MyBillsEntityDataFactory("009");
            } else if (emoneyApiResult.getGetErrorConfigVersion()) {
                return BuiltInFictitiousFunctionClassFactory(emoneyApiResult, continuation);
            } else {
                String str = emoneyApiResult.getAuthRequestContext;
                MyBillsEntityDataFactory(str != null ? str : "", EmoneyMandiriErrorMessage.ERROR_AGGREGATOR);
                return MyBillsEntityDataFactory(emoneyApiResult.getAuthRequestContext);
            }
        }
        ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker = this.KClassImpl$Data$declaredNonStaticMembers$2.electronicMoneyMixpanelTracker;
        if (electronicMoneyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            electronicMoneyAnalyticTracker = null;
        }
        electronicMoneyAnalyticTracker.BuiltInFictitiousFunctionClassFactory("MANDIRI", "success", "", "");
        return new BalanceResult(true, ElectronicMoneyName.EMONEY, this.PlaceComponentResult.moveToNextValue, this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, null, null, false, null, null, 496, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0127 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0135 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0136 A[PHI: r15
      0x0136: PHI (r15v30 java.lang.Object) = (r15v29 java.lang.Object), (r15v1 java.lang.Object) binds: [B:43:0x0133, B:25:0x00a2] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017d A[PHI: r15
      0x017d: PHI (r15v37 java.lang.Object) = (r15v36 java.lang.Object), (r15v1 java.lang.Object) binds: [B:56:0x017a, B:22:0x007f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e6 A[PHI: r15
      0x01e6: PHI (r15v45 java.lang.Object) = (r15v44 java.lang.Object), (r15v1 java.lang.Object) binds: [B:75:0x01e3, B:18:0x0057] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object BuiltInFictitiousFunctionClassFactory(id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r14, kotlin.coroutines.Continuation<? super id.dana.electronicmoney.BalanceResult> r15) {
        /*
            Method dump skipped, instructions count: 764
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.applet.CardApplet.BuiltInFictitiousFunctionClassFactory(id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(2:3|(15:5|6|(1:(1:(7:10|11|(3:13|(1:15)(1:17)|16)|18|19|20|21)(2:25|26))(1:27))(5:37|(1:39)|40|(2:42|(1:44))|45)|28|(1:30)|31|(1:33)|34|(1:36)|11|(0)|18|19|20|21))|46|6|(0)(0)|28|(0)|31|(0)|34|(0)|11|(0)|18|19|20|21) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ca, code lost:
    
        r14 = r13.PlaceComponentResult.moveToNextValue;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAuthRequestContext(id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r13, id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r14, kotlin.coroutines.Continuation<? super id.dana.electronicmoney.BalanceResult> r15) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.applet.CardApplet.getAuthRequestContext(id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult, id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object MyBillsEntityDataFactory(String str, EmoneyApiResult emoneyApiResult, Continuation<? super EmoneyApiResult> continuation) {
        MandiriEmoneyManager mandiriEmoneyManager = this.KClassImpl$Data$declaredNonStaticMembers$2;
        CardAttributeGenerator cardAttributeGenerator = CardAttributeGenerator.INSTANCE;
        return mandiriEmoneyManager.getAuthRequestContext(CardAttributeGenerator.getAuthRequestContext(this.PlaceComponentResult, this.MyBillsEntityDataFactory, str, emoneyApiResult), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object BuiltInFictitiousFunctionClassFactory(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof id.dana.electronicmoney.bank.mandiri.applet.CardApplet$confirm$1
            if (r0 == 0) goto L14
            r0 = r8
            id.dana.electronicmoney.bank.mandiri.applet.CardApplet$confirm$1 r0 = (id.dana.electronicmoney.bank.mandiri.applet.CardApplet$confirm$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            id.dana.electronicmoney.bank.mandiri.applet.CardApplet$confirm$1 r0 = new id.dana.electronicmoney.bank.mandiri.applet.CardApplet$confirm$1
            r0.<init>(r5, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L83
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$2
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r0.L$0
            id.dana.electronicmoney.bank.mandiri.applet.CardApplet r2 = (id.dana.electronicmoney.bank.mandiri.applet.CardApplet) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L63
        L46:
            kotlin.ResultKt.throwOnFailure(r8)
            id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager r8 = r5.KClassImpl$Data$declaredNonStaticMembers$2
            id.dana.electronicmoney.bank.mandiri.CardAttributeGenerator r2 = id.dana.electronicmoney.bank.mandiri.CardAttributeGenerator.INSTANCE
            id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute r2 = r5.PlaceComponentResult
            id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute r2 = id.dana.electronicmoney.bank.mandiri.CardAttributeGenerator.PlaceComponentResult(r2, r6, r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = r8.BuiltInFictitiousFunctionClassFactory(r2, r0)
            if (r8 != r1) goto L62
            return r1
        L62:
            r2 = r5
        L63:
            id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r8 = (id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult) r8
            boolean r4 = r8.getGetErrorConfigVersion()
            if (r4 != 0) goto L83
            id.dana.electronicmoney.helper.EmoneyErrorHelper r4 = id.dana.electronicmoney.helper.EmoneyErrorHelper.INSTANCE
            boolean r8 = id.dana.electronicmoney.helper.EmoneyErrorHelper.NetworkUserEntityData$$ExternalSyntheticLambda0(r8)
            if (r8 == 0) goto L83
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r6 = r2.BuiltInFictitiousFunctionClassFactory(r6, r7, r0)
            if (r6 != r1) goto L83
            return r1
        L83:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.applet.CardApplet.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object lookAheadTest(id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r6, kotlin.coroutines.Continuation<? super id.dana.electronicmoney.BalanceResult> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof id.dana.electronicmoney.bank.mandiri.applet.CardApplet$doReversal$1
            if (r0 == 0) goto L14
            r0 = r7
            id.dana.electronicmoney.bank.mandiri.applet.CardApplet$doReversal$1 r0 = (id.dana.electronicmoney.bank.mandiri.applet.CardApplet$doReversal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            id.dana.electronicmoney.bank.mandiri.applet.CardApplet$doReversal$1 r0 = new id.dana.electronicmoney.bank.mandiri.applet.CardApplet$doReversal$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L60
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$0
            id.dana.electronicmoney.bank.mandiri.applet.CardApplet r6 = (id.dana.electronicmoney.bank.mandiri.applet.CardApplet) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L52
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r6 = r6.lookAheadTest
            if (r6 != 0) goto L46
            java.lang.String r6 = ""
        L46:
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r5.BuiltInFictitiousFunctionClassFactory(r6, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r6 = r5
        L52:
            id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r7 = (id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult) r7
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r6.getAuthRequestContext(r7, r0)
            if (r7 != r1) goto L60
            return r1
        L60:
            id.dana.electronicmoney.BalanceResult r7 = (id.dana.electronicmoney.BalanceResult) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.applet.CardApplet.lookAheadTest(id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object getAuthRequestContext(EmoneyApiResult emoneyApiResult, Continuation<? super BalanceResult> continuation) {
        if (emoneyApiResult.getGetErrorConfigVersion() || emoneyApiResult.getMyBillsEntityDataFactory()) {
            return KClassImpl$Data$declaredNonStaticMembers$2(emoneyApiResult, continuation);
        }
        String str = emoneyApiResult.getAuthRequestContext;
        if (str == null) {
            str = "";
        }
        String str2 = EmoneyMandiriErrorMessage.REVERSAL;
        MyBillsEntityDataFactory(str, EmoneyMandiriErrorMessage.REVERSAL);
        String str3 = emoneyApiResult.getAuthRequestContext;
        if (str3 != null) {
            str2 = str3;
        }
        getAuthRequestContext(str2, "");
        return MyBillsEntityDataFactory("009");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void PlaceComponentResult() {
        ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker = this.KClassImpl$Data$declaredNonStaticMembers$2.electronicMoneyMixpanelTracker;
        if (electronicMoneyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            electronicMoneyAnalyticTracker = null;
        }
        electronicMoneyAnalyticTracker.BuiltInFictitiousFunctionClassFactory("MANDIRI", "success", "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker = this.KClassImpl$Data$declaredNonStaticMembers$2.electronicMoneyMixpanelTracker;
        if (electronicMoneyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            electronicMoneyAnalyticTracker = null;
        }
        if (p0 == null) {
            p0 = "";
        }
        electronicMoneyAnalyticTracker.BuiltInFictitiousFunctionClassFactory("MANDIRI", "failed", p0, p1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BalanceResult MyBillsEntityDataFactory(String p0) {
        String str = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
        return new BalanceResult(false, ElectronicMoneyName.EMONEY, this.PlaceComponentResult.moveToNextValue, str, null, p0, false, null, null, 464, null);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        if (Intrinsics.areEqual(p0, "NEW")) {
            if (!(p1 != null && Integer.parseInt(p1) == 0)) {
                String str = p1;
                if (!(str == null || StringsKt.isBlank(str))) {
                    return false;
                }
            }
            return true;
        }
        EmoneyErrorHelper emoneyErrorHelper = EmoneyErrorHelper.INSTANCE;
        return EmoneyErrorHelper.MyBillsEntityDataFactory(p1);
    }

    private final void getAuthRequestContext(String p0, String p1) {
        EmoneyErrorHelper emoneyErrorHelper = EmoneyErrorHelper.INSTANCE;
        if (EmoneyErrorHelper.MyBillsEntityDataFactory(p0)) {
            return;
        }
        ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker = this.KClassImpl$Data$declaredNonStaticMembers$2.electronicMoneyMixpanelTracker;
        if (electronicMoneyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            electronicMoneyAnalyticTracker = null;
        }
        if (p0 == null) {
            p0 = "";
        }
        electronicMoneyAnalyticTracker.getAuthRequestContext("Emoney", "Failed", p0, p1);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object MyBillsEntityDataFactory(id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r6, kotlin.coroutines.Continuation<? super id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof id.dana.electronicmoney.bank.mandiri.applet.CardApplet$handleErrorReversal$1
            if (r0 == 0) goto L14
            r0 = r7
            id.dana.electronicmoney.bank.mandiri.applet.CardApplet$handleErrorReversal$1 r0 = (id.dana.electronicmoney.bank.mandiri.applet.CardApplet$handleErrorReversal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            id.dana.electronicmoney.bank.mandiri.applet.CardApplet$handleErrorReversal$1 r0 = new id.dana.electronicmoney.bank.mandiri.applet.CardApplet$handleErrorReversal$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r6 = r0.L$1
            id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r6 = (id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult) r6
            java.lang.Object r0 = r0.L$0
            id.dana.electronicmoney.bank.mandiri.applet.CardApplet r0 = (id.dana.electronicmoney.bank.mandiri.applet.CardApplet) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto Lac
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L72
        L42:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6.getGetErrorConfigVersion()
            if (r7 != 0) goto L50
            int r7 = r5.BuiltInFictitiousFunctionClassFactory
            r2 = 3
            if (r7 >= r2) goto Lbe
        L50:
            id.dana.electronicmoney.helper.EmoneyErrorHelper r7 = id.dana.electronicmoney.helper.EmoneyErrorHelper.INSTANCE
            boolean r7 = id.dana.electronicmoney.helper.EmoneyErrorHelper.KClassImpl$Data$declaredNonStaticMembers$2(r6)
            java.lang.String r2 = ""
            if (r7 == 0) goto L73
            int r6 = r5.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + r4
            r5.BuiltInFictitiousFunctionClassFactory = r6
            id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r6 = r5.getAuthRequestContext
            r7 = 0
            if (r6 == 0) goto L66
            java.lang.String r7 = r6.lookAheadTest
        L66:
            if (r7 == 0) goto L69
            r2 = r7
        L69:
            r0.label = r4
            java.lang.Object r7 = r5.BuiltInFictitiousFunctionClassFactory(r2, r0)
            if (r7 != r1) goto L72
            return r1
        L72:
            return r7
        L73:
            id.dana.electronicmoney.helper.EmoneyErrorHelper r7 = id.dana.electronicmoney.helper.EmoneyErrorHelper.INSTANCE
            boolean r7 = id.dana.electronicmoney.helper.EmoneyErrorHelper.initRecordTimeStamp(r6)
            if (r7 != 0) goto Lbe
            id.dana.electronicmoney.helper.EmoneyErrorHelper r7 = id.dana.electronicmoney.helper.EmoneyErrorHelper.INSTANCE
            boolean r7 = id.dana.electronicmoney.helper.EmoneyErrorHelper.scheduleImpl(r6)
            if (r7 != 0) goto Lbe
            id.dana.electronicmoney.helper.EmoneyErrorHelper r7 = id.dana.electronicmoney.helper.EmoneyErrorHelper.INSTANCE
            boolean r7 = id.dana.electronicmoney.helper.EmoneyErrorHelper.PlaceComponentResult(r6)
            if (r7 == 0) goto Lb3
            id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r7 = r5.getAuthRequestContext
            if (r7 == 0) goto Lab
            java.lang.String r4 = r7.lookAheadTest
            if (r4 == 0) goto L94
            r2 = r4
        L94:
            java.util.Map<java.lang.String, java.lang.String> r7 = r7.PlaceComponentResult
            java.lang.String r4 = "session"
            java.lang.Object r7 = r7.get(r4)
            java.lang.String r7 = (java.lang.String) r7
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.BuiltInFictitiousFunctionClassFactory(r2, r7, r0)
            if (r7 != r1) goto Lab
            return r1
        Lab:
            r0 = r5
        Lac:
            java.lang.String r6 = r6.getAuthRequestContext
            id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r6 = BuiltInFictitiousFunctionClassFactory(r0, r6)
            goto Lc4
        Lb3:
            boolean r7 = r6.getGetErrorConfigVersion()
            if (r7 == 0) goto Lc4
            r6.getErrorConfigVersion = r4
            r6.scheduleImpl = r4
            goto Lc4
        Lbe:
            java.lang.String r6 = r6.getAuthRequestContext
            id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r6 = BuiltInFictitiousFunctionClassFactory(r5, r6)
        Lc4:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.applet.CardApplet.MyBillsEntityDataFactory(id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(EmoneyApiResult emoneyApiResult) {
        String str = emoneyApiResult.lookAheadTest;
        if (str == null) {
            str = "";
        }
        String PlaceComponentResult = EmoneyApiResultKt.PlaceComponentResult(emoneyApiResult);
        if (PlaceComponentResult == null) {
            PlaceComponentResult = EmoneyApiResultKt.MyBillsEntityDataFactory(emoneyApiResult);
        }
        return BuiltInFictitiousFunctionClassFactory(str, PlaceComponentResult);
    }

    private static /* synthetic */ EmoneyApiResult BuiltInFictitiousFunctionClassFactory(CardApplet cardApplet, String str) {
        cardApplet.BuiltInFictitiousFunctionClassFactory = 0;
        if (Intrinsics.areEqual(str, "000")) {
            return new EmoneyApiResult(true, "", null, null, null, null, null, new LinkedHashMap(), false, false, 636, null);
        }
        return new EmoneyApiResult(false, str, null, null, null, null, null, new LinkedHashMap(), false, false, 892, null);
    }

    private final Object scheduleImpl(EmoneyApiResult emoneyApiResult, Continuation<? super BalanceResult> continuation) {
        if (Intrinsics.areEqual(emoneyApiResult.getAuthRequestContext, EmoneyMandiriErrorCode.REVERSAL_NEEDED)) {
            return lookAheadTest(emoneyApiResult, continuation);
        }
        getAuthRequestContext(emoneyApiResult.getAuthRequestContext, "");
        String str = emoneyApiResult.getAuthRequestContext;
        return MyBillsEntityDataFactory(str != null ? str : "");
    }
}
