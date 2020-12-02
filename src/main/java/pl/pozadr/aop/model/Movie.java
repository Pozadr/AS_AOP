package pl.pozadr.aop.model;

import javax.validation.constraints.*;


public class Movie {
    @NotNull
    @Min(1)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 2)
    private String title;

    @NotNull
    @NotBlank
    @Size(min = 2)
    private String producer;

    @NotNull
    private Integer yearOfProduction;

    public Movie(Long id, String title, String producer, Integer yearOfProduction) {
        this.id = id;
        this.title = title;
        this.producer = producer;
        this.yearOfProduction = yearOfProduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
}


