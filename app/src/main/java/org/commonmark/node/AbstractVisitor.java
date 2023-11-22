package org.commonmark.node;

/* loaded from: classes6.dex */
public abstract class AbstractVisitor implements Visitor {
    @Override // org.commonmark.node.Visitor
    public void BuiltInFictitiousFunctionClassFactory(BlockQuote blockQuote) {
        getAuthRequestContext(blockQuote);
    }

    @Override // org.commonmark.node.Visitor
    public void BuiltInFictitiousFunctionClassFactory(BulletList bulletList) {
        getAuthRequestContext(bulletList);
    }

    @Override // org.commonmark.node.Visitor
    public void BuiltInFictitiousFunctionClassFactory(Code code) {
        getAuthRequestContext(code);
    }

    @Override // org.commonmark.node.Visitor
    public void BuiltInFictitiousFunctionClassFactory(Document document) {
        getAuthRequestContext(document);
    }

    @Override // org.commonmark.node.Visitor
    public void PlaceComponentResult(Emphasis emphasis) {
        getAuthRequestContext(emphasis);
    }

    @Override // org.commonmark.node.Visitor
    public void getAuthRequestContext(FencedCodeBlock fencedCodeBlock) {
        getAuthRequestContext((Node) fencedCodeBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void MyBillsEntityDataFactory(HardLineBreak hardLineBreak) {
        getAuthRequestContext(hardLineBreak);
    }

    @Override // org.commonmark.node.Visitor
    public void MyBillsEntityDataFactory(Heading heading) {
        getAuthRequestContext(heading);
    }

    @Override // org.commonmark.node.Visitor
    public void PlaceComponentResult(ThematicBreak thematicBreak) {
        getAuthRequestContext(thematicBreak);
    }

    @Override // org.commonmark.node.Visitor
    public void BuiltInFictitiousFunctionClassFactory(HtmlInline htmlInline) {
        getAuthRequestContext(htmlInline);
    }

    @Override // org.commonmark.node.Visitor
    public void PlaceComponentResult(HtmlBlock htmlBlock) {
        getAuthRequestContext(htmlBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void getAuthRequestContext(Image image) {
        getAuthRequestContext((Node) image);
    }

    @Override // org.commonmark.node.Visitor
    public void MyBillsEntityDataFactory(IndentedCodeBlock indentedCodeBlock) {
        getAuthRequestContext(indentedCodeBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void KClassImpl$Data$declaredNonStaticMembers$2(Link link) {
        getAuthRequestContext(link);
    }

    @Override // org.commonmark.node.Visitor
    public void getAuthRequestContext(ListItem listItem) {
        getAuthRequestContext((Node) listItem);
    }

    @Override // org.commonmark.node.Visitor
    public void getAuthRequestContext(OrderedList orderedList) {
        getAuthRequestContext((Node) orderedList);
    }

    @Override // org.commonmark.node.Visitor
    public void PlaceComponentResult(Paragraph paragraph) {
        getAuthRequestContext(paragraph);
    }

    @Override // org.commonmark.node.Visitor
    public void getAuthRequestContext(SoftLineBreak softLineBreak) {
        getAuthRequestContext((Node) softLineBreak);
    }

    @Override // org.commonmark.node.Visitor
    public void MyBillsEntityDataFactory(StrongEmphasis strongEmphasis) {
        getAuthRequestContext(strongEmphasis);
    }

    @Override // org.commonmark.node.Visitor
    public void BuiltInFictitiousFunctionClassFactory(Text text) {
        getAuthRequestContext(text);
    }

    @Override // org.commonmark.node.Visitor
    public void KClassImpl$Data$declaredNonStaticMembers$2(CustomBlock customBlock) {
        getAuthRequestContext(customBlock);
    }

    @Override // org.commonmark.node.Visitor
    public void getAuthRequestContext(CustomNode customNode) {
        getAuthRequestContext((Node) customNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getAuthRequestContext(Node node) {
        Node node2 = node.getErrorConfigVersion;
        while (node2 != null) {
            Node node3 = node2.NetworkUserEntityData$$ExternalSyntheticLambda0;
            node2.KClassImpl$Data$declaredNonStaticMembers$2(this);
            node2 = node3;
        }
    }
}
