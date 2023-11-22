package org.commonmark.ext.gfm.tables.internal;

import com.alipay.mobile.zebra.data.TextData;
import java.util.Collections;
import java.util.Map;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.Node;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlWriter;

/* loaded from: classes9.dex */
public class TableHtmlNodeRenderer extends TableNodeRenderer {
    private final HtmlNodeRendererContext KClassImpl$Data$declaredNonStaticMembers$2;
    private final HtmlWriter getAuthRequestContext;

    @Override // org.commonmark.ext.gfm.tables.internal.TableNodeRenderer, org.commonmark.renderer.NodeRenderer
    public final /* bridge */ /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Node node) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(node);
    }

    @Override // org.commonmark.ext.gfm.tables.internal.TableNodeRenderer
    protected final void PlaceComponentResult(TableBlock tableBlock) {
        HtmlWriter htmlWriter = this.getAuthRequestContext;
        char c = htmlWriter.getAuthRequestContext;
        if (c != 0 && c != '\n') {
            htmlWriter.PlaceComponentResult("\n");
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("table", this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
        Node node = tableBlock.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(node);
            node = node2;
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("/table", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
        HtmlWriter htmlWriter2 = this.getAuthRequestContext;
        char c2 = htmlWriter2.getAuthRequestContext;
        if (c2 == 0 || c2 == '\n') {
            return;
        }
        htmlWriter2.PlaceComponentResult("\n");
    }

    @Override // org.commonmark.ext.gfm.tables.internal.TableNodeRenderer
    protected final void getAuthRequestContext(TableHead tableHead) {
        HtmlWriter htmlWriter = this.getAuthRequestContext;
        char c = htmlWriter.getAuthRequestContext;
        if (c != 0 && c != '\n') {
            htmlWriter.PlaceComponentResult("\n");
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("thead", this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
        Node node = tableHead.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(node);
            node = node2;
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("/thead", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
        HtmlWriter htmlWriter2 = this.getAuthRequestContext;
        char c2 = htmlWriter2.getAuthRequestContext;
        if (c2 == 0 || c2 == '\n') {
            return;
        }
        htmlWriter2.PlaceComponentResult("\n");
    }

    @Override // org.commonmark.ext.gfm.tables.internal.TableNodeRenderer
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(TableBody tableBody) {
        HtmlWriter htmlWriter = this.getAuthRequestContext;
        char c = htmlWriter.getAuthRequestContext;
        if (c != 0 && c != '\n') {
            htmlWriter.PlaceComponentResult("\n");
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("tbody", this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
        Node node = tableBody.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(node);
            node = node2;
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("/tbody", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
        HtmlWriter htmlWriter2 = this.getAuthRequestContext;
        char c2 = htmlWriter2.getAuthRequestContext;
        if (c2 == 0 || c2 == '\n') {
            return;
        }
        htmlWriter2.PlaceComponentResult("\n");
    }

    @Override // org.commonmark.ext.gfm.tables.internal.TableNodeRenderer
    protected final void PlaceComponentResult(TableRow tableRow) {
        HtmlWriter htmlWriter = this.getAuthRequestContext;
        char c = htmlWriter.getAuthRequestContext;
        if (c != 0 && c != '\n') {
            htmlWriter.PlaceComponentResult("\n");
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("tr", this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
        Node node = tableRow.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(node);
            node = node2;
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("/tr", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
        HtmlWriter htmlWriter2 = this.getAuthRequestContext;
        char c2 = htmlWriter2.getAuthRequestContext;
        if (c2 == 0 || c2 == '\n') {
            return;
        }
        htmlWriter2.PlaceComponentResult("\n");
    }

    @Override // org.commonmark.ext.gfm.tables.internal.TableNodeRenderer
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(TableCell tableCell) {
        Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2;
        String str;
        String str2 = tableCell.PlaceComponentResult() ? "th" : "td";
        HtmlWriter htmlWriter = this.getAuthRequestContext;
        if (tableCell.BuiltInFictitiousFunctionClassFactory != null) {
            HtmlNodeRendererContext htmlNodeRendererContext = this.KClassImpl$Data$declaredNonStaticMembers$2;
            TableCell.Alignment alignment = tableCell.BuiltInFictitiousFunctionClassFactory;
            int i = AnonymousClass1.getAuthRequestContext[alignment.ordinal()];
            if (i == 1) {
                str = "left";
            } else if (i == 2) {
                str = TextData.ALIGN_CENTER;
            } else if (i != 3) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown alignment: ");
                sb.append(alignment);
                throw new IllegalStateException(sb.toString());
            } else {
                str = "right";
            }
            KClassImpl$Data$declaredNonStaticMembers$2 = htmlNodeRendererContext.KClassImpl$Data$declaredNonStaticMembers$2(Collections.singletonMap("align", str));
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap());
        }
        htmlWriter.KClassImpl$Data$declaredNonStaticMembers$2(str2, KClassImpl$Data$declaredNonStaticMembers$2, false);
        Node node = tableCell.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(node);
            node = node2;
        }
        HtmlWriter htmlWriter2 = this.getAuthRequestContext;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/");
        sb2.append(str2);
        htmlWriter2.KClassImpl$Data$declaredNonStaticMembers$2(sb2.toString(), HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
    }

    /* renamed from: org.commonmark.ext.gfm.tables.internal.TableHtmlNodeRenderer$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[TableCell.Alignment.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[TableCell.Alignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[TableCell.Alignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[TableCell.Alignment.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
