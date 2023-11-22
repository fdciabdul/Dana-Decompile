package id.dana.contract.promodiscovery;

import android.location.Location;
import id.dana.base.AbstractContractKt;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.promodiscovery.model.ProductInfoDiscoveryModel;
import id.dana.promocenter.model.PromoModel;
import id.dana.promodiscovery.model.FourKingItem;
import id.dana.promodiscovery.model.FourKingModel;
import id.dana.promodiscovery.model.PromoDiscoverySectionConfigModel;
import id.dana.referral.model.MyReferralConsult;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/promodiscovery/PromoDiscoveryContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PromoDiscoveryContract {

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u000b\u001a\u00020\u0013H&¢\u0006\u0004\b\u000b\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0016H&¢\u0006\u0004\b\u000f\u0010\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/promodiscovery/PromoDiscoveryContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/Integer;)V", "", "p1", "Landroid/location/Location;", "p2", "MyBillsEntityDataFactory", "(Ljava/lang/Integer;Ljava/lang/String;Landroid/location/Location;)V", "()V", "Lid/dana/domain/geocode/model/LocationSubdisivision;", "getAuthRequestContext", "()Lid/dana/domain/geocode/model/LocationSubdisivision;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/referral/model/MyReferralConsult;", "()Lid/dana/referral/model/MyReferralConsult;", "getErrorConfigVersion", "Lid/dana/promodiscovery/model/FourKingItem;", "(Lid/dana/promodiscovery/model/FourKingItem;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        MyReferralConsult MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(Integer p0);

        void MyBillsEntityDataFactory(Integer p0, String p1, Location p2);

        void PlaceComponentResult();

        void PlaceComponentResult(Integer p0);

        LocationSubdisivision getAuthRequestContext();

        void getAuthRequestContext(FourKingItem p0);

        void getAuthRequestContext(Integer p0);

        void getErrorConfigVersion();
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u0007\u0010\fJ\u001d\u0010\u0005\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u0005\u0010\u000fJ\u001d\u0010\u0007\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00100\rH&¢\u0006\u0004\b\u0007\u0010\u000fJ\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\b\u0010\u000fJ\u001d\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00110\rH&¢\u0006\u0004\b\u0003\u0010\u000fJ\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0012H&¢\u0006\u0004\b\b\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0014H&¢\u0006\u0004\b\u0005\u0010\u0015J\u001d\u0010\u0006\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u0006\u0010\u000fJ\u001d\u0010\u0016\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00110\rH&¢\u0006\u0004\b\u0016\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/promodiscovery/PromoDiscoveryContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "PlaceComponentResult", "()V", "getAuthRequestContext", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "getErrorConfigVersion", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "p0", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;)V", "", "Lid/dana/promocenter/model/PromoModel;", "(Ljava/util/List;)V", "Lid/dana/domain/promodiscovery/model/ProductInfoDiscoveryModel;", "Lid/dana/promodiscovery/model/FourKingModel;", "Lid/dana/promodiscovery/model/PromoDiscoverySectionConfigModel;", "(Lid/dana/promodiscovery/model/PromoDiscoverySectionConfigModel;)V", "", "(Z)V", "scheduleImpl"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(ThirdPartyServiceResponse p0);

        void BuiltInFictitiousFunctionClassFactory(List<ProductInfoDiscoveryModel> p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoverySectionConfigModel p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(List<? extends PromoModel> p0);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(List<? extends PromoModel> p0);

        void PlaceComponentResult();

        void PlaceComponentResult(List<FourKingModel> p0);

        void getAuthRequestContext();

        void getAuthRequestContext(List<? extends PromoModel> p0);

        void getAuthRequestContext(boolean p0);

        void getErrorConfigVersion();

        void scheduleImpl(List<FourKingModel> p0);
    }
}
