package id.dana.data.services.repository;

import id.dana.analytics.firebase.Crashlytics;
import id.dana.danah5.DanaH5;
import id.dana.data.favoriteservice.mapper.FavoriteServicesResultMapper;
import id.dana.data.homeinfo.mapper.HomeInfoResultMapper;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import id.dana.data.services.repository.source.ServicesEntityData;
import id.dana.data.services.repository.source.ServicesEntityDataFactory;
import id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData;
import id.dana.data.services.repository.source.model.CategoryHighlightedFeature;
import id.dana.data.services.repository.source.model.CategoryServices;
import id.dana.data.services.repository.source.model.ServiceHighlighted;
import id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig;
import id.dana.data.userconfig.UserConfigBizTypeConstant;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.data.util.DateTimeUtil;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.model.CategoryServicesModel;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import id.dana.domain.userconfig.model.QueryConfig;
import id.dana.utils.jacoco.ExcludeFromJacocoGeneratedReport;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import j$.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Typography;

@Singleton
@Metadata(bv = {}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001B3\b\u0007\u0012\u0006\u0010e\u001a\u00020d\u0012\u0006\u0010h\u001a\u00020g\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010n\u001a\u00020m\u0012\u0006\u0010q\u001a\u00020p¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J'\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00030\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0002H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u000b\u001a\f\u0012\b\u0012\u0006*\u00020\n0\n0\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J1\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 J)\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00022\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0016¢\u0006\u0004\b\"\u0010\u001dJ\u001b\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00050\u0002H\u0016¢\u0006\u0004\b$\u0010\bJ%\u0010&\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00030\u0002¢\u0006\u0004\b&\u0010\bJ\u0019\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00050\u0002¢\u0006\u0004\b'\u0010\bJ!\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00022\u0006\u0010(\u001a\u00020\u0004¢\u0006\u0004\b)\u0010 J!\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00022\u0006\u0010(\u001a\u00020\u0004¢\u0006\u0004\b*\u0010 J\u001b\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b+\u0010 J\u001b\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u0002H\u0016¢\u0006\u0004\b,\u0010\bJ\u001b\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u0002H\u0016¢\u0006\u0004\b-\u0010\bJ\u001b\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00050\u0002H\u0016¢\u0006\u0004\b.\u0010\bJ)\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00022\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0016¢\u0006\u0004\b0\u0010\u001dJ)\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00022\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0016¢\u0006\u0004\b1\u0010\u001dJ\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\u0006\u00102\u001a\u00020\u000fH\u0016¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u0002062\u0006\u00105\u001a\u00020\u0012H\u0016¢\u0006\u0004\b7\u00108J\u0015\u00109\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0016¢\u0006\u0004\b9\u0010\bJ\u0011\u0010:\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b:\u0010\u0014J\u0015\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002H\u0016¢\u0006\u0004\b;\u0010\bJ\u0015\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002H\u0016¢\u0006\u0004\b<\u0010\bJ#\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0016¢\u0006\u0004\b>\u0010\u001dJ\u0015\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0016¢\u0006\u0004\b?\u0010\bJ)\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0016¢\u0006\u0004\b@\u0010\u001dJ)\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00050\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0016¢\u0006\u0004\bA\u0010\u001dJ\u0015\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0016¢\u0006\u0004\bB\u0010\bJ\u001b\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170C0\u0002H\u0016¢\u0006\u0004\bD\u0010\bJ=\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170C0\u00022\u0006\u0010F\u001a\u00020E2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020E0C2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020H0C¢\u0006\u0004\bJ\u0010KJO\u0010P\u001a\u0002062\u0006\u0010F\u001a\u00020E2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020H0C2\u0006\u0010M\u001a\u00020L2 \u0010O\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170C\u0012\u0006\u0012\u0004\u0018\u00010H\u0012\u0004\u0012\u0002060NH\u0007¢\u0006\u0004\bP\u0010QJ;\u0010U\u001a\u0002062\u0006\u0010F\u001a\u00020E2\b\b\u0002\u0010S\u001a\u00020R2\u0018\u0010O\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170C\u0012\u0004\u0012\u0002060TH\u0007¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u0002062\b\u0010W\u001a\u0004\u0018\u00010H¢\u0006\u0004\bX\u0010YJ\u0013\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002¢\u0006\u0004\bZ\u0010\bJ\u0015\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0016¢\u0006\u0004\b[\u0010\bJ\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\u0006\u0010\\\u001a\u00020\u0004H\u0016¢\u0006\u0004\b]\u0010 J\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\u0006\u0010\\\u001a\u00020\u0004H\u0016¢\u0006\u0004\b^\u0010 J/\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00022\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\u0006\u0010`\u001a\u00020\u0004¢\u0006\u0004\ba\u0010bJ'\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005¢\u0006\u0004\bc\u0010\u001dR\u0014\u0010e\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010h\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010k\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010n\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010q\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u00105\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010sR$\u0010t\u001a\u0004\u0018\u00010E8\u0001@\u0001X\u0080\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001b\u0010}\u001a\u00020\n8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010\rR1\u0010\u0081\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00030\u00028G¢\u0006\r\u0012\u0005\b\u007f\u0010\u0080\u0001\u001a\u0004\b~\u0010\b"}, d2 = {"Lid/dana/data/services/repository/ServicesEntityRepository;", "Lid/dana/domain/services/ServicesRepository;", "Lio/reactivex/Observable;", "", "", "", "Lid/dana/data/homeinfo/model/ThirdPartyEntity;", "getAllServicesDefault", "()Lio/reactivex/Observable;", "getAllListOfService", "Lid/dana/data/services/repository/source/ServicesEntityData;", "createServiceSource", "createDefaultServices", "()Lid/dana/data/services/repository/source/ServicesEntityData;", "favoriteServices", "", "serviceHaveBlank", "(Ljava/util/List;)Z", "Lid/dana/domain/services/model/ThirdPartyCategoryService;", "getSendMoneyService", "()Lid/dana/domain/services/model/ThirdPartyCategoryService;", "getTopupService", "serviceKeys", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "serviceResponses", "sortServicesWithGivenList", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", DanaH5.SERVICE_KEY, "getEnabledServicesByKey", "(Ljava/util/List;)Lio/reactivex/Observable;", "getServicesByKey", "getServiceByKey", "(Ljava/lang/String;)Lio/reactivex/Observable;", "serviceNames", "getServicesByName", "Lid/dana/domain/services/model/CategoryServicesModel;", "getAllCategories", "Lid/dana/data/services/repository/source/model/CategoryServices;", "getAllMapServices", "getAllSections", "categoryKey", "getListOfService", "getCategoriesByCategoryKey", "getServiceFromServiceKey", "getAllServices", "getAllDefaultServices", "getRawServices", "categoryKeys", "getServicesByCategoryKey", "getServicesByCategoryKeyDefault", "globalNetworkMode", "getFavoriteServicesCache", "(Z)Lio/reactivex/Observable;", "inMemoryFavoriteServiceCache", "", "setInMemoryFavoriteServiceCache", "(Lid/dana/domain/services/model/ThirdPartyCategoryService;)V", "resetInMemoryFavoriteServiceCache", "getInMemoryFavoriteServiceCache", "getFavoriteServices", "getFavoriteServiceFromRemoteSource", "services", "saveFavoriteServices", "clearCacheFavoriteServices", "getExploreServices", "getDefaultSkuExplore", "updateHighlightedService", "Lj$/util/Optional;", "getHighlightedService", "Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;", "split", "local", "Lid/dana/data/services/repository/source/model/ServiceHighlighted;", "highlightedOptional", "getHighlightedServiceOptional", "(Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;Lj$/util/Optional;Lj$/util/Optional;)Lio/reactivex/Observable;", "", "currentTimeMillis", "Lkotlin/Function2;", "onResult", "getNextEnableHighlightedService", "(Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;Lj$/util/Optional;JLkotlin/jvm/functions/Function2;)V", "", "currentIndex", "Lkotlin/Function1;", "getEnabledHighlightedService", "(Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;ILkotlin/jvm/functions/Function1;)V", "serviceHighlighted", "saveServiceHighlighted", "(Lid/dana/data/services/repository/source/model/ServiceHighlighted;)V", "getFavoriteServicesFromLocal", "resetInMemoryCategoryHighlightedFeature", "key", "isFeatureHighlightExist", "overwriteHighlightedService", "keywords", "filterBy", "getFilteredServices", "(Ljava/util/List;Ljava/lang/String;)Lio/reactivex/Observable;", "getCategoryFeaturedServices", "Lid/dana/data/services/repository/source/ServicesEntityDataFactory;", "servicesEntityDataFactory", "Lid/dana/data/services/repository/source/ServicesEntityDataFactory;", "Lid/dana/data/homeinfo/mapper/HomeInfoResultMapper;", "homeInfoResultMapper", "Lid/dana/data/homeinfo/mapper/HomeInfoResultMapper;", "Lid/dana/data/favoriteservice/mapper/FavoriteServicesResultMapper;", "favoriteServicesResultMapper", "Lid/dana/data/favoriteservice/mapper/FavoriteServicesResultMapper;", "Lid/dana/data/userconfig/repository/UserConfigEntityRepository;", "userConfigEntityRepository", "Lid/dana/data/userconfig/repository/UserConfigEntityRepository;", "Lid/dana/data/services/repository/source/local/PreferenceFavoriteServicesEntityData;", "preferenceFavoriteServicesEntityData", "Lid/dana/data/services/repository/source/local/PreferenceFavoriteServicesEntityData;", "Lid/dana/domain/services/model/ThirdPartyCategoryService;", "inMemoryCategoryHighlightedFeature", "Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;", "getInMemoryCategoryHighlightedFeature$data_productionRelease", "()Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;", "setInMemoryCategoryHighlightedFeature$data_productionRelease", "(Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;)V", "splitSourceServices$delegate", "Lkotlin/Lazy;", "getSplitSourceServices", "splitSourceServices", "getAllServicesWithDefaultValue", "getAllServicesWithDefaultValue$annotations", "()V", "allServicesWithDefaultValue", "<init>", "(Lid/dana/data/services/repository/source/ServicesEntityDataFactory;Lid/dana/data/homeinfo/mapper/HomeInfoResultMapper;Lid/dana/data/favoriteservice/mapper/FavoriteServicesResultMapper;Lid/dana/data/userconfig/repository/UserConfigEntityRepository;Lid/dana/data/services/repository/source/local/PreferenceFavoriteServicesEntityData;)V", "Companion"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class ServicesEntityRepository implements ServicesRepository {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int MyBillsEntityDataFactory = 1;
    private static int PlaceComponentResult = 0;
    public static final String SEND_MONEY = "send_money";
    public static final String SERVICE_GAMES = "service_games";
    public static final String TOPUP = "topup";
    private static char[] getAuthRequestContext;
    private final FavoriteServicesResultMapper favoriteServicesResultMapper;
    private final HomeInfoResultMapper homeInfoResultMapper;
    private CategoryHighlightedFeature inMemoryCategoryHighlightedFeature;
    private ThirdPartyCategoryService inMemoryFavoriteServiceCache;
    private final PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData;
    private final ServicesEntityDataFactory servicesEntityDataFactory;

    /* renamed from: splitSourceServices$delegate  reason: from kotlin metadata */
    private final Lazy splitSourceServices;
    private final UserConfigEntityRepository userConfigEntityRepository;

    /* renamed from: $r8$lambda$-F67DDmL60YFkKVcfb8cGdAZPEQ  reason: not valid java name */
    public static /* synthetic */ ObservableSource m1940$r8$lambda$F67DDmL60YFkKVcfb8cGdAZPEQ(ServicesEntityRepository servicesEntityRepository, String str) {
        ObservableSource m1965getCategoriesByCategoryKey$lambda15;
        int i = PlaceComponentResult + 35;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? '1' : '0') != '0') {
            try {
                m1965getCategoriesByCategoryKey$lambda15 = m1965getCategoriesByCategoryKey$lambda15(servicesEntityRepository, str);
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            m1965getCategoriesByCategoryKey$lambda15 = m1965getCategoriesByCategoryKey$lambda15(servicesEntityRepository, str);
        }
        try {
            int i2 = PlaceComponentResult + 61;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            return m1965getCategoriesByCategoryKey$lambda15;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$4LJKP-QWzEXinnM3X67FHFy8Fh8  reason: not valid java name */
    public static /* synthetic */ void m1941$r8$lambda$4LJKPQWzEXinnM3X67FHFy8Fh8(Optional optional, CategoryHighlightedFeature categoryHighlightedFeature, Optional optional2, ServicesEntityRepository servicesEntityRepository, long j, ObservableEmitter observableEmitter) {
        int i = MyBillsEntityDataFactory + 49;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? '+' : 'M';
        Object[] objArr = null;
        m1983getHighlightedServiceOptional$lambda50$lambda49(optional, categoryHighlightedFeature, optional2, servicesEntityRepository, j, observableEmitter);
        if (c == '+') {
            int length = objArr.length;
        }
        int i2 = MyBillsEntityDataFactory + 15;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 23 : 'S') != 'S') {
            objArr.hashCode();
        }
    }

    /* renamed from: $r8$lambda$8NVIklvS3HYlQ61BBMDsY2g-dJA  reason: not valid java name */
    public static /* synthetic */ List m1942$r8$lambda$8NVIklvS3HYlQ61BBMDsY2gdJA(ServicesEntityRepository servicesEntityRepository, Map map) {
        int i = PlaceComponentResult + 93;
        MyBillsEntityDataFactory = i % 128;
        char c = i % 2 == 0 ? 'C' : 'I';
        List m1964getAllServices$lambda19 = m1964getAllServices$lambda19(servicesEntityRepository, map);
        if (c == 'C') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return m1964getAllServices$lambda19;
    }

    public static /* synthetic */ boolean $r8$lambda$A6cRiLn5Z0y8aCoKF5OgBjURSPE(List list) {
        try {
            int i = MyBillsEntityDataFactory + 71;
            try {
                PlaceComponentResult = i % 128;
                char c = i % 2 != 0 ? '_' : (char) 22;
                boolean m1963getAllSections$lambda9 = m1963getAllSections$lambda9(list);
                if (c == '_') {
                    int i2 = 65 / 0;
                }
                return m1963getAllSections$lambda9;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$B0cqEhHTNwkHpcMk302ShJ9S62w(ServicesEntityRepository servicesEntityRepository, Pair pair) {
        int i = MyBillsEntityDataFactory + 71;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            ObservableSource m1979getHighlightedService$lambda47 = m1979getHighlightedService$lambda47(servicesEntityRepository, pair);
            int i3 = PlaceComponentResult + 45;
            MyBillsEntityDataFactory = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return m1979getHighlightedService$lambda47;
            }
            Object obj = null;
            obj.hashCode();
            return m1979getHighlightedService$lambda47;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$DEJLZJVlI889bt-IdfQd2IJrWgs  reason: not valid java name */
    public static /* synthetic */ List m1943$r8$lambda$DEJLZJVlI889btIdfQd2IJrWgs(List list) {
        int i = PlaceComponentResult + 81;
        MyBillsEntityDataFactory = i % 128;
        boolean z = i % 2 == 0;
        Object[] objArr = null;
        List m1958getAllCategories$lambda5 = m1958getAllCategories$lambda5(list);
        if (z) {
            int length = objArr.length;
        }
        int i2 = MyBillsEntityDataFactory + 97;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 != 0 ? '#' : '?') != '?') {
            int length2 = objArr.length;
            return m1958getAllCategories$lambda5;
        }
        return m1958getAllCategories$lambda5;
    }

    /* renamed from: $r8$lambda$JTvFuIzG_NdHl-Sc-9_AEJfiY3o  reason: not valid java name */
    public static /* synthetic */ ObservableSource m1944$r8$lambda$JTvFuIzG_NdHlSc9_AEJfiY3o(ServicesEntityRepository servicesEntityRepository, List list) {
        int i = MyBillsEntityDataFactory + 3;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? (char) 14 : 'U';
        ObservableSource m1966getCategoryFeaturedServices$lambda75 = m1966getCategoryFeaturedServices$lambda75(servicesEntityRepository, list);
        if (c == 14) {
            int i2 = 55 / 0;
        }
        int i3 = PlaceComponentResult + 31;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return m1966getCategoryFeaturedServices$lambda75;
    }

    /* renamed from: $r8$lambda$MBVME9-WlCooSEYQmu1APHoXtwo  reason: not valid java name */
    public static /* synthetic */ Pair m1945$r8$lambda$MBVME9WlCooSEYQmu1APHoXtwo(CategoryHighlightedFeature categoryHighlightedFeature, Optional optional) {
        try {
            int i = MyBillsEntityDataFactory + 29;
            PlaceComponentResult = i % 128;
            char c = i % 2 != 0 ? 'V' : '(';
            Pair m1978getHighlightedService$lambda45 = m1978getHighlightedService$lambda45(categoryHighlightedFeature, optional);
            if (c == 'V') {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = MyBillsEntityDataFactory + 75;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            return m1978getHighlightedService$lambda45;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$O4W0yMjw7xAxezT3P3NGtsJtPOU(ServicesEntityRepository servicesEntityRepository, List list) {
        int i = PlaceComponentResult + 113;
        MyBillsEntityDataFactory = i % 128;
        char c = i % 2 == 0 ? 'b' : 'H';
        ObservableSource m1973getFavoriteServicesFromLocal$lambda58 = m1973getFavoriteServicesFromLocal$lambda58(servicesEntityRepository, list);
        if (c != 'H') {
            int i2 = 67 / 0;
        }
        return m1973getFavoriteServicesFromLocal$lambda58;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$PQ9hTDq2twoHjaD4neBTAJQT9_4(String str, ServicesEntityData servicesEntityData) {
        int i = MyBillsEntityDataFactory + 81;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? '\b' : 'F';
        ObservableSource m1987getServiceByKey$lambda2 = m1987getServiceByKey$lambda2(str, servicesEntityData);
        if (c == '\b') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = PlaceComponentResult + 37;
        MyBillsEntityDataFactory = i2 % 128;
        if ((i2 % 2 == 0 ? 'L' : 'C') != 'L') {
            return m1987getServiceByKey$lambda2;
        }
        int i3 = 84 / 0;
        return m1987getServiceByKey$lambda2;
    }

    /* renamed from: $r8$lambda$QHeN-L0323uyTavsXLnx9czdSGY  reason: not valid java name */
    public static /* synthetic */ ObservableSource m1946$r8$lambda$QHeNL0323uyTavsXLnx9czdSGY(ServicesEntityRepository servicesEntityRepository, String[] strArr, List list) {
        int i = MyBillsEntityDataFactory + 59;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ObservableSource m1971getFavoriteServiceFromRemoteSource$lambda33$lambda32 = m1971getFavoriteServiceFromRemoteSource$lambda33$lambda32(servicesEntityRepository, strArr, list);
        int i3 = MyBillsEntityDataFactory + 113;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return m1971getFavoriteServiceFromRemoteSource$lambda33$lambda32;
    }

    public static /* synthetic */ List $r8$lambda$VJ9qrtW7wU3sO0h1j6KcJw5iTWc(List list, ServicesEntityRepository servicesEntityRepository, Map map) {
        int i = MyBillsEntityDataFactory + 59;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            List m1992getServicesByCategoryKeyDefault$lambda31 = m1992getServicesByCategoryKeyDefault$lambda31(list, servicesEntityRepository, map);
            int i3 = MyBillsEntityDataFactory + 83;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return m1992getServicesByCategoryKeyDefault$lambda31;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$WH0sPo9kogE9xU3DJOvMSIChQJc(Optional optional, CategoryHighlightedFeature categoryHighlightedFeature, Optional optional2, ServicesEntityRepository servicesEntityRepository) {
        int i = PlaceComponentResult + 59;
        MyBillsEntityDataFactory = i % 128;
        boolean z = i % 2 != 0;
        ObservableSource m1982getHighlightedServiceOptional$lambda50 = m1982getHighlightedServiceOptional$lambda50(optional, categoryHighlightedFeature, optional2, servicesEntityRepository);
        if (!z) {
            int i2 = 73 / 0;
        }
        try {
            int i3 = MyBillsEntityDataFactory + 45;
            try {
                PlaceComponentResult = i3 % 128;
                if ((i3 % 2 != 0 ? '2' : '%') != '%') {
                    int i4 = 5 / 0;
                    return m1982getHighlightedServiceOptional$lambda50;
                }
                return m1982getHighlightedServiceOptional$lambda50;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ Triple $r8$lambda$WlKov1eEAxjmDbVDEobKsIyV3FA(Pair pair, Optional optional, CategoryHighlightedFeature categoryHighlightedFeature) {
        int i = PlaceComponentResult + 35;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            Triple m1980getHighlightedService$lambda47$lambda46 = m1980getHighlightedService$lambda47$lambda46(pair, optional, categoryHighlightedFeature);
            try {
                int i3 = PlaceComponentResult + 9;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return m1980getHighlightedService$lambda47$lambda46;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$XqgoWikK8aowXzulxvTjzTi4a6s(ServicesEntityRepository servicesEntityRepository, List list, List list2) {
        int i = MyBillsEntityDataFactory + 15;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 != 0;
        ObservableSource m1974getFavoriteServicesFromLocal$lambda58$lambda57 = m1974getFavoriteServicesFromLocal$lambda58$lambda57(servicesEntityRepository, list, list2);
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = MyBillsEntityDataFactory + 117;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return m1974getFavoriteServicesFromLocal$lambda58$lambda57;
    }

    /* renamed from: $r8$lambda$YbsW_1y3nNrV213UQsneQ-TzpJE  reason: not valid java name */
    public static /* synthetic */ List m1947$r8$lambda$YbsW_1y3nNrV213UQsneQTzpJE(ServicesEntityRepository servicesEntityRepository, Map map) {
        int i = MyBillsEntityDataFactory + 117;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        List m1959getAllDefaultServices$lambda22 = m1959getAllDefaultServices$lambda22(servicesEntityRepository, map);
        int i3 = PlaceComponentResult + 33;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return m1959getAllDefaultServices$lambda22;
    }

    public static /* synthetic */ Boolean $r8$lambda$Zj6LKdFhedaUUwYVrjeqGRclaIA(ServiceHighlighted serviceHighlighted) {
        int i = MyBillsEntityDataFactory + 119;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 == 0;
        Boolean m1995overwriteHighlightedService$lambda63$lambda62 = m1995overwriteHighlightedService$lambda63$lambda62(serviceHighlighted);
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return m1995overwriteHighlightedService$lambda63$lambda62;
    }

    public static /* synthetic */ Boolean $r8$lambda$_fsUwJN2uDdKRowbCwtjKeGguy4(ServiceHighlighted serviceHighlighted) {
        int i = PlaceComponentResult + 75;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            Boolean m1997updateHighlightedService$lambda43$lambda42 = m1997updateHighlightedService$lambda43$lambda42(serviceHighlighted);
            int i3 = MyBillsEntityDataFactory + 115;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 == 0) {
                return m1997updateHighlightedService$lambda43$lambda42;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return m1997updateHighlightedService$lambda43$lambda42;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$d6xXZ_XJdVLcViL_ETbiujOn9RQ(String str, CategoryHighlightedFeature categoryHighlightedFeature) {
        ObservableSource m1993isFeatureHighlightExist$lambda61$lambda60;
        int i = MyBillsEntityDataFactory + 115;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            try {
                m1993isFeatureHighlightExist$lambda61$lambda60 = m1993isFeatureHighlightExist$lambda61$lambda60(str, categoryHighlightedFeature);
            } catch (Exception e) {
                throw e;
            }
        } else {
            try {
                m1993isFeatureHighlightExist$lambda61$lambda60 = m1993isFeatureHighlightExist$lambda61$lambda60(str, categoryHighlightedFeature);
                int i2 = 31 / 0;
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = PlaceComponentResult + 103;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 == 0 ? 'c' : (char) 11) != 11) {
            Object[] objArr = null;
            int length = objArr.length;
            return m1993isFeatureHighlightExist$lambda61$lambda60;
        }
        return m1993isFeatureHighlightExist$lambda61$lambda60;
    }

    /* renamed from: $r8$lambda$deDx-gAK3eXosdOHiW8O6d0kmaM  reason: not valid java name */
    public static /* synthetic */ List m1948$r8$lambda$deDxgAK3eXosdOHiW8O6d0kmaM(ServicesEntityRepository servicesEntityRepository, List list, List list2) {
        List m1967getDefaultSkuExplore$lambda41;
        int i = PlaceComponentResult + 33;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            m1967getDefaultSkuExplore$lambda41 = m1967getDefaultSkuExplore$lambda41(servicesEntityRepository, list, list2);
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            try {
                m1967getDefaultSkuExplore$lambda41 = m1967getDefaultSkuExplore$lambda41(servicesEntityRepository, list, list2);
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i2 = PlaceComponentResult + 35;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            return m1967getDefaultSkuExplore$lambda41;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$eXl-fKQiNk-DeHgMzEfH0C59kwA  reason: not valid java name */
    public static /* synthetic */ ThirdPartyServiceResponse m1949$r8$lambda$eXlfKQiNkDeHgMzEfH0C59kwA(ServicesEntityRepository servicesEntityRepository, ThirdPartyEntity thirdPartyEntity) {
        int i = MyBillsEntityDataFactory + 105;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ThirdPartyServiceResponse m1988getServiceByKey$lambda3 = m1988getServiceByKey$lambda3(servicesEntityRepository, thirdPartyEntity);
        int i3 = PlaceComponentResult + 101;
        MyBillsEntityDataFactory = i3 % 128;
        if (i3 % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return m1988getServiceByKey$lambda3;
        }
        return m1988getServiceByKey$lambda3;
    }

    public static /* synthetic */ List $r8$lambda$fiaMYE1aYsgH6V9t6M5lJPycFgo(ServicesEntityRepository servicesEntityRepository, List list) {
        int i = PlaceComponentResult + 95;
        MyBillsEntityDataFactory = i % 128;
        boolean z = i % 2 != 0;
        Object[] objArr = null;
        List m1984getListOfService$lambda14 = m1984getListOfService$lambda14(servicesEntityRepository, list);
        if (!z) {
            int length = objArr.length;
        }
        int i2 = PlaceComponentResult + 1;
        MyBillsEntityDataFactory = i2 % 128;
        if (i2 % 2 != 0) {
            return m1984getListOfService$lambda14;
        }
        int length2 = objArr.length;
        return m1984getListOfService$lambda14;
    }

    public static /* synthetic */ List $r8$lambda$gy4nEjhb_FPI4Kg_hR875W35BTU(ServicesEntityRepository servicesEntityRepository, Map map) {
        int i = PlaceComponentResult + 15;
        MyBillsEntityDataFactory = i % 128;
        boolean z = i % 2 == 0;
        List m1976getFilteredServices$lambda73 = m1976getFilteredServices$lambda73(servicesEntityRepository, map);
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = PlaceComponentResult + 33;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        return m1976getFilteredServices$lambda73;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$h0x4zWbXuprG9ciDz8LCyrIluPA(ServicesEntityRepository servicesEntityRepository, Optional optional) {
        int i = PlaceComponentResult + 119;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            ObservableSource m1996updateHighlightedService$lambda43 = m1996updateHighlightedService$lambda43(servicesEntityRepository, optional);
            int i3 = PlaceComponentResult + 11;
            MyBillsEntityDataFactory = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 7 : '?') != '?') {
                Object obj = null;
                obj.hashCode();
                return m1996updateHighlightedService$lambda43;
            }
            return m1996updateHighlightedService$lambda43;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$jcgm-_hsAq_b59Jzg7mDjRUuEdM  reason: not valid java name */
    public static /* synthetic */ ObservableSource m1950$r8$lambda$jcgm_hsAq_b59Jzg7mDjRUuEdM(List list) {
        int i = MyBillsEntityDataFactory + 53;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ObservableSource m1962getAllSections$lambda11 = m1962getAllSections$lambda11(list);
        int i3 = MyBillsEntityDataFactory + 23;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 24 / 0;
            return m1962getAllSections$lambda11;
        }
        return m1962getAllSections$lambda11;
    }

    /* renamed from: $r8$lambda$jx-vNXqSbGgwuVu_-44_WcODbxg  reason: not valid java name */
    public static /* synthetic */ ObservableSource m1951$r8$lambda$jxvNXqSbGgwuVu_44_WcODbxg(ServicesEntityRepository servicesEntityRepository, Triple triple) {
        int i = MyBillsEntityDataFactory + 115;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ObservableSource m1981getHighlightedService$lambda48 = m1981getHighlightedService$lambda48(servicesEntityRepository, triple);
        int i3 = PlaceComponentResult + 19;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 34 / 0;
            return m1981getHighlightedService$lambda48;
        }
        return m1981getHighlightedService$lambda48;
    }

    public static /* synthetic */ Pair $r8$lambda$lNErFQ0KcF4C2KczRvgDQWeOe2o(CategoryHighlightedFeature categoryHighlightedFeature, Optional optional) {
        int i = PlaceComponentResult + 99;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Pair m1977getHighlightedService$lambda44 = m1977getHighlightedService$lambda44(categoryHighlightedFeature, optional);
        int i3 = MyBillsEntityDataFactory + 107;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return m1977getHighlightedService$lambda44;
    }

    public static /* synthetic */ List $r8$lambda$lOuZh_oIe0tTrcpQDtCa1TSvXFU(List list) {
        int i = PlaceComponentResult + 11;
        MyBillsEntityDataFactory = i % 128;
        char c = i % 2 == 0 ? Typography.greater : '.';
        List m1968getEnabledServicesByKey$lambda1 = m1968getEnabledServicesByKey$lambda1(list);
        if (c == '>') {
            Object obj = null;
            obj.hashCode();
        }
        return m1968getEnabledServicesByKey$lambda1;
    }

    /* renamed from: $r8$lambda$lPR2MvzYEzxgRdzOS87-EAdih8s  reason: not valid java name */
    public static /* synthetic */ List m1952$r8$lambda$lPR2MvzYEzxgRdzOS87EAdih8s(ServicesEntityRepository servicesEntityRepository, Pair pair) {
        int i = PlaceComponentResult + 85;
        MyBillsEntityDataFactory = i % 128;
        char c = i % 2 == 0 ? (char) 19 : '@';
        List m1991getServicesByCategoryKey$lambda27 = m1991getServicesByCategoryKey$lambda27(servicesEntityRepository, pair);
        if (c == 19) {
            Object obj = null;
            obj.hashCode();
        }
        return m1991getServicesByCategoryKey$lambda27;
    }

    public static /* synthetic */ void $r8$lambda$lh10A99e0NPpEwgytSijJ1J0QyU(ServicesEntityRepository servicesEntityRepository, ThirdPartyCategoryService thirdPartyCategoryService) {
        int i = MyBillsEntityDataFactory + 65;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            try {
                m1972getFavoriteServiceFromRemoteSource$lambda34(servicesEntityRepository, thirdPartyCategoryService);
                int i2 = 53 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            m1972getFavoriteServiceFromRemoteSource$lambda34(servicesEntityRepository, thirdPartyCategoryService);
        }
        int i3 = PlaceComponentResult + 63;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static /* synthetic */ List $r8$lambda$nBZ642g0DQagRTJTejKt50MRc5o(ServicesEntityRepository servicesEntityRepository, List list) {
        int i = MyBillsEntityDataFactory + 109;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            List m1986getRawServices$lambda25 = m1986getRawServices$lambda25(servicesEntityRepository, list);
            int i3 = MyBillsEntityDataFactory + 37;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return m1986getRawServices$lambda25;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ Map $r8$lambda$nuvouN9NspO0BIukTts422v7954(ServicesEntityRepository servicesEntityRepository, List list) {
        try {
            int i = MyBillsEntityDataFactory + 55;
            PlaceComponentResult = i % 128;
            char c = i % 2 != 0 ? '*' : 'W';
            Map m1961getAllMapServices$lambda8 = m1961getAllMapServices$lambda8(servicesEntityRepository, list);
            if (c != 'W') {
                int i2 = 27 / 0;
            }
            int i3 = MyBillsEntityDataFactory + 31;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return m1961getAllMapServices$lambda8;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$r01_h6pVzLE5qPSpQ1eeSst8uZk(ServicesEntityRepository servicesEntityRepository, String[] strArr) {
        ObservableSource m1970getFavoriteServiceFromRemoteSource$lambda33;
        int i = PlaceComponentResult + 57;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? '[' : (char) 27) != '[') {
            try {
                m1970getFavoriteServiceFromRemoteSource$lambda33 = m1970getFavoriteServiceFromRemoteSource$lambda33(servicesEntityRepository, strArr);
            } catch (Exception e) {
                throw e;
            }
        } else {
            m1970getFavoriteServiceFromRemoteSource$lambda33 = m1970getFavoriteServiceFromRemoteSource$lambda33(servicesEntityRepository, strArr);
            int i2 = 70 / 0;
        }
        int i3 = MyBillsEntityDataFactory + 123;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return m1970getFavoriteServiceFromRemoteSource$lambda33;
    }

    public static /* synthetic */ List $r8$lambda$sKHWcE6RHOzugQF5bQ1oHVExxq8(ServicesEntityRepository servicesEntityRepository, List list) {
        try {
            int i = PlaceComponentResult + 85;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            List m1960getAllListOfService$lambda13 = m1960getAllListOfService$lambda13(servicesEntityRepository, list);
            int i3 = PlaceComponentResult + 17;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return m1960getAllListOfService$lambda13;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$sLQabbjQD2_Td3Ffd9-BNUxux3E  reason: not valid java name */
    public static /* synthetic */ void m1953$r8$lambda$sLQabbjQD2_Td3Ffd9BNUxux3E(Throwable th) {
        int i = MyBillsEntityDataFactory + 47;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        m1957_get_allServicesWithDefaultValue_$lambda64(th);
        try {
            int i3 = PlaceComponentResult + 79;
            MyBillsEntityDataFactory = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ List $r8$lambda$t0_ILXzvMlQpA3TB4e_zjPltrfc(List list, ServicesEntityRepository servicesEntityRepository, List list2) {
        int i = PlaceComponentResult + 5;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        List m1969getExploreServices$lambda36 = m1969getExploreServices$lambda36(list, servicesEntityRepository, list2);
        try {
            int i3 = PlaceComponentResult + 45;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return m1969getExploreServices$lambda36;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$uJsiaetiqKRR-jJJ00RuKkTUOpY  reason: not valid java name */
    public static /* synthetic */ ObservableSource m1954$r8$lambda$uJsiaetiqKRRjJJ00RuKkTUOpY(String str, ServicesEntityRepository servicesEntityRepository, Optional optional) {
        try {
            int i = PlaceComponentResult + 1;
            MyBillsEntityDataFactory = i % 128;
            boolean z = i % 2 == 0;
            ObservableSource m1994overwriteHighlightedService$lambda63 = m1994overwriteHighlightedService$lambda63(str, servicesEntityRepository, optional);
            if (z) {
                Object obj = null;
                obj.hashCode();
            }
            int i2 = MyBillsEntityDataFactory + 21;
            PlaceComponentResult = i2 % 128;
            if (i2 % 2 == 0) {
                return m1994overwriteHighlightedService$lambda63;
            }
            int i3 = 92 / 0;
            return m1994overwriteHighlightedService$lambda63;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ Pair $r8$lambda$vzJCDFTmFbJ0bAgtzXrenE35G3M(List list, List list2) {
        try {
            int i = MyBillsEntityDataFactory + 125;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            Pair m1990getServicesByCategoryKey$lambda26 = m1990getServicesByCategoryKey$lambda26(list, list2);
            int i3 = MyBillsEntityDataFactory + 17;
            PlaceComponentResult = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return m1990getServicesByCategoryKey$lambda26;
            }
            Object obj = null;
            obj.hashCode();
            return m1990getServicesByCategoryKey$lambda26;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$zt6UiwiJ2XV1GeAY6gbp--hgCSU  reason: not valid java name */
    public static /* synthetic */ Map m1955$r8$lambda$zt6UiwiJ2XV1GeAY6gbphgCSU(String str, List list, Map map) {
        Map m1975getFilteredServices$lambda70;
        int i = PlaceComponentResult + 69;
        MyBillsEntityDataFactory = i % 128;
        try {
            if (!(i % 2 == 0)) {
                m1975getFilteredServices$lambda70 = m1975getFilteredServices$lambda70(str, list, map);
            } else {
                m1975getFilteredServices$lambda70 = m1975getFilteredServices$lambda70(str, list, map);
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = PlaceComponentResult + 9;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            return m1975getFilteredServices$lambda70;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$zxxt_XIF7EZs9S2NkLhfznlODsE(Throwable th) {
        int i = MyBillsEntityDataFactory + 117;
        PlaceComponentResult = i % 128;
        if (!(i % 2 != 0)) {
            m1985getRawServices$lambda23(th);
            return;
        }
        try {
            m1985getRawServices$lambda23(th);
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$zz739WFhBxI9qGm-aa8P-2EqOjU  reason: not valid java name */
    public static /* synthetic */ ObservableSource m1956$r8$lambda$zz739WFhBxI9qGmaa8P2EqOjU(ServicesEntityRepository servicesEntityRepository, String str) {
        int i = PlaceComponentResult + 97;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            ObservableSource m1989getServiceFromServiceKey$lambda16 = m1989getServiceFromServiceKey$lambda16(servicesEntityRepository, str);
            int i3 = PlaceComponentResult + 41;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return m1989getServiceFromServiceKey$lambda16;
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
        int i = MyBillsEntityDataFactory + 35;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    public static /* synthetic */ void getAllServicesWithDefaultValue$annotations() {
        int i = MyBillsEntityDataFactory + 121;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? ',' : '@') != ',') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    static void getAuthRequestContext() {
        getAuthRequestContext = new char[]{35552, 35424, 35424, 35429, 35427};
    }

    @Inject
    public ServicesEntityRepository(ServicesEntityDataFactory servicesEntityDataFactory, HomeInfoResultMapper homeInfoResultMapper, FavoriteServicesResultMapper favoriteServicesResultMapper, UserConfigEntityRepository userConfigEntityRepository, PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData) {
        Intrinsics.checkNotNullParameter(servicesEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(homeInfoResultMapper, "");
        Intrinsics.checkNotNullParameter(favoriteServicesResultMapper, "");
        Intrinsics.checkNotNullParameter(userConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(preferenceFavoriteServicesEntityData, "");
        this.servicesEntityDataFactory = servicesEntityDataFactory;
        this.homeInfoResultMapper = homeInfoResultMapper;
        this.favoriteServicesResultMapper = favoriteServicesResultMapper;
        this.userConfigEntityRepository = userConfigEntityRepository;
        this.preferenceFavoriteServicesEntityData = preferenceFavoriteServicesEntityData;
        this.splitSourceServices = LazyKt.lazy(new Function0<ServicesEntityData>() { // from class: id.dana.data.services.repository.ServicesEntityRepository$splitSourceServices$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ServicesEntityData invoke() {
                return ServicesEntityRepository.access$getServicesEntityDataFactory$p(ServicesEntityRepository.this).createData2("split");
            }
        });
    }

    public static final /* synthetic */ HomeInfoResultMapper access$getHomeInfoResultMapper$p(ServicesEntityRepository servicesEntityRepository) {
        int i = MyBillsEntityDataFactory + 103;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            HomeInfoResultMapper homeInfoResultMapper = servicesEntityRepository.homeInfoResultMapper;
            Object[] objArr = null;
            int length = objArr.length;
            return homeInfoResultMapper;
        }
        return servicesEntityRepository.homeInfoResultMapper;
    }

    public static final /* synthetic */ ServicesEntityDataFactory access$getServicesEntityDataFactory$p(ServicesEntityRepository servicesEntityRepository) {
        int i = PlaceComponentResult + 73;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            ServicesEntityDataFactory servicesEntityDataFactory = servicesEntityRepository.servicesEntityDataFactory;
            int i3 = MyBillsEntityDataFactory + 65;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return servicesEntityDataFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getInMemoryCategoryHighlightedFeature$data_productionRelease")
    public final CategoryHighlightedFeature getInMemoryCategoryHighlightedFeature$data_productionRelease() {
        int i = MyBillsEntityDataFactory + 57;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            CategoryHighlightedFeature categoryHighlightedFeature = this.inMemoryCategoryHighlightedFeature;
            Object obj = null;
            obj.hashCode();
            return categoryHighlightedFeature;
        }
        return this.inMemoryCategoryHighlightedFeature;
    }

    @JvmName(name = "setInMemoryCategoryHighlightedFeature$data_productionRelease")
    public final void setInMemoryCategoryHighlightedFeature$data_productionRelease(CategoryHighlightedFeature categoryHighlightedFeature) {
        int i = MyBillsEntityDataFactory + 93;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? ';' : (char) 18) != ';') {
            try {
                this.inMemoryCategoryHighlightedFeature = categoryHighlightedFeature;
            } catch (Exception e) {
                throw e;
            }
        } else {
            try {
                this.inMemoryCategoryHighlightedFeature = categoryHighlightedFeature;
                Object obj = null;
                obj.hashCode();
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i2 = MyBillsEntityDataFactory + 113;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<List<ThirdPartyCategoryService>> getEnabledServicesByKey(List<String> serviceKey) {
        Intrinsics.checkNotNullParameter(serviceKey, "");
        Observable map = getFilteredServices(serviceKey, "key").map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.$r8$lambda$lOuZh_oIe0tTrcpQDtCa1TSvXFU((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = MyBillsEntityDataFactory + 85;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return map;
    }

    /* renamed from: getEnabledServicesByKey$lambda-1  reason: not valid java name */
    private static final List m1968getEnabledServicesByKey$lambda1(List list) {
        Object next;
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            try {
                if (!it.hasNext()) {
                    break;
                }
                int i = PlaceComponentResult + 21;
                try {
                    MyBillsEntityDataFactory = i % 128;
                    if ((i % 2 == 0 ? 'I' : '\'') != 'I') {
                        next = it.next();
                        List<ThirdPartyServiceResponse> thirdPartyServices = ((ThirdPartyCategoryService) next).getThirdPartyServices();
                        Intrinsics.checkNotNullExpressionValue(thirdPartyServices, "");
                        if ((((ThirdPartyServiceResponse) CollectionsKt.first((List) thirdPartyServices)).isEnable() ? 'H' : 'K') != 'K') {
                            int i2 = MyBillsEntityDataFactory + 103;
                            PlaceComponentResult = i2 % 128;
                            int i3 = i2 % 2;
                            arrayList.add(next);
                        }
                    } else {
                        next = it.next();
                        List<ThirdPartyServiceResponse> thirdPartyServices2 = ((ThirdPartyCategoryService) next).getThirdPartyServices();
                        Intrinsics.checkNotNullExpressionValue(thirdPartyServices2, "");
                        boolean isEnable = ((ThirdPartyServiceResponse) CollectionsKt.first((List) thirdPartyServices2)).isEnable();
                        Object[] objArr = null;
                        int length = objArr.length;
                        if (isEnable) {
                            int i22 = MyBillsEntityDataFactory + 103;
                            PlaceComponentResult = i22 % 128;
                            int i32 = i22 % 2;
                            arrayList.add(next);
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        ArrayList arrayList2 = arrayList;
        int i4 = MyBillsEntityDataFactory + 55;
        PlaceComponentResult = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 24 / 0;
            return arrayList2;
        }
        return arrayList2;
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<List<ThirdPartyCategoryService>> getServicesByKey(List<String> serviceKey) {
        int i = MyBillsEntityDataFactory + 13;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(serviceKey, "");
        Observable<List<ThirdPartyCategoryService>> filteredServices = getFilteredServices(serviceKey, "key");
        try {
            int i3 = PlaceComponentResult + 113;
            try {
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return filteredServices;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<ThirdPartyServiceResponse> getServiceByKey(final String serviceKey) {
        Intrinsics.checkNotNullParameter(serviceKey, "");
        Observable<ThirdPartyServiceResponse> map = createServiceSource().flatMap(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.$r8$lambda$PQ9hTDq2twoHjaD4neBTAJQT9_4(serviceKey, (ServicesEntityData) obj);
            }
        }).onErrorResumeNext(createDefaultServices().getService(serviceKey)).map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.m1949$r8$lambda$eXlfKQiNkDeHgMzEfH0C59kwA(ServicesEntityRepository.this, (ThirdPartyEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = PlaceComponentResult + 73;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return map;
    }

    /* renamed from: getServiceByKey$lambda-2  reason: not valid java name */
    private static final ObservableSource m1987getServiceByKey$lambda2(String str, ServicesEntityData servicesEntityData) {
        Observable<ThirdPartyEntity> service;
        try {
            int i = PlaceComponentResult + 59;
            MyBillsEntityDataFactory = i % 128;
            if (!(i % 2 == 0)) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(servicesEntityData, "");
                service = servicesEntityData.getService(str);
            } else {
                try {
                    Intrinsics.checkNotNullParameter(str, "");
                    Intrinsics.checkNotNullParameter(servicesEntityData, "");
                    service = servicesEntityData.getService(str);
                    int i2 = 88 / 0;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = PlaceComponentResult + 59;
            MyBillsEntityDataFactory = i3 % 128;
            if (i3 % 2 != 0) {
                return service;
            }
            Object obj = null;
            obj.hashCode();
            return service;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: getServiceByKey$lambda-3  reason: not valid java name */
    private static final ThirdPartyServiceResponse m1988getServiceByKey$lambda3(ServicesEntityRepository servicesEntityRepository, ThirdPartyEntity thirdPartyEntity) {
        try {
            int i = MyBillsEntityDataFactory + 61;
            try {
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
                Intrinsics.checkNotNullParameter(thirdPartyEntity, "");
                ThirdPartyServiceResponse transform = servicesEntityRepository.homeInfoResultMapper.transform(thirdPartyEntity);
                int i3 = PlaceComponentResult + 51;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return transform;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0020
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // id.dana.domain.services.ServicesRepository
    public final io.reactivex.Observable<java.util.List<id.dana.domain.services.model.ThirdPartyCategoryService>> getServicesByName(java.util.List<java.lang.String> r3) {
        /*
            r2 = this;
            int r0 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult     // Catch: java.lang.Exception -> L22
            int r0 = r0 + 61
            int r1 = r0 % 128
            id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch: java.lang.Exception -> L22
            java.lang.String r0 = "name"
            io.reactivex.Observable r3 = r2.getFilteredServices(r3, r0)     // Catch: java.lang.Exception -> L22
            int r0 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            return r3
        L20:
            r3 = move-exception
            throw r3
        L22:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.getServicesByName(java.util.List):io.reactivex.Observable");
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<List<CategoryServicesModel>> getAllCategories() {
        Observable map = getSplitSourceServices().getSections().onErrorResumeNext(createDefaultServices().getSections()).onErrorResumeNext(Observable.just(CollectionsKt.emptyList())).map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda28
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.m1943$r8$lambda$DEJLZJVlI889btIdfQd2IJrWgs((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        try {
            int i = PlaceComponentResult + 93;
            MyBillsEntityDataFactory = i % 128;
            if (!(i % 2 == 0)) {
                return map;
            }
            int i2 = 51 / 0;
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getAllCategories$lambda-5  reason: not valid java name */
    private static final List m1958getAllCategories$lambda5(List list) {
        try {
            Intrinsics.checkNotNullParameter(list, "");
            List<CategoryServices> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (CategoryServices categoryServices : list2) {
                arrayList.add(new CategoryServicesModel(categoryServices.getCategory(), categoryServices.getEn(), categoryServices.getId()));
                int i = MyBillsEntityDataFactory + 91;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
            }
            return arrayList;
        } catch (Exception e) {
            throw e;
        }
    }

    private final Observable<Map<String, List<ThirdPartyEntity>>> getAllServicesDefault() {
        try {
            int i = MyBillsEntityDataFactory + 103;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            Observable<Map<String, List<ThirdPartyEntity>>> allServices = createDefaultServices().getAllServices();
            int i3 = PlaceComponentResult + 55;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return allServices;
        } catch (Exception e) {
            throw e;
        }
    }

    public final Observable<Map<CategoryServices, List<ThirdPartyEntity>>> getAllMapServices() {
        Observable map = getAllSections().map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda33
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.$r8$lambda$nuvouN9NspO0BIukTts422v7954(ServicesEntityRepository.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = MyBillsEntityDataFactory + 37;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? (char) 22 : (char) 30) != 30) {
            Object[] objArr = null;
            int length = objArr.length;
            return map;
        }
        return map;
    }

    /* renamed from: getAllMapServices$lambda-8  reason: not valid java name */
    private static final Map m1961getAllMapServices$lambda8(ServicesEntityRepository servicesEntityRepository, List list) {
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        Sequence filter = SequencesKt.filter(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(list), new Function1<CategoryServices, Boolean>() { // from class: id.dana.data.services.repository.ServicesEntityRepository$getAllMapServices$1$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(CategoryServices categoryServices) {
                Intrinsics.checkNotNullParameter(categoryServices, "");
                return Boolean.valueOf(categoryServices.getCategory().length() > 0);
            }
        }), new ServicesEntityRepository$getAllMapServices$1$2(servicesEntityRepository)), new Function1<Pair<? extends CategoryServices, ? extends List<? extends ThirdPartyEntity>>, Boolean>() { // from class: id.dana.data.services.repository.ServicesEntityRepository$getAllMapServices$1$3
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Boolean invoke2(Pair<CategoryServices, ? extends List<ThirdPartyEntity>> pair) {
                Intrinsics.checkNotNullExpressionValue(pair.getSecond(), "");
                return Boolean.valueOf(!r2.isEmpty());
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Boolean invoke(Pair<? extends CategoryServices, ? extends List<? extends ThirdPartyEntity>> pair) {
                return invoke2((Pair<CategoryServices, ? extends List<ThirdPartyEntity>>) pair);
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = filter.iterator();
        while (true) {
            if (!(it.hasNext())) {
                break;
            }
            int i = PlaceComponentResult + 115;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 == 0 ? 'S' : 'D') != 'S') {
                try {
                    Pair pair = (Pair) it.next();
                    CategoryServices categoryServices = (CategoryServices) pair.getFirst();
                    Object second = pair.getSecond();
                    Intrinsics.checkNotNullExpressionValue(second, "");
                    linkedHashMap.put(categoryServices, (List) second);
                } catch (Exception e) {
                    throw e;
                }
            } else {
                Pair pair2 = (Pair) it.next();
                CategoryServices categoryServices2 = (CategoryServices) pair2.getFirst();
                Object second2 = pair2.getSecond();
                Intrinsics.checkNotNullExpressionValue(second2, "");
                linkedHashMap.put(categoryServices2, (List) second2);
                Object obj = null;
                obj.hashCode();
            }
        }
        int i2 = PlaceComponentResult + 31;
        MyBillsEntityDataFactory = i2 % 128;
        if ((i2 % 2 == 0 ? '\'' : '#') != '\'') {
            return linkedHashMap;
        }
        int i3 = 37 / 0;
        return linkedHashMap;
    }

    public final Observable<List<CategoryServices>> getAllSections() {
        try {
            Observable flatMap = getSplitSourceServices().getSections().onErrorResumeNext(createDefaultServices().getSections()).filter(new Predicate() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda25
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    return ServicesEntityRepository.$r8$lambda$A6cRiLn5Z0y8aCoKF5OgBjURSPE((List) obj);
                }
            }).switchIfEmpty(createDefaultServices().getSections()).flatMap(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda26
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ServicesEntityRepository.m1950$r8$lambda$jcgm_hsAq_b59Jzg7mDjRUuEdM((List) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            int i = PlaceComponentResult + 1;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 == 0 ? (char) 6 : 'V') != 6) {
                return flatMap;
            }
            int i2 = 58 / 0;
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getAllSections$lambda-9  reason: not valid java name */
    private static final boolean m1963getAllSections$lambda9(List list) {
        int i = PlaceComponentResult + 37;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(list, "");
        boolean z = !list.isEmpty();
        int i3 = MyBillsEntityDataFactory + 73;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return z;
    }

    /* renamed from: getAllSections$lambda-11  reason: not valid java name */
    private static final ObservableSource m1962getAllSections$lambda11(List list) {
        try {
            int i = PlaceComponentResult + 71;
            try {
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(list, "");
                List createListBuilder = CollectionsKt.createListBuilder();
                createListBuilder.addAll(list);
                Observable just = Observable.just(CollectionsKt.build(createListBuilder));
                int i3 = PlaceComponentResult + 5;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return just;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final Observable<List<ThirdPartyEntity>> getAllListOfService() {
        Observable map = getAllSections().map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda34
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.$r8$lambda$sKHWcE6RHOzugQF5bQ1oHVExxq8(ServicesEntityRepository.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        try {
            int i = PlaceComponentResult + 121;
            try {
                MyBillsEntityDataFactory = i % 128;
                if (!(i % 2 == 0)) {
                    return map;
                }
                Object obj = null;
                obj.hashCode();
                return map;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final Observable<List<ThirdPartyEntity>> getListOfService(String categoryKey) {
        try {
            Intrinsics.checkNotNullParameter(categoryKey, "");
            Observable map = getCategoriesByCategoryKey(categoryKey).map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda7
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ServicesEntityRepository.$r8$lambda$fiaMYE1aYsgH6V9t6M5lJPycFgo(ServicesEntityRepository.this, (List) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
            int i = PlaceComponentResult + 37;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getListOfService$lambda-14  reason: not valid java name */
    private static final List m1984getListOfService$lambda14(ServicesEntityRepository servicesEntityRepository, List list) {
        try {
            Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
            Intrinsics.checkNotNullParameter(list, "");
            List list2 = SequencesKt.toList(SequencesKt.distinctBy(SequencesKt.filter(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(list), new Function1<String, Boolean>() { // from class: id.dana.data.services.repository.ServicesEntityRepository$getListOfService$1$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String str) {
                    Intrinsics.checkNotNullParameter(str, "");
                    return Boolean.valueOf(str.length() > 0);
                }
            }), new ServicesEntityRepository$getListOfService$1$2(servicesEntityRepository)), new Function1<ThirdPartyEntity, Boolean>() { // from class: id.dana.data.services.repository.ServicesEntityRepository$getListOfService$1$3
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ThirdPartyEntity thirdPartyEntity) {
                    Intrinsics.checkNotNullParameter(thirdPartyEntity, "");
                    return Boolean.valueOf(thirdPartyEntity.getName() != null);
                }
            }), new Function1<ThirdPartyEntity, String>() { // from class: id.dana.data.services.repository.ServicesEntityRepository$getListOfService$1$4
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(ThirdPartyEntity thirdPartyEntity) {
                    Intrinsics.checkNotNullParameter(thirdPartyEntity, "");
                    return thirdPartyEntity.getKey();
                }
            }));
            int i = PlaceComponentResult + 25;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return list2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final Observable<List<String>> getCategoriesByCategoryKey(final String categoryKey) {
        Intrinsics.checkNotNullParameter(categoryKey, "");
        Observable<List<String>> defer = Observable.defer(new Callable() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda23
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ServicesEntityRepository.m1940$r8$lambda$F67DDmL60YFkKVcfb8cGdAZPEQ(ServicesEntityRepository.this, categoryKey);
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        int i = MyBillsEntityDataFactory + 29;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '7' : (char) 14) != '7') {
            return defer;
        }
        int i2 = 98 / 0;
        return defer;
    }

    /* renamed from: getCategoriesByCategoryKey$lambda-15  reason: not valid java name */
    private static final ObservableSource m1965getCategoriesByCategoryKey$lambda15(ServicesEntityRepository servicesEntityRepository, String str) {
        int i = MyBillsEntityDataFactory + 33;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Observable<List<String>> onErrorResumeNext = servicesEntityRepository.getSplitSourceServices().getCategories(str).onErrorResumeNext(servicesEntityRepository.createDefaultServices().getCategories(str)).onErrorResumeNext(Observable.just(CollectionsKt.emptyList()));
        int i3 = MyBillsEntityDataFactory + 87;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return onErrorResumeNext;
    }

    public final Observable<ThirdPartyEntity> getServiceFromServiceKey(final String serviceKey) {
        Intrinsics.checkNotNullParameter(serviceKey, "");
        Observable<ThirdPartyEntity> defer = Observable.defer(new Callable() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ServicesEntityRepository.m1956$r8$lambda$zz739WFhBxI9qGmaa8P2EqOjU(ServicesEntityRepository.this, serviceKey);
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        int i = MyBillsEntityDataFactory + 63;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return defer;
    }

    /* renamed from: getServiceFromServiceKey$lambda-16  reason: not valid java name */
    private static final ObservableSource m1989getServiceFromServiceKey$lambda16(ServicesEntityRepository servicesEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Observable<ThirdPartyEntity> onErrorResumeNext = servicesEntityRepository.getSplitSourceServices().getService(str).onErrorResumeNext(servicesEntityRepository.createDefaultServices().getService(str)).onErrorResumeNext(Observable.just(new ThirdPartyEntity(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, null, null, false, null, null, null, null, false, null, null, null, null, null, null, -8193, 7, null)));
        int i = MyBillsEntityDataFactory + 47;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return onErrorResumeNext;
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<List<ThirdPartyCategoryService>> getAllServices() {
        Observable map = getAllServicesWithDefaultValue().map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda31
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.m1942$r8$lambda$8NVIklvS3HYlQ61BBMDsY2gdJA(ServicesEntityRepository.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        try {
            int i = MyBillsEntityDataFactory + 59;
            try {
                PlaceComponentResult = i % 128;
                if ((i % 2 != 0 ? 'O' : (char) 14) != 14) {
                    Object obj = null;
                    obj.hashCode();
                    return map;
                }
                return map;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<List<ThirdPartyCategoryService>> getAllDefaultServices() {
        Observable map = getAllServicesDefault().map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda39
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.m1947$r8$lambda$YbsW_1y3nNrV213UQsneQTzpJE(ServicesEntityRepository.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = MyBillsEntityDataFactory + 43;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return map;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
    
        if (r3.isEmpty() == false) goto L19;
     */
    /* renamed from: getAllDefaultServices$lambda-22  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.List m1959getAllDefaultServices$lambda22(id.dana.data.services.repository.ServicesEntityRepository r4, java.util.Map r5) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r5.size()
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
            int r1 = id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory
            int r1 = r1 + 45
            int r2 = r1 % 128
            id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult = r2
            int r1 = r1 % 2
        L25:
            boolean r1 = r5.hasNext()
            r2 = 52
            if (r1 == 0) goto L30
            r1 = 52
            goto L32
        L30:
            r1 = 34
        L32:
            if (r1 == r2) goto L9a
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r5 = r0.iterator()
        L43:
            boolean r0 = r5.hasNext()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L80
            java.lang.Object r0 = r5.next()
            r3 = r0
            id.dana.domain.services.model.ThirdPartyCategoryService r3 = (id.dana.domain.services.model.ThirdPartyCategoryService) r3
            java.util.List r3 = r3.getThirdPartyServices()
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L63
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Exception -> L61
            if (r3 != 0) goto L63
            goto L6e
        L61:
            r4 = move-exception
            goto L7f
        L63:
            int r1 = id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory
            int r1 = r1 + 3
            int r3 = r1 % 128
            id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult = r3
            int r1 = r1 % 2
            r1 = 1
        L6e:
            r1 = r1 ^ r2
            if (r1 == 0) goto L43
            int r1 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult     // Catch: java.lang.Exception -> L61
            int r1 = r1 + 67
            int r2 = r1 % 128
            id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r2     // Catch: java.lang.Exception -> L61
            int r1 = r1 % 2
            r4.add(r0)
            goto L43
        L7f:
            throw r4
        L80:
            java.util.List r4 = (java.util.List) r4
            int r5 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult
            int r5 = r5 + 91
            int r0 = r5 % 128
            id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r0
            int r5 = r5 % 2
            if (r5 != 0) goto L90
            r5 = 1
            goto L91
        L90:
            r5 = 0
        L91:
            if (r5 == r2) goto L94
            return r4
        L94:
            r5 = 37
            int r5 = r5 / r1
            return r4
        L98:
            r4 = move-exception
            throw r4
        L9a:
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Exception -> Lbb
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Exception -> Lbb
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Exception -> Lbb
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> Lbb
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Exception -> Lbb
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Exception -> Lbb
            id.dana.data.homeinfo.mapper.HomeInfoResultMapper r3 = r4.homeInfoResultMapper     // Catch: java.lang.Exception -> Lbb
            java.util.List r1 = r3.transform(r1)     // Catch: java.lang.Exception -> Lbb
            id.dana.domain.services.model.ThirdPartyCategoryService r1 = r3.transform(r1, r2)     // Catch: java.lang.Exception -> Lbb
            r0.add(r1)     // Catch: java.lang.Exception -> Lbb
            goto L25
        Lbb:
            r4 = move-exception
            goto Lbe
        Lbd:
            throw r4
        Lbe:
            goto Lbd
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.m1959getAllDefaultServices$lambda22(id.dana.data.services.repository.ServicesEntityRepository, java.util.Map):java.util.List");
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<List<ThirdPartyServiceResponse>> getRawServices() {
        Observable map = getAllListOfService().doOnError(new Consumer() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ServicesEntityRepository.$r8$lambda$zxxt_XIF7EZs9S2NkLhfznlODsE((Throwable) obj);
            }
        }).map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.$r8$lambda$nBZ642g0DQagRTJTejKt50MRc5o(ServicesEntityRepository.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = MyBillsEntityDataFactory + 97;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            return map;
        }
        return map;
    }

    /* renamed from: getRawServices$lambda-23  reason: not valid java name */
    private static final void m1985getRawServices$lambda23(Throwable th) {
        int i = PlaceComponentResult + 123;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Crashlytics.Companion companion = Crashlytics.INSTANCE;
        Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
        Intrinsics.checkNotNullParameter("case", "");
        Intrinsics.checkNotNullParameter("Get All Raw Services", "");
        authRequestContext.getAuthRequestContext.setCustomKey("case", "Get All Raw Services");
        Intrinsics.checkNotNullExpressionValue(th, "");
        Intrinsics.checkNotNullParameter(th, "");
        authRequestContext.getAuthRequestContext.recordException(th);
        int i3 = PlaceComponentResult + 75;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    /* renamed from: getRawServices$lambda-25  reason: not valid java name */
    private static final List m1986getRawServices$lambda25(ServicesEntityRepository servicesEntityRepository, List list) {
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        int i = MyBillsEntityDataFactory + 125;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        while (it.hasNext()) {
            int i3 = MyBillsEntityDataFactory + 113;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            ThirdPartyServiceResponse transform = servicesEntityRepository.homeInfoResultMapper.transform((ThirdPartyEntity) it.next());
            if (transform != null) {
                arrayList.add(transform);
                int i5 = PlaceComponentResult + 9;
                MyBillsEntityDataFactory = i5 % 128;
                int i6 = i5 % 2;
            }
        }
        return arrayList;
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<List<ThirdPartyCategoryService>> getServicesByCategoryKey(List<String> categoryKeys) {
        Intrinsics.checkNotNullParameter(categoryKeys, "");
        Observable<List<ThirdPartyCategoryService>> map = Observable.zip(getAllSections(), Observable.just(categoryKeys), new BiFunction() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ServicesEntityRepository.$r8$lambda$vzJCDFTmFbJ0bAgtzXrenE35G3M((List) obj, (List) obj2);
            }
        }).map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.m1952$r8$lambda$lPR2MvzYEzxgRdzOS87EAdih8s(ServicesEntityRepository.this, (Pair) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = PlaceComponentResult + 77;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? (char) 21 : 'S') != 'S') {
            Object[] objArr = null;
            int length = objArr.length;
            return map;
        }
        return map;
    }

    /* renamed from: getServicesByCategoryKey$lambda-26  reason: not valid java name */
    private static final Pair m1990getServicesByCategoryKey$lambda26(List list, List list2) {
        Pair pair;
        int i = PlaceComponentResult + 1;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(list2, "");
            pair = TuplesKt.to(list, list2);
            int i2 = 33 / 0;
        } else {
            try {
                Intrinsics.checkNotNullParameter(list, "");
                Intrinsics.checkNotNullParameter(list2, "");
                pair = TuplesKt.to(list, list2);
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = MyBillsEntityDataFactory + 73;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 78 / 0;
            return pair;
        }
        return pair;
    }

    /* renamed from: getServicesByCategoryKey$lambda-27  reason: not valid java name */
    private static final List m1991getServicesByCategoryKey$lambda27(ServicesEntityRepository servicesEntityRepository, Pair pair) {
        try {
            Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
            Intrinsics.checkNotNullParameter(pair, "");
            try {
                List list = (List) pair.component1();
                List list2 = (List) pair.component2();
                Intrinsics.checkNotNullExpressionValue(list2, "");
                List list3 = SequencesKt.toList(SequencesKt.map(CollectionsKt.asSequence(list2), new ServicesEntityRepository$getServicesByCategoryKey$2$1(list, servicesEntityRepository)));
                int i = PlaceComponentResult + 37;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                return list3;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<List<ThirdPartyCategoryService>> getServicesByCategoryKeyDefault(final List<String> categoryKeys) {
        try {
            Intrinsics.checkNotNullParameter(categoryKeys, "");
            Observable map = getAllServicesDefault().map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda29
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ServicesEntityRepository.$r8$lambda$VJ9qrtW7wU3sO0h1j6KcJw5iTWc(categoryKeys, this, (Map) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
            int i = MyBillsEntityDataFactory + 87;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<ThirdPartyCategoryService> getFavoriteServicesCache(boolean globalNetworkMode) {
        Observable<ThirdPartyCategoryService> onErrorResumeNext = this.preferenceFavoriteServicesEntityData.getFavoriteServicesCache().onErrorResumeNext(Observable.just(new ThirdPartyCategoryService()));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        int i = PlaceComponentResult + 27;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return onErrorResumeNext;
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final void setInMemoryFavoriteServiceCache(ThirdPartyCategoryService inMemoryFavoriteServiceCache) {
        int i = PlaceComponentResult + 13;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(inMemoryFavoriteServiceCache, "");
        this.inMemoryFavoriteServiceCache = inMemoryFavoriteServiceCache;
        int i3 = PlaceComponentResult + 45;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 25 : 'I') != 'I') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<Boolean> resetInMemoryFavoriteServiceCache() {
        int i = PlaceComponentResult + 63;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        this.inMemoryFavoriteServiceCache = null;
        Observable<Boolean> just = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        int i3 = PlaceComponentResult + 23;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 == 0 ? 'Y' : '#') != '#') {
            int i4 = 7 / 0;
            return just;
        }
        return just;
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final ThirdPartyCategoryService getInMemoryFavoriteServiceCache() {
        ThirdPartyCategoryService thirdPartyCategoryService;
        try {
            int i = PlaceComponentResult + 113;
            try {
                MyBillsEntityDataFactory = i % 128;
                if (i % 2 == 0) {
                    thirdPartyCategoryService = this.inMemoryFavoriteServiceCache;
                    int i2 = 62 / 0;
                } else {
                    thirdPartyCategoryService = this.inMemoryFavoriteServiceCache;
                }
                int i3 = PlaceComponentResult + 123;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return thirdPartyCategoryService;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<ThirdPartyCategoryService> getFavoriteServices() {
        int i = MyBillsEntityDataFactory + 39;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            try {
                Observable<ThirdPartyCategoryService> onErrorResumeNext = getFavoriteServiceFromRemoteSource().onErrorResumeNext(getFavoriteServicesFromLocal());
                Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
                return onErrorResumeNext;
            } catch (Exception e) {
                throw e;
            }
        }
        Observable<ThirdPartyCategoryService> onErrorResumeNext2 = getFavoriteServiceFromRemoteSource().onErrorResumeNext(getFavoriteServicesFromLocal());
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext2, "");
        Object[] objArr = null;
        int length = objArr.length;
        return onErrorResumeNext2;
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<ThirdPartyCategoryService> getFavoriteServiceFromRemoteSource() {
        Observable<ThirdPartyCategoryService> doOnNext = this.userConfigEntityRepository.getUserSpecificConfig(new QueryConfig(UserConfigBizTypeConstant.CONFIG_MY_FAVORITE_SERVICE, String[].class)).flatMap(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.$r8$lambda$r01_h6pVzLE5qPSpQ1eeSst8uZk(ServicesEntityRepository.this, (String[]) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ServicesEntityRepository.$r8$lambda$lh10A99e0NPpEwgytSijJ1J0QyU(ServicesEntityRepository.this, (ThirdPartyCategoryService) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        int i = MyBillsEntityDataFactory + 3;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return doOnNext;
    }

    /* renamed from: getFavoriteServiceFromRemoteSource$lambda-33  reason: not valid java name */
    private static final ObservableSource m1970getFavoriteServiceFromRemoteSource$lambda33(final ServicesEntityRepository servicesEntityRepository, final String[] strArr) {
        try {
            Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
            Intrinsics.checkNotNullParameter(strArr, "");
            ObservableSource flatMap = servicesEntityRepository.getCategoryFeaturedServices(CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length))).flatMap(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ServicesEntityRepository.m1946$r8$lambda$QHeNL0323uyTavsXLnx9czdSGY(ServicesEntityRepository.this, strArr, (List) obj);
                }
            });
            int i = MyBillsEntityDataFactory + 77;
            PlaceComponentResult = i % 128;
            if ((i % 2 == 0 ? '\f' : 'M') != '\f') {
                int i2 = 98 / 0;
                return flatMap;
            }
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getFavoriteServiceFromRemoteSource$lambda-33$lambda-32  reason: not valid java name */
    private static final ObservableSource m1971getFavoriteServiceFromRemoteSource$lambda33$lambda32(ServicesEntityRepository servicesEntityRepository, String[] strArr, List list) {
        int i = PlaceComponentResult + 65;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
            Intrinsics.checkNotNullParameter(strArr, "");
            Intrinsics.checkNotNullParameter(list, "");
            Observable<ThirdPartyCategoryService> transform = servicesEntityRepository.favoriteServicesResultMapper.transform(CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)), list);
            Object obj = null;
            obj.hashCode();
            return transform;
        }
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(strArr, "");
        Intrinsics.checkNotNullParameter(list, "");
        return servicesEntityRepository.favoriteServicesResultMapper.transform(CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)), list);
    }

    /* renamed from: getFavoriteServiceFromRemoteSource$lambda-34  reason: not valid java name */
    private static final void m1972getFavoriteServiceFromRemoteSource$lambda34(ServicesEntityRepository servicesEntityRepository, ThirdPartyCategoryService thirdPartyCategoryService) {
        try {
            int i = PlaceComponentResult + 35;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
            servicesEntityRepository.inMemoryFavoriteServiceCache = thirdPartyCategoryService;
            PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData = servicesEntityRepository.preferenceFavoriteServicesEntityData;
            Intrinsics.checkNotNullExpressionValue(thirdPartyCategoryService, "");
            preferenceFavoriteServicesEntityData.saveFavoriteServiceCache(thirdPartyCategoryService).blockingFirst();
            int i3 = MyBillsEntityDataFactory + 111;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<Boolean> saveFavoriteServices(List<String> services) {
        Intrinsics.checkNotNullParameter(services, "");
        Observable<Boolean> saveUserSpecificConfigBackendFirst = this.userConfigEntityRepository.saveUserSpecificConfigBackendFirst(new StoreFavoriteServiceConfig(services));
        Intrinsics.checkNotNullExpressionValue(saveUserSpecificConfigBackendFirst, "");
        try {
            int i = PlaceComponentResult + 57;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return saveUserSpecificConfigBackendFirst;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<Boolean> clearCacheFavoriteServices() {
        int i = MyBillsEntityDataFactory + 27;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Observable<Boolean> clearCacheFavoriteServices = this.preferenceFavoriteServicesEntityData.clearCacheFavoriteServices();
        try {
            int i3 = MyBillsEntityDataFactory + 125;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return clearCacheFavoriteServices;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<List<ThirdPartyCategoryService>> getExploreServices(final List<String> serviceKey) {
        Intrinsics.checkNotNullParameter(serviceKey, "");
        Observable map = getFilteredServices(serviceKey, "key").map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.$r8$lambda$t0_ILXzvMlQpA3TB4e_zjPltrfc(serviceKey, this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = PlaceComponentResult + 47;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return map;
    }

    /* renamed from: getExploreServices$lambda-36  reason: not valid java name */
    private static final List m1969getExploreServices$lambda36(List list, ServicesEntityRepository servicesEntityRepository, List list2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(list2, "");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            List<ThirdPartyServiceResponse> thirdPartyServices = ((ThirdPartyCategoryService) next).getThirdPartyServices();
            Intrinsics.checkNotNullExpressionValue(thirdPartyServices, "");
            if (!(hashSet.add(((ThirdPartyServiceResponse) CollectionsKt.first((List) thirdPartyServices)).getKey()) ? false : true)) {
                int i = PlaceComponentResult + 121;
                MyBillsEntityDataFactory = i % 128;
                if (i % 2 == 0) {
                    arrayList.add(next);
                    Object[] objArr = null;
                    int length = objArr.length;
                } else {
                    arrayList.add(next);
                }
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        Object[] objArr2 = new Object[1];
        a(new int[]{0, 5, 140, 0}, true, new byte[]{0, 1, 1, 1, 1}, objArr2);
        if (list.contains(((String) objArr2[0]).intern())) {
            mutableList.add(0, servicesEntityRepository.getTopupService());
        }
        if (list.contains("send_money")) {
            int i2 = PlaceComponentResult + 39;
            MyBillsEntityDataFactory = i2 % 128;
            if (i2 % 2 == 0) {
                mutableList.add(5, servicesEntityRepository.getSendMoneyService());
            } else {
                mutableList.add(2, servicesEntityRepository.getSendMoneyService());
            }
        }
        return CollectionsKt.toList(mutableList);
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<List<ThirdPartyServiceResponse>> getDefaultSkuExplore(final List<String> serviceKey) {
        Intrinsics.checkNotNullParameter(serviceKey, "");
        Observable map = getFilteredServices(serviceKey, "key").map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.m1948$r8$lambda$deDxgAK3eXosdOHiW8O6d0kmaM(ServicesEntityRepository.this, serviceKey, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = MyBillsEntityDataFactory + 95;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return map;
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<Boolean> updateHighlightedService() {
        Observable flatMap = this.preferenceFavoriteServicesEntityData.getServiceHighlighted().flatMap(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.$r8$lambda$h0x4zWbXuprG9ciDz8LCyrIluPA(ServicesEntityRepository.this, (Optional) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = MyBillsEntityDataFactory + 37;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    /* renamed from: updateHighlightedService$lambda-43$lambda-42  reason: not valid java name */
    private static final Boolean m1997updateHighlightedService$lambda43$lambda42(ServiceHighlighted serviceHighlighted) {
        int i = PlaceComponentResult + 51;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(serviceHighlighted, "");
            Boolean bool = Boolean.TRUE;
            int i3 = PlaceComponentResult + 109;
            MyBillsEntityDataFactory = i3 % 128;
            if (i3 % 2 == 0) {
                Object[] objArr = null;
                int length = objArr.length;
                return bool;
            }
            return bool;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: updateHighlightedService$lambda-43  reason: not valid java name */
    private static final ObservableSource m1996updateHighlightedService$lambda43(ServicesEntityRepository servicesEntityRepository, Optional optional) {
        ObservableSource map;
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(optional, "");
        if (!(optional.KClassImpl$Data$declaredNonStaticMembers$2())) {
            map = Observable.just(Boolean.FALSE);
        } else {
            try {
                int i = PlaceComponentResult + 87;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                Object obj = optional.PlaceComponentResult;
                if (obj == null) {
                    throw new NoSuchElementException("No value present");
                }
                try {
                    int i3 = MyBillsEntityDataFactory + 55;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    map = servicesEntityRepository.preferenceFavoriteServicesEntityData.saveServiceHighlighted(ServiceHighlighted.copy$default((ServiceHighlighted) obj, null, DateTimeUtil.getCurrentTimeMillis(), null, 5, null)).map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda14
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj2) {
                            return ServicesEntityRepository.$r8$lambda$_fsUwJN2uDdKRowbCwtjKeGguy4((ServiceHighlighted) obj2);
                        }
                    });
                    int i5 = PlaceComponentResult + 23;
                    MyBillsEntityDataFactory = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        ObservableSource observableSource = map;
        int i7 = PlaceComponentResult + 89;
        MyBillsEntityDataFactory = i7 % 128;
        int i8 = i7 % 2;
        return observableSource;
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<Optional<ThirdPartyServiceResponse>> getHighlightedService() {
        Observable zip;
        int i = PlaceComponentResult + 73;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        CategoryHighlightedFeature categoryHighlightedFeature = this.inMemoryCategoryHighlightedFeature;
        if (categoryHighlightedFeature != null) {
            zip = Observable.zip(Observable.just(categoryHighlightedFeature), this.preferenceFavoriteServicesEntityData.getCategoryHighlightedFeature(), new BiFunction() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda35
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ServicesEntityRepository.$r8$lambda$lNErFQ0KcF4C2KczRvgDQWeOe2o((CategoryHighlightedFeature) obj, (Optional) obj2);
                }
            });
        } else {
            zip = Observable.zip(getSplitSourceServices().getCategoryHighlightedFeature(), this.preferenceFavoriteServicesEntityData.getCategoryHighlightedFeature(), new BiFunction() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda36
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return ServicesEntityRepository.m1945$r8$lambda$MBVME9WlCooSEYQmu1APHoXtwo((CategoryHighlightedFeature) obj, (Optional) obj2);
                }
            });
            int i3 = MyBillsEntityDataFactory + 13;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        }
        try {
            Observable<Optional<ThirdPartyServiceResponse>> flatMap = zip.flatMap(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda37
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ServicesEntityRepository.$r8$lambda$B0cqEhHTNwkHpcMk302ShJ9S62w(ServicesEntityRepository.this, (Pair) obj);
                }
            }).flatMap(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda38
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ServicesEntityRepository.m1951$r8$lambda$jxvNXqSbGgwuVu_44_WcODbxg(ServicesEntityRepository.this, (Triple) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getHighlightedService$lambda-44  reason: not valid java name */
    private static final Pair m1977getHighlightedService$lambda44(CategoryHighlightedFeature categoryHighlightedFeature, Optional optional) {
        int i = PlaceComponentResult + 67;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 != 0) {
            try {
                Intrinsics.checkNotNullParameter(categoryHighlightedFeature, "");
                Intrinsics.checkNotNullParameter(optional, "");
                return TuplesKt.to(categoryHighlightedFeature, optional);
            } catch (Exception e) {
                throw e;
            }
        }
        Intrinsics.checkNotNullParameter(categoryHighlightedFeature, "");
        Intrinsics.checkNotNullParameter(optional, "");
        Pair pair = TuplesKt.to(categoryHighlightedFeature, optional);
        int i2 = 83 / 0;
        return pair;
    }

    /* renamed from: getHighlightedService$lambda-45  reason: not valid java name */
    private static final Pair m1978getHighlightedService$lambda45(CategoryHighlightedFeature categoryHighlightedFeature, Optional optional) {
        int i = PlaceComponentResult + 77;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(categoryHighlightedFeature, "");
        Intrinsics.checkNotNullParameter(optional, "");
        Pair pair = TuplesKt.to(categoryHighlightedFeature, optional);
        int i3 = PlaceComponentResult + 71;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return pair;
    }

    /* renamed from: getHighlightedService$lambda-47  reason: not valid java name */
    private static final ObservableSource m1979getHighlightedService$lambda47(ServicesEntityRepository servicesEntityRepository, final Pair pair) {
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(pair, "");
        servicesEntityRepository.inMemoryCategoryHighlightedFeature = (CategoryHighlightedFeature) pair.getFirst();
        Observable<Optional<ServiceHighlighted>> serviceHighlighted = servicesEntityRepository.preferenceFavoriteServicesEntityData.getServiceHighlighted();
        PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData = servicesEntityRepository.preferenceFavoriteServicesEntityData;
        Object first = pair.getFirst();
        Intrinsics.checkNotNullExpressionValue(first, "");
        Observable zip = Observable.zip(serviceHighlighted, preferenceFavoriteServicesEntityData.saveCategoryHighlightedFeature((CategoryHighlightedFeature) first), new BiFunction() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ServicesEntityRepository.$r8$lambda$WlKov1eEAxjmDbVDEobKsIyV3FA(Pair.this, (Optional) obj, (CategoryHighlightedFeature) obj2);
            }
        });
        int i = PlaceComponentResult + 29;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return zip;
    }

    /* renamed from: getHighlightedService$lambda-47$lambda-46  reason: not valid java name */
    private static final Triple m1980getHighlightedService$lambda47$lambda46(Pair pair, Optional optional, CategoryHighlightedFeature categoryHighlightedFeature) {
        Intrinsics.checkNotNullParameter(pair, "");
        Intrinsics.checkNotNullParameter(optional, "");
        Intrinsics.checkNotNullParameter(categoryHighlightedFeature, "");
        Triple triple = new Triple(pair.getFirst(), pair.getSecond(), optional);
        int i = PlaceComponentResult + 95;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 != 0) {
            return triple;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return triple;
    }

    /* renamed from: getHighlightedService$lambda-48  reason: not valid java name */
    private static final ObservableSource m1981getHighlightedService$lambda48(ServicesEntityRepository servicesEntityRepository, Triple triple) {
        Observable<Optional<ThirdPartyServiceResponse>> highlightedServiceOptional;
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(triple, "");
        CategoryHighlightedFeature categoryHighlightedFeature = (CategoryHighlightedFeature) triple.component1();
        Optional<CategoryHighlightedFeature> optional = (Optional) triple.component2();
        Optional<ServiceHighlighted> optional2 = (Optional) triple.component3();
        if (!(categoryHighlightedFeature.getEnable())) {
            int i = PlaceComponentResult + 109;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            highlightedServiceOptional = Observable.just(Optional.MyBillsEntityDataFactory());
            Intrinsics.checkNotNullExpressionValue(highlightedServiceOptional, "");
        } else {
            try {
                Intrinsics.checkNotNullExpressionValue(categoryHighlightedFeature, "");
                Intrinsics.checkNotNullExpressionValue(optional, "");
                Intrinsics.checkNotNullExpressionValue(optional2, "");
                highlightedServiceOptional = servicesEntityRepository.getHighlightedServiceOptional(categoryHighlightedFeature, optional, optional2);
                int i3 = MyBillsEntityDataFactory + 37;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            return highlightedServiceOptional;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final Observable<Optional<ThirdPartyServiceResponse>> getHighlightedServiceOptional(final CategoryHighlightedFeature split, final Optional<CategoryHighlightedFeature> local, final Optional<ServiceHighlighted> highlightedOptional) {
        Intrinsics.checkNotNullParameter(split, "");
        Intrinsics.checkNotNullParameter(local, "");
        Intrinsics.checkNotNullParameter(highlightedOptional, "");
        Observable<Optional<ThirdPartyServiceResponse>> defer = Observable.defer(new Callable() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda30
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ServicesEntityRepository.$r8$lambda$WH0sPo9kogE9xU3DJOvMSIChQJc(Optional.this, split, highlightedOptional, this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        int i = PlaceComponentResult + 31;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return defer;
    }

    /* renamed from: getHighlightedServiceOptional$lambda-50  reason: not valid java name */
    private static final ObservableSource m1982getHighlightedServiceOptional$lambda50(final Optional optional, final CategoryHighlightedFeature categoryHighlightedFeature, final Optional optional2, final ServicesEntityRepository servicesEntityRepository) {
        Intrinsics.checkNotNullParameter(optional, "");
        Intrinsics.checkNotNullParameter(categoryHighlightedFeature, "");
        Intrinsics.checkNotNullParameter(optional2, "");
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        final long currentTimeMillis = DateTimeUtil.getCurrentTimeMillis();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                ServicesEntityRepository.m1941$r8$lambda$4LJKPQWzEXinnM3X67FHFy8Fh8(Optional.this, categoryHighlightedFeature, optional2, servicesEntityRepository, currentTimeMillis, observableEmitter);
            }
        });
        try {
            int i = PlaceComponentResult + 83;
            MyBillsEntityDataFactory = i % 128;
            if (i % 2 == 0) {
                int i2 = 24 / 0;
                return create;
            }
            return create;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
    
        if ((r6.KClassImpl$Data$declaredNonStaticMembers$2() ? 'O' : '\t') != 'O') goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
    
        if (r6.KClassImpl$Data$declaredNonStaticMembers$2() != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        r6 = r6.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (r6 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        if (r1 == 1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
    
        r0 = id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory + 45;
        id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        if ((r0 % 2) == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
    
        r0 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r0 = 22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
    
        if (r0 == 22) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
    
        r0 = r0.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0079, code lost:
    
        if (((id.dana.data.services.repository.source.model.CategoryHighlightedFeature) r6).getResetCounter() < r7.getResetCounter()) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007f, code lost:
    
        if (r8.KClassImpl$Data$declaredNonStaticMembers$2() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0086, code lost:
    
        r9.getNextEnableHighlightedService(r7, r8, r10, new id.dana.data.services.repository.ServicesEntityRepository$getHighlightedServiceOptional$1$1$2(r12, r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0090, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0091, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0092, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
    
        throw new java.util.NoSuchElementException("No value present");
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009c, code lost:
    
        getEnabledHighlightedService$default(r9, r7, 0, new id.dana.data.services.repository.ServicesEntityRepository$getHighlightedServiceOptional$1$1$1(r12, r9, r10), 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ac, code lost:
    
        return;
     */
    /* renamed from: getHighlightedServiceOptional$lambda-50$lambda-49  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void m1983getHighlightedServiceOptional$lambda50$lambda49(j$.util.Optional r6, id.dana.data.services.repository.source.model.CategoryHighlightedFeature r7, j$.util.Optional r8, final id.dana.data.services.repository.ServicesEntityRepository r9, long r10, final io.reactivex.ObservableEmitter r12) {
        /*
            int r0 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult
            r1 = 91
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r2
            int r0 = r0 % 2
            java.lang.String r2 = ""
            if (r0 != 0) goto L37
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)     // Catch: java.lang.Exception -> L35
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)     // Catch: java.lang.Exception -> L35
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)     // Catch: java.lang.Exception -> L35
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)     // Catch: java.lang.Exception -> L35
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r2)     // Catch: java.lang.Exception -> L35
            boolean r0 = r6.KClassImpl$Data$declaredNonStaticMembers$2()     // Catch: java.lang.Exception -> L35
            r2 = 46
            int r2 = r2 / 0
            r2 = 79
            if (r0 == 0) goto L2d
            r0 = 79
            goto L2f
        L2d:
            r0 = 9
        L2f:
            if (r0 == r2) goto L4c
            goto L9c
        L33:
            r6 = move-exception
            throw r6
        L35:
            r6 = move-exception
            goto L93
        L37:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r2)
            boolean r0 = r6.KClassImpl$Data$declaredNonStaticMembers$2()
            if (r0 == 0) goto L9c
        L4c:
            java.lang.Object r6 = r6.PlaceComponentResult
            r0 = 1
            if (r6 == 0) goto L52
            goto L53
        L52:
            r1 = 1
        L53:
            if (r1 == r0) goto L94
            int r0 = id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory
            int r0 = r0 + 45
            int r1 = r0 % 128
            id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 22
            if (r0 == 0) goto L66
            r0 = 16
            goto L68
        L66:
            r0 = 22
        L68:
            if (r0 == r1) goto L6f
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L6d
            goto L6f
        L6d:
            r6 = move-exception
            throw r6
        L6f:
            id.dana.data.services.repository.source.model.CategoryHighlightedFeature r6 = (id.dana.data.services.repository.source.model.CategoryHighlightedFeature) r6
            int r6 = r6.getResetCounter()
            int r0 = r7.getResetCounter()
            if (r6 < r0) goto L9c
            boolean r6 = r8.KClassImpl$Data$declaredNonStaticMembers$2()     // Catch: java.lang.Exception -> L35
            if (r6 == 0) goto L9c
            id.dana.data.services.repository.ServicesEntityRepository$getHighlightedServiceOptional$1$1$2 r6 = new id.dana.data.services.repository.ServicesEntityRepository$getHighlightedServiceOptional$1$1$2
            r6.<init>()
            r5 = r6
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch: java.lang.Exception -> L91
            r0 = r9
            r1 = r7
            r2 = r8
            r3 = r10
            r0.getNextEnableHighlightedService(r1, r2, r3, r5)     // Catch: java.lang.Exception -> L91
            return
        L91:
            r6 = move-exception
            throw r6
        L93:
            throw r6
        L94:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException
            java.lang.String r7 = "No value present"
            r6.<init>(r7)
            throw r6
        L9c:
            r2 = 0
            id.dana.data.services.repository.ServicesEntityRepository$getHighlightedServiceOptional$1$1$1 r6 = new id.dana.data.services.repository.ServicesEntityRepository$getHighlightedServiceOptional$1$1$1
            r6.<init>(r12, r9, r10)
            r3 = r6
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = 2
            r5 = 0
            r0 = r9
            r1 = r7
            getEnabledHighlightedService$default(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.m1983getHighlightedServiceOptional$lambda50$lambda49(j$.util.Optional, id.dana.data.services.repository.source.model.CategoryHighlightedFeature, j$.util.Optional, id.dana.data.services.repository.ServicesEntityRepository, long, io.reactivex.ObservableEmitter):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
    
        if (((r5 & 2) != 0 ? ';' : 'C') != 'C') goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r3 = -1;
        r5 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult + 13;
        id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (((r5 & 5) != 0 ? '!' : 1) != 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void getEnabledHighlightedService$default(id.dana.data.services.repository.ServicesEntityRepository r1, id.dana.data.services.repository.source.model.CategoryHighlightedFeature r2, int r3, kotlin.jvm.functions.Function1 r4, int r5, java.lang.Object r6) {
        /*
            int r6 = id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory
            int r6 = r6 + 37
            int r0 = r6 % 128
            id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult = r0
            int r6 = r6 % 2
            if (r6 == 0) goto L18
            r5 = r5 & 5
            r6 = 1
            if (r5 == 0) goto L14
            r5 = 33
            goto L15
        L14:
            r5 = 1
        L15:
            if (r5 == r6) goto L30
            goto L25
        L18:
            r5 = r5 & 2
            r6 = 67
            if (r5 == 0) goto L21
            r5 = 59
            goto L23
        L21:
            r5 = 67
        L23:
            if (r5 == r6) goto L30
        L25:
            r3 = -1
            int r5 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult
            int r5 = r5 + 13
            int r6 = r5 % 128
            id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r6
            int r5 = r5 % 2
        L30:
            r1.getEnabledHighlightedService(r2, r3, r4)     // Catch: java.lang.Exception -> L34
            return
        L34:
            r1 = move-exception
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.getEnabledHighlightedService$default(id.dana.data.services.repository.ServicesEntityRepository, id.dana.data.services.repository.source.model.CategoryHighlightedFeature, int, kotlin.jvm.functions.Function1, int, java.lang.Object):void");
    }

    @ExcludeFromJacocoGeneratedReport
    public final void getEnabledHighlightedService(CategoryHighlightedFeature split, int currentIndex, Function1<? super Optional<ThirdPartyServiceResponse>, Unit> onResult) {
        int i;
        Object m3179constructorimpl;
        int i2 = MyBillsEntityDataFactory + 99;
        PlaceComponentResult = i2 % 128;
        if (i2 % 2 == 0) {
            Intrinsics.checkNotNullParameter(split, "");
            Intrinsics.checkNotNullParameter(onResult, "");
            i = currentIndex + 1;
        } else {
            Intrinsics.checkNotNullParameter(split, "");
            Intrinsics.checkNotNullParameter(onResult, "");
            i = currentIndex % 1;
        }
        int size = split.getFeatureHighlight().size();
        int size2 = split.getFeatureHighlight().size();
        for (int i3 = 0; i3 < size2; i3++) {
            int i4 = MyBillsEntityDataFactory + 45;
            PlaceComponentResult = i4 % 128;
            int i5 = i4 % 2;
            if (size - 1 < i) {
                i = 0;
            }
            String str = split.getFeatureHighlight().get(i);
            Object obj = null;
            try {
                Result.Companion companion = Result.INSTANCE;
                ThirdPartyServiceResponse blockingFirst = getServiceByKey(str).blockingFirst();
                blockingFirst.setIndexOfHighlighted(Integer.valueOf(i + 1));
                if (!blockingFirst.isEnable()) {
                    blockingFirst = null;
                }
                m3179constructorimpl = Result.m3179constructorimpl(blockingFirst);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
            }
            if ((Result.m3185isFailureimpl(m3179constructorimpl) ? 'c' : 'J') == 'c') {
                m3179constructorimpl = null;
            }
            ThirdPartyServiceResponse thirdPartyServiceResponse = (ThirdPartyServiceResponse) m3179constructorimpl;
            if ((thirdPartyServiceResponse != null ? '[' : (char) 21) != 21) {
                int i6 = MyBillsEntityDataFactory + 1;
                PlaceComponentResult = i6 % 128;
                int i7 = i6 % 2;
                Optional BuiltInFictitiousFunctionClassFactory = Optional.BuiltInFictitiousFunctionClassFactory(thirdPartyServiceResponse);
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                onResult.invoke(BuiltInFictitiousFunctionClassFactory);
                return;
            }
            i++;
            if (i == currentIndex) {
                int i8 = PlaceComponentResult + 69;
                MyBillsEntityDataFactory = i8 % 128;
                if (i8 % 2 == 0) {
                    obj.hashCode();
                    return;
                }
                return;
            }
        }
        Optional MyBillsEntityDataFactory2 = Optional.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        onResult.invoke(MyBillsEntityDataFactory2);
    }

    public final void saveServiceHighlighted(ServiceHighlighted serviceHighlighted) {
        int i = PlaceComponentResult + 99;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if (serviceHighlighted == null) {
            return;
        }
        Completable ignoreElements = this.preferenceFavoriteServicesEntityData.saveServiceHighlighted(serviceHighlighted).observeOn(Schedulers.MyBillsEntityDataFactory()).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        Object[] objArr = null;
        SubscribersKt.MyBillsEntityDataFactory(ignoreElements, null, new Function0<Unit>() { // from class: id.dana.data.services.repository.ServicesEntityRepository$saveServiceHighlighted$disposable$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, 1);
        int i3 = PlaceComponentResult + 97;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 19 : (char) 2) != 19) {
            int length = objArr.length;
        }
    }

    public final Observable<ThirdPartyCategoryService> getFavoriteServicesFromLocal() {
        try {
            try {
                Observable flatMap = this.preferenceFavoriteServicesEntityData.getFavoriteServices().flatMap(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda32
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return ServicesEntityRepository.$r8$lambda$O4W0yMjw7xAxezT3P3NGtsJtPOU(ServicesEntityRepository.this, (List) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(flatMap, "");
                int i = PlaceComponentResult + 3;
                MyBillsEntityDataFactory = i % 128;
                if ((i % 2 == 0 ? '`' : 'H') != 'H') {
                    int i2 = 9 / 0;
                    return flatMap;
                }
                return flatMap;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: getFavoriteServicesFromLocal$lambda-58  reason: not valid java name */
    private static final ObservableSource m1973getFavoriteServicesFromLocal$lambda58(final ServicesEntityRepository servicesEntityRepository, final List list) {
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        ObservableSource flatMap = servicesEntityRepository.getCategoryFeaturedServices(list).flatMap(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda40
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.$r8$lambda$XqgoWikK8aowXzulxvTjzTi4a6s(ServicesEntityRepository.this, list, (List) obj);
            }
        });
        int i = MyBillsEntityDataFactory + 37;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'O' : 'D') != 'O') {
            return flatMap;
        }
        Object obj = null;
        obj.hashCode();
        return flatMap;
    }

    /* renamed from: getFavoriteServicesFromLocal$lambda-58$lambda-57  reason: not valid java name */
    private static final ObservableSource m1974getFavoriteServicesFromLocal$lambda58$lambda57(ServicesEntityRepository servicesEntityRepository, List list, List list2) {
        Observable<ThirdPartyCategoryService> transform;
        int i = PlaceComponentResult + 61;
        MyBillsEntityDataFactory = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? '5' : '#') != '#') {
            Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(list2, "");
            transform = servicesEntityRepository.favoriteServicesResultMapper.transform(list, list2);
            int length = objArr.length;
        } else {
            try {
                Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
                Intrinsics.checkNotNullParameter(list, "");
                Intrinsics.checkNotNullParameter(list2, "");
                transform = servicesEntityRepository.favoriteServicesResultMapper.transform(list, list2);
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = MyBillsEntityDataFactory + 73;
        PlaceComponentResult = i2 % 128;
        if (i2 % 2 == 0) {
            return transform;
        }
        int length2 = objArr.length;
        return transform;
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<Boolean> resetInMemoryCategoryHighlightedFeature() {
        Observable<Boolean> just;
        int i = PlaceComponentResult + 19;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? Typography.greater : ';') != '>') {
            this.inMemoryCategoryHighlightedFeature = null;
            just = Observable.just(Boolean.TRUE);
            Intrinsics.checkNotNullExpressionValue(just, "");
        } else {
            this.inMemoryCategoryHighlightedFeature = null;
            just = Observable.just(Boolean.TRUE);
            Intrinsics.checkNotNullExpressionValue(just, "");
            int i2 = 68 / 0;
        }
        int i3 = MyBillsEntityDataFactory + 59;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return just;
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<Boolean> isFeatureHighlightExist(final String key) {
        Observable<Boolean> just;
        int i = PlaceComponentResult + 63;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(key, "");
            CategoryHighlightedFeature categoryHighlightedFeature = this.inMemoryCategoryHighlightedFeature;
            if (!(categoryHighlightedFeature != null)) {
                just = null;
            } else {
                try {
                    just = Observable.just(Boolean.valueOf(categoryHighlightedFeature.getFeatureHighlight().contains(key)));
                    int i3 = MyBillsEntityDataFactory + 51;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            if (just == null) {
                Observable flatMap = getSplitSourceServices().getCategoryHighlightedFeature().flatMap(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda27
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return ServicesEntityRepository.$r8$lambda$d6xXZ_XJdVLcViL_ETbiujOn9RQ(key, (CategoryHighlightedFeature) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(flatMap, "");
                return flatMap;
            }
            return just;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: isFeatureHighlightExist$lambda-61$lambda-60  reason: not valid java name */
    private static final ObservableSource m1993isFeatureHighlightExist$lambda61$lambda60(String str, CategoryHighlightedFeature categoryHighlightedFeature) {
        try {
            int i = MyBillsEntityDataFactory + 51;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(categoryHighlightedFeature, "");
            Observable just = Observable.just(Boolean.valueOf(categoryHighlightedFeature.getFeatureHighlight().contains(str)));
            int i3 = PlaceComponentResult + 5;
            MyBillsEntityDataFactory = i3 % 128;
            if (i3 % 2 != 0) {
                return just;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return just;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.domain.services.ServicesRepository
    public final Observable<Boolean> overwriteHighlightedService(final String key) {
        try {
            Intrinsics.checkNotNullParameter(key, "");
            Observable flatMap = this.preferenceFavoriteServicesEntityData.getServiceHighlighted().flatMap(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda9
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ServicesEntityRepository.m1954$r8$lambda$uJsiaetiqKRRjJJ00RuKkTUOpY(key, this, (Optional) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            int i = MyBillsEntityDataFactory + 21;
            PlaceComponentResult = i % 128;
            if (i % 2 == 0) {
                return flatMap;
            }
            Object obj = null;
            obj.hashCode();
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        if ((!r0) != true) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
    
        if ((r11.KClassImpl$Data$declaredNonStaticMembers$2() ? 6 : ':') != 6) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
    
        r9 = io.reactivex.Observable.just(java.lang.Boolean.FALSE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        r11 = r11.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        if (r11 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
    
        r2 = 'I';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        r2 = id.dana.cashier.view.InputCardNumberView.DIVIDER;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        if (r2 == ' ') goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        r0 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult + 61;
        id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "");
        r9 = r10.preferenceFavoriteServicesEntityData.saveServiceHighlighted(id.dana.data.services.repository.source.model.ServiceHighlighted.copy$default((id.dana.data.services.repository.source.model.ServiceHighlighted) r11, r9, id.dana.data.util.DateTimeUtil.getCurrentTimeMillis(), null, 4, null)).map(new id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda21());
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0082, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008b, code lost:
    
        throw new java.util.NoSuchElementException("No value present");
     */
    /* renamed from: overwriteHighlightedService$lambda-63  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final io.reactivex.ObservableSource m1994overwriteHighlightedService$lambda63(java.lang.String r9, id.dana.data.services.repository.ServicesEntityRepository r10, j$.util.Optional r11) {
        /*
            int r0 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult
            int r0 = r0 + 67
            int r1 = r0 % 128
            id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            java.lang.String r1 = ""
            if (r0 != 0) goto L2a
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            boolean r0 = r11.KClassImpl$Data$declaredNonStaticMembers$2()
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L28
            r2 = 1
            if (r0 == 0) goto L24
            r0 = 0
            goto L25
        L24:
            r0 = 1
        L25:
            if (r0 == r2) goto L40
            goto L47
        L28:
            r9 = move-exception
            throw r9
        L2a:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            boolean r0 = r11.KClassImpl$Data$declaredNonStaticMembers$2()
            r2 = 6
            if (r0 == 0) goto L3c
            r0 = 6
            goto L3e
        L3c:
            r0 = 58
        L3e:
            if (r0 == r2) goto L47
        L40:
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            io.reactivex.Observable r9 = io.reactivex.Observable.just(r9)
            goto L7f
        L47:
            java.lang.Object r11 = r11.PlaceComponentResult
            r0 = 32
            if (r11 == 0) goto L50
            r2 = 73
            goto L52
        L50:
            r2 = 32
        L52:
            if (r2 == r0) goto L84
            int r0 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult
            int r0 = r0 + 61
            int r2 = r0 % 128
            id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r2
            int r0 = r0 % 2
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)     // Catch: java.lang.Exception -> L82
            r2 = r11
            id.dana.data.services.repository.source.model.ServiceHighlighted r2 = (id.dana.data.services.repository.source.model.ServiceHighlighted) r2     // Catch: java.lang.Exception -> L82
            long r4 = id.dana.data.util.DateTimeUtil.getCurrentTimeMillis()     // Catch: java.lang.Exception -> L82
            r6 = 0
            r7 = 4
            r8 = 0
            r3 = r9
            id.dana.data.services.repository.source.model.ServiceHighlighted r9 = id.dana.data.services.repository.source.model.ServiceHighlighted.copy$default(r2, r3, r4, r6, r7, r8)     // Catch: java.lang.Exception -> L82
            id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData r10 = r10.preferenceFavoriteServicesEntityData     // Catch: java.lang.Exception -> L82
            io.reactivex.Observable r9 = r10.saveServiceHighlighted(r9)     // Catch: java.lang.Exception -> L82
            id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda21 r10 = new id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda21     // Catch: java.lang.Exception -> L82
            r10.<init>()     // Catch: java.lang.Exception -> L82
            io.reactivex.Observable r9 = r9.map(r10)     // Catch: java.lang.Exception -> L82
        L7f:
            io.reactivex.ObservableSource r9 = (io.reactivex.ObservableSource) r9
            return r9
        L82:
            r9 = move-exception
            throw r9
        L84:
            java.util.NoSuchElementException r9 = new java.util.NoSuchElementException
            java.lang.String r10 = "No value present"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.m1994overwriteHighlightedService$lambda63(java.lang.String, id.dana.data.services.repository.ServicesEntityRepository, j$.util.Optional):io.reactivex.ObservableSource");
    }

    /* renamed from: overwriteHighlightedService$lambda-63$lambda-62  reason: not valid java name */
    private static final Boolean m1995overwriteHighlightedService$lambda63$lambda62(ServiceHighlighted serviceHighlighted) {
        Boolean bool;
        int i = MyBillsEntityDataFactory + 25;
        PlaceComponentResult = i % 128;
        Object[] objArr = null;
        if ((i % 2 != 0 ? 'c' : 'S') != 'c') {
            Intrinsics.checkNotNullParameter(serviceHighlighted, "");
            bool = Boolean.TRUE;
        } else {
            Intrinsics.checkNotNullParameter(serviceHighlighted, "");
            bool = Boolean.TRUE;
            int length = objArr.length;
        }
        int i2 = MyBillsEntityDataFactory + 65;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 != 0 ? Typography.less : 'Z') != '<') {
            return bool;
        }
        objArr.hashCode();
        return bool;
    }

    @JvmName(name = "getAllServicesWithDefaultValue")
    public final Observable<Map<CategoryServices, List<ThirdPartyEntity>>> getAllServicesWithDefaultValue() {
        Observable<Map<CategoryServices, List<ThirdPartyEntity>>> doOnError = getAllMapServices().doOnError(new Consumer() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ServicesEntityRepository.m1953$r8$lambda$sLQabbjQD2_Td3Ffd9BNUxux3E((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnError, "");
        int i = MyBillsEntityDataFactory + 79;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return doOnError;
    }

    /* renamed from: _get_allServicesWithDefaultValue_$lambda-64  reason: not valid java name */
    private static final void m1957_get_allServicesWithDefaultValue_$lambda64(Throwable th) {
        int i = MyBillsEntityDataFactory + 57;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Crashlytics.Companion companion = Crashlytics.INSTANCE;
        Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
        Intrinsics.checkNotNullParameter("case", "");
        Intrinsics.checkNotNullParameter("Get All Service With Default Value", "");
        authRequestContext.getAuthRequestContext.setCustomKey("case", "Get All Service With Default Value");
        Intrinsics.checkNotNullExpressionValue(th, "");
        Intrinsics.checkNotNullParameter(th, "");
        authRequestContext.getAuthRequestContext.recordException(th);
        int i3 = PlaceComponentResult + 69;
        MyBillsEntityDataFactory = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public final Observable<List<ThirdPartyCategoryService>> getFilteredServices(final List<String> keywords, final String filterBy) {
        Intrinsics.checkNotNullParameter(keywords, "");
        Intrinsics.checkNotNullParameter(filterBy, "");
        Observable<List<ThirdPartyCategoryService>> map = getAllServicesWithDefaultValue().map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.m1955$r8$lambda$zt6UiwiJ2XV1GeAY6gbphgCSU(filterBy, keywords, (Map) obj);
            }
        }).map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ServicesEntityRepository.$r8$lambda$gy4nEjhb_FPI4Kg_hR875W35BTU(ServicesEntityRepository.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = MyBillsEntityDataFactory + 59;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return map;
    }

    private final Observable<ServicesEntityData> createServiceSource() {
        Observable<ServicesEntityData> just;
        int i = PlaceComponentResult + 43;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 == 0) {
            try {
                try {
                    just = Observable.just(this.servicesEntityDataFactory.createData2("split"));
                    Intrinsics.checkNotNullExpressionValue(just, "");
                    Object obj = null;
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            just = Observable.just(this.servicesEntityDataFactory.createData2("split"));
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        int i2 = PlaceComponentResult + 87;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        return just;
    }

    private final ServicesEntityData createDefaultServices() {
        int i = MyBillsEntityDataFactory + 29;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            ServicesEntityData createData2 = this.servicesEntityDataFactory.createData2("local");
            int i3 = MyBillsEntityDataFactory + 119;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? 'F' : 'Q') != 'F') {
                return createData2;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return createData2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getSplitSourceServices")
    private final ServicesEntityData getSplitSourceServices() {
        int i = PlaceComponentResult + 17;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        ServicesEntityData servicesEntityData = (ServicesEntityData) this.splitSourceServices.getValue();
        int i3 = MyBillsEntityDataFactory + 85;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 31 : 'I') != 'I') {
            Object obj = null;
            obj.hashCode();
            return servicesEntityData;
        }
        return servicesEntityData;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if ((r6.isEmpty() ? '[' : 2) != 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        if (serviceHaveBlank(r6) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        r6 = getAllCategories().flatMap(new id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda24(r5));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        r6 = new java.util.ArrayList();
        r6.add(id.dana.domain.services.Category.FEATURED);
        r6 = getServicesByCategoryKey(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        r0 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult + 85;
        id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        if ((!r0 ? '[' : '6') != '[') goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final io.reactivex.Observable<java.util.List<id.dana.domain.services.model.ThirdPartyCategoryService>> getCategoryFeaturedServices(java.util.List<java.lang.String> r6) {
        /*
            r5 = this;
            int r0 = id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 91
            java.lang.String r3 = ""
            if (r0 == 0) goto L25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            boolean r0 = r6.isEmpty()
            r4 = 0
            int r4 = r4.length     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto L1e
            r0 = 91
            goto L20
        L1e:
            r0 = 54
        L20:
            if (r0 == r2) goto L32
            goto L4b
        L23:
            r6 = move-exception
            throw r6
        L25:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L2f
            r2 = 2
        L2f:
            if (r2 == r1) goto L32
            goto L4b
        L32:
            boolean r6 = r5.serviceHaveBlank(r6)
            if (r6 != 0) goto L4b
            io.reactivex.Observable r6 = r5.getAllCategories()     // Catch: java.lang.Exception -> L49
            id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda24 r0 = new id.dana.data.services.repository.ServicesEntityRepository$$ExternalSyntheticLambda24     // Catch: java.lang.Exception -> L49
            r0.<init>()     // Catch: java.lang.Exception -> L49
            io.reactivex.Observable r6 = r6.flatMap(r0)     // Catch: java.lang.Exception -> L49
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)     // Catch: java.lang.Exception -> L49
            goto L64
        L49:
            r6 = move-exception
            throw r6
        L4b:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            java.lang.String r0 = "category_featured"
            r6.add(r0)
            io.reactivex.Observable r6 = r5.getServicesByCategoryKey(r6)
            int r0 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult     // Catch: java.lang.Exception -> L65
            int r0 = r0 + 85
            int r2 = r0 % 128
            id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r2     // Catch: java.lang.Exception -> L65
            int r0 = r0 % r1
        L64:
            return r6
        L65:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.getCategoryFeaturedServices(java.util.List):io.reactivex.Observable");
    }

    /* renamed from: getCategoryFeaturedServices$lambda-75  reason: not valid java name */
    private static final ObservableSource m1966getCategoryFeaturedServices$lambda75(ServicesEntityRepository servicesEntityRepository, List list) {
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        try {
            int i = MyBillsEntityDataFactory + 85;
            try {
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                while (true) {
                    if ((it.hasNext() ? ',' : (char) 2) != ',') {
                        return servicesEntityRepository.getServicesByCategoryKey(arrayList);
                    }
                    int i3 = MyBillsEntityDataFactory + 117;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                    arrayList.add(((CategoryServicesModel) it.next()).getCategory());
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean serviceHaveBlank(java.util.List<java.lang.String> r5) {
        /*
            r4 = this;
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r0 = r5 instanceof java.util.Collection
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L12
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L12
            goto L61
        L12:
            java.util.Iterator r5 = r5.iterator()
        L16:
            boolean r0 = r5.hasNext()
            r3 = 83
            if (r0 == 0) goto L21
            r0 = 38
            goto L23
        L21:
            r0 = 83
        L23:
            if (r0 == r3) goto L61
            java.lang.Object r0 = r5.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L56
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)     // Catch: java.lang.Exception -> L54
            r3 = 29
            if (r0 != 0) goto L3a
            r0 = 44
            goto L3c
        L3a:
            r0 = 29
        L3c:
            if (r0 == r3) goto L56
            int r0 = id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L6c
            int r0 = r0 + 7
            int r3 = r0 % 128
            id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult = r3     // Catch: java.lang.Exception -> L6c
            int r0 = r0 % 2
            int r0 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult
            int r0 = r0 + 89
            int r3 = r0 % 128
            id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r3
            int r0 = r0 % 2
            r0 = 0
            goto L57
        L54:
            r5 = move-exception
            throw r5
        L56:
            r0 = 1
        L57:
            if (r0 == 0) goto L5b
            r0 = 1
            goto L5c
        L5b:
            r0 = 0
        L5c:
            if (r0 == r2) goto L5f
            goto L16
        L5f:
            r1 = 1
            goto L6b
        L61:
            int r5 = id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L6c
            int r5 = r5 + 95
            int r0 = r5 % 128
            id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult = r0     // Catch: java.lang.Exception -> L6c
            int r5 = r5 % 2
        L6b:
            return r1
        L6c:
            r5 = move-exception
            goto L6f
        L6e:
            throw r5
        L6f:
            goto L6e
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.serviceHaveBlank(java.util.List):boolean");
    }

    private final ThirdPartyCategoryService getSendMoneyService() {
        ThirdPartyCategoryService thirdPartyCategoryService = new ThirdPartyCategoryService();
        thirdPartyCategoryService.setKey("send_money");
        int i = PlaceComponentResult + 59;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 == 0)) {
            return thirdPartyCategoryService;
        }
        Object obj = null;
        obj.hashCode();
        return thirdPartyCategoryService;
    }

    private final ThirdPartyCategoryService getTopupService() {
        ThirdPartyCategoryService thirdPartyCategoryService = new ThirdPartyCategoryService();
        Object[] objArr = new Object[1];
        a(new int[]{0, 5, 140, 0}, true, new byte[]{0, 1, 1, 1, 1}, objArr);
        thirdPartyCategoryService.setKey(((String) objArr[0]).intern());
        int i = MyBillsEntityDataFactory + 23;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return thirdPartyCategoryService;
    }

    private final List<ThirdPartyServiceResponse> sortServicesWithGivenList(List<String> serviceKeys, List<ThirdPartyServiceResponse> serviceResponses) {
        try {
            Iterable withIndex = CollectionsKt.withIndex(serviceKeys);
            final LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(withIndex, 10)), 16));
            Iterator it = withIndex.iterator();
            try {
                int i = PlaceComponentResult + 123;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                while (true) {
                    if ((it.hasNext() ? (char) 23 : 'H') == 23) {
                        int i3 = MyBillsEntityDataFactory + 113;
                        PlaceComponentResult = i3 % 128;
                        int i4 = i3 % 2;
                        IndexedValue indexedValue = (IndexedValue) it.next();
                        Pair pair = TuplesKt.to(indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
                        linkedHashMap.put(pair.getFirst(), pair.getSecond());
                    } else {
                        return CollectionsKt.sortedWith(serviceResponses, new Comparator() { // from class: id.dana.data.services.repository.ServicesEntityRepository$sortServicesWithGivenList$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues((Integer) linkedHashMap.get(((ThirdPartyServiceResponse) t).getKey()), (Integer) linkedHashMap.get(((ThirdPartyServiceResponse) t2).getKey()));
                            }
                        });
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: getAllListOfService$lambda-13  reason: not valid java name */
    private static final List m1960getAllListOfService$lambda13(ServicesEntityRepository servicesEntityRepository, List list) {
        Object[] objArr;
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            objArr = null;
            if ((it.hasNext() ? '/' : 'b') == 'b') {
                break;
            }
            int i = MyBillsEntityDataFactory + 63;
            PlaceComponentResult = i % 128;
            if ((i % 2 != 0 ? 'R' : (char) 20) != 'R') {
                List<ThirdPartyEntity> blockingFirst = servicesEntityRepository.getListOfService(((CategoryServices) it.next()).getCategory()).blockingFirst();
                Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
                CollectionsKt.addAll(arrayList, blockingFirst);
            } else {
                List<ThirdPartyEntity> blockingFirst2 = servicesEntityRepository.getListOfService(((CategoryServices) it.next()).getCategory()).blockingFirst();
                Intrinsics.checkNotNullExpressionValue(blockingFirst2, "");
                CollectionsKt.addAll(arrayList, blockingFirst2);
                int length = objArr.length;
            }
        }
        ArrayList arrayList2 = arrayList;
        int i2 = PlaceComponentResult + 77;
        MyBillsEntityDataFactory = i2 % 128;
        if ((i2 % 2 != 0 ? 'H' : (char) 20) != 'H') {
            int length2 = objArr.length;
            return arrayList2;
        }
        return arrayList2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0091, code lost:
    
        if ((r4 != null ? 27 : '9') != '9') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a3, code lost:
    
        if (r4 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a9, code lost:
    
        if (r4.isEmpty() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ab, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ad, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ae, code lost:
    
        if (r4 == true) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b0, code lost:
    
        r4 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult + 29;
        id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bc, code lost:
    
        if ((r4 % 2) != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c4, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c7, code lost:
    
        if ((true ^ r3) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c9, code lost:
    
        r1 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cc, code lost:
    
        r1 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cd, code lost:
    
        if (r1 == 5) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cf, code lost:
    
        r1 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult + 29;
        id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r1 % 128;
        r1 = r1 % 2;
        r7.add(r0);
     */
    /* renamed from: getAllServices$lambda-19  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.List m1964getAllServices$lambda19(id.dana.data.services.repository.ServicesEntityRepository r7, java.util.Map r8) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.m1964getAllServices$lambda19(id.dana.data.services.repository.ServicesEntityRepository, java.util.Map):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c6, code lost:
    
        if (r0 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d8, code lost:
    
        if (r0 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00de, code lost:
    
        if (r0.isEmpty() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e0, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e2, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e4, code lost:
    
        if ((!r0) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e6, code lost:
    
        r0 = id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory + 95;
        id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f2, code lost:
    
        if ((r0 % 2) == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f4, code lost:
    
        r0 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f7, code lost:
    
        r0 = kotlin.text.Typography.greater;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f9, code lost:
    
        if (r0 == '>') goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00fb, code lost:
    
        r6.add(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0100, code lost:
    
        r7 = 66 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0104, code lost:
    
        r6.add(r7);
     */
    /* renamed from: getServicesByCategoryKeyDefault$lambda-31  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.List m1992getServicesByCategoryKeyDefault$lambda31(java.util.List r5, id.dana.data.services.repository.ServicesEntityRepository r6, java.util.Map r7) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.m1992getServicesByCategoryKeyDefault$lambda31(java.util.List, id.dana.data.services.repository.ServicesEntityRepository, java.util.Map):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bc, code lost:
    
        if ((!r8.isEnable()) != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cb, code lost:
    
        if (r9 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d9, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r8.getKey(), id.dana.data.services.repository.ServicesEntityRepository.SERVICE_GAMES) != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00db, code lost:
    
        r8 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00de, code lost:
    
        r8 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e0, code lost:
    
        if (r8 == '?') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e2, code lost:
    
        r8 = id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult + 53;
        id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory = r8 % 128;
        r8 = r8 % 2;
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ee, code lost:
    
        r8 = false;
     */
    /* renamed from: getDefaultSkuExplore$lambda-41  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.List m1967getDefaultSkuExplore$lambda41(id.dana.data.services.repository.ServicesEntityRepository r11, java.util.List r12, java.util.List r13) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.m1967getDefaultSkuExplore$lambda41(id.dana.data.services.repository.ServicesEntityRepository, java.util.List, java.util.List):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x007c, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r9, "name") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0096, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r9, "name") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0098, code lost:
    
        r2 = new java.util.ArrayList();
        r1 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a9, code lost:
    
        if (r1.hasNext() == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ab, code lost:
    
        r6 = r1.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bd, code lost:
    
        if (kotlin.collections.CollectionsKt.contains(r10, ((id.dana.data.homeinfo.model.ThirdPartyEntity) r6).getName()) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bf, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c1, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c2, code lost:
    
        if (r7 == true) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c5, code lost:
    
        r2.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c9, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ce, code lost:
    
        r2 = new java.util.ArrayList();
        r1 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e1, code lost:
    
        if (r1.hasNext() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e3, code lost:
    
        r6 = '=';
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e6, code lost:
    
        r6 = 28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e8, code lost:
    
        if (r6 == 28) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ea, code lost:
    
        r6 = r1.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fc, code lost:
    
        if (kotlin.collections.CollectionsKt.contains(r10, ((id.dana.data.homeinfo.model.ThirdPartyEntity) r6).getKey()) == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00fe, code lost:
    
        r7 = id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory + 47;
        id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0108, code lost:
    
        r2.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x010c, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x010f, code lost:
    
        continue;
     */
    /* renamed from: getFilteredServices$lambda-70  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.Map m1975getFilteredServices$lambda70(java.lang.String r9, java.util.List r10, java.util.Map r11) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.m1975getFilteredServices$lambda70(java.lang.String, java.util.List, java.util.Map):java.util.Map");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
    
        if ((r3 != null ? 'Q' : 'P') != 'P') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009b, code lost:
    
        if (r3 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009d, code lost:
    
        r4 = id.dana.data.services.repository.ServicesEntityRepository.MyBillsEntityDataFactory + 67;
        id.dana.data.services.repository.ServicesEntityRepository.PlaceComponentResult = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a7, code lost:
    
        if ((r4 % 2) == 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00af, code lost:
    
        r4 = 82 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
    
        if (r3.isEmpty() != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b9, code lost:
    
        if (r3.isEmpty() != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bb, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bd, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00be, code lost:
    
        if (r3 == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c1, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c3, code lost:
    
        if ((true ^ r2) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c5, code lost:
    
        r6.add(r0);
     */
    /* renamed from: getFilteredServices$lambda-73  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.List m1976getFilteredServices$lambda73(id.dana.data.services.repository.ServicesEntityRepository r6, java.util.Map r7) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.m1976getFilteredServices$lambda73(id.dana.data.services.repository.ServicesEntityRepository, java.util.Map):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00db A[Catch: Exception -> 0x0111, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0111, blocks: (B:6:0x002b, B:44:0x00db, B:62:0x010d, B:63:0x0110), top: B:71:0x0023 }] */
    @id.dana.utils.jacoco.ExcludeFromJacocoGeneratedReport
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getNextEnableHighlightedService(id.dana.data.services.repository.source.model.CategoryHighlightedFeature r20, j$.util.Optional<id.dana.data.services.repository.source.model.ServiceHighlighted> r21, final long r22, final kotlin.jvm.functions.Function2<? super j$.util.Optional<id.dana.domain.homeinfo.ThirdPartyServiceResponse>, ? super id.dana.data.services.repository.source.model.ServiceHighlighted, kotlin.Unit> r24) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.getNextEnableHighlightedService(id.dana.data.services.repository.source.model.CategoryHighlightedFeature, j$.util.Optional, long, kotlin.jvm.functions.Function2):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
    
        if ((r18[r0.BuiltInFictitiousFunctionClassFactory] != 0) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007e, code lost:
    
        if (r18[r0.BuiltInFictitiousFunctionClassFactory] == 1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0080, code lost:
    
        r2[r0.BuiltInFictitiousFunctionClassFactory] = (char) (((r9[r0.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008e, code lost:
    
        r2[r0.BuiltInFictitiousFunctionClassFactory] = (char) ((r9[r0.BuiltInFictitiousFunctionClassFactory] * 2) - r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int[] r16, boolean r17, byte[] r18, java.lang.Object[] r19) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.ServicesEntityRepository.a(int[], boolean, byte[], java.lang.Object[]):void");
    }
}
