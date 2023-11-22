package id.dana.mybills.di;

import id.dana.base.AbstractContractKt;
import id.dana.domain.mybills.model.MonthlyAmountAndHighlightRequest;
import id.dana.domain.mybills.model.MyBillsMonthlyAmount;
import id.dana.model.CurrencyAmountModel;
import id.dana.mybills.model.BillSubscriptionHighlightModel;
import id.dana.mybills.model.BizProductModel;
import id.dana.mybills.model.BizProductOrderModel;
import id.dana.mybills.model.HighlighTransactionPayModel;
import id.dana.mybills.model.HighlightTransactionPayRequestModel;
import id.dana.mybills.model.MonthlyHighlightBillModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/di/MyBillsContract;", "", "<init>", "()V", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBillsContract {

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\u0005\u0010\fJ'\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\u0015J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/di/MyBillsContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "Lid/dana/mybills/model/BizProductModel;", "p0", "", "PlaceComponentResult", "(Lid/dana/mybills/model/BizProductModel;)V", "Lid/dana/mybills/model/HighlightTransactionPayRequestModel;", "MyBillsEntityDataFactory", "(Lid/dana/mybills/model/HighlightTransactionPayRequestModel;)V", "", "Lid/dana/mybills/model/BillSubscriptionHighlightModel;", "(Ljava/util/List;)V", "", "p1", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/mybills/model/MonthlyAmountAndHighlightRequest;", "getAuthRequestContext", "(Lid/dana/domain/mybills/model/MonthlyAmountAndHighlightRequest;)V", "()V", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(HighlightTransactionPayRequestModel p0);

        void PlaceComponentResult(BizProductModel p0);

        void PlaceComponentResult(List<BillSubscriptionHighlightModel> p0);

        void getAuthRequestContext();

        void getAuthRequestContext(MonthlyAmountAndHighlightRequest p0);
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\fH&¢\u0006\u0004\b\u0003\u0010\rJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000eH&¢\u0006\u0004\b\u0003\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nH&¢\u0006\u0004\b\u0005\u0010\u0015J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0016H&¢\u0006\u0004\b\u0012\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u001aH&¢\u0006\u0004\b\u0005\u0010\u001bJ\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0010H&¢\u0006\u0004\b\b\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/di/MyBillsContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/model/BizProductOrderModel;", "p0", "MyBillsEntityDataFactory", "(Lid/dana/mybills/model/BizProductOrderModel;)V", "Lid/dana/mybills/model/MonthlyHighlightBillModel;", "(Lid/dana/mybills/model/MonthlyHighlightBillModel;)V", "Lid/dana/mybills/model/HighlighTransactionPayModel;", "(Lid/dana/mybills/model/HighlighTransactionPayModel;)V", "Lid/dana/domain/mybills/model/MyBillsMonthlyAmount;", "(Lid/dana/domain/mybills/model/MyBillsMonthlyAmount;)V", "", "Lid/dana/mybills/model/BizProductModel;", "PlaceComponentResult", "(Ljava/util/List;)V", "p1", "(Lid/dana/domain/mybills/model/MyBillsMonthlyAmount;Lid/dana/mybills/model/MonthlyHighlightBillModel;)V", "", "(Ljava/lang/String;)V", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/model/CurrencyAmountModel;", "(Lid/dana/model/CurrencyAmountModel;)V", "Lid/dana/mybills/model/BillSubscriptionHighlightModel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(MyBillsMonthlyAmount p0);

        void BuiltInFictitiousFunctionClassFactory(HighlighTransactionPayModel p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(MyBillsMonthlyAmount p0, MonthlyHighlightBillModel p1);

        void KClassImpl$Data$declaredNonStaticMembers$2(CurrencyAmountModel p0);

        void MyBillsEntityDataFactory(BizProductOrderModel p0);

        void MyBillsEntityDataFactory(MonthlyHighlightBillModel p0);

        void MyBillsEntityDataFactory(List<BillSubscriptionHighlightModel> p0);

        void PlaceComponentResult(String p0);

        void PlaceComponentResult(List<BizProductModel> p0);

        void getAuthRequestContext(String p0, String p1);
    }
}
