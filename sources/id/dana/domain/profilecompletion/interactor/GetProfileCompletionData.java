package id.dana.domain.profilecompletion.interactor;

import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.auth.face.result.FaceAuthPopUpConsultationResult;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.profilecompletion.model.ProfileCompletionData;
import id.dana.domain.twilio.TwilioEnrollmentEligibilityRepository;
import id.dana.domain.twilio.model.TwilioInfo;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useremailaddress.model.UserEmailAddress;
import id.dana.domain.useremailaddress.repository.UserEmailAddressRepository;
import id.dana.domain.usersecurityquestions.model.SecuritySettingData;
import id.dana.domain.usersecurityquestions.model.SecuritySettingMenuData;
import id.dana.domain.usersecurityquestions.model.SecuritySettingMenuGroups;
import id.dana.domain.usersecurityquestions.model.SecuritySettingMenuItems;
import id.dana.domain.usersecurityquestions.model.UserSecurityQuestionInfo;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function5;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002%&B1\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\u000e\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/domain/profilecompletion/interactor/GetProfileCompletionData;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/profilecompletion/model/ProfileCompletionData;", "Lid/dana/domain/profilecompletion/interactor/GetProfileCompletionData$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/profilecompletion/interactor/GetProfileCompletionData$Params;)Lio/reactivex/Observable;", "Lio/reactivex/functions/Function5;", "Lid/dana/domain/auth/face/result/FaceAuthPopUpConsultationResult;", "Lid/dana/domain/twilio/model/TwilioInfo;", "Lid/dana/domain/user/UserInfoResponse;", "Lid/dana/domain/useremailaddress/model/UserEmailAddress;", "Lid/dana/domain/usersecurityquestions/model/UserSecurityQuestionInfo;", "combineData", "()Lio/reactivex/functions/Function5;", "emittedUserSecurityInfo", "", "getSecurityQuestionStatus", "(Lid/dana/domain/usersecurityquestions/model/UserSecurityQuestionInfo;)Ljava/lang/String;", "Lid/dana/domain/auth/face/repository/FaceAuthPopUpConsultationRepository;", "faceAuthPopUpConsultationRepository", "Lid/dana/domain/auth/face/repository/FaceAuthPopUpConsultationRepository;", "Lid/dana/domain/twilio/TwilioEnrollmentEligibilityRepository;", "twilioEnrollmentEligibilityRepository", "Lid/dana/domain/twilio/TwilioEnrollmentEligibilityRepository;", "Lid/dana/domain/useremailaddress/repository/UserEmailAddressRepository;", "userEmailAddressRepository", "Lid/dana/domain/useremailaddress/repository/UserEmailAddressRepository;", "Lid/dana/domain/user/repository/UserRepository;", "userRepository", "Lid/dana/domain/user/repository/UserRepository;", "Lid/dana/domain/usersecurityquestions/repository/UserSecurityQuestionStateRepository;", "userSecurityQuestionStateRepository", "Lid/dana/domain/usersecurityquestions/repository/UserSecurityQuestionStateRepository;", "<init>", "(Lid/dana/domain/auth/face/repository/FaceAuthPopUpConsultationRepository;Lid/dana/domain/twilio/TwilioEnrollmentEligibilityRepository;Lid/dana/domain/user/repository/UserRepository;Lid/dana/domain/useremailaddress/repository/UserEmailAddressRepository;Lid/dana/domain/usersecurityquestions/repository/UserSecurityQuestionStateRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetProfileCompletionData extends BaseUseCase<ProfileCompletionData, Params> {
    private static final String SECURITY_QUESTIONS_TITLE = "Security Question";
    private static final String SECURITY_SETTING_STATUS_ON = "Set";
    private final FaceAuthPopUpConsultationRepository faceAuthPopUpConsultationRepository;
    private final TwilioEnrollmentEligibilityRepository twilioEnrollmentEligibilityRepository;
    private final UserEmailAddressRepository userEmailAddressRepository;
    private final UserRepository userRepository;
    private final UserSecurityQuestionStateRepository userSecurityQuestionStateRepository;

    @Inject
    public GetProfileCompletionData(FaceAuthPopUpConsultationRepository faceAuthPopUpConsultationRepository, TwilioEnrollmentEligibilityRepository twilioEnrollmentEligibilityRepository, UserRepository userRepository, UserEmailAddressRepository userEmailAddressRepository, UserSecurityQuestionStateRepository userSecurityQuestionStateRepository) {
        Intrinsics.checkNotNullParameter(faceAuthPopUpConsultationRepository, "");
        Intrinsics.checkNotNullParameter(twilioEnrollmentEligibilityRepository, "");
        Intrinsics.checkNotNullParameter(userRepository, "");
        Intrinsics.checkNotNullParameter(userEmailAddressRepository, "");
        Intrinsics.checkNotNullParameter(userSecurityQuestionStateRepository, "");
        this.faceAuthPopUpConsultationRepository = faceAuthPopUpConsultationRepository;
        this.twilioEnrollmentEligibilityRepository = twilioEnrollmentEligibilityRepository;
        this.userRepository = userRepository;
        this.userEmailAddressRepository = userEmailAddressRepository;
        this.userSecurityQuestionStateRepository = userSecurityQuestionStateRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<ProfileCompletionData> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<ProfileCompletionData> zip = Observable.zip(this.faceAuthPopUpConsultationRepository.consultFaceAuthPopUpToBackend(false, false).onErrorReturn(new Function() { // from class: id.dana.domain.profilecompletion.interactor.GetProfileCompletionData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FaceAuthPopUpConsultationResult m2413buildUseCase$lambda0;
                m2413buildUseCase$lambda0 = GetProfileCompletionData.m2413buildUseCase$lambda0((Throwable) obj);
                return m2413buildUseCase$lambda0;
            }
        }), this.twilioEnrollmentEligibilityRepository.getTwilioIsEligibleForEnrollment().onErrorReturn(new Function() { // from class: id.dana.domain.profilecompletion.interactor.GetProfileCompletionData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TwilioInfo m2414buildUseCase$lambda1;
                m2414buildUseCase$lambda1 = GetProfileCompletionData.m2414buildUseCase$lambda1((Throwable) obj);
                return m2414buildUseCase$lambda1;
            }
        }), this.userRepository.getUserInfoWithKyc(false), this.userEmailAddressRepository.getEmailAddressAndVerifyResult(), this.userSecurityQuestionStateRepository.getSecurityQuestionState(params.getKbaVersionForSecurityQuestion()), combineData());
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final FaceAuthPopUpConsultationResult m2413buildUseCase$lambda0(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new FaceAuthPopUpConsultationResult(false, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final TwilioInfo m2414buildUseCase$lambda1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new TwilioInfo(false, false, null, null, 12, null);
    }

    private final Function5<FaceAuthPopUpConsultationResult, TwilioInfo, UserInfoResponse, UserEmailAddress, UserSecurityQuestionInfo, ProfileCompletionData> combineData() {
        return new Function5() { // from class: id.dana.domain.profilecompletion.interactor.GetProfileCompletionData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function5
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                ProfileCompletionData m2415combineData$lambda3;
                m2415combineData$lambda3 = GetProfileCompletionData.m2415combineData$lambda3(GetProfileCompletionData.this, (FaceAuthPopUpConsultationResult) obj, (TwilioInfo) obj2, (UserInfoResponse) obj3, (UserEmailAddress) obj4, (UserSecurityQuestionInfo) obj5);
                return m2415combineData$lambda3;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: combineData$lambda-3  reason: not valid java name */
    public static final ProfileCompletionData m2415combineData$lambda3(GetProfileCompletionData getProfileCompletionData, FaceAuthPopUpConsultationResult faceAuthPopUpConsultationResult, TwilioInfo twilioInfo, UserInfoResponse userInfoResponse, UserEmailAddress userEmailAddress, UserSecurityQuestionInfo userSecurityQuestionInfo) {
        String loginId;
        Intrinsics.checkNotNullParameter(getProfileCompletionData, "");
        Intrinsics.checkNotNullParameter(faceAuthPopUpConsultationResult, "");
        Intrinsics.checkNotNullParameter(twilioInfo, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        Intrinsics.checkNotNullParameter(userEmailAddress, "");
        Intrinsics.checkNotNullParameter(userSecurityQuestionInfo, "");
        ProfileCompletionData profileCompletionData = new ProfileCompletionData(null, null, null, false, false, false, false, null, false, null, null, 2047, null);
        boolean matches = new Regex("\\d+").matches(userInfoResponse.getNickname());
        if (matches) {
            loginId = userInfoResponse.getNickname();
        } else {
            loginId = userInfoResponse.getLoginId();
        }
        profileCompletionData.setPhoneNumber(loginId);
        profileCompletionData.setNickName(!matches ? userInfoResponse.getNickname() : "");
        profileCompletionData.setUsername(userInfoResponse.getUsername());
        profileCompletionData.setEmail(Intrinsics.areEqual(userEmailAddress.getVerifyStatus(), UserEmailAddress.INSTANCE.getUNVERIFIED_EMAIL()) ? "" : userEmailAddress.getUserEmail());
        profileCompletionData.setSecurityQuestionAvailable(Intrinsics.areEqual(getProfileCompletionData.getSecurityQuestionStatus(userSecurityQuestionInfo), SECURITY_SETTING_STATUS_ON));
        profileCompletionData.setShouldShowFaceAuth(faceAuthPopUpConsultationResult.getShouldShowProfileCompletionTask());
        profileCompletionData.setShouldShowTrustedDevice(twilioInfo.getRegisterAllowed());
        profileCompletionData.setTrustedDeviceRegistered(twilioInfo.getRegistered());
        profileCompletionData.setKycAccepted(Intrinsics.areEqual("KYC2", userInfoResponse.getKycInfo()));
        String securityId = twilioInfo.getSecurityId();
        profileCompletionData.setSecurityIdForTrustedDevice(securityId != null ? securityId : "");
        return profileCompletionData;
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/profilecompletion/interactor/GetProfileCompletionData$Params;", "", "", "component1", "()Ljava/lang/String;", "kbaVersionForSecurityQuestion", "copy", "(Ljava/lang/String;)Lid/dana/domain/profilecompletion/interactor/GetProfileCompletionData$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getKbaVersionForSecurityQuestion", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final String kbaVersionForSecurityQuestion;

        public static /* synthetic */ Params copy$default(Params params, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.kbaVersionForSecurityQuestion;
            }
            return params.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getKbaVersionForSecurityQuestion() {
            return this.kbaVersionForSecurityQuestion;
        }

        public final Params copy(String kbaVersionForSecurityQuestion) {
            Intrinsics.checkNotNullParameter(kbaVersionForSecurityQuestion, "");
            return new Params(kbaVersionForSecurityQuestion);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.kbaVersionForSecurityQuestion, ((Params) other).kbaVersionForSecurityQuestion);
        }

        public final int hashCode() {
            return this.kbaVersionForSecurityQuestion.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(kbaVersionForSecurityQuestion=");
            sb.append(this.kbaVersionForSecurityQuestion);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.kbaVersionForSecurityQuestion = str;
        }

        @JvmName(name = "getKbaVersionForSecurityQuestion")
        public final String getKbaVersionForSecurityQuestion() {
            return this.kbaVersionForSecurityQuestion;
        }
    }
}
