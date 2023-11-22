package id.dana.data.wallet_v3.repository;

import id.dana.animation.HomeTabActivity;
import id.dana.danah5.DanaH5;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.homeinfo.mapper.HomeInfoResultMapper;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import id.dana.data.services.repository.source.ServicesEntityData;
import id.dana.data.services.repository.source.ServicesEntityDataFactory;
import id.dana.data.wallet_v3.repository.source.local.LocalWalletConfigEntityData;
import id.dana.data.wallet_v3.repository.source.network.WalletConfigEntityData;
import id.dana.data.wallet_v3.repository.source.network.WalletConfigEntityDataFactory;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.wallet_v3.model.SearchCategory;
import id.dana.domain.wallet_v3.model.WalletConfig;
import id.dana.domain.wallet_v3.model.WalletSearch;
import id.dana.domain.wallet_v3.model.WalletV3AddAssetServices;
import id.dana.domain.wallet_v3.model.WalletV3Config;
import id.dana.domain.wallet_v3.model.WalletV3RestrictedErrorCodes;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 C2\u00020\u0001:\u0001CB)\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\bA\u0010BJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J#\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00050\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0010J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0013J#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\bJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020&8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020,8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00103\u001a\u00020/8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b0\u0010(\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b5\u0010(\u001a\u0004\b6\u00107R\u0014\u0010:\u001a\u0002098\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\"\u0010<\u001a\u00020\u001b8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010\u001f"}, d2 = {"Lid/dana/data/wallet_v3/repository/WalletConfigEntityRepository;", "Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "", HomeTabActivity.WALLET_SECTION, "Lio/reactivex/Observable;", "", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "getBottomSheetServices", "(I)Lio/reactivex/Observable;", "", "services", "Lid/dana/data/homeinfo/model/ThirdPartyEntity;", "getListOfService", "(Ljava/util/List;)Lio/reactivex/Observable;", DanaH5.SERVICE_KEY, "getServiceFromServiceKey", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/model/WalletConfig;", "getWalletConfig", "()Lio/reactivex/Observable;", "getWalletConfigFromLocal", "category", "Lid/dana/domain/wallet_v3/model/SearchCategory;", "getWalletSearchCategory", "Lid/dana/domain/wallet_v3/model/WalletV3RestrictedErrorCodes;", "getWalletV3RestrictedErrorCodes", "handleGetListOfService", "Lid/dana/domain/wallet_v3/model/WalletV3Config;", "walletV3Config", "", "setWalletV3Config", "(Lid/dana/domain/wallet_v3/model/WalletV3Config;)V", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "configEntityDataFactory", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "Lid/dana/data/homeinfo/mapper/HomeInfoResultMapper;", "homeInfoResultMapper", "Lid/dana/data/homeinfo/mapper/HomeInfoResultMapper;", "Lid/dana/data/wallet_v3/repository/source/network/WalletConfigEntityData;", "localWalletConfigEntityData$delegate", "Lkotlin/Lazy;", "getLocalWalletConfigEntityData", "()Lid/dana/data/wallet_v3/repository/source/network/WalletConfigEntityData;", "localWalletConfigEntityData", "Lid/dana/data/services/repository/source/ServicesEntityDataFactory;", "servicesEntityDataFactory", "Lid/dana/data/services/repository/source/ServicesEntityDataFactory;", "Lid/dana/data/config/source/ConfigEntityData;", "splitConfigEntityData$delegate", "getSplitConfigEntityData", "()Lid/dana/data/config/source/ConfigEntityData;", "splitConfigEntityData", "Lid/dana/data/services/repository/source/ServicesEntityData;", "splitSourceServices$delegate", "getSplitSourceServices", "()Lid/dana/data/services/repository/source/ServicesEntityData;", "splitSourceServices", "Lid/dana/data/wallet_v3/repository/source/network/WalletConfigEntityDataFactory;", "walletConfigEntityDataFactory", "Lid/dana/data/wallet_v3/repository/source/network/WalletConfigEntityDataFactory;", "walletV3ConfigResult", "Lid/dana/domain/wallet_v3/model/WalletV3Config;", "getWalletV3ConfigResult$data_productionRelease", "()Lid/dana/domain/wallet_v3/model/WalletV3Config;", "setWalletV3ConfigResult$data_productionRelease", "<init>", "(Lid/dana/data/config/source/ConfigEntityDataFactory;Lid/dana/data/wallet_v3/repository/source/network/WalletConfigEntityDataFactory;Lid/dana/data/services/repository/source/ServicesEntityDataFactory;Lid/dana/data/homeinfo/mapper/HomeInfoResultMapper;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WalletConfigEntityRepository implements WalletConfigRepository {
    public static final int FINANCIAL = 2;
    public static final int IDENTITY = 5;
    public static final int LOYALTY = 4;
    public static final int PAYMENT = 1;
    public static final int VOUCHER = 3;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final HomeInfoResultMapper homeInfoResultMapper;

    /* renamed from: localWalletConfigEntityData$delegate  reason: from kotlin metadata */
    private final Lazy localWalletConfigEntityData;
    private final ServicesEntityDataFactory servicesEntityDataFactory;

    /* renamed from: splitConfigEntityData$delegate  reason: from kotlin metadata */
    private final Lazy splitConfigEntityData;

    /* renamed from: splitSourceServices$delegate  reason: from kotlin metadata */
    private final Lazy splitSourceServices;
    private final WalletConfigEntityDataFactory walletConfigEntityDataFactory;
    private WalletV3Config walletV3ConfigResult;

    @Inject
    public WalletConfigEntityRepository(ConfigEntityDataFactory configEntityDataFactory, WalletConfigEntityDataFactory walletConfigEntityDataFactory, ServicesEntityDataFactory servicesEntityDataFactory, HomeInfoResultMapper homeInfoResultMapper) {
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(walletConfigEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(servicesEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(homeInfoResultMapper, "");
        this.configEntityDataFactory = configEntityDataFactory;
        this.walletConfigEntityDataFactory = walletConfigEntityDataFactory;
        this.servicesEntityDataFactory = servicesEntityDataFactory;
        this.homeInfoResultMapper = homeInfoResultMapper;
        this.walletV3ConfigResult = new WalletV3Config(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
        this.splitConfigEntityData = LazyKt.lazy(new Function0<ConfigEntityData>() { // from class: id.dana.data.wallet_v3.repository.WalletConfigEntityRepository$splitConfigEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConfigEntityData invoke() {
                ConfigEntityDataFactory configEntityDataFactory2;
                configEntityDataFactory2 = WalletConfigEntityRepository.this.configEntityDataFactory;
                return configEntityDataFactory2.createData2("split");
            }
        });
        this.localWalletConfigEntityData = LazyKt.lazy(new Function0<LocalWalletConfigEntityData>() { // from class: id.dana.data.wallet_v3.repository.WalletConfigEntityRepository$localWalletConfigEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LocalWalletConfigEntityData invoke() {
                WalletConfigEntityDataFactory walletConfigEntityDataFactory2;
                walletConfigEntityDataFactory2 = WalletConfigEntityRepository.this.walletConfigEntityDataFactory;
                return walletConfigEntityDataFactory2.createData2("local");
            }
        });
        this.splitSourceServices = LazyKt.lazy(new Function0<ServicesEntityData>() { // from class: id.dana.data.wallet_v3.repository.WalletConfigEntityRepository$splitSourceServices$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ServicesEntityData invoke() {
                ServicesEntityDataFactory servicesEntityDataFactory2;
                servicesEntityDataFactory2 = WalletConfigEntityRepository.this.servicesEntityDataFactory;
                return servicesEntityDataFactory2.createData2("split");
            }
        });
    }

    @JvmName(name = "getWalletV3ConfigResult$data_productionRelease")
    /* renamed from: getWalletV3ConfigResult$data_productionRelease  reason: from getter */
    public final WalletV3Config getWalletV3ConfigResult() {
        return this.walletV3ConfigResult;
    }

    @JvmName(name = "setWalletV3ConfigResult$data_productionRelease")
    public final void setWalletV3ConfigResult$data_productionRelease(WalletV3Config walletV3Config) {
        Intrinsics.checkNotNullParameter(walletV3Config, "");
        this.walletV3ConfigResult = walletV3Config;
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletConfigRepository
    public final Observable<WalletConfig> getWalletConfig() {
        Observable<WalletConfig> doOnNext = getSplitConfigEntityData().getWalletConfig().doOnNext(new Consumer() { // from class: id.dana.data.wallet_v3.repository.WalletConfigEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WalletConfigEntityRepository.m2174getWalletConfig$lambda0(WalletConfigEntityRepository.this, (WalletConfig) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.wallet_v3.repository.WalletConfigEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WalletConfigEntityRepository.m2175getWalletConfig$lambda1(WalletConfigEntityRepository.this, (WalletConfig) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getWalletConfig$lambda-0  reason: not valid java name */
    public static final void m2174getWalletConfig$lambda0(WalletConfigEntityRepository walletConfigEntityRepository, WalletConfig walletConfig) {
        Intrinsics.checkNotNullParameter(walletConfigEntityRepository, "");
        WalletConfigEntityData localWalletConfigEntityData = walletConfigEntityRepository.getLocalWalletConfigEntityData();
        Intrinsics.checkNotNullExpressionValue(walletConfig, "");
        localWalletConfigEntityData.saveWalletConfig(walletConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getWalletConfig$lambda-1  reason: not valid java name */
    public static final void m2175getWalletConfig$lambda1(WalletConfigEntityRepository walletConfigEntityRepository, WalletConfig walletConfig) {
        Intrinsics.checkNotNullParameter(walletConfigEntityRepository, "");
        walletConfigEntityRepository.setWalletV3Config(walletConfig.getWalletV3());
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletConfigRepository
    public final Observable<WalletConfig> getWalletConfigFromLocal() {
        return getLocalWalletConfigEntityData().getWalletConfig();
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletConfigRepository
    public final Observable<List<ThirdPartyServiceResponse>> getBottomSheetServices(int section) {
        Observable map = handleGetListOfService(section).map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletConfigEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2172getBottomSheetServices$lambda3;
                m2172getBottomSheetServices$lambda3 = WalletConfigEntityRepository.m2172getBottomSheetServices$lambda3(WalletConfigEntityRepository.this, (List) obj);
                return m2172getBottomSheetServices$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBottomSheetServices$lambda-3  reason: not valid java name */
    public static final List m2172getBottomSheetServices$lambda3(WalletConfigEntityRepository walletConfigEntityRepository, List list) {
        Intrinsics.checkNotNullParameter(walletConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ThirdPartyServiceResponse transform = walletConfigEntityRepository.homeInfoResultMapper.transform((ThirdPartyEntity) it.next());
            if (transform != null) {
                arrayList.add(transform);
            }
        }
        return arrayList;
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletConfigRepository
    public final Observable<List<SearchCategory>> getWalletSearchCategory(final String category) {
        Intrinsics.checkNotNullParameter(category, "");
        Observable map = getSplitConfigEntityData().getSearchCategory().map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletConfigEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2176getWalletSearchCategory$lambda4;
                m2176getWalletSearchCategory$lambda4 = WalletConfigEntityRepository.m2176getWalletSearchCategory$lambda4(category, (WalletSearch) obj);
                return m2176getWalletSearchCategory$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getWalletSearchCategory$lambda-4  reason: not valid java name */
    public static final List m2176getWalletSearchCategory$lambda4(String str, WalletSearch walletSearch) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(walletSearch, "");
        int hashCode = str.hashCode();
        if (hashCode != -786681338) {
            if (hashCode != -80148248) {
                if (hashCode == 357555337 && str.equals("financial")) {
                    return walletSearch.getSearchFinancial();
                }
            } else if (str.equals("general")) {
                return walletSearch.getSearchGeneral();
            }
        } else if (str.equals("payment")) {
            return walletSearch.getSearchPayment();
        }
        return CollectionsKt.emptyList();
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletConfigRepository
    public final Observable<WalletV3RestrictedErrorCodes> getWalletV3RestrictedErrorCodes() {
        Observable<WalletV3RestrictedErrorCodes> walletV3RestrictedErrorCodes = getSplitConfigEntityData().getWalletV3RestrictedErrorCodes();
        Intrinsics.checkNotNullExpressionValue(walletV3RestrictedErrorCodes, "");
        return walletV3RestrictedErrorCodes;
    }

    private final Observable<List<ThirdPartyEntity>> handleGetListOfService(int section) {
        List<String> services;
        if (section == 1) {
            WalletV3AddAssetServices categoryPayment = this.walletV3ConfigResult.getCategoryPayment();
            services = categoryPayment != null ? categoryPayment.getServices() : null;
            if (services == null) {
                services = CollectionsKt.emptyList();
            }
            return getListOfService(services);
        } else if (section == 2) {
            WalletV3AddAssetServices categoryFinancial = this.walletV3ConfigResult.getCategoryFinancial();
            services = categoryFinancial != null ? categoryFinancial.getServices() : null;
            if (services == null) {
                services = CollectionsKt.emptyList();
            }
            return getListOfService(services);
        } else if (section == 3) {
            WalletV3AddAssetServices categoryVoucherAndTicket = this.walletV3ConfigResult.getCategoryVoucherAndTicket();
            services = categoryVoucherAndTicket != null ? categoryVoucherAndTicket.getServices() : null;
            if (services == null) {
                services = CollectionsKt.emptyList();
            }
            return getListOfService(services);
        } else if (section == 4) {
            WalletV3AddAssetServices categoryLoyalty = this.walletV3ConfigResult.getCategoryLoyalty();
            services = categoryLoyalty != null ? categoryLoyalty.getServices() : null;
            if (services == null) {
                services = CollectionsKt.emptyList();
            }
            return getListOfService(services);
        } else {
            WalletV3AddAssetServices categoryIdentity = this.walletV3ConfigResult.getCategoryIdentity();
            services = categoryIdentity != null ? categoryIdentity.getServices() : null;
            if (services == null) {
                services = CollectionsKt.emptyList();
            }
            return getListOfService(services);
        }
    }

    private final Observable<List<ThirdPartyEntity>> getListOfService(List<String> services) {
        Observable<List<ThirdPartyEntity>> just = Observable.just(SequencesKt.toList(SequencesKt.distinctBy(SequencesKt.filter(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(services), new Function1<String, Boolean>() { // from class: id.dana.data.wallet_v3.repository.WalletConfigEntityRepository$getListOfService$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return Boolean.valueOf(str.length() > 0);
            }
        }), new WalletConfigEntityRepository$getListOfService$2(this)), new Function1<ThirdPartyEntity, Boolean>() { // from class: id.dana.data.wallet_v3.repository.WalletConfigEntityRepository$getListOfService$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ThirdPartyEntity thirdPartyEntity) {
                return Boolean.valueOf(thirdPartyEntity.getName() != null);
            }
        }), new Function1<ThirdPartyEntity, String>() { // from class: id.dana.data.wallet_v3.repository.WalletConfigEntityRepository$getListOfService$4
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(ThirdPartyEntity thirdPartyEntity) {
                return thirdPartyEntity.getKey();
            }
        })));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<ThirdPartyEntity> getServiceFromServiceKey(final String serviceKey) {
        Observable<ThirdPartyEntity> defer = Observable.defer(new Callable() { // from class: id.dana.data.wallet_v3.repository.WalletConfigEntityRepository$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m2173getServiceFromServiceKey$lambda5;
                m2173getServiceFromServiceKey$lambda5 = WalletConfigEntityRepository.m2173getServiceFromServiceKey$lambda5(WalletConfigEntityRepository.this, serviceKey);
                return m2173getServiceFromServiceKey$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getServiceFromServiceKey$lambda-5  reason: not valid java name */
    public static final ObservableSource m2173getServiceFromServiceKey$lambda5(WalletConfigEntityRepository walletConfigEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(walletConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return walletConfigEntityRepository.getSplitSourceServices().getService(str).onErrorResumeNext(Observable.just(new ThirdPartyEntity(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, null, null, false, null, null, null, null, false, null, null, null, null, null, null, -8193, 7, null)));
    }

    private final void setWalletV3Config(WalletV3Config walletV3Config) {
        this.walletV3ConfigResult = walletV3Config;
    }

    @JvmName(name = "getSplitConfigEntityData")
    private final ConfigEntityData getSplitConfigEntityData() {
        Object value = this.splitConfigEntityData.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        return (ConfigEntityData) value;
    }

    @JvmName(name = "getLocalWalletConfigEntityData")
    private final WalletConfigEntityData getLocalWalletConfigEntityData() {
        return (WalletConfigEntityData) this.localWalletConfigEntityData.getValue();
    }

    @JvmName(name = "getSplitSourceServices")
    private final ServicesEntityData getSplitSourceServices() {
        return (ServicesEntityData) this.splitSourceServices.getValue();
    }
}
