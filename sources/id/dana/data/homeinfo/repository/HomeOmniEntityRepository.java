package id.dana.data.homeinfo.repository;

import id.dana.data.homeinfo.mapper.HomeOmniResultMapperKt;
import id.dana.data.homeinfo.repository.source.HomeOmniEntityDataFactory;
import id.dana.data.homeinfo.repository.source.network.NetworkHomeOmniEntityData;
import id.dana.data.homeinfo.repository.source.network.result.PaylaterChannelResult;
import id.dana.data.homeinfo.repository.source.network.result.ProcessingTransactionResultWrapper;
import id.dana.data.homeinfo.repository.source.network.result.SurveyInfoResultWrapper;
import id.dana.domain.homeinfo.ProcessingTransactionModel;
import id.dana.domain.homeinfo.repository.HomeOmniRepository;
import id.dana.domain.wallet_v3.model.SurveyInfoModel;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\r8GX\u0087\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/homeinfo/repository/HomeOmniEntityRepository;", "Lid/dana/domain/homeinfo/repository/HomeOmniRepository;", "Lio/reactivex/Observable;", "", "getPaylaterChannel", "()Lio/reactivex/Observable;", "Lid/dana/domain/homeinfo/ProcessingTransactionModel;", "getProcessingTransaction", "Lid/dana/domain/wallet_v3/model/SurveyInfoModel;", "getSurveyInfo", "Lid/dana/data/homeinfo/repository/source/HomeOmniEntityDataFactory;", "homeOmniEntityDataFactory", "Lid/dana/data/homeinfo/repository/source/HomeOmniEntityDataFactory;", "Lid/dana/data/homeinfo/repository/source/network/NetworkHomeOmniEntityData;", "networkHomeOmniEntityData$delegate", "Lkotlin/Lazy;", "getNetworkHomeOmniEntityData", "()Lid/dana/data/homeinfo/repository/source/network/NetworkHomeOmniEntityData;", "networkHomeOmniEntityData", "<init>", "(Lid/dana/data/homeinfo/repository/source/HomeOmniEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HomeOmniEntityRepository implements HomeOmniRepository {
    private final HomeOmniEntityDataFactory homeOmniEntityDataFactory;

    /* renamed from: networkHomeOmniEntityData$delegate  reason: from kotlin metadata */
    private final Lazy networkHomeOmniEntityData;

    @Inject
    public HomeOmniEntityRepository(HomeOmniEntityDataFactory homeOmniEntityDataFactory) {
        Intrinsics.checkNotNullParameter(homeOmniEntityDataFactory, "");
        this.homeOmniEntityDataFactory = homeOmniEntityDataFactory;
        this.networkHomeOmniEntityData = LazyKt.lazy(new Function0<NetworkHomeOmniEntityData>() { // from class: id.dana.data.homeinfo.repository.HomeOmniEntityRepository$networkHomeOmniEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NetworkHomeOmniEntityData invoke() {
                HomeOmniEntityDataFactory homeOmniEntityDataFactory2;
                homeOmniEntityDataFactory2 = HomeOmniEntityRepository.this.homeOmniEntityDataFactory;
                return homeOmniEntityDataFactory2.createData2("network");
            }
        });
    }

    @JvmName(name = "getNetworkHomeOmniEntityData")
    public final NetworkHomeOmniEntityData getNetworkHomeOmniEntityData() {
        return (NetworkHomeOmniEntityData) this.networkHomeOmniEntityData.getValue();
    }

    @Override // id.dana.domain.homeinfo.repository.HomeOmniRepository
    public final Observable<String> getPaylaterChannel() {
        Observable map = getNetworkHomeOmniEntityData().getPaylaterChannel().map(new Function() { // from class: id.dana.data.homeinfo.repository.HomeOmniEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String m1370getPaylaterChannel$lambda0;
                m1370getPaylaterChannel$lambda0 = HomeOmniEntityRepository.m1370getPaylaterChannel$lambda0((PaylaterChannelResult) obj);
                return m1370getPaylaterChannel$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPaylaterChannel$lambda-0  reason: not valid java name */
    public static final String m1370getPaylaterChannel$lambda0(PaylaterChannelResult paylaterChannelResult) {
        Intrinsics.checkNotNullParameter(paylaterChannelResult, "");
        String paylaterChannel = paylaterChannelResult.getPaylaterChannel();
        return paylaterChannel == null ? "" : paylaterChannel;
    }

    @Override // id.dana.domain.homeinfo.repository.HomeOmniRepository
    public final Observable<SurveyInfoModel> getSurveyInfo() {
        Observable map = getNetworkHomeOmniEntityData().getSurveyInfo().map(new Function() { // from class: id.dana.data.homeinfo.repository.HomeOmniEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SurveyInfoModel m1372getSurveyInfo$lambda1;
                m1372getSurveyInfo$lambda1 = HomeOmniEntityRepository.m1372getSurveyInfo$lambda1((SurveyInfoResultWrapper) obj);
                return m1372getSurveyInfo$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSurveyInfo$lambda-1  reason: not valid java name */
    public static final SurveyInfoModel m1372getSurveyInfo$lambda1(SurveyInfoResultWrapper surveyInfoResultWrapper) {
        Intrinsics.checkNotNullParameter(surveyInfoResultWrapper, "");
        return HomeOmniResultMapperKt.toSurveyInfoModel(surveyInfoResultWrapper);
    }

    @Override // id.dana.domain.homeinfo.repository.HomeOmniRepository
    public final Observable<ProcessingTransactionModel> getProcessingTransaction() {
        Observable map = getNetworkHomeOmniEntityData().getProcessingTransaction().map(new Function() { // from class: id.dana.data.homeinfo.repository.HomeOmniEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ProcessingTransactionModel m1371getProcessingTransaction$lambda2;
                m1371getProcessingTransaction$lambda2 = HomeOmniEntityRepository.m1371getProcessingTransaction$lambda2((ProcessingTransactionResultWrapper) obj);
                return m1371getProcessingTransaction$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getProcessingTransaction$lambda-2  reason: not valid java name */
    public static final ProcessingTransactionModel m1371getProcessingTransaction$lambda2(ProcessingTransactionResultWrapper processingTransactionResultWrapper) {
        Intrinsics.checkNotNullParameter(processingTransactionResultWrapper, "");
        return HomeOmniResultMapperKt.toProcessingTransactionModel(processingTransactionResultWrapper);
    }
}
