package com.github.frisney.nfe.web.view;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

abstract public class View implements IView {
    protected String html;
    protected final Map<String, Object> params = new HashMap<>();

    public View(String name) {
        this.html = load(name);
    }

    public IView pushParam(String key, Object value) {
        params.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return html;
    }

    public IView render() {
        html = View.render(this.html, this.params);
        return this;
    }

    public static String load(String name) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("views/" + name + ".html");
        if (is == null) {
            return "";
        }
        try {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String renderNamed(String name, Map<String, Object> parameters) {
        return View.render(load(name), parameters);
    }

    protected static String render(String content, Map<String, Object> parameters) {
        String newContent = content;
        for (var par : parameters.entrySet()) {
            var placeholder = "\\{\\{" + par.getKey() + "}}";
            var value = par.getValue().toString();
            newContent = newContent.replaceAll(placeholder, value);
        }
        return newContent;
    }
}
