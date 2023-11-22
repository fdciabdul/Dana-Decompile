package id.dana.social.adapter.friendsheader;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.feeds.ui.model.FriendModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/adapter/friendsheader/FriendsFeedsHeaderViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/model/FriendModel;", "Landroid/view/ViewGroup;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "p0", "Lkotlin/Function1;", "", "", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendsFeedsHeaderViewHolder extends BaseRecyclerViewHolder<FriendModel> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final ViewGroup BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FriendModel friendModel) {
        FriendModel friendModel2 = friendModel;
        if (friendModel2 != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.res_0x7f0a1707_tncsummaryactivity_externalsyntheticlambda0);
            if (appCompatTextView != null) {
                String str = friendModel2.KClassImpl$Data$declaredNonStaticMembers$2;
                if (str.length() > 10) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(StringsKt.substring(str, new IntRange(0, 9)));
                    sb.append("...");
                    str = sb.toString();
                }
                appCompatTextView.setText(str);
            }
            String str2 = friendModel2.getErrorConfigVersion;
            CircleImageView circleImageView = (CircleImageView) this.itemView.findViewById(R.id.iv_friends_header_profile_avatar);
            if (circleImageView != null) {
                GlideApp.getAuthRequestContext(circleImageView.getContext()).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(str2).getErrorConfigVersion((int) R.drawable.avatar_placeholder).PlaceComponentResult((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) circleImageView);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsFeedsHeaderViewHolder(ViewGroup viewGroup, final Function1<? super Integer, Unit> function1) {
        super(viewGroup.getContext(), R.layout.viewholder_friends_header, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.BuiltInFictitiousFunctionClassFactory = viewGroup;
        ConstraintLayout constraintLayout = (ConstraintLayout) this.itemView.findViewById(R.id.vg_friends_header_root);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.friendsheader.FriendsFeedsHeaderViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FriendsFeedsHeaderViewHolder.BuiltInFictitiousFunctionClassFactory(Function1.this, this);
                }
            });
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Function1 function1, FriendsFeedsHeaderViewHolder friendsFeedsHeaderViewHolder) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(friendsFeedsHeaderViewHolder, "");
        function1.invoke(Integer.valueOf(friendsFeedsHeaderViewHolder.getBindingAdapterPosition() - 1));
    }
}
