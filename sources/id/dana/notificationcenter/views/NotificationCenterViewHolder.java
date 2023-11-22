package id.dana.notificationcenter.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.notificationcenter.model.NotificationDTO;
import id.dana.utils.SimpleTimeConversion;
import ru.noties.markwon.Markwon;

/* loaded from: classes5.dex */
public class NotificationCenterViewHolder extends BaseRecyclerViewHolder<NotificationDTO> {
    private final DynamicUrlWrapper BuiltInFictitiousFunctionClassFactory;
    @BindView(R.id.notification_content)
    TextView content;
    @BindView(R.id.notification_icon)
    ImageView iconNotification;
    @BindView(R.id.notification_badge)
    LinearLayout notificationBadge;
    @BindView(R.id.notification_wrapper)
    RelativeLayout notificationWrapper;
    @BindView(R.id.notification_time)
    TextView time;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(NotificationDTO notificationDTO) {
        NotificationDTO notificationDTO2 = notificationDTO;
        if (notificationDTO2 != null) {
            notificationDTO2.getAuthRequestContext = this.BuiltInFictitiousFunctionClassFactory;
            String str = notificationDTO2.MyBillsEntityDataFactory;
            if (!TextUtils.isEmpty(str)) {
                this.content.setText(new SpannableStringBuilder(Markwon.MyBillsEntityDataFactory(getContext(), str)));
            }
            String PlaceComponentResult = new SimpleTimeConversion(getContext(), notificationDTO2.BuiltInFictitiousFunctionClassFactory, "1").PlaceComponentResult();
            if (!TextUtils.isEmpty(PlaceComponentResult)) {
                this.time.setText(PlaceComponentResult);
            }
            getAuthRequestContext(notificationDTO2.PlaceComponentResult());
            String str2 = notificationDTO2.KClassImpl$Data$declaredNonStaticMembers$2;
            if (!TextUtils.isEmpty(str2)) {
                if (SvgLoader.getAuthRequestContext(str2)) {
                    SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
                    KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = str2;
                    KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7;
                    KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = new CircleCrop();
                    KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = this.iconNotification;
                    new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
                } else {
                    GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str2).getErrorConfigVersion((int) R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult((int) R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7).MyBillsEntityDataFactory(this.iconNotification);
                }
            }
            if (notificationDTO2.getAuthRequestContext() == null || notificationDTO2.getAuthRequestContext().isEmpty()) {
                return;
            }
            getAuthRequestContext(notificationDTO2.PlaceComponentResult());
        }
    }

    public NotificationCenterViewHolder(Context context, ViewGroup viewGroup, DynamicUrlWrapper dynamicUrlWrapper) {
        super(context, R.layout.cardview_notification_center, viewGroup);
        this.BuiltInFictitiousFunctionClassFactory = dynamicUrlWrapper;
    }

    private void getAuthRequestContext(boolean z) {
        this.notificationBadge.setVisibility(z ? 8 : 0);
        this.notificationWrapper.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), z ? R.color.f27072131100488 : R.color.f26572131100334));
    }
}
