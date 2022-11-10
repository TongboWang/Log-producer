package com.xpc.log.productor.po;

/***
 * @author Tongbo Wang
 * @date 2022/10/14 10:49 上午 周五
 * @jdk jdk1.8.0
 * @version 1.0
 ***/

public class SearchDisplay extends LogBase{

    private String display_type;
    private String item_id;
    private String item_type;
    private int page_x;
    private int page_y;
    private int page_index;
    private String host;
    private String param;
    private String referer;
    private String url;
    private long event_time;

    public String getDisplay_type() {
        return display_type;
    }

    public void setDisplay_type(String display_type) {
        this.display_type = display_type;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public int getPage_x() {
        return page_x;
    }

    public void setPage_x(int page_x) {
        this.page_x = page_x;
    }

    public int getPage_y() {
        return page_y;
    }

    public void setPage_y(int page_y) {
        this.page_y = page_y;
    }

    public int getPage_index() {
        return page_index;
    }

    public void setPage_index(int page_index) {
        this.page_index = page_index;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getEvent_time() {
        return event_time;
    }

    public void setEvent_time(long event_time) {
        this.event_time = event_time;
    }
}
