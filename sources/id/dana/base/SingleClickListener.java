package id.dana.base;

import android.view.View;

/* loaded from: classes4.dex */
public abstract class SingleClickListener implements View.OnClickListener {
    MultipleClickHandler getAuthRequestContext;

    public abstract void PlaceComponentResult(View view);

    public SingleClickListener(MultipleClickHandler multipleClickHandler) {
        this.getAuthRequestContext = multipleClickHandler;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MultipleClickHandler multipleClickHandler = this.getAuthRequestContext;
        if (multipleClickHandler != null && multipleClickHandler.isClickable()) {
            this.getAuthRequestContext.disableClick();
            PlaceComponentResult(view);
        } else if (this.getAuthRequestContext == null) {
            PlaceComponentResult(view);
        }
    }
}
