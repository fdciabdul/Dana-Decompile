package id.dana.myprofile.viewholder;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.ProfileCompletion;
import id.dana.domain.profilemenu.model.SettingModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\f"}, d2 = {"Lid/dana/myprofile/viewholder/NewProfileCompletionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Lid/dana/domain/profilemenu/model/ProfileCompletion;", "", "PlaceComponentResult", "(Lid/dana/domain/profilemenu/model/ProfileCompletion;)Z", "Lid/dana/domain/profilemenu/model/ProfileCompletion;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewProfileCompletionViewHolder extends BaseRecyclerViewHolder<SettingModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private ProfileCompletion KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        String currentTaskTitle;
        SettingModel settingModel2 = settingModel;
        ProfileCompletion profileCompletion = settingModel2 instanceof ProfileCompletion ? (ProfileCompletion) settingModel2 : null;
        if (profileCompletion != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = profileCompletion;
            TextView textView = (TextView) this.itemView.findViewById(R.id.tv_profile_completion_title);
            if (textView != null) {
                if (PlaceComponentResult(profileCompletion)) {
                    currentTaskTitle = getContext().getString(R.string.lbl_profile_completion_title_finished);
                } else {
                    currentTaskTitle = profileCompletion.getCurrentTaskTitle();
                }
                textView.setText(currentTaskTitle);
            }
            ProgressBar progressBar = (ProgressBar) this.itemView.findViewById(R.id.pb_profile_completion_step_bar);
            if (progressBar != null) {
                progressBar.setProgress(profileCompletion.getCompletedTaskCount());
            }
            ProgressBar progressBar2 = (ProgressBar) this.itemView.findViewById(R.id.pb_profile_completion_step_bar);
            if (progressBar2 != null) {
                progressBar2.setMax(profileCompletion.getTaskCount());
            }
            TextView textView2 = (TextView) this.itemView.findViewById(R.id.res_0x7f0a1857_lambda_am_srizqaxj1qc9qx9e5pl6jdzlvbu);
            if (textView2 != null) {
                textView2.setText(getContext().getString(R.string.lbl_profile_completion_steps, Integer.valueOf(profileCompletion.getCompletedTaskCount()), Integer.valueOf(profileCompletion.getTaskCount())));
            }
            if (PlaceComponentResult(profileCompletion)) {
                if (profileCompletion.isKycRevoked()) {
                    TextView textView3 = (TextView) this.itemView.findViewById(R.id.tv_profile_completion_desc);
                    if (textView3 != null) {
                        String string = getContext().getString(R.string.lbl_profile_completion_desc_finished_non_kyc);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        String string2 = getContext().getString(R.string.lbl_profile_completion_keyword_dana_premium);
                        Intrinsics.checkNotNullExpressionValue(string2, "");
                        String str = string;
                        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, string2, 0, false, 6, (Object) null);
                        int length = string2.length();
                        SpannableString spannableString = new SpannableString(str);
                        spannableString.setSpan(new StyleSpan(1), indexOf$default, length + indexOf$default, 33);
                        textView3.setText(spannableString);
                    }
                } else {
                    TextView textView4 = (TextView) this.itemView.findViewById(R.id.tv_profile_completion_desc);
                    if (textView4 != null) {
                        textView4.setText(R.string.lbl_profile_completion_desc_finished_kyc);
                    }
                }
            } else {
                ((TextView) this.itemView.findViewById(R.id.tv_profile_completion_title)).setText(profileCompletion.getCurrentTaskTitle());
                ((TextView) this.itemView.findViewById(R.id.tv_profile_completion_desc)).setText(profileCompletion.getCurrentTaskDesc());
            }
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.iv_profile_completion_arrow);
            if (imageView != null) {
                imageView.setVisibility(PlaceComponentResult(profileCompletion) ? 4 : 0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewProfileCompletionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_new_profile_completion_status, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        ProfileCompletion profileCompletion = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (profileCompletion == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            profileCompletion = null;
        }
        if (PlaceComponentResult(profileCompletion)) {
            return;
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.NewProfileCompletionViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewProfileCompletionViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(BaseRecyclerViewHolder.OnItemClickListener.this, this);
            }
        });
    }

    private static boolean PlaceComponentResult(ProfileCompletion profileCompletion) {
        return profileCompletion.getCompletedTaskCount() >= 6;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, NewProfileCompletionViewHolder newProfileCompletionViewHolder) {
        Intrinsics.checkNotNullParameter(newProfileCompletionViewHolder, "");
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(newProfileCompletionViewHolder.getBindingAdapterPosition());
        }
    }
}
