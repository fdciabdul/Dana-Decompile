package id.dana.feeds.data.username.source.network;

import id.dana.feeds.data.username.source.network.request.CheckUsernameRequest;
import id.dana.feeds.data.username.source.network.response.CheckUsernameResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/feeds/data/username/source/network/response/CheckUsernameResult;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.feeds.data.username.source.network.NetworkUserProfileEntityData$checkUsername$1", f = "NetworkUserProfileEntityData.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class NetworkUserProfileEntityData$checkUsername$1 extends SuspendLambda implements Function2<FlowCollector<? super CheckUsernameResult>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $username;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetworkUserProfileEntityData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkUserProfileEntityData$checkUsername$1(String str, NetworkUserProfileEntityData networkUserProfileEntityData, Continuation<? super NetworkUserProfileEntityData$checkUsername$1> continuation) {
        super(2, continuation);
        this.$username = str;
        this.this$0 = networkUserProfileEntityData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NetworkUserProfileEntityData$checkUsername$1 networkUserProfileEntityData$checkUsername$1 = new NetworkUserProfileEntityData$checkUsername$1(this.$username, this.this$0, continuation);
        networkUserProfileEntityData$checkUsername$1.L$0 = obj;
        return networkUserProfileEntityData$checkUsername$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super CheckUsernameResult> flowCollector, Continuation<? super Unit> continuation) {
        return ((NetworkUserProfileEntityData$checkUsername$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserProfileService castedFacade;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            CheckUsernameRequest checkUsernameRequest = new CheckUsernameRequest(this.$username);
            castedFacade = this.this$0.getCastedFacade();
            this.label = 1;
            if (flowCollector.emit(castedFacade.checkUsername(checkUsernameRequest), this) == coroutine_suspended) {
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
