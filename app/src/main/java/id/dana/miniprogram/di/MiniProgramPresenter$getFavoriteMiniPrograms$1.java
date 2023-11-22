package id.dana.miniprogram.di;

import id.dana.domain.miniprogram.model.MiniProgram;
import id.dana.miniprogram.di.MiniProgramContract;
import java.util.ArrayList;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.miniprogram.di.MiniProgramPresenter$getFavoriteMiniPrograms$1", f = "MiniProgramPresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class MiniProgramPresenter$getFavoriteMiniPrograms$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<MiniProgram> $miniPrograms;
    int label;
    final /* synthetic */ MiniProgramPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniProgramPresenter$getFavoriteMiniPrograms$1(List<MiniProgram> list, MiniProgramPresenter miniProgramPresenter, Continuation<? super MiniProgramPresenter$getFavoriteMiniPrograms$1> continuation) {
        super(2, continuation);
        this.$miniPrograms = list;
        this.this$0 = miniProgramPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniProgramPresenter$getFavoriteMiniPrograms$1(this.$miniPrograms, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniProgramPresenter$getFavoriteMiniPrograms$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<MiniProgram> list = this.$miniPrograms;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (((MiniProgram) obj2).isFavorite()) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = arrayList;
            CoroutineScope coroutineScope2 = this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (coroutineScope2 != null) {
                coroutineScope = coroutineScope2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                coroutineScope = null;
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.this$0, arrayList2, null), 3, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.miniprogram.di.MiniProgramPresenter$getFavoriteMiniPrograms$1$1", f = "MiniProgramPresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.miniprogram.di.MiniProgramPresenter$getFavoriteMiniPrograms$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<MiniProgram> $favoriteMiniPrograms;
        int label;
        final /* synthetic */ MiniProgramPresenter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MiniProgramPresenter miniProgramPresenter, List<MiniProgram> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = miniProgramPresenter;
            this.$favoriteMiniPrograms = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$favoriteMiniPrograms, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MiniProgramContract.View view;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                view = this.this$0.PlaceComponentResult;
                view.onLoadFavoriteMiniPrograms(this.$favoriteMiniPrograms);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
