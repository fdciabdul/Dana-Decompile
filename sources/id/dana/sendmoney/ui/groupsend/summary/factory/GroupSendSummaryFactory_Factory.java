package id.dana.sendmoney.ui.groupsend.summary.factory;

import dagger.internal.Factory;
import id.dana.sendmoney.ui.groupsend.summary.state.X2BGroupSendSummary;
import id.dana.sendmoney.ui.groupsend.summary.state.X2PGroupSendSummary;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class GroupSendSummaryFactory_Factory implements Factory<GroupSendSummaryFactory> {
    private final Provider<X2BGroupSendSummary> BuiltInFictitiousFunctionClassFactory;
    private final Provider<X2PGroupSendSummary> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GroupSendSummaryFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
