package id.dana.data.geocode.repository;

import android.location.Location;
import id.dana.data.geocode.model.GeocodeReverseConfigResult;
import id.dana.data.geocode.repository.config.GeocodeConfigEntityData;
import id.dana.data.geocode.repository.config.GeocodeConfigEntityDataFactory;
import id.dana.data.geocode.repository.source.GeocodeEntityData;
import id.dana.data.geocode.repository.source.GeocodeEntityDataFactory;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.geocode.model.GeocodeReverseConfig;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.domain.miniprogram.model.Address;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import id.dana.utils.BuildConfigUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b6\u00107J-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0016¢\u0006\u0004\b\u001e\u0010\u0018J\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\bH\u0016¢\u0006\u0004\b \u0010\u0018J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0019H\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190\b2\u0006\u0010'\u001a\u00020\u0013H\u0016¢\u0006\u0004\b(\u0010)J\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00190\b2\u0006\u0010*\u001a\u00020\u001fH\u0016¢\u0006\u0004\b+\u0010,J\u0013\u0010.\u001a\u00020\u0016*\u00020-H\u0002¢\u0006\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105"}, d2 = {"Lid/dana/data/geocode/repository/GeocodeEntityRepository;", "Lid/dana/domain/geocode/GeocodeRepository;", "Landroid/location/Location;", "location", "Lid/dana/domain/geocode/model/IndoSubdivisions;", "indoSubdivisions", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "Lio/reactivex/Observable;", "addIndoSubdivisionDataFromNetworkGeocoder", "(Landroid/location/Location;Lid/dana/domain/geocode/model/IndoSubdivisions;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "Lid/dana/data/geocode/repository/config/GeocodeConfigEntityData;", "createGeocodeConfigLocalEntityData", "()Lid/dana/data/geocode/repository/config/GeocodeConfigEntityData;", "createGeocodeConfigSplitEntityData", "Lid/dana/data/geocode/repository/source/GeocodeEntityData;", "createLocalGeocodeEntityData", "()Lid/dana/data/geocode/repository/source/GeocodeEntityData;", "createNetworkGeocodeEntityData", "", "getDistrictNameByLocation", "(Landroid/location/Location;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "Lid/dana/domain/geocode/model/GeocodeReverseConfig;", "getGeocodeReverseConfig", "()Lio/reactivex/Observable;", "", "shouldCallHEREGeocodeAPI", "isGpsMockedForUnderLollipop", "getIndoSubdivisionsNameByLocation", "(Landroid/location/Location;ZZLid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "getLatestProvinceLandmark", "Lid/dana/domain/geocode/model/LocationSubdisivision;", "getLatestSubdivisions", "Lid/dana/domain/miniprogram/model/Address;", "getReverseGeocodeByLoc", "(Landroid/location/Location;)Lio/reactivex/Observable;", "isMockGpsForUnderLollipop", "isGpsMocked", "(Landroid/location/Location;Z)Z", "provinceName", "saveLatestProvinceLandmark", "(Ljava/lang/String;)Lio/reactivex/Observable;", "locationSubdisivision", "saveLatestSubdivisions", "(Lid/dana/domain/geocode/model/LocationSubdisivision;)Lio/reactivex/Observable;", "Lid/dana/data/geocode/model/GeocodeReverseConfigResult;", "toGeocodeReverseConfig", "(Lid/dana/data/geocode/model/GeocodeReverseConfigResult;)Lid/dana/domain/geocode/model/GeocodeReverseConfig;", "Lid/dana/data/geocode/repository/config/GeocodeConfigEntityDataFactory;", "geocodeConfigEntityDataFactory", "Lid/dana/data/geocode/repository/config/GeocodeConfigEntityDataFactory;", "Lid/dana/data/geocode/repository/source/GeocodeEntityDataFactory;", "geocodeEntityDataFactory", "Lid/dana/data/geocode/repository/source/GeocodeEntityDataFactory;", "<init>", "(Lid/dana/data/geocode/repository/source/GeocodeEntityDataFactory;Lid/dana/data/geocode/repository/config/GeocodeConfigEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GeocodeEntityRepository implements GeocodeRepository {
    private final GeocodeConfigEntityDataFactory geocodeConfigEntityDataFactory;
    private final GeocodeEntityDataFactory geocodeEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLatestProvinceLandmark$lambda-9  reason: not valid java name */
    public static final String m1293getLatestProvinceLandmark$lambda9(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return "";
    }

    @Inject
    public GeocodeEntityRepository(GeocodeEntityDataFactory geocodeEntityDataFactory, GeocodeConfigEntityDataFactory geocodeConfigEntityDataFactory) {
        Intrinsics.checkNotNullParameter(geocodeEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(geocodeConfigEntityDataFactory, "");
        this.geocodeEntityDataFactory = geocodeEntityDataFactory;
        this.geocodeConfigEntityDataFactory = geocodeConfigEntityDataFactory;
    }

    @Override // id.dana.domain.geocode.GeocodeRepository
    public final Observable<String> getDistrictNameByLocation(final Location location, final HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        Observable flatMap = createLocalGeocodeEntityData().getDistrictNameByLocation(location, hereMixPanelTrackerData).flatMap(new Function() { // from class: id.dana.data.geocode.repository.GeocodeEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1288getDistrictNameByLocation$lambda0;
                m1288getDistrictNameByLocation$lambda0 = GeocodeEntityRepository.m1288getDistrictNameByLocation$lambda0(GeocodeEntityRepository.this, location, hereMixPanelTrackerData, (String) obj);
                return m1288getDistrictNameByLocation$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDistrictNameByLocation$lambda-0  reason: not valid java name */
    public static final ObservableSource m1288getDistrictNameByLocation$lambda0(GeocodeEntityRepository geocodeEntityRepository, Location location, HereMixPanelTrackerData hereMixPanelTrackerData, String str) {
        Observable<String> just;
        Intrinsics.checkNotNullParameter(geocodeEntityRepository, "");
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (str.length() == 0) {
            just = geocodeEntityRepository.createNetworkGeocodeEntityData().getDistrictNameByLocation(location, hereMixPanelTrackerData);
        } else {
            just = Observable.just(str);
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    @Override // id.dana.domain.geocode.GeocodeRepository
    public final Observable<IndoSubdivisions> getIndoSubdivisionsNameByLocation(final Location location, final boolean shouldCallHEREGeocodeAPI, final boolean isGpsMockedForUnderLollipop, final HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        Observable<IndoSubdivisions> flatMap = createLocalGeocodeEntityData().getSubdivisionsFromGeocoder(location, hereMixPanelTrackerData).flatMap(new Function() { // from class: id.dana.data.geocode.repository.GeocodeEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1290getIndoSubdivisionsNameByLocation$lambda3;
                m1290getIndoSubdivisionsNameByLocation$lambda3 = GeocodeEntityRepository.m1290getIndoSubdivisionsNameByLocation$lambda3(shouldCallHEREGeocodeAPI, this, location, hereMixPanelTrackerData, isGpsMockedForUnderLollipop, (IndoSubdivisions) obj);
                return m1290getIndoSubdivisionsNameByLocation$lambda3;
            }
        }).flatMap(new Function() { // from class: id.dana.data.geocode.repository.GeocodeEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1292getIndoSubdivisionsNameByLocation$lambda5;
                m1292getIndoSubdivisionsNameByLocation$lambda5 = GeocodeEntityRepository.m1292getIndoSubdivisionsNameByLocation$lambda5(GeocodeEntityRepository.this, location, isGpsMockedForUnderLollipop, (IndoSubdivisions) obj);
                return m1292getIndoSubdivisionsNameByLocation$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getIndoSubdivisionsNameByLocation$lambda-3  reason: not valid java name */
    public static final ObservableSource m1290getIndoSubdivisionsNameByLocation$lambda3(boolean z, final GeocodeEntityRepository geocodeEntityRepository, final Location location, HereMixPanelTrackerData hereMixPanelTrackerData, final boolean z2, IndoSubdivisions indoSubdivisions) {
        Intrinsics.checkNotNullParameter(geocodeEntityRepository, "");
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        Intrinsics.checkNotNullParameter(indoSubdivisions, "");
        if (z && indoSubdivisions.isThereAnyEmptyField()) {
            return geocodeEntityRepository.addIndoSubdivisionDataFromNetworkGeocoder(location, indoSubdivisions, hereMixPanelTrackerData).map(new Function() { // from class: id.dana.data.geocode.repository.GeocodeEntityRepository$$ExternalSyntheticLambda6
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    IndoSubdivisions m1291getIndoSubdivisionsNameByLocation$lambda3$lambda2;
                    m1291getIndoSubdivisionsNameByLocation$lambda3$lambda2 = GeocodeEntityRepository.m1291getIndoSubdivisionsNameByLocation$lambda3$lambda2(GeocodeEntityRepository.this, location, z2, (IndoSubdivisions) obj);
                    return m1291getIndoSubdivisionsNameByLocation$lambda3$lambda2;
                }
            });
        }
        return Observable.just(indoSubdivisions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getIndoSubdivisionsNameByLocation$lambda-3$lambda-2  reason: not valid java name */
    public static final IndoSubdivisions m1291getIndoSubdivisionsNameByLocation$lambda3$lambda2(GeocodeEntityRepository geocodeEntityRepository, Location location, boolean z, IndoSubdivisions indoSubdivisions) {
        Intrinsics.checkNotNullParameter(geocodeEntityRepository, "");
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(indoSubdivisions, "");
        indoSubdivisions.setMockLocation(geocodeEntityRepository.isGpsMocked(location, z));
        return indoSubdivisions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getIndoSubdivisionsNameByLocation$lambda-5  reason: not valid java name */
    public static final ObservableSource m1292getIndoSubdivisionsNameByLocation$lambda5(GeocodeEntityRepository geocodeEntityRepository, Location location, boolean z, IndoSubdivisions indoSubdivisions) {
        Intrinsics.checkNotNullParameter(geocodeEntityRepository, "");
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(indoSubdivisions, "");
        indoSubdivisions.setMockLocation(geocodeEntityRepository.isGpsMocked(location, z));
        return Observable.just(indoSubdivisions);
    }

    private final boolean isGpsMocked(Location location, boolean isMockGpsForUnderLollipop) {
        if (location.isFromMockProvider() || isMockGpsForUnderLollipop) {
            BuildConfigUtils.BuiltInFictitiousFunctionClassFactory();
            return true;
        }
        return false;
    }

    private final Observable<IndoSubdivisions> addIndoSubdivisionDataFromNetworkGeocoder(Location location, final IndoSubdivisions indoSubdivisions, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Observable map = createNetworkGeocodeEntityData().getSubdivisionsFromGeocoder(location, hereMixPanelTrackerData).map(new Function() { // from class: id.dana.data.geocode.repository.GeocodeEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                IndoSubdivisions m1287addIndoSubdivisionDataFromNetworkGeocoder$lambda6;
                m1287addIndoSubdivisionDataFromNetworkGeocoder$lambda6 = GeocodeEntityRepository.m1287addIndoSubdivisionDataFromNetworkGeocoder$lambda6(IndoSubdivisions.this, (IndoSubdivisions) obj);
                return m1287addIndoSubdivisionDataFromNetworkGeocoder$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addIndoSubdivisionDataFromNetworkGeocoder$lambda-6  reason: not valid java name */
    public static final IndoSubdivisions m1287addIndoSubdivisionDataFromNetworkGeocoder$lambda6(IndoSubdivisions indoSubdivisions, IndoSubdivisions indoSubdivisions2) {
        Intrinsics.checkNotNullParameter(indoSubdivisions, "");
        Intrinsics.checkNotNullParameter(indoSubdivisions2, "");
        IndoSubdivisions.Builder builder = new IndoSubdivisions.Builder(indoSubdivisions);
        if (indoSubdivisions.getCountryCode().length() == 0) {
            builder.withCountryCode(indoSubdivisions2.getCountryCode());
        }
        if (indoSubdivisions.getCountryName().length() == 0) {
            builder.withCountryName(indoSubdivisions2.getCountryName());
        }
        if (indoSubdivisions.getProviceName().length() == 0) {
            builder.withProvinceName(indoSubdivisions2.getProviceName());
        }
        if (indoSubdivisions.getCityName().length() == 0) {
            builder.withCityName(indoSubdivisions2.getCityName());
        }
        if (indoSubdivisions.getDistrictName().length() == 0) {
            builder.withDistrictName(indoSubdivisions2.getDistrictName());
        }
        if (indoSubdivisions.getSubdistrictName().length() == 0) {
            builder.withSubdistrictName(indoSubdivisions2.getSubdistrictName());
        }
        if (indoSubdivisions.getStreetName().length() == 0) {
            builder.withStreetName(indoSubdivisions2.getStreetName());
        }
        if (indoSubdivisions.getPostalCode().length() == 0) {
            builder.withPostalCode(indoSubdivisions2.getPostalCode());
        }
        return builder.create();
    }

    @Override // id.dana.domain.geocode.GeocodeRepository
    public final Observable<GeocodeReverseConfig> getGeocodeReverseConfig() {
        Observable map = createGeocodeConfigSplitEntityData().getGeocodeReverseConfig().onErrorResumeNext(createGeocodeConfigLocalEntityData().getGeocodeReverseConfig()).map(new Function() { // from class: id.dana.data.geocode.repository.GeocodeEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                GeocodeReverseConfig m1289getGeocodeReverseConfig$lambda7;
                m1289getGeocodeReverseConfig$lambda7 = GeocodeEntityRepository.m1289getGeocodeReverseConfig$lambda7(GeocodeEntityRepository.this, (GeocodeReverseConfigResult) obj);
                return m1289getGeocodeReverseConfig$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getGeocodeReverseConfig$lambda-7  reason: not valid java name */
    public static final GeocodeReverseConfig m1289getGeocodeReverseConfig$lambda7(GeocodeEntityRepository geocodeEntityRepository, GeocodeReverseConfigResult geocodeReverseConfigResult) {
        Intrinsics.checkNotNullParameter(geocodeEntityRepository, "");
        Intrinsics.checkNotNullParameter(geocodeReverseConfigResult, "");
        return geocodeEntityRepository.toGeocodeReverseConfig(geocodeReverseConfigResult);
    }

    @Override // id.dana.domain.geocode.GeocodeRepository
    public final Observable<Boolean> saveLatestSubdivisions(LocationSubdisivision locationSubdisivision) {
        Intrinsics.checkNotNullParameter(locationSubdisivision, "");
        return createLocalGeocodeEntityData().saveLatestLocationSubdisivision(locationSubdisivision);
    }

    @Override // id.dana.domain.geocode.GeocodeRepository
    public final Observable<LocationSubdisivision> getLatestSubdivisions() {
        Observable<LocationSubdisivision> onErrorReturn = createLocalGeocodeEntityData().getLatestLocationSubdisivision().onErrorReturn(new Function() { // from class: id.dana.data.geocode.repository.GeocodeEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                LocationSubdisivision m1294getLatestSubdivisions$lambda8;
                m1294getLatestSubdivisions$lambda8 = GeocodeEntityRepository.m1294getLatestSubdivisions$lambda8((Throwable) obj);
                return m1294getLatestSubdivisions$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLatestSubdivisions$lambda-8  reason: not valid java name */
    public static final LocationSubdisivision m1294getLatestSubdivisions$lambda8(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return LocationSubdisivision.INSTANCE.empty();
    }

    @Override // id.dana.domain.geocode.GeocodeRepository
    public final Observable<Address> getReverseGeocodeByLoc(Location location) {
        Intrinsics.checkNotNullParameter(location, "");
        return createLocalGeocodeEntityData().getReverseGeocodeByLoc(location);
    }

    @Override // id.dana.domain.geocode.GeocodeRepository
    public final Observable<String> getLatestProvinceLandmark() {
        Observable<String> onErrorReturn = createLocalGeocodeEntityData().getLatestProvinceLandmark().onErrorReturn(new Function() { // from class: id.dana.data.geocode.repository.GeocodeEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String m1293getLatestProvinceLandmark$lambda9;
                m1293getLatestProvinceLandmark$lambda9 = GeocodeEntityRepository.m1293getLatestProvinceLandmark$lambda9((Throwable) obj);
                return m1293getLatestProvinceLandmark$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        return onErrorReturn;
    }

    @Override // id.dana.domain.geocode.GeocodeRepository
    public final Observable<Boolean> saveLatestProvinceLandmark(String provinceName) {
        Intrinsics.checkNotNullParameter(provinceName, "");
        return createLocalGeocodeEntityData().saveLatestProvinceLandmark(provinceName);
    }

    private final GeocodeReverseConfig toGeocodeReverseConfig(GeocodeReverseConfigResult geocodeReverseConfigResult) {
        return new GeocodeReverseConfig(geocodeReverseConfigResult.getDistanceInMeters(), geocodeReverseConfigResult.getIntervalInHours(), geocodeReverseConfigResult.getShouldCallHEREGeocodeAPI());
    }

    private final GeocodeEntityData createNetworkGeocodeEntityData() {
        return this.geocodeEntityDataFactory.createData2("network");
    }

    private final GeocodeEntityData createLocalGeocodeEntityData() {
        return this.geocodeEntityDataFactory.createData2("local");
    }

    private final GeocodeConfigEntityData createGeocodeConfigSplitEntityData() {
        return this.geocodeConfigEntityDataFactory.createData2("split");
    }

    private final GeocodeConfigEntityData createGeocodeConfigLocalEntityData() {
        return this.geocodeConfigEntityDataFactory.createData2("local");
    }
}
