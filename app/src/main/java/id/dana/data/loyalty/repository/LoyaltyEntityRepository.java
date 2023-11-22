package id.dana.data.loyalty.repository;

import id.dana.data.loyalty.mapper.LoyaltyEntityRepositoryMapperExtKt;
import id.dana.data.loyalty.repository.source.LoyaltyEntityData;
import id.dana.data.loyalty.repository.source.LoyaltyEntityDataFactory;
import id.dana.data.loyalty.repository.source.local.entity.LoyaltyReceiptEntity;
import id.dana.data.loyalty.repository.source.network.response.SubmitReceiptResponse;
import id.dana.domain.loyalty.LoyaltyRepository;
import id.dana.domain.loyalty.model.Base64ReceiptLoyalty;
import id.dana.domain.loyalty.model.FileOcrReceiptLoyalty;
import id.dana.domain.loyalty.model.SubmitReceiptResult;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001e\u001a\u00020\u00138CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017"}, d2 = {"Lid/dana/data/loyalty/repository/LoyaltyEntityRepository;", "Lid/dana/domain/loyalty/LoyaltyRepository;", "", "userLoyaltyId", "Lio/reactivex/Observable;", "Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;", "getReceiptData", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "removeReceiptData", "fileOcrReceiptLoyalty", "saveReceiptData", "(Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;)Lio/reactivex/Observable;", "Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;", "base64ReceiptLoyalty", "token", "Lid/dana/domain/loyalty/model/SubmitReceiptResult;", "submitReceipt", "(Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/loyalty/repository/source/LoyaltyEntityData;", "localLoyaltyEntityData$delegate", "Lkotlin/Lazy;", "getLocalLoyaltyEntityData", "()Lid/dana/data/loyalty/repository/source/LoyaltyEntityData;", "localLoyaltyEntityData", "Lid/dana/data/loyalty/repository/source/LoyaltyEntityDataFactory;", "loyaltyEntityDataFactory", "Lid/dana/data/loyalty/repository/source/LoyaltyEntityDataFactory;", "networkLoyaltyEntityData$delegate", "getNetworkLoyaltyEntityData", "networkLoyaltyEntityData", "<init>", "(Lid/dana/data/loyalty/repository/source/LoyaltyEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoyaltyEntityRepository implements LoyaltyRepository {

    /* renamed from: localLoyaltyEntityData$delegate  reason: from kotlin metadata */
    private final Lazy localLoyaltyEntityData;
    private final LoyaltyEntityDataFactory loyaltyEntityDataFactory;

    /* renamed from: networkLoyaltyEntityData$delegate  reason: from kotlin metadata */
    private final Lazy networkLoyaltyEntityData;

    @Inject
    public LoyaltyEntityRepository(LoyaltyEntityDataFactory loyaltyEntityDataFactory) {
        Intrinsics.checkNotNullParameter(loyaltyEntityDataFactory, "");
        this.loyaltyEntityDataFactory = loyaltyEntityDataFactory;
        this.networkLoyaltyEntityData = LazyKt.lazy(new Function0<LoyaltyEntityData>() { // from class: id.dana.data.loyalty.repository.LoyaltyEntityRepository$networkLoyaltyEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LoyaltyEntityData invoke() {
                LoyaltyEntityDataFactory loyaltyEntityDataFactory2;
                loyaltyEntityDataFactory2 = LoyaltyEntityRepository.this.loyaltyEntityDataFactory;
                return loyaltyEntityDataFactory2.createData2("network");
            }
        });
        this.localLoyaltyEntityData = LazyKt.lazy(new Function0<LoyaltyEntityData>() { // from class: id.dana.data.loyalty.repository.LoyaltyEntityRepository$localLoyaltyEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LoyaltyEntityData invoke() {
                LoyaltyEntityDataFactory loyaltyEntityDataFactory2;
                loyaltyEntityDataFactory2 = LoyaltyEntityRepository.this.loyaltyEntityDataFactory;
                return loyaltyEntityDataFactory2.createData2("local");
            }
        });
    }

    @Override // id.dana.domain.loyalty.LoyaltyRepository
    public final Observable<SubmitReceiptResult> submitReceipt(Base64ReceiptLoyalty base64ReceiptLoyalty, String token) {
        Observable<SubmitReceiptResult> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(base64ReceiptLoyalty, "");
        Intrinsics.checkNotNullParameter(token, "");
        Single<SubmitReceiptResponse> submitReceipt = getNetworkLoyaltyEntityData().submitReceipt(LoyaltyEntityRepositoryMapperExtKt.toSubmitReceiptRequest(base64ReceiptLoyalty), token);
        Function function = new Function() { // from class: id.dana.data.loyalty.repository.LoyaltyEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SubmitReceiptResult m1458submitReceipt$lambda0;
                m1458submitReceipt$lambda0 = LoyaltyEntityRepository.m1458submitReceipt$lambda0((SubmitReceiptResponse) obj);
                return m1458submitReceipt$lambda0;
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        Single BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(submitReceipt, function));
        if (BuiltInFictitiousFunctionClassFactory2 instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) BuiltInFictitiousFunctionClassFactory2).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(BuiltInFictitiousFunctionClassFactory2));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: submitReceipt$lambda-0  reason: not valid java name */
    public static final SubmitReceiptResult m1458submitReceipt$lambda0(SubmitReceiptResponse submitReceiptResponse) {
        Intrinsics.checkNotNullParameter(submitReceiptResponse, "");
        return LoyaltyEntityRepositoryMapperExtKt.toSubmitReceiptResult(submitReceiptResponse);
    }

    @Override // id.dana.domain.loyalty.LoyaltyRepository
    public final Observable<Boolean> saveReceiptData(FileOcrReceiptLoyalty fileOcrReceiptLoyalty) {
        Intrinsics.checkNotNullParameter(fileOcrReceiptLoyalty, "");
        Observable flatMap = getLocalLoyaltyEntityData().saveReceiptData(LoyaltyEntityRepositoryMapperExtKt.toLoyaltyReceiptEntity(fileOcrReceiptLoyalty)).flatMap(new Function() { // from class: id.dana.data.loyalty.repository.LoyaltyEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1457saveReceiptData$lambda1;
                m1457saveReceiptData$lambda1 = LoyaltyEntityRepository.m1457saveReceiptData$lambda1((Long) obj);
                return m1457saveReceiptData$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveReceiptData$lambda-1  reason: not valid java name */
    public static final ObservableSource m1457saveReceiptData$lambda1(Long l) {
        Intrinsics.checkNotNullParameter(l, "");
        return Observable.just(Boolean.TRUE);
    }

    @Override // id.dana.domain.loyalty.LoyaltyRepository
    public final Observable<FileOcrReceiptLoyalty> getReceiptData(String userLoyaltyId) {
        Intrinsics.checkNotNullParameter(userLoyaltyId, "");
        Observable map = getLocalLoyaltyEntityData().getReceiptDataByUserLoyaltyId(userLoyaltyId).map(new Function() { // from class: id.dana.data.loyalty.repository.LoyaltyEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FileOcrReceiptLoyalty m1455getReceiptData$lambda2;
                m1455getReceiptData$lambda2 = LoyaltyEntityRepository.m1455getReceiptData$lambda2((LoyaltyReceiptEntity) obj);
                return m1455getReceiptData$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getReceiptData$lambda-2  reason: not valid java name */
    public static final FileOcrReceiptLoyalty m1455getReceiptData$lambda2(LoyaltyReceiptEntity loyaltyReceiptEntity) {
        Intrinsics.checkNotNullParameter(loyaltyReceiptEntity, "");
        return LoyaltyEntityRepositoryMapperExtKt.toOcrReceiptLoyalty(loyaltyReceiptEntity);
    }

    @Override // id.dana.domain.loyalty.LoyaltyRepository
    public final Observable<Boolean> removeReceiptData(String userLoyaltyId) {
        Intrinsics.checkNotNullParameter(userLoyaltyId, "");
        Observable flatMap = getLocalLoyaltyEntityData().deleteReceiptDataByUserLoyaltyId(userLoyaltyId).flatMap(new Function() { // from class: id.dana.data.loyalty.repository.LoyaltyEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1456removeReceiptData$lambda3;
                m1456removeReceiptData$lambda3 = LoyaltyEntityRepository.m1456removeReceiptData$lambda3((Integer) obj);
                return m1456removeReceiptData$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeReceiptData$lambda-3  reason: not valid java name */
    public static final ObservableSource m1456removeReceiptData$lambda3(Integer num) {
        Intrinsics.checkNotNullParameter(num, "");
        return Observable.just(Boolean.TRUE);
    }

    @JvmName(name = "getNetworkLoyaltyEntityData")
    private final LoyaltyEntityData getNetworkLoyaltyEntityData() {
        return (LoyaltyEntityData) this.networkLoyaltyEntityData.getValue();
    }

    @JvmName(name = "getLocalLoyaltyEntityData")
    private final LoyaltyEntityData getLocalLoyaltyEntityData() {
        return (LoyaltyEntityData) this.localLoyaltyEntityData.getValue();
    }
}
