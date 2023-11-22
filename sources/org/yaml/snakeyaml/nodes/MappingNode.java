package org.yaml.snakeyaml.nodes;

import com.google.common.base.Ascii;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.List;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes6.dex */
public class MappingNode extends CollectionNode<NodeTuple> {
    public List<NodeTuple> BuiltInFictitiousFunctionClassFactory;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public static final byte[] PlaceComponentResult = {36, -18, 4, 125, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 133;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            int r6 = r6 + 105
            byte[] r0 = org.yaml.snakeyaml.nodes.MappingNode.PlaceComponentResult
            int r8 = r8 * 3
            int r8 = 16 - r8
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L18:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L1c:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L36:
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.nodes.MappingNode.a(int, short, byte, java.lang.Object[]):void");
    }

    public MappingNode(Tag tag, boolean z, List<NodeTuple> list, Mark mark, DumperOptions.FlowStyle flowStyle) {
        super(tag, mark, flowStyle);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        if (list == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
    }

    @Override // org.yaml.snakeyaml.nodes.Node
    public final NodeId KClassImpl$Data$declaredNonStaticMembers$2() {
        return NodeId.mapping;
    }

    @Override // org.yaml.snakeyaml.nodes.CollectionNode
    public final List<NodeTuple> PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NodeTuple nodeTuple : this.BuiltInFictitiousFunctionClassFactory) {
            sb.append("{ key=");
            sb.append(nodeTuple.BuiltInFictitiousFunctionClassFactory);
            sb.append("; value=");
            if (nodeTuple.KClassImpl$Data$declaredNonStaticMembers$2 instanceof CollectionNode) {
                try {
                    Object[] objArr = {nodeTuple.KClassImpl$Data$declaredNonStaticMembers$2};
                    Object[] objArr2 = new Object[1];
                    a((byte) (-PlaceComponentResult[5]), (short) 14, (byte) (PlaceComponentResult[5] + 1), objArr2);
                    Class<?> cls = Class.forName((String) objArr2[0]);
                    byte b = (byte) (PlaceComponentResult[5] + 1);
                    byte b2 = PlaceComponentResult[5];
                    Object[] objArr3 = new Object[1];
                    a(b, b2, (byte) (b2 + 1), objArr3);
                    sb.append(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue());
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } else {
                sb.append(nodeTuple);
            }
            sb.append(" }");
        }
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(SimpleComparison.LESS_THAN_OPERATION);
        sb2.append(getClass().getName());
        sb2.append(" (tag=");
        sb2.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb2.append(", values=");
        sb2.append(obj);
        sb2.append(")>");
        return sb2.toString();
    }

    public final boolean getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
