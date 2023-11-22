package id.dana.domain.tracker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/tracker/GeocodeTrackerDataKey;", "", "AppLayerSource", "DataLayerSource", "GeocoderSource"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface GeocodeTrackerDataKey {

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/domain/tracker/GeocodeTrackerDataKey$AppLayerSource;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public @interface AppLayerSource {
        public static final String BALANCEGNPAYFRAGMENT_INIT = "BalanceGnPayFragment.init";

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String GETLOCATIONNAMEBRIDGE_LOCATIONNAME = "GetLocationNameBridge.locationName";
        public static final String HOMETABACTIVITY_DISPLAYFACELOGINSUGGESTIONDIALOG = "HomeTabActivity.displayFaceLoginSuggestionDialog";
        public static final String HOMETABFRAGMENT_GETCOUNTRYCODEBYLOCATION_GN_ONBOARDINGSTEP = "HomeTabFragment#getCountryCodeByLocation#onGnOnboardingStep";
        public static final String HOMETABFRAGMENT_GETCOUNTRYCODEBYLOCATION_QRIS_ONBOARDINGTEP = "HomeTabFragment#getCountryCodeByLocation#onQcbOnboardingStep";
        public static final String MINIPROGRAMLOCATIONPICKERACTIVITY_SETUPRECYCLERVIEW = "MiniProgramLocationPickerActivity.setupRecyclerView";
        public static final String MINIPROGRAMLOCATIONPICKERACTIVITY_SETUPSEARCHVIEW = "MiniProgramLocationPickerActivity.setupSearchView";
        public static final String NEARBYMEACTIVITY_GETDISTRICTBYLOCATION = "NearbyMeActivity.getDistrictByLocation";
        public static final String NEARBYMEACTIVITY_SETUPCAMERALISTENER = "NearbyMeActivity.setupCameraListener";
        public static final String NEARBYMERCHANTLOCATIONSEARCHVIEW_SETUP = "NearbyMerchantLocationSearchView.setup";
        public static final String NEARBYMERCHANTLOCATIONSEARCHVIEW_SETUPSEARCHVIEW = "NearbyMerchantLocationSearchView.setupSearchView";
        public static final String NEARBYSEARCHFRAGMENT_SEARCHLOCATION = "NearbySearchFragment.searchLocation";
        public static final String SCANNERFRAGMENT_CHECKLOCATIONPERMISSION = "ScannerFragment.checkLocationPermission";
        public static final String SPLITOBSERVANT_SETLOCATIONATTRIBUTE = "SplitObservant.setLocationAttribute";
        public static final String VERIFYREFERRALCODEFRAGMENT_GETUSERCURRENTLOCATIONANDSENDREFERRALCODE = "VerifyReferralCodeFragment.getUserCurrentLocationAndSendReferralCode";
        public static final String ZOOMDIALOG_INIT = "ZoomDialog.init";

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/domain/tracker/GeocodeTrackerDataKey$AppLayerSource$Companion;", "", "", "BALANCEGNPAYFRAGMENT_INIT", "Ljava/lang/String;", "GETLOCATIONNAMEBRIDGE_LOCATIONNAME", "HOMETABACTIVITY_DISPLAYFACELOGINSUGGESTIONDIALOG", "HOMETABFRAGMENT_GETCOUNTRYCODEBYLOCATION_GN_ONBOARDINGSTEP", "HOMETABFRAGMENT_GETCOUNTRYCODEBYLOCATION_QRIS_ONBOARDINGTEP", "MINIPROGRAMLOCATIONPICKERACTIVITY_SETUPRECYCLERVIEW", "MINIPROGRAMLOCATIONPICKERACTIVITY_SETUPSEARCHVIEW", "NEARBYMEACTIVITY_GETDISTRICTBYLOCATION", "NEARBYMEACTIVITY_SETUPCAMERALISTENER", "NEARBYMERCHANTLOCATIONSEARCHVIEW_SETUP", "NEARBYMERCHANTLOCATIONSEARCHVIEW_SETUPSEARCHVIEW", "NEARBYSEARCHFRAGMENT_SEARCHLOCATION", "SCANNERFRAGMENT_CHECKLOCATIONPERMISSION", "SPLITOBSERVANT_SETLOCATIONATTRIBUTE", "VERIFYREFERRALCODEFRAGMENT_GETUSERCURRENTLOCATIONANDSENDREFERRALCODE", "ZOOMDIALOG_INIT", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String BALANCEGNPAYFRAGMENT_INIT = "BalanceGnPayFragment.init";
            public static final String GETLOCATIONNAMEBRIDGE_LOCATIONNAME = "GetLocationNameBridge.locationName";
            public static final String HOMETABACTIVITY_DISPLAYFACELOGINSUGGESTIONDIALOG = "HomeTabActivity.displayFaceLoginSuggestionDialog";
            public static final String HOMETABFRAGMENT_GETCOUNTRYCODEBYLOCATION_GN_ONBOARDINGSTEP = "HomeTabFragment#getCountryCodeByLocation#onGnOnboardingStep";
            public static final String HOMETABFRAGMENT_GETCOUNTRYCODEBYLOCATION_QRIS_ONBOARDINGTEP = "HomeTabFragment#getCountryCodeByLocation#onQcbOnboardingStep";
            public static final String MINIPROGRAMLOCATIONPICKERACTIVITY_SETUPRECYCLERVIEW = "MiniProgramLocationPickerActivity.setupRecyclerView";
            public static final String MINIPROGRAMLOCATIONPICKERACTIVITY_SETUPSEARCHVIEW = "MiniProgramLocationPickerActivity.setupSearchView";
            public static final String NEARBYMEACTIVITY_GETDISTRICTBYLOCATION = "NearbyMeActivity.getDistrictByLocation";
            public static final String NEARBYMEACTIVITY_SETUPCAMERALISTENER = "NearbyMeActivity.setupCameraListener";
            public static final String NEARBYMERCHANTLOCATIONSEARCHVIEW_SETUP = "NearbyMerchantLocationSearchView.setup";
            public static final String NEARBYMERCHANTLOCATIONSEARCHVIEW_SETUPSEARCHVIEW = "NearbyMerchantLocationSearchView.setupSearchView";
            public static final String NEARBYSEARCHFRAGMENT_SEARCHLOCATION = "NearbySearchFragment.searchLocation";
            public static final String SCANNERFRAGMENT_CHECKLOCATIONPERMISSION = "ScannerFragment.checkLocationPermission";
            public static final String SPLITOBSERVANT_SETLOCATIONATTRIBUTE = "SplitObservant.setLocationAttribute";
            public static final String VERIFYREFERRALCODEFRAGMENT_GETUSERCURRENTLOCATIONANDSENDREFERRALCODE = "VerifyReferralCodeFragment.getUserCurrentLocationAndSendReferralCode";
            public static final String ZOOMDIALOG_INIT = "ZoomDialog.init";

            private Companion() {
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/domain/tracker/GeocodeTrackerDataKey$DataLayerSource;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public @interface DataLayerSource {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String GETAUTOSUGGESTCHAINQUERY = "GetAutoSuggestChainQuery";
        public static final String GETCHAINQUERYRESULT = "GetChainQueryResult";
        public static final String GETCOUNTRYCODEBYLOCATION = "GetCountryCodeByLocation";
        public static final String GETDISTRICTNAMEBYLOCATION = "GetDistrictNameByLocation";
        public static final String GETINDOSUBDIVISIONSBYLOCATION = "GetIndoSubdivisionsByLocation";
        public static final String GETLISTNEARBYLOCATION = "GetListNearbyLocation";
        public static final String GETLOCATIONDETAIL = "GetLocationDetail";
        public static final String GETQRISCOUNTRYCODEBYLOCATION = "GetQrisCountryCodeByLocation";

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004"}, d2 = {"Lid/dana/domain/tracker/GeocodeTrackerDataKey$DataLayerSource$Companion;", "", "", "GETAUTOSUGGESTCHAINQUERY", "Ljava/lang/String;", "GETCHAINQUERYRESULT", "GETCOUNTRYCODEBYLOCATION", "GETDISTRICTNAMEBYLOCATION", "GETINDOSUBDIVISIONSBYLOCATION", "GETLISTNEARBYLOCATION", "GETLOCATIONDETAIL", "GETQRISCOUNTRYCODEBYLOCATION", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String GETAUTOSUGGESTCHAINQUERY = "GetAutoSuggestChainQuery";
            public static final String GETCHAINQUERYRESULT = "GetChainQueryResult";
            public static final String GETCOUNTRYCODEBYLOCATION = "GetCountryCodeByLocation";
            public static final String GETDISTRICTNAMEBYLOCATION = "GetDistrictNameByLocation";
            public static final String GETINDOSUBDIVISIONSBYLOCATION = "GetIndoSubdivisionsByLocation";
            public static final String GETLISTNEARBYLOCATION = "GetListNearbyLocation";
            public static final String GETLOCATIONDETAIL = "GetLocationDetail";
            public static final String GETQRISCOUNTRYCODEBYLOCATION = "GetQrisCountryCodeByLocation";

            private Companion() {
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/domain/tracker/GeocodeTrackerDataKey$GeocoderSource;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public @interface GeocoderSource {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String GOOGLE = "GOOGLE";
        public static final String HERE = "HERE";
        public static final String NATIVE = "NATIVE";

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/domain/tracker/GeocodeTrackerDataKey$GeocoderSource$Companion;", "", "", "GOOGLE", "Ljava/lang/String;", "HERE", "NATIVE", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String GOOGLE = "GOOGLE";
            public static final String HERE = "HERE";
            public static final String NATIVE = "NATIVE";

            private Companion() {
            }
        }
    }
}
