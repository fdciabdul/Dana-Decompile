package id.dana.requestmoney.bank;

import id.dana.base.AbstractContractKt;
import id.dana.requestmoney.model.RequestMoneyInitModel;
import id.dana.requestmoney.model.UserBankModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/requestmoney/bank/UserBankContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface UserBankContract {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/requestmoney/bank/UserBankContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "Lid/dana/requestmoney/model/UserBankModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/requestmoney/model/UserBankModel;)V", "getAuthRequestContext", "()V", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(UserBankModel p0);

        void PlaceComponentResult();

        void getAuthRequestContext(UserBankModel p0);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\f\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/requestmoney/bank/UserBankContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "Lid/dana/requestmoney/model/UserBankModel;", "p1", "BuiltInFictitiousFunctionClassFactory", "(ZLid/dana/requestmoney/model/UserBankModel;)V", "", "getAuthRequestContext", "(Ljava/util/List;)V", "Lid/dana/requestmoney/model/RequestMoneyInitModel;", "(Lid/dana/requestmoney/model/RequestMoneyInitModel;)V", "PlaceComponentResult", "()V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class View implements AbstractContractKt.AbstractView {
        public void BuiltInFictitiousFunctionClassFactory(boolean p0, UserBankModel p1) {
            Intrinsics.checkNotNullParameter(p1, "");
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        }

        public void PlaceComponentResult() {
        }

        @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
        public /* synthetic */ void dismissProgress() {
            AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
        }

        public void getAuthRequestContext(RequestMoneyInitModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
        }

        public void getAuthRequestContext(List<UserBankModel> p0) {
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
}
