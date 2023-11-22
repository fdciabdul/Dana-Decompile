package id.dana.data.saving.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.authcode.repository.source.network.NetworkAuthEntityData$$ExternalSyntheticLambda2;
import id.dana.data.constant.UrlParam;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.saving.repository.SavingEntityData;
import id.dana.data.saving.repository.source.network.exception.GoalsApiException;
import id.dana.data.saving.repository.source.network.request.GoalRevokeRequest;
import id.dana.data.saving.repository.source.network.request.GoalTopUpInitRequest;
import id.dana.data.saving.repository.source.network.request.GoalUpdateInitRequest;
import id.dana.data.saving.repository.source.network.request.GoalUpdateSubmitRequest;
import id.dana.data.saving.repository.source.network.request.SavingDetailRequest;
import id.dana.data.saving.repository.source.network.request.SavingTopUpSubmitRequest;
import id.dana.data.saving.repository.source.network.request.SavingWithdrawInitEntityRequest;
import id.dana.data.saving.repository.source.network.request.UserGoalCreateSubmitRequest;
import id.dana.data.saving.repository.source.network.request.UserSavingSummaryConsultRequest;
import id.dana.data.saving.repository.source.network.response.GoalCreateInitResult;
import id.dana.data.saving.repository.source.network.response.GoalCreateSubmitResult;
import id.dana.data.saving.repository.source.network.response.GoalRevokeResult;
import id.dana.data.saving.repository.source.network.response.GoalTopUpInitResult;
import id.dana.data.saving.repository.source.network.response.GoalUpdateInitResult;
import id.dana.data.saving.repository.source.network.response.GoalUpdateSubmitResult;
import id.dana.data.saving.repository.source.network.response.SavingDetailResult;
import id.dana.data.saving.repository.source.network.response.SavingTopUpSubmitResult;
import id.dana.data.saving.repository.source.network.response.SavingWithdrawInitEntityResult;
import id.dana.data.saving.repository.source.network.response.UserSavingSummaryConsultResult;
import id.dana.domain.saving.model.SavingWithdrawInitRequest;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.ConnectionExceptionParser;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.exception.NetworkException;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001DB)\b\u0007\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\tH\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u001eJ\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\t2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u001eJ-\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010+J5\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\fJ\u001d\u00100\u001a\u00028\u0000\"\b\b\u0000\u0010/*\u00020.*\u00028\u0000H\u0002¢\u0006\u0004\b0\u00101JH\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010/*\u0002022\u0006\u00103\u001a\u0002022\u001f\u00107\u001a\u001b\u0012\u000b\u0012\t\u0018\u000105¢\u0006\u0002\b6\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t04H\u0002¢\u0006\u0004\b8\u00109"}, d2 = {"Lid/dana/data/saving/repository/source/network/NetworkSavingEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/saving/repository/source/network/SavingFacade;", "Lid/dana/data/saving/repository/SavingEntityData;", "", UrlParam.REQUEST_ID, "categoryCode", "title", "targetAmount", "Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalCreateSubmitResult;", "createSaving", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "savingId", "", "topUpViewsPage", "topUpViewsSize", "Lid/dana/data/saving/repository/source/network/response/SavingDetailResult;", "getSavingDetail", "(Ljava/lang/String;JJ)Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/UserSavingSummaryConsultResult;", "getSavingSummary", "()Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalCreateInitResult;", "initSavingCreate", "Lid/dana/data/saving/repository/source/network/response/GoalTopUpInitResult;", "initSavingTopUp", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalUpdateInitResult;", "initSavingUpdate", "Lid/dana/domain/saving/model/SavingWithdrawInitRequest;", "savingWithdrawInitRequest", "Lid/dana/data/saving/repository/source/network/response/SavingWithdrawInitEntityResult;", "initSavingWithdraw", "(Lid/dana/domain/saving/model/SavingWithdrawInitRequest;)Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalRevokeResult;", "revokeSaving", "fundAmount", "Lid/dana/data/saving/repository/source/network/response/SavingTopUpSubmitResult;", "topUpSaving", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalUpdateSubmitResult;", "updateSaving", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "T", "addMobileEnvInfo", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "defaultException", "Lkotlin/Function1;", "Lid/dana/network/exception/NetworkException;", "Lkotlin/ParameterName;", "onNetworkException", "mapGoalsApiExceptions", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkSavingEntityData extends SecureBaseNetwork<SavingFacade> implements SavingEntityData {
    private static final List<String> REACH_MAXIMUM_GOAL_ERROR_CODES = CollectionsKt.listOf((Object[]) new String[]{"DE13113048999200", "DE13113048999201"});

    @Override // id.dana.network.base.BaseNetwork
    public final Class<SavingFacade> getFacadeClass() {
        return SavingFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkSavingEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<UserSavingSummaryConsultResult> getSavingSummary() {
        Observable<UserSavingSummaryConsultResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UserSavingSummaryConsultResult m1881getSavingSummary$lambda0;
                m1881getSavingSummary$lambda0 = NetworkSavingEntityData.m1881getSavingSummary$lambda0(NetworkSavingEntityData.this, (SavingFacade) obj);
                return m1881getSavingSummary$lambda0;
            }
        }).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser())).onErrorResumeNext(new Function() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1882getSavingSummary$lambda1;
                m1882getSavingSummary$lambda1 = NetworkSavingEntityData.m1882getSavingSummary$lambda1(NetworkSavingEntityData.this, (Throwable) obj);
                return m1882getSavingSummary$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* renamed from: getSavingSummary$lambda-0 */
    public static final UserSavingSummaryConsultResult m1881getSavingSummary$lambda0(NetworkSavingEntityData networkSavingEntityData, SavingFacade savingFacade) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        return savingFacade.getSavingSummary((UserSavingSummaryConsultRequest) networkSavingEntityData.addMobileEnvInfo(new UserSavingSummaryConsultRequest(false, 0L, 0L, 7, null)));
    }

    /* renamed from: getSavingSummary$lambda-1 */
    public static final ObservableSource m1882getSavingSummary$lambda1(NetworkSavingEntityData networkSavingEntityData, Throwable th) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        Intrinsics.checkNotNullParameter(th, "");
        return networkSavingEntityData.mapGoalsApiExceptions(th, new GoalsApiException.UnableToLoad(null, null, th.getMessage(), 3, null), new Function1<NetworkException, Observable<UserSavingSummaryConsultResult>>() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$getSavingSummary$3$1
            @Override // kotlin.jvm.functions.Function1
            public final Observable<UserSavingSummaryConsultResult> invoke(NetworkException networkException) {
                Intrinsics.checkNotNullParameter(networkException, "");
                Observable<UserSavingSummaryConsultResult> error = Observable.error(new GoalsApiException.UnableToLoad(networkException.getErrorCode(), networkException.getTraceId(), networkException.getMessage()));
                Intrinsics.checkNotNullExpressionValue(error, "");
                return error;
            }
        });
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<SavingDetailResult> getSavingDetail(final String savingId, final long topUpViewsPage, final long topUpViewsSize) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Observable<SavingDetailResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda10
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SavingDetailResult m1879getSavingDetail$lambda2;
                m1879getSavingDetail$lambda2 = NetworkSavingEntityData.m1879getSavingDetail$lambda2(NetworkSavingEntityData.this, savingId, topUpViewsPage, topUpViewsSize, (SavingFacade) obj);
                return m1879getSavingDetail$lambda2;
            }
        }).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser())).onErrorResumeNext(new Function() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1880getSavingDetail$lambda3;
                m1880getSavingDetail$lambda3 = NetworkSavingEntityData.m1880getSavingDetail$lambda3(NetworkSavingEntityData.this, (Throwable) obj);
                return m1880getSavingDetail$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* renamed from: getSavingDetail$lambda-2 */
    public static final SavingDetailResult m1879getSavingDetail$lambda2(NetworkSavingEntityData networkSavingEntityData, String str, long j, long j2, SavingFacade savingFacade) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return savingFacade.getSavingDetail((SavingDetailRequest) networkSavingEntityData.addMobileEnvInfo(new SavingDetailRequest(str, j, j2)));
    }

    /* renamed from: getSavingDetail$lambda-3 */
    public static final ObservableSource m1880getSavingDetail$lambda3(NetworkSavingEntityData networkSavingEntityData, Throwable th) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        Intrinsics.checkNotNullParameter(th, "");
        return networkSavingEntityData.mapGoalsApiExceptions(th, new GoalsApiException.UnableToLoad(null, null, th.getMessage(), 3, null), new Function1<NetworkException, Observable<SavingDetailResult>>() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$getSavingDetail$3$1
            @Override // kotlin.jvm.functions.Function1
            public final Observable<SavingDetailResult> invoke(NetworkException networkException) {
                Intrinsics.checkNotNullParameter(networkException, "");
                Observable<SavingDetailResult> error = Observable.error(new GoalsApiException.UnableToLoad(networkException.getErrorCode(), networkException.getTraceId(), networkException.getMessage()));
                Intrinsics.checkNotNullExpressionValue(error, "");
                return error;
            }
        });
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<GoalCreateInitResult> initSavingCreate() {
        Observable<GoalCreateInitResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda13
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GoalCreateInitResult m1883initSavingCreate$lambda4;
                m1883initSavingCreate$lambda4 = NetworkSavingEntityData.m1883initSavingCreate$lambda4(NetworkSavingEntityData.this, (SavingFacade) obj);
                return m1883initSavingCreate$lambda4;
            }
        }).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser())).onErrorResumeNext(new Function() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1884initSavingCreate$lambda5;
                m1884initSavingCreate$lambda5 = NetworkSavingEntityData.m1884initSavingCreate$lambda5(NetworkSavingEntityData.this, (Throwable) obj);
                return m1884initSavingCreate$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* renamed from: initSavingCreate$lambda-4 */
    public static final GoalCreateInitResult m1883initSavingCreate$lambda4(NetworkSavingEntityData networkSavingEntityData, SavingFacade savingFacade) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        return savingFacade.initSavingCreate(networkSavingEntityData.addMobileEnvInfo(new BaseRpcRequest()));
    }

    /* renamed from: initSavingCreate$lambda-5 */
    public static final ObservableSource m1884initSavingCreate$lambda5(NetworkSavingEntityData networkSavingEntityData, Throwable th) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        Intrinsics.checkNotNullParameter(th, "");
        return networkSavingEntityData.mapGoalsApiExceptions(th, new GoalsApiException.UnableToCreate(null, null, th.getMessage(), 3, null), new Function1<NetworkException, Observable<GoalCreateInitResult>>() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$initSavingCreate$3$1
            @Override // kotlin.jvm.functions.Function1
            public final Observable<GoalCreateInitResult> invoke(NetworkException networkException) {
                List list;
                Intrinsics.checkNotNullParameter(networkException, "");
                list = NetworkSavingEntityData.REACH_MAXIMUM_GOAL_ERROR_CODES;
                if (list.contains(networkException.getErrorCode())) {
                    Observable<GoalCreateInitResult> error = Observable.error(new GoalsApiException.ReachMaximum(networkException.getErrorCode(), networkException.getTraceId(), networkException.getMessage()));
                    Intrinsics.checkNotNullExpressionValue(error, "");
                    return error;
                }
                Observable<GoalCreateInitResult> error2 = Observable.error(new GoalsApiException.UnableToCreate(networkException.getErrorCode(), networkException.getTraceId(), networkException.getMessage()));
                Intrinsics.checkNotNullExpressionValue(error2, "");
                return error2;
            }
        });
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<GoalCreateSubmitResult> createSaving(final String r9, final String categoryCode, final String title, final String targetAmount) {
        Intrinsics.checkNotNullParameter(r9, "");
        Intrinsics.checkNotNullParameter(categoryCode, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(targetAmount, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GoalCreateSubmitResult m1878createSaving$lambda6;
                m1878createSaving$lambda6 = NetworkSavingEntityData.m1878createSaving$lambda6(NetworkSavingEntityData.this, r9, categoryCode, title, targetAmount, (SavingFacade) obj);
                return m1878createSaving$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: createSaving$lambda-6 */
    public static final GoalCreateSubmitResult m1878createSaving$lambda6(NetworkSavingEntityData networkSavingEntityData, String str, String str2, String str3, String str4, SavingFacade savingFacade) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        return savingFacade.createSaving((UserGoalCreateSubmitRequest) networkSavingEntityData.addMobileEnvInfo(new UserGoalCreateSubmitRequest(str, str2, str3, str4)));
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<GoalUpdateInitResult> initSavingUpdate(final String savingId) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GoalUpdateInitResult m1887initSavingUpdate$lambda7;
                m1887initSavingUpdate$lambda7 = NetworkSavingEntityData.m1887initSavingUpdate$lambda7(NetworkSavingEntityData.this, savingId, (SavingFacade) obj);
                return m1887initSavingUpdate$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: initSavingUpdate$lambda-7 */
    public static final GoalUpdateInitResult m1887initSavingUpdate$lambda7(NetworkSavingEntityData networkSavingEntityData, String str, SavingFacade savingFacade) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return savingFacade.initSavingUpdate((GoalUpdateInitRequest) networkSavingEntityData.addMobileEnvInfo(new GoalUpdateInitRequest(str)));
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<GoalUpdateSubmitResult> updateSaving(final String savingId, final String categoryCode, final String title, final String targetAmount) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Intrinsics.checkNotNullParameter(categoryCode, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(targetAmount, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda12
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GoalUpdateSubmitResult m1892updateSaving$lambda8;
                m1892updateSaving$lambda8 = NetworkSavingEntityData.m1892updateSaving$lambda8(NetworkSavingEntityData.this, savingId, categoryCode, title, targetAmount, (SavingFacade) obj);
                return m1892updateSaving$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: updateSaving$lambda-8 */
    public static final GoalUpdateSubmitResult m1892updateSaving$lambda8(NetworkSavingEntityData networkSavingEntityData, String str, String str2, String str3, String str4, SavingFacade savingFacade) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        return savingFacade.updateSaving((GoalUpdateSubmitRequest) networkSavingEntityData.addMobileEnvInfo(new GoalUpdateSubmitRequest(str, str2, str3, str4)));
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<GoalRevokeResult> revokeSaving(final String savingId) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda5
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GoalRevokeResult m1890revokeSaving$lambda9;
                m1890revokeSaving$lambda9 = NetworkSavingEntityData.m1890revokeSaving$lambda9(NetworkSavingEntityData.this, savingId, (SavingFacade) obj);
                return m1890revokeSaving$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: revokeSaving$lambda-9 */
    public static final GoalRevokeResult m1890revokeSaving$lambda9(NetworkSavingEntityData networkSavingEntityData, String str, SavingFacade savingFacade) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return savingFacade.revokeSaving((GoalRevokeRequest) networkSavingEntityData.addMobileEnvInfo(new GoalRevokeRequest(str)));
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<GoalTopUpInitResult> initSavingTopUp(final String savingId) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Observable<GoalTopUpInitResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GoalTopUpInitResult m1885initSavingTopUp$lambda10;
                m1885initSavingTopUp$lambda10 = NetworkSavingEntityData.m1885initSavingTopUp$lambda10(NetworkSavingEntityData.this, savingId, (SavingFacade) obj);
                return m1885initSavingTopUp$lambda10;
            }
        }).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser())).onErrorResumeNext(new Function() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1886initSavingTopUp$lambda11;
                m1886initSavingTopUp$lambda11 = NetworkSavingEntityData.m1886initSavingTopUp$lambda11(NetworkSavingEntityData.this, (Throwable) obj);
                return m1886initSavingTopUp$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* renamed from: initSavingTopUp$lambda-10 */
    public static final GoalTopUpInitResult m1885initSavingTopUp$lambda10(NetworkSavingEntityData networkSavingEntityData, String str, SavingFacade savingFacade) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return savingFacade.initSavingTopUp((GoalTopUpInitRequest) networkSavingEntityData.addMobileEnvInfo(new GoalTopUpInitRequest(str)));
    }

    /* renamed from: initSavingTopUp$lambda-11 */
    public static final ObservableSource m1886initSavingTopUp$lambda11(NetworkSavingEntityData networkSavingEntityData, Throwable th) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        Intrinsics.checkNotNullParameter(th, "");
        return networkSavingEntityData.mapGoalsApiExceptions(th, new GoalsApiException.UnableToTopUp(null, null, th.getMessage(), 3, null), new Function1<NetworkException, Observable<GoalTopUpInitResult>>() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$initSavingTopUp$3$1
            @Override // kotlin.jvm.functions.Function1
            public final Observable<GoalTopUpInitResult> invoke(NetworkException networkException) {
                Intrinsics.checkNotNullParameter(networkException, "");
                Observable<GoalTopUpInitResult> error = Observable.error(new GoalsApiException.UnableToTopUp(networkException.getErrorCode(), networkException.getTraceId(), networkException.getMessage()));
                Intrinsics.checkNotNullExpressionValue(error, "");
                return error;
            }
        });
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<SavingTopUpSubmitResult> topUpSaving(final String savingId, final String fundAmount, final String r5) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Intrinsics.checkNotNullParameter(fundAmount, "");
        Intrinsics.checkNotNullParameter(r5, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SavingTopUpSubmitResult m1891topUpSaving$lambda12;
                m1891topUpSaving$lambda12 = NetworkSavingEntityData.m1891topUpSaving$lambda12(NetworkSavingEntityData.this, savingId, fundAmount, r5, (SavingFacade) obj);
                return m1891topUpSaving$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: topUpSaving$lambda-12 */
    public static final SavingTopUpSubmitResult m1891topUpSaving$lambda12(NetworkSavingEntityData networkSavingEntityData, String str, String str2, String str3, SavingFacade savingFacade) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        return savingFacade.topUpSaving((SavingTopUpSubmitRequest) networkSavingEntityData.addMobileEnvInfo(new SavingTopUpSubmitRequest(str, str2, str3)));
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<SavingWithdrawInitEntityResult> initSavingWithdraw(final SavingWithdrawInitRequest savingWithdrawInitRequest) {
        Intrinsics.checkNotNullParameter(savingWithdrawInitRequest, "");
        Observable<SavingWithdrawInitEntityResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda8
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SavingWithdrawInitEntityResult m1888initSavingWithdraw$lambda13;
                m1888initSavingWithdraw$lambda13 = NetworkSavingEntityData.m1888initSavingWithdraw$lambda13(NetworkSavingEntityData.this, savingWithdrawInitRequest, (SavingFacade) obj);
                return m1888initSavingWithdraw$lambda13;
            }
        }).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser())).onErrorResumeNext(new Function() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1889initSavingWithdraw$lambda14;
                m1889initSavingWithdraw$lambda14 = NetworkSavingEntityData.m1889initSavingWithdraw$lambda14(NetworkSavingEntityData.this, (Throwable) obj);
                return m1889initSavingWithdraw$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* renamed from: initSavingWithdraw$lambda-13 */
    public static final SavingWithdrawInitEntityResult m1888initSavingWithdraw$lambda13(NetworkSavingEntityData networkSavingEntityData, SavingWithdrawInitRequest savingWithdrawInitRequest, SavingFacade savingFacade) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        Intrinsics.checkNotNullParameter(savingWithdrawInitRequest, "");
        return savingFacade.initSavingWithdraw((SavingWithdrawInitEntityRequest) networkSavingEntityData.addMobileEnvInfo(new SavingWithdrawInitEntityRequest(savingWithdrawInitRequest.getSavingId(), savingWithdrawInitRequest.getWithdrawMethod())));
    }

    /* renamed from: initSavingWithdraw$lambda-14 */
    public static final ObservableSource m1889initSavingWithdraw$lambda14(NetworkSavingEntityData networkSavingEntityData, Throwable th) {
        Intrinsics.checkNotNullParameter(networkSavingEntityData, "");
        Intrinsics.checkNotNullParameter(th, "");
        return networkSavingEntityData.mapGoalsApiExceptions(th, new GoalsApiException.UnableToWithdraw(null, null, th.getMessage(), 3, null), new Function1<NetworkException, Observable<SavingWithdrawInitEntityResult>>() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingEntityData$initSavingWithdraw$3$1
            @Override // kotlin.jvm.functions.Function1
            public final Observable<SavingWithdrawInitEntityResult> invoke(NetworkException networkException) {
                Intrinsics.checkNotNullParameter(networkException, "");
                Observable<SavingWithdrawInitEntityResult> error = Observable.error(new GoalsApiException.UnableToWithdraw(networkException.getErrorCode(), networkException.getTraceId(), networkException.getMessage()));
                Intrinsics.checkNotNullExpressionValue(error, "");
                return error;
            }
        });
    }

    private final <T extends BaseRpcRequest> T addMobileEnvInfo(T t) {
        t.envInfo = generateMobileEnvInfo();
        return t;
    }

    private final <T> Observable<T> mapGoalsApiExceptions(Throwable th, Throwable th2, Function1<? super NetworkException, ? extends Observable<T>> function1) {
        if (th instanceof NoInternetConnectionException) {
            Observable<T> error = Observable.error(th);
            Intrinsics.checkNotNullExpressionValue(error, "");
            return error;
        } else if (th instanceof NetworkException) {
            return function1.invoke(th);
        } else {
            Observable<T> error2 = Observable.error(th2);
            Intrinsics.checkNotNullExpressionValue(error2, "");
            return error2;
        }
    }
}
