package id.dana.social.adapter.friendsheader;

import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class LoadMoreViewHolder_ViewBinding implements Unbinder {
    private LoadMoreViewHolder BuiltInFictitiousFunctionClassFactory;

    public LoadMoreViewHolder_ViewBinding(LoadMoreViewHolder loadMoreViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = loadMoreViewHolder;
        loadMoreViewHolder.btnLoadMore = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_loadmore, "field 'btnLoadMore'", Button.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        LoadMoreViewHolder loadMoreViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (loadMoreViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        loadMoreViewHolder.btnLoadMore = null;
    }
}
