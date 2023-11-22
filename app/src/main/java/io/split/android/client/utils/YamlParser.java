package io.split.android.client.utils;

import io.split.android.client.utils.logger.Logger;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.reader.StreamReader;

/* loaded from: classes6.dex */
public class YamlParser {
    Yaml yaml = new Yaml();

    public <T> T parse(String str) {
        try {
            return (T) this.yaml.getAuthRequestContext(new StreamReader(str), Object.class);
        } catch (YAMLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error parsing yaml file: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
            return null;
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown error while parsing yaml file: ");
            sb2.append(e2.getLocalizedMessage());
            Logger.e(sb2.toString());
            return null;
        }
    }
}
