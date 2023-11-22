package id.dana.domain.wallet_v3.interactor;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.wallet_v3.constant.WalletRecommendationConstant;
import id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation;
import id.dana.domain.wallet_v3.model.AssetRecommendation;
import id.dana.domain.wallet_v3.model.WalletConfig;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001#B!\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b!\u0010\"J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJC\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00022\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0002\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetDynamicRecommendation;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/wallet_v3/model/AssetRecommendation;", "Lid/dana/domain/wallet_v3/interactor/GetDynamicRecommendation$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/GetDynamicRecommendation$Params;)Lio/reactivex/Observable;", "configs", "Lid/dana/domain/wallet_v3/model/WalletConfig;", "walletConfig", "filterEnableService", "(Ljava/util/List;Lid/dana/domain/wallet_v3/model/WalletConfig;)Lio/reactivex/Observable;", "", UserMetadata.KEYDATA_FILENAME, "Lkotlin/Function1;", "", "isContains", "getRecommendationConfigs", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "sectionType", "isSectionAvailable$domain_productionRelease", "(Lid/dana/domain/wallet_v3/model/WalletConfig;Ljava/lang/String;)Z", "Lid/dana/domain/services/ServicesRepository;", "servicesRepository", "Lid/dana/domain/services/ServicesRepository;", "Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "walletConfigRepository", "Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "walletV3Repository", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/WalletV3Repository;Lid/dana/domain/services/ServicesRepository;Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetDynamicRecommendation extends BaseUseCase<List<? extends AssetRecommendation>, Params> {
    private final ServicesRepository servicesRepository;
    private final WalletConfigRepository walletConfigRepository;
    private final WalletV3Repository walletV3Repository;

    @Inject
    public GetDynamicRecommendation(WalletV3Repository walletV3Repository, ServicesRepository servicesRepository, WalletConfigRepository walletConfigRepository) {
        Intrinsics.checkNotNullParameter(walletV3Repository, "");
        Intrinsics.checkNotNullParameter(servicesRepository, "");
        Intrinsics.checkNotNullParameter(walletConfigRepository, "");
        this.walletV3Repository = walletV3Repository;
        this.servicesRepository = servicesRepository;
        this.walletConfigRepository = walletConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<AssetRecommendation>> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<List<AssetRecommendation>> map = this.walletV3Repository.getRecommendationConfigKey().flatMap(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2542buildUseCase$lambda0;
                m2542buildUseCase$lambda0 = GetDynamicRecommendation.m2542buildUseCase$lambda0(GetDynamicRecommendation.this, params, (List) obj);
                return m2542buildUseCase$lambda0;
            }
        }).flatMap(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2543buildUseCase$lambda2;
                m2543buildUseCase$lambda2 = GetDynamicRecommendation.m2543buildUseCase$lambda2(GetDynamicRecommendation.this, (List) obj);
                return m2543buildUseCase$lambda2;
            }
        }).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2545buildUseCase$lambda7;
                m2545buildUseCase$lambda7 = GetDynamicRecommendation.m2545buildUseCase$lambda7(GetDynamicRecommendation.this, (List) obj);
                return m2545buildUseCase$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2542buildUseCase$lambda0(GetDynamicRecommendation getDynamicRecommendation, final Params params, List list) {
        Intrinsics.checkNotNullParameter(getDynamicRecommendation, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(list, "");
        return getDynamicRecommendation.getRecommendationConfigs(list, new Function1<List<? extends String>, Boolean>() { // from class: id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation$buildUseCase$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Boolean invoke(List<? extends String> list2) {
                return invoke2((List<String>) list2);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Boolean invoke2(List<String> list2) {
                Intrinsics.checkNotNullParameter(list2, "");
                List<String> list3 = list2;
                GetDynamicRecommendation.Params params2 = GetDynamicRecommendation.Params.this;
                boolean z = true;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    Iterator<T> it = list3.iterator();
                    while (it.hasNext()) {
                        if (StringsKt.contains((CharSequence) params2.getQuery(), (CharSequence) ((String) it.next()), true)) {
                            break;
                        }
                    }
                }
                z = false;
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final ObservableSource m2543buildUseCase$lambda2(final GetDynamicRecommendation getDynamicRecommendation, final List list) {
        Intrinsics.checkNotNullParameter(getDynamicRecommendation, "");
        Intrinsics.checkNotNullParameter(list, "");
        return getDynamicRecommendation.walletConfigRepository.getWalletConfigFromLocal().flatMap(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2544buildUseCase$lambda2$lambda1;
                m2544buildUseCase$lambda2$lambda1 = GetDynamicRecommendation.m2544buildUseCase$lambda2$lambda1(GetDynamicRecommendation.this, list, (WalletConfig) obj);
                return m2544buildUseCase$lambda2$lambda1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2$lambda-1  reason: not valid java name */
    public static final ObservableSource m2544buildUseCase$lambda2$lambda1(GetDynamicRecommendation getDynamicRecommendation, List list, WalletConfig walletConfig) {
        Intrinsics.checkNotNullParameter(getDynamicRecommendation, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(walletConfig, "");
        return getDynamicRecommendation.filterEnableService(list, walletConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-7  reason: not valid java name */
    public static final List m2545buildUseCase$lambda7(GetDynamicRecommendation getDynamicRecommendation, List list) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(getDynamicRecommendation, "");
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final AssetRecommendation assetRecommendation = (AssetRecommendation) it.next();
            if (StringsKt.contains((CharSequence) assetRecommendation.getRawSQL(), (CharSequence) WalletRecommendationConstant.KTP_DAO, true)) {
                bool = (Boolean) getDynamicRecommendation.walletV3Repository.getUserIdentityViaQuery(assetRecommendation.getRawSQL()).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        Boolean m2546buildUseCase$lambda7$lambda6$lambda3;
                        m2546buildUseCase$lambda7$lambda6$lambda3 = GetDynamicRecommendation.m2546buildUseCase$lambda7$lambda6$lambda3(AssetRecommendation.this, (List) obj);
                        return m2546buildUseCase$lambda7$lambda6$lambda3;
                    }
                }).blockingFirst();
            } else if (StringsKt.contains((CharSequence) assetRecommendation.getRawSQL(), (CharSequence) WalletRecommendationConstant.USER_POCKET_ASSET_DAO, true)) {
                bool = (Boolean) getDynamicRecommendation.walletV3Repository.getUserPocketViaQuery(assetRecommendation.getRawSQL()).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        Boolean m2547buildUseCase$lambda7$lambda6$lambda4;
                        m2547buildUseCase$lambda7$lambda6$lambda4 = GetDynamicRecommendation.m2547buildUseCase$lambda7$lambda6$lambda4(AssetRecommendation.this, (List) obj);
                        return m2547buildUseCase$lambda7$lambda6$lambda4;
                    }
                }).blockingFirst();
            } else if (StringsKt.contains((CharSequence) assetRecommendation.getRawSQL(), (CharSequence) WalletRecommendationConstant.USER_PAYMENT_ASSET_DAO, true)) {
                bool = (Boolean) getDynamicRecommendation.walletV3Repository.getUserPaymentViaQuery(assetRecommendation.getRawSQL()).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation$$ExternalSyntheticLambda2
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        Boolean m2548buildUseCase$lambda7$lambda6$lambda5;
                        m2548buildUseCase$lambda7$lambda6$lambda5 = GetDynamicRecommendation.m2548buildUseCase$lambda7$lambda6$lambda5(AssetRecommendation.this, (List) obj);
                        return m2548buildUseCase$lambda7$lambda6$lambda5;
                    }
                }).blockingFirst();
            } else {
                bool = Boolean.FALSE;
            }
            Intrinsics.checkNotNullExpressionValue(bool, "");
            if (!bool.booleanValue()) {
                assetRecommendation = null;
            }
            if (assetRecommendation != null) {
                arrayList.add(assetRecommendation);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-7$lambda-6$lambda-3  reason: not valid java name */
    public static final Boolean m2546buildUseCase$lambda7$lambda6$lambda3(AssetRecommendation assetRecommendation, List list) {
        Intrinsics.checkNotNullParameter(assetRecommendation, "");
        Intrinsics.checkNotNullParameter(list, "");
        return Boolean.valueOf(assetRecommendation.checkRules(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-7$lambda-6$lambda-4  reason: not valid java name */
    public static final Boolean m2547buildUseCase$lambda7$lambda6$lambda4(AssetRecommendation assetRecommendation, List list) {
        Intrinsics.checkNotNullParameter(assetRecommendation, "");
        Intrinsics.checkNotNullParameter(list, "");
        return Boolean.valueOf(assetRecommendation.checkRules(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-7$lambda-6$lambda-5  reason: not valid java name */
    public static final Boolean m2548buildUseCase$lambda7$lambda6$lambda5(AssetRecommendation assetRecommendation, List list) {
        Intrinsics.checkNotNullParameter(assetRecommendation, "");
        Intrinsics.checkNotNullParameter(list, "");
        return Boolean.valueOf(assetRecommendation.checkRules(list));
    }

    private final Observable<List<AssetRecommendation>> getRecommendationConfigs(List<String> keys, final Function1<? super List<String>, Boolean> isContains) {
        if ((!keys.isEmpty()) != false) {
            List<String> list = keys;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(this.walletV3Repository.getRecommendationConfig((String) it.next()));
            }
            Observable<List<AssetRecommendation>> zip = Observable.zip(arrayList, new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation$$ExternalSyntheticLambda6
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    List m2550getRecommendationConfigs$lambda10;
                    m2550getRecommendationConfigs$lambda10 = GetDynamicRecommendation.m2550getRecommendationConfigs$lambda10(Function1.this, (Object[]) obj);
                    return m2550getRecommendationConfigs$lambda10;
                }
            });
            Intrinsics.checkNotNullExpressionValue(zip, "");
            return zip;
        }
        Observable<List<AssetRecommendation>> just = Observable.just(CollectionsKt.emptyList());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    private final Observable<List<AssetRecommendation>> filterEnableService(List<AssetRecommendation> configs, final WalletConfig walletConfig) {
        if ((!configs.isEmpty()) != false) {
            ArrayList arrayList = new ArrayList();
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (AssetRecommendation assetRecommendation : configs) {
                linkedHashMap.put(assetRecommendation.getService(), assetRecommendation);
                Observable<ThirdPartyServiceResponse> serviceByKey = this.servicesRepository.getServiceByKey(assetRecommendation.getService());
                Intrinsics.checkNotNullExpressionValue(serviceByKey, "");
                arrayList.add(serviceByKey);
            }
            Observable<List<AssetRecommendation>> zip = Observable.zip(arrayList, new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation$$ExternalSyntheticLambda8
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    List m2549filterEnableService$lambda14;
                    m2549filterEnableService$lambda14 = GetDynamicRecommendation.m2549filterEnableService$lambda14(linkedHashMap, this, walletConfig, (Object[]) obj);
                    return m2549filterEnableService$lambda14;
                }
            });
            Intrinsics.checkNotNullExpressionValue(zip, "");
            return zip;
        }
        Observable<List<AssetRecommendation>> just = Observable.just(CollectionsKt.emptyList());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006e A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isSectionAvailable$domain_productionRelease(id.dana.domain.wallet_v3.model.WalletConfig r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L70
            int r0 = r3.hashCode()
            switch(r0) {
                case -1150817175: goto L5b;
                case -554006299: goto L48;
                case -68698650: goto L35;
                case 646865086: goto L22;
                case 1076711462: goto Lf;
                default: goto Le;
            }
        Le:
            goto L70
        Lf:
            java.lang.String r0 = "LOYALTY"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L70
            id.dana.domain.wallet_v3.model.WalletV3Config r2 = r2.getWalletV3()
            id.dana.domain.wallet_v3.model.WalletV3AddAssetServices r2 = r2.getCategoryLoyalty()
            if (r2 == 0) goto L70
            goto L6e
        L22:
            java.lang.String r0 = "IDENTITY"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L70
            id.dana.domain.wallet_v3.model.WalletV3Config r2 = r2.getWalletV3()
            id.dana.domain.wallet_v3.model.WalletV3AddAssetServices r2 = r2.getCategoryIdentity()
            if (r2 == 0) goto L70
            goto L6e
        L35:
            java.lang.String r0 = "PAYMENT"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L70
            id.dana.domain.wallet_v3.model.WalletV3Config r2 = r2.getWalletV3()
            id.dana.domain.wallet_v3.model.WalletV3AddAssetServices r2 = r2.getCategoryPayment()
            if (r2 == 0) goto L70
            goto L6e
        L48:
            java.lang.String r0 = "VOUCHER_AND_TICKET"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L70
            id.dana.domain.wallet_v3.model.WalletV3Config r2 = r2.getWalletV3()
            id.dana.domain.wallet_v3.model.WalletV3AddAssetServices r2 = r2.getCategoryVoucherAndTicket()
            if (r2 == 0) goto L70
            goto L6e
        L5b:
            java.lang.String r0 = "FINANCIAL"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L70
            id.dana.domain.wallet_v3.model.WalletV3Config r2 = r2.getWalletV3()
            id.dana.domain.wallet_v3.model.WalletV3AddAssetServices r2 = r2.getCategoryFinancial()
            if (r2 != 0) goto L6e
            goto L70
        L6e:
            r2 = 1
            goto L71
        L70:
            r2 = 0
        L71:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation.isSectionAvailable$domain_productionRelease(id.dana.domain.wallet_v3.model.WalletConfig, java.lang.String):boolean");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetDynamicRecommendation$Params;", "", "", "component1", "()Ljava/lang/String;", "query", "copy", "(Ljava/lang/String;)Lid/dana/domain/wallet_v3/interactor/GetDynamicRecommendation$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getQuery", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final String query;

        public static /* synthetic */ Params copy$default(Params params, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.query;
            }
            return params.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        public final Params copy(String query) {
            Intrinsics.checkNotNullParameter(query, "");
            return new Params(query);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.query, ((Params) other).query);
        }

        public final int hashCode() {
            return this.query.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(query=");
            sb.append(this.query);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.query = str;
        }

        @JvmName(name = "getQuery")
        public final String getQuery() {
            return this.query;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecommendationConfigs$lambda-10  reason: not valid java name */
    public static final List m2550getRecommendationConfigs$lambda10(Function1 function1, Object[] objArr) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(objArr, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            AssetRecommendation assetRecommendation = null;
            if (obj instanceof AssetRecommendation) {
                AssetRecommendation assetRecommendation2 = (AssetRecommendation) obj;
                if (((Boolean) function1.invoke(assetRecommendation2.getKeywords())).booleanValue()) {
                    assetRecommendation = assetRecommendation2;
                }
            }
            if (assetRecommendation != null) {
                arrayList.add(assetRecommendation);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: filterEnableService$lambda-14  reason: not valid java name */
    public static final List m2549filterEnableService$lambda14(Map map, GetDynamicRecommendation getDynamicRecommendation, WalletConfig walletConfig, Object[] objArr) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(getDynamicRecommendation, "");
        Intrinsics.checkNotNullParameter(walletConfig, "");
        Intrinsics.checkNotNullParameter(objArr, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            AssetRecommendation assetRecommendation = null;
            if (obj instanceof ThirdPartyServiceResponse) {
                ThirdPartyServiceResponse thirdPartyServiceResponse = (ThirdPartyServiceResponse) obj;
                AssetRecommendation assetRecommendation2 = (AssetRecommendation) map.get(thirdPartyServiceResponse.getKey());
                if (thirdPartyServiceResponse.isEnable() && assetRecommendation2 != null && getDynamicRecommendation.isSectionAvailable$domain_productionRelease(walletConfig, assetRecommendation2.getSectionType())) {
                    assetRecommendation2.setThirdPartyServiceResponse(thirdPartyServiceResponse);
                    assetRecommendation = assetRecommendation2;
                }
            }
            if (assetRecommendation != null) {
                arrayList.add(assetRecommendation);
            }
        }
        return arrayList;
    }
}
