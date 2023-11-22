package org.commonmark.internal.renderer.text;

/* loaded from: classes9.dex */
public abstract class ListHolder {
    public final ListHolder KClassImpl$Data$declaredNonStaticMembers$2;
    public final String MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListHolder(ListHolder listHolder) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = listHolder;
        if (listHolder != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(listHolder.MyBillsEntityDataFactory);
            sb.append("   ");
            this.MyBillsEntityDataFactory = sb.toString();
            return;
        }
        this.MyBillsEntityDataFactory = "";
    }
}
