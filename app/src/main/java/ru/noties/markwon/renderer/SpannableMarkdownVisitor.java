package ru.noties.markwon.renderer;

import id.dana.cashier.view.InputCardNumberView;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.CustomBlock;
import org.commonmark.node.CustomNode;
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
import ru.noties.markwon.SpannableBuilder;
import ru.noties.markwon.SpannableConfiguration;
import ru.noties.markwon.SpannableFactory;
import ru.noties.markwon.html.api.MarkwonHtmlParser;
import ru.noties.markwon.spans.SpannableTheme;
import ru.noties.markwon.spans.TableRowSpan;
import ru.noties.markwon.tasklist.TaskListBlock;
import ru.noties.markwon.tasklist.TaskListItem;

/* loaded from: classes6.dex */
public class SpannableMarkdownVisitor extends AbstractVisitor {
    private int BuiltInFictitiousFunctionClassFactory;
    private final MarkwonHtmlParser KClassImpl$Data$declaredNonStaticMembers$2;
    private final SpannableConfiguration MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final SpannableFactory PlaceComponentResult;
    private final SpannableBuilder getAuthRequestContext;
    private final SpannableTheme getErrorConfigVersion;
    private boolean lookAheadTest;
    private int moveToNextValue;
    private List<TableRowSpan.Cell> scheduleImpl;

    public SpannableMarkdownVisitor(SpannableConfiguration spannableConfiguration, SpannableBuilder spannableBuilder) {
        this.MyBillsEntityDataFactory = spannableConfiguration;
        this.getAuthRequestContext = spannableBuilder;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = spannableConfiguration.getAuthRequestContext;
        this.getErrorConfigVersion = spannableConfiguration.scheduleImpl;
        this.PlaceComponentResult = spannableConfiguration.MyBillsEntityDataFactory;
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(Document document) {
        super.BuiltInFictitiousFunctionClassFactory(document);
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(Text text) {
        SpannableBuilder spannableBuilder = this.getAuthRequestContext;
        spannableBuilder.getAuthRequestContext.append(text.PlaceComponentResult);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void MyBillsEntityDataFactory(StrongEmphasis strongEmphasis) {
        int length = this.getAuthRequestContext.length();
        getAuthRequestContext(strongEmphasis);
        Object BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
        SpannableBuilder spannableBuilder = this.getAuthRequestContext;
        SpannableBuilder.PlaceComponentResult(spannableBuilder, BuiltInFictitiousFunctionClassFactory, length, spannableBuilder.length());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void PlaceComponentResult(Emphasis emphasis) {
        int length = this.getAuthRequestContext.length();
        getAuthRequestContext(emphasis);
        Object PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult();
        SpannableBuilder spannableBuilder = this.getAuthRequestContext;
        SpannableBuilder.PlaceComponentResult(spannableBuilder, PlaceComponentResult, length, spannableBuilder.length());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(BlockQuote blockQuote) {
        getAuthRequestContext();
        if (this.BuiltInFictitiousFunctionClassFactory != 0) {
            this.getAuthRequestContext.getAuthRequestContext.append('\n');
        }
        int length = this.getAuthRequestContext.length();
        this.BuiltInFictitiousFunctionClassFactory++;
        getAuthRequestContext(blockQuote);
        Object PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(this.getErrorConfigVersion);
        SpannableBuilder spannableBuilder = this.getAuthRequestContext;
        SpannableBuilder.PlaceComponentResult(spannableBuilder, PlaceComponentResult, length, spannableBuilder.length());
        this.BuiltInFictitiousFunctionClassFactory--;
        if (BuiltInFictitiousFunctionClassFactory((Node) blockQuote)) {
            getAuthRequestContext();
            if (this.BuiltInFictitiousFunctionClassFactory == 0) {
                this.getAuthRequestContext.getAuthRequestContext.append('\n');
            }
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(Code code) {
        int length = this.getAuthRequestContext.length();
        this.getAuthRequestContext.getAuthRequestContext.append(Typography.nbsp);
        SpannableBuilder spannableBuilder = this.getAuthRequestContext;
        spannableBuilder.getAuthRequestContext.append(code.MyBillsEntityDataFactory);
        this.getAuthRequestContext.getAuthRequestContext.append(Typography.nbsp);
        Object BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, false);
        SpannableBuilder spannableBuilder2 = this.getAuthRequestContext;
        SpannableBuilder.PlaceComponentResult(spannableBuilder2, BuiltInFictitiousFunctionClassFactory, length, spannableBuilder2.length());
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(String str, Node node) {
        getAuthRequestContext();
        int length = this.getAuthRequestContext.length();
        SpannableBuilder spannableBuilder = this.getAuthRequestContext;
        spannableBuilder.getAuthRequestContext.append(Typography.nbsp);
        spannableBuilder.getAuthRequestContext.append('\n');
        SpannableBuilder spannableBuilder2 = this.getAuthRequestContext;
        CharSequence BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(str);
        spannableBuilder2.KClassImpl$Data$declaredNonStaticMembers$2(spannableBuilder2.length(), BuiltInFictitiousFunctionClassFactory);
        spannableBuilder2.getAuthRequestContext.append(BuiltInFictitiousFunctionClassFactory);
        getAuthRequestContext();
        this.getAuthRequestContext.getAuthRequestContext.append(Typography.nbsp);
        Object BuiltInFictitiousFunctionClassFactory2 = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, true);
        SpannableBuilder spannableBuilder3 = this.getAuthRequestContext;
        SpannableBuilder.PlaceComponentResult(spannableBuilder3, BuiltInFictitiousFunctionClassFactory2, length, spannableBuilder3.length());
        if (BuiltInFictitiousFunctionClassFactory(node)) {
            getAuthRequestContext();
            this.getAuthRequestContext.getAuthRequestContext.append('\n');
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(BulletList bulletList) {
        MyBillsEntityDataFactory(bulletList);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(OrderedList orderedList) {
        MyBillsEntityDataFactory(orderedList);
    }

    private void MyBillsEntityDataFactory(Node node) {
        getAuthRequestContext();
        getAuthRequestContext(node);
        if (BuiltInFictitiousFunctionClassFactory(node)) {
            getAuthRequestContext();
            if (this.moveToNextValue == 0 && this.BuiltInFictitiousFunctionClassFactory == 0) {
                this.getAuthRequestContext.getAuthRequestContext.append('\n');
            }
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(ListItem listItem) {
        int length = this.getAuthRequestContext.length();
        this.BuiltInFictitiousFunctionClassFactory++;
        this.moveToNextValue++;
        Block MyBillsEntityDataFactory = listItem.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory instanceof OrderedList) {
            OrderedList orderedList = (OrderedList) MyBillsEntityDataFactory;
            int i = orderedList.getAuthRequestContext;
            getAuthRequestContext((Node) listItem);
            Object PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(this.getErrorConfigVersion, i);
            SpannableBuilder spannableBuilder = this.getAuthRequestContext;
            SpannableBuilder.PlaceComponentResult(spannableBuilder, PlaceComponentResult, length, spannableBuilder.length());
            orderedList.getAuthRequestContext++;
        } else {
            getAuthRequestContext((Node) listItem);
            Object KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, this.moveToNextValue - 1);
            SpannableBuilder spannableBuilder2 = this.getAuthRequestContext;
            SpannableBuilder.PlaceComponentResult(spannableBuilder2, KClassImpl$Data$declaredNonStaticMembers$2, length, spannableBuilder2.length());
        }
        this.BuiltInFictitiousFunctionClassFactory--;
        this.moveToNextValue--;
        if (BuiltInFictitiousFunctionClassFactory(listItem)) {
            getAuthRequestContext();
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void PlaceComponentResult(ThematicBreak thematicBreak) {
        getAuthRequestContext();
        int length = this.getAuthRequestContext.length();
        this.getAuthRequestContext.getAuthRequestContext.append(Typography.nbsp);
        Object MyBillsEntityDataFactory = this.PlaceComponentResult.MyBillsEntityDataFactory(this.getErrorConfigVersion);
        SpannableBuilder spannableBuilder = this.getAuthRequestContext;
        SpannableBuilder.PlaceComponentResult(spannableBuilder, MyBillsEntityDataFactory, length, spannableBuilder.length());
        if (BuiltInFictitiousFunctionClassFactory(thematicBreak)) {
            getAuthRequestContext();
            this.getAuthRequestContext.getAuthRequestContext.append('\n');
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void MyBillsEntityDataFactory(Heading heading) {
        getAuthRequestContext();
        int length = this.getAuthRequestContext.length();
        getAuthRequestContext(heading);
        Object authRequestContext = this.PlaceComponentResult.getAuthRequestContext(this.getErrorConfigVersion, heading.getAuthRequestContext);
        SpannableBuilder spannableBuilder = this.getAuthRequestContext;
        SpannableBuilder.PlaceComponentResult(spannableBuilder, authRequestContext, length, spannableBuilder.length());
        if (BuiltInFictitiousFunctionClassFactory(heading)) {
            getAuthRequestContext();
            this.getAuthRequestContext.getAuthRequestContext.append('\n');
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(SoftLineBreak softLineBreak) {
        if (this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory()) {
            getAuthRequestContext();
        } else {
            this.getAuthRequestContext.getAuthRequestContext.append(InputCardNumberView.DIVIDER);
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void MyBillsEntityDataFactory(HardLineBreak hardLineBreak) {
        getAuthRequestContext();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void KClassImpl$Data$declaredNonStaticMembers$2(CustomBlock customBlock) {
        if (customBlock instanceof TaskListBlock) {
            this.BuiltInFictitiousFunctionClassFactory++;
            getAuthRequestContext(customBlock);
            this.BuiltInFictitiousFunctionClassFactory--;
            if (BuiltInFictitiousFunctionClassFactory(customBlock)) {
                getAuthRequestContext();
                this.getAuthRequestContext.getAuthRequestContext.append('\n');
                return;
            }
            return;
        }
        super.KClassImpl$Data$declaredNonStaticMembers$2(customBlock);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(CustomNode customNode) {
        if (customNode instanceof Strikethrough) {
            int length = this.getAuthRequestContext.length();
            getAuthRequestContext((Node) customNode);
            Object authRequestContext = this.PlaceComponentResult.getAuthRequestContext();
            SpannableBuilder spannableBuilder = this.getAuthRequestContext;
            SpannableBuilder.PlaceComponentResult(spannableBuilder, authRequestContext, length, spannableBuilder.length());
        } else if (customNode instanceof TaskListItem) {
            TaskListItem taskListItem = (TaskListItem) customNode;
            int length2 = this.getAuthRequestContext.length();
            this.BuiltInFictitiousFunctionClassFactory += taskListItem.BuiltInFictitiousFunctionClassFactory;
            getAuthRequestContext((Node) customNode);
            Object PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(this.getErrorConfigVersion, this.BuiltInFictitiousFunctionClassFactory, taskListItem.KClassImpl$Data$declaredNonStaticMembers$2());
            SpannableBuilder spannableBuilder2 = this.getAuthRequestContext;
            SpannableBuilder.PlaceComponentResult(spannableBuilder2, PlaceComponentResult, length2, spannableBuilder2.length());
            if (BuiltInFictitiousFunctionClassFactory(customNode)) {
                getAuthRequestContext();
            }
            this.BuiltInFictitiousFunctionClassFactory -= taskListItem.BuiltInFictitiousFunctionClassFactory;
        } else if (MyBillsEntityDataFactory(customNode)) {
        } else {
            super.getAuthRequestContext(customNode);
        }
    }

    private boolean MyBillsEntityDataFactory(CustomNode customNode) {
        if (customNode instanceof TableBody) {
            getAuthRequestContext((Node) customNode);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
            if (BuiltInFictitiousFunctionClassFactory(customNode)) {
                getAuthRequestContext();
                this.getAuthRequestContext.getAuthRequestContext.append('\n');
            }
        } else if ((customNode instanceof TableRow) || (customNode instanceof TableHead)) {
            int length = this.getAuthRequestContext.length();
            getAuthRequestContext((Node) customNode);
            if (this.scheduleImpl != null) {
                int length2 = this.getAuthRequestContext.length();
                boolean z = length2 > 0 && '\n' != this.getAuthRequestContext.charAt(length2 - 1);
                if (z) {
                    this.getAuthRequestContext.getAuthRequestContext.append('\n');
                }
                this.getAuthRequestContext.getAuthRequestContext.append(Typography.nbsp);
                Object PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(this.getErrorConfigVersion, this.scheduleImpl, this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda0 % 2 == 1);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.lookAheadTest ? 0 : this.NetworkUserEntityData$$ExternalSyntheticLambda0 + 1;
                if (z) {
                    length++;
                }
                SpannableBuilder spannableBuilder = this.getAuthRequestContext;
                SpannableBuilder.PlaceComponentResult(spannableBuilder, PlaceComponentResult, length, spannableBuilder.length());
                this.scheduleImpl = null;
            }
        } else if (!(customNode instanceof TableCell)) {
            return false;
        } else {
            TableCell tableCell = (TableCell) customNode;
            int length3 = this.getAuthRequestContext.length();
            getAuthRequestContext((Node) tableCell);
            if (this.scheduleImpl == null) {
                this.scheduleImpl = new ArrayList(2);
            }
            List<TableRowSpan.Cell> list = this.scheduleImpl;
            TableCell.Alignment alignment = tableCell.BuiltInFictitiousFunctionClassFactory;
            if (alignment != null) {
                int i = AnonymousClass1.getAuthRequestContext[alignment.ordinal()];
                if (i == 1) {
                    r2 = 1;
                } else if (i == 2) {
                    r2 = 2;
                }
            }
            list.add(new TableRowSpan.Cell(r2, this.getAuthRequestContext.PlaceComponentResult(length3)));
            this.lookAheadTest = tableCell.PlaceComponentResult();
        }
        return true;
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void PlaceComponentResult(Paragraph paragraph) {
        boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory(paragraph);
        if (!MyBillsEntityDataFactory) {
            getAuthRequestContext();
        }
        int length = this.getAuthRequestContext.length();
        getAuthRequestContext(paragraph);
        SpannableBuilder spannableBuilder = this.getAuthRequestContext;
        SpannableBuilder.PlaceComponentResult(spannableBuilder, null, length, spannableBuilder.length());
        if (!BuiltInFictitiousFunctionClassFactory(paragraph) || MyBillsEntityDataFactory) {
            return;
        }
        getAuthRequestContext();
        if (this.BuiltInFictitiousFunctionClassFactory == 0) {
            this.getAuthRequestContext.getAuthRequestContext.append('\n');
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(Image image) {
        int length = this.getAuthRequestContext.length();
        getAuthRequestContext((Node) image);
        if (length == this.getAuthRequestContext.length()) {
            this.getAuthRequestContext.getAuthRequestContext.append((char) 65532);
        }
        Node authRequestContext = image.getAuthRequestContext();
        Object KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, this.MyBillsEntityDataFactory.lookAheadTest.PlaceComponentResult(image.PlaceComponentResult), this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory.PlaceComponentResult, null, authRequestContext != null && (authRequestContext instanceof Link));
        SpannableBuilder spannableBuilder = this.getAuthRequestContext;
        SpannableBuilder.PlaceComponentResult(spannableBuilder, KClassImpl$Data$declaredNonStaticMembers$2, length, spannableBuilder.length());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Link link) {
        int length = this.getAuthRequestContext.length();
        getAuthRequestContext(link);
        Object KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, this.MyBillsEntityDataFactory.lookAheadTest.PlaceComponentResult(link.BuiltInFictitiousFunctionClassFactory), this.MyBillsEntityDataFactory.moveToNextValue);
        SpannableBuilder spannableBuilder = this.getAuthRequestContext;
        SpannableBuilder.PlaceComponentResult(spannableBuilder, KClassImpl$Data$declaredNonStaticMembers$2, length, spannableBuilder.length());
    }

    private void getAuthRequestContext() {
        if (this.getAuthRequestContext.length() <= 0 || '\n' == this.getAuthRequestContext.PlaceComponentResult()) {
            return;
        }
        this.getAuthRequestContext.getAuthRequestContext.append('\n');
    }

    private static boolean MyBillsEntityDataFactory(Paragraph paragraph) {
        Node authRequestContext;
        Block MyBillsEntityDataFactory = paragraph.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory == null || (authRequestContext = MyBillsEntityDataFactory.getAuthRequestContext()) == null || !(authRequestContext instanceof ListBlock)) {
            return false;
        }
        return ((ListBlock) authRequestContext).PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ru.noties.markwon.renderer.SpannableMarkdownVisitor$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[TableCell.Alignment.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[TableCell.Alignment.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[TableCell.Alignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Node node) {
        return node.NetworkUserEntityData$$ExternalSyntheticLambda0 != null;
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void getAuthRequestContext(FencedCodeBlock fencedCodeBlock) {
        String str = fencedCodeBlock.MyBillsEntityDataFactory;
        KClassImpl$Data$declaredNonStaticMembers$2(fencedCodeBlock.PlaceComponentResult, fencedCodeBlock);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void PlaceComponentResult(HtmlBlock htmlBlock) {
        String str = htmlBlock.MyBillsEntityDataFactory;
        if (str != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext((MarkwonHtmlParser) this.getAuthRequestContext, str);
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void BuiltInFictitiousFunctionClassFactory(HtmlInline htmlInline) {
        String str = htmlInline.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext((MarkwonHtmlParser) this.getAuthRequestContext, str);
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public final void MyBillsEntityDataFactory(IndentedCodeBlock indentedCodeBlock) {
        KClassImpl$Data$declaredNonStaticMembers$2(indentedCodeBlock.BuiltInFictitiousFunctionClassFactory, indentedCodeBlock);
    }
}
