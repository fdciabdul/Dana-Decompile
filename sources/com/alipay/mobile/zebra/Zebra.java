package com.alipay.mobile.zebra;

import android.content.Context;
import android.view.View;
import com.alipay.mobile.zebra.core.ZebraOption;
import com.alipay.mobile.zebra.core.ZebraParser;
import com.alipay.mobile.zebra.data.ZebraData;
import com.alipay.mobile.zebra.internal.ZebraLog;
import com.alipay.mobile.zebra.layout.ZebraLayout;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class Zebra {

    /* loaded from: classes7.dex */
    public interface OnClickCallback {
        void onClick(View view, ZebraData<? extends ZebraLayout> zebraData, ZebraLayout<? extends ZebraData> zebraLayout);
    }

    /* loaded from: classes7.dex */
    public interface OnLoadCallback {
        void onLoad(View view, ZebraData<? extends ZebraLayout> zebraData, ZebraLayout<? extends ZebraData> zebraLayout);
    }

    /* loaded from: classes7.dex */
    public interface OnUpdateCallback {
        void onUpdate(View view, ZebraData<? extends ZebraLayout> zebraData, ZebraLayout<? extends ZebraData> zebraLayout);
    }

    public static View load(Context context, String str) {
        return load(context, str, ZebraOption.NORMAL);
    }

    public static View load(Context context, String str, ZebraLoader zebraLoader) {
        return load(context, str, ZebraOption.NORMAL, zebraLoader, null);
    }

    public static View load(Context context, String str, ZebraOption zebraOption) {
        return load(context, str, zebraOption, (ZebraLoader) null);
    }

    public static View load(Context context, String str, ZebraOption zebraOption, ZebraLoader zebraLoader) {
        return load(context, str, zebraOption, zebraLoader, null);
    }

    public static View load(Context context, String str, ZebraLoader zebraLoader, OnLoadCallback onLoadCallback) {
        return load(context, str, ZebraOption.NORMAL, zebraLoader, onLoadCallback);
    }

    public static View load(Context context, String str, ZebraOption zebraOption, ZebraLoader zebraLoader, OnLoadCallback onLoadCallback) {
        try {
            ZebraData parse = ZebraParser.INSTANCE.parse(str, zebraOption);
            View render = parse.render(context);
            parse.setOnLoadCallback(onLoadCallback);
            parse.loadResource(zebraLoader);
            return render;
        } catch (Throwable th) {
            ZebraLog.e("Zebra", th);
            return null;
        }
    }

    public static ZebraData<? extends ZebraLayout> parse(String str) {
        try {
            return ZebraParser.INSTANCE.parse(str, ZebraOption.NORMAL);
        } catch (Throwable th) {
            ZebraLog.e("Zebra", th);
            return null;
        }
    }

    public static ZebraData<? extends ZebraLayout> parse(String str, ZebraOption zebraOption) {
        try {
            return ZebraParser.INSTANCE.parse(str, zebraOption);
        } catch (Throwable th) {
            ZebraLog.e("Zebra", th);
            return null;
        }
    }

    public static View render(Context context, ZebraData<? extends ZebraLayout> zebraData, ZebraLoader zebraLoader) {
        return render(context, zebraData, zebraLoader, null);
    }

    public static View render(Context context, ZebraData<? extends ZebraLayout> zebraData, ZebraLoader zebraLoader, OnLoadCallback onLoadCallback) {
        if (zebraData == null) {
            return null;
        }
        try {
            View render = zebraData.render(context);
            zebraData.setOnLoadCallback(onLoadCallback);
            zebraData.loadResource(zebraLoader);
            return render;
        } catch (Throwable th) {
            ZebraLog.e("Zebra", th);
            return null;
        }
    }

    public static ZebraData<? extends ZebraLayout> getDataContext(View view) {
        if (view == null || !(view.getTag() instanceof ZebraData)) {
            return null;
        }
        return (ZebraData) view.getTag();
    }

    public static ZebraLayout<? extends ZebraData> getLayoutContext(View view) {
        ZebraData<? extends ZebraLayout> dataContext = getDataContext(view);
        if (dataContext != null) {
            return dataContext.getLayoutContext();
        }
        return null;
    }

    public static View getRootView(View view) {
        ZebraData<? extends ZebraLayout> dataContext = getDataContext(view);
        if (dataContext == null) {
            return null;
        }
        while (dataContext.getParent() != null) {
            dataContext = dataContext.getParent();
        }
        return dataContext.getLayoutContext().getRenderContext();
    }

    public static void bindOnClickCallback(View view, OnClickCallback onClickCallback) {
        bindOnClickCallback(getDataContext(view), onClickCallback);
    }

    protected static void bindOnClickCallback(final ZebraData<? extends ZebraLayout> zebraData, final OnClickCallback onClickCallback) {
        if (zebraData == null) {
            return;
        }
        if (zebraData.isClickable() && zebraData.getId() != null) {
            final ZebraLayout layoutContext = zebraData.getLayoutContext();
            final View renderContext = layoutContext != null ? layoutContext.getRenderContext() : null;
            if (renderContext != null) {
                renderContext.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.zebra.Zebra.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OnClickCallback onClickCallback2 = OnClickCallback.this;
                        if (onClickCallback2 != null) {
                            onClickCallback2.onClick(renderContext, zebraData, layoutContext);
                        }
                    }
                });
            }
        }
        Iterator<ZebraData> it = zebraData.getChildren().iterator();
        while (it.hasNext()) {
            bindOnClickCallback(it.next(), onClickCallback);
        }
    }

    public static boolean canUpdate(View view) {
        return canUpdate(getDataContext(view));
    }

    protected static boolean canUpdate(ZebraData<? extends ZebraLayout> zebraData) {
        if (zebraData == null) {
            return false;
        }
        if (zebraData.canUpdate()) {
            return true;
        }
        Iterator<ZebraData> it = zebraData.getChildren().iterator();
        while (it.hasNext()) {
            if (canUpdate(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void bindOnUpdateCallback(View view, OnUpdateCallback onUpdateCallback) {
        bindOnUpdateCallback(getDataContext(view), onUpdateCallback);
    }

    protected static void bindOnUpdateCallback(ZebraData<? extends ZebraLayout> zebraData, final OnUpdateCallback onUpdateCallback) {
        if (zebraData == null) {
            return;
        }
        if (zebraData.canUpdate()) {
            zebraData.setOnUpdateCallback(new OnUpdateCallback() { // from class: com.alipay.mobile.zebra.Zebra.2
                @Override // com.alipay.mobile.zebra.Zebra.OnUpdateCallback
                public final void onUpdate(View view, ZebraData<? extends ZebraLayout> zebraData2, ZebraLayout<? extends ZebraData> zebraLayout) {
                    OnUpdateCallback onUpdateCallback2 = OnUpdateCallback.this;
                    if (onUpdateCallback2 != null) {
                        onUpdateCallback2.onUpdate(view, zebraData2, zebraLayout);
                    }
                }
            });
        }
        Iterator<ZebraData> it = zebraData.getChildren().iterator();
        while (it.hasNext()) {
            bindOnUpdateCallback(it.next(), onUpdateCallback);
        }
    }

    public static boolean isAllReady(View view) {
        return isAllReady(getDataContext(view));
    }

    protected static boolean isAllReady(ZebraData<? extends ZebraLayout> zebraData) {
        if (zebraData == null || !zebraData.isReady()) {
            return false;
        }
        Iterator<ZebraData> it = zebraData.getChildren().iterator();
        while (it.hasNext()) {
            if (!isAllReady(it.next())) {
                return false;
            }
        }
        return true;
    }
}
