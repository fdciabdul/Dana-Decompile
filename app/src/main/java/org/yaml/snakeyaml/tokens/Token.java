package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;

/* loaded from: classes6.dex */
public abstract class Token {
    public final Mark getErrorConfigVersion;
    public final Mark scheduleImpl;

    public abstract ID BuiltInFictitiousFunctionClassFactory();

    /* loaded from: classes6.dex */
    public enum ID {
        Alias("<alias>"),
        Anchor("<anchor>"),
        BlockEnd("<block end>"),
        BlockEntry("-"),
        BlockMappingStart("<block mapping start>"),
        BlockSequenceStart("<block sequence start>"),
        Directive("<directive>"),
        DocumentEnd("<document end>"),
        DocumentStart("<document start>"),
        FlowEntry(","),
        FlowMappingEnd("}"),
        FlowMappingStart("{"),
        FlowSequenceEnd("]"),
        FlowSequenceStart("["),
        Key("?"),
        Scalar("<scalar>"),
        StreamEnd("<stream end>"),
        StreamStart("<stream start>"),
        Tag("<tag>"),
        Value(":"),
        Whitespace("<whitespace>"),
        Comment("#"),
        Error("<error>");

        private final String description;

        ID(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.description;
        }
    }

    public Token(Mark mark, Mark mark2) {
        if (mark == null || mark2 == null) {
            throw new YAMLException("Token requires marks.");
        }
        this.scheduleImpl = mark;
        this.getErrorConfigVersion = mark2;
    }
}
