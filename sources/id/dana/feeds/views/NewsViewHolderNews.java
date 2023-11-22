package id.dana.feeds.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import id.dana.R;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.feeds.model.ActivityModel;
import id.dana.feeds.views.NewsViewHolderNews;
import id.dana.utils.ImageOss;

/* loaded from: classes8.dex */
public class NewsViewHolderNews extends FeedsWrapperViewHolder {
    FeedsViewHolderActions PlaceComponentResult;
    @BindView(R.id.news_content)
    TextView content;
    @BindView(R.id.news_wrapper)
    RelativeLayout feedWrapper;
    @BindView(R.id.news_icon)
    ImageView iconFeeds;
    @BindView(R.id.news_title)
    TextView title;

    /* loaded from: classes8.dex */
    public interface FeedsViewHolderActions {
    }

    @Override // id.dana.feeds.views.FeedsWrapperViewHolder, id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(ActivityModel activityModel) {
        bindData(activityModel);
    }

    @Override // id.dana.feeds.views.FeedsWrapperViewHolder
    /* renamed from: PlaceComponentResult */
    public final void bindData(final ActivityModel activityModel) {
        if (activityModel != null) {
            String str = activityModel.MyBillsEntityDataFactory;
            if (str != null) {
                this.title.setText(str);
            }
            String str2 = activityModel.getAuthRequestContext;
            if (str2 != null) {
                this.content.setText(str2);
            }
            String str3 = activityModel.lookAheadTest;
            if (!TextUtils.isEmpty(str3)) {
                if (!SvgLoader.getAuthRequestContext(str3)) {
                    final Context context = getContext();
                    ImageOss.MyBillsEntityDataFactory(str3, this.iconFeeds, new ImageOss.EventListener() { // from class: id.dana.feeds.views.NewsViewHolderNews$$ExternalSyntheticLambda0
                        @Override // id.dana.utils.ImageOss.EventListener
                        public final void PlaceComponentResult(String str4, ImageView imageView) {
                            GlideApp.getAuthRequestContext(context).PlaceComponentResult(str4).getErrorConfigVersion((int) R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult((int) R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7).MyBillsEntityDataFactory(imageView);
                        }
                    });
                } else {
                    SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
                    KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = str3;
                    KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7;
                    KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = new CircleCrop();
                    KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = this.iconFeeds;
                    new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
                }
            }
            this.feedWrapper.setOnClickListener(new View.OnClickListener() { // from class: id.dana.feeds.views.NewsViewHolderNews$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewsViewHolderNews newsViewHolderNews = NewsViewHolderNews.this;
                    if (activityModel.MyBillsEntityDataFactory()) {
                        NewsViewHolderNews.FeedsViewHolderActions feedsViewHolderActions = newsViewHolderNews.PlaceComponentResult;
                    }
                }
            });
        }
    }
}
