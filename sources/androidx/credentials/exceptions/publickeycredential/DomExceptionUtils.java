package androidx.credentials.exceptions.publickeycredential;

import androidx.credentials.exceptions.domerrors.AbortError;
import androidx.credentials.exceptions.domerrors.ConstraintError;
import androidx.credentials.exceptions.domerrors.DataCloneError;
import androidx.credentials.exceptions.domerrors.DataError;
import androidx.credentials.exceptions.domerrors.DomError;
import androidx.credentials.exceptions.domerrors.EncodingError;
import androidx.credentials.exceptions.domerrors.HierarchyRequestError;
import androidx.credentials.exceptions.domerrors.InUseAttributeError;
import androidx.credentials.exceptions.domerrors.InvalidCharacterError;
import androidx.credentials.exceptions.domerrors.InvalidModificationError;
import androidx.credentials.exceptions.domerrors.InvalidNodeTypeError;
import androidx.credentials.exceptions.domerrors.InvalidStateError;
import androidx.credentials.exceptions.domerrors.NamespaceError;
import androidx.credentials.exceptions.domerrors.NetworkError;
import androidx.credentials.exceptions.domerrors.NoModificationAllowedError;
import androidx.credentials.exceptions.domerrors.NotAllowedError;
import androidx.credentials.exceptions.domerrors.NotFoundError;
import androidx.credentials.exceptions.domerrors.NotReadableError;
import androidx.credentials.exceptions.domerrors.NotSupportedError;
import androidx.credentials.exceptions.domerrors.OperationError;
import androidx.credentials.exceptions.domerrors.OptOutError;
import androidx.credentials.exceptions.domerrors.QuotaExceededError;
import androidx.credentials.exceptions.domerrors.ReadOnlyError;
import androidx.credentials.exceptions.domerrors.SecurityError;
import androidx.credentials.exceptions.domerrors.SyntaxError;
import androidx.credentials.exceptions.domerrors.TimeoutError;
import androidx.credentials.exceptions.domerrors.TransactionInactiveError;
import androidx.credentials.exceptions.domerrors.UnknownError;
import androidx.credentials.exceptions.domerrors.VersionError;
import androidx.credentials.exceptions.domerrors.WrongDocumentError;
import androidx.credentials.internal.FrameworkClassParsingException;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/credentials/exceptions/publickeycredential/DomExceptionUtils;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomExceptionUtils {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String SEPARATOR = "/";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J:\u0010\b\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/credentials/exceptions/publickeycredential/DomExceptionUtils$Companion;", "", "T", "", "type", "prefix", "msg", SecurityConstants.KEY_TEXT, "generateDomException$credentials_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "Landroidx/credentials/exceptions/domerrors/DomError;", "domError", "generateException", "(Landroidx/credentials/exceptions/domerrors/DomError;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "SEPARATOR", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ <T> T generateDomException$credentials_release(String type, String prefix, String msg, T r6) {
            Intrinsics.checkNotNullParameter(type, "");
            Intrinsics.checkNotNullParameter(prefix, "");
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            sb.append(AbortError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_ABORT_ERROR);
            if (Intrinsics.areEqual(type, sb.toString())) {
                return (T) generateException(new AbortError(), msg, r6);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(prefix);
            sb2.append(ConstraintError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_CONSTRAINT_ERROR);
            if (Intrinsics.areEqual(type, sb2.toString())) {
                return (T) generateException(new ConstraintError(), msg, r6);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(prefix);
            sb3.append(DataCloneError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DATA_CLONE_ERROR);
            if (Intrinsics.areEqual(type, sb3.toString())) {
                return (T) generateException(new DataCloneError(), msg, r6);
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(prefix);
            sb4.append(DataError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DATA_ERROR);
            if (Intrinsics.areEqual(type, sb4.toString())) {
                return (T) generateException(new DataError(), msg, r6);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(prefix);
            sb5.append(EncodingError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_ENCODING_ERROR);
            if (Intrinsics.areEqual(type, sb5.toString())) {
                return (T) generateException(new EncodingError(), msg, r6);
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append(prefix);
            sb6.append(HierarchyRequestError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_HIERARCHY_REQUEST_ERROR);
            if (Intrinsics.areEqual(type, sb6.toString())) {
                return (T) generateException(new HierarchyRequestError(), msg, r6);
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append(prefix);
            sb7.append(InUseAttributeError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_IN_USE_ATTRIBUTE_ERROR);
            if (Intrinsics.areEqual(type, sb7.toString())) {
                return (T) generateException(new InUseAttributeError(), msg, r6);
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append(prefix);
            sb8.append(InvalidCharacterError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_CHARACTER_ERROR);
            if (Intrinsics.areEqual(type, sb8.toString())) {
                return (T) generateException(new InvalidCharacterError(), msg, r6);
            }
            StringBuilder sb9 = new StringBuilder();
            sb9.append(prefix);
            sb9.append(InvalidModificationError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_MODIFICATION_ERROR);
            if (Intrinsics.areEqual(type, sb9.toString())) {
                return (T) generateException(new InvalidModificationError(), msg, r6);
            }
            StringBuilder sb10 = new StringBuilder();
            sb10.append(prefix);
            sb10.append(InvalidNodeTypeError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_NODE_TYPE_ERROR);
            if (Intrinsics.areEqual(type, sb10.toString())) {
                return (T) generateException(new InvalidNodeTypeError(), msg, r6);
            }
            StringBuilder sb11 = new StringBuilder();
            sb11.append(prefix);
            sb11.append(InvalidStateError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_STATE_ERROR);
            if (Intrinsics.areEqual(type, sb11.toString())) {
                return (T) generateException(new InvalidStateError(), msg, r6);
            }
            StringBuilder sb12 = new StringBuilder();
            sb12.append(prefix);
            sb12.append(NamespaceError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NAMESPACE_ERROR);
            if (Intrinsics.areEqual(type, sb12.toString())) {
                return (T) generateException(new NamespaceError(), msg, r6);
            }
            StringBuilder sb13 = new StringBuilder();
            sb13.append(prefix);
            sb13.append(NetworkError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NETWORK_ERROR);
            if (Intrinsics.areEqual(type, sb13.toString())) {
                return (T) generateException(new NetworkError(), msg, r6);
            }
            StringBuilder sb14 = new StringBuilder();
            sb14.append(prefix);
            sb14.append(NoModificationAllowedError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NO_MODIFICATION_ALLOWED_ERROR);
            if (Intrinsics.areEqual(type, sb14.toString())) {
                return (T) generateException(new NoModificationAllowedError(), msg, r6);
            }
            StringBuilder sb15 = new StringBuilder();
            sb15.append(prefix);
            sb15.append(NotAllowedError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_ALLOWED_ERROR);
            if (Intrinsics.areEqual(type, sb15.toString())) {
                return (T) generateException(new NotAllowedError(), msg, r6);
            }
            StringBuilder sb16 = new StringBuilder();
            sb16.append(prefix);
            sb16.append(NotFoundError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_FOUND_ERROR);
            if (Intrinsics.areEqual(type, sb16.toString())) {
                return (T) generateException(new NotFoundError(), msg, r6);
            }
            StringBuilder sb17 = new StringBuilder();
            sb17.append(prefix);
            sb17.append(NotReadableError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_READABLE_ERROR);
            if (Intrinsics.areEqual(type, sb17.toString())) {
                return (T) generateException(new NotReadableError(), msg, r6);
            }
            StringBuilder sb18 = new StringBuilder();
            sb18.append(prefix);
            sb18.append(NotSupportedError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_SUPPORTED_ERROR);
            if (Intrinsics.areEqual(type, sb18.toString())) {
                return (T) generateException(new NotSupportedError(), msg, r6);
            }
            StringBuilder sb19 = new StringBuilder();
            sb19.append(prefix);
            sb19.append(OperationError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_OPERATION_ERROR);
            if (Intrinsics.areEqual(type, sb19.toString())) {
                return (T) generateException(new OperationError(), msg, r6);
            }
            StringBuilder sb20 = new StringBuilder();
            sb20.append(prefix);
            sb20.append(OptOutError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_OPT_OUT_ERROR);
            if (Intrinsics.areEqual(type, sb20.toString())) {
                return (T) generateException(new OptOutError(), msg, r6);
            }
            StringBuilder sb21 = new StringBuilder();
            sb21.append(prefix);
            sb21.append(QuotaExceededError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_QUOTA_EXCEEDED_ERROR);
            if (Intrinsics.areEqual(type, sb21.toString())) {
                return (T) generateException(new QuotaExceededError(), msg, r6);
            }
            StringBuilder sb22 = new StringBuilder();
            sb22.append(prefix);
            sb22.append(ReadOnlyError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_READ_ONLY_ERROR);
            if (Intrinsics.areEqual(type, sb22.toString())) {
                return (T) generateException(new ReadOnlyError(), msg, r6);
            }
            StringBuilder sb23 = new StringBuilder();
            sb23.append(prefix);
            sb23.append(SecurityError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_SECURITY_ERROR);
            if (Intrinsics.areEqual(type, sb23.toString())) {
                return (T) generateException(new SecurityError(), msg, r6);
            }
            StringBuilder sb24 = new StringBuilder();
            sb24.append(prefix);
            sb24.append(SyntaxError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_SYNTAX_ERROR);
            if (Intrinsics.areEqual(type, sb24.toString())) {
                return (T) generateException(new SyntaxError(), msg, r6);
            }
            StringBuilder sb25 = new StringBuilder();
            sb25.append(prefix);
            sb25.append(TimeoutError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_TIMEOUT_ERROR);
            if (Intrinsics.areEqual(type, sb25.toString())) {
                return (T) generateException(new TimeoutError(), msg, r6);
            }
            StringBuilder sb26 = new StringBuilder();
            sb26.append(prefix);
            sb26.append(TransactionInactiveError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_TRANSACTION_INACTIVE_ERROR);
            if (Intrinsics.areEqual(type, sb26.toString())) {
                return (T) generateException(new TransactionInactiveError(), msg, r6);
            }
            StringBuilder sb27 = new StringBuilder();
            sb27.append(prefix);
            sb27.append(UnknownError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_UNKNOWN_ERROR);
            if (Intrinsics.areEqual(type, sb27.toString())) {
                return (T) generateException(new UnknownError(), msg, r6);
            }
            StringBuilder sb28 = new StringBuilder();
            sb28.append(prefix);
            sb28.append(VersionError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_VERSION_ERROR);
            if (Intrinsics.areEqual(type, sb28.toString())) {
                return (T) generateException(new VersionError(), msg, r6);
            }
            StringBuilder sb29 = new StringBuilder();
            sb29.append(prefix);
            sb29.append(WrongDocumentError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_WRONG_DOCUMENT_ERROR);
            if (Intrinsics.areEqual(type, sb29.toString())) {
                return (T) generateException(new WrongDocumentError(), msg, r6);
            }
            throw new FrameworkClassParsingException();
        }

        public final <T> T generateException(DomError domError, String msg, T r4) {
            if (r4 instanceof CreatePublicKeyCredentialDomException) {
                return (T) new CreatePublicKeyCredentialDomException(domError, msg);
            }
            if (r4 instanceof GetPublicKeyCredentialDomException) {
                return (T) new GetPublicKeyCredentialDomException(domError, msg);
            }
            throw new FrameworkClassParsingException();
        }
    }
}
