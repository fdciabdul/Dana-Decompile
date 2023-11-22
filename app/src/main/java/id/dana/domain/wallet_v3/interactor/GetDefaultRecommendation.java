package id.dana.domain.wallet_v3.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.wallet_v3.constant.WalletRecommendationConstant;
import id.dana.domain.wallet_v3.model.AssetRecommendation;
import id.dana.domain.wallet_v3.model.WalletConfig;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u001f B!\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetDefaultRecommendation;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/wallet_v3/model/AssetRecommendation;", "Lid/dana/domain/wallet_v3/interactor/GetDefaultRecommendation$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/GetDefaultRecommendation$Params;)Lio/reactivex/Observable;", "getDefaultRecommendation", "Lid/dana/domain/wallet_v3/model/WalletConfig;", "walletConfig", "", "sectionType", "", "isSectionAvailable$domain_productionRelease", "(Lid/dana/domain/wallet_v3/model/WalletConfig;Ljava/lang/String;)Z", "asset", "passCheckRules", "(Lid/dana/domain/wallet_v3/model/AssetRecommendation;)Z", "Lid/dana/domain/services/ServicesRepository;", "servicesRepository", "Lid/dana/domain/services/ServicesRepository;", "Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "walletConfigRepository", "Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "walletV3Repository", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/WalletV3Repository;Lid/dana/domain/services/ServicesRepository;Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetDefaultRecommendation extends BaseUseCase<List<? extends AssetRecommendation>, Params> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ServicesRepository servicesRepository;
    private final WalletConfigRepository walletConfigRepository;
    private final WalletV3Repository walletV3Repository;

    @Inject
    public GetDefaultRecommendation(WalletV3Repository walletV3Repository, ServicesRepository servicesRepository, WalletConfigRepository walletConfigRepository) {
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
        Observable flatMap = this.walletV3Repository.getRecommendationConfigKey().flatMap(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDefaultRecommendation$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2530buildUseCase$lambda0;
                m2530buildUseCase$lambda0 = GetDefaultRecommendation.m2530buildUseCase$lambda0(GetDefaultRecommendation.this, params, (List) obj);
                return m2530buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2530buildUseCase$lambda0(GetDefaultRecommendation getDefaultRecommendation, Params params, List list) {
        Observable<List<AssetRecommendation>> just;
        Intrinsics.checkNotNullParameter(getDefaultRecommendation, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(list, "");
        if ((!list.isEmpty()) != false) {
            just = getDefaultRecommendation.getDefaultRecommendation(params);
        } else {
            just = Observable.just(CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    private final Observable<List<AssetRecommendation>> getDefaultRecommendation(Params params) {
        List<String> services = params.getServices();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(services, 10));
        Iterator<T> it = services.iterator();
        while (it.hasNext()) {
            arrayList.add(this.servicesRepository.getServiceByKey((String) it.next()));
        }
        Observable<List<AssetRecommendation>> map = Observable.zip(arrayList, new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDefaultRecommendation$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2531getDefaultRecommendation$lambda3;
                m2531getDefaultRecommendation$lambda3 = GetDefaultRecommendation.m2531getDefaultRecommendation$lambda3((Object[]) obj);
                return m2531getDefaultRecommendation$lambda3;
            }
        }).flatMap(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDefaultRecommendation$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2532getDefaultRecommendation$lambda5;
                m2532getDefaultRecommendation$lambda5 = GetDefaultRecommendation.m2532getDefaultRecommendation$lambda5(GetDefaultRecommendation.this, (List) obj);
                return m2532getDefaultRecommendation$lambda5;
            }
        }).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDefaultRecommendation$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2534getDefaultRecommendation$lambda8;
                m2534getDefaultRecommendation$lambda8 = GetDefaultRecommendation.m2534getDefaultRecommendation$lambda8(GetDefaultRecommendation.this, (Pair) obj);
                return m2534getDefaultRecommendation$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDefaultRecommendation$lambda-5  reason: not valid java name */
    public static final ObservableSource m2532getDefaultRecommendation$lambda5(GetDefaultRecommendation getDefaultRecommendation, final List list) {
        Intrinsics.checkNotNullParameter(getDefaultRecommendation, "");
        Intrinsics.checkNotNullParameter(list, "");
        return getDefaultRecommendation.walletConfigRepository.getWalletConfigFromLocal().map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDefaultRecommendation$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Pair m2533getDefaultRecommendation$lambda5$lambda4;
                m2533getDefaultRecommendation$lambda5$lambda4 = GetDefaultRecommendation.m2533getDefaultRecommendation$lambda5$lambda4(list, (WalletConfig) obj);
                return m2533getDefaultRecommendation$lambda5$lambda4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDefaultRecommendation$lambda-5$lambda-4  reason: not valid java name */
    public static final Pair m2533getDefaultRecommendation$lambda5$lambda4(List list, WalletConfig walletConfig) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(walletConfig, "");
        return TuplesKt.to(list, walletConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDefaultRecommendation$lambda-8  reason: not valid java name */
    public static final List m2534getDefaultRecommendation$lambda8(GetDefaultRecommendation getDefaultRecommendation, Pair pair) {
        AssetRecommendation assetRecommendation;
        Intrinsics.checkNotNullParameter(getDefaultRecommendation, "");
        Intrinsics.checkNotNullParameter(pair, "");
        List<ThirdPartyServiceResponse> list = (List) pair.component1();
        WalletConfig walletConfig = (WalletConfig) pair.component2();
        Intrinsics.checkNotNullExpressionValue(list, "");
        ArrayList arrayList = new ArrayList();
        for (ThirdPartyServiceResponse thirdPartyServiceResponse : list) {
            AssetRecommendation assetRecommendation2 = null;
            if (thirdPartyServiceResponse.isEnable() && (assetRecommendation = WalletRecommendationConstant.INSTANCE.getDefaultAssetMap().get(thirdPartyServiceResponse.getKey())) != null) {
                Intrinsics.checkNotNullExpressionValue(walletConfig, "");
                if (getDefaultRecommendation.isSectionAvailable$domain_productionRelease(walletConfig, assetRecommendation.getSectionType())) {
                    assetRecommendation.setThirdPartyServiceResponse(thirdPartyServiceResponse);
                    if (getDefaultRecommendation.passCheckRules(assetRecommendation)) {
                        assetRecommendation2 = assetRecommendation;
                    }
                }
            }
            if (assetRecommendation2 != null) {
                arrayList.add(assetRecommendation2);
            }
        }
        return arrayList;
    }

    private final boolean passCheckRules(final AssetRecommendation asset) {
        if (StringsKt.contains((CharSequence) asset.getRawSQL(), (CharSequence) WalletRecommendationConstant.KTP_DAO, true)) {
            Object blockingFirst = this.walletV3Repository.getUserIdentityViaQuery(asset.getRawSQL()).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDefaultRecommendation$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Boolean m2537passCheckRules$lambda9;
                    m2537passCheckRules$lambda9 = GetDefaultRecommendation.m2537passCheckRules$lambda9(AssetRecommendation.this, (List) obj);
                    return m2537passCheckRules$lambda9;
                }
            }).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
            return ((Boolean) blockingFirst).booleanValue();
        } else if (StringsKt.contains((CharSequence) asset.getRawSQL(), (CharSequence) WalletRecommendationConstant.USER_POCKET_ASSET_DAO, true)) {
            Object blockingFirst2 = this.walletV3Repository.getUserPocketViaQuery(asset.getRawSQL()).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDefaultRecommendation$$ExternalSyntheticLambda6
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Boolean m2535passCheckRules$lambda10;
                    m2535passCheckRules$lambda10 = GetDefaultRecommendation.m2535passCheckRules$lambda10(AssetRecommendation.this, (List) obj);
                    return m2535passCheckRules$lambda10;
                }
            }).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst2, "");
            return ((Boolean) blockingFirst2).booleanValue();
        } else if (StringsKt.contains((CharSequence) asset.getRawSQL(), (CharSequence) WalletRecommendationConstant.USER_PAYMENT_ASSET_DAO, true)) {
            Object blockingFirst3 = this.walletV3Repository.getUserPaymentViaQuery(asset.getRawSQL()).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetDefaultRecommendation$$ExternalSyntheticLambda7
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Boolean m2536passCheckRules$lambda11;
                    m2536passCheckRules$lambda11 = GetDefaultRecommendation.m2536passCheckRules$lambda11(AssetRecommendation.this, (List) obj);
                    return m2536passCheckRules$lambda11;
                }
            }).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst3, "");
            return ((Boolean) blockingFirst3).booleanValue();
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: passCheckRules$lambda-9  reason: not valid java name */
    public static final Boolean m2537passCheckRules$lambda9(AssetRecommendation assetRecommendation, List list) {
        Intrinsics.checkNotNullParameter(assetRecommendation, "");
        Intrinsics.checkNotNullParameter(list, "");
        return Boolean.valueOf(assetRecommendation.checkRules(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: passCheckRules$lambda-10  reason: not valid java name */
    public static final Boolean m2535passCheckRules$lambda10(AssetRecommendation assetRecommendation, List list) {
        Intrinsics.checkNotNullParameter(assetRecommendation, "");
        Intrinsics.checkNotNullParameter(list, "");
        return Boolean.valueOf(assetRecommendation.checkRules(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: passCheckRules$lambda-11  reason: not valid java name */
    public static final Boolean m2536passCheckRules$lambda11(AssetRecommendation assetRecommendation, List list) {
        Intrinsics.checkNotNullParameter(assetRecommendation, "");
        Intrinsics.checkNotNullParameter(list, "");
        return Boolean.valueOf(assetRecommendation.checkRules(list));
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.wallet_v3.interactor.GetDefaultRecommendation.isSectionAvailable$domain_productionRelease(id.dana.domain.wallet_v3.model.WalletConfig, java.lang.String):boolean");
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetDefaultRecommendation$Params;", "", "", "", "component1", "()Ljava/util/List;", "services", "copy", "(Ljava/util/List;)Lid/dana/domain/wallet_v3/interactor/GetDefaultRecommendation$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getServices", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final List<String> services;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Params() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.wallet_v3.interactor.GetDefaultRecommendation.Params.<init>():void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Params copy$default(Params params, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = params.services;
            }
            return params.copy(list);
        }

        public final List<String> component1() {
            return this.services;
        }

        public final Params copy(List<String> services) {
            Intrinsics.checkNotNullParameter(services, "");
            return new Params(services);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.services, ((Params) other).services);
        }

        public final int hashCode() {
            return this.services.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(services=");
            sb.append(this.services);
            sb.append(')');
            return sb.toString();
        }

        public Params(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.services = list;
        }

        @JvmName(name = "getServices")
        public final List<String> getServices() {
            return this.services;
        }

        public /* synthetic */ Params(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.listOf((Object[]) new String[]{"service_ektp", "service_dana_plus", "service_deals", "service_bank_card"}) : list);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetDefaultRecommendation$Companion;", "", "Lid/dana/domain/wallet_v3/interactor/GetDefaultRecommendation$Params;", "forDefault", "()Lid/dana/domain/wallet_v3/interactor/GetDefaultRecommendation$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
        public final Params forDefault() {
            ?? r1 = 0;
            return new Params(r1, 1, r1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDefaultRecommendation$lambda-3  reason: not valid java name */
    public static final List m2531getDefaultRecommendation$lambda3(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "");
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.domain.homeinfo.ThirdPartyServiceResponse");
            }
            arrayList.add((ThirdPartyServiceResponse) obj);
        }
        return arrayList;
    }
}
