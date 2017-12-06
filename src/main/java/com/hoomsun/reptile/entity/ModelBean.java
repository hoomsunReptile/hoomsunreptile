package com.hoomsun.reptile.entity;

public class ModelBean {
    private int categoryId;    //模块id
    private String categoryNameCN; //模块名称中文
    private String categoryNameEN;  //模块名称英文
    private String categoryCollectionUrl; //模块访问地址
    private boolean positioningControl;    //控件定位
    private boolean keyBoard;               //模拟键盘输入
    private String processParameters;       //参数
    private String modelDescribe;           //描述
    private  String testParameters;

    public String getTestParameters() {
        return testParameters;
    }

    public void setTestParameters(String testParameters) {
        this.testParameters = testParameters;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryNameCN() {
        return categoryNameCN;
    }

    public void setCategoryNameCN(String categoryNameCN) {
        this.categoryNameCN = categoryNameCN;
    }

    public String getCategoryNameEN() {
        return categoryNameEN;
    }

    public void setCategoryNameEN(String categoryNameEN) {
        this.categoryNameEN = categoryNameEN;
    }

    public String getCategoryCollectionUrl() {
        return categoryCollectionUrl;
    }

    public void setCategoryCollectionUrl(String categoryCollectionUrl) {
        this.categoryCollectionUrl = categoryCollectionUrl;
    }

    public boolean isPositioningControl() {
        return positioningControl;
    }

    public void setPositioningControl(boolean positioningControl) {
        this.positioningControl = positioningControl;
    }

    public boolean isKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(boolean keyBoard) {
        this.keyBoard = keyBoard;
    }

    public String getProcessParameters() {
        return processParameters;
    }

    public void setProcessParameters(String processParameters) {
        this.processParameters = processParameters;
    }

    public String getModelDescribe() {
        return modelDescribe;
    }

    public void setModelDescribe(String modelDescribe) {
        this.modelDescribe = modelDescribe;
    }

    @Override
    public String toString() {
        return "ModelBean{" +
                "categoryId=" + categoryId +
                ", categoryNameCN='" + categoryNameCN + '\'' +
                ", categoryNameEN='" + categoryNameEN + '\'' +
                ", categoryCollectionUrl='" + categoryCollectionUrl + '\'' +
                ", positioningControl=" + positioningControl +
                ", keyBoard=" + keyBoard +
                ", processParameters='" + processParameters + '\'' +
                ", modelDescribe='" + modelDescribe + '\'' +
                ", testParameters='" + testParameters + '\'' +
                '}';
    }
}
