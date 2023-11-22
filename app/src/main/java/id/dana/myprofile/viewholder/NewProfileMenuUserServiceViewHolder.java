package id.dana.myprofile.viewholder;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.statement.StatementType;
import id.dana.myprofile.mepagerevamp.GroupedSettingItemClickListener;
import id.dana.myprofile.mepagerevamp.adapter.GridUserServiceAdapter;
import id.dana.statement.StatementActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010"}, d2 = {"Lid/dana/myprofile/viewholder/NewProfileMenuUserServiceViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/domain/statement/StatementType;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/statement/StatementType;)V", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Lid/dana/myprofile/mepagerevamp/adapter/GridUserServiceAdapter;", "getAuthRequestContext", "Lid/dana/myprofile/mepagerevamp/adapter/GridUserServiceAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/myprofile/mepagerevamp/GroupedSettingItemClickListener;", "Lid/dana/myprofile/mepagerevamp/GroupedSettingItemClickListener;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewProfileMenuUserServiceViewHolder extends BaseRecyclerViewHolder<SettingModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private GroupedSettingItemClickListener MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private GridUserServiceAdapter BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        if (settingModel2 == null || settingModel2.getSettingChilds().isEmpty()) {
            return;
        }
        List<SettingModel> settingChilds = settingModel2.getSettingChilds();
        Intrinsics.checkNotNullExpressionValue(settingChilds, "");
        Iterator<SettingModel> it = settingChilds.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getName(), MyProfileMenuAction.SETTING_STATEMENT)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            View view = this.itemView;
            view.findViewById(R.id.res_0x7f0a1b85_gettopupuserconsult_externalsyntheticlambda0).setVisibility(0);
            String income = settingModel2.getSettingChilds().get(i).getIncome();
            String expense = settingModel2.getSettingChilds().get(i).getExpense();
            String currency = settingModel2.getSettingChilds().get(i).getCurrency();
            if (!TextUtils.isEmpty(income)) {
                TextView textView = (TextView) view.findViewById(R.id.tv_income_amount);
                StringBuilder sb = new StringBuilder();
                sb.append(currency);
                sb.append(income);
                textView.setText(sb.toString());
            }
            if (!TextUtils.isEmpty(expense)) {
                TextView textView2 = (TextView) view.findViewById(R.id.tv_expense_amount);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(currency);
                sb2.append(expense);
                textView2.setText(sb2.toString());
            }
        }
        List<SettingModel> settingChilds2 = settingModel2.getSettingChilds();
        Intrinsics.checkNotNullExpressionValue(settingChilds2, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : settingChilds2) {
            if ((!Intrinsics.areEqual(((SettingModel) obj).getName(), MyProfileMenuAction.SETTING_STATEMENT)) != false) {
                arrayList.add(obj);
            }
        }
        final ArrayList arrayList2 = arrayList;
        GridUserServiceAdapter gridUserServiceAdapter = new GridUserServiceAdapter();
        this.BuiltInFictitiousFunctionClassFactory = gridUserServiceAdapter;
        gridUserServiceAdapter.setOnItemClickListener(new GroupedSettingItemClickListener() { // from class: id.dana.myprofile.viewholder.NewProfileMenuUserServiceViewHolder$initRecyclerView$1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int p0) {
                GroupedSettingItemClickListener groupedSettingItemClickListener;
                SettingModel settingModel3 = (SettingModel) CollectionsKt.getOrNull(arrayList2, p0);
                groupedSettingItemClickListener = this.MyBillsEntityDataFactory;
                if (groupedSettingItemClickListener != null) {
                    groupedSettingItemClickListener.getAuthRequestContext(settingModel3);
                }
            }

            @Override // id.dana.myprofile.mepagerevamp.GroupedSettingItemClickListener
            public final void getAuthRequestContext(SettingModel p0) {
                GroupedSettingItemClickListener groupedSettingItemClickListener;
                groupedSettingItemClickListener = this.MyBillsEntityDataFactory;
                if (groupedSettingItemClickListener != null) {
                    groupedSettingItemClickListener.getAuthRequestContext(p0);
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.KeyBizExceptionLog);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), arrayList2.size() <= 4 ? 2 : 3));
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(this.BuiltInFictitiousFunctionClassFactory);
        }
        GridUserServiceAdapter gridUserServiceAdapter2 = this.BuiltInFictitiousFunctionClassFactory;
        if (gridUserServiceAdapter2 != null) {
            gridUserServiceAdapter2.setItems(arrayList2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewProfileMenuUserServiceViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_profile_new_setting_user_service, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ((ConstraintLayout) this.itemView.findViewById(R.id.res_0x7f0a03f6_cachebuilderspec_accessdurationparser)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.NewProfileMenuUserServiceViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewProfileMenuUserServiceViewHolder.PlaceComponentResult(NewProfileMenuUserServiceViewHolder.this);
            }
        });
        ((ConstraintLayout) this.itemView.findViewById(R.id.cl_accumulate_expense)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.NewProfileMenuUserServiceViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewProfileMenuUserServiceViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(NewProfileMenuUserServiceViewHolder.this);
            }
        });
        this.MyBillsEntityDataFactory = p0 instanceof GroupedSettingItemClickListener ? (GroupedSettingItemClickListener) p0 : null;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(StatementType p0) {
        Intent intent = new Intent(getContext(), StatementActivity.class);
        intent.putExtra("EXTRA_SOURCE", "Profile - Me");
        intent.putExtra(StatementActivity.TAB_MENU_SELECTED, p0.name());
        getContext().startActivity(intent);
    }

    public static /* synthetic */ void PlaceComponentResult(NewProfileMenuUserServiceViewHolder newProfileMenuUserServiceViewHolder) {
        Intrinsics.checkNotNullParameter(newProfileMenuUserServiceViewHolder, "");
        newProfileMenuUserServiceViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(StatementType.INCOME);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(NewProfileMenuUserServiceViewHolder newProfileMenuUserServiceViewHolder) {
        Intrinsics.checkNotNullParameter(newProfileMenuUserServiceViewHolder, "");
        newProfileMenuUserServiceViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(StatementType.EXPENSE);
    }
}
