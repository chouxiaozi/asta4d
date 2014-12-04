package com.astamuse.asta4d.web.test.form.field;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.testng.annotations.Test;

import com.astamuse.asta4d.render.Renderer;
import com.astamuse.asta4d.util.Java8TimeUtil;
import com.astamuse.asta4d.web.form.field.impl.TimeRenderer;
import com.astamuse.asta4d.web.test.WebTestBase;
import com.astamuse.asta4d.web.test.form.FormRenderCase;

public class TimeTest extends WebTestBase {
    public static class TestSnippet {
        public Renderer normalEditValue() {
            FieldRenderBuilder builder = FieldRenderBuilder.of(TimeRenderer.class);
            builder.addValue("nullvalue", null);
            builder.addValue("emptyvalue", "");
            builder.addValue("datevalue", new Date(2014 - 1900, 10 - 1, 23, 12, 00, 23));
            builder.addValue("jodadatetimevalue", new DateTime(2014, 10, 23, 12, 00, 23));
            builder.addValue("jodalocaltimevalue", new LocalTime(12, 00, 23));
            builder.addValue("java8instantvalue",
                    java.time.LocalDateTime.of(2014, 10, 23, 12, 00, 23).toInstant(Java8TimeUtil.defaultZoneOffset()));
            builder.addValue("java8localdatetimevalue", java.time.LocalDateTime.of(2014, 10, 23, 12, 00, 23));
            builder.addValue("java8localtimevalue", java.time.LocalTime.of(12, 00, 23));
            return builder.toRenderer(true);
        }

        public Renderer normalDisplayValue() {
            FieldRenderBuilder builder = FieldRenderBuilder.of(TimeRenderer.class);
            builder.addValue("nullvalue", null);
            builder.addValue("emptyvalue", "");
            builder.addValue("datevalue", new Date(2014 - 1900, 10 - 1, 23, 12, 00, 23));
            builder.addValue("jodadatetimevalue", new DateTime(2014, 10, 23, 12, 00, 23));
            builder.addValue("jodalocaltimevalue", new LocalTime(12, 00, 23));
            builder.addValue("java8instantvalue",
                    java.time.LocalDateTime.of(2014, 10, 23, 12, 00, 23).toInstant(Java8TimeUtil.defaultZoneOffset()));
            builder.addValue("java8localdatetimevalue", java.time.LocalDateTime.of(2014, 10, 23, 12, 00, 23));
            builder.addValue("java8localtimevalue", java.time.LocalTime.of(12, 00, 23));
            return builder.toRenderer(false);
        }
    }

    @Test
    public void test() throws Throwable {
        new FormRenderCase("/Time.html");
    }
}