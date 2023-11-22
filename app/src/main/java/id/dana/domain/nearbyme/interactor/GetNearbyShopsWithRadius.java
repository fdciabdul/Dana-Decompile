package id.dana.domain.nearbyme.interactor;

import android.location.Location;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyme.model.NearbyConfig;
import id.dana.domain.nearbyme.model.ShopsPage;
import id.dana.domain.tracker.MixpanelRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001e\u001fB!\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R*\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0007@GX\u0086.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetNearbyShopsWithRadius;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "Lid/dana/domain/nearbyme/model/ShopsPage;", "Lid/dana/domain/nearbyme/interactor/GetNearbyShopsWithRadius$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/nearbyme/interactor/GetNearbyShopsWithRadius$Params;)Lio/reactivex/Observable;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "Lid/dana/domain/tracker/MixpanelRepository;", "mixpanelRepository", "Lid/dana/domain/tracker/MixpanelRepository;", "Lid/dana/domain/nearbyme/model/NearbyConfig;", "<set-?>", "nearbyConfig", "Lid/dana/domain/nearbyme/model/NearbyConfig;", "getNearbyConfig", "()Lid/dana/domain/nearbyme/model/NearbyConfig;", "setNearbyConfig", "(Lid/dana/domain/nearbyme/model/NearbyConfig;)V", "Lid/dana/domain/nearbyme/NearbyMeRepository;", "nearbyMeRepository", "Lid/dana/domain/nearbyme/NearbyMeRepository;", "<init>", "(Lid/dana/domain/nearbyme/NearbyMeRepository;Lid/dana/domain/featureconfig/FeatureConfigRepository;Lid/dana/domain/tracker/MixpanelRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetNearbyShopsWithRadius extends BaseUseCaseWithAnalytics<ShopsPage, Params> {
    public static final String QUERY_RADIUS_DISCOVERY = "id.dana.discovery.nearby.queryRadius";
    public static final String QUERY_RADIUS_MOBILEWALLET = "alipayplus.mobilewallet.nearby.queryradius";
    private final FeatureConfigRepository featureConfigRepository;
    private final MixpanelRepository mixpanelRepository;
    public NearbyConfig nearbyConfig;
    private final NearbyMeRepository nearbyMeRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetNearbyShopsWithRadius(NearbyMeRepository nearbyMeRepository, FeatureConfigRepository featureConfigRepository, MixpanelRepository mixpanelRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(nearbyMeRepository, "");
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        this.nearbyMeRepository = nearbyMeRepository;
        this.featureConfigRepository = featureConfigRepository;
        this.mixpanelRepository = mixpanelRepository;
    }

    @JvmName(name = "getNearbyConfig")
    public final NearbyConfig getNearbyConfig() {
        NearbyConfig nearbyConfig = this.nearbyConfig;
        if (nearbyConfig != null) {
            return nearbyConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setNearbyConfig")
    public final void setNearbyConfig(NearbyConfig nearbyConfig) {
        Intrinsics.checkNotNullParameter(nearbyConfig, "");
        this.nearbyConfig = nearbyConfig;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<ShopsPage> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = this.featureConfigRepository.getNearbyConfig().flatMap(new Function() { // from class: id.dana.domain.nearbyme.interactor.GetNearbyShopsWithRadius$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2377buildUseCase$lambda0;
                m2377buildUseCase$lambda0 = GetNearbyShopsWithRadius.m2377buildUseCase$lambda0(GetNearbyShopsWithRadius.this, params, (NearbyConfig) obj);
                return m2377buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: buildUseCase$lambda-0 */
    public static final ObservableSource m2377buildUseCase$lambda0(GetNearbyShopsWithRadius getNearbyShopsWithRadius, Params params, NearbyConfig nearbyConfig) {
        Intrinsics.checkNotNullParameter(getNearbyShopsWithRadius, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(nearbyConfig, "");
        getNearbyShopsWithRadius.setNearbyConfig(nearbyConfig);
        return getNearbyShopsWithRadius.nearbyMeRepository.getNearbyShopByRadius(params.getCurrentLocation(), params.getRadius(), params.getPageNum(), params.getPageSize(), params.getOnInit(), params.getUseNewMerchantCategory(), params.getSearchKeyword(), params.getSearchType());
    }

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return this.nearbyConfig != null ? getNearbyConfig().getUseQueryRadiusDiscoveryApi() ? QUERY_RADIUS_DISCOVERY : QUERY_RADIUS_MOBILEWALLET : "";
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u00158\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00158\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000b"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetNearbyShopsWithRadius$Params;", "", "Landroid/location/Location;", "currentLocation", "Landroid/location/Location;", "getCurrentLocation", "()Landroid/location/Location;", "", "onInit", "Z", "getOnInit", "()Z", "", "pageNum", "I", "getPageNum", "()I", SecurityConstants.KEY_PAGE_SIZE, "getPageSize", "radius", "getRadius", "", "searchKeyword", "Ljava/lang/String;", "getSearchKeyword", "()Ljava/lang/String;", "searchType", "getSearchType", "useNewMerchantCategory", "getUseNewMerchantCategory", "<init>", "(Landroid/location/Location;IIIZZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final Location currentLocation;
        private final boolean onInit;
        private final int pageNum;
        private final int pageSize;
        private final int radius;
        private final String searchKeyword;
        private final String searchType;
        private final boolean useNewMerchantCategory;

        public Params(Location location, int i, int i2, int i3, boolean z, boolean z2, String str, String str2) {
            Intrinsics.checkNotNullParameter(location, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.currentLocation = location;
            this.radius = i;
            this.pageNum = i2;
            this.pageSize = i3;
            this.onInit = z;
            this.useNewMerchantCategory = z2;
            this.searchKeyword = str;
            this.searchType = str2;
        }

        public /* synthetic */ Params(Location location, int i, int i2, int i3, boolean z, boolean z2, String str, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(location, i, i2, i3, z, (i4 & 32) != 0 ? false : z2, str, str2);
        }

        @JvmName(name = "getCurrentLocation")
        public final Location getCurrentLocation() {
            return this.currentLocation;
        }

        @JvmName(name = "getRadius")
        public final int getRadius() {
            return this.radius;
        }

        @JvmName(name = "getPageNum")
        public final int getPageNum() {
            return this.pageNum;
        }

        @JvmName(name = "getPageSize")
        public final int getPageSize() {
            return this.pageSize;
        }

        @JvmName(name = "getOnInit")
        public final boolean getOnInit() {
            return this.onInit;
        }

        @JvmName(name = "getUseNewMerchantCategory")
        public final boolean getUseNewMerchantCategory() {
            return this.useNewMerchantCategory;
        }

        @JvmName(name = "getSearchKeyword")
        public final String getSearchKeyword() {
            return this.searchKeyword;
        }

        @JvmName(name = "getSearchType")
        public final String getSearchType() {
            return this.searchType;
        }
    }
}
