package id.dana.domain.promocenter.repository;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipay.mobile.map.model.MapConstant;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.domain.promocenter.model.CategoryPromo;
import id.dana.domain.promocenter.model.PromoAds;
import id.dana.domain.promocenter.model.PromoCategoryInfo;
import id.dana.domain.promocenter.model.PromoCategoryRequest;
import id.dana.domain.promocenter.model.PromoResult;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ5\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u001b\u0010\u001cø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/promocenter/repository/PromoCenterRepository;", "", "", SecurityConstants.KEY_PAGE_SIZE, ZdocRecordService.PAGE_NUMBER, "", "loadMore", "Lio/reactivex/Observable;", "Lid/dana/domain/promocenter/model/PromoCategoryInfo;", "getCategories", "(IIZ)Lio/reactivex/Observable;", GriverMonitorConstants.KEY_SIZE, "", "lat", MapConstant.EXTRA_LON, "", "source", "Lid/dana/domain/promocenter/model/PromoAds;", "getPromoAds", "(IDDLjava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/promocenter/model/PromoCategoryRequest;", "promoCategoryRequest", "Lid/dana/domain/promocenter/model/CategoryPromo;", "getPromoCategorizedList", "(Lid/dana/domain/promocenter/model/PromoCategoryRequest;)Lio/reactivex/Observable;", "sortBy", "Lid/dana/domain/promocenter/model/PromoResult;", "getPromoList", "(IILjava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PromoCenterRepository {
    Observable<PromoCategoryInfo> getCategories(int pageSize, int pageNumber, boolean loadMore);

    Observable<PromoAds> getPromoAds(int size, double lat, double lon, String source);

    Observable<CategoryPromo> getPromoCategorizedList(PromoCategoryRequest promoCategoryRequest);

    Observable<PromoResult> getPromoList(int pageSize, int pageNumber, String sortBy);
}
