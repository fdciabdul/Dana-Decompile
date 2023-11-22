package id.dana.myprofile.viewholder;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.statement.StatementType;
import id.dana.statement.StatementActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/myprofile/viewholder/ProfileMenuSettingStatementViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/domain/statement/StatementType;", "p0", "", "PlaceComponentResult", "(Lid/dana/domain/statement/StatementType;)V", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileMenuSettingStatementViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        this.itemView.setVisibility(0);
        if (settingModel2 != null) {
            View view = this.itemView;
            view.setVisibility(0);
            String income = settingModel2.getIncome();
            String expense = settingModel2.getExpense();
            String currency = settingModel2.getCurrency();
            if (!TextUtils.isEmpty(income)) {
                TextView textView = (TextView) view.findViewById(R.id.tv_income_amount);
                StringBuilder sb = new StringBuilder();
                sb.append(currency);
                sb.append(income);
                textView.setText(sb.toString());
            }
            if (TextUtils.isEmpty(expense)) {
                return;
            }
            TextView textView2 = (TextView) view.findViewById(R.id.tv_expense_amount);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(currency);
            sb2.append(expense);
            textView2.setText(sb2.toString());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMenuSettingStatementViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_profile_setting_statement, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ((ConstraintLayout) this.itemView.findViewById(R.id.res_0x7f0a03f6_cachebuilderspec_accessdurationparser)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuSettingStatementViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileMenuSettingStatementViewHolder.getAuthRequestContext(ProfileMenuSettingStatementViewHolder.this);
            }
        });
        ((ConstraintLayout) this.itemView.findViewById(R.id.cl_accumulate_expense)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuSettingStatementViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileMenuSettingStatementViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(ProfileMenuSettingStatementViewHolder.this);
            }
        });
    }

    private final void PlaceComponentResult(StatementType p0) {
        Intent intent = new Intent(getContext(), StatementActivity.class);
        intent.putExtra("EXTRA_SOURCE", "Profile - Me");
        intent.putExtra(StatementActivity.TAB_MENU_SELECTED, p0.name());
        getContext().startActivity(intent);
    }

    public static /* synthetic */ void getAuthRequestContext(ProfileMenuSettingStatementViewHolder profileMenuSettingStatementViewHolder) {
        Intrinsics.checkNotNullParameter(profileMenuSettingStatementViewHolder, "");
        profileMenuSettingStatementViewHolder.PlaceComponentResult(StatementType.INCOME);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ProfileMenuSettingStatementViewHolder profileMenuSettingStatementViewHolder) {
        Intrinsics.checkNotNullParameter(profileMenuSettingStatementViewHolder, "");
        profileMenuSettingStatementViewHolder.PlaceComponentResult(StatementType.EXPENSE);
    }
}
