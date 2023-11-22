package id.dana.riskChallenges.ui.missedCallOtp;

import android.content.Context;
import androidx.core.os.BundleKt;
import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import id.dana.core.ui.constant.BottomInfoSnackbarState;
import id.dana.core.ui.dialog.DanaLoadingDialogFragment;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.core.ui.richview.BottomInfoSnackbar;
import id.dana.core.ui.richview.InputPhoneView;
import id.dana.core.ui.richview.RetryAndTimerView;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentMissedCallOtpBinding;
import id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpUIState;
import id.dana.utils.StringWrapperKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$observeUiState$1", f = "MissedCallOtpFragment.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class MissedCallOtpFragment$observeUiState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MissedCallOtpFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissedCallOtpFragment$observeUiState$1(MissedCallOtpFragment missedCallOtpFragment, Continuation<? super MissedCallOtpFragment$observeUiState$1> continuation) {
        super(2, continuation);
        this.this$0 = missedCallOtpFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MissedCallOtpFragment$observeUiState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MissedCallOtpFragment$observeUiState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$observeUiState$1$1", f = "MissedCallOtpFragment.kt", i = {}, l = {349}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$observeUiState$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MissedCallOtpFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MissedCallOtpFragment missedCallOtpFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = missedCallOtpFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<MissedCallOtpUIState> stateFlow = MissedCallOtpFragment.moveToNextValue(this.this$0).scheduleImpl;
                final MissedCallOtpFragment missedCallOtpFragment = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment.observeUiState.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
                    public final Object emit(MissedCallOtpUIState missedCallOtpUIState, Continuation<? super Unit> continuation) {
                        if (missedCallOtpUIState instanceof MissedCallOtpUIState.MissedCallOtpPermission) {
                            MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this).PlaceComponentResult();
                            MissedCallOtpUIState.MissedCallOtpPermission missedCallOtpPermission = (MissedCallOtpUIState.MissedCallOtpPermission) missedCallOtpUIState;
                            MissedCallOtpFragment.BuiltInFictitiousFunctionClassFactory(MissedCallOtpFragment.this, missedCallOtpPermission.getBuiltInFictitiousFunctionClassFactory(), missedCallOtpPermission.getKClassImpl$Data$declaredNonStaticMembers$2());
                        } else if (!(missedCallOtpUIState instanceof MissedCallOtpUIState.ShowProgress)) {
                            if (!(missedCallOtpUIState instanceof MissedCallOtpUIState.DismissProgress)) {
                                if (!(missedCallOtpUIState instanceof MissedCallOtpUIState.ShowResendProgress)) {
                                    if (!(missedCallOtpUIState instanceof MissedCallOtpUIState.DismissResendProgress)) {
                                        if (missedCallOtpUIState instanceof MissedCallOtpUIState.Success) {
                                            MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this).PlaceComponentResult();
                                            VB vb = MissedCallOtpFragment.this.PlaceComponentResult;
                                            if (vb != 0) {
                                                RetryAndTimerView retryAndTimerView = ((FragmentMissedCallOtpBinding) vb).scheduleImpl;
                                                final MissedCallOtpFragment missedCallOtpFragment2 = MissedCallOtpFragment.this;
                                                Intrinsics.checkNotNullExpressionValue(retryAndTimerView, "");
                                                retryAndTimerView.setVisibility(0);
                                                missedCallOtpFragment2.MyBillsEntityDataFactory(new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$observeUiState$1$1$1$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
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
                                                        ((DanaLoadingDialogFragment) MissedCallOtpFragment.this.DatabaseTableConfigUtil.getValue()).dismissAllowingStateLoss();
                                                    }
                                                });
                                                MissedCallOtpUIState.Success success = (MissedCallOtpUIState.Success) missedCallOtpUIState;
                                                Integer timeUntilNextAttempt = success.BuiltInFictitiousFunctionClassFactory.getTimeUntilNextAttempt();
                                                retryAndTimerView.setTimeUntilNextAttempt(timeUntilNextAttempt != null ? timeUntilNextAttempt.intValue() : 0);
                                                Integer remainingAttempts = success.BuiltInFictitiousFunctionClassFactory.getRemainingAttempts();
                                                retryAndTimerView.setRemainingAttempts(remainingAttempts != null ? remainingAttempts.intValue() : 0);
                                                retryAndTimerView.setupButton(RetryAndTimerView.ButtonState.COUNTDOWN_TIMER);
                                                VB vb2 = MissedCallOtpFragment.this.PlaceComponentResult;
                                                if (vb2 != 0) {
                                                    InputPhoneView inputPhoneView = ((FragmentMissedCallOtpBinding) vb2).PlaceComponentResult;
                                                    inputPhoneView.getInput().setText("");
                                                    String prefix = success.BuiltInFictitiousFunctionClassFactory.getPrefix();
                                                    inputPhoneView.setPrefixMissedCallOtp(prefix != null ? prefix : "", 2);
                                                    if (inputPhoneView == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                        return inputPhoneView;
                                                    }
                                                } else {
                                                    throw new IllegalArgumentException("Required value was null.".toString());
                                                }
                                            } else {
                                                throw new IllegalArgumentException("Required value was null.".toString());
                                            }
                                        } else if (missedCallOtpUIState instanceof MissedCallOtpUIState.TimeOut) {
                                            MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this).PlaceComponentResult();
                                            ((DanaLoadingDialogFragment) MissedCallOtpFragment.this.DatabaseTableConfigUtil.getValue()).dismissAllowingStateLoss();
                                            BottomInfoSnackbar scheduleImpl = MissedCallOtpFragment.scheduleImpl(MissedCallOtpFragment.this);
                                            MissedCallOtpFragment missedCallOtpFragment3 = MissedCallOtpFragment.this;
                                            scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
                                            String string = missedCallOtpFragment3.getString(R.string.general_error_message);
                                            Intrinsics.checkNotNullExpressionValue(string, "");
                                            Intrinsics.checkNotNullParameter(string, "");
                                            scheduleImpl.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(string);
                                            scheduleImpl.show();
                                        } else if (missedCallOtpUIState instanceof MissedCallOtpUIState.MaxAttemptsReached) {
                                            MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this).PlaceComponentResult();
                                            ((DanaLoadingDialogFragment) MissedCallOtpFragment.this.DatabaseTableConfigUtil.getValue()).dismissAllowingStateLoss();
                                            MissedCallOtpFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(MissedCallOtpFragment.this);
                                        } else if (missedCallOtpUIState instanceof MissedCallOtpUIState.Failed) {
                                            MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this).PlaceComponentResult();
                                            ((DanaLoadingDialogFragment) MissedCallOtpFragment.this.DatabaseTableConfigUtil.getValue()).dismissAllowingStateLoss();
                                            BottomInfoSnackbar scheduleImpl2 = MissedCallOtpFragment.scheduleImpl(MissedCallOtpFragment.this);
                                            scheduleImpl2.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
                                            Context context = scheduleImpl2.getContext();
                                            Intrinsics.checkNotNullExpressionValue(context, "");
                                            String authRequestContext = StringWrapperKt.getAuthRequestContext(context, ((MissedCallOtpUIState.Failed) missedCallOtpUIState).MyBillsEntityDataFactory);
                                            Intrinsics.checkNotNullParameter(authRequestContext, "");
                                            scheduleImpl2.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(authRequestContext);
                                            scheduleImpl2.show();
                                        } else if (missedCallOtpUIState instanceof MissedCallOtpUIState.FailedFirstTime) {
                                            MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this).PlaceComponentResult();
                                            ((DanaLoadingDialogFragment) MissedCallOtpFragment.this.DatabaseTableConfigUtil.getValue()).dismissAllowingStateLoss();
                                            BottomInfoSnackbar scheduleImpl3 = MissedCallOtpFragment.scheduleImpl(MissedCallOtpFragment.this);
                                            final MissedCallOtpFragment missedCallOtpFragment4 = MissedCallOtpFragment.this;
                                            scheduleImpl3.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
                                            Context context2 = scheduleImpl3.getContext();
                                            Intrinsics.checkNotNullExpressionValue(context2, "");
                                            String authRequestContext2 = StringWrapperKt.getAuthRequestContext(context2, ((MissedCallOtpUIState.FailedFirstTime) missedCallOtpUIState).getAuthRequestContext);
                                            Intrinsics.checkNotNullParameter(authRequestContext2, "");
                                            scheduleImpl3.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(authRequestContext2);
                                            scheduleImpl3.addCallback(new BaseTransientBottomBar.BaseCallback<BottomInfoSnackbar>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$observeUiState$1$1$1$5$1
                                                @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
                                                public final /* synthetic */ void onDismissed(BottomInfoSnackbar bottomInfoSnackbar, int i2) {
                                                    if (FragmentExtKt.PlaceComponentResult(MissedCallOtpFragment.this)) {
                                                        MissedCallOtpFragment.this.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0), TuplesKt.to("KEY_IS_ERROR", Boolean.TRUE)));
                                                    }
                                                }
                                            });
                                            scheduleImpl3.show();
                                        } else if (missedCallOtpUIState instanceof MissedCallOtpUIState.VerifyInvalidOtp) {
                                            MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this).PlaceComponentResult();
                                            BottomInfoSnackbar scheduleImpl4 = MissedCallOtpFragment.scheduleImpl(MissedCallOtpFragment.this);
                                            final MissedCallOtpFragment missedCallOtpFragment5 = MissedCallOtpFragment.this;
                                            missedCallOtpFragment5.MyBillsEntityDataFactory(new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$observeUiState$1$1$1$6$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
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
                                                    ((DanaLoadingDialogFragment) MissedCallOtpFragment.this.DatabaseTableConfigUtil.getValue()).dismissAllowingStateLoss();
                                                }
                                            });
                                            MissedCallOtpFragment.MyBillsEntityDataFactory(missedCallOtpFragment5);
                                            scheduleImpl4.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
                                            Context context3 = scheduleImpl4.getContext();
                                            Intrinsics.checkNotNullExpressionValue(context3, "");
                                            String authRequestContext3 = StringWrapperKt.getAuthRequestContext(context3, ((MissedCallOtpUIState.VerifyInvalidOtp) missedCallOtpUIState).KClassImpl$Data$declaredNonStaticMembers$2);
                                            Intrinsics.checkNotNullParameter(authRequestContext3, "");
                                            scheduleImpl4.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(authRequestContext3);
                                            scheduleImpl4.show();
                                            VB vb3 = MissedCallOtpFragment.this.PlaceComponentResult;
                                            if (vb3 != 0) {
                                                ((FragmentMissedCallOtpBinding) vb3).PlaceComponentResult.setErrorViewV2();
                                            } else {
                                                throw new IllegalArgumentException("Required value was null.".toString());
                                            }
                                        } else if (missedCallOtpUIState instanceof MissedCallOtpUIState.VerifyFailed) {
                                            MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this).PlaceComponentResult();
                                            ((DanaLoadingDialogFragment) MissedCallOtpFragment.this.DatabaseTableConfigUtil.getValue()).dismissAllowingStateLoss();
                                            BottomInfoSnackbar scheduleImpl5 = MissedCallOtpFragment.scheduleImpl(MissedCallOtpFragment.this);
                                            MissedCallOtpFragment.this.MyBillsEntityDataFactory(
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x026f: INVOKE 
                                                  (wrap: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment : 0x026d: IGET 
                                                  (r6v0 'this' id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$observeUiState$1$1$1<T> A[IMMUTABLE_TYPE, THIS])
                                                 A[WRAPPED] id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment.observeUiState.1.1.1.MyBillsEntityDataFactory id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment)
                                                  (wrap: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$showKeyboard$1 : 0x0000: SGET  A[WRAPPED] (LINE:521) id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$showKeyboard$1.INSTANCE id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$showKeyboard$1)
                                                 type: DIRECT call: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment.MyBillsEntityDataFactory(kotlin.jvm.functions.Function0):void A[MD:(kotlin.jvm.functions.Function0<kotlin.Unit>):void (m)] (LINE:521) in method: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment.observeUiState.1.1.1.getAuthRequestContext(id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpUIState, kotlin.coroutines.Continuation<? super kotlin.Unit>):java.lang.Object, file: classes5.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$showKeyboard$1, state: NOT_LOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                                                	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                                                	... 59 more
                                                */
                                            /*
                                                Method dump skipped, instructions count: 867
                                                To view this dump change 'Code comments level' option to 'DEBUG'
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$observeUiState$1.AnonymousClass1.C01791.emit(id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpUIState, kotlin.coroutines.Continuation):java.lang.Object");
                                        }
                                    }, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else if (i == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                throw new KotlinNothingValueException();
                            }
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (RepeatOnLifecycleKt.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0, Lifecycle.State.STARTED, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }
