package org.yaml.snakeyaml.parser;

import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class VersionTagsTuple {
    final Map<String, String> MyBillsEntityDataFactory;
    final DumperOptions.Version PlaceComponentResult;

    public VersionTagsTuple(DumperOptions.Version version, Map<String, String> map) {
        this.PlaceComponentResult = version;
        this.MyBillsEntityDataFactory = map;
    }

    public String toString() {
        return String.format("VersionTagsTuple<%s, %s>", this.PlaceComponentResult, this.MyBillsEntityDataFactory);
    }
}
