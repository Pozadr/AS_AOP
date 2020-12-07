package pl.pozadr.aop.dto;

import javax.validation.constraints.NotNull;

public class MovieDTO {

    @NotNull
    private String title;

    @NotNull
    private String producer;

    @NotNull
    private String yearOfProduction;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(String yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
}
