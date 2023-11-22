package com.google.android.play.core.ktx;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.ktx.AppUpdateResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1", f = "AppUpdateManagerKtx.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AppUpdateManagerKtxKt$requestUpdateFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super AppUpdateResult>, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppUpdateManager $this_requestUpdateFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppUpdateManagerKtxKt$requestUpdateFlow$1(AppUpdateManager appUpdateManager, Continuation<? super AppUpdateManagerKtxKt$requestUpdateFlow$1> continuation) {
        super(2, continuation);
        this.$this_requestUpdateFlow = appUpdateManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AppUpdateManagerKtxKt$requestUpdateFlow$1 appUpdateManagerKtxKt$requestUpdateFlow$1 = new AppUpdateManagerKtxKt$requestUpdateFlow$1(this.$this_requestUpdateFlow, continuation);
        appUpdateManagerKtxKt$requestUpdateFlow$1.L$0 = obj;
        return appUpdateManagerKtxKt$requestUpdateFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super AppUpdateResult> producerScope, Continuation<? super Unit> continuation) {
        return ((AppUpdateManagerKtxKt$requestUpdateFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final AppUpdateManager appUpdateManager = this.$this_requestUpdateFlow;
            final AppUpdatePassthroughListener appUpdatePassthroughListener = new AppUpdatePassthroughListener(new InstallStateUpdatedListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$1
                @Override // com.google.android.play.core.listener.StateUpdatedListener
                public final void onStateUpdate(InstallState installState) {
                    Intrinsics.checkNotNullParameter(installState, "");
                    if (installState.installStatus() == 11) {
                        AppUpdateManagerKtxKt.tryOffer(producerScope, new AppUpdateResult.Downloaded(appUpdateManager));
                    } else {
                        AppUpdateManagerKtxKt.tryOffer(producerScope, new AppUpdateResult.InProgress(installState));
                    }
                }
            }, new Function1<AppUpdatePassthroughListener, Unit>() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(AppUpdatePassthroughListener appUpdatePassthroughListener2) {
                    invoke2(appUpdatePassthroughListener2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(AppUpdatePassthroughListener appUpdatePassthroughListener2) {
                    Intrinsics.checkNotNullParameter(appUpdatePassthroughListener2, "");
                    SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                }
            });
            Task<AppUpdateInfo> appUpdateInfo = this.$this_requestUpdateFlow.getAppUpdateInfo();
            final AppUpdateManager appUpdateManager2 = this.$this_requestUpdateFlow;
            appUpdateInfo.addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1.1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(AppUpdateInfo appUpdateInfo2) {
                    int updateAvailability = appUpdateInfo2.updateAvailability();
                    if (updateAvailability == 0) {
                        producerScope.close(new InstallException(-2));
                    } else if (updateAvailability == 1) {
                        AppUpdateManagerKtxKt.tryOffer(producerScope, AppUpdateResult.NotAvailable.INSTANCE);
                        SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                    } else if (updateAvailability == 2 || updateAvailability == 3) {
                        Intrinsics.checkNotNullExpressionValue(appUpdateInfo2, "");
                        if (appUpdateInfo2.installStatus() == 11) {
                            AppUpdateManagerKtxKt.tryOffer(producerScope, new AppUpdateResult.Downloaded(appUpdateManager2));
                            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                            return;
                        }
                        appUpdateManager2.registerListener(appUpdatePassthroughListener);
                        AppUpdateManagerKtxKt.tryOffer(producerScope, new AppUpdateResult.Available(appUpdateManager2, appUpdateInfo2));
                    }
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1.2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    Intrinsics.checkNotNullParameter(exc, "");
                    producerScope.close(exc);
                }
            });
            final AppUpdateManager appUpdateManager3 = this.$this_requestUpdateFlow;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke */
                public final void invoke2() {
                    appUpdateManager3.unregisterListener(appUpdatePassthroughListener);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
