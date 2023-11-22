package id.dana.base;

import id.dana.base.BaseRecyclerViewHolder;

/* loaded from: classes4.dex */
public abstract class SingleItemClickListener implements BaseRecyclerViewHolder.OnItemClickListener {
    private final MultipleClickHandler getAuthRequestContext;

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(int i);

    public SingleItemClickListener(MultipleClickHandler multipleClickHandler) {
        this.getAuthRequestContext = multipleClickHandler;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
    public void onItemClick(int i) {
        MultipleClickHandler multipleClickHandler = this.getAuthRequestContext;
        if (multipleClickHandler != null && multipleClickHandler.isClickable()) {
            this.getAuthRequestContext.disableClick();
            KClassImpl$Data$declaredNonStaticMembers$2(i);
        } else if (this.getAuthRequestContext == null) {
            KClassImpl$Data$declaredNonStaticMembers$2(i);
        }
    }
}
