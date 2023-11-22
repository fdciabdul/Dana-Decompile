package id.dana.sendmoney.ui.core.presenter;

import id.dana.core.ui.model.UiTextModel;
import id.dana.sendmoney.ui.core.model.SendMoneyApiMigrationConfigModel;
import id.dana.sendmoney.ui.core.model.TransferInitResultModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SendMoneyCoreContract {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ/\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;", "", "", "p0", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "p2", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter {
        void BuiltInFictitiousFunctionClassFactory(String p0, String p1);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3);

        void PlaceComponentResult();
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J,\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H&J\b\u0010\u0016\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$View;", "", "hideShimmerLoading", "", "onErrorGetSendMoneyApiMigrationConfig", "onErrorGetTransferBalanceInit", "throwable", "", "onErrorSendToSelfAccount", "errorMessage", "Lid/dana/core/ui/model/UiTextModel;", "onSuccessGetSendMoneyApiMigrationConfig", "sendMoneyApiMigrationConfigModel", "Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;", "onSuccessGetTransferBalanceInit", "transferInitResultModel", "Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "onTrackDisplayedError", "operationType", "", "displayedMessage", "source", "showShimmerLoading", "feature-sendmoney_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(SendMoneyApiMigrationConfigModel sendMoneyApiMigrationConfigModel);

        void KClassImpl$Data$declaredNonStaticMembers$2(UiTextModel uiTextModel);

        void MyBillsEntityDataFactory(Throwable th);

        void MyBillsEntityDataFactory(Throwable th, String str, String str2, String str3);

        void PlaceComponentResult();

        void PlaceComponentResult(TransferInitResultModel transferInitResultModel);

        void getAuthRequestContext();
    }
}
