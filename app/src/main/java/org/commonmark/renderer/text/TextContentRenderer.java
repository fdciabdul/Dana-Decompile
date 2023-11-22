package org.commonmark.renderer.text;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.Extension;
import org.commonmark.internal.renderer.NodeRendererMap;
import org.commonmark.node.Node;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.Renderer;

/* loaded from: classes9.dex */
public class TextContentRenderer implements Renderer {
    private final boolean getAuthRequestContext;

    /* renamed from: org.commonmark.renderer.text.TextContentRenderer$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass1 implements TextContentNodeRendererFactory {
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        private boolean MyBillsEntityDataFactory = false;
        private List<TextContentNodeRendererFactory> getAuthRequestContext = new ArrayList();
    }

    /* loaded from: classes6.dex */
    public interface TextContentRendererExtension extends Extension {
    }

    /* loaded from: classes9.dex */
    class RendererContext implements TextContentNodeRendererContext {
        final /* synthetic */ TextContentRenderer BuiltInFictitiousFunctionClassFactory;
        private final NodeRendererMap getAuthRequestContext;

        @Override // org.commonmark.renderer.text.TextContentNodeRendererContext
        public final boolean getAuthRequestContext() {
            return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
        }

        @Override // org.commonmark.renderer.text.TextContentNodeRendererContext
        public final void PlaceComponentResult(Node node) {
            NodeRenderer nodeRenderer = this.getAuthRequestContext.getAuthRequestContext.get(node.getClass());
            if (nodeRenderer != null) {
                nodeRenderer.KClassImpl$Data$declaredNonStaticMembers$2(node);
            }
        }
    }
}
