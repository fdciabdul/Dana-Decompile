package id.dana.contract.onlinemerchant;

import id.dana.base.AbstractContractKt;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.globalsearch.model.SearchResult;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/onlinemerchant/OnlineMerchantContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface OnlineMerchantContract {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0005\u001a\u00020\tH&¢\u0006\u0004\b\u0005\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\bJ\u001d\u0010\u0007\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0007\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/onlinemerchant/OnlineMerchantContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "()V", "", "()Z", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "PlaceComponentResult", "getAuthRequestContext", "", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(boolean p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        boolean KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(List<PaySearchInfoModel> p0);

        void PlaceComponentResult();

        void getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0003\u0010\u000bJ\u001d\u0010\b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¢\u0006\u0004\b\b\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¢\u0006\u0004\b\u0007\u0010\u000eJ\u001d\u0010\u0005\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¢\u0006\u0004\b\u0005\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/onlinemerchant/OnlineMerchantContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "PlaceComponentResult", "getAuthRequestContext", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/globalsearch/model/SearchResult;", "p0", "(Lid/dana/globalsearch/model/SearchResult;)V", "", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(SearchResult p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(List<PaySearchInfoModel> p0);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(List<PaySearchInfoModel> p0);

        void PlaceComponentResult();

        void PlaceComponentResult(List<PaySearchInfoModel> p0);

        void getAuthRequestContext();
    }
}
