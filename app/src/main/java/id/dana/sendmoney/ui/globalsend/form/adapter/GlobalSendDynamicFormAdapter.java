package id.dana.sendmoney.ui.globalsend.form.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemDropdownFormBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.BankNameFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CityFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.ProvinceFormModel;
import id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.DropdownFormViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.RadioGlobalSendFormViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.AddressFormViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.BankTypeFormViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.CountryFormViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.DefaultFormViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.DisabledTransferDestinationViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.EnabledTransferToDebitViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.SelectCountryViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.SpinnerFormViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u001f\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/adapter/GlobalSendDynamicFormAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "Landroidx/recyclerview/widget/RecyclerView;", "", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "Landroidx/fragment/app/FragmentManager;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/fragment/app/FragmentManager;", "getAuthRequestContext", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "PlaceComponentResult", "I", "moveToNextValue", "Landroidx/recyclerview/widget/RecyclerView;", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "<init>", "(Ljava/util/List;Landroidx/fragment/app/FragmentManager;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSendDynamicFormAdapter extends RecyclerView.Adapter<BaseGlobalSendFormViewHolder<?, GlobalSendFormModel>> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FragmentManager getAuthRequestContext;
    public final List<GlobalSendFormModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Function1<? super Integer, Unit> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function1<Integer, Unit> MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private RecyclerView lookAheadTest;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(BaseGlobalSendFormViewHolder<?, GlobalSendFormModel> baseGlobalSendFormViewHolder, int i) {
        BaseGlobalSendFormViewHolder<?, GlobalSendFormModel> baseGlobalSendFormViewHolder2 = baseGlobalSendFormViewHolder;
        Intrinsics.checkNotNullParameter(baseGlobalSendFormViewHolder2, "");
        baseGlobalSendFormViewHolder2.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get(i));
        if (baseGlobalSendFormViewHolder2 instanceof RadioGlobalSendFormViewHolder) {
            int i2 = this.BuiltInFictitiousFunctionClassFactory;
            int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (i2 != i3) {
                ((RadioGlobalSendFormViewHolder) baseGlobalSendFormViewHolder2).BuiltInFictitiousFunctionClassFactory(i == i3);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v40, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder<?, id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel>] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ BaseGlobalSendFormViewHolder<?, GlobalSendFormModel> onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        switch (i) {
            case 4:
                CountryFormViewHolder.Companion companion = CountryFormViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new CountryFormViewHolder(CountryFormViewHolder.Companion.getAuthRequestContext(viewGroup));
                break;
            case 5:
                DefaultFormViewHolder.Companion companion2 = DefaultFormViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new DefaultFormViewHolder(DefaultFormViewHolder.Companion.getAuthRequestContext(viewGroup), 0, 0, false, 0, 30, null);
                break;
            case 6:
                DefaultFormViewHolder.Companion companion3 = DefaultFormViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new SpinnerFormViewHolder(DefaultFormViewHolder.Companion.getAuthRequestContext(viewGroup));
                break;
            case 7:
                DefaultFormViewHolder.Companion companion4 = DefaultFormViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new DefaultFormViewHolder(DefaultFormViewHolder.Companion.getAuthRequestContext(viewGroup), 2, 0, false, 0, 28, null);
                break;
            case 8:
            case 11:
                DefaultFormViewHolder.Companion companion5 = DefaultFormViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new DefaultFormViewHolder(DefaultFormViewHolder.Companion.getAuthRequestContext(viewGroup), 3, 0, false, 0, 28, null);
                break;
            case 9:
                DropdownFormViewHolder.Companion companion6 = DropdownFormViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new DropdownFormViewHolder(DropdownFormViewHolder.Companion.PlaceComponentResult(viewGroup), i, this.getAuthRequestContext, new Function1<GlobalSendFormOptionModel, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.adapter.GlobalSendDynamicFormAdapter$onCreateViewHolder$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(GlobalSendFormOptionModel globalSendFormOptionModel) {
                        invoke2(globalSendFormOptionModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(GlobalSendFormOptionModel globalSendFormOptionModel) {
                        Intrinsics.checkNotNullParameter(globalSendFormOptionModel, "");
                        GlobalSendDynamicFormAdapter.MyBillsEntityDataFactory(GlobalSendDynamicFormAdapter.this, globalSendFormOptionModel);
                        GlobalSendDynamicFormAdapter.this.notifyDataSetChanged();
                    }
                });
                break;
            case 10:
                DefaultFormViewHolder.Companion companion7 = DefaultFormViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new DefaultFormViewHolder(DefaultFormViewHolder.Companion.getAuthRequestContext(viewGroup), 3, R.string.res_0x7f130091_kclassimpl_data_declarednonstaticmembers_2, true, 0, 16, null);
                break;
            case 12:
                BankTypeFormViewHolder.Companion companion8 = BankTypeFormViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new BankTypeFormViewHolder(BankTypeFormViewHolder.Companion.PlaceComponentResult(viewGroup));
                break;
            case 13:
                DefaultFormViewHolder.Companion companion9 = DefaultFormViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new DefaultFormViewHolder(DefaultFormViewHolder.Companion.getAuthRequestContext(viewGroup), 3, 0, false, R.string.additional_info_form_debit_card, 12, null);
                break;
            case 14:
                DisabledTransferDestinationViewHolder.Companion companion10 = DisabledTransferDestinationViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new DisabledTransferDestinationViewHolder(DisabledTransferDestinationViewHolder.Companion.PlaceComponentResult(viewGroup));
                break;
            case 15:
                EnabledTransferToDebitViewHolder.Companion companion11 = EnabledTransferToDebitViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new EnabledTransferToDebitViewHolder(EnabledTransferToDebitViewHolder.Companion.KClassImpl$Data$declaredNonStaticMembers$2(viewGroup), this.MyBillsEntityDataFactory, null, 4, null);
                break;
            case 16:
                DropdownFormViewHolder.Companion companion12 = DropdownFormViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new SelectCountryViewHolder(DropdownFormViewHolder.Companion.PlaceComponentResult(viewGroup), i, this.getAuthRequestContext, new Function1<GlobalSendFormOptionModel, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.adapter.GlobalSendDynamicFormAdapter$onCreateViewHolder$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(GlobalSendFormOptionModel globalSendFormOptionModel) {
                        invoke2(globalSendFormOptionModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(GlobalSendFormOptionModel globalSendFormOptionModel) {
                        Intrinsics.checkNotNullParameter(globalSendFormOptionModel, "");
                        GlobalSendDynamicFormAdapter.getAuthRequestContext(GlobalSendDynamicFormAdapter.this, globalSendFormOptionModel);
                    }
                });
                break;
            case 17:
                DropdownFormViewHolder.Companion companion13 = DropdownFormViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new DropdownFormViewHolder(DropdownFormViewHolder.Companion.PlaceComponentResult(viewGroup), i, this.getAuthRequestContext, new Function1<GlobalSendFormOptionModel, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.adapter.GlobalSendDynamicFormAdapter$onCreateViewHolder$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(GlobalSendFormOptionModel globalSendFormOptionModel) {
                        invoke2(globalSendFormOptionModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(GlobalSendFormOptionModel globalSendFormOptionModel) {
                        Intrinsics.checkNotNullParameter(globalSendFormOptionModel, "");
                        GlobalSendDynamicFormAdapter.BuiltInFictitiousFunctionClassFactory(GlobalSendDynamicFormAdapter.this, globalSendFormOptionModel);
                    }
                });
                break;
            case 18:
                DefaultFormViewHolder.Companion companion14 = DefaultFormViewHolder.INSTANCE;
                viewHolder = (BaseGlobalSendFormViewHolder) new AddressFormViewHolder(DefaultFormViewHolder.Companion.getAuthRequestContext(viewGroup), new Function1<Integer, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.adapter.GlobalSendDynamicFormAdapter$onCreateViewHolder$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2) {
                        GlobalSendDynamicFormAdapter.KClassImpl$Data$declaredNonStaticMembers$2(GlobalSendDynamicFormAdapter.this, i2);
                    }
                });
                break;
            default:
                throw new IllegalArgumentException("Invalid view type");
        }
        return viewHolder;
    }

    public GlobalSendDynamicFormAdapter(List<GlobalSendFormModel> list, FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(list, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.getAuthRequestContext = fragmentManager;
        this.BuiltInFictitiousFunctionClassFactory = -1;
        this.PlaceComponentResult = new Function1<Integer, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.adapter.GlobalSendDynamicFormAdapter$onTransferDestinationItemSelected$1
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        };
        this.MyBillsEntityDataFactory = new Function1<Integer, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.adapter.GlobalSendDynamicFormAdapter$onRadioItemSelected$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                Function1 function1;
                int i2;
                function1 = GlobalSendDynamicFormAdapter.this.PlaceComponentResult;
                function1.invoke(Integer.valueOf(i));
                GlobalSendDynamicFormAdapter globalSendDynamicFormAdapter = GlobalSendDynamicFormAdapter.this;
                i2 = globalSendDynamicFormAdapter.NetworkUserEntityData$$ExternalSyntheticLambda0;
                globalSendDynamicFormAdapter.BuiltInFictitiousFunctionClassFactory = i2;
                GlobalSendDynamicFormAdapter.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
                GlobalSendDynamicFormAdapter.this.notifyDataSetChanged();
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttachedToRecyclerView(p0);
        this.lookAheadTest = p0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.get(p0).PlaceComponentResult;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.size();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GlobalSendDynamicFormAdapter globalSendDynamicFormAdapter, int i) {
        RecyclerView recyclerView = globalSendDynamicFormAdapter.lookAheadTest;
        if (recyclerView != null) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i + 1);
            SelectCountryViewHolder selectCountryViewHolder = findViewHolderForAdapterPosition instanceof SelectCountryViewHolder ? (SelectCountryViewHolder) findViewHolderForAdapterPosition : null;
            if (selectCountryViewHolder != null) {
                ((ItemDropdownFormBinding) selectCountryViewHolder.MyBillsEntityDataFactory).PlaceComponentResult.performClick();
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(GlobalSendDynamicFormAdapter globalSendDynamicFormAdapter, GlobalSendFormOptionModel globalSendFormOptionModel) {
        Object obj;
        Object obj2;
        Iterator<T> it = globalSendDynamicFormAdapter.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((GlobalSendFormModel) obj2) instanceof BankNameFormModel) {
                break;
            }
        }
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.ui.globalsend.form.model.form.receiver.BankNameFormModel");
        }
        List<GlobalSendFormOptionModel> list = ((BankNameFormModel) obj2).KClassImpl$Data$declaredNonStaticMembers$2;
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            ((GlobalSendFormOptionModel) it2.next()).KClassImpl$Data$declaredNonStaticMembers$2 = false;
        }
        Iterator<T> it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next = it3.next();
            if (Intrinsics.areEqual((GlobalSendFormOptionModel) next, globalSendFormOptionModel)) {
                obj = next;
                break;
            }
        }
        GlobalSendFormOptionModel globalSendFormOptionModel2 = (GlobalSendFormOptionModel) obj;
        if (globalSendFormOptionModel2 != null) {
            globalSendFormOptionModel2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GlobalSendDynamicFormAdapter globalSendDynamicFormAdapter, GlobalSendFormOptionModel globalSendFormOptionModel) {
        Object obj;
        Object obj2;
        Iterator<T> it = globalSendDynamicFormAdapter.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((GlobalSendFormModel) obj2) instanceof CityFormModel) {
                break;
            }
        }
        if (obj2 != null) {
            CityFormModel cityFormModel = (CityFormModel) obj2;
            List<GlobalSendFormOptionModel> list = cityFormModel.getAuthRequestContext;
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                ((GlobalSendFormOptionModel) it2.next()).KClassImpl$Data$declaredNonStaticMembers$2 = false;
            }
            Iterator<T> it3 = list.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next = it3.next();
                if (Intrinsics.areEqual((GlobalSendFormOptionModel) next, globalSendFormOptionModel)) {
                    obj = next;
                    break;
                }
            }
            GlobalSendFormOptionModel globalSendFormOptionModel2 = (GlobalSendFormOptionModel) obj;
            if (globalSendFormOptionModel2 != null) {
                globalSendFormOptionModel2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
            globalSendDynamicFormAdapter.notifyItemChanged(globalSendDynamicFormAdapter.KClassImpl$Data$declaredNonStaticMembers$2.indexOf(cityFormModel));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CityFormModel");
    }

    public static final /* synthetic */ void getAuthRequestContext(GlobalSendDynamicFormAdapter globalSendDynamicFormAdapter, GlobalSendFormOptionModel globalSendFormOptionModel) {
        Object obj;
        Object obj2;
        Iterator<T> it = globalSendDynamicFormAdapter.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((GlobalSendFormModel) obj2) instanceof ProvinceFormModel) {
                break;
            }
        }
        if (obj2 != null) {
            ProvinceFormModel provinceFormModel = (ProvinceFormModel) obj2;
            List<GlobalSendFormOptionModel> list = provinceFormModel.lookAheadTest;
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                ((GlobalSendFormOptionModel) it2.next()).KClassImpl$Data$declaredNonStaticMembers$2 = false;
            }
            Iterator<T> it3 = list.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next = it3.next();
                if (Intrinsics.areEqual((GlobalSendFormOptionModel) next, globalSendFormOptionModel)) {
                    obj = next;
                    break;
                }
            }
            GlobalSendFormOptionModel globalSendFormOptionModel2 = (GlobalSendFormOptionModel) obj;
            if (globalSendFormOptionModel2 != null) {
                globalSendFormOptionModel2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
            globalSendDynamicFormAdapter.notifyItemChanged(globalSendDynamicFormAdapter.KClassImpl$Data$declaredNonStaticMembers$2.indexOf(provinceFormModel));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.ui.globalsend.form.model.form.receiver.ProvinceFormModel");
    }
}
