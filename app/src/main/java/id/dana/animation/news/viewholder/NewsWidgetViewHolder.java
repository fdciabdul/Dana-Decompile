package id.dana.animation.news.viewholder;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import id.dana.R;
import id.dana.base.BaseAsyncRecyclerViewHolder;
import id.dana.base.BaseAsyncView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.domain.feeds.model.ActivityData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/home/news/viewholder/NewsWidgetViewHolder;", "Lid/dana/base/BaseAsyncRecyclerViewHolder;", "Lid/dana/domain/feeds/model/ActivityData;", "Lid/dana/base/BaseAsyncView;", "p0", "<init>", "(Lid/dana/base/BaseAsyncView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewsWidgetViewHolder extends BaseAsyncRecyclerViewHolder<ActivityData> {
    @Override // id.dana.base.BaseAsyncRecyclerViewHolder
    public final /* synthetic */ void MyBillsEntityDataFactory(ActivityData activityData) {
        String actorAvatar;
        ActivityData activityData2 = activityData;
        Intrinsics.checkNotNullParameter(activityData2, "");
        TextView textView = (TextView) this.itemView.findViewById(R.id.res_0x7f0a17f8_maybemergearray_clqsimplequeue);
        if (textView != null) {
            String activityTitle = activityData2.getActivityTitle();
            if (activityTitle == null) {
                activityTitle = "";
            }
            textView.setText(activityTitle);
        }
        TextView textView2 = (TextView) this.itemView.findViewById(R.id.res_0x7f0a17f7_access_isfreetransferavailable);
        if (textView2 != null) {
            String activityContent = activityData2.getActivityContent();
            textView2.setText(activityContent != null ? activityContent : "");
        }
        if (activityData2 == null || (actorAvatar = activityData2.getActorAvatar()) == null) {
            return;
        }
        if (SvgLoader.getAuthRequestContext(actorAvatar)) {
            SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(this.itemView.getContext());
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = actorAvatar;
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7;
            KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = new CircleCrop();
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (AppCompatImageView) this.itemView.findViewById(R.id.res_0x7f0a0baa_windowinsetscompat_builderimpl29);
            new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
            return;
        }
        GlideApp.getAuthRequestContext(this.itemView.getContext()).PlaceComponentResult(actorAvatar).getErrorConfigVersion((int) R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult((int) R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) this.itemView.findViewById(R.id.res_0x7f0a0baa_windowinsetscompat_builderimpl29)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsWidgetViewHolder(BaseAsyncView baseAsyncView) {
        super(baseAsyncView);
        Intrinsics.checkNotNullParameter(baseAsyncView, "");
    }
}
