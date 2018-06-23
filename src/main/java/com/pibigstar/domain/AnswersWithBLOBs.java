package com.pibigstar.domain;

public class AnswersWithBLOBs extends Answers {
    private String selections;

    private String checkboxs;

    private String content;

    public String getSelections() {
        return selections;
    }

    public void setSelections(String selections) {
        this.selections = selections == null ? null : selections.trim();
    }

    public String getCheckboxs() {
        return checkboxs;
    }

    public void setCheckboxs(String checkboxs) {
        this.checkboxs = checkboxs == null ? null : checkboxs.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}