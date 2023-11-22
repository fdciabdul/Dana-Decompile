package org.commonmark.ext.gfm.strikethrough.internal;

import java.io.IOException;
import org.commonmark.node.Node;
import org.commonmark.renderer.text.TextContentNodeRendererContext;
import org.commonmark.renderer.text.TextContentWriter;

/* loaded from: classes9.dex */
public class StrikethroughTextContentNodeRenderer extends StrikethroughNodeRenderer {
    private final TextContentWriter KClassImpl$Data$declaredNonStaticMembers$2;
    private final TextContentNodeRendererContext PlaceComponentResult;

    @Override // org.commonmark.renderer.NodeRenderer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Node node) {
        TextContentWriter textContentWriter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        try {
            textContentWriter.BuiltInFictitiousFunctionClassFactory.append('/');
            textContentWriter.KClassImpl$Data$declaredNonStaticMembers$2 = '/';
            Node node2 = node.getErrorConfigVersion;
            while (node2 != null) {
                Node node3 = node2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                this.PlaceComponentResult.PlaceComponentResult(node2);
                node2 = node3;
            }
            TextContentWriter textContentWriter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            try {
                textContentWriter2.BuiltInFictitiousFunctionClassFactory.append('/');
                textContentWriter2.KClassImpl$Data$declaredNonStaticMembers$2 = '/';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
