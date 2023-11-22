package id.dana.data.di;

import dagger.Module;
import dagger.Provides;
import id.dana.data.BuildConfig;
import id.dana.data.account.avatar.repository.source.network.AvatarApi;
import id.dana.data.base.DanaContentApi;
import id.dana.data.constant.DanaUrl;
import id.dana.data.deeplink.repository.source.network.BranchApi;
import id.dana.data.expresspurchase.source.network.ExpressPurchaseApi;
import id.dana.data.expresspurchase.source.network.ExpressPurchaseOfferApi;
import id.dana.data.geocode.repository.source.network.GeocoderApi;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.data.here.source.network.HereAutosuggestApi;
import id.dana.data.here.source.network.HereGeocodeApi;
import id.dana.data.here.source.network.HereTokenApi;
import id.dana.data.lazada.repository.source.network.LazadaRegistrationUrlApi;
import id.dana.data.loyalty.repository.source.network.LoyaltyApi;
import id.dana.data.nearbyplaces.repository.source.network.NearbyPlacesApi;
import id.dana.data.otp.repository.source.network.OtpApi;
import id.dana.data.recentrecipient.source.network.ConvertCardIndexNoSecureApi;
import id.dana.data.senddigitalmoney.repository.source.network.CardQueryNoPrefixApi;
import id.dana.data.sendmoney.repository.source.network.NameCheckSecureApi;
import id.dana.data.uploadfiles.UploadFilesApi;
import id.dana.data.useremailaddress.repository.source.network.UserEmailAddressApi;
import id.dana.data.zendesk.repository.source.network.ZendeskApi;
import java.util.Objects;
import javax.inject.Named;
import javax.inject.Singleton;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;

@Module
/* loaded from: classes.dex */
public class ApiModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public DanaContentApi provideDanaCdnApi(Retrofit.Builder builder) {
        return (DanaContentApi) builder.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(DanaContentApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public BranchApi provideBranchIoApi(@Named("SECURED_RETROFIT") Retrofit.Builder builder) {
        Objects.requireNonNull(DanaUrl.BRANCHIO_URL, "baseUrl == null");
        return (BranchApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get(DanaUrl.BRANCHIO_URL)).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(BranchApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public CardQueryNoPrefixApi provideCardQueryNoPrefixApi(@Named("SESSION_RETROFIT") Retrofit.Builder builder) {
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        return (CardQueryNoPrefixApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(CardQueryNoPrefixApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public ConvertCardIndexNoSecureApi provideConvertCardIndexNoApi(@Named("SECURED_RETROFIT") Retrofit.Builder builder) {
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        return (ConvertCardIndexNoSecureApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(ConvertCardIndexNoSecureApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public ExpressPurchaseApi provideExpressPurchaseApi(@Named("SECURED_RETROFIT") Retrofit.Builder builder) {
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        return (ExpressPurchaseApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(ExpressPurchaseApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public ExpressPurchaseOfferApi provideExpressPurchaseOfferApi(@Named("SECURED_RETROFIT_WITH_LOCATION_CHECK") Retrofit.Builder builder) {
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        return (ExpressPurchaseOfferApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(ExpressPurchaseOfferApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public GeocoderApi provideGeocoderApi(Retrofit.Builder builder) {
        Objects.requireNonNull(DanaUrl.GEOCODER_URL, "baseUrl == null");
        return (GeocoderApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get(DanaUrl.GEOCODER_URL)).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(GeocoderApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public HereAutosuggestApi provideHereAutocompleteApi(@Named("NON_DANA_SERVICE_RETROFIT") Retrofit.Builder builder) {
        Objects.requireNonNull(HereUrlConstant.AUTO_SUGGEST_URL, "baseUrl == null");
        return (HereAutosuggestApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get(HereUrlConstant.AUTO_SUGGEST_URL)).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(HereAutosuggestApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public HereGeocodeApi provideHereGeocodeApi(@Named("NON_DANA_SERVICE_RETROFIT") Retrofit.Builder builder) {
        Objects.requireNonNull(HereUrlConstant.GEOCODE_REVERSE_URL, "baseUrl == null");
        return (HereGeocodeApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get(HereUrlConstant.GEOCODE_REVERSE_URL)).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(HereGeocodeApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public HereTokenApi provideHereTokenApi(@Named("NON_DANA_SERVICE_RETROFIT") Retrofit.Builder builder) {
        Objects.requireNonNull(HereUrlConstant.HERE_TOKEN_URL, "baseUrl == null");
        return (HereTokenApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get(HereUrlConstant.HERE_TOKEN_URL)).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(HereTokenApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public LazadaRegistrationUrlApi provideIpgRegistrationUrlApi(Retrofit.Builder builder) {
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        return (LazadaRegistrationUrlApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(LazadaRegistrationUrlApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public LoyaltyApi provideLoyaltyApi(@Named("SECURED_RETROFIT") Retrofit.Builder builder) {
        Objects.requireNonNull(BuildConfig.LOYALTY_BASE_URL, "baseUrl == null");
        return (LoyaltyApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get(BuildConfig.LOYALTY_BASE_URL)).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(LoyaltyApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public NameCheckSecureApi provideNameCheckApi(@Named("SECURED_RETROFIT_NAMECHECK") Retrofit.Builder builder) {
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        return (NameCheckSecureApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(NameCheckSecureApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public NearbyPlacesApi provideNearbyPlacesApi(Retrofit.Builder builder) {
        Objects.requireNonNull(DanaUrl.GOOGLE_MAP_BASE_URL, "baseUrl == null");
        return (NearbyPlacesApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get(DanaUrl.GOOGLE_MAP_BASE_URL)).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(NearbyPlacesApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public OtpApi provideOtpApi(@Named("SESSION_RETROFIT") Retrofit.Builder builder) {
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        return (OtpApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(OtpApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public UploadFilesApi provideUploadFilesApi(@Named("UPLOAD_FILES_RETROFIT") Retrofit.Builder builder) {
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        return (UploadFilesApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(UploadFilesApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public AvatarApi provideUserApi(@Named("SESSION_RETROFIT") Retrofit.Builder builder) {
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        return (AvatarApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(AvatarApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public UserEmailAddressApi provideUserEmailAddressApi(@Named("SESSION_RETROFIT") Retrofit.Builder builder) {
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        return (UserEmailAddressApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(UserEmailAddressApi.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public ZendeskApi provideZendeskApi(Retrofit.Builder builder) {
        Objects.requireNonNull(DanaUrl.ZENDESK_API, "baseUrl == null");
        return (ZendeskApi) builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get(DanaUrl.ZENDESK_API)).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(ZendeskApi.class);
    }
}
