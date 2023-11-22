package androidx.credentials.playservices;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.fido.Fido;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J)\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0014\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J'\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010 "}, d2 = {"Landroidx/credentials/playservices/HiddenActivity;", "Landroid/app/Activity;", "", "handleBeginSignIn", "()V", "handleCreatePassword", "handleCreatePublicKeyCredential", "handleGetSignInIntent", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "restoreState", "Landroid/os/ResultReceiver;", "resultReceiver", "", "errName", "errMsg", "setupFailure", "(Landroid/os/ResultReceiver;Ljava/lang/String;Ljava/lang/String;)V", "", "mWaitingForActivityResult", "Z", "Landroid/os/ResultReceiver;", "<init>", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class HiddenActivity extends Activity {
    private static final int DEFAULT_VALUE = 1;
    private static final String KEY_AWAITING_RESULT = "androidx.credentials.playservices.AWAITING_RESULT";
    private static final String TAG = "HiddenActivity";
    private boolean mWaitingForActivityResult;
    private ResultReceiver resultReceiver;

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        String stringExtra = getIntent().getStringExtra("TYPE");
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra(CredentialProviderBaseController.RESULT_RECEIVER_TAG);
        this.resultReceiver = resultReceiver;
        if (resultReceiver == null) {
            finish();
        }
        restoreState(savedInstanceState);
        if (this.mWaitingForActivityResult) {
            return;
        }
        if (stringExtra != null) {
            switch (stringExtra.hashCode()) {
                case -441061071:
                    if (stringExtra.equals(CredentialProviderBaseController.BEGIN_SIGN_IN_TAG)) {
                        handleBeginSignIn();
                        return;
                    }
                    break;
                case 15545322:
                    if (stringExtra.equals(CredentialProviderBaseController.CREATE_PUBLIC_KEY_CREDENTIAL_TAG)) {
                        handleCreatePublicKeyCredential();
                        return;
                    }
                    break;
                case 1246634622:
                    if (stringExtra.equals(CredentialProviderBaseController.CREATE_PASSWORD_TAG)) {
                        handleCreatePassword();
                        return;
                    }
                    break;
                case 1980564212:
                    if (stringExtra.equals(CredentialProviderBaseController.SIGN_IN_INTENT_TAG)) {
                        handleGetSignInIntent();
                        return;
                    }
                    break;
            }
        }
        InstrumentInjector.log_w(TAG, "Activity handed an unsupported type");
        finish();
    }

    private final void restoreState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.mWaitingForActivityResult = savedInstanceState.getBoolean(KEY_AWAITING_RESULT, false);
        }
    }

    private final void handleCreatePublicKeyCredential() {
        Task<PendingIntent> task;
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) getIntent().getParcelableExtra(CredentialProviderBaseController.REQUEST_TAG);
        final int intExtra = getIntent().getIntExtra(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, 1);
        if (publicKeyCredentialCreationOptions != null) {
            Task<PendingIntent> registerPendingIntent = Fido.getFido2ApiClient((Activity) this).getRegisterPendingIntent(publicKeyCredentialCreationOptions);
            final Function1<PendingIntent, Unit> function1 = new Function1<PendingIntent, Unit>() { // from class: androidx.credentials.playservices.HiddenActivity$handleCreatePublicKeyCredential$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(PendingIntent pendingIntent) {
                    invoke2(pendingIntent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(PendingIntent pendingIntent) {
                    ResultReceiver resultReceiver;
                    Intrinsics.checkNotNullParameter(pendingIntent, "");
                    try {
                        HiddenActivity.this.mWaitingForActivityResult = true;
                        HiddenActivity.this.startIntentSenderForResult(pendingIntent.getIntentSender(), intExtra, null, 0, 0, 0, null);
                    } catch (IntentSender.SendIntentException e) {
                        HiddenActivity hiddenActivity = HiddenActivity.this;
                        resultReceiver = hiddenActivity.resultReceiver;
                        Intrinsics.checkNotNull(resultReceiver);
                        StringBuilder sb = new StringBuilder();
                        sb.append("During public key credential, found IntentSender failure on public key creation: ");
                        sb.append(e.getMessage());
                        hiddenActivity.setupFailure(resultReceiver, CredentialProviderBaseController.CREATE_UNKNOWN, sb.toString());
                    }
                }
            };
            task = registerPendingIntent.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.credentials.playservices.HiddenActivity$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HiddenActivity.handleCreatePublicKeyCredential$lambda$2$lambda$0(Function1.this, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: androidx.credentials.playservices.HiddenActivity$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiddenActivity.handleCreatePublicKeyCredential$lambda$2$lambda$1(HiddenActivity.this, exc);
                }
            });
        } else {
            task = null;
        }
        if (task == null) {
            InstrumentInjector.log_w(TAG, "During create public key credential, request is null, so nothing to launch for public key credentials");
            finish();
        }
    }

    public static final void handleCreatePublicKeyCredential$lambda$2$lambda$0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "");
        function1.invoke(obj);
    }

    public static final void handleCreatePublicKeyCredential$lambda$2$lambda$1(HiddenActivity hiddenActivity, Exception exc) {
        Intrinsics.checkNotNullParameter(hiddenActivity, "");
        Intrinsics.checkNotNullParameter(exc, "");
        String str = ((exc instanceof ApiException) && CredentialProviderBaseController.INSTANCE.getRetryables().contains(Integer.valueOf(((ApiException) exc).getStatusCode()))) ? CredentialProviderBaseController.CREATE_INTERRUPTED : CredentialProviderBaseController.CREATE_UNKNOWN;
        ResultReceiver resultReceiver = hiddenActivity.resultReceiver;
        Intrinsics.checkNotNull(resultReceiver);
        StringBuilder sb = new StringBuilder();
        sb.append("During create public key credential, fido registration failure: ");
        sb.append(exc.getMessage());
        hiddenActivity.setupFailure(resultReceiver, str, sb.toString());
    }

    public final void setupFailure(ResultReceiver resultReceiver, String errName, String errMsg) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(CredentialProviderBaseController.FAILURE_RESPONSE_TAG, true);
        bundle.putString(CredentialProviderBaseController.EXCEPTION_TYPE_TAG, errName);
        bundle.putString(CredentialProviderBaseController.EXCEPTION_MESSAGE_TAG, errMsg);
        resultReceiver.send(Integer.MAX_VALUE, bundle);
        finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "");
        outState.putBoolean(KEY_AWAITING_RESULT, this.mWaitingForActivityResult);
        super.onSaveInstanceState(outState);
    }

    private final void handleGetSignInIntent() {
        Task<PendingIntent> task;
        GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) getIntent().getParcelableExtra(CredentialProviderBaseController.REQUEST_TAG);
        final int intExtra = getIntent().getIntExtra(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, 1);
        if (getSignInIntentRequest != null) {
            Task<PendingIntent> signInIntent = Identity.getSignInClient((Activity) this).getSignInIntent(getSignInIntentRequest);
            final Function1<PendingIntent, Unit> function1 = new Function1<PendingIntent, Unit>() { // from class: androidx.credentials.playservices.HiddenActivity$handleGetSignInIntent$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(PendingIntent pendingIntent) {
                    invoke2(pendingIntent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(PendingIntent pendingIntent) {
                    ResultReceiver resultReceiver;
                    try {
                        HiddenActivity.this.mWaitingForActivityResult = true;
                        HiddenActivity.this.startIntentSenderForResult(pendingIntent.getIntentSender(), intExtra, null, 0, 0, 0, null);
                    } catch (IntentSender.SendIntentException e) {
                        HiddenActivity hiddenActivity = HiddenActivity.this;
                        resultReceiver = hiddenActivity.resultReceiver;
                        Intrinsics.checkNotNull(resultReceiver);
                        StringBuilder sb = new StringBuilder();
                        sb.append("During get sign-in intent, one tap ui intent sender failure: ");
                        sb.append(e.getMessage());
                        hiddenActivity.setupFailure(resultReceiver, CredentialProviderBaseController.GET_UNKNOWN, sb.toString());
                    }
                }
            };
            task = signInIntent.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.credentials.playservices.HiddenActivity$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HiddenActivity.handleGetSignInIntent$lambda$6$lambda$4(Function1.this, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: androidx.credentials.playservices.HiddenActivity$$ExternalSyntheticLambda3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiddenActivity.handleGetSignInIntent$lambda$6$lambda$5(HiddenActivity.this, exc);
                }
            });
        } else {
            task = null;
        }
        if (task == null) {
            InstrumentInjector.log_i(TAG, "During get sign-in intent, params is null, nothing to launch for get sign-in intent");
            finish();
        }
    }

    public static final void handleGetSignInIntent$lambda$6$lambda$4(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "");
        function1.invoke(obj);
    }

    public static final void handleGetSignInIntent$lambda$6$lambda$5(HiddenActivity hiddenActivity, Exception exc) {
        Intrinsics.checkNotNullParameter(hiddenActivity, "");
        Intrinsics.checkNotNullParameter(exc, "");
        String str = ((exc instanceof ApiException) && CredentialProviderBaseController.INSTANCE.getRetryables().contains(Integer.valueOf(((ApiException) exc).getStatusCode()))) ? CredentialProviderBaseController.GET_INTERRUPTED : CredentialProviderBaseController.GET_NO_CREDENTIALS;
        ResultReceiver resultReceiver = hiddenActivity.resultReceiver;
        Intrinsics.checkNotNull(resultReceiver);
        StringBuilder sb = new StringBuilder();
        sb.append("During get sign-in intent, failure response from one tap: ");
        sb.append(exc.getMessage());
        hiddenActivity.setupFailure(resultReceiver, str, sb.toString());
    }

    private final void handleBeginSignIn() {
        Task<BeginSignInResult> task;
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) getIntent().getParcelableExtra(CredentialProviderBaseController.REQUEST_TAG);
        final int intExtra = getIntent().getIntExtra(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, 1);
        if (beginSignInRequest != null) {
            Task<BeginSignInResult> beginSignIn = Identity.getSignInClient((Activity) this).beginSignIn(beginSignInRequest);
            final Function1<BeginSignInResult, Unit> function1 = new Function1<BeginSignInResult, Unit>() { // from class: androidx.credentials.playservices.HiddenActivity$handleBeginSignIn$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(BeginSignInResult beginSignInResult) {
                    invoke2(beginSignInResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(BeginSignInResult beginSignInResult) {
                    ResultReceiver resultReceiver;
                    try {
                        HiddenActivity.this.mWaitingForActivityResult = true;
                        HiddenActivity.this.startIntentSenderForResult(beginSignInResult.getPendingIntent().getIntentSender(), intExtra, null, 0, 0, 0, null);
                    } catch (IntentSender.SendIntentException e) {
                        HiddenActivity hiddenActivity = HiddenActivity.this;
                        resultReceiver = hiddenActivity.resultReceiver;
                        Intrinsics.checkNotNull(resultReceiver);
                        StringBuilder sb = new StringBuilder();
                        sb.append("During begin sign in, one tap ui intent sender failure: ");
                        sb.append(e.getMessage());
                        hiddenActivity.setupFailure(resultReceiver, CredentialProviderBaseController.GET_UNKNOWN, sb.toString());
                    }
                }
            };
            task = beginSignIn.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.credentials.playservices.HiddenActivity$$ExternalSyntheticLambda4
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HiddenActivity.handleBeginSignIn$lambda$10$lambda$8(Function1.this, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: androidx.credentials.playservices.HiddenActivity$$ExternalSyntheticLambda5
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiddenActivity.handleBeginSignIn$lambda$10$lambda$9(HiddenActivity.this, exc);
                }
            });
        } else {
            task = null;
        }
        if (task == null) {
            InstrumentInjector.log_i(TAG, "During begin sign in, params is null, nothing to launch for begin sign in");
            finish();
        }
    }

    public static final void handleBeginSignIn$lambda$10$lambda$8(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "");
        function1.invoke(obj);
    }

    public static final void handleBeginSignIn$lambda$10$lambda$9(HiddenActivity hiddenActivity, Exception exc) {
        Intrinsics.checkNotNullParameter(hiddenActivity, "");
        Intrinsics.checkNotNullParameter(exc, "");
        String str = ((exc instanceof ApiException) && CredentialProviderBaseController.INSTANCE.getRetryables().contains(Integer.valueOf(((ApiException) exc).getStatusCode()))) ? CredentialProviderBaseController.GET_INTERRUPTED : CredentialProviderBaseController.GET_NO_CREDENTIALS;
        ResultReceiver resultReceiver = hiddenActivity.resultReceiver;
        Intrinsics.checkNotNull(resultReceiver);
        StringBuilder sb = new StringBuilder();
        sb.append("During begin sign in, failure response from one tap: ");
        sb.append(exc.getMessage());
        hiddenActivity.setupFailure(resultReceiver, str, sb.toString());
    }

    private final void handleCreatePassword() {
        Task<SavePasswordResult> task;
        SavePasswordRequest savePasswordRequest = (SavePasswordRequest) getIntent().getParcelableExtra(CredentialProviderBaseController.REQUEST_TAG);
        final int intExtra = getIntent().getIntExtra(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, 1);
        if (savePasswordRequest != null) {
            Task<SavePasswordResult> savePassword = Identity.getCredentialSavingClient((Activity) this).savePassword(savePasswordRequest);
            final Function1<SavePasswordResult, Unit> function1 = new Function1<SavePasswordResult, Unit>() { // from class: androidx.credentials.playservices.HiddenActivity$handleCreatePassword$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(SavePasswordResult savePasswordResult) {
                    invoke2(savePasswordResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SavePasswordResult savePasswordResult) {
                    ResultReceiver resultReceiver;
                    try {
                        HiddenActivity.this.mWaitingForActivityResult = true;
                        HiddenActivity.this.startIntentSenderForResult(savePasswordResult.getPendingIntent().getIntentSender(), intExtra, null, 0, 0, 0, null);
                    } catch (IntentSender.SendIntentException e) {
                        HiddenActivity hiddenActivity = HiddenActivity.this;
                        resultReceiver = hiddenActivity.resultReceiver;
                        Intrinsics.checkNotNull(resultReceiver);
                        StringBuilder sb = new StringBuilder();
                        sb.append("During save password, found UI intent sender failure: ");
                        sb.append(e.getMessage());
                        hiddenActivity.setupFailure(resultReceiver, CredentialProviderBaseController.CREATE_UNKNOWN, sb.toString());
                    }
                }
            };
            task = savePassword.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.credentials.playservices.HiddenActivity$$ExternalSyntheticLambda6
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HiddenActivity.handleCreatePassword$lambda$14$lambda$12(Function1.this, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: androidx.credentials.playservices.HiddenActivity$$ExternalSyntheticLambda7
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiddenActivity.handleCreatePassword$lambda$14$lambda$13(HiddenActivity.this, exc);
                }
            });
        } else {
            task = null;
        }
        if (task == null) {
            InstrumentInjector.log_i(TAG, "During save password, params is null, nothing to launch for create password");
            finish();
        }
    }

    public static final void handleCreatePassword$lambda$14$lambda$12(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "");
        function1.invoke(obj);
    }

    public static final void handleCreatePassword$lambda$14$lambda$13(HiddenActivity hiddenActivity, Exception exc) {
        Intrinsics.checkNotNullParameter(hiddenActivity, "");
        Intrinsics.checkNotNullParameter(exc, "");
        String str = ((exc instanceof ApiException) && CredentialProviderBaseController.INSTANCE.getRetryables().contains(Integer.valueOf(((ApiException) exc).getStatusCode()))) ? CredentialProviderBaseController.CREATE_INTERRUPTED : CredentialProviderBaseController.CREATE_UNKNOWN;
        ResultReceiver resultReceiver = hiddenActivity.resultReceiver;
        Intrinsics.checkNotNull(resultReceiver);
        StringBuilder sb = new StringBuilder();
        sb.append("During save password, found password failure response from one tap ");
        sb.append(exc.getMessage());
        hiddenActivity.setupFailure(resultReceiver, str, sb.toString());
    }

    @Override // android.app.Activity
    protected void onActivityResult(int r4, int resultCode, Intent data) {
        super.onActivityResult(r4, resultCode, data);
        Bundle bundle = new Bundle();
        bundle.putBoolean(CredentialProviderBaseController.FAILURE_RESPONSE_TAG, false);
        bundle.putInt(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, r4);
        bundle.putParcelable(CredentialProviderBaseController.RESULT_DATA_TAG, data);
        ResultReceiver resultReceiver = this.resultReceiver;
        if (resultReceiver != null) {
            resultReceiver.send(resultCode, bundle);
        }
        this.mWaitingForActivityResult = false;
        finish();
    }
}
