package id.dana.data.qrbarcode.repository;

import id.dana.data.config.repository.FeatureConfigEntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.model.DefaultInfoResult;
import id.dana.data.model.DefaultInfoResultKt;
import id.dana.data.qrbarcode.ScanSelfException;
import id.dana.data.qrbarcode.mapper.QrBarcodeMapper;
import id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData;
import id.dana.data.qrbarcode.repository.source.QrBarcodeEntityDataFactory;
import id.dana.data.qrbarcode.repository.source.QrScanWhitelistFactory;
import id.dana.data.qrbarcode.repository.source.network.request.PreCreateOrderEntityRequestKt;
import id.dana.data.qrbarcode.repository.source.network.request.TransferBankGenerateQrEntity;
import id.dana.data.qrbarcode.repository.source.network.request.TransferGenerateQrRequest;
import id.dana.data.qrbarcode.repository.source.network.request.UserBankGenerateQrEntity;
import id.dana.data.qrbarcode.repository.source.network.result.DecodedQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.SplitBillQrResult;
import id.dana.data.splitbill.mapper.SplitBillPayerEntityMapper;
import id.dana.domain.qrbarcode.DecodeQrBizType;
import id.dana.domain.qrbarcode.DecodedScan;
import id.dana.domain.qrbarcode.PreCreateOrderRequest;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.domain.qrbarcode.QrUserBankResult;
import id.dana.domain.qrbarcode.QrUserResult;
import id.dana.domain.splitbill.model.SplitBillPayer;
import id.dana.domain.splitbill.model.TransferBankGenerateQr;
import id.dana.domain.splitbill.model.UserBankGenerateQr;
import id.dana.utils.rpc.response.DefaultResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Timed;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class QrBarcodeEntityRepository implements QrBarcodeRepository {
    private final FeatureConfigEntityRepository featureConfigEntityRepository;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final QrBarcodeMapper mapper;
    private final QrBarcodeEntityDataFactory qrBarcodeEntityDataFactory;
    private final QrScanWhitelistFactory qrScanWhitelistFactory;
    private final SplitBillPayerEntityMapper splitBillPayerEntityMapper;
    private Timed<List<String>> whitelistedQrH5ContainerTimed;

    @Inject
    public QrBarcodeEntityRepository(QrBarcodeEntityDataFactory qrBarcodeEntityDataFactory, QrBarcodeMapper qrBarcodeMapper, QrScanWhitelistFactory qrScanWhitelistFactory, SplitBillPayerEntityMapper splitBillPayerEntityMapper, FeatureConfigEntityRepository featureConfigEntityRepository, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.qrBarcodeEntityDataFactory = qrBarcodeEntityDataFactory;
        this.mapper = qrBarcodeMapper;
        this.qrScanWhitelistFactory = qrScanWhitelistFactory;
        this.splitBillPayerEntityMapper = splitBillPayerEntityMapper;
        this.featureConfigEntityRepository = featureConfigEntityRepository;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.qrbarcode.QrBarcodeRepository
    public Observable<DecodedScan> getDecodedQrBarcode(String str, String str2, boolean z) {
        return decodeQrBarcode(str, str2, z);
    }

    @Override // id.dana.domain.qrbarcode.QrBarcodeRepository
    public Observable<QrUserResult> getUserQr(boolean z, String str, int i) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createQrData().userCode(z, str, i));
        QrBarcodeMapper qrBarcodeMapper = this.mapper;
        Objects.requireNonNull(qrBarcodeMapper);
        return authenticatedRequest.map(new QrBarcodeEntityRepository$$ExternalSyntheticLambda5(qrBarcodeMapper));
    }

    @Override // id.dana.domain.qrbarcode.QrBarcodeRepository
    public Observable<QrUserBankResult> getUserBankQr(UserBankGenerateQr userBankGenerateQr) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createQrData().userBankCode(UserBankGenerateQrEntity.fromUserBankGenerateQr(userBankGenerateQr))).map(new QrBarcodeEntityRepository$$ExternalSyntheticLambda3());
    }

    @Override // id.dana.domain.qrbarcode.QrBarcodeRepository
    public Observable<QrUserResult> getTransferQr(boolean z, String str, String str2, int i) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createQrData().requestTransferCode(new TransferGenerateQrRequest(z, str, str2, i)));
        QrBarcodeMapper qrBarcodeMapper = this.mapper;
        Objects.requireNonNull(qrBarcodeMapper);
        return authenticatedRequest.map(new QrBarcodeEntityRepository$$ExternalSyntheticLambda5(qrBarcodeMapper));
    }

    @Override // id.dana.domain.qrbarcode.QrBarcodeRepository
    public Observable<QrUserBankResult> getTransferBankQr(TransferBankGenerateQr transferBankGenerateQr) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createQrData().requestTransferBankCode(TransferBankGenerateQrEntity.fromTransferBankGenerateQr(transferBankGenerateQr))).map(new QrBarcodeEntityRepository$$ExternalSyntheticLambda3());
    }

    @Override // id.dana.domain.qrbarcode.QrBarcodeRepository
    public Observable<QrUserResult> getSplitBillQr(List<SplitBillPayer> list, String str) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createQrData().requestSplitBillCode(this.splitBillPayerEntityMapper.apply(list), str));
        final QrBarcodeMapper qrBarcodeMapper = this.mapper;
        Objects.requireNonNull(qrBarcodeMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.qrbarcode.repository.QrBarcodeEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return QrBarcodeMapper.this.transform((SplitBillQrResult) obj);
            }
        });
    }

    @Override // id.dana.domain.qrbarcode.QrBarcodeRepository
    public Observable<DefaultResponse> preCreateCashierOrder(final PreCreateOrderRequest preCreateOrderRequest) {
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.holdLoginV1EntityRepository;
        return holdLoginV1EntityRepository.authenticatedRequest(holdLoginV1EntityRepository.createAccountData().getNickname().flatMap(new Function() { // from class: id.dana.data.qrbarcode.repository.QrBarcodeEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return QrBarcodeEntityRepository.this.m1692xd165afc4(preCreateOrderRequest, (String) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$preCreateCashierOrder$0$id-dana-data-qrbarcode-repository-QrBarcodeEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1692xd165afc4(PreCreateOrderRequest preCreateOrderRequest, String str) throws Exception {
        preCreateOrderRequest.setUserName(str);
        return createQrData().preCreateCashierOrder(PreCreateOrderEntityRequestKt.toPreCreateOrderEntityRequest(preCreateOrderRequest)).map(new Function() { // from class: id.dana.data.qrbarcode.repository.QrBarcodeEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultInfoResultKt.toDefaultResponse((DefaultInfoResult) obj);
            }
        });
    }

    @Override // id.dana.domain.qrbarcode.QrBarcodeRepository
    public Observable<List<String>> getMerchantQrDomainWhitelist() {
        return getWhitelistedQrH5ContainerList();
    }

    private Observable<List<String>> getWhitelistedQrH5ContainerList() {
        if (isWhitelistH5ContainerEmptyOrStale()) {
            return this.qrScanWhitelistFactory.createData2("split").getWhitelistedQrH5Container().timestamp().doOnNext(new Consumer() { // from class: id.dana.data.qrbarcode.repository.QrBarcodeEntityRepository$$ExternalSyntheticLambda8
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    QrBarcodeEntityRepository.this.m1691xf0f6315c((Timed) obj);
                }
            }).map(new Function() { // from class: id.dana.data.qrbarcode.repository.QrBarcodeEntityRepository$$ExternalSyntheticLambda9
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return (List) ((Timed) obj).MyBillsEntityDataFactory;
                }
            });
        }
        return Observable.just(this.whitelistedQrH5ContainerTimed.MyBillsEntityDataFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getWhitelistedQrH5ContainerList$1$id-dana-data-qrbarcode-repository-QrBarcodeEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1691xf0f6315c(Timed timed) throws Exception {
        this.whitelistedQrH5ContainerTimed = timed;
    }

    private boolean isWhitelistH5ContainerEmptyOrStale() {
        if (this.whitelistedQrH5ContainerTimed != null) {
            long hours = TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis());
            Timed<List<String>> timed = this.whitelistedQrH5ContainerTimed;
            if (hours - TimeUnit.HOURS.convert(timed.getAuthRequestContext, timed.PlaceComponentResult) < 2 && this.whitelistedQrH5ContainerTimed.MyBillsEntityDataFactory != null && !this.whitelistedQrH5ContainerTimed.MyBillsEntityDataFactory.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private QrBarcodeEntityData createQrData() {
        return this.qrBarcodeEntityDataFactory.createData2("network");
    }

    private Observable<DecodedScan> decodeQrBarcode(final String str, final String str2, final boolean z) {
        return this.featureConfigEntityRepository.getDecodeQrTimeout().flatMap(new Function() { // from class: id.dana.data.qrbarcode.repository.QrBarcodeEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return QrBarcodeEntityRepository.this.m1690xb4111cae(str, str2, z, (Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$decodeQrBarcode$3$id-dana-data-qrbarcode-repository-QrBarcodeEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1690xb4111cae(String str, String str2, final boolean z, Long l) throws Exception {
        Observable flatMap = this.holdLoginV1EntityRepository.authenticatedRequest(createQrData().decode(str, str2, l)).flatMap(new Function() { // from class: id.dana.data.qrbarcode.repository.QrBarcodeEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return QrBarcodeEntityRepository.this.m1689xf99b7c2d(z, (DecodedQrResult) obj);
            }
        });
        final QrBarcodeMapper qrBarcodeMapper = this.mapper;
        Objects.requireNonNull(qrBarcodeMapper);
        return flatMap.map(new Function() { // from class: id.dana.data.qrbarcode.repository.QrBarcodeEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return QrBarcodeMapper.this.transform((DecodedQrResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$decodeQrBarcode$2$id-dana-data-qrbarcode-repository-QrBarcodeEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1689xf99b7c2d(boolean z, DecodedQrResult decodedQrResult) throws Exception {
        if ((DecodeQrBizType.PROFILE_CODE.equalsIgnoreCase(decodedQrResult.bizType) || DecodeQrBizType.TRANSFER_CODE.equalsIgnoreCase(decodedQrResult.bizType) || DecodeQrBizType.USER_MERCHANT_CODE.equalsIgnoreCase(decodedQrResult.bizType)) && z) {
            return onScanSelf(decodedQrResult);
        }
        return Observable.just(decodedQrResult);
    }

    private Observable<DecodedQrResult> onScanSelf(final DecodedQrResult decodedQrResult) {
        return this.holdLoginV1EntityRepository.createAccountData().getUserId().flatMap(new Function() { // from class: id.dana.data.qrbarcode.repository.QrBarcodeEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return QrBarcodeEntityRepository.lambda$onScanSelf$4(DecodedQrResult.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$onScanSelf$4(DecodedQrResult decodedQrResult, String str) throws Exception {
        if (str.equalsIgnoreCase(decodedQrResult.receiverId)) {
            throw new ScanSelfException();
        }
        return Observable.just(decodedQrResult);
    }
}
