package id.dana.domain.promodiscovery.interactor;

import com.alibaba.ariver.kernel.RVStartParams;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.promodiscovery.model.ProductInfoDiscoveryModel;
import id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository;
import id.dana.sendmoney.summary.SummaryActivity;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/promodiscovery/interactor/GetDanaDealsThumbnail;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/promodiscovery/model/ProductInfoDiscoveryModel;", "Lid/dana/domain/promodiscovery/interactor/GetDanaDealsThumbnail$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/promodiscovery/interactor/GetDanaDealsThumbnail$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/promodiscovery/repository/PromoDiscoveryRepository;", "promoDiscoveryRepository", "Lid/dana/domain/promodiscovery/repository/PromoDiscoveryRepository;", "<init>", "(Lid/dana/domain/promodiscovery/repository/PromoDiscoveryRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetDanaDealsThumbnail extends BaseUseCase<List<? extends ProductInfoDiscoveryModel>, Params> {
    private PromoDiscoveryRepository promoDiscoveryRepository;

    @Inject
    public GetDanaDealsThumbnail(PromoDiscoveryRepository promoDiscoveryRepository) {
        Intrinsics.checkNotNullParameter(promoDiscoveryRepository, "");
        this.promoDiscoveryRepository = promoDiscoveryRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<ProductInfoDiscoveryModel>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.promoDiscoveryRepository.getPromoDanaDeals("DANA_VOUCHER", "PRIORITY", params.getLatitude(), params.getLongitude(), params.getStartPage(), params.getItemSize(), params.getSortBy());
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0019\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001e\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\fR\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b!\u0010\u0004"}, d2 = {"Lid/dana/domain/promodiscovery/interactor/GetDanaDealsThumbnail$Params;", "", "", "component1", "()I", "", "component2", "()D", "component3", "component4", "", "component5", "()Ljava/lang/String;", "itemSize", "latitude", "longitude", RVStartParams.START_SCENE_START_PAGE, "sortBy", "copy", "(IDDILjava/lang/String;)Lid/dana/domain/promodiscovery/interactor/GetDanaDealsThumbnail$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getItemSize", SummaryActivity.DAYS, "getLatitude", "getLongitude", "Ljava/lang/String;", "getSortBy", "getStartPage", "<init>", "(IDDILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final int itemSize;
        private final double latitude;
        private final double longitude;
        private final String sortBy;
        private final int startPage;

        public static /* synthetic */ Params copy$default(Params params, int i, double d, double d2, int i2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = params.itemSize;
            }
            if ((i3 & 2) != 0) {
                d = params.latitude;
            }
            double d3 = d;
            if ((i3 & 4) != 0) {
                d2 = params.longitude;
            }
            double d4 = d2;
            if ((i3 & 8) != 0) {
                i2 = params.startPage;
            }
            int i4 = i2;
            if ((i3 & 16) != 0) {
                str = params.sortBy;
            }
            return params.copy(i, d3, d4, i4, str);
        }

        /* renamed from: component1  reason: from getter */
        public final int getItemSize() {
            return this.itemSize;
        }

        /* renamed from: component2  reason: from getter */
        public final double getLatitude() {
            return this.latitude;
        }

        /* renamed from: component3  reason: from getter */
        public final double getLongitude() {
            return this.longitude;
        }

        /* renamed from: component4  reason: from getter */
        public final int getStartPage() {
            return this.startPage;
        }

        /* renamed from: component5  reason: from getter */
        public final String getSortBy() {
            return this.sortBy;
        }

        public final Params copy(int itemSize, double latitude, double longitude, int startPage, String sortBy) {
            Intrinsics.checkNotNullParameter(sortBy, "");
            return new Params(itemSize, latitude, longitude, startPage, sortBy);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return this.itemSize == params.itemSize && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(params.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(params.longitude)) && this.startPage == params.startPage && Intrinsics.areEqual(this.sortBy, params.sortBy);
            }
            return false;
        }

        public final int hashCode() {
            return (((((((this.itemSize * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.latitude)) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.longitude)) * 31) + this.startPage) * 31) + this.sortBy.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(itemSize=");
            sb.append(this.itemSize);
            sb.append(", latitude=");
            sb.append(this.latitude);
            sb.append(", longitude=");
            sb.append(this.longitude);
            sb.append(", startPage=");
            sb.append(this.startPage);
            sb.append(", sortBy=");
            sb.append(this.sortBy);
            sb.append(')');
            return sb.toString();
        }

        public Params(int i, double d, double d2, int i2, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.itemSize = i;
            this.latitude = d;
            this.longitude = d2;
            this.startPage = i2;
            this.sortBy = str;
        }

        @JvmName(name = "getItemSize")
        public final int getItemSize() {
            return this.itemSize;
        }

        @JvmName(name = "getLatitude")
        public final double getLatitude() {
            return this.latitude;
        }

        @JvmName(name = "getLongitude")
        public final double getLongitude() {
            return this.longitude;
        }

        @JvmName(name = "getStartPage")
        public final int getStartPage() {
            return this.startPage;
        }

        @JvmName(name = "getSortBy")
        public final String getSortBy() {
            return this.sortBy;
        }
    }
}
