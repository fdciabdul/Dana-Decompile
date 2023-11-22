package org.commonmark.renderer.html;

import com.caverock.androidsvg.SVGParser;
import id.dana.data.constant.BranchLinkConstant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.commonmark.internal.util.Escaping;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import org.commonmark.renderer.NodeRenderer;

/* loaded from: classes9.dex */
public class CoreHtmlNodeRenderer extends AbstractVisitor implements NodeRenderer {
    protected final HtmlNodeRendererContext BuiltInFictitiousFunctionClassFactory;
    private final HtmlWriter PlaceComponentResult;

    @Override // org.commonmark.renderer.NodeRenderer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Node node) {
        node.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void MyBillsEntityDataFactory(Heading heading) {
        StringBuilder sb = new StringBuilder();
        sb.append("h");
        sb.append(heading.getAuthRequestContext);
        String obj = sb.toString();
        HtmlWriter htmlWriter = this.PlaceComponentResult;
        char c = htmlWriter.getAuthRequestContext;
        if (c != 0 && c != '\n') {
            htmlWriter.PlaceComponentResult("\n");
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(obj, this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
        Node node = heading.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(node);
            node = node2;
        }
        HtmlWriter htmlWriter2 = this.PlaceComponentResult;
        StringBuilder sb2 = new StringBuilder();
        sb2.append('/');
        sb2.append(obj);
        htmlWriter2.KClassImpl$Data$declaredNonStaticMembers$2(sb2.toString(), HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
        HtmlWriter htmlWriter3 = this.PlaceComponentResult;
        char c2 = htmlWriter3.getAuthRequestContext;
        if (c2 == 0 || c2 == '\n') {
            return;
        }
        htmlWriter3.PlaceComponentResult("\n");
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void PlaceComponentResult(Paragraph paragraph) {
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(paragraph);
        if (!KClassImpl$Data$declaredNonStaticMembers$2) {
            HtmlWriter htmlWriter = this.PlaceComponentResult;
            char c = htmlWriter.getAuthRequestContext;
            if (c != 0 && c != '\n') {
                htmlWriter.PlaceComponentResult("\n");
            }
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(BranchLinkConstant.PayloadKey.PROMO_CODE, this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
        }
        Node node = paragraph.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(node);
            node = node2;
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("/p", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
        HtmlWriter htmlWriter2 = this.PlaceComponentResult;
        char c2 = htmlWriter2.getAuthRequestContext;
        if (c2 == 0 || c2 == '\n') {
            return;
        }
        htmlWriter2.PlaceComponentResult("\n");
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(BlockQuote blockQuote) {
        HtmlWriter htmlWriter = this.PlaceComponentResult;
        char c = htmlWriter.getAuthRequestContext;
        if (c != 0 && c != '\n') {
            htmlWriter.PlaceComponentResult("\n");
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("blockquote", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
        HtmlWriter htmlWriter2 = this.PlaceComponentResult;
        char c2 = htmlWriter2.getAuthRequestContext;
        if (c2 != 0 && c2 != '\n') {
            htmlWriter2.PlaceComponentResult("\n");
        }
        Node node = blockQuote.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(node);
            node = node2;
        }
        HtmlWriter htmlWriter3 = this.PlaceComponentResult;
        char c3 = htmlWriter3.getAuthRequestContext;
        if (c3 != 0 && c3 != '\n') {
            htmlWriter3.PlaceComponentResult("\n");
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("/blockquote", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
        HtmlWriter htmlWriter4 = this.PlaceComponentResult;
        char c4 = htmlWriter4.getAuthRequestContext;
        if (c4 == 0 || c4 == '\n') {
            return;
        }
        htmlWriter4.PlaceComponentResult("\n");
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void PlaceComponentResult(HtmlBlock htmlBlock) {
        HtmlWriter htmlWriter = this.PlaceComponentResult;
        char c = htmlWriter.getAuthRequestContext;
        if (c != 0 && c != '\n') {
            htmlWriter.PlaceComponentResult("\n");
        }
        if (this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory()) {
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(BranchLinkConstant.PayloadKey.PROMO_CODE, this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
            this.PlaceComponentResult.PlaceComponentResult(Escaping.MyBillsEntityDataFactory(htmlBlock.MyBillsEntityDataFactory, false));
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("/p", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
        } else {
            this.PlaceComponentResult.PlaceComponentResult(htmlBlock.MyBillsEntityDataFactory);
        }
        HtmlWriter htmlWriter2 = this.PlaceComponentResult;
        char c2 = htmlWriter2.getAuthRequestContext;
        if (c2 == 0 || c2 == '\n') {
            return;
        }
        htmlWriter2.PlaceComponentResult("\n");
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void PlaceComponentResult(ThematicBreak thematicBreak) {
        HtmlWriter htmlWriter = this.PlaceComponentResult;
        char c = htmlWriter.getAuthRequestContext;
        if (c != 0 && c != '\n') {
            htmlWriter.PlaceComponentResult("\n");
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("hr", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), true);
        HtmlWriter htmlWriter2 = this.PlaceComponentResult;
        char c2 = htmlWriter2.getAuthRequestContext;
        if (c2 == 0 || c2 == '\n') {
            return;
        }
        htmlWriter2.PlaceComponentResult("\n");
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Link link) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SVGParser.XML_STYLESHEET_ATTR_HREF, this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(link.BuiltInFictitiousFunctionClassFactory));
        if (link.PlaceComponentResult != null) {
            linkedHashMap.put("title", link.PlaceComponentResult);
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("a", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(linkedHashMap), false);
        Node node = link.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(node);
            node = node2;
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("/a", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(ListItem listItem) {
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("li", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
        Node node = listItem.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(node);
            node = node2;
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("/li", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
        HtmlWriter htmlWriter = this.PlaceComponentResult;
        char c = htmlWriter.getAuthRequestContext;
        if (c == 0 || c == '\n') {
            return;
        }
        htmlWriter.PlaceComponentResult("\n");
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(Image image) {
        String KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(image.PlaceComponentResult);
        AltTextVisitor altTextVisitor = new AltTextVisitor((byte) 0);
        altTextVisitor.getAuthRequestContext(image);
        String obj = altTextVisitor.BuiltInFictitiousFunctionClassFactory.toString();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("src", KClassImpl$Data$declaredNonStaticMembers$2);
        linkedHashMap.put("alt", obj);
        if (image.MyBillsEntityDataFactory != null) {
            linkedHashMap.put("title", image.MyBillsEntityDataFactory);
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("img", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(linkedHashMap), true);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void PlaceComponentResult(Emphasis emphasis) {
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("em", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
        Node node = emphasis.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(node);
            node = node2;
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("/em", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void MyBillsEntityDataFactory(StrongEmphasis strongEmphasis) {
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("strong", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
        Node node = strongEmphasis.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(node);
            node = node2;
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("/strong", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(Text text) {
        this.PlaceComponentResult.PlaceComponentResult(Escaping.MyBillsEntityDataFactory(text.PlaceComponentResult, false));
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(Code code) {
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("code", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
        this.PlaceComponentResult.PlaceComponentResult(Escaping.MyBillsEntityDataFactory(code.MyBillsEntityDataFactory, false));
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("/code", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(HtmlInline htmlInline) {
        if (this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory()) {
            this.PlaceComponentResult.PlaceComponentResult(Escaping.MyBillsEntityDataFactory(htmlInline.KClassImpl$Data$declaredNonStaticMembers$2, false));
        } else {
            this.PlaceComponentResult.PlaceComponentResult(htmlInline.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(SoftLineBreak softLineBreak) {
        this.PlaceComponentResult.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void MyBillsEntityDataFactory(HardLineBreak hardLineBreak) {
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("br", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), true);
        HtmlWriter htmlWriter = this.PlaceComponentResult;
        char c = htmlWriter.getAuthRequestContext;
        if (c == 0 || c == '\n') {
            return;
        }
        htmlWriter.PlaceComponentResult("\n");
    }

    private void PlaceComponentResult(String str, Node node, Map<String, String> map) {
        HtmlWriter htmlWriter = this.PlaceComponentResult;
        char c = htmlWriter.getAuthRequestContext;
        if (c != 0 && c != '\n') {
            htmlWriter.PlaceComponentResult("\n");
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("pre", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()), false);
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("code", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(map), false);
        this.PlaceComponentResult.PlaceComponentResult(Escaping.MyBillsEntityDataFactory(str, false));
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("/code", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("/pre", HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
        HtmlWriter htmlWriter2 = this.PlaceComponentResult;
        char c2 = htmlWriter2.getAuthRequestContext;
        if (c2 == 0 || c2 == '\n') {
            return;
        }
        htmlWriter2.PlaceComponentResult("\n");
    }

    private void getAuthRequestContext(ListBlock listBlock, String str, Map<String, String> map) {
        HtmlWriter htmlWriter = this.PlaceComponentResult;
        char c = htmlWriter.getAuthRequestContext;
        if (c != 0 && c != '\n') {
            htmlWriter.PlaceComponentResult("\n");
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(str, map, false);
        HtmlWriter htmlWriter2 = this.PlaceComponentResult;
        char c2 = htmlWriter2.getAuthRequestContext;
        if (c2 != 0 && c2 != '\n') {
            htmlWriter2.PlaceComponentResult("\n");
        }
        Node node = listBlock.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(node);
            node = node2;
        }
        HtmlWriter htmlWriter3 = this.PlaceComponentResult;
        char c3 = htmlWriter3.getAuthRequestContext;
        if (c3 != 0 && c3 != '\n') {
            htmlWriter3.PlaceComponentResult("\n");
        }
        HtmlWriter htmlWriter4 = this.PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        sb.append(str);
        htmlWriter4.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString(), HtmlWriter.BuiltInFictitiousFunctionClassFactory, false);
        HtmlWriter htmlWriter5 = this.PlaceComponentResult;
        char c4 = htmlWriter5.getAuthRequestContext;
        if (c4 == 0 || c4 == '\n') {
            return;
        }
        htmlWriter5.PlaceComponentResult("\n");
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Paragraph paragraph) {
        Node authRequestContext;
        Block MyBillsEntityDataFactory = paragraph.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory == null || (authRequestContext = MyBillsEntityDataFactory.getAuthRequestContext()) == null || !(authRequestContext instanceof ListBlock)) {
            return false;
        }
        return ((ListBlock) authRequestContext).PlaceComponentResult();
    }

    /* loaded from: classes9.dex */
    static class AltTextVisitor extends AbstractVisitor {
        final StringBuilder BuiltInFictitiousFunctionClassFactory;

        private AltTextVisitor() {
            this.BuiltInFictitiousFunctionClassFactory = new StringBuilder();
        }

        /* synthetic */ AltTextVisitor(byte b) {
            this();
        }

        @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
        public final void BuiltInFictitiousFunctionClassFactory(Text text) {
            this.BuiltInFictitiousFunctionClassFactory.append(text.PlaceComponentResult);
        }

        @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
        public final void getAuthRequestContext(SoftLineBreak softLineBreak) {
            this.BuiltInFictitiousFunctionClassFactory.append('\n');
        }

        @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
        public final void MyBillsEntityDataFactory(HardLineBreak hardLineBreak) {
            this.BuiltInFictitiousFunctionClassFactory.append('\n');
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(BulletList bulletList) {
        getAuthRequestContext(bulletList, "ul", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyMap()));
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(Document document) {
        Node node = document.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(node);
            node = node2;
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(FencedCodeBlock fencedCodeBlock) {
        String str = fencedCodeBlock.PlaceComponentResult;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str2 = fencedCodeBlock.MyBillsEntityDataFactory;
        if (str2 != null && !str2.isEmpty()) {
            int indexOf = str2.indexOf(" ");
            if (indexOf != -1) {
                str2 = str2.substring(0, indexOf);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("language-");
            sb.append(str2);
            linkedHashMap.put("class", sb.toString());
        }
        PlaceComponentResult(str, fencedCodeBlock, linkedHashMap);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void MyBillsEntityDataFactory(IndentedCodeBlock indentedCodeBlock) {
        PlaceComponentResult(indentedCodeBlock.BuiltInFictitiousFunctionClassFactory, indentedCodeBlock, Collections.emptyMap());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(OrderedList orderedList) {
        int i = orderedList.getAuthRequestContext;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (i != 1) {
            linkedHashMap.put("start", String.valueOf(i));
        }
        getAuthRequestContext(orderedList, "ol", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(linkedHashMap));
    }

    @Override // org.commonmark.node.AbstractVisitor
    public final void getAuthRequestContext(Node node) {
        Node node2 = node.getErrorConfigVersion;
        while (node2 != null) {
            Node node3 = node2.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(node2);
            node2 = node3;
        }
    }
}
