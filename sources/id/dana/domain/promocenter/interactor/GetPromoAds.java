package id.dana.domain.promocenter.interactor;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipay.mobile.map.model.MapConstant;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promocenter.model.PromoAds;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B%\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/promocenter/interactor/GetPromoAds;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/promocenter/model/PromoAds;", "Lid/dana/domain/promocenter/interactor/GetPromoAds$PromoAdsParams;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/promocenter/interactor/GetPromoAds$PromoAdsParams;)Lio/reactivex/Observable;", "Lid/dana/domain/promocenter/repository/PromoCenterRepository;", "promoCenterRepository", "Lid/dana/domain/promocenter/repository/PromoCenterRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/domain/promocenter/repository/PromoCenterRepository;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;)V", "PromoAdsParams"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetPromoAds extends UseCase<PromoAds, PromoAdsParams> {
    private final PromoCenterRepository promoCenterRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetPromoAds(PromoCenterRepository promoCenterRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(promoCenterRepository, "");
        this.promoCenterRepository = promoCenterRepository;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000bR\u0017\u0010\r\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u001a\u0010\u0007R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u000b"}, d2 = {"Lid/dana/domain/promocenter/interactor/GetPromoAds$PromoAdsParams;", "", "", "component1", "()I", "", "component2", "()D", "component3", "", "component4", "()Ljava/lang/String;", GriverMonitorConstants.KEY_SIZE, "lat", MapConstant.EXTRA_LON, "source", "copy", "(IDDLjava/lang/String;)Lid/dana/domain/promocenter/interactor/GetPromoAds$PromoAdsParams;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", SummaryActivity.DAYS, "getLat", "getLon", "I", "getSize", "Ljava/lang/String;", "getSource", "<init>", "(IDDLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class PromoAdsParams {
        private final double lat;
        private final double lon;
        private final int size;
        private final String source;

        public static /* synthetic */ PromoAdsParams copy$default(PromoAdsParams promoAdsParams, int i, double d, double d2, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = promoAdsParams.size;
            }
            if ((i2 & 2) != 0) {
                d = promoAdsParams.lat;
            }
            double d3 = d;
            if ((i2 & 4) != 0) {
                d2 = promoAdsParams.lon;
            }
            double d4 = d2;
            if ((i2 & 8) != 0) {
                str = promoAdsParams.source;
            }
            return promoAdsParams.copy(i, d3, d4, str);
        }

        /* renamed from: component1  reason: from getter */
        public final int getSize() {
            return this.size;
        }

        /* renamed from: component2  reason: from getter */
        public final double getLat() {
            return this.lat;
        }

        /* renamed from: component3  reason: from getter */
        public final double getLon() {
            return this.lon;
        }

        /* renamed from: component4  reason: from getter */
        public final String getSource() {
            return this.source;
        }

        public final PromoAdsParams copy(int size, double lat, double lon, String source) {
            Intrinsics.checkNotNullParameter(source, "");
            return new PromoAdsParams(size, lat, lon, source);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof PromoAdsParams) {
                PromoAdsParams promoAdsParams = (PromoAdsParams) other;
                return this.size == promoAdsParams.size && Intrinsics.areEqual((Object) Double.valueOf(this.lat), (Object) Double.valueOf(promoAdsParams.lat)) && Intrinsics.areEqual((Object) Double.valueOf(this.lon), (Object) Double.valueOf(promoAdsParams.lon)) && Intrinsics.areEqual(this.source, promoAdsParams.source);
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.size * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.lat)) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.lon)) * 31) + this.source.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PromoAdsParams(size=");
            sb.append(this.size);
            sb.append(", lat=");
            sb.append(this.lat);
            sb.append(", lon=");
            sb.append(this.lon);
            sb.append(", source=");
            sb.append(this.source);
            sb.append(')');
            return sb.toString();
        }

        public PromoAdsParams(int i, double d, double d2, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.size = i;
            this.lat = d;
            this.lon = d2;
            this.source = str;
        }

        @JvmName(name = "getLat")
        public final double getLat() {
            return this.lat;
        }

        @JvmName(name = "getLon")
        public final double getLon() {
            return this.lon;
        }

        @JvmName(name = "getSize")
        public final int getSize() {
            return this.size;
        }

        @JvmName(name = "getSource")
        public final String getSource() {
            return this.source;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public final Observable<PromoAds> buildUseCaseObservable(PromoAdsParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.promoCenterRepository.getPromoAds(params.getSize(), params.getLat(), params.getLon(), params.getSource());
    }
}
