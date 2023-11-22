package id.dana.riskChallenges.ui.util.strategy;

import id.dana.riskChallenges.ui.util.model.HistoryFallbackModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0003\u0010\tJ\u0019\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\u0005\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0005\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/util/strategy/FallbackStrategyImpl;", "Lid/dana/riskChallenges/ui/util/strategy/FallbackStrategy;", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "PlaceComponentResult", "", "p0", "", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/ui/util/model/HistoryFallbackModel;", "(Lid/dana/riskChallenges/ui/util/model/HistoryFallbackModel;)V", "Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/riskChallenges/ui/util/model/HistoryFallbackModel;", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FallbackStrategyImpl implements FallbackStrategy {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public HistoryFallbackModel MyBillsEntityDataFactory;

    @Inject
    public FallbackStrategyImpl() {
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.FallbackStrategy
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult = p0;
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.FallbackStrategy
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.FallbackStrategy
    public final void PlaceComponentResult(HistoryFallbackModel p0) {
        this.MyBillsEntityDataFactory = p0;
    }

    public final boolean PlaceComponentResult() {
        HistoryFallbackModel historyFallbackModel = this.MyBillsEntityDataFactory;
        String str = null;
        if ((historyFallbackModel != null ? historyFallbackModel.getAuthRequestContext : null) != null) {
            HistoryFallbackModel historyFallbackModel2 = this.MyBillsEntityDataFactory;
            String str2 = historyFallbackModel2 != null ? historyFallbackModel2.getAuthRequestContext : null;
            String str3 = this.PlaceComponentResult;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                str = str3;
            }
            if (Intrinsics.areEqual(str2, str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return !(str == null || str.length() == 0);
    }
}
