package id.dana.data.paylater.repository.source.split;

import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.paylater.repository.PaylaterEntityData;
import id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.domain.paylater.model.LoanWhitelist;
import id.dana.model.PayMethodModel;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Singleton
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/data/paylater/repository/source/split/SplitPaylaterEntityData;", "Lid/dana/data/paylater/repository/PaylaterEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/paylater/repository/source/network/result/PaylaterCicilMethodConfigResult;", "getPaylaterCicilMethodConfig", "()Lio/reactivex/Observable;", "", "type", "state", "", "setLoanServicesState", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/paylater/model/LoanWhitelist;", "loanWhitelist", "setOffLoanServicesState", "(Lid/dana/domain/paylater/model/LoanWhitelist;)Lio/reactivex/Observable;", "paylaterChannel", "setPaylaterChannel", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitPaylaterEntityData implements PaylaterEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String ATTR_KEY_PAYLATER_CHANNEL = "paylater_channel";
    public static final String ATTR_KEY_STATE = "state";
    private static char[] BuiltInFictitiousFunctionClassFactory = null;
    private static int PlaceComponentResult = 1;
    private static int getAuthRequestContext;
    private final SplitFacade splitFacade;

    public static /* synthetic */ PaylaterCicilMethodConfigResult $r8$lambda$wDF9AuNcIjkempaI6K2_gECtKzk(PaylaterCicilMethodConfigResult paylaterCicilMethodConfigResult, BaseTrafficType baseTrafficType) {
        int i = PlaceComponentResult + 31;
        getAuthRequestContext = i % 128;
        char c = i % 2 != 0 ? '?' : 'W';
        PaylaterCicilMethodConfigResult m1581getPaylaterCicilMethodConfig$lambda0 = m1581getPaylaterCicilMethodConfig$lambda0(paylaterCicilMethodConfigResult, baseTrafficType);
        if (c == '?') {
            Object obj = null;
            obj.hashCode();
        }
        return m1581getPaylaterCicilMethodConfig$lambda0;
    }

    static {
        MyBillsEntityDataFactory();
        INSTANCE = new Companion(null);
        int i = PlaceComponentResult + 97;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    static void MyBillsEntityDataFactory() {
        BuiltInFictitiousFunctionClassFactory = new char[]{35340, 35771, 35770, 35769, 35765, 35768, 35712, 35712, 35768, 35766, 35765, 35767, 35768, 35773, 35772, 35769, 35773, 35773, 35773, 35712, 35771, 35766, 35767, 35769, 35773, 35761, 35764, 35771};
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable clearCacheLoanWhitelist(String str) {
        int i = PlaceComponentResult + 39;
        getAuthRequestContext = i % 128;
        char c = i % 2 != 0 ? '3' : (char) 16;
        Observable $default$clearCacheLoanWhitelist = PaylaterEntityData.CC.$default$clearCacheLoanWhitelist(this, str);
        if (c == '3') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return $default$clearCacheLoanWhitelist;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getLoanConsultWhitelist(String str, boolean z) {
        int i = PlaceComponentResult + 107;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Observable $default$getLoanConsultWhitelist = PaylaterEntityData.CC.$default$getLoanConsultWhitelist(this, str, z);
        int i3 = PlaceComponentResult + 5;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 4 : (char) 27) != 27) {
            Object[] objArr = null;
            int length = objArr.length;
            return $default$getLoanConsultWhitelist;
        }
        return $default$getLoanConsultWhitelist;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getLoanRegisterInfo(String str) {
        int i = PlaceComponentResult + 105;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Observable $default$getLoanRegisterInfo = PaylaterEntityData.CC.$default$getLoanRegisterInfo(this, str);
        int i3 = getAuthRequestContext + 95;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            return $default$getLoanRegisterInfo;
        }
        return $default$getLoanRegisterInfo;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getPayLaterCacheWhitelistValue(String str) {
        int i = getAuthRequestContext + 67;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Observable $default$getPayLaterCacheWhitelistValue = PaylaterEntityData.CC.$default$getPayLaterCacheWhitelistValue(this, str);
        int i3 = getAuthRequestContext + 23;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 == 0 ? 'P' : (char) 16) != 'P') {
            return $default$getPayLaterCacheWhitelistValue;
        }
        Object obj = null;
        obj.hashCode();
        return $default$getPayLaterCacheWhitelistValue;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getPayLaterLoanStatus(String str) {
        try {
            int i = getAuthRequestContext + 105;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            Observable $default$getPayLaterLoanStatus = PaylaterEntityData.CC.$default$getPayLaterLoanStatus(this, str);
            int i3 = getAuthRequestContext + 53;
            try {
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return $default$getPayLaterLoanStatus;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getPaylaterHomeInfo(boolean z) {
        try {
            int i = PlaceComponentResult + 37;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            Observable $default$getPaylaterHomeInfo = PaylaterEntityData.CC.$default$getPaylaterHomeInfo(this, z);
            int i3 = PlaceComponentResult + 65;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return $default$getPaylaterHomeInfo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getPaylaterRotationDelayTime(String str) {
        int i = getAuthRequestContext + 53;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Observable $default$getPaylaterRotationDelayTime = PaylaterEntityData.CC.$default$getPaylaterRotationDelayTime(this, str);
        int i3 = getAuthRequestContext + 67;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 18 : (char) 6) != 6) {
            int i4 = 75 / 0;
            return $default$getPaylaterRotationDelayTime;
        }
        return $default$getPaylaterRotationDelayTime;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable resetPayLaterCacheLoanWhitelist() {
        int i = PlaceComponentResult + 71;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Observable $default$resetPayLaterCacheLoanWhitelist = PaylaterEntityData.CC.$default$resetPayLaterCacheLoanWhitelist(this);
        try {
            int i3 = PlaceComponentResult + 107;
            getAuthRequestContext = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return $default$resetPayLaterCacheLoanWhitelist;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return $default$resetPayLaterCacheLoanWhitelist;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable savePayLaterCacheWhitelistValue(String str, LoanWhitelist loanWhitelist) {
        int i = getAuthRequestContext + 9;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Observable $default$savePayLaterCacheWhitelistValue = PaylaterEntityData.CC.$default$savePayLaterCacheWhitelistValue(this, str, loanWhitelist);
        int i3 = getAuthRequestContext + 89;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return $default$savePayLaterCacheWhitelistValue;
        }
        return $default$savePayLaterCacheWhitelistValue;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable savePayLaterLoanStatus(List list, String str) {
        int i = getAuthRequestContext + 83;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Observable $default$savePayLaterLoanStatus = PaylaterEntityData.CC.$default$savePayLaterLoanStatus(this, list, str);
        int i3 = getAuthRequestContext + 27;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return $default$savePayLaterLoanStatus;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable savePaylaterRotationDelayTime(String str, long j) {
        int i = PlaceComponentResult + 97;
        getAuthRequestContext = i % 128;
        char c = i % 2 != 0 ? (char) 6 : (char) 31;
        Observable $default$savePaylaterRotationDelayTime = PaylaterEntityData.CC.$default$savePaylaterRotationDelayTime(this, str, j);
        if (c != 31) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return $default$savePaylaterRotationDelayTime;
    }

    @Inject
    public SplitPaylaterEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final Observable<PaylaterCicilMethodConfigResult> getPaylaterCicilMethodConfig() {
        final PaylaterCicilMethodConfigResult paylaterCicilMethodConfigResult = new PaylaterCicilMethodConfigResult(PayMethodModel.CashierSectionTitle.DANA_CICIL, "%@x installments, pay every 2 weeks!", "paylater_cicil_contents", CollectionsKt.listOf("loan_credit_tnc"), "216620000097334287923", 24, 5, null, "0% loan interest fee promo", "Free Interest Fee", "Let's activate DANA CICIL now!", null, null, 6272, null);
        Observable<PaylaterCicilMethodConfigResult> onErrorResumeNext = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitPaylaterEntityData.$r8$lambda$wDF9AuNcIjkempaI6K2_gECtKzk(PaylaterCicilMethodConfigResult.this, (BaseTrafficType) obj);
            }
        }).onErrorResumeNext(SplitConfigEntityData.INSTANCE.onJSONErrorReturnDefault(paylaterCicilMethodConfigResult));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        int i = PlaceComponentResult + 45;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return onErrorResumeNext;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final Observable<Boolean> setPaylaterChannel(String paylaterChannel) {
        Observable<Boolean> just;
        int i = getAuthRequestContext + 9;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(paylaterChannel, "");
            SplitFacade.PlaceComponentResult(ATTR_KEY_PAYLATER_CHANNEL, paylaterChannel);
            just = Observable.just(Boolean.TRUE);
            Intrinsics.checkNotNullExpressionValue(just, "");
            Object obj = null;
            obj.hashCode();
        } else {
            Intrinsics.checkNotNullParameter(paylaterChannel, "");
            SplitFacade.PlaceComponentResult(ATTR_KEY_PAYLATER_CHANNEL, paylaterChannel);
            just = Observable.just(Boolean.TRUE);
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        try {
            int i2 = getAuthRequestContext + 39;
            try {
                PlaceComponentResult = i2 % 128;
                int i3 = i2 % 2;
                return just;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if ((r6.length() > 0 ? 20 : 23) != 23) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        r0 = id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.PlaceComponentResult + 87;
        id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.getAuthRequestContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        if ((r0 % 2) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        if ((r0 > 0) != false) goto L19;
     */
    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final io.reactivex.Observable<java.lang.Boolean> setLoanServicesState(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            int r0 = id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.getAuthRequestContext
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            java.lang.String r3 = ""
            if (r0 != 0) goto L2b
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r4 = 0
            r4.hashCode()     // Catch: java.lang.Throwable -> L29
            if (r0 <= 0) goto L25
            r0 = 1
            goto L26
        L25:
            r0 = 0
        L26:
            if (r0 == 0) goto L52
            goto L43
        L29:
            r6 = move-exception
            throw r6
        L2b:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)     // Catch: java.lang.Exception -> L7c
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)     // Catch: java.lang.Exception -> L7c
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> L7c
            int r0 = r0.length()     // Catch: java.lang.Exception -> L7c
            r4 = 23
            if (r0 <= 0) goto L3f
            r0 = 20
            goto L41
        L3f:
            r0 = 23
        L41:
            if (r0 == r4) goto L52
        L43:
            int r0 = id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.PlaceComponentResult
            int r0 = r0 + 87
            int r4 = r0 % 128
            id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.getAuthRequestContext = r4
            int r0 = r0 % 2
            if (r0 == 0) goto L50
            goto L53
        L50:
            r2 = 1
            goto L53
        L52:
            r1 = 0
        L53:
            if (r1 == 0) goto L72
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r6 = r6.toLowerCase(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            r0.append(r6)
            java.lang.String r6 = "_state"
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            id.dana.data.toggle.SplitFacade.PlaceComponentResult(r6, r7)
        L72:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            io.reactivex.Observable r6 = io.reactivex.Observable.just(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            return r6
        L7c:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.setLoanServicesState(java.lang.String, java.lang.String):io.reactivex.Observable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        if ((r6 != null ? '_' : 'M') != 'M') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        if ((r6 == null) != true) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        r6 = r6.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
    
        if (r6.hasNext() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        r1 = (id.dana.domain.paylater.model.LoanInfo) r6.next();
        r2 = new java.lang.StringBuilder();
        r2.append("service_paylater_");
        r3 = r1.getType().toLowerCase(java.util.Locale.ROOT);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "");
        r2.append(r3);
        r2 = r2.toString();
        r3 = new java.lang.StringBuilder();
        r3.append("setting_paylater_");
        r1 = r1.getType().toLowerCase(java.util.Locale.ROOT);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "");
        r3.append(r1);
        r1 = r3.toString();
        setLoanServicesState(r2, "off");
        setLoanServicesState(r1, "off");
     */
    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final io.reactivex.Observable<java.lang.Boolean> setOffLoanServicesState(id.dana.domain.paylater.model.LoanWhitelist r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            if (r6 == 0) goto L90
            int r1 = id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.getAuthRequestContext     // Catch: java.lang.Exception -> L8e
            int r1 = r1 + 115
            int r2 = r1 % 128
            id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.PlaceComponentResult = r2     // Catch: java.lang.Exception -> L8e
            int r1 = r1 % 2
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L14
            r1 = 1
            goto L15
        L14:
            r1 = 0
        L15:
            if (r1 == r3) goto L27
            java.util.List r6 = r6.getLoanInfo()
            r1 = 77
            if (r6 == 0) goto L22
            r2 = 95
            goto L24
        L22:
            r2 = 77
        L24:
            if (r2 == r1) goto L90
            goto L35
        L27:
            java.util.List r6 = r6.getLoanInfo()
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L8c
            if (r6 == 0) goto L32
            goto L33
        L32:
            r2 = 1
        L33:
            if (r2 == r3) goto L90
        L35:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L3b:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L90
            java.lang.Object r1 = r6.next()
            id.dana.domain.paylater.model.LoanInfo r1 = (id.dana.domain.paylater.model.LoanInfo) r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "service_paylater_"
            r2.append(r3)
            java.lang.String r3 = r1.getType()
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toLowerCase(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "setting_paylater_"
            r3.append(r4)
            java.lang.String r1 = r1.getType()
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r3 = "off"
            r5.setLoanServicesState(r2, r3)
            r5.setLoanServicesState(r1, r3)
            goto L3b
        L8c:
            r6 = move-exception
            throw r6
        L8e:
            r6 = move-exception
            throw r6
        L90:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            io.reactivex.Observable r6 = io.reactivex.Observable.just(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            int r0 = id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.getAuthRequestContext
            int r0 = r0 + 55
            int r1 = r0 % 128
            id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.PlaceComponentResult = r1
            int r0 = r0 % 2
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.setOffLoanServicesState(id.dana.domain.paylater.model.LoanWhitelist):io.reactivex.Observable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0071, code lost:
    
        if (id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult.class.isAssignableFrom(org.json.JSONArray.class) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0073, code lost:
    
        if (r7 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0075, code lost:
    
        r6 = id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.PlaceComponentResult + 117;
        id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.getAuthRequestContext = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0080, code lost:
    
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0081, code lost:
    
        r6 = (id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult) new org.json.JSONArray(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008b, code lost:
    
        if (r7 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008d, code lost:
    
        r1 = '.';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0090, code lost:
    
        r1 = 'V';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0092, code lost:
    
        if (r1 == 'V') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0094, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0095, code lost:
    
        r0 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult().fromJson(id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r7, null), (java.lang.Class<id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult>) id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0045, code lost:
    
        if ((id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult.class.isAssignableFrom(org.json.JSONArray.class) ? 'C' : 'W') != 'C') goto L16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getPaylaterCicilMethodConfig$lambda-0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult m1581getPaylaterCicilMethodConfig$lambda0(id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult r6, id.dana.data.toggle.traffictype.BaseTrafficType r7) {
        /*
            int r0 = id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.getAuthRequestContext
            int r0 = r0 + 55
            int r1 = r0 % 128
            id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 28
            r2 = 4
            r3 = 0
            r4 = 1
            java.lang.String r5 = ""
            if (r0 != 0) goto L48
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r5)
            int[] r0 = new int[r2]
            r0 = {x00ba: FILL_ARRAY_DATA , data: [0, 28, 189, 0} // fill-array
            byte[] r1 = new byte[r1]
            r1 = {x00c6: FILL_ARRAY_DATA , data: [0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1} // fill-array
            java.lang.Object[] r2 = new java.lang.Object[r4]
            a(r0, r4, r1, r2)
            r0 = r2[r3]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.lang.String r7 = r7.getAuthRequestContext(r0, r3)
            java.lang.Class<id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult> r0 = id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult.class
            java.lang.Class<org.json.JSONArray> r1 = org.json.JSONArray.class
            boolean r0 = r0.isAssignableFrom(r1)
            r1 = 67
            if (r0 == 0) goto L43
            r0 = 67
            goto L45
        L43:
            r0 = 87
        L45:
            if (r0 == r1) goto L73
            goto L89
        L48:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r5)
            int[] r0 = new int[r2]
            r0 = {x00d8: FILL_ARRAY_DATA , data: [0, 28, 189, 0} // fill-array
            byte[] r1 = new byte[r1]
            r1 = {x00e4: FILL_ARRAY_DATA , data: [0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1} // fill-array
            java.lang.Object[] r2 = new java.lang.Object[r4]
            a(r0, r4, r1, r2)
            r0 = r2[r3]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.lang.String r7 = r7.getAuthRequestContext(r0, r3)
            java.lang.Class<id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult> r0 = id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult.class
            java.lang.Class<org.json.JSONArray> r1 = org.json.JSONArray.class
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 == 0) goto L89
        L73:
            if (r7 != 0) goto L80
            int r6 = id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.PlaceComponentResult
            int r6 = r6 + 117
            int r7 = r6 % 128
            id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.getAuthRequestContext = r7
            int r6 = r6 % 2
            goto L81
        L80:
            r5 = r7
        L81:
            org.json.JSONArray r6 = new org.json.JSONArray
            r6.<init>(r5)
            id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult r6 = (id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult) r6
            goto Lb6
        L89:
            r0 = 86
            if (r7 == 0) goto L90
            r1 = 46
            goto L92
        L90:
            r1 = 86
        L92:
            if (r1 == r0) goto Lb6
            r0 = 0
            com.google.gson.Gson r1 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult()     // Catch: java.lang.Exception -> La4
            java.lang.String r7 = id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r7, r0)     // Catch: java.lang.Exception -> La4
            java.lang.Class<id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult> r2 = id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult.class
            java.lang.Object r0 = r1.fromJson(r7, r2)     // Catch: java.lang.Exception -> La4
            goto La5
        La4:
        La5:
            if (r0 != 0) goto La8
            r3 = 1
        La8:
            if (r3 == 0) goto Lb5
            int r7 = id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.getAuthRequestContext
            int r7 = r7 + 99
            int r0 = r7 % 128
            id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.PlaceComponentResult = r0
            int r7 = r7 % 2
            goto Lb6
        Lb5:
            r6 = r0
        Lb6:
            id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult r6 = (id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.paylater.repository.source.split.SplitPaylaterEntityData.m1581getPaylaterCicilMethodConfig$lambda0(id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult, id.dana.data.toggle.traffictype.BaseTrafficType):id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult");
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        char[] cArr;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                cArr3[i5] = (char) (cArr2[i5] ^ 5097613533456403102L);
            }
            cArr2 = cArr3;
        }
        char[] cArr4 = new char[i2];
        try {
            System.arraycopy(cArr2, i, cArr4, 0, i2);
            if (!(bArr == null)) {
                int i6 = $11 + 73;
                $10 = i6 % 128;
                if (i6 % 2 != 0) {
                    cArr = new char[i2];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 1;
                } else {
                    cArr = new char[i2];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                }
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    if ((bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1 ? (char) 11 : 'F') != 11) {
                        cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    } else {
                        int i7 = $11 + 83;
                        $10 = i7 % 128;
                        if (i7 % 2 != 0) {
                            cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] + 4) - 0) >>> c);
                        } else {
                            cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                        }
                    }
                    try {
                        c = cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                cArr4 = cArr;
            }
            if (!(i4 <= 0)) {
                int i8 = $11 + 125;
                $10 = i8 % 128;
                if (i8 % 2 != 0) {
                    char[] cArr5 = new char[i2];
                    System.arraycopy(cArr4, 1, cArr5, 1, i2);
                    System.arraycopy(cArr5, 1, cArr4, i2 + i4, i4);
                    System.arraycopy(cArr5, i4, cArr4, 1, i2 * i4);
                } else {
                    char[] cArr6 = new char[i2];
                    System.arraycopy(cArr4, 0, cArr6, 0, i2);
                    int i9 = i2 - i4;
                    System.arraycopy(cArr6, 0, cArr4, i9, i4);
                    System.arraycopy(cArr6, i4, cArr4, 0, i9);
                }
            }
            if (z) {
                char[] cArr7 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    int i10 = $11 + 41;
                    $10 = i10 % 128;
                    int i11 = i10 % 2;
                    cArr7[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr4[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr4 = cArr7;
            }
            if (i3 > 0) {
                int i12 = $11 + 125;
                $10 = i12 % 128;
                if (i12 % 2 != 0) {
                }
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
            }
            objArr[0] = new String(cArr4);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
