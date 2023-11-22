package androidx.credentials.playservices.controllers;

import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import com.alibaba.ariver.kernel.RVEvents;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000 #*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\b\b\u0002\u0010\u0004*\u00020\u0001*\b\b\u0003\u0010\u0005*\u00020\u0001*\b\b\u0004\u0010\u0006*\u00020\u00012\u00020\u0007:\u0001#B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\u0017\u0010\t\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0000H$¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00028\u00032\u0006\u0010\u000b\u001a\u00028\u0002H$¢\u0006\u0004\b\f\u0010\nJ=\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00028\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J[\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00162\u001c\u0010\u001a\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00028\u00040\u00182\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0004¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Landroidx/credentials/playservices/controllers/CredentialProviderController;", "", "T1", "T2", "R2", "R1", "E1", "Landroidx/credentials/playservices/controllers/CredentialProviderBaseController;", "request", "convertRequestToPlayServices", "(Ljava/lang/Object;)Ljava/lang/Object;", "response", "convertResponseToCredentialManager", "Landroidx/credentials/CredentialManagerCallback;", "callback", "Ljava/util/concurrent/Executor;", "executor", "Landroid/os/CancellationSignal;", "cancellationSignal", "", "invokePlayServices", "(Ljava/lang/Object;Landroidx/credentials/CredentialManagerCallback;Ljava/util/concurrent/Executor;Landroid/os/CancellationSignal;)V", "Landroid/os/Bundle;", "resultData", "Lkotlin/Function2;", "", "conversionFn", "", "maybeReportErrorFromResultReceiver", "(Landroid/os/Bundle;Lkotlin/jvm/functions/Function2;Ljava/util/concurrent/Executor;Landroidx/credentials/CredentialManagerCallback;Landroid/os/CancellationSignal;)Z", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class CredentialProviderController<T1, T2, R2, R1, E1> extends CredentialProviderBaseController {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ERROR_MESSAGE_START_ACTIVITY_FAILED = "Failed to launch the selector UI. Hint: ensure the `context` parameter is an Activity-based context.";
    private final Context context;

    @JvmStatic
    public static final void cancelOrCallbackExceptionOrResult(CancellationSignal cancellationSignal, Function0<Unit> function0) {
        INSTANCE.cancelOrCallbackExceptionOrResult(cancellationSignal, function0);
    }

    @JvmStatic
    public static final boolean maybeReportErrorResultCodeCreate(int i, Function2<? super CancellationSignal, ? super Function0<Unit>, Unit> function2, Function1<? super CreateCredentialException, Unit> function1, CancellationSignal cancellationSignal) {
        return INSTANCE.maybeReportErrorResultCodeCreate(i, function2, function1, cancellationSignal);
    }

    @JvmStatic
    public static final boolean maybeReportErrorResultCodeGet(int i, Function2<? super CancellationSignal, ? super Function0<Unit>, Unit> function2, Function1<? super GetCredentialException, Unit> function1, CancellationSignal cancellationSignal) {
        return INSTANCE.maybeReportErrorResultCodeGet(i, function2, function1, cancellationSignal);
    }

    protected abstract T2 convertRequestToPlayServices(T1 request);

    protected abstract R1 convertResponseToCredentialManager(R2 response);

    public abstract void invokePlayServices(T1 request, CredentialManagerCallback<R1, E1> callback, Executor executor, CancellationSignal cancellationSignal);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialProviderController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJW\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2 \u0010\u0011\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0005¢\u0006\u0004\b\u0016\u0010\u0017JW\u0010\u0019\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2 \u0010\u0011\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0005¢\u0006\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Landroidx/credentials/playservices/controllers/CredentialProviderController$Companion;", "", "Landroid/os/CancellationSignal;", "cancellationSignal", "Lkotlin/Function0;", "", "onResultOrException", "cancelOrCallbackExceptionOrResult", "(Landroid/os/CancellationSignal;Lkotlin/jvm/functions/Function0;)V", "", "generateErrorStringCanceled$credentials_play_services_auth_release", "()Ljava/lang/String;", "", "resultCode", "generateErrorStringUnknown$credentials_play_services_auth_release", "(I)Ljava/lang/String;", "Lkotlin/Function2;", "cancelOnError", "Lkotlin/Function1;", "Landroidx/credentials/exceptions/CreateCredentialException;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "", "maybeReportErrorResultCodeCreate", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroid/os/CancellationSignal;)Z", "Landroidx/credentials/exceptions/GetCredentialException;", "maybeReportErrorResultCodeGet", "ERROR_MESSAGE_START_ACTIVITY_FAILED", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String generateErrorStringCanceled$credentials_play_services_auth_release() {
            return "activity is cancelled by the user.";
        }

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [androidx.credentials.exceptions.CreateCredentialCancellationException, T] */
        /* JADX WARN: Type inference failed for: r2v0, types: [androidx.credentials.exceptions.CreateCredentialUnknownException, T] */
        @JvmStatic
        protected final boolean maybeReportErrorResultCodeCreate(int resultCode, Function2<? super CancellationSignal, ? super Function0<Unit>, Unit> cancelOnError, final Function1<? super CreateCredentialException, Unit> onError, CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter(cancelOnError, "");
            Intrinsics.checkNotNullParameter(onError, "");
            if (resultCode != -1) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new CreateCredentialUnknownException(generateErrorStringUnknown$credentials_play_services_auth_release(resultCode));
                if (resultCode == 0) {
                    objectRef.element = new CreateCredentialCancellationException(generateErrorStringCanceled$credentials_play_services_auth_release());
                }
                cancelOnError.invoke(cancellationSignal, new Function0<Unit>() { // from class: androidx.credentials.playservices.controllers.CredentialProviderController$Companion$maybeReportErrorResultCodeCreate$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        onError.invoke(objectRef.element);
                    }
                });
                return true;
            }
            return false;
        }

        public final String generateErrorStringUnknown$credentials_play_services_auth_release(int resultCode) {
            StringBuilder sb = new StringBuilder();
            sb.append("activity with result code: ");
            sb.append(resultCode);
            sb.append(" indicating not RESULT_OK");
            return sb.toString();
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [androidx.credentials.exceptions.GetCredentialCancellationException, T] */
        /* JADX WARN: Type inference failed for: r2v0, types: [T, androidx.credentials.exceptions.GetCredentialUnknownException] */
        @JvmStatic
        protected final boolean maybeReportErrorResultCodeGet(int resultCode, Function2<? super CancellationSignal, ? super Function0<Unit>, Unit> cancelOnError, final Function1<? super GetCredentialException, Unit> onError, CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter(cancelOnError, "");
            Intrinsics.checkNotNullParameter(onError, "");
            if (resultCode != -1) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new GetCredentialUnknownException(generateErrorStringUnknown$credentials_play_services_auth_release(resultCode));
                if (resultCode == 0) {
                    objectRef.element = new GetCredentialCancellationException(generateErrorStringCanceled$credentials_play_services_auth_release());
                }
                cancelOnError.invoke(cancellationSignal, new Function0<Unit>() { // from class: androidx.credentials.playservices.controllers.CredentialProviderController$Companion$maybeReportErrorResultCodeGet$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        onError.invoke(objectRef.element);
                    }
                });
                return true;
            }
            return false;
        }

        @JvmStatic
        protected final void cancelOrCallbackExceptionOrResult(CancellationSignal cancellationSignal, Function0<Unit> onResultOrException) {
            Intrinsics.checkNotNullParameter(onResultOrException, "");
            if (CredentialProviderPlayServicesImpl.INSTANCE.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal)) {
                return;
            }
            onResultOrException.invoke();
        }
    }

    public final boolean maybeReportErrorFromResultReceiver(Bundle resultData, Function2<? super String, ? super String, ? extends E1> conversionFn, Executor executor, CredentialManagerCallback<R1, E1> callback, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(resultData, "");
        Intrinsics.checkNotNullParameter(conversionFn, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(callback, "");
        if (resultData.getBoolean(CredentialProviderBaseController.FAILURE_RESPONSE_TAG)) {
            cancelOrCallbackExceptionOrResult(cancellationSignal, new CredentialProviderController$maybeReportErrorFromResultReceiver$1(executor, callback, conversionFn.invoke(resultData.getString(CredentialProviderBaseController.EXCEPTION_TYPE_TAG), resultData.getString(CredentialProviderBaseController.EXCEPTION_MESSAGE_TAG))));
            return true;
        }
        return false;
    }
}
