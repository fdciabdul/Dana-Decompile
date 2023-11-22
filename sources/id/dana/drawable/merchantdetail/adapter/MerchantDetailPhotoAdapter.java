package id.dana.drawable.merchantdetail.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.merchantbanner.MerchantBannerView;
import id.dana.drawable.model.MerchantBannerItemModel;
import id.dana.nearbyme.model.ShopModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\u00020\u000f8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0014X\u0087\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantDetailPhotoAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantDetailPhotoAdapter$MerchantCarouselPhotoViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantBannerItemModel;", "", "getItemCount", "()I", "p0", "p1", "", "getAuthRequestContext", "(Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantDetailPhotoAdapter$MerchantCarouselPhotoViewHolder;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "BuiltInFictitiousFunctionClassFactory", "", "MyBillsEntityDataFactory", "Z", "()Z", "PlaceComponentResult", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantDetailPhotoAdapter$Listener;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantDetailPhotoAdapter$Listener;", "Lid/dana/nearbyme/model/ShopModel;", "Lid/dana/nearbyme/model/ShopModel;", "<init>", "()V", "Listener", "MerchantCarouselPhotoViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDetailPhotoAdapter extends BaseRecyclerViewAdapter<MerchantCarouselPhotoViewHolder, MerchantBannerItemModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Listener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public ShopModel getAuthRequestContext = new ShopModel();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean PlaceComponentResult = true;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantDetailPhotoAdapter$Listener;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Listener {
        void BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new MerchantCarouselPhotoViewHolder(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        MerchantCarouselPhotoViewHolder merchantCarouselPhotoViewHolder = (MerchantCarouselPhotoViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(merchantCarouselPhotoViewHolder, "");
        ShopModel shopModel = merchantCarouselPhotoViewHolder.BuiltInFictitiousFunctionClassFactory;
        Integer num = null;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        String str = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
        if (str == null || str.length() == 0) {
            num = 0;
        } else {
            MerchantBannerView merchantBannerView = (MerchantBannerView) merchantCarouselPhotoViewHolder.itemView.findViewById(R.id.tryNextTokenChar);
            if (merchantBannerView != null) {
                num = Integer.valueOf(merchantBannerView.getCurrentPos());
            }
        }
        this.BuiltInFictitiousFunctionClassFactory = num != null ? num.intValue() : 0;
        super.onViewDetachedFromWindow(merchantCarouselPhotoViewHolder);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [id.dana.nearbyrevamp.model.MerchantBannerItemModel$State, kotlin.jvm.internal.DefaultConstructorMarker] */
    public MerchantDetailPhotoAdapter() {
        ?? r3 = 0;
        setItems(CollectionsKt.mutableListOf(new MerchantBannerItemModel(r3, 1, r3)));
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // id.dana.base.BaseRecyclerViewAdapter
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(MerchantCarouselPhotoViewHolder p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ShopModel shopModel = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(shopModel, "");
        p0.BuiltInFictitiousFunctionClassFactory = shopModel;
        p0.MyBillsEntityDataFactory = this.PlaceComponentResult;
        p0.getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2;
        p0.KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory;
        super.onBindViewHolder((MerchantDetailPhotoAdapter) p0, p1);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0006\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0012\u0010\b\u001a\u00020\u000eX\u0086\"¢\u0006\u0006\n\u0004\b\r\u0010\u000f"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantDetailPhotoAdapter$MerchantCarouselPhotoViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantBannerItemModel;", "", "PlaceComponentResult", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "", "BuiltInFictitiousFunctionClassFactory", "Z", "MyBillsEntityDataFactory", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantDetailPhotoAdapter$Listener;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantDetailPhotoAdapter$Listener;", "getAuthRequestContext", "Lid/dana/nearbyme/model/ShopModel;", "Lid/dana/nearbyme/model/ShopModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantCarouselPhotoViewHolder extends BaseRecyclerViewHolder<MerchantBannerItemModel> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        boolean MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        Listener getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public ShopModel BuiltInFictitiousFunctionClassFactory;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] MyBillsEntityDataFactory;

            static {
                int[] iArr = new int[MerchantBannerItemModel.State.values().length];
                iArr[MerchantBannerItemModel.State.SHIMMERING.ordinal()] = 1;
                iArr[MerchantBannerItemModel.State.LOADED.ordinal()] = 2;
                MyBillsEntityDataFactory = iArr;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:74:0x0109  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x010b  */
        @Override // id.dana.base.BaseRecyclerViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final /* synthetic */ void bindData(id.dana.drawable.model.MerchantBannerItemModel r9) {
            /*
                Method dump skipped, instructions count: 448
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyrevamp.merchantdetail.adapter.MerchantDetailPhotoAdapter.MerchantCarouselPhotoViewHolder.bindData(java.lang.Object):void");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantCarouselPhotoViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_merchant_carousel, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.MyBillsEntityDataFactory = true;
        }
    }
}
