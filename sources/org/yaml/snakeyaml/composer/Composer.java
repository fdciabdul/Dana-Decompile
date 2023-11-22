package org.yaml.snakeyaml.composer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.comments.CommentEventsCollector;
import org.yaml.snakeyaml.comments.CommentLine;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.parser.Parser;
import org.yaml.snakeyaml.resolver.Resolver;

/* loaded from: classes6.dex */
public class Composer {
    private final CommentEventsCollector BuiltInFictitiousFunctionClassFactory;
    private final CommentEventsCollector KClassImpl$Data$declaredNonStaticMembers$2;
    protected final Parser MyBillsEntityDataFactory;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final LoaderOptions PlaceComponentResult;
    private final Map<String, Node> getAuthRequestContext;
    private final Resolver getErrorConfigVersion;
    private final Set<Node> scheduleImpl;
    private int moveToNextValue = 0;
    private int lookAheadTest = 0;

    public Composer(Parser parser, Resolver resolver, LoaderOptions loaderOptions) {
        if (resolver == null) {
            throw new NullPointerException("Resolver must be provided");
        }
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided");
        }
        this.MyBillsEntityDataFactory = parser;
        this.getErrorConfigVersion = resolver;
        this.getAuthRequestContext = new HashMap();
        this.scheduleImpl = new HashSet();
        this.PlaceComponentResult = loaderOptions;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new CommentEventsCollector(parser, CommentType.BLANK_LINE, CommentType.BLOCK);
        this.BuiltInFictitiousFunctionClassFactory = new CommentEventsCollector(parser, CommentType.IN_LINE);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = loaderOptions.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean PlaceComponentResult() {
        if (this.MyBillsEntityDataFactory.getAuthRequestContext(Event.ID.StreamStart)) {
            this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return !this.MyBillsEntityDataFactory.getAuthRequestContext(Event.ID.StreamEnd);
    }

    public final Node getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        if (this.MyBillsEntityDataFactory.getAuthRequestContext(Event.ID.StreamEnd)) {
            List<CommentLine> KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
            Mark mark = KClassImpl$Data$declaredNonStaticMembers$2.get(0).KClassImpl$Data$declaredNonStaticMembers$2;
            MappingNode mappingNode = new MappingNode(Tag.KClassImpl$Data$declaredNonStaticMembers$2, false, Collections.emptyList(), mark, DumperOptions.FlowStyle.BLOCK);
            mappingNode.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2;
            return mappingNode;
        }
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        Node authRequestContext = getAuthRequestContext(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult()) {
            authRequestContext.getErrorConfigVersion = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        this.getAuthRequestContext.clear();
        this.scheduleImpl.clear();
        return authRequestContext;
    }

    public final Node MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        Node authRequestContext = !this.MyBillsEntityDataFactory.getAuthRequestContext(Event.ID.StreamEnd) ? getAuthRequestContext() : null;
        if (!this.MyBillsEntityDataFactory.getAuthRequestContext(Event.ID.StreamEnd)) {
            throw new ComposerException("expected a single document in the stream", authRequestContext != null ? authRequestContext.initRecordTimeStamp : null, "but found another document", this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2().scheduleImpl);
        }
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        return authRequestContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [org.yaml.snakeyaml.composer.Composer] */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v56, types: [org.yaml.snakeyaml.nodes.Node] */
    /* JADX WARN: Type inference failed for: r2v63, types: [org.yaml.snakeyaml.nodes.Node, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7, types: [org.yaml.snakeyaml.nodes.Node, org.yaml.snakeyaml.nodes.SequenceNode, org.yaml.snakeyaml.nodes.CollectionNode, java.lang.Object] */
    private Node getAuthRequestContext(Node node) {
        Tag BuiltInFictitiousFunctionClassFactory;
        boolean z;
        MappingNode mappingNode;
        Node node2;
        Tag BuiltInFictitiousFunctionClassFactory2;
        boolean z2;
        Tag BuiltInFictitiousFunctionClassFactory3;
        boolean z3;
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        if (node != null) {
            this.scheduleImpl.add(node);
        }
        if (this.MyBillsEntityDataFactory.getAuthRequestContext(Event.ID.Alias)) {
            AliasEvent aliasEvent = (AliasEvent) this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
            String str = aliasEvent.BuiltInFictitiousFunctionClassFactory;
            if (!this.getAuthRequestContext.containsKey(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("found undefined alias ");
                sb.append(str);
                throw new ComposerException(null, null, sb.toString(), aliasEvent.scheduleImpl);
            }
            node2 = this.getAuthRequestContext.get(str);
            if (!(node2 instanceof ScalarNode)) {
                int i = this.moveToNextValue + 1;
                this.moveToNextValue = i;
                if (i > this.PlaceComponentResult.MyBillsEntityDataFactory) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Number of aliases for non-scalar nodes exceeds the specified max=");
                    sb2.append(this.PlaceComponentResult.MyBillsEntityDataFactory);
                    throw new YAMLException(sb2.toString());
                }
            }
            if (this.scheduleImpl.remove(node2)) {
                node2.DatabaseTableConfigUtil = true;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            String str2 = ((NodeEvent) this.MyBillsEntityDataFactory.PlaceComponentResult()).BuiltInFictitiousFunctionClassFactory;
            int i2 = this.lookAheadTest;
            if (i2 > this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Nesting Depth exceeded max ");
                sb3.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                throw new YAMLException(sb3.toString());
            }
            this.lookAheadTest = i2 + 1;
            if (this.MyBillsEntityDataFactory.getAuthRequestContext(Event.ID.Scalar)) {
                List<CommentLine> KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
                ScalarEvent scalarEvent = (ScalarEvent) this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                String str3 = scalarEvent.getAuthRequestContext;
                if (str3 == null || str3.equals("!")) {
                    BuiltInFictitiousFunctionClassFactory3 = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(NodeId.scalar, scalarEvent.getErrorConfigVersion, scalarEvent.MyBillsEntityDataFactory.PlaceComponentResult());
                    z3 = true;
                } else {
                    Tag tag = new Tag(str3);
                    if (tag.KClassImpl$Data$declaredNonStaticMembers$2() && !this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(tag)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Global tag is not allowed: ");
                        sb4.append(str3);
                        throw new ComposerException(null, null, sb4.toString(), scalarEvent.scheduleImpl);
                    }
                    BuiltInFictitiousFunctionClassFactory3 = tag;
                    z3 = false;
                }
                ScalarNode scalarNode = new ScalarNode(BuiltInFictitiousFunctionClassFactory3, z3, scalarEvent.getErrorConfigVersion, scalarEvent.scheduleImpl, scalarEvent.PlaceComponentResult, scalarEvent.KClassImpl$Data$declaredNonStaticMembers$2);
                if (str2 != null) {
                    scalarNode.getAuthRequestContext = str2;
                    this.getAuthRequestContext.put(str2, scalarNode);
                }
                scalarNode.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2;
                scalarNode.moveToNextValue = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2();
                node2 = scalarNode;
            } else {
                if (this.MyBillsEntityDataFactory.getAuthRequestContext(Event.ID.SequenceStart)) {
                    SequenceStartEvent sequenceStartEvent = (SequenceStartEvent) this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                    String str4 = sequenceStartEvent.MyBillsEntityDataFactory;
                    if (str4 == null || str4.equals("!")) {
                        BuiltInFictitiousFunctionClassFactory2 = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(NodeId.sequence, null, sequenceStartEvent.getAuthRequestContext());
                        z2 = true;
                    } else {
                        Tag tag2 = new Tag(str4);
                        if (tag2.KClassImpl$Data$declaredNonStaticMembers$2() && !this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(tag2)) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Global tag is not allowed: ");
                            sb5.append(str4);
                            throw new ComposerException(null, null, sb5.toString(), sequenceStartEvent.scheduleImpl);
                        }
                        BuiltInFictitiousFunctionClassFactory2 = tag2;
                        z2 = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    ?? sequenceNode = new SequenceNode(BuiltInFictitiousFunctionClassFactory2, z2, arrayList, sequenceStartEvent.scheduleImpl, sequenceStartEvent.KClassImpl$Data$declaredNonStaticMembers$2);
                    if (sequenceStartEvent.PlaceComponentResult()) {
                        sequenceNode.scheduleImpl = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                    if (str2 != null) {
                        sequenceNode.getAuthRequestContext = str2;
                        this.getAuthRequestContext.put(str2, sequenceNode);
                    }
                    while (!this.MyBillsEntityDataFactory.getAuthRequestContext(Event.ID.SequenceEnd)) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                        if (this.MyBillsEntityDataFactory.getAuthRequestContext(Event.ID.SequenceEnd)) {
                            break;
                        }
                        arrayList.add(getAuthRequestContext(sequenceNode));
                    }
                    if (sequenceStartEvent.PlaceComponentResult()) {
                        sequenceNode.moveToNextValue = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                    sequenceNode.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult);
                    this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
                    mappingNode = sequenceNode;
                    if (!this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
                        sequenceNode.moveToNextValue = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                        mappingNode = sequenceNode;
                    }
                } else {
                    MappingStartEvent mappingStartEvent = (MappingStartEvent) this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                    String str5 = mappingStartEvent.MyBillsEntityDataFactory;
                    if (str5 == null || str5.equals("!")) {
                        BuiltInFictitiousFunctionClassFactory = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(NodeId.mapping, null, mappingStartEvent.getAuthRequestContext());
                        z = true;
                    } else {
                        Tag tag3 = new Tag(str5);
                        if (tag3.KClassImpl$Data$declaredNonStaticMembers$2() && !this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(tag3)) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("Global tag is not allowed: ");
                            sb6.append(str5);
                            throw new ComposerException(null, null, sb6.toString(), mappingStartEvent.scheduleImpl);
                        }
                        BuiltInFictitiousFunctionClassFactory = tag3;
                        z = false;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    MappingNode mappingNode2 = new MappingNode(BuiltInFictitiousFunctionClassFactory, z, arrayList2, mappingStartEvent.scheduleImpl, mappingStartEvent.KClassImpl$Data$declaredNonStaticMembers$2);
                    if (mappingStartEvent.PlaceComponentResult()) {
                        mappingNode2.scheduleImpl = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                    if (str2 != null) {
                        mappingNode2.getAuthRequestContext = str2;
                        this.getAuthRequestContext.put(str2, mappingNode2);
                    }
                    while (!this.MyBillsEntityDataFactory.getAuthRequestContext(Event.ID.MappingEnd)) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                        if (this.MyBillsEntityDataFactory.getAuthRequestContext(Event.ID.MappingEnd)) {
                            break;
                        }
                        Node authRequestContext = getAuthRequestContext(mappingNode2);
                        if (authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2.equals(Tag.getErrorConfigVersion)) {
                            mappingNode2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                        }
                        arrayList2.add(new NodeTuple(authRequestContext, getAuthRequestContext(mappingNode2)));
                    }
                    if (mappingStartEvent.PlaceComponentResult()) {
                        mappingNode2.moveToNextValue = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                    mappingNode2.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult);
                    this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
                    mappingNode = mappingNode2;
                    if (!this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
                        mappingNode2.moveToNextValue = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                        mappingNode = mappingNode2;
                    }
                }
                node2 = mappingNode;
            }
            int i3 = this.lookAheadTest;
            if (i3 > 0) {
                this.lookAheadTest = i3 - 1;
            } else {
                throw new YAMLException("Nesting Depth cannot be negative");
            }
        }
        this.scheduleImpl.remove(node);
        return node2;
    }
}
