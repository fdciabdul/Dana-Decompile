package com.alibaba.griver.lottie.parser;

import com.alibaba.griver.lottie.model.content.MergePaths;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes6.dex */
class MergePathsParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "mm", "hd");

    private MergePathsParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MergePaths parse(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
            } else if (selectName == 2) {
                z = jsonReader.nextBoolean();
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        return new MergePaths(str, mergePathsMode, z);
    }
}
