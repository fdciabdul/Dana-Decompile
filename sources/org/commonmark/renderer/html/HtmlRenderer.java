package org.commonmark.renderer.html;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.commonmark.Extension;
import org.commonmark.internal.renderer.NodeRendererMap;
import org.commonmark.internal.util.Escaping;
import org.commonmark.node.Node;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.Renderer;

/* loaded from: classes9.dex */
public class HtmlRenderer implements Renderer {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private final String MyBillsEntityDataFactory;
    private final boolean PlaceComponentResult;

    /* renamed from: org.commonmark.renderer.html.HtmlRenderer$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass1 implements HtmlNodeRendererFactory {
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        private String PlaceComponentResult = "\n";
        private boolean BuiltInFictitiousFunctionClassFactory = false;
        private boolean getAuthRequestContext = false;
        private List<AttributeProviderFactory> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        private List<HtmlNodeRendererFactory> MyBillsEntityDataFactory = new ArrayList();
    }

    /* loaded from: classes6.dex */
    public interface HtmlRendererExtension extends Extension {
    }

    /* loaded from: classes9.dex */
    class RendererContext implements HtmlNodeRendererContext, AttributeProviderContext {
        private final NodeRendererMap BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ HtmlRenderer KClassImpl$Data$declaredNonStaticMembers$2;
        private final List<AttributeProvider> PlaceComponentResult;

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public final boolean BuiltInFictitiousFunctionClassFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public final String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
            String PlaceComponentResult;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory) {
                PlaceComponentResult = Escaping.PlaceComponentResult(Escaping.PlaceComponentResult, str, Escaping.scheduleImpl);
                return PlaceComponentResult;
            }
            return str;
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public final Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2(Map<String, String> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            for (AttributeProvider attributeProvider : this.PlaceComponentResult) {
            }
            return linkedHashMap;
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public final String PlaceComponentResult() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public final void PlaceComponentResult(Node node) {
            NodeRenderer nodeRenderer = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.get(node.getClass());
            if (nodeRenderer != null) {
                nodeRenderer.KClassImpl$Data$declaredNonStaticMembers$2(node);
            }
        }
    }
}
