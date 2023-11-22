package org.commonmark.internal.renderer.text;

import org.commonmark.node.BulletList;

/* loaded from: classes9.dex */
public class BulletListHolder extends ListHolder {
    private final char getAuthRequestContext;

    public BulletListHolder(ListHolder listHolder, BulletList bulletList) {
        super(listHolder);
        this.getAuthRequestContext = bulletList.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final char getAuthRequestContext() {
        return this.getAuthRequestContext;
    }
}
