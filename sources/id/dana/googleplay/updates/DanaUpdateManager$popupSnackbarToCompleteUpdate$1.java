package id.dana.googleplay.updates;

import android.view.View;
import com.google.android.play.core.appupdate.AppUpdateManager;
import id.dana.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.googleplay.updates.DanaUpdateManager$popupSnackbarToCompleteUpdate$1", f = "DanaUpdateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class DanaUpdateManager$popupSnackbarToCompleteUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DanaUpdateManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaUpdateManager$popupSnackbarToCompleteUpdate$1(DanaUpdateManager danaUpdateManager, Continuation<? super DanaUpdateManager$popupSnackbarToCompleteUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = danaUpdateManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DanaUpdateManager$popupSnackbarToCompleteUpdate$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DanaUpdateManager$popupSnackbarToCompleteUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final DanaUpdateManager danaUpdateManager = this.this$0;
            danaUpdateManager.getAuthRequestContext(R.string.updates_ready_to_install, R.string.update, -2, new View.OnClickListener() { // from class: id.dana.googleplay.updates.DanaUpdateManager$popupSnackbarToCompleteUpdate$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DanaUpdateManager$popupSnackbarToCompleteUpdate$1.m2613invokeSuspend$lambda0(DanaUpdateManager.this, view);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m2613invokeSuspend$lambda0(DanaUpdateManager danaUpdateManager, View view) {
        AppUpdateManager appUpdateManager;
        appUpdateManager = danaUpdateManager.PlaceComponentResult;
        if (appUpdateManager != null) {
            appUpdateManager.completeUpdate();
        }
    }
}
