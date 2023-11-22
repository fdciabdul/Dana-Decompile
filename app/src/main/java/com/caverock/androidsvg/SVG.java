package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Process;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.caverock.androidsvg.CSSParser;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.data.socialshare.ShareAppKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes3.dex */
public class SVG {
    private static final int DEFAULT_PICTURE_HEIGHT = 512;
    private static final int DEFAULT_PICTURE_WIDTH = 512;
    private static int PlaceComponentResult = 1;
    private static final long SPECIFIED_ALL = -1;
    static final long SPECIFIED_CLIP = 1048576;
    static final long SPECIFIED_CLIP_PATH = 268435456;
    static final long SPECIFIED_CLIP_RULE = 536870912;
    static final long SPECIFIED_COLOR = 4096;
    static final long SPECIFIED_DIRECTION = 68719476736L;
    static final long SPECIFIED_DISPLAY = 16777216;
    static final long SPECIFIED_FILL = 1;
    static final long SPECIFIED_FILL_OPACITY = 4;
    static final long SPECIFIED_FILL_RULE = 2;
    static final long SPECIFIED_FONT_FAMILY = 8192;
    static final long SPECIFIED_FONT_SIZE = 16384;
    static final long SPECIFIED_FONT_STYLE = 65536;
    static final long SPECIFIED_FONT_WEIGHT = 32768;
    static final long SPECIFIED_IMAGE_RENDERING = 137438953472L;
    static final long SPECIFIED_MARKER_END = 8388608;
    static final long SPECIFIED_MARKER_MID = 4194304;
    static final long SPECIFIED_MARKER_START = 2097152;
    static final long SPECIFIED_MASK = 1073741824;
    static final long SPECIFIED_OPACITY = 2048;
    static final long SPECIFIED_OVERFLOW = 524288;
    static final long SPECIFIED_SOLID_COLOR = 2147483648L;
    static final long SPECIFIED_SOLID_OPACITY = 4294967296L;
    static final long SPECIFIED_STOP_COLOR = 67108864;
    static final long SPECIFIED_STOP_OPACITY = 134217728;
    static final long SPECIFIED_STROKE = 8;
    static final long SPECIFIED_STROKE_DASHARRAY = 512;
    static final long SPECIFIED_STROKE_DASHOFFSET = 1024;
    static final long SPECIFIED_STROKE_LINECAP = 64;
    static final long SPECIFIED_STROKE_LINEJOIN = 128;
    static final long SPECIFIED_STROKE_MITERLIMIT = 256;
    static final long SPECIFIED_STROKE_OPACITY = 16;
    static final long SPECIFIED_STROKE_WIDTH = 32;
    static final long SPECIFIED_TEXT_ANCHOR = 262144;
    static final long SPECIFIED_TEXT_DECORATION = 131072;
    static final long SPECIFIED_VECTOR_EFFECT = 34359738368L;
    static final long SPECIFIED_VIEWPORT_FILL = 8589934592L;
    static final long SPECIFIED_VIEWPORT_FILL_OPACITY = 17179869184L;
    static final long SPECIFIED_VISIBILITY = 33554432;
    private static final double SQRT2 = 1.414213562373095d;
    private static final String VERSION = "1.4";
    private static boolean enableInternalEntities = true;
    private static SVGExternalFileResolver externalFileResolver;
    private static int getAuthRequestContext;
    private Svg rootElement = null;
    private String title = "";
    private String desc = "";
    private float renderDPI = 96.0f;
    private CSSParser.Ruleset cssRules = new CSSParser.Ruleset();
    private Map<String, SvgElementBase> idToElementMap = new HashMap();

    /* loaded from: classes3.dex */
    static class Circle extends GraphicsElement {
        Length cx;
        Length cy;
        Length r;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "circle";
        }
    }

    /* loaded from: classes3.dex */
    static class ClipPath extends Group implements NotDirectlyRendered {
        Boolean clipPathUnitsAreUser;

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "clipPath";
        }
    }

    /* loaded from: classes3.dex */
    static class Defs extends Group implements NotDirectlyRendered {
        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "defs";
        }
    }

    /* loaded from: classes3.dex */
    static class Ellipse extends GraphicsElement {
        Length cx;
        Length cy;
        Length rx;
        Length ry;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "ellipse";
        }
    }

    /* loaded from: classes3.dex */
    enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    /* loaded from: classes3.dex */
    interface HasTransform {
        void setTransform(Matrix matrix);
    }

    /* loaded from: classes3.dex */
    static class Line extends GraphicsElement {
        Length x1;
        Length x2;
        Length y1;
        Length y2;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return ShareAppKey.LINE;
        }
    }

    /* loaded from: classes3.dex */
    static class Marker extends SvgViewBoxContainer implements NotDirectlyRendered {
        Length markerHeight;
        boolean markerUnitsAreUser;
        Length markerWidth;
        Float orient;
        Length refX;
        Length refY;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "marker";
        }
    }

    /* loaded from: classes3.dex */
    static class Mask extends SvgConditionalContainer implements NotDirectlyRendered {
        Length height;
        Boolean maskContentUnitsAreUser;
        Boolean maskUnitsAreUser;
        Length width;
        Length x;
        Length y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "mask";
        }
    }

    /* loaded from: classes3.dex */
    interface NotDirectlyRendered {
    }

    /* loaded from: classes3.dex */
    static class Path extends GraphicsElement {
        PathDefinition d;
        Float pathLength;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "path";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface PathInterface {
        void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);

        void close();

        void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

        void lineTo(float f, float f2);

        void moveTo(float f, float f2);

        void quadTo(float f, float f2, float f3, float f4);
    }

    /* loaded from: classes3.dex */
    static class Pattern extends SvgViewBoxContainer implements NotDirectlyRendered {
        Length height;
        String href;
        Boolean patternContentUnitsAreUser;
        Matrix patternTransform;
        Boolean patternUnitsAreUser;
        Length width;
        Length x;
        Length y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "pattern";
        }
    }

    /* loaded from: classes3.dex */
    static class PolyLine extends GraphicsElement {
        float[] points;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "polyline";
        }
    }

    /* loaded from: classes3.dex */
    static class Polygon extends PolyLine {
        @Override // com.caverock.androidsvg.SVG.PolyLine, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "polygon";
        }
    }

    /* loaded from: classes3.dex */
    static class Rect extends GraphicsElement {
        Length height;
        Length rx;
        Length ry;
        Length width;
        Length x;
        Length y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "rect";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Svg extends SvgViewBoxContainer {
        Length height;
        public String version;
        Length width;
        Length x;
        Length y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "svg";
        }
    }

    /* loaded from: classes3.dex */
    interface SvgConditional {
        String getRequiredExtensions();

        Set<String> getRequiredFeatures();

        Set<String> getRequiredFonts();

        Set<String> getRequiredFormats();

        Set<String> getSystemLanguage();

        void setRequiredExtensions(String str);

        void setRequiredFeatures(Set<String> set);

        void setRequiredFonts(Set<String> set);

        void setRequiredFormats(Set<String> set);

        void setSystemLanguage(Set<String> set);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface SvgContainer {
        void addChild(SvgObject svgObject) throws SVGParseException;

        List<SvgObject> getChildren();
    }

    /* loaded from: classes3.dex */
    static class SvgLinearGradient extends GradientElement {
        Length x1;
        Length x2;
        Length y1;
        Length y2;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "linearGradient";
        }
    }

    /* loaded from: classes3.dex */
    static class SvgRadialGradient extends GradientElement {
        Length cx;
        Length cy;
        Length fx;
        Length fy;
        Length r;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "radialGradient";
        }
    }

    /* loaded from: classes3.dex */
    static class Switch extends Group {
        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "switch";
        }
    }

    /* loaded from: classes3.dex */
    static class Symbol extends SvgViewBoxContainer implements NotDirectlyRendered {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "symbol";
        }
    }

    /* loaded from: classes3.dex */
    interface TextChild {
        TextRoot getTextRoot();

        void setTextRoot(TextRoot textRoot);
    }

    /* loaded from: classes3.dex */
    interface TextRoot {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    /* loaded from: classes3.dex */
    static class Use extends Group {
        Length height;
        String href;
        Length width;
        Length x;
        Length y;

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "use";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class View extends SvgViewBoxContainer implements NotDirectlyRendered {
        static final String NODE_NAME = "view";

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return NODE_NAME;
        }
    }

    public static String getVersion() {
        return VERSION;
    }

    public static SVG getFromInputStream(InputStream inputStream) throws SVGParseException {
        return new SVGParser().parse(inputStream, enableInternalEntities);
    }

    public static SVG getFromString(String str) throws SVGParseException {
        return new SVGParser().parse(new ByteArrayInputStream(str.getBytes()), enableInternalEntities);
    }

    public static SVG getFromResource(Context context, int i) throws SVGParseException {
        return getFromResource(context.getResources(), i);
    }

    public static SVG getFromResource(Resources resources, int i) throws SVGParseException {
        SVGParser sVGParser = new SVGParser();
        InputStream openRawResource = resources.openRawResource(i);
        try {
            return sVGParser.parse(openRawResource, enableInternalEntities);
        } finally {
            try {
                openRawResource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static SVG getFromAsset(AssetManager assetManager, String str) throws SVGParseException, IOException {
        SVGParser sVGParser = new SVGParser();
        try {
            Object[] objArr = {assetManager, str};
            Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
            if (obj == null) {
                obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - (Process.myTid() >> 22)), ViewConfiguration.getWindowTouchSlop() >> 8, TextUtils.indexOf("", "", 0) + 49)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
            }
            InputStream inputStream = (InputStream) ((Method) obj).invoke(null, objArr);
            try {
                SVG parse = sVGParser.parse(inputStream, enableInternalEntities);
                try {
                    int i = PlaceComponentResult + 117;
                    getAuthRequestContext = i % 128;
                    int i2 = i % 2;
                } catch (IOException unused) {
                }
                return parse;
            } finally {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static void setInternalEntitiesEnabled(boolean z) {
        enableInternalEntities = z;
    }

    public static boolean isInternalEntitiesEnabled() {
        return enableInternalEntities;
    }

    public static void registerExternalFileResolver(SVGExternalFileResolver sVGExternalFileResolver) {
        externalFileResolver = sVGExternalFileResolver;
    }

    public static void deregisterExternalFileResolver() {
        externalFileResolver = null;
    }

    public void setRenderDPI(float f) {
        this.renderDPI = f;
    }

    public float getRenderDPI() {
        return this.renderDPI;
    }

    public Picture renderToPicture() {
        return renderToPicture(null);
    }

    public Picture renderToPicture(int i, int i2) {
        return renderToPicture(i, i2, null);
    }

    public Picture renderToPicture(RenderOptions renderOptions) {
        Box box = (renderOptions == null || !renderOptions.hasViewBox()) ? this.rootElement.viewBox : renderOptions.viewBox;
        if (renderOptions != null && renderOptions.hasViewPort()) {
            return renderToPicture((int) Math.ceil(renderOptions.viewPort.maxX()), (int) Math.ceil(renderOptions.viewPort.maxY()), renderOptions);
        } else if (this.rootElement.width != null && this.rootElement.width.unit != Unit.percent && this.rootElement.height != null && this.rootElement.height.unit != Unit.percent) {
            return renderToPicture((int) Math.ceil(this.rootElement.width.floatValue(this.renderDPI)), (int) Math.ceil(this.rootElement.height.floatValue(this.renderDPI)), renderOptions);
        } else if (this.rootElement.width != null && box != null) {
            return renderToPicture((int) Math.ceil(this.rootElement.width.floatValue(this.renderDPI)), (int) Math.ceil((box.height * r1) / box.width), renderOptions);
        } else if (this.rootElement.height != null && box != null) {
            return renderToPicture((int) Math.ceil((box.width * r1) / box.height), (int) Math.ceil(this.rootElement.height.floatValue(this.renderDPI)), renderOptions);
        } else {
            return renderToPicture(512, 512, renderOptions);
        }
    }

    public Picture renderToPicture(int i, int i2, RenderOptions renderOptions) {
        Picture picture = new Picture();
        Canvas beginRecording = picture.beginRecording(i, i2);
        if (renderOptions == null || renderOptions.viewPort == null) {
            renderOptions = renderOptions == null ? new RenderOptions() : new RenderOptions(renderOptions);
            renderOptions.viewPort(0.0f, 0.0f, i, i2);
        }
        new SVGAndroidRenderer(beginRecording, this.renderDPI).renderDocument(this, renderOptions);
        picture.endRecording();
        return picture;
    }

    public Picture renderViewToPicture(String str, int i, int i2) {
        RenderOptions renderOptions = new RenderOptions();
        renderOptions.view(str).viewPort(0.0f, 0.0f, i, i2);
        Picture picture = new Picture();
        new SVGAndroidRenderer(picture.beginRecording(i, i2), this.renderDPI).renderDocument(this, renderOptions);
        picture.endRecording();
        return picture;
    }

    public void renderToCanvas(Canvas canvas) {
        renderToCanvas(canvas, (RenderOptions) null);
    }

    public void renderToCanvas(Canvas canvas, RectF rectF) {
        RenderOptions renderOptions = new RenderOptions();
        if (rectF != null) {
            renderOptions.viewPort(rectF.left, rectF.top, rectF.width(), rectF.height());
        } else {
            renderOptions.viewPort(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        }
        new SVGAndroidRenderer(canvas, this.renderDPI).renderDocument(this, renderOptions);
    }

    public void renderToCanvas(Canvas canvas, RenderOptions renderOptions) {
        if (renderOptions == null) {
            renderOptions = new RenderOptions();
        }
        if (!renderOptions.hasViewPort()) {
            renderOptions.viewPort(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        }
        new SVGAndroidRenderer(canvas, this.renderDPI).renderDocument(this, renderOptions);
    }

    public void renderViewToCanvas(String str, Canvas canvas) {
        renderToCanvas(canvas, RenderOptions.create().view(str));
    }

    public void renderViewToCanvas(String str, Canvas canvas, RectF rectF) {
        RenderOptions view = RenderOptions.create().view(str);
        if (rectF != null) {
            view.viewPort(rectF.left, rectF.top, rectF.width(), rectF.height());
        }
        renderToCanvas(canvas, view);
    }

    public String getDocumentTitle() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return this.title;
    }

    public String getDocumentDescription() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return this.desc;
    }

    public String getDocumentSVGVersion() {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return svg.version;
    }

    public Set<String> getViewList() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        List<SvgObject> elementsByTagName = getElementsByTagName("view");
        HashSet hashSet = new HashSet(elementsByTagName.size());
        Iterator<SvgObject> it = elementsByTagName.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (view.f7420id != null) {
                hashSet.add(view.f7420id);
            } else {
                InstrumentInjector.log_w("AndroidSVG", "getViewList(): found a <view> without an id attribute");
            }
        }
        return hashSet;
    }

    public float getDocumentWidth() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return getDocumentDimensions(this.renderDPI).width;
    }

    public void setDocumentWidth(float f) {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.width = new Length(f);
    }

    public void setDocumentWidth(String str) throws SVGParseException {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.width = SVGParser.parseLength(str);
    }

    public float getDocumentHeight() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return getDocumentDimensions(this.renderDPI).height;
    }

    public void setDocumentHeight(float f) {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.height = new Length(f);
    }

    public void setDocumentHeight(String str) throws SVGParseException {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.height = SVGParser.parseLength(str);
    }

    public void setDocumentViewBox(float f, float f2, float f3, float f4) {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.viewBox = new Box(f, f2, f3, f4);
    }

    public RectF getDocumentViewBox() {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        if (svg.viewBox == null) {
            return null;
        }
        return this.rootElement.viewBox.toRectF();
    }

    public void setDocumentPreserveAspectRatio(PreserveAspectRatio preserveAspectRatio) {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.preserveAspectRatio = preserveAspectRatio;
    }

    public PreserveAspectRatio getDocumentPreserveAspectRatio() {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        if (svg.preserveAspectRatio == null) {
            return null;
        }
        return this.rootElement.preserveAspectRatio;
    }

    public float getDocumentAspectRatio() {
        float f;
        float f2;
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        Length length = svg.width;
        Length length2 = this.rootElement.height;
        if (length != null && length2 != null && length.unit != Unit.percent && length2.unit != Unit.percent) {
            if (length.isZero() || length2.isZero()) {
                return -1.0f;
            }
            f = length.floatValue(this.renderDPI);
            f2 = length2.floatValue(this.renderDPI);
        } else if (this.rootElement.viewBox == null || this.rootElement.viewBox.width == 0.0f || this.rootElement.viewBox.height == 0.0f) {
            return -1.0f;
        } else {
            f = this.rootElement.viewBox.width;
            f2 = this.rootElement.viewBox.height;
        }
        return f / f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Svg getRootElement() {
        return this.rootElement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRootElement(Svg svg) {
        this.rootElement = svg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SvgObject resolveIRI(String str) {
        if (str == null) {
            return null;
        }
        String cssQuotedString = cssQuotedString(str);
        if (cssQuotedString.length() <= 1 || !cssQuotedString.startsWith("#")) {
            return null;
        }
        return getElementById(cssQuotedString.substring(1));
    }

    private String cssQuotedString(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        return str.replace("\\\n", "").replace("\\A", "\n");
    }

    private Box getDocumentDimensions(float f) {
        float f2;
        Length length = this.rootElement.width;
        Length length2 = this.rootElement.height;
        if (length == null || length.isZero() || length.unit == Unit.percent || length.unit == Unit.em || length.unit == Unit.ex) {
            return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
        }
        float floatValue = length.floatValue(f);
        if (length2 != null) {
            if (length2.isZero() || length2.unit == Unit.percent || length2.unit == Unit.em || length2.unit == Unit.ex) {
                return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
            }
            f2 = length2.floatValue(f);
        } else {
            f2 = this.rootElement.viewBox != null ? (this.rootElement.viewBox.height * floatValue) / this.rootElement.viewBox.width : floatValue;
        }
        return new Box(0.0f, 0.0f, floatValue, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCSSRules(CSSParser.Ruleset ruleset) {
        this.cssRules.addAll(ruleset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<CSSParser.Rule> getCSSRules() {
        return this.cssRules.getRules();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasCSSRules() {
        return !this.cssRules.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearRenderCSSRules() {
        this.cssRules.removeFromSource(CSSParser.Source.RenderOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Box {
        float height;
        float minX;
        float minY;
        float width;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Box(float f, float f2, float f3, float f4) {
            this.minX = f;
            this.minY = f2;
            this.width = f3;
            this.height = f4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Box(Box box) {
            this.minX = box.minX;
            this.minY = box.minY;
            this.width = box.width;
            this.height = box.height;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Box fromLimits(float f, float f2, float f3, float f4) {
            return new Box(f, f2, f3 - f, f4 - f2);
        }

        RectF toRectF() {
            return new RectF(this.minX, this.minY, maxX(), maxY());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float maxX() {
            return this.minX + this.width;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float maxY() {
            return this.minY + this.height;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void union(Box box) {
            float f = box.minX;
            if (f < this.minX) {
                this.minX = f;
            }
            float f2 = box.minY;
            if (f2 < this.minY) {
                this.minY = f2;
            }
            if (box.maxX() > maxX()) {
                this.width = box.maxX() - this.minX;
            }
            if (box.maxY() > maxY()) {
                this.height = box.maxY() - this.minY;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.minX);
            sb.append(" ");
            sb.append(this.minY);
            sb.append(" ");
            sb.append(this.width);
            sb.append(" ");
            sb.append(this.height);
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Style implements Cloneable {
        static final int FONT_WEIGHT_BOLD = 700;
        static final int FONT_WEIGHT_BOLDER = 1;
        static final int FONT_WEIGHT_LIGHTER = -1;
        static final int FONT_WEIGHT_NORMAL = 400;
        CSSClipRect clip;
        String clipPath;
        FillRule clipRule;
        Colour color;
        TextDirection direction;
        Boolean display;
        SvgPaint fill;
        Float fillOpacity;
        FillRule fillRule;
        List<String> fontFamily;
        Length fontSize;
        FontStyle fontStyle;
        Integer fontWeight;
        RenderQuality imageRendering;
        String markerEnd;
        String markerMid;
        String markerStart;
        String mask;
        Float opacity;
        Boolean overflow;
        SvgPaint solidColor;
        Float solidOpacity;
        long specifiedFlags = 0;
        SvgPaint stopColor;
        Float stopOpacity;
        SvgPaint stroke;
        Length[] strokeDashArray;
        Length strokeDashOffset;
        LineCap strokeLineCap;
        LineJoin strokeLineJoin;
        Float strokeMiterLimit;
        Float strokeOpacity;
        Length strokeWidth;
        TextAnchor textAnchor;
        TextDecoration textDecoration;
        VectorEffect vectorEffect;
        SvgPaint viewportFill;
        Float viewportFillOpacity;
        Boolean visibility;

        /* loaded from: classes3.dex */
        public enum FillRule {
            NonZero,
            EvenOdd
        }

        /* loaded from: classes3.dex */
        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        /* loaded from: classes3.dex */
        public enum LineCap {
            Butt,
            Round,
            Square
        }

        /* loaded from: classes3.dex */
        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        /* loaded from: classes3.dex */
        public enum RenderQuality {
            auto,
            optimizeQuality,
            optimizeSpeed
        }

        /* loaded from: classes3.dex */
        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        /* loaded from: classes3.dex */
        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        /* loaded from: classes3.dex */
        public enum TextDirection {
            LTR,
            RTL
        }

        /* loaded from: classes3.dex */
        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Style getDefaultStyle() {
            Style style = new Style();
            style.specifiedFlags = -1L;
            style.fill = Colour.BLACK;
            style.fillRule = FillRule.NonZero;
            Float valueOf = Float.valueOf(1.0f);
            style.fillOpacity = valueOf;
            style.stroke = null;
            style.strokeOpacity = valueOf;
            style.strokeWidth = new Length(1.0f);
            style.strokeLineCap = LineCap.Butt;
            style.strokeLineJoin = LineJoin.Miter;
            style.strokeMiterLimit = Float.valueOf(4.0f);
            style.strokeDashArray = null;
            style.strokeDashOffset = new Length(0.0f);
            style.opacity = valueOf;
            style.color = Colour.BLACK;
            style.fontFamily = null;
            style.fontSize = new Length(12.0f, Unit.pt);
            style.fontWeight = 400;
            style.fontStyle = FontStyle.Normal;
            style.textDecoration = TextDecoration.None;
            style.direction = TextDirection.LTR;
            style.textAnchor = TextAnchor.Start;
            style.overflow = Boolean.TRUE;
            style.clip = null;
            style.markerStart = null;
            style.markerMid = null;
            style.markerEnd = null;
            style.display = Boolean.TRUE;
            style.visibility = Boolean.TRUE;
            style.stopColor = Colour.BLACK;
            style.stopOpacity = valueOf;
            style.clipPath = null;
            style.clipRule = FillRule.NonZero;
            style.mask = null;
            style.solidColor = null;
            style.solidOpacity = valueOf;
            style.viewportFill = null;
            style.viewportFillOpacity = valueOf;
            style.vectorEffect = VectorEffect.None;
            style.imageRendering = RenderQuality.auto;
            return style;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void resetNonInheritingProperties(boolean z) {
            this.display = Boolean.TRUE;
            this.overflow = z ? Boolean.TRUE : Boolean.FALSE;
            this.clip = null;
            this.clipPath = null;
            this.opacity = Float.valueOf(1.0f);
            this.stopColor = Colour.BLACK;
            this.stopOpacity = Float.valueOf(1.0f);
            this.mask = null;
            this.solidColor = null;
            this.solidOpacity = Float.valueOf(1.0f);
            this.viewportFill = null;
            this.viewportFillOpacity = Float.valueOf(1.0f);
            this.vectorEffect = VectorEffect.None;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Object clone() throws CloneNotSupportedException {
            Style style = (Style) super.clone();
            Length[] lengthArr = this.strokeDashArray;
            if (lengthArr != null) {
                style.strokeDashArray = (Length[]) lengthArr.clone();
            }
            return style;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class SvgPaint implements Cloneable {
        SvgPaint() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Colour extends SvgPaint {
        static final Colour BLACK = new Colour(-16777216);
        static final Colour TRANSPARENT = new Colour(0);
        int colour;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Colour(int i) {
            this.colour = i;
        }

        public String toString() {
            return String.format("#%08x", Integer.valueOf(this.colour));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CurrentColor extends SvgPaint {
        private static CurrentColor instance = new CurrentColor();

        private CurrentColor() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static CurrentColor getInstance() {
            return instance;
        }
    }

    /* loaded from: classes3.dex */
    static class PaintReference extends SvgPaint {
        SvgPaint fallback;
        String href;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PaintReference(String str, SvgPaint svgPaint) {
            this.href = str;
            this.fallback = svgPaint;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.href);
            sb.append(" ");
            sb.append(this.fallback);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Length implements Cloneable {
        Unit unit;
        float value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Length(float f, Unit unit) {
            this.value = f;
            this.unit = unit;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Length(float f) {
            this.value = f;
            this.unit = Unit.px;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValue() {
            return this.value;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValueX(SVGAndroidRenderer sVGAndroidRenderer) {
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVG$Unit[this.unit.ordinal()]) {
                case 1:
                    return this.value;
                case 2:
                    return this.value * sVGAndroidRenderer.getCurrentFontSize();
                case 3:
                    return this.value * sVGAndroidRenderer.getCurrentFontXHeight();
                case 4:
                    return this.value * sVGAndroidRenderer.getDPI();
                case 5:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 2.54f;
                case 6:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 25.4f;
                case 7:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 72.0f;
                case 8:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 6.0f;
                case 9:
                    Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
                    if (currentViewPortInUserUnits == null) {
                        return this.value;
                    }
                    return (this.value * currentViewPortInUserUnits.width) / 100.0f;
                default:
                    return this.value;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValueY(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.unit == Unit.percent) {
                Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
                if (currentViewPortInUserUnits == null) {
                    return this.value;
                }
                return (this.value * currentViewPortInUserUnits.height) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValue(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.unit == Unit.percent) {
                Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
                if (currentViewPortInUserUnits == null) {
                    return this.value;
                }
                float f = currentViewPortInUserUnits.width;
                if (f == currentViewPortInUserUnits.height) {
                    return (this.value * f) / 100.0f;
                }
                return (this.value * ((float) (Math.sqrt((f * f) + (r7 * r7)) / SVG.SQRT2))) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValue(SVGAndroidRenderer sVGAndroidRenderer, float f) {
            if (this.unit == Unit.percent) {
                return (this.value * f) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValue(float f) {
            int i = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVG$Unit[this.unit.ordinal()];
            if (i == 1) {
                return this.value;
            }
            switch (i) {
                case 4:
                    return this.value * f;
                case 5:
                    return (this.value * f) / 2.54f;
                case 6:
                    return (this.value * f) / 25.4f;
                case 7:
                    return (this.value * f) / 72.0f;
                case 8:
                    return (this.value * f) / 6.0f;
                default:
                    return this.value;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isZero() {
            return this.value == 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isNegative() {
            return this.value < 0.0f;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.value));
            sb.append(this.unit);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.caverock.androidsvg.SVG$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVG$Unit;

        static {
            int[] iArr = new int[Unit.values().length];
            $SwitchMap$com$caverock$androidsvg$SVG$Unit = iArr;
            try {
                iArr[Unit.px.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.em.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.ex.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.in.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.cm.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.mm.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.pt.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.pc.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.percent.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CSSClipRect {
        Length bottom;
        Length left;
        Length right;
        Length top;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CSSClipRect(Length length, Length length2, Length length3, Length length4) {
            this.top = length;
            this.right = length2;
            this.bottom = length3;
            this.left = length4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SvgObject {
        SVG document;
        SvgContainer parent;

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getNodeName() {
            return "";
        }

        SvgObject() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class SvgElementBase extends SvgObject {

        /* renamed from: id  reason: collision with root package name */
        String f7420id = null;
        Boolean spacePreserve = null;
        Style baseStyle = null;
        Style style = null;
        List<String> classNames = null;

        SvgElementBase() {
        }

        public String toString() {
            return getNodeName();
        }
    }

    /* loaded from: classes3.dex */
    static abstract class SvgElement extends SvgElementBase {
        Box boundingBox = null;

        SvgElement() {
        }
    }

    /* loaded from: classes3.dex */
    static abstract class SvgConditionalElement extends SvgElement implements SvgConditional {
        Set<String> requiredFeatures = null;
        String requiredExtensions = null;
        Set<String> systemLanguage = null;
        Set<String> requiredFormats = null;
        Set<String> requiredFonts = null;

        SvgConditionalElement() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.requiredFeatures = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> set) {
            this.systemLanguage = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return this.systemLanguage;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.requiredFormats = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.requiredFonts = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }
    }

    /* loaded from: classes3.dex */
    static abstract class SvgConditionalContainer extends SvgElement implements SvgContainer, SvgConditional {
        List<SvgObject> children = new ArrayList();
        Set<String> requiredFeatures = null;
        String requiredExtensions = null;
        Set<String> systemLanguage = null;
        Set<String> requiredFormats = null;
        Set<String> requiredFonts = null;

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return null;
        }

        SvgConditionalContainer() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return this.children;
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) throws SVGParseException {
            this.children.add(svgObject);
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.requiredFeatures = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> set) {
            this.systemLanguage = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.requiredFormats = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.requiredFonts = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class SvgPreserveAspectRatioContainer extends SvgConditionalContainer {
        PreserveAspectRatio preserveAspectRatio = null;

        SvgPreserveAspectRatioContainer() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class SvgViewBoxContainer extends SvgPreserveAspectRatioContainer {
        Box viewBox;

        SvgViewBoxContainer() {
        }
    }

    /* loaded from: classes3.dex */
    static class Group extends SvgConditionalContainer implements HasTransform {
        Matrix transform;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "group";
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* loaded from: classes3.dex */
    static abstract class GraphicsElement extends SvgConditionalElement implements HasTransform {
        Matrix transform;

        GraphicsElement() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* loaded from: classes3.dex */
    static abstract class TextContainer extends SvgConditionalContainer {
        TextContainer() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditionalContainer, com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) throws SVGParseException {
            if (svgObject instanceof TextChild) {
                this.children.add(svgObject);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Text content elements cannot contain ");
            sb.append(svgObject);
            sb.append(" elements.");
            throw new SVGParseException(sb.toString());
        }
    }

    /* loaded from: classes3.dex */
    static abstract class TextPositionedContainer extends TextContainer {
        List<Length> dx;
        List<Length> dy;
        List<Length> x;
        List<Length> y;

        TextPositionedContainer() {
        }
    }

    /* loaded from: classes3.dex */
    static class Text extends TextPositionedContainer implements TextRoot, HasTransform {
        Matrix transform;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "text";
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* loaded from: classes3.dex */
    static class TSpan extends TextPositionedContainer implements TextChild {
        private TextRoot textRoot;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "tspan";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    /* loaded from: classes3.dex */
    static class TextSequence extends SvgObject implements TextChild {
        String text;
        private TextRoot textRoot;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TextSequence(String str) {
            this.text = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TextChild: '");
            sb.append(this.text);
            sb.append("'");
            return sb.toString();
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    /* loaded from: classes3.dex */
    static class TRef extends TextContainer implements TextChild {
        String href;
        private TextRoot textRoot;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "tref";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    /* loaded from: classes3.dex */
    static class TextPath extends TextContainer implements TextChild {
        String href;
        Length startOffset;
        private TextRoot textRoot;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "textPath";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    /* loaded from: classes3.dex */
    static abstract class GradientElement extends SvgElementBase implements SvgContainer {
        List<SvgObject> children = new ArrayList();
        Matrix gradientTransform;
        Boolean gradientUnitsAreUser;
        String href;
        GradientSpread spreadMethod;

        GradientElement() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return this.children;
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) throws SVGParseException {
            if (svgObject instanceof Stop) {
                this.children.add(svgObject);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Gradient elements cannot contain ");
            sb.append(svgObject);
            sb.append(" elements.");
            throw new SVGParseException(sb.toString());
        }
    }

    /* loaded from: classes3.dex */
    static class Stop extends SvgElementBase implements SvgContainer {
        Float offset;

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "stop";
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return Collections.emptyList();
        }
    }

    /* loaded from: classes3.dex */
    static class Image extends SvgPreserveAspectRatioContainer implements HasTransform {
        Length height;
        String href;
        Matrix transform;
        Length width;
        Length x;
        Length y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "image";
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* loaded from: classes3.dex */
    static class SolidColor extends SvgElementBase implements SvgContainer {
        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "solidColor";
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTitle(String str) {
        this.title = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDesc(String str) {
        this.desc = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SVGExternalFileResolver getFileResolver() {
        return externalFileResolver;
    }

    /* loaded from: classes3.dex */
    static class PathDefinition implements PathInterface {
        private static final byte ARCTO = 4;
        private static final byte CLOSE = 8;
        private static final byte CUBICTO = 2;
        private static final byte LINETO = 1;
        private static final byte MOVETO = 0;
        private static final byte QUADTO = 3;
        private int commandsLength = 0;
        private int coordsLength = 0;
        private byte[] commands = new byte[8];
        private float[] coords = new float[16];

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.commandsLength == 0;
        }

        private void addCommand(byte b) {
            int i = this.commandsLength;
            byte[] bArr = this.commands;
            if (i == bArr.length) {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.commands = bArr2;
            }
            byte[] bArr3 = this.commands;
            int i2 = this.commandsLength;
            this.commandsLength = i2 + 1;
            bArr3[i2] = b;
        }

        private void coordsEnsure(int i) {
            float[] fArr = this.coords;
            if (fArr.length < this.coordsLength + i) {
                float[] fArr2 = new float[fArr.length * 2];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.coords = fArr2;
            }
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f, float f2) {
            addCommand((byte) 0);
            coordsEnsure(2);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            fArr[i] = f;
            this.coordsLength = i2 + 1;
            fArr[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f, float f2) {
            addCommand((byte) 1);
            coordsEnsure(2);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            fArr[i] = f;
            this.coordsLength = i2 + 1;
            fArr[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            addCommand((byte) 2);
            coordsEnsure(6);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            fArr[i] = f;
            int i3 = i2 + 1;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            fArr[i4] = f4;
            int i6 = i5 + 1;
            fArr[i5] = f5;
            this.coordsLength = i6 + 1;
            fArr[i6] = f6;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            addCommand((byte) 3);
            coordsEnsure(4);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            fArr[i] = f;
            int i3 = i2 + 1;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            fArr[i3] = f3;
            this.coordsLength = i4 + 1;
            fArr[i4] = f4;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            addCommand((byte) ((z ? 2 : 0) | 4 | (z2 ? 1 : 0)));
            coordsEnsure(5);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            fArr[i] = f;
            int i3 = i2 + 1;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            fArr[i4] = f4;
            this.coordsLength = i5 + 1;
            fArr[i5] = f5;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            addCommand((byte) 8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void enumeratePath(PathInterface pathInterface) {
            int i;
            int i2 = 0;
            for (int i3 = 0; i3 < this.commandsLength; i3++) {
                byte b = this.commands[i3];
                if (b == 0) {
                    float[] fArr = this.coords;
                    int i4 = i2 + 1;
                    i = i4 + 1;
                    pathInterface.moveTo(fArr[i2], fArr[i4]);
                } else if (b != 1) {
                    if (b == 2) {
                        float[] fArr2 = this.coords;
                        int i5 = i2 + 1;
                        float f = fArr2[i2];
                        int i6 = i5 + 1;
                        float f2 = fArr2[i5];
                        int i7 = i6 + 1;
                        float f3 = fArr2[i6];
                        int i8 = i7 + 1;
                        float f4 = fArr2[i7];
                        int i9 = i8 + 1;
                        float f5 = fArr2[i8];
                        i2 = i9 + 1;
                        pathInterface.cubicTo(f, f2, f3, f4, f5, fArr2[i9]);
                    } else if (b == 3) {
                        float[] fArr3 = this.coords;
                        int i10 = i2 + 1;
                        int i11 = i10 + 1;
                        int i12 = i11 + 1;
                        pathInterface.quadTo(fArr3[i2], fArr3[i10], fArr3[i11], fArr3[i12]);
                        i2 = i12 + 1;
                    } else if (b == 8) {
                        pathInterface.close();
                    } else {
                        boolean z = (b & 2) != 0;
                        boolean z2 = (b & 1) != 0;
                        float[] fArr4 = this.coords;
                        int i13 = i2 + 1;
                        float f6 = fArr4[i2];
                        int i14 = i13 + 1;
                        float f7 = fArr4[i13];
                        int i15 = i14 + 1;
                        float f8 = fArr4[i14];
                        int i16 = i15 + 1;
                        pathInterface.arcTo(f6, f7, f8, z, z2, fArr4[i15], fArr4[i16]);
                        i2 = i16 + 1;
                    }
                } else {
                    float[] fArr5 = this.coords;
                    int i17 = i2 + 1;
                    i = i17 + 1;
                    pathInterface.lineTo(fArr5[i2], fArr5[i17]);
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SvgElementBase getElementById(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.rootElement.f7420id)) {
            return this.rootElement;
        }
        if (this.idToElementMap.containsKey(str)) {
            return this.idToElementMap.get(str);
        }
        SvgElementBase elementById = getElementById(this.rootElement, str);
        this.idToElementMap.put(str, elementById);
        return elementById;
    }

    private SvgElementBase getElementById(SvgContainer svgContainer, String str) {
        SvgElementBase elementById;
        SvgElementBase svgElementBase = (SvgElementBase) svgContainer;
        if (str.equals(svgElementBase.f7420id)) {
            return svgElementBase;
        }
        for (SvgObject svgObject : svgContainer.getChildren()) {
            if (svgObject instanceof SvgElementBase) {
                SvgElementBase svgElementBase2 = (SvgElementBase) svgObject;
                if (str.equals(svgElementBase2.f7420id)) {
                    return svgElementBase2;
                }
                if ((svgObject instanceof SvgContainer) && (elementById = getElementById((SvgContainer) svgObject, str)) != null) {
                    return elementById;
                }
            }
        }
        return null;
    }

    private List<SvgObject> getElementsByTagName(String str) {
        ArrayList arrayList = new ArrayList();
        getElementsByTagName(arrayList, this.rootElement, str);
        return arrayList;
    }

    private void getElementsByTagName(List<SvgObject> list, SvgObject svgObject, String str) {
        if (svgObject.getNodeName().equals(str)) {
            list.add(svgObject);
        }
        if (svgObject instanceof SvgContainer) {
            Iterator<SvgObject> it = ((SvgContainer) svgObject).getChildren().iterator();
            while (it.hasNext()) {
                getElementsByTagName(list, it.next(), str);
            }
        }
    }
}
