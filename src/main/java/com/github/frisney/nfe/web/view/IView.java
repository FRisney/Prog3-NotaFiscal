package com.github.frisney.nfe.web.view;

public interface IView {
    IView render();
    IView pushParam(String key, Object value);
}
