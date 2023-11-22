package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import android.util.Base64;
import androidx.credentials.CreatePublicKeyCredentialRequest;
import androidx.credentials.GetPublicKeyCredentialOption;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.exceptions.domerrors.AbortError;
import androidx.credentials.exceptions.domerrors.ConstraintError;
import androidx.credentials.exceptions.domerrors.DataError;
import androidx.credentials.exceptions.domerrors.DomError;
import androidx.credentials.exceptions.domerrors.EncodingError;
import androidx.credentials.exceptions.domerrors.InvalidStateError;
import androidx.credentials.exceptions.domerrors.NetworkError;
import androidx.credentials.exceptions.domerrors.NotAllowedError;
import androidx.credentials.exceptions.domerrors.NotReadableError;
import androidx.credentials.exceptions.domerrors.NotSupportedError;
import androidx.credentials.exceptions.domerrors.SecurityError;
import androidx.credentials.exceptions.domerrors.TimeoutError;
import androidx.credentials.exceptions.domerrors.UnknownError;
import androidx.credentials.exceptions.publickeycredential.CreatePublicKeyCredentialDomException;
import androidx.credentials.exceptions.publickeycredential.GetPublicKeyCredentialDomException;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.fido2.api.common.Attachment;
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;
import com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorSelectionCriteria;
import com.google.android.gms.fido.fido2.api.common.COSEAlgorithmIdentifier;
import com.google.android.gms.fido.fido2.api.common.ErrorCode;
import com.google.android.gms.fido.fido2.api.common.FidoAppIdExtension;
import com.google.android.gms.fido.fido2.api.common.GoogleThirdPartyPaymentExtension;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialDescriptor;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialParameters;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRpEntity;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialUserEntity;
import com.google.android.gms.fido.fido2.api.common.ResidentKeyRequirement;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethodExtension;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/credentials/playservices/controllers/CreatePublicKeyCredential/PublicKeyCredentialControllerUtility;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PublicKeyCredentialControllerUtility {
    private static final int FLAGS = 11;
    private static final String TAG = "PublicKeyUtility";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String JSON_KEY_CLIENT_DATA = "clientDataJSON";
    private static final String JSON_KEY_ATTESTATION_OBJ = "attestationObject";
    private static final String JSON_KEY_AUTH_DATA = "authenticatorData";
    private static final String JSON_KEY_SIGNATURE = BranchLinkConstant.OauthParams.SIGNATURE;
    private static final String JSON_KEY_USER_HANDLE = "userHandle";
    private static final String JSON_KEY_RESPONSE = "response";
    private static final String JSON_KEY_ID = "id";
    private static final String JSON_KEY_RAW_ID = "rawId";
    private static final String JSON_KEY_TYPE = "type";
    private static final String JSON_KEY_RPID = "rpId";
    private static final String JSON_KEY_CHALLENGE = ClientData.KEY_CHALLENGE;
    private static final String JSON_KEY_APPID = "appid";
    private static final String JSON_KEY_THIRD_PARTY_PAYMENT = "thirdPartyPayment";
    private static final String JSON_KEY_AUTH_SELECTION = "authenticatorSelection";
    private static final String JSON_KEY_REQUIRE_RES_KEY = "requireResidentKey";
    private static final String JSON_KEY_RES_KEY = "residentKey";
    private static final String JSON_KEY_AUTH_ATTACHMENT = "authenticatorAttachment";
    private static final String JSON_KEY_TIMEOUT = TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT;
    private static final String JSON_KEY_EXCLUDE_CREDENTIALS = "excludeCredentials";
    private static final String JSON_KEY_TRANSPORTS = "transports";
    private static final String JSON_KEY_RP = "rp";
    private static final String JSON_KEY_NAME = "name";
    private static final String JSON_KEY_ICON = "icon";
    private static final String JSON_KEY_ALG = "alg";
    private static final String JSON_KEY_USER = "user";
    private static final String JSON_KEY_DISPLAY_NAME = ExtendInfoUtilKt.DISPLAY_NAME_KEY;
    private static final String JSON_KEY_USER_VERIFICATION_METHOD = "userVerificationMethod";
    private static final String JSON_KEY_KEY_PROTECTION_TYPE = "keyProtectionType";
    private static final String JSON_KEY_MATCHER_PROTECTION_TYPE = "matcherProtectionType";
    private static final String JSON_KEY_EXTENSTIONS = "extensions";
    private static final String JSON_KEY_ATTESTATION = "attestation";
    private static final String JSON_KEY_PUB_KEY_CRED_PARAMS = "pubKeyCredParams";
    private static final String JSON_KEY_CLIENT_EXTENSION_RESULTS = "clientExtensionResults";
    private static final String JSON_KEY_RK = "rk";
    private static final String JSON_KEY_CRED_PROPS = "credProps";
    private static final LinkedHashMap<ErrorCode, DomError> orderedErrorCodeToExceptions = MapsKt.linkedMapOf(TuplesKt.to(ErrorCode.UNKNOWN_ERR, new UnknownError()), TuplesKt.to(ErrorCode.ABORT_ERR, new AbortError()), TuplesKt.to(ErrorCode.ATTESTATION_NOT_PRIVATE_ERR, new NotReadableError()), TuplesKt.to(ErrorCode.CONSTRAINT_ERR, new ConstraintError()), TuplesKt.to(ErrorCode.DATA_ERR, new DataError()), TuplesKt.to(ErrorCode.INVALID_STATE_ERR, new InvalidStateError()), TuplesKt.to(ErrorCode.ENCODING_ERR, new EncodingError()), TuplesKt.to(ErrorCode.NETWORK_ERR, new NetworkError()), TuplesKt.to(ErrorCode.NOT_ALLOWED_ERR, new NotAllowedError()), TuplesKt.to(ErrorCode.NOT_SUPPORTED_ERR, new NotSupportedError()), TuplesKt.to(ErrorCode.SECURITY_ERR, new SecurityError()), TuplesKt.to(ErrorCode.TIMEOUT_ERR, new TimeoutError()));

    @JvmStatic
    public static final PublicKeyCredentialCreationOptions convert(CreatePublicKeyCredentialRequest createPublicKeyCredentialRequest) {
        return INSTANCE.convert(createPublicKeyCredentialRequest);
    }

    @Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020 2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b#\u0010$J\u0015\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020*2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0004\b3\u00102J\u001f\u00104\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0004\b4\u00102J\u001f\u00105\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0004\b5\u00102J\u001f\u00106\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0004\b6\u00102J\u001f\u00107\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0004\b7\u00102J\u0017\u0010;\u001a\u0004\u0018\u00010:2\u0006\u00109\u001a\u000208¢\u0006\u0004\b;\u0010<J\u0015\u0010>\u001a\u00020\u00062\u0006\u00109\u001a\u00020=¢\u0006\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020\u00068\u0001X\u0080D¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bF\u0010C\u001a\u0004\bG\u0010ER\u001a\u0010H\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bH\u0010C\u001a\u0004\bI\u0010ER\u001a\u0010J\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bJ\u0010C\u001a\u0004\bK\u0010ER\u001a\u0010L\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bL\u0010C\u001a\u0004\bM\u0010ER\u001a\u0010N\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bN\u0010C\u001a\u0004\bO\u0010ER\u001a\u0010P\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bP\u0010C\u001a\u0004\bQ\u0010ER\u001a\u0010R\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bR\u0010C\u001a\u0004\bS\u0010ER\u001a\u0010T\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bT\u0010C\u001a\u0004\bU\u0010ER\u001a\u0010V\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bV\u0010C\u001a\u0004\bW\u0010ER\u001a\u0010X\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bX\u0010C\u001a\u0004\bY\u0010ER\u001a\u0010Z\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bZ\u0010C\u001a\u0004\b[\u0010ER\u001a\u0010\\\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\b\\\u0010C\u001a\u0004\b]\u0010ER\u001a\u0010^\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\b^\u0010C\u001a\u0004\b_\u0010ER\u001a\u0010`\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\b`\u0010C\u001a\u0004\ba\u0010ER\u001a\u0010b\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bb\u0010C\u001a\u0004\bc\u0010ER\u001a\u0010d\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bd\u0010C\u001a\u0004\be\u0010ER\u001a\u0010f\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bf\u0010C\u001a\u0004\bg\u0010ER\u001a\u0010h\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bh\u0010C\u001a\u0004\bi\u0010ER\u001a\u0010j\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bj\u0010C\u001a\u0004\bk\u0010ER\u001a\u0010l\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bl\u0010C\u001a\u0004\bm\u0010ER\u001a\u0010n\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bn\u0010C\u001a\u0004\bo\u0010ER\u001a\u0010p\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bp\u0010C\u001a\u0004\bq\u0010ER\u001a\u0010r\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\br\u0010C\u001a\u0004\bs\u0010ER\u001a\u0010t\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bt\u0010C\u001a\u0004\bu\u0010ER\u001a\u0010v\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bv\u0010C\u001a\u0004\bw\u0010ER\u001a\u0010x\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bx\u0010C\u001a\u0004\by\u0010ER\u001a\u0010z\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\bz\u0010C\u001a\u0004\b{\u0010ER\u001a\u0010|\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\b|\u0010C\u001a\u0004\b}\u0010ER\u001a\u0010~\u001a\u00020\u00068\u0001X\u0081D¢\u0006\f\n\u0004\b~\u0010C\u001a\u0004\b\u007f\u0010ER\u001d\u0010\u0080\u0001\u001a\u00020\u00068\u0001X\u0081D¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010C\u001a\u0005\b\u0081\u0001\u0010ER\u001d\u0010\u0082\u0001\u001a\u00020\u00068\u0001X\u0081D¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010C\u001a\u0005\b\u0083\u0001\u0010ER\u001d\u0010\u0084\u0001\u001a\u00020\u00068\u0001X\u0081D¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010C\u001a\u0005\b\u0085\u0001\u0010ER\u001d\u0010\u0086\u0001\u001a\u00020\u00068\u0001X\u0081D¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010C\u001a\u0005\b\u0087\u0001\u0010ER\u001d\u0010\u0088\u0001\u001a\u00020\u00068\u0001X\u0081D¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010C\u001a\u0005\b\u0089\u0001\u0010ER\u0016\u0010\u008a\u0001\u001a\u00020\u00068\u0002X\u0083T¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010CR?\u0010\u008e\u0001\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0005\u0012\u00030\u008c\u00010\u008b\u0001j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0005\u0012\u00030\u008c\u0001`\u008d\u00018\u0001X\u0081\u0004¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001"}, d2 = {"Landroidx/credentials/playservices/controllers/CreatePublicKeyCredential/PublicKeyCredentialControllerUtility$Companion;", "", "", "clientDataJSON", "attestationObject", "", "", "transportArray", "Lorg/json/JSONObject;", "json", "", "addAuthenticatorAttestationResponse$credentials_play_services_auth_release", "([B[B[Ljava/lang/String;Lorg/json/JSONObject;)V", "str", "b64Decode", "(Ljava/lang/String;)[B", "data", "b64Encode", "([B)Ljava/lang/String;", "Lcom/google/android/gms/fido/fido2/api/common/ErrorCode;", "code", "msg", "Landroidx/credentials/exceptions/GetCredentialException;", "beginSignInPublicKeyCredentialResponseContainsError$credentials_play_services_auth_release", "(Lcom/google/android/gms/fido/fido2/api/common/ErrorCode;Ljava/lang/String;)Landroidx/credentials/exceptions/GetCredentialException;", "", "alg", "", "checkAlgSupported", "(I)Z", "Landroidx/credentials/CreatePublicKeyCredentialRequest;", "request", "Lcom/google/android/gms/fido/fido2/api/common/PublicKeyCredentialCreationOptions;", "convert", "(Landroidx/credentials/CreatePublicKeyCredentialRequest;)Lcom/google/android/gms/fido/fido2/api/common/PublicKeyCredentialCreationOptions;", "convertJSON$credentials_play_services_auth_release", "(Lorg/json/JSONObject;)Lcom/google/android/gms/fido/fido2/api/common/PublicKeyCredentialCreationOptions;", "Landroidx/credentials/GetPublicKeyCredentialOption;", "option", "Lcom/google/android/gms/auth/api/identity/BeginSignInRequest$PasskeyJsonRequestOptions;", "convertToPlayAuthPasskeyJsonRequest", "(Landroidx/credentials/GetPublicKeyCredentialOption;)Lcom/google/android/gms/auth/api/identity/BeginSignInRequest$PasskeyJsonRequestOptions;", "Lcom/google/android/gms/auth/api/identity/BeginSignInRequest$PasskeysRequestOptions;", "convertToPlayAuthPasskeyRequest", "(Landroidx/credentials/GetPublicKeyCredentialOption;)Lcom/google/android/gms/auth/api/identity/BeginSignInRequest$PasskeysRequestOptions;", "getChallenge", "(Lorg/json/JSONObject;)[B", "Lcom/google/android/gms/fido/fido2/api/common/PublicKeyCredentialCreationOptions$Builder;", "builder", "parseOptionalAuthenticatorSelection$credentials_play_services_auth_release", "(Lorg/json/JSONObject;Lcom/google/android/gms/fido/fido2/api/common/PublicKeyCredentialCreationOptions$Builder;)V", "parseOptionalExtensions$credentials_play_services_auth_release", "parseOptionalTimeout$credentials_play_services_auth_release", "parseOptionalWithRequiredDefaultsAttestationAndExcludeCredentials$credentials_play_services_auth_release", "parseRequiredChallengeAndUser$credentials_play_services_auth_release", "parseRequiredRpAndParams$credentials_play_services_auth_release", "Lcom/google/android/gms/fido/fido2/api/common/PublicKeyCredential;", "cred", "Landroidx/credentials/exceptions/CreateCredentialException;", "publicKeyCredentialResponseContainsError", "(Lcom/google/android/gms/fido/fido2/api/common/PublicKeyCredential;)Landroidx/credentials/exceptions/CreateCredentialException;", "Lcom/google/android/gms/auth/api/identity/SignInCredential;", "toAssertPasskeyResponse", "(Lcom/google/android/gms/auth/api/identity/SignInCredential;)Ljava/lang/String;", "FLAGS", "I", "JSON_KEY_ALG", "Ljava/lang/String;", "getJSON_KEY_ALG$credentials_play_services_auth_release", "()Ljava/lang/String;", "JSON_KEY_APPID", "getJSON_KEY_APPID$credentials_play_services_auth_release", "JSON_KEY_ATTESTATION", "getJSON_KEY_ATTESTATION$credentials_play_services_auth_release", "JSON_KEY_ATTESTATION_OBJ", "getJSON_KEY_ATTESTATION_OBJ$credentials_play_services_auth_release", "JSON_KEY_AUTH_ATTACHMENT", "getJSON_KEY_AUTH_ATTACHMENT$credentials_play_services_auth_release", "JSON_KEY_AUTH_DATA", "getJSON_KEY_AUTH_DATA$credentials_play_services_auth_release", "JSON_KEY_AUTH_SELECTION", "getJSON_KEY_AUTH_SELECTION$credentials_play_services_auth_release", "JSON_KEY_CHALLENGE", "getJSON_KEY_CHALLENGE$credentials_play_services_auth_release", "JSON_KEY_CLIENT_DATA", "getJSON_KEY_CLIENT_DATA$credentials_play_services_auth_release", "JSON_KEY_CLIENT_EXTENSION_RESULTS", "getJSON_KEY_CLIENT_EXTENSION_RESULTS$credentials_play_services_auth_release", "JSON_KEY_CRED_PROPS", "getJSON_KEY_CRED_PROPS$credentials_play_services_auth_release", "JSON_KEY_DISPLAY_NAME", "getJSON_KEY_DISPLAY_NAME$credentials_play_services_auth_release", "JSON_KEY_EXCLUDE_CREDENTIALS", "getJSON_KEY_EXCLUDE_CREDENTIALS$credentials_play_services_auth_release", "JSON_KEY_EXTENSTIONS", "getJSON_KEY_EXTENSTIONS$credentials_play_services_auth_release", "JSON_KEY_ICON", "getJSON_KEY_ICON$credentials_play_services_auth_release", "JSON_KEY_ID", "getJSON_KEY_ID$credentials_play_services_auth_release", "JSON_KEY_KEY_PROTECTION_TYPE", "getJSON_KEY_KEY_PROTECTION_TYPE$credentials_play_services_auth_release", "JSON_KEY_MATCHER_PROTECTION_TYPE", "getJSON_KEY_MATCHER_PROTECTION_TYPE$credentials_play_services_auth_release", "JSON_KEY_NAME", "getJSON_KEY_NAME$credentials_play_services_auth_release", "JSON_KEY_PUB_KEY_CRED_PARAMS", "getJSON_KEY_PUB_KEY_CRED_PARAMS$credentials_play_services_auth_release", "JSON_KEY_RAW_ID", "getJSON_KEY_RAW_ID$credentials_play_services_auth_release", "JSON_KEY_REQUIRE_RES_KEY", "getJSON_KEY_REQUIRE_RES_KEY$credentials_play_services_auth_release", "JSON_KEY_RESPONSE", "getJSON_KEY_RESPONSE$credentials_play_services_auth_release", "JSON_KEY_RES_KEY", "getJSON_KEY_RES_KEY$credentials_play_services_auth_release", "JSON_KEY_RK", "getJSON_KEY_RK$credentials_play_services_auth_release", "JSON_KEY_RP", "getJSON_KEY_RP$credentials_play_services_auth_release", "JSON_KEY_RPID", "getJSON_KEY_RPID$credentials_play_services_auth_release", "JSON_KEY_SIGNATURE", "getJSON_KEY_SIGNATURE$credentials_play_services_auth_release", "JSON_KEY_THIRD_PARTY_PAYMENT", "getJSON_KEY_THIRD_PARTY_PAYMENT$credentials_play_services_auth_release", "JSON_KEY_TIMEOUT", "getJSON_KEY_TIMEOUT$credentials_play_services_auth_release", "JSON_KEY_TRANSPORTS", "getJSON_KEY_TRANSPORTS$credentials_play_services_auth_release", "JSON_KEY_TYPE", "getJSON_KEY_TYPE$credentials_play_services_auth_release", "JSON_KEY_USER", "getJSON_KEY_USER$credentials_play_services_auth_release", "JSON_KEY_USER_HANDLE", "getJSON_KEY_USER_HANDLE$credentials_play_services_auth_release", "JSON_KEY_USER_VERIFICATION_METHOD", "getJSON_KEY_USER_VERIFICATION_METHOD$credentials_play_services_auth_release", "TAG", "Ljava/util/LinkedHashMap;", "Landroidx/credentials/exceptions/domerrors/DomError;", "Lkotlin/collections/LinkedHashMap;", "orderedErrorCodeToExceptions", "Ljava/util/LinkedHashMap;", "getOrderedErrorCodeToExceptions$credentials_play_services_auth_release", "()Ljava/util/LinkedHashMap;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getJSON_KEY_CLIENT_DATA$credentials_play_services_auth_release")
        public final String getJSON_KEY_CLIENT_DATA$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_CLIENT_DATA;
        }

        @JvmName(name = "getJSON_KEY_ATTESTATION_OBJ$credentials_play_services_auth_release")
        public final String getJSON_KEY_ATTESTATION_OBJ$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_ATTESTATION_OBJ;
        }

        @JvmName(name = "getJSON_KEY_AUTH_DATA$credentials_play_services_auth_release")
        public final String getJSON_KEY_AUTH_DATA$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_AUTH_DATA;
        }

        @JvmName(name = "getJSON_KEY_SIGNATURE$credentials_play_services_auth_release")
        public final String getJSON_KEY_SIGNATURE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_SIGNATURE;
        }

        @JvmName(name = "getJSON_KEY_USER_HANDLE$credentials_play_services_auth_release")
        public final String getJSON_KEY_USER_HANDLE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_USER_HANDLE;
        }

        @JvmName(name = "getJSON_KEY_RESPONSE$credentials_play_services_auth_release")
        public final String getJSON_KEY_RESPONSE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_RESPONSE;
        }

        @JvmName(name = "getJSON_KEY_ID$credentials_play_services_auth_release")
        public final String getJSON_KEY_ID$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_ID;
        }

        @JvmName(name = "getJSON_KEY_RAW_ID$credentials_play_services_auth_release")
        public final String getJSON_KEY_RAW_ID$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_RAW_ID;
        }

        @JvmName(name = "getJSON_KEY_TYPE$credentials_play_services_auth_release")
        public final String getJSON_KEY_TYPE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_TYPE;
        }

        @JvmName(name = "getJSON_KEY_RPID$credentials_play_services_auth_release")
        public final String getJSON_KEY_RPID$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_RPID;
        }

        @JvmName(name = "getJSON_KEY_CHALLENGE$credentials_play_services_auth_release")
        public final String getJSON_KEY_CHALLENGE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_CHALLENGE;
        }

        @JvmName(name = "getJSON_KEY_APPID$credentials_play_services_auth_release")
        public final String getJSON_KEY_APPID$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_APPID;
        }

        @JvmName(name = "getJSON_KEY_THIRD_PARTY_PAYMENT$credentials_play_services_auth_release")
        public final String getJSON_KEY_THIRD_PARTY_PAYMENT$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_THIRD_PARTY_PAYMENT;
        }

        @JvmName(name = "getJSON_KEY_AUTH_SELECTION$credentials_play_services_auth_release")
        public final String getJSON_KEY_AUTH_SELECTION$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_AUTH_SELECTION;
        }

        @JvmName(name = "getJSON_KEY_REQUIRE_RES_KEY$credentials_play_services_auth_release")
        public final String getJSON_KEY_REQUIRE_RES_KEY$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_REQUIRE_RES_KEY;
        }

        @JvmName(name = "getJSON_KEY_RES_KEY$credentials_play_services_auth_release")
        public final String getJSON_KEY_RES_KEY$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_RES_KEY;
        }

        @JvmName(name = "getJSON_KEY_AUTH_ATTACHMENT$credentials_play_services_auth_release")
        public final String getJSON_KEY_AUTH_ATTACHMENT$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_AUTH_ATTACHMENT;
        }

        @JvmName(name = "getJSON_KEY_TIMEOUT$credentials_play_services_auth_release")
        public final String getJSON_KEY_TIMEOUT$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_TIMEOUT;
        }

        @JvmName(name = "getJSON_KEY_EXCLUDE_CREDENTIALS$credentials_play_services_auth_release")
        public final String getJSON_KEY_EXCLUDE_CREDENTIALS$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_EXCLUDE_CREDENTIALS;
        }

        @JvmName(name = "getJSON_KEY_TRANSPORTS$credentials_play_services_auth_release")
        public final String getJSON_KEY_TRANSPORTS$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_TRANSPORTS;
        }

        @JvmName(name = "getJSON_KEY_RP$credentials_play_services_auth_release")
        public final String getJSON_KEY_RP$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_RP;
        }

        @JvmName(name = "getJSON_KEY_NAME$credentials_play_services_auth_release")
        public final String getJSON_KEY_NAME$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_NAME;
        }

        @JvmName(name = "getJSON_KEY_ICON$credentials_play_services_auth_release")
        public final String getJSON_KEY_ICON$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_ICON;
        }

        @JvmName(name = "getJSON_KEY_ALG$credentials_play_services_auth_release")
        public final String getJSON_KEY_ALG$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_ALG;
        }

        @JvmName(name = "getJSON_KEY_USER$credentials_play_services_auth_release")
        public final String getJSON_KEY_USER$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_USER;
        }

        @JvmName(name = "getJSON_KEY_DISPLAY_NAME$credentials_play_services_auth_release")
        public final String getJSON_KEY_DISPLAY_NAME$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_DISPLAY_NAME;
        }

        @JvmName(name = "getJSON_KEY_USER_VERIFICATION_METHOD$credentials_play_services_auth_release")
        public final String getJSON_KEY_USER_VERIFICATION_METHOD$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_USER_VERIFICATION_METHOD;
        }

        @JvmName(name = "getJSON_KEY_KEY_PROTECTION_TYPE$credentials_play_services_auth_release")
        public final String getJSON_KEY_KEY_PROTECTION_TYPE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_KEY_PROTECTION_TYPE;
        }

        @JvmName(name = "getJSON_KEY_MATCHER_PROTECTION_TYPE$credentials_play_services_auth_release")
        public final String getJSON_KEY_MATCHER_PROTECTION_TYPE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_MATCHER_PROTECTION_TYPE;
        }

        @JvmName(name = "getJSON_KEY_EXTENSTIONS$credentials_play_services_auth_release")
        public final String getJSON_KEY_EXTENSTIONS$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_EXTENSTIONS;
        }

        @JvmName(name = "getJSON_KEY_ATTESTATION$credentials_play_services_auth_release")
        public final String getJSON_KEY_ATTESTATION$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_ATTESTATION;
        }

        @JvmName(name = "getJSON_KEY_PUB_KEY_CRED_PARAMS$credentials_play_services_auth_release")
        public final String getJSON_KEY_PUB_KEY_CRED_PARAMS$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_PUB_KEY_CRED_PARAMS;
        }

        @JvmName(name = "getJSON_KEY_CLIENT_EXTENSION_RESULTS$credentials_play_services_auth_release")
        public final String getJSON_KEY_CLIENT_EXTENSION_RESULTS$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_CLIENT_EXTENSION_RESULTS;
        }

        @JvmName(name = "getJSON_KEY_RK$credentials_play_services_auth_release")
        public final String getJSON_KEY_RK$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_RK;
        }

        @JvmName(name = "getJSON_KEY_CRED_PROPS$credentials_play_services_auth_release")
        public final String getJSON_KEY_CRED_PROPS$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_CRED_PROPS;
        }

        @JvmStatic
        public final PublicKeyCredentialCreationOptions convert(CreatePublicKeyCredentialRequest request) {
            Intrinsics.checkNotNullParameter(request, "");
            return convertJSON$credentials_play_services_auth_release(new JSONObject(request.getRequestJson()));
        }

        public final PublicKeyCredentialCreationOptions convertJSON$credentials_play_services_auth_release(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "");
            PublicKeyCredentialCreationOptions.Builder builder = new PublicKeyCredentialCreationOptions.Builder();
            parseRequiredChallengeAndUser$credentials_play_services_auth_release(json, builder);
            parseRequiredRpAndParams$credentials_play_services_auth_release(json, builder);
            parseOptionalWithRequiredDefaultsAttestationAndExcludeCredentials$credentials_play_services_auth_release(json, builder);
            parseOptionalTimeout$credentials_play_services_auth_release(json, builder);
            parseOptionalAuthenticatorSelection$credentials_play_services_auth_release(json, builder);
            parseOptionalExtensions$credentials_play_services_auth_release(json, builder);
            PublicKeyCredentialCreationOptions build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "");
            return build;
        }

        public final void addAuthenticatorAttestationResponse$credentials_play_services_auth_release(byte[] clientDataJSON, byte[] attestationObject, String[] transportArray, JSONObject json) {
            Intrinsics.checkNotNullParameter(clientDataJSON, "");
            Intrinsics.checkNotNullParameter(attestationObject, "");
            Intrinsics.checkNotNullParameter(transportArray, "");
            Intrinsics.checkNotNullParameter(json, "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(getJSON_KEY_CLIENT_DATA$credentials_play_services_auth_release(), b64Encode(clientDataJSON));
            jSONObject.put(getJSON_KEY_ATTESTATION_OBJ$credentials_play_services_auth_release(), b64Encode(attestationObject));
            jSONObject.put(getJSON_KEY_TRANSPORTS$credentials_play_services_auth_release(), new JSONArray(transportArray));
            json.put(getJSON_KEY_RESPONSE$credentials_play_services_auth_release(), jSONObject);
        }

        public final String toAssertPasskeyResponse(SignInCredential cred) {
            Intrinsics.checkNotNullParameter(cred, "");
            JSONObject jSONObject = new JSONObject();
            PublicKeyCredential publicKeyCredential = cred.getPublicKeyCredential();
            AuthenticatorResponse response = publicKeyCredential != null ? publicKeyCredential.getResponse() : null;
            Intrinsics.checkNotNull(response);
            if (response instanceof AuthenticatorErrorResponse) {
                AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) response;
                ErrorCode errorCode = authenticatorErrorResponse.getErrorCode();
                Intrinsics.checkNotNullExpressionValue(errorCode, "");
                throw beginSignInPublicKeyCredentialResponseContainsError$credentials_play_services_auth_release(errorCode, authenticatorErrorResponse.getErrorMessage());
            } else if (response instanceof AuthenticatorAssertionResponse) {
                try {
                    String json = publicKeyCredential.toJson();
                    Intrinsics.checkNotNullExpressionValue(json, "");
                    return json;
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("The PublicKeyCredential response json had an unexpected exception when parsing: ");
                    sb.append(th.getMessage());
                    throw new GetCredentialUnknownException(sb.toString());
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("AuthenticatorResponse expected assertion response but got: ");
                sb2.append(response.getClass().getName());
                InstrumentInjector.log_e(PublicKeyCredentialControllerUtility.TAG, sb2.toString());
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "");
                return jSONObject2;
            }
        }

        public final BeginSignInRequest.PasskeyJsonRequestOptions convertToPlayAuthPasskeyJsonRequest(GetPublicKeyCredentialOption option) {
            Intrinsics.checkNotNullParameter(option, "");
            BeginSignInRequest.PasskeyJsonRequestOptions build = new BeginSignInRequest.PasskeyJsonRequestOptions.Builder().setSupported(true).setRequestJson(option.getRequestJson()).build();
            Intrinsics.checkNotNullExpressionValue(build, "");
            return build;
        }

        @Deprecated(message = "Upgrade GMS version so 'convertToPlayAuthPasskeyJsonRequest' is used")
        public final BeginSignInRequest.PasskeysRequestOptions convertToPlayAuthPasskeyRequest(GetPublicKeyCredentialOption option) {
            Intrinsics.checkNotNullParameter(option, "");
            JSONObject jSONObject = new JSONObject(option.getRequestJson());
            String optString = jSONObject.optString(getJSON_KEY_RPID$credentials_play_services_auth_release(), "");
            Intrinsics.checkNotNullExpressionValue(optString, "");
            if (optString.length() == 0) {
                throw new JSONException("GetPublicKeyCredentialOption - rpId not specified in the request or is unexpectedly empty");
            }
            BeginSignInRequest.PasskeysRequestOptions build = new BeginSignInRequest.PasskeysRequestOptions.Builder().setSupported(true).setRpId(optString).setChallenge(getChallenge(jSONObject)).build();
            Intrinsics.checkNotNullExpressionValue(build, "");
            return build;
        }

        private final byte[] getChallenge(JSONObject json) {
            String optString = json.optString(getJSON_KEY_CHALLENGE$credentials_play_services_auth_release(), "");
            Intrinsics.checkNotNullExpressionValue(optString, "");
            if (optString.length() == 0) {
                throw new JSONException("Challenge not found in request or is unexpectedly empty");
            }
            return b64Decode(optString);
        }

        public final CreateCredentialException publicKeyCredentialResponseContainsError(PublicKeyCredential cred) {
            Intrinsics.checkNotNullParameter(cred, "");
            AuthenticatorResponse response = cred.getResponse();
            Intrinsics.checkNotNullExpressionValue(response, "");
            if (response instanceof AuthenticatorErrorResponse) {
                AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) response;
                ErrorCode errorCode = authenticatorErrorResponse.getErrorCode();
                Intrinsics.checkNotNullExpressionValue(errorCode, "");
                DomError domError = getOrderedErrorCodeToExceptions$credentials_play_services_auth_release().get(errorCode);
                String errorMessage = authenticatorErrorResponse.getErrorMessage();
                if (domError == null) {
                    UnknownError unknownError = new UnknownError();
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown fido gms exception - ");
                    sb.append(errorMessage);
                    return new CreatePublicKeyCredentialDomException(unknownError, sb.toString());
                }
                if (errorCode == ErrorCode.CONSTRAINT_ERR) {
                    boolean z = false;
                    if (errorMessage != null && StringsKt.contains$default((CharSequence) errorMessage, (CharSequence) "Unable to get sync account", false, 2, (Object) null)) {
                        z = true;
                    }
                    if (z) {
                        return new CreateCredentialCancellationException("Passkey registration was cancelled by the user.");
                    }
                }
                return new CreatePublicKeyCredentialDomException(domError, errorMessage);
            }
            return null;
        }

        public final GetCredentialException beginSignInPublicKeyCredentialResponseContainsError$credentials_play_services_auth_release(ErrorCode code, String msg) {
            Intrinsics.checkNotNullParameter(code, "");
            DomError domError = getOrderedErrorCodeToExceptions$credentials_play_services_auth_release().get(code);
            if (domError == null) {
                UnknownError unknownError = new UnknownError();
                StringBuilder sb = new StringBuilder();
                sb.append("unknown fido gms exception - ");
                sb.append(msg);
                return new GetPublicKeyCredentialDomException(unknownError, sb.toString());
            }
            if (code == ErrorCode.CONSTRAINT_ERR) {
                boolean z = false;
                if (msg != null && StringsKt.contains$default((CharSequence) msg, (CharSequence) "Unable to get sync account", false, 2, (Object) null)) {
                    z = true;
                }
                if (z) {
                    return new GetCredentialCancellationException("Passkey retrieval was cancelled by the user.");
                }
            }
            return new GetPublicKeyCredentialDomException(domError, msg);
        }

        public final void parseOptionalExtensions$credentials_play_services_auth_release(JSONObject json, PublicKeyCredentialCreationOptions.Builder builder) {
            Intrinsics.checkNotNullParameter(json, "");
            Intrinsics.checkNotNullParameter(builder, "");
            if (json.has(getJSON_KEY_EXTENSTIONS$credentials_play_services_auth_release())) {
                JSONObject jSONObject = json.getJSONObject(getJSON_KEY_EXTENSTIONS$credentials_play_services_auth_release());
                AuthenticationExtensions.Builder builder2 = new AuthenticationExtensions.Builder();
                String optString = jSONObject.optString(getJSON_KEY_APPID$credentials_play_services_auth_release(), "");
                Intrinsics.checkNotNullExpressionValue(optString, "");
                if (optString.length() > 0) {
                    builder2.setFido2Extension(new FidoAppIdExtension(optString));
                }
                if (jSONObject.optBoolean(getJSON_KEY_THIRD_PARTY_PAYMENT$credentials_play_services_auth_release(), false)) {
                    builder2.setGoogleThirdPartyPaymentExtension(new GoogleThirdPartyPaymentExtension(true));
                }
                if (jSONObject.optBoolean("uvm", false)) {
                    builder2.setUserVerificationMethodExtension(new UserVerificationMethodExtension(true));
                }
                builder.setAuthenticationExtensions(builder2.build());
            }
        }

        public final void parseOptionalAuthenticatorSelection$credentials_play_services_auth_release(JSONObject json, PublicKeyCredentialCreationOptions.Builder builder) {
            Intrinsics.checkNotNullParameter(json, "");
            Intrinsics.checkNotNullParameter(builder, "");
            if (json.has(getJSON_KEY_AUTH_SELECTION$credentials_play_services_auth_release())) {
                JSONObject jSONObject = json.getJSONObject(getJSON_KEY_AUTH_SELECTION$credentials_play_services_auth_release());
                AuthenticatorSelectionCriteria.Builder builder2 = new AuthenticatorSelectionCriteria.Builder();
                boolean optBoolean = jSONObject.optBoolean(getJSON_KEY_REQUIRE_RES_KEY$credentials_play_services_auth_release(), false);
                String optString = jSONObject.optString(getJSON_KEY_RES_KEY$credentials_play_services_auth_release(), "");
                Intrinsics.checkNotNullExpressionValue(optString, "");
                builder2.setRequireResidentKey(Boolean.valueOf(optBoolean)).setResidentKeyRequirement(optString.length() > 0 ? ResidentKeyRequirement.fromString(optString) : null);
                String optString2 = jSONObject.optString(getJSON_KEY_AUTH_ATTACHMENT$credentials_play_services_auth_release(), "");
                Intrinsics.checkNotNullExpressionValue(optString2, "");
                if (optString2.length() > 0) {
                    builder2.setAttachment(Attachment.fromString(optString2));
                }
                builder.setAuthenticatorSelection(builder2.build());
            }
        }

        public final void parseOptionalTimeout$credentials_play_services_auth_release(JSONObject json, PublicKeyCredentialCreationOptions.Builder builder) {
            Intrinsics.checkNotNullParameter(json, "");
            Intrinsics.checkNotNullParameter(builder, "");
            if (json.has(getJSON_KEY_TIMEOUT$credentials_play_services_auth_release())) {
                double d = json.getLong(getJSON_KEY_TIMEOUT$credentials_play_services_auth_release());
                Double.isNaN(d);
                builder.setTimeoutSeconds(Double.valueOf(d / 1000.0d));
            }
        }

        public final void parseOptionalWithRequiredDefaultsAttestationAndExcludeCredentials$credentials_play_services_auth_release(JSONObject json, PublicKeyCredentialCreationOptions.Builder builder) {
            Intrinsics.checkNotNullParameter(json, "");
            Intrinsics.checkNotNullParameter(builder, "");
            ArrayList arrayList = new ArrayList();
            if (json.has(getJSON_KEY_EXCLUDE_CREDENTIALS$credentials_play_services_auth_release())) {
                JSONArray jSONArray = json.getJSONArray(getJSON_KEY_EXCLUDE_CREDENTIALS$credentials_play_services_auth_release());
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString(getJSON_KEY_ID$credentials_play_services_auth_release());
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    byte[] b64Decode = b64Decode(string);
                    String string2 = jSONObject.getString(getJSON_KEY_TYPE$credentials_play_services_auth_release());
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    if (string2.length() == 0) {
                        throw new JSONException("PublicKeyCredentialDescriptor type value is not found or unexpectedly empty");
                    }
                    if (b64Decode.length == 0) {
                        throw new JSONException("PublicKeyCredentialDescriptor id value is not found or unexpectedly empty");
                    }
                    ArrayList arrayList2 = null;
                    if (jSONObject.has(getJSON_KEY_TRANSPORTS$credentials_play_services_auth_release())) {
                        arrayList2 = new ArrayList();
                        JSONArray jSONArray2 = jSONObject.getJSONArray(getJSON_KEY_TRANSPORTS$credentials_play_services_auth_release());
                        int length2 = jSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            try {
                                Transport fromString = Transport.fromString(jSONArray2.getString(i2));
                                Intrinsics.checkNotNullExpressionValue(fromString, "");
                                arrayList2.add(fromString);
                            } catch (Transport.UnsupportedTransportException e) {
                                throw new CreatePublicKeyCredentialDomException(new EncodingError(), e.getMessage());
                            }
                        }
                    }
                    arrayList.add(new PublicKeyCredentialDescriptor(string2, b64Decode, arrayList2));
                }
            }
            builder.setExcludeList(arrayList);
            String optString = json.optString(getJSON_KEY_ATTESTATION$credentials_play_services_auth_release(), "none");
            Intrinsics.checkNotNullExpressionValue(optString, "");
            builder.setAttestationConveyancePreference(AttestationConveyancePreference.fromString(optString.length() == 0 ? "none" : optString));
        }

        public final void parseRequiredRpAndParams$credentials_play_services_auth_release(JSONObject json, PublicKeyCredentialCreationOptions.Builder builder) {
            Intrinsics.checkNotNullParameter(json, "");
            Intrinsics.checkNotNullParameter(builder, "");
            JSONObject jSONObject = json.getJSONObject(getJSON_KEY_RP$credentials_play_services_auth_release());
            String string = jSONObject.getString(getJSON_KEY_ID$credentials_play_services_auth_release());
            String optString = jSONObject.optString(getJSON_KEY_NAME$credentials_play_services_auth_release(), "");
            String optString2 = jSONObject.optString(getJSON_KEY_ICON$credentials_play_services_auth_release(), "");
            Intrinsics.checkNotNull(optString2);
            if (optString2.length() == 0) {
                optString2 = null;
            }
            Intrinsics.checkNotNullExpressionValue(optString, "");
            if (optString.length() == 0) {
                throw new JSONException("PublicKeyCredentialCreationOptions rp name is missing or unexpectedly empty");
            }
            Intrinsics.checkNotNullExpressionValue(string, "");
            if (string.length() == 0) {
                throw new JSONException("PublicKeyCredentialCreationOptions rp ID is missing or unexpectedly empty");
            }
            builder.setRp(new PublicKeyCredentialRpEntity(string, optString, optString2));
            JSONArray jSONArray = json.getJSONArray(getJSON_KEY_PUB_KEY_CRED_PARAMS$credentials_play_services_auth_release());
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                int i2 = (int) jSONObject2.getLong(getJSON_KEY_ALG$credentials_play_services_auth_release());
                String optString3 = jSONObject2.optString(getJSON_KEY_TYPE$credentials_play_services_auth_release(), "");
                Intrinsics.checkNotNullExpressionValue(optString3, "");
                if (optString3.length() == 0) {
                    throw new JSONException("PublicKeyCredentialCreationOptions PublicKeyCredentialParameter type missing or unexpectedly empty");
                }
                if (checkAlgSupported(i2)) {
                    arrayList.add(new PublicKeyCredentialParameters(optString3, i2));
                }
            }
            builder.setParameters(arrayList);
        }

        public final void parseRequiredChallengeAndUser$credentials_play_services_auth_release(JSONObject json, PublicKeyCredentialCreationOptions.Builder builder) {
            Intrinsics.checkNotNullParameter(json, "");
            Intrinsics.checkNotNullParameter(builder, "");
            builder.setChallenge(getChallenge(json));
            JSONObject jSONObject = json.getJSONObject(getJSON_KEY_USER$credentials_play_services_auth_release());
            String string = jSONObject.getString(getJSON_KEY_ID$credentials_play_services_auth_release());
            Intrinsics.checkNotNullExpressionValue(string, "");
            byte[] b64Decode = b64Decode(string);
            String string2 = jSONObject.getString(getJSON_KEY_NAME$credentials_play_services_auth_release());
            String string3 = jSONObject.getString(getJSON_KEY_DISPLAY_NAME$credentials_play_services_auth_release());
            String optString = jSONObject.optString(getJSON_KEY_ICON$credentials_play_services_auth_release(), "");
            Intrinsics.checkNotNullExpressionValue(string3, "");
            if (string3.length() == 0) {
                throw new JSONException("PublicKeyCredentialCreationOptions UserEntity missing displayName or they are unexpectedly empty");
            }
            if (b64Decode.length == 0) {
                throw new JSONException("PublicKeyCredentialCreationOptions UserEntity missing user id or they are unexpectedly empty");
            }
            Intrinsics.checkNotNullExpressionValue(string2, "");
            if (string2.length() == 0) {
                throw new JSONException("PublicKeyCredentialCreationOptions UserEntity missing user name or they are unexpectedly empty");
            }
            builder.setUser(new PublicKeyCredentialUserEntity(b64Decode, string2, optString, string3));
        }

        public final byte[] b64Decode(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            byte[] decode = Base64.decode(str, 11);
            Intrinsics.checkNotNullExpressionValue(decode, "");
            return decode;
        }

        public final String b64Encode(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "");
            String encodeToString = Base64.encodeToString(data, 11);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "");
            return encodeToString;
        }

        public final boolean checkAlgSupported(int alg) {
            try {
                COSEAlgorithmIdentifier.fromCoseValue(alg);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }

        @JvmName(name = "getOrderedErrorCodeToExceptions$credentials_play_services_auth_release")
        public final LinkedHashMap<ErrorCode, DomError> getOrderedErrorCodeToExceptions$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.orderedErrorCodeToExceptions;
        }
    }
}
