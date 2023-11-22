package com.alibaba.griver.api.ui.share;

import com.alibaba.griver.api.common.GriverExtension;
import java.util.Map;

/* loaded from: classes.dex */
public interface GriverShareURLCreatorExtension extends GriverExtension {
    String urlForParams(Map<String, String> map);
}
