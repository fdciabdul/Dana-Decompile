package id.dana.domain.danaprotection.interactor;

import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.auth.face.result.FaceAuthPopUpConsultationResult;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.danaprotection.DanaProtectionInfoRepository;
import id.dana.domain.danaprotection.model.DanaProtectionRecommendationModel;
import id.dana.domain.usercredential.CredentialRepository;
import id.dana.domain.usercredential.model.PinRegularChangesConfig;
import id.dana.domain.usercredential.model.QueryCredentialInfoModel;
import id.dana.domain.usersecurityquestions.model.SecuritySettingData;
import id.dana.domain.usersecurityquestions.model.SecuritySettingMenuData;
import id.dana.domain.usersecurityquestions.model.SecuritySettingMenuGroups;
import id.dana.domain.usersecurityquestions.model.SecuritySettingMenuItems;
import id.dana.domain.usersecurityquestions.model.UserSecurityQuestionInfo;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0002)*B)\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b'\u0010(J+\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&"}, d2 = {"Lid/dana/domain/danaprotection/interactor/GetDanaProtectionRecommendation;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/danaprotection/model/DanaProtectionRecommendationModel;", "Lid/dana/domain/danaprotection/interactor/GetDanaProtectionRecommendation$Params;", "", "name", "", "enable", "value", "buildRecommendationData", "(Ljava/lang/String;ZLjava/lang/String;)Lid/dana/domain/danaprotection/model/DanaProtectionRecommendationModel;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/danaprotection/interactor/GetDanaProtectionRecommendation$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/auth/face/result/FaceAuthPopUpConsultationResult;", "faceAuthPopUpConsultationResult", "Lid/dana/domain/usercredential/model/QueryCredentialInfoModel;", "queryCredentialModel", "Lid/dana/domain/usersecurityquestions/model/UserSecurityQuestionInfo;", "securityQuestionInfo", "combineData", "(Lid/dana/domain/auth/face/result/FaceAuthPopUpConsultationResult;Lid/dana/domain/usercredential/model/QueryCredentialInfoModel;Lid/dana/domain/usersecurityquestions/model/UserSecurityQuestionInfo;)Ljava/util/List;", "emittedUserSecurityInfo", "getSecurityQuestionStatus", "(Lid/dana/domain/usersecurityquestions/model/UserSecurityQuestionInfo;)Ljava/lang/String;", "Lid/dana/domain/usercredential/CredentialRepository;", "credentialEntityRepository", "Lid/dana/domain/usercredential/CredentialRepository;", "Lid/dana/domain/danaprotection/DanaProtectionInfoRepository;", "danaProtectionInfoRepository", "Lid/dana/domain/danaprotection/DanaProtectionInfoRepository;", "Lid/dana/domain/auth/face/repository/FaceAuthPopUpConsultationRepository;", "faceAuthPopUpConsultationRepository", "Lid/dana/domain/auth/face/repository/FaceAuthPopUpConsultationRepository;", "Lid/dana/domain/usersecurityquestions/repository/UserSecurityQuestionStateRepository;", "userSecurityQuestionStateRepository", "Lid/dana/domain/usersecurityquestions/repository/UserSecurityQuestionStateRepository;", "<init>", "(Lid/dana/domain/auth/face/repository/FaceAuthPopUpConsultationRepository;Lid/dana/domain/usercredential/CredentialRepository;Lid/dana/domain/usersecurityquestions/repository/UserSecurityQuestionStateRepository;Lid/dana/domain/danaprotection/DanaProtectionInfoRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetDanaProtectionRecommendation extends BaseUseCase<List<DanaProtectionRecommendationModel>, Params> {
    private static final String CHANGE_PIN = "change_pin";
    private static final String DANA_VIZ = "dana_viz";
    private static final String SECURITY_QUESTION = "security_question";
    private static final String SECURITY_QUESTIONS_TITLE = "Security Question";
    private static final String SECURITY_SETTING_STATUS_ON = "Set";
    private final CredentialRepository credentialEntityRepository;
    private final DanaProtectionInfoRepository danaProtectionInfoRepository;
    private final FaceAuthPopUpConsultationRepository faceAuthPopUpConsultationRepository;
    private final UserSecurityQuestionStateRepository userSecurityQuestionStateRepository;

    @Inject
    public GetDanaProtectionRecommendation(FaceAuthPopUpConsultationRepository faceAuthPopUpConsultationRepository, CredentialRepository credentialRepository, UserSecurityQuestionStateRepository userSecurityQuestionStateRepository, DanaProtectionInfoRepository danaProtectionInfoRepository) {
        Intrinsics.checkNotNullParameter(faceAuthPopUpConsultationRepository, "");
        Intrinsics.checkNotNullParameter(credentialRepository, "");
        Intrinsics.checkNotNullParameter(userSecurityQuestionStateRepository, "");
        Intrinsics.checkNotNullParameter(danaProtectionInfoRepository, "");
        this.faceAuthPopUpConsultationRepository = faceAuthPopUpConsultationRepository;
        this.credentialEntityRepository = credentialRepository;
        this.userSecurityQuestionStateRepository = userSecurityQuestionStateRepository;
        this.danaProtectionInfoRepository = danaProtectionInfoRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<DanaProtectionRecommendationModel>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        if (params.getUseCache()) {
            Observable<List<DanaProtectionRecommendationModel>> just = Observable.just(CollectionsKt.toMutableList((Collection) this.danaProtectionInfoRepository.getDanaProtectionRecommendationInMemoryCache()));
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<List<DanaProtectionRecommendationModel>> zip = Observable.zip(this.faceAuthPopUpConsultationRepository.consultFaceAuthPopUpToBackend(false, false).onErrorReturn(new Function() { // from class: id.dana.domain.danaprotection.interactor.GetDanaProtectionRecommendation$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FaceAuthPopUpConsultationResult m2291buildUseCase$lambda0;
                m2291buildUseCase$lambda0 = GetDanaProtectionRecommendation.m2291buildUseCase$lambda0((Throwable) obj);
                return m2291buildUseCase$lambda0;
            }
        }), this.credentialEntityRepository.getFeaturePinRegularChangesConfig(true).flatMap(new Function() { // from class: id.dana.domain.danaprotection.interactor.GetDanaProtectionRecommendation$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2292buildUseCase$lambda1;
                m2292buildUseCase$lambda1 = GetDanaProtectionRecommendation.m2292buildUseCase$lambda1(GetDanaProtectionRecommendation.this, (PinRegularChangesConfig) obj);
                return m2292buildUseCase$lambda1;
            }
        }), this.userSecurityQuestionStateRepository.getSecurityQuestionState(params.getKbaVersionForSecurityQuestion()), new Function3() { // from class: id.dana.domain.danaprotection.interactor.GetDanaProtectionRecommendation$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                List m2293buildUseCase$lambda2;
                m2293buildUseCase$lambda2 = GetDanaProtectionRecommendation.m2293buildUseCase$lambda2(GetDanaProtectionRecommendation.this, (FaceAuthPopUpConsultationResult) obj, (QueryCredentialInfoModel) obj2, (UserSecurityQuestionInfo) obj3);
                return m2293buildUseCase$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final FaceAuthPopUpConsultationResult m2291buildUseCase$lambda0(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new FaceAuthPopUpConsultationResult(false, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final ObservableSource m2292buildUseCase$lambda1(GetDanaProtectionRecommendation getDanaProtectionRecommendation, PinRegularChangesConfig pinRegularChangesConfig) {
        Observable<QueryCredentialInfoModel> just;
        Intrinsics.checkNotNullParameter(getDanaProtectionRecommendation, "");
        Intrinsics.checkNotNullParameter(pinRegularChangesConfig, "");
        if (pinRegularChangesConfig.getEnable()) {
            just = getDanaProtectionRecommendation.credentialEntityRepository.getPasswordLastModified(true, pinRegularChangesConfig.getPinExpiredInDays());
        } else {
            just = Observable.just(new QueryCredentialInfoModel(1L, true, 1));
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final List m2293buildUseCase$lambda2(GetDanaProtectionRecommendation getDanaProtectionRecommendation, FaceAuthPopUpConsultationResult faceAuthPopUpConsultationResult, QueryCredentialInfoModel queryCredentialInfoModel, UserSecurityQuestionInfo userSecurityQuestionInfo) {
        Intrinsics.checkNotNullParameter(getDanaProtectionRecommendation, "");
        Intrinsics.checkNotNullParameter(faceAuthPopUpConsultationResult, "");
        Intrinsics.checkNotNullParameter(queryCredentialInfoModel, "");
        Intrinsics.checkNotNullParameter(userSecurityQuestionInfo, "");
        return getDanaProtectionRecommendation.combineData(faceAuthPopUpConsultationResult, queryCredentialInfoModel, userSecurityQuestionInfo);
    }

    private final List<DanaProtectionRecommendationModel> combineData(FaceAuthPopUpConsultationResult faceAuthPopUpConsultationResult, QueryCredentialInfoModel queryCredentialModel, UserSecurityQuestionInfo securityQuestionInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(buildRecommendationData$default(this, DANA_VIZ, faceAuthPopUpConsultationResult.getHasFaceLoginEnrolled(), null, 4, null));
        arrayList.add(buildRecommendationData$default(this, "change_pin", !queryCredentialModel.shouldChangePin(), null, 4, null));
        arrayList.add(buildRecommendationData$default(this, SECURITY_QUESTION, Intrinsics.areEqual(getSecurityQuestionStatus(securityQuestionInfo), SECURITY_SETTING_STATUS_ON), null, 4, null));
        this.danaProtectionInfoRepository.setDanaProtectionRecommendationInMemoryCache(arrayList);
        return arrayList;
    }

    static /* synthetic */ DanaProtectionRecommendationModel buildRecommendationData$default(GetDanaProtectionRecommendation getDanaProtectionRecommendation, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return getDanaProtectionRecommendation.buildRecommendationData(str, z, str2);
    }

    private final DanaProtectionRecommendationModel buildRecommendationData(String name, boolean enable, String value) {
        return new DanaProtectionRecommendationModel(name, enable, value);
    }

    private final String getSecurityQuestionStatus(UserSecurityQuestionInfo emittedUserSecurityInfo) {
        SecuritySettingData data;
        SecuritySettingMenuData menuData;
        SecuritySettingMenuGroups[] menuGroups;
        SecuritySettingMenuItems securitySettingMenuItems;
        if (emittedUserSecurityInfo != null && (data = emittedUserSecurityInfo.getData()) != null && (menuData = data.getMenuData()) != null && (menuGroups = menuData.getMenuGroups()) != null) {
            for (SecuritySettingMenuGroups securitySettingMenuGroups : menuGroups) {
                SecuritySettingMenuItems[] menuItems = securitySettingMenuGroups.getMenuItems();
                Intrinsics.checkNotNullExpressionValue(menuItems, "");
                SecuritySettingMenuItems[] securitySettingMenuItemsArr = menuItems;
                int length = securitySettingMenuItemsArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        securitySettingMenuItems = null;
                        break;
                    }
                    securitySettingMenuItems = securitySettingMenuItemsArr[i];
                    if (Intrinsics.areEqual(securitySettingMenuItems.getTitle(), SECURITY_QUESTIONS_TITLE)) {
                        break;
                    }
                    i++;
                }
                SecuritySettingMenuItems securitySettingMenuItems2 = securitySettingMenuItems;
                if (securitySettingMenuItems2 != null) {
                    return securitySettingMenuItems2.getDesc();
                }
            }
        }
        return null;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007"}, d2 = {"Lid/dana/domain/danaprotection/interactor/GetDanaProtectionRecommendation$Params;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "kbaVersionForSecurityQuestion", "useCache", "copy", "(Ljava/lang/String;Z)Lid/dana/domain/danaprotection/interactor/GetDanaProtectionRecommendation$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getKbaVersionForSecurityQuestion", "Z", "getUseCache", "<init>", "(Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Params {
        private final String kbaVersionForSecurityQuestion;
        private final boolean useCache;

        public static /* synthetic */ Params copy$default(Params params, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.kbaVersionForSecurityQuestion;
            }
            if ((i & 2) != 0) {
                z = params.useCache;
            }
            return params.copy(str, z);
        }

        /* renamed from: component1  reason: from getter */
        public final String getKbaVersionForSecurityQuestion() {
            return this.kbaVersionForSecurityQuestion;
        }

        /* renamed from: component2  reason: from getter */
        public final boolean getUseCache() {
            return this.useCache;
        }

        public final Params copy(String kbaVersionForSecurityQuestion, boolean useCache) {
            Intrinsics.checkNotNullParameter(kbaVersionForSecurityQuestion, "");
            return new Params(kbaVersionForSecurityQuestion, useCache);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.kbaVersionForSecurityQuestion, params.kbaVersionForSecurityQuestion) && this.useCache == params.useCache;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.kbaVersionForSecurityQuestion.hashCode();
            boolean z = this.useCache;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (hashCode * 31) + i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(kbaVersionForSecurityQuestion=");
            sb.append(this.kbaVersionForSecurityQuestion);
            sb.append(", useCache=");
            sb.append(this.useCache);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            this.kbaVersionForSecurityQuestion = str;
            this.useCache = z;
        }

        public /* synthetic */ Params(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? false : z);
        }

        @JvmName(name = "getKbaVersionForSecurityQuestion")
        public final String getKbaVersionForSecurityQuestion() {
            return this.kbaVersionForSecurityQuestion;
        }

        @JvmName(name = "getUseCache")
        public final boolean getUseCache() {
            return this.useCache;
        }
    }
}
