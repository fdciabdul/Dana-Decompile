package id.dana.data.auth.face.repository.source.entity;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.auth.face.FaceAuthMapperKt;
import id.dana.data.auth.face.repository.source.FaceAuthSuggestionDataFactory;
import id.dana.data.auth.face.repository.source.FaceAuthSuggestionRepository;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.auth.face.result.FaceAuthPopUpConsultationResult;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B)\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00102\u001a\u000201¢\u0006\u0004\b;\u0010<J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0016H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J/\u0010$\u001a\u001a\u0012\b\u0012\u0006*\u00020#0#*\f\u0012\b\u0012\u0006*\u00020#0#0\u00040\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010&\u001a\u00020\u000bH\u0016¢\u0006\u0004\b'\u0010%J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010(\u001a\u00020\u000bH\u0016¢\u0006\u0004\b)\u0010%J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0002¢\u0006\u0004\b*\u0010\rR\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\rR\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\rR\u0014\u00109\u001a\u0002088\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b9\u0010:"}, d2 = {"Lid/dana/data/auth/face/repository/source/entity/FaceAuthPopUpConsultationEntityRepository;", "Lid/dana/domain/auth/face/repository/FaceAuthPopUpConsultationRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "", "clearFaceAuthSuggestionState", "()Lio/reactivex/Observable;", "parallelMode", "withKycStatus", "Lid/dana/domain/auth/face/result/FaceAuthPopUpConsultationResult;", "consultFaceAuthPopUpToBackend", "(ZZ)Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "Lid/dana/data/config/source/ConfigEntityData;", "createSplitConfigEntity", "()Lid/dana/data/config/source/ConfigEntityData;", "Lid/dana/data/auth/face/repository/source/FaceAuthSuggestionRepository;", "createSuggestionData", "()Lid/dana/data/auth/face/repository/source/FaceAuthSuggestionRepository;", "Lid/dana/domain/user/UserInfoResponse;", "getUserInfo", "(Z)Lio/reactivex/Observable;", "hasShown", "saveFaceAuthSuggestionState", "shouldNeverShow", "saveNeverShowFaceAuthSuggestionState", "shouldSuggestFaceAuthScreen", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "configEntityDataFactory", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "Lid/dana/data/auth/face/repository/source/FaceAuthSuggestionDataFactory;", "faceAuthSuggestionDataFactory", "Lid/dana/data/auth/face/repository/source/FaceAuthSuggestionDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "getShouldNeverShowFaceAuthSuggestion", "shouldNeverShowFaceAuthSuggestion", "getShouldSuggestFaceAuth", "shouldSuggestFaceAuth", "Lid/dana/domain/user/repository/UserRepository;", "userInfoRepository", "Lid/dana/domain/user/repository/UserRepository;", "<init>", "(Lid/dana/data/config/source/ConfigEntityDataFactory;Lid/dana/domain/user/repository/UserRepository;Lid/dana/data/auth/face/repository/source/FaceAuthSuggestionDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaceAuthPopUpConsultationEntityRepository implements FaceAuthPopUpConsultationRepository, HoldLoginV1Repository {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TWO_WEEKS = 14;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final FaceAuthSuggestionDataFactory faceAuthSuggestionDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final UserRepository userInfoRepository;

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
    public FaceAuthPopUpConsultationEntityRepository(ConfigEntityDataFactory configEntityDataFactory, UserRepository userRepository, FaceAuthSuggestionDataFactory faceAuthSuggestionDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(userRepository, "");
        Intrinsics.checkNotNullParameter(faceAuthSuggestionDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.configEntityDataFactory = configEntityDataFactory;
        this.userInfoRepository = userRepository;
        this.faceAuthSuggestionDataFactory = faceAuthSuggestionDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository
    public final Observable<FaceAuthPopUpConsultationResult> consultFaceAuthPopUpToBackend(boolean parallelMode, final boolean withKycStatus) {
        if (parallelMode) {
            Observable zip = Observable.zip(CollectionsKt.listOf((Object[]) new Observable[]{createSplitConfigEntity().isFaceLoginEnabled(), getUserInfo(withKycStatus)}), new Function() { // from class: id.dana.data.auth.face.repository.source.entity.FaceAuthPopUpConsultationEntityRepository$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    FaceAuthPopUpConsultationResult m788consultFaceAuthPopUpToBackend$lambda0;
                    m788consultFaceAuthPopUpToBackend$lambda0 = FaceAuthPopUpConsultationEntityRepository.m788consultFaceAuthPopUpToBackend$lambda0((Object[]) obj);
                    return m788consultFaceAuthPopUpToBackend$lambda0;
                }
            });
            Intrinsics.checkNotNullExpressionValue(zip, "");
            return authenticatedRequest(zip);
        }
        Observable concatMap = createSplitConfigEntity().isFaceLoginEnabled().timeout(3L, TimeUnit.SECONDS).concatMap(new Function() { // from class: id.dana.data.auth.face.repository.source.entity.FaceAuthPopUpConsultationEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m789consultFaceAuthPopUpToBackend$lambda1;
                m789consultFaceAuthPopUpToBackend$lambda1 = FaceAuthPopUpConsultationEntityRepository.m789consultFaceAuthPopUpToBackend$lambda1((Boolean) obj);
                return m789consultFaceAuthPopUpToBackend$lambda1;
            }
        }).concatMap(new Function() { // from class: id.dana.data.auth.face.repository.source.entity.FaceAuthPopUpConsultationEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m790consultFaceAuthPopUpToBackend$lambda3;
                m790consultFaceAuthPopUpToBackend$lambda3 = FaceAuthPopUpConsultationEntityRepository.m790consultFaceAuthPopUpToBackend$lambda3(FaceAuthPopUpConsultationEntityRepository.this, withKycStatus, (FaceAuthPopUpConsultationResult) obj);
                return m790consultFaceAuthPopUpToBackend$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(concatMap, "");
        return authenticatedRequest(concatMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: consultFaceAuthPopUpToBackend$lambda-0  reason: not valid java name */
    public static final FaceAuthPopUpConsultationResult m788consultFaceAuthPopUpToBackend$lambda0(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "");
        Object obj = objArr[1];
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.domain.user.UserInfoResponse");
        }
        FaceAuthPopUpConsultationResult faceAuthPopUpConsultationResult = FaceAuthMapperKt.toFaceAuthPopUpConsultationResult((UserInfoResponse) obj, Intrinsics.areEqual(ArraysKt.firstOrNull(objArr), Boolean.TRUE));
        Intrinsics.checkNotNull(faceAuthPopUpConsultationResult);
        return faceAuthPopUpConsultationResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: consultFaceAuthPopUpToBackend$lambda-1  reason: not valid java name */
    public static final ObservableSource m789consultFaceAuthPopUpToBackend$lambda1(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "");
        return Observable.just(new FaceAuthPopUpConsultationResult(bool.booleanValue(), false, false, false, false, 30, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: consultFaceAuthPopUpToBackend$lambda-3  reason: not valid java name */
    public static final ObservableSource m790consultFaceAuthPopUpToBackend$lambda3(FaceAuthPopUpConsultationEntityRepository faceAuthPopUpConsultationEntityRepository, boolean z, final FaceAuthPopUpConsultationResult faceAuthPopUpConsultationResult) {
        Intrinsics.checkNotNullParameter(faceAuthPopUpConsultationEntityRepository, "");
        Intrinsics.checkNotNullParameter(faceAuthPopUpConsultationResult, "");
        return faceAuthPopUpConsultationEntityRepository.getUserInfo(z).map(new Function() { // from class: id.dana.data.auth.face.repository.source.entity.FaceAuthPopUpConsultationEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FaceAuthPopUpConsultationResult m791consultFaceAuthPopUpToBackend$lambda3$lambda2;
                m791consultFaceAuthPopUpToBackend$lambda3$lambda2 = FaceAuthPopUpConsultationEntityRepository.m791consultFaceAuthPopUpToBackend$lambda3$lambda2(FaceAuthPopUpConsultationResult.this, (UserInfoResponse) obj);
                return m791consultFaceAuthPopUpToBackend$lambda3$lambda2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: consultFaceAuthPopUpToBackend$lambda-3$lambda-2  reason: not valid java name */
    public static final FaceAuthPopUpConsultationResult m791consultFaceAuthPopUpToBackend$lambda3$lambda2(FaceAuthPopUpConsultationResult faceAuthPopUpConsultationResult, UserInfoResponse userInfoResponse) {
        Intrinsics.checkNotNullParameter(faceAuthPopUpConsultationResult, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        FaceAuthPopUpConsultationResult faceAuthPopUpConsultationResult2 = FaceAuthMapperKt.toFaceAuthPopUpConsultationResult(userInfoResponse, faceAuthPopUpConsultationResult.isFaceLoginFeatureEnabled());
        Intrinsics.checkNotNull(faceAuthPopUpConsultationResult2);
        return faceAuthPopUpConsultationResult2;
    }

    @Override // id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository
    @JvmName(name = "getShouldSuggestFaceAuth")
    public final Observable<Boolean> getShouldSuggestFaceAuth() {
        return shouldSuggestFaceAuthScreen();
    }

    private final Observable<Boolean> shouldSuggestFaceAuthScreen() {
        Observable map = createSuggestionData().getShouldSuggestFaceAuth().map(new Function() { // from class: id.dana.data.auth.face.repository.source.entity.FaceAuthPopUpConsultationEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m792shouldSuggestFaceAuthScreen$lambda4;
                m792shouldSuggestFaceAuthScreen$lambda4 = FaceAuthPopUpConsultationEntityRepository.m792shouldSuggestFaceAuthScreen$lambda4(FaceAuthPopUpConsultationEntityRepository.this, (Boolean) obj);
                return m792shouldSuggestFaceAuthScreen$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shouldSuggestFaceAuthScreen$lambda-4  reason: not valid java name */
    public static final Boolean m792shouldSuggestFaceAuthScreen$lambda4(FaceAuthPopUpConsultationEntityRepository faceAuthPopUpConsultationEntityRepository, Boolean bool) {
        Intrinsics.checkNotNullParameter(faceAuthPopUpConsultationEntityRepository, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return INSTANCE.calcDayDiff(faceAuthPopUpConsultationEntityRepository.createSuggestionData().getFaceAuthSuggestionStateSavingTime()) == 14 ? Boolean.TRUE : bool;
    }

    @Override // id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository
    @JvmName(name = "getShouldNeverShowFaceAuthSuggestion")
    public final Observable<Boolean> getShouldNeverShowFaceAuthSuggestion() {
        return createSuggestionData().getShouldNeverShowFaceAuthSuggestion();
    }

    @Override // id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository
    public final Observable<Boolean> saveFaceAuthSuggestionState(boolean hasShown) {
        createSuggestionData().saveFaceAuthSuggestionStateSavingTime(Calendar.getInstance().getTimeInMillis());
        return createSuggestionData().saveFaceAuthSuggestionState(hasShown);
    }

    @Override // id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository
    public final Observable<Boolean> saveNeverShowFaceAuthSuggestionState(boolean shouldNeverShow) {
        return createSuggestionData().saveNeverShowFaceAuthSuggestionState(shouldNeverShow);
    }

    @Override // id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository
    public final Observable<Boolean> clearFaceAuthSuggestionState() {
        return createSuggestionData().clearFaceAuthSuggestionState();
    }

    private final Observable<UserInfoResponse> getUserInfo(boolean withKycStatus) {
        if (withKycStatus) {
            return this.userInfoRepository.getUserInfo(true);
        }
        return this.userInfoRepository.getFaceAuthInfo(true);
    }

    private final ConfigEntityData createSplitConfigEntity() {
        ConfigEntityData createData2 = this.configEntityDataFactory.createData2("split");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return createData2;
    }

    private final FaceAuthSuggestionRepository createSuggestionData() {
        return this.faceAuthSuggestionDataFactory.createData2("local");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/auth/face/repository/source/entity/FaceAuthPopUpConsultationEntityRepository$Companion;", "", "", "lastSaved", "", "calcDayDiff", "(J)I", "TWO_WEEKS", "I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int calcDayDiff(long lastSaved) {
            return Math.round((((float) (Calendar.getInstance().getTimeInMillis() - new Date(lastSaved).getTime())) * 1.0f) / ((float) TimeUnit.MILLISECONDS.convert(1L, TimeUnit.DAYS)));
        }
    }
}
