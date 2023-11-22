package id.dana.domain.nearbyme.interactor;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyme.model.OtherStoreListResult;
import id.dana.sendmoney.summary.SummaryActivity;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetOtherStoreList;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/nearbyme/model/OtherStoreListResult;", "Lid/dana/domain/nearbyme/interactor/GetOtherStoreList$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/nearbyme/interactor/GetOtherStoreList$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/nearbyme/NearbyMeRepository;", "nearbyMeRepository", "Lid/dana/domain/nearbyme/NearbyMeRepository;", "<init>", "(Lid/dana/domain/nearbyme/NearbyMeRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetOtherStoreList extends BaseUseCase<OtherStoreListResult, Params> {
    private final NearbyMeRepository nearbyMeRepository;

    @Inject
    public GetOtherStoreList(NearbyMeRepository nearbyMeRepository) {
        Intrinsics.checkNotNullParameter(nearbyMeRepository, "");
        this.nearbyMeRepository = nearbyMeRepository;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J`\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u000bJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004R\u0017\u0010\u0013\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b#\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b(\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b)\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b*\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b,\u0010\u0011"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetOtherStoreList$Params;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()D", "component3", "", "component4", "()I", "component5", "component6", "component7", "", "component8", "()Z", "merchantId", "latitude", "longitude", SecurityConstants.KEY_PAGE_SIZE, "pageNum", "searchKeyword", "searchType", "useNewMerchantCategories", "copy", "(Ljava/lang/String;DDIILjava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/nearbyme/interactor/GetOtherStoreList$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", SummaryActivity.DAYS, "getLatitude", "getLongitude", "Ljava/lang/String;", "getMerchantId", "I", "getPageNum", "getPageSize", "getSearchKeyword", "getSearchType", "Z", "getUseNewMerchantCategories", "<init>", "(Ljava/lang/String;DDIILjava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final double latitude;
        private final double longitude;
        private final String merchantId;
        private final int pageNum;
        private final int pageSize;
        private final String searchKeyword;
        private final String searchType;
        private final boolean useNewMerchantCategories;

        /* renamed from: component1  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
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
        public final int getPageSize() {
            return this.pageSize;
        }

        /* renamed from: component5  reason: from getter */
        public final int getPageNum() {
            return this.pageNum;
        }

        /* renamed from: component6  reason: from getter */
        public final String getSearchKeyword() {
            return this.searchKeyword;
        }

        /* renamed from: component7  reason: from getter */
        public final String getSearchType() {
            return this.searchType;
        }

        /* renamed from: component8  reason: from getter */
        public final boolean getUseNewMerchantCategories() {
            return this.useNewMerchantCategories;
        }

        public final Params copy(String merchantId, double latitude, double longitude, int pageSize, int pageNum, String searchKeyword, String searchType, boolean useNewMerchantCategories) {
            Intrinsics.checkNotNullParameter(merchantId, "");
            Intrinsics.checkNotNullParameter(searchKeyword, "");
            Intrinsics.checkNotNullParameter(searchType, "");
            return new Params(merchantId, latitude, longitude, pageSize, pageNum, searchKeyword, searchType, useNewMerchantCategories);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.merchantId, params.merchantId) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(params.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(params.longitude)) && this.pageSize == params.pageSize && this.pageNum == params.pageNum && Intrinsics.areEqual(this.searchKeyword, params.searchKeyword) && Intrinsics.areEqual(this.searchType, params.searchType) && this.useNewMerchantCategories == params.useNewMerchantCategories;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.merchantId.hashCode();
            int KClassImpl$Data$declaredNonStaticMembers$2 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.latitude);
            int KClassImpl$Data$declaredNonStaticMembers$22 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.longitude);
            int i = this.pageSize;
            int i2 = this.pageNum;
            int hashCode2 = this.searchKeyword.hashCode();
            int hashCode3 = this.searchType.hashCode();
            boolean z = this.useNewMerchantCategories;
            int i3 = z;
            if (z != 0) {
                i3 = 1;
            }
            return (((((((((((((hashCode * 31) + KClassImpl$Data$declaredNonStaticMembers$2) * 31) + KClassImpl$Data$declaredNonStaticMembers$22) * 31) + i) * 31) + i2) * 31) + hashCode2) * 31) + hashCode3) * 31) + i3;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(merchantId=");
            sb.append(this.merchantId);
            sb.append(", latitude=");
            sb.append(this.latitude);
            sb.append(", longitude=");
            sb.append(this.longitude);
            sb.append(", pageSize=");
            sb.append(this.pageSize);
            sb.append(", pageNum=");
            sb.append(this.pageNum);
            sb.append(", searchKeyword=");
            sb.append(this.searchKeyword);
            sb.append(", searchType=");
            sb.append(this.searchType);
            sb.append(", useNewMerchantCategories=");
            sb.append(this.useNewMerchantCategories);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, double d, double d2, int i, int i2, String str2, String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.merchantId = str;
            this.latitude = d;
            this.longitude = d2;
            this.pageSize = i;
            this.pageNum = i2;
            this.searchKeyword = str2;
            this.searchType = str3;
            this.useNewMerchantCategories = z;
        }

        public /* synthetic */ Params(String str, double d, double d2, int i, int i2, String str2, String str3, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, d, d2, i, i2, str2, str3, (i3 & 128) != 0 ? false : z);
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "getLatitude")
        public final double getLatitude() {
            return this.latitude;
        }

        @JvmName(name = "getLongitude")
        public final double getLongitude() {
            return this.longitude;
        }

        @JvmName(name = "getPageSize")
        public final int getPageSize() {
            return this.pageSize;
        }

        @JvmName(name = "getPageNum")
        public final int getPageNum() {
            return this.pageNum;
        }

        @JvmName(name = "getSearchKeyword")
        public final String getSearchKeyword() {
            return this.searchKeyword;
        }

        @JvmName(name = "getSearchType")
        public final String getSearchType() {
            return this.searchType;
        }

        @JvmName(name = "getUseNewMerchantCategories")
        public final boolean getUseNewMerchantCategories() {
            return this.useNewMerchantCategories;
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<OtherStoreListResult> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.nearbyMeRepository.getOtherStoreList(params.getMerchantId(), params.getLatitude(), params.getLongitude(), params.getPageNum(), params.getPageSize(), params.getSearchKeyword(), params.getSearchType(), params.getUseNewMerchantCategories());
    }
}
