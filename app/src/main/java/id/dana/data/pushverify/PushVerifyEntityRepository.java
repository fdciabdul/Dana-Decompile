package id.dana.data.pushverify;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.pushverify.mapper.PushVerifyChallengeMapperKt;
import id.dana.data.pushverify.mapper.VerifyPushChallengeMapperKt;
import id.dana.data.pushverify.source.PushVerifyEntityData;
import id.dana.data.pushverify.source.PushVerifyEntityDataFactory;
import id.dana.data.pushverify.source.PushVerifyPreferenceEntityData;
import id.dana.data.pushverify.source.PushVerifyPreferenceEntityDataFactory;
import id.dana.data.pushverify.source.model.PushVerificationListResult;
import id.dana.data.pushverify.source.model.PushVerifyChallengeResult;
import id.dana.data.pushverify.source.model.VerifyPushChallengeResult;
import id.dana.domain.pushverify.model.PushVerificationList;
import id.dana.domain.pushverify.model.PushVerifyChallenge;
import id.dana.domain.pushverify.model.PushVerifyParam;
import id.dana.domain.pushverify.model.VerifyPushChallenge;
import id.dana.domain.pushverify.model.VerifyPushChallengeParam;
import id.dana.domain.pushverify.repository.PushVerifyRepository;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\bF\u0010GJ*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0004H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020#H\u0016¢\u0006\u0004\b(\u0010)J\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u00042\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010.R\u001b\u00102\u001a\u00020\u000b8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\rR\u0014\u00104\u001a\u0002038\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010:\u001a\u0002068CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b7\u00100\u001a\u0004\b8\u00109R\u0014\u0010<\u001a\u00020;8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001b\u0010B\u001a\u00020>8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b?\u00100\u001a\u0004\b@\u0010AR\u0014\u0010D\u001a\u00020C8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bD\u0010E"}, d2 = {"Lid/dana/data/pushverify/PushVerifyEntityRepository;", "Lid/dana/domain/pushverify/repository/PushVerifyRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "", "", "verificationStatusList", "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "Lid/dana/domain/pushverify/model/PushVerificationList;", "getPushVerificationList", "(Ljava/util/List;II)Lio/reactivex/Observable;", "Lid/dana/domain/pushverify/model/PushVerifyParam;", "pushVerifyParam", "Lid/dana/domain/pushverify/model/PushVerifyChallenge;", "getPushVerifyChallenge", "(Lid/dana/domain/pushverify/model/PushVerifyParam;)Lio/reactivex/Observable;", "", "isNotificationPromptDisabled", "()Lio/reactivex/Observable;", "enabled", "Lio/reactivex/Completable;", "saveNotificationPromptPreference", "(Z)Lio/reactivex/Completable;", "Lid/dana/domain/pushverify/model/VerifyPushChallengeParam;", "verifyPushChallengeParam", "Lid/dana/domain/pushverify/model/VerifyPushChallenge;", "verifyPushChallenge", "(Lid/dana/domain/pushverify/model/VerifyPushChallengeParam;)Lio/reactivex/Observable;", "accountEntityData$delegate", "Lkotlin/Lazy;", "getAccountEntityData", "accountEntityData", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/pushverify/source/PushVerifyEntityData;", "pushVerifyData$delegate", "getPushVerifyData", "()Lid/dana/data/pushverify/source/PushVerifyEntityData;", "pushVerifyData", "Lid/dana/data/pushverify/source/PushVerifyEntityDataFactory;", "pushVerifyEntityDataFactory", "Lid/dana/data/pushverify/source/PushVerifyEntityDataFactory;", "Lid/dana/data/pushverify/source/PushVerifyPreferenceEntityData;", "pushVerifyPreference$delegate", "getPushVerifyPreference", "()Lid/dana/data/pushverify/source/PushVerifyPreferenceEntityData;", "pushVerifyPreference", "Lid/dana/data/pushverify/source/PushVerifyPreferenceEntityDataFactory;", "pushVerifyPreferenceEntityDataFactory", "Lid/dana/data/pushverify/source/PushVerifyPreferenceEntityDataFactory;", "<init>", "(Lid/dana/data/pushverify/source/PushVerifyEntityDataFactory;Lid/dana/data/pushverify/source/PushVerifyPreferenceEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PushVerifyEntityRepository implements PushVerifyRepository, HoldLoginV1Repository {

    /* renamed from: accountEntityData$delegate  reason: from kotlin metadata */
    private final Lazy accountEntityData;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;

    /* renamed from: pushVerifyData$delegate  reason: from kotlin metadata */
    private final Lazy pushVerifyData;
    private final PushVerifyEntityDataFactory pushVerifyEntityDataFactory;

    /* renamed from: pushVerifyPreference$delegate  reason: from kotlin metadata */
    private final Lazy pushVerifyPreference;
    private final PushVerifyPreferenceEntityDataFactory pushVerifyPreferenceEntityDataFactory;

    public final <T> Observable<T> authenticatedRequest(Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "");
        Observable<T> authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(observable);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    public final <T> Flow<T> authenticatedRequest(Flow<? extends T> flow) {
        Intrinsics.checkNotNullParameter(flow, "");
        return this.holdLoginV1EntityRepository.PlaceComponentResult(flow);
    }

    public final AccountEntityData createAccountData() {
        AccountEntityData createAccountData = this.holdLoginV1EntityRepository.createAccountData();
        Intrinsics.checkNotNullExpressionValue(createAccountData, "");
        return createAccountData;
    }

    public final ErrorConfigEntityData createLocalErrorConfigData() {
        ErrorConfigEntityData createLocalErrorConfigData = this.holdLoginV1EntityRepository.createLocalErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createLocalErrorConfigData, "");
        return createLocalErrorConfigData;
    }

    public final ErrorConfigEntityData createNetworkErrorConfigData() {
        ErrorConfigEntityData createNetworkErrorConfigData = this.holdLoginV1EntityRepository.createNetworkErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createNetworkErrorConfigData, "");
        return createNetworkErrorConfigData;
    }

    public final LoginEntityData createNetworkLogin() {
        LoginEntityData createNetworkLogin = this.holdLoginV1EntityRepository.createNetworkLogin();
        Intrinsics.checkNotNullExpressionValue(createNetworkLogin, "");
        return createNetworkLogin;
    }

    @Inject
    public PushVerifyEntityRepository(PushVerifyEntityDataFactory pushVerifyEntityDataFactory, PushVerifyPreferenceEntityDataFactory pushVerifyPreferenceEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(pushVerifyEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(pushVerifyPreferenceEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.pushVerifyEntityDataFactory = pushVerifyEntityDataFactory;
        this.pushVerifyPreferenceEntityDataFactory = pushVerifyPreferenceEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
        this.pushVerifyData = LazyKt.lazy(new Function0<PushVerifyEntityData>() { // from class: id.dana.data.pushverify.PushVerifyEntityRepository$pushVerifyData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PushVerifyEntityData invoke() {
                PushVerifyEntityDataFactory pushVerifyEntityDataFactory2;
                pushVerifyEntityDataFactory2 = PushVerifyEntityRepository.this.pushVerifyEntityDataFactory;
                return pushVerifyEntityDataFactory2.createData2("network");
            }
        });
        this.pushVerifyPreference = LazyKt.lazy(new Function0<PushVerifyPreferenceEntityData>() { // from class: id.dana.data.pushverify.PushVerifyEntityRepository$pushVerifyPreference$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PushVerifyPreferenceEntityData invoke() {
                PushVerifyPreferenceEntityDataFactory pushVerifyPreferenceEntityDataFactory2;
                pushVerifyPreferenceEntityDataFactory2 = PushVerifyEntityRepository.this.pushVerifyPreferenceEntityDataFactory;
                return pushVerifyPreferenceEntityDataFactory2.createData2("local");
            }
        });
        this.accountEntityData = LazyKt.lazy(new Function0<AccountEntityData>() { // from class: id.dana.data.pushverify.PushVerifyEntityRepository$accountEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountEntityData invoke() {
                return PushVerifyEntityRepository.this.createAccountData();
            }
        });
    }

    @JvmName(name = "getPushVerifyData")
    private final PushVerifyEntityData getPushVerifyData() {
        return (PushVerifyEntityData) this.pushVerifyData.getValue();
    }

    @JvmName(name = "getPushVerifyPreference")
    private final PushVerifyPreferenceEntityData getPushVerifyPreference() {
        return (PushVerifyPreferenceEntityData) this.pushVerifyPreference.getValue();
    }

    @JvmName(name = "getAccountEntityData")
    private final AccountEntityData getAccountEntityData() {
        return (AccountEntityData) this.accountEntityData.getValue();
    }

    @Override // id.dana.domain.pushverify.repository.PushVerifyRepository
    public final Observable<PushVerificationList> getPushVerificationList(List<String> verificationStatusList, int pageNum, int pageSize) {
        Intrinsics.checkNotNullParameter(verificationStatusList, "");
        ObservableSource map = getPushVerifyData().getPushVerificationList(verificationStatusList, pageNum, pageSize).map(new Function() { // from class: id.dana.data.pushverify.PushVerifyEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PushVerificationList m1677getPushVerificationList$lambda0;
                m1677getPushVerificationList$lambda0 = PushVerifyEntityRepository.m1677getPushVerificationList$lambda0((PushVerificationListResult) obj);
                return m1677getPushVerificationList$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPushVerificationList$lambda-0  reason: not valid java name */
    public static final PushVerificationList m1677getPushVerificationList$lambda0(PushVerificationListResult pushVerificationListResult) {
        Intrinsics.checkNotNullParameter(pushVerificationListResult, "");
        return PushVerifyChallengeMapperKt.toPushVerificationList(pushVerificationListResult);
    }

    @Override // id.dana.domain.pushverify.repository.PushVerifyRepository
    public final Observable<PushVerifyChallenge> getPushVerifyChallenge(PushVerifyParam pushVerifyParam) {
        Intrinsics.checkNotNullParameter(pushVerifyParam, "");
        ObservableSource map = getPushVerifyData().getPushVerifyChallenge(PushVerifyChallengeMapperKt.toPushVerifyChallengeRequest(pushVerifyParam)).map(new Function() { // from class: id.dana.data.pushverify.PushVerifyEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PushVerifyChallenge m1678getPushVerifyChallenge$lambda1;
                m1678getPushVerifyChallenge$lambda1 = PushVerifyEntityRepository.m1678getPushVerifyChallenge$lambda1((PushVerifyChallengeResult) obj);
                return m1678getPushVerifyChallenge$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPushVerifyChallenge$lambda-1  reason: not valid java name */
    public static final PushVerifyChallenge m1678getPushVerifyChallenge$lambda1(PushVerifyChallengeResult pushVerifyChallengeResult) {
        Intrinsics.checkNotNullParameter(pushVerifyChallengeResult, "");
        return PushVerifyChallengeMapperKt.toPushVerifyChallenge(pushVerifyChallengeResult);
    }

    @Override // id.dana.domain.pushverify.repository.PushVerifyRepository
    public final Observable<VerifyPushChallenge> verifyPushChallenge(VerifyPushChallengeParam verifyPushChallengeParam) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeParam, "");
        ObservableSource map = getPushVerifyData().verifyPushChallenge(VerifyPushChallengeMapperKt.toVerifyPushChallengeRequest(verifyPushChallengeParam)).map(new Function() { // from class: id.dana.data.pushverify.PushVerifyEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VerifyPushChallenge m1681verifyPushChallenge$lambda2;
                m1681verifyPushChallenge$lambda2 = PushVerifyEntityRepository.m1681verifyPushChallenge$lambda2((VerifyPushChallengeResult) obj);
                return m1681verifyPushChallenge$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: verifyPushChallenge$lambda-2  reason: not valid java name */
    public static final VerifyPushChallenge m1681verifyPushChallenge$lambda2(VerifyPushChallengeResult verifyPushChallengeResult) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeResult, "");
        return VerifyPushChallengeMapperKt.toVerifyPushChallenge(verifyPushChallengeResult);
    }

    @Override // id.dana.domain.pushverify.repository.PushVerifyRepository
    public final Completable saveNotificationPromptPreference(final boolean enabled) {
        Completable flatMapCompletable = getAccountEntityData().getPhoneNumber().flatMapCompletable(new Function() { // from class: id.dana.data.pushverify.PushVerifyEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource m1680saveNotificationPromptPreference$lambda3;
                m1680saveNotificationPromptPreference$lambda3 = PushVerifyEntityRepository.m1680saveNotificationPromptPreference$lambda3(PushVerifyEntityRepository.this, enabled, (String) obj);
                return m1680saveNotificationPromptPreference$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "");
        return flatMapCompletable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveNotificationPromptPreference$lambda-3  reason: not valid java name */
    public static final CompletableSource m1680saveNotificationPromptPreference$lambda3(PushVerifyEntityRepository pushVerifyEntityRepository, boolean z, String str) {
        Intrinsics.checkNotNullParameter(pushVerifyEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return pushVerifyEntityRepository.getPushVerifyPreference().saveNotificationPromptPreference(str, z);
    }

    @Override // id.dana.domain.pushverify.repository.PushVerifyRepository
    public final Observable<Boolean> isNotificationPromptDisabled() {
        Observable flatMap = getAccountEntityData().getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.pushverify.PushVerifyEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1679isNotificationPromptDisabled$lambda4;
                m1679isNotificationPromptDisabled$lambda4 = PushVerifyEntityRepository.m1679isNotificationPromptDisabled$lambda4(PushVerifyEntityRepository.this, (String) obj);
                return m1679isNotificationPromptDisabled$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isNotificationPromptDisabled$lambda-4  reason: not valid java name */
    public static final ObservableSource m1679isNotificationPromptDisabled$lambda4(PushVerifyEntityRepository pushVerifyEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(pushVerifyEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return pushVerifyEntityRepository.getPushVerifyPreference().isNotificationPromptDisabled(str);
    }
}
