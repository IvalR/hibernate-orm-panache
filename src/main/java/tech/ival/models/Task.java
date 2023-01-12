package tech.ival.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Task extends PanacheEntity {

    @NotBlank
    public String title;
    public String description;
    public String subject;
    public Integer score;
}
