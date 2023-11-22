package id.dana.myprofile.viewholder;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.ProfileCompletion;
import id.dana.domain.profilemenu.model.SettingModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\n\u001a\u00020\u0005*\u00020\f2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\n\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u0010"}, d2 = {"Lid/dana/myprofile/viewholder/ProfileCompletionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Lid/dana/domain/profilemenu/model/ProfileCompletion;", "", "MyBillsEntityDataFactory", "(Lid/dana/domain/profilemenu/model/ProfileCompletion;)Z", "Landroid/widget/TextView;", "", "p1", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/profilemenu/model/ProfileCompletion;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileCompletionViewHolder extends BaseRecyclerViewHolder<SettingModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private ProfileCompletion KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        ProfileCompletion profileCompletion = settingModel2 instanceof ProfileCompletion ? (ProfileCompletion) settingModel2 : null;
        if (profileCompletion != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = profileCompletion;
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.iv_profile_completion_avatar);
            if (imageView != null) {
                InstrumentInjector.Resources_setImageResource(imageView, MyBillsEntityDataFactory(profileCompletion) ? R.drawable.ic_profile_completion_verify : R.drawable.ic_profile_completion_default);
            }
            TextView textView = (TextView) this.itemView.findViewById(R.id.tv_profile_completion_title);
            if (textView != null) {
                textView.setText(MyBillsEntityDataFactory(profileCompletion) ? R.string.lbl_profile_completion_title_finished : R.string.lbl_profile_completion_title_default);
            }
            ProgressBar progressBar = (ProgressBar) this.itemView.findViewById(R.id.pb_profile_completion_step_bar);
            if (progressBar != null) {
                progressBar.setProgress(profileCompletion.getCompletedTaskCount());
            }
            TextView textView2 = (TextView) this.itemView.findViewById(R.id.res_0x7f0a1857_lambda_am_srizqaxj1qc9qx9e5pl6jdzlvbu);
            if (textView2 != null) {
                textView2.setText(getContext().getString(R.string.lbl_profile_completion_steps, Integer.valueOf(profileCompletion.getCompletedTaskCount()), 5));
            }
            if (MyBillsEntityDataFactory(profileCompletion)) {
                if (profileCompletion.isKycRevoked()) {
                    TextView textView3 = (TextView) this.itemView.findViewById(R.id.tv_profile_completion_desc);
                    if (textView3 != null) {
                        String string = getContext().getString(R.string.lbl_profile_completion_desc_finished_non_kyc);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        String string2 = getContext().getString(R.string.lbl_profile_completion_keyword_dana_premium);
                        Intrinsics.checkNotNullExpressionValue(string2, "");
                        MyBillsEntityDataFactory(textView3, string, string2);
                    }
                } else {
                    TextView textView4 = (TextView) this.itemView.findViewById(R.id.tv_profile_completion_desc);
                    if (textView4 != null) {
                        textView4.setText(R.string.lbl_profile_completion_desc_finished_kyc);
                    }
                }
            } else {
                TextView textView5 = (TextView) this.itemView.findViewById(R.id.tv_profile_completion_desc);
                if (textView5 != null) {
                    String string3 = getContext().getString(R.string.lbl_profile_completion_desc_default, profileCompletion.getCurrentTaskTitle());
                    Intrinsics.checkNotNullExpressionValue(string3, "");
                    MyBillsEntityDataFactory(textView5, string3, profileCompletion.getCurrentTaskTitle());
                }
            }
            ImageView imageView2 = (ImageView) this.itemView.findViewById(R.id.iv_profile_completion_arrow);
            if (imageView2 != null) {
                imageView2.setVisibility(MyBillsEntityDataFactory(profileCompletion) ? 4 : 0);
            }
            ImageButton imageButton = (ImageButton) this.itemView.findViewById(R.id.ib_profile_completion_close);
            if (imageButton != null) {
                Intrinsics.checkNotNullExpressionValue(imageButton, "");
                imageButton.setVisibility(MyBillsEntityDataFactory(profileCompletion) ? 0 : 8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileCompletionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_profile_completion_status, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        ProfileCompletion profileCompletion = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (profileCompletion == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            profileCompletion = null;
        }
        if (!MyBillsEntityDataFactory(profileCompletion)) {
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.ProfileCompletionViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileCompletionViewHolder.MyBillsEntityDataFactory(BaseRecyclerViewHolder.OnItemClickListener.this, this);
                }
            });
        }
        ImageButton imageButton = (ImageButton) this.itemView.findViewById(R.id.ib_profile_completion_close);
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.ProfileCompletionViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileCompletionViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(ProfileCompletionViewHolder.this, p0);
                }
            });
        }
    }

    private static void MyBillsEntityDataFactory(TextView textView, String str, String str2) {
        String str3 = str;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str3, str2, 0, false, 6, (Object) null);
        int length = str2.length();
        SpannableString spannableString = new SpannableString(str3);
        spannableString.setSpan(new StyleSpan(1), indexOf$default, length + indexOf$default, 33);
        textView.setText(spannableString);
    }

    private static boolean MyBillsEntityDataFactory(ProfileCompletion profileCompletion) {
        return profileCompletion.getCompletedTaskCount() >= 5;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ProfileCompletionViewHolder profileCompletionViewHolder, BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        Intrinsics.checkNotNullParameter(profileCompletionViewHolder, "");
        View view = profileCompletionViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "");
        view.setVisibility(8);
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(profileCompletionViewHolder.getAdapterPosition());
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, ProfileCompletionViewHolder profileCompletionViewHolder) {
        Intrinsics.checkNotNullParameter(profileCompletionViewHolder, "");
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(profileCompletionViewHolder.getAdapterPosition());
        }
    }
}
