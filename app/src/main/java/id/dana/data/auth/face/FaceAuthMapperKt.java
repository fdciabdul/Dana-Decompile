package id.dana.data.auth.face;

import id.dana.domain.auth.face.result.FaceAuthPopUpConsultationResult;
import id.dana.domain.user.UserInfoResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/domain/user/UserInfoResponse;", "", "isFaceLoginFeatureEnabled", "Lid/dana/domain/auth/face/result/FaceAuthPopUpConsultationResult;", "toFaceAuthPopUpConsultationResult", "(Lid/dana/domain/user/UserInfoResponse;Z)Lid/dana/domain/auth/face/result/FaceAuthPopUpConsultationResult;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FaceAuthMapperKt {
    public static final FaceAuthPopUpConsultationResult toFaceAuthPopUpConsultationResult(UserInfoResponse userInfoResponse, boolean z) {
        if (userInfoResponse != null) {
            return new FaceAuthPopUpConsultationResult(z, userInfoResponse.isFaceLoginEnabled(), userInfoResponse.getHasFaceLoginEnrolled(), userInfoResponse.isFaceLoginReady(), (userInfoResponse.getKycInfo() == null || Intrinsics.areEqual(userInfoResponse.getKycInfo(), "KYC0")) ? false : true);
        }
        return null;
    }
}
