package id.dana.data.nearbyme.repository.source.local;

import android.content.Context;
import id.dana.data.config.source.split.DefaultJsonPath;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.nearbyme.model.MerchantConfigEntity;
import id.dana.data.storage.Serializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lid/dana/data/nearbyme/model/MerchantConfigEntity;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.data.nearbyme.repository.source.local.DefaultMerchantConfigEntityData$getMerchantDetailConfig$2", f = "DefaultMerchantConfigEntityData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class DefaultMerchantConfigEntityData$getMerchantDetailConfig$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MerchantConfigEntity>>, Object> {
    final /* synthetic */ boolean $default;
    final /* synthetic */ String[] $keys;
    int label;
    final /* synthetic */ DefaultMerchantConfigEntityData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultMerchantConfigEntityData$getMerchantDetailConfig$2(DefaultMerchantConfigEntityData defaultMerchantConfigEntityData, String[] strArr, boolean z, Continuation<? super DefaultMerchantConfigEntityData$getMerchantDetailConfig$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultMerchantConfigEntityData;
        this.$keys = strArr;
        this.$default = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultMerchantConfigEntityData$getMerchantDetailConfig$2(this.this$0, this.$keys, this.$default, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends MerchantConfigEntity>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<MerchantConfigEntity>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<MerchantConfigEntity>> continuation) {
        return ((DefaultMerchantConfigEntityData$getMerchantDetailConfig$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context context;
        Serializer serializer;
        MerchantConfigEntity merchantConfigEntity;
        Serializer serializer2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            context = this.this$0.context;
            String PlaceComponentResult = JsonUtil.PlaceComponentResult(context, DefaultJsonPath.DEFAULT_NEARBY_MERCHANT_CONFIG);
            if (PlaceComponentResult != null) {
                DefaultMerchantConfigEntityData defaultMerchantConfigEntityData = this.this$0;
                String[] strArr = this.$keys;
                boolean z = this.$default;
                serializer = defaultMerchantConfigEntityData.serializer;
                Map<String, String> deserializeMap = serializer.deserializeMap(PlaceComponentResult);
                Intrinsics.checkNotNullExpressionValue(deserializeMap, "");
                Map map = MapsKt.toMap(deserializeMap);
                ArrayList arrayList = new ArrayList(strArr.length);
                for (String str : strArr) {
                    String str2 = (String) map.get(str);
                    if (str2 != null) {
                        serializer2 = defaultMerchantConfigEntityData.serializer;
                        merchantConfigEntity = (MerchantConfigEntity) serializer2.deserialize(str2, MerchantConfigEntity.class);
                    } else {
                        merchantConfigEntity = null;
                    }
                    if (merchantConfigEntity == null) {
                        merchantConfigEntity = new MerchantConfigEntity(z);
                    }
                    arrayList.add(merchantConfigEntity);
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
