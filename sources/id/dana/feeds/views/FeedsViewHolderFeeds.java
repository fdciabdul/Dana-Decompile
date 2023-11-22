package id.dana.feeds.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import id.dana.R;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.feeds.FeedsContentFormatter;
import id.dana.feeds.model.ActivityModel;
import id.dana.feeds.views.FeedsViewHolderFeeds;
import id.dana.utils.SimpleTimeConversion;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public class FeedsViewHolderFeeds extends FeedsWrapperViewHolder {
    public int BuiltInFictitiousFunctionClassFactory;
    private Context MyBillsEntityDataFactory;
    @BindView(R.id.feed_content)
    TextView content;
    @BindView(R.id.feed_delete)
    TextView delete;
    @BindView(R.id.feed_wrapper)
    RelativeLayout feedWrapper;
    public FeedsViewHolderActions getAuthRequestContext;
    @BindView(R.id.feed_icon)
    ImageView iconFeeds;
    @BindView(R.id.feed_time)
    TextView time;

    /* loaded from: classes8.dex */
    public interface FeedsViewHolderActions {
        void KClassImpl$Data$declaredNonStaticMembers$2(int i, boolean z);

        void MyBillsEntityDataFactory(int i);

        void MyBillsEntityDataFactory(String str);

        void PlaceComponentResult(Context context, int i);
    }

    @Override // id.dana.feeds.views.FeedsWrapperViewHolder, id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(ActivityModel activityModel) {
        bindData(activityModel);
    }

    public FeedsViewHolderFeeds(Context context, ViewGroup viewGroup) {
        super(context, R.layout.cardview_feed, viewGroup);
        this.BuiltInFictitiousFunctionClassFactory = 8;
        this.MyBillsEntityDataFactory = context;
    }

    private String MyBillsEntityDataFactory(int i) {
        if (i != 1) {
            return i != 2 ? "" : this.MyBillsEntityDataFactory.getString(R.string.feeds_delete_deleting_state);
        }
        return this.MyBillsEntityDataFactory.getString(R.string.option_delete);
    }

    @Override // id.dana.feeds.views.FeedsWrapperViewHolder
    /* renamed from: PlaceComponentResult */
    public final void bindData(final ActivityModel activityModel) {
        if (activityModel != null) {
            FeedsContentFormatter feedsContentFormatter = new FeedsContentFormatter(activityModel.KClassImpl$Data$declaredNonStaticMembers$2, activityModel.DatabaseTableConfigUtil, activityModel.NetworkUserEntityData$$ExternalSyntheticLambda2, activityModel.scheduleImpl);
            StringBuilder sb = new StringBuilder();
            sb.append("<b>");
            sb.append(feedsContentFormatter.PlaceComponentResult);
            sb.append("</b> ");
            sb.append(feedsContentFormatter.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(" <b>");
            sb.append(feedsContentFormatter.getAuthRequestContext);
            sb.append("</b> ");
            sb.append(feedsContentFormatter.BuiltInFictitiousFunctionClassFactory);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb.toString());
            Pattern compile = Pattern.compile("<b>.*?</b>", 2);
            byte b = 0;
            boolean z = false;
            while (!z) {
                Matcher matcher = compile.matcher(spannableStringBuilder.toString());
                if (matcher.find()) {
                    spannableStringBuilder.setSpan(new StyleSpan(1), matcher.start(), matcher.end(), 18);
                    spannableStringBuilder.delete(matcher.end() - 4, matcher.end());
                    spannableStringBuilder.delete(matcher.start(), matcher.start() + 3);
                } else {
                    z = true;
                }
            }
            this.content.setText(spannableStringBuilder);
            int i = activityModel.moveToNextValue;
            if (i != -1) {
                this.delete.setText(MyBillsEntityDataFactory(i));
            }
            String PlaceComponentResult = new SimpleTimeConversion(this.MyBillsEntityDataFactory, activityModel.initRecordTimeStamp, "0").PlaceComponentResult();
            if (PlaceComponentResult != null) {
                this.time.setText(PlaceComponentResult);
            }
            String str = activityModel.lookAheadTest;
            if (!TextUtils.isEmpty(str)) {
                if (SvgLoader.getAuthRequestContext(str)) {
                    SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
                    KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = str;
                    KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7;
                    KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = new CircleCrop();
                    KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = this.iconFeeds;
                    new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, b);
                } else {
                    GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).getErrorConfigVersion((int) R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult((int) R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7).MyBillsEntityDataFactory(this.iconFeeds);
                }
            }
            this.delete.setVisibility(this.BuiltInFictitiousFunctionClassFactory);
            this.delete.setText(MyBillsEntityDataFactory(activityModel.moveToNextValue));
            TextView textView = this.delete;
            int i2 = activityModel.moveToNextValue;
            int i3 = -41643;
            if (i2 != 1 && i2 == 2) {
                i3 = -4802890;
            }
            textView.setTextColor(i3);
            this.delete.setOnClickListener(new View.OnClickListener() { // from class: id.dana.feeds.views.FeedsViewHolderFeeds$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedsViewHolderFeeds feedsViewHolderFeeds = FeedsViewHolderFeeds.this;
                    FeedsViewHolderFeeds.FeedsViewHolderActions feedsViewHolderActions = feedsViewHolderFeeds.getAuthRequestContext;
                    if (feedsViewHolderActions != null) {
                        feedsViewHolderActions.KClassImpl$Data$declaredNonStaticMembers$2(feedsViewHolderFeeds.getAdapterPosition(), false);
                    }
                    feedsViewHolderFeeds.getAuthRequestContext.PlaceComponentResult(feedsViewHolderFeeds.getContext(), feedsViewHolderFeeds.getAdapterPosition());
                }
            });
            this.feedWrapper.setOnClickListener(new View.OnClickListener() { // from class: id.dana.feeds.views.FeedsViewHolderFeeds$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedsViewHolderFeeds feedsViewHolderFeeds = FeedsViewHolderFeeds.this;
                    ActivityModel activityModel2 = activityModel;
                    if (!activityModel2.MyBillsEntityDataFactory() || activityModel2.NetworkUserEntityData$$ExternalSyntheticLambda1.isEmpty()) {
                        return;
                    }
                    feedsViewHolderFeeds.getAuthRequestContext.MyBillsEntityDataFactory(activityModel2.NetworkUserEntityData$$ExternalSyntheticLambda1);
                }
            });
        }
    }
}
