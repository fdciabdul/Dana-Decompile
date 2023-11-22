package id.dana.sendmoney_v2.landing.contract;

import id.dana.base.AbstractContractKt;
import id.dana.sendmoney.model.RecipientModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ManageAccountContract {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0003\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Lid/dana/sendmoney/model/RecipientModel;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/model/RecipientModel;)V", "", "p1", "", "p2", "(Lid/dana/sendmoney/model/RecipientModel;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(RecipientModel p0, String p1, boolean p2);

        void KClassImpl$Data$declaredNonStaticMembers$2(RecipientModel p0);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J,\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onGetMaxFavoriteAccount", "", "maxFavoriteAccount", "", "onRemoveRecentTransactionSuccess", "recipientModel", "Lid/dana/sendmoney/model/RecipientModel;", "onTrackDisplayedError", "throwable", "", "operationType", "", "displayedMessage", "source", "onUndoRemove", "onUpdateRecentBankNameSuccess", "showSnackbarError", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(RecipientModel recipientModel);

        void BuiltInFictitiousFunctionClassFactory(Throwable th, String str, String str2, String str3);

        void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th);

        void getAuthRequestContext(int i);

        void getErrorConfigVersion();

        void lookAheadTest();
    }
}
