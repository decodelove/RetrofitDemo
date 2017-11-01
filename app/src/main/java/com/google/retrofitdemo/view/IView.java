package com.google.retrofitdemo.view;

import java.util.Objects;

/**
 * Created by Administrator on 2017/10/30.
 */

public interface IView {
    void success(Object o);

    void failed(String msg);

}
