package id.dana.domain.promodiscovery.repository;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.domain.promodiscovery.model.FourKingsPromoModel;
import id.dana.domain.promodiscovery.model.ProductInfoDiscoveryModel;
import id.dana.domain.promodiscovery.model.PromoDiscoverySectionConfig;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\bJS\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005H&¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0003H&¢\u0006\u0004\b\u0019\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/promodiscovery/repository/PromoDiscoveryRepository;", "", "", "", "fourKingsTypes", "Lio/reactivex/Observable;", "Lid/dana/domain/promodiscovery/model/FourKingsPromoModel;", "getFourKingsPromo", "(Ljava/util/List;)Lio/reactivex/Observable;", "type", "filterBy", "", "latitude", "longitude", "", "start", SecurityConstants.KEY_PAGE_SIZE, "sortBy", "Lid/dana/domain/promodiscovery/model/ProductInfoDiscoveryModel;", "getPromoDanaDeals", "(Ljava/lang/String;Ljava/lang/String;DDIILjava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/promodiscovery/model/PromoDiscoverySectionConfig;", "getPromoDiscovery", "()Lio/reactivex/Observable;", "pillarType", "switchFourKingsPromoRedDot", "(Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PromoDiscoveryRepository {
    Observable<List<FourKingsPromoModel>> getFourKingsPromo(List<String> fourKingsTypes);

    Observable<List<ProductInfoDiscoveryModel>> getPromoDanaDeals(String type, String filterBy, double latitude, double longitude, int start, int pageSize, String sortBy);

    Observable<PromoDiscoverySectionConfig> getPromoDiscovery();

    Observable<List<FourKingsPromoModel>> switchFourKingsPromoRedDot(String pillarType);
}
