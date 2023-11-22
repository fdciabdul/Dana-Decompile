package org.commonmark.renderer.text;

import id.dana.cashier.view.InputCardNumberView;
import java.io.IOException;
import kotlin.text.Typography;
import org.commonmark.internal.renderer.text.BulletListHolder;
import org.commonmark.internal.renderer.text.ListHolder;
import org.commonmark.internal.renderer.text.OrderedListHolder;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import org.commonmark.renderer.NodeRenderer;

/* loaded from: classes9.dex */
public class CoreTextContentNodeRenderer extends AbstractVisitor implements NodeRenderer {
    protected final TextContentNodeRendererContext MyBillsEntityDataFactory;
    private ListHolder PlaceComponentResult;
    private final TextContentWriter getAuthRequestContext;

    @Override // org.commonmark.renderer.NodeRenderer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Node node) {
        node.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(BlockQuote blockQuote) {
        TextContentWriter textContentWriter = this.getAuthRequestContext;
        try {
            textContentWriter.BuiltInFictitiousFunctionClassFactory.append((char) 171);
            textContentWriter.KClassImpl$Data$declaredNonStaticMembers$2 = (char) 171;
            Node node = blockQuote.getErrorConfigVersion;
            while (node != null) {
                Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
                this.MyBillsEntityDataFactory.PlaceComponentResult(node);
                node = node2;
            }
            TextContentWriter textContentWriter2 = this.getAuthRequestContext;
            try {
                textContentWriter2.BuiltInFictitiousFunctionClassFactory.append((char) 187);
                textContentWriter2.KClassImpl$Data$declaredNonStaticMembers$2 = (char) 187;
                MyBillsEntityDataFactory(blockQuote, null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(BulletList bulletList) {
        if (this.PlaceComponentResult != null) {
            PlaceComponentResult();
        }
        this.PlaceComponentResult = new BulletListHolder(this.PlaceComponentResult, bulletList);
        Node node = bulletList.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.MyBillsEntityDataFactory.PlaceComponentResult(node);
            node = node2;
        }
        MyBillsEntityDataFactory(bulletList, null);
        if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            this.PlaceComponentResult = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        } else {
            this.PlaceComponentResult = null;
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(Code code) {
        TextContentWriter textContentWriter = this.getAuthRequestContext;
        try {
            textContentWriter.BuiltInFictitiousFunctionClassFactory.append(Typography.quote);
            textContentWriter.KClassImpl$Data$declaredNonStaticMembers$2 = Typography.quote;
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(code.MyBillsEntityDataFactory);
            TextContentWriter textContentWriter2 = this.getAuthRequestContext;
            try {
                textContentWriter2.BuiltInFictitiousFunctionClassFactory.append(Typography.quote);
                textContentWriter2.KClassImpl$Data$declaredNonStaticMembers$2 = Typography.quote;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(FencedCodeBlock fencedCodeBlock) {
        if (this.MyBillsEntityDataFactory.getAuthRequestContext()) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(fencedCodeBlock.PlaceComponentResult.replaceAll("[\\r\\n\\s]+", " "));
            MyBillsEntityDataFactory(fencedCodeBlock, null);
            return;
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(fencedCodeBlock.PlaceComponentResult);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void MyBillsEntityDataFactory(HardLineBreak hardLineBreak) {
        MyBillsEntityDataFactory(hardLineBreak, null);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void PlaceComponentResult(ThematicBreak thematicBreak) {
        if (!this.MyBillsEntityDataFactory.getAuthRequestContext()) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("***");
        }
        MyBillsEntityDataFactory(thematicBreak, null);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void MyBillsEntityDataFactory(IndentedCodeBlock indentedCodeBlock) {
        if (this.MyBillsEntityDataFactory.getAuthRequestContext()) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(indentedCodeBlock.BuiltInFictitiousFunctionClassFactory.replaceAll("[\\r\\n\\s]+", " "));
            MyBillsEntityDataFactory(indentedCodeBlock, null);
            return;
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(indentedCodeBlock.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(ListItem listItem) {
        ListHolder listHolder = this.PlaceComponentResult;
        if (listHolder != null && (listHolder instanceof OrderedListHolder)) {
            OrderedListHolder orderedListHolder = (OrderedListHolder) listHolder;
            String str = this.MyBillsEntityDataFactory.getAuthRequestContext() ? "" : orderedListHolder.MyBillsEntityDataFactory;
            TextContentWriter textContentWriter = this.getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(orderedListHolder.PlaceComponentResult);
            sb.append(orderedListHolder.BuiltInFictitiousFunctionClassFactory());
            sb.append(" ");
            textContentWriter.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
            Node node = listItem.getErrorConfigVersion;
            while (node != null) {
                Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
                this.MyBillsEntityDataFactory.PlaceComponentResult(node);
                node = node2;
            }
            MyBillsEntityDataFactory(listItem, null);
            orderedListHolder.PlaceComponentResult++;
        } else if (listHolder == null || !(listHolder instanceof BulletListHolder)) {
        } else {
            BulletListHolder bulletListHolder = (BulletListHolder) listHolder;
            if (!this.MyBillsEntityDataFactory.getAuthRequestContext()) {
                TextContentWriter textContentWriter2 = this.getAuthRequestContext;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(bulletListHolder.MyBillsEntityDataFactory);
                sb2.append(bulletListHolder.getAuthRequestContext());
                sb2.append(" ");
                textContentWriter2.KClassImpl$Data$declaredNonStaticMembers$2(sb2.toString());
            }
            Node node3 = listItem.getErrorConfigVersion;
            while (node3 != null) {
                Node node4 = node3.NetworkUserEntityData$$ExternalSyntheticLambda0;
                this.MyBillsEntityDataFactory.PlaceComponentResult(node3);
                node3 = node4;
            }
            MyBillsEntityDataFactory(listItem, null);
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(OrderedList orderedList) {
        if (this.PlaceComponentResult != null) {
            PlaceComponentResult();
        }
        this.PlaceComponentResult = new OrderedListHolder(this.PlaceComponentResult, orderedList);
        Node node = orderedList.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.MyBillsEntityDataFactory.PlaceComponentResult(node);
            node = node2;
        }
        MyBillsEntityDataFactory(orderedList, null);
        if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            this.PlaceComponentResult = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        } else {
            this.PlaceComponentResult = null;
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(SoftLineBreak softLineBreak) {
        MyBillsEntityDataFactory(softLineBreak, null);
    }

    private void getAuthRequestContext(String str) {
        if (this.MyBillsEntityDataFactory.getAuthRequestContext()) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(str.replaceAll("[\\r\\n\\s]+", " "));
        } else {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(str);
        }
    }

    private void MyBillsEntityDataFactory(Node node, Character ch) {
        TextContentWriter textContentWriter;
        char c;
        TextContentWriter textContentWriter2;
        char c2;
        if (this.MyBillsEntityDataFactory.getAuthRequestContext()) {
            if (ch != null) {
                TextContentWriter textContentWriter3 = this.getAuthRequestContext;
                char charValue = ch.charValue();
                try {
                    textContentWriter3.BuiltInFictitiousFunctionClassFactory.append(charValue);
                    textContentWriter3.KClassImpl$Data$declaredNonStaticMembers$2 = charValue;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (node.NetworkUserEntityData$$ExternalSyntheticLambda0 == null || (c2 = (textContentWriter2 = this.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2) == 0 || c2 == ' ') {
                return;
            }
            try {
                textContentWriter2.BuiltInFictitiousFunctionClassFactory.append(InputCardNumberView.DIVIDER);
                textContentWriter2.KClassImpl$Data$declaredNonStaticMembers$2 = InputCardNumberView.DIVIDER;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        } else if (node.NetworkUserEntityData$$ExternalSyntheticLambda0 == null || (c = (textContentWriter = this.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2) == 0 || c == '\n') {
        } else {
            try {
                textContentWriter.BuiltInFictitiousFunctionClassFactory.append('\n');
                textContentWriter.KClassImpl$Data$declaredNonStaticMembers$2 = '\n';
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    private void PlaceComponentResult() {
        if (this.MyBillsEntityDataFactory.getAuthRequestContext()) {
            TextContentWriter textContentWriter = this.getAuthRequestContext;
            char c = textContentWriter.KClassImpl$Data$declaredNonStaticMembers$2;
            if (c == 0 || c == ' ') {
                return;
            }
            try {
                textContentWriter.BuiltInFictitiousFunctionClassFactory.append(InputCardNumberView.DIVIDER);
                textContentWriter.KClassImpl$Data$declaredNonStaticMembers$2 = InputCardNumberView.DIVIDER;
                return;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        TextContentWriter textContentWriter2 = this.getAuthRequestContext;
        char c2 = textContentWriter2.KClassImpl$Data$declaredNonStaticMembers$2;
        if (c2 == 0 || c2 == '\n') {
            return;
        }
        try {
            textContentWriter2.BuiltInFictitiousFunctionClassFactory.append('\n');
            textContentWriter2.KClassImpl$Data$declaredNonStaticMembers$2 = '\n';
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void MyBillsEntityDataFactory(Node node, String str, String str2) {
        boolean z = false;
        boolean z2 = node.getErrorConfigVersion != null;
        boolean z3 = (str == null || str.equals(str2)) ? false : true;
        if (str2 != null && !str2.equals("")) {
            z = true;
        }
        if (z2) {
            TextContentWriter textContentWriter = this.getAuthRequestContext;
            try {
                textContentWriter.BuiltInFictitiousFunctionClassFactory.append(Typography.quote);
                textContentWriter.KClassImpl$Data$declaredNonStaticMembers$2 = Typography.quote;
                Node node2 = node.getErrorConfigVersion;
                while (node2 != null) {
                    Node node3 = node2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    this.MyBillsEntityDataFactory.PlaceComponentResult(node2);
                    node2 = node3;
                }
                TextContentWriter textContentWriter2 = this.getAuthRequestContext;
                try {
                    textContentWriter2.BuiltInFictitiousFunctionClassFactory.append(Typography.quote);
                    textContentWriter2.KClassImpl$Data$declaredNonStaticMembers$2 = Typography.quote;
                    if (z3 || z) {
                        TextContentWriter textContentWriter3 = this.getAuthRequestContext;
                        char c = textContentWriter3.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (c != 0 && c != ' ') {
                            try {
                                textContentWriter3.BuiltInFictitiousFunctionClassFactory.append(InputCardNumberView.DIVIDER);
                                textContentWriter3.KClassImpl$Data$declaredNonStaticMembers$2 = InputCardNumberView.DIVIDER;
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        TextContentWriter textContentWriter4 = this.getAuthRequestContext;
                        try {
                            textContentWriter4.BuiltInFictitiousFunctionClassFactory.append('(');
                            textContentWriter4.KClassImpl$Data$declaredNonStaticMembers$2 = '(';
                        } catch (IOException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                }
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            }
        }
        if (z3) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(str);
            if (z) {
                TextContentWriter textContentWriter5 = this.getAuthRequestContext;
                char c2 = textContentWriter5.KClassImpl$Data$declaredNonStaticMembers$2;
                if (c2 != 0 && c2 != ':') {
                    try {
                        textContentWriter5.BuiltInFictitiousFunctionClassFactory.append(':');
                        textContentWriter5.KClassImpl$Data$declaredNonStaticMembers$2 = ':';
                    } catch (IOException e5) {
                        throw new RuntimeException(e5);
                    }
                }
                TextContentWriter textContentWriter6 = this.getAuthRequestContext;
                char c3 = textContentWriter6.KClassImpl$Data$declaredNonStaticMembers$2;
                if (c3 != 0 && c3 != ' ') {
                    try {
                        textContentWriter6.BuiltInFictitiousFunctionClassFactory.append(InputCardNumberView.DIVIDER);
                        textContentWriter6.KClassImpl$Data$declaredNonStaticMembers$2 = InputCardNumberView.DIVIDER;
                    } catch (IOException e6) {
                        throw new RuntimeException(e6);
                    }
                }
            }
        }
        if (z) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(str2);
        }
        if (z2) {
            if (z3 || z) {
                TextContentWriter textContentWriter7 = this.getAuthRequestContext;
                try {
                    textContentWriter7.BuiltInFictitiousFunctionClassFactory.append(')');
                    textContentWriter7.KClassImpl$Data$declaredNonStaticMembers$2 = ')';
                } catch (IOException e7) {
                    throw new RuntimeException(e7);
                }
            }
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(Document document) {
        Node node = document.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.MyBillsEntityDataFactory.PlaceComponentResult(node);
            node = node2;
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void MyBillsEntityDataFactory(Heading heading) {
        Node node = heading.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.MyBillsEntityDataFactory.PlaceComponentResult(node);
            node = node2;
        }
        MyBillsEntityDataFactory(heading, ':');
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void PlaceComponentResult(HtmlBlock htmlBlock) {
        getAuthRequestContext(htmlBlock.MyBillsEntityDataFactory);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(HtmlInline htmlInline) {
        getAuthRequestContext(htmlInline.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(Image image) {
        MyBillsEntityDataFactory(image, image.MyBillsEntityDataFactory, image.PlaceComponentResult);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Link link) {
        MyBillsEntityDataFactory(link, link.PlaceComponentResult, link.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void PlaceComponentResult(Paragraph paragraph) {
        Node node = paragraph.getErrorConfigVersion;
        while (node != null) {
            Node node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.MyBillsEntityDataFactory.PlaceComponentResult(node);
            node = node2;
        }
        if (paragraph.MyBillsEntityDataFactory() == null || (paragraph.MyBillsEntityDataFactory() instanceof Document)) {
            MyBillsEntityDataFactory(paragraph, null);
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(Text text) {
        getAuthRequestContext(text.PlaceComponentResult);
    }

    @Override // org.commonmark.node.AbstractVisitor
    public final void getAuthRequestContext(Node node) {
        Node node2 = node.getErrorConfigVersion;
        while (node2 != null) {
            Node node3 = node2.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.MyBillsEntityDataFactory.PlaceComponentResult(node2);
            node2 = node3;
        }
    }
}
