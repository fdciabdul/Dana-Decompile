package id.dana.data.nearbyme.repository.source.split;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import id.dana.data.nearbyme.MerchantConfigEntityData;
import id.dana.data.nearbyme.model.MerchantConfigEntity;
import id.dana.data.toggle.SplitFacade;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Singleton
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\f\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/data/nearbyme/repository/source/split/SplitMerchantConfigEntity;", "Lid/dana/data/nearbyme/MerchantConfigEntityData;", "", "", UserMetadata.KEYDATA_FILENAME, "", "default", "", "Lid/dana/data/nearbyme/model/MerchantConfigEntity;", "getMerchantDetailConfig", "([Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/model/MerchantDetailPromoConfigEntity;", "getMerchantDetailPromoConfigEntity", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitMerchantConfigEntity implements MerchantConfigEntityData {
    private final SplitFacade splitFacade;

    @Inject
    public SplitMerchantConfigEntity(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @Override // id.dana.data.nearbyme.MerchantConfigEntityData
    public final Object getMerchantDetailConfig(String[] strArr, boolean z, Continuation<? super List<MerchantConfigEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new SplitMerchantConfigEntity$getMerchantDetailConfig$2(this, strArr, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // id.dana.data.nearbyme.MerchantConfigEntityData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMerchantDetailPromoConfigEntity(kotlin.coroutines.Continuation<? super id.dana.data.nearbyme.model.MerchantDetailPromoConfigEntity> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$1
            if (r0 == 0) goto L14
            r0 = r6
            id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$1 r0 = (id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$1 r0 = new id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2 r2 = new id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$2
            r4 = 0
            r2.<init>(r5, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity.getMerchantDetailPromoConfigEntity(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
