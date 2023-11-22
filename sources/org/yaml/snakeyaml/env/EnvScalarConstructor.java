package org.yaml.snakeyaml.env;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.constructor.AbstractConstruct;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.MissingEnvironmentVariableException;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes9.dex */
public class EnvScalarConstructor extends Constructor {
    public static final Tag PrepareContext = new Tag("!ENV");
    public static final Pattern NetworkUserEntityData$$ExternalSyntheticLambda7 = Pattern.compile("^\\$\\{\\s*((?<name>\\w+)((?<separator>:?(-|\\?))(?<value>\\S+)?)?)\\s*\\}$");

    public EnvScalarConstructor() {
        super(new LoaderOptions());
        this.initRecordTimeStamp.put(PrepareContext, new ConstructEnv(this, (byte) 0));
    }

    /* loaded from: classes9.dex */
    class ConstructEnv extends AbstractConstruct {
        private ConstructEnv() {
        }

        /* synthetic */ ConstructEnv(EnvScalarConstructor envScalarConstructor, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            Matcher matcher = EnvScalarConstructor.NetworkUserEntityData$$ExternalSyntheticLambda7.matcher(((ScalarNode) node).KClassImpl$Data$declaredNonStaticMembers$2);
            matcher.matches();
            String group = matcher.group("name");
            String group2 = matcher.group("value");
            String group3 = matcher.group("separator");
            if (group2 == null) {
                group2 = "";
            }
            return EnvScalarConstructor.BuiltInFictitiousFunctionClassFactory(group, group3, group2, System.getenv(group));
        }
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3, String str4) {
        if (str4 == null || str4.isEmpty()) {
            if (str2 != null) {
                if (str2.equals("?") && str4 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Missing mandatory variable ");
                    sb.append(str);
                    sb.append(": ");
                    sb.append(str3);
                    throw new MissingEnvironmentVariableException(sb.toString());
                }
                if (str2.equals(":?")) {
                    if (str4 == null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Missing mandatory variable ");
                        sb2.append(str);
                        sb2.append(": ");
                        sb2.append(str3);
                        throw new MissingEnvironmentVariableException(sb2.toString());
                    } else if (str4.isEmpty()) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Empty mandatory variable ");
                        sb3.append(str);
                        sb3.append(": ");
                        sb3.append(str3);
                        throw new MissingEnvironmentVariableException(sb3.toString());
                    }
                }
                return str2.startsWith(":") ? (str4 == null || str4.isEmpty()) ? str3 : "" : str4 == null ? str3 : "";
            }
            return "";
        }
        return str4;
    }
}
