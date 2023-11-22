package id.dana.data.deeplink.repository;

import android.text.TextUtils;
import android.util.Pair;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.constant.DanaUrl;
import id.dana.data.deeplink.mapper.DeepLinkEntityMapper;
import id.dana.data.deeplink.repository.source.GenerateLinkEntityData;
import id.dana.data.deeplink.repository.source.GenerateLinkEntityDataFactory;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkEntity;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData;
import id.dana.data.qrbarcode.repository.source.QrBarcodeEntityDataFactory;
import id.dana.data.qrbarcode.repository.source.network.result.SplitBillQrResult;
import id.dana.data.referral.repository.source.MyReferralConsultEntityData;
import id.dana.data.referral.repository.source.MyReferralConsultEntityDataFactory;
import id.dana.data.splitbill.mapper.RecentPayerEntityMapper;
import id.dana.data.splitbill.mapper.SplitBillEncodeEntityMapper;
import id.dana.data.splitbill.mapper.SplitBillPayerEntityMapper;
import id.dana.data.splitbill.mapper.SplitBillToSplitBillEntityMapper;
import id.dana.data.splitbill.repository.source.RecentPayerEntityData;
import id.dana.data.splitbill.repository.source.RecentPayerEntityDataFactory;
import id.dana.data.splitbill.repository.source.SplitBillEntityData;
import id.dana.data.splitbill.repository.source.SplitBillEntityDataFactory;
import id.dana.data.util.ConfigUtil;
import id.dana.domain.deeplink.model.DeepLink;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.splitbill.model.SplitBill;
import id.dana.domain.splitbill.model.SplitBillDeeplink;
import id.dana.domain.splitbill.model.SplitBillPayer;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.functions.Function1;

@Singleton
/* loaded from: classes2.dex */
public class GenerateLinkEntityRepository implements GenerateLinkRepository {
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final DeepLinkEntityMapper deepLinkEntityMapper;
    private final GenerateLinkEntityDataFactory generateLinkEntityDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final MyReferralConsultEntityDataFactory myReferralConsultEntityDataFactory;
    private final QrBarcodeEntityDataFactory qrBarcodeEntityDataFactory;
    private final RecentPayerEntityDataFactory recentPayerEntityDataFactory;
    private final RecentPayerEntityMapper recentPayerEntityMapper;
    private final SplitBillEncodeEntityMapper splitBillEncodeEntityMapper;
    private final SplitBillEntityDataFactory splitBillEntityDataFactory;
    private String splitBillId;
    private final SplitBillPayerEntityMapper splitBillPayerEntityMapper;
    private final SplitBillToSplitBillEntityMapper splitBillToSplitBillEntityMapper;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ DeepLink lambda$generateSplitBillQrDeepLink$5(DeepLink deepLink, Long l) throws Exception {
        return deepLink;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ DeepLink lambda$generateSplitBillQrDeepLink$7(DeepLink deepLink, List list) throws Exception {
        return deepLink;
    }

    @Inject
    public GenerateLinkEntityRepository(ConfigEntityDataFactory configEntityDataFactory, GenerateLinkEntityDataFactory generateLinkEntityDataFactory, MyReferralConsultEntityDataFactory myReferralConsultEntityDataFactory, DeepLinkEntityMapper deepLinkEntityMapper, QrBarcodeEntityDataFactory qrBarcodeEntityDataFactory, SplitBillEntityDataFactory splitBillEntityDataFactory, RecentPayerEntityDataFactory recentPayerEntityDataFactory, RecentPayerEntityMapper recentPayerEntityMapper, SplitBillPayerEntityMapper splitBillPayerEntityMapper, SplitBillToSplitBillEntityMapper splitBillToSplitBillEntityMapper, SplitBillEncodeEntityMapper splitBillEncodeEntityMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.configEntityDataFactory = configEntityDataFactory;
        this.generateLinkEntityDataFactory = generateLinkEntityDataFactory;
        this.myReferralConsultEntityDataFactory = myReferralConsultEntityDataFactory;
        this.deepLinkEntityMapper = deepLinkEntityMapper;
        this.qrBarcodeEntityDataFactory = qrBarcodeEntityDataFactory;
        this.splitBillEntityDataFactory = splitBillEntityDataFactory;
        this.recentPayerEntityDataFactory = recentPayerEntityDataFactory;
        this.recentPayerEntityMapper = recentPayerEntityMapper;
        this.splitBillPayerEntityMapper = splitBillPayerEntityMapper;
        this.splitBillToSplitBillEntityMapper = splitBillToSplitBillEntityMapper;
        this.splitBillEncodeEntityMapper = splitBillEncodeEntityMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.deeplink.repository.GenerateLinkRepository
    public Observable<DeepLink> generateReferralDeepLink(final String str) {
        Observable flatMap = configEntityDataFallback(new GenerateLinkEntityRepository$$ExternalSyntheticLambda21()).flatMap(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1172x77cc6aad(str, (Boolean) obj);
            }
        });
        DeepLinkEntityMapper deepLinkEntityMapper = this.deepLinkEntityMapper;
        Objects.requireNonNull(deepLinkEntityMapper);
        return flatMap.map(new GenerateLinkEntityRepository$$ExternalSyntheticLambda23(deepLinkEntityMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generateReferralDeepLink$0$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1172x77cc6aad(String str, Boolean bool) throws Exception {
        if (!bool.booleanValue()) {
            return Observable.just(new DeepLinkEntity(DanaUrl.REFERRAL_URL));
        }
        return createBranchData().generateReferralDeepLink(str);
    }

    @Override // id.dana.domain.deeplink.repository.GenerateLinkRepository
    public Observable<DeepLink> generateTransferQrDeepLink(final String str, final String str2, final String str3) {
        Observable flatMap = configEntityDataFallback(new GenerateLinkEntityRepository$$ExternalSyntheticLambda21()).flatMap(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1177x4880833d(str, str2, str3, (Boolean) obj);
            }
        });
        DeepLinkEntityMapper deepLinkEntityMapper = this.deepLinkEntityMapper;
        Objects.requireNonNull(deepLinkEntityMapper);
        return flatMap.map(new GenerateLinkEntityRepository$$ExternalSyntheticLambda23(deepLinkEntityMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generateTransferQrDeepLink$1$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1177x4880833d(String str, String str2, String str3, Boolean bool) throws Exception {
        if (!bool.booleanValue()) {
            return Observable.just(new DeepLinkEntity(str));
        }
        return bindWithReferral(str).flatMap(getTransferQrDeepLink(str2, str3));
    }

    @Override // id.dana.domain.deeplink.repository.GenerateLinkRepository
    public Observable<DeepLink> generateProfileQrDeepLink(final String str, final String str2, final String str3, final boolean z) {
        Observable flatMap = configEntityDataFallback(new GenerateLinkEntityRepository$$ExternalSyntheticLambda21()).flatMap(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda24
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1171xe3a44319(str, str2, str3, z, (Boolean) obj);
            }
        });
        DeepLinkEntityMapper deepLinkEntityMapper = this.deepLinkEntityMapper;
        Objects.requireNonNull(deepLinkEntityMapper);
        return flatMap.map(new GenerateLinkEntityRepository$$ExternalSyntheticLambda23(deepLinkEntityMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generateProfileQrDeepLink$3$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1171xe3a44319(final String str, String str2, String str3, final boolean z, Boolean bool) throws Exception {
        if (!bool.booleanValue() && !TextUtils.isEmpty(str)) {
            return Observable.just(new DeepLinkEntity(str));
        }
        return bindWithReferral(str).flatMap(generateLinkEntityData(str, str2, str3, z)).doOnNext(new Consumer() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GenerateLinkEntityRepository.this.m1170xf014bed8(str, z, (DeepLinkEntity) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generateProfileQrDeepLink$2$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1170xf014bed8(String str, boolean z, DeepLinkEntity deepLinkEntity) throws Exception {
        if (isSaveToLocal(str, deepLinkEntity, z)) {
            saveDeepLinkProfileQr(deepLinkEntity);
        }
    }

    @Override // id.dana.domain.deeplink.repository.GenerateLinkRepository
    public Observable<SplitBillDeeplink> generateSplitBillQrDeepLink(final SplitBill splitBill, final String str, final String str2) {
        return getSplitBillQrCode(splitBill).flatMap(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Observable splitBillId;
                splitBillId = GenerateLinkEntityRepository.this.setSplitBillId((SplitBillQrResult) obj);
                return splitBillId;
            }
        }).flatMap(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1174x9ed3d272(str, str2, (SplitBillQrResult) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1175x85f2daf4(splitBill, (DeepLink) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1176x6d11e376(splitBill, (DeepLink) obj);
            }
        }).map(getSplitBillDeeplink());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generateSplitBillQrDeepLink$4$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1174x9ed3d272(String str, String str2, SplitBillQrResult splitBillQrResult) throws Exception {
        return generateSplitBillDeepLink(splitBillQrResult.splitBillId, splitBillQrResult.qrCode, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generateSplitBillQrDeepLink$6$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1175x85f2daf4(SplitBill splitBill, final DeepLink deepLink) throws Exception {
        return saveSplitBillHistory(deepLink, splitBill).map(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.lambda$generateSplitBillQrDeepLink$5(DeepLink.this, (Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generateSplitBillQrDeepLink$8$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1176x6d11e376(SplitBill splitBill, final DeepLink deepLink) throws Exception {
        return saveRecentPayer(deepLink, splitBill.getPayers()).map(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.lambda$generateSplitBillQrDeepLink$7(DeepLink.this, (List) obj);
            }
        });
    }

    private Function<DeepLink, SplitBillDeeplink> getSplitBillDeeplink() {
        return new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1179xadfee9af((DeepLink) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSplitBillDeeplink$9$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ SplitBillDeeplink m1179xadfee9af(DeepLink deepLink) throws Exception {
        this.splitBillEncodeEntityMapper.setSplitBillId(this.splitBillId);
        return this.splitBillEncodeEntityMapper.apply(deepLink.getLink());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<SplitBillQrResult> setSplitBillId(SplitBillQrResult splitBillQrResult) {
        this.splitBillId = splitBillQrResult.splitBillId;
        return Observable.just(splitBillQrResult);
    }

    private boolean isSaveToLocal(String str, DeepLinkEntity deepLinkEntity, boolean z) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(deepLinkEntity.getLink()) || (z && deepLinkEntity.isReferralCodeEmpty())) ? false : true;
    }

    private Observable<SplitBillQrResult> getSplitBillQrCode(SplitBill splitBill) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createNetworkQrBarcodeData().requestSplitBillCode(this.splitBillPayerEntityMapper.apply(splitBill.getPayers()), splitBill.getComment()));
    }

    private Observable<DeepLink> generateSplitBillDeepLink(final String str, final String str2, final String str3, final String str4) {
        Observable flatMap = configEntityDataFallback(new GenerateLinkEntityRepository$$ExternalSyntheticLambda21()).flatMap(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1173x8c4a7b5a(str2, str, str3, str4, (Boolean) obj);
            }
        });
        DeepLinkEntityMapper deepLinkEntityMapper = this.deepLinkEntityMapper;
        Objects.requireNonNull(deepLinkEntityMapper);
        return flatMap.map(new GenerateLinkEntityRepository$$ExternalSyntheticLambda23(deepLinkEntityMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generateSplitBillDeepLink$10$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1173x8c4a7b5a(String str, String str2, String str3, String str4, Boolean bool) throws Exception {
        if (!bool.booleanValue()) {
            return Observable.just(new DeepLinkEntity(str));
        }
        return bindWithReferral(str).flatMap(getSplitBillQrDeepLink(str2, str3, str4));
    }

    private <T> Observable<T> configEntityDataFallback(Function1<ConfigEntityData, Observable<T>> function1) {
        return ConfigUtil.getConfigFallback(new ConfigEntityData[]{createSplitConfigData()}, function1);
    }

    private Function<Pair<String, String>, ObservableSource<DeepLinkEntity>> getSplitBillQrDeepLink(final String str, final String str2, final String str3) {
        return new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1181xeaf1e842(str, str2, str3, (Pair) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSplitBillQrDeepLink$12$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1181xeaf1e842(final String str, final String str2, final String str3, final Pair pair) throws Exception {
        return this.holdLoginV1EntityRepository.createAccountData().getUserId().flatMap(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1180xf7626401(str, pair, str2, str3, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSplitBillQrDeepLink$11$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1180xf7626401(String str, Pair pair, String str2, String str3, String str4) throws Exception {
        return createBranchData().generateSplitBillQrDeepLink(str4, str, (String) pair.first, (String) pair.second, str2, str3);
    }

    private Observable<Long> saveSplitBillHistory(DeepLink deepLink, SplitBill splitBill) {
        if (deepLink != null && !TextUtils.isEmpty(deepLink.getLink())) {
            this.splitBillToSplitBillEntityMapper.setDeeplinkUrl(deepLink.getLink());
            this.splitBillToSplitBillEntityMapper.setSplitBillId(this.splitBillId);
            return createLocalSplitBillData().saveSplitBillHistory(this.splitBillToSplitBillEntityMapper.apply(splitBill));
        }
        return Observable.error(new Throwable());
    }

    private Observable<List<Long>> saveRecentPayer(DeepLink deepLink, List<SplitBillPayer> list) {
        if (deepLink != null && !TextUtils.isEmpty(deepLink.getLink())) {
            return createLocalRecentPayerData().saveRecentPayers(this.recentPayerEntityMapper.apply(list));
        }
        return Observable.error(new Throwable());
    }

    private Function<Pair<String, String>, ObservableSource<DeepLinkEntity>> generateLinkEntityData(final String str, final String str2, final String str3, final boolean z) {
        return new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1169xf281e19a(str, str2, str3, z, (Pair) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generateLinkEntityData$14$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1169xf281e19a(final String str, String str2, String str3, boolean z, Pair pair) throws Exception {
        return Observable.defer(new Callable() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda16
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return GenerateLinkEntityRepository.this.m1168xfef25d59(str);
            }
        }).flatMap(getProfileQrDeepLink(pair, str2, str3, z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generateLinkEntityData$13$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1168xfef25d59(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return Observable.just(createLocalData());
        }
        return Observable.just(createBranchData());
    }

    private Function<GenerateLinkEntityData, ObservableSource<DeepLinkEntity>> getProfileQrDeepLink(final Pair<String, String> pair, final String str, final String str2, final boolean z) {
        return new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1178x781f671e(pair, str, str2, z, (GenerateLinkEntityData) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getProfileQrDeepLink$16$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1178x781f671e(final Pair pair, final String str, final String str2, final boolean z, final GenerateLinkEntityData generateLinkEntityData) throws Exception {
        return this.holdLoginV1EntityRepository.createAccountData().getUserId().flatMap(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource generateProfileQrDeepLink;
                String str3 = (String) obj;
                generateProfileQrDeepLink = GenerateLinkEntityData.this.generateProfileQrDeepLink(str3, (String) r1.first, (String) pair.second, str, str2, z);
                return generateProfileQrDeepLink;
            }
        });
    }

    private Function<Pair<String, String>, ObservableSource<DeepLinkEntity>> getTransferQrDeepLink(final String str, final String str2) {
        return new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1183x6b51b58c(str, str2, (Pair) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getTransferQrDeepLink$18$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1183x6b51b58c(final String str, final String str2, final Pair pair) throws Exception {
        return this.holdLoginV1EntityRepository.createAccountData().getUserId().flatMap(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1182x77c2314b(pair, str, str2, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getTransferQrDeepLink$17$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1182x77c2314b(Pair pair, String str, String str2, String str3) throws Exception {
        return createBranchData().generateTransferQrDeepLink(str3, (String) pair.first, (String) pair.second, str, str2);
    }

    private ConfigEntityData createSplitConfigData() {
        return this.configEntityDataFactory.createData2("split");
    }

    private GenerateLinkEntityData createBranchData() {
        return this.generateLinkEntityDataFactory.createData2("network");
    }

    private GenerateLinkEntityData createLocalData() {
        return this.generateLinkEntityDataFactory.createData2("local");
    }

    private QrBarcodeEntityData createNetworkQrBarcodeData() {
        return this.qrBarcodeEntityDataFactory.createData2("network");
    }

    private SplitBillEntityData createLocalSplitBillData() {
        return this.splitBillEntityDataFactory.createData2("local");
    }

    private RecentPayerEntityData createLocalRecentPayerData() {
        return this.recentPayerEntityDataFactory.createData2("local");
    }

    private void saveDeepLinkProfileQr(DeepLinkEntity deepLinkEntity) {
        StringBuilder sb = new StringBuilder();
        sb.append(DanaLogConstants.Prefix.DEEPLINK_PROFILE_QR);
        sb.append(getClass().getName());
        sb.append("Save Link to local");
        sb.append(deepLinkEntity.getLink());
        DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString());
        createLocalData().saveProfileQrDeepLink(deepLinkEntity.getLink(), !deepLinkEntity.isReferralCodeEmpty());
    }

    private Observable<Pair<String, String>> bindWithReferral(final String str) {
        return createReferralEntityData("local").getReferralCode().onErrorResumeNext(retryReferralWithNetwork()).flatMap(new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource just;
                just = Observable.just(new Pair(str, (String) obj));
                return just;
            }
        });
    }

    private MyReferralConsultEntityData createReferralEntityData(String str) {
        return this.myReferralConsultEntityDataFactory.createData2(str);
    }

    private Function<Throwable, ObservableSource<? extends String>> retryReferralWithNetwork() {
        return new Function() { // from class: id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GenerateLinkEntityRepository.this.m1184xd5fe804e((Throwable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$retryReferralWithNetwork$20$id-dana-data-deeplink-repository-GenerateLinkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1184xd5fe804e(Throwable th) throws Exception {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createReferralEntityData("network").getMyReferralConsult()).map(new GenerateLinkEntityRepository$$ExternalSyntheticLambda2()).onErrorResumeNext(Observable.just(""));
    }
}
