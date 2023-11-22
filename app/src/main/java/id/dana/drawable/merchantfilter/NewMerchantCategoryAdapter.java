package id.dana.drawable.merchantfilter;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.android.material.chip.Chip;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.merchantfilter.NewMerchantCategoryAdapter;
import id.dana.nearbyme.MerchantViewType;
import id.dana.nearbyme.OnCategoryCheckedListener;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.utils.ResourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u0012\u0012\b\u0012\u00060\u0002R\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0001:\u0003#$%B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\f¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0018\u001a\u0006*\u00020\u00030\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u001dR\u0014\u0010 \u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/nearbyrevamp/merchantfilter/NewMerchantCategoryAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/nearbyrevamp/merchantfilter/NewMerchantCategoryAdapter$MerchantCategoryViewHolder;", "Lid/dana/nearbyme/model/MerchantCategoryModel;", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(I)Lid/dana/nearbyme/model/MerchantCategoryModel;", "getItemCount", "()I", "getItemViewType", "(I)I", "", "MyBillsEntityDataFactory", "()Z", "", "(Lid/dana/nearbyme/model/MerchantCategoryModel;)V", "", "setItems", "(Ljava/util/List;)V", "", "getAuthRequestContext", "Ljava/util/Set;", "Lid/dana/nearbyme/model/MerchantCategoryModel;", "PlaceComponentResult", "I", "Lid/dana/nearbyme/OnCategoryCheckedListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/OnCategoryCheckedListener;", "Ljava/util/List;", "moveToNextValue", "Z", "getErrorConfigVersion", "<init>", "(Z)V", "DefaultSelectedMerchantCategoryViewHolder", "MerchantCategoryViewHolder", "MerchantCategoryViewType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewMerchantCategoryAdapter extends BaseRecyclerViewAdapter<MerchantCategoryViewHolder, MerchantCategoryModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final MerchantCategoryModel PlaceComponentResult;
    OnCategoryCheckedListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final List<MerchantCategoryModel> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final Set<MerchantCategoryModel> MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final boolean getErrorConfigVersion;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MerchantCategoryViewHolder merchantCategoryViewHolder = (MerchantCategoryViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(merchantCategoryViewHolder, "");
        super.onBindViewHolder((NewMerchantCategoryAdapter) merchantCategoryViewHolder, i);
        merchantCategoryViewHolder.bindData(getItem(i));
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final /* synthetic */ void onBindViewHolder(MerchantCategoryViewHolder merchantCategoryViewHolder, int i) {
        MerchantCategoryViewHolder merchantCategoryViewHolder2 = merchantCategoryViewHolder;
        Intrinsics.checkNotNullParameter(merchantCategoryViewHolder2, "");
        super.onBindViewHolder((NewMerchantCategoryAdapter) merchantCategoryViewHolder2, i);
        merchantCategoryViewHolder2.bindData(getItem(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        DefaultSelectedMerchantCategoryViewHolder merchantCategoryViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == MerchantCategoryViewType.DEFAULT_SELECTED_CATEGORY.getType()) {
            merchantCategoryViewHolder = new DefaultSelectedMerchantCategoryViewHolder(this, viewGroup);
        } else if (i == MerchantCategoryViewType.NORMAL_TYPE_CATEGORY.getType()) {
            merchantCategoryViewHolder = new MerchantCategoryViewHolder(this, viewGroup);
        } else {
            merchantCategoryViewHolder = new MerchantCategoryViewHolder(this, viewGroup);
        }
        return merchantCategoryViewHolder;
    }

    public NewMerchantCategoryAdapter(boolean z) {
        this.getErrorConfigVersion = z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.MyBillsEntityDataFactory = linkedHashSet;
        this.getAuthRequestContext = new ArrayList();
        MerchantCategoryModel merchantCategoryModel = MerchantCategoryModel.BuiltInFictitiousFunctionClassFactory;
        this.PlaceComponentResult = merchantCategoryModel;
        if (z) {
            Intrinsics.checkNotNullExpressionValue(merchantCategoryModel, "");
            linkedHashSet.add(merchantCategoryModel);
        }
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void setItems(List<MerchantCategoryModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.clear();
        this.getAuthRequestContext.addAll(p0);
        if (!this.MyBillsEntityDataFactory.contains(this.PlaceComponentResult) && this.MyBillsEntityDataFactory.size() > 0) {
            p0.removeAll(this.MyBillsEntityDataFactory);
            p0.addAll(0, this.MyBillsEntityDataFactory);
        }
        super.setItems(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // id.dana.base.BaseRecyclerViewAdapter
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public MerchantCategoryModel getItem(int p0) {
        if (this.getErrorConfigVersion) {
            return p0 == 0 ? this.PlaceComponentResult : (MerchantCategoryModel) super.getItem(p0 - 1);
        }
        return (MerchantCategoryModel) super.getItem(p0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        if (getItem(p0) == this.PlaceComponentResult) {
            return MerchantCategoryViewType.DEFAULT_SELECTED_CATEGORY.getType();
        }
        return MerchantCategoryViewType.NORMAL_TYPE_CATEGORY.getType();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getGetAuthRequestContext() {
        return super.getGetAuthRequestContext() + (MyBillsEntityDataFactory() ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory() {
        return this.PlaceComponentResult != null && this.getErrorConfigVersion;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0096\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0005\u0010\rJ\u0013\u0010\n\u001a\u00020\u0007*\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u0007*\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011"}, d2 = {"Lid/dana/nearbyrevamp/merchantfilter/NewMerchantCategoryAdapter$MerchantCategoryViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/MerchantCategoryModel;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/nearbyme/model/MerchantCategoryModel;)V", "", "p1", "Landroid/graphics/drawable/StateListDrawable;", "KClassImpl$Data$declaredNonStaticMembers$2", "(II)Landroid/graphics/drawable/StateListDrawable;", "", "(Lid/dana/nearbyme/model/MerchantCategoryModel;Z)V", "(Lid/dana/nearbyme/model/MerchantCategoryModel;)I", "getAuthRequestContext", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "<init>", "(Lid/dana/nearbyrevamp/merchantfilter/NewMerchantCategoryAdapter;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public class MerchantCategoryViewHolder extends BaseRecyclerViewHolder<MerchantCategoryModel> {
        final /* synthetic */ NewMerchantCategoryAdapter MyBillsEntityDataFactory;
        public final ViewGroup getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantCategoryViewHolder(NewMerchantCategoryAdapter newMerchantCategoryAdapter, ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_merchant_category, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.MyBillsEntityDataFactory = newMerchantCategoryAdapter;
            this.getAuthRequestContext = viewGroup;
        }

        @Override // id.dana.base.BaseRecyclerViewHolder
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
        public final void bindData(final MerchantCategoryModel p0) {
            String string;
            if (p0 != null) {
                NewMerchantCategoryAdapter newMerchantCategoryAdapter = this.MyBillsEntityDataFactory;
                Chip chip = (Chip) this.itemView.findViewById(R.id.f3431x461046d9);
                if (chip != null) {
                    Intrinsics.checkNotNullExpressionValue(chip, "");
                    if (Intrinsics.areEqual(p0.MyBillsEntityDataFactory, MerchantViewType.MERCHANT_CAT_ALL)) {
                        string = chip.getContext().getString(R.string.btnAllFilterMaps);
                    } else {
                        string = newMerchantCategoryAdapter.getErrorConfigVersion ? chip.getContext().getString(R.string.btnFilterMaps) : chip.getContext().getString(R.string.btnFilterBottomsheets);
                    }
                    chip.setContentDescription(string);
                    chip.setChecked(newMerchantCategoryAdapter.MyBillsEntityDataFactory.contains(p0));
                    chip.setText(p0.getAuthRequestContext);
                    int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(p0);
                    int authRequestContext = getAuthRequestContext(p0);
                    if (Intrinsics.areEqual(p0.MyBillsEntityDataFactory, MerchantViewType.MERCHANT_CAT_DANA_BISNIS) || authRequestContext == 0) {
                        ((Chip) chip.findViewById(R.id.f3431x461046d9)).setChipIconVisible(false);
                    } else if (authRequestContext != 0 && KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                        ((Chip) chip.findViewById(R.id.f3431x461046d9)).setChipIconVisible(true);
                        ((Chip) chip.findViewById(R.id.f3431x461046d9)).setChipIcon(KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, KClassImpl$Data$declaredNonStaticMembers$2));
                    }
                    final NewMerchantCategoryAdapter newMerchantCategoryAdapter2 = this.MyBillsEntityDataFactory;
                    chip.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.merchantfilter.NewMerchantCategoryAdapter$MerchantCategoryViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            NewMerchantCategoryAdapter.MerchantCategoryViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(NewMerchantCategoryAdapter.MerchantCategoryViewHolder.this, p0, newMerchantCategoryAdapter2, view);
                        }
                    });
                }
            }
        }

        private final int getAuthRequestContext(MerchantCategoryModel merchantCategoryModel) {
            StringBuilder sb = new StringBuilder();
            sb.append("ic_");
            sb.append(merchantCategoryModel.MyBillsEntityDataFactory);
            sb.append("_unchecked");
            String obj = sb.toString();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            return ResourceUtils.KClassImpl$Data$declaredNonStaticMembers$2(context, obj);
        }

        private final int KClassImpl$Data$declaredNonStaticMembers$2(MerchantCategoryModel merchantCategoryModel) {
            StringBuilder sb = new StringBuilder();
            sb.append("ic_");
            sb.append(merchantCategoryModel.MyBillsEntityDataFactory);
            sb.append("_checked");
            String obj = sb.toString();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            return ResourceUtils.KClassImpl$Data$declaredNonStaticMembers$2(context, obj);
        }

        private final StateListDrawable KClassImpl$Data$declaredNonStaticMembers$2(int p0, int p1) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842912}, ContextCompat.PlaceComponentResult(getContext(), p1));
            stateListDrawable.addState(new int[0], ContextCompat.PlaceComponentResult(getContext(), p0));
            return stateListDrawable;
        }

        public void MyBillsEntityDataFactory(MerchantCategoryModel p0, boolean p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (p1) {
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(p0);
            } else {
                this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.remove(p0);
                if (this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.isEmpty() && this.MyBillsEntityDataFactory.getErrorConfigVersion) {
                    Set<MerchantCategoryModel> set = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
                    MerchantCategoryModel merchantCategoryModel = this.MyBillsEntityDataFactory.PlaceComponentResult;
                    Intrinsics.checkNotNullExpressionValue(merchantCategoryModel, "");
                    set.add(merchantCategoryModel);
                }
                NewMerchantCategoryAdapter.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
            }
            this.MyBillsEntityDataFactory.notifyDataSetChanged();
        }

        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MerchantCategoryViewHolder merchantCategoryViewHolder, MerchantCategoryModel merchantCategoryModel, NewMerchantCategoryAdapter newMerchantCategoryAdapter, View view) {
            Intrinsics.checkNotNullParameter(merchantCategoryViewHolder, "");
            Intrinsics.checkNotNullParameter(merchantCategoryModel, "");
            Intrinsics.checkNotNullParameter(newMerchantCategoryAdapter, "");
            Intrinsics.checkNotNullParameter(view, "");
            boolean isChecked = ((Chip) view).isChecked();
            merchantCategoryViewHolder.MyBillsEntityDataFactory(merchantCategoryModel, isChecked);
            OnCategoryCheckedListener onCategoryCheckedListener = merchantCategoryViewHolder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            if (onCategoryCheckedListener != null) {
                onCategoryCheckedListener.onCategoryClick(merchantCategoryModel);
            }
            ArrayList arrayList = new ArrayList(newMerchantCategoryAdapter.MyBillsEntityDataFactory);
            OnCategoryCheckedListener onCategoryCheckedListener2 = merchantCategoryViewHolder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            if (onCategoryCheckedListener2 != null) {
                onCategoryCheckedListener2.onMulitpleCategorySelected(arrayList, isChecked);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(MerchantCategoryModel p0) {
        if (this.BuiltInFictitiousFunctionClassFactory == 0) {
            this.MyBillsEntityDataFactory.clear();
        }
        this.MyBillsEntityDataFactory.add(p0);
        if (this.MyBillsEntityDataFactory.contains(this.PlaceComponentResult)) {
            this.MyBillsEntityDataFactory.remove(this.PlaceComponentResult);
        }
        getItems().remove(p0);
        getItems().add(this.MyBillsEntityDataFactory.size() - 1, p0);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/nearbyrevamp/merchantfilter/NewMerchantCategoryAdapter$DefaultSelectedMerchantCategoryViewHolder;", "Lid/dana/nearbyrevamp/merchantfilter/NewMerchantCategoryAdapter$MerchantCategoryViewHolder;", "Lid/dana/nearbyrevamp/merchantfilter/NewMerchantCategoryAdapter;", "Lid/dana/nearbyme/model/MerchantCategoryModel;", "p0", "", "p1", "", "MyBillsEntityDataFactory", "(Lid/dana/nearbyme/model/MerchantCategoryModel;Z)V", "Landroid/view/ViewGroup;", "<init>", "(Lid/dana/nearbyrevamp/merchantfilter/NewMerchantCategoryAdapter;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class DefaultSelectedMerchantCategoryViewHolder extends MerchantCategoryViewHolder {
        final /* synthetic */ NewMerchantCategoryAdapter KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DefaultSelectedMerchantCategoryViewHolder(NewMerchantCategoryAdapter newMerchantCategoryAdapter, ViewGroup viewGroup) {
            super(newMerchantCategoryAdapter, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = newMerchantCategoryAdapter;
        }

        @Override // id.dana.nearbyrevamp.merchantfilter.NewMerchantCategoryAdapter.MerchantCategoryViewHolder
        public final void MyBillsEntityDataFactory(MerchantCategoryModel p0, boolean p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (p1) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.clear();
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.add(p0);
                this.KClassImpl$Data$declaredNonStaticMembers$2.getItems().clear();
                this.KClassImpl$Data$declaredNonStaticMembers$2.getItems().addAll(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
            } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.isEmpty() && this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.add(p0);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.notifyDataSetChanged();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n"}, d2 = {"Lid/dana/nearbyrevamp/merchantfilter/NewMerchantCategoryAdapter$MerchantCategoryViewType;", "", "", BridgeDSL.INVOKE, "()I", "type", "I", "<init>", "(Ljava/lang/String;II)V", "DEFAULT_SELECTED_CATEGORY", "NORMAL_TYPE_CATEGORY"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum MerchantCategoryViewType {
        DEFAULT_SELECTED_CATEGORY(0),
        NORMAL_TYPE_CATEGORY(1);

        private final int type;

        MerchantCategoryViewType(int i) {
            this.type = i;
        }

        /* renamed from: invoke  reason: from getter */
        public final int getType() {
            return this.type;
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(NewMerchantCategoryAdapter newMerchantCategoryAdapter) {
        List<MerchantCategoryModel> list = newMerchantCategoryAdapter.getAuthRequestContext;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MerchantCategoryModel merchantCategoryModel = (MerchantCategoryModel) next;
            if ((newMerchantCategoryAdapter.MyBillsEntityDataFactory.contains(merchantCategoryModel) || Intrinsics.areEqual(merchantCategoryModel.MyBillsEntityDataFactory, newMerchantCategoryAdapter.PlaceComponentResult.MyBillsEntityDataFactory)) ? false : true) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        Set<MerchantCategoryModel> set = newMerchantCategoryAdapter.MyBillsEntityDataFactory;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : set) {
            if ((!Intrinsics.areEqual(((MerchantCategoryModel) obj).MyBillsEntityDataFactory, newMerchantCategoryAdapter.PlaceComponentResult.MyBillsEntityDataFactory)) != false) {
                arrayList3.add(obj);
            }
        }
        newMerchantCategoryAdapter.getItems().clear();
        newMerchantCategoryAdapter.getItems().addAll(arrayList3);
        newMerchantCategoryAdapter.getItems().addAll(arrayList2);
        newMerchantCategoryAdapter.notifyDataSetChanged();
    }
}
