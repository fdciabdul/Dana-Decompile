package id.dana.mybills.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequests;
import id.dana.mybills.databinding.ItemBillsRecentTransactionV2Binding;
import id.dana.mybills.ui.model.BizProductModel;
import id.dana.mybills.ui.model.MyBillsServiceModel;
import id.dana.mybills.ui.model.MyBillsServiceModelKt;
import id.dana.mybills.ui.viewholder.QuickBuyBillsViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001e\u0010\f\u001a\f\u0012\b\u0012\u0006*\u00020\u000b0\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/mybills/ui/adapter/QuickBuyBillsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/mybills/ui/viewholder/QuickBuyBillsViewHolder;", "", "getItemCount", "()I", "Lid/dana/mybills/ui/adapter/QuickBuyBillsAdapter$diffCallBack$1;", "PlaceComponentResult", "Lid/dana/mybills/ui/adapter/QuickBuyBillsAdapter$diffCallBack$1;", "MyBillsEntityDataFactory", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lid/dana/mybills/ui/model/BizProductModel;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lid/dana/mybills/ui/viewholder/QuickBuyBillsViewHolder$OnQuickBuyBillsClickCallback;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/ui/viewholder/QuickBuyBillsViewHolder$OnQuickBuyBillsClickCallback;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class QuickBuyBillsAdapter extends RecyclerView.Adapter<QuickBuyBillsViewHolder> {
    public final AsyncListDiffer<BizProductModel> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public QuickBuyBillsViewHolder.OnQuickBuyBillsClickCallback getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final QuickBuyBillsAdapter$diffCallBack$1 MyBillsEntityDataFactory;

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.mybills.ui.adapter.QuickBuyBillsAdapter$diffCallBack$1] */
    public QuickBuyBillsAdapter() {
        ?? r0 = new DiffUtil.ItemCallback<BizProductModel>() { // from class: id.dana.mybills.ui.adapter.QuickBuyBillsAdapter$diffCallBack$1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(BizProductModel bizProductModel, BizProductModel bizProductModel2) {
                return PlaceComponentResult(bizProductModel, bizProductModel2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public final /* synthetic */ boolean getAuthRequestContext(BizProductModel bizProductModel, BizProductModel bizProductModel2) {
                return MyBillsEntityDataFactory(bizProductModel, bizProductModel2);
            }

            private static boolean MyBillsEntityDataFactory(BizProductModel p0, BizProductModel p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                return Intrinsics.areEqual(p0.getBizId(), p1.getBizId());
            }

            private static boolean PlaceComponentResult(BizProductModel p0, BizProductModel p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                return Intrinsics.areEqual(p0, p1);
            }
        };
        this.MyBillsEntityDataFactory = r0;
        this.BuiltInFictitiousFunctionClassFactory = new AsyncListDiffer<>(this, (DiffUtil.ItemCallback) r0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(QuickBuyBillsViewHolder quickBuyBillsViewHolder, int i) {
        final QuickBuyBillsViewHolder quickBuyBillsViewHolder2 = quickBuyBillsViewHolder;
        Intrinsics.checkNotNullParameter(quickBuyBillsViewHolder2, "");
        List<BizProductModel> list = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(list, "");
        final BizProductModel bizProductModel = list.get(i);
        if (bizProductModel != null) {
            ItemBillsRecentTransactionV2Binding itemBillsRecentTransactionV2Binding = quickBuyBillsViewHolder2.getAuthRequestContext;
            GlideRequests authRequestContext = GlideApp.getAuthRequestContext(itemBillsRecentTransactionV2Binding.MyBillsEntityDataFactory.getContext());
            MyBillsServiceModel serviceModel = bizProductModel.getServiceModel();
            String str = null;
            authRequestContext.PlaceComponentResult(serviceModel != null ? serviceModel.getIcon() : null).SubSequence().MyBillsEntityDataFactory((ImageView) itemBillsRecentTransactionV2Binding.BuiltInFictitiousFunctionClassFactory);
            itemBillsRecentTransactionV2Binding.KClassImpl$Data$declaredNonStaticMembers$2.setText(bizProductModel.getBizId());
            TextView textView = itemBillsRecentTransactionV2Binding.moveToNextValue;
            MyBillsServiceModel serviceModel2 = bizProductModel.getServiceModel();
            if (serviceModel2 != null) {
                Context context = quickBuyBillsViewHolder2.getAuthRequestContext.MyBillsEntityDataFactory.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "");
                String localizedName = MyBillsServiceModelKt.getLocalizedName(serviceModel2, context);
                if (localizedName != null) {
                    String str2 = localizedName;
                    if (str2.length() == 0) {
                        str2 = bizProductModel.getProviderName();
                    }
                    str = str2;
                }
            }
            textView.setText(str);
            TextView textView2 = itemBillsRecentTransactionV2Binding.PlaceComponentResult;
            String customerName = bizProductModel.getCustomerName();
            if (customerName.length() == 0) {
                customerName = bizProductModel.getGoodsTitle();
            }
            textView2.setText(customerName);
            itemBillsRecentTransactionV2Binding.getAuthRequestContext.setText(bizProductModel.getDenom().getDisplayAmount());
            itemBillsRecentTransactionV2Binding.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.viewholder.QuickBuyBillsViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuickBuyBillsViewHolder.BuiltInFictitiousFunctionClassFactory(QuickBuyBillsViewHolder.this, bizProductModel);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ QuickBuyBillsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemBillsRecentTransactionV2Binding MyBillsEntityDataFactory = ItemBillsRecentTransactionV2Binding.MyBillsEntityDataFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        QuickBuyBillsViewHolder.OnQuickBuyBillsClickCallback onQuickBuyBillsClickCallback = this.getAuthRequestContext;
        if (onQuickBuyBillsClickCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onQuickBuyBillsClickCallback = null;
        }
        return new QuickBuyBillsViewHolder(MyBillsEntityDataFactory, onQuickBuyBillsClickCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        List<BizProductModel> list = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(list, "");
        return list.size();
    }
}
