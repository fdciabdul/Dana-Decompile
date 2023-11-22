package id.dana.riskChallenges.data.passkey.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/network/PasskeyFacade;", "", "Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationFinishRequest;", "request", "Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationFinishResponse;", "authenticationFinish", "(Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationFinishRequest;)Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationFinishResponse;", "Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationStartRequest;", "Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationStartResponse;", "authenticationStart", "(Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationStartRequest;)Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationStartResponse;", "Lid/dana/riskChallenges/data/passkey/source/network/QueryUserCredentialsRequest;", "Lid/dana/riskChallenges/data/passkey/source/network/QueryUserCredentialsResponse;", "queryUserCredentials", "(Lid/dana/riskChallenges/data/passkey/source/network/QueryUserCredentialsRequest;)Lid/dana/riskChallenges/data/passkey/source/network/QueryUserCredentialsResponse;", "Lid/dana/riskChallenges/data/passkey/source/network/RegistrationFinishRequest;", "Lid/dana/riskChallenges/data/passkey/source/network/RegistrationFinishResponse;", "registrationFinish", "(Lid/dana/riskChallenges/data/passkey/source/network/RegistrationFinishRequest;)Lid/dana/riskChallenges/data/passkey/source/network/RegistrationFinishResponse;", "Lid/dana/riskChallenges/data/passkey/source/network/RegistrationStartRequest;", "Lid/dana/riskChallenges/data/passkey/source/network/RegistrationStartResponse;", "registrationStart", "(Lid/dana/riskChallenges/data/passkey/source/network/RegistrationStartRequest;)Lid/dana/riskChallenges/data/passkey/source/network/RegistrationStartResponse;", "Lid/dana/riskChallenges/data/passkey/source/network/RemoveCredentialRequest;", "Lid/dana/riskChallenges/data/passkey/source/network/RemoveCredentialResponse;", "removeCredential", "(Lid/dana/riskChallenges/data/passkey/source/network/RemoveCredentialRequest;)Lid/dana/riskChallenges/data/passkey/source/network/RemoveCredentialResponse;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface PasskeyFacade {
    public static final String AUTHENTICATION_FINISH = "id.dana.userprod.user.passKey.finishAuthentication";
    public static final String AUTHENTICATION_START = "id.dana.userprod.user.passKey.startAuthentication";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String QUERY_USER_CREDENTIALS = "id.dana.userprod.user.passKey.queryUserCredentials";
    public static final String REGISTRATION_FINISH = "id.dana.userprod.user.passKey.finishRegistration";
    public static final String REGISTRATION_START = "id.dana.userprod.user.passKey.startRegistration";
    public static final String REMOVE_CREDENTIAL = "id.dana.userprod.user.passKey.removeUserCredential";

    @OperationType("id.dana.userprod.user.passKey.finishAuthentication")
    @SignCheck
    AuthenticationFinishResponse authenticationFinish(AuthenticationFinishRequest request);

    @OperationType("id.dana.userprod.user.passKey.startAuthentication")
    @SignCheck
    AuthenticationStartResponse authenticationStart(AuthenticationStartRequest request);

    @OperationType("id.dana.userprod.user.passKey.queryUserCredentials")
    @SignCheck
    QueryUserCredentialsResponse queryUserCredentials(QueryUserCredentialsRequest request);

    @OperationType("id.dana.userprod.user.passKey.finishRegistration")
    @SignCheck
    RegistrationFinishResponse registrationFinish(RegistrationFinishRequest request);

    @OperationType("id.dana.userprod.user.passKey.startRegistration")
    @SignCheck
    RegistrationStartResponse registrationStart(RegistrationStartRequest request);

    @OperationType("id.dana.userprod.user.passKey.removeUserCredential")
    @SignCheck
    RemoveCredentialResponse removeCredential(RemoveCredentialRequest request);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/network/PasskeyFacade$Companion;", "", "", "AUTHENTICATION_FINISH", "Ljava/lang/String;", "AUTHENTICATION_START", "OPERATION_TYPE_PREFIX", "QUERY_USER_CREDENTIALS", "REGISTRATION_FINISH", "REGISTRATION_START", "REMOVE_CREDENTIAL", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String AUTHENTICATION_FINISH = "id.dana.userprod.user.passKey.finishAuthentication";
        public static final String AUTHENTICATION_START = "id.dana.userprod.user.passKey.startAuthentication";
        private static final String OPERATION_TYPE_PREFIX = "id.dana.userprod.user.passKey";
        public static final String QUERY_USER_CREDENTIALS = "id.dana.userprod.user.passKey.queryUserCredentials";
        public static final String REGISTRATION_FINISH = "id.dana.userprod.user.passKey.finishRegistration";
        public static final String REGISTRATION_START = "id.dana.userprod.user.passKey.startRegistration";
        public static final String REMOVE_CREDENTIAL = "id.dana.userprod.user.passKey.removeUserCredential";

        private Companion() {
        }
    }
}
