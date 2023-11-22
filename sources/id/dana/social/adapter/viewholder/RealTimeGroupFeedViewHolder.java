package id.dana.social.adapter.viewholder;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.extension.SocialFeedExtKt;
import id.dana.social.model.SocialFeedModel;
import id.dana.social.utils.FeedRegexData;
import id.dana.social.utils.RegexUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/adapter/viewholder/RealTimeGroupFeedViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/SocialFeedModel;", "Lid/dana/social/adapter/SocialFeedClickListener;", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/SocialFeedClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "Landroid/content/Context;", "p1", "Landroid/view/ViewGroup;", "p2", "<init>", "(Lid/dana/social/adapter/SocialFeedClickListener;Landroid/content/Context;Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RealTimeGroupFeedViewHolder extends BaseRecyclerViewHolder<SocialFeedModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SocialFeedClickListener KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SocialFeedModel socialFeedModel) {
        SpannableString spannableString;
        SocialFeedModel socialFeedModel2 = socialFeedModel;
        Intrinsics.checkNotNullParameter(socialFeedModel2, "");
        super.bindData(socialFeedModel2);
        View view = this.itemView;
        HashMap<String, String> hashMap = socialFeedModel2.PlaceComponentResult;
        if (hashMap != null) {
            Context context = getContext();
            Object[] objArr = new Object[1];
            int i = socialFeedModel2.MyBillsEntityDataFactory;
            objArr[0] = i > 99 ? "99+" : String.valueOf(i);
            String string = context.getString(R.string.feed_widget_content_grouping_text, objArr);
            Intrinsics.checkNotNullExpressionValue(string, "");
            ExtendInfoUtilKt.setDisplayName(hashMap, string);
        }
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        FeedRegexData KClassImpl$Data$declaredNonStaticMembers$2 = socialFeedModel2.KClassImpl$Data$declaredNonStaticMembers$2(context2, this.KClassImpl$Data$declaredNonStaticMembers$2);
        TextView textView = (TextView) this.itemView.findViewById(R.id.containsNull);
        if (textView != null) {
            if ((!KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.isEmpty()) != false) {
                RegexUtils.Companion companion = RegexUtils.INSTANCE;
                spannableString = RegexUtils.Companion.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, Integer.valueOf((int) R.font.f34282131296266), true, false, 8);
            } else {
                spannableString = new SpannableString(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion);
            }
            textView.setText(spannableString);
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.ivActor1);
        if (shapeableImageView != null) {
            Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
            ShapeableImageView shapeableImageView2 = shapeableImageView;
            String str = socialFeedModel2.lookAheadTest;
            if (str == null) {
                str = "";
            }
            SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(shapeableImageView2, str, R.drawable.ic_avatar_grey_default);
        }
        ShapeableImageView shapeableImageView3 = (ShapeableImageView) view.findViewById(R.id.setHelperTextAppearance);
        if (shapeableImageView3 != null) {
            Intrinsics.checkNotNullExpressionValue(shapeableImageView3, "");
            ShapeableImageView shapeableImageView4 = shapeableImageView3;
            String str2 = socialFeedModel2.moveToNextValue;
            SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(shapeableImageView4, str2 != null ? str2 : "", R.drawable.ic_avatar_grey_default);
        }
        setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.social.adapter.viewholder.RealTimeGroupFeedViewHolder$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i2) {
                RealTimeGroupFeedViewHolder.MyBillsEntityDataFactory(RealTimeGroupFeedViewHolder.this);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealTimeGroupFeedViewHolder(SocialFeedClickListener socialFeedClickListener, Context context, ViewGroup viewGroup) {
        super(context, R.layout.real_time_group_feed_viewholder, viewGroup);
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = socialFeedClickListener;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(RealTimeGroupFeedViewHolder realTimeGroupFeedViewHolder) {
        Intrinsics.checkNotNullParameter(realTimeGroupFeedViewHolder, "");
        realTimeGroupFeedViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(realTimeGroupFeedViewHolder.getAbsoluteAdapterPosition());
    }
}
