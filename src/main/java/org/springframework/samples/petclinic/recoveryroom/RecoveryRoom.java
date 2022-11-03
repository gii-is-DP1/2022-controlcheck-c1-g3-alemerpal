package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "recovery_rooms")
public class RecoveryRoom {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(unique = true)
    String name;

    @NotNull
    @Min(0)
    double size;

    @NotNull
    boolean secure;
    
    @ManyToOne(optional = false)
    RecoveryRoomType roomType;
}
