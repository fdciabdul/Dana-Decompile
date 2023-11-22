package id.dana.core.ui.svg;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class SvgDecoder implements ResourceDecoder<InputStream, SVG> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* synthetic */ Resource<SVG> BuiltInFictitiousFunctionClassFactory(InputStream inputStream, int i, int i2, Options options) throws IOException {
        return getAuthRequestContext(inputStream);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* bridge */ /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(InputStream inputStream, Options options) throws IOException {
        return true;
    }

    private static Resource<SVG> getAuthRequestContext(InputStream inputStream) throws IOException {
        try {
            return new SimpleResource(SVG.getFromInputStream(inputStream));
        } catch (SVGParseException e) {
            throw new IOException("Cannot load SVG from stream", e);
        }
    }
}
