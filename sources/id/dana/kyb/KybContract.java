package id.dana.kyb;

import android.content.Context;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.kyb.domain.model.KybCompressQrConfig;
import id.dana.kyb.domain.model.KybUrlsConfig;
import id.dana.kyb.helper.service.listener.KybServiceListener;
import id.dana.kyb.model.KybCompleteInfoModel;
import id.dana.kyb.model.KybMerchantInfoModel;
import id.dana.kyb.model.KybServiceMessageModel;
import id.dana.kyb.model.KybServiceModel;
import id.dana.kyb.model.TransactionListQueryModel;
import id.dana.model.PromotionModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/kyb/KybContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface KybContract {

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J'\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0005\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0015H&¢\u0006\u0004\b\u0005\u0010\u0016J'\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0015H&¢\u0006\u0004\b\u0005\u0010\u0017J'\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0015H&¢\u0006\u0004\b\b\u0010\u0017J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0015H&¢\u0006\u0004\b\u000b\u0010\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/kyb/KybContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "", "getAuthRequestContext", "()V", "BuiltInFictitiousFunctionClassFactory", "", "p0", "PlaceComponentResult", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "getErrorConfigVersion", "moveToNextValue", "Landroid/content/Context;", "Lid/dana/kyb/model/KybServiceModel;", "p1", "Lid/dana/kyb/helper/service/listener/KybServiceListener;", "p2", "(Landroid/content/Context;Lid/dana/kyb/model/KybServiceModel;Lid/dana/kyb/helper/service/listener/KybServiceListener;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "(Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(Context p0, KybServiceModel p1, KybServiceListener p2);

        void BuiltInFictitiousFunctionClassFactory(String p0);

        void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String p0, String p1, String p2);

        void MyBillsEntityDataFactory(boolean p0);

        void NetworkUserEntityData$$ExternalSyntheticLambda0();

        void PlaceComponentResult();

        void PlaceComponentResult(String p0, String p1, String p2);

        void PlaceComponentResult(boolean p0);

        void getAuthRequestContext();

        void getErrorConfigVersion();

        void moveToNextValue();
    }

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u0007\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\u0006H&¢\u0006\u0004\b\u000e\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0007\u0010\u0011J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0012H&¢\u0006\u0004\b\r\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H&¢\u0006\u0004\b\u0014\u0010\nJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0015H&¢\u0006\u0004\b\u0007\u0010\u0016J\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0004\b\u000b\u0010\u0018J\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0004\b\f\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H&¢\u0006\u0004\b\u001b\u0010\nJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0015H&¢\u0006\u0004\b\f\u0010\u001dJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0017H&¢\u0006\u0004\b\u0007\u0010\u0018J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u001eH&¢\u0006\u0004\b\r\u0010\u001fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0017H&¢\u0006\u0004\b\u000e\u0010\u0018J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020 H&¢\u0006\u0004\b\u0007\u0010!J\u001f\u0010\u000e\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000fH&¢\u0006\u0004\b\u000e\u0010\u0011J\u001d\u0010\f\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\f\u0010\u0011J\u000f\u0010\"\u001a\u00020\u0006H&¢\u0006\u0004\b\"\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020#H&¢\u0006\u0004\b\u000b\u0010$J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0017H&¢\u0006\u0004\b\f\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/kyb/KybContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "p0", "Lid/dana/kyb/model/KybCompleteInfoModel;", "p1", "", "MyBillsEntityDataFactory", "(ILid/dana/kyb/model/KybCompleteInfoModel;)V", "", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "", "Lid/dana/kyb/model/KybServiceModel;", "(Ljava/util/List;)V", "Lid/dana/model/PromotionModel;", "(Lid/dana/model/PromotionModel;)V", "scheduleImpl", "Lid/dana/kyb/model/TransactionListQueryModel;", "(Lid/dana/kyb/model/TransactionListQueryModel;)V", "", "(Ljava/lang/String;)V", "Lid/dana/kyb/model/KybServiceMessageModel;", "(Lid/dana/kyb/model/KybServiceMessageModel;)V", "moveToNextValue", "Lid/dana/kyb/model/KybMerchantInfoModel;", "(Lid/dana/kyb/model/KybMerchantInfoModel;Lid/dana/kyb/model/TransactionListQueryModel;)V", "", "(Z)V", "Lid/dana/kyb/domain/model/KybCompressQrConfig;", "(Lid/dana/kyb/domain/model/KybCompressQrConfig;)V", "lookAheadTest", "Lid/dana/kyb/domain/model/KybUrlsConfig;", "(Lid/dana/kyb/domain/model/KybUrlsConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(PromotionModel p0);

        void BuiltInFictitiousFunctionClassFactory(boolean p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(KybUrlsConfig p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(int p0, KybCompleteInfoModel p1);

        void MyBillsEntityDataFactory(KybCompressQrConfig p0);

        void MyBillsEntityDataFactory(TransactionListQueryModel p0);

        void MyBillsEntityDataFactory(String p0);

        void MyBillsEntityDataFactory(List<KybServiceModel> p0);

        void PlaceComponentResult();

        void PlaceComponentResult(KybMerchantInfoModel p0, TransactionListQueryModel p1);

        void PlaceComponentResult(KybServiceMessageModel p0);

        void PlaceComponentResult(String p0);

        void PlaceComponentResult(List<KybServiceModel> p0);

        void getAuthRequestContext();

        void getAuthRequestContext(String p0);

        void getAuthRequestContext(List<String> p0);

        void lookAheadTest();

        void moveToNextValue();

        void scheduleImpl();
    }
}
