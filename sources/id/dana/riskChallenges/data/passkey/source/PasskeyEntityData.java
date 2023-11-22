package id.dana.riskChallenges.data.passkey.source;

import com.alibaba.fastjson.JSONObject;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.riskChallenges.data.passkey.source.network.AuthenticationFinishResponse;
import id.dana.riskChallenges.data.passkey.source.network.AuthenticationStartResponse;
import id.dana.riskChallenges.data.passkey.source.network.QueryUserCredentialsResponse;
import id.dana.riskChallenges.data.passkey.source.network.RegistrationFinishResponse;
import id.dana.riskChallenges.data.passkey.source.network.RegistrationStartResponse;
import id.dana.riskChallenges.data.passkey.source.network.RemoveCredentialResponse;
import io.reactivex.Observable;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\tJ)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0019\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/PasskeyEntityData;", "", "Lcom/alibaba/fastjson/JSONObject;", "credential", "", "userId", "Lio/reactivex/Observable;", "Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationFinishResponse;", "authenticationFinish", "(Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationStartResponse;", "authenticationStart", "()Lio/reactivex/Observable;", "credentialId", "Lid/dana/riskChallenges/data/passkey/source/network/QueryUserCredentialsResponse;", "queryUserCredentials", "(Ljava/lang/String;)Lio/reactivex/Observable;", BioUtilityBridge.SECURITY_ID, "Lid/dana/riskChallenges/data/passkey/source/network/RegistrationFinishResponse;", "registrationFinish", NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "Lid/dana/riskChallenges/data/passkey/source/network/RegistrationStartResponse;", "registrationStart", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/riskChallenges/data/passkey/source/network/RemoveCredentialResponse;", "removeCredential"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface PasskeyEntityData {
    @Deprecated(message = "not used, we will use from alipayplus.mobilewallet.product.security.verify")
    Observable<AuthenticationFinishResponse> authenticationFinish(JSONObject credential, String userId);

    Observable<AuthenticationStartResponse> authenticationStart();

    Observable<QueryUserCredentialsResponse> queryUserCredentials(String credentialId);

    Observable<RegistrationFinishResponse> registrationFinish(JSONObject credential, String r2);

    Observable<RegistrationStartResponse> registrationStart(String r1, String r2);

    Observable<RemoveCredentialResponse> removeCredential(String r1);
}
