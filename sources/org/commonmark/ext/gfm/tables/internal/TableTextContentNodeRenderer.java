package org.commonmark.ext.gfm.tables.internal;

import id.dana.cashier.view.InputCardNumberView;
import java.io.IOException;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.Node;
import org.commonmark.renderer.text.TextContentNodeRendererContext;
import org.commonmark.renderer.text.TextContentWriter;

/* loaded from: classes9.dex */
public class TableTextContentNodeRenderer extends TableNodeRenderer {
    private final TextContentNodeRendererContext KClassImpl$Data$declaredNonStaticMembers$2;
    private final TextContentWriter MyBillsEntityDataFactory;

    @Override // org.commonmark.ext.gfm.tables.internal.TableNodeRenderer, org.commonmark.renderer.NodeRenderer
    public final /* bridge */ /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Node node) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(node);
    }

    @Override // org.commonmark.ext.gfm.tables.internal.TableNodeRenderer
    protected final void PlaceComponentResult(TableBlock tableBlock) {
        MyBillsEntityDataFactory(tableBlock);
        if (tableBlock.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2("\n");
        }
    }

    @Override // org.commonmark.ext.gfm.tables.internal.TableNodeRenderer
    protected final void getAuthRequestContext(TableHead tableHead) {
        MyBillsEntityDataFactory(tableHead);
    }

    @Override // org.commonmark.ext.gfm.tables.internal.TableNodeRenderer
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(TableBody tableBody) {
        MyBillsEntityDataFactory(tableBody);
    }

    @Override // org.commonmark.ext.gfm.tables.internal.TableNodeRenderer
    protected final void PlaceComponentResult(TableRow tableRow) {
        TextContentWriter textContentWriter = this.MyBillsEntityDataFactory;
        char c = textContentWriter.KClassImpl$Data$declaredNonStaticMembers$2;
        if (c != 0 && c != '\n') {
            try {
                textContentWriter.BuiltInFictitiousFunctionClassFactory.append('\n');
                textContentWriter.KClassImpl$Data$declaredNonStaticMembers$2 = '\n';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        MyBillsEntityDataFactory(tableRow);
        TextContentWriter textContentWriter2 = this.MyBillsEntityDataFactory;
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

    @Override // org.commonmark.ext.gfm.tables.internal.TableNodeRenderer
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(TableCell tableCell) {
        MyBillsEntityDataFactory(tableCell);
        TextContentWriter textContentWriter = this.MyBillsEntityDataFactory;
        try {
            textContentWriter.BuiltInFictitiousFunctionClassFactory.append('|');
            textContentWriter.KClassImpl$Data$declaredNonStaticMembers$2 = '|';
            TextContentWriter textContentWriter2 = this.MyBillsEntityDataFactory;
            char c = textContentWriter2.KClassImpl$Data$declaredNonStaticMembers$2;
            if (c == 0 || c == ' ') {
                return;
            }
            try {
                textContentWriter2.BuiltInFictitiousFunctionClassFactory.append(InputCardNumberView.DIVIDER);
                textContentWriter2.KClassImpl$Data$declaredNonStaticMembers$2 = InputCardNumberView.DIVIDER;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void MyBillsEntityDataFactory(Node node) {
        Node node2 = node.getErrorConfigVersion;
        while (node2 != null) {
            Node node3 = node2.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (!(node2 instanceof TableCell) || node3 != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(node2);
            } else {
                MyBillsEntityDataFactory((TableCell) node2);
            }
            node2 = node3;
        }
    }
}
