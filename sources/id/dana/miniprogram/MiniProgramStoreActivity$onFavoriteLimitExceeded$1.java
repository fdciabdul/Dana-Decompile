package id.dana.miniprogram;

import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.domain.miniprogram.model.MiniProgram;
import id.dana.miniprogram.adapter.AllMiniProgramsAdapter;
import id.dana.miniprogram.view.FavoriteButton;
import id.dana.miniprogram.view.SectionView;
import java.util.Iterator;
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
@DebugMetadata(c = "id.dana.miniprogram.MiniProgramStoreActivity$onFavoriteLimitExceeded$1", f = "MiniProgramStoreActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
final class MiniProgramStoreActivity$onFavoriteLimitExceeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    int label;
    final /* synthetic */ MiniProgramStoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniProgramStoreActivity$onFavoriteLimitExceeded$1(MiniProgramStoreActivity miniProgramStoreActivity, String str, Continuation<? super MiniProgramStoreActivity$onFavoriteLimitExceeded$1> continuation) {
        super(2, continuation);
        this.this$0 = miniProgramStoreActivity;
        this.$appId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniProgramStoreActivity$onFavoriteLimitExceeded$1(this.this$0, this.$appId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniProgramStoreActivity$onFavoriteLimitExceeded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AllMiniProgramsAdapter allMiniProgramsAdapter;
        CoroutineScope coroutineScope;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            allMiniProgramsAdapter = this.this$0.MyBillsEntityDataFactory;
            if (allMiniProgramsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                allMiniProgramsAdapter = null;
            }
            List<MiniProgram> items = allMiniProgramsAdapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            String str = this.$appId;
            int i = 0;
            Iterator<MiniProgram> it = items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().getAppId(), str)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                coroutineScope = this.this$0.scheduleImpl;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.this$0, i, null), 3, null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.miniprogram.MiniProgramStoreActivity$onFavoriteLimitExceeded$1$1", f = "MiniProgramStoreActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.miniprogram.MiniProgramStoreActivity$onFavoriteLimitExceeded$1$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $position;
        int label;
        final /* synthetic */ MiniProgramStoreActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MiniProgramStoreActivity miniProgramStoreActivity, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = miniProgramStoreActivity;
            this.$position = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$position, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((RecyclerView) ((SectionView) this.this$0._$_findCachedViewById(R.id.res_0x7f0a11f8_getenableexpresspayinfo_lambda_21))._$_findCachedViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator)).findViewHolderForAdapterPosition(this.$position);
                if (findViewHolderForAdapterPosition == null) {
                    return Unit.INSTANCE;
                }
                ((FavoriteButton) findViewHolderForAdapterPosition.itemView.findViewById(R.id.btnFavorite)).setState(false);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
