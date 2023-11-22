package id.dana.tutorial.viewholders;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.tutorial.model.TutorialModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/tutorial/viewholders/TutorialViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/tutorial/model/TutorialModel;", "Landroid/content/Context;", "p0", "Landroid/view/ViewGroup;", "p1", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class TutorialViewHolder extends BaseRecyclerViewHolder<TutorialModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(TutorialModel tutorialModel) {
        String str;
        TutorialModel tutorialModel2 = tutorialModel;
        Intrinsics.checkNotNullParameter(tutorialModel2, "");
        super.bindData(tutorialModel2);
        if (tutorialModel2 != null && (str = tutorialModel2.BuiltInFictitiousFunctionClassFactory) != null) {
            if (SvgLoader.getAuthRequestContext(str)) {
                SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
                KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = str;
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7;
                KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = new FitCenter();
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (AppCompatImageView) this.itemView.findViewById(R.id.BottomSheetType);
                new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, r1);
            } else {
                GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).getErrorConfigVersion((int) R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7).PlaceComponentResult((int) R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7).whenAvailable().MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) this.itemView.findViewById(R.id.BottomSheetType)));
            }
        }
        Boolean bool = tutorialModel2.getErrorConfigVersion;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            TextView textView = (TextView) this.itemView.findViewById(R.id.res_0x7f0a1965_ocrcameramodule_provideocrrequestmodel_app_productionreleasefactory);
            if (textView != null) {
                Intrinsics.checkNotNullExpressionValue(textView, "");
                textView.setVisibility(booleanValue ? (byte) 0 : (byte) 8);
            }
        }
        TextView textView2 = (TextView) this.itemView.findViewById(R.id.tv_tutorial_title);
        if (textView2 != null) {
            textView2.setText(tutorialModel2.lookAheadTest);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TutorialViewHolder(Context context, ViewGroup viewGroup) {
        super(context, R.layout.tutorial_viewholder, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
