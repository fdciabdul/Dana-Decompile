package org.commonmark.ext.gfm.strikethrough.internal;

import java.util.Collections;
import org.commonmark.node.Node;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlWriter;

/* loaded from: classes9.dex */
public class StrikethroughHtmlNodeRenderer extends StrikethroughNodeRenderer {
    private final HtmlWriter KClassImpl$Data$declaredNonStaticMembers$2;
    private final HtmlNodeRendererContext getAuthRequestContext;

    @Override // org.commonmark.renderer.NodeRenderer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Node node) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("del", this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
        Node node2 = node.getErrorConfigVersion;
        while (node2 != null) {
            Node node3 = node2.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.getAuthRequestContext.PlaceComponentResult(node2);
            node2 = node3;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("/del", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
    }
}
