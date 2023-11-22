package id.dana.merchantmanagement.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.merchantmanagement.model.LinkedMerchantModel;
import id.dana.merchantmanagement.view.viewholder.BannerViewHolder;
import id.dana.merchantmanagement.view.viewholder.MerchantItemViewHolder;
import id.dana.merchantmanagement.view.viewholder.MerchantSkeletonViewHolder;
import id.dana.merchantmanagement.view.viewholder.TitleListViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0007\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\u000eR\u0012\u0010\u0010\u001a\u00020\u000fX\u0086\"¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/merchantmanagement/adapter/MerchantManagementAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/merchantmanagement/model/LinkedMerchantModel;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/util/List;)V", "", "getItemViewType", "(I)I", "", "getAuthRequestContext", "()Z", "Lid/dana/merchantmanagement/adapter/LinkedMerchantClickListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/merchantmanagement/adapter/LinkedMerchantClickListener;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantManagementAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<LinkedMerchantModel>, LinkedMerchantModel> {
    public LinkedMerchantClickListener BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MerchantItemViewHolder merchantItemViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        LinkedMerchantClickListener linkedMerchantClickListener = null;
        if (i == 1) {
            LinkedMerchantClickListener linkedMerchantClickListener2 = this.BuiltInFictitiousFunctionClassFactory;
            if (linkedMerchantClickListener2 != null) {
                linkedMerchantClickListener = linkedMerchantClickListener2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            merchantItemViewHolder = new MerchantItemViewHolder(viewGroup, linkedMerchantClickListener, false, 4, null);
        } else if (i == 3) {
            merchantItemViewHolder = new TitleListViewHolder(viewGroup);
        } else if (i == 4) {
            LinkedMerchantClickListener linkedMerchantClickListener3 = this.BuiltInFictitiousFunctionClassFactory;
            if (linkedMerchantClickListener3 != null) {
                linkedMerchantClickListener = linkedMerchantClickListener3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            merchantItemViewHolder = new BannerViewHolder(viewGroup, linkedMerchantClickListener);
        } else if (i != 5) {
            merchantItemViewHolder = new MerchantSkeletonViewHolder(viewGroup);
        } else {
            LinkedMerchantClickListener linkedMerchantClickListener4 = this.BuiltInFictitiousFunctionClassFactory;
            if (linkedMerchantClickListener4 != null) {
                linkedMerchantClickListener = linkedMerchantClickListener4;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            merchantItemViewHolder = new MerchantItemViewHolder(viewGroup, linkedMerchantClickListener, true);
        }
        return merchantItemViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        if (getItems().get(p0).NetworkUserEntityData$$ExternalSyntheticLambda0.length() > 0) {
            return getItems().size() - 1 == p0 ? 5 : 1;
        } else if (getItems().get(p0).getErrorConfigVersion == 3) {
            return 3;
        } else {
            return getItems().get(p0).getErrorConfigVersion == 4 ? 4 : 2;
        }
    }

    public final void MyBillsEntityDataFactory(List<LinkedMerchantModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<LinkedMerchantModel> items = getItems();
        if (items != null) {
            items.addAll(p0);
        } else {
            setItems(p0);
        }
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean MyBillsEntityDataFactory() {
        /*
            r6 = this;
            java.util.List r0 = r6.getItems()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L3a
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L18
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L18
            goto L38
        L18:
            java.util.Iterator r0 = r0.iterator()
        L1c:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L38
            java.lang.Object r3 = r0.next()
            id.dana.merchantmanagement.model.LinkedMerchantModel r3 = (id.dana.merchantmanagement.model.LinkedMerchantModel) r3
            int r4 = r3.getErrorConfigVersion
            r5 = 3
            if (r4 == r5) goto L34
            int r3 = r3.getErrorConfigVersion
            r4 = 4
            if (r3 == r4) goto L34
            r3 = 0
            goto L35
        L34:
            r3 = 1
        L35:
            if (r3 == 0) goto L1c
            goto L3a
        L38:
            r0 = 0
            goto L3b
        L3a:
            r0 = 1
        L3b:
            if (r0 == 0) goto L71
            java.util.List r0 = r6.getItems()
            if (r0 == 0) goto L6d
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L52
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L6d
        L52:
            java.util.Iterator r0 = r0.iterator()
        L56:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L6d
            java.lang.Object r3 = r0.next()
            id.dana.merchantmanagement.model.LinkedMerchantModel r3 = (id.dana.merchantmanagement.model.LinkedMerchantModel) r3
            int r3 = r3.getErrorConfigVersion
            if (r3 != r2) goto L68
            r3 = 1
            goto L69
        L68:
            r3 = 0
        L69:
            if (r3 == 0) goto L56
            r0 = 0
            goto L6e
        L6d:
            r0 = 1
        L6e:
            if (r0 == 0) goto L71
            r1 = 1
        L71:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.merchantmanagement.adapter.MerchantManagementAdapter.MyBillsEntityDataFactory():boolean");
    }

    public final boolean getAuthRequestContext() {
        return getItems().get(1).getErrorConfigVersion != 4;
    }
}
