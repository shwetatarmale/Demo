package com.avekshaa.traning.xls;

public class MyData {
    private String idtxn;
    private String description;
    private String errorcode;

    public MyData() {
    }

    // Getters and Setters for the properties

    public String getId() {
        return idtxn;
    }

    public void setId(String idtxn) {
        this.idtxn = idtxn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }
}
