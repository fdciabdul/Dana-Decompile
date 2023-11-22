package androidx.credentials.playservices.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.ResultReceiver;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialInterruptedException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialInterruptedException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.exceptions.NoCredentialException;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\t\u0010\nJ#\u0010\f\u001a\u0004\u0018\u00010\u0002\"\n\b\u0000\u0010\u000b*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Landroidx/credentials/playservices/controllers/CredentialProviderBaseController;", "", "Landroid/os/ResultReceiver;", "resultReceiver", "Landroid/content/Intent;", "hiddenIntent", "", "typeTag", "", "generateHiddenActivityIntent", "(Landroid/os/ResultReceiver;Landroid/content/Intent;Ljava/lang/String;)V", "T", "toIpcFriendlyResultReceiver", "(Landroid/os/ResultReceiver;)Landroid/os/ResultReceiver;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class CredentialProviderBaseController {
    public static final String ACTIVITY_REQUEST_CODE_TAG = "ACTIVITY_REQUEST_CODE";
    public static final String BEGIN_SIGN_IN_TAG = "BEGIN_SIGN_IN";
    public static final String CREATE_CANCELED = "CREATE_CANCELED";
    public static final String CREATE_INTERRUPTED = "CREATE_INTERRUPTED";
    public static final String CREATE_PASSWORD_TAG = "CREATE_PASSWORD";
    public static final String CREATE_PUBLIC_KEY_CREDENTIAL_TAG = "CREATE_PUBLIC_KEY_CREDENTIAL";
    public static final String CREATE_UNKNOWN = "CREATE_UNKNOWN";
    public static final String EXCEPTION_MESSAGE_TAG = "EXCEPTION_MESSAGE";
    public static final String EXCEPTION_TYPE_TAG = "EXCEPTION_TYPE";
    public static final String FAILURE_RESPONSE_TAG = "FAILURE_RESPONSE";
    public static final String GET_CANCELED = "GET_CANCELED_TAG";
    public static final String GET_INTERRUPTED = "GET_INTERRUPTED";
    public static final String GET_NO_CREDENTIALS = "GET_NO_CREDENTIALS";
    public static final String GET_UNKNOWN = "GET_UNKNOWN";
    public static final String REQUEST_TAG = "REQUEST_TYPE";
    public static final String RESULT_DATA_TAG = "RESULT_DATA";
    public static final String RESULT_RECEIVER_TAG = "RESULT_RECEIVER";
    public static final String SIGN_IN_INTENT_TAG = "SIGN_IN_INTENT";
    public static final String TYPE_TAG = "TYPE";
    private final Context context;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<Integer> retryables = SetsKt.setOf((Object[]) new Integer[]{7, 20});
    private static final int CONTROLLER_REQUEST_CODE = 1;

    public static final int getCONTROLLER_REQUEST_CODE() {
        return INSTANCE.getCONTROLLER_REQUEST_CODE();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\"\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b+\u0010\u0014J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR \u0010\u000f\u001a\u00020\u000e8\u0005X\u0085D¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0019\u0010\fR\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u001b\u0010\fR\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u001c\u0010\fR\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u001d\u0010\fR\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u001e\u0010\fR\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u001f\u0010\fR\u0014\u0010 \u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b \u0010\fR\u0014\u0010!\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b!\u0010\fR\u0014\u0010\"\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\"\u0010\fR\u0014\u0010#\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b#\u0010\fR\u0014\u0010$\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b$\u0010\fR\u0014\u0010%\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b%\u0010\fR \u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0&8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*"}, d2 = {"Landroidx/credentials/playservices/controllers/CredentialProviderBaseController$Companion;", "", "", "typeName", "msg", "Landroidx/credentials/exceptions/CreateCredentialException;", "createCredentialExceptionTypeToException$credentials_play_services_auth_release", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/credentials/exceptions/CreateCredentialException;", "Landroidx/credentials/exceptions/GetCredentialException;", "getCredentialExceptionTypeToException$credentials_play_services_auth_release", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/credentials/exceptions/GetCredentialException;", "ACTIVITY_REQUEST_CODE_TAG", "Ljava/lang/String;", "BEGIN_SIGN_IN_TAG", "", "CONTROLLER_REQUEST_CODE", "I", "getCONTROLLER_REQUEST_CODE", "()I", "getCONTROLLER_REQUEST_CODE$annotations", "()V", CredentialProviderBaseController.CREATE_CANCELED, CredentialProviderBaseController.CREATE_INTERRUPTED, "CREATE_PASSWORD_TAG", "CREATE_PUBLIC_KEY_CREDENTIAL_TAG", CredentialProviderBaseController.CREATE_UNKNOWN, "EXCEPTION_MESSAGE_TAG", "EXCEPTION_TYPE_TAG", "FAILURE_RESPONSE_TAG", "GET_CANCELED", CredentialProviderBaseController.GET_INTERRUPTED, CredentialProviderBaseController.GET_NO_CREDENTIALS, CredentialProviderBaseController.GET_UNKNOWN, "REQUEST_TAG", "RESULT_DATA_TAG", "RESULT_RECEIVER_TAG", "SIGN_IN_INTENT_TAG", "TYPE_TAG", "", "retryables", "Ljava/util/Set;", "getRetryables", "()Ljava/util/Set;", "<init>"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        protected static /* synthetic */ void getCONTROLLER_REQUEST_CODE$annotations() {
        }

        private Companion() {
        }

        @JvmName(name = "getRetryables")
        public final Set<Integer> getRetryables() {
            return CredentialProviderBaseController.retryables;
        }

        @JvmName(name = "getCONTROLLER_REQUEST_CODE")
        protected final int getCONTROLLER_REQUEST_CODE() {
            return CredentialProviderBaseController.CONTROLLER_REQUEST_CODE;
        }

        public final GetCredentialException getCredentialExceptionTypeToException$credentials_play_services_auth_release(String typeName, String msg) {
            if (typeName != null) {
                int hashCode = typeName.hashCode();
                if (hashCode != -1567968963) {
                    if (hashCode != -154594663) {
                        if (hashCode == 1996705159 && typeName.equals(CredentialProviderBaseController.GET_NO_CREDENTIALS)) {
                            return new NoCredentialException(msg);
                        }
                    } else if (typeName.equals(CredentialProviderBaseController.GET_INTERRUPTED)) {
                        return new GetCredentialInterruptedException(msg);
                    }
                } else if (typeName.equals(CredentialProviderBaseController.GET_CANCELED)) {
                    return new GetCredentialCancellationException(msg);
                }
            }
            return new GetCredentialUnknownException(msg);
        }

        public final CreateCredentialException createCredentialExceptionTypeToException$credentials_play_services_auth_release(String typeName, String msg) {
            if (Intrinsics.areEqual(typeName, CredentialProviderBaseController.CREATE_CANCELED)) {
                return new CreateCredentialCancellationException(msg);
            }
            if (Intrinsics.areEqual(typeName, CredentialProviderBaseController.CREATE_INTERRUPTED)) {
                return new CreateCredentialInterruptedException(msg);
            }
            return new CreateCredentialUnknownException(msg);
        }
    }

    public CredentialProviderBaseController(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
    }

    public final <T extends ResultReceiver> ResultReceiver toIpcFriendlyResultReceiver(T resultReceiver) {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "");
        Intrinsics.checkNotNull(resultReceiver);
        resultReceiver.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return resultReceiver2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void generateHiddenActivityIntent(ResultReceiver resultReceiver, Intent hiddenIntent, String typeTag) {
        Intrinsics.checkNotNullParameter(resultReceiver, "");
        Intrinsics.checkNotNullParameter(hiddenIntent, "");
        Intrinsics.checkNotNullParameter(typeTag, "");
        hiddenIntent.putExtra("TYPE", typeTag);
        hiddenIntent.putExtra(ACTIVITY_REQUEST_CODE_TAG, CONTROLLER_REQUEST_CODE);
        hiddenIntent.putExtra(RESULT_RECEIVER_TAG, toIpcFriendlyResultReceiver(resultReceiver));
        hiddenIntent.setFlags(65536);
    }
}
