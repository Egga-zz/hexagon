package de.egga.greetings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`greetings`")
@Data
@AllArgsConstructor
@NoArgsConstructor
class Greetings {

    @Id
    @JsonIgnore
    private String id;

    private String value;
    private String timeOfDay;

}
