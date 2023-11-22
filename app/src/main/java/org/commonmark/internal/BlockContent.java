package org.commonmark.internal;

/* loaded from: classes6.dex */
class BlockContent {
    private int MyBillsEntityDataFactory;
    final StringBuilder PlaceComponentResult;

    public BlockContent() {
        this.MyBillsEntityDataFactory = 0;
        this.PlaceComponentResult = new StringBuilder();
    }

    public BlockContent(String str) {
        this.MyBillsEntityDataFactory = 0;
        this.PlaceComponentResult = new StringBuilder(str);
    }

    public final void getAuthRequestContext(CharSequence charSequence) {
        if (this.MyBillsEntityDataFactory != 0) {
            this.PlaceComponentResult.append('\n');
        }
        this.PlaceComponentResult.append(charSequence);
        this.MyBillsEntityDataFactory++;
    }
}
