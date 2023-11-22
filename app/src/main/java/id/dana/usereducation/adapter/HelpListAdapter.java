package id.dana.usereducation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.core.ui.glide.ShimmerImageAttacherFactory;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.utils.ImageOss;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class HelpListAdapter extends RecyclerView.Adapter<HelpListViewHolder> {
    private List<ContentOnBoardingModel> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(HelpListViewHolder helpListViewHolder, int i) {
        final HelpListViewHolder helpListViewHolder2 = helpListViewHolder;
        final ContentOnBoardingModel contentOnBoardingModel = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
        if (contentOnBoardingModel != null) {
            helpListViewHolder2.tvTitle.setText(HelpListViewHolder.MyBillsEntityDataFactory(contentOnBoardingModel.KClassImpl$Data$declaredNonStaticMembers$2));
            helpListViewHolder2.tvDescription.setText(HelpListViewHolder.MyBillsEntityDataFactory(contentOnBoardingModel.PlaceComponentResult));
            ImageOss.MyBillsEntityDataFactory(contentOnBoardingModel.BuiltInFictitiousFunctionClassFactory, helpListViewHolder2.ivIcon, new ImageOss.EventListener() { // from class: id.dana.usereducation.adapter.HelpListViewHolder$$ExternalSyntheticLambda0
                @Override // id.dana.utils.ImageOss.EventListener
                public final void PlaceComponentResult(String str, ImageView imageView) {
                    new ShimmerImageAttacherFactory().KClassImpl$Data$declaredNonStaticMembers$2(HelpListViewHolder.this.itemView.getContext(), imageView, str, contentOnBoardingModel.getAuthRequestContext);
                }
            });
        }
    }

    public HelpListAdapter(List<ContentOnBoardingModel> list) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.addAll(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ HelpListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new HelpListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_help, viewGroup, false));
    }
}
