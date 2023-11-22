package org.yaml.snakeyaml.resolver;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes6.dex */
public class Resolver {
    protected Map<Character, List<ResolverTuple>> getErrorConfigVersion = new HashMap();
    public static final Pattern BuiltInFictitiousFunctionClassFactory = Pattern.compile("^(?:yes|Yes|YES|no|No|NO|true|True|TRUE|false|False|FALSE|on|On|ON|off|Off|OFF)$");
    public static final Pattern PlaceComponentResult = Pattern.compile("^([-+]?(?:[0-9][0-9_]*)\\.[0-9_]*(?:[eE][-+]?[0-9]+)?|[-+]?(?:[0-9][0-9_]*)(?:[eE][-+]?[0-9]+)|[-+]?\\.[0-9_]+(?:[eE][-+]?[0-9]+)?|[-+]?[0-9][0-9_]*(?::[0-5]?[0-9])+\\.[0-9_]*|[-+]?\\.(?:inf|Inf|INF)|\\.(?:nan|NaN|NAN))$");
    public static final Pattern MyBillsEntityDataFactory = Pattern.compile("^(?:[-+]?0b_*[0-1][0-1_]*|[-+]?0_*[0-7][0-7_]*|[-+]?(?:0|[1-9][0-9_]*)|[-+]?0x_*[0-9a-fA-F][0-9a-fA-F_]*|[-+]?[1-9][0-9_]*(?::[0-5]?[0-9])+)$");
    public static final Pattern getAuthRequestContext = Pattern.compile("^(?:<<)$");
    public static final Pattern moveToNextValue = Pattern.compile("^(?:~|null|Null|NULL| )$");
    public static final Pattern KClassImpl$Data$declaredNonStaticMembers$2 = Pattern.compile("^$");
    public static final Pattern lookAheadTest = Pattern.compile("^(?:[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]|[0-9][0-9][0-9][0-9]-[0-9][0-9]?-[0-9][0-9]?(?:[Tt]|[ \t]+)[0-9][0-9]?:[0-9][0-9]:[0-9][0-9](?:\\.[0-9]*)?(?:[ \t]*(?:Z|[-+][0-9][0-9]?(?::[0-9][0-9])?))?)$");
    public static final Pattern NetworkUserEntityData$$ExternalSyntheticLambda0 = Pattern.compile("^(?:=)$");
    public static final Pattern scheduleImpl = Pattern.compile("^(?:!|&|\\*)$");

    public Resolver() {
        KClassImpl$Data$declaredNonStaticMembers$2(Tag.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory, "yYnNtTfFoO", 10);
        KClassImpl$Data$declaredNonStaticMembers$2(Tag.getAuthRequestContext, MyBillsEntityDataFactory, "-+0123456789", 1024);
        KClassImpl$Data$declaredNonStaticMembers$2(Tag.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult, "-+0123456789.", 1024);
        KClassImpl$Data$declaredNonStaticMembers$2(Tag.getErrorConfigVersion, getAuthRequestContext, SimpleComparison.LESS_THAN_OPERATION, 10);
        KClassImpl$Data$declaredNonStaticMembers$2(Tag.moveToNextValue, moveToNextValue, "~nN\u0000", 10);
        KClassImpl$Data$declaredNonStaticMembers$2(Tag.moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$2, null, 10);
        KClassImpl$Data$declaredNonStaticMembers$2(Tag.initRecordTimeStamp, lookAheadTest, "0123456789", 50);
        KClassImpl$Data$declaredNonStaticMembers$2(Tag.GetContactSyncConfig, scheduleImpl, "!&*", 10);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Tag tag, Pattern pattern, String str, int i) {
        if (str == null) {
            List<ResolverTuple> list = this.getErrorConfigVersion.get(null);
            if (list == null) {
                list = new ArrayList<>();
                this.getErrorConfigVersion.put(null, list);
            }
            list.add(new ResolverTuple(tag, pattern, i));
            return;
        }
        for (char c : str.toCharArray()) {
            Character valueOf = Character.valueOf(c);
            if (valueOf.charValue() == 0) {
                valueOf = null;
            }
            List<ResolverTuple> list2 = this.getErrorConfigVersion.get(valueOf);
            if (list2 == null) {
                list2 = new ArrayList<>();
                this.getErrorConfigVersion.put(valueOf, list2);
            }
            list2.add(new ResolverTuple(tag, pattern, i));
        }
    }

    public final Tag BuiltInFictitiousFunctionClassFactory(NodeId nodeId, String str, boolean z) {
        List<ResolverTuple> list;
        if (nodeId == NodeId.scalar && z) {
            if (str.length() == 0) {
                list = this.getErrorConfigVersion.get((char) 0);
            } else {
                list = this.getErrorConfigVersion.get(Character.valueOf(str.charAt(0)));
            }
            if (list != null) {
                for (ResolverTuple resolverTuple : list) {
                    Tag tag = resolverTuple.MyBillsEntityDataFactory;
                    Pattern pattern = resolverTuple.PlaceComponentResult;
                    if (str.length() <= resolverTuple.getAuthRequestContext && pattern.matcher(str).matches()) {
                        return tag;
                    }
                }
            }
            if (this.getErrorConfigVersion.containsKey(null)) {
                for (ResolverTuple resolverTuple2 : this.getErrorConfigVersion.get(null)) {
                    Tag tag2 = resolverTuple2.MyBillsEntityDataFactory;
                    Pattern pattern2 = resolverTuple2.PlaceComponentResult;
                    if (str.length() <= resolverTuple2.getAuthRequestContext && pattern2.matcher(str).matches()) {
                        return tag2;
                    }
                }
            }
        }
        int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[nodeId.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return Tag.NetworkUserEntityData$$ExternalSyntheticLambda1;
            }
            return Tag.scheduleImpl;
        }
        return Tag.DatabaseTableConfigUtil;
    }

    /* renamed from: org.yaml.snakeyaml.resolver.Resolver$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[NodeId.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[NodeId.scalar.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[NodeId.sequence.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
