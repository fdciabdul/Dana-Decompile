package org.yaml.snakeyaml;

import java.util.Map;
import java.util.TimeZone;
import kotlin.text.Typography;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.serializer.AnchorGenerator;
import org.yaml.snakeyaml.serializer.NumberAnchorGenerator;

/* loaded from: classes6.dex */
public class DumperOptions {
    ScalarStyle BuiltInFictitiousFunctionClassFactory = ScalarStyle.PLAIN;
    FlowStyle PlaceComponentResult = FlowStyle.AUTO;
    private boolean GetContactSyncConfig = false;
    private boolean getErrorConfigVersion = true;
    boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    int getAuthRequestContext = 2;
    int MyBillsEntityDataFactory = 0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = 80;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
    private LineBreak NetworkUserEntityData$$ExternalSyntheticLambda1 = LineBreak.UNIX;
    private boolean initRecordTimeStamp = false;
    private boolean DatabaseTableConfigUtil = false;
    TimeZone moveToNextValue = null;
    private int PrepareContext = 128;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
    public NonPrintableStyle lookAheadTest = NonPrintableStyle.BINARY;
    private Version NetworkUserEntityData$$ExternalSyntheticLambda6 = null;
    private Map<String, String> isLayoutRequested = null;
    private Boolean newProxyInstance = Boolean.FALSE;
    private AnchorGenerator scheduleImpl = new NumberAnchorGenerator();

    /* loaded from: classes6.dex */
    public enum NonPrintableStyle {
        BINARY,
        ESCAPE
    }

    /* loaded from: classes6.dex */
    public enum ScalarStyle {
        DOUBLE_QUOTED(Character.valueOf(Typography.quote)),
        SINGLE_QUOTED('\''),
        LITERAL('|'),
        FOLDED(Character.valueOf(Typography.greater)),
        PLAIN(null);

        private final Character styleChar;

        ScalarStyle(Character ch) {
            this.styleChar = ch;
        }

        public final Character getChar() {
            return this.styleChar;
        }

        @Override // java.lang.Enum
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Scalar style: '");
            sb.append(this.styleChar);
            sb.append("'");
            return sb.toString();
        }

        public static ScalarStyle createStyle(Character ch) {
            if (ch == null) {
                return PLAIN;
            }
            char charValue = ch.charValue();
            if (charValue != '\"') {
                if (charValue != '\'') {
                    if (charValue != '>') {
                        if (charValue == '|') {
                            return LITERAL;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unknown scalar style character: ");
                        sb.append(ch);
                        throw new YAMLException(sb.toString());
                    }
                    return FOLDED;
                }
                return SINGLE_QUOTED;
            }
            return DOUBLE_QUOTED;
        }
    }

    /* loaded from: classes6.dex */
    public enum FlowStyle {
        FLOW(Boolean.TRUE),
        BLOCK(Boolean.FALSE),
        AUTO(null);

        private final Boolean styleBoolean;

        FlowStyle(Boolean bool) {
            this.styleBoolean = bool;
        }

        @Override // java.lang.Enum
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Flow style: '");
            sb.append(this.styleBoolean);
            sb.append("'");
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public enum LineBreak {
        WIN("\r\n"),
        MAC("\r"),
        UNIX("\n");

        private final String lineBreak;

        LineBreak(String str) {
            this.lineBreak = str;
        }

        public final String getString() {
            return this.lineBreak;
        }

        @Override // java.lang.Enum
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Line break: ");
            sb.append(name());
            return sb.toString();
        }

        public static LineBreak getPlatformLineBreak() {
            String property = System.getProperty("line.separator");
            for (LineBreak lineBreak : values()) {
                if (lineBreak.lineBreak.equals(property)) {
                    return lineBreak;
                }
            }
            return UNIX;
        }
    }

    /* loaded from: classes6.dex */
    public enum Version {
        V1_0(new Integer[]{1, 0}),
        V1_1(new Integer[]{1, 1});

        private final Integer[] version;

        Version(Integer[] numArr) {
            this.version = numArr;
        }

        public final int major() {
            return this.version[0].intValue();
        }

        public final int minor() {
            return this.version[1].intValue();
        }

        public final String getRepresentation() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.version[0]);
            sb.append(".");
            sb.append(this.version[1]);
            return sb.toString();
        }

        @Override // java.lang.Enum
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Version: ");
            sb.append(getRepresentation());
            return sb.toString();
        }
    }

    public final boolean getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
