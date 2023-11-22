package com.alibaba.griver.base.api;

/* loaded from: classes3.dex */
public interface INebulaPage {

    /* loaded from: classes3.dex */
    public interface H5PageHandler {
        boolean shouldExit();
    }

    H5EmbededViewProvider getEmbededViewProvider();

    Object getExtra(String str);

    APWebView getWebView();

    boolean ifContainsEmbedSurfaceView();

    boolean ifContainsEmbedView();

    void setContainsEmbedSurfaceView(boolean z);

    void setContainsEmbedView(boolean z);

    void setExtra(String str, Object obj);

    void setHandler(H5PageHandler h5PageHandler);
}
