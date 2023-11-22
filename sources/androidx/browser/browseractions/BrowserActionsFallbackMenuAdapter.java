package androidx.browser.browseractions;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.R;
import androidx.core.content.res.ResourcesCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@Deprecated
/* loaded from: classes6.dex */
class BrowserActionsFallbackMenuAdapter extends BaseAdapter {
    private final Context PlaceComponentResult;
    private final List<BrowserActionItem> getAuthRequestContext;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.getAuthRequestContext.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.getAuthRequestContext.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolderItem viewHolderItem;
        BrowserActionItem browserActionItem = this.getAuthRequestContext.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.PlaceComponentResult).inflate(R.layout.browser_actions_context_menu_row, (ViewGroup) null);
            ImageView imageView = (ImageView) view.findViewById(R.id.browser_actions_menu_item_icon);
            TextView textView = (TextView) view.findViewById(R.id.browser_actions_menu_item_text);
            if (imageView == null || textView == null) {
                throw new IllegalStateException("Browser Actions fallback UI does not contain necessary Views.");
            }
            viewHolderItem = new ViewHolderItem(imageView, textView);
            view.setTag(viewHolderItem);
        } else {
            viewHolderItem = (ViewHolderItem) view.getTag();
        }
        final String str = browserActionItem.MyBillsEntityDataFactory;
        viewHolderItem.getAuthRequestContext.setText(str);
        if (browserActionItem.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
            viewHolderItem.KClassImpl$Data$declaredNonStaticMembers$2.setImageDrawable(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getResources(), browserActionItem.KClassImpl$Data$declaredNonStaticMembers$2, null));
        } else if (browserActionItem.BuiltInFictitiousFunctionClassFactory != null) {
            final ListenableFuture<Bitmap> loadBitmap = BrowserServiceFileProvider.loadBitmap(this.PlaceComponentResult.getContentResolver(), browserActionItem.BuiltInFictitiousFunctionClassFactory);
            loadBitmap.addListener(new Runnable() { // from class: androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    if (TextUtils.equals(str, viewHolderItem.getAuthRequestContext.getText())) {
                        try {
                            bitmap = (Bitmap) loadBitmap.get();
                        } catch (InterruptedException | ExecutionException unused) {
                            bitmap = null;
                        }
                        if (bitmap != null) {
                            viewHolderItem.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
                            viewHolderItem.KClassImpl$Data$declaredNonStaticMembers$2.setImageBitmap(bitmap);
                            return;
                        }
                        viewHolderItem.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(4);
                        viewHolderItem.KClassImpl$Data$declaredNonStaticMembers$2.setImageBitmap(null);
                    }
                }
            }, new Executor() { // from class: androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter.2
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    runnable.run();
                }
            });
        } else {
            viewHolderItem.KClassImpl$Data$declaredNonStaticMembers$2.setImageBitmap(null);
            viewHolderItem.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(4);
        }
        return view;
    }

    /* loaded from: classes6.dex */
    static class ViewHolderItem {
        final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
        final TextView getAuthRequestContext;

        ViewHolderItem(ImageView imageView, TextView textView) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView;
            this.getAuthRequestContext = textView;
        }
    }
}
