package id.dana.social.adapter;

import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.fullstory.instrumentation.InstrumentInjector;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.adapter.NewSocialWidgetFeedAdapter;
import id.dana.social.model.SocialFeedModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B#\u0012\u0006\u0010\u0007\u001a\u00020\u0015\u0012\u0006\u0010\t\u001a\u00020\u0010\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013"}, d2 = {"Lid/dana/social/adapter/NewSocialFeedViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/SocialFeedModel;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "Landroid/text/Spannable;", "p2", "MyBillsEntityDataFactory", "(Landroid/text/Spannable;ILjava/lang/String;)V", "Lid/dana/social/adapter/SocialFeedClickListener;", "Lid/dana/social/adapter/SocialFeedClickListener;", "Lid/dana/social/adapter/NewSocialWidgetFeedAdapter$OnSlideTounch;", "Lid/dana/social/adapter/NewSocialWidgetFeedAdapter$OnSlideTounch;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;Lid/dana/social/adapter/NewSocialWidgetFeedAdapter$OnSlideTounch;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class NewSocialFeedViewHolder extends BaseRecyclerViewHolder<SocialFeedModel> {
    private final SocialFeedClickListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final NewSocialWidgetFeedAdapter.OnSlideTounch PlaceComponentResult;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0220, code lost:
    
        if (r0 == null) goto L44;
     */
    @Override // id.dana.base.BaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void bindData(id.dana.social.model.SocialFeedModel r9) {
        /*
            Method dump skipped, instructions count: 784
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.adapter.NewSocialFeedViewHolder.bindData(java.lang.Object):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewSocialFeedViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener, NewSocialWidgetFeedAdapter.OnSlideTounch onSlideTounch) {
        super(viewGroup.getContext(), R.layout.new_item_social_feed_list, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        this.BuiltInFictitiousFunctionClassFactory = socialFeedClickListener;
        this.PlaceComponentResult = onSlideTounch;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        View view = this.itemView;
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.iv_feeds_widget_profile);
        if (circleImageView != null) {
            circleImageView.setBorderWidth(0);
        }
        TextView textView = (TextView) view.findViewById(R.id.saveMonthOfFetchFreeTransfer);
        if (textView != null) {
            textView.setVisibility(8);
        }
        CircleImageView circleImageView2 = (CircleImageView) view.findViewById(R.id.iv_feeds_widget_profile);
        if (circleImageView2 != null) {
            if (circleImageView2 instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(circleImageView2, R.drawable.ic_illustration_empty_state_empty_contact);
            } else {
                circleImageView2.setImageResource(R.drawable.ic_illustration_empty_state_empty_contact);
            }
        }
        BuiltInFictitiousFunctionClassFactory();
        TextView textView2 = (TextView) view.findViewById(R.id.tv_feeds_widget_activities);
        if (textView2 != null) {
            Intrinsics.checkNotNullExpressionValue(textView2, "");
            textView2.setText(str);
            textView2.setMaxLines(10);
        }
        BuiltInFictitiousFunctionClassFactory();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        View view = this.itemView;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.iv_feeds_widget_mini_avatar_1);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(8);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.iv_feeds_widget_mini_avatar_2);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(8);
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) view.findViewById(R.id.res_0x7f0a0b22_hereauthenticationpreference_savebackoffdata_1);
        if (appCompatImageView3 != null) {
            appCompatImageView3.setVisibility(8);
        }
    }

    private final void MyBillsEntityDataFactory(Spannable p0, int p1, String p2) {
        View view = this.itemView;
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.iv_feeds_widget_profile);
        if (circleImageView != null) {
            circleImageView.setBorderWidth(0);
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_feeds_widget_activities);
        if (textView != null) {
            textView.setText(p0);
        }
        CircleImageView circleImageView2 = (CircleImageView) view.findViewById(R.id.iv_feeds_widget_profile);
        if (circleImageView2 != null) {
            if (circleImageView2 instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(circleImageView2, p1);
            } else {
                circleImageView2.setImageResource(p1);
            }
        }
        TextView textView2 = (TextView) this.itemView.findViewById(R.id.saveMonthOfFetchFreeTransfer);
        if (textView2 != null) {
            textView2.setText(p2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(NewSocialFeedViewHolder newSocialFeedViewHolder, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(newSocialFeedViewHolder, "");
        if (motionEvent.getAction() == 0) {
            NewSocialWidgetFeedAdapter.OnSlideTounch onSlideTounch = newSocialFeedViewHolder.PlaceComponentResult;
            return false;
        }
        return false;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(NewSocialFeedViewHolder newSocialFeedViewHolder) {
        Intrinsics.checkNotNullParameter(newSocialFeedViewHolder, "");
        newSocialFeedViewHolder.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(newSocialFeedViewHolder.getBindingAdapterPosition());
    }
}
