package id.dana.sendmoney.ui.groupsend.recipient.activity;

import androidx.paging.AsyncPagingDataDiffer;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import id.dana.core.ui.util.NumberUtil;
import id.dana.sendmoney.ui.groupsend.recipient.adapter.RecipientAdapter;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$initFlowRecipientAdapter$1", f = "GroupRecipientActivity.kt", i = {}, l = {555}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class GroupRecipientActivity$initFlowRecipientAdapter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GroupRecipientActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupRecipientActivity$initFlowRecipientAdapter$1(GroupRecipientActivity groupRecipientActivity, Continuation<? super GroupRecipientActivity$initFlowRecipientAdapter$1> continuation) {
        super(2, continuation);
        this.this$0 = groupRecipientActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupRecipientActivity$initFlowRecipientAdapter$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GroupRecipientActivity$initFlowRecipientAdapter$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Landroidx/paging/PagingData;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$initFlowRecipientAdapter$1$1", f = "GroupRecipientActivity.kt", i = {}, l = {564}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$initFlowRecipientAdapter$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PagingData<RecipientViewModel>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ GroupRecipientActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GroupRecipientActivity groupRecipientActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = groupRecipientActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PagingData<RecipientViewModel> pagingData, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pagingData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "contact", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        @DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$initFlowRecipientAdapter$1$1$1", f = "GroupRecipientActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$initFlowRecipientAdapter$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C01931 extends SuspendLambda implements Function2<RecipientViewModel, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ GroupRecipientActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01931(GroupRecipientActivity groupRecipientActivity, Continuation<? super C01931> continuation) {
                super(2, continuation);
                this.this$0 = groupRecipientActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01931 c01931 = new C01931(this.this$0, continuation);
                c01931.L$0 = obj;
                return c01931;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(RecipientViewModel recipientViewModel, Continuation<? super Unit> continuation) {
                return ((C01931) create(recipientViewModel, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                List list;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    RecipientViewModel recipientViewModel = (RecipientViewModel) this.L$0;
                    list = this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda4;
                    NumberUtil numberUtil = NumberUtil.INSTANCE;
                    String str = recipientViewModel.DatabaseTableConfigUtil;
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    if (list.contains(NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str))) {
                        recipientViewModel.lookAheadTest = true;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            RecipientAdapter recipientAdapter;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PagingData pagingData = (PagingData) this.L$0;
                RecipientAdapter recipientAdapter2 = null;
                PagingDataTransforms.PlaceComponentResult(pagingData, new C01931(this.this$0, null));
                recipientAdapter = this.this$0.isLayoutRequested;
                if (recipientAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    recipientAdapter2 = recipientAdapter;
                }
                this.label = 1;
                AsyncPagingDataDiffer<T> asyncPagingDataDiffer = recipientAdapter2.getAuthRequestContext;
                asyncPagingDataDiffer.lookAheadTest.incrementAndGet();
                Object BuiltInFictitiousFunctionClassFactory = asyncPagingDataDiffer.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(pagingData, this);
                if (BuiltInFictitiousFunctionClassFactory != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    BuiltInFictitiousFunctionClassFactory = Unit.INSTANCE;
                }
                if (BuiltInFictitiousFunctionClassFactory != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    BuiltInFictitiousFunctionClassFactory = Unit.INSTANCE;
                }
                if (BuiltInFictitiousFunctionClassFactory == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.MyBillsEntityDataFactory();
            this.this$0.lookAheadTest();
            this.this$0.BuiltInFictitiousFunctionClassFactory();
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<PagingData<RecipientViewModel>> flow = GroupRecipientActivity.access$getVm(this.this$0).GetContactSyncConfig;
            if (flow == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                flow = null;
            }
            this.label = 1;
            if (FlowKt.collectLatest(flow, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
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
