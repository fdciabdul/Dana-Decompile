package id.dana.sendmoney.domain.groupsend.interactor;

import id.dana.domain.uploadfiles.UploadFilesEntity;
import id.dana.domain.uploadfiles.UploadFilesRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.domain.groupsend.interactor.UploadGroupAvatar$buildUseCase$2", f = "UploadGroupAvatar.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class UploadGroupAvatar$buildUseCase$2 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ UploadFilesEntity $file;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UploadGroupAvatar this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadGroupAvatar$buildUseCase$2(UploadGroupAvatar uploadGroupAvatar, UploadFilesEntity uploadFilesEntity, Continuation<? super UploadGroupAvatar$buildUseCase$2> continuation) {
        super(2, continuation);
        this.this$0 = uploadGroupAvatar;
        this.$file = uploadFilesEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UploadGroupAvatar$buildUseCase$2 uploadGroupAvatar$buildUseCase$2 = new UploadGroupAvatar$buildUseCase$2(this.this$0, this.$file, continuation);
        uploadGroupAvatar$buildUseCase$2.L$0 = obj;
        return uploadGroupAvatar$buildUseCase$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
        return ((UploadGroupAvatar$buildUseCase$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UploadFilesRepository uploadFilesRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            uploadFilesRepository = this.this$0.PlaceComponentResult;
            this.label = 1;
            if (flowCollector.emit(uploadFilesRepository.uploadFiles(CollectionsKt.listOf(this.$file), "grouptransfer").blockingFirst().get(0).getContentUrl(), this) == coroutine_suspended) {
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
