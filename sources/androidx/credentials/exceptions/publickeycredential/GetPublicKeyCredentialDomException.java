package androidx.credentials.exceptions.publickeycredential;

import androidx.credentials.exceptions.GetCredentialCustomException;
import androidx.credentials.exceptions.GetCredentialException;
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
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/credentials/exceptions/publickeycredential/GetPublicKeyCredentialDomException;", "Landroidx/credentials/exceptions/publickeycredential/GetPublicKeyCredentialException;", "Landroidx/credentials/exceptions/domerrors/DomError;", "domError", "Landroidx/credentials/exceptions/domerrors/DomError;", "getDomError", "()Landroidx/credentials/exceptions/domerrors/DomError;", "", "errorMessage", "<init>", "(Landroidx/credentials/exceptions/domerrors/DomError;Ljava/lang/CharSequence;)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetPublicKeyCredentialDomException extends GetPublicKeyCredentialException {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION = "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION";
    private final DomError domError;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.CharSequence, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetPublicKeyCredentialDomException(androidx.credentials.exceptions.domerrors.DomError r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 2
            r2.<init>(r3, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.exceptions.publickeycredential.GetPublicKeyCredentialDomException.<init>(androidx.credentials.exceptions.domerrors.DomError):void");
    }

    @JvmStatic
    public static final GetCredentialException createFrom(String str, String str2) {
        return INSTANCE.createFrom(str, str2);
    }

    public /* synthetic */ GetPublicKeyCredentialDomException(DomError domError, CharSequence charSequence, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(domError, (i & 2) != 0 ? null : charSequence);
    }

    @JvmName(name = "getDomError")
    public final DomError getDomError() {
        return this.domError;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetPublicKeyCredentialDomException(androidx.credentials.exceptions.domerrors.DomError r3, java.lang.CharSequence r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/"
            r0.append(r1)
            java.lang.String r1 = r3.getType()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0, r4)
            r2.domError = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.exceptions.publickeycredential.GetPublicKeyCredentialDomException.<init>(androidx.credentials.exceptions.domerrors.DomError, java.lang.CharSequence):void");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Landroidx/credentials/exceptions/publickeycredential/GetPublicKeyCredentialDomException$Companion;", "", "", "type", "msg", "Landroidx/credentials/exceptions/GetCredentialException;", "createFrom", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/credentials/exceptions/GetCredentialException;", "TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.CharSequence, kotlin.jvm.internal.DefaultConstructorMarker] */
        @JvmStatic
        public final GetCredentialException createFrom(String type, String msg) {
            Object generateException;
            Intrinsics.checkNotNullParameter(type, "");
            try {
                DomExceptionUtils.Companion companion = DomExceptionUtils.INSTANCE;
                ?? r5 = 0;
                GetPublicKeyCredentialDomException getPublicKeyCredentialDomException = new GetPublicKeyCredentialDomException(new UnknownError(), r5, 2, r5);
                StringBuilder sb = new StringBuilder();
                sb.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                sb.append(AbortError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_ABORT_ERROR);
                if (Intrinsics.areEqual(type, sb.toString())) {
                    generateException = companion.generateException(new AbortError(), msg, getPublicKeyCredentialDomException);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                    sb2.append(ConstraintError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_CONSTRAINT_ERROR);
                    if (Intrinsics.areEqual(type, sb2.toString())) {
                        generateException = companion.generateException(new ConstraintError(), msg, getPublicKeyCredentialDomException);
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                        sb3.append(DataCloneError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DATA_CLONE_ERROR);
                        if (Intrinsics.areEqual(type, sb3.toString())) {
                            generateException = companion.generateException(new DataCloneError(), msg, getPublicKeyCredentialDomException);
                        } else {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                            sb4.append(DataError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DATA_ERROR);
                            if (Intrinsics.areEqual(type, sb4.toString())) {
                                generateException = companion.generateException(new DataError(), msg, getPublicKeyCredentialDomException);
                            } else {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                sb5.append(EncodingError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_ENCODING_ERROR);
                                if (Intrinsics.areEqual(type, sb5.toString())) {
                                    generateException = companion.generateException(new EncodingError(), msg, getPublicKeyCredentialDomException);
                                } else {
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                    sb6.append(HierarchyRequestError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_HIERARCHY_REQUEST_ERROR);
                                    if (Intrinsics.areEqual(type, sb6.toString())) {
                                        generateException = companion.generateException(new HierarchyRequestError(), msg, getPublicKeyCredentialDomException);
                                    } else {
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                        sb7.append(InUseAttributeError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_IN_USE_ATTRIBUTE_ERROR);
                                        if (Intrinsics.areEqual(type, sb7.toString())) {
                                            generateException = companion.generateException(new InUseAttributeError(), msg, getPublicKeyCredentialDomException);
                                        } else {
                                            StringBuilder sb8 = new StringBuilder();
                                            sb8.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                            sb8.append(InvalidCharacterError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_CHARACTER_ERROR);
                                            if (Intrinsics.areEqual(type, sb8.toString())) {
                                                generateException = companion.generateException(new InvalidCharacterError(), msg, getPublicKeyCredentialDomException);
                                            } else {
                                                StringBuilder sb9 = new StringBuilder();
                                                sb9.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                sb9.append(InvalidModificationError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_MODIFICATION_ERROR);
                                                if (Intrinsics.areEqual(type, sb9.toString())) {
                                                    generateException = companion.generateException(new InvalidModificationError(), msg, getPublicKeyCredentialDomException);
                                                } else {
                                                    StringBuilder sb10 = new StringBuilder();
                                                    sb10.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                    sb10.append(InvalidNodeTypeError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_NODE_TYPE_ERROR);
                                                    if (Intrinsics.areEqual(type, sb10.toString())) {
                                                        generateException = companion.generateException(new InvalidNodeTypeError(), msg, getPublicKeyCredentialDomException);
                                                    } else {
                                                        StringBuilder sb11 = new StringBuilder();
                                                        sb11.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                        sb11.append(InvalidStateError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_STATE_ERROR);
                                                        if (Intrinsics.areEqual(type, sb11.toString())) {
                                                            generateException = companion.generateException(new InvalidStateError(), msg, getPublicKeyCredentialDomException);
                                                        } else {
                                                            StringBuilder sb12 = new StringBuilder();
                                                            sb12.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                            sb12.append(NamespaceError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NAMESPACE_ERROR);
                                                            if (Intrinsics.areEqual(type, sb12.toString())) {
                                                                generateException = companion.generateException(new NamespaceError(), msg, getPublicKeyCredentialDomException);
                                                            } else {
                                                                StringBuilder sb13 = new StringBuilder();
                                                                sb13.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                sb13.append(NetworkError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NETWORK_ERROR);
                                                                if (Intrinsics.areEqual(type, sb13.toString())) {
                                                                    generateException = companion.generateException(new NetworkError(), msg, getPublicKeyCredentialDomException);
                                                                } else {
                                                                    StringBuilder sb14 = new StringBuilder();
                                                                    sb14.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                    sb14.append(NoModificationAllowedError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NO_MODIFICATION_ALLOWED_ERROR);
                                                                    if (Intrinsics.areEqual(type, sb14.toString())) {
                                                                        generateException = companion.generateException(new NoModificationAllowedError(), msg, getPublicKeyCredentialDomException);
                                                                    } else {
                                                                        StringBuilder sb15 = new StringBuilder();
                                                                        sb15.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                        sb15.append(NotAllowedError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_ALLOWED_ERROR);
                                                                        if (Intrinsics.areEqual(type, sb15.toString())) {
                                                                            generateException = companion.generateException(new NotAllowedError(), msg, getPublicKeyCredentialDomException);
                                                                        } else {
                                                                            StringBuilder sb16 = new StringBuilder();
                                                                            sb16.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                            sb16.append(NotFoundError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_FOUND_ERROR);
                                                                            if (Intrinsics.areEqual(type, sb16.toString())) {
                                                                                generateException = companion.generateException(new NotFoundError(), msg, getPublicKeyCredentialDomException);
                                                                            } else {
                                                                                StringBuilder sb17 = new StringBuilder();
                                                                                sb17.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                                sb17.append(NotReadableError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_READABLE_ERROR);
                                                                                if (Intrinsics.areEqual(type, sb17.toString())) {
                                                                                    generateException = companion.generateException(new NotReadableError(), msg, getPublicKeyCredentialDomException);
                                                                                } else {
                                                                                    StringBuilder sb18 = new StringBuilder();
                                                                                    sb18.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                                    sb18.append(NotSupportedError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_SUPPORTED_ERROR);
                                                                                    if (Intrinsics.areEqual(type, sb18.toString())) {
                                                                                        generateException = companion.generateException(new NotSupportedError(), msg, getPublicKeyCredentialDomException);
                                                                                    } else {
                                                                                        StringBuilder sb19 = new StringBuilder();
                                                                                        sb19.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                                        sb19.append(OperationError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_OPERATION_ERROR);
                                                                                        if (Intrinsics.areEqual(type, sb19.toString())) {
                                                                                            generateException = companion.generateException(new OperationError(), msg, getPublicKeyCredentialDomException);
                                                                                        } else {
                                                                                            StringBuilder sb20 = new StringBuilder();
                                                                                            sb20.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                                            sb20.append(OptOutError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_OPT_OUT_ERROR);
                                                                                            if (Intrinsics.areEqual(type, sb20.toString())) {
                                                                                                generateException = companion.generateException(new OptOutError(), msg, getPublicKeyCredentialDomException);
                                                                                            } else {
                                                                                                StringBuilder sb21 = new StringBuilder();
                                                                                                sb21.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                                                sb21.append(QuotaExceededError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_QUOTA_EXCEEDED_ERROR);
                                                                                                if (Intrinsics.areEqual(type, sb21.toString())) {
                                                                                                    generateException = companion.generateException(new QuotaExceededError(), msg, getPublicKeyCredentialDomException);
                                                                                                } else {
                                                                                                    StringBuilder sb22 = new StringBuilder();
                                                                                                    sb22.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                                                    sb22.append(ReadOnlyError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_READ_ONLY_ERROR);
                                                                                                    if (Intrinsics.areEqual(type, sb22.toString())) {
                                                                                                        generateException = companion.generateException(new ReadOnlyError(), msg, getPublicKeyCredentialDomException);
                                                                                                    } else {
                                                                                                        StringBuilder sb23 = new StringBuilder();
                                                                                                        sb23.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                                                        sb23.append(SecurityError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_SECURITY_ERROR);
                                                                                                        if (Intrinsics.areEqual(type, sb23.toString())) {
                                                                                                            generateException = companion.generateException(new SecurityError(), msg, getPublicKeyCredentialDomException);
                                                                                                        } else {
                                                                                                            StringBuilder sb24 = new StringBuilder();
                                                                                                            sb24.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                                                            sb24.append(SyntaxError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_SYNTAX_ERROR);
                                                                                                            if (Intrinsics.areEqual(type, sb24.toString())) {
                                                                                                                generateException = companion.generateException(new SyntaxError(), msg, getPublicKeyCredentialDomException);
                                                                                                            } else {
                                                                                                                StringBuilder sb25 = new StringBuilder();
                                                                                                                sb25.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                                                                sb25.append(TimeoutError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_TIMEOUT_ERROR);
                                                                                                                if (Intrinsics.areEqual(type, sb25.toString())) {
                                                                                                                    generateException = companion.generateException(new TimeoutError(), msg, getPublicKeyCredentialDomException);
                                                                                                                } else {
                                                                                                                    StringBuilder sb26 = new StringBuilder();
                                                                                                                    sb26.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                                                                    sb26.append(TransactionInactiveError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_TRANSACTION_INACTIVE_ERROR);
                                                                                                                    if (Intrinsics.areEqual(type, sb26.toString())) {
                                                                                                                        generateException = companion.generateException(new TransactionInactiveError(), msg, getPublicKeyCredentialDomException);
                                                                                                                    } else {
                                                                                                                        StringBuilder sb27 = new StringBuilder();
                                                                                                                        sb27.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                                                                        sb27.append(UnknownError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_UNKNOWN_ERROR);
                                                                                                                        if (Intrinsics.areEqual(type, sb27.toString())) {
                                                                                                                            generateException = companion.generateException(new UnknownError(), msg, getPublicKeyCredentialDomException);
                                                                                                                        } else {
                                                                                                                            StringBuilder sb28 = new StringBuilder();
                                                                                                                            sb28.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                                                                            sb28.append(VersionError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_VERSION_ERROR);
                                                                                                                            if (Intrinsics.areEqual(type, sb28.toString())) {
                                                                                                                                generateException = companion.generateException(new VersionError(), msg, getPublicKeyCredentialDomException);
                                                                                                                            } else {
                                                                                                                                StringBuilder sb29 = new StringBuilder();
                                                                                                                                sb29.append("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/");
                                                                                                                                sb29.append(WrongDocumentError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_WRONG_DOCUMENT_ERROR);
                                                                                                                                if (Intrinsics.areEqual(type, sb29.toString())) {
                                                                                                                                    generateException = companion.generateException(new WrongDocumentError(), msg, getPublicKeyCredentialDomException);
                                                                                                                                } else {
                                                                                                                                    throw new FrameworkClassParsingException();
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return (GetCredentialException) generateException;
            } catch (FrameworkClassParsingException unused) {
                return new GetCredentialCustomException(type, msg);
            }
        }
    }
}
