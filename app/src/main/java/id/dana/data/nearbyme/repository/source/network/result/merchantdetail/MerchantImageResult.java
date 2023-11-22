package id.dana.data.nearbyme.repository.source.network.result.merchantdetail;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.nearbyme.model.MerchantImageEntity;
import id.dana.domain.nearbyme.model.MerchantImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005\"\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/data/nearbyme/model/MerchantImageEntity;", "component1", "()Ljava/util/List;", "images", "copy", "(Ljava/util/List;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/domain/nearbyme/model/MerchantImage;", "toMerchantImages", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getImages", "setImages", "(Ljava/util/List;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantImageResult extends BaseRpcResult {
    private List<MerchantImageEntity> images;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MerchantImageResult copy$default(MerchantImageResult merchantImageResult, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = merchantImageResult.images;
        }
        return merchantImageResult.copy(list);
    }

    public final List<MerchantImageEntity> component1() {
        return this.images;
    }

    public final MerchantImageResult copy(List<MerchantImageEntity> images) {
        Intrinsics.checkNotNullParameter(images, "");
        return new MerchantImageResult(images);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MerchantImageResult) && Intrinsics.areEqual(this.images, ((MerchantImageResult) other).images);
    }

    public final int hashCode() {
        return this.images.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantImageResult(images=");
        sb.append(this.images);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getImages")
    public final List<MerchantImageEntity> getImages() {
        return this.images;
    }

    @JvmName(name = "setImages")
    public final void setImages(List<MerchantImageEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.images = list;
    }

    public MerchantImageResult(List<MerchantImageEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.images = list;
    }

    public final List<MerchantImage> toMerchantImages() {
        List<MerchantImageEntity> list = this.images;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MerchantImageEntity) it.next()).toMerchantImage());
        }
        return arrayList;
    }
}
