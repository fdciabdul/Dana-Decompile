package id.dana.data.nearbyme;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import id.dana.data.nearbyme.model.MerchantConfigEntity;
import id.dana.data.nearbyme.model.MerchantDetailPromoConfigEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\f\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/nearbyme/MerchantConfigEntityData;", "", "", "", UserMetadata.KEYDATA_FILENAME, "", "default", "", "Lid/dana/data/nearbyme/model/MerchantConfigEntity;", "getMerchantDetailConfig", "([Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/model/MerchantDetailPromoConfigEntity;", "getMerchantDetailPromoConfigEntity", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MerchantConfigEntityData {
    Object getMerchantDetailConfig(String[] strArr, boolean z, Continuation<? super List<MerchantConfigEntity>> continuation);

    Object getMerchantDetailPromoConfigEntity(Continuation<? super MerchantDetailPromoConfigEntity> continuation);
}
