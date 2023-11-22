package org.commonmark.ext.gfm.tables.internal;

import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.Node;
import org.commonmark.renderer.NodeRenderer;

/* loaded from: classes9.dex */
abstract class TableNodeRenderer implements NodeRenderer {
    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2(TableBody tableBody);

    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2(TableCell tableCell);

    protected abstract void PlaceComponentResult(TableBlock tableBlock);

    protected abstract void PlaceComponentResult(TableRow tableRow);

    protected abstract void getAuthRequestContext(TableHead tableHead);

    TableNodeRenderer() {
    }

    @Override // org.commonmark.renderer.NodeRenderer
    public void KClassImpl$Data$declaredNonStaticMembers$2(Node node) {
        if (node instanceof TableBlock) {
            PlaceComponentResult((TableBlock) node);
        } else if (node instanceof TableHead) {
            getAuthRequestContext((TableHead) node);
        } else if (node instanceof TableBody) {
            KClassImpl$Data$declaredNonStaticMembers$2((TableBody) node);
        } else if (node instanceof TableRow) {
            PlaceComponentResult((TableRow) node);
        } else if (node instanceof TableCell) {
            KClassImpl$Data$declaredNonStaticMembers$2((TableCell) node);
        }
    }
}
