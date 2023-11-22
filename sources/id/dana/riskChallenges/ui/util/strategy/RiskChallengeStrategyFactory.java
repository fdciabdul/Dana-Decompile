package id.dana.riskChallenges.ui.util.strategy;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.util.RiskChallengeFactory;
import id.dana.riskChallenges.ui.util.mapper.RiskChallengeMapper;
import id.dana.riskChallenges.ui.util.model.HistoryFallbackModel;
import id.dana.riskChallenges.ui.util.model.TrackerModel;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BU\u0012\u0006\u0010\u0004\u001a\u00020\n\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010 \u0012\u0006\u0010'\u001a\u00020\"\u0012\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0012¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0016\u0010\u001c\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010!R\u0014\u0010\u0013\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010#"}, d2 = {"Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategyFactory;", "Lid/dana/riskChallenges/ui/util/RiskChallengeFactory;", "", "Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategy;", "p0", "PlaceComponentResult", "(Ljava/lang/String;)Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategy;", "Lid/dana/riskChallenges/ui/util/model/TrackerModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/riskChallenges/ui/util/model/TrackerModel;", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", "MyBillsEntityDataFactory", "", "", "getErrorConfigVersion", "Ljava/util/Map;", "getAuthRequestContext", "Lkotlin/Function0;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/jvm/functions/Function0;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentResultListener;", "", "Lkotlin/jvm/functions/Function1;", "Lid/dana/riskChallenges/ui/util/model/HistoryFallbackModel;", "Lid/dana/riskChallenges/ui/util/model/HistoryFallbackModel;", "scheduleImpl", "Ljava/lang/String;", "moveToNextValue", "lookAheadTest", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;Ljava/util/Map;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RiskChallengeStrategyFactory implements RiskChallengeFactory<String, RiskChallengeStrategy> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public HistoryFallbackModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String lookAheadTest;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Function1<? super FragmentResultListener, Unit> PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Function0<String> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FragmentActivity MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Map<String, Object> getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final UseCaseStrategy NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final UiComponent scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final String moveToNextValue;

    public RiskChallengeStrategyFactory(FragmentActivity fragmentActivity, String str, String str2, UiComponent uiComponent, UseCaseStrategy useCaseStrategy, Map<String, ? extends Object> map, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(useCaseStrategy, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.MyBillsEntityDataFactory = fragmentActivity;
        this.lookAheadTest = str;
        this.moveToNextValue = str2;
        this.scheduleImpl = uiComponent;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = useCaseStrategy;
        this.getAuthRequestContext = map;
        this.BuiltInFictitiousFunctionClassFactory = function0;
    }

    private final TrackerModel KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Object obj = this.getAuthRequestContext.get("KEY_SOURCE");
        String str = obj instanceof String ? (String) obj : null;
        RiskChallengeMapper riskChallengeMapper = RiskChallengeMapper.INSTANCE;
        return new TrackerModel(str, RiskChallengeMapper.BuiltInFictitiousFunctionClassFactory(p0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01dc, code lost:
    
        if (r22.equals(id.dana.riskChallenges.constant.RiskChallengeKey.OTP_SMS) != false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01de, code lost:
    
        r1 = r21.MyBillsEntityDataFactory;
        r3 = r21.moveToNextValue;
        r9 = r21.scheduleImpl;
        r10 = r21.lookAheadTest;
        r4 = r21.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01ea, code lost:
    
        if (r4 != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ec, code lost:
    
        r4 = r21.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01f0, code lost:
    
        r11 = r4;
        r4 = r21.getAuthRequestContext.get("KEY_SERVICE_CODE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f9, code lost:
    
        if ((r4 instanceof java.lang.String) == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01fb, code lost:
    
        r4 = (java.lang.String) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01fe, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0200, code lost:
    
        if (r4 != null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0202, code lost:
    
        r12 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0204, code lost:
    
        r12 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0205, code lost:
    
        r4 = r21.getAuthRequestContext.get("KEY_MERCHANT_ID");
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x020d, code lost:
    
        if ((r4 instanceof java.lang.String) == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x020f, code lost:
    
        r4 = (java.lang.String) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0212, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0214, code lost:
    
        if (r4 != null) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0216, code lost:
    
        r13 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0218, code lost:
    
        r13 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0219, code lost:
    
        r4 = r21.getAuthRequestContext.get("KEY_SERVICE_CODE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0221, code lost:
    
        if ((r4 instanceof java.lang.Boolean) == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0223, code lost:
    
        r4 = (java.lang.Boolean) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0226, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0228, code lost:
    
        if (r4 == null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x022a, code lost:
    
        r14 = r4.booleanValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0230, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0231, code lost:
    
        r4 = r21.getAuthRequestContext.get("KEY_SCENARIO");
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0239, code lost:
    
        if ((r4 instanceof java.lang.String) == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x023b, code lost:
    
        r4 = (java.lang.String) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x023e, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0240, code lost:
    
        if (r4 != null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0242, code lost:
    
        r15 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0244, code lost:
    
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0245, code lost:
    
        r19 = new id.dana.riskChallenges.ui.otp.otpsms.OtpSmsChallengeStrategy(r1, r3, r10, id.dana.domain.otp.model.OtpChannel.SMS, r9, r11, r12, r13, r14, r15, r21.getErrorConfigVersion, r21.KClassImpl$Data$declaredNonStaticMembers$2, r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e2, code lost:
    
        if (r22.equals(id.dana.riskChallenges.constant.RiskChallengeKey.RISK_REJECT) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x010b, code lost:
    
        if (r22.equals(id.dana.riskChallenges.constant.RiskChallengeKey.MIC_OTP_EMAIL) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0114, code lost:
    
        if (r22.equals(id.dana.riskChallenges.constant.RiskChallengeKey.MIC_SQ) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x011d, code lost:
    
        if (r22.equals("SQ") != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0126, code lost:
    
        if (r22.equals(id.dana.riskChallenges.constant.RiskChallengeKey.OTP_EMAIL) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0128, code lost:
    
        r1 = new id.dana.riskChallenges.ui.callcsordiana.CallCsOrDianaChallengeStrategy(r21.MyBillsEntityDataFactory, r21.moveToNextValue, r21.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext, r21.scheduleImpl, r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01d3, code lost:
    
        if (r22.equals(id.dana.riskChallenges.constant.RiskChallengeKey.MIC_OTP_SMS) != false) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0269  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy PlaceComponentResult(java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategyFactory.PlaceComponentResult(java.lang.String):id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy");
    }
}
