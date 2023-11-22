package org.yaml.snakeyaml.constructor;

import com.alibaba.griver.image.capture.meta.CameraParams;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.sendmoney.summary.SummaryActivity;
import j$.util.DesugarTimeZone;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.LongCompanionObject;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes6.dex */
public class SafeConstructor extends BaseConstructor {
    private static final Map<String, Boolean> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private static final int[][] NetworkUserEntityData$$ExternalSyntheticLambda2;
    private static final Pattern NetworkUserEntityData$$ExternalSyntheticLambda8;
    public static final ConstructUndefined isLayoutRequested = new ConstructUndefined();
    private static final Pattern newProxyInstance;

    static {
        HashMap hashMap = new HashMap();
        NetworkUserEntityData$$ExternalSyntheticLambda1 = hashMap;
        hashMap.put("yes", Boolean.TRUE);
        hashMap.put("no", Boolean.FALSE);
        hashMap.put(SummaryActivity.CHECKED, Boolean.TRUE);
        hashMap.put("false", Boolean.FALSE);
        hashMap.put(CameraParams.FLASH_MODE_ON, Boolean.TRUE);
        hashMap.put("off", Boolean.FALSE);
        NetworkUserEntityData$$ExternalSyntheticLambda2 = (int[][]) Array.newInstance(Integer.TYPE, 17, 2);
        int[] iArr = {2, 8, 10, 16};
        for (int i = 0; i < 4; i++) {
            int i2 = iArr[i];
            int[][] iArr2 = NetworkUserEntityData$$ExternalSyntheticLambda2;
            int[] iArr3 = new int[2];
            iArr3[0] = Integer.toString(Integer.MAX_VALUE, i2).length();
            iArr3[1] = Long.toString(LongCompanionObject.MAX_VALUE, i2).length();
            iArr2[i2] = iArr3;
        }
        newProxyInstance = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)(?:(?:[Tt]|[ \t]+)([0-9][0-9]?):([0-9][0-9]):([0-9][0-9])(?:\\.([0-9]*))?(?:[ \t]*(?:Z|([-+][0-9][0-9]?)(?::([0-9][0-9])?)?))?)?$");
        NetworkUserEntityData$$ExternalSyntheticLambda8 = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)$");
    }

    public SafeConstructor(LoaderOptions loaderOptions) {
        super(loaderOptions);
        this.initRecordTimeStamp.put(Tag.moveToNextValue, new ConstructYamlNull());
        this.initRecordTimeStamp.put(Tag.PlaceComponentResult, new ConstructYamlBool());
        this.initRecordTimeStamp.put(Tag.getAuthRequestContext, new ConstructYamlInt());
        this.initRecordTimeStamp.put(Tag.BuiltInFictitiousFunctionClassFactory, new ConstructYamlFloat());
        this.initRecordTimeStamp.put(Tag.MyBillsEntityDataFactory, new ConstructYamlBinary());
        this.initRecordTimeStamp.put(Tag.initRecordTimeStamp, new ConstructYamlTimestamp());
        this.initRecordTimeStamp.put(Tag.lookAheadTest, new ConstructYamlOmap());
        this.initRecordTimeStamp.put(Tag.NetworkUserEntityData$$ExternalSyntheticLambda0, new ConstructYamlPairs());
        this.initRecordTimeStamp.put(Tag.NetworkUserEntityData$$ExternalSyntheticLambda2, new ConstructYamlSet());
        this.initRecordTimeStamp.put(Tag.DatabaseTableConfigUtil, new ConstructYamlStr());
        this.initRecordTimeStamp.put(Tag.NetworkUserEntityData$$ExternalSyntheticLambda1, new ConstructYamlSeq());
        this.initRecordTimeStamp.put(Tag.scheduleImpl, new ConstructYamlMap());
        Map<Tag, Construct> map = this.initRecordTimeStamp;
        ConstructUndefined constructUndefined = isLayoutRequested;
        map.put(null, constructUndefined);
        this.DatabaseTableConfigUtil.put(NodeId.scalar, constructUndefined);
        this.DatabaseTableConfigUtil.put(NodeId.sequence, constructUndefined);
        this.DatabaseTableConfigUtil.put(NodeId.mapping, constructUndefined);
    }

    public final void BuiltInFictitiousFunctionClassFactory(MappingNode mappingNode, boolean z) {
        PlaceComponentResult(mappingNode, z);
        if (mappingNode.getAuthRequestContext()) {
            mappingNode.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2(mappingNode, true, new HashMap(), new ArrayList(), z);
        }
    }

    /* renamed from: org.yaml.snakeyaml.constructor.SafeConstructor$1 */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[NodeId.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[NodeId.mapping.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[NodeId.sequence.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class ConstructYamlNull extends AbstractConstruct {
        public ConstructYamlNull() {
            SafeConstructor.this = r1;
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            if (node != null) {
                SafeConstructor.getAuthRequestContext((ScalarNode) node);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public class ConstructYamlBool extends AbstractConstruct {
        public ConstructYamlBool() {
            SafeConstructor.this = r1;
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            return SafeConstructor.NetworkUserEntityData$$ExternalSyntheticLambda1.get(SafeConstructor.getAuthRequestContext((ScalarNode) node).toLowerCase());
        }
    }

    /* loaded from: classes6.dex */
    public class ConstructYamlInt extends AbstractConstruct {
        public ConstructYamlInt() {
            SafeConstructor.this = r1;
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            int i;
            String substring;
            String replaceAll = SafeConstructor.getAuthRequestContext((ScalarNode) node).replaceAll("_", "");
            if (replaceAll.isEmpty()) {
                throw new ConstructorException("while constructing an int", node.initRecordTimeStamp, "found empty value", node.initRecordTimeStamp);
            }
            char charAt = replaceAll.charAt(0);
            if (charAt == '-') {
                replaceAll = replaceAll.substring(1);
                i = -1;
            } else {
                if (charAt == '+') {
                    replaceAll = replaceAll.substring(1);
                }
                i = 1;
            }
            if ("0".equals(replaceAll)) {
                return 0;
            }
            int i2 = 2;
            if (replaceAll.startsWith("0b")) {
                substring = replaceAll.substring(2);
            } else if (replaceAll.startsWith("0x")) {
                substring = replaceAll.substring(2);
                i2 = 16;
            } else if (replaceAll.startsWith("0")) {
                substring = replaceAll.substring(1);
                i2 = 8;
            } else if (replaceAll.indexOf(58) == -1) {
                return SafeConstructor.BuiltInFictitiousFunctionClassFactory(i, replaceAll, 10);
            } else {
                String[] split = replaceAll.split(":");
                int length = split.length;
                int i3 = 0;
                int i4 = 1;
                for (int i5 = 0; i5 < length; i5++) {
                    i3 = (int) (i3 + (Long.parseLong(split[(length - i5) - 1]) * i4));
                    i4 *= 60;
                }
                return SafeConstructor.BuiltInFictitiousFunctionClassFactory(i, String.valueOf(i3), 10);
            }
            return SafeConstructor.BuiltInFictitiousFunctionClassFactory(i, substring, i2);
        }
    }

    public static Number BuiltInFictitiousFunctionClassFactory(int i, String str, int i2) {
        int length = str != null ? str.length() : 0;
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("-");
            sb.append(str);
            str = sb.toString();
        }
        int[][] iArr = NetworkUserEntityData$$ExternalSyntheticLambda2;
        int[] iArr2 = i2 < iArr.length ? iArr[i2] : null;
        if (iArr2 != null) {
            if (length > iArr2[0]) {
                if (length > iArr2[1]) {
                    return new BigInteger(str, i2);
                }
                return KClassImpl$Data$declaredNonStaticMembers$2(str, i2);
            }
        }
        try {
            return Integer.valueOf(str, i2);
        } catch (NumberFormatException unused) {
            return KClassImpl$Data$declaredNonStaticMembers$2(str, i2);
        }
    }

    private static Number KClassImpl$Data$declaredNonStaticMembers$2(String str, int i) {
        try {
            return Long.valueOf(str, i);
        } catch (NumberFormatException unused) {
            return new BigInteger(str, i);
        }
    }

    /* loaded from: classes6.dex */
    public class ConstructYamlFloat extends AbstractConstruct {
        public ConstructYamlFloat() {
            SafeConstructor.this = r1;
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            int i;
            String replaceAll = SafeConstructor.getAuthRequestContext((ScalarNode) node).replaceAll("_", "");
            if (replaceAll.isEmpty()) {
                throw new ConstructorException("while constructing a float", node.initRecordTimeStamp, "found empty value", node.initRecordTimeStamp);
            }
            char charAt = replaceAll.charAt(0);
            if (charAt == '-') {
                replaceAll = replaceAll.substring(1);
                i = -1;
            } else {
                if (charAt == '+') {
                    replaceAll = replaceAll.substring(1);
                }
                i = 1;
            }
            String lowerCase = replaceAll.toLowerCase();
            if (".inf".equals(lowerCase)) {
                return Double.valueOf(i == -1 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            } else if (".nan".equals(lowerCase)) {
                return Double.valueOf(Double.NaN);
            } else {
                if (replaceAll.indexOf(58) != -1) {
                    String[] split = replaceAll.split(":");
                    double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    int length = split.length;
                    int i2 = 1;
                    for (int i3 = 0; i3 < length; i3++) {
                        double parseDouble = Double.parseDouble(split[(length - i3) - 1]);
                        double d2 = i2;
                        Double.isNaN(d2);
                        d += parseDouble * d2;
                        i2 *= 60;
                    }
                    double d3 = i;
                    Double.isNaN(d3);
                    return Double.valueOf(d3 * d);
                }
                double doubleValue = Double.valueOf(replaceAll).doubleValue();
                double d4 = i;
                Double.isNaN(d4);
                return Double.valueOf(doubleValue * d4);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class ConstructYamlBinary extends AbstractConstruct {
        public ConstructYamlBinary() {
            SafeConstructor.this = r1;
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            byte[] authRequestContext;
            authRequestContext = Base64Coder.getAuthRequestContext(r3, 0, SafeConstructor.getAuthRequestContext((ScalarNode) node).replaceAll("\\s", "").toCharArray().length);
            return authRequestContext;
        }
    }

    /* loaded from: classes6.dex */
    public static class ConstructYamlTimestamp extends AbstractConstruct {
        Calendar BuiltInFictitiousFunctionClassFactory;

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            TimeZone BuiltInFictitiousFunctionClassFactory;
            String str;
            String str2 = ((ScalarNode) node).KClassImpl$Data$declaredNonStaticMembers$2;
            Matcher matcher = SafeConstructor.NetworkUserEntityData$$ExternalSyntheticLambda8.matcher(str2);
            if (!matcher.matches()) {
                Matcher matcher2 = SafeConstructor.newProxyInstance.matcher(str2);
                if (!matcher2.matches()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected timestamp: ");
                    sb.append(str2);
                    throw new YAMLException(sb.toString());
                }
                String group = matcher2.group(1);
                String group2 = matcher2.group(2);
                String group3 = matcher2.group(3);
                String group4 = matcher2.group(4);
                String group5 = matcher2.group(5);
                String group6 = matcher2.group(6);
                String group7 = matcher2.group(7);
                if (group7 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(group6);
                    sb2.append(".");
                    sb2.append(group7);
                    group6 = sb2.toString();
                }
                double parseDouble = Double.parseDouble(group6);
                int round = (int) Math.round(Math.floor(parseDouble));
                double d = round;
                Double.isNaN(d);
                int round2 = (int) Math.round((parseDouble - d) * 1000.0d);
                String group8 = matcher2.group(8);
                String group9 = matcher2.group(9);
                if (group8 != null) {
                    if (group9 != null) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(":");
                        sb3.append(group9);
                        str = sb3.toString();
                    } else {
                        str = "00";
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("GMT");
                    sb4.append(group8);
                    sb4.append(str);
                    BuiltInFictitiousFunctionClassFactory = DesugarTimeZone.BuiltInFictitiousFunctionClassFactory(sb4.toString());
                } else {
                    BuiltInFictitiousFunctionClassFactory = DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("UTC");
                }
                Calendar calendar = Calendar.getInstance(BuiltInFictitiousFunctionClassFactory);
                this.BuiltInFictitiousFunctionClassFactory = calendar;
                calendar.set(1, Integer.parseInt(group));
                this.BuiltInFictitiousFunctionClassFactory.set(2, Integer.parseInt(group2) - 1);
                this.BuiltInFictitiousFunctionClassFactory.set(5, Integer.parseInt(group3));
                this.BuiltInFictitiousFunctionClassFactory.set(11, Integer.parseInt(group4));
                this.BuiltInFictitiousFunctionClassFactory.set(12, Integer.parseInt(group5));
                this.BuiltInFictitiousFunctionClassFactory.set(13, round);
                this.BuiltInFictitiousFunctionClassFactory.set(14, round2);
                return this.BuiltInFictitiousFunctionClassFactory.getTime();
            }
            String group10 = matcher.group(1);
            String group11 = matcher.group(2);
            String group12 = matcher.group(3);
            Calendar calendar2 = Calendar.getInstance(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("UTC"));
            this.BuiltInFictitiousFunctionClassFactory = calendar2;
            calendar2.clear();
            this.BuiltInFictitiousFunctionClassFactory.set(1, Integer.parseInt(group10));
            this.BuiltInFictitiousFunctionClassFactory.set(2, Integer.parseInt(group11) - 1);
            this.BuiltInFictitiousFunctionClassFactory.set(5, Integer.parseInt(group12));
            return this.BuiltInFictitiousFunctionClassFactory.getTime();
        }
    }

    /* loaded from: classes6.dex */
    public class ConstructYamlOmap extends AbstractConstruct {
        public ConstructYamlOmap() {
            SafeConstructor.this = r1;
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (node instanceof SequenceNode) {
                for (Node node2 : ((SequenceNode) node).KClassImpl$Data$declaredNonStaticMembers$2) {
                    if (node2 instanceof MappingNode) {
                        MappingNode mappingNode = (MappingNode) node2;
                        if (mappingNode.BuiltInFictitiousFunctionClassFactory.size() == 1) {
                            linkedHashMap.put(SafeConstructor.this.BuiltInFictitiousFunctionClassFactory(mappingNode.BuiltInFictitiousFunctionClassFactory.get(0).BuiltInFictitiousFunctionClassFactory), SafeConstructor.this.BuiltInFictitiousFunctionClassFactory(mappingNode.BuiltInFictitiousFunctionClassFactory.get(0).KClassImpl$Data$declaredNonStaticMembers$2));
                        } else {
                            Mark mark = node.initRecordTimeStamp;
                            StringBuilder sb = new StringBuilder();
                            sb.append("expected a single mapping item, but found ");
                            sb.append(mappingNode.BuiltInFictitiousFunctionClassFactory.size());
                            sb.append(" items");
                            throw new ConstructorException("while constructing an ordered map", mark, sb.toString(), mappingNode.initRecordTimeStamp);
                        }
                    } else {
                        Mark mark2 = node.initRecordTimeStamp;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("expected a mapping of length 1, but found ");
                        sb2.append(node2.KClassImpl$Data$declaredNonStaticMembers$2());
                        throw new ConstructorException("while constructing an ordered map", mark2, sb2.toString(), node2.initRecordTimeStamp);
                    }
                }
                return linkedHashMap;
            }
            Mark mark3 = node.initRecordTimeStamp;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("expected a sequence, but found ");
            sb3.append(node.KClassImpl$Data$declaredNonStaticMembers$2());
            throw new ConstructorException("while constructing an ordered map", mark3, sb3.toString(), node.initRecordTimeStamp);
        }
    }

    /* loaded from: classes6.dex */
    public class ConstructYamlPairs extends AbstractConstruct {
        public ConstructYamlPairs() {
            SafeConstructor.this = r1;
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            if (node instanceof SequenceNode) {
                SequenceNode sequenceNode = (SequenceNode) node;
                ArrayList arrayList = new ArrayList(sequenceNode.KClassImpl$Data$declaredNonStaticMembers$2.size());
                for (Node node2 : sequenceNode.KClassImpl$Data$declaredNonStaticMembers$2) {
                    if (node2 instanceof MappingNode) {
                        MappingNode mappingNode = (MappingNode) node2;
                        if (mappingNode.BuiltInFictitiousFunctionClassFactory.size() == 1) {
                            arrayList.add(new Object[]{SafeConstructor.this.BuiltInFictitiousFunctionClassFactory(mappingNode.BuiltInFictitiousFunctionClassFactory.get(0).BuiltInFictitiousFunctionClassFactory), SafeConstructor.this.BuiltInFictitiousFunctionClassFactory(mappingNode.BuiltInFictitiousFunctionClassFactory.get(0).KClassImpl$Data$declaredNonStaticMembers$2)});
                        } else {
                            Mark mark = node.initRecordTimeStamp;
                            StringBuilder sb = new StringBuilder();
                            sb.append("expected a single mapping item, but found ");
                            sb.append(mappingNode.BuiltInFictitiousFunctionClassFactory.size());
                            sb.append(" items");
                            throw new ConstructorException("while constructing pairs", mark, sb.toString(), mappingNode.initRecordTimeStamp);
                        }
                    } else {
                        Mark mark2 = node.initRecordTimeStamp;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("expected a mapping of length 1, but found ");
                        sb2.append(node2.KClassImpl$Data$declaredNonStaticMembers$2());
                        throw new ConstructorException("while constructingpairs", mark2, sb2.toString(), node2.initRecordTimeStamp);
                    }
                }
                return arrayList;
            }
            Mark mark3 = node.initRecordTimeStamp;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("expected a sequence, but found ");
            sb3.append(node.KClassImpl$Data$declaredNonStaticMembers$2());
            throw new ConstructorException("while constructing pairs", mark3, sb3.toString(), node.initRecordTimeStamp);
        }
    }

    /* loaded from: classes6.dex */
    public class ConstructYamlSet implements Construct {
        public ConstructYamlSet() {
            SafeConstructor.this = r1;
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            if (node.MyBillsEntityDataFactory()) {
                return SafeConstructor.this.PlaceComponentResult.containsKey(node) ? SafeConstructor.this.PlaceComponentResult.get(node) : SafeConstructor.getAuthRequestContext(((MappingNode) node).BuiltInFictitiousFunctionClassFactory.size());
            }
            return SafeConstructor.this.PlaceComponentResult((MappingNode) node);
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final void getAuthRequestContext(Node node, Object obj) {
            if (node.MyBillsEntityDataFactory()) {
                SafeConstructor.this.BuiltInFictitiousFunctionClassFactory((MappingNode) node, (Set) obj);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected recursive set structure. Node: ");
            sb.append(node);
            throw new YAMLException(sb.toString());
        }
    }

    /* loaded from: classes6.dex */
    public class ConstructYamlStr extends AbstractConstruct {
        public ConstructYamlStr() {
            SafeConstructor.this = r1;
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            return SafeConstructor.getAuthRequestContext((ScalarNode) node);
        }
    }

    /* loaded from: classes6.dex */
    public class ConstructYamlSeq implements Construct {
        public ConstructYamlSeq() {
            SafeConstructor.this = r1;
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            SequenceNode sequenceNode = (SequenceNode) node;
            if (node.MyBillsEntityDataFactory()) {
                return SafeConstructor.this.PlaceComponentResult(sequenceNode);
            }
            return SafeConstructor.this.getAuthRequestContext(sequenceNode);
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final void getAuthRequestContext(Node node, Object obj) {
            if (node.MyBillsEntityDataFactory()) {
                SafeConstructor.this.PlaceComponentResult((SequenceNode) node, (Collection<Object>) ((List) obj));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected recursive sequence structure. Node: ");
            sb.append(node);
            throw new YAMLException(sb.toString());
        }
    }

    /* loaded from: classes6.dex */
    public class ConstructYamlMap implements Construct {
        public ConstructYamlMap() {
            SafeConstructor.this = r1;
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            MappingNode mappingNode = (MappingNode) node;
            if (node.MyBillsEntityDataFactory()) {
                return SafeConstructor.PlaceComponentResult(mappingNode.BuiltInFictitiousFunctionClassFactory.size());
            }
            return SafeConstructor.this.getAuthRequestContext(mappingNode);
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final void getAuthRequestContext(Node node, Object obj) {
            if (node.MyBillsEntityDataFactory()) {
                SafeConstructor.this.PlaceComponentResult((MappingNode) node, (Map) obj);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected recursive mapping structure. Node: ");
            sb.append(node);
            throw new YAMLException(sb.toString());
        }
    }

    /* loaded from: classes6.dex */
    public static final class ConstructUndefined extends AbstractConstruct {
        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            StringBuilder sb = new StringBuilder();
            sb.append("could not determine a constructor for the tag ");
            sb.append(node.NetworkUserEntityData$$ExternalSyntheticLambda2);
            throw new ConstructorException(null, null, sb.toString(), node.initRecordTimeStamp);
        }
    }

    private List<NodeTuple> KClassImpl$Data$declaredNonStaticMembers$2(MappingNode mappingNode, boolean z, Map<Object, Integer> map, List<NodeTuple> list, boolean z2) {
        Iterator<NodeTuple> it = mappingNode.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            NodeTuple next = it.next();
            Node node = next.BuiltInFictitiousFunctionClassFactory;
            Node node2 = next.KClassImpl$Data$declaredNonStaticMembers$2;
            if (node.NetworkUserEntityData$$ExternalSyntheticLambda2.equals(Tag.getErrorConfigVersion)) {
                it.remove();
                int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[node2.KClassImpl$Data$declaredNonStaticMembers$2().ordinal()];
                if (i == 1) {
                    KClassImpl$Data$declaredNonStaticMembers$2((MappingNode) node2, false, map, list, z2);
                } else if (i == 2) {
                    for (Node node3 : ((SequenceNode) node2).KClassImpl$Data$declaredNonStaticMembers$2) {
                        if (node3 instanceof MappingNode) {
                            KClassImpl$Data$declaredNonStaticMembers$2((MappingNode) node3, false, map, list, z2);
                        } else {
                            Mark mark = mappingNode.initRecordTimeStamp;
                            StringBuilder sb = new StringBuilder();
                            sb.append("expected a mapping for merging, but found ");
                            sb.append(node3.KClassImpl$Data$declaredNonStaticMembers$2());
                            throw new ConstructorException("while constructing a mapping", mark, sb.toString(), node3.initRecordTimeStamp);
                        }
                    }
                } else {
                    Mark mark2 = mappingNode.initRecordTimeStamp;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("expected a mapping or list of mappings for merging, but found ");
                    sb2.append(node2.KClassImpl$Data$declaredNonStaticMembers$2());
                    throw new ConstructorException("while constructing a mapping", mark2, sb2.toString(), node2.initRecordTimeStamp);
                }
            } else {
                if (z2) {
                    if (node instanceof ScalarNode) {
                        if (!String.class.isAssignableFrom(node.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                            node.NetworkUserEntityData$$ExternalSyntheticLambda1 = String.class;
                        }
                        Tag tag = Tag.DatabaseTableConfigUtil;
                        if (tag == null) {
                            throw new NullPointerException("tag in a Node is required.");
                        }
                        node.NetworkUserEntityData$$ExternalSyntheticLambda2 = tag;
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Keys must be scalars but found: ");
                        sb3.append(node);
                        throw new YAMLException(sb3.toString());
                    }
                }
                Object BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(node);
                if (!map.containsKey(BuiltInFictitiousFunctionClassFactory)) {
                    list.add(next);
                    map.put(BuiltInFictitiousFunctionClassFactory, Integer.valueOf(list.size() - 1));
                } else if (z) {
                    list.set(map.get(BuiltInFictitiousFunctionClassFactory).intValue(), next);
                }
            }
        }
        return list;
    }

    @Override // org.yaml.snakeyaml.constructor.BaseConstructor
    public final void PlaceComponentResult(MappingNode mappingNode, Map<Object, Object> map) {
        BuiltInFictitiousFunctionClassFactory(mappingNode, false);
        super.PlaceComponentResult(mappingNode, map);
    }

    @Override // org.yaml.snakeyaml.constructor.BaseConstructor
    public final void BuiltInFictitiousFunctionClassFactory(MappingNode mappingNode, Set<Object> set) {
        BuiltInFictitiousFunctionClassFactory(mappingNode, false);
        super.BuiltInFictitiousFunctionClassFactory(mappingNode, set);
    }

    private void PlaceComponentResult(MappingNode mappingNode, boolean z) {
        List<NodeTuple> list = mappingNode.BuiltInFictitiousFunctionClassFactory;
        HashMap hashMap = new HashMap(list.size());
        TreeSet treeSet = new TreeSet();
        int i = 0;
        for (NodeTuple nodeTuple : list) {
            Node node = nodeTuple.BuiltInFictitiousFunctionClassFactory;
            if (!node.NetworkUserEntityData$$ExternalSyntheticLambda2.equals(Tag.getErrorConfigVersion)) {
                if (z) {
                    if (node instanceof ScalarNode) {
                        if (!String.class.isAssignableFrom(node.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                            node.NetworkUserEntityData$$ExternalSyntheticLambda1 = String.class;
                        }
                        Tag tag = Tag.DatabaseTableConfigUtil;
                        if (tag == null) {
                            throw new NullPointerException("tag in a Node is required.");
                        }
                        node.NetworkUserEntityData$$ExternalSyntheticLambda2 = tag;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Keys must be scalars but found: ");
                        sb.append(node);
                        throw new YAMLException(sb.toString());
                    }
                }
                Object BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(node);
                if (BuiltInFictitiousFunctionClassFactory != null && !z && node.MyBillsEntityDataFactory()) {
                    if (!this.getAuthRequestContext.getAuthRequestContext()) {
                        throw new YAMLException("Recursive key for mapping is detected but it is not configured to be allowed.");
                    }
                    try {
                        BuiltInFictitiousFunctionClassFactory.hashCode();
                    } catch (Exception e) {
                        Mark mark = mappingNode.initRecordTimeStamp;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("found unacceptable key ");
                        sb2.append(BuiltInFictitiousFunctionClassFactory);
                        throw new ConstructorException("while constructing a mapping", mark, sb2.toString(), nodeTuple.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp, e);
                    }
                }
                Integer num = (Integer) hashMap.put(BuiltInFictitiousFunctionClassFactory, Integer.valueOf(i));
                if (num == null) {
                    continue;
                } else if (!KClassImpl$Data$declaredNonStaticMembers$2()) {
                    throw new DuplicateKeyException(mappingNode.initRecordTimeStamp, BuiltInFictitiousFunctionClassFactory, nodeTuple.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp);
                } else {
                    treeSet.add(num);
                }
            }
            i++;
        }
        Iterator descendingIterator = treeSet.descendingIterator();
        while (descendingIterator.hasNext()) {
            list.remove(((Integer) descendingIterator.next()).intValue());
        }
    }
}
