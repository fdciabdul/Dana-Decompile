package id.dana.statement;

import id.dana.base.AbstractContractKt;
import id.dana.statement.UserStatementContract;
import id.dana.statement.model.StatementViewModel;
import id.dana.statement.model.UserStatementDetailModel;
import id.dana.statement.model.UserStatementModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0005\u0010\u000fJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\t\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0005\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\t\u0010\u0015"}, d2 = {"Lid/dana/statement/UserStatementListener;", "Lid/dana/statement/UserStatementContract$View;", "", "p0", "", "MyBillsEntityDataFactory", "(Z)V", "", "Lid/dana/statement/model/StatementViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)V", "PlaceComponentResult", "()V", "Lid/dana/statement/model/UserStatementDetailModel;", "getAuthRequestContext", "(Lid/dana/statement/model/UserStatementDetailModel;)V", "Lid/dana/statement/model/UserStatementModel;", "(Lid/dana/statement/model/UserStatementModel;)V", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class UserStatementListener implements UserStatementContract.View {
    @Override // id.dana.statement.UserStatementContract.View
    public void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
    }

    @Override // id.dana.statement.UserStatementContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(UserStatementModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.statement.UserStatementContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
    }

    @Override // id.dana.statement.UserStatementContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(List<StatementViewModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.statement.UserStatementContract.View
    public void MyBillsEntityDataFactory(UserStatementDetailModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.statement.UserStatementContract.View
    public void MyBillsEntityDataFactory(UserStatementModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.statement.UserStatementContract.View
    public /* synthetic */ void MyBillsEntityDataFactory(List list) {
        Intrinsics.checkNotNullParameter(list, "");
    }

    @Override // id.dana.statement.UserStatementContract.View
    public void MyBillsEntityDataFactory(boolean p0) {
    }

    @Override // id.dana.statement.UserStatementContract.View
    public void PlaceComponentResult() {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.statement.UserStatementContract.View
    public void getAuthRequestContext(UserStatementDetailModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }
}
