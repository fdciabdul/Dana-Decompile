package id.dana.domain.auth.face.repository;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.domain.auth.face.result.FaceAuthenticationResult;
import id.dana.riskChallenges.ui.missedCallOtp.PhoneStateReceiver;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J1\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\nJ;\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/auth/face/repository/FaceAuthenticationRepository;", "", "", "faceAuthNew", "", BioUtilityBridge.SECURITY_ID, NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "Lio/reactivex/Observable;", "Lid/dana/domain/auth/face/result/FaceAuthenticationResult;", "switch", "(ZLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "pin", RecordError.KEY_PUB_KEY, PhoneStateReceiver.VERIFY, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FaceAuthenticationRepository {
    /* renamed from: switch */
    Observable<FaceAuthenticationResult> mo785switch(boolean faceAuthNew, String securityId, String pageSource);

    Observable<FaceAuthenticationResult> verify(boolean faceAuthNew, String securityId, String pin, String pubKey);
}
