package id.dana.data.nearbyme.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import id.dana.data.nearbyme.MerchantConfigEntityData;
import id.dana.data.nearbyme.model.MerchantConfigEntity;
import id.dana.data.nearbyme.model.MerchantDetailPromoConfigEntity;
import id.dana.data.storage.Serializer;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Singleton
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\f\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/data/nearbyme/repository/source/local/DefaultMerchantConfigEntityData;", "Lid/dana/data/nearbyme/MerchantConfigEntityData;", "", "", UserMetadata.KEYDATA_FILENAME, "", "default", "", "Lid/dana/data/nearbyme/model/MerchantConfigEntity;", "getMerchantDetailConfig", "([Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/model/MerchantDetailPromoConfigEntity;", "getMerchantDetailPromoConfigEntity", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultMerchantConfigEntityData implements MerchantConfigEntityData {
    private final Context context;
    private final Serializer serializer;

    @Inject
    public DefaultMerchantConfigEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.context = context;
        this.serializer = serializer;
    }

    @Override // id.dana.data.nearbyme.MerchantConfigEntityData
    public final Object getMerchantDetailConfig(String[] strArr, boolean z, Continuation<? super List<MerchantConfigEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new DefaultMerchantConfigEntityData$getMerchantDetailConfig$2(this, strArr, z, null), continuation);
    }

    @Override // id.dana.data.nearbyme.MerchantConfigEntityData
    public final Object getMerchantDetailPromoConfigEntity(Continuation<? super MerchantDetailPromoConfigEntity> continuation) {
        return new MerchantDetailPromoConfigEntity(false, 4);
    }
}
